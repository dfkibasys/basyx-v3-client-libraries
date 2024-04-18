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
package org.eclipse.digitaltwin.basyx.v3.clientfacade;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.http.HttpStatus;
import org.eclipse.digitaltwin.aas4j.v3.model.AssetAdministrationShell;
import org.eclipse.digitaltwin.aas4j.v3.model.AssetAdministrationShellDescriptor;
import org.eclipse.digitaltwin.aas4j.v3.model.AssetKind;
import org.eclipse.digitaltwin.aas4j.v3.model.Reference;
import org.eclipse.digitaltwin.aas4j.v3.model.Submodel;
import org.eclipse.digitaltwin.aas4j.v3.model.SubmodelDescriptor;
import org.eclipse.digitaltwin.aas4j.v3.model.SubmodelElement;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.api.Aas4jObjectMapperFactory;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.api.BasyxRegistryApis;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.cache.BasyxClientCache;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.cache.PassThroughBasyxClientCache;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.config.BasyxRegistryServiceConfiguration;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.config.EnvironmentBasedBasyxServiceConfiguration;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.endpoints.EndpointResolver;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.endpoints.FirstEndpointResolver;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.references.SimpleSubmodelReferenceResolver;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.references.SubmodelReferenceResolver;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.util.BasyxCollectionIterable;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.util.BasyxIterable;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.util.BasyxResult;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.util.FetchingBasyxIterable;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.util.MappingBasyxIterable;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.util.ResultResolver;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.util.SubmodelElementElementResolver;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.util.SubmodelElementHierarchyResolver;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.util.SubmodelElementPathsIterable;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.util.SubmodelElementWalker;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.util.SubmodelElementsIterable;
import org.eclipse.digitaltwin.basyx.v3.clients.ApiException;
import org.eclipse.digitaltwin.basyx.v3.clients.api.AssetAdministrationShellRegistryApi;
import org.eclipse.digitaltwin.basyx.v3.clients.api.AssetAdministrationShellRepositoryApi;
import org.eclipse.digitaltwin.basyx.v3.clients.api.SubmodelRegistryApi;
import org.eclipse.digitaltwin.basyx.v3.clients.api.SubmodelRepositoryApi;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part2.GetAssetAdministrationShellDescriptorsResult;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part2.GetSubmodelDescriptorsResult;
import org.eclipse.digitaltwin.basyx.v3.clients.model.search.Page;
import org.eclipse.digitaltwin.basyx.v3.clients.model.search.ShellDescriptorQuery;
import org.eclipse.digitaltwin.basyx.v3.clients.model.search.ShellDescriptorQuery.QueryTypeEnum;
import org.eclipse.digitaltwin.basyx.v3.clients.model.search.ShellDescriptorSearchRequest;
import org.eclipse.digitaltwin.basyx.v3.clients.model.search.ShellDescriptorSearchResponse;
import org.eclipse.digitaltwin.basyx.v3.clients.model.search.SortDirection;
import org.eclipse.digitaltwin.basyx.v3.clients.model.search.Sorting;
import org.eclipse.digitaltwin.basyx.v3.clients.model.search.SortingPath;

import com.fasterxml.jackson.databind.ObjectMapper;

class DefaultBasyxServiceFacade implements BasyxServiceFacade {

	private final ObjectMapper mapper;
	private final BasyxRegistryApis registryApis;
	private EndpointResolver endpointResolver;
	private SubmodelReferenceResolver smReferenceResolver;
	private BasyxClientCache clientCache;
	private final Integer limit;

	DefaultBasyxServiceFacade(ObjectMapper mapper, BasyxRegistryApis registryApis, Integer limit) {
		this.mapper = mapper;
		this.endpointResolver = new FirstEndpointResolver();
		this.smReferenceResolver = new SimpleSubmodelReferenceResolver();
		this.clientCache = new PassThroughBasyxClientCache();
		this.registryApis = registryApis;
		this.limit = limit;
	}

	DefaultBasyxServiceFacade(ObjectMapper mapper, BasyxRegistryServiceConfiguration config) {
		this(mapper, new BasyxRegistryApis(mapper, config), config.getFetchLimit());
	}

	DefaultBasyxServiceFacade(ObjectMapper mapper) {
		this(mapper, new EnvironmentBasedBasyxServiceConfiguration());
	}

	public DefaultBasyxServiceFacade() {
		this(new Aas4jObjectMapperFactory().newObjectMapper());
	}

	@Override
	public DefaultBasyxServiceFacade withEndpointResolver(EndpointResolver endpointResolverStrategy) {
		this.endpointResolver = endpointResolverStrategy;
		return this;
	}

	@Override
	public DefaultBasyxServiceFacade withSubmodelResolver(SubmodelReferenceResolver smReferenceResolver) {
		this.smReferenceResolver = smReferenceResolver;
		return this;
	}

	DefaultBasyxServiceFacade withClientCache(BasyxClientCache cache) {
		this.clientCache = cache;
		return this;
	}

