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
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.eclipse.digitaltwin.aas4j.v3.model.AssetAdministrationShell;
import org.eclipse.digitaltwin.aas4j.v3.model.AssetAdministrationShellDescriptor;
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

	public BasyxTestRunner(BasyxTestEnvironmentBase environment, ObjectMapper mapper, Path testFolder) {
		this.environment = environment;
		this.mapper = mapper;
		this.testFolder = testFolder;
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
					content = content.replace("$PROPERTY(basyxtest.mockserver.url.internal)", environment.getInternalMockServerUrl());
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

	public void initializeServices(BasyxRepositoryState initialState) throws JsonProcessingException, IOException {
		if (initialState == null) {
			return;
		}
		List<AssetAdministrationShell> shells = initialState.getShells();
		List<Submodel> submodels = initialState.getSubmodels();
		List<AssetAdministrationShellDescriptor> shellDescriptors = initialState.getShellDescriptors();
		List<SubmodelDescriptor> smDescriptors = initialState.getSubmodelDescriptors();
		Map<String, String> thumbnails = new HashMap<>(
				initialState.getThumbnails() != null ? initialState.getThumbnails() : Map.of());

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
			assertEnvironmentState(def.getName(), def.getExpectedState());
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
			initializeMockService(def.getMocks());
			initializeServices(def.getInitialState());

			Integer expectedStatus = def.getExpectedErrorStatusCode();
			List<R> expected = def.getExpectedReturnValue();
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

			Set<R> toCompareResult = new HashSet<>(result);
			Set<R> toCompareExpected = new HashSet<>(expected);
			toCompareResult.removeAll(expected);
			if (!toCompareResult.isEmpty()) {
				Assert.assertEquals(def.getName() + ": Got more return values than expected",
						mapper.writeValueAsString(result), mapper.writeValueAsString(expected));
			}
			toCompareExpected.removeAll(result);
			if (!toCompareExpected.isEmpty()) {
				Assert.assertEquals(def.getName() + ": Got less return values than expected",
						mapper.writeValueAsString(result), mapper.writeValueAsString(expected));
			}
			assertEnvironmentState(def.getName(), def.getExpectedState());
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
			LOGGER.info("Running: " + def.getName());
			initializeServices(def.getInitialState());
			initializeMockService(def.getMocks());

			T args = Optional.ofNullable(def.getInvocation()).map(Invocation::getArgs).orElse(null);
			Integer expectedStatus = def.getExpectedErrorStatusCode();
			R expected = def.getExpectedReturnValue();
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
				if (expected instanceof File && result instanceof File) {
					File expectedFile = (File) expected;
					Assert.assertTrue(def.getName() + ": Return file is not equals to " + expectedFile.getPath(),
							areFilesEqual(expectedFile, (File) result));
				} else if (!Objects.equal(expected, result)) {
					Assert.assertEquals(def.getName() + ": Return values is not equals to the expected one",
							mapper.writeValueAsString(expected), mapper.writeValueAsString(result));
				}
			}
			assertEnvironmentState(def.getName(), def.getExpectedState());
		} catch (IOException | JSONException e) {
			throw new RuntimeException(e);
		} finally {
			cleanupMockService(def.getMocks());
			environment.cleanup();
		}
	}

	public static boolean areFilesEqual(File file1, File file2) throws IOException {
		if (file1.length() != file2.length()) {
			return false;
		}
		try (InputStream is1 = new FileInputStream(file1); InputStream is2 = new FileInputStream(file2)) {

			byte[] buffer1 = new byte[1024];
			byte[] buffer2 = new byte[1024];
			int bytesRead1, bytesRead2;

			while ((bytesRead1 = is1.read(buffer1)) != -1) {
				bytesRead2 = is2.read(buffer2);
				if (bytesRead1 != bytesRead2 || !Arrays.equals(buffer1, buffer2)) {
					return false;
				}
			}
		}

		return true;
	}

	private void assertEnvironmentState(String name, BasyxRepositoryState expected) throws IOException, JSONException {
		if (expected == null) {
			return;
		}
		assertRepositoryStatus(name, expected);
		List<AssetAdministrationShell> expectedShellList = expected.getShells();
		if (expectedShellList != null) {
			Map<String, AssetAdministrationShell> expectedShells = expectedShellList.stream()
					.collect(Collectors.toMap(AssetAdministrationShell::getId, Functions.identity()));
			Map<String, AssetAdministrationShell> currentShells = environment.getAllShells().stream()
					.collect(Collectors.toMap(AssetAdministrationShell::getId, Function.identity()));
			assertEquals(name, expectedShells, currentShells, "Shells");
		}
		List<Submodel> expectedSubmodelList = expected.getSubmodels();
		if (expectedSubmodelList != null) {
			Map<String, Submodel> expectedSubmodels = expectedSubmodelList.stream()
					.collect(Collectors.toMap(Submodel::getId, Functions.identity()));
			Map<String, Submodel> currentSumodels = environment.getAllSubmodels().stream()
					.collect(Collectors.toMap(Submodel::getId, Function.identity()));
			assertEquals(name, expectedSubmodels, currentSumodels, "Submodels");
		}
		List<AssetAdministrationShellDescriptor> expectedShellDescriptorsList = expected.getShellDescriptors();
		if (expectedShellDescriptorsList != null) {
			Map<String, AssetAdministrationShellDescriptor> expectedShellDescriptors = expectedShellDescriptorsList
					.stream()
					.collect(Collectors.toMap(AssetAdministrationShellDescriptor::getId, Functions.identity()));
			Map<String, AssetAdministrationShellDescriptor> currentShellDescriptors = environment
					.getAllShellDescriptors().stream()
					.collect(Collectors.toMap(AssetAdministrationShellDescriptor::getId, Function.identity()));
			assertEquals(name, expectedShellDescriptors, currentShellDescriptors, "ShellDescriptors");
		}
		List<SubmodelDescriptor> expectedSubmodelDescriptorsList = expected.getSubmodelDescriptors();
		if (expectedSubmodelDescriptorsList != null) {
			Map<String, SubmodelDescriptor> expectedSubmodelDescriptors = expectedSubmodelDescriptorsList.stream()
					.collect(Collectors.toMap(SubmodelDescriptor::getId, Functions.identity()));
			Map<String, SubmodelDescriptor> currentSubmodelDescriptors = environment.getAllSubmodelDescriptors()
					.stream().collect(Collectors.toMap(SubmodelDescriptor::getId, Function.identity()));
			assertEquals(name, expectedSubmodelDescriptors, currentSubmodelDescriptors, "SubmodelDescriptors");
		}
	}

	private void assertRepositoryStatus(String name, BasyxRepositoryState expected) throws IOException, JSONException {
		if (expected == null) {
			return;
		}
		List<AssetAdministrationShellDescriptor> expectedShellDescrList = expected.getShellDescriptors();
		if (expectedShellDescrList != null) {
			Map<String, AssetAdministrationShellDescriptor> expectedShells = expectedShellDescrList.stream()
					.collect(Collectors.toMap(AssetAdministrationShellDescriptor::getId, Functions.identity()));
			Map<String, AssetAdministrationShellDescriptor> currentShells = environment.getAllShellDescriptors()
					.stream().collect(Collectors.toMap(AssetAdministrationShellDescriptor::getId, Function.identity()));

			assertEquals(name, expectedShells, currentShells, "ShellDescriptors");
		}
		List<Submodel> expectedSubmodelList = expected.getSubmodels();
		if (expectedSubmodelList != null) {
			Map<String, Submodel> expectedSubmodels = expected.getSubmodels().stream()
					.collect(Collectors.toMap(Submodel::getId, Functions.identity()));
			Map<String, Submodel> currentSumodels = environment.getAllSubmodels().stream()
					.collect(Collectors.toMap(Submodel::getId, Function.identity()));

			assertEquals(name, expectedSubmodels, currentSumodels, "SubmodelDescriptors");
		}
		Map<String, String> thumbnails = expected.getThumbnails();
		if (thumbnails != null) {
			for (Entry<String, String> eachThumbnail : thumbnails.entrySet()) {
				String id = eachThumbnail.getKey();
				Path tnPath = Path.of(eachThumbnail.getValue());
				Optional<byte[]> dataOpt = environment.getThumbnail(id);
				Assert.assertTrue("Thumbnail for shell '" + id + "' not found on backend.", dataOpt.isPresent());
				byte[] expectedFile = Files.readAllBytes(tnPath);
				Assert.assertArrayEquals(expectedFile, dataOpt.get());
			}
		}
	}

	private <T> void assertEquals(String name, Map<String, T> expected, Map<String, T> current, String resourceName)
			throws JsonProcessingException, JSONException {
		if (current.isEmpty() && expected.isEmpty()) {
			return;
		}

		for (Entry<String, T> eachEntry : expected.entrySet()) {
			String id = eachEntry.getKey();
			T expectedValue = eachEntry.getValue();
			T eachCurrent = current.remove(id);
			if (eachCurrent == null) {
				if (current.isEmpty()) {
					Assert.assertNotNull(name + ": Expected " + resourceName + " with id " + id
							+ " not found. No resources available on serverside.", eachCurrent);
				} else {
					Assert.assertNotNull(name + ": Expected " + resourceName + " with id " + id + " not found. Only "
							+ current.keySet() + "available.", eachCurrent);
				}
			}
			new BasyxTestMatcher(mapper).assertEquals(
					"Expected resource for id '" + id + "' is not equals the current value.", expectedValue,
					eachCurrent);
		}
		Assert.assertTrue(
				name + ": " + resourceName + " found on backend site but are not expected: " + current.keySet(),
				current.isEmpty());
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
		private File expectedReturnFile;

		public R getExpectedReturnValue() {
			return expectedReturnValue;
		}

		public void setExpectedReturnValue(R returnValue) {
			this.expectedReturnValue = returnValue;
		}

		public File getExpectedReturnFile() {
			return expectedReturnFile;
		}

		public void setExpectedReturnFile(File expectedReturnFile) {
			this.expectedReturnFile = expectedReturnFile;
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