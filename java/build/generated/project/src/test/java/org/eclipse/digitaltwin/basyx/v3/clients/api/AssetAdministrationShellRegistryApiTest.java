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
import org.eclipse.digitaltwin.aas4j.v3.model.AssetAdministrationShellDescriptor;
import org.eclipse.digitaltwin.aas4j.v3.model.AssetKind;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part2.GetAssetAdministrationShellDescriptorsResult;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part2.GetSubmodelDescriptorsResult;
import org.eclipse.digitaltwin.aas4j.v3.model.Result;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part2.ServiceDescription;
import org.eclipse.digitaltwin.basyx.v3.clients.model.search.ShellDescriptorSearchRequest;
import org.eclipse.digitaltwin.basyx.v3.clients.model.search.ShellDescriptorSearchResponse;
import org.eclipse.digitaltwin.aas4j.v3.model.SubmodelDescriptor;
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
 * API tests for AssetAdministrationShellRegistryApi
 */
public class AssetAdministrationShellRegistryApiTest {


    public AssetAdministrationShellRegistryApiTest() {
    }

    private static String getPropertyOrThrow(String propName) {
    	String prop = System.getProperty(propName);
	    if (prop == null) {
	    	throw new IllegalArgumentException("Property '" + propName + "' not set.");
	    }
	    return prop;
    }

    
    @RunWith(Parameterized.class)
    public static class DeleteAssetAdministrationShellDescriptor extends AbstractBasyxTest {

        private AssetAdministrationShellRegistryApi api;
        private final BasyxTestRunner runner;
        private final BasyxVoidTestDefinition<DeleteAssetAdministrationShellDescriptorParams> def;

        public DeleteAssetAdministrationShellDescriptor(String testName, BasyxVoidTestDefinition<DeleteAssetAdministrationShellDescriptorParams> def, BasyxTestRunner runner) {
            this.runner = runner;
            this.def = def;
        }

        @Before
        public void init() {
            this.api = new AssetAdministrationShellRegistryApi(MAPPER, ENVIRONMENT.getAasRegistryUrl());            
        }

        @Parameters(name="{0}")
        public static List<Object[]> initialize() {
            Path testFolder = Path.of(getPropertyOrThrow("basyxtest.folder"), "aas-registry");
            ArrayList<Object[]> config = new ArrayList<>();
            BasyxTestRunner runner = new BasyxTestRunner(ENVIRONMENT, MAPPER, testFolder);
            List<BasyxVoidTestDefinition<DeleteAssetAdministrationShellDescriptorParams>> defs = runner.loadVoidTestDefinition("deleteAssetAdministrationShellDescriptor", DeleteAssetAdministrationShellDescriptorParams.class);
            for (BasyxVoidTestDefinition<DeleteAssetAdministrationShellDescriptorParams> eachDef : defs) {            
        	    config.add(new Object[] {eachDef.getName(), eachDef, runner});
            }            
        	return config;
        }

        /**
        * Deletes an Asset Administration Shell Descriptor, i.e. de-registers an AAS
        *
        * 
        *
        */
        @Test
        public void deleteAssetAdministrationShellDescriptorTest() throws ApiException {                
           runner.runAndAssertWithVoidResult(def, this::deleteAssetAdministrationShellDescriptor);            
        }
        
        private void deleteAssetAdministrationShellDescriptor(DeleteAssetAdministrationShellDescriptorParams params) throws ApiException {
            api.deleteAssetAdministrationShellDescriptor(params.getAasIdentifier());
        }
    }

    @RunWith(Parameterized.class)
    public static class DeleteSubmodelDescriptor extends AbstractBasyxTest {

        private AssetAdministrationShellRegistryApi api;
        private final BasyxTestRunner runner;
        private final BasyxVoidTestDefinition<DeleteSubmodelDescriptorParams> def;

        public DeleteSubmodelDescriptor(String testName, BasyxVoidTestDefinition<DeleteSubmodelDescriptorParams> def, BasyxTestRunner runner) {
            this.runner = runner;
            this.def = def;
        }

        @Before
        public void init() {
            this.api = new AssetAdministrationShellRegistryApi(MAPPER, ENVIRONMENT.getAasRegistryUrl());            
        }

