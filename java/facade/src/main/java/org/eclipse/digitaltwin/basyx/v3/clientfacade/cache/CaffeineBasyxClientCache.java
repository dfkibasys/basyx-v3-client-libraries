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
