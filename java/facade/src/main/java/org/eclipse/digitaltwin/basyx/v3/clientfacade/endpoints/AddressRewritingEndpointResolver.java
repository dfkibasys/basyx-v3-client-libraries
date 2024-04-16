package org.eclipse.digitaltwin.basyx.v3.clientfacade.endpoints;

public class AddressRewritingEndpointResolver extends AbstractEndpointRewritingStrategy {

	private final String address;

	public AddressRewritingEndpointResolver(String address) {
		this.address = address;
	}

	@Override
	protected String convert(String oldHref) {				
		if (oldHref == null) {
			return null;
		}
		int start = oldHref.indexOf("://");
		if (start == -1) {
			return oldHref;
		}
		start +=3;
		int end = oldHref.indexOf("/", start);
		return oldHref.substring(0, start) + address + oldHref.substring(end); 				
	}

}