        @Parameters(name="{0}")
        public static List<Object[]> initialize() {
            Path testFolder = Path.of(getPropertyOrThrow("basyxtest.folder"), "aas-registry");
            ArrayList<Object[]> config = new ArrayList<>();
            BasyxTestRunner runner = new BasyxTestRunner(ENVIRONMENT, MAPPER, testFolder);
            List<BasyxVoidTestDefinition<DeleteSubmodelDescriptorParams>> defs = runner.loadVoidTestDefinition("deleteSubmodelDescriptor", DeleteSubmodelDescriptorParams.class);
            for (BasyxVoidTestDefinition<DeleteSubmodelDescriptorParams> eachDef : defs) {            
        	    config.add(new Object[] {eachDef.getName(), eachDef, runner});
            }            
        	return config;
        }

        /**
        * Deletes a Submodel Descriptor, i.e. de-registers a submodel
        *
        * 
        *
        */
        @Test
        public void deleteSubmodelDescriptorTest() throws ApiException {                
           runner.runAndAssertWithVoidResult(def, this::deleteSubmodelDescriptor);            
        }
        
        private void deleteSubmodelDescriptor(DeleteSubmodelDescriptorParams params) throws ApiException {
            api.deleteSubmodelDescriptor(params.getAasIdentifier(), params.getSubmodelIdentifier());
        }
    }

    @RunWith(Parameterized.class)
    public static class GetAllAssetAdministrationShellDescriptors extends AbstractBasyxTest {

        private AssetAdministrationShellRegistryApi api;
        private final BasyxTestRunner runner;
        private final BasyxFunctionalTestDefinition<GetAllAssetAdministrationShellDescriptorsParams, GetAssetAdministrationShellDescriptorsResult> def;

        public GetAllAssetAdministrationShellDescriptors(String testName, BasyxFunctionalTestDefinition<GetAllAssetAdministrationShellDescriptorsParams, GetAssetAdministrationShellDescriptorsResult> def, BasyxTestRunner runner) {
            this.runner = runner;
            this.def = def;
        }

        @Before
        public void init() {
            this.api = new AssetAdministrationShellRegistryApi(MAPPER, ENVIRONMENT.getAasRegistryUrl());            
        }

        @Parameters(name="{0}")
        public static List<Object[]> initialize() {
            Path testFolder = Path.of(getPropertyOrThrow("basyxtest.folder"), "aas-registry");
            ArrayList<Object[]> config = new ArrayList<>();
            BasyxTestRunner runner = new BasyxTestRunner(ENVIRONMENT, MAPPER, testFolder);
            List<BasyxFunctionalTestDefinition<GetAllAssetAdministrationShellDescriptorsParams, GetAssetAdministrationShellDescriptorsResult>> defs = runner.loadFunctionalTestDefinition("getAllAssetAdministrationShellDescriptors", GetAllAssetAdministrationShellDescriptorsParams.class, GetAssetAdministrationShellDescriptorsResult.class);
            for (BasyxFunctionalTestDefinition<GetAllAssetAdministrationShellDescriptorsParams, GetAssetAdministrationShellDescriptorsResult> eachDef : defs) {            
        	    config.add(new Object[] {eachDef.getName(), eachDef, runner});
            }            
        	return config;
        }

        /**
        * Returns all Asset Administration Shell Descriptors
        *
        * 
        *
        */
        @Test
        public void getAllAssetAdministrationShellDescriptorsTest() throws ApiException {                
           runner.runAndAssertWithFunctionalResult(def, this::getAllAssetAdministrationShellDescriptors);            
        }
        
        private GetAssetAdministrationShellDescriptorsResult getAllAssetAdministrationShellDescriptors(GetAllAssetAdministrationShellDescriptorsParams params) throws ApiException {
            return api.getAllAssetAdministrationShellDescriptors(params.getLimit(), params.getCursor(), params.getAssetKind(), params.getAssetType());
        }
    }

    @RunWith(Parameterized.class)
    public static class GetAllSubmodelDescriptors extends AbstractBasyxTest {

        private AssetAdministrationShellRegistryApi api;
        private final BasyxTestRunner runner;
        private final BasyxFunctionalTestDefinition<GetAllSubmodelDescriptorsParams, GetSubmodelDescriptorsResult> def;

