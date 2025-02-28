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
import org.eclipse.digitaltwin.basyx.v3.clients.model.part2.GetSubmodelElementsResult;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part2.GetSubmodelsResult;
import org.eclipse.digitaltwin.aas4j.v3.model.OperationRequest;
import org.eclipse.digitaltwin.aas4j.v3.model.OperationResult;
import org.eclipse.digitaltwin.aas4j.v3.model.Result;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part2.ServiceDescription;
import org.eclipse.digitaltwin.aas4j.v3.model.Submodel;
import org.eclipse.digitaltwin.aas4j.v3.model.SubmodelElement;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part2.SubmodelElementValue;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part2.SubmodelMetadata;
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
 * API tests for SubmodelRepositoryApi
 */
public class SubmodelRepositoryApiTest {


    public SubmodelRepositoryApiTest() {
    }

    private static String getPropertyOrThrow(String propName) {
    	String prop = System.getProperty(propName);
	    if (prop == null) {
	    	throw new IllegalArgumentException("Property '" + propName + "' not set.");
	    }
	    return prop;
    }

    
    @RunWith(Parameterized.class)
    public static class DeleteFileAttachment extends AbstractBasyxTest {

        private SubmodelRepositoryApi api;
        private final BasyxTestRunner runner;
        private final BasyxVoidTestDefinition<DeleteFileAttachmentParams> def;

        public DeleteFileAttachment(String testName, BasyxVoidTestDefinition<DeleteFileAttachmentParams> def, BasyxTestRunner runner) {
            this.runner = runner;
            this.def = def;
        }

        @Before
        public void init() {
            this.api = new SubmodelRepositoryApi(MAPPER, ENVIRONMENT.getSubmodelRepositoryUrl());            
        }

