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
package org.eclipse.digitaltwin.basyx.v3.clientfacade.main;

import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.eclipse.digitaltwin.aas4j.v3.model.AssetAdministrationShell;
import org.eclipse.digitaltwin.aas4j.v3.model.DataTypeDefXsd;
import org.eclipse.digitaltwin.aas4j.v3.model.Entity;
import org.eclipse.digitaltwin.aas4j.v3.model.Property;
import org.eclipse.digitaltwin.aas4j.v3.model.Reference;
import org.eclipse.digitaltwin.aas4j.v3.model.Submodel;
import org.eclipse.digitaltwin.aas4j.v3.model.impl.DefaultAssetAdministrationShell;
import org.eclipse.digitaltwin.aas4j.v3.model.impl.DefaultAssetAdministrationShell.Builder;
import org.eclipse.digitaltwin.aas4j.v3.model.impl.DefaultEntity;
import org.eclipse.digitaltwin.aas4j.v3.model.impl.DefaultProperty;
import org.eclipse.digitaltwin.aas4j.v3.model.impl.DefaultSubmodel;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.*;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.config.BasyxApiConfiguration;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.config.EnvironmentBasedBasyxApiConfiguration;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.config.SimpleBasyxApiConfiguration;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.exception.ConflictingIdentifierException;
import org.eclipse.digitaltwin.basyx.v3.clientfacade.util.BasyxIterable;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.eclipse.digitaltwin.basyx.v3.clients.JSON;

public class MainByEnvSettings {

	public static void main(String[] args) throws JsonProcessingException, ConflictingIdentifierException {

		BasyxApiConfiguration conf = new EnvironmentBasedBasyxApiConfiguration();
		BasyxApiManager apiManager = new DefaultBasyxApiManager(conf);
		BasyxFacadeManager manager = new DefaultBasyxFacadeManager(apiManager);

		BasyxWriteFacade writeFacade = manager.newWriteFacade();
		
		writeFacade.deleteAllShells();
		writeFacade.deleteAllSubmodels();
		
		postShells(writeFacade);
		
		BasyxReadFacade facade = manager.newReadFacade();

		AssetAdministrationShell shell = facade.getShellById("http://aas.test.org/robot/5").get();
		System.out.println(shell.getIdShort());
		for (Submodel eachSm : facade.getAllSubmodels(shell)) {
			System.out.println(toJsonPretty(eachSm));
			facade.getAllSubmodelElementPaths(eachSm).stream().forEach(System.out::println);
			System.out.println(facade.getSubmodelElementByIdShortPath(eachSm, "robot.height", Property.class).get().getValue());

		}
		facade.getAllSubmodels(shell).stream().map(Submodel::getKind).forEach(System.err::println);
		System.out.println(facade.getAllShells().stream().count());
		facade.getAllShells().stream().map(AssetAdministrationShell::getIdShort).forEach(System.out::println);
		facade.findShellsByIdShortRegex("^robot-.*[3|4|5]$").stream().map(AssetAdministrationShell::getId).forEach(System.out::println);
		
		for (Submodel eachSm : facade.getAllSubmodels()) {
			System.out.println(eachSm.getId());
		}
		
		facade.getSubmodelById("http://sm.test.org/technical/9/6").map(facade::getAllSubmodelElementReferences).stream().flatMap(BasyxIterable::stream).map(MainByEnvSettings::toJsonPretty).forEach(System.out::println);
		
		writeFacade.deleteAllShells();
		writeFacade.deleteAllSubmodels();
		
	}

	private static void postShells(BasyxWriteFacade updateFacade) throws ConflictingIdentifierException {
		for (int i = 0; i < 10; i++) {
			Builder builder = new DefaultAssetAdministrationShell.Builder().id("http://aas.test.org/robot/" + i).idShort("robot-"+i);
			for (int j = 0; j < 10; j++) {
				Property height = new DefaultProperty.Builder().idShort("height").valueType(DataTypeDefXsd.INT).value("200").build();
				Property width = new DefaultProperty.Builder().idShort("width").valueType(DataTypeDefXsd.INT).value("33").build();
				Entity entity = new DefaultEntity.Builder().idShort("robot").statements(List.of(height, width)).build();
				Submodel sm = new DefaultSubmodel.Builder().id("http://sm.test.org/technical/"+i +"/" +j).idShort("technical").submodelElements(entity).build();
				Reference ref = updateFacade.postSubmodel(sm);
				builder.submodels(ref);
			}
			updateFacade.postShell(builder.build());
		}		
	}

	private static String toJsonPretty(Object object) {
		try {
			return JSON.getDefault().getMapper().writerWithDefaultPrettyPrinter().writeValueAsString(object);
		} catch (JsonProcessingException e) {
			return null;
		}
	}

}