        public GetAllSubmodelDescriptors(String testName, BasyxFunctionalTestDefinition<GetAllSubmodelDescriptorsParams, GetSubmodelDescriptorsResult> def, BasyxTestRunner runner) {
            this.runner = runner;
            this.def = def;
        }

        @Before
        public void init() {
            this.api = new AssetAdministrationShellRegistryApi(MAPPER, ENVIRONMENT.getAasRegistryUrl());            
        }

        @Parameters(name="{0}")
        public static List<Object[]> initialize() {
            Path testFolder = Path.of(getPropertyOrThrow("basyxtest.folder"), "aas-registry");
            ArrayList<Object[]> config = new ArrayList<>();
            BasyxTestRunner runner = new BasyxTestRunner(ENVIRONMENT, MAPPER, testFolder);
            List<BasyxFunctionalTestDefinition<GetAllSubmodelDescriptorsParams, GetSubmodelDescriptorsResult>> defs = runner.loadFunctionalTestDefinition("getAllSubmodelDescriptors", GetAllSubmodelDescriptorsParams.class, GetSubmodelDescriptorsResult.class);
            for (BasyxFunctionalTestDefinition<GetAllSubmodelDescriptorsParams, GetSubmodelDescriptorsResult> eachDef : defs) {            
        	    config.add(new Object[] {eachDef.getName(), eachDef, runner});
            }            
        	return config;
        }

        /**
        * Returns all Submodel Descriptors
        *
        * 
        *
        */
        @Test
        public void getAllSubmodelDescriptorsTest() throws ApiException {                
           runner.runAndAssertWithFunctionalResult(def, this::getAllSubmodelDescriptors);            
        }
        
        private GetSubmodelDescriptorsResult getAllSubmodelDescriptors(GetAllSubmodelDescriptorsParams params) throws ApiException {
            return api.getAllSubmodelDescriptors(params.getAasIdentifier(), params.getLimit(), params.getCursor());
        }
    }

    @RunWith(Parameterized.class)
    public static class GetAssetAdministrationShellDescriptor extends AbstractBasyxTest {

        private AssetAdministrationShellRegistryApi api;
        private final BasyxTestRunner runner;
        private final BasyxFunctionalTestDefinition<GetAssetAdministrationShellDescriptorParams, AssetAdministrationShellDescriptor> def;

        public GetAssetAdministrationShellDescriptor(String testName, BasyxFunctionalTestDefinition<GetAssetAdministrationShellDescriptorParams, AssetAdministrationShellDescriptor> def, BasyxTestRunner runner) {
            this.runner = runner;
            this.def = def;
        }

        @Before
        public void init() {
            this.api = new AssetAdministrationShellRegistryApi(MAPPER, ENVIRONMENT.getAasRegistryUrl());            
        }

        @Parameters(name="{0}")
        public static List<Object[]> initialize() {
            Path testFolder = Path.of(getPropertyOrThrow("basyxtest.folder"), "aas-registry");
            ArrayList<Object[]> config = new ArrayList<>();
            BasyxTestRunner runner = new BasyxTestRunner(ENVIRONMENT, MAPPER, testFolder);
            List<BasyxFunctionalTestDefinition<GetAssetAdministrationShellDescriptorParams, AssetAdministrationShellDescriptor>> defs = runner.loadFunctionalTestDefinition("getAssetAdministrationShellDescriptor", GetAssetAdministrationShellDescriptorParams.class, AssetAdministrationShellDescriptor.class);
            for (BasyxFunctionalTestDefinition<GetAssetAdministrationShellDescriptorParams, AssetAdministrationShellDescriptor> eachDef : defs) {            
        	    config.add(new Object[] {eachDef.getName(), eachDef, runner});
            }            
        	return config;
        }

        /**
        * Returns a specific Asset Administration Shell Descriptor
        *
        * 
        *
        */
        @Test
        public void getAssetAdministrationShellDescriptorTest() throws ApiException {                
           runner.runAndAssertWithFunctionalResult(def, this::getAssetAdministrationShellDescriptor);            
        }
        
