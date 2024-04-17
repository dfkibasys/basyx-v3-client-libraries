/*******************************************************************************
 * Copyright (C) 2024 DFKI GmbH (https://www.dfki.de/en/web)
 * 
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 * 
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 * 
 * SPDX-License-Identifier: MIT
 ******************************************************************************/
package org.eclipse.digitaltwin.basyx.v3.clientfacade.cache;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;

import org.eclipse.digitaltwin.aas4j.v3.model.AssetAdministrationShell;
import org.eclipse.digitaltwin.aas4j.v3.model.Reference;
import org.eclipse.digitaltwin.aas4j.v3.model.Submodel;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;

public class CaffeineBasyxClientCache implements BasyxClientCache {

	private final Cache<String, AssetAdministrationShell> shellCache;
	private final Cache<String, Submodel> submodelCache;
	private final Cache<Reference, Submodel> shellToSubmodelCache;

	public CaffeineBasyxClientCache() {
		this(Caffeine.newBuilder().maximumSize(200).expireAfterWrite(Duration.ofMinutes(5)));
	}

	private CaffeineBasyxClientCache(Caffeine<Object, Object> cacheBuilder) {
		this(cacheBuilder, cacheBuilder, cacheBuilder);
	}

	public CaffeineBasyxClientCache(Caffeine<Object, Object> shellCacheBuilder, Caffeine<Object, Object> submodelCacheBuilder, Caffeine<Object, Object> shellToSubmodelCacheBuilder) {
		shellCache = shellCacheBuilder.build();
		submodelCache = submodelCacheBuilder.build();
		shellToSubmodelCache = shellToSubmodelCacheBuilder.build();
	}

	@Override
	public AssetAdministrationShell getShellById(String id, Function<String, AssetAdministrationShell> resolver) {
		return shellCache.get(id, resolver);
	}

	@Override
	public Submodel getSubmodelById(String id, Function<String, Submodel> resolver) {
		return submodelCache.get(id, resolver);
	}

	@Override
	public Submodel getSubmodelByReference(Reference ref, Function<Reference, Submodel> resolver) {
		return shellToSubmodelCache.get(ref, resolver);
	}

	@Override
	public void invalidateShell(AssetAdministrationShell shell) {
		shellCache.invalidate(shell.getId());
		List<Reference> refs = shell.getSubmodels();
		if (refs == null) {
			return;
		}
		for (Reference eachRef : refs) {
			Submodel sm = shellToSubmodelCache.getIfPresent(eachRef);
			invalidateSubmodel(sm);
			shellToSubmodelCache.invalidate(eachRef);
		}
	}

	@Override
	public void invalidateSubmodel(Submodel sm) {
		submodelCache.invalidate(sm.getId());
	}

}
