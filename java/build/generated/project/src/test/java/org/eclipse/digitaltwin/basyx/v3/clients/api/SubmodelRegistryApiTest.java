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
import org.eclipse.digitaltwin.basyx.v3.clients.model.part2.GetSubmodelDescriptorsResult;
import org.eclipse.digitaltwin.aas4j.v3.model.Result;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part2.ServiceDescription;
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
 * API tests for SubmodelRegistryApi
 */
public class SubmodelRegistryApiTest {


    public SubmodelRegistryApiTest() {
    }

    private static String getPropertyOrThrow(String propName) {
    	String prop = System.getProperty(propName);
	    if (prop == null) {
	    	throw new IllegalArgumentException("Property '" + propName + "' not set.");
	    }
	    return prop;
    }

    
    @RunWith(Parameterized.class)
    public static class DeleteSubmodelDescriptorById extends AbstractBasyxTest {

        private SubmodelRegistryApi api;
        private final BasyxTestRunner runner;
        private final BasyxVoidTestDefinition<DeleteSubmodelDescriptorByIdParams> def;

        public DeleteSubmodelDescriptorById(String testName, BasyxVoidTestDefinition<DeleteSubmodelDescriptorByIdParams> def, BasyxTestRunner runner) {
            this.runner = runner;
            this.def = def;
        }

        @Before
        public void init() {
            this.api = new SubmodelRegistryApi(MAPPER, ENVIRONMENT.getSubmodelRegistryUrl());            
        }

