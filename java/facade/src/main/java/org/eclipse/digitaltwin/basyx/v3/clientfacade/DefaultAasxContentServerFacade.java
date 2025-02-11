package org.eclipse.digitaltwin.basyx.v3.clientfacade;

import org.apache.http.HttpStatus;
import org.eclipse.digitaltwin.aas4j.v3.model.PackageDescription;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.exception.AasxPackageNotFoundException;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.exception.ConflictingIdentifierException;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.util.BasyxIterable;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.util.BasyxIterables;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.util.BasyxResult;
import org.eclipse.digitaltwin.basyx.v3.clients.ApiException;
import org.eclipse.digitaltwin.basyx.v3.clients.api.AasxFileServerApi;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part2.GetPackageDescriptionsResult;

import java.io.File;
import java.util.List;

class DefaultAasxContentServerFacade implements AasxFileServerFacade {

	private final BasyxApiManager apiManager;
	private final AasxFileServerApi api;

	DefaultAasxContentServerFacade(BasyxApiManager apiManager) {
		this.apiManager = apiManager;
		this.api = apiManager.getAasxFileServerApi();
	}
	
	@Override
	public BasyxIterable<PackageDescription> getAllPackagesByAasId(String aasId) {
		PackageIdsByAasIdFetcher fetcher = new PackageIdsByAasIdFetcher(api, aasId, apiManager.getConfig().getFetchLimit());
		return BasyxIterables.fetchingIterable(fetcher::fetchPackageDescriptions);
	}
	
	@Override
	public File getPackageById(String packageId) throws AasxPackageNotFoundException {
		try {
			return api.getAASXByPackageId(packageId);
		} catch (ApiException ex) {
			if (ex.getCode() == HttpStatus.SC_NOT_FOUND) {
				throw new AasxPackageNotFoundException(packageId);
			}
			throw ex; // rethrow
		}
	}
	
	@Override
	public void deletePackageById(String packageId) throws AasxPackageNotFoundException {
		try {
			api.deleteAASXByPackageId(packageId);
		} catch (ApiException ex) {
			if (ex.getCode() == HttpStatus.SC_NOT_FOUND) {
				throw new AasxPackageNotFoundException(packageId);
			}
			throw ex; // rethrow
		}
	}

	@Override
	public PackageDescription postPackage(List<String> aasIds, File file, String fileName) throws ConflictingIdentifierException {
		try {
			return api.postAASXPackage(aasIds, file, fileName);
		} catch (ApiException ex) {
			if (ex.getCode() == HttpStatus.SC_CONFLICT) {
				throw new ConflictingIdentifierException("Conflicting identifiers.. Might be thrown if a Submodel or SubmodelElement with the same ShortId is contained in a POST request.");
			}
			throw ex; // rethrow
		}
	}
	
	@Override
	public void updatePackageById(String packageId, List<String> aasIds, File file, String fileName) throws AasxPackageNotFoundException {
		try {
			api.postAASXPackage(aasIds, file, fileName);
		} catch (ApiException ex) {
			if (ex.getCode() == HttpStatus.SC_NOT_FOUND) {
				throw new AasxPackageNotFoundException(packageId);
			}
			throw ex; // rethrow
		}
	}
	
	private static class PackageIdsByAasIdFetcher {
		
		private final AasxFileServerApi api;
		private final String aasId;
		private final int fetchLimit;
		
		private PackageIdsByAasIdFetcher(AasxFileServerApi api, String aasId, int fetchLimit) {
			this.api = api;
			this.aasId = aasId;
			this.fetchLimit = fetchLimit;
		}
		
		private BasyxResult<String, PackageDescription> fetchPackageDescriptions(String cursor) throws ApiException {
			GetPackageDescriptionsResult result =  api.getAllAASXPackageIds(aasId, fetchLimit, cursor);
			return new BasyxResult<String, PackageDescription>(result.getPagingMetadata().getCursor(), result.getResult());
		}
		
	}
	
}