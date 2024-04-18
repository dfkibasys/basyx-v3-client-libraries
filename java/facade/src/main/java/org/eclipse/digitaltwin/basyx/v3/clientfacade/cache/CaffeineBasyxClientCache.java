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
import java.util.Optional;
import java.util.function.Function;

import org.eclipse.digitaltwin.aas4j.v3.model.AssetAdministrationShell;
import org.eclipse.digitaltwin.aas4j.v3.model.Submodel;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;

public class CaffeineBasyxClientCache implements BasyxClientCache {

	private final Cache<String, Optional<AssetAdministrationShell>> shellCache;
	private final Cache<String, Optional<Submodel>> submodelCache;

	public CaffeineBasyxClientCache() {
		this(Caffeine.newBuilder().maximumSize(200).initialCapacity(20).weakValues().expireAfterWrite(Duration.ofMinutes(5)));
	}

	private CaffeineBasyxClientCache(Caffeine<Object, Object> cacheBuilder) {
		this(cacheBuilder, cacheBuilder);
	}

	public CaffeineBasyxClientCache(Caffeine<Object, Object> shellCacheBuilder, Caffeine<Object, Object> submodelCacheBuilder) {
		shellCache = shellCacheBuilder.build();
		submodelCache = submodelCacheBuilder.build();
	}

	@Override
	public Optional<AssetAdministrationShell> getShellById(String id, Function<String, Optional<AssetAdministrationShell>> resolver) {
		return shellCache.get(id, resolver);
	}

	@Override
	public Optional<Submodel> getSubmodelById(String id, Function<String, Optional<Submodel>> resolver) {
		return submodelCache.get(id, resolver);
	}

	@Override
	public void invalidateShell(String shellId) {
		shellCache.invalidate(shellId);
	}
	
	@Override
	public Optional<AssetAdministrationShell> getShellByIdIfPresent(String id) {
		Optional<AssetAdministrationShell> shellOpt = shellCache.asMap().get(id);
		if (shellOpt == null) {
			return Optional.empty();
		}
		return shellOpt;
	}

	@Override
	public void invalidateSubmodel(String smId) {
		submodelCache.invalidate(smId);
	}
	
	@Override
	public void offerLocally(AssetAdministrationShell shell) {
		shellCache.put(shell.getId(), Optional.ofNullable(shell));
	}
	
	@Override
	public void offerLocally(Submodel submodel) {
		submodelCache.put(submodel.getId(), Optional.ofNullable(submodel));
	}
}