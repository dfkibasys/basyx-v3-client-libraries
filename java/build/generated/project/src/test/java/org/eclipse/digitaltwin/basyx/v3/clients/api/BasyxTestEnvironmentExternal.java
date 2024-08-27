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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.cfg.MapperBuilder;
import com.fasterxml.jackson.databind.json.JsonMapper;

public class BasyxTestEnvironmentExternal extends BasyxTestEnvironmentBase {

	private String aasRegistryUrl;
	private String smRegistryUrl;
	private String aasRepositoryUrl;
	private String smRepositoryUrl;
	private String externalMockServerUrl;
	private String internalMockServerUrl;

	private BasyxTestEnvironmentExternal(ObjectMapper mapper) {
		super(mapper);
	}

	@Override
	protected String getExternalMockServerUrl() {
		return externalMockServerUrl;
	}
	
	@Override
	protected String getInternalMockServerUrl() {
		return internalMockServerUrl;
	}
	
	
	@Override
	public String getAasRegistryUrl() {
		return aasRegistryUrl;
	}

	@Override
	public String getSubmodelRepositoryUrl() {
		return smRepositoryUrl;
	}

	@Override
	public String getSubmodelRegistryUrl() {
		return smRegistryUrl;
	}

	@Override
	public String getAasRepositoryUrl() {
		return aasRepositoryUrl;
	}

	@Override
	protected String getCdRepositoryUrl() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String getAasServiceUrl() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String getAasDiscoveryserviceUrl() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String getAasxFileserverUrl() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String getSubmodelServiceUrl() {
		// TODO Auto-generated method stub
		return null;
	}

	public static final class Builder {

		private final BasyxTestEnvironmentExternal external;
		private final String baseHost;

		public Builder(ObjectMapper mapper, String baseHost) {
			this.external = new BasyxTestEnvironmentExternal(mapper);
			this.baseHost = baseHost;
		}
		
		public Builder mockServicePort(int port, String containerUrl) {
			external.externalMockServerUrl = toUrl(port);
			external.internalMockServerUrl = containerUrl;
			return this;
		}

		public Builder aasRegistryPort(int port) {
			external.aasRegistryUrl = toUrl(port);
			return this;
		}

		public Builder aasRepositoryPort(int port) {
			external.aasRepositoryUrl = toUrl(port);
			return this;
		}

		public Builder smRegistryPort(int port) {
			external.smRegistryUrl = toUrl(port);
			return this;
		}

		public Builder smRepositoryPort(int port) {
			external.smRepositoryUrl = toUrl(port);
			return this;
		}

		private String toUrl(int port) {
			return baseHost + ":" + port;
		}

		public BasyxTestEnvironmentBase build() {
			return external;
		}
	}

}