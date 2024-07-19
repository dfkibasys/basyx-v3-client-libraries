package org.eclipse.digitaltwin.basyx.v3.clientfacade.main;

import java.nio.file.Path;
import java.util.List;

import org.eclipse.digitaltwin.aas4j.v3.model.PackageDescription;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.AasxFileServerFacade;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.BasyxConnectionManager;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.DefaultBasyxConnectionManager;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.config.SimpleAasxFileServiceConfiguration;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.exception.ConflictingIdentifierException;

public class MainFileServer {

	
	public static void main(String[] args) throws ConflictingIdentifierException {
		BasyxConnectionManager manager = new DefaultBasyxConnectionManager();
		String url = "http://localhost:8080"; 
		AasxFileServerFacade facade = manager.newAasxFileServiceFacade(new SimpleAasxFileServiceConfiguration().withAasxFileServerUrl(url));
		
		System.out.println("aaa: " + facade.getAllPackagesByAasId("aaa").stream().count());
		
		List<String> aasIds = List.of("https://htw-berlin.de/ids/aas/demoaasv3", "https://example.com/ids/sm/2411_7160_0132_4523");
		Path path = Path.of("./demo/ExampleV3.aasx");
		
		PackageDescription descr = facade.postPackage(aasIds, path.toFile(), "random");
		System.out.println(descr);
		System.out.println(facade.getAllPackagesByAasId("test").stream().count());
	}
}
