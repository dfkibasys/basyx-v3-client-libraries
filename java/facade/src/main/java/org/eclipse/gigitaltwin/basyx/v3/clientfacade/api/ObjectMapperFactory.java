package org.eclipse.gigitaltwin.basyx.v3.clientfacade.api;

import com.fasterxml.jackson.databind.ObjectMapper;

public interface ObjectMapperFactory {

	ObjectMapper newObjectMapper();
	
}