        private AssetAdministrationShellDescriptor getAssetAdministrationShellDescriptor(GetAssetAdministrationShellDescriptorParams params) throws ApiException {
            return api.getAssetAdministrationShellDescriptor(params.getAasIdentifier());
        }
    }

    @RunWith(Parameterized.class)
    public static class GetDescription extends AbstractBasyxTest {

        private AssetAdministrationShellRegistryApi api;
        private final BasyxTestRunner runner;
        private final BasyxFunctionalTestDefinition<GetDescriptionParams, ServiceDescription> def;

        public GetDescription(String testName, BasyxFunctionalTestDefinition<GetDescriptionParams, ServiceDescription> def, BasyxTestRunner runner) {
            this.runner = runner;
            this.def = def;
        }

        @Before
        public void init() {
            this.api = new AssetAdministrationShellRegistryApi(MAPPER, ENVIRONMENT.getAasRegistryUrl());            
        }

        @Parameters(name="{0}")
        public static List<Object[]> initialize() {
            Path testFolder = Path.of(getPropertyOrThrow("basyxtest.folder"), "aas-registry");
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
    public static class GetSubmodelDescriptor extends AbstractBasyxTest {

        private AssetAdministrationShellRegistryApi api;
        private final BasyxTestRunner runner;
        private final BasyxFunctionalTestDefinition<GetSubmodelDescriptorParams, SubmodelDescriptor> def;

        public GetSubmodelDescriptor(String testName, BasyxFunctionalTestDefinition<GetSubmodelDescriptorParams, SubmodelDescriptor> def, BasyxTestRunner runner) {
            this.runner = runner;
            this.def = def;
        }

        @Before
        public void init() {
            this.api = new AssetAdministrationShellRegistryApi(MAPPER, ENVIRONMENT.getAasRegistryUrl());            
        }

        @Parameters(name="{0}")
        public static List<Object[]> initialize() {
            Path testFolder = Path.of(getPropertyOrThrow("basyxtest.folder"), "aas-registry");
            ArrayList<Object[]> config = new ArrayList<>();
            BasyxTestRunner runner = new BasyxTestRunner(ENVIRONMENT, MAPPER, testFolder);
            List<BasyxFunctionalTestDefinition<GetSubmodelDescriptorParams, SubmodelDescriptor>> defs = runner.loadFunctionalTestDefinition("getSubmodelDescriptor", GetSubmodelDescriptorParams.class, SubmodelDescriptor.class);
            for (BasyxFunctionalTestDefinition<GetSubmodelDescriptorParams, SubmodelDescriptor> eachDef : defs) {            
        	    config.add(new Object[] {eachDef.getName(), eachDef, runner});
            }            
        	return config;
        }

        /**
        * Returns a specific Submodel Descriptor
        *
        * 
        *
        */
        @Test
        public void getSubmodelDescriptorTest() throws ApiException {                
           runner.runAndAssertWithFunctionalResult(def, this::getSubmodelDescriptor);            
        }
        
        private SubmodelDescriptor getSubmodelDescriptor(GetSubmodelDescriptorParams params) throws ApiException {
            return api.getSubmodelDescriptor(params.getAasIdentifier(), params.getSubmodelIdentifier());
        }
    }

    @RunWith(Parameterized.class)
    public static class PostAssetAdministrationShellDescriptor extends AbstractBasyxTest {

        private AssetAdministrationShellRegistryApi api;
        private final BasyxTestRunner runner;
        private final BasyxFunctionalTestDefinition<PostAssetAdministrationShellDescriptorParams, AssetAdministrationShellDescriptor> def;

        public PostAssetAdministrationShellDescriptor(String testName, BasyxFunctionalTestDefinition<PostAssetAdministrationShellDescriptorParams, AssetAdministrationShellDescriptor> def, BasyxTestRunner runner) {
            this.runner = runner;
            this.def = def;
        }

        @Before
        public void init() {
            this.api = new AssetAdministrationShellRegistryApi(MAPPER, ENVIRONMENT.getAasRegistryUrl());            
        }

        @Parameters(name="{0}")
        public static List<Object[]> initialize() {
            Path testFolder = Path.of(getPropertyOrThrow("basyxtest.folder"), "aas-registry");
            ArrayList<Object[]> config = new ArrayList<>();
            BasyxTestRunner runner = new BasyxTestRunner(ENVIRONMENT, MAPPER, testFolder);
            List<BasyxFunctionalTestDefinition<PostAssetAdministrationShellDescriptorParams, AssetAdministrationShellDescriptor>> defs = runner.loadFunctionalTestDefinition("postAssetAdministrationShellDescriptor", PostAssetAdministrationShellDescriptorParams.class, AssetAdministrationShellDescriptor.class);
            for (BasyxFunctionalTestDefinition<PostAssetAdministrationShellDescriptorParams, AssetAdministrationShellDescriptor> eachDef : defs) {            
        	    config.add(new Object[] {eachDef.getName(), eachDef, runner});
            }            
        	return config;
        }

        /**
        * Creates a new Asset Administration Shell Descriptor, i.e. registers an AAS
        *
        * 
        *
        */
        @Test
        public void postAssetAdministrationShellDescriptorTest() throws ApiException {                
           runner.runAndAssertWithFunctionalResult(def, this::postAssetAdministrationShellDescriptor);            
        }
        
        private AssetAdministrationShellDescriptor postAssetAdministrationShellDescriptor(PostAssetAdministrationShellDescriptorParams params) throws ApiException {
            return api.postAssetAdministrationShellDescriptor(params.getAssetAdministrationShellDescriptor());
        }
    }

    @RunWith(Parameterized.class)
    public static class PostSubmodelDescriptor extends AbstractBasyxTest {

        private AssetAdministrationShellRegistryApi api;
        private final BasyxTestRunner runner;
        private final BasyxFunctionalTestDefinition<PostSubmodelDescriptorParams, SubmodelDescriptor> def;

        public PostSubmodelDescriptor(String testName, BasyxFunctionalTestDefinition<PostSubmodelDescriptorParams, SubmodelDescriptor> def, BasyxTestRunner runner) {
            this.runner = runner;
            this.def = def;
        }

        @Before
        public void init() {
            this.api = new AssetAdministrationShellRegistryApi(MAPPER, ENVIRONMENT.getAasRegistryUrl());            
        }

        @Parameters(name="{0}")
        public static List<Object[]> initialize() {
            Path testFolder = Path.of(getPropertyOrThrow("basyxtest.folder"), "aas-registry");
            ArrayList<Object[]> config = new ArrayList<>();
            BasyxTestRunner runner = new BasyxTestRunner(ENVIRONMENT, MAPPER, testFolder);
            List<BasyxFunctionalTestDefinition<PostSubmodelDescriptorParams, SubmodelDescriptor>> defs = runner.loadFunctionalTestDefinition("postSubmodelDescriptor", PostSubmodelDescriptorParams.class, SubmodelDescriptor.class);
            for (BasyxFunctionalTestDefinition<PostSubmodelDescriptorParams, SubmodelDescriptor> eachDef : defs) {            
        	    config.add(new Object[] {eachDef.getName(), eachDef, runner});
            }            
        	return config;
        }

        /**
        * Creates a new Submodel Descriptor, i.e. registers a submodel
        *
        * 
        *
        */
        @Test
        public void postSubmodelDescriptorTest() throws ApiException {                
           runner.runAndAssertWithFunctionalResult(def, this::postSubmodelDescriptor);            
        }
        
        private SubmodelDescriptor postSubmodelDescriptor(PostSubmodelDescriptorParams params) throws ApiException {
            return api.postSubmodelDescriptor(params.getAasIdentifier(), params.getSubmodelDescriptor());
        }
    }

    @RunWith(Parameterized.class)
    public static class PutAssetAdministrationShellDescriptor extends AbstractBasyxTest {

        private AssetAdministrationShellRegistryApi api;
        private final BasyxTestRunner runner;
        private final BasyxVoidTestDefinition<PutAssetAdministrationShellDescriptorParams> def;

        public PutAssetAdministrationShellDescriptor(String testName, BasyxVoidTestDefinition<PutAssetAdministrationShellDescriptorParams> def, BasyxTestRunner runner) {
            this.runner = runner;
            this.def = def;
        }

        @Before
        public void init() {
            this.api = new AssetAdministrationShellRegistryApi(MAPPER, ENVIRONMENT.getAasRegistryUrl());            
        }

        @Parameters(name="{0}")
        public static List<Object[]> initialize() {
            Path testFolder = Path.of(getPropertyOrThrow("basyxtest.folder"), "aas-registry");
            ArrayList<Object[]> config = new ArrayList<>();
            BasyxTestRunner runner = new BasyxTestRunner(ENVIRONMENT, MAPPER, testFolder);
            List<BasyxVoidTestDefinition<PutAssetAdministrationShellDescriptorParams>> defs = runner.loadVoidTestDefinition("putAssetAdministrationShellDescriptor", PutAssetAdministrationShellDescriptorParams.class);
            for (BasyxVoidTestDefinition<PutAssetAdministrationShellDescriptorParams> eachDef : defs) {            
        	    config.add(new Object[] {eachDef.getName(), eachDef, runner});
            }            
        	return config;
        }

        /**
        * Updates an existing Asset Administration Shell Descriptor
        *
        * 
        *
        */
        @Test
        public void putAssetAdministrationShellDescriptorTest() throws ApiException {                
           runner.runAndAssertWithVoidResult(def, this::putAssetAdministrationShellDescriptor);            
        }
        
        private void putAssetAdministrationShellDescriptor(PutAssetAdministrationShellDescriptorParams params) throws ApiException {
            api.putAssetAdministrationShellDescriptor(params.getAasIdentifier(), params.getAssetAdministrationShellDescriptor());
        }
    }

    @RunWith(Parameterized.class)
    public static class PutSubmodelDescriptor extends AbstractBasyxTest {

        private AssetAdministrationShellRegistryApi api;
        private final BasyxTestRunner runner;
        private final BasyxVoidTestDefinition<PutSubmodelDescriptorParams> def;

        public PutSubmodelDescriptor(String testName, BasyxVoidTestDefinition<PutSubmodelDescriptorParams> def, BasyxTestRunner runner) {
            this.runner = runner;
            this.def = def;
        }

        @Before
        public void init() {
            this.api = new AssetAdministrationShellRegistryApi(MAPPER, ENVIRONMENT.getAasRegistryUrl());            
        }

        @Parameters(name="{0}")
        public static List<Object[]> initialize() {
            Path testFolder = Path.of(getPropertyOrThrow("basyxtest.folder"), "aas-registry");
            ArrayList<Object[]> config = new ArrayList<>();
            BasyxTestRunner runner = new BasyxTestRunner(ENVIRONMENT, MAPPER, testFolder);
            List<BasyxVoidTestDefinition<PutSubmodelDescriptorParams>> defs = runner.loadVoidTestDefinition("putSubmodelDescriptor", PutSubmodelDescriptorParams.class);
            for (BasyxVoidTestDefinition<PutSubmodelDescriptorParams> eachDef : defs) {            
        	    config.add(new Object[] {eachDef.getName(), eachDef, runner});
            }            
        	return config;
        }

        /**
        * Updates an existing Submodel Descriptor
        *
        * 
        *
        */
        @Test
        public void putSubmodelDescriptorTest() throws ApiException {                
           runner.runAndAssertWithVoidResult(def, this::putSubmodelDescriptor);            
        }
        
        private void putSubmodelDescriptor(PutSubmodelDescriptorParams params) throws ApiException {
            api.putSubmodelDescriptor(params.getAasIdentifier(), params.getSubmodelIdentifier(), params.getSubmodelDescriptor());
        }
    }

    @RunWith(Parameterized.class)
    public static class SearchShellDescriptors extends AbstractBasyxTest {

        private AssetAdministrationShellRegistryApi api;
        private final BasyxTestRunner runner;
        private final BasyxFunctionalTestDefinition<SearchShellDescriptorsParams, ShellDescriptorSearchResponse> def;

        public SearchShellDescriptors(String testName, BasyxFunctionalTestDefinition<SearchShellDescriptorsParams, ShellDescriptorSearchResponse> def, BasyxTestRunner runner) {
            this.runner = runner;
            this.def = def;
        }

        @Before
        public void init() {
            this.api = new AssetAdministrationShellRegistryApi(MAPPER, ENVIRONMENT.getAasRegistryUrl());            
        }

        @Parameters(name="{0}")
        public static List<Object[]> initialize() {
            Path testFolder = Path.of(getPropertyOrThrow("basyxtest.folder"), "aas-registry");
            ArrayList<Object[]> config = new ArrayList<>();
            BasyxTestRunner runner = new BasyxTestRunner(ENVIRONMENT, MAPPER, testFolder);
            List<BasyxFunctionalTestDefinition<SearchShellDescriptorsParams, ShellDescriptorSearchResponse>> defs = runner.loadFunctionalTestDefinition("searchShellDescriptors", SearchShellDescriptorsParams.class, ShellDescriptorSearchResponse.class);
            for (BasyxFunctionalTestDefinition<SearchShellDescriptorsParams, ShellDescriptorSearchResponse> eachDef : defs) {            
        	    config.add(new Object[] {eachDef.getName(), eachDef, runner});
            }            
        	return config;
        }

        /**
        * 
        *
        * 
        *
        */
        @Test
        public void searchShellDescriptorsTest() throws ApiException {                
           runner.runAndAssertWithFunctionalResult(def, this::searchShellDescriptors);            
        }
        
        private ShellDescriptorSearchResponse searchShellDescriptors(SearchShellDescriptorsParams params) throws ApiException {
            return api.searchShellDescriptors(params.getShellDescriptorSearchRequest());
        }
    }
    private static class DeleteAssetAdministrationShellDescriptorParams implements BasyxTestValues {

        private String aasIdentifier;
        @SuppressWarnings("unused")
        public void setAasIdentifier(String aasIdentifier) {
            this.aasIdentifier = aasIdentifier;
        }

        public String getAasIdentifier() {
            return this.aasIdentifier;
        }
    }  
    private static class DeleteSubmodelDescriptorParams implements BasyxTestValues {

        private String aasIdentifier;
        private String submodelIdentifier;
        @SuppressWarnings("unused")
        public void setAasIdentifier(String aasIdentifier) {
            this.aasIdentifier = aasIdentifier;
        }
        @SuppressWarnings("unused")
        public void setSubmodelIdentifier(String submodelIdentifier) {
            this.submodelIdentifier = submodelIdentifier;
        }

        public String getAasIdentifier() {
            return this.aasIdentifier;
        }

        public String getSubmodelIdentifier() {
            return this.submodelIdentifier;
        }
    }  
    private static class GetAllAssetAdministrationShellDescriptorsParams implements BasyxTestValues {

        private Integer limit;
        private String cursor;
        private AssetKind assetKind;
        private String assetType;
        @SuppressWarnings("unused")
        public void setLimit(Integer limit) {
            this.limit = limit;
        }
        @SuppressWarnings("unused")
        public void setCursor(String cursor) {
            this.cursor = cursor;
        }
        @SuppressWarnings("unused")
        public void setAssetKind(AssetKind assetKind) {
            this.assetKind = assetKind;
        }
        @SuppressWarnings("unused")
        public void setAssetType(String assetType) {
            this.assetType = assetType;
        }

        public Integer getLimit() {
            return this.limit;
        }

        public String getCursor() {
            return this.cursor;
        }

        public AssetKind getAssetKind() {
            return this.assetKind;
        }

        public String getAssetType() {
            return this.assetType;
        }
    }  
    private static class GetAllSubmodelDescriptorsParams implements BasyxTestValues {

        private String aasIdentifier;
        private Integer limit;
        private String cursor;
        @SuppressWarnings("unused")
        public void setAasIdentifier(String aasIdentifier) {
            this.aasIdentifier = aasIdentifier;
        }
        @SuppressWarnings("unused")
        public void setLimit(Integer limit) {
            this.limit = limit;
        }
        @SuppressWarnings("unused")
        public void setCursor(String cursor) {
            this.cursor = cursor;
        }

        public String getAasIdentifier() {
            return this.aasIdentifier;
        }

        public Integer getLimit() {
            return this.limit;
        }

        public String getCursor() {
            return this.cursor;
        }
    }  
    private static class GetAssetAdministrationShellDescriptorParams implements BasyxTestValues {

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
    private static class GetSubmodelDescriptorParams implements BasyxTestValues {

        private String aasIdentifier;
        private String submodelIdentifier;
        @SuppressWarnings("unused")
        public void setAasIdentifier(String aasIdentifier) {
            this.aasIdentifier = aasIdentifier;
        }
        @SuppressWarnings("unused")
        public void setSubmodelIdentifier(String submodelIdentifier) {
            this.submodelIdentifier = submodelIdentifier;
        }

        public String getAasIdentifier() {
            return this.aasIdentifier;
        }

        public String getSubmodelIdentifier() {
            return this.submodelIdentifier;
        }
    }  
    private static class PostAssetAdministrationShellDescriptorParams implements BasyxTestValues {

        private AssetAdministrationShellDescriptor assetAdministrationShellDescriptor;
        @SuppressWarnings("unused")
        public void setAssetAdministrationShellDescriptor(AssetAdministrationShellDescriptor assetAdministrationShellDescriptor) {
            this.assetAdministrationShellDescriptor = assetAdministrationShellDescriptor;
        }

        public AssetAdministrationShellDescriptor getAssetAdministrationShellDescriptor() {
            return this.assetAdministrationShellDescriptor;
        }
    }  
    private static class PostSubmodelDescriptorParams implements BasyxTestValues {

        private String aasIdentifier;
        private SubmodelDescriptor submodelDescriptor;
        @SuppressWarnings("unused")
        public void setAasIdentifier(String aasIdentifier) {
            this.aasIdentifier = aasIdentifier;
        }
        @SuppressWarnings("unused")
        public void setSubmodelDescriptor(SubmodelDescriptor submodelDescriptor) {
            this.submodelDescriptor = submodelDescriptor;
        }

        public String getAasIdentifier() {
            return this.aasIdentifier;
        }

        public SubmodelDescriptor getSubmodelDescriptor() {
            return this.submodelDescriptor;
        }
    }  
    private static class PutAssetAdministrationShellDescriptorParams implements BasyxTestValues {

        private String aasIdentifier;
        private AssetAdministrationShellDescriptor assetAdministrationShellDescriptor;
        @SuppressWarnings("unused")
        public void setAasIdentifier(String aasIdentifier) {
            this.aasIdentifier = aasIdentifier;
        }
        @SuppressWarnings("unused")
        public void setAssetAdministrationShellDescriptor(AssetAdministrationShellDescriptor assetAdministrationShellDescriptor) {
            this.assetAdministrationShellDescriptor = assetAdministrationShellDescriptor;
        }

        public String getAasIdentifier() {
            return this.aasIdentifier;
        }

        public AssetAdministrationShellDescriptor getAssetAdministrationShellDescriptor() {
            return this.assetAdministrationShellDescriptor;
        }
    }  
    private static class PutSubmodelDescriptorParams implements BasyxTestValues {

        private String aasIdentifier;
        private String submodelIdentifier;
        private SubmodelDescriptor submodelDescriptor;
        @SuppressWarnings("unused")
        public void setAasIdentifier(String aasIdentifier) {
            this.aasIdentifier = aasIdentifier;
        }
        @SuppressWarnings("unused")
        public void setSubmodelIdentifier(String submodelIdentifier) {
            this.submodelIdentifier = submodelIdentifier;
        }
        @SuppressWarnings("unused")
        public void setSubmodelDescriptor(SubmodelDescriptor submodelDescriptor) {
            this.submodelDescriptor = submodelDescriptor;
        }

        public String getAasIdentifier() {
            return this.aasIdentifier;
        }

        public String getSubmodelIdentifier() {
            return this.submodelIdentifier;
        }

        public SubmodelDescriptor getSubmodelDescriptor() {
            return this.submodelDescriptor;
        }
    }  
    private static class SearchShellDescriptorsParams implements BasyxTestValues {

        private ShellDescriptorSearchRequest shellDescriptorSearchRequest;
        @SuppressWarnings("unused")
        public void setShellDescriptorSearchRequest(ShellDescriptorSearchRequest shellDescriptorSearchRequest) {
            this.shellDescriptorSearchRequest = shellDescriptorSearchRequest;
        }

        public ShellDescriptorSearchRequest getShellDescriptorSearchRequest() {
            return this.shellDescriptorSearchRequest;
        }
    }  
}    
