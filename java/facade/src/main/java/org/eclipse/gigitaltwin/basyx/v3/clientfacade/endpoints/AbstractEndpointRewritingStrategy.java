package org.eclipse.gigitaltwin.basyx.v3.clientfacade.endpoints;

import org.eclipse.digitaltwin.aas4j.v3.model.Endpoint;
import org.eclipse.digitaltwin.aas4j.v3.model.ProtocolInformation;

public abstract class AbstractEndpointRewritingStrategy implements EndpointRewritingStrategy {

	@Override
	public Endpoint rewriteEndpoint(Endpoint ep) {
		ProtocolInformation info = ep.getProtocolInformation();
		if (info != null) {
			String oldHref = info.getHref();
			String newHref = convert(oldHref);
			info.setHref(newHref);
		}
		return ep;
	}

	protected abstract String convert(String oldHref);

}
