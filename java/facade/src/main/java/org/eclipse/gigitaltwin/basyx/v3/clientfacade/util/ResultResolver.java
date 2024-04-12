package org.eclipse.gigitaltwin.basyx.v3.clientfacade.util;

import org.eclipse.digitaltwin.basyx.v3.clients.ApiException;

@FunctionalInterface
public interface ResultResolver<C, T> {

	BasyxResult<C, T> fetchResult(C cursor) throws ApiException;

}