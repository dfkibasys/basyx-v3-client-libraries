package org.eclipse.digitaltwin.basyx.v3.clientfacade.main;

import java.nio.file.Path;
import java.util.List;

import org.eclipse.digitaltwin.aas4j.v3.model.PackageDescription;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.*;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.config.BasyxApiConfiguration;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.config.SimpleAasxFileServiceConfiguration;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.config.SimpleBasyxApiConfiguration;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.exception.ConflictingIdentifierException;

public class MainFileServer {

	
	public static void main(String[] args) throws ConflictingIdentifierException {
		String url = "http://localhost:8080";
		BasyxApiConfiguration conf = new SimpleBasyxApiConfiguration().withAasxFileServerUrl(url).withAasxFileServerUrl(url);
		BasyxApiManager apiManager = new DefaultBasyxApiManager(conf);
		BasyxFacadeManager manager = new DefaultBasyxFacadeManager(apiManager);

		AasxFileServerFacade facade = manager.newAasxFileServerFacade();
		
		System.out.println("aaa: " + facade.getAllPackagesByAasId("aaa").stream().count());
		
		List<String> aasIds = List.of("https://htw-berlin.de/ids/aas/demoaasv3", "https://example.com/ids/sm/2411_7160_0132_4523");
		Path path = Path.of("./demo/ExampleV3.aasx");
		
		PackageDescription descr = facade.postPackage(aasIds, path.toFile(), "random");
		System.out.println(descr);
		System.out.println(facade.getAllPackagesByAasId("test").stream().count());
	}
}
