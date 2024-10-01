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
import java.io.File;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part2.GetPathItemsResult;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part2.GetSubmodelElementsMetadataResult;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part2.GetSubmodelElementsResult;
import org.eclipse.digitaltwin.aas4j.v3.model.OperationRequest;
import org.eclipse.digitaltwin.aas4j.v3.model.OperationResult;
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
 * API tests for SubmodelServiceApi
 */
public class SubmodelServiceApiTest {


    public SubmodelServiceApiTest() {
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

        private SubmodelServiceApi api;
        private final BasyxTestRunner runner;
        private final BasyxVoidTestDefinition<DeleteFileByPathParams> def;

        public DeleteFileByPath(String testName, BasyxVoidTestDefinition<DeleteFileByPathParams> def, BasyxTestRunner runner) {
            this.runner = runner;
            this.def = def;
        }

        @Before
        public void init() {
            this.api = new SubmodelServiceApi(MAPPER, ENVIRONMENT.getSubmodelServiceUrl());            
        }

        @Parameters(name="{0}")
        public static List<Object[]> initialize() {
            Path testFolder = Path.of(getPropertyOrThrow("basyxtest.folder"), "submodel-service");
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
            api.deleteFileByPath(params.getIdShortPath());
        }
    }

    @RunWith(Parameterized.class)
    public static class DeleteSubmodelElement extends AbstractBasyxTest {

        private SubmodelServiceApi api;
        private final BasyxTestRunner runner;
        private final BasyxVoidTestDefinition<DeleteSubmodelElementParams> def;

        public DeleteSubmodelElement(String testName, BasyxVoidTestDefinition<DeleteSubmodelElementParams> def, BasyxTestRunner runner) {
            this.runner = runner;
            this.def = def;
        }

        @Before
        public void init() {
            this.api = new SubmodelServiceApi(MAPPER, ENVIRONMENT.getSubmodelServiceUrl());            
        }

