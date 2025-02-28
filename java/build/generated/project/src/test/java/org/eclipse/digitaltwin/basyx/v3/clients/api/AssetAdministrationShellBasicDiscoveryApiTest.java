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
package org.eclipse.digitaltwin.basyx.v3.clients.api;

import org.eclipse.digitaltwin.basyx.v3.clients.ApiException;
import org.eclipse.digitaltwin.basyx.v3.clients.model.GetAllAssetLinksResult;
import org.eclipse.digitaltwin.aas4j.v3.model.Result;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part2.ServiceDescription;
import org.eclipse.digitaltwin.aas4j.v3.model.SpecificAssetId;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.junit.jupiter.Container;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import java.nio.file.Path;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.eclipse.digitaltwin.basyx.v3.testenvironment.AbstractBasyxTest;
import org.eclipse.digitaltwin.basyx.v3.testenvironment.BasyxTestRunner;
import org.eclipse.digitaltwin.basyx.v3.testenvironment.BasyxTestRunner.BasyxFunctionalTestDefinition;
import org.eclipse.digitaltwin.basyx.v3.testenvironment.BasyxTestRunner.BasyxListTestDefinition;
import org.eclipse.digitaltwin.basyx.v3.testenvironment.BasyxTestRunner.BasyxVoidTestDefinition;
import org.eclipse.digitaltwin.basyx.v3.testenvironment.BasyxTestRunner.BasyxTestValues;
import org.eclipse.digitaltwin.aas4j.v3.dataformat.json.JsonMapperFactory;
import org.eclipse.digitaltwin.aas4j.v3.dataformat.json.SimpleAbstractTypeResolverFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleAbstractTypeResolver;

import org.eclipse.digitaltwin.aas4j.v3.model.AssetAdministrationShellDescriptor;
import org.eclipse.digitaltwin.aas4j.v3.model.SubmodelDescriptor;


/**
 * API tests for AssetAdministrationShellBasicDiscoveryApi
 */
public class AssetAdministrationShellBasicDiscoveryApiTest {


    public AssetAdministrationShellBasicDiscoveryApiTest() {
    }

    private static String getPropertyOrThrow(String propName) {
    	String prop = System.getProperty(propName);
	    if (prop == null) {
	    	throw new IllegalArgumentException("Property '" + propName + "' not set.");
	    }
	    return prop;
    }

    
    @RunWith(Parameterized.class)
    public static class DeleteAssetLinksByShellId extends AbstractBasyxTest {

        private AssetAdministrationShellBasicDiscoveryApi api;
        private final BasyxTestRunner runner;
        private final BasyxVoidTestDefinition<DeleteAssetLinksByShellIdParams> def;

        public DeleteAssetLinksByShellId(String testName, BasyxVoidTestDefinition<DeleteAssetLinksByShellIdParams> def, BasyxTestRunner runner) {
            this.runner = runner;
            this.def = def;
        }

        @Before
        public void init() {
            this.api = new AssetAdministrationShellBasicDiscoveryApi(MAPPER, ENVIRONMENT.getAasDiscoveryserviceUrl());            
        }

        @Parameters(name="{0}")
        public static List<Object[]> initialize() {
            Path testFolder = Path.of(getPropertyOrThrow("basyxtest.folder"), "aas-discoveryservice");
            ArrayList<Object[]> config = new ArrayList<>();
            BasyxTestRunner runner = new BasyxTestRunner(ENVIRONMENT, MAPPER, testFolder);
            List<BasyxVoidTestDefinition<DeleteAssetLinksByShellIdParams>> defs = runner.loadVoidTestDefinition("deleteAssetLinksByShellId", DeleteAssetLinksByShellIdParams.class);
            for (BasyxVoidTestDefinition<DeleteAssetLinksByShellIdParams> eachDef : defs) {            
        	    config.add(new Object[] {eachDef.getName(), eachDef, runner});
            }            
        	return config;
        }

        /**
        * Deletes all specific Asset identifiers linked to an Asset Administration Shell to edit discoverable content
        *
        * 
        *
        */
        @Test
        public void deleteAssetLinksByShellIdTest() throws ApiException {                
           runner.runAndAssertWithVoidResult(def, this::deleteAssetLinksByShellId);            
        }
        
        private void deleteAssetLinksByShellId(DeleteAssetLinksByShellIdParams params) throws ApiException {
            api.deleteAssetLinksByShellId(params.getAasIdentifier());
        }
    }

    @RunWith(Parameterized.class)
    public static class GetAllShellIdsByAssetLinks extends AbstractBasyxTest {

        private AssetAdministrationShellBasicDiscoveryApi api;
        private final BasyxTestRunner runner;
        private final BasyxFunctionalTestDefinition<GetAllShellIdsByAssetLinksParams, GetAllAssetLinksResult> def;

        public GetAllShellIdsByAssetLinks(String testName, BasyxFunctionalTestDefinition<GetAllShellIdsByAssetLinksParams, GetAllAssetLinksResult> def, BasyxTestRunner runner) {
            this.runner = runner;
            this.def = def;
        }

