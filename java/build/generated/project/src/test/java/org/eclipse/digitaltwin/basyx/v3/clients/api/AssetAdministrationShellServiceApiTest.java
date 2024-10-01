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
import org.eclipse.digitaltwin.aas4j.v3.model.BaseOperationResult;
import org.eclipse.digitaltwin.aas4j.v3.model.Environment;
import java.io.File;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part2.GetPathItemsResult;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part2.GetReferencesResult;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part2.GetSubmodelElementsMetadataResult;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part2.GetSubmodelElementsResult;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part2.GetSubmodelElementsValueResult;
import org.eclipse.digitaltwin.aas4j.v3.model.OperationRequest;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part2.OperationRequestValueOnly;
import org.eclipse.digitaltwin.aas4j.v3.model.OperationResult;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part2.OperationResultValueOnly;
import org.eclipse.digitaltwin.aas4j.v3.model.Reference;
import org.eclipse.digitaltwin.aas4j.v3.model.Result;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part2.ServiceDescription;
import org.eclipse.digitaltwin.aas4j.v3.model.Submodel;
import org.eclipse.digitaltwin.aas4j.v3.model.SubmodelElement;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part2.SubmodelElementMetadata;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part2.SubmodelElementValue;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part2.SubmodelMetadata;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part2.SubmodelValue;
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
 * API tests for AssetAdministrationShellServiceApi
 */
public class AssetAdministrationShellServiceApiTest {


    public AssetAdministrationShellServiceApiTest() {
    }

    private static String getPropertyOrThrow(String propName) {
    	String prop = System.getProperty(propName);
	    if (prop == null) {
	    	throw new IllegalArgumentException("Property '" + propName + "' not set.");
	    }
	    return prop;
    }

    
    @RunWith(Parameterized.class)
    public static class DeleteFileByPath extends AbstractBasyxTest {

        private AssetAdministrationShellServiceApi api;
        private final BasyxTestRunner runner;
        private final BasyxVoidTestDefinition<DeleteFileByPathParams> def;

        public DeleteFileByPath(String testName, BasyxVoidTestDefinition<DeleteFileByPathParams> def, BasyxTestRunner runner) {
            this.runner = runner;
            this.def = def;
        }

        @Before
        public void init() {
            this.api = new AssetAdministrationShellServiceApi(MAPPER, ENVIRONMENT.getAasServiceUrl());            
        }

        @Parameters(name="{0}")
        public static List<Object[]> initialize() {
            Path testFolder = Path.of(getPropertyOrThrow("basyxtest.folder"), "aas-service");
            ArrayList<Object[]> config = new ArrayList<>();
            BasyxTestRunner runner = new BasyxTestRunner(ENVIRONMENT, MAPPER, testFolder);
            List<BasyxVoidTestDefinition<DeleteFileByPathParams>> defs = runner.loadVoidTestDefinition("deleteFileByPath", DeleteFileByPathParams.class);
            for (BasyxVoidTestDefinition<DeleteFileByPathParams> eachDef : defs) {            
        	    config.add(new Object[] {eachDef.getName(), eachDef, runner});
            }            
        	return config;
        }

        /**
        * Deletes file content of an existing submodel element at a specified path within submodel elements hierarchy
        *
        * 
        *
        */
        @Test
        public void deleteFileByPathTest() throws ApiException {                
           runner.runAndAssertWithVoidResult(def, this::deleteFileByPath);            
        }
        
        private void deleteFileByPath(DeleteFileByPathParams params) throws ApiException {
            api.deleteFileByPath(params.getSubmodelIdentifier(), params.getIdShortPath());
        }
    }

    @RunWith(Parameterized.class)
    public static class DeleteSubmodelById extends AbstractBasyxTest {

        private AssetAdministrationShellServiceApi api;
        private final BasyxTestRunner runner;
        private final BasyxVoidTestDefinition<DeleteSubmodelByIdParams> def;

        public DeleteSubmodelById(String testName, BasyxVoidTestDefinition<DeleteSubmodelByIdParams> def, BasyxTestRunner runner) {
            this.runner = runner;
            this.def = def;
        }

        @Before
        public void init() {
            this.api = new AssetAdministrationShellServiceApi(MAPPER, ENVIRONMENT.getAasServiceUrl());            
        }

        @Parameters(name="{0}")
        public static List<Object[]> initialize() {
            Path testFolder = Path.of(getPropertyOrThrow("basyxtest.folder"), "aas-service");
            ArrayList<Object[]> config = new ArrayList<>();
            BasyxTestRunner runner = new BasyxTestRunner(ENVIRONMENT, MAPPER, testFolder);
            List<BasyxVoidTestDefinition<DeleteSubmodelByIdParams>> defs = runner.loadVoidTestDefinition("deleteSubmodelById", DeleteSubmodelByIdParams.class);
            for (BasyxVoidTestDefinition<DeleteSubmodelByIdParams> eachDef : defs) {            
        	    config.add(new Object[] {eachDef.getName(), eachDef, runner});
            }            
        	return config;
        }

        /**
        * Deletes the submodel from the Asset Administration Shell.
        *
        * 
        *
        */
        @Test
        public void deleteSubmodelByIdTest() throws ApiException {                
           runner.runAndAssertWithVoidResult(def, this::deleteSubmodelById);            
        }
        
        private void deleteSubmodelById(DeleteSubmodelByIdParams params) throws ApiException {
            api.deleteSubmodelById(params.getSubmodelIdentifier());
        }
    }

    @RunWith(Parameterized.class)
    public static class DeleteSubmodelElementByPath extends AbstractBasyxTest {

        private AssetAdministrationShellServiceApi api;
        private final BasyxTestRunner runner;
        private final BasyxVoidTestDefinition<DeleteSubmodelElementByPathParams> def;

        public DeleteSubmodelElementByPath(String testName, BasyxVoidTestDefinition<DeleteSubmodelElementByPathParams> def, BasyxTestRunner runner) {
            this.runner = runner;
            this.def = def;
        }

        @Before
        public void init() {
            this.api = new AssetAdministrationShellServiceApi(MAPPER, ENVIRONMENT.getAasServiceUrl());            
        }

        @Parameters(name="{0}")
        public static List<Object[]> initialize() {
            Path testFolder = Path.of(getPropertyOrThrow("basyxtest.folder"), "aas-service");
            ArrayList<Object[]> config = new ArrayList<>();
            BasyxTestRunner runner = new BasyxTestRunner(ENVIRONMENT, MAPPER, testFolder);
            List<BasyxVoidTestDefinition<DeleteSubmodelElementByPathParams>> defs = runner.loadVoidTestDefinition("deleteSubmodelElementByPath", DeleteSubmodelElementByPathParams.class);
            for (BasyxVoidTestDefinition<DeleteSubmodelElementByPathParams> eachDef : defs) {            
        	    config.add(new Object[] {eachDef.getName(), eachDef, runner});
            }            
        	return config;
        }

        /**
        * Deletes a submodel element at a specified path within the submodel elements hierarchy
        *
        * 
        *
        */
        @Test
        public void deleteSubmodelElementByPathTest() throws ApiException {                
           runner.runAndAssertWithVoidResult(def, this::deleteSubmodelElementByPath);            
        }
        
        private void deleteSubmodelElementByPath(DeleteSubmodelElementByPathParams params) throws ApiException {
            api.deleteSubmodelElementByPath(params.getSubmodelIdentifier(), params.getIdShortPath());
        }
    }

    @RunWith(Parameterized.class)
    public static class DeleteSubmodelReferenceById extends AbstractBasyxTest {

        private AssetAdministrationShellServiceApi api;
        private final BasyxTestRunner runner;
        private final BasyxVoidTestDefinition<DeleteSubmodelReferenceByIdParams> def;

        public DeleteSubmodelReferenceById(String testName, BasyxVoidTestDefinition<DeleteSubmodelReferenceByIdParams> def, BasyxTestRunner runner) {
            this.runner = runner;
            this.def = def;
        }

        @Before
        public void init() {
            this.api = new AssetAdministrationShellServiceApi(MAPPER, ENVIRONMENT.getAasServiceUrl());            
        }

