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
import org.eclipse.digitaltwin.aas4j.v3.model.AssetAdministrationShell;
import org.eclipse.digitaltwin.aas4j.v3.model.AssetInformation;
import java.io.File;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part2.GetAssetAdministrationShellsResult;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part2.GetReferencesResult;
import org.eclipse.digitaltwin.aas4j.v3.model.Reference;
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
 * API tests for AssetAdministrationShellRepositoryApi
 */
public class AssetAdministrationShellRepositoryApiTest {


    public AssetAdministrationShellRepositoryApiTest() {
    }

    private static String getPropertyOrThrow(String propName) {
    	String prop = System.getProperty(propName);
	    if (prop == null) {
	    	throw new IllegalArgumentException("Property '" + propName + "' not set.");
	    }
	    return prop;
    }

    
    @RunWith(Parameterized.class)
    public static class DeleteAssetAdministrationShell extends AbstractBasyxTest {

        private AssetAdministrationShellRepositoryApi api;
        private final BasyxTestRunner runner;
        private final BasyxVoidTestDefinition<DeleteAssetAdministrationShellParams> def;

        public DeleteAssetAdministrationShell(String testName, BasyxVoidTestDefinition<DeleteAssetAdministrationShellParams> def, BasyxTestRunner runner) {
            this.runner = runner;
            this.def = def;
        }

        @Before
        public void init() {
            this.api = new AssetAdministrationShellRepositoryApi(MAPPER, ENVIRONMENT.getAasRepositoryUrl());            
        }

        @Parameters(name="{0}")
        public static List<Object[]> initialize() {
            Path testFolder = Path.of(getPropertyOrThrow("basyxtest.folder"), "aas-repository");
            ArrayList<Object[]> config = new ArrayList<>();
            BasyxTestRunner runner = new BasyxTestRunner(ENVIRONMENT, MAPPER, testFolder);
            List<BasyxVoidTestDefinition<DeleteAssetAdministrationShellParams>> defs = runner.loadVoidTestDefinition("deleteAssetAdministrationShell", DeleteAssetAdministrationShellParams.class);
            for (BasyxVoidTestDefinition<DeleteAssetAdministrationShellParams> eachDef : defs) {            
        	    config.add(new Object[] {eachDef.getName(), eachDef, runner});
            }            
        	return config;
        }

        /**
        * Deletes an Asset Administration Shell
        *
        * 
        *
        */
        @Test
        public void deleteAssetAdministrationShellTest() throws ApiException {                
           runner.runAndAssertWithVoidResult(def, this::deleteAssetAdministrationShell);            
        }
        
        private void deleteAssetAdministrationShell(DeleteAssetAdministrationShellParams params) throws ApiException {
            api.deleteAssetAdministrationShell(params.getAasIdentifier());
        }
    }

    @RunWith(Parameterized.class)
    public static class DeleteSubmodelReference extends AbstractBasyxTest {

        private AssetAdministrationShellRepositoryApi api;
        private final BasyxTestRunner runner;
        private final BasyxVoidTestDefinition<DeleteSubmodelReferenceParams> def;

        public DeleteSubmodelReference(String testName, BasyxVoidTestDefinition<DeleteSubmodelReferenceParams> def, BasyxTestRunner runner) {
            this.runner = runner;
            this.def = def;
        }

        @Before
        public void init() {
            this.api = new AssetAdministrationShellRepositoryApi(MAPPER, ENVIRONMENT.getAasRepositoryUrl());            
        }

        @Parameters(name="{0}")
        public static List<Object[]> initialize() {
            Path testFolder = Path.of(getPropertyOrThrow("basyxtest.folder"), "aas-repository");
            ArrayList<Object[]> config = new ArrayList<>();
            BasyxTestRunner runner = new BasyxTestRunner(ENVIRONMENT, MAPPER, testFolder);
            List<BasyxVoidTestDefinition<DeleteSubmodelReferenceParams>> defs = runner.loadVoidTestDefinition("deleteSubmodelReference", DeleteSubmodelReferenceParams.class);
            for (BasyxVoidTestDefinition<DeleteSubmodelReferenceParams> eachDef : defs) {            
        	    config.add(new Object[] {eachDef.getName(), eachDef, runner});
            }            
        	return config;
        }

