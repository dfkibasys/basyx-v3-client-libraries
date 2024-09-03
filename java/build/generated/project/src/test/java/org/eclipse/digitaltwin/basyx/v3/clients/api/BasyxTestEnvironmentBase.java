package org.eclipse.digitaltwin.basyx.v3.clients.api;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.Base64;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.eclipse.digitaltwin.aas4j.v3.model.AssetAdministrationShell;
import org.eclipse.digitaltwin.aas4j.v3.model.AssetAdministrationShellDescriptor;
import org.eclipse.digitaltwin.aas4j.v3.model.AssetInformation;
import org.eclipse.digitaltwin.aas4j.v3.model.Identifiable;
import org.eclipse.digitaltwin.aas4j.v3.model.Resource;
import org.eclipse.digitaltwin.aas4j.v3.model.SpecificAssetId;
import org.eclipse.digitaltwin.aas4j.v3.model.Submodel;
import org.eclipse.digitaltwin.aas4j.v3.model.SubmodelDescriptor;
import org.eclipse.digitaltwin.basyx.v3.clients.ApiException;
import org.eclipse.digitaltwin.basyx.v3.clients.model.GetAllAssetLinksResult;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part2.GetAssetAdministrationShellDescriptorsResult;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part2.GetAssetAdministrationShellsResult;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part2.GetSubmodelDescriptorsResult;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part2.GetSubmodelsResult;
import org.junit.Assert;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class BasyxTestEnvironmentBase {

	private final ObjectMapper mapper;
	
	public BasyxTestEnvironmentBase(ObjectMapper mapper) {
		this.mapper = mapper; 
	}
		
	public void postSubmodel(CloseableHttpClient client, Submodel sm) throws ClientProtocolException, IOException {
		postResource(client, getSubmodelRepositoryUrl(), "submodels", sm);
	}

	public void postShell(CloseableHttpClient client, AssetAdministrationShell shell)
			throws ClientProtocolException, IOException {
		postResource(client, getAasRepositoryUrl(), "shells", shell);
	}

	public void postShellDescriptor(CloseableHttpClient client, AssetAdministrationShellDescriptor descr)
			throws ClientProtocolException, IOException {
		postResource(client, getAasRegistryUrl(), "shell-descriptors", descr);
	}

	public void postSubmodelDescriptor(CloseableHttpClient client, SubmodelDescriptor descr)
			throws ClientProtocolException, IOException {
		postResource(client, getSubmodelRegistryUrl(), "submodel-descriptors", descr);
	}

	private void postResource(CloseableHttpClient client, String url, String path, Object resource)
			throws ClientProtocolException, IOException {
		HttpPost post = new HttpPost(url + "/" + path);
		post.setHeader("Content-Type", "application/json");
		String toSend = mapper.writeValueAsString(resource);
		post.setEntity(new StringEntity(toSend, ContentType.APPLICATION_JSON));

		try (CloseableHttpResponse response = client.execute(post)) {
			Assert.assertEquals(HttpStatus.SC_CREATED, response.getStatusLine().getStatusCode());
		}
	}

	public void putThumbnailFile(CloseableHttpClient client, String id, Path filePath)
			throws ClientProtocolException, IOException {
		HttpEntity entity = MultipartEntityBuilder.create().addPart("file", new FileBody(filePath.toFile()))
				.addTextBody("fileName", filePath.getFileName().toString())
				.setContentType(ContentType.MULTIPART_FORM_DATA).build();
		String encodedId = Base64.getUrlEncoder().encodeToString(id.getBytes(StandardCharsets.UTF_8));
		HttpPut put = new HttpPut(getAasRepositoryUrl() + "/shells/"
				+ encodedId + "/asset-information/thumbnail");
		put.setEntity(entity);		
		
		try (CloseableHttpResponse response = client.execute(put)) {
			Assert.assertEquals(HttpStatus.SC_OK, response.getStatusLine().getStatusCode());
		}
	}
	
	public void putFileAttachment(CloseableHttpClient client, String smId, String smePath, Path filePath) throws ClientProtocolException, IOException {
		// for now we assume that value and content-type in submodel-element match the referenced file of this put request
		HttpEntity entity = MultipartEntityBuilder.create().addPart("file", new FileBody(filePath.toFile()))
				.addTextBody("fileName", filePath.getFileName().toString())
				.setContentType(ContentType.MULTIPART_FORM_DATA).build();
		String encodedId = Base64.getUrlEncoder().encodeToString(smId.getBytes(StandardCharsets.UTF_8));
		HttpPut put = new HttpPut(getSubmodelRepositoryUrl() + "/submodels/"
				+ encodedId + "/submodel-elements/" + smePath + "/attachment?fileName=");
		put.setEntity(entity);		
		
		try (CloseableHttpResponse response = client.execute(put)) {
			Assert.assertEquals(HttpStatus.SC_OK, response.getStatusLine().getStatusCode());
		}
	}
	
	public void postAssetLinks(CloseableHttpClient client, String id, List<SpecificAssetId> value) throws ClientProtocolException, IOException {
		String url = getAasDiscoveryserviceUrl();
		String encodedId = Base64.getUrlEncoder().encodeToString(id.getBytes(StandardCharsets.UTF_8));
		HttpPost post = new HttpPost(url + "/lookup/shells/" + encodedId);
		post.setHeader("Content-Type", "application/json");
		String toSend = mapper.writeValueAsString(value);
		post.setEntity(new StringEntity(toSend, ContentType.APPLICATION_JSON));

		try (CloseableHttpResponse response = client.execute(post)) {
			Assert.assertEquals(HttpStatus.SC_CREATED, response.getStatusLine().getStatusCode());
		}
	}
	
	public void cleanup() {
		try (CloseableHttpClient client = HttpClients.createMinimal()) {

			for (AssetAdministrationShell eachShell : getAllShells()) {
				String id = eachShell.getId();				
				deleteThumbnailIfPresent(client, eachShell);
				deleteShell(client, id);
			}
			for (Submodel eachSm : getAllSubmodels()) {
				deleteSubmodel(client, eachSm.getId());
			}
			for (AssetAdministrationShellDescriptor eachDescr : getAllShellDescriptors()) {
				deleteShellDescriptor(client, eachDescr.getId());
			}
			for (SubmodelDescriptor eachDescr : getAllSubmodelDescriptors()) {
				deleteSubmodelDescriptor(client, eachDescr.getId());
			}
			for (String eachId : getAllAssetLinks()) {
				deleteAssetLinks(client, eachId);
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private void deleteAssetLinks(CloseableHttpClient client, String id) throws ClientProtocolException, IOException {
		deleteResource(client, getAasDiscoveryserviceUrl(), "lookup/shells", id);
	}

	private void deleteShellDescriptor(CloseableHttpClient client, String id)
			throws ClientProtocolException, IOException {
		deleteResource(client, getAasRegistryUrl(), "shell-descriptors", id);
	}

	private void deleteSubmodelDescriptor(CloseableHttpClient client, String id)
			throws ClientProtocolException, IOException {
		deleteResource(client, getSubmodelRegistryUrl(), "submodel-descriptors", id);
	}

	private void deleteSubmodel(CloseableHttpClient client, String id) throws ClientProtocolException, IOException {
		deleteResource(client, getSubmodelRepositoryUrl(), "submodels", id);
	}

	private void deleteShell(CloseableHttpClient client, String id) throws ClientProtocolException, IOException {
		deleteResource(client, getAasRepositoryUrl(), "shells", id);
	}

	private <T extends Identifiable> void deleteResource(CloseableHttpClient client, String url,
			String resourcePath, String id) throws ClientProtocolException, IOException {
		String idEncoded = Base64.getUrlEncoder().encodeToString(id.getBytes(StandardCharsets.UTF_8));
		HttpDelete delete = new HttpDelete(
				url + "/" + resourcePath + "/" + idEncoded);
		delete.setHeader("Accept", "application/json");
		try (CloseableHttpResponse response = client.execute(delete)) {
			Assert.assertEquals(HttpStatus.SC_NO_CONTENT, response.getStatusLine().getStatusCode());
		}
	}
	

	public List<AssetAdministrationShell> getAllShells() {
		return getAllResources(getAasRepositoryUrl(), "shells",
				GetAssetAdministrationShellsResult.class).getResult();
	}

	protected abstract String getAasRepositoryUrl();

	public List<Submodel> getAllSubmodels() {
		return getAllResources(getSubmodelRepositoryUrl(),"submodels", GetSubmodelsResult.class)
				.getResult();
	}

	protected abstract String getSubmodelRepositoryUrl();

	public Collection<AssetAdministrationShellDescriptor> getAllShellDescriptors() {
		return getAllResources(getAasRegistryUrl(), "shell-descriptors",
				GetAssetAdministrationShellDescriptorsResult.class).getResult();
	}

	protected abstract String getAasRegistryUrl();

	public Collection<SubmodelDescriptor> getAllSubmodelDescriptors() {
		return getAllResources(getSubmodelRegistryUrl(), "submodel-descriptors",
				GetSubmodelDescriptorsResult.class).getResult();
	}
	
	public List<String> getAllAssetLinks() {
		return getAllResources(getAasDiscoveryserviceUrl(), "/lookup/shells", GetAllAssetLinksResult.class).getResult();
	}
	
	public Optional<List<SpecificAssetId>> getAssetLinks(String id) {
		try (CloseableHttpClient client = HttpClients.createMinimal()) {
			String idEncoded = Base64.getUrlEncoder().encodeToString(id.getBytes(StandardCharsets.UTF_8));
			HttpGet get = new HttpGet(getAasDiscoveryserviceUrl() + "/lookup/shells/" + idEncoded + "?limit=" + Integer.MAX_VALUE);
			get.setHeader("Accept", "application/json");
			try (CloseableHttpResponse response = client.execute(get)) {
				if (response.getStatusLine().getStatusCode() == HttpStatus.SC_NOT_FOUND) {
					return Optional.empty();
				}
				Assert.assertEquals(HttpStatus.SC_OK, response.getStatusLine().getStatusCode());
				try (InputStream in = response.getEntity().getContent();
						BufferedInputStream bIn = new BufferedInputStream(in);
						InputStreamReader reader = new InputStreamReader(bIn, StandardCharsets.UTF_8)) {
					MappingIterator<SpecificAssetId> iter = mapper.readerFor(SpecificAssetId.class).readValues(reader);
					return Optional.of(iter.readAll());
				}
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}


	protected abstract String getSubmodelRegistryUrl();

	private <T> T getAllResources(String url, String resourcePath, Class<T> cls) {
		try (CloseableHttpClient client = HttpClients.createMinimal()) {
			HttpGet get = new HttpGet(url + "/" + resourcePath + "?limit=" + Integer.MAX_VALUE);
			get.setHeader("Accept", "application/json");
			try (CloseableHttpResponse response = client.execute(get)) {
				Assert.assertEquals(HttpStatus.SC_OK, response.getStatusLine().getStatusCode());
				try (InputStream in = response.getEntity().getContent();
						BufferedInputStream bIn = new BufferedInputStream(in);
						InputStreamReader reader = new InputStreamReader(bIn, StandardCharsets.UTF_8)) {
					return mapper.readerFor(cls).readValue(reader);
				}
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public void deleteThumbnailIfPresent(CloseableHttpClient client, AssetAdministrationShell eachShell)
			throws ClientProtocolException, IOException {
		String id = eachShell.getId();
		Optional<Resource> thumbnailOpt = Optional.of(eachShell).map(AssetAdministrationShell::getAssetInformation).map(AssetInformation::getDefaultThumbnail);
		if (thumbnailOpt.isEmpty()) {
			return;
		}
		String encodedId = Base64.getUrlEncoder().encodeToString(id.getBytes(StandardCharsets.UTF_8));
		HttpDelete delete = new HttpDelete(getAasRepositoryUrl()
				+ "/shells/" + encodedId + "/asset-information/thumbnail");
		try (CloseableHttpResponse response = client.execute(delete)) {
		}
	}
	
	public Optional<byte[]> getThumbnail(String id) throws ClientProtocolException, IOException {
		try (CloseableHttpClient client = HttpClients.createMinimal()) {
			String encodedId = Base64.getUrlEncoder().encodeToString(id.getBytes(StandardCharsets.UTF_8));
			HttpGet get = new HttpGet(getAasRepositoryUrl() + "/shells/"
					+ encodedId + "/asset-information/thumbnail");
			try (CloseableHttpResponse response = client.execute(get)) {
				if (response.getStatusLine().getStatusCode() == 200) {
					HttpEntity entity = response.getEntity();
					ByteArrayOutputStream bOut = new ByteArrayOutputStream();
					entity.writeTo(bOut);
					return Optional.of(bOut.toByteArray());
				}
				return Optional.empty();
			}
		}
	}
	

	public Optional<byte[]> getFileAttachment(String smId, String path) throws ClientProtocolException, IOException {
		try (CloseableHttpClient client = HttpClients.createMinimal()) {
			String encodedId = Base64.getUrlEncoder().encodeToString(smId.getBytes(StandardCharsets.UTF_8));
			HttpGet get = new HttpGet(getSubmodelRepositoryUrl() + "/submodels/"
					+ encodedId + "/submodel-elements/" + path + "/attachment");
			try (CloseableHttpResponse response = client.execute(get)) {
				if (response.getStatusLine().getStatusCode() == 200) {
					HttpEntity entity = response.getEntity();
					ByteArrayOutputStream bOut = new ByteArrayOutputStream();
					entity.writeTo(bOut);
					return Optional.of(bOut.toByteArray());
				}
				return Optional.empty();
			}
		}
	}

	public void up() {
	}

	public void down() {
	}

	protected abstract String getCdRepositoryUrl();

	protected abstract String getAasServiceUrl();

	protected abstract String getAasDiscoveryserviceUrl();

	protected abstract String getAasxFileserverUrl();

	protected abstract String getSubmodelServiceUrl();
	
	protected abstract String getInternalMockServerUrl();

	protected abstract String getExternalMockServerUrl();





}