        @Before
        public void init() {
            this.api = new AssetAdministrationShellBasicDiscoveryApi(MAPPER, ENVIRONMENT.getAasDiscoveryserviceUrl());            
        }

        @Parameters(name="{0}")
        public static List<Object[]> initialize() {
            Path testFolder = Path.of(getPropertyOrThrow("basyxtest.folder"), "aas-discoveryservice");
            ArrayList<Object[]> config = new ArrayList<>();
            BasyxTestRunner runner = new BasyxTestRunner(ENVIRONMENT, MAPPER, testFolder);
            List<BasyxFunctionalTestDefinition<GetAllShellIdsByAssetLinksParams, GetAllAssetLinksResult>> defs = runner.loadFunctionalTestDefinition("getAllShellIdsByAssetLinks", GetAllShellIdsByAssetLinksParams.class, GetAllAssetLinksResult.class);
            for (BasyxFunctionalTestDefinition<GetAllShellIdsByAssetLinksParams, GetAllAssetLinksResult> eachDef : defs) {            
        	    config.add(new Object[] {eachDef.getName(), eachDef, runner});
            }            
        	return config;
        }

        /**
        * Returns a list of Asset Administration Shell ids linked to specific Asset identifiers
        *
        * 
        *
        */
        @Test
        public void getAllShellIdsByAssetLinksTest() throws ApiException {                
           runner.runAndAssertWithFunctionalResult(def, this::getAllShellIdsByAssetLinks);            
        }
        
        private GetAllAssetLinksResult getAllShellIdsByAssetLinks(GetAllShellIdsByAssetLinksParams params) throws ApiException {
            return api.getAllShellIdsByAssetLinks(params.getAssetIds(), params.getLimit(), params.getCursor());
        }
    }

    @RunWith(Parameterized.class)
    public static class GetAssetLinksByShellId extends AbstractBasyxTest {

        private AssetAdministrationShellBasicDiscoveryApi api;
        private final BasyxTestRunner runner;
        private final BasyxListTestDefinition<GetAssetLinksByShellIdParams, SpecificAssetId> def;

        public GetAssetLinksByShellId(String testName, BasyxListTestDefinition<GetAssetLinksByShellIdParams, SpecificAssetId> def, BasyxTestRunner runner) {
            this.runner = runner;
            this.def = def;
        }

        @Before
        public void init() {
            this.api = new AssetAdministrationShellBasicDiscoveryApi(MAPPER, ENVIRONMENT.getAasDiscoveryserviceUrl());            
        }

        @Parameters(name="{0}")
        public static List<Object[]> initialize() {
            Path testFolder = Path.of(getPropertyOrThrow("basyxtest.folder"), "aas-discoveryservice");
            ArrayList<Object[]> config = new ArrayList<>();
            BasyxTestRunner runner = new BasyxTestRunner(ENVIRONMENT, MAPPER, testFolder);
            List<BasyxListTestDefinition<GetAssetLinksByShellIdParams, SpecificAssetId>> defs = runner.loadListTestDefinition("getAssetLinksByShellId", GetAssetLinksByShellIdParams.class, SpecificAssetId.class);
            for (BasyxListTestDefinition<GetAssetLinksByShellIdParams, SpecificAssetId> eachDef : defs) {            
        	    config.add(new Object[] {eachDef.getName(), eachDef, runner});
            }            
        	return config;
        }

        /**
        * Returns a list of specific Asset identifiers based on an Asset Administration Shell id to edit discoverable content
        *
        * 
        *
        */
        @Test
        public void getAssetLinksByShellIdTest() throws ApiException {                
           runner.runAndAssertWithListResult(def, this::getAssetLinksByShellId);            
        }
        
        private List<SpecificAssetId> getAssetLinksByShellId(GetAssetLinksByShellIdParams params) throws ApiException {
            return api.getAssetLinksByShellId(params.getAasIdentifier());
        }
    }

    @RunWith(Parameterized.class)
    public static class GetDescription extends AbstractBasyxTest {

        private AssetAdministrationShellBasicDiscoveryApi api;
        private final BasyxTestRunner runner;
        private final BasyxFunctionalTestDefinition<GetDescriptionParams, ServiceDescription> def;

        public GetDescription(String testName, BasyxFunctionalTestDefinition<GetDescriptionParams, ServiceDescription> def, BasyxTestRunner runner) {
            this.runner = runner;
            this.def = def;
        }

        @Before
        public void init() {
            this.api = new AssetAdministrationShellBasicDiscoveryApi(MAPPER, ENVIRONMENT.getAasDiscoveryserviceUrl());            
        }

        @Parameters(name="{0}")
        public static List<Object[]> initialize() {
            Path testFolder = Path.of(getPropertyOrThrow("basyxtest.folder"), "aas-discoveryservice");
            ArrayList<Object[]> config = new ArrayList<>();
            BasyxTestRunner runner = new BasyxTestRunner(ENVIRONMENT, MAPPER, testFolder);
            List<BasyxFunctionalTestDefinition<GetDescriptionParams, ServiceDescription>> defs = runner.loadFunctionalTestDefinition("getDescription", GetDescriptionParams.class, ServiceDescription.class);
            for (BasyxFunctionalTestDefinition<GetDescriptionParams, ServiceDescription> eachDef : defs) {            
        	    config.add(new Object[] {eachDef.getName(), eachDef, runner});
            }            
        	return config;
        }

