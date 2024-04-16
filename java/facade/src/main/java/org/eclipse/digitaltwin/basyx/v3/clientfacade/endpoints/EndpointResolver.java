package org.eclipse.digitaltwin.basyx.v3.clientfacade.endpoints;

import java.util.List;

import org.eclipse.digitaltwin.aas4j.v3.model.AssetAdministrationShell;
import org.eclipse.digitaltwin.aas4j.v3.model.Endpoint;
import org.eclipse.digitaltwin.aas4j.v3.model.Submodel;

import com.fasterxml.jackson.databind.ObjectMapper;

public interface EndpointResolver {
	
	public AssetAdministrationShell resolveShell(ObjectMapper mapper, List<Endpoint> endpoints);
	
	public Submodel resolveSubmodel(ObjectMapper mapper, List<Endpoint> endpoints);
	
}
