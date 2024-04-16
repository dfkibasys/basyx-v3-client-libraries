package org.eclipse.digitaltwin.basyx.v3.clientfacade.endpoints;

import org.eclipse.digitaltwin.aas4j.v3.model.Endpoint;

public interface EndpointRewritingStrategy {

	Endpoint rewriteEndpoint(Endpoint ep);

}
