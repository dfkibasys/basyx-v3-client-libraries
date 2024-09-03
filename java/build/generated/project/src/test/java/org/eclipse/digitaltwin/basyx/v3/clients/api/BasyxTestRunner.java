package org.eclipse.digitaltwin.basyx.v3.clients.api;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.swing.event.TreeSelectionEvent;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.eclipse.digitaltwin.aas4j.v3.model.AssetAdministrationShell;
import org.eclipse.digitaltwin.aas4j.v3.model.AssetAdministrationShellDescriptor;
import org.eclipse.digitaltwin.aas4j.v3.model.SpecificAssetId;
import org.eclipse.digitaltwin.aas4j.v3.model.Submodel;
import org.eclipse.digitaltwin.aas4j.v3.model.SubmodelDescriptor;
import org.eclipse.digitaltwin.basyx.v3.clients.ApiException;
import org.json.JSONException;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.stubbing.StubImport;
import com.github.tomakehurst.wiremock.stubbing.StubImportBuilder;
import com.github.tomakehurst.wiremock.stubbing.StubMapping;
import com.google.common.base.Functions;
import com.google.common.base.Objects;
import com.google.common.base.Strings;

public class BasyxTestRunner {

	private final BasyxTestEnvironmentBase environment;
	private final ObjectMapper mapper;
	private final Path testFolder;

	private static final Logger LOGGER = LoggerFactory.getLogger(BasyxTestRunner.class);
	
	private final BasyxTestAssertions assertions;

	public BasyxTestRunner(BasyxTestEnvironmentBase environment, ObjectMapper mapper, Path testFolder) {
		this.environment = environment;
		this.mapper = mapper;
		this.testFolder = testFolder;
		assertions = new BasyxTestAssertions(environment, mapper);
	}

	public <T extends BasyxTestValues> List<BasyxVoidTestDefinition<T>> loadVoidTestDefinition(String fileName,
			Class<T> testArgsCls) {
		JavaType javaType = mapper.getTypeFactory().constructParametricType(BasyxVoidTestDefinition.class, testArgsCls);
		return load(javaType, fileName);
	}

	public <T extends BasyxTestValues, R extends Object> List<BasyxListTestDefinition<T, R>> loadListTestDefinition(
			String fileName, Class<T> testArgsCls, Class<R> returnValue) {
		JavaType javaType = mapper.getTypeFactory().constructParametricType(BasyxListTestDefinition.class, testArgsCls,
				returnValue);
		return load(javaType, fileName);
	}

	public <T extends BasyxTestValues, R extends Object> List<BasyxFunctionalTestDefinition<T, R>> loadFunctionalTestDefinition(
			String fileName, Class<T> testArgsCls, Class<R> returnValue) {
		JavaType javaType = mapper.getTypeFactory().constructParametricType(BasyxFunctionalTestDefinition.class,
				testArgsCls, returnValue);
		return load(javaType, fileName);
	}

	private <T extends BasyxTestValues, C extends AbstractBasyxTestDefinition<T>> List<C> load(JavaType javaType,
			String fileName) {

		try {
			List<Path> filePaths = Files.list(testFolder).filter(p -> isValidFileName(p, fileName))
					.collect(Collectors.toList());
			List<C> values = new ArrayList<>();

			for (Path eachPath : filePaths) {
				try {
					String content = Files.readString(eachPath, StandardCharsets.UTF_8);
					content = content.replace("$PROPERTY(basyxtest.folder)",
							testFolder.toString().replace("\\", "\\\\"));
					content = content.replace("$PROPERTY(basyxtest.mockserver.url.internal)",
							environment.getInternalMockServerUrl());
					C value = mapper.readValue(content, javaType);
					if (Strings.isNullOrEmpty(value.getName())) {
						value.setName(fileName);
					}
					values.add(value);
				} catch (IOException e) {
					throw new RuntimeException("Failed to load tests for " + eachPath, e);
				}
			}
			return values;
		} catch (IOException e) {
			throw new RuntimeException("Failed to load tests", e);
		}
	}

