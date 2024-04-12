package org.eclipse.gigitaltwin.basyx.v3.clientfacade.endpoints;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;
import java.util.function.BiFunction;

import org.eclipse.digitaltwin.aas4j.v3.model.AssetAdministrationShell;
import org.eclipse.digitaltwin.aas4j.v3.model.Endpoint;
import org.eclipse.digitaltwin.aas4j.v3.model.Identifiable;
import org.eclipse.digitaltwin.aas4j.v3.model.ProtocolInformation;
import org.eclipse.digitaltwin.aas4j.v3.model.Submodel;
import org.eclipse.digitaltwin.basyx.v3.clients.ApiException;
import org.eclipse.digitaltwin.basyx.v3.clients.api.AssetAdministrationShellRepositoryApi;
import org.eclipse.digitaltwin.basyx.v3.clients.api.SubmodelRepositoryApi;

import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class AbstractEndpointResolver implements EndpointResolver {

	@Override
	public AssetAdministrationShell resolveShell(ObjectMapper mapper, List<Endpoint> endpoints) {
		return resolve(mapper, endpoints, this::resolveShellInstance);
	}
	
	@Override
	public Submodel resolveSubmodel(ObjectMapper mapper, List<Endpoint> endpoints) {
		return resolve(mapper, endpoints, this::resolveSubmodelInstance);
	}

	private <T extends Identifiable> T resolve(ObjectMapper mapper, List<Endpoint> endpoints, BiFunction<ObjectMapper, Endpoint, T> resolver) {
		if (endpoints == null || endpoints.isEmpty()) {
			return null;
		}
		Endpoint endpoint = chooseEndpoint(endpoints);
		if (endpoint == null) {
			return null;
		}
		return resolver.apply(mapper, endpoint);
	}
	
	abstract Endpoint chooseEndpoint(List<Endpoint> endpoints);

	protected AssetAdministrationShell resolveShellInstance(ObjectMapper mapper, Endpoint endpoint) {
		EndpointParser parser = EndpointParser.forShells();
		EndpointParser.EndpointInfo info = parser.parse(endpoint);		
		AssetAdministrationShellRepositoryApi repoApi = new AssetAdministrationShellRepositoryApi(mapper, info.getServerPart());
		return repoApi.getAssetAdministrationShellById(info.getIdPartDecoded());
	}
	
	protected Submodel resolveSubmodelInstance(ObjectMapper mapper, Endpoint endpoint) {
		EndpointParser parser = EndpointParser.forSubmodels();
		EndpointParser.EndpointInfo info = parser.parse(endpoint);		
		SubmodelRepositoryApi repoApi = new SubmodelRepositoryApi(mapper, info.getServerPart());
		return repoApi.getSubmodelById(info.getIdPartDecoded(), null, null);
	}
		
	private static class EndpointParser {
		
		private final static String SHELLS_SEPARATOR = "/shells/";
		private final static String SUBMODELS_SEPARATOR = "/submodels/";
		
		private final String serverIdSeparator;
		
		private EndpointParser(String serverIdSeparator) {
			this.serverIdSeparator = serverIdSeparator;
		}
		
		public static EndpointParser forShells() {
			return new EndpointParser(SHELLS_SEPARATOR);
		}
		
		public static EndpointParser forSubmodels() {
			return new EndpointParser(SUBMODELS_SEPARATOR);
		}
		
		
		private EndpointInfo parse(Endpoint endpoint) {
			ProtocolInformation info = endpoint.getProtocolInformation();
			if (info == null) {
				throw new ApiException("ProtocolInformation not set");
			}
			String href = info.getHref();
			if (href == null) {
				throw new ApiException("Href not set");
			}
			String[] split = href.split(serverIdSeparator);
			if (split.length != 2) {
				throw new ApiException("Href reference format not supported " + href);
			}
			return new EndpointInfo(split[0], split[1]);
		}
		
		public static class EndpointInfo {

			private final String serverPart;
			private final String idPart;
					
			public EndpointInfo(String serverPart, String idPart) {
				this.serverPart = serverPart;
				this.idPart = idPart;
			}
			
			public String getServerPart() {
				return serverPart;
			}
			
			public String getIdPart() {
				return idPart;
			}
			
			public String getIdPartDecoded() {
				return new String(Base64.getUrlDecoder().decode(getIdPart()), StandardCharsets.UTF_8);	
			}
		}
	}	
}
