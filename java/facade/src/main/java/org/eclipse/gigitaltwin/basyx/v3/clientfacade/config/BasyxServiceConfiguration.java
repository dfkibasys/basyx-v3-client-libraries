package org.eclipse.gigitaltwin.basyx.v3.clientfacade.config;

public interface BasyxServiceConfiguration {

	Integer DEFAULT_FETCH_LIMIT = 100;
	
	String getAasRegistryUrl();
	
	String getSubmodelRegistrUrl();

	Integer getFetchLimit();
	
	
}