	private boolean isValidFileName(Path file, String namePrefix) {
		String name = file.getFileName().toString();
		return (name.equals(namePrefix + ".json") || name.startsWith(namePrefix + "_")) && name.endsWith(".json");
	}

	private void initializeServices(BasyxRepositoryState initialState) throws JsonProcessingException, IOException {
		if (initialState == null) {
			return;
		}
		List<AssetAdministrationShell> shells = initialState.getShells();
		List<Submodel> submodels = initialState.getSubmodels();
		List<AssetAdministrationShellDescriptor> shellDescriptors = initialState.getShellDescriptors();
		List<SubmodelDescriptor> smDescriptors = initialState.getSubmodelDescriptors();
		Map<String, String> thumbnails = new HashMap<>(
				initialState.getThumbnails() != null ? initialState.getThumbnails() : Map.of());
		Map<String, Map<String, String>> fileAttachments = initialState.getFileAttachments();
		Map<String, List<SpecificAssetId>> assetLinks = initialState.getAssetLinks();

		Assert.assertFalse(
				"As auto registration is activated just initialize shells or shell descriptors (even if declared empty), because shell descriptors are deployed implicitely.",
				shells != null && shellDescriptors != null);
		Assert.assertFalse(
				"As auto registration is activated just initialize submodels or submodel descriptors (even if declared empty) because submodel descriptors are deployed implicitely.",
				submodels != null && smDescriptors != null);

		environment.cleanup();
		try (CloseableHttpClient client = HttpClients.createMinimal()) {
			if (shells != null) {
				for (AssetAdministrationShell eachShell : shells) {
					environment.postShell(client, eachShell);
					String id = eachShell.getId();
					String tn = thumbnails.remove(id);
					if (tn != null) {
						environment.putThumbnailFile(client, id, Path.of(tn));
					}
				}
			}
			if (submodels != null) {
				for (Submodel sm : submodels) {
					environment.postSubmodel(client, sm);

				}
			}
			if (fileAttachments != null) {
				for (Entry<String, Map<String, String>> eachIdToPathMap : fileAttachments.entrySet()) {
					String smId = eachIdToPathMap.getKey();
					for (Entry<String, String> eachPathToFileMap : eachIdToPathMap.getValue().entrySet()) {
						String path = eachPathToFileMap.getKey();
						String filePath = eachPathToFileMap.getValue();
						environment.putFileAttachment(client, smId, path, Path.of(filePath));
					}

				}
			}
			if (shellDescriptors != null) {
				for (AssetAdministrationShellDescriptor eachDescriptor : shellDescriptors) {
					environment.postShellDescriptor(client, eachDescriptor);
				}
			}
			if (smDescriptors != null) {
				for (SubmodelDescriptor eachDescriptor : smDescriptors) {
					environment.postSubmodelDescriptor(client, eachDescriptor);
				}
			}
			if (assetLinks != null) {
				for (Entry<String, List<SpecificAssetId>> assetIds : assetLinks.entrySet()) {
					environment.postAssetLinks(client, assetIds.getKey(), assetIds.getValue());
				}
			}
		}

		Assert.assertTrue("These thumbnails do not have corresponding ids: " + thumbnails.keySet(),
				thumbnails.isEmpty());

	}

	private void initializeMockService(List<StubMapping> mappings) {
		if (mappings == null || mappings.isEmpty()) {
			return;
		}

		URI uri = URI.create(environment.getExternalMockServerUrl());
		WireMock.configureFor(uri.getScheme(), uri.getHost(), uri.getPort());
		StubImportBuilder builder = StubImport.stubImport().overwriteExisting();
		for (StubMapping eachMapping : mappings) {
			builder.stub(eachMapping);
		}
		WireMock.importStubs(builder);
	}

	private void cleanupMockService(List<StubMapping> mappings) {
		if (mappings == null) {
			return;
		}
		for (StubMapping eachMapping : mappings) {
			WireMock.removeStub(eachMapping);
		}
	}

