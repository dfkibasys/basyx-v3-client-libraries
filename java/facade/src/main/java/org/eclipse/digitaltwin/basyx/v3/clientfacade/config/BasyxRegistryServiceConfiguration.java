package org.eclipse.digitaltwin.basyx.v3.clientfacade.config;

public interface BasyxRegistryServiceConfiguration {

	Integer DEFAULT_FETCH_LIMIT = 100;
	
	String getAasRegistryUrl();
	
	String getSubmodelRegistrUrl();

	Integer getFetchLimit();
	
	
}
