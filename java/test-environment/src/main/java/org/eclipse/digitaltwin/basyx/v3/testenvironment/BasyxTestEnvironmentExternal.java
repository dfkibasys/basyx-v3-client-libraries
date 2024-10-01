package org.eclipse.digitaltwin.basyx.v3.testenvironment;

import com.fasterxml.jackson.databind.ObjectMapper;

public class BasyxTestEnvironmentExternal extends BasyxTestEnvironmentBase {

	private String aasRegistryUrl;
	private String smRegistryUrl;
	private String aasRepositoryUrl;
	private String smRepositoryUrl;
	private String externalMockServerUrl;
	private String internalMockServerUrl;
	private String getAasDiscoveryServiceUrl;
	private String smServiceUrl;

	private BasyxTestEnvironmentExternal(ObjectMapper mapper) {
		super(mapper);
	}

	@Override
	public String getExternalMockServerUrl() {
		return externalMockServerUrl;
	}
	
	@Override
	public String getInternalMockServerUrl() {
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
	public String getCdRepositoryUrl() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAasServiceUrl() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAasDiscoveryserviceUrl() {
		return getAasDiscoveryServiceUrl;
	}

	@Override
	public String getAasxFileserverUrl() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSubmodelServiceUrl() {
		return smServiceUrl;
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
		
		public Builder smServicePort(int port) {
			external.smServiceUrl = toUrl(port);
			return this;
		}

		public Builder aasDiscoveryServicePort(int port) {
			external.getAasDiscoveryServiceUrl = toUrl(port);
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