        /**
        * Returns the self-describing information of a network resource (ServiceDescription)
        *
        * 
        *
        */
        @Test
        public void getDescriptionTest() throws ApiException {                
           runner.runAndAssertWithFunctionalResult(def, this::getDescription);            
        }
        
        private ServiceDescription getDescription(GetDescriptionParams params) throws ApiException {
            return api.getDescription();
        }
    }

    @RunWith(Parameterized.class)
    public static class PostAssetLinksByShellId extends AbstractBasyxTest {

        private AssetAdministrationShellBasicDiscoveryApi api;
        private final BasyxTestRunner runner;
        private final BasyxListTestDefinition<PostAssetLinksByShellIdParams, SpecificAssetId> def;

        public PostAssetLinksByShellId(String testName, BasyxListTestDefinition<PostAssetLinksByShellIdParams, SpecificAssetId> def, BasyxTestRunner runner) {
            this.runner = runner;
            this.def = def;
        }

        @Before
        public void init() {
            this.api = new AssetAdministrationShellBasicDiscoveryApi(MAPPER, ENVIRONMENT.getAasDiscoveryserviceUrl());            
        }

        @Parameters(name="{0}")
        public static List<Object[]> initialize() {
            Path testFolder = Path.of(getPropertyOrThrow("basyxtest.folder"), "aas-discoveryservice");
            ArrayList<Object[]> config = new ArrayList<>();
            BasyxTestRunner runner = new BasyxTestRunner(ENVIRONMENT, MAPPER, testFolder);
            List<BasyxListTestDefinition<PostAssetLinksByShellIdParams, SpecificAssetId>> defs = runner.loadListTestDefinition("postAssetLinksByShellId", PostAssetLinksByShellIdParams.class, SpecificAssetId.class);
            for (BasyxListTestDefinition<PostAssetLinksByShellIdParams, SpecificAssetId> eachDef : defs) {            
        	    config.add(new Object[] {eachDef.getName(), eachDef, runner});
            }            
        	return config;
        }

        /**
        * Creates specific Asset identifiers linked to an Asset Administration Shell to edit discoverable content
        *
        * 
        *
        */
        @Test
        public void postAssetLinksByShellIdTest() throws ApiException {                
           runner.runAndAssertWithListResult(def, this::postAssetLinksByShellId);            
        }
        
        private List<SpecificAssetId> postAssetLinksByShellId(PostAssetLinksByShellIdParams params) throws ApiException {
            return api.postAssetLinksByShellId(params.getAasIdentifier(), params.getSpecificAssetId());
        }
    }
    private static class DeleteAssetLinksByShellIdParams implements BasyxTestValues {

        private String aasIdentifier;
        @SuppressWarnings("unused")
        public void setAasIdentifier(String aasIdentifier) {
            this.aasIdentifier = aasIdentifier;
        }

        public String getAasIdentifier() {
            return this.aasIdentifier;
        }
    }  
    private static class GetAllShellIdsByAssetLinksParams implements BasyxTestValues {

        private List<SpecificAssetId> assetIds;
        private Integer limit;
        private String cursor;
        @SuppressWarnings("unused")
        public void setAssetIds(List<SpecificAssetId> assetIds) {
            this.assetIds = assetIds;
        }
        @SuppressWarnings("unused")
        public void setLimit(Integer limit) {
            this.limit = limit;
        }
        @SuppressWarnings("unused")
        public void setCursor(String cursor) {
            this.cursor = cursor;
        }

        public List<SpecificAssetId> getAssetIds() {
            return this.assetIds;
        }

        public Integer getLimit() {
            return this.limit;
        }

        public String getCursor() {
            return this.cursor;
        }
    }  
    private static class GetAssetLinksByShellIdParams implements BasyxTestValues {

        private String aasIdentifier;
        @SuppressWarnings("unused")
        public void setAasIdentifier(String aasIdentifier) {
            this.aasIdentifier = aasIdentifier;
        }

        public String getAasIdentifier() {
            return this.aasIdentifier;
        }
    }  
    private static class GetDescriptionParams implements BasyxTestValues {

    }  
    private static class PostAssetLinksByShellIdParams implements BasyxTestValues {

        private String aasIdentifier;
        private List<SpecificAssetId> specificAssetId;
        @SuppressWarnings("unused")
        public void setAasIdentifier(String aasIdentifier) {
            this.aasIdentifier = aasIdentifier;
        }
        @SuppressWarnings("unused")
        public void setSpecificAssetId(List<SpecificAssetId> specificAssetId) {
            this.specificAssetId = specificAssetId;
        }

        public String getAasIdentifier() {
            return this.aasIdentifier;
        }

        public List<SpecificAssetId> getSpecificAssetId() {
            return this.specificAssetId;
        }
    }  
}    