        /**
        * Deletes the submodel reference from the Asset Administration Shell. Does not delete the submodel itself!
        *
        * 
        *
        */
        @Test
        public void deleteSubmodelReferenceTest() throws ApiException {                
           runner.runAndAssertWithVoidResult(def, this::deleteSubmodelReference);            
        }
        
        private void deleteSubmodelReference(DeleteSubmodelReferenceParams params) throws ApiException {
            api.deleteSubmodelReference(params.getAasIdentifier(), params.getSubmodelIdentifier());
        }
    }

    @RunWith(Parameterized.class)
    public static class DeleteThumbnail extends AbstractBasyxTest {

        private AssetAdministrationShellRepositoryApi api;
        private final BasyxTestRunner runner;
        private final BasyxVoidTestDefinition<DeleteThumbnailParams> def;

        public DeleteThumbnail(String testName, BasyxVoidTestDefinition<DeleteThumbnailParams> def, BasyxTestRunner runner) {
            this.runner = runner;
            this.def = def;
        }

        @Before
        public void init() {
            this.api = new AssetAdministrationShellRepositoryApi(MAPPER, ENVIRONMENT.getAasRepositoryUrl());            
        }

        @Parameters(name="{0}")
        public static List<Object[]> initialize() {
            Path testFolder = Path.of(getPropertyOrThrow("basyxtest.folder"), "aas-repository");
            ArrayList<Object[]> config = new ArrayList<>();
            BasyxTestRunner runner = new BasyxTestRunner(ENVIRONMENT, MAPPER, testFolder);
            List<BasyxVoidTestDefinition<DeleteThumbnailParams>> defs = runner.loadVoidTestDefinition("deleteThumbnail", DeleteThumbnailParams.class);
            for (BasyxVoidTestDefinition<DeleteThumbnailParams> eachDef : defs) {            
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
        public void deleteThumbnailTest() throws ApiException {                
           runner.runAndAssertWithVoidResult(def, this::deleteThumbnail);            
        }
        
        private void deleteThumbnail(DeleteThumbnailParams params) throws ApiException {
            api.deleteThumbnail(params.getAasIdentifier());
        }
    }

    @RunWith(Parameterized.class)
    public static class GetAllAssetAdministrationShells extends AbstractBasyxTest {

        private AssetAdministrationShellRepositoryApi api;
        private final BasyxTestRunner runner;
        private final BasyxFunctionalTestDefinition<GetAllAssetAdministrationShellsParams, GetAssetAdministrationShellsResult> def;

        public GetAllAssetAdministrationShells(String testName, BasyxFunctionalTestDefinition<GetAllAssetAdministrationShellsParams, GetAssetAdministrationShellsResult> def, BasyxTestRunner runner) {
            this.runner = runner;
            this.def = def;
        }

        @Before
        public void init() {
            this.api = new AssetAdministrationShellRepositoryApi(MAPPER, ENVIRONMENT.getAasRepositoryUrl());            
        }

        @Parameters(name="{0}")
        public static List<Object[]> initialize() {
            Path testFolder = Path.of(getPropertyOrThrow("basyxtest.folder"), "aas-repository");
            ArrayList<Object[]> config = new ArrayList<>();
            BasyxTestRunner runner = new BasyxTestRunner(ENVIRONMENT, MAPPER, testFolder);
            List<BasyxFunctionalTestDefinition<GetAllAssetAdministrationShellsParams, GetAssetAdministrationShellsResult>> defs = runner.loadFunctionalTestDefinition("getAllAssetAdministrationShells", GetAllAssetAdministrationShellsParams.class, GetAssetAdministrationShellsResult.class);
            for (BasyxFunctionalTestDefinition<GetAllAssetAdministrationShellsParams, GetAssetAdministrationShellsResult> eachDef : defs) {            
        	    config.add(new Object[] {eachDef.getName(), eachDef, runner});
            }            
        	return config;
        }

        /**
        * Returns all Asset Administration Shells
        *
        * 
        *
        */
        @Test
        public void getAllAssetAdministrationShellsTest() throws ApiException {                
           runner.runAndAssertWithFunctionalResult(def, this::getAllAssetAdministrationShells);            
        }
        
        private GetAssetAdministrationShellsResult getAllAssetAdministrationShells(GetAllAssetAdministrationShellsParams params) throws ApiException {
            return api.getAllAssetAdministrationShells(params.getAssetIds(), params.getIdShort(), params.getLimit(), params.getCursor());
        }
    }

    @RunWith(Parameterized.class)
    public static class GetAllSubmodelReferences extends AbstractBasyxTest {

        private AssetAdministrationShellRepositoryApi api;
        private final BasyxTestRunner runner;
        private final BasyxFunctionalTestDefinition<GetAllSubmodelReferencesParams, GetReferencesResult> def;

        public GetAllSubmodelReferences(String testName, BasyxFunctionalTestDefinition<GetAllSubmodelReferencesParams, GetReferencesResult> def, BasyxTestRunner runner) {
            this.runner = runner;
            this.def = def;
        }

        @Before
        public void init() {
            this.api = new AssetAdministrationShellRepositoryApi(MAPPER, ENVIRONMENT.getAasRepositoryUrl());            
        }

        @Parameters(name="{0}")
        public static List<Object[]> initialize() {
            Path testFolder = Path.of(getPropertyOrThrow("basyxtest.folder"), "aas-repository");
            ArrayList<Object[]> config = new ArrayList<>();
            BasyxTestRunner runner = new BasyxTestRunner(ENVIRONMENT, MAPPER, testFolder);
            List<BasyxFunctionalTestDefinition<GetAllSubmodelReferencesParams, GetReferencesResult>> defs = runner.loadFunctionalTestDefinition("getAllSubmodelReferences", GetAllSubmodelReferencesParams.class, GetReferencesResult.class);
            for (BasyxFunctionalTestDefinition<GetAllSubmodelReferencesParams, GetReferencesResult> eachDef : defs) {            
        	    config.add(new Object[] {eachDef.getName(), eachDef, runner});
            }            
        	return config;
        }

        /**
        * Returns all submodel references
        *
        * 
        *
        */
        @Test
        public void getAllSubmodelReferencesTest() throws ApiException {                
           runner.runAndAssertWithFunctionalResult(def, this::getAllSubmodelReferences);            
        }
        
        private GetReferencesResult getAllSubmodelReferences(GetAllSubmodelReferencesParams params) throws ApiException {
            return api.getAllSubmodelReferences(params.getAasIdentifier(), params.getLimit(), params.getCursor());
        }
    }

    @RunWith(Parameterized.class)
    public static class GetAssetAdministrationShell extends AbstractBasyxTest {

        private AssetAdministrationShellRepositoryApi api;
        private final BasyxTestRunner runner;
        private final BasyxFunctionalTestDefinition<GetAssetAdministrationShellParams, AssetAdministrationShell> def;

        public GetAssetAdministrationShell(String testName, BasyxFunctionalTestDefinition<GetAssetAdministrationShellParams, AssetAdministrationShell> def, BasyxTestRunner runner) {
            this.runner = runner;
            this.def = def;
        }

        @Before
        public void init() {
            this.api = new AssetAdministrationShellRepositoryApi(MAPPER, ENVIRONMENT.getAasRepositoryUrl());            
        }

        @Parameters(name="{0}")
        public static List<Object[]> initialize() {
            Path testFolder = Path.of(getPropertyOrThrow("basyxtest.folder"), "aas-repository");
            ArrayList<Object[]> config = new ArrayList<>();
            BasyxTestRunner runner = new BasyxTestRunner(ENVIRONMENT, MAPPER, testFolder);
            List<BasyxFunctionalTestDefinition<GetAssetAdministrationShellParams, AssetAdministrationShell>> defs = runner.loadFunctionalTestDefinition("getAssetAdministrationShell", GetAssetAdministrationShellParams.class, AssetAdministrationShell.class);
            for (BasyxFunctionalTestDefinition<GetAssetAdministrationShellParams, AssetAdministrationShell> eachDef : defs) {            
        	    config.add(new Object[] {eachDef.getName(), eachDef, runner});
            }            
        	return config;
        }

        /**
        * Returns a specific Asset Administration Shell
        *
        * 
        *
        */
        @Test
        public void getAssetAdministrationShellTest() throws ApiException {                
           runner.runAndAssertWithFunctionalResult(def, this::getAssetAdministrationShell);            
        }
        
        private AssetAdministrationShell getAssetAdministrationShell(GetAssetAdministrationShellParams params) throws ApiException {
            return api.getAssetAdministrationShell(params.getAasIdentifier());
        }
    }

    @RunWith(Parameterized.class)
    public static class GetAssetInformation extends AbstractBasyxTest {

        private AssetAdministrationShellRepositoryApi api;
        private final BasyxTestRunner runner;
        private final BasyxFunctionalTestDefinition<GetAssetInformationParams, AssetInformation> def;

        public GetAssetInformation(String testName, BasyxFunctionalTestDefinition<GetAssetInformationParams, AssetInformation> def, BasyxTestRunner runner) {
            this.runner = runner;
            this.def = def;
        }

        @Before
        public void init() {
            this.api = new AssetAdministrationShellRepositoryApi(MAPPER, ENVIRONMENT.getAasRepositoryUrl());            
        }

        @Parameters(name="{0}")
        public static List<Object[]> initialize() {
            Path testFolder = Path.of(getPropertyOrThrow("basyxtest.folder"), "aas-repository");
            ArrayList<Object[]> config = new ArrayList<>();
            BasyxTestRunner runner = new BasyxTestRunner(ENVIRONMENT, MAPPER, testFolder);
            List<BasyxFunctionalTestDefinition<GetAssetInformationParams, AssetInformation>> defs = runner.loadFunctionalTestDefinition("getAssetInformation", GetAssetInformationParams.class, AssetInformation.class);
            for (BasyxFunctionalTestDefinition<GetAssetInformationParams, AssetInformation> eachDef : defs) {            
        	    config.add(new Object[] {eachDef.getName(), eachDef, runner});
            }            
        	return config;
        }

        /**
        * Returns the Asset Information
        *
        * 
        *
        */
        @Test
        public void getAssetInformationTest() throws ApiException {                
           runner.runAndAssertWithFunctionalResult(def, this::getAssetInformation);            
        }
        
        private AssetInformation getAssetInformation(GetAssetInformationParams params) throws ApiException {
            return api.getAssetInformation(params.getAasIdentifier());
        }
    }

    @RunWith(Parameterized.class)
    public static class GetDescription extends AbstractBasyxTest {

        private AssetAdministrationShellRepositoryApi api;
        private final BasyxTestRunner runner;
        private final BasyxFunctionalTestDefinition<GetDescriptionParams, ServiceDescription> def;

        public GetDescription(String testName, BasyxFunctionalTestDefinition<GetDescriptionParams, ServiceDescription> def, BasyxTestRunner runner) {
            this.runner = runner;
            this.def = def;
        }

        @Before
        public void init() {
            this.api = new AssetAdministrationShellRepositoryApi(MAPPER, ENVIRONMENT.getAasRepositoryUrl());            
        }

        @Parameters(name="{0}")
        public static List<Object[]> initialize() {
            Path testFolder = Path.of(getPropertyOrThrow("basyxtest.folder"), "aas-repository");
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
    public static class GetThumbnail extends AbstractBasyxTest {

        private AssetAdministrationShellRepositoryApi api;
        private final BasyxTestRunner runner;
        private final BasyxFunctionalTestDefinition<GetThumbnailParams, File> def;

        public GetThumbnail(String testName, BasyxFunctionalTestDefinition<GetThumbnailParams, File> def, BasyxTestRunner runner) {
            this.runner = runner;
            this.def = def;
        }

        @Before
        public void init() {
            this.api = new AssetAdministrationShellRepositoryApi(MAPPER, ENVIRONMENT.getAasRepositoryUrl());            
        }

        @Parameters(name="{0}")
        public static List<Object[]> initialize() {
            Path testFolder = Path.of(getPropertyOrThrow("basyxtest.folder"), "aas-repository");
            ArrayList<Object[]> config = new ArrayList<>();
            BasyxTestRunner runner = new BasyxTestRunner(ENVIRONMENT, MAPPER, testFolder);
            List<BasyxFunctionalTestDefinition<GetThumbnailParams, File>> defs = runner.loadFunctionalTestDefinition("getThumbnail", GetThumbnailParams.class, File.class);
            for (BasyxFunctionalTestDefinition<GetThumbnailParams, File> eachDef : defs) {            
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
        public void getThumbnailTest() throws ApiException {                
           runner.runAndAssertWithFunctionalResult(def, this::getThumbnail);            
        }
        
        private File getThumbnail(GetThumbnailParams params) throws ApiException {
            java.io.InputStream in = api.getThumbnail(params.getAasIdentifier());
            try {
				Path temp = java.nio.file.Files.createTempFile("getThumbnail", ".tmp");
				java.nio.file.Files.copy(in, temp, java.nio.file.StandardCopyOption.REPLACE_EXISTING);
				return temp.toFile();
			} catch (java.io.IOException e) {
				throw new ApiException(e);
			}            
        }
    }

    @RunWith(Parameterized.class)
    public static class PostAssetAdministrationShell extends AbstractBasyxTest {

        private AssetAdministrationShellRepositoryApi api;
        private final BasyxTestRunner runner;
        private final BasyxFunctionalTestDefinition<PostAssetAdministrationShellParams, AssetAdministrationShell> def;

        public PostAssetAdministrationShell(String testName, BasyxFunctionalTestDefinition<PostAssetAdministrationShellParams, AssetAdministrationShell> def, BasyxTestRunner runner) {
            this.runner = runner;
            this.def = def;
        }

        @Before
        public void init() {
            this.api = new AssetAdministrationShellRepositoryApi(MAPPER, ENVIRONMENT.getAasRepositoryUrl());            
        }

        @Parameters(name="{0}")
        public static List<Object[]> initialize() {
            Path testFolder = Path.of(getPropertyOrThrow("basyxtest.folder"), "aas-repository");
            ArrayList<Object[]> config = new ArrayList<>();
            BasyxTestRunner runner = new BasyxTestRunner(ENVIRONMENT, MAPPER, testFolder);
            List<BasyxFunctionalTestDefinition<PostAssetAdministrationShellParams, AssetAdministrationShell>> defs = runner.loadFunctionalTestDefinition("postAssetAdministrationShell", PostAssetAdministrationShellParams.class, AssetAdministrationShell.class);
            for (BasyxFunctionalTestDefinition<PostAssetAdministrationShellParams, AssetAdministrationShell> eachDef : defs) {            
        	    config.add(new Object[] {eachDef.getName(), eachDef, runner});
            }            
        	return config;
        }

        /**
        * Creates a new Asset Administration Shell
        *
        * 
        *
        */
        @Test
        public void postAssetAdministrationShellTest() throws ApiException {                
           runner.runAndAssertWithFunctionalResult(def, this::postAssetAdministrationShell);            
        }
        
        private AssetAdministrationShell postAssetAdministrationShell(PostAssetAdministrationShellParams params) throws ApiException {
            return api.postAssetAdministrationShell(params.getAssetAdministrationShell());
        }
    }

    @RunWith(Parameterized.class)
    public static class PostSubmodelReference extends AbstractBasyxTest {

        private AssetAdministrationShellRepositoryApi api;
        private final BasyxTestRunner runner;
        private final BasyxFunctionalTestDefinition<PostSubmodelReferenceParams, Reference> def;

        public PostSubmodelReference(String testName, BasyxFunctionalTestDefinition<PostSubmodelReferenceParams, Reference> def, BasyxTestRunner runner) {
            this.runner = runner;
            this.def = def;
        }

        @Before
        public void init() {
            this.api = new AssetAdministrationShellRepositoryApi(MAPPER, ENVIRONMENT.getAasRepositoryUrl());            
        }

        @Parameters(name="{0}")
        public static List<Object[]> initialize() {
            Path testFolder = Path.of(getPropertyOrThrow("basyxtest.folder"), "aas-repository");
            ArrayList<Object[]> config = new ArrayList<>();
            BasyxTestRunner runner = new BasyxTestRunner(ENVIRONMENT, MAPPER, testFolder);
            List<BasyxFunctionalTestDefinition<PostSubmodelReferenceParams, Reference>> defs = runner.loadFunctionalTestDefinition("postSubmodelReference", PostSubmodelReferenceParams.class, Reference.class);
            for (BasyxFunctionalTestDefinition<PostSubmodelReferenceParams, Reference> eachDef : defs) {            
        	    config.add(new Object[] {eachDef.getName(), eachDef, runner});
            }            
        	return config;
        }

        /**
        * Creates a submodel reference at the Asset Administration Shell
        *
        * 
        *
        */
        @Test
        public void postSubmodelReferenceTest() throws ApiException {                
           runner.runAndAssertWithFunctionalResult(def, this::postSubmodelReference);            
        }
        
        private Reference postSubmodelReference(PostSubmodelReferenceParams params) throws ApiException {
            return api.postSubmodelReference(params.getAasIdentifier(), params.getReference());
        }
    }

    @RunWith(Parameterized.class)
    public static class PutAssetAdministrationShell extends AbstractBasyxTest {

        private AssetAdministrationShellRepositoryApi api;
        private final BasyxTestRunner runner;
        private final BasyxVoidTestDefinition<PutAssetAdministrationShellParams> def;

        public PutAssetAdministrationShell(String testName, BasyxVoidTestDefinition<PutAssetAdministrationShellParams> def, BasyxTestRunner runner) {
            this.runner = runner;
            this.def = def;
        }

        @Before
        public void init() {
            this.api = new AssetAdministrationShellRepositoryApi(MAPPER, ENVIRONMENT.getAasRepositoryUrl());            
        }

        @Parameters(name="{0}")
        public static List<Object[]> initialize() {
            Path testFolder = Path.of(getPropertyOrThrow("basyxtest.folder"), "aas-repository");
            ArrayList<Object[]> config = new ArrayList<>();
            BasyxTestRunner runner = new BasyxTestRunner(ENVIRONMENT, MAPPER, testFolder);
            List<BasyxVoidTestDefinition<PutAssetAdministrationShellParams>> defs = runner.loadVoidTestDefinition("putAssetAdministrationShell", PutAssetAdministrationShellParams.class);
            for (BasyxVoidTestDefinition<PutAssetAdministrationShellParams> eachDef : defs) {            
        	    config.add(new Object[] {eachDef.getName(), eachDef, runner});
            }            
        	return config;
        }

        /**
        * Updates an existing Asset Administration Shell
        *
        * 
        *
        */
        @Test
        public void putAssetAdministrationShellTest() throws ApiException {                
           runner.runAndAssertWithVoidResult(def, this::putAssetAdministrationShell);            
        }
        
        private void putAssetAdministrationShell(PutAssetAdministrationShellParams params) throws ApiException {
            api.putAssetAdministrationShell(params.getAasIdentifier(), params.getAssetAdministrationShell());
        }
    }

    @RunWith(Parameterized.class)
    public static class PutAssetInformation extends AbstractBasyxTest {

        private AssetAdministrationShellRepositoryApi api;
        private final BasyxTestRunner runner;
        private final BasyxVoidTestDefinition<PutAssetInformationParams> def;

        public PutAssetInformation(String testName, BasyxVoidTestDefinition<PutAssetInformationParams> def, BasyxTestRunner runner) {
            this.runner = runner;
            this.def = def;
        }

        @Before
        public void init() {
            this.api = new AssetAdministrationShellRepositoryApi(MAPPER, ENVIRONMENT.getAasRepositoryUrl());            
        }

        @Parameters(name="{0}")
        public static List<Object[]> initialize() {
            Path testFolder = Path.of(getPropertyOrThrow("basyxtest.folder"), "aas-repository");
            ArrayList<Object[]> config = new ArrayList<>();
            BasyxTestRunner runner = new BasyxTestRunner(ENVIRONMENT, MAPPER, testFolder);
            List<BasyxVoidTestDefinition<PutAssetInformationParams>> defs = runner.loadVoidTestDefinition("putAssetInformation", PutAssetInformationParams.class);
            for (BasyxVoidTestDefinition<PutAssetInformationParams> eachDef : defs) {            
        	    config.add(new Object[] {eachDef.getName(), eachDef, runner});
            }            
        	return config;
        }

        /**
        * Updates the Asset Information
        *
        * 
        *
        */
        @Test
        public void putAssetInformationTest() throws ApiException {                
           runner.runAndAssertWithVoidResult(def, this::putAssetInformation);            
        }
        
        private void putAssetInformation(PutAssetInformationParams params) throws ApiException {
            api.putAssetInformation(params.getAasIdentifier(), params.getAssetInformation());
        }
    }

    @RunWith(Parameterized.class)
    public static class PutThumbnail extends AbstractBasyxTest {

        private AssetAdministrationShellRepositoryApi api;
        private final BasyxTestRunner runner;
        private final BasyxVoidTestDefinition<PutThumbnailParams> def;

        public PutThumbnail(String testName, BasyxVoidTestDefinition<PutThumbnailParams> def, BasyxTestRunner runner) {
            this.runner = runner;
            this.def = def;
        }

        @Before
        public void init() {
            this.api = new AssetAdministrationShellRepositoryApi(MAPPER, ENVIRONMENT.getAasRepositoryUrl());            
        }

        @Parameters(name="{0}")
        public static List<Object[]> initialize() {
            Path testFolder = Path.of(getPropertyOrThrow("basyxtest.folder"), "aas-repository");
            ArrayList<Object[]> config = new ArrayList<>();
            BasyxTestRunner runner = new BasyxTestRunner(ENVIRONMENT, MAPPER, testFolder);
            List<BasyxVoidTestDefinition<PutThumbnailParams>> defs = runner.loadVoidTestDefinition("putThumbnail", PutThumbnailParams.class);
            for (BasyxVoidTestDefinition<PutThumbnailParams> eachDef : defs) {            
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
        public void putThumbnailTest() throws ApiException {                
           runner.runAndAssertWithVoidResult(def, this::putThumbnail);            
        }
        
        private void putThumbnail(PutThumbnailParams params) throws ApiException {
            api.putThumbnail(params.getAasIdentifier(), params.getFileName(), params.get_file());
        }
    }
    private static class DeleteAssetAdministrationShellParams implements BasyxTestValues {

        private String aasIdentifier;
        @SuppressWarnings("unused")
        public void setAasIdentifier(String aasIdentifier) {
            this.aasIdentifier = aasIdentifier;
        }

        public String getAasIdentifier() {
            return this.aasIdentifier;
        }
    }  
    private static class DeleteSubmodelReferenceParams implements BasyxTestValues {

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
    private static class DeleteThumbnailParams implements BasyxTestValues {

        private String aasIdentifier;
        @SuppressWarnings("unused")
        public void setAasIdentifier(String aasIdentifier) {
            this.aasIdentifier = aasIdentifier;
        }

        public String getAasIdentifier() {
            return this.aasIdentifier;
        }
    }  
    private static class GetAllAssetAdministrationShellsParams implements BasyxTestValues {

        private List<SpecificAssetId> assetIds;
        private String idShort;
        private Integer limit;
        private String cursor;
        @SuppressWarnings("unused")
        public void setAssetIds(List<SpecificAssetId> assetIds) {
            this.assetIds = assetIds;
        }
        @SuppressWarnings("unused")
        public void setIdShort(String idShort) {
            this.idShort = idShort;
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

        public String getIdShort() {
            return this.idShort;
        }

        public Integer getLimit() {
            return this.limit;
        }

        public String getCursor() {
            return this.cursor;
        }
    }  
    private static class GetAllSubmodelReferencesParams implements BasyxTestValues {

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
    private static class GetAssetAdministrationShellParams implements BasyxTestValues {

        private String aasIdentifier;
        @SuppressWarnings("unused")
        public void setAasIdentifier(String aasIdentifier) {
            this.aasIdentifier = aasIdentifier;
        }

        public String getAasIdentifier() {
            return this.aasIdentifier;
        }
    }  
    private static class GetAssetInformationParams implements BasyxTestValues {

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
    private static class GetThumbnailParams implements BasyxTestValues {

        private String aasIdentifier;
        @SuppressWarnings("unused")
        public void setAasIdentifier(String aasIdentifier) {
            this.aasIdentifier = aasIdentifier;
        }

        public String getAasIdentifier() {
            return this.aasIdentifier;
        }
    }  
    private static class PostAssetAdministrationShellParams implements BasyxTestValues {

        private AssetAdministrationShell assetAdministrationShell;
        @SuppressWarnings("unused")
        public void setAssetAdministrationShell(AssetAdministrationShell assetAdministrationShell) {
            this.assetAdministrationShell = assetAdministrationShell;
        }

        public AssetAdministrationShell getAssetAdministrationShell() {
            return this.assetAdministrationShell;
        }
    }  
    private static class PostSubmodelReferenceParams implements BasyxTestValues {

        private String aasIdentifier;
        private Reference reference;
        @SuppressWarnings("unused")
        public void setAasIdentifier(String aasIdentifier) {
            this.aasIdentifier = aasIdentifier;
        }
        @SuppressWarnings("unused")
        public void setReference(Reference reference) {
            this.reference = reference;
        }

        public String getAasIdentifier() {
            return this.aasIdentifier;
        }

        public Reference getReference() {
            return this.reference;
        }
    }  
    private static class PutAssetAdministrationShellParams implements BasyxTestValues {

        private String aasIdentifier;
        private AssetAdministrationShell assetAdministrationShell;
        @SuppressWarnings("unused")
        public void setAasIdentifier(String aasIdentifier) {
            this.aasIdentifier = aasIdentifier;
        }
        @SuppressWarnings("unused")
        public void setAssetAdministrationShell(AssetAdministrationShell assetAdministrationShell) {
            this.assetAdministrationShell = assetAdministrationShell;
        }

        public String getAasIdentifier() {
            return this.aasIdentifier;
        }

        public AssetAdministrationShell getAssetAdministrationShell() {
            return this.assetAdministrationShell;
        }
    }  
    private static class PutAssetInformationParams implements BasyxTestValues {

        private String aasIdentifier;
        private AssetInformation assetInformation;
        @SuppressWarnings("unused")
        public void setAasIdentifier(String aasIdentifier) {
            this.aasIdentifier = aasIdentifier;
        }
        @SuppressWarnings("unused")
        public void setAssetInformation(AssetInformation assetInformation) {
            this.assetInformation = assetInformation;
        }

        public String getAasIdentifier() {
            return this.aasIdentifier;
        }

        public AssetInformation getAssetInformation() {
            return this.assetInformation;
        }
    }  
    private static class PutThumbnailParams implements BasyxTestValues {

        private String aasIdentifier;
        private String fileName;
        private File _file;
        @SuppressWarnings("unused")
        public void setAasIdentifier(String aasIdentifier) {
            this.aasIdentifier = aasIdentifier;
        }
        @SuppressWarnings("unused")
        public void setFileName(String fileName) {
            this.fileName = fileName;
        }
        @SuppressWarnings("unused")
        public void set_file(File _file) {
            this._file = _file;
        }

        public String getAasIdentifier() {
            return this.aasIdentifier;
        }

        public String getFileName() {
            return this.fileName;
        }

        public File get_file() {
            return this._file;
        }
    }  
}    
