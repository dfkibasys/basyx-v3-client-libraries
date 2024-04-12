package org.eclipse.gigitaltwin.basyx.v3.clientfacade.api;

import org.eclipse.digitaltwin.aas4j.v3.dataformat.json.JsonMapperFactory;
import org.eclipse.digitaltwin.aas4j.v3.dataformat.json.SimpleAbstractTypeResolverFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleAbstractTypeResolver;

public class Aas4jObjectMapperFactory implements ObjectMapperFactory {
	
	@Override
	public ObjectMapper newObjectMapper() {
		SimpleAbstractTypeResolver typeResolver = new SimpleAbstractTypeResolverFactory().create();
		JsonMapperFactory     jsonMapperFactory = new JsonMapperFactory();
	    return jsonMapperFactory.create(typeResolver);
	}
}