        @Parameters(name="{0}")
        public static List<Object[]> initialize() {
            Path testFolder = Path.of(getPropertyOrThrow("basyxtest.folder"), "submodel-repository");
            ArrayList<Object[]> config = new ArrayList<>();
            BasyxTestRunner runner = new BasyxTestRunner(ENVIRONMENT, MAPPER, testFolder);
            List<BasyxVoidTestDefinition<DeleteFileAttachmentParams>> defs = runner.loadVoidTestDefinition("deleteFileAttachment", DeleteFileAttachmentParams.class);
            for (BasyxVoidTestDefinition<DeleteFileAttachmentParams> eachDef : defs) {            
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
        public void deleteFileAttachmentTest() throws ApiException {                
           runner.runAndAssertWithVoidResult(def, this::deleteFileAttachment);            
        }
        
        private void deleteFileAttachment(DeleteFileAttachmentParams params) throws ApiException {
            api.deleteFileAttachment(params.getSubmodelIdentifier(), params.getIdShortPath());
        }
    }

    @RunWith(Parameterized.class)
    public static class DeleteSubmodel extends AbstractBasyxTest {

        private SubmodelRepositoryApi api;
        private final BasyxTestRunner runner;
        private final BasyxVoidTestDefinition<DeleteSubmodelParams> def;

        public DeleteSubmodel(String testName, BasyxVoidTestDefinition<DeleteSubmodelParams> def, BasyxTestRunner runner) {
            this.runner = runner;
            this.def = def;
        }

        @Before
        public void init() {
            this.api = new SubmodelRepositoryApi(MAPPER, ENVIRONMENT.getSubmodelRepositoryUrl());            
        }

        @Parameters(name="{0}")
        public static List<Object[]> initialize() {
            Path testFolder = Path.of(getPropertyOrThrow("basyxtest.folder"), "submodel-repository");
            ArrayList<Object[]> config = new ArrayList<>();
            BasyxTestRunner runner = new BasyxTestRunner(ENVIRONMENT, MAPPER, testFolder);
            List<BasyxVoidTestDefinition<DeleteSubmodelParams>> defs = runner.loadVoidTestDefinition("deleteSubmodel", DeleteSubmodelParams.class);
            for (BasyxVoidTestDefinition<DeleteSubmodelParams> eachDef : defs) {            
        	    config.add(new Object[] {eachDef.getName(), eachDef, runner});
            }            
        	return config;
        }

        /**
        * Deletes a Submodel
        *
        * 
        *
        */
        @Test
        public void deleteSubmodelTest() throws ApiException {                
           runner.runAndAssertWithVoidResult(def, this::deleteSubmodel);            
        }
        
        private void deleteSubmodel(DeleteSubmodelParams params) throws ApiException {
            api.deleteSubmodel(params.getSubmodelIdentifier());
        }
    }

    @RunWith(Parameterized.class)
    public static class DeleteSubmodelElement extends AbstractBasyxTest {

        private SubmodelRepositoryApi api;
        private final BasyxTestRunner runner;
        private final BasyxVoidTestDefinition<DeleteSubmodelElementParams> def;

        public DeleteSubmodelElement(String testName, BasyxVoidTestDefinition<DeleteSubmodelElementParams> def, BasyxTestRunner runner) {
            this.runner = runner;
            this.def = def;
        }

        @Before
        public void init() {
            this.api = new SubmodelRepositoryApi(MAPPER, ENVIRONMENT.getSubmodelRepositoryUrl());            
        }

        @Parameters(name="{0}")
        public static List<Object[]> initialize() {
            Path testFolder = Path.of(getPropertyOrThrow("basyxtest.folder"), "submodel-repository");
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
            api.deleteSubmodelElement(params.getSubmodelIdentifier(), params.getIdShortPath());
        }
    }

    @RunWith(Parameterized.class)
    public static class GetAllSubmodelElements extends AbstractBasyxTest {

        private SubmodelRepositoryApi api;
        private final BasyxTestRunner runner;
        private final BasyxFunctionalTestDefinition<GetAllSubmodelElementsParams, GetSubmodelElementsResult> def;

        public GetAllSubmodelElements(String testName, BasyxFunctionalTestDefinition<GetAllSubmodelElementsParams, GetSubmodelElementsResult> def, BasyxTestRunner runner) {
            this.runner = runner;
            this.def = def;
        }

        @Before
        public void init() {
            this.api = new SubmodelRepositoryApi(MAPPER, ENVIRONMENT.getSubmodelRepositoryUrl());            
        }

        @Parameters(name="{0}")
        public static List<Object[]> initialize() {
            Path testFolder = Path.of(getPropertyOrThrow("basyxtest.folder"), "submodel-repository");
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
    public static class GetAllSubmodels extends AbstractBasyxTest {

        private SubmodelRepositoryApi api;
        private final BasyxTestRunner runner;
        private final BasyxFunctionalTestDefinition<GetAllSubmodelsParams, GetSubmodelsResult> def;

        public GetAllSubmodels(String testName, BasyxFunctionalTestDefinition<GetAllSubmodelsParams, GetSubmodelsResult> def, BasyxTestRunner runner) {
            this.runner = runner;
            this.def = def;
        }

        @Before
        public void init() {
            this.api = new SubmodelRepositoryApi(MAPPER, ENVIRONMENT.getSubmodelRepositoryUrl());            
        }

        @Parameters(name="{0}")
        public static List<Object[]> initialize() {
            Path testFolder = Path.of(getPropertyOrThrow("basyxtest.folder"), "submodel-repository");
            ArrayList<Object[]> config = new ArrayList<>();
            BasyxTestRunner runner = new BasyxTestRunner(ENVIRONMENT, MAPPER, testFolder);
            List<BasyxFunctionalTestDefinition<GetAllSubmodelsParams, GetSubmodelsResult>> defs = runner.loadFunctionalTestDefinition("getAllSubmodels", GetAllSubmodelsParams.class, GetSubmodelsResult.class);
            for (BasyxFunctionalTestDefinition<GetAllSubmodelsParams, GetSubmodelsResult> eachDef : defs) {            
        	    config.add(new Object[] {eachDef.getName(), eachDef, runner});
            }            
        	return config;
        }

        /**
        * Returns all Submodels
        *
        * 
        *
        */
        @Test
        public void getAllSubmodelsTest() throws ApiException {                
           runner.runAndAssertWithFunctionalResult(def, this::getAllSubmodels);            
        }
        
        private GetSubmodelsResult getAllSubmodels(GetAllSubmodelsParams params) throws ApiException {
            return api.getAllSubmodels(params.getSemanticId(), params.getIdShort(), params.getLimit(), params.getCursor(), params.getLevel(), params.getExtent());
        }
    }

    @RunWith(Parameterized.class)
    public static class GetDescription extends AbstractBasyxTest {

        private SubmodelRepositoryApi api;
        private final BasyxTestRunner runner;
        private final BasyxFunctionalTestDefinition<GetDescriptionParams, ServiceDescription> def;

        public GetDescription(String testName, BasyxFunctionalTestDefinition<GetDescriptionParams, ServiceDescription> def, BasyxTestRunner runner) {
            this.runner = runner;
            this.def = def;
        }

        @Before
        public void init() {
            this.api = new SubmodelRepositoryApi(MAPPER, ENVIRONMENT.getSubmodelRepositoryUrl());            
        }

        @Parameters(name="{0}")
        public static List<Object[]> initialize() {
            Path testFolder = Path.of(getPropertyOrThrow("basyxtest.folder"), "submodel-repository");
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
    public static class GetFileAttachment extends AbstractBasyxTest {

        private SubmodelRepositoryApi api;
        private final BasyxTestRunner runner;
        private final BasyxFunctionalTestDefinition<GetFileAttachmentParams, File> def;

        public GetFileAttachment(String testName, BasyxFunctionalTestDefinition<GetFileAttachmentParams, File> def, BasyxTestRunner runner) {
            this.runner = runner;
            this.def = def;
        }

        @Before
        public void init() {
            this.api = new SubmodelRepositoryApi(MAPPER, ENVIRONMENT.getSubmodelRepositoryUrl());            
        }

        @Parameters(name="{0}")
        public static List<Object[]> initialize() {
            Path testFolder = Path.of(getPropertyOrThrow("basyxtest.folder"), "submodel-repository");
            ArrayList<Object[]> config = new ArrayList<>();
            BasyxTestRunner runner = new BasyxTestRunner(ENVIRONMENT, MAPPER, testFolder);
            List<BasyxFunctionalTestDefinition<GetFileAttachmentParams, File>> defs = runner.loadFunctionalTestDefinition("getFileAttachment", GetFileAttachmentParams.class, File.class);
            for (BasyxFunctionalTestDefinition<GetFileAttachmentParams, File> eachDef : defs) {            
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
        public void getFileAttachmentTest() throws ApiException {                
           runner.runAndAssertWithFunctionalResult(def, this::getFileAttachment);            
        }
        
        private File getFileAttachment(GetFileAttachmentParams params) throws ApiException {
            java.io.InputStream in = api.getFileAttachment(params.getSubmodelIdentifier(), params.getIdShortPath());
            try {
				Path temp = java.nio.file.Files.createTempFile("getFileAttachment", ".tmp");
				java.nio.file.Files.copy(in, temp, java.nio.file.StandardCopyOption.REPLACE_EXISTING);
				return temp.toFile();
			} catch (java.io.IOException e) {
				throw new ApiException(e);
			}            
        }
    }

    @RunWith(Parameterized.class)
    public static class GetSubmodel extends AbstractBasyxTest {

        private SubmodelRepositoryApi api;
        private final BasyxTestRunner runner;
        private final BasyxFunctionalTestDefinition<GetSubmodelParams, Submodel> def;

        public GetSubmodel(String testName, BasyxFunctionalTestDefinition<GetSubmodelParams, Submodel> def, BasyxTestRunner runner) {
            this.runner = runner;
            this.def = def;
        }

        @Before
        public void init() {
            this.api = new SubmodelRepositoryApi(MAPPER, ENVIRONMENT.getSubmodelRepositoryUrl());            
        }

        @Parameters(name="{0}")
        public static List<Object[]> initialize() {
            Path testFolder = Path.of(getPropertyOrThrow("basyxtest.folder"), "submodel-repository");
            ArrayList<Object[]> config = new ArrayList<>();
            BasyxTestRunner runner = new BasyxTestRunner(ENVIRONMENT, MAPPER, testFolder);
            List<BasyxFunctionalTestDefinition<GetSubmodelParams, Submodel>> defs = runner.loadFunctionalTestDefinition("getSubmodel", GetSubmodelParams.class, Submodel.class);
            for (BasyxFunctionalTestDefinition<GetSubmodelParams, Submodel> eachDef : defs) {            
        	    config.add(new Object[] {eachDef.getName(), eachDef, runner});
            }            
        	return config;
        }

        /**
        * Returns a specific Submodel
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
    public static class GetSubmodelElement extends AbstractBasyxTest {

        private SubmodelRepositoryApi api;
        private final BasyxTestRunner runner;
        private final BasyxFunctionalTestDefinition<GetSubmodelElementParams, SubmodelElement> def;

        public GetSubmodelElement(String testName, BasyxFunctionalTestDefinition<GetSubmodelElementParams, SubmodelElement> def, BasyxTestRunner runner) {
            this.runner = runner;
            this.def = def;
        }

        @Before
        public void init() {
            this.api = new SubmodelRepositoryApi(MAPPER, ENVIRONMENT.getSubmodelRepositoryUrl());            
        }

        @Parameters(name="{0}")
        public static List<Object[]> initialize() {
            Path testFolder = Path.of(getPropertyOrThrow("basyxtest.folder"), "submodel-repository");
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
            return api.getSubmodelElement(params.getSubmodelIdentifier(), params.getIdShortPath(), params.getLevel(), params.getExtent());
        }
    }

    @RunWith(Parameterized.class)
    public static class GetSubmodelElementValue extends AbstractBasyxTest {

        private SubmodelRepositoryApi api;
        private final BasyxTestRunner runner;
        private final BasyxFunctionalTestDefinition<GetSubmodelElementValueParams, SubmodelElementValue> def;

        public GetSubmodelElementValue(String testName, BasyxFunctionalTestDefinition<GetSubmodelElementValueParams, SubmodelElementValue> def, BasyxTestRunner runner) {
            this.runner = runner;
            this.def = def;
        }

        @Before
        public void init() {
            this.api = new SubmodelRepositoryApi(MAPPER, ENVIRONMENT.getSubmodelRepositoryUrl());            
        }

        @Parameters(name="{0}")
        public static List<Object[]> initialize() {
            Path testFolder = Path.of(getPropertyOrThrow("basyxtest.folder"), "submodel-repository");
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
            return api.getSubmodelElementValue(params.getSubmodelIdentifier(), params.getIdShortPath(), params.getLevel(), params.getExtent());
        }
    }

    @RunWith(Parameterized.class)
    public static class GetSubmodelMetadata extends AbstractBasyxTest {

        private SubmodelRepositoryApi api;
        private final BasyxTestRunner runner;
        private final BasyxFunctionalTestDefinition<GetSubmodelMetadataParams, SubmodelMetadata> def;

        public GetSubmodelMetadata(String testName, BasyxFunctionalTestDefinition<GetSubmodelMetadataParams, SubmodelMetadata> def, BasyxTestRunner runner) {
            this.runner = runner;
            this.def = def;
        }

        @Before
        public void init() {
            this.api = new SubmodelRepositoryApi(MAPPER, ENVIRONMENT.getSubmodelRepositoryUrl());            
        }

        @Parameters(name="{0}")
        public static List<Object[]> initialize() {
            Path testFolder = Path.of(getPropertyOrThrow("basyxtest.folder"), "submodel-repository");
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
            return api.getSubmodelMetadata(params.getSubmodelIdentifier(), params.getLevel());
        }
    }

    @RunWith(Parameterized.class)
    public static class InvokeOperation extends AbstractBasyxTest {

        private SubmodelRepositoryApi api;
        private final BasyxTestRunner runner;
        private final BasyxFunctionalTestDefinition<InvokeOperationParams, OperationResult> def;

        public InvokeOperation(String testName, BasyxFunctionalTestDefinition<InvokeOperationParams, OperationResult> def, BasyxTestRunner runner) {
            this.runner = runner;
            this.def = def;
        }

        @Before
        public void init() {
            this.api = new SubmodelRepositoryApi(MAPPER, ENVIRONMENT.getSubmodelRepositoryUrl());            
        }

        @Parameters(name="{0}")
        public static List<Object[]> initialize() {
            Path testFolder = Path.of(getPropertyOrThrow("basyxtest.folder"), "submodel-repository");
            ArrayList<Object[]> config = new ArrayList<>();
            BasyxTestRunner runner = new BasyxTestRunner(ENVIRONMENT, MAPPER, testFolder);
            List<BasyxFunctionalTestDefinition<InvokeOperationParams, OperationResult>> defs = runner.loadFunctionalTestDefinition("invokeOperation", InvokeOperationParams.class, OperationResult.class);
            for (BasyxFunctionalTestDefinition<InvokeOperationParams, OperationResult> eachDef : defs) {            
        	    config.add(new Object[] {eachDef.getName(), eachDef, runner});
            }            
        	return config;
        }

        /**
        * Synchronously or asynchronously invokes an Operation at a specified path
        *
        * 
        *
        */
        @Test
        public void invokeOperationTest() throws ApiException {                
           runner.runAndAssertWithFunctionalResult(def, this::invokeOperation);            
        }
        
        private OperationResult invokeOperation(InvokeOperationParams params) throws ApiException {
            return api.invokeOperation(params.getSubmodelIdentifier(), params.getIdShortPath(), params.getOperationRequest(), params.getAsync());
        }
    }

    @RunWith(Parameterized.class)
    public static class PatchSubmodelElementValue extends AbstractBasyxTest {

        private SubmodelRepositoryApi api;
        private final BasyxTestRunner runner;
        private final BasyxVoidTestDefinition<PatchSubmodelElementValueParams> def;

        public PatchSubmodelElementValue(String testName, BasyxVoidTestDefinition<PatchSubmodelElementValueParams> def, BasyxTestRunner runner) {
            this.runner = runner;
            this.def = def;
        }

        @Before
        public void init() {
            this.api = new SubmodelRepositoryApi(MAPPER, ENVIRONMENT.getSubmodelRepositoryUrl());            
        }

        @Parameters(name="{0}")
        public static List<Object[]> initialize() {
            Path testFolder = Path.of(getPropertyOrThrow("basyxtest.folder"), "submodel-repository");
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
            api.patchSubmodelElementValue(params.getSubmodelIdentifier(), params.getIdShortPath(), params.getSubmodelElementValue(), params.getLevel());
        }
    }

    @RunWith(Parameterized.class)
    public static class PostSubmodel extends AbstractBasyxTest {

        private SubmodelRepositoryApi api;
        private final BasyxTestRunner runner;
        private final BasyxFunctionalTestDefinition<PostSubmodelParams, Submodel> def;

        public PostSubmodel(String testName, BasyxFunctionalTestDefinition<PostSubmodelParams, Submodel> def, BasyxTestRunner runner) {
            this.runner = runner;
            this.def = def;
        }

        @Before
        public void init() {
            this.api = new SubmodelRepositoryApi(MAPPER, ENVIRONMENT.getSubmodelRepositoryUrl());            
        }

        @Parameters(name="{0}")
        public static List<Object[]> initialize() {
            Path testFolder = Path.of(getPropertyOrThrow("basyxtest.folder"), "submodel-repository");
            ArrayList<Object[]> config = new ArrayList<>();
            BasyxTestRunner runner = new BasyxTestRunner(ENVIRONMENT, MAPPER, testFolder);
            List<BasyxFunctionalTestDefinition<PostSubmodelParams, Submodel>> defs = runner.loadFunctionalTestDefinition("postSubmodel", PostSubmodelParams.class, Submodel.class);
            for (BasyxFunctionalTestDefinition<PostSubmodelParams, Submodel> eachDef : defs) {            
        	    config.add(new Object[] {eachDef.getName(), eachDef, runner});
            }            
        	return config;
        }

        /**
        * Creates a new Submodel
        *
        * 
        *
        */
        @Test
        public void postSubmodelTest() throws ApiException {                
           runner.runAndAssertWithFunctionalResult(def, this::postSubmodel);            
        }
        
        private Submodel postSubmodel(PostSubmodelParams params) throws ApiException {
            return api.postSubmodel(params.getSubmodel());
        }
    }

    @RunWith(Parameterized.class)
    public static class PostSubmodelElement extends AbstractBasyxTest {

        private SubmodelRepositoryApi api;
        private final BasyxTestRunner runner;
        private final BasyxFunctionalTestDefinition<PostSubmodelElementParams, SubmodelElement> def;

        public PostSubmodelElement(String testName, BasyxFunctionalTestDefinition<PostSubmodelElementParams, SubmodelElement> def, BasyxTestRunner runner) {
            this.runner = runner;
            this.def = def;
        }

        @Before
        public void init() {
            this.api = new SubmodelRepositoryApi(MAPPER, ENVIRONMENT.getSubmodelRepositoryUrl());            
        }

        @Parameters(name="{0}")
        public static List<Object[]> initialize() {
            Path testFolder = Path.of(getPropertyOrThrow("basyxtest.folder"), "submodel-repository");
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
    public static class PostSubmodelElementUnderPath extends AbstractBasyxTest {

        private SubmodelRepositoryApi api;
        private final BasyxTestRunner runner;
        private final BasyxFunctionalTestDefinition<PostSubmodelElementUnderPathParams, SubmodelElement> def;

        public PostSubmodelElementUnderPath(String testName, BasyxFunctionalTestDefinition<PostSubmodelElementUnderPathParams, SubmodelElement> def, BasyxTestRunner runner) {
            this.runner = runner;
            this.def = def;
        }

        @Before
        public void init() {
            this.api = new SubmodelRepositoryApi(MAPPER, ENVIRONMENT.getSubmodelRepositoryUrl());            
        }

        @Parameters(name="{0}")
        public static List<Object[]> initialize() {
            Path testFolder = Path.of(getPropertyOrThrow("basyxtest.folder"), "submodel-repository");
            ArrayList<Object[]> config = new ArrayList<>();
            BasyxTestRunner runner = new BasyxTestRunner(ENVIRONMENT, MAPPER, testFolder);
            List<BasyxFunctionalTestDefinition<PostSubmodelElementUnderPathParams, SubmodelElement>> defs = runner.loadFunctionalTestDefinition("postSubmodelElementUnderPath", PostSubmodelElementUnderPathParams.class, SubmodelElement.class);
            for (BasyxFunctionalTestDefinition<PostSubmodelElementUnderPathParams, SubmodelElement> eachDef : defs) {            
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
        public void postSubmodelElementUnderPathTest() throws ApiException {                
           runner.runAndAssertWithFunctionalResult(def, this::postSubmodelElementUnderPath);            
        }
        
        private SubmodelElement postSubmodelElementUnderPath(PostSubmodelElementUnderPathParams params) throws ApiException {
            return api.postSubmodelElementUnderPath(params.getSubmodelIdentifier(), params.getIdShortPath(), params.getSubmodelElement());
        }
    }

    @RunWith(Parameterized.class)
    public static class PutFileAttachment extends AbstractBasyxTest {

        private SubmodelRepositoryApi api;
        private final BasyxTestRunner runner;
        private final BasyxVoidTestDefinition<PutFileAttachmentParams> def;

        public PutFileAttachment(String testName, BasyxVoidTestDefinition<PutFileAttachmentParams> def, BasyxTestRunner runner) {
            this.runner = runner;
            this.def = def;
        }

        @Before
        public void init() {
            this.api = new SubmodelRepositoryApi(MAPPER, ENVIRONMENT.getSubmodelRepositoryUrl());            
        }

        @Parameters(name="{0}")
        public static List<Object[]> initialize() {
            Path testFolder = Path.of(getPropertyOrThrow("basyxtest.folder"), "submodel-repository");
            ArrayList<Object[]> config = new ArrayList<>();
            BasyxTestRunner runner = new BasyxTestRunner(ENVIRONMENT, MAPPER, testFolder);
            List<BasyxVoidTestDefinition<PutFileAttachmentParams>> defs = runner.loadVoidTestDefinition("putFileAttachment", PutFileAttachmentParams.class);
            for (BasyxVoidTestDefinition<PutFileAttachmentParams> eachDef : defs) {            
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
        public void putFileAttachmentTest() throws ApiException {                
           runner.runAndAssertWithVoidResult(def, this::putFileAttachment);            
        }
        
        private void putFileAttachment(PutFileAttachmentParams params) throws ApiException {
            api.putFileAttachment(params.getSubmodelIdentifier(), params.getIdShortPath(), params.getFileName(), params.get_file());
        }
    }

    @RunWith(Parameterized.class)
    public static class PutSubmodel extends AbstractBasyxTest {

        private SubmodelRepositoryApi api;
        private final BasyxTestRunner runner;
        private final BasyxVoidTestDefinition<PutSubmodelParams> def;

        public PutSubmodel(String testName, BasyxVoidTestDefinition<PutSubmodelParams> def, BasyxTestRunner runner) {
            this.runner = runner;
            this.def = def;
        }

        @Before
        public void init() {
            this.api = new SubmodelRepositoryApi(MAPPER, ENVIRONMENT.getSubmodelRepositoryUrl());            
        }

        @Parameters(name="{0}")
        public static List<Object[]> initialize() {
            Path testFolder = Path.of(getPropertyOrThrow("basyxtest.folder"), "submodel-repository");
            ArrayList<Object[]> config = new ArrayList<>();
            BasyxTestRunner runner = new BasyxTestRunner(ENVIRONMENT, MAPPER, testFolder);
            List<BasyxVoidTestDefinition<PutSubmodelParams>> defs = runner.loadVoidTestDefinition("putSubmodel", PutSubmodelParams.class);
            for (BasyxVoidTestDefinition<PutSubmodelParams> eachDef : defs) {            
        	    config.add(new Object[] {eachDef.getName(), eachDef, runner});
            }            
        	return config;
        }

        /**
        * Updates an existing Submodel
        *
        * 
        *
        */
        @Test
        public void putSubmodelTest() throws ApiException {                
           runner.runAndAssertWithVoidResult(def, this::putSubmodel);            
        }
        
        private void putSubmodel(PutSubmodelParams params) throws ApiException {
            api.putSubmodel(params.getSubmodelIdentifier(), params.getSubmodel());
        }
    }

    @RunWith(Parameterized.class)
    public static class PutSubmodelElement extends AbstractBasyxTest {

        private SubmodelRepositoryApi api;
        private final BasyxTestRunner runner;
        private final BasyxVoidTestDefinition<PutSubmodelElementParams> def;

        public PutSubmodelElement(String testName, BasyxVoidTestDefinition<PutSubmodelElementParams> def, BasyxTestRunner runner) {
            this.runner = runner;
            this.def = def;
        }

        @Before
        public void init() {
            this.api = new SubmodelRepositoryApi(MAPPER, ENVIRONMENT.getSubmodelRepositoryUrl());            
        }

        @Parameters(name="{0}")
        public static List<Object[]> initialize() {
            Path testFolder = Path.of(getPropertyOrThrow("basyxtest.folder"), "submodel-repository");
            ArrayList<Object[]> config = new ArrayList<>();
            BasyxTestRunner runner = new BasyxTestRunner(ENVIRONMENT, MAPPER, testFolder);
            List<BasyxVoidTestDefinition<PutSubmodelElementParams>> defs = runner.loadVoidTestDefinition("putSubmodelElement", PutSubmodelElementParams.class);
            for (BasyxVoidTestDefinition<PutSubmodelElementParams> eachDef : defs) {            
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
        public void putSubmodelElementTest() throws ApiException {                
           runner.runAndAssertWithVoidResult(def, this::putSubmodelElement);            
        }
        
        private void putSubmodelElement(PutSubmodelElementParams params) throws ApiException {
            api.putSubmodelElement(params.getSubmodelIdentifier(), params.getIdShortPath(), params.getSubmodelElement(), params.getLevel());
        }
    }
    private static class DeleteFileAttachmentParams implements BasyxTestValues {

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
    private static class DeleteSubmodelParams implements BasyxTestValues {

        private String submodelIdentifier;
        @SuppressWarnings("unused")
        public void setSubmodelIdentifier(String submodelIdentifier) {
            this.submodelIdentifier = submodelIdentifier;
        }

        public String getSubmodelIdentifier() {
            return this.submodelIdentifier;
        }
    }  
    private static class DeleteSubmodelElementParams implements BasyxTestValues {

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
    private static class GetAllSubmodelsParams implements BasyxTestValues {

        private String semanticId;
        private String idShort;
        private Integer limit;
        private String cursor;
        private String level;
        private String extent;
        @SuppressWarnings("unused")
        public void setSemanticId(String semanticId) {
            this.semanticId = semanticId;
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
        @SuppressWarnings("unused")
        public void setLevel(String level) {
            this.level = level;
        }
        @SuppressWarnings("unused")
        public void setExtent(String extent) {
            this.extent = extent;
        }

        public String getSemanticId() {
            return this.semanticId;
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

        public String getLevel() {
            return this.level;
        }

        public String getExtent() {
            return this.extent;
        }
    }  
    private static class GetDescriptionParams implements BasyxTestValues {

    }  
    private static class GetFileAttachmentParams implements BasyxTestValues {

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
    private static class GetSubmodelElementParams implements BasyxTestValues {

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
    private static class GetSubmodelElementValueParams implements BasyxTestValues {

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
    private static class InvokeOperationParams implements BasyxTestValues {

        private String submodelIdentifier;
        private String idShortPath;
        private OperationRequest operationRequest;
        private Boolean async;
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
        @SuppressWarnings("unused")
        public void setAsync(Boolean async) {
            this.async = async;
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

        public Boolean getAsync() {
            return this.async;
        }
    }  
    private static class PatchSubmodelElementValueParams implements BasyxTestValues {

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
    private static class PostSubmodelParams implements BasyxTestValues {

        private Submodel submodel;
        @SuppressWarnings("unused")
        public void setSubmodel(Submodel submodel) {
            this.submodel = submodel;
        }

        public Submodel getSubmodel() {
            return this.submodel;
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
    private static class PostSubmodelElementUnderPathParams implements BasyxTestValues {

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
    private static class PutFileAttachmentParams implements BasyxTestValues {

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
        @SuppressWarnings("unused")
        public void setSubmodelIdentifier(String submodelIdentifier) {
            this.submodelIdentifier = submodelIdentifier;
        }
        @SuppressWarnings("unused")
        public void setSubmodel(Submodel submodel) {
            this.submodel = submodel;
        }

        public String getSubmodelIdentifier() {
            return this.submodelIdentifier;
        }

        public Submodel getSubmodel() {
            return this.submodel;
        }
    }  
    private static class PutSubmodelElementParams implements BasyxTestValues {

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
}    
