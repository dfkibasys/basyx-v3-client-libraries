package org.eclipse.digitaltwin.basyx.v3.clientfacade.endpoints;

import java.util.Optional;

import org.eclipse.digitaltwin.aas4j.v3.model.Identifiable;

@FunctionalInterface
public interface IdentifiableResolver<T extends Identifiable> {
	
	Optional<T> resolve(String serverUrl, String id);
}