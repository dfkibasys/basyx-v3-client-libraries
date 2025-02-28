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
import org.eclipse.digitaltwin.aas4j.v3.model.ConceptDescription;
import org.eclipse.digitaltwin.aas4j.v3.model.Environment;
import java.io.File;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part2.GetConceptDescriptionsResult;
import org.eclipse.digitaltwin.aas4j.v3.model.Result;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part2.ServiceDescription;
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
 * API tests for ConceptDescriptionRepositoryApi
 */
public class ConceptDescriptionRepositoryApiTest {


    public ConceptDescriptionRepositoryApiTest() {
    }

    private static String getPropertyOrThrow(String propName) {
    	String prop = System.getProperty(propName);
	    if (prop == null) {
	    	throw new IllegalArgumentException("Property '" + propName + "' not set.");
	    }
	    return prop;
    }

    
    @RunWith(Parameterized.class)
    public static class DeleteConceptDescriptionById extends AbstractBasyxTest {

        private ConceptDescriptionRepositoryApi api;
        private final BasyxTestRunner runner;
        private final BasyxVoidTestDefinition<DeleteConceptDescriptionByIdParams> def;

        public DeleteConceptDescriptionById(String testName, BasyxVoidTestDefinition<DeleteConceptDescriptionByIdParams> def, BasyxTestRunner runner) {
            this.runner = runner;
            this.def = def;
        }

        @Before
        public void init() {
            this.api = new ConceptDescriptionRepositoryApi(MAPPER, ENVIRONMENT.getCdRepositoryUrl());            
        }

        @Parameters(name="{0}")
        public static List<Object[]> initialize() {
            Path testFolder = Path.of(getPropertyOrThrow("basyxtest.folder"), "cd-repository");
            ArrayList<Object[]> config = new ArrayList<>();
            BasyxTestRunner runner = new BasyxTestRunner(ENVIRONMENT, MAPPER, testFolder);
            List<BasyxVoidTestDefinition<DeleteConceptDescriptionByIdParams>> defs = runner.loadVoidTestDefinition("deleteConceptDescriptionById", DeleteConceptDescriptionByIdParams.class);
            for (BasyxVoidTestDefinition<DeleteConceptDescriptionByIdParams> eachDef : defs) {            
        	    config.add(new Object[] {eachDef.getName(), eachDef, runner});
            }            
        	return config;
        }

        /**
        * Deletes a Concept Description
        *
        * 
        *
        */
        @Test
        public void deleteConceptDescriptionByIdTest() throws ApiException {                
           runner.runAndAssertWithVoidResult(def, this::deleteConceptDescriptionById);            
        }
        
        private void deleteConceptDescriptionById(DeleteConceptDescriptionByIdParams params) throws ApiException {
            api.deleteConceptDescriptionById(params.getCdIdentifier());
        }
    }

    @RunWith(Parameterized.class)
    public static class GenerateSerializationByIds extends AbstractBasyxTest {

        private ConceptDescriptionRepositoryApi api;
        private final BasyxTestRunner runner;
        private final BasyxFunctionalTestDefinition<GenerateSerializationByIdsParams, File> def;

        public GenerateSerializationByIds(String testName, BasyxFunctionalTestDefinition<GenerateSerializationByIdsParams, File> def, BasyxTestRunner runner) {
            this.runner = runner;
            this.def = def;
        }

        @Before
        public void init() {
            this.api = new ConceptDescriptionRepositoryApi(MAPPER, ENVIRONMENT.getCdRepositoryUrl());            
        }

