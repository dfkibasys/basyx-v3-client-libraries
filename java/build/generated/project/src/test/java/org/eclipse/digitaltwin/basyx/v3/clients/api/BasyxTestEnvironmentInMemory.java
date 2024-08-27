package org.eclipse.digitaltwin.basyx.v3.clients.api;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
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
import org.apache.http.entity.BasicHttpEntity;
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
import org.eclipse.digitaltwin.aas4j.v3.model.Submodel;
import org.eclipse.digitaltwin.aas4j.v3.model.SubmodelDescriptor;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part2.GetAssetAdministrationShellDescriptorsResult;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part2.GetAssetAdministrationShellsResult;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part2.GetSubmodelDescriptorsResult;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part2.GetSubmodelsResult;
import org.junit.Assert;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.Network;
import org.testcontainers.containers.wait.strategy.Wait;
import org.testcontainers.utility.DockerImageName;
import org.wiremock.integrations.testcontainers.WireMockContainer;

import com.fasterxml.jackson.databind.ObjectMapper;

public class BasyxTestEnvironmentInMemory extends BasyxTestEnvironmentBase {

	private final Network NETWORK = Network.newNetwork();

	private final GenericContainer<?> aasRegistryContainer = new GenericContainer<>(
			DockerImageName.parse("eclipsebasyx/aas-registry-log-mem:2.0.0-SNAPSHOT")).withExposedPorts(8080)
			.withNetwork(NETWORK).withNetworkAliases("aas-registry").withReuse(true);

	private final GenericContainer<?> smRegistryContainer = new GenericContainer<>(
			DockerImageName.parse("eclipsebasyx/submodel-registry-log-mem:2.0.0-SNAPSHOT")).withExposedPorts(8080)
			.withNetwork(NETWORK).withNetworkAliases("sm-registry").withReuse(true);
	private final GenericContainer<?> aasEnvironmentContainer = new GenericContainer<>(
			DockerImageName.parse("eclipsebasyx/aas-environment:2.0.0-SNAPSHOT")).withExposedPorts(8081)
			.withNetworkAliases("aas-environment")
			.withEnv("BASYX_AASREPOSITORY_FEATURE_REGISTRYINTEGRATION", "http://aas-registry:8080")
			.withEnv("BASYX_SUBMODELREPOSITORY_FEATURE_REGISTRYINTEGRATION", "http://sm-registry:8080")
			.withEnv("BASYX_EXTERNALURL", "http://aas-environment:8081").withNetwork(NETWORK)
			.dependsOn(aasRegistryContainer, smRegistryContainer).withReuse(true);
	
    private final WireMockContainer wireMockContainer = new WireMockContainer("wiremock/wiremock:3.9.1").withNetwork(NETWORK).withReuse(true)
    		.withNetworkAliases("wiremock");

    
	public BasyxTestEnvironmentInMemory(ObjectMapper mapper) {
		super(mapper);
	}

	@Override
	public void up() {
		aasRegistryContainer.waitingFor(Wait.forHealthcheck()).start();
		smRegistryContainer.waitingFor(Wait.forHealthcheck()).start();
		aasEnvironmentContainer.start();
		wireMockContainer.start();
	}

	@Override
	public void down() {
		aasRegistryContainer.stop();
		smRegistryContainer.stop();
		aasEnvironmentContainer.stop();
		wireMockContainer.stop();
	}
	
	@Override
	protected String getInternalMockServerUrl() {
		return "http://wiremock:8080";
	}
	
	@Override
	protected String getExternalMockServerUrl() {
		return "http://localhost:" + wireMockContainer.getFirstMappedPort();
	}

	@Override
	public String getAasRegistryUrl() {
		return "http://localhost:" + aasRegistryContainer.getFirstMappedPort();
	}

	@Override
	public String getSubmodelRepositoryUrl() {
		return getEnvironmentUrl();
	}

	@Override
	public String getSubmodelRegistryUrl() {
		return "http://localhost:" + smRegistryContainer.getFirstMappedPort();
	}
	
	@Override
	public String getAasRepositoryUrl() {
		return getEnvironmentUrl();
	}

	public String getCdRepositoryUrl() {
		return getEnvironmentUrl();
	}

	private String getEnvironmentUrl() {
		return "http://localhost:" + aasEnvironmentContainer.getFirstMappedPort();
	}

	public String getAasxFileserverUrl() {
		// TODO
		return null;
	}

	public String getAasDiscoveryserviceUrl() {
		// TODO
		return null;
	}

	public String getSubmodelServiceUrl() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getAasServiceUrl() {
		// TODO Auto-generated method stub
		return null;
	}

}