        @Parameters(name="{0}")
        public static List<Object[]> initialize() {
            Path testFolder = Path.of(getPropertyOrThrow("basyxtest.folder"), "submodel-service");
            ArrayList<Object[]> config = new ArrayList<>();
            BasyxTestRunner runner = new BasyxTestRunner(ENVIRONMENT, MAPPER, testFolder);
            List<BasyxVoidTestDefinition<DeleteSubmodelElementParams>> defs = runner.loadVoidTestDefinition("deleteSubmodelElement", DeleteSubmodelElementParams.class);
            for (BasyxVoidTestDefinition<DeleteSubmodelElementParams> eachDef : defs) {            
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
        public void deleteSubmodelElementTest() throws ApiException {                
           runner.runAndAssertWithVoidResult(def, this::deleteSubmodelElement);            
        }
        
        private void deleteSubmodelElement(DeleteSubmodelElementParams params) throws ApiException {
            api.deleteSubmodelElement(params.getIdShortPath());
        }
    }

    @RunWith(Parameterized.class)
    public static class GetAllSubmodelElements extends AbstractBasyxTest {

        private SubmodelServiceApi api;
        private final BasyxTestRunner runner;
        private final BasyxFunctionalTestDefinition<GetAllSubmodelElementsParams, GetSubmodelElementsResult> def;

        public GetAllSubmodelElements(String testName, BasyxFunctionalTestDefinition<GetAllSubmodelElementsParams, GetSubmodelElementsResult> def, BasyxTestRunner runner) {
            this.runner = runner;
            this.def = def;
        }

        @Before
        public void init() {
            this.api = new SubmodelServiceApi(MAPPER, ENVIRONMENT.getSubmodelServiceUrl());            
        }

        @Parameters(name="{0}")
        public static List<Object[]> initialize() {
            Path testFolder = Path.of(getPropertyOrThrow("basyxtest.folder"), "submodel-service");
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
            return api.getAllSubmodelElements(params.getLimit(), params.getCursor(), params.getLevel(), params.getExtent());
        }
    }

    @RunWith(Parameterized.class)
    public static class GetAllSubmodelElementsMetadata extends AbstractBasyxTest {

        private SubmodelServiceApi api;
        private final BasyxTestRunner runner;
        private final BasyxFunctionalTestDefinition<GetAllSubmodelElementsMetadataParams, GetSubmodelElementsMetadataResult> def;

        public GetAllSubmodelElementsMetadata(String testName, BasyxFunctionalTestDefinition<GetAllSubmodelElementsMetadataParams, GetSubmodelElementsMetadataResult> def, BasyxTestRunner runner) {
            this.runner = runner;
            this.def = def;
        }

        @Before
        public void init() {
            this.api = new SubmodelServiceApi(MAPPER, ENVIRONMENT.getSubmodelServiceUrl());            
        }

        @Parameters(name="{0}")
        public static List<Object[]> initialize() {
            Path testFolder = Path.of(getPropertyOrThrow("basyxtest.folder"), "submodel-service");
            ArrayList<Object[]> config = new ArrayList<>();
            BasyxTestRunner runner = new BasyxTestRunner(ENVIRONMENT, MAPPER, testFolder);
            List<BasyxFunctionalTestDefinition<GetAllSubmodelElementsMetadataParams, GetSubmodelElementsMetadataResult>> defs = runner.loadFunctionalTestDefinition("getAllSubmodelElementsMetadata", GetAllSubmodelElementsMetadataParams.class, GetSubmodelElementsMetadataResult.class);
            for (BasyxFunctionalTestDefinition<GetAllSubmodelElementsMetadataParams, GetSubmodelElementsMetadataResult> eachDef : defs) {            
        	    config.add(new Object[] {eachDef.getName(), eachDef, runner});
            }            
        	return config;
        }

        /**
        * Returns the metadata attributes of all submodel elements including their hierarchy
        *
        * 
        *
        */
        @Test
        public void getAllSubmodelElementsMetadataTest() throws ApiException {                
           runner.runAndAssertWithFunctionalResult(def, this::getAllSubmodelElementsMetadata);            
        }
        
        private GetSubmodelElementsMetadataResult getAllSubmodelElementsMetadata(GetAllSubmodelElementsMetadataParams params) throws ApiException {
            return api.getAllSubmodelElementsMetadata(params.getLimit(), params.getCursor(), params.getLevel());
        }
    }

    @RunWith(Parameterized.class)
    public static class GetAllSubmodelElementsPath extends AbstractBasyxTest {

        private SubmodelServiceApi api;
        private final BasyxTestRunner runner;
        private final BasyxFunctionalTestDefinition<GetAllSubmodelElementsPathParams, GetPathItemsResult> def;

        public GetAllSubmodelElementsPath(String testName, BasyxFunctionalTestDefinition<GetAllSubmodelElementsPathParams, GetPathItemsResult> def, BasyxTestRunner runner) {
            this.runner = runner;
            this.def = def;
        }

        @Before
        public void init() {
            this.api = new SubmodelServiceApi(MAPPER, ENVIRONMENT.getSubmodelServiceUrl());            
        }

        @Parameters(name="{0}")
        public static List<Object[]> initialize() {
            Path testFolder = Path.of(getPropertyOrThrow("basyxtest.folder"), "submodel-service");
            ArrayList<Object[]> config = new ArrayList<>();
            BasyxTestRunner runner = new BasyxTestRunner(ENVIRONMENT, MAPPER, testFolder);
            List<BasyxFunctionalTestDefinition<GetAllSubmodelElementsPathParams, GetPathItemsResult>> defs = runner.loadFunctionalTestDefinition("getAllSubmodelElementsPath", GetAllSubmodelElementsPathParams.class, GetPathItemsResult.class);
            for (BasyxFunctionalTestDefinition<GetAllSubmodelElementsPathParams, GetPathItemsResult> eachDef : defs) {            
        	    config.add(new Object[] {eachDef.getName(), eachDef, runner});
            }            
        	return config;
        }

        /**
        * Returns all submodel elements including their hierarchy in the Path notation
        *
        * 
        *
        */
        @Test
        public void getAllSubmodelElementsPathTest() throws ApiException {                
           runner.runAndAssertWithFunctionalResult(def, this::getAllSubmodelElementsPath);            
        }
        
        private GetPathItemsResult getAllSubmodelElementsPath(GetAllSubmodelElementsPathParams params) throws ApiException {
            return api.getAllSubmodelElementsPath(params.getLimit(), params.getCursor(), params.getLevel());
        }
    }

    @RunWith(Parameterized.class)
    public static class GetDescription extends AbstractBasyxTest {

        private SubmodelServiceApi api;
        private final BasyxTestRunner runner;
        private final BasyxFunctionalTestDefinition<GetDescriptionParams, ServiceDescription> def;

        public GetDescription(String testName, BasyxFunctionalTestDefinition<GetDescriptionParams, ServiceDescription> def, BasyxTestRunner runner) {
            this.runner = runner;
            this.def = def;
        }

        @Before
        public void init() {
            this.api = new SubmodelServiceApi(MAPPER, ENVIRONMENT.getSubmodelServiceUrl());            
        }

        @Parameters(name="{0}")
        public static List<Object[]> initialize() {
            Path testFolder = Path.of(getPropertyOrThrow("basyxtest.folder"), "submodel-service");
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

        private SubmodelServiceApi api;
        private final BasyxTestRunner runner;
        private final BasyxFunctionalTestDefinition<GetFileByPathParams, File> def;

        public GetFileByPath(String testName, BasyxFunctionalTestDefinition<GetFileByPathParams, File> def, BasyxTestRunner runner) {
            this.runner = runner;
            this.def = def;
        }

        @Before
        public void init() {
            this.api = new SubmodelServiceApi(MAPPER, ENVIRONMENT.getSubmodelServiceUrl());            
        }

        @Parameters(name="{0}")
        public static List<Object[]> initialize() {
            Path testFolder = Path.of(getPropertyOrThrow("basyxtest.folder"), "submodel-service");
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
            return api.getFileByPath(params.getIdShortPath());
        }
    }

    @RunWith(Parameterized.class)
    public static class GetSubmodel extends AbstractBasyxTest {

        private SubmodelServiceApi api;
        private final BasyxTestRunner runner;
        private final BasyxFunctionalTestDefinition<GetSubmodelParams, Submodel> def;

        public GetSubmodel(String testName, BasyxFunctionalTestDefinition<GetSubmodelParams, Submodel> def, BasyxTestRunner runner) {
            this.runner = runner;
            this.def = def;
        }

        @Before
        public void init() {
            this.api = new SubmodelServiceApi(MAPPER, ENVIRONMENT.getSubmodelServiceUrl());            
        }

        @Parameters(name="{0}")
        public static List<Object[]> initialize() {
            Path testFolder = Path.of(getPropertyOrThrow("basyxtest.folder"), "submodel-service");
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
            return api.getSubmodel(params.getLevel(), params.getExtent());
        }
    }

    @RunWith(Parameterized.class)
    public static class GetSubmodelElement extends AbstractBasyxTest {

        private SubmodelServiceApi api;
        private final BasyxTestRunner runner;
        private final BasyxFunctionalTestDefinition<GetSubmodelElementParams, SubmodelElement> def;

        public GetSubmodelElement(String testName, BasyxFunctionalTestDefinition<GetSubmodelElementParams, SubmodelElement> def, BasyxTestRunner runner) {
            this.runner = runner;
            this.def = def;
        }

        @Before
        public void init() {
            this.api = new SubmodelServiceApi(MAPPER, ENVIRONMENT.getSubmodelServiceUrl());            
        }

        @Parameters(name="{0}")
        public static List<Object[]> initialize() {
            Path testFolder = Path.of(getPropertyOrThrow("basyxtest.folder"), "submodel-service");
            ArrayList<Object[]> config = new ArrayList<>();
            BasyxTestRunner runner = new BasyxTestRunner(ENVIRONMENT, MAPPER, testFolder);
            List<BasyxFunctionalTestDefinition<GetSubmodelElementParams, SubmodelElement>> defs = runner.loadFunctionalTestDefinition("getSubmodelElement", GetSubmodelElementParams.class, SubmodelElement.class);
            for (BasyxFunctionalTestDefinition<GetSubmodelElementParams, SubmodelElement> eachDef : defs) {            
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
        public void getSubmodelElementTest() throws ApiException {                
           runner.runAndAssertWithFunctionalResult(def, this::getSubmodelElement);            
        }
        
        private SubmodelElement getSubmodelElement(GetSubmodelElementParams params) throws ApiException {
            return api.getSubmodelElement(params.getIdShortPath(), params.getLevel(), params.getExtent());
        }
    }

    @RunWith(Parameterized.class)
    public static class GetSubmodelElementByPathMetadata extends AbstractBasyxTest {

        private SubmodelServiceApi api;
        private final BasyxTestRunner runner;
        private final BasyxFunctionalTestDefinition<GetSubmodelElementByPathMetadataParams, SubmodelElementMetadata> def;

        public GetSubmodelElementByPathMetadata(String testName, BasyxFunctionalTestDefinition<GetSubmodelElementByPathMetadataParams, SubmodelElementMetadata> def, BasyxTestRunner runner) {
            this.runner = runner;
            this.def = def;
        }

        @Before
        public void init() {
            this.api = new SubmodelServiceApi(MAPPER, ENVIRONMENT.getSubmodelServiceUrl());            
        }

        @Parameters(name="{0}")
        public static List<Object[]> initialize() {
            Path testFolder = Path.of(getPropertyOrThrow("basyxtest.folder"), "submodel-service");
            ArrayList<Object[]> config = new ArrayList<>();
            BasyxTestRunner runner = new BasyxTestRunner(ENVIRONMENT, MAPPER, testFolder);
            List<BasyxFunctionalTestDefinition<GetSubmodelElementByPathMetadataParams, SubmodelElementMetadata>> defs = runner.loadFunctionalTestDefinition("getSubmodelElementByPathMetadata", GetSubmodelElementByPathMetadataParams.class, SubmodelElementMetadata.class);
            for (BasyxFunctionalTestDefinition<GetSubmodelElementByPathMetadataParams, SubmodelElementMetadata> eachDef : defs) {            
        	    config.add(new Object[] {eachDef.getName(), eachDef, runner});
            }            
        	return config;
        }

        /**
        * Returns the matadata attributes of a specific submodel element from the Submodel at a specified path
        *
        * 
        *
        */
        @Test
        public void getSubmodelElementByPathMetadataTest() throws ApiException {                
           runner.runAndAssertWithFunctionalResult(def, this::getSubmodelElementByPathMetadata);            
        }
        
        private SubmodelElementMetadata getSubmodelElementByPathMetadata(GetSubmodelElementByPathMetadataParams params) throws ApiException {
            return api.getSubmodelElementByPathMetadata(params.getIdShortPath(), params.getCursor());
        }
    }

    @RunWith(Parameterized.class)
    public static class GetSubmodelElementByPathPath extends AbstractBasyxTest {

        private SubmodelServiceApi api;
        private final BasyxTestRunner runner;
        private final BasyxFunctionalTestDefinition<GetSubmodelElementByPathPathParams, String> def;

        public GetSubmodelElementByPathPath(String testName, BasyxFunctionalTestDefinition<GetSubmodelElementByPathPathParams, String> def, BasyxTestRunner runner) {
            this.runner = runner;
            this.def = def;
        }

        @Before
        public void init() {
            this.api = new SubmodelServiceApi(MAPPER, ENVIRONMENT.getSubmodelServiceUrl());            
        }

        @Parameters(name="{0}")
        public static List<Object[]> initialize() {
            Path testFolder = Path.of(getPropertyOrThrow("basyxtest.folder"), "submodel-service");
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
            return api.getSubmodelElementByPathPath(params.getIdShortPath(), params.getLevel());
        }
    }

    @RunWith(Parameterized.class)
    public static class GetSubmodelElementValue extends AbstractBasyxTest {

        private SubmodelServiceApi api;
        private final BasyxTestRunner runner;
        private final BasyxFunctionalTestDefinition<GetSubmodelElementValueParams, SubmodelElementValue> def;

        public GetSubmodelElementValue(String testName, BasyxFunctionalTestDefinition<GetSubmodelElementValueParams, SubmodelElementValue> def, BasyxTestRunner runner) {
            this.runner = runner;
            this.def = def;
        }

        @Before
        public void init() {
            this.api = new SubmodelServiceApi(MAPPER, ENVIRONMENT.getSubmodelServiceUrl());            
        }

        @Parameters(name="{0}")
        public static List<Object[]> initialize() {
            Path testFolder = Path.of(getPropertyOrThrow("basyxtest.folder"), "submodel-service");
            ArrayList<Object[]> config = new ArrayList<>();
            BasyxTestRunner runner = new BasyxTestRunner(ENVIRONMENT, MAPPER, testFolder);
            List<BasyxFunctionalTestDefinition<GetSubmodelElementValueParams, SubmodelElementValue>> defs = runner.loadFunctionalTestDefinition("getSubmodelElementValue", GetSubmodelElementValueParams.class, SubmodelElementValue.class);
            for (BasyxFunctionalTestDefinition<GetSubmodelElementValueParams, SubmodelElementValue> eachDef : defs) {            
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
        public void getSubmodelElementValueTest() throws ApiException {                
           runner.runAndAssertWithFunctionalResult(def, this::getSubmodelElementValue);            
        }
        
        private SubmodelElementValue getSubmodelElementValue(GetSubmodelElementValueParams params) throws ApiException {
            return api.getSubmodelElementValue(params.getIdShortPath(), params.getLevel(), params.getExtent());
        }
    }

    @RunWith(Parameterized.class)
    public static class GetSubmodelMetadata extends AbstractBasyxTest {

        private SubmodelServiceApi api;
        private final BasyxTestRunner runner;
        private final BasyxFunctionalTestDefinition<GetSubmodelMetadataParams, SubmodelMetadata> def;

        public GetSubmodelMetadata(String testName, BasyxFunctionalTestDefinition<GetSubmodelMetadataParams, SubmodelMetadata> def, BasyxTestRunner runner) {
            this.runner = runner;
            this.def = def;
        }

        @Before
        public void init() {
            this.api = new SubmodelServiceApi(MAPPER, ENVIRONMENT.getSubmodelServiceUrl());            
        }

        @Parameters(name="{0}")
        public static List<Object[]> initialize() {
            Path testFolder = Path.of(getPropertyOrThrow("basyxtest.folder"), "submodel-service");
            ArrayList<Object[]> config = new ArrayList<>();
            BasyxTestRunner runner = new BasyxTestRunner(ENVIRONMENT, MAPPER, testFolder);
            List<BasyxFunctionalTestDefinition<GetSubmodelMetadataParams, SubmodelMetadata>> defs = runner.loadFunctionalTestDefinition("getSubmodelMetadata", GetSubmodelMetadataParams.class, SubmodelMetadata.class);
            for (BasyxFunctionalTestDefinition<GetSubmodelMetadataParams, SubmodelMetadata> eachDef : defs) {            
        	    config.add(new Object[] {eachDef.getName(), eachDef, runner});
            }            
        	return config;
        }

        /**
        * Returns the metadata attributes of a specific Submodel
        *
        * 
        *
        */
        @Test
        public void getSubmodelMetadataTest() throws ApiException {                
           runner.runAndAssertWithFunctionalResult(def, this::getSubmodelMetadata);            
        }
        
        private SubmodelMetadata getSubmodelMetadata(GetSubmodelMetadataParams params) throws ApiException {
            return api.getSubmodelMetadata(params.getLevel());
        }
    }

    @RunWith(Parameterized.class)
    public static class GetSubmodelValue extends AbstractBasyxTest {

        private SubmodelServiceApi api;
        private final BasyxTestRunner runner;
        private final BasyxFunctionalTestDefinition<GetSubmodelValueParams, SubmodelValue> def;

        public GetSubmodelValue(String testName, BasyxFunctionalTestDefinition<GetSubmodelValueParams, SubmodelValue> def, BasyxTestRunner runner) {
            this.runner = runner;
            this.def = def;
        }

        @Before
        public void init() {
            this.api = new SubmodelServiceApi(MAPPER, ENVIRONMENT.getSubmodelServiceUrl());            
        }

        @Parameters(name="{0}")
        public static List<Object[]> initialize() {
            Path testFolder = Path.of(getPropertyOrThrow("basyxtest.folder"), "submodel-service");
            ArrayList<Object[]> config = new ArrayList<>();
            BasyxTestRunner runner = new BasyxTestRunner(ENVIRONMENT, MAPPER, testFolder);
            List<BasyxFunctionalTestDefinition<GetSubmodelValueParams, SubmodelValue>> defs = runner.loadFunctionalTestDefinition("getSubmodelValue", GetSubmodelValueParams.class, SubmodelValue.class);
            for (BasyxFunctionalTestDefinition<GetSubmodelValueParams, SubmodelValue> eachDef : defs) {            
        	    config.add(new Object[] {eachDef.getName(), eachDef, runner});
            }            
        	return config;
        }

        /**
        * Returns the Submodel in the ValueOnly representation
        *
        * 
        *
        */
        @Test
        public void getSubmodelValueTest() throws ApiException {                
           runner.runAndAssertWithFunctionalResult(def, this::getSubmodelValue);            
        }
        
        private SubmodelValue getSubmodelValue(GetSubmodelValueParams params) throws ApiException {
            return api.getSubmodelValue(params.getLevel(), params.getExtent());
        }
    }

    @RunWith(Parameterized.class)
    public static class InvokeOperation extends AbstractBasyxTest {

        private SubmodelServiceApi api;
        private final BasyxTestRunner runner;
        private final BasyxFunctionalTestDefinition<InvokeOperationParams, OperationResult> def;

        public InvokeOperation(String testName, BasyxFunctionalTestDefinition<InvokeOperationParams, OperationResult> def, BasyxTestRunner runner) {
            this.runner = runner;
            this.def = def;
        }

        @Before
        public void init() {
            this.api = new SubmodelServiceApi(MAPPER, ENVIRONMENT.getSubmodelServiceUrl());            
        }

        @Parameters(name="{0}")
        public static List<Object[]> initialize() {
            Path testFolder = Path.of(getPropertyOrThrow("basyxtest.folder"), "submodel-service");
            ArrayList<Object[]> config = new ArrayList<>();
            BasyxTestRunner runner = new BasyxTestRunner(ENVIRONMENT, MAPPER, testFolder);
            List<BasyxFunctionalTestDefinition<InvokeOperationParams, OperationResult>> defs = runner.loadFunctionalTestDefinition("invokeOperation", InvokeOperationParams.class, OperationResult.class);
            for (BasyxFunctionalTestDefinition<InvokeOperationParams, OperationResult> eachDef : defs) {            
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
        public void invokeOperationTest() throws ApiException {                
           runner.runAndAssertWithFunctionalResult(def, this::invokeOperation);            
        }
        
        private OperationResult invokeOperation(InvokeOperationParams params) throws ApiException {
            return api.invokeOperation(params.getIdShortPath(), params.getOperationRequest());
        }
    }

    @RunWith(Parameterized.class)
    public static class PatchSubmodelElementByPathMetadata extends AbstractBasyxTest {

        private SubmodelServiceApi api;
        private final BasyxTestRunner runner;
        private final BasyxVoidTestDefinition<PatchSubmodelElementByPathMetadataParams> def;

        public PatchSubmodelElementByPathMetadata(String testName, BasyxVoidTestDefinition<PatchSubmodelElementByPathMetadataParams> def, BasyxTestRunner runner) {
            this.runner = runner;
            this.def = def;
        }

        @Before
        public void init() {
            this.api = new SubmodelServiceApi(MAPPER, ENVIRONMENT.getSubmodelServiceUrl());            
        }

        @Parameters(name="{0}")
        public static List<Object[]> initialize() {
            Path testFolder = Path.of(getPropertyOrThrow("basyxtest.folder"), "submodel-service");
            ArrayList<Object[]> config = new ArrayList<>();
            BasyxTestRunner runner = new BasyxTestRunner(ENVIRONMENT, MAPPER, testFolder);
            List<BasyxVoidTestDefinition<PatchSubmodelElementByPathMetadataParams>> defs = runner.loadVoidTestDefinition("patchSubmodelElementByPathMetadata", PatchSubmodelElementByPathMetadataParams.class);
            for (BasyxVoidTestDefinition<PatchSubmodelElementByPathMetadataParams> eachDef : defs) {            
        	    config.add(new Object[] {eachDef.getName(), eachDef, runner});
            }            
        	return config;
        }

        /**
        * Updates the metadata attributes an existing SubmodelElement
        *
        * 
        *
        */
        @Test
        public void patchSubmodelElementByPathMetadataTest() throws ApiException {                
           runner.runAndAssertWithVoidResult(def, this::patchSubmodelElementByPathMetadata);            
        }
        
        private void patchSubmodelElementByPathMetadata(PatchSubmodelElementByPathMetadataParams params) throws ApiException {
            api.patchSubmodelElementByPathMetadata(params.getIdShortPath(), params.getGetSubmodelElementsMetadataResult(), params.getLimit(), params.getCursor(), params.getLevel());
        }
    }

    @RunWith(Parameterized.class)
    public static class PatchSubmodelElementValue extends AbstractBasyxTest {

        private SubmodelServiceApi api;
        private final BasyxTestRunner runner;
        private final BasyxVoidTestDefinition<PatchSubmodelElementValueParams> def;

        public PatchSubmodelElementValue(String testName, BasyxVoidTestDefinition<PatchSubmodelElementValueParams> def, BasyxTestRunner runner) {
            this.runner = runner;
            this.def = def;
        }

        @Before
        public void init() {
            this.api = new SubmodelServiceApi(MAPPER, ENVIRONMENT.getSubmodelServiceUrl());            
        }

        @Parameters(name="{0}")
        public static List<Object[]> initialize() {
            Path testFolder = Path.of(getPropertyOrThrow("basyxtest.folder"), "submodel-service");
            ArrayList<Object[]> config = new ArrayList<>();
            BasyxTestRunner runner = new BasyxTestRunner(ENVIRONMENT, MAPPER, testFolder);
            List<BasyxVoidTestDefinition<PatchSubmodelElementValueParams>> defs = runner.loadVoidTestDefinition("patchSubmodelElementValue", PatchSubmodelElementValueParams.class);
            for (BasyxVoidTestDefinition<PatchSubmodelElementValueParams> eachDef : defs) {            
        	    config.add(new Object[] {eachDef.getName(), eachDef, runner});
            }            
        	return config;
        }

        /**
        * Updates the value of an existing SubmodelElement
        *
        * 
        *
        */
        @Test
        public void patchSubmodelElementValueTest() throws ApiException {                
           runner.runAndAssertWithVoidResult(def, this::patchSubmodelElementValue);            
        }
        
        private void patchSubmodelElementValue(PatchSubmodelElementValueParams params) throws ApiException {
            api.patchSubmodelElementValue(params.getIdShortPath(), params.getSubmodelElementValue(), params.getLimit(), params.getCursor(), params.getLevel());
        }
    }

    @RunWith(Parameterized.class)
    public static class PostSubmodelElement extends AbstractBasyxTest {

        private SubmodelServiceApi api;
        private final BasyxTestRunner runner;
        private final BasyxFunctionalTestDefinition<PostSubmodelElementParams, SubmodelElement> def;

        public PostSubmodelElement(String testName, BasyxFunctionalTestDefinition<PostSubmodelElementParams, SubmodelElement> def, BasyxTestRunner runner) {
            this.runner = runner;
            this.def = def;
        }

        @Before
        public void init() {
            this.api = new SubmodelServiceApi(MAPPER, ENVIRONMENT.getSubmodelServiceUrl());            
        }

        @Parameters(name="{0}")
        public static List<Object[]> initialize() {
            Path testFolder = Path.of(getPropertyOrThrow("basyxtest.folder"), "submodel-service");
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
            return api.postSubmodelElement(params.getSubmodelElement());
        }
    }

    @RunWith(Parameterized.class)
    public static class PostSubmodelElementByPath extends AbstractBasyxTest {

        private SubmodelServiceApi api;
        private final BasyxTestRunner runner;
        private final BasyxFunctionalTestDefinition<PostSubmodelElementByPathParams, SubmodelElement> def;

        public PostSubmodelElementByPath(String testName, BasyxFunctionalTestDefinition<PostSubmodelElementByPathParams, SubmodelElement> def, BasyxTestRunner runner) {
            this.runner = runner;
            this.def = def;
        }

        @Before
        public void init() {
            this.api = new SubmodelServiceApi(MAPPER, ENVIRONMENT.getSubmodelServiceUrl());            
        }

        @Parameters(name="{0}")
        public static List<Object[]> initialize() {
            Path testFolder = Path.of(getPropertyOrThrow("basyxtest.folder"), "submodel-service");
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
            return api.postSubmodelElementByPath(params.getIdShortPath(), params.getSubmodelElement());
        }
    }

    @RunWith(Parameterized.class)
    public static class PutFileByPath extends AbstractBasyxTest {

        private SubmodelServiceApi api;
        private final BasyxTestRunner runner;
        private final BasyxVoidTestDefinition<PutFileByPathParams> def;

        public PutFileByPath(String testName, BasyxVoidTestDefinition<PutFileByPathParams> def, BasyxTestRunner runner) {
            this.runner = runner;
            this.def = def;
        }

        @Before
        public void init() {
            this.api = new SubmodelServiceApi(MAPPER, ENVIRONMENT.getSubmodelServiceUrl());            
        }

        @Parameters(name="{0}")
        public static List<Object[]> initialize() {
            Path testFolder = Path.of(getPropertyOrThrow("basyxtest.folder"), "submodel-service");
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
            api.putFileByPath(params.getIdShortPath(), params.getFileName(), params.get_file());
        }
    }

    @RunWith(Parameterized.class)
    public static class PutSubmodelElementByPath extends AbstractBasyxTest {

        private SubmodelServiceApi api;
        private final BasyxTestRunner runner;
        private final BasyxVoidTestDefinition<PutSubmodelElementByPathParams> def;

        public PutSubmodelElementByPath(String testName, BasyxVoidTestDefinition<PutSubmodelElementByPathParams> def, BasyxTestRunner runner) {
            this.runner = runner;
            this.def = def;
        }

        @Before
        public void init() {
            this.api = new SubmodelServiceApi(MAPPER, ENVIRONMENT.getSubmodelServiceUrl());            
        }

        @Parameters(name="{0}")
        public static List<Object[]> initialize() {
            Path testFolder = Path.of(getPropertyOrThrow("basyxtest.folder"), "submodel-service");
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
            api.putSubmodelElementByPath(params.getIdShortPath(), params.getSubmodelElement(), params.getLevel());
        }
    }
    private static class DeleteFileByPathParams implements BasyxTestValues {

        private String idShortPath;
        @SuppressWarnings("unused")
        public void setIdShortPath(String idShortPath) {
            this.idShortPath = idShortPath;
        }

        public String getIdShortPath() {
            return this.idShortPath;
        }
    }  
    private static class DeleteSubmodelElementParams implements BasyxTestValues {

        private String idShortPath;
        @SuppressWarnings("unused")
        public void setIdShortPath(String idShortPath) {
            this.idShortPath = idShortPath;
        }

        public String getIdShortPath() {
            return this.idShortPath;
        }
    }  
    private static class GetAllSubmodelElementsParams implements BasyxTestValues {

        private Integer limit;
        private String cursor;
        private String level;
        private String extent;
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

        private Integer limit;
        private String cursor;
        private String level;
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

        private Integer limit;
        private String cursor;
        private String level;
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
    private static class GetDescriptionParams implements BasyxTestValues {

    }  
    private static class GetFileByPathParams implements BasyxTestValues {

        private String idShortPath;
        @SuppressWarnings("unused")
        public void setIdShortPath(String idShortPath) {
            this.idShortPath = idShortPath;
        }

        public String getIdShortPath() {
            return this.idShortPath;
        }
    }  
    private static class GetSubmodelParams implements BasyxTestValues {

        private String level;
        private String extent;
        @SuppressWarnings("unused")
        public void setLevel(String level) {
            this.level = level;
        }
        @SuppressWarnings("unused")
        public void setExtent(String extent) {
            this.extent = extent;
        }

        public String getLevel() {
            return this.level;
        }

        public String getExtent() {
            return this.extent;
        }
    }  
    private static class GetSubmodelElementParams implements BasyxTestValues {

        private String idShortPath;
        private String level;
        private String extent;
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

        private String idShortPath;
        private String cursor;
        @SuppressWarnings("unused")
        public void setIdShortPath(String idShortPath) {
            this.idShortPath = idShortPath;
        }
        @SuppressWarnings("unused")
        public void setCursor(String cursor) {
            this.cursor = cursor;
        }

        public String getIdShortPath() {
            return this.idShortPath;
        }

        public String getCursor() {
            return this.cursor;
        }
    }  
    private static class GetSubmodelElementByPathPathParams implements BasyxTestValues {

        private String idShortPath;
        private String level;
        @SuppressWarnings("unused")
        public void setIdShortPath(String idShortPath) {
            this.idShortPath = idShortPath;
        }
        @SuppressWarnings("unused")
        public void setLevel(String level) {
            this.level = level;
        }

        public String getIdShortPath() {
            return this.idShortPath;
        }

        public String getLevel() {
            return this.level;
        }
    }  
    private static class GetSubmodelElementValueParams implements BasyxTestValues {

        private String idShortPath;
        private String level;
        private String extent;
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
    private static class GetSubmodelMetadataParams implements BasyxTestValues {

        private String level;
        @SuppressWarnings("unused")
        public void setLevel(String level) {
            this.level = level;
        }

        public String getLevel() {
            return this.level;
        }
    }  
    private static class GetSubmodelValueParams implements BasyxTestValues {

        private String level;
        private String extent;
        @SuppressWarnings("unused")
        public void setLevel(String level) {
            this.level = level;
        }
        @SuppressWarnings("unused")
        public void setExtent(String extent) {
            this.extent = extent;
        }

        public String getLevel() {
            return this.level;
        }

        public String getExtent() {
            return this.extent;
        }
    }  
    private static class InvokeOperationParams implements BasyxTestValues {

        private String idShortPath;
        private OperationRequest operationRequest;
        @SuppressWarnings("unused")
        public void setIdShortPath(String idShortPath) {
            this.idShortPath = idShortPath;
        }
        @SuppressWarnings("unused")
        public void setOperationRequest(OperationRequest operationRequest) {
            this.operationRequest = operationRequest;
        }

        public String getIdShortPath() {
            return this.idShortPath;
        }

        public OperationRequest getOperationRequest() {
            return this.operationRequest;
        }
    }  
    private static class PatchSubmodelElementByPathMetadataParams implements BasyxTestValues {

        private String idShortPath;
        private GetSubmodelElementsMetadataResult getSubmodelElementsMetadataResult;
        private Integer limit;
        private String cursor;
        private String level;
        @SuppressWarnings("unused")
        public void setIdShortPath(String idShortPath) {
            this.idShortPath = idShortPath;
        }
        @SuppressWarnings("unused")
        public void setGetSubmodelElementsMetadataResult(GetSubmodelElementsMetadataResult getSubmodelElementsMetadataResult) {
            this.getSubmodelElementsMetadataResult = getSubmodelElementsMetadataResult;
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

        public String getIdShortPath() {
            return this.idShortPath;
        }

        public GetSubmodelElementsMetadataResult getGetSubmodelElementsMetadataResult() {
            return this.getSubmodelElementsMetadataResult;
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
    private static class PatchSubmodelElementValueParams implements BasyxTestValues {

        private String idShortPath;
        private SubmodelElementValue submodelElementValue;
        private Integer limit;
        private String cursor;
        private String level;
        @SuppressWarnings("unused")
        public void setIdShortPath(String idShortPath) {
            this.idShortPath = idShortPath;
        }
        @SuppressWarnings("unused")
        public void setSubmodelElementValue(SubmodelElementValue submodelElementValue) {
            this.submodelElementValue = submodelElementValue;
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

        public String getIdShortPath() {
            return this.idShortPath;
        }

        public SubmodelElementValue getSubmodelElementValue() {
            return this.submodelElementValue;
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
    private static class PostSubmodelElementParams implements BasyxTestValues {

        private SubmodelElement submodelElement;
        @SuppressWarnings("unused")
        public void setSubmodelElement(SubmodelElement submodelElement) {
            this.submodelElement = submodelElement;
        }

        public SubmodelElement getSubmodelElement() {
            return this.submodelElement;
        }
    }  
    private static class PostSubmodelElementByPathParams implements BasyxTestValues {

        private String idShortPath;
        private SubmodelElement submodelElement;
        @SuppressWarnings("unused")
        public void setIdShortPath(String idShortPath) {
            this.idShortPath = idShortPath;
        }
        @SuppressWarnings("unused")
        public void setSubmodelElement(SubmodelElement submodelElement) {
            this.submodelElement = submodelElement;
        }

        public String getIdShortPath() {
            return this.idShortPath;
        }

        public SubmodelElement getSubmodelElement() {
            return this.submodelElement;
        }
    }  
    private static class PutFileByPathParams implements BasyxTestValues {

        private String idShortPath;
        private String fileName;
        private File _file;
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
    private static class PutSubmodelElementByPathParams implements BasyxTestValues {

        private String idShortPath;
        private SubmodelElement submodelElement;
        private String level;
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
}    