        @Parameters(name="{0}")
        public static List<Object[]> initialize() {
            Path testFolder = Path.of(getPropertyOrThrow("basyxtest.folder"), "cd-repository");
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
    public static class GetAllConceptDescriptions extends AbstractBasyxTest {

        private ConceptDescriptionRepositoryApi api;
        private final BasyxTestRunner runner;
        private final BasyxFunctionalTestDefinition<GetAllConceptDescriptionsParams, GetConceptDescriptionsResult> def;

        public GetAllConceptDescriptions(String testName, BasyxFunctionalTestDefinition<GetAllConceptDescriptionsParams, GetConceptDescriptionsResult> def, BasyxTestRunner runner) {
            this.runner = runner;
            this.def = def;
        }

        @Before
        public void init() {
            this.api = new ConceptDescriptionRepositoryApi(MAPPER, ENVIRONMENT.getCdRepositoryUrl());            
        }

        @Parameters(name="{0}")
        public static List<Object[]> initialize() {
            Path testFolder = Path.of(getPropertyOrThrow("basyxtest.folder"), "cd-repository");
            ArrayList<Object[]> config = new ArrayList<>();
            BasyxTestRunner runner = new BasyxTestRunner(ENVIRONMENT, MAPPER, testFolder);
            List<BasyxFunctionalTestDefinition<GetAllConceptDescriptionsParams, GetConceptDescriptionsResult>> defs = runner.loadFunctionalTestDefinition("getAllConceptDescriptions", GetAllConceptDescriptionsParams.class, GetConceptDescriptionsResult.class);
            for (BasyxFunctionalTestDefinition<GetAllConceptDescriptionsParams, GetConceptDescriptionsResult> eachDef : defs) {            
        	    config.add(new Object[] {eachDef.getName(), eachDef, runner});
            }            
        	return config;
        }

        /**
        * Returns all Concept Descriptions
        *
        * 
        *
        */
        @Test
        public void getAllConceptDescriptionsTest() throws ApiException {                
           runner.runAndAssertWithFunctionalResult(def, this::getAllConceptDescriptions);            
        }
        
        private GetConceptDescriptionsResult getAllConceptDescriptions(GetAllConceptDescriptionsParams params) throws ApiException {
            return api.getAllConceptDescriptions(params.getIdShort(), params.getIsCaseOf(), params.getDataSpecificationRef(), params.getLimit(), params.getCursor());
        }
    }

    @RunWith(Parameterized.class)
    public static class GetConceptDescriptionById extends AbstractBasyxTest {

        private ConceptDescriptionRepositoryApi api;
        private final BasyxTestRunner runner;
        private final BasyxFunctionalTestDefinition<GetConceptDescriptionByIdParams, ConceptDescription> def;

        public GetConceptDescriptionById(String testName, BasyxFunctionalTestDefinition<GetConceptDescriptionByIdParams, ConceptDescription> def, BasyxTestRunner runner) {
            this.runner = runner;
            this.def = def;
        }

        @Before
        public void init() {
            this.api = new ConceptDescriptionRepositoryApi(MAPPER, ENVIRONMENT.getCdRepositoryUrl());            
        }

        @Parameters(name="{0}")
        public static List<Object[]> initialize() {
            Path testFolder = Path.of(getPropertyOrThrow("basyxtest.folder"), "cd-repository");
            ArrayList<Object[]> config = new ArrayList<>();
            BasyxTestRunner runner = new BasyxTestRunner(ENVIRONMENT, MAPPER, testFolder);
            List<BasyxFunctionalTestDefinition<GetConceptDescriptionByIdParams, ConceptDescription>> defs = runner.loadFunctionalTestDefinition("getConceptDescriptionById", GetConceptDescriptionByIdParams.class, ConceptDescription.class);
            for (BasyxFunctionalTestDefinition<GetConceptDescriptionByIdParams, ConceptDescription> eachDef : defs) {            
        	    config.add(new Object[] {eachDef.getName(), eachDef, runner});
            }            
        	return config;
        }

        /**
        * Returns a specific Concept Description
        *
        * 
        *
        */
        @Test
        public void getConceptDescriptionByIdTest() throws ApiException {                
           runner.runAndAssertWithFunctionalResult(def, this::getConceptDescriptionById);            
        }
        
        private ConceptDescription getConceptDescriptionById(GetConceptDescriptionByIdParams params) throws ApiException {
            return api.getConceptDescriptionById(params.getCdIdentifier());
        }
    }

    @RunWith(Parameterized.class)
    public static class GetDescription extends AbstractBasyxTest {

        private ConceptDescriptionRepositoryApi api;
        private final BasyxTestRunner runner;
        private final BasyxFunctionalTestDefinition<GetDescriptionParams, ServiceDescription> def;

        public GetDescription(String testName, BasyxFunctionalTestDefinition<GetDescriptionParams, ServiceDescription> def, BasyxTestRunner runner) {
            this.runner = runner;
            this.def = def;
        }

        @Before
        public void init() {
            this.api = new ConceptDescriptionRepositoryApi(MAPPER, ENVIRONMENT.getCdRepositoryUrl());            
        }

        @Parameters(name="{0}")
        public static List<Object[]> initialize() {
            Path testFolder = Path.of(getPropertyOrThrow("basyxtest.folder"), "cd-repository");
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
    public static class PostConceptDescription extends AbstractBasyxTest {

        private ConceptDescriptionRepositoryApi api;
        private final BasyxTestRunner runner;
        private final BasyxFunctionalTestDefinition<PostConceptDescriptionParams, ConceptDescription> def;

        public PostConceptDescription(String testName, BasyxFunctionalTestDefinition<PostConceptDescriptionParams, ConceptDescription> def, BasyxTestRunner runner) {
            this.runner = runner;
            this.def = def;
        }

        @Before
        public void init() {
            this.api = new ConceptDescriptionRepositoryApi(MAPPER, ENVIRONMENT.getCdRepositoryUrl());            
        }

        @Parameters(name="{0}")
        public static List<Object[]> initialize() {
            Path testFolder = Path.of(getPropertyOrThrow("basyxtest.folder"), "cd-repository");
            ArrayList<Object[]> config = new ArrayList<>();
            BasyxTestRunner runner = new BasyxTestRunner(ENVIRONMENT, MAPPER, testFolder);
            List<BasyxFunctionalTestDefinition<PostConceptDescriptionParams, ConceptDescription>> defs = runner.loadFunctionalTestDefinition("postConceptDescription", PostConceptDescriptionParams.class, ConceptDescription.class);
            for (BasyxFunctionalTestDefinition<PostConceptDescriptionParams, ConceptDescription> eachDef : defs) {            
        	    config.add(new Object[] {eachDef.getName(), eachDef, runner});
            }            
        	return config;
        }

        /**
        * Creates a new Concept Description
        *
        * 
        *
        */
        @Test
        public void postConceptDescriptionTest() throws ApiException {                
           runner.runAndAssertWithFunctionalResult(def, this::postConceptDescription);            
        }
        
        private ConceptDescription postConceptDescription(PostConceptDescriptionParams params) throws ApiException {
            return api.postConceptDescription(params.getConceptDescription());
        }
    }

    @RunWith(Parameterized.class)
    public static class PutConceptDescriptionById extends AbstractBasyxTest {

        private ConceptDescriptionRepositoryApi api;
        private final BasyxTestRunner runner;
        private final BasyxVoidTestDefinition<PutConceptDescriptionByIdParams> def;

        public PutConceptDescriptionById(String testName, BasyxVoidTestDefinition<PutConceptDescriptionByIdParams> def, BasyxTestRunner runner) {
            this.runner = runner;
            this.def = def;
        }

        @Before
        public void init() {
            this.api = new ConceptDescriptionRepositoryApi(MAPPER, ENVIRONMENT.getCdRepositoryUrl());            
        }

        @Parameters(name="{0}")
        public static List<Object[]> initialize() {
            Path testFolder = Path.of(getPropertyOrThrow("basyxtest.folder"), "cd-repository");
            ArrayList<Object[]> config = new ArrayList<>();
            BasyxTestRunner runner = new BasyxTestRunner(ENVIRONMENT, MAPPER, testFolder);
            List<BasyxVoidTestDefinition<PutConceptDescriptionByIdParams>> defs = runner.loadVoidTestDefinition("putConceptDescriptionById", PutConceptDescriptionByIdParams.class);
            for (BasyxVoidTestDefinition<PutConceptDescriptionByIdParams> eachDef : defs) {            
        	    config.add(new Object[] {eachDef.getName(), eachDef, runner});
            }            
        	return config;
        }

        /**
        * Updates an existing Concept Description
        *
        * 
        *
        */
        @Test
        public void putConceptDescriptionByIdTest() throws ApiException {                
           runner.runAndAssertWithVoidResult(def, this::putConceptDescriptionById);            
        }
        
        private void putConceptDescriptionById(PutConceptDescriptionByIdParams params) throws ApiException {
            api.putConceptDescriptionById(params.getCdIdentifier(), params.getConceptDescription());
        }
    }
    private static class DeleteConceptDescriptionByIdParams implements BasyxTestValues {

        private String cdIdentifier;
        @SuppressWarnings("unused")
        public void setCdIdentifier(String cdIdentifier) {
            this.cdIdentifier = cdIdentifier;
        }

        public String getCdIdentifier() {
            return this.cdIdentifier;
        }
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
    private static class GetAllConceptDescriptionsParams implements BasyxTestValues {

        private String idShort;
        private String isCaseOf;
        private String dataSpecificationRef;
        private Integer limit;
        private String cursor;
        @SuppressWarnings("unused")
        public void setIdShort(String idShort) {
            this.idShort = idShort;
        }
        @SuppressWarnings("unused")
        public void setIsCaseOf(String isCaseOf) {
            this.isCaseOf = isCaseOf;
        }
        @SuppressWarnings("unused")
        public void setDataSpecificationRef(String dataSpecificationRef) {
            this.dataSpecificationRef = dataSpecificationRef;
        }
        @SuppressWarnings("unused")
        public void setLimit(Integer limit) {
            this.limit = limit;
        }
        @SuppressWarnings("unused")
        public void setCursor(String cursor) {
            this.cursor = cursor;
        }

        public String getIdShort() {
            return this.idShort;
        }

        public String getIsCaseOf() {
            return this.isCaseOf;
        }

        public String getDataSpecificationRef() {
            return this.dataSpecificationRef;
        }

        public Integer getLimit() {
            return this.limit;
        }

        public String getCursor() {
            return this.cursor;
        }
    }  
    private static class GetConceptDescriptionByIdParams implements BasyxTestValues {

        private String cdIdentifier;
        @SuppressWarnings("unused")
        public void setCdIdentifier(String cdIdentifier) {
            this.cdIdentifier = cdIdentifier;
        }

        public String getCdIdentifier() {
            return this.cdIdentifier;
        }
    }  
    private static class GetDescriptionParams implements BasyxTestValues {

    }  
    private static class PostConceptDescriptionParams implements BasyxTestValues {

        private ConceptDescription conceptDescription;
        @SuppressWarnings("unused")
        public void setConceptDescription(ConceptDescription conceptDescription) {
            this.conceptDescription = conceptDescription;
        }

        public ConceptDescription getConceptDescription() {
            return this.conceptDescription;
        }
    }  
    private static class PutConceptDescriptionByIdParams implements BasyxTestValues {

        private String cdIdentifier;
        private ConceptDescription conceptDescription;
        @SuppressWarnings("unused")
        public void setCdIdentifier(String cdIdentifier) {
            this.cdIdentifier = cdIdentifier;
        }
        @SuppressWarnings("unused")
        public void setConceptDescription(ConceptDescription conceptDescription) {
            this.conceptDescription = conceptDescription;
        }

        public String getCdIdentifier() {
            return this.cdIdentifier;
        }

        public ConceptDescription getConceptDescription() {
            return this.conceptDescription;
        }
    }  
}    