	public <T extends BasyxTestValues> void runAndAssertWithVoidResult(BasyxVoidTestDefinition<T> def,
			Consumer<T> consumer) {
		try {
			initializeMockService(def.getMocks());
			initializeServices(def.getInitialState());

			Integer errorCode = def.getExpectedErrorStatusCode();
			T args = Optional.ofNullable(def.getInvocation()).map(Invocation::getArgs).orElse(null);
			if (errorCode != null) {
				try {
					consumer.accept(args);
					Assert.fail("Expected error status code " + errorCode);
				} catch (ApiException ex) {
					Assert.assertEquals(errorCode.intValue(), ex.getCode());
				}
			} else {
				consumer.accept(args);
			}
			assertions.assertEnvironmentState(def.getName(), def.getExpectedState());
		} catch (IOException | JSONException e) {
			throw new RuntimeException(e);
		} finally {
			cleanupMockService(def.getMocks());
			environment.cleanup();
		}
	}

	public <T extends BasyxTestValues, R extends Object> void runAndAssertWithListResult(
			BasyxListTestDefinition<T, R> def, Function<T, List<R>> func) {
		try {
			String name = def.getName();
			initializeMockService(def.getMocks());
			initializeServices(def.getInitialState());

			Integer expectedStatus = def.getExpectedErrorStatusCode();
			List<R> expected = def.getExpectedReturnValue();
			Assert.assertTrue("Only specify expectedReturnValues or expectedErrorStatusCode, not both", expectedStatus != null || expected != null);
			List<R> result;

			T args = Optional.ofNullable(def.getInvocation()).map(Invocation::getArgs).orElse(null);
			if (expectedStatus != null) {
				try {
					result = func.apply(args);
					Assert.fail("Expected error status code " + expectedStatus);
				} catch (ApiException ex) {
					Assert.assertEquals(expectedStatus.intValue(), ex.getCode());
					result = null;
				}
			} else {
				result = func.apply(args);
				Assert.assertTrue("No 'expectedReturnValue' specified", expected != null);
			}
			if (expected != null) {
				assertions.assertExpectedReturnValues(name, expected, result);				
			}
			assertions.assertEnvironmentState(def.getName(), def.getExpectedState());
		} catch (IOException | JSONException e) {
			throw new RuntimeException(e);
		} finally {
			cleanupMockService(def.getMocks());
			environment.cleanup();
		}
	}

	public <T extends BasyxTestValues, R extends Object> void runAndAssertWithFunctionalResult(
			BasyxFunctionalTestDefinition<T, R> def, Function<T, R> func) {
		try {
			String name = def.getName();
			LOGGER.info("Running: " + name);
			initializeServices(def.getInitialState());
			initializeMockService(def.getMocks());

			T args = Optional.ofNullable(def.getInvocation()).map(Invocation::getArgs).orElse(null);
			Integer expectedStatus = def.getExpectedErrorStatusCode();
			R expected = def.getExpectedReturnValue();

			Assert.assertTrue("Only specify expectedReturnValues or expectedErrorStatusCode, not both", expectedStatus != null || expected != null);
			R result;
			if (expectedStatus != null) {
				try {
					result = func.apply(args);
					Assert.fail("Expected error status code " + expectedStatus);
				} catch (ApiException ex) {
					Assert.assertEquals(expectedStatus.intValue(), ex.getCode());
					result = null;
				}
			} else {
				Assert.assertTrue("No 'expectedReturnValue' specified", expected != null);
				result = func.apply(args);
			}
			if (expected != null) {
				assertions.assertExpectedReturnValue(name, expected, result);
			}
			assertions.assertEnvironmentState(name, def.getExpectedState());
		} catch (IOException | JSONException e) {
			throw new RuntimeException(e);
		} finally {
			cleanupMockService(def.getMocks());
			environment.cleanup();
		}
	}



	public static class Invocation<T> {

		private T args;

		public T getArgs() {
			return args;
		}