	@Override
	public BasyxIterable<AssetAdministrationShell> getAllShells() throws ApiException {
		return getAllShells(null, null);
	}

	@Override
	public BasyxIterable<AssetAdministrationShell> getAllShells(AssetKind assetKind, String assetType) throws ApiException {
		ResultResolver<String, AssetAdministrationShell> resolver = cursor -> fetchShells(cursor, assetKind, assetType);
		return new FetchingBasyxIterable<>(resolver);
	}

	@Override
	public BasyxIterable<Submodel> getAllSubmodels(AssetAdministrationShell shell) {
		if (shell == null) {
			return BasyxCollectionIterable.empty();
		}
		List<Reference> submodelRefs = shell.getSubmodels();
		if (submodelRefs == null) {
			return BasyxCollectionIterable.empty();
		}
		return new MappingBasyxIterable<>(submodelRefs.iterator(), this::getSubmodelByReference);
	}
	
	@Override
	public Optional<Submodel> getSubmodelByReference(Reference ref) {
		return smReferenceResolver.resolveSubmodel(ref, this::getSubmodelById);
	}	

	@Override
	public BasyxIterable<Submodel> getAllSubmodels() {
		ResultResolver<String, Submodel> resolver = cursor -> fetchSubmodels(cursor);
		return new FetchingBasyxIterable<>(resolver);
	}

	@Override
	public BasyxIterable<SubmodelElement> getAllSubmodelElements(Submodel sm) {
		return new SubmodelElementsIterable(sm);
	}

	@Override
	public BasyxIterable<String> getAllSubmodelElementPaths(Submodel sm) {
		return new SubmodelElementPathsIterable(sm);
	}

	@Override
	public Optional<SubmodelElement> getSubmodelElementByIdShortPath(Submodel sm, String idShortPath) {
		SubmodelElementElementResolver finder = new SubmodelElementElementResolver(idShortPath);
		SubmodelElementWalker walker = new SubmodelElementWalker(finder, new SubmodelElementHierarchyResolver());
		walker.walkSubmodel(sm);
		return finder.result();
	}

	@Override
	public <T extends SubmodelElement> Optional<T> getSubmodelElementByIdShortPath(Submodel sm, String idShortPath, Class<T> resultCls) {
		return getSubmodelElementByIdShortPath(sm, idShortPath).filter(resultCls::isInstance).map(resultCls::cast);
	}

	@Override
	public Optional<AssetAdministrationShell> getShellById(String id) {
		return clientCache.getShellById(id, this::fetchShellById);
	}

	@Override
	public Optional<Submodel> getSubmodelById(String id) {
		return clientCache.getSubmodelById(id, this::fetchSubmodelById);
	}

	@Override
	public BasyxIterable<AssetAdministrationShell> findShellsByIdShort(String idShort) {
		return findShellsByIdShort(idShort, null, null);
	}

	@Override
	public BasyxIterable<AssetAdministrationShell> findShellsByIdShortRegex(String idShortRegex) {
		return findShellsByIdShort(idShortRegex, null, QueryTypeEnum.REGEX);
	}

	@Override
	public BasyxIterable<AssetAdministrationShell> findShellsByIdShort(String idShort, SortDirection direction) {
		return findShellsByIdShort(idShort, new Sorting().direction(direction).addPathItem(SortingPath.IDSHORT), null);
	}

	@Override
	public BasyxIterable<AssetAdministrationShell> findShellsByIdShortRegex(String idShortRegex, SortDirection direction) {
		return findShellsByIdShort(idShortRegex, new Sorting().direction(direction).addPathItem(SortingPath.IDSHORT), QueryTypeEnum.REGEX);
	}

	private BasyxIterable<AssetAdministrationShell> findShellsByIdShort(String idShort, Sorting sorting, QueryTypeEnum queryType) {
		ResultResolver<Integer, AssetAdministrationShell> resultResolver = index -> searchShellsByIdShort(idShort, index, sorting, queryType);
		return new FetchingBasyxIterable<>(resultResolver);
	}

	private Optional<Submodel> fetchSubmodelById(String id) {
		SubmodelDescriptor descriptor = getSubmodelDescriptorById(id);
		return endpointResolver.resolveSubmodel(mapper, descriptor.getEndpoints(), this::fetchSubmodelById);
	}
	
	private Optional<Submodel> fetchSubmodelById(String baseUrl, String id) {
		SubmodelRepositoryApi repoApi = new SubmodelRepositoryApi(mapper, baseUrl);
		try {
			return Optional.of(repoApi.getSubmodelById(id, null, null));
		} catch (ApiException ex) {
			if (ex.getCode() == HttpStatus.SC_NOT_FOUND) {
				return Optional.empty();
			}
			throw ex;
		}
	}

	private SubmodelDescriptor getSubmodelDescriptorById(String id) {
		SubmodelRegistryApi regApi = registryApis.getSubmodelRegistryApi();
		return regApi.getSubmodelDescriptorById(id);
	}

	private BasyxResult<Integer, AssetAdministrationShell> searchShellsByIdShort(String idShort, Integer index, Sorting sorting, QueryTypeEnum queryType) {
		if (index == null) {
			index = 0;
		}
		AssetAdministrationShellRegistryApi regApi = registryApis.getShellRegistryApi();
		Page page = new Page().index(index).size(limit);
		ShellDescriptorQuery query = new ShellDescriptorQuery().path("idShort").value(idShort).queryType(queryType);
		ShellDescriptorSearchRequest request = new ShellDescriptorSearchRequest().page(page).sortBy(sorting).query(query);
		ShellDescriptorSearchResponse response = regApi.searchShellDescriptors(request);
		int newIndex = ++index;
		int pos = newIndex * limit;
		Integer cursor = pos < response.getTotal() ? newIndex : null;
		List<AssetAdministrationShellDescriptor> hits = response.getHits();
		List<AssetAdministrationShell> toReturn = new ArrayList<>(hits.size());
		for (AssetAdministrationShellDescriptor eachDescriptor : hits) {
			Optional<AssetAdministrationShell> shellOpt = clientCache.getShellByIdIfPresent(idShort);
			if (shellOpt.isEmpty()) {
				shellOpt = endpointResolver.resolveShell(mapper, eachDescriptor.getEndpoints(), this::fetchShellById); 
			}
			shellOpt.ifPresent(toReturn::add);
		}
		return new BasyxResult<>(cursor, toReturn);
	}

	private BasyxResult<String, SubmodelDescriptor> fetchSubmodelDescriptors(String cursor) {
		SubmodelRegistryApi regApi = registryApis.getSubmodelRegistryApi();
		GetSubmodelDescriptorsResult descriptorResult = regApi.getAllSubmodelDescriptors(this.limit, cursor);
		List<SubmodelDescriptor> descriptors = descriptorResult.getResult();
		return new BasyxResult<>(descriptorResult.getPagingMetadata().getCursor(), descriptors);
	}

	private BasyxResult<String, Submodel> fetchSubmodels(String cursor) {
		BasyxResult<String, SubmodelDescriptor> descriptorResult = fetchSubmodelDescriptors(cursor);
		List<SubmodelDescriptor> fetchedResult = descriptorResult.result();
		List<Submodel> toReturn = new ArrayList<>(fetchedResult.size());
		for (SubmodelDescriptor eachDescriptor : fetchedResult) {
			Optional<Submodel> sm = endpointResolver.resolveSubmodel(mapper, eachDescriptor.getEndpoints(), this::fetchSubmodelById);
			if (sm.isPresent()) {
				toReturn.add(sm.get());
			}
		}
		return new BasyxResult<>(descriptorResult.cursor(), toReturn);
	}

	private Optional<AssetAdministrationShell> fetchShellById(String id) {
		AssetAdministrationShellDescriptor descriptor = fetchShellDescriptorById(id);
		return endpointResolver.resolveShell(mapper, descriptor.getEndpoints(), this::fetchShellById);
	}

	private Optional<AssetAdministrationShell> fetchShellById(String baseUrl, String id) {
		AssetAdministrationShellRepositoryApi api = new AssetAdministrationShellRepositoryApi(mapper, baseUrl);
		try {
			return Optional.of(api.getAssetAdministrationShellById(id));
		} catch (ApiException ex) {
			if (ex.getCode() == HttpStatus.SC_NOT_FOUND) {
				return Optional.empty();
			}
			throw ex;
		}
	}

	private BasyxResult<String, AssetAdministrationShellDescriptor> fetchShellDescriptors(String cursor, AssetKind assetKind, String assetType) throws ApiException {
		AssetAdministrationShellRegistryApi registryApi = registryApis.getShellRegistryApi();
		GetAssetAdministrationShellDescriptorsResult result = registryApi.getAllAssetAdministrationShellDescriptors(limit, cursor, assetKind, assetType);
		return new BasyxResult<>(result.getPagingMetadata().getCursor(), result.getResult());
	}

	private AssetAdministrationShellDescriptor fetchShellDescriptorById(String id) {
		AssetAdministrationShellRegistryApi regApi = registryApis.getShellRegistryApi();
		return regApi.getAssetAdministrationShellDescriptorById(id);
	}

	private BasyxResult<String, AssetAdministrationShell> fetchShells(String cursor, AssetKind kind, String assetType) throws ApiException {
		BasyxResult<String, AssetAdministrationShellDescriptor> descriptorResult = fetchShellDescriptors(cursor, kind, assetType);
		List<AssetAdministrationShellDescriptor> fetchedResult = descriptorResult.result();
		List<AssetAdministrationShell> toReturn = new ArrayList<>(fetchedResult.size());
		for (AssetAdministrationShellDescriptor eachDescriptor : fetchedResult) {
			Optional<AssetAdministrationShell> shellDescriptorOpt = endpointResolver.resolveShell(mapper, eachDescriptor.getEndpoints(), this::fetchShellById); 
			shellDescriptorOpt.ifPresent(toReturn::add);
		}
		return new BasyxResult<>(descriptorResult.cursor(), toReturn);
	}
}
