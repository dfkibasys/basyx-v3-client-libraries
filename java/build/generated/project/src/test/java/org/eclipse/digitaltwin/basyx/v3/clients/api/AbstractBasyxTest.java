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

	private static SimpleAbstractTypeResolver TYPE_RESOLVER = new SimpleAbstractTypeResolverFactory().create();
	private static JsonMapperFactory JSON_MAPPER_FACTORY = new JsonMapperTestFactory();
	protected static ObjectMapper MAPPER = JSON_MAPPER_FACTORY.create(TYPE_RESOLVER);

	public static BasyxTestEnvironment ENVIRONMENT = new BasyxTestEnvironment(MAPPER);

	static {

		ENVIRONMENT.up();
	}

	private static final class JsonMapperTestFactory extends JsonMapperFactory {
		@Override
		public JsonMapper create(SimpleAbstractTypeResolver typeResolver) {
			Builder builder = JsonMapper.builder().enable(SerializationFeature.INDENT_OUTPUT).disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES).enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
					.annotationIntrospector(new ReflectionAnnotationIntrospector()).serializationInclusion(JsonInclude.Include.NON_NULL);
			builder.configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, true);
			builder.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
			getModulesToInstall(typeResolver).stream().forEach(m -> builder.addModule(m));

			JsonMapper mapper = builder.build();
			ReflectionHelper.JSON_MIXINS.entrySet().forEach(x -> mapper.addMixIn(x.getKey(), x.getValue()));

			return mapper;
		}
	}

}