        @Parameters(name="{0}")
        public static List<Object[]> initialize() {
            Path testFolder = Path.of(getPropertyOrThrow("basyxtest.folder"), "submodel-registry");
            ArrayList<Object[]> config = new ArrayList<>();
            BasyxTestRunner runner = new BasyxTestRunner(ENVIRONMENT, MAPPER, testFolder);
            List<BasyxVoidTestDefinition<DeleteSubmodelDescriptorByIdParams>> defs = runner.loadVoidTestDefinition("deleteSubmodelDescriptorById", DeleteSubmodelDescriptorByIdParams.class);
            for (BasyxVoidTestDefinition<DeleteSubmodelDescriptorByIdParams> eachDef : defs) {            
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
        public void deleteSubmodelDescriptorByIdTest() throws ApiException {                
           runner.runAndAssertWithVoidResult(def, this::deleteSubmodelDescriptorById);            
        }
        
        private void deleteSubmodelDescriptorById(DeleteSubmodelDescriptorByIdParams params) throws ApiException {
            api.deleteSubmodelDescriptorById(params.getSubmodelIdentifier());
        }
    }

    @RunWith(Parameterized.class)
    public static class GetAllSubmodelDescriptors extends AbstractBasyxTest {

        private SubmodelRegistryApi api;
        private final BasyxTestRunner runner;
        private final BasyxFunctionalTestDefinition<GetAllSubmodelDescriptorsParams, GetSubmodelDescriptorsResult> def;

        public GetAllSubmodelDescriptors(String testName, BasyxFunctionalTestDefinition<GetAllSubmodelDescriptorsParams, GetSubmodelDescriptorsResult> def, BasyxTestRunner runner) {
            this.runner = runner;
            this.def = def;
        }

        @Before
        public void init() {
            this.api = new SubmodelRegistryApi(MAPPER, ENVIRONMENT.getSubmodelRegistryUrl());            
        }

        @Parameters(name="{0}")
        public static List<Object[]> initialize() {
            Path testFolder = Path.of(getPropertyOrThrow("basyxtest.folder"), "submodel-registry");
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
            return api.getAllSubmodelDescriptors(params.getLimit(), params.getCursor());
        }
    }

    @RunWith(Parameterized.class)
    public static class GetDescription extends AbstractBasyxTest {

        private SubmodelRegistryApi api;
        private final BasyxTestRunner runner;
        private final BasyxFunctionalTestDefinition<GetDescriptionParams, ServiceDescription> def;

        public GetDescription(String testName, BasyxFunctionalTestDefinition<GetDescriptionParams, ServiceDescription> def, BasyxTestRunner runner) {
            this.runner = runner;
            this.def = def;
        }

        @Before
        public void init() {
            this.api = new SubmodelRegistryApi(MAPPER, ENVIRONMENT.getSubmodelRegistryUrl());            
        }

        @Parameters(name="{0}")
        public static List<Object[]> initialize() {
            Path testFolder = Path.of(getPropertyOrThrow("basyxtest.folder"), "submodel-registry");
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
    public static class GetSubmodelDescriptorById extends AbstractBasyxTest {

        private SubmodelRegistryApi api;
        private final BasyxTestRunner runner;
        private final BasyxFunctionalTestDefinition<GetSubmodelDescriptorByIdParams, SubmodelDescriptor> def;

        public GetSubmodelDescriptorById(String testName, BasyxFunctionalTestDefinition<GetSubmodelDescriptorByIdParams, SubmodelDescriptor> def, BasyxTestRunner runner) {
            this.runner = runner;
            this.def = def;
        }

        @Before
        public void init() {
            this.api = new SubmodelRegistryApi(MAPPER, ENVIRONMENT.getSubmodelRegistryUrl());            
        }

        @Parameters(name="{0}")
        public static List<Object[]> initialize() {
            Path testFolder = Path.of(getPropertyOrThrow("basyxtest.folder"), "submodel-registry");
            ArrayList<Object[]> config = new ArrayList<>();
            BasyxTestRunner runner = new BasyxTestRunner(ENVIRONMENT, MAPPER, testFolder);
            List<BasyxFunctionalTestDefinition<GetSubmodelDescriptorByIdParams, SubmodelDescriptor>> defs = runner.loadFunctionalTestDefinition("getSubmodelDescriptorById", GetSubmodelDescriptorByIdParams.class, SubmodelDescriptor.class);
            for (BasyxFunctionalTestDefinition<GetSubmodelDescriptorByIdParams, SubmodelDescriptor> eachDef : defs) {            
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
        public void getSubmodelDescriptorByIdTest() throws ApiException {                
           runner.runAndAssertWithFunctionalResult(def, this::getSubmodelDescriptorById);            
        }
        
        private SubmodelDescriptor getSubmodelDescriptorById(GetSubmodelDescriptorByIdParams params) throws ApiException {
            return api.getSubmodelDescriptorById(params.getSubmodelIdentifier());
        }
    }

    @RunWith(Parameterized.class)
    public static class PostSubmodelDescriptor extends AbstractBasyxTest {

        private SubmodelRegistryApi api;
        private final BasyxTestRunner runner;
        private final BasyxFunctionalTestDefinition<PostSubmodelDescriptorParams, SubmodelDescriptor> def;

        public PostSubmodelDescriptor(String testName, BasyxFunctionalTestDefinition<PostSubmodelDescriptorParams, SubmodelDescriptor> def, BasyxTestRunner runner) {
            this.runner = runner;
            this.def = def;
        }

        @Before
        public void init() {
            this.api = new SubmodelRegistryApi(MAPPER, ENVIRONMENT.getSubmodelRegistryUrl());            
        }

        @Parameters(name="{0}")
        public static List<Object[]> initialize() {
            Path testFolder = Path.of(getPropertyOrThrow("basyxtest.folder"), "submodel-registry");
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
            return api.postSubmodelDescriptor(params.getSubmodelDescriptor());
        }
    }

    @RunWith(Parameterized.class)
    public static class PutSubmodelDescriptorById extends AbstractBasyxTest {

        private SubmodelRegistryApi api;
        private final BasyxTestRunner runner;
        private final BasyxVoidTestDefinition<PutSubmodelDescriptorByIdParams> def;

        public PutSubmodelDescriptorById(String testName, BasyxVoidTestDefinition<PutSubmodelDescriptorByIdParams> def, BasyxTestRunner runner) {
            this.runner = runner;
            this.def = def;
        }

        @Before
        public void init() {
            this.api = new SubmodelRegistryApi(MAPPER, ENVIRONMENT.getSubmodelRegistryUrl());            
        }

        @Parameters(name="{0}")
        public static List<Object[]> initialize() {
            Path testFolder = Path.of(getPropertyOrThrow("basyxtest.folder"), "submodel-registry");
            ArrayList<Object[]> config = new ArrayList<>();
            BasyxTestRunner runner = new BasyxTestRunner(ENVIRONMENT, MAPPER, testFolder);
            List<BasyxVoidTestDefinition<PutSubmodelDescriptorByIdParams>> defs = runner.loadVoidTestDefinition("putSubmodelDescriptorById", PutSubmodelDescriptorByIdParams.class);
            for (BasyxVoidTestDefinition<PutSubmodelDescriptorByIdParams> eachDef : defs) {            
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
        public void putSubmodelDescriptorByIdTest() throws ApiException {                
           runner.runAndAssertWithVoidResult(def, this::putSubmodelDescriptorById);            
        }
        
        private void putSubmodelDescriptorById(PutSubmodelDescriptorByIdParams params) throws ApiException {
            api.putSubmodelDescriptorById(params.getSubmodelIdentifier(), params.getSubmodelDescriptor());
        }
    }
    private static class DeleteSubmodelDescriptorByIdParams implements BasyxTestValues {

        private String submodelIdentifier;
        @SuppressWarnings("unused")
        public void setSubmodelIdentifier(String submodelIdentifier) {
            this.submodelIdentifier = submodelIdentifier;
        }

        public String getSubmodelIdentifier() {
            return this.submodelIdentifier;
        }
    }  
    private static class GetAllSubmodelDescriptorsParams implements BasyxTestValues {

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
    private static class GetDescriptionParams implements BasyxTestValues {

    }  
    private static class GetSubmodelDescriptorByIdParams implements BasyxTestValues {

        private String submodelIdentifier;
        @SuppressWarnings("unused")
        public void setSubmodelIdentifier(String submodelIdentifier) {
            this.submodelIdentifier = submodelIdentifier;
        }

        public String getSubmodelIdentifier() {
            return this.submodelIdentifier;
        }
    }  
    private static class PostSubmodelDescriptorParams implements BasyxTestValues {

        private SubmodelDescriptor submodelDescriptor;
        @SuppressWarnings("unused")
        public void setSubmodelDescriptor(SubmodelDescriptor submodelDescriptor) {
            this.submodelDescriptor = submodelDescriptor;
        }

        public SubmodelDescriptor getSubmodelDescriptor() {
            return this.submodelDescriptor;
        }
    }  
    private static class PutSubmodelDescriptorByIdParams implements BasyxTestValues {

        private String submodelIdentifier;
        private SubmodelDescriptor submodelDescriptor;
        @SuppressWarnings("unused")
        public void setSubmodelIdentifier(String submodelIdentifier) {
            this.submodelIdentifier = submodelIdentifier;
        }
        @SuppressWarnings("unused")
        public void setSubmodelDescriptor(SubmodelDescriptor submodelDescriptor) {
            this.submodelDescriptor = submodelDescriptor;
        }

        public String getSubmodelIdentifier() {
            return this.submodelIdentifier;
        }

        public SubmodelDescriptor getSubmodelDescriptor() {
            return this.submodelDescriptor;
        }
    }  
}    
