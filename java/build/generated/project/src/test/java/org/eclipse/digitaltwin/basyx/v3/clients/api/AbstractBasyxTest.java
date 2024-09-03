package org.eclipse.digitaltwin.basyx.v3.clients.api;

import org.eclipse.digitaltwin.aas4j.v3.dataformat.core.internal.util.ReflectionHelper;
import org.eclipse.digitaltwin.aas4j.v3.dataformat.json.JsonMapperFactory;
import org.eclipse.digitaltwin.aas4j.v3.dataformat.json.SimpleAbstractTypeResolverFactory;
import org.eclipse.digitaltwin.aas4j.v3.dataformat.json.internal.ReflectionAnnotationIntrospector;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.json.JsonMapper.Builder;
import com.fasterxml.jackson.databind.module.SimpleAbstractTypeResolver;

public abstract class AbstractBasyxTest {

	private static final String ENVIRONMENT_MOCKSERVICE_CONTAINERURL = "environment.mockservice.containerurl";
	private static final String ENVIRONMENT_MOCKSERVICE_PORT = "environment.mockservice.port";
	private static final String ENVIRONMENT_SUBMODELREPOSITORY_PORT = "environment.submodelrepository.port";
	private static final String ENVIRONMENT_AASREPOSITORY_PORT = "environment.aasrepository.port";
	private static final String ENVIRONMENT_AASDISCOVERY_PORT = "environment.aasdiscovery.port";
	private static final String ENVIRONMENT_SUBMODELREGISTRY_PORT = "environment.submodelregistry.port";
	private static final String ENVIRONMENT_AASREGISTRY_PORT = "environment.aasregistry.port";
	private static final String ENVIRONMENT_TYPE_EXTERNAL = "EXTERNAL";
	private static final String ENVIRONMENT_TYPE = "environment.type";
	private static final String ENVIRONMENT_BASEURL = "environment.baseurl";
	private static SimpleAbstractTypeResolver TYPE_RESOLVER = new SimpleAbstractTypeResolverFactory().create();
	private static JsonMapperFactory JSON_MAPPER_FACTORY = new JsonMapperTestFactory();
	protected static ObjectMapper MAPPER = JSON_MAPPER_FACTORY.create(TYPE_RESOLVER);

	public static final BasyxTestEnvironmentBase ENVIRONMENT;	

	static {
		String envType = System.getProperty(ENVIRONMENT_TYPE);
		if (ENVIRONMENT_TYPE_EXTERNAL.equals(envType)) {
			String host = getHostName();
			int mockServicePort = getPort(ENVIRONMENT_MOCKSERVICE_PORT);
			int aasRegistryPort = getPort(ENVIRONMENT_AASREGISTRY_PORT);
			int smRegistryPort = getPort(ENVIRONMENT_SUBMODELREGISTRY_PORT);
			int aasRepositoryPort = getPort(ENVIRONMENT_AASREPOSITORY_PORT);
			int smRepositoryPort = getPort(ENVIRONMENT_SUBMODELREPOSITORY_PORT);
			int aasDiscoveryPort = getPort(ENVIRONMENT_AASDISCOVERY_PORT);
			String containerUrl = getWireMockContainerUrl();
			ENVIRONMENT = new BasyxTestEnvironmentExternal.Builder(MAPPER, host).aasRegistryPort(aasRegistryPort)
					.mockServicePort(mockServicePort, containerUrl)
					.aasDiscoveryServicePort(aasDiscoveryPort)
					.aasRepositoryPort(aasRepositoryPort).smRegistryPort(smRegistryPort)
					.smRepositoryPort(smRepositoryPort).build();
		} else {
			ENVIRONMENT = new BasyxTestEnvironmentTestContainers(MAPPER);
		}

	}

	static {
		ENVIRONMENT.up();
	}
	

	private static final class JsonMapperTestFactory extends JsonMapperFactory {
		@Override
		public JsonMapper create(SimpleAbstractTypeResolver typeResolver) {
			Builder builder = JsonMapper.builder().enable(SerializationFeature.INDENT_OUTPUT)
					.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
					.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
					.annotationIntrospector(new ReflectionAnnotationIntrospector())
					.serializationInclusion(JsonInclude.Include.NON_NULL);
			builder.configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, true);
			builder.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
			getModulesToInstall(typeResolver).stream().forEach(m -> builder.addModule(m));

			JsonMapper mapper = builder.build();
			ReflectionHelper.JSON_MIXINS.entrySet().forEach(x -> mapper.addMixIn(x.getKey(), x.getValue()));

			return mapper;
		}
	}


	private static String getHostName() {
		return getSystemPropertyOrDefault(ENVIRONMENT_BASEURL, "http://localhost");
	}
	
	private static String getWireMockContainerUrl() {
		return getSystemPropertyOrDefault(ENVIRONMENT_MOCKSERVICE_CONTAINERURL, "http://wiremock:8080");
	}
	
	public static String getSystemPropertyOrDefault(String prop, String defaultValue) {		
		String host = System.getProperty(prop);
		if (host == null) {
			host = defaultValue;
		}
		return host;
	}
	
	private static int getPort(String envName) {
		String sPort = System.getProperty(envName);
		if (sPort == null) {
			throw new IllegalArgumentException("Environment variable not set: " + envName);
		}
		try {
			return Integer.parseInt(sPort);
		} catch (NumberFormatException ex) {
			throw new IllegalArgumentException("Failed to parse portnumber for " + envName + ": " + sPort);
		}
	}

}
