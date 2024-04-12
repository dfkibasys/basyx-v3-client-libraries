package org.eclipse.gigitaltwin.basyx.v3.clientfacade.endpoints;

import java.util.List;

import org.eclipse.digitaltwin.aas4j.v3.model.AssetAdministrationShell;
import org.eclipse.digitaltwin.aas4j.v3.model.Endpoint;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RewritingEndpointResolver extends AbstractEndpointResolver {

	private final AbstractEndpointResolver resolver;
	private final EndpointRewritingStrategy strategy;
	
	public RewritingEndpointResolver(AbstractEndpointResolver resolver, EndpointRewritingStrategy strategy) {
		this.resolver = resolver;
		this.strategy = strategy;
	}
	
	@Override
	protected Endpoint chooseEndpoint(List<Endpoint> endpoints) {
		Endpoint ep = resolver.chooseEndpoint(endpoints);
		return strategy.rewriteEndpoint(ep);
	}
	
	@Override
	protected AssetAdministrationShell resolveShellInstance(ObjectMapper mapper, Endpoint endpoint) {
		return resolver.resolveShellInstance(mapper, endpoint);
	}


}
