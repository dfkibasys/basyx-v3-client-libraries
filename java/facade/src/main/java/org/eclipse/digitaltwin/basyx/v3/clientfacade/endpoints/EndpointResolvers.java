package org.eclipse.digitaltwin.basyx.v3.clientfacade.endpoints;

public class EndpointResolvers {

	private EndpointResolvers() {
		
	}
	
	public static EndpointResolver firstWithAddress(String address) {
		return new RewritingEndpointResolver(new FirstEndpointResolver(), new AddressRewritingEndpointResolver(address));
	}
}
