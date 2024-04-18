package org.eclipse.digitaltwin.basyx.v3.clientfacade;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.digitaltwin.aas4j.v3.model.AssetAdministrationShell;
import org.eclipse.digitaltwin.aas4j.v3.model.Reference;
import org.eclipse.digitaltwin.aas4j.v3.model.Submodel;
import org.eclipse.digitaltwin.aas4j.v3.model.impl.DefaultAssetAdministrationShell;
import org.eclipse.digitaltwin.aas4j.v3.model.impl.DefaultSubmodel;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.cache.CaffeineBasyxClientCache;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.config.BasyxRegistryServiceConfiguration;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.config.BasyxUpdateConfiguration;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.config.SimpleBasyxServiceConfiguration;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.config.SimpleBasyxUpdateConfiguration;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.exception.ConflictingIdentifierException;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.exception.IdentifiableNotFoundException;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

@Ignore
public class BasyxFacadeTest {

	private final String AAS_REGISTRY_URL = "http://localhost:8083";
	private final String SM_REGISTRY_URL = "http://localhost:8082";
	private final String ENVIRONMENT_URL = "http://localhost:8081";

	private final BasyxRegistryServiceConfiguration serviceConf = new SimpleBasyxServiceConfiguration().withAasRegistryUrl(AAS_REGISTRY_URL).withSubmodelRegistryUrl(SM_REGISTRY_URL);
	private final BasyxUpdateConfiguration updateConf = SimpleBasyxUpdateConfiguration.forEnvironmentUrl(ENVIRONMENT_URL);

	private final BasyxConnectionManager manager = new DefaultBasyxConnectionManager().withClientCache(new CaffeineBasyxClientCache());
	private final BasyxUpdateFacade updateFacade = manager.newUpdateFacade(updateConf);
	private final BasyxServiceFacade facade = manager.newServiceFacade(serviceConf);

	@Before
	public void setUp() {
		updateFacade.deleteAllShells();
		updateFacade.deleteAllSubmodels();
	}

	@After
	public void tearDown() {
		updateFacade.deleteAllShells();
		updateFacade.deleteAllSubmodels();
	}

	@Test
	public void testCreation() throws ConflictingIdentifierException {
		Submodel sm0 = submodel(0, 0);
		Submodel sm1 = submodel(0, 1);
		Reference ref0 = updateFacade.postSubmodel(sm0);
		Reference ref1 = updateFacade.postSubmodel(sm1);

		AssetAdministrationShell shell = shell(0, List.of(ref0, ref1));
		Reference shellRef = updateFacade.postShell(shell);
		System.out.println(shellRef);
		
		assertThrows(ConflictingIdentifierException.class, ()-> updateFacade.postShell(shell));		
	}

	@Test
	public void testDeleteAll() throws ConflictingIdentifierException {
		initialize();

		assertEquals(10, facade.getAllShells().stream().count());
		assertEquals(10 * 5, facade.getAllSubmodels().stream().count());

		updateFacade.deleteAllShells();
		updateFacade.deleteAllSubmodels();

		assertEquals(0, facade.getAllShells().stream().count());
		assertEquals(0, facade.getAllSubmodels().stream().count());
	}

	@Test
	public void testFacade() throws ConflictingIdentifierException, IdentifiableNotFoundException {
		updateFacade.deleteAllShells();
		updateFacade.deleteAllSubmodels();
		initialize();
		assertEquals(10, facade.getAllShells().stream().count());
		assertEquals(10 * 5, facade.getAllSubmodels().stream().count());

		long total = 0;
		for (AssetAdministrationShell eachShell : facade.getAllShells()) {
			for (Submodel sm : facade.getAllSubmodels(eachShell)) {
				total++;
				updateFacade.deleteSubmodel(sm);
			}
			updateFacade.deleteShell(eachShell);
		}
		assertEquals(10 * 5, total);
		
		assertEquals(0, facade.getAllShells().stream().count());
		assertEquals(0, facade.getAllSubmodels().stream().count());

	}

	private void initialize() throws ConflictingIdentifierException {
		for (int i = 0; i < 10; i++) {
			List<Reference> refs = new ArrayList<>();
			for (int j = 0; j < 5; j++) {
				Submodel sm = submodel(i, j);
				Reference ref = updateFacade.postSubmodel(sm);
				refs.add(ref);
			}
			updateFacade.postShell(shell(i, refs));
		}
	}

	private AssetAdministrationShell shell(int id, List<Reference> refs) {
		AssetAdministrationShell shell = new DefaultAssetAdministrationShell();
		shell.setId("http://sms.shell.org/" + id);
		shell.setIdShort("" + id);
		shell.setSubmodels(refs);
		return shell;
	}

	private Submodel submodel(int first, int second) {
		Submodel sm = new DefaultSubmodel();
		String idShort = first + "/" + second;
		sm.setId("http://sms.shell.org/" + idShort);
		sm.setIdShort(first + idShort);
		return sm;
	}

}
