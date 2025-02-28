package org.eclipse.digitaltwin.basyx.v3.testenvironment;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.apache.http.client.ClientProtocolException;
import org.eclipse.digitaltwin.aas4j.v3.model.AssetAdministrationShell;
import org.eclipse.digitaltwin.aas4j.v3.model.AssetAdministrationShellDescriptor;
import org.eclipse.digitaltwin.aas4j.v3.model.SpecificAssetId;
import org.eclipse.digitaltwin.aas4j.v3.model.Submodel;
import org.eclipse.digitaltwin.aas4j.v3.model.SubmodelDescriptor;
import org.eclipse.digitaltwin.aas4j.v3.model.SubmodelElement;
import org.eclipse.digitaltwin.basyx.v3.testenvironment.BasyxTestRunner.BasyxRepositoryState;
import org.junit.Assert;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Functions;
import com.google.common.base.Objects;

public class BasyxTestAssertions {
	
	private final ObjectMapper mapper;
	private final BasyxTestEnvironmentBase environment;
	
	public BasyxTestAssertions(BasyxTestEnvironmentBase environment, ObjectMapper mapper) {
		this.mapper = mapper;
		this.environment = environment;
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

	public void assertEnvironmentState(String name, BasyxRepositoryState expected) throws IOException {
		if (expected != null) {
			compareShells(name, expected.getShells());
			compareSubmodels(name, expected.getSubmodels());
			compareShellDescriptors(name, expected.getShellDescriptors());
			compareSubmodelDescriptors(name, expected.getSubmodelDescriptors());
			compareThumbnails(expected.getThumbnails());
			compareFileAttachments(expected.getFileAttachments());
			compareAssetLinks(expected.getAssetLinks());
			compareSubmodelServiceElements(name, expected.getSubmodelServiceElements());
		}
	}

	private void compareSubmodelServiceElements(String name, List<SubmodelElement> submodelServiceElements) throws ClientProtocolException, IOException {
		if (submodelServiceElements != null) {
			Map<String, SubmodelElement> expectedElements = submodelServiceElements.stream().collect(Collectors.toMap(SubmodelElement::getIdShort, Function.identity()));
			Map<String, SubmodelElement> currentElements = environment.getSubmodelServiceElements().stream().collect(Collectors.toMap(SubmodelElement::getIdShort, Function.identity()));
			assertEquals(name, expectedElements, currentElements, "Submodel");
		}		
	}


	private void compareShells(String name, List<AssetAdministrationShell> expectedShellList) throws JsonProcessingException {
		if (expectedShellList != null) {
			Map<String, AssetAdministrationShell> expectedShells = expectedShellList.stream()
					.collect(Collectors.toMap(AssetAdministrationShell::getId, Functions.identity()));
			Map<String, AssetAdministrationShell> currentShells = environment.getAllShells().stream()
					.collect(Collectors.toMap(AssetAdministrationShell::getId, Function.identity()));
			assertEquals(name, expectedShells, currentShells, "Shells");
		}
	}

	private void compareSubmodels(String name, List<Submodel> expectedSubmodelList)
			throws JsonProcessingException {
		if (expectedSubmodelList != null) {
			Map<String, Submodel> expectedSubmodels = expectedSubmodelList.stream()
					.collect(Collectors.toMap(Submodel::getId, Functions.identity()));
			Map<String, Submodel> currentSumodels = environment.getAllSubmodels().stream()
					.collect(Collectors.toMap(Submodel::getId, Function.identity()));
			assertEquals(name, expectedSubmodels, currentSumodels, "Submodels");
		}
	}

	private void compareShellDescriptors(String name,
			List<AssetAdministrationShellDescriptor> expectedShellDescriptorsList)
			throws JsonProcessingException {
		if (expectedShellDescriptorsList != null) {
			Map<String, AssetAdministrationShellDescriptor> expectedShellDescriptors = expectedShellDescriptorsList
					.stream()
					.collect(Collectors.toMap(AssetAdministrationShellDescriptor::getId, Functions.identity()));
			Map<String, AssetAdministrationShellDescriptor> currentShellDescriptors = environment
					.getAllShellDescriptors().stream()
					.collect(Collectors.toMap(AssetAdministrationShellDescriptor::getId, Function.identity()));
			assertEquals(name, expectedShellDescriptors, currentShellDescriptors, "ShellDescriptors");
		}
	}

	private void compareSubmodelDescriptors(String name, List<SubmodelDescriptor> expectedSubmodelDescriptorsList)
			throws JsonProcessingException {
		if (expectedSubmodelDescriptorsList != null) {
			Map<String, SubmodelDescriptor> expectedSubmodelDescriptors = expectedSubmodelDescriptorsList.stream()
					.collect(Collectors.toMap(SubmodelDescriptor::getId, Functions.identity()));
			Map<String, SubmodelDescriptor> currentSubmodelDescriptors = environment.getAllSubmodelDescriptors()
					.stream().collect(Collectors.toMap(SubmodelDescriptor::getId, Function.identity()));
			assertEquals(name, expectedSubmodelDescriptors, currentSubmodelDescriptors, "SubmodelDescriptors");
		}
	}

	private void compareThumbnails(Map<String, String> thumbnails) throws ClientProtocolException, IOException {
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

	private void compareFileAttachments(Map<String, Map<String, String>> attachments) throws IOException {
		if (attachments == null) {
			return;
		}
		for (Entry<String, Map<String, String>> eachAttachment : attachments.entrySet()) {
			String smId = eachAttachment.getKey();
			for (Entry<String, String> eachPathMapping : eachAttachment.getValue().entrySet()) {
				String path = eachPathMapping.getKey();
				Path filePath = Path.of(eachPathMapping.getValue());
				Optional<byte[]> dataOpt = environment.getFileAttachment(smId, path);
				Assert.assertTrue("File attachment for submodel '" + smId + "' and submodel element path '" + path
						+ "' not found on backend.", dataOpt.isPresent());
				byte[] expectedFile = Files.readAllBytes(filePath);
				Assert.assertArrayEquals(expectedFile, dataOpt.get());
			}
		}
	}

	private void compareAssetLinks(Map<String, List<SpecificAssetId>> expectedAssetLinks)
			throws JsonProcessingException {
		if (expectedAssetLinks == null) {
			return;
		}
		List<String> currentIds = environment.getAllAssetLinks();
		TreeSet<String> missing = new TreeSet<>(expectedAssetLinks.keySet());
		missing.removeAll(currentIds);
		TreeSet<String> notExpected = new TreeSet<>(currentIds);
		notExpected.removeAll(expectedAssetLinks.keySet());
		Assert.assertTrue("Entries " + missing + " not found on backend-side.", missing.isEmpty());
		Assert.assertTrue("Entries " + currentIds + " found on backend-side but are not expected.",
				notExpected.isEmpty());

		for (Entry<String, List<SpecificAssetId>> eachExpected : expectedAssetLinks.entrySet()) {
			String id = eachExpected.getKey();
			List<SpecificAssetId> expectedLinks = eachExpected.getValue();
			Optional<List<SpecificAssetId>> currentLinksOpt = environment.getAssetLinks(id);
			compareAssetLinksForId(id, expectedLinks, currentLinksOpt);
		}

	}

	private void compareAssetLinksForId(String id, List<SpecificAssetId> expectedLinks,
			Optional<List<SpecificAssetId>> currentLinksOpt) throws JsonProcessingException {

		Assert.assertTrue("Entry " + id + " not found on backend-side", currentLinksOpt.isPresent());
		List<SpecificAssetId> currentLinks = currentLinksOpt.get();

		SortedSet<SpecificAssetId> sortedCurrent = sortedIds(currentLinks);
		SortedSet<SpecificAssetId> sortedExpected = sortedIds(expectedLinks);
		// for now we care about the order of elements
		String currentAsJson = mapper.writeValueAsString(sortedCurrent);
		String expectedAsJson = mapper.writeValueAsString(sortedExpected);

		Assert.assertEquals("Expected and backend-side asset links are not the same.", expectedAsJson, currentAsJson);

	}

	private SortedSet<SpecificAssetId> sortedIds(List<SpecificAssetId> ids) {
		Comparator<SpecificAssetId> comparator = Comparator.comparing(SpecificAssetId::getName).thenComparing(SpecificAssetId::getValue);
		TreeSet<SpecificAssetId> idsSorted = new TreeSet<>(comparator);
		idsSorted.addAll(ids);
		return idsSorted;
	}

	private <T> void assertEquals(String name, Map<String, T> expected, Map<String, T> current, String resourceName)
			throws JsonProcessingException {
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

	public <R extends Object> void assertExpectedReturnValue(String name, R expected, R result) throws IOException {
		if (expected instanceof File && result instanceof File) {
			File expectedFile = (File) expected;
			Assert.assertTrue(name + ": Return file is not equals to " + expectedFile.getPath(),
					areFilesEqual(expectedFile, (File) result));
			
		} else if (!Objects.equal(expected, result)) {
			Assert.assertEquals(name + ": Return values is not equals to the expected one",
					mapper.writeValueAsString(expected), mapper.writeValueAsString(result));
		}
	}


	public <R extends Object> void assertExpectedReturnValues(String name, List<R> expected, List<R> result) throws JsonProcessingException {
		Set<R> toCompareResult = new HashSet<>(result);
		Set<R> toCompareExpected = new HashSet<>(expected);
		toCompareResult.removeAll(expected);
		if (!toCompareResult.isEmpty()) {
			Assert.assertEquals(name + ": Got more return values than expected",
					mapper.writeValueAsString(result), mapper.writeValueAsString(expected));
		}
		toCompareExpected.removeAll(result);
		if (!toCompareExpected.isEmpty()) {
			Assert.assertEquals(name + ": Got less return values than expected",
					mapper.writeValueAsString(result), mapper.writeValueAsString(expected));
		}
	}
}
