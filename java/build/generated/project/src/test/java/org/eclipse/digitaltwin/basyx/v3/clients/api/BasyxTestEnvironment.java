//package org.eclipse.digitaltwin.basyx.v3.clients.api;
//
//import java.io.BufferedInputStream;
//import java.io.ByteArrayOutputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.nio.charset.StandardCharsets;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.util.Base64;
//import java.util.Collection;
//import java.util.List;
//import java.util.Optional;
//
//import org.apache.http.HttpEntity;
//import org.apache.http.HttpStatus;
//import org.apache.http.client.ClientProtocolException;
//import org.apache.http.client.methods.CloseableHttpResponse;
//import org.apache.http.client.methods.HttpDelete;
//import org.apache.http.client.methods.HttpGet;
//import org.apache.http.client.methods.HttpPost;
//import org.apache.http.client.methods.HttpPut;
//import org.apache.http.entity.BasicHttpEntity;
//import org.apache.http.entity.ContentType;
//import org.apache.http.entity.StringEntity;
//import org.apache.http.entity.mime.MultipartEntityBuilder;
//import org.apache.http.entity.mime.content.FileBody;
//import org.apache.http.impl.client.CloseableHttpClient;
//import org.apache.http.impl.client.HttpClients;
//import org.eclipse.digitaltwin.aas4j.v3.model.AssetAdministrationShell;
//import org.eclipse.digitaltwin.aas4j.v3.model.AssetAdministrationShellDescriptor;
//import org.eclipse.digitaltwin.aas4j.v3.model.AssetInformation;
//import org.eclipse.digitaltwin.aas4j.v3.model.Identifiable;
//import org.eclipse.digitaltwin.aas4j.v3.model.Resource;
//import org.eclipse.digitaltwin.aas4j.v3.model.Submodel;
//import org.eclipse.digitaltwin.aas4j.v3.model.SubmodelDescriptor;
//import org.eclipse.digitaltwin.basyx.v3.clients.model.part2.GetAssetAdministrationShellDescriptorsResult;
//import org.eclipse.digitaltwin.basyx.v3.clients.model.part2.GetAssetAdministrationShellsResult;
//import org.eclipse.digitaltwin.basyx.v3.clients.model.part2.GetSubmodelDescriptorsResult;
//import org.eclipse.digitaltwin.basyx.v3.clients.model.part2.GetSubmodelsResult;
//import org.junit.Assert;
//import org.testcontainers.containers.GenericContainer;
//import org.testcontainers.containers.Network;
//import org.testcontainers.containers.wait.strategy.Wait;
//import org.testcontainers.utility.DockerImageName;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//public class BasyxTestEnvironment {
//
//	private final Network NETWORK = Network.newNetwork();
//
//	private final GenericContainer<?> aasRegistryContainer = new GenericContainer<>(
//			DockerImageName.parse("eclipsebasyx/aas-registry-log-mem:2.0.0-SNAPSHOT")).withExposedPorts(8080)
//			.withNetwork(NETWORK).withNetworkAliases("aas-registry").withReuse(true);
//
//	private final GenericContainer<?> smRegistryContainer = new GenericContainer<>(
//			DockerImageName.parse("eclipsebasyx/submodel-registry-log-mem:2.0.0-SNAPSHOT")).withExposedPorts(8080)
//			.withNetwork(NETWORK).withNetworkAliases("sm-registry").withReuse(true);
//	private final GenericContainer<?> aasEnvironmentContainer = new GenericContainer<>(
//			DockerImageName.parse("eclipsebasyx/aas-environment:2.0.0-SNAPSHOT")).withExposedPorts(8081)
//			.withNetworkAliases("aas-environment")
//			.withEnv("BASYX_AASREPOSITORY_FEATURE_REGISTRYINTEGRATION", "http://aas-registry:8080")
//			.withEnv("BASYX_SUBMODELREPOSITORY_FEATURE_REGISTRYINTEGRATION", "http://sm-registry:8080")
//			.withEnv("BASYX_EXTERNALURL", "http://aas-environment:8081").withNetwork(NETWORK)
//			.dependsOn(aasRegistryContainer, smRegistryContainer).withReuse(true);
//
//	private final ObjectMapper mapper;
//
//	public BasyxTestEnvironment(ObjectMapper mapper) {
//		this.mapper = mapper;
//	}
//
//	public void cleanup() {
//		try (CloseableHttpClient client = HttpClients.createMinimal()) {
//
//			for (AssetAdministrationShell eachShell : getAllShells()) {
//				String id = eachShell.getId();				
//				deleteThumbnailIfPresent(client, eachShell);
//				deleteShell(client, id);
//			}
//			for (Submodel eachSm : getAllSubmodels()) {
//				deleteSubmodel(client, eachSm.getId());
//			}
//			for (AssetAdministrationShellDescriptor eachDescr : getAllShellDescriptors()) {
//				deleteShellDescriptor(client, eachDescr.getId());
//			}
//			for (SubmodelDescriptor eachDescr : getAllSubmodelDescriptors()) {
//				deleteSubmodelDescriptor(client, eachDescr.getId());
//			}
//		} catch (IOException e) {
//			throw new RuntimeException(e);
//		}
//	}
//
//	private void deleteShellDescriptor(CloseableHttpClient client, String id)
//			throws ClientProtocolException, IOException {
//		deleteResource(client, aasRegistryContainer, "shell-descriptors", id);
//	}
//
//	private void deleteSubmodelDescriptor(CloseableHttpClient client, String id)
//			throws ClientProtocolException, IOException {
//		deleteResource(client, smRegistryContainer, "submodel-descriptors", id);
//	}
//
//	private void deleteSubmodel(CloseableHttpClient client, String id) throws ClientProtocolException, IOException {
//		deleteResource(client, aasEnvironmentContainer, "submodels", id);
//	}
//
//	private void deleteShell(CloseableHttpClient client, String id) throws ClientProtocolException, IOException {
//		deleteResource(client, aasEnvironmentContainer, "shells", id);
//	}
//
//	private <T extends Identifiable> void deleteResource(CloseableHttpClient client, GenericContainer<?> container,
//			String resourcePath, String id) throws ClientProtocolException, IOException {
//		String idEncoded = Base64.getUrlEncoder().encodeToString(id.getBytes(StandardCharsets.UTF_8));
//		HttpDelete delete = new HttpDelete(
//				"http://localhost:" + container.getFirstMappedPort() + "/" + resourcePath + "/" + idEncoded);
//		delete.setHeader("Accept", "application/json");
//		try (CloseableHttpResponse response = client.execute(delete)) {
//			Assert.assertEquals(HttpStatus.SC_NO_CONTENT, response.getStatusLine().getStatusCode());
//		}
//	}
//
//	public List<AssetAdministrationShell> getAllShells() {
//		return getAllResources(aasEnvironmentContainer.getFirstMappedPort(), "shells",
//				GetAssetAdministrationShellsResult.class).getResult();
//	}
//
//	public List<Submodel> getAllSubmodels() {
//		return getAllResources(aasEnvironmentContainer.getFirstMappedPort(), "submodels", GetSubmodelsResult.class)
//				.getResult();
//	}
//
//	public Collection<AssetAdministrationShellDescriptor> getAllShellDescriptors() {
//		return getAllResources(aasRegistryContainer.getFirstMappedPort(), "shell-descriptors",
//				GetAssetAdministrationShellDescriptorsResult.class).getResult();
//	}
//
//	public Collection<SubmodelDescriptor> getAllSubmodelDescriptors() {
//		return getAllResources(smRegistryContainer.getFirstMappedPort(), "submodel-descriptors",
//				GetSubmodelDescriptorsResult.class).getResult();
//	}
//
//	private <T> T getAllResources(int port, String resourcePath, Class<T> cls) {
//		try (CloseableHttpClient client = HttpClients.createMinimal()) {
//			HttpGet get = new HttpGet("http://localhost:" + port + "/" + resourcePath + "?limit=" + Integer.MAX_VALUE);
//			get.setHeader("Accept", "application/json");
//			try (CloseableHttpResponse response = client.execute(get)) {
//				Assert.assertEquals(HttpStatus.SC_OK, response.getStatusLine().getStatusCode());
//				try (InputStream in = response.getEntity().getContent();
//						BufferedInputStream bIn = new BufferedInputStream(in);
//						InputStreamReader reader = new InputStreamReader(bIn, StandardCharsets.UTF_8)) {
//					return mapper.readerFor(cls).readValue(reader);
//				}
//			}
//		} catch (IOException e) {
//			throw new RuntimeException(e);
//		}
//	}
//
//	public void postSubmodel(CloseableHttpClient client, Submodel sm) throws ClientProtocolException, IOException {
//		postResource(client, aasEnvironmentContainer, "submodels", sm);
//	}
//
//	public void postShell(CloseableHttpClient client, AssetAdministrationShell shell)
//			throws ClientProtocolException, IOException {
//		postResource(client, aasEnvironmentContainer, "shells", shell);
//	}
//
//	public void postShellDescriptor(CloseableHttpClient client, AssetAdministrationShellDescriptor descr)
//			throws ClientProtocolException, IOException {
//		postResource(client, aasRegistryContainer, "shell-descriptors", descr);
//	}
//
//	public void postSubmodelDescriptor(CloseableHttpClient client, SubmodelDescriptor descr)
//			throws ClientProtocolException, IOException {
//		postResource(client, smRegistryContainer, "submodel-descriptors", descr);
//	}
//
//	private void postResource(CloseableHttpClient client, GenericContainer<?> container, String path, Object resource)
//			throws ClientProtocolException, IOException {
//		HttpPost post = new HttpPost("http://localhost:" + container.getFirstMappedPort() + "/" + path);
//		post.setHeader("Content-Type", "application/json");
//		String toSend = mapper.writeValueAsString(resource);
//		post.setEntity(new StringEntity(toSend, ContentType.APPLICATION_JSON));
//
//		try (CloseableHttpResponse response = client.execute(post)) {
//			Assert.assertEquals(HttpStatus.SC_CREATED, response.getStatusLine().getStatusCode());
//		}
//	}
//
//	public void putThumbnailFile(CloseableHttpClient client, String id, Path filePath)
//			throws ClientProtocolException, IOException {
//		HttpEntity entity = MultipartEntityBuilder.create().addPart("file", new FileBody(filePath.toFile()))
//				.addTextBody("fileName", filePath.getFileName().toString())
//				.setContentType(ContentType.MULTIPART_FORM_DATA).build();
//		String encodedId = Base64.getUrlEncoder().encodeToString(id.getBytes(StandardCharsets.UTF_8));
//		HttpPut put = new HttpPut("http://localhost:" + aasEnvironmentContainer.getFirstMappedPort() + "/shells/"
//				+ encodedId + "/asset-information/thumbnail");
//		put.setEntity(entity);		
//		
//		try (CloseableHttpResponse response = client.execute(put)) {
//			Assert.assertEquals(HttpStatus.SC_OK, response.getStatusLine().getStatusCode());
//		}
//	}
//
//	public Optional<byte[]> getThumbnail(String id) throws ClientProtocolException, IOException {
//		try (CloseableHttpClient client = HttpClients.createMinimal()) {
//			String encodedId = Base64.getUrlEncoder().encodeToString(id.getBytes(StandardCharsets.UTF_8));
//			HttpGet get = new HttpGet("http://localhost:" + aasEnvironmentContainer.getFirstMappedPort() + "/shells/"
//					+ encodedId + "/asset-information/thumbnail");
//			try (CloseableHttpResponse response = client.execute(get)) {
//				if (response.getStatusLine().getStatusCode() == 200) {
//					HttpEntity entity = response.getEntity();
//					ByteArrayOutputStream bOut = new ByteArrayOutputStream();
//					entity.writeTo(bOut);
//					return Optional.of(bOut.toByteArray());
//				}
//				return Optional.empty();
//			}
//		}
//	}
//
//	public void deleteThumbnailIfPresent(CloseableHttpClient client, AssetAdministrationShell eachShell)
//			throws ClientProtocolException, IOException {
//		String id = eachShell.getId();
//		Optional<Resource> thumbnailOpt = Optional.of(eachShell).map(AssetAdministrationShell::getAssetInformation).map(AssetInformation::getDefaultThumbnail);
//		if (thumbnailOpt.isEmpty()) {
//			return;
//		}
//		String encodedId = Base64.getUrlEncoder().encodeToString(id.getBytes(StandardCharsets.UTF_8));
//		HttpDelete delete = new HttpDelete("http://localhost:" + aasEnvironmentContainer.getFirstMappedPort()
//				+ "/shells/" + encodedId + "/asset-information/thumbnail");
//		try (CloseableHttpResponse response = client.execute(delete)) {
//		}
//	}
//
//	public void up() {
//		aasRegistryContainer.waitingFor(Wait.forHealthcheck()).start();
//		smRegistryContainer.waitingFor(Wait.forHealthcheck()).start();
//		aasEnvironmentContainer.start();
//
//	}
//
//	public void down() {
//		aasRegistryContainer.stop();
//		smRegistryContainer.stop();
//		aasEnvironmentContainer.stop();
//	}
//
//	public String getAasRegistryUrl() {
//		return "http://localhost:" + aasRegistryContainer.getFirstMappedPort();
//	}
//
////	public String getSubmodelServiceUrl() {
////		// TODO
////		return null;
////	}
////
////	public String getAasServiceUrl() {
////		// TODO
////		return null;
////	}
//
//	public String getSubmodelRepositoryUrl() {
//		return getEnvironmentUrl();
//	}
//
//	public String getSubmodelRegistryUrl() {
//		return "http://localhost:" + smRegistryContainer.getFirstMappedPort();
//	}
//
//	public String getAasRepositoryUrl() {
//		return getEnvironmentUrl();
//	}
//
//	public String getCdRepositoryUrl() {
//		return getEnvironmentUrl();
//	}
//
//	private String getEnvironmentUrl() {
//		return "http://localhost:" + aasEnvironmentContainer.getFirstMappedPort();
//	}
//
//	public String getAasxFileserverUrl() {
//		// TODO
//		return null;
//	}
//
//	public String getAasDiscoveryserviceUrl() {
//		// TODO
//		return null;
//	}
//
//	public String getSubmodelServiceUrl() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	public String getAasServiceUrl() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//}