        @Parameters(name="{0}")
        public static List<Object[]> initialize() {
            Path testFolder = Path.of(getPropertyOrThrow("basyxtest.folder"), "aas-service");
            ArrayList<Object[]> config = new ArrayList<>();
            BasyxTestRunner runner = new BasyxTestRunner(ENVIRONMENT, MAPPER, testFolder);
            List<BasyxVoidTestDefinition<DeleteSubmodelReferenceByIdParams>> defs = runner.loadVoidTestDefinition("deleteSubmodelReferenceById", DeleteSubmodelReferenceByIdParams.class);
            for (BasyxVoidTestDefinition<DeleteSubmodelReferenceByIdParams> eachDef : defs) {            
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
        public void deleteSubmodelReferenceByIdTest() throws ApiException {                
           runner.runAndAssertWithVoidResult(def, this::deleteSubmodelReferenceById);            
        }
        
        private void deleteSubmodelReferenceById(DeleteSubmodelReferenceByIdParams params) throws ApiException {
            api.deleteSubmodelReferenceById(params.getSubmodelIdentifier());
        }
    }

    @RunWith(Parameterized.class)
    public static class DeleteThumbnail extends AbstractBasyxTest {

        private AssetAdministrationShellServiceApi api;
        private final BasyxTestRunner runner;
        private final BasyxVoidTestDefinition<DeleteThumbnailParams> def;

        public DeleteThumbnail(String testName, BasyxVoidTestDefinition<DeleteThumbnailParams> def, BasyxTestRunner runner) {
            this.runner = runner;
            this.def = def;
        }

        @Before
        public void init() {
            this.api = new AssetAdministrationShellServiceApi(MAPPER, ENVIRONMENT.getAasServiceUrl());            
        }

        @Parameters(name="{0}")
        public static List<Object[]> initialize() {
            Path testFolder = Path.of(getPropertyOrThrow("basyxtest.folder"), "aas-service");
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
            api.deleteThumbnail();
        }
    }

    @RunWith(Parameterized.class)
    public static class GenerateSerializationByIds extends AbstractBasyxTest {

        private AssetAdministrationShellServiceApi api;
        private final BasyxTestRunner runner;
        private final BasyxFunctionalTestDefinition<GenerateSerializationByIdsParams, File> def;

        public GenerateSerializationByIds(String testName, BasyxFunctionalTestDefinition<GenerateSerializationByIdsParams, File> def, BasyxTestRunner runner) {
            this.runner = runner;
            this.def = def;
        }

        @Before
        public void init() {
            this.api = new AssetAdministrationShellServiceApi(MAPPER, ENVIRONMENT.getAasServiceUrl());            
        }

        @Parameters(name="{0}")
        public static List<Object[]> initialize() {
            Path testFolder = Path.of(getPropertyOrThrow("basyxtest.folder"), "aas-service");
            ArrayList<Object[]> config = new ArrayList<>();
            BasyxTestRunner runner = new BasyxTestRunner(ENVIRONMENT, MAPPER, testFolder);
            List<BasyxFunctionalTestDefinition<GenerateSerializationByIdsParams, File>> defs = runner.loadFunctionalTestDefinition("generateSerializationByIds", GenerateSerializationByIdsParams.class, File.class);
            for (BasyxFunctionalTestDefinition<GenerateSerializationByIdsParams, File> eachDef : defs) {            
        	    config.add(new Object[] {eachDef.getName(), eachDef, runner});
            }            
        	return config;
        }

        /**
        * Returns an appropriate serialization based on the specified format (see SerializationFormat)
        *
        * 
        *
        */
        @Test
        public void generateSerializationByIdsTest() throws ApiException {                
           runner.runAndAssertWithFunctionalResult(def, this::generateSerializationByIds);            
        }
        
        private File generateSerializationByIds(GenerateSerializationByIdsParams params) throws ApiException {
            return api.generateSerializationByIds(params.getAasIds(), params.getSubmodelIds(), params.getIncludeConceptDescriptions());
        }
    }

    @RunWith(Parameterized.class)
    public static class GetAllSubmodelElements extends AbstractBasyxTest {

        private AssetAdministrationShellServiceApi api;
        private final BasyxTestRunner runner;
        private final BasyxFunctionalTestDefinition<GetAllSubmodelElementsParams, GetSubmodelElementsResult> def;

        public GetAllSubmodelElements(String testName, BasyxFunctionalTestDefinition<GetAllSubmodelElementsParams, GetSubmodelElementsResult> def, BasyxTestRunner runner) {
            this.runner = runner;
            this.def = def;
        }

        @Before
        public void init() {
            this.api = new AssetAdministrationShellServiceApi(MAPPER, ENVIRONMENT.getAasServiceUrl());            
        }

        @Parameters(name="{0}")
        public static List<Object[]> initialize() {
            Path testFolder = Path.of(getPropertyOrThrow("basyxtest.folder"), "aas-service");
            ArrayList<Object[]> config = new ArrayList<>();
            BasyxTestRunner runner = new BasyxTestRunner(ENVIRONMENT, MAPPER, testFolder);
            List<BasyxFunctionalTestDefinition<GetAllSubmodelElementsParams, GetSubmodelElementsResult>> defs = runner.loadFunctionalTestDefinition("getAllSubmodelElements", GetAllSubmodelElementsParams.class, GetSubmodelElementsResult.class);
            for (BasyxFunctionalTestDefinition<GetAllSubmodelElementsParams, GetSubmodelElementsResult> eachDef : defs) {            
        	    config.add(new Object[] {eachDef.getName(), eachDef, runner});
            }            
        	return config;
        }

        /**
        * Returns all submodel elements including their hierarchy
        *
        * 
        *
        */
        @Test
        public void getAllSubmodelElementsTest() throws ApiException {                
           runner.runAndAssertWithFunctionalResult(def, this::getAllSubmodelElements);            
        }
        
        private GetSubmodelElementsResult getAllSubmodelElements(GetAllSubmodelElementsParams params) throws ApiException {
            return api.getAllSubmodelElements(params.getSubmodelIdentifier(), params.getLimit(), params.getCursor(), params.getLevel(), params.getExtent());
        }
    }

    @RunWith(Parameterized.class)
    public static class GetAllSubmodelElementsMetadata extends AbstractBasyxTest {

        private AssetAdministrationShellServiceApi api;
        private final BasyxTestRunner runner;
        private final BasyxFunctionalTestDefinition<GetAllSubmodelElementsMetadataParams, GetSubmodelElementsMetadataResult> def;

        public GetAllSubmodelElementsMetadata(String testName, BasyxFunctionalTestDefinition<GetAllSubmodelElementsMetadataParams, GetSubmodelElementsMetadataResult> def, BasyxTestRunner runner) {
            this.runner = runner;
            this.def = def;
        }

        @Before
        public void init() {
            this.api = new AssetAdministrationShellServiceApi(MAPPER, ENVIRONMENT.getAasServiceUrl());            
        }

        @Parameters(name="{0}")
        public static List<Object[]> initialize() {
            Path testFolder = Path.of(getPropertyOrThrow("basyxtest.folder"), "aas-service");
            ArrayList<Object[]> config = new ArrayList<>();
            BasyxTestRunner runner = new BasyxTestRunner(ENVIRONMENT, MAPPER, testFolder);
            List<BasyxFunctionalTestDefinition<GetAllSubmodelElementsMetadataParams, GetSubmodelElementsMetadataResult>> defs = runner.loadFunctionalTestDefinition("getAllSubmodelElementsMetadata", GetAllSubmodelElementsMetadataParams.class, GetSubmodelElementsMetadataResult.class);
            for (BasyxFunctionalTestDefinition<GetAllSubmodelElementsMetadataParams, GetSubmodelElementsMetadataResult> eachDef : defs) {            
        	    config.add(new Object[] {eachDef.getName(), eachDef, runner});
            }            
        	return config;
        }

        /**
        * Returns all submodel elements including their hierarchy
        *
        * 
        *
        */
        @Test
        public void getAllSubmodelElementsMetadataTest() throws ApiException {                
           runner.runAndAssertWithFunctionalResult(def, this::getAllSubmodelElementsMetadata);            
        }
        
        private GetSubmodelElementsMetadataResult getAllSubmodelElementsMetadata(GetAllSubmodelElementsMetadataParams params) throws ApiException {
            return api.getAllSubmodelElementsMetadata(params.getSubmodelIdentifier(), params.getLimit(), params.getCursor(), params.getLevel());
        }
    }

    @RunWith(Parameterized.class)
    public static class GetAllSubmodelElementsPath extends AbstractBasyxTest {

        private AssetAdministrationShellServiceApi api;
        private final BasyxTestRunner runner;
        private final BasyxFunctionalTestDefinition<GetAllSubmodelElementsPathParams, GetPathItemsResult> def;

        public GetAllSubmodelElementsPath(String testName, BasyxFunctionalTestDefinition<GetAllSubmodelElementsPathParams, GetPathItemsResult> def, BasyxTestRunner runner) {
            this.runner = runner;
            this.def = def;
        }

        @Before
        public void init() {
            this.api = new AssetAdministrationShellServiceApi(MAPPER, ENVIRONMENT.getAasServiceUrl());            
        }

        @Parameters(name="{0}")
        public static List<Object[]> initialize() {
            Path testFolder = Path.of(getPropertyOrThrow("basyxtest.folder"), "aas-service");
            ArrayList<Object[]> config = new ArrayList<>();
            BasyxTestRunner runner = new BasyxTestRunner(ENVIRONMENT, MAPPER, testFolder);
            List<BasyxFunctionalTestDefinition<GetAllSubmodelElementsPathParams, GetPathItemsResult>> defs = runner.loadFunctionalTestDefinition("getAllSubmodelElementsPath", GetAllSubmodelElementsPathParams.class, GetPathItemsResult.class);
            for (BasyxFunctionalTestDefinition<GetAllSubmodelElementsPathParams, GetPathItemsResult> eachDef : defs) {            
        	    config.add(new Object[] {eachDef.getName(), eachDef, runner});
            }            
        	return config;
        }

        /**
        * Returns all submodel elements including their hierarchy
        *
        * 
        *
        */
        @Test
        public void getAllSubmodelElementsPathTest() throws ApiException {                
           runner.runAndAssertWithFunctionalResult(def, this::getAllSubmodelElementsPath);            
        }
        
        private GetPathItemsResult getAllSubmodelElementsPath(GetAllSubmodelElementsPathParams params) throws ApiException {
            return api.getAllSubmodelElementsPath(params.getSubmodelIdentifier(), params.getLimit(), params.getCursor(), params.getLevel());
        }
    }

    @RunWith(Parameterized.class)
    public static class GetAllSubmodelElementsReference extends AbstractBasyxTest {

        private AssetAdministrationShellServiceApi api;
        private final BasyxTestRunner runner;
        private final BasyxFunctionalTestDefinition<GetAllSubmodelElementsReferenceParams, GetReferencesResult> def;

        public GetAllSubmodelElementsReference(String testName, BasyxFunctionalTestDefinition<GetAllSubmodelElementsReferenceParams, GetReferencesResult> def, BasyxTestRunner runner) {
            this.runner = runner;
            this.def = def;
        }

        @Before
        public void init() {
            this.api = new AssetAdministrationShellServiceApi(MAPPER, ENVIRONMENT.getAasServiceUrl());            
        }

        @Parameters(name="{0}")
        public static List<Object[]> initialize() {
            Path testFolder = Path.of(getPropertyOrThrow("basyxtest.folder"), "aas-service");
            ArrayList<Object[]> config = new ArrayList<>();
            BasyxTestRunner runner = new BasyxTestRunner(ENVIRONMENT, MAPPER, testFolder);
            List<BasyxFunctionalTestDefinition<GetAllSubmodelElementsReferenceParams, GetReferencesResult>> defs = runner.loadFunctionalTestDefinition("getAllSubmodelElementsReference", GetAllSubmodelElementsReferenceParams.class, GetReferencesResult.class);
            for (BasyxFunctionalTestDefinition<GetAllSubmodelElementsReferenceParams, GetReferencesResult> eachDef : defs) {            
        	    config.add(new Object[] {eachDef.getName(), eachDef, runner});
            }            
        	return config;
        }

        /**
        * Returns all submodel elements as a list of References
        *
        * 
        *
        */
        @Test
        public void getAllSubmodelElementsReferenceTest() throws ApiException {                
           runner.runAndAssertWithFunctionalResult(def, this::getAllSubmodelElementsReference);            
        }
        
        private GetReferencesResult getAllSubmodelElementsReference(GetAllSubmodelElementsReferenceParams params) throws ApiException {
            return api.getAllSubmodelElementsReference(params.getSubmodelIdentifier(), params.getLimit(), params.getCursor(), params.getLevel());
        }
    }

    @RunWith(Parameterized.class)
    public static class GetAllSubmodelElementsValueOnly extends AbstractBasyxTest {

        private AssetAdministrationShellServiceApi api;
        private final BasyxTestRunner runner;
        private final BasyxFunctionalTestDefinition<GetAllSubmodelElementsValueOnlyParams, GetSubmodelElementsValueResult> def;

        public GetAllSubmodelElementsValueOnly(String testName, BasyxFunctionalTestDefinition<GetAllSubmodelElementsValueOnlyParams, GetSubmodelElementsValueResult> def, BasyxTestRunner runner) {
            this.runner = runner;
            this.def = def;
        }

        @Before
        public void init() {
            this.api = new AssetAdministrationShellServiceApi(MAPPER, ENVIRONMENT.getAasServiceUrl());            
        }

        @Parameters(name="{0}")
        public static List<Object[]> initialize() {
            Path testFolder = Path.of(getPropertyOrThrow("basyxtest.folder"), "aas-service");
            ArrayList<Object[]> config = new ArrayList<>();
            BasyxTestRunner runner = new BasyxTestRunner(ENVIRONMENT, MAPPER, testFolder);
            List<BasyxFunctionalTestDefinition<GetAllSubmodelElementsValueOnlyParams, GetSubmodelElementsValueResult>> defs = runner.loadFunctionalTestDefinition("getAllSubmodelElementsValueOnly", GetAllSubmodelElementsValueOnlyParams.class, GetSubmodelElementsValueResult.class);
            for (BasyxFunctionalTestDefinition<GetAllSubmodelElementsValueOnlyParams, GetSubmodelElementsValueResult> eachDef : defs) {            
        	    config.add(new Object[] {eachDef.getName(), eachDef, runner});
            }            
        	return config;
        }

        /**
        * Returns all submodel elements including their hierarchy in the ValueOnly representation
        *
        * 
        *
        */
        @Test
        public void getAllSubmodelElementsValueOnlyTest() throws ApiException {                
           runner.runAndAssertWithFunctionalResult(def, this::getAllSubmodelElementsValueOnly);            
        }
        
        private GetSubmodelElementsValueResult getAllSubmodelElementsValueOnly(GetAllSubmodelElementsValueOnlyParams params) throws ApiException {
            return api.getAllSubmodelElementsValueOnly(params.getSubmodelIdentifier(), params.getLimit(), params.getCursor(), params.getLevel(), params.getExtent());
        }
    }

    @RunWith(Parameterized.class)
    public static class GetAllSubmodelReferences extends AbstractBasyxTest {

        private AssetAdministrationShellServiceApi api;
        private final BasyxTestRunner runner;
        private final BasyxFunctionalTestDefinition<GetAllSubmodelReferencesParams, GetReferencesResult> def;

        public GetAllSubmodelReferences(String testName, BasyxFunctionalTestDefinition<GetAllSubmodelReferencesParams, GetReferencesResult> def, BasyxTestRunner runner) {
            this.runner = runner;
            this.def = def;
        }

        @Before
        public void init() {
            this.api = new AssetAdministrationShellServiceApi(MAPPER, ENVIRONMENT.getAasServiceUrl());            
        }

        @Parameters(name="{0}")
        public static List<Object[]> initialize() {
            Path testFolder = Path.of(getPropertyOrThrow("basyxtest.folder"), "aas-service");
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
            return api.getAllSubmodelReferences(params.getLimit(), params.getCursor());
        }
    }

    @RunWith(Parameterized.class)
    public static class GetAssetAdministrationShell extends AbstractBasyxTest {

        private AssetAdministrationShellServiceApi api;
        private final BasyxTestRunner runner;
        private final BasyxFunctionalTestDefinition<GetAssetAdministrationShellParams, AssetAdministrationShell> def;

        public GetAssetAdministrationShell(String testName, BasyxFunctionalTestDefinition<GetAssetAdministrationShellParams, AssetAdministrationShell> def, BasyxTestRunner runner) {
            this.runner = runner;
            this.def = def;
        }

        @Before
        public void init() {
            this.api = new AssetAdministrationShellServiceApi(MAPPER, ENVIRONMENT.getAasServiceUrl());            
        }

        @Parameters(name="{0}")
        public static List<Object[]> initialize() {
            Path testFolder = Path.of(getPropertyOrThrow("basyxtest.folder"), "aas-service");
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
            return api.getAssetAdministrationShell();
        }
    }

    @RunWith(Parameterized.class)
    public static class GetAssetAdministrationShellReference extends AbstractBasyxTest {

        private AssetAdministrationShellServiceApi api;
        private final BasyxTestRunner runner;
        private final BasyxFunctionalTestDefinition<GetAssetAdministrationShellReferenceParams, Reference> def;

        public GetAssetAdministrationShellReference(String testName, BasyxFunctionalTestDefinition<GetAssetAdministrationShellReferenceParams, Reference> def, BasyxTestRunner runner) {
            this.runner = runner;
            this.def = def;
        }

        @Before
        public void init() {
            this.api = new AssetAdministrationShellServiceApi(MAPPER, ENVIRONMENT.getAasServiceUrl());            
        }

        @Parameters(name="{0}")
        public static List<Object[]> initialize() {
            Path testFolder = Path.of(getPropertyOrThrow("basyxtest.folder"), "aas-service");
            ArrayList<Object[]> config = new ArrayList<>();
            BasyxTestRunner runner = new BasyxTestRunner(ENVIRONMENT, MAPPER, testFolder);
            List<BasyxFunctionalTestDefinition<GetAssetAdministrationShellReferenceParams, Reference>> defs = runner.loadFunctionalTestDefinition("getAssetAdministrationShellReference", GetAssetAdministrationShellReferenceParams.class, Reference.class);
            for (BasyxFunctionalTestDefinition<GetAssetAdministrationShellReferenceParams, Reference> eachDef : defs) {            
        	    config.add(new Object[] {eachDef.getName(), eachDef, runner});
            }            
        	return config;
        }

        /**
        * Returns a specific Asset Administration Shell as a Reference
        *
        * 
        *
        */
        @Test
        public void getAssetAdministrationShellReferenceTest() throws ApiException {                
           runner.runAndAssertWithFunctionalResult(def, this::getAssetAdministrationShellReference);            
        }
        
        private Reference getAssetAdministrationShellReference(GetAssetAdministrationShellReferenceParams params) throws ApiException {
            return api.getAssetAdministrationShellReference();
        }
    }

    @RunWith(Parameterized.class)
    public static class GetAssetInformation extends AbstractBasyxTest {

        private AssetAdministrationShellServiceApi api;
        private final BasyxTestRunner runner;
        private final BasyxFunctionalTestDefinition<GetAssetInformationParams, AssetInformation> def;

        public GetAssetInformation(String testName, BasyxFunctionalTestDefinition<GetAssetInformationParams, AssetInformation> def, BasyxTestRunner runner) {
            this.runner = runner;
            this.def = def;
        }

        @Before
        public void init() {
            this.api = new AssetAdministrationShellServiceApi(MAPPER, ENVIRONMENT.getAasServiceUrl());            
        }

        @Parameters(name="{0}")
        public static List<Object[]> initialize() {
            Path testFolder = Path.of(getPropertyOrThrow("basyxtest.folder"), "aas-service");
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
            return api.getAssetInformation();
        }
    }

    @RunWith(Parameterized.class)
    public static class GetDescription extends AbstractBasyxTest {

        private AssetAdministrationShellServiceApi api;
        private final BasyxTestRunner runner;
        private final BasyxFunctionalTestDefinition<GetDescriptionParams, ServiceDescription> def;

        public GetDescription(String testName, BasyxFunctionalTestDefinition<GetDescriptionParams, ServiceDescription> def, BasyxTestRunner runner) {
            this.runner = runner;
            this.def = def;
        }

        @Before
        public void init() {
            this.api = new AssetAdministrationShellServiceApi(MAPPER, ENVIRONMENT.getAasServiceUrl());            
        }

        @Parameters(name="{0}")
        public static List<Object[]> initialize() {
            Path testFolder = Path.of(getPropertyOrThrow("basyxtest.folder"), "aas-service");
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
    public static class GetFileByPath extends AbstractBasyxTest {

        private AssetAdministrationShellServiceApi api;
        private final BasyxTestRunner runner;
        private final BasyxFunctionalTestDefinition<GetFileByPathParams, File> def;

        public GetFileByPath(String testName, BasyxFunctionalTestDefinition<GetFileByPathParams, File> def, BasyxTestRunner runner) {
            this.runner = runner;
            this.def = def;
        }

        @Before
        public void init() {
            this.api = new AssetAdministrationShellServiceApi(MAPPER, ENVIRONMENT.getAasServiceUrl());            
        }

        @Parameters(name="{0}")
        public static List<Object[]> initialize() {
            Path testFolder = Path.of(getPropertyOrThrow("basyxtest.folder"), "aas-service");
            ArrayList<Object[]> config = new ArrayList<>();
            BasyxTestRunner runner = new BasyxTestRunner(ENVIRONMENT, MAPPER, testFolder);
            List<BasyxFunctionalTestDefinition<GetFileByPathParams, File>> defs = runner.loadFunctionalTestDefinition("getFileByPath", GetFileByPathParams.class, File.class);
            for (BasyxFunctionalTestDefinition<GetFileByPathParams, File> eachDef : defs) {            
        	    config.add(new Object[] {eachDef.getName(), eachDef, runner});
            }            
        	return config;
        }

        /**
        * Downloads file content from a specific submodel element from the Submodel at a specified path
        *
        * 
        *
        */
        @Test
        public void getFileByPathTest() throws ApiException {                
           runner.runAndAssertWithFunctionalResult(def, this::getFileByPath);            
        }
        
        private File getFileByPath(GetFileByPathParams params) throws ApiException {
            return api.getFileByPath(params.getSubmodelIdentifier(), params.getIdShortPath());
        }
    }

    @RunWith(Parameterized.class)
    public static class GetOperationAsyncResult extends AbstractBasyxTest {

        private AssetAdministrationShellServiceApi api;
        private final BasyxTestRunner runner;
        private final BasyxFunctionalTestDefinition<GetOperationAsyncResultParams, OperationResult> def;

        public GetOperationAsyncResult(String testName, BasyxFunctionalTestDefinition<GetOperationAsyncResultParams, OperationResult> def, BasyxTestRunner runner) {
            this.runner = runner;
            this.def = def;
        }

        @Before
        public void init() {
            this.api = new AssetAdministrationShellServiceApi(MAPPER, ENVIRONMENT.getAasServiceUrl());            
        }

        @Parameters(name="{0}")
        public static List<Object[]> initialize() {
            Path testFolder = Path.of(getPropertyOrThrow("basyxtest.folder"), "aas-service");
            ArrayList<Object[]> config = new ArrayList<>();
            BasyxTestRunner runner = new BasyxTestRunner(ENVIRONMENT, MAPPER, testFolder);
            List<BasyxFunctionalTestDefinition<GetOperationAsyncResultParams, OperationResult>> defs = runner.loadFunctionalTestDefinition("getOperationAsyncResult", GetOperationAsyncResultParams.class, OperationResult.class);
            for (BasyxFunctionalTestDefinition<GetOperationAsyncResultParams, OperationResult> eachDef : defs) {            
        	    config.add(new Object[] {eachDef.getName(), eachDef, runner});
            }            
        	return config;
        }

        /**
        * Returns the Operation result of an asynchronous invoked Operation
        *
        * 
        *
        */
        @Test
        public void getOperationAsyncResultTest() throws ApiException {                
           runner.runAndAssertWithFunctionalResult(def, this::getOperationAsyncResult);            
        }
        
        private OperationResult getOperationAsyncResult(GetOperationAsyncResultParams params) throws ApiException {
            return api.getOperationAsyncResult(params.getSubmodelIdentifier(), params.getAasIdentifier(), params.getIdShortPath(), params.getHandleId());
        }
    }

    @RunWith(Parameterized.class)
    public static class GetOperationAsyncResultValueOnly extends AbstractBasyxTest {

        private AssetAdministrationShellServiceApi api;
        private final BasyxTestRunner runner;
        private final BasyxFunctionalTestDefinition<GetOperationAsyncResultValueOnlyParams, OperationResultValueOnly> def;

        public GetOperationAsyncResultValueOnly(String testName, BasyxFunctionalTestDefinition<GetOperationAsyncResultValueOnlyParams, OperationResultValueOnly> def, BasyxTestRunner runner) {
            this.runner = runner;
            this.def = def;
        }

        @Before
        public void init() {
            this.api = new AssetAdministrationShellServiceApi(MAPPER, ENVIRONMENT.getAasServiceUrl());            
        }

        @Parameters(name="{0}")
        public static List<Object[]> initialize() {
            Path testFolder = Path.of(getPropertyOrThrow("basyxtest.folder"), "aas-service");
            ArrayList<Object[]> config = new ArrayList<>();
            BasyxTestRunner runner = new BasyxTestRunner(ENVIRONMENT, MAPPER, testFolder);
            List<BasyxFunctionalTestDefinition<GetOperationAsyncResultValueOnlyParams, OperationResultValueOnly>> defs = runner.loadFunctionalTestDefinition("getOperationAsyncResultValueOnly", GetOperationAsyncResultValueOnlyParams.class, OperationResultValueOnly.class);
            for (BasyxFunctionalTestDefinition<GetOperationAsyncResultValueOnlyParams, OperationResultValueOnly> eachDef : defs) {            
        	    config.add(new Object[] {eachDef.getName(), eachDef, runner});
            }            
        	return config;
        }

        /**
        * Returns the value of the Operation result of an asynchronous invoked Operation
        *
        * 
        *
        */
        @Test
        public void getOperationAsyncResultValueOnlyTest() throws ApiException {                
           runner.runAndAssertWithFunctionalResult(def, this::getOperationAsyncResultValueOnly);            
        }
        
        private OperationResultValueOnly getOperationAsyncResultValueOnly(GetOperationAsyncResultValueOnlyParams params) throws ApiException {
            return api.getOperationAsyncResultValueOnly(params.getSubmodelIdentifier(), params.getAasIdentifier(), params.getIdShortPath(), params.getHandleId());
        }
    }

    @RunWith(Parameterized.class)
    public static class GetOperationAsyncStatus extends AbstractBasyxTest {

        private AssetAdministrationShellServiceApi api;
        private final BasyxTestRunner runner;
        private final BasyxFunctionalTestDefinition<GetOperationAsyncStatusParams, BaseOperationResult> def;

        public GetOperationAsyncStatus(String testName, BasyxFunctionalTestDefinition<GetOperationAsyncStatusParams, BaseOperationResult> def, BasyxTestRunner runner) {
            this.runner = runner;
            this.def = def;
        }

        @Before
        public void init() {
            this.api = new AssetAdministrationShellServiceApi(MAPPER, ENVIRONMENT.getAasServiceUrl());            
        }

        @Parameters(name="{0}")
        public static List<Object[]> initialize() {
            Path testFolder = Path.of(getPropertyOrThrow("basyxtest.folder"), "aas-service");
            ArrayList<Object[]> config = new ArrayList<>();
            BasyxTestRunner runner = new BasyxTestRunner(ENVIRONMENT, MAPPER, testFolder);
            List<BasyxFunctionalTestDefinition<GetOperationAsyncStatusParams, BaseOperationResult>> defs = runner.loadFunctionalTestDefinition("getOperationAsyncStatus", GetOperationAsyncStatusParams.class, BaseOperationResult.class);
            for (BasyxFunctionalTestDefinition<GetOperationAsyncStatusParams, BaseOperationResult> eachDef : defs) {            
        	    config.add(new Object[] {eachDef.getName(), eachDef, runner});
            }            
        	return config;
        }

        /**
        * Returns the status of an asynchronously invoked Operation
        *
        * 
        *
        */
        @Test
        public void getOperationAsyncStatusTest() throws ApiException {                
           runner.runAndAssertWithFunctionalResult(def, this::getOperationAsyncStatus);            
        }
        
        private BaseOperationResult getOperationAsyncStatus(GetOperationAsyncStatusParams params) throws ApiException {
            return api.getOperationAsyncStatus(params.getSubmodelIdentifier(), params.getAasIdentifier(), params.getIdShortPath(), params.getHandleId());
        }
    }

    @RunWith(Parameterized.class)
    public static class GetSubmodel extends AbstractBasyxTest {

        private AssetAdministrationShellServiceApi api;
        private final BasyxTestRunner runner;
        private final BasyxFunctionalTestDefinition<GetSubmodelParams, Submodel> def;

        public GetSubmodel(String testName, BasyxFunctionalTestDefinition<GetSubmodelParams, Submodel> def, BasyxTestRunner runner) {
            this.runner = runner;
            this.def = def;
        }

        @Before
        public void init() {
            this.api = new AssetAdministrationShellServiceApi(MAPPER, ENVIRONMENT.getAasServiceUrl());            
        }

        @Parameters(name="{0}")
        public static List<Object[]> initialize() {
            Path testFolder = Path.of(getPropertyOrThrow("basyxtest.folder"), "aas-service");
            ArrayList<Object[]> config = new ArrayList<>();
            BasyxTestRunner runner = new BasyxTestRunner(ENVIRONMENT, MAPPER, testFolder);
            List<BasyxFunctionalTestDefinition<GetSubmodelParams, Submodel>> defs = runner.loadFunctionalTestDefinition("getSubmodel", GetSubmodelParams.class, Submodel.class);
            for (BasyxFunctionalTestDefinition<GetSubmodelParams, Submodel> eachDef : defs) {            
        	    config.add(new Object[] {eachDef.getName(), eachDef, runner});
            }            
        	return config;
        }

        /**
        * Returns the Submodel
        *
        * 
        *
        */
        @Test
        public void getSubmodelTest() throws ApiException {                
           runner.runAndAssertWithFunctionalResult(def, this::getSubmodel);            
        }
        
        private Submodel getSubmodel(GetSubmodelParams params) throws ApiException {
            return api.getSubmodel(params.getSubmodelIdentifier(), params.getLevel(), params.getExtent());
        }
    }

    @RunWith(Parameterized.class)
    public static class GetSubmodelElementByPath extends AbstractBasyxTest {

        private AssetAdministrationShellServiceApi api;
        private final BasyxTestRunner runner;
        private final BasyxFunctionalTestDefinition<GetSubmodelElementByPathParams, SubmodelElement> def;

        public GetSubmodelElementByPath(String testName, BasyxFunctionalTestDefinition<GetSubmodelElementByPathParams, SubmodelElement> def, BasyxTestRunner runner) {
            this.runner = runner;
            this.def = def;
        }

        @Before
        public void init() {
            this.api = new AssetAdministrationShellServiceApi(MAPPER, ENVIRONMENT.getAasServiceUrl());            
        }

        @Parameters(name="{0}")
        public static List<Object[]> initialize() {
            Path testFolder = Path.of(getPropertyOrThrow("basyxtest.folder"), "aas-service");
            ArrayList<Object[]> config = new ArrayList<>();
            BasyxTestRunner runner = new BasyxTestRunner(ENVIRONMENT, MAPPER, testFolder);
            List<BasyxFunctionalTestDefinition<GetSubmodelElementByPathParams, SubmodelElement>> defs = runner.loadFunctionalTestDefinition("getSubmodelElementByPath", GetSubmodelElementByPathParams.class, SubmodelElement.class);
            for (BasyxFunctionalTestDefinition<GetSubmodelElementByPathParams, SubmodelElement> eachDef : defs) {            
        	    config.add(new Object[] {eachDef.getName(), eachDef, runner});
            }            
        	return config;
        }

        /**
        * Returns a specific submodel element from the Submodel at a specified path
        *
        * 
        *
        */
        @Test
        public void getSubmodelElementByPathTest() throws ApiException {                
           runner.runAndAssertWithFunctionalResult(def, this::getSubmodelElementByPath);            
        }
        
        private SubmodelElement getSubmodelElementByPath(GetSubmodelElementByPathParams params) throws ApiException {
            return api.getSubmodelElementByPath(params.getSubmodelIdentifier(), params.getIdShortPath(), params.getLevel(), params.getExtent());
        }
    }

    @RunWith(Parameterized.class)
    public static class GetSubmodelElementByPathMetadata extends AbstractBasyxTest {

        private AssetAdministrationShellServiceApi api;
        private final BasyxTestRunner runner;
        private final BasyxFunctionalTestDefinition<GetSubmodelElementByPathMetadataParams, SubmodelElementMetadata> def;

        public GetSubmodelElementByPathMetadata(String testName, BasyxFunctionalTestDefinition<GetSubmodelElementByPathMetadataParams, SubmodelElementMetadata> def, BasyxTestRunner runner) {
            this.runner = runner;
            this.def = def;
        }

        @Before
        public void init() {
            this.api = new AssetAdministrationShellServiceApi(MAPPER, ENVIRONMENT.getAasServiceUrl());            
        }

        @Parameters(name="{0}")
        public static List<Object[]> initialize() {
            Path testFolder = Path.of(getPropertyOrThrow("basyxtest.folder"), "aas-service");
            ArrayList<Object[]> config = new ArrayList<>();
            BasyxTestRunner runner = new BasyxTestRunner(ENVIRONMENT, MAPPER, testFolder);
            List<BasyxFunctionalTestDefinition<GetSubmodelElementByPathMetadataParams, SubmodelElementMetadata>> defs = runner.loadFunctionalTestDefinition("getSubmodelElementByPathMetadata", GetSubmodelElementByPathMetadataParams.class, SubmodelElementMetadata.class);
            for (BasyxFunctionalTestDefinition<GetSubmodelElementByPathMetadataParams, SubmodelElementMetadata> eachDef : defs) {            
        	    config.add(new Object[] {eachDef.getName(), eachDef, runner});
            }            
        	return config;
        }

        /**
        * Returns the metadata attributes if a specific submodel element from the Submodel at a specified path
        *
        * 
        *
        */
        @Test
        public void getSubmodelElementByPathMetadataTest() throws ApiException {                
           runner.runAndAssertWithFunctionalResult(def, this::getSubmodelElementByPathMetadata);            
        }
        
        private SubmodelElementMetadata getSubmodelElementByPathMetadata(GetSubmodelElementByPathMetadataParams params) throws ApiException {
            return api.getSubmodelElementByPathMetadata(params.getSubmodelIdentifier(), params.getIdShortPath(), params.getLevel());
        }
    }

    @RunWith(Parameterized.class)
    public static class GetSubmodelElementByPathPath extends AbstractBasyxTest {

        private AssetAdministrationShellServiceApi api;
        private final BasyxTestRunner runner;
        private final BasyxFunctionalTestDefinition<GetSubmodelElementByPathPathParams, String> def;

        public GetSubmodelElementByPathPath(String testName, BasyxFunctionalTestDefinition<GetSubmodelElementByPathPathParams, String> def, BasyxTestRunner runner) {
            this.runner = runner;
            this.def = def;
        }

        @Before
        public void init() {
            this.api = new AssetAdministrationShellServiceApi(MAPPER, ENVIRONMENT.getAasServiceUrl());            
        }

        @Parameters(name="{0}")
        public static List<Object[]> initialize() {
            Path testFolder = Path.of(getPropertyOrThrow("basyxtest.folder"), "aas-service");
            ArrayList<Object[]> config = new ArrayList<>();
            BasyxTestRunner runner = new BasyxTestRunner(ENVIRONMENT, MAPPER, testFolder);
            List<BasyxFunctionalTestDefinition<GetSubmodelElementByPathPathParams, String>> defs = runner.loadFunctionalTestDefinition("getSubmodelElementByPathPath", GetSubmodelElementByPathPathParams.class, String.class);
            for (BasyxFunctionalTestDefinition<GetSubmodelElementByPathPathParams, String> eachDef : defs) {            
        	    config.add(new Object[] {eachDef.getName(), eachDef, runner});
            }            
        	return config;
        }

        /**
        * Returns a specific submodel element from the Submodel at a specified path in the Path notation
        *
        * 
        *
        */
        @Test
        public void getSubmodelElementByPathPathTest() throws ApiException {                
           runner.runAndAssertWithFunctionalResult(def, this::getSubmodelElementByPathPath);            
        }
        
        private String getSubmodelElementByPathPath(GetSubmodelElementByPathPathParams params) throws ApiException {
            return api.getSubmodelElementByPathPath(params.getSubmodelIdentifier(), params.getIdShortPath(), params.getLevel());
        }
    }

    @RunWith(Parameterized.class)
    public static class GetSubmodelElementByPathReference extends AbstractBasyxTest {

        private AssetAdministrationShellServiceApi api;
        private final BasyxTestRunner runner;
        private final BasyxFunctionalTestDefinition<GetSubmodelElementByPathReferenceParams, Reference> def;

        public GetSubmodelElementByPathReference(String testName, BasyxFunctionalTestDefinition<GetSubmodelElementByPathReferenceParams, Reference> def, BasyxTestRunner runner) {
            this.runner = runner;
            this.def = def;
        }

        @Before
        public void init() {
            this.api = new AssetAdministrationShellServiceApi(MAPPER, ENVIRONMENT.getAasServiceUrl());            
        }

        @Parameters(name="{0}")
        public static List<Object[]> initialize() {
            Path testFolder = Path.of(getPropertyOrThrow("basyxtest.folder"), "aas-service");
            ArrayList<Object[]> config = new ArrayList<>();
            BasyxTestRunner runner = new BasyxTestRunner(ENVIRONMENT, MAPPER, testFolder);
            List<BasyxFunctionalTestDefinition<GetSubmodelElementByPathReferenceParams, Reference>> defs = runner.loadFunctionalTestDefinition("getSubmodelElementByPathReference", GetSubmodelElementByPathReferenceParams.class, Reference.class);
            for (BasyxFunctionalTestDefinition<GetSubmodelElementByPathReferenceParams, Reference> eachDef : defs) {            
        	    config.add(new Object[] {eachDef.getName(), eachDef, runner});
            }            
        	return config;
        }

        /**
        * Returns the Reference of a specific submodel element from the Submodel at a specified path in the ValueOnly representation
        *
        * 
        *
        */
        @Test
        public void getSubmodelElementByPathReferenceTest() throws ApiException {                
           runner.runAndAssertWithFunctionalResult(def, this::getSubmodelElementByPathReference);            
        }
        
        private Reference getSubmodelElementByPathReference(GetSubmodelElementByPathReferenceParams params) throws ApiException {
            return api.getSubmodelElementByPathReference(params.getSubmodelIdentifier(), params.getIdShortPath());
        }
    }

    @RunWith(Parameterized.class)
    public static class GetSubmodelElementByPathValueOnly extends AbstractBasyxTest {

        private AssetAdministrationShellServiceApi api;
        private final BasyxTestRunner runner;
        private final BasyxFunctionalTestDefinition<GetSubmodelElementByPathValueOnlyParams, SubmodelElementValue> def;

        public GetSubmodelElementByPathValueOnly(String testName, BasyxFunctionalTestDefinition<GetSubmodelElementByPathValueOnlyParams, SubmodelElementValue> def, BasyxTestRunner runner) {
            this.runner = runner;
            this.def = def;
        }

        @Before
        public void init() {
            this.api = new AssetAdministrationShellServiceApi(MAPPER, ENVIRONMENT.getAasServiceUrl());            
        }

        @Parameters(name="{0}")
        public static List<Object[]> initialize() {
            Path testFolder = Path.of(getPropertyOrThrow("basyxtest.folder"), "aas-service");
            ArrayList<Object[]> config = new ArrayList<>();
            BasyxTestRunner runner = new BasyxTestRunner(ENVIRONMENT, MAPPER, testFolder);
            List<BasyxFunctionalTestDefinition<GetSubmodelElementByPathValueOnlyParams, SubmodelElementValue>> defs = runner.loadFunctionalTestDefinition("getSubmodelElementByPathValueOnly", GetSubmodelElementByPathValueOnlyParams.class, SubmodelElementValue.class);
            for (BasyxFunctionalTestDefinition<GetSubmodelElementByPathValueOnlyParams, SubmodelElementValue> eachDef : defs) {            
        	    config.add(new Object[] {eachDef.getName(), eachDef, runner});
            }            
        	return config;
        }

        /**
        * Returns a specific submodel element from the Submodel at a specified path in the ValueOnly representation
        *
        * 
        *
        */
        @Test
        public void getSubmodelElementByPathValueOnlyTest() throws ApiException {                
           runner.runAndAssertWithFunctionalResult(def, this::getSubmodelElementByPathValueOnly);            
        }
        
        private SubmodelElementValue getSubmodelElementByPathValueOnly(GetSubmodelElementByPathValueOnlyParams params) throws ApiException {
            return api.getSubmodelElementByPathValueOnly(params.getSubmodelIdentifier(), params.getIdShortPath(), params.getLevel());
        }
    }

    @RunWith(Parameterized.class)
    public static class GetSubmodelMetadata extends AbstractBasyxTest {

        private AssetAdministrationShellServiceApi api;
        private final BasyxTestRunner runner;
        private final BasyxFunctionalTestDefinition<GetSubmodelMetadataParams, SubmodelMetadata> def;

        public GetSubmodelMetadata(String testName, BasyxFunctionalTestDefinition<GetSubmodelMetadataParams, SubmodelMetadata> def, BasyxTestRunner runner) {
            this.runner = runner;
            this.def = def;
        }

        @Before
        public void init() {
            this.api = new AssetAdministrationShellServiceApi(MAPPER, ENVIRONMENT.getAasServiceUrl());            
        }

        @Parameters(name="{0}")
        public static List<Object[]> initialize() {
            Path testFolder = Path.of(getPropertyOrThrow("basyxtest.folder"), "aas-service");
            ArrayList<Object[]> config = new ArrayList<>();
            BasyxTestRunner runner = new BasyxTestRunner(ENVIRONMENT, MAPPER, testFolder);
            List<BasyxFunctionalTestDefinition<GetSubmodelMetadataParams, SubmodelMetadata>> defs = runner.loadFunctionalTestDefinition("getSubmodelMetadata", GetSubmodelMetadataParams.class, SubmodelMetadata.class);
            for (BasyxFunctionalTestDefinition<GetSubmodelMetadataParams, SubmodelMetadata> eachDef : defs) {            
        	    config.add(new Object[] {eachDef.getName(), eachDef, runner});
            }            
        	return config;
        }

        /**
        * Returns the Submodel&#39;s metadata elements
        *
        * 
        *
        */
        @Test
        public void getSubmodelMetadataTest() throws ApiException {                
           runner.runAndAssertWithFunctionalResult(def, this::getSubmodelMetadata);            
        }
        
        private SubmodelMetadata getSubmodelMetadata(GetSubmodelMetadataParams params) throws ApiException {
            return api.getSubmodelMetadata(params.getSubmodelIdentifier(), params.getLevel());
        }
    }

    @RunWith(Parameterized.class)
    public static class GetSubmodelMetadataReference extends AbstractBasyxTest {

        private AssetAdministrationShellServiceApi api;
        private final BasyxTestRunner runner;
        private final BasyxFunctionalTestDefinition<GetSubmodelMetadataReferenceParams, Reference> def;

        public GetSubmodelMetadataReference(String testName, BasyxFunctionalTestDefinition<GetSubmodelMetadataReferenceParams, Reference> def, BasyxTestRunner runner) {
            this.runner = runner;
            this.def = def;
        }

        @Before
        public void init() {
            this.api = new AssetAdministrationShellServiceApi(MAPPER, ENVIRONMENT.getAasServiceUrl());            
        }

        @Parameters(name="{0}")
        public static List<Object[]> initialize() {
            Path testFolder = Path.of(getPropertyOrThrow("basyxtest.folder"), "aas-service");
            ArrayList<Object[]> config = new ArrayList<>();
            BasyxTestRunner runner = new BasyxTestRunner(ENVIRONMENT, MAPPER, testFolder);
            List<BasyxFunctionalTestDefinition<GetSubmodelMetadataReferenceParams, Reference>> defs = runner.loadFunctionalTestDefinition("getSubmodelMetadataReference", GetSubmodelMetadataReferenceParams.class, Reference.class);
            for (BasyxFunctionalTestDefinition<GetSubmodelMetadataReferenceParams, Reference> eachDef : defs) {            
        	    config.add(new Object[] {eachDef.getName(), eachDef, runner});
            }            
        	return config;
        }

        /**
        * Returns the Submodel as a Reference
        *
        * 
        *
        */
        @Test
        public void getSubmodelMetadataReferenceTest() throws ApiException {                
           runner.runAndAssertWithFunctionalResult(def, this::getSubmodelMetadataReference);            
        }
        
        private Reference getSubmodelMetadataReference(GetSubmodelMetadataReferenceParams params) throws ApiException {
            return api.getSubmodelMetadataReference(params.getSubmodelIdentifier(), params.getLevel());
        }
    }

    @RunWith(Parameterized.class)
    public static class GetSubmodelPath extends AbstractBasyxTest {

        private AssetAdministrationShellServiceApi api;
        private final BasyxTestRunner runner;
        private final BasyxListTestDefinition<GetSubmodelPathParams, String> def;

        public GetSubmodelPath(String testName, BasyxListTestDefinition<GetSubmodelPathParams, String> def, BasyxTestRunner runner) {
            this.runner = runner;
            this.def = def;
        }

        @Before
        public void init() {
            this.api = new AssetAdministrationShellServiceApi(MAPPER, ENVIRONMENT.getAasServiceUrl());            
        }

        @Parameters(name="{0}")
        public static List<Object[]> initialize() {
            Path testFolder = Path.of(getPropertyOrThrow("basyxtest.folder"), "aas-service");
            ArrayList<Object[]> config = new ArrayList<>();
            BasyxTestRunner runner = new BasyxTestRunner(ENVIRONMENT, MAPPER, testFolder);
            List<BasyxListTestDefinition<GetSubmodelPathParams, String>> defs = runner.loadListTestDefinition("getSubmodelPath", GetSubmodelPathParams.class, String.class);
            for (BasyxListTestDefinition<GetSubmodelPathParams, String> eachDef : defs) {            
        	    config.add(new Object[] {eachDef.getName(), eachDef, runner});
            }            
        	return config;
        }

        /**
        * Returns the Submodel&#39;s metadata elements
        *
        * 
        *
        */
        @Test
        public void getSubmodelPathTest() throws ApiException {                
           runner.runAndAssertWithListResult(def, this::getSubmodelPath);            
        }
        
        private List<String> getSubmodelPath(GetSubmodelPathParams params) throws ApiException {
            return api.getSubmodelPath(params.getSubmodelIdentifier(), params.getLevel());
        }
    }

    @RunWith(Parameterized.class)
    public static class GetSubmodelValueOnly extends AbstractBasyxTest {

        private AssetAdministrationShellServiceApi api;
        private final BasyxTestRunner runner;
        private final BasyxFunctionalTestDefinition<GetSubmodelValueOnlyParams, SubmodelValue> def;

        public GetSubmodelValueOnly(String testName, BasyxFunctionalTestDefinition<GetSubmodelValueOnlyParams, SubmodelValue> def, BasyxTestRunner runner) {
            this.runner = runner;
            this.def = def;
        }

        @Before
        public void init() {
            this.api = new AssetAdministrationShellServiceApi(MAPPER, ENVIRONMENT.getAasServiceUrl());            
        }

        @Parameters(name="{0}")
        public static List<Object[]> initialize() {
            Path testFolder = Path.of(getPropertyOrThrow("basyxtest.folder"), "aas-service");
            ArrayList<Object[]> config = new ArrayList<>();
            BasyxTestRunner runner = new BasyxTestRunner(ENVIRONMENT, MAPPER, testFolder);
            List<BasyxFunctionalTestDefinition<GetSubmodelValueOnlyParams, SubmodelValue>> defs = runner.loadFunctionalTestDefinition("getSubmodelValueOnly", GetSubmodelValueOnlyParams.class, SubmodelValue.class);
            for (BasyxFunctionalTestDefinition<GetSubmodelValueOnlyParams, SubmodelValue> eachDef : defs) {            
        	    config.add(new Object[] {eachDef.getName(), eachDef, runner});
            }            
        	return config;
        }

        /**
        * Returns the Submodel&#39;s ValueOnly representation
        *
        * 
        *
        */
        @Test
        public void getSubmodelValueOnlyTest() throws ApiException {                
           runner.runAndAssertWithFunctionalResult(def, this::getSubmodelValueOnly);            
        }
        
        private SubmodelValue getSubmodelValueOnly(GetSubmodelValueOnlyParams params) throws ApiException {
            return api.getSubmodelValueOnly(params.getSubmodelIdentifier(), params.getLevel(), params.getExtent());
        }
    }

    @RunWith(Parameterized.class)
    public static class GetThumbnail extends AbstractBasyxTest {

        private AssetAdministrationShellServiceApi api;
        private final BasyxTestRunner runner;
        private final BasyxFunctionalTestDefinition<GetThumbnailParams, File> def;

        public GetThumbnail(String testName, BasyxFunctionalTestDefinition<GetThumbnailParams, File> def, BasyxTestRunner runner) {
            this.runner = runner;
            this.def = def;
        }

        @Before
        public void init() {
            this.api = new AssetAdministrationShellServiceApi(MAPPER, ENVIRONMENT.getAasServiceUrl());            
        }

        @Parameters(name="{0}")
        public static List<Object[]> initialize() {
            Path testFolder = Path.of(getPropertyOrThrow("basyxtest.folder"), "aas-service");
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
            return api.getThumbnail();
        }
    }

    @RunWith(Parameterized.class)
    public static class InvokeOperationAsync extends AbstractBasyxTest {

        private AssetAdministrationShellServiceApi api;
        private final BasyxTestRunner runner;
        private final BasyxVoidTestDefinition<InvokeOperationAsyncParams> def;

        public InvokeOperationAsync(String testName, BasyxVoidTestDefinition<InvokeOperationAsyncParams> def, BasyxTestRunner runner) {
            this.runner = runner;
            this.def = def;
        }

        @Before
        public void init() {
            this.api = new AssetAdministrationShellServiceApi(MAPPER, ENVIRONMENT.getAasServiceUrl());            
        }

        @Parameters(name="{0}")
        public static List<Object[]> initialize() {
            Path testFolder = Path.of(getPropertyOrThrow("basyxtest.folder"), "aas-service");
            ArrayList<Object[]> config = new ArrayList<>();
            BasyxTestRunner runner = new BasyxTestRunner(ENVIRONMENT, MAPPER, testFolder);
            List<BasyxVoidTestDefinition<InvokeOperationAsyncParams>> defs = runner.loadVoidTestDefinition("invokeOperationAsync", InvokeOperationAsyncParams.class);
            for (BasyxVoidTestDefinition<InvokeOperationAsyncParams> eachDef : defs) {            
        	    config.add(new Object[] {eachDef.getName(), eachDef, runner});
            }            
        	return config;
        }

        /**
        * Asynchronously invokes an Operation at a specified path
        *
        * 
        *
        */
        @Test
        public void invokeOperationAsyncTest() throws ApiException {                
           runner.runAndAssertWithVoidResult(def, this::invokeOperationAsync);            
        }
        
        private void invokeOperationAsync(InvokeOperationAsyncParams params) throws ApiException {
            api.invokeOperationAsync(params.getSubmodelIdentifier(), params.getIdShortPath(), params.getOperationRequest());
        }
    }

    @RunWith(Parameterized.class)
    public static class InvokeOperationAsyncValueOnly extends AbstractBasyxTest {

        private AssetAdministrationShellServiceApi api;
        private final BasyxTestRunner runner;
        private final BasyxVoidTestDefinition<InvokeOperationAsyncValueOnlyParams> def;

        public InvokeOperationAsyncValueOnly(String testName, BasyxVoidTestDefinition<InvokeOperationAsyncValueOnlyParams> def, BasyxTestRunner runner) {
            this.runner = runner;
            this.def = def;
        }

        @Before
        public void init() {
            this.api = new AssetAdministrationShellServiceApi(MAPPER, ENVIRONMENT.getAasServiceUrl());            
        }

        @Parameters(name="{0}")
        public static List<Object[]> initialize() {
            Path testFolder = Path.of(getPropertyOrThrow("basyxtest.folder"), "aas-service");
            ArrayList<Object[]> config = new ArrayList<>();
            BasyxTestRunner runner = new BasyxTestRunner(ENVIRONMENT, MAPPER, testFolder);
            List<BasyxVoidTestDefinition<InvokeOperationAsyncValueOnlyParams>> defs = runner.loadVoidTestDefinition("invokeOperationAsyncValueOnly", InvokeOperationAsyncValueOnlyParams.class);
            for (BasyxVoidTestDefinition<InvokeOperationAsyncValueOnlyParams> eachDef : defs) {            
        	    config.add(new Object[] {eachDef.getName(), eachDef, runner});
            }            
        	return config;
        }

        /**
        * Asynchronously invokes an Operation at a specified path
        *
        * 
        *
        */
        @Test
        public void invokeOperationAsyncValueOnlyTest() throws ApiException {                
           runner.runAndAssertWithVoidResult(def, this::invokeOperationAsyncValueOnly);            
        }
        
        private void invokeOperationAsyncValueOnly(InvokeOperationAsyncValueOnlyParams params) throws ApiException {
            api.invokeOperationAsyncValueOnly(params.getSubmodelIdentifier(), params.getIdShortPath(), params.getOperationRequestValueOnly());
        }
    }

    @RunWith(Parameterized.class)
    public static class InvokeOperationSync extends AbstractBasyxTest {

        private AssetAdministrationShellServiceApi api;
        private final BasyxTestRunner runner;
        private final BasyxFunctionalTestDefinition<InvokeOperationSyncParams, OperationResult> def;

        public InvokeOperationSync(String testName, BasyxFunctionalTestDefinition<InvokeOperationSyncParams, OperationResult> def, BasyxTestRunner runner) {
            this.runner = runner;
            this.def = def;
        }

        @Before
        public void init() {
            this.api = new AssetAdministrationShellServiceApi(MAPPER, ENVIRONMENT.getAasServiceUrl());            
        }

        @Parameters(name="{0}")
        public static List<Object[]> initialize() {
            Path testFolder = Path.of(getPropertyOrThrow("basyxtest.folder"), "aas-service");
            ArrayList<Object[]> config = new ArrayList<>();
            BasyxTestRunner runner = new BasyxTestRunner(ENVIRONMENT, MAPPER, testFolder);
            List<BasyxFunctionalTestDefinition<InvokeOperationSyncParams, OperationResult>> defs = runner.loadFunctionalTestDefinition("invokeOperationSync", InvokeOperationSyncParams.class, OperationResult.class);
            for (BasyxFunctionalTestDefinition<InvokeOperationSyncParams, OperationResult> eachDef : defs) {            
        	    config.add(new Object[] {eachDef.getName(), eachDef, runner});
            }            
        	return config;
        }

        /**
        * Synchronously invokes an Operation at a specified path
        *
        * 
        *
        */
        @Test
        public void invokeOperationSyncTest() throws ApiException {                
           runner.runAndAssertWithFunctionalResult(def, this::invokeOperationSync);            
        }
        
        private OperationResult invokeOperationSync(InvokeOperationSyncParams params) throws ApiException {
            return api.invokeOperationSync(params.getSubmodelIdentifier(), params.getIdShortPath(), params.getOperationRequest());
        }
    }

    @RunWith(Parameterized.class)
    public static class InvokeOperationSyncValueOnly extends AbstractBasyxTest {

        private AssetAdministrationShellServiceApi api;
        private final BasyxTestRunner runner;
        private final BasyxFunctionalTestDefinition<InvokeOperationSyncValueOnlyParams, OperationResultValueOnly> def;

        public InvokeOperationSyncValueOnly(String testName, BasyxFunctionalTestDefinition<InvokeOperationSyncValueOnlyParams, OperationResultValueOnly> def, BasyxTestRunner runner) {
            this.runner = runner;
            this.def = def;
        }

        @Before
        public void init() {
            this.api = new AssetAdministrationShellServiceApi(MAPPER, ENVIRONMENT.getAasServiceUrl());            
        }

        @Parameters(name="{0}")
        public static List<Object[]> initialize() {
            Path testFolder = Path.of(getPropertyOrThrow("basyxtest.folder"), "aas-service");
            ArrayList<Object[]> config = new ArrayList<>();
            BasyxTestRunner runner = new BasyxTestRunner(ENVIRONMENT, MAPPER, testFolder);
            List<BasyxFunctionalTestDefinition<InvokeOperationSyncValueOnlyParams, OperationResultValueOnly>> defs = runner.loadFunctionalTestDefinition("invokeOperationSyncValueOnly", InvokeOperationSyncValueOnlyParams.class, OperationResultValueOnly.class);
            for (BasyxFunctionalTestDefinition<InvokeOperationSyncValueOnlyParams, OperationResultValueOnly> eachDef : defs) {            
        	    config.add(new Object[] {eachDef.getName(), eachDef, runner});
            }            
        	return config;
        }

        /**
        * Synchronously invokes an Operation at a specified path
        *
        * 
        *
        */
        @Test
        public void invokeOperationSyncValueOnlyTest() throws ApiException {                
           runner.runAndAssertWithFunctionalResult(def, this::invokeOperationSyncValueOnly);            
        }
        
        private OperationResultValueOnly invokeOperationSyncValueOnly(InvokeOperationSyncValueOnlyParams params) throws ApiException {
            return api.invokeOperationSyncValueOnly(params.getSubmodelIdentifier(), params.getIdShortPath(), params.getOperationRequestValueOnly());
        }
    }

    @RunWith(Parameterized.class)
    public static class PatchSubmodel extends AbstractBasyxTest {

        private AssetAdministrationShellServiceApi api;
        private final BasyxTestRunner runner;
        private final BasyxVoidTestDefinition<PatchSubmodelParams> def;

        public PatchSubmodel(String testName, BasyxVoidTestDefinition<PatchSubmodelParams> def, BasyxTestRunner runner) {
            this.runner = runner;
            this.def = def;
        }

        @Before
        public void init() {
            this.api = new AssetAdministrationShellServiceApi(MAPPER, ENVIRONMENT.getAasServiceUrl());            
        }

        @Parameters(name="{0}")
        public static List<Object[]> initialize() {
            Path testFolder = Path.of(getPropertyOrThrow("basyxtest.folder"), "aas-service");
            ArrayList<Object[]> config = new ArrayList<>();
            BasyxTestRunner runner = new BasyxTestRunner(ENVIRONMENT, MAPPER, testFolder);
            List<BasyxVoidTestDefinition<PatchSubmodelParams>> defs = runner.loadVoidTestDefinition("patchSubmodel", PatchSubmodelParams.class);
            for (BasyxVoidTestDefinition<PatchSubmodelParams> eachDef : defs) {            
        	    config.add(new Object[] {eachDef.getName(), eachDef, runner});
            }            
        	return config;
        }

        /**
        * Updates the Submodel
        *
        * 
        *
        */
        @Test
        public void patchSubmodelTest() throws ApiException {                
           runner.runAndAssertWithVoidResult(def, this::patchSubmodel);            
        }
        
        private void patchSubmodel(PatchSubmodelParams params) throws ApiException {
            api.patchSubmodel(params.getSubmodelIdentifier(), params.getSubmodel(), params.getLevel());
        }
    }

    @RunWith(Parameterized.class)
    public static class PatchSubmodelElementValueByPath extends AbstractBasyxTest {

        private AssetAdministrationShellServiceApi api;
        private final BasyxTestRunner runner;
        private final BasyxVoidTestDefinition<PatchSubmodelElementValueByPathParams> def;

        public PatchSubmodelElementValueByPath(String testName, BasyxVoidTestDefinition<PatchSubmodelElementValueByPathParams> def, BasyxTestRunner runner) {
            this.runner = runner;
            this.def = def;
        }

        @Before
        public void init() {
            this.api = new AssetAdministrationShellServiceApi(MAPPER, ENVIRONMENT.getAasServiceUrl());            
        }

        @Parameters(name="{0}")
        public static List<Object[]> initialize() {
            Path testFolder = Path.of(getPropertyOrThrow("basyxtest.folder"), "aas-service");
            ArrayList<Object[]> config = new ArrayList<>();
            BasyxTestRunner runner = new BasyxTestRunner(ENVIRONMENT, MAPPER, testFolder);
            List<BasyxVoidTestDefinition<PatchSubmodelElementValueByPathParams>> defs = runner.loadVoidTestDefinition("patchSubmodelElementValueByPath", PatchSubmodelElementValueByPathParams.class);
            for (BasyxVoidTestDefinition<PatchSubmodelElementValueByPathParams> eachDef : defs) {            
        	    config.add(new Object[] {eachDef.getName(), eachDef, runner});
            }            
        	return config;
        }

        /**
        * Updates an existing submodel element value at a specified path within submodel elements hierarchy
        *
        * 
        *
        */
        @Test
        public void patchSubmodelElementValueByPathTest() throws ApiException {                
           runner.runAndAssertWithVoidResult(def, this::patchSubmodelElementValueByPath);            
        }
        
        private void patchSubmodelElementValueByPath(PatchSubmodelElementValueByPathParams params) throws ApiException {
            api.patchSubmodelElementValueByPath(params.getSubmodelIdentifier(), params.getIdShortPath(), params.getSubmodelElement(), params.getLevel());
        }
    }

    @RunWith(Parameterized.class)
    public static class PatchSubmodelElementValueByPathMetadata extends AbstractBasyxTest {

        private AssetAdministrationShellServiceApi api;
        private final BasyxTestRunner runner;
        private final BasyxVoidTestDefinition<PatchSubmodelElementValueByPathMetadataParams> def;

        public PatchSubmodelElementValueByPathMetadata(String testName, BasyxVoidTestDefinition<PatchSubmodelElementValueByPathMetadataParams> def, BasyxTestRunner runner) {
            this.runner = runner;
            this.def = def;
        }

        @Before
        public void init() {
            this.api = new AssetAdministrationShellServiceApi(MAPPER, ENVIRONMENT.getAasServiceUrl());            
        }

        @Parameters(name="{0}")
        public static List<Object[]> initialize() {
            Path testFolder = Path.of(getPropertyOrThrow("basyxtest.folder"), "aas-service");
            ArrayList<Object[]> config = new ArrayList<>();
            BasyxTestRunner runner = new BasyxTestRunner(ENVIRONMENT, MAPPER, testFolder);
            List<BasyxVoidTestDefinition<PatchSubmodelElementValueByPathMetadataParams>> defs = runner.loadVoidTestDefinition("patchSubmodelElementValueByPathMetadata", PatchSubmodelElementValueByPathMetadataParams.class);
            for (BasyxVoidTestDefinition<PatchSubmodelElementValueByPathMetadataParams> eachDef : defs) {            
        	    config.add(new Object[] {eachDef.getName(), eachDef, runner});
            }            
        	return config;
        }

        /**
        * Updates the metadata attributes of an existing submodel element value at a specified path within submodel elements hierarchy
        *
        * 
        *
        */
        @Test
        public void patchSubmodelElementValueByPathMetadataTest() throws ApiException {                
           runner.runAndAssertWithVoidResult(def, this::patchSubmodelElementValueByPathMetadata);            
        }
        
        private void patchSubmodelElementValueByPathMetadata(PatchSubmodelElementValueByPathMetadataParams params) throws ApiException {
            api.patchSubmodelElementValueByPathMetadata(params.getSubmodelIdentifier(), params.getIdShortPath(), params.getSubmodelElementMetadata(), params.getLevel());
        }
    }

    @RunWith(Parameterized.class)
    public static class PatchSubmodelElementValueByPathValueOnly extends AbstractBasyxTest {

        private AssetAdministrationShellServiceApi api;
        private final BasyxTestRunner runner;
        private final BasyxVoidTestDefinition<PatchSubmodelElementValueByPathValueOnlyParams> def;

        public PatchSubmodelElementValueByPathValueOnly(String testName, BasyxVoidTestDefinition<PatchSubmodelElementValueByPathValueOnlyParams> def, BasyxTestRunner runner) {
            this.runner = runner;
            this.def = def;
        }

        @Before
        public void init() {
            this.api = new AssetAdministrationShellServiceApi(MAPPER, ENVIRONMENT.getAasServiceUrl());            
        }

        @Parameters(name="{0}")
        public static List<Object[]> initialize() {
            Path testFolder = Path.of(getPropertyOrThrow("basyxtest.folder"), "aas-service");
            ArrayList<Object[]> config = new ArrayList<>();
            BasyxTestRunner runner = new BasyxTestRunner(ENVIRONMENT, MAPPER, testFolder);
            List<BasyxVoidTestDefinition<PatchSubmodelElementValueByPathValueOnlyParams>> defs = runner.loadVoidTestDefinition("patchSubmodelElementValueByPathValueOnly", PatchSubmodelElementValueByPathValueOnlyParams.class);
            for (BasyxVoidTestDefinition<PatchSubmodelElementValueByPathValueOnlyParams> eachDef : defs) {            
        	    config.add(new Object[] {eachDef.getName(), eachDef, runner});
            }            
        	return config;
        }

        /**
        * Updates the value of an existing submodel element value at a specified path within submodel elements hierarchy
        *
        * 
        *
        */
        @Test
        public void patchSubmodelElementValueByPathValueOnlyTest() throws ApiException {                
           runner.runAndAssertWithVoidResult(def, this::patchSubmodelElementValueByPathValueOnly);            
        }
        
        private void patchSubmodelElementValueByPathValueOnly(PatchSubmodelElementValueByPathValueOnlyParams params) throws ApiException {
            api.patchSubmodelElementValueByPathValueOnly(params.getSubmodelIdentifier(), params.getIdShortPath(), params.getSubmodelElementValue(), params.getLevel());
        }
    }

    @RunWith(Parameterized.class)
    public static class PatchSubmodelMetadata extends AbstractBasyxTest {

        private AssetAdministrationShellServiceApi api;
        private final BasyxTestRunner runner;
        private final BasyxVoidTestDefinition<PatchSubmodelMetadataParams> def;

        public PatchSubmodelMetadata(String testName, BasyxVoidTestDefinition<PatchSubmodelMetadataParams> def, BasyxTestRunner runner) {
            this.runner = runner;
            this.def = def;
        }

        @Before
        public void init() {
            this.api = new AssetAdministrationShellServiceApi(MAPPER, ENVIRONMENT.getAasServiceUrl());            
        }

        @Parameters(name="{0}")
        public static List<Object[]> initialize() {
            Path testFolder = Path.of(getPropertyOrThrow("basyxtest.folder"), "aas-service");
            ArrayList<Object[]> config = new ArrayList<>();
            BasyxTestRunner runner = new BasyxTestRunner(ENVIRONMENT, MAPPER, testFolder);
            List<BasyxVoidTestDefinition<PatchSubmodelMetadataParams>> defs = runner.loadVoidTestDefinition("patchSubmodelMetadata", PatchSubmodelMetadataParams.class);
            for (BasyxVoidTestDefinition<PatchSubmodelMetadataParams> eachDef : defs) {            
        	    config.add(new Object[] {eachDef.getName(), eachDef, runner});
            }            
        	return config;
        }

        /**
        * Updates the metadata attributes of the Submodel
        *
        * 
        *
        */
        @Test
        public void patchSubmodelMetadataTest() throws ApiException {                
           runner.runAndAssertWithVoidResult(def, this::patchSubmodelMetadata);            
        }
        
        private void patchSubmodelMetadata(PatchSubmodelMetadataParams params) throws ApiException {
            api.patchSubmodelMetadata(params.getSubmodelIdentifier(), params.getSubmodelMetadata(), params.getLevel());
        }
    }

    @RunWith(Parameterized.class)
    public static class PatchSubmodelValueOnly extends AbstractBasyxTest {

        private AssetAdministrationShellServiceApi api;
        private final BasyxTestRunner runner;
        private final BasyxVoidTestDefinition<PatchSubmodelValueOnlyParams> def;

        public PatchSubmodelValueOnly(String testName, BasyxVoidTestDefinition<PatchSubmodelValueOnlyParams> def, BasyxTestRunner runner) {
            this.runner = runner;
            this.def = def;
        }

        @Before
        public void init() {
            this.api = new AssetAdministrationShellServiceApi(MAPPER, ENVIRONMENT.getAasServiceUrl());            
        }

        @Parameters(name="{0}")
        public static List<Object[]> initialize() {
            Path testFolder = Path.of(getPropertyOrThrow("basyxtest.folder"), "aas-service");
            ArrayList<Object[]> config = new ArrayList<>();
            BasyxTestRunner runner = new BasyxTestRunner(ENVIRONMENT, MAPPER, testFolder);
            List<BasyxVoidTestDefinition<PatchSubmodelValueOnlyParams>> defs = runner.loadVoidTestDefinition("patchSubmodelValueOnly", PatchSubmodelValueOnlyParams.class);
            for (BasyxVoidTestDefinition<PatchSubmodelValueOnlyParams> eachDef : defs) {            
        	    config.add(new Object[] {eachDef.getName(), eachDef, runner});
            }            
        	return config;
        }

        /**
        * Updates teh values of the Submodel
        *
        * 
        *
        */
        @Test
        public void patchSubmodelValueOnlyTest() throws ApiException {                
           runner.runAndAssertWithVoidResult(def, this::patchSubmodelValueOnly);            
        }
        
        private void patchSubmodelValueOnly(PatchSubmodelValueOnlyParams params) throws ApiException {
            api.patchSubmodelValueOnly(params.getSubmodelIdentifier(), params.getSubmodelValue(), params.getLevel());
        }
    }

    @RunWith(Parameterized.class)
    public static class PostSubmodelElement extends AbstractBasyxTest {

        private AssetAdministrationShellServiceApi api;
        private final BasyxTestRunner runner;
        private final BasyxFunctionalTestDefinition<PostSubmodelElementParams, SubmodelElement> def;

        public PostSubmodelElement(String testName, BasyxFunctionalTestDefinition<PostSubmodelElementParams, SubmodelElement> def, BasyxTestRunner runner) {
            this.runner = runner;
            this.def = def;
        }

        @Before
        public void init() {
            this.api = new AssetAdministrationShellServiceApi(MAPPER, ENVIRONMENT.getAasServiceUrl());            
        }

        @Parameters(name="{0}")
        public static List<Object[]> initialize() {
            Path testFolder = Path.of(getPropertyOrThrow("basyxtest.folder"), "aas-service");
            ArrayList<Object[]> config = new ArrayList<>();
            BasyxTestRunner runner = new BasyxTestRunner(ENVIRONMENT, MAPPER, testFolder);
            List<BasyxFunctionalTestDefinition<PostSubmodelElementParams, SubmodelElement>> defs = runner.loadFunctionalTestDefinition("postSubmodelElement", PostSubmodelElementParams.class, SubmodelElement.class);
            for (BasyxFunctionalTestDefinition<PostSubmodelElementParams, SubmodelElement> eachDef : defs) {            
        	    config.add(new Object[] {eachDef.getName(), eachDef, runner});
            }            
        	return config;
        }

        /**
        * Creates a new submodel element
        *
        * 
        *
        */
        @Test
        public void postSubmodelElementTest() throws ApiException {                
           runner.runAndAssertWithFunctionalResult(def, this::postSubmodelElement);            
        }
        
        private SubmodelElement postSubmodelElement(PostSubmodelElementParams params) throws ApiException {
            return api.postSubmodelElement(params.getSubmodelIdentifier(), params.getSubmodelElement());
        }
    }

    @RunWith(Parameterized.class)
    public static class PostSubmodelElementByPath extends AbstractBasyxTest {

        private AssetAdministrationShellServiceApi api;
        private final BasyxTestRunner runner;
        private final BasyxFunctionalTestDefinition<PostSubmodelElementByPathParams, SubmodelElement> def;

        public PostSubmodelElementByPath(String testName, BasyxFunctionalTestDefinition<PostSubmodelElementByPathParams, SubmodelElement> def, BasyxTestRunner runner) {
            this.runner = runner;
            this.def = def;
        }

        @Before
        public void init() {
            this.api = new AssetAdministrationShellServiceApi(MAPPER, ENVIRONMENT.getAasServiceUrl());            
        }

        @Parameters(name="{0}")
        public static List<Object[]> initialize() {
            Path testFolder = Path.of(getPropertyOrThrow("basyxtest.folder"), "aas-service");
            ArrayList<Object[]> config = new ArrayList<>();
            BasyxTestRunner runner = new BasyxTestRunner(ENVIRONMENT, MAPPER, testFolder);
            List<BasyxFunctionalTestDefinition<PostSubmodelElementByPathParams, SubmodelElement>> defs = runner.loadFunctionalTestDefinition("postSubmodelElementByPath", PostSubmodelElementByPathParams.class, SubmodelElement.class);
            for (BasyxFunctionalTestDefinition<PostSubmodelElementByPathParams, SubmodelElement> eachDef : defs) {            
        	    config.add(new Object[] {eachDef.getName(), eachDef, runner});
            }            
        	return config;
        }

        /**
        * Creates a new submodel element at a specified path within submodel elements hierarchy
        *
        * 
        *
        */
        @Test
        public void postSubmodelElementByPathTest() throws ApiException {                
           runner.runAndAssertWithFunctionalResult(def, this::postSubmodelElementByPath);            
        }
        
        private SubmodelElement postSubmodelElementByPath(PostSubmodelElementByPathParams params) throws ApiException {
            return api.postSubmodelElementByPath(params.getSubmodelIdentifier(), params.getIdShortPath(), params.getSubmodelElement());
        }
    }

    @RunWith(Parameterized.class)
    public static class PostSubmodelReference extends AbstractBasyxTest {

        private AssetAdministrationShellServiceApi api;
        private final BasyxTestRunner runner;
        private final BasyxFunctionalTestDefinition<PostSubmodelReferenceParams, Reference> def;

        public PostSubmodelReference(String testName, BasyxFunctionalTestDefinition<PostSubmodelReferenceParams, Reference> def, BasyxTestRunner runner) {
            this.runner = runner;
            this.def = def;
        }

        @Before
        public void init() {
            this.api = new AssetAdministrationShellServiceApi(MAPPER, ENVIRONMENT.getAasServiceUrl());            
        }

        @Parameters(name="{0}")
        public static List<Object[]> initialize() {
            Path testFolder = Path.of(getPropertyOrThrow("basyxtest.folder"), "aas-service");
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
            return api.postSubmodelReference(params.getReference());
        }
    }

    @RunWith(Parameterized.class)
    public static class PutAssetAdministrationShell extends AbstractBasyxTest {

        private AssetAdministrationShellServiceApi api;
        private final BasyxTestRunner runner;
        private final BasyxVoidTestDefinition<PutAssetAdministrationShellParams> def;

        public PutAssetAdministrationShell(String testName, BasyxVoidTestDefinition<PutAssetAdministrationShellParams> def, BasyxTestRunner runner) {
            this.runner = runner;
            this.def = def;
        }

        @Before
        public void init() {
            this.api = new AssetAdministrationShellServiceApi(MAPPER, ENVIRONMENT.getAasServiceUrl());            
        }

        @Parameters(name="{0}")
        public static List<Object[]> initialize() {
            Path testFolder = Path.of(getPropertyOrThrow("basyxtest.folder"), "aas-service");
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
            api.putAssetAdministrationShell(params.getAssetAdministrationShell());
        }
    }

    @RunWith(Parameterized.class)
    public static class PutAssetInformation extends AbstractBasyxTest {

        private AssetAdministrationShellServiceApi api;
        private final BasyxTestRunner runner;
        private final BasyxVoidTestDefinition<PutAssetInformationParams> def;

        public PutAssetInformation(String testName, BasyxVoidTestDefinition<PutAssetInformationParams> def, BasyxTestRunner runner) {
            this.runner = runner;
            this.def = def;
        }

        @Before
        public void init() {
            this.api = new AssetAdministrationShellServiceApi(MAPPER, ENVIRONMENT.getAasServiceUrl());            
        }

        @Parameters(name="{0}")
        public static List<Object[]> initialize() {
            Path testFolder = Path.of(getPropertyOrThrow("basyxtest.folder"), "aas-service");
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
            api.putAssetInformation(params.getAssetInformation());
        }
    }

    @RunWith(Parameterized.class)
    public static class PutFileByPath extends AbstractBasyxTest {

        private AssetAdministrationShellServiceApi api;
        private final BasyxTestRunner runner;
        private final BasyxVoidTestDefinition<PutFileByPathParams> def;

        public PutFileByPath(String testName, BasyxVoidTestDefinition<PutFileByPathParams> def, BasyxTestRunner runner) {
            this.runner = runner;
            this.def = def;
        }

        @Before
        public void init() {
            this.api = new AssetAdministrationShellServiceApi(MAPPER, ENVIRONMENT.getAasServiceUrl());            
        }

        @Parameters(name="{0}")
        public static List<Object[]> initialize() {
            Path testFolder = Path.of(getPropertyOrThrow("basyxtest.folder"), "aas-service");
            ArrayList<Object[]> config = new ArrayList<>();
            BasyxTestRunner runner = new BasyxTestRunner(ENVIRONMENT, MAPPER, testFolder);
            List<BasyxVoidTestDefinition<PutFileByPathParams>> defs = runner.loadVoidTestDefinition("putFileByPath", PutFileByPathParams.class);
            for (BasyxVoidTestDefinition<PutFileByPathParams> eachDef : defs) {            
        	    config.add(new Object[] {eachDef.getName(), eachDef, runner});
            }            
        	return config;
        }

        /**
        * Uploads file content to an existing submodel element at a specified path within submodel elements hierarchy
        *
        * 
        *
        */
        @Test
        public void putFileByPathTest() throws ApiException {                
           runner.runAndAssertWithVoidResult(def, this::putFileByPath);            
        }
        
        private void putFileByPath(PutFileByPathParams params) throws ApiException {
            api.putFileByPath(params.getSubmodelIdentifier(), params.getIdShortPath(), params.getFileName(), params.get_file());
        }
    }

    @RunWith(Parameterized.class)
    public static class PutSubmodel extends AbstractBasyxTest {

        private AssetAdministrationShellServiceApi api;
        private final BasyxTestRunner runner;
        private final BasyxVoidTestDefinition<PutSubmodelParams> def;

        public PutSubmodel(String testName, BasyxVoidTestDefinition<PutSubmodelParams> def, BasyxTestRunner runner) {
            this.runner = runner;
            this.def = def;
        }

        @Before
        public void init() {
            this.api = new AssetAdministrationShellServiceApi(MAPPER, ENVIRONMENT.getAasServiceUrl());            
        }

        @Parameters(name="{0}")
        public static List<Object[]> initialize() {
            Path testFolder = Path.of(getPropertyOrThrow("basyxtest.folder"), "aas-service");
            ArrayList<Object[]> config = new ArrayList<>();
            BasyxTestRunner runner = new BasyxTestRunner(ENVIRONMENT, MAPPER, testFolder);
            List<BasyxVoidTestDefinition<PutSubmodelParams>> defs = runner.loadVoidTestDefinition("putSubmodel", PutSubmodelParams.class);
            for (BasyxVoidTestDefinition<PutSubmodelParams> eachDef : defs) {            
        	    config.add(new Object[] {eachDef.getName(), eachDef, runner});
            }            
        	return config;
        }

        /**
        * Updates the Submodel
        *
        * 
        *
        */
        @Test
        public void putSubmodelTest() throws ApiException {                
           runner.runAndAssertWithVoidResult(def, this::putSubmodel);            
        }
        
        private void putSubmodel(PutSubmodelParams params) throws ApiException {
            api.putSubmodel(params.getSubmodelIdentifier(), params.getSubmodel(), params.getLevel());
        }
    }

    @RunWith(Parameterized.class)
    public static class PutSubmodelElementByPath extends AbstractBasyxTest {

        private AssetAdministrationShellServiceApi api;
        private final BasyxTestRunner runner;
        private final BasyxVoidTestDefinition<PutSubmodelElementByPathParams> def;

        public PutSubmodelElementByPath(String testName, BasyxVoidTestDefinition<PutSubmodelElementByPathParams> def, BasyxTestRunner runner) {
            this.runner = runner;
            this.def = def;
        }

        @Before
        public void init() {
            this.api = new AssetAdministrationShellServiceApi(MAPPER, ENVIRONMENT.getAasServiceUrl());            
        }

        @Parameters(name="{0}")
        public static List<Object[]> initialize() {
            Path testFolder = Path.of(getPropertyOrThrow("basyxtest.folder"), "aas-service");
            ArrayList<Object[]> config = new ArrayList<>();
            BasyxTestRunner runner = new BasyxTestRunner(ENVIRONMENT, MAPPER, testFolder);
            List<BasyxVoidTestDefinition<PutSubmodelElementByPathParams>> defs = runner.loadVoidTestDefinition("putSubmodelElementByPath", PutSubmodelElementByPathParams.class);
            for (BasyxVoidTestDefinition<PutSubmodelElementByPathParams> eachDef : defs) {            
        	    config.add(new Object[] {eachDef.getName(), eachDef, runner});
            }            
        	return config;
        }

        /**
        * Updates an existing submodel element at a specified path within submodel elements hierarchy
        *
        * 
        *
        */
        @Test
        public void putSubmodelElementByPathTest() throws ApiException {                
           runner.runAndAssertWithVoidResult(def, this::putSubmodelElementByPath);            
        }
        
        private void putSubmodelElementByPath(PutSubmodelElementByPathParams params) throws ApiException {
            api.putSubmodelElementByPath(params.getSubmodelIdentifier(), params.getIdShortPath(), params.getSubmodelElement());
        }
    }

    @RunWith(Parameterized.class)
    public static class PutThumbnail extends AbstractBasyxTest {

        private AssetAdministrationShellServiceApi api;
        private final BasyxTestRunner runner;
        private final BasyxVoidTestDefinition<PutThumbnailParams> def;

        public PutThumbnail(String testName, BasyxVoidTestDefinition<PutThumbnailParams> def, BasyxTestRunner runner) {
            this.runner = runner;
            this.def = def;
        }

        @Before
        public void init() {
            this.api = new AssetAdministrationShellServiceApi(MAPPER, ENVIRONMENT.getAasServiceUrl());            
        }

        @Parameters(name="{0}")
        public static List<Object[]> initialize() {
            Path testFolder = Path.of(getPropertyOrThrow("basyxtest.folder"), "aas-service");
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
            api.putThumbnail(params.getFileName(), params.get_file());
        }
    }
    private static class DeleteFileByPathParams implements BasyxTestValues {

        private String submodelIdentifier;
        private String idShortPath;
        @SuppressWarnings("unused")
        public void setSubmodelIdentifier(String submodelIdentifier) {
            this.submodelIdentifier = submodelIdentifier;
        }
        @SuppressWarnings("unused")
        public void setIdShortPath(String idShortPath) {
            this.idShortPath = idShortPath;
        }

        public String getSubmodelIdentifier() {
            return this.submodelIdentifier;
        }

        public String getIdShortPath() {
            return this.idShortPath;
        }
    }  
    private static class DeleteSubmodelByIdParams implements BasyxTestValues {

        private String submodelIdentifier;
        @SuppressWarnings("unused")
        public void setSubmodelIdentifier(String submodelIdentifier) {
            this.submodelIdentifier = submodelIdentifier;
        }

        public String getSubmodelIdentifier() {
            return this.submodelIdentifier;
        }
    }  
    private static class DeleteSubmodelElementByPathParams implements BasyxTestValues {

        private String submodelIdentifier;
        private String idShortPath;
        @SuppressWarnings("unused")
        public void setSubmodelIdentifier(String submodelIdentifier) {
            this.submodelIdentifier = submodelIdentifier;
        }
        @SuppressWarnings("unused")
        public void setIdShortPath(String idShortPath) {
            this.idShortPath = idShortPath;
        }

        public String getSubmodelIdentifier() {
            return this.submodelIdentifier;
        }

        public String getIdShortPath() {
            return this.idShortPath;
        }
    }  
    private static class DeleteSubmodelReferenceByIdParams implements BasyxTestValues {

        private String submodelIdentifier;
        @SuppressWarnings("unused")
        public void setSubmodelIdentifier(String submodelIdentifier) {
            this.submodelIdentifier = submodelIdentifier;
        }

        public String getSubmodelIdentifier() {
            return this.submodelIdentifier;
        }
    }  
    private static class DeleteThumbnailParams implements BasyxTestValues {

    }  
    private static class GenerateSerializationByIdsParams implements BasyxTestValues {

        private List<String> aasIds;
        private List<String> submodelIds;
        private Boolean includeConceptDescriptions;
        @SuppressWarnings("unused")
        public void setAasIds(List<String> aasIds) {
            this.aasIds = aasIds;
        }
        @SuppressWarnings("unused")
        public void setSubmodelIds(List<String> submodelIds) {
            this.submodelIds = submodelIds;
        }
        @SuppressWarnings("unused")
        public void setIncludeConceptDescriptions(Boolean includeConceptDescriptions) {
            this.includeConceptDescriptions = includeConceptDescriptions;
        }

        public List<String> getAasIds() {
            return this.aasIds;
        }

        public List<String> getSubmodelIds() {
            return this.submodelIds;
        }

        public Boolean getIncludeConceptDescriptions() {
            return this.includeConceptDescriptions;
        }
    }  
    private static class GetAllSubmodelElementsParams implements BasyxTestValues {

        private String submodelIdentifier;
        private Integer limit;
        private String cursor;
        private String level;
        private String extent;
        @SuppressWarnings("unused")
        public void setSubmodelIdentifier(String submodelIdentifier) {
            this.submodelIdentifier = submodelIdentifier;
        }
        @SuppressWarnings("unused")
        public void setLimit(Integer limit) {
            this.limit = limit;
        }
        @SuppressWarnings("unused")
        public void setCursor(String cursor) {
            this.cursor = cursor;
        }
        @SuppressWarnings("unused")
        public void setLevel(String level) {
            this.level = level;
        }
        @SuppressWarnings("unused")
        public void setExtent(String extent) {
            this.extent = extent;
        }

        public String getSubmodelIdentifier() {
            return this.submodelIdentifier;
        }

        public Integer getLimit() {
            return this.limit;
        }

        public String getCursor() {
            return this.cursor;
        }

        public String getLevel() {
            return this.level;
        }

        public String getExtent() {
            return this.extent;
        }
    }  
    private static class GetAllSubmodelElementsMetadataParams implements BasyxTestValues {

        private String submodelIdentifier;
        private Integer limit;
        private String cursor;
        private String level;
        @SuppressWarnings("unused")
        public void setSubmodelIdentifier(String submodelIdentifier) {
            this.submodelIdentifier = submodelIdentifier;
        }
        @SuppressWarnings("unused")
        public void setLimit(Integer limit) {
            this.limit = limit;
        }
        @SuppressWarnings("unused")
        public void setCursor(String cursor) {
            this.cursor = cursor;
        }
        @SuppressWarnings("unused")
        public void setLevel(String level) {
            this.level = level;
        }

        public String getSubmodelIdentifier() {
            return this.submodelIdentifier;
        }

        public Integer getLimit() {
            return this.limit;
        }

        public String getCursor() {
            return this.cursor;
        }

        public String getLevel() {
            return this.level;
        }
    }  
    private static class GetAllSubmodelElementsPathParams implements BasyxTestValues {

        private String submodelIdentifier;
        private Integer limit;
        private String cursor;
        private String level;
        @SuppressWarnings("unused")
        public void setSubmodelIdentifier(String submodelIdentifier) {
            this.submodelIdentifier = submodelIdentifier;
        }
        @SuppressWarnings("unused")
        public void setLimit(Integer limit) {
            this.limit = limit;
        }
        @SuppressWarnings("unused")
        public void setCursor(String cursor) {
            this.cursor = cursor;
        }
        @SuppressWarnings("unused")
        public void setLevel(String level) {
            this.level = level;
        }

        public String getSubmodelIdentifier() {
            return this.submodelIdentifier;
        }

        public Integer getLimit() {
            return this.limit;
        }

        public String getCursor() {
            return this.cursor;
        }

        public String getLevel() {
            return this.level;
        }
    }  
    private static class GetAllSubmodelElementsReferenceParams implements BasyxTestValues {

        private String submodelIdentifier;
        private Integer limit;
        private String cursor;
        private String level;
        @SuppressWarnings("unused")
        public void setSubmodelIdentifier(String submodelIdentifier) {
            this.submodelIdentifier = submodelIdentifier;
        }
        @SuppressWarnings("unused")
        public void setLimit(Integer limit) {
            this.limit = limit;
        }
        @SuppressWarnings("unused")
        public void setCursor(String cursor) {
            this.cursor = cursor;
        }
        @SuppressWarnings("unused")
        public void setLevel(String level) {
            this.level = level;
        }

        public String getSubmodelIdentifier() {
            return this.submodelIdentifier;
        }

        public Integer getLimit() {
            return this.limit;
        }

        public String getCursor() {
            return this.cursor;
        }

        public String getLevel() {
            return this.level;
        }
    }  
    private static class GetAllSubmodelElementsValueOnlyParams implements BasyxTestValues {

        private String submodelIdentifier;
        private Integer limit;
        private String cursor;
        private String level;
        private String extent;
        @SuppressWarnings("unused")
        public void setSubmodelIdentifier(String submodelIdentifier) {
            this.submodelIdentifier = submodelIdentifier;
        }
        @SuppressWarnings("unused")
        public void setLimit(Integer limit) {
            this.limit = limit;
        }
        @SuppressWarnings("unused")
        public void setCursor(String cursor) {
            this.cursor = cursor;
        }
        @SuppressWarnings("unused")
        public void setLevel(String level) {
            this.level = level;
        }
        @SuppressWarnings("unused")
        public void setExtent(String extent) {
            this.extent = extent;
        }

        public String getSubmodelIdentifier() {
            return this.submodelIdentifier;
        }

        public Integer getLimit() {
            return this.limit;
        }

        public String getCursor() {
            return this.cursor;
        }

        public String getLevel() {
            return this.level;
        }

        public String getExtent() {
            return this.extent;
        }
    }  
    private static class GetAllSubmodelReferencesParams implements BasyxTestValues {

        private Integer limit;
        private String cursor;
        @SuppressWarnings("unused")
        public void setLimit(Integer limit) {
            this.limit = limit;
        }
        @SuppressWarnings("unused")
        public void setCursor(String cursor) {
            this.cursor = cursor;
        }

        public Integer getLimit() {
            return this.limit;
        }

        public String getCursor() {
            return this.cursor;
        }
    }  
    private static class GetAssetAdministrationShellParams implements BasyxTestValues {

    }  
    private static class GetAssetAdministrationShellReferenceParams implements BasyxTestValues {

    }  
    private static class GetAssetInformationParams implements BasyxTestValues {

    }  
    private static class GetDescriptionParams implements BasyxTestValues {

    }  
    private static class GetFileByPathParams implements BasyxTestValues {

        private String submodelIdentifier;
        private String idShortPath;
        @SuppressWarnings("unused")
        public void setSubmodelIdentifier(String submodelIdentifier) {
            this.submodelIdentifier = submodelIdentifier;
        }
        @SuppressWarnings("unused")
        public void setIdShortPath(String idShortPath) {
            this.idShortPath = idShortPath;
        }

        public String getSubmodelIdentifier() {
            return this.submodelIdentifier;
        }

        public String getIdShortPath() {
            return this.idShortPath;
        }
    }  
    private static class GetOperationAsyncResultParams implements BasyxTestValues {

        private String submodelIdentifier;
        private String aasIdentifier;
        private String idShortPath;
        private String handleId;
        @SuppressWarnings("unused")
        public void setSubmodelIdentifier(String submodelIdentifier) {
            this.submodelIdentifier = submodelIdentifier;
        }
        @SuppressWarnings("unused")
        public void setAasIdentifier(String aasIdentifier) {
            this.aasIdentifier = aasIdentifier;
        }
        @SuppressWarnings("unused")
        public void setIdShortPath(String idShortPath) {
            this.idShortPath = idShortPath;
        }
        @SuppressWarnings("unused")
        public void setHandleId(String handleId) {
            this.handleId = handleId;
        }

        public String getSubmodelIdentifier() {
            return this.submodelIdentifier;
        }

        public String getAasIdentifier() {
            return this.aasIdentifier;
        }

        public String getIdShortPath() {
            return this.idShortPath;
        }

        public String getHandleId() {
            return this.handleId;
        }
    }  
    private static class GetOperationAsyncResultValueOnlyParams implements BasyxTestValues {

        private String submodelIdentifier;
        private String aasIdentifier;
        private String idShortPath;
        private String handleId;
        @SuppressWarnings("unused")
        public void setSubmodelIdentifier(String submodelIdentifier) {
            this.submodelIdentifier = submodelIdentifier;
        }
        @SuppressWarnings("unused")
        public void setAasIdentifier(String aasIdentifier) {
            this.aasIdentifier = aasIdentifier;
        }
        @SuppressWarnings("unused")
        public void setIdShortPath(String idShortPath) {
            this.idShortPath = idShortPath;
        }
        @SuppressWarnings("unused")
        public void setHandleId(String handleId) {
            this.handleId = handleId;
        }

        public String getSubmodelIdentifier() {
            return this.submodelIdentifier;
        }

        public String getAasIdentifier() {
            return this.aasIdentifier;
        }

        public String getIdShortPath() {
            return this.idShortPath;
        }

        public String getHandleId() {
            return this.handleId;
        }
    }  
    private static class GetOperationAsyncStatusParams implements BasyxTestValues {

        private String submodelIdentifier;
        private String aasIdentifier;
        private String idShortPath;
        private String handleId;
        @SuppressWarnings("unused")
        public void setSubmodelIdentifier(String submodelIdentifier) {
            this.submodelIdentifier = submodelIdentifier;
        }
        @SuppressWarnings("unused")
        public void setAasIdentifier(String aasIdentifier) {
            this.aasIdentifier = aasIdentifier;
        }
        @SuppressWarnings("unused")
        public void setIdShortPath(String idShortPath) {
            this.idShortPath = idShortPath;
        }
        @SuppressWarnings("unused")
        public void setHandleId(String handleId) {
            this.handleId = handleId;
        }

        public String getSubmodelIdentifier() {
            return this.submodelIdentifier;
        }

        public String getAasIdentifier() {
            return this.aasIdentifier;
        }

        public String getIdShortPath() {
            return this.idShortPath;
        }

        public String getHandleId() {
            return this.handleId;
        }
    }  
    private static class GetSubmodelParams implements BasyxTestValues {

        private String submodelIdentifier;
        private String level;
        private String extent;
        @SuppressWarnings("unused")
        public void setSubmodelIdentifier(String submodelIdentifier) {
            this.submodelIdentifier = submodelIdentifier;
        }
        @SuppressWarnings("unused")
        public void setLevel(String level) {
            this.level = level;
        }
        @SuppressWarnings("unused")
        public void setExtent(String extent) {
            this.extent = extent;
        }

        public String getSubmodelIdentifier() {
            return this.submodelIdentifier;
        }

        public String getLevel() {
            return this.level;
        }

        public String getExtent() {
            return this.extent;
        }
    }  
    private static class GetSubmodelElementByPathParams implements BasyxTestValues {

        private String submodelIdentifier;
        private String idShortPath;
        private String level;
        private String extent;
        @SuppressWarnings("unused")
        public void setSubmodelIdentifier(String submodelIdentifier) {
            this.submodelIdentifier = submodelIdentifier;
        }
        @SuppressWarnings("unused")
        public void setIdShortPath(String idShortPath) {
            this.idShortPath = idShortPath;
        }
        @SuppressWarnings("unused")
        public void setLevel(String level) {
            this.level = level;
        }
        @SuppressWarnings("unused")
        public void setExtent(String extent) {
            this.extent = extent;
        }

        public String getSubmodelIdentifier() {
            return this.submodelIdentifier;
        }

        public String getIdShortPath() {
            return this.idShortPath;
        }

        public String getLevel() {
            return this.level;
        }

        public String getExtent() {
            return this.extent;
        }
    }  
    private static class GetSubmodelElementByPathMetadataParams implements BasyxTestValues {

        private String submodelIdentifier;
        private String idShortPath;
        private String level;
        @SuppressWarnings("unused")
        public void setSubmodelIdentifier(String submodelIdentifier) {
            this.submodelIdentifier = submodelIdentifier;
        }
        @SuppressWarnings("unused")
        public void setIdShortPath(String idShortPath) {
            this.idShortPath = idShortPath;
        }
        @SuppressWarnings("unused")
        public void setLevel(String level) {
            this.level = level;
        }

        public String getSubmodelIdentifier() {
            return this.submodelIdentifier;
        }

        public String getIdShortPath() {
            return this.idShortPath;
        }

        public String getLevel() {
            return this.level;
        }
    }  
    private static class GetSubmodelElementByPathPathParams implements BasyxTestValues {

        private String submodelIdentifier;
        private String idShortPath;
        private String level;
        @SuppressWarnings("unused")
        public void setSubmodelIdentifier(String submodelIdentifier) {
            this.submodelIdentifier = submodelIdentifier;
        }
        @SuppressWarnings("unused")
        public void setIdShortPath(String idShortPath) {
            this.idShortPath = idShortPath;
        }
        @SuppressWarnings("unused")
        public void setLevel(String level) {
            this.level = level;
        }

        public String getSubmodelIdentifier() {
            return this.submodelIdentifier;
        }

        public String getIdShortPath() {
            return this.idShortPath;
        }

        public String getLevel() {
            return this.level;
        }
    }  
    private static class GetSubmodelElementByPathReferenceParams implements BasyxTestValues {

        private String submodelIdentifier;
        private String idShortPath;
        @SuppressWarnings("unused")
        public void setSubmodelIdentifier(String submodelIdentifier) {
            this.submodelIdentifier = submodelIdentifier;
        }
        @SuppressWarnings("unused")
        public void setIdShortPath(String idShortPath) {
            this.idShortPath = idShortPath;
        }

        public String getSubmodelIdentifier() {
            return this.submodelIdentifier;
        }

        public String getIdShortPath() {
            return this.idShortPath;
        }
    }  
    private static class GetSubmodelElementByPathValueOnlyParams implements BasyxTestValues {

        private String submodelIdentifier;
        private String idShortPath;
        private String level;
        @SuppressWarnings("unused")
        public void setSubmodelIdentifier(String submodelIdentifier) {
            this.submodelIdentifier = submodelIdentifier;
        }
        @SuppressWarnings("unused")
        public void setIdShortPath(String idShortPath) {
            this.idShortPath = idShortPath;
        }
        @SuppressWarnings("unused")
        public void setLevel(String level) {
            this.level = level;
        }

        public String getSubmodelIdentifier() {
            return this.submodelIdentifier;
        }

        public String getIdShortPath() {
            return this.idShortPath;
        }

        public String getLevel() {
            return this.level;
        }
    }  
    private static class GetSubmodelMetadataParams implements BasyxTestValues {

        private String submodelIdentifier;
        private String level;
        @SuppressWarnings("unused")
        public void setSubmodelIdentifier(String submodelIdentifier) {
            this.submodelIdentifier = submodelIdentifier;
        }
        @SuppressWarnings("unused")
        public void setLevel(String level) {
            this.level = level;
        }

        public String getSubmodelIdentifier() {
            return this.submodelIdentifier;
        }

        public String getLevel() {
            return this.level;
        }
    }  
    private static class GetSubmodelMetadataReferenceParams implements BasyxTestValues {

        private String submodelIdentifier;
        private String level;
        @SuppressWarnings("unused")
        public void setSubmodelIdentifier(String submodelIdentifier) {
            this.submodelIdentifier = submodelIdentifier;
        }
        @SuppressWarnings("unused")
        public void setLevel(String level) {
            this.level = level;
        }

        public String getSubmodelIdentifier() {
            return this.submodelIdentifier;
        }

        public String getLevel() {
            return this.level;
        }
    }  
    private static class GetSubmodelPathParams implements BasyxTestValues {

        private String submodelIdentifier;
        private String level;
        @SuppressWarnings("unused")
        public void setSubmodelIdentifier(String submodelIdentifier) {
            this.submodelIdentifier = submodelIdentifier;
        }
        @SuppressWarnings("unused")
        public void setLevel(String level) {
            this.level = level;
        }

        public String getSubmodelIdentifier() {
            return this.submodelIdentifier;
        }

        public String getLevel() {
            return this.level;
        }
    }  
    private static class GetSubmodelValueOnlyParams implements BasyxTestValues {

        private String submodelIdentifier;
        private String level;
        private String extent;
        @SuppressWarnings("unused")
        public void setSubmodelIdentifier(String submodelIdentifier) {
            this.submodelIdentifier = submodelIdentifier;
        }
        @SuppressWarnings("unused")
        public void setLevel(String level) {
            this.level = level;
        }
        @SuppressWarnings("unused")
        public void setExtent(String extent) {
            this.extent = extent;
        }

        public String getSubmodelIdentifier() {
            return this.submodelIdentifier;
        }

        public String getLevel() {
            return this.level;
        }

        public String getExtent() {
            return this.extent;
        }
    }  
    private static class GetThumbnailParams implements BasyxTestValues {

    }  
    private static class InvokeOperationAsyncParams implements BasyxTestValues {

        private String submodelIdentifier;
        private String idShortPath;
        private OperationRequest operationRequest;
        @SuppressWarnings("unused")
        public void setSubmodelIdentifier(String submodelIdentifier) {
            this.submodelIdentifier = submodelIdentifier;
        }
        @SuppressWarnings("unused")
        public void setIdShortPath(String idShortPath) {
            this.idShortPath = idShortPath;
        }
        @SuppressWarnings("unused")
        public void setOperationRequest(OperationRequest operationRequest) {
            this.operationRequest = operationRequest;
        }

        public String getSubmodelIdentifier() {
            return this.submodelIdentifier;
        }

        public String getIdShortPath() {
            return this.idShortPath;
        }

        public OperationRequest getOperationRequest() {
            return this.operationRequest;
        }
    }  
    private static class InvokeOperationAsyncValueOnlyParams implements BasyxTestValues {

        private String submodelIdentifier;
        private String idShortPath;
        private OperationRequestValueOnly operationRequestValueOnly;
        @SuppressWarnings("unused")
        public void setSubmodelIdentifier(String submodelIdentifier) {
            this.submodelIdentifier = submodelIdentifier;
        }
        @SuppressWarnings("unused")
        public void setIdShortPath(String idShortPath) {
            this.idShortPath = idShortPath;
        }
        @SuppressWarnings("unused")
        public void setOperationRequestValueOnly(OperationRequestValueOnly operationRequestValueOnly) {
            this.operationRequestValueOnly = operationRequestValueOnly;
        }

        public String getSubmodelIdentifier() {
            return this.submodelIdentifier;
        }

        public String getIdShortPath() {
            return this.idShortPath;
        }

        public OperationRequestValueOnly getOperationRequestValueOnly() {
            return this.operationRequestValueOnly;
        }
    }  
    private static class InvokeOperationSyncParams implements BasyxTestValues {

        private String submodelIdentifier;
        private String idShortPath;
        private OperationRequest operationRequest;
        @SuppressWarnings("unused")
        public void setSubmodelIdentifier(String submodelIdentifier) {
            this.submodelIdentifier = submodelIdentifier;
        }
        @SuppressWarnings("unused")
        public void setIdShortPath(String idShortPath) {
            this.idShortPath = idShortPath;
        }
        @SuppressWarnings("unused")
        public void setOperationRequest(OperationRequest operationRequest) {
            this.operationRequest = operationRequest;
        }

        public String getSubmodelIdentifier() {
            return this.submodelIdentifier;
        }

        public String getIdShortPath() {
            return this.idShortPath;
        }

        public OperationRequest getOperationRequest() {
            return this.operationRequest;
        }
    }  
    private static class InvokeOperationSyncValueOnlyParams implements BasyxTestValues {

        private String submodelIdentifier;
        private String idShortPath;
        private OperationRequestValueOnly operationRequestValueOnly;
        @SuppressWarnings("unused")
        public void setSubmodelIdentifier(String submodelIdentifier) {
            this.submodelIdentifier = submodelIdentifier;
        }
        @SuppressWarnings("unused")
        public void setIdShortPath(String idShortPath) {
            this.idShortPath = idShortPath;
        }
        @SuppressWarnings("unused")
        public void setOperationRequestValueOnly(OperationRequestValueOnly operationRequestValueOnly) {
            this.operationRequestValueOnly = operationRequestValueOnly;
        }

        public String getSubmodelIdentifier() {
            return this.submodelIdentifier;
        }

        public String getIdShortPath() {
            return this.idShortPath;
        }

        public OperationRequestValueOnly getOperationRequestValueOnly() {
            return this.operationRequestValueOnly;
        }
    }  
    private static class PatchSubmodelParams implements BasyxTestValues {

        private String submodelIdentifier;
        private Submodel submodel;
        private String level;
        @SuppressWarnings("unused")
        public void setSubmodelIdentifier(String submodelIdentifier) {
            this.submodelIdentifier = submodelIdentifier;
        }
        @SuppressWarnings("unused")
        public void setSubmodel(Submodel submodel) {
            this.submodel = submodel;
        }
        @SuppressWarnings("unused")
        public void setLevel(String level) {
            this.level = level;
        }

        public String getSubmodelIdentifier() {
            return this.submodelIdentifier;
        }

        public Submodel getSubmodel() {
            return this.submodel;
        }

        public String getLevel() {
            return this.level;
        }
    }  
    private static class PatchSubmodelElementValueByPathParams implements BasyxTestValues {

        private String submodelIdentifier;
        private String idShortPath;
        private SubmodelElement submodelElement;
        private String level;
        @SuppressWarnings("unused")
        public void setSubmodelIdentifier(String submodelIdentifier) {
            this.submodelIdentifier = submodelIdentifier;
        }
        @SuppressWarnings("unused")
        public void setIdShortPath(String idShortPath) {
            this.idShortPath = idShortPath;
        }
        @SuppressWarnings("unused")
        public void setSubmodelElement(SubmodelElement submodelElement) {
            this.submodelElement = submodelElement;
        }
        @SuppressWarnings("unused")
        public void setLevel(String level) {
            this.level = level;
        }

        public String getSubmodelIdentifier() {
            return this.submodelIdentifier;
        }

        public String getIdShortPath() {
            return this.idShortPath;
        }

        public SubmodelElement getSubmodelElement() {
            return this.submodelElement;
        }

        public String getLevel() {
            return this.level;
        }
    }  
    private static class PatchSubmodelElementValueByPathMetadataParams implements BasyxTestValues {

        private String submodelIdentifier;
        private String idShortPath;
        private SubmodelElementMetadata submodelElementMetadata;
        private String level;
        @SuppressWarnings("unused")
        public void setSubmodelIdentifier(String submodelIdentifier) {
            this.submodelIdentifier = submodelIdentifier;
        }
        @SuppressWarnings("unused")
        public void setIdShortPath(String idShortPath) {
            this.idShortPath = idShortPath;
        }
        @SuppressWarnings("unused")
        public void setSubmodelElementMetadata(SubmodelElementMetadata submodelElementMetadata) {
            this.submodelElementMetadata = submodelElementMetadata;
        }
        @SuppressWarnings("unused")
        public void setLevel(String level) {
            this.level = level;
        }

        public String getSubmodelIdentifier() {
            return this.submodelIdentifier;
        }

        public String getIdShortPath() {
            return this.idShortPath;
        }

        public SubmodelElementMetadata getSubmodelElementMetadata() {
            return this.submodelElementMetadata;
        }

        public String getLevel() {
            return this.level;
        }
    }  
    private static class PatchSubmodelElementValueByPathValueOnlyParams implements BasyxTestValues {

        private String submodelIdentifier;
        private String idShortPath;
        private SubmodelElementValue submodelElementValue;
        private String level;
        @SuppressWarnings("unused")
        public void setSubmodelIdentifier(String submodelIdentifier) {
            this.submodelIdentifier = submodelIdentifier;
        }
        @SuppressWarnings("unused")
        public void setIdShortPath(String idShortPath) {
            this.idShortPath = idShortPath;
        }
        @SuppressWarnings("unused")
        public void setSubmodelElementValue(SubmodelElementValue submodelElementValue) {
            this.submodelElementValue = submodelElementValue;
        }
        @SuppressWarnings("unused")
        public void setLevel(String level) {
            this.level = level;
        }

        public String getSubmodelIdentifier() {
            return this.submodelIdentifier;
        }

        public String getIdShortPath() {
            return this.idShortPath;
        }

        public SubmodelElementValue getSubmodelElementValue() {
            return this.submodelElementValue;
        }

        public String getLevel() {
            return this.level;
        }
    }  
    private static class PatchSubmodelMetadataParams implements BasyxTestValues {

        private String submodelIdentifier;
        private SubmodelMetadata submodelMetadata;
        private String level;
        @SuppressWarnings("unused")
        public void setSubmodelIdentifier(String submodelIdentifier) {
            this.submodelIdentifier = submodelIdentifier;
        }
        @SuppressWarnings("unused")
        public void setSubmodelMetadata(SubmodelMetadata submodelMetadata) {
            this.submodelMetadata = submodelMetadata;
        }
        @SuppressWarnings("unused")
        public void setLevel(String level) {
            this.level = level;
        }

        public String getSubmodelIdentifier() {
            return this.submodelIdentifier;
        }

        public SubmodelMetadata getSubmodelMetadata() {
            return this.submodelMetadata;
        }

        public String getLevel() {
            return this.level;
        }
    }  
    private static class PatchSubmodelValueOnlyParams implements BasyxTestValues {

        private String submodelIdentifier;
        private SubmodelValue submodelValue;
        private String level;
        @SuppressWarnings("unused")
        public void setSubmodelIdentifier(String submodelIdentifier) {
            this.submodelIdentifier = submodelIdentifier;
        }
        @SuppressWarnings("unused")
        public void setSubmodelValue(SubmodelValue submodelValue) {
            this.submodelValue = submodelValue;
        }
        @SuppressWarnings("unused")
        public void setLevel(String level) {
            this.level = level;
        }

        public String getSubmodelIdentifier() {
            return this.submodelIdentifier;
        }

        public SubmodelValue getSubmodelValue() {
            return this.submodelValue;
        }

        public String getLevel() {
            return this.level;
        }
    }  
    private static class PostSubmodelElementParams implements BasyxTestValues {

        private String submodelIdentifier;
        private SubmodelElement submodelElement;
        @SuppressWarnings("unused")
        public void setSubmodelIdentifier(String submodelIdentifier) {
            this.submodelIdentifier = submodelIdentifier;
        }
        @SuppressWarnings("unused")
        public void setSubmodelElement(SubmodelElement submodelElement) {
            this.submodelElement = submodelElement;
        }

        public String getSubmodelIdentifier() {
            return this.submodelIdentifier;
        }

        public SubmodelElement getSubmodelElement() {
            return this.submodelElement;
        }
    }  
    private static class PostSubmodelElementByPathParams implements BasyxTestValues {

        private String submodelIdentifier;
        private String idShortPath;
        private SubmodelElement submodelElement;
        @SuppressWarnings("unused")
        public void setSubmodelIdentifier(String submodelIdentifier) {
            this.submodelIdentifier = submodelIdentifier;
        }
        @SuppressWarnings("unused")
        public void setIdShortPath(String idShortPath) {
            this.idShortPath = idShortPath;
        }
        @SuppressWarnings("unused")
        public void setSubmodelElement(SubmodelElement submodelElement) {
            this.submodelElement = submodelElement;
        }

        public String getSubmodelIdentifier() {
            return this.submodelIdentifier;
        }

        public String getIdShortPath() {
            return this.idShortPath;
        }

        public SubmodelElement getSubmodelElement() {
            return this.submodelElement;
        }
    }  
    private static class PostSubmodelReferenceParams implements BasyxTestValues {

        private Reference reference;
        @SuppressWarnings("unused")
        public void setReference(Reference reference) {
            this.reference = reference;
        }

        public Reference getReference() {
            return this.reference;
        }
    }  
    private static class PutAssetAdministrationShellParams implements BasyxTestValues {

        private AssetAdministrationShell assetAdministrationShell;
        @SuppressWarnings("unused")
        public void setAssetAdministrationShell(AssetAdministrationShell assetAdministrationShell) {
            this.assetAdministrationShell = assetAdministrationShell;
        }

        public AssetAdministrationShell getAssetAdministrationShell() {
            return this.assetAdministrationShell;
        }
    }  
    private static class PutAssetInformationParams implements BasyxTestValues {

        private AssetInformation assetInformation;
        @SuppressWarnings("unused")
        public void setAssetInformation(AssetInformation assetInformation) {
            this.assetInformation = assetInformation;
        }

        public AssetInformation getAssetInformation() {
            return this.assetInformation;
        }
    }  
    private static class PutFileByPathParams implements BasyxTestValues {

        private String submodelIdentifier;
        private String idShortPath;
        private String fileName;
        private File _file;
        @SuppressWarnings("unused")
        public void setSubmodelIdentifier(String submodelIdentifier) {
            this.submodelIdentifier = submodelIdentifier;
        }
        @SuppressWarnings("unused")
        public void setIdShortPath(String idShortPath) {
            this.idShortPath = idShortPath;
        }
        @SuppressWarnings("unused")
        public void setFileName(String fileName) {
            this.fileName = fileName;
        }
        @SuppressWarnings("unused")
        public void set_file(File _file) {
            this._file = _file;
        }

        public String getSubmodelIdentifier() {
            return this.submodelIdentifier;
        }

        public String getIdShortPath() {
            return this.idShortPath;
        }

        public String getFileName() {
            return this.fileName;
        }

        public File get_file() {
            return this._file;
        }
    }  
    private static class PutSubmodelParams implements BasyxTestValues {

        private String submodelIdentifier;
        private Submodel submodel;
        private String level;
        @SuppressWarnings("unused")
        public void setSubmodelIdentifier(String submodelIdentifier) {
            this.submodelIdentifier = submodelIdentifier;
        }
        @SuppressWarnings("unused")
        public void setSubmodel(Submodel submodel) {
            this.submodel = submodel;
        }
        @SuppressWarnings("unused")
        public void setLevel(String level) {
            this.level = level;
        }

        public String getSubmodelIdentifier() {
            return this.submodelIdentifier;
        }

        public Submodel getSubmodel() {
            return this.submodel;
        }

        public String getLevel() {
            return this.level;
        }
    }  
    private static class PutSubmodelElementByPathParams implements BasyxTestValues {

        private String submodelIdentifier;
        private String idShortPath;
        private SubmodelElement submodelElement;
        @SuppressWarnings("unused")
        public void setSubmodelIdentifier(String submodelIdentifier) {
            this.submodelIdentifier = submodelIdentifier;
        }
        @SuppressWarnings("unused")
        public void setIdShortPath(String idShortPath) {
            this.idShortPath = idShortPath;
        }
        @SuppressWarnings("unused")
        public void setSubmodelElement(SubmodelElement submodelElement) {
            this.submodelElement = submodelElement;
        }

        public String getSubmodelIdentifier() {
            return this.submodelIdentifier;
        }

        public String getIdShortPath() {
            return this.idShortPath;
        }

        public SubmodelElement getSubmodelElement() {
            return this.submodelElement;
        }
    }  
    private static class PutThumbnailParams implements BasyxTestValues {

        private String fileName;
        private File _file;
        @SuppressWarnings("unused")
        public void setFileName(String fileName) {
            this.fileName = fileName;
        }
        @SuppressWarnings("unused")
        public void set_file(File _file) {
            this._file = _file;
        }

        public String getFileName() {
            return this.fileName;
        }

        public File get_file() {
            return this._file;
        }
    }  
}    