		public void setArgs(T args) {
			this.args = args;
		}

	}

	public static abstract class AbstractBasyxTestDefinition<T extends BasyxTestValues> {

		private String name;

		private String comment;

		private List<StubMapping> mocks;

		private BasyxRepositoryState initialState;

		private BasyxRepositoryState expectedState;

		private Integer expectedErrorStatusCode;

		private Invocation<T> invocation;

		public List<StubMapping> getMocks() {
			return mocks;
		}

		public void setMocks(List<StubMapping> mocks) {
			this.mocks = mocks;
		}

		public Integer getExpectedErrorStatusCode() {
			return expectedErrorStatusCode;
		}

		public void setExpectedErrorStatusCode(Integer expectedErrorStatusCode) {
			this.expectedErrorStatusCode = expectedErrorStatusCode;
		}

		public String getComment() {
			return comment;
		}

		public void setComment(String comment) {
			this.comment = comment;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Invocation<T> getInvocation() {
			return invocation;
		}

		public void setInvocation(Invocation<T> invocation) {
			this.invocation = invocation;
		}

		public BasyxRepositoryState getExpectedState() {
			return expectedState;
		}

		public void setExpectedState(BasyxRepositoryState expectedState) {
			this.expectedState = expectedState;
		}

		public BasyxRepositoryState getInitialState() {
			return initialState;
		}

		public void setInitialState(BasyxRepositoryState initialState) {
			this.initialState = initialState;
		}
	}

	public static class BasyxVoidTestDefinition<T extends BasyxTestValues> extends AbstractBasyxTestDefinition<T> {

	}

	public static class BasyxListTestDefinition<T extends BasyxTestValues, R extends Object>
			extends AbstractBasyxTestDefinition<T> {

		private List<R> expectedReturnValue;

		public List<R> getExpectedReturnValue() {
			return expectedReturnValue;
		}

		public void setExpectedReturnValue(List<R> returnValue) {
			this.expectedReturnValue = returnValue;
		}
	}

	public static class BasyxFunctionalTestDefinition<T extends BasyxTestValues, R extends Object>
			extends AbstractBasyxTestDefinition<T> {

		private R expectedReturnValue;

		public R getExpectedReturnValue() {
			return expectedReturnValue;
		}

		public void setExpectedReturnValue(R returnValue) {
			this.expectedReturnValue = returnValue;
		}

	}

	public static class Thumbnail {

		private String fileName = "";

		private String base64 = "";

		public String getBase64() {
			return base64;
		}

		public String getFileName() {
			return fileName;
		}
	}

	public static class BasyxRepositoryState {

		private List<AssetAdministrationShell> shells;

		private List<Submodel> submodels;

		private List<AssetAdministrationShellDescriptor> shellDescriptors;

		private List<SubmodelDescriptor> submodelDescriptors;

		private Map<String, String> thumbnails;

		private Map<String, Map<String, String>> fileAttachments;

		private Map<String, List<SpecificAssetId>> assetLinks;

		public Map<String, List<SpecificAssetId>> getAssetLinks() {
			return assetLinks;
		}

		public void setAssetLinks(Map<String, List<SpecificAssetId>> assetLinks) {
			this.assetLinks = assetLinks;
		}

		public Map<String, Map<String, String>> getFileAttachments() {
			return fileAttachments;
		}

		public void setFileAttachments(Map<String, Map<String, String>> fileAttachments) {
			this.fileAttachments = fileAttachments;
		}

		public Map<String, String> getThumbnails() {
			return thumbnails;
		}

		public List<AssetAdministrationShell> getShells() {
			return shells;
		}

		public List<Submodel> getSubmodels() {
			return submodels;
		}

		public List<AssetAdministrationShellDescriptor> getShellDescriptors() {
			return shellDescriptors;
		}

		public List<SubmodelDescriptor> getSubmodelDescriptors() {
			return submodelDescriptors;
		}
	}

	public static interface BasyxTestValues {

	}
}