package org.eclipse.gigitaltwin.basyx.v3.clientfacade.config;

public class SimpleBasyxServiceConfiguration implements BasyxServiceConfiguration {

	private String aasRegistryUrl;
	private String submodelRegistryUrl;
	private Integer fetchLimit;
	
	public SimpleBasyxServiceConfiguration withAasRegistryUrl(String aasRegistryUrl) {
		this.aasRegistryUrl = aasRegistryUrl;
		return this;
	}
	
	@Override
	public String getAasRegistryUrl() {
		return aasRegistryUrl;
	}
	
	public SimpleBasyxServiceConfiguration withSubmodelRegistryUrl(String submodelRegistryUrl) {
		this.submodelRegistryUrl = submodelRegistryUrl;
		return this;
	}
	
	@Override
	public String getSubmodelRegistrUrl() {
		return submodelRegistryUrl;
	}
	
	public SimpleBasyxServiceConfiguration withFetchLimit(Integer fetchLimit) {
		this.fetchLimit = fetchLimit;
		return this;
	}
	
	@Override
	public Integer getFetchLimit() {
		return fetchLimit;
	}

}
