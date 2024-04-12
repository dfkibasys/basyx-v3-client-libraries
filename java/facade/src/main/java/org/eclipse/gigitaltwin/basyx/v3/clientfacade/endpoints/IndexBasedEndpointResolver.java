package org.eclipse.gigitaltwin.basyx.v3.clientfacade.endpoints;

import java.util.List;

import org.eclipse.digitaltwin.aas4j.v3.model.Endpoint;

public class IndexBasedEndpointResolver extends AbstractEndpointResolver {

	private final int index;
	
	public IndexBasedEndpointResolver(int index) {
		this.index = index;
	}

	@Override
	protected Endpoint chooseEndpoint(List<Endpoint> endpoints) {
		if (endpoints.size() > index) {
			return endpoints.get(index);
		}
		return null;
	}
	
	

}
