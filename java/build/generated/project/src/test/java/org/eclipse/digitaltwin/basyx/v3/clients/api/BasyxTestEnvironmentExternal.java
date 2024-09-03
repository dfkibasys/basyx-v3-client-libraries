package org.eclipse.digitaltwin.basyx.v3.clients.api;

import com.fasterxml.jackson.databind.ObjectMapper;

public class BasyxTestEnvironmentExternal extends BasyxTestEnvironmentBase {

	private String aasRegistryUrl;
	private String smRegistryUrl;
	private String aasRepositoryUrl;
	private String smRepositoryUrl;
	private String externalMockServerUrl;
	private String internalMockServerUrl;
	private String getAasDiscoveryServiceUrl;

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
		return getAasDiscoveryServiceUrl;
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