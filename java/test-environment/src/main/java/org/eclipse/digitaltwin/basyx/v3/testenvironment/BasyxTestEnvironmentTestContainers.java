package org.eclipse.digitaltwin.basyx.v3.testenvironment;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.Network;
import org.testcontainers.containers.wait.strategy.Wait;
import org.testcontainers.images.builder.ImageFromDockerfile;
import org.testcontainers.images.builder.Transferable;
import org.testcontainers.utility.DockerImageName;
import org.wiremock.integrations.testcontainers.WireMockContainer;

import com.fasterxml.jackson.databind.ObjectMapper;

public class BasyxTestEnvironmentTestContainers extends BasyxTestEnvironmentBase {

	private final Network NETWORK = Network.newNetwork();

	private final GenericContainer<?> aasRegistryContainer = new GenericContainer<>(
			DockerImageName.parse("eclipsebasyx/aas-registry-log-mem:2.0.0-SNAPSHOT")).withExposedPorts(8080)
			.withNetwork(NETWORK).withNetworkAliases("aas-registry").withReuse(true);

	private final GenericContainer<?> smRegistryContainer = new GenericContainer<>(
			DockerImageName.parse("eclipsebasyx/submodel-registry-log-mem:2.0.0-SNAPSHOT")).withExposedPorts(8080)
			.withNetwork(NETWORK).withNetworkAliases("sm-registry").withReuse(true);
	private final GenericContainer<?> aasEnvironmentContainer = new GenericContainer<>(
			DockerImageName.parse("eclipsebasyx/aas-environment:2.0.0-SNAPSHOT")).withExposedPorts(8081)
			.withNetworkAliases("aas-environment")
			.withEnv("BASYX_AASREPOSITORY_FEATURE_REGISTRYINTEGRATION", "http://aas-registry:8080")
			.withEnv("BASYX_SUBMODELREPOSITORY_FEATURE_REGISTRYINTEGRATION", "http://sm-registry:8080")
			.withEnv("BASYX_EXTERNALURL", "http://aas-environment:8081").withNetwork(NETWORK)
			.dependsOn(aasRegistryContainer, smRegistryContainer).withReuse(true);

	private final GenericContainer<?> aasDiscoveryContainer = new GenericContainer<>(
			DockerImageName.parse("eclipsebasyx/aas-discovery:2.0.0-SNAPSHOT")).withExposedPorts(8081)
			.withNetworkAliases("aas-discovery-container").withReuse(true);

	// TODO replace this if the submodel service is online
	private final ImageFromDockerfile builtImage = new ImageFromDockerfile().withFileFromPath(".",
			new File("C:\\repo\\bgeso\\basyx.submodelservice\\basyx.submodelservice.component").toPath());

	private final GenericContainer<?> smServiceContainer = new GenericContainer<>(builtImage)
			// DockerImageName.parse("eclipsebasyx/submodel-service:test"))
			.withExposedPorts(8080).withNetworkAliases("submodel-service").withNetwork(NETWORK).withReuse(true);

	private final WireMockContainer wireMockContainer = new WireMockContainer("wiremock/wiremock:3.9.1")
			.withNetwork(NETWORK).withReuse(true).withNetworkAliases("wiremock");

	public BasyxTestEnvironmentTestContainers(ObjectMapper mapper) {
		super(mapper);
	}

	@Override
	public void up() {
		SubmodelServiceInitializer initializer = new SubmodelServiceInitializer(new SubmodelServiceTransferables());
		initializer.withContent(smServiceContainer);
		CompletableFuture
				.allOf(CompletableFuture.runAsync(() -> aasRegistryContainer.waitingFor(Wait.forHealthcheck()).start()),
						CompletableFuture.runAsync(() -> smRegistryContainer.waitingFor(Wait.forHealthcheck()).start()),
						CompletableFuture
								.runAsync(() -> aasEnvironmentContainer.waitingFor(Wait.forHealthcheck()).start()),
						CompletableFuture.runAsync(() -> wireMockContainer.waitingFor(Wait.forHealthcheck()).start()),
						CompletableFuture
								.runAsync(() -> aasDiscoveryContainer.waitingFor(Wait.forHealthcheck()).start()),
						CompletableFuture.runAsync(() -> smServiceContainer.waitingFor(Wait.forHealthcheck()).start()))
				.join();
		System.out.println("test");
	}

	@Override
	public void down() {
		CompletableFuture.allOf(CompletableFuture.runAsync(() -> aasRegistryContainer.stop()),
				CompletableFuture.runAsync(() -> smRegistryContainer.stop()),
				CompletableFuture.runAsync(() -> aasEnvironmentContainer.stop()),
				CompletableFuture.runAsync(() -> wireMockContainer.stop()),
				CompletableFuture.runAsync(() -> aasDiscoveryContainer.stop()),
				CompletableFuture.runAsync(() -> smServiceContainer.stop())).join();
	}

	@Override
	public String getInternalMockServerUrl() {
		return "http://wiremock:8080";
	}

	@Override
	public String getExternalMockServerUrl() {
		return "http://localhost:" + wireMockContainer.getFirstMappedPort();
	}

	@Override
	public String getAasRegistryUrl() {
		return "http://localhost:" + aasRegistryContainer.getFirstMappedPort();
	}

	@Override
	public String getSubmodelRepositoryUrl() {
		return getEnvironmentUrl();
	}

	@Override
	public String getSubmodelRegistryUrl() {
		return "http://localhost:" + smRegistryContainer.getFirstMappedPort();
	}

	@Override
	public String getAasRepositoryUrl() {
		return getEnvironmentUrl();
	}

	public String getCdRepositoryUrl() {
		return getEnvironmentUrl();
	}

	private String getEnvironmentUrl() {
		return "http://localhost:" + aasEnvironmentContainer.getFirstMappedPort();
	}

	public String getAasxFileserverUrl() {
		// TODO
		return null;
	}

	public String getAasDiscoveryserviceUrl() {
		return "http://localhost:" + aasDiscoveryContainer.getFirstMappedPort();
	}

	public String getSubmodelServiceUrl() {
		return "http://localhost:" + smServiceContainer.getFirstMappedPort();
	}

	public String getAasServiceUrl() {
		// TODO Auto-generated method stub
		return null;
	}

	private static class SubmodelServiceInitializer {

		private final SubmodelServiceTransferables transferables;

		public SubmodelServiceInitializer(SubmodelServiceTransferables transferables) {
			this.transferables = transferables;
		}

		private <SELF extends GenericContainer<SELF>> GenericContainer<SELF> withContent(
				GenericContainer<SELF> container) {
			try {
				transferables.buildTransferables(ResourcePath.values()).forEach((k,v)->container.withCopyToContainer(v, k));
				return container;
			} catch (IOException ex) {
				throw new RuntimeException("Failed to provide submodel service content", ex);
			}
		}
	}
	public static enum ResourcePath {

		SUBMODEL("/application/submodel.json"),
		POST_OP("/application/classes/PostOperation.class"),
		APPLICATION_CONFIG("/application/config/application.yml");
//		POST_OP("/application/sources/PostOperation.java"),
//		JAR_DATA_FORMAT_CORE("/application/libs/aas4j-dataformat-core-1.0.2.jar"),
//		JAR_DATA_FORMAT_JSON("/application/libs/aas4j-dataformat-json-1.0.2.jar"),
//		JAR_AAS4J_MODEL("/application/libs/aas4j-model-1.0.2.jar"),
//		JAR_JACKSON_CORE("/application/libs/jackson-core-2.17.2.jar"),
//		JAR_JACKSON_DATABIND("/application/libs/jackson-databind-2.17.2.jar");
		
		private final String path;

		private ResourcePath(String path) {
			this.path = path;
		}
		
		public String getPath() {
			return path;
		}
	}
	private static class SubmodelServiceTransferables {

		public Map<String, Transferable> buildTransferables(ResourcePath... paths) throws IOException {
			Map<String, Transferable> toReturn = new HashMap<>();
			for (ResourcePath eachPath : paths) {
				String path = eachPath.getPath();
				toReturn.put(path, getTransferableFromResource(path));
			}
			return toReturn;
		}
		
		public Transferable getTransferableFromResource(String path) throws IOException {
			return Transferable.of(ClasspathResources.readFromResource(path));
		}
	}
}