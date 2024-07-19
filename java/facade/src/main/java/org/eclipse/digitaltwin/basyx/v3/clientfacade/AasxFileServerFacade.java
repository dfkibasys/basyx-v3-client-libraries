package org.eclipse.digitaltwin.basyx.v3.clientfacade;

import java.io.File;
import java.util.List;

import org.eclipse.digitaltwin.aas4j.v3.model.PackageDescription;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.exception.AasxPackageNotFoundException;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.exception.ConflictingIdentifierException;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.util.BasyxIterable;

public interface AasxFileServerFacade {

	BasyxIterable<PackageDescription> getAllPackagesByAasId(String aasId);
	
	File getPackageById(String packageId) throws AasxPackageNotFoundException;
	
	void deletePackageById(String packageId) throws AasxPackageNotFoundException;
	
	PackageDescription postPackage(List<String> aasIds, File file, String fileName) throws ConflictingIdentifierException;
	
	void updatePackageById(String packageId, List<String> aasIds, File file, String fileName) throws AasxPackageNotFoundException;
	
}
