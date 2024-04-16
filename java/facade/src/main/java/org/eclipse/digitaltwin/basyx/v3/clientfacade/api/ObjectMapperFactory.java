package org.eclipse.digitaltwin.basyx.v3.clientfacade.api;

import com.fasterxml.jackson.databind.ObjectMapper;

public interface ObjectMapperFactory {

	ObjectMapper newObjectMapper();
	
}
