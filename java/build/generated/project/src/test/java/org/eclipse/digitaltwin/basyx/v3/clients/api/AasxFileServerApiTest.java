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
import org.eclipse.digitaltwin.basyx.v3.clients.model.part2.GetPackageDescriptionsResult;
import org.eclipse.digitaltwin.aas4j.v3.model.PackageDescription;
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
 * API tests for AasxFileServerApi
 */
public class AasxFileServerApiTest {


    public AasxFileServerApiTest() {
    }

    private static String getPropertyOrThrow(String propName) {
    	String prop = System.getProperty(propName);
	    if (prop == null) {
	    	throw new IllegalArgumentException("Property '" + propName + "' not set.");
	    }
	    return prop;
    }

    
    @RunWith(Parameterized.class)
    public static class DeleteAASXByPackageId extends AbstractBasyxTest {

        private AasxFileServerApi api;
        private final BasyxTestRunner runner;
        private final BasyxVoidTestDefinition<DeleteAASXByPackageIdParams> def;

        public DeleteAASXByPackageId(String testName, BasyxVoidTestDefinition<DeleteAASXByPackageIdParams> def, BasyxTestRunner runner) {
            this.runner = runner;
            this.def = def;
        }

        @Before
        public void init() {
            this.api = new AasxFileServerApi(MAPPER, ENVIRONMENT.getAasxFileserverUrl());            
        }

        @Parameters(name="{0}")
        public static List<Object[]> initialize() {
            Path testFolder = Path.of(getPropertyOrThrow("basyxtest.folder"), "aasx-fileserver");
            ArrayList<Object[]> config = new ArrayList<>();
            BasyxTestRunner runner = new BasyxTestRunner(ENVIRONMENT, MAPPER, testFolder);
            List<BasyxVoidTestDefinition<DeleteAASXByPackageIdParams>> defs = runner.loadVoidTestDefinition("deleteAASXByPackageId", DeleteAASXByPackageIdParams.class);
            for (BasyxVoidTestDefinition<DeleteAASXByPackageIdParams> eachDef : defs) {            
        	    config.add(new Object[] {eachDef.getName(), eachDef, runner});
            }            
        	return config;
        }

        /**
        * Deletes a specific AASX package from the server
        *
        * 
        *
        */
        @Test
        public void deleteAASXByPackageIdTest() throws ApiException {                
           runner.runAndAssertWithVoidResult(def, this::deleteAASXByPackageId);            
        }
        
        private void deleteAASXByPackageId(DeleteAASXByPackageIdParams params) throws ApiException {
            api.deleteAASXByPackageId(params.getPackageId());
        }
    }

    @RunWith(Parameterized.class)
    public static class GetAASXByPackageId extends AbstractBasyxTest {

        private AasxFileServerApi api;
        private final BasyxTestRunner runner;
        private final BasyxFunctionalTestDefinition<GetAASXByPackageIdParams, File> def;

        public GetAASXByPackageId(String testName, BasyxFunctionalTestDefinition<GetAASXByPackageIdParams, File> def, BasyxTestRunner runner) {
            this.runner = runner;
            this.def = def;
        }

        @Before
        public void init() {
            this.api = new AasxFileServerApi(MAPPER, ENVIRONMENT.getAasxFileserverUrl());            
        }

        @Parameters(name="{0}")
        public static List<Object[]> initialize() {
            Path testFolder = Path.of(getPropertyOrThrow("basyxtest.folder"), "aasx-fileserver");
            ArrayList<Object[]> config = new ArrayList<>();
            BasyxTestRunner runner = new BasyxTestRunner(ENVIRONMENT, MAPPER, testFolder);
            List<BasyxFunctionalTestDefinition<GetAASXByPackageIdParams, File>> defs = runner.loadFunctionalTestDefinition("getAASXByPackageId", GetAASXByPackageIdParams.class, File.class);
            for (BasyxFunctionalTestDefinition<GetAASXByPackageIdParams, File> eachDef : defs) {            
        	    config.add(new Object[] {eachDef.getName(), eachDef, runner});
            }            
        	return config;
        }

        /**
        * Returns a specific AASX package from the server
        *
        * 
        *
        */
        @Test
        public void getAASXByPackageIdTest() throws ApiException {                
           runner.runAndAssertWithFunctionalResult(def, this::getAASXByPackageId);            
        }
        
        private File getAASXByPackageId(GetAASXByPackageIdParams params) throws ApiException {
            return api.getAASXByPackageId(params.getPackageId());
        }
    }

    @RunWith(Parameterized.class)
    public static class GetAllAASXPackageIds extends AbstractBasyxTest {

        private AasxFileServerApi api;
        private final BasyxTestRunner runner;
        private final BasyxFunctionalTestDefinition<GetAllAASXPackageIdsParams, GetPackageDescriptionsResult> def;

        public GetAllAASXPackageIds(String testName, BasyxFunctionalTestDefinition<GetAllAASXPackageIdsParams, GetPackageDescriptionsResult> def, BasyxTestRunner runner) {
            this.runner = runner;
            this.def = def;
        }

        @Before
        public void init() {
            this.api = new AasxFileServerApi(MAPPER, ENVIRONMENT.getAasxFileserverUrl());            
        }

        @Parameters(name="{0}")
        public static List<Object[]> initialize() {
            Path testFolder = Path.of(getPropertyOrThrow("basyxtest.folder"), "aasx-fileserver");
            ArrayList<Object[]> config = new ArrayList<>();
            BasyxTestRunner runner = new BasyxTestRunner(ENVIRONMENT, MAPPER, testFolder);
            List<BasyxFunctionalTestDefinition<GetAllAASXPackageIdsParams, GetPackageDescriptionsResult>> defs = runner.loadFunctionalTestDefinition("getAllAASXPackageIds", GetAllAASXPackageIdsParams.class, GetPackageDescriptionsResult.class);
            for (BasyxFunctionalTestDefinition<GetAllAASXPackageIdsParams, GetPackageDescriptionsResult> eachDef : defs) {            
        	    config.add(new Object[] {eachDef.getName(), eachDef, runner});
            }            
        	return config;
        }

        /**
        * Returns a list of available AASX packages at the server
        *
        * 
        *
        */
        @Test
        public void getAllAASXPackageIdsTest() throws ApiException {                
           runner.runAndAssertWithFunctionalResult(def, this::getAllAASXPackageIds);            
        }
        
        private GetPackageDescriptionsResult getAllAASXPackageIds(GetAllAASXPackageIdsParams params) throws ApiException {
            return api.getAllAASXPackageIds(params.getAasId(), params.getLimit(), params.getCursor());
        }
    }

    @RunWith(Parameterized.class)
    public static class GetDescription extends AbstractBasyxTest {

        private AasxFileServerApi api;
        private final BasyxTestRunner runner;
        private final BasyxFunctionalTestDefinition<GetDescriptionParams, ServiceDescription> def;

        public GetDescription(String testName, BasyxFunctionalTestDefinition<GetDescriptionParams, ServiceDescription> def, BasyxTestRunner runner) {
            this.runner = runner;
            this.def = def;
        }

        @Before
        public void init() {
            this.api = new AasxFileServerApi(MAPPER, ENVIRONMENT.getAasxFileserverUrl());            
        }

        @Parameters(name="{0}")
        public static List<Object[]> initialize() {
            Path testFolder = Path.of(getPropertyOrThrow("basyxtest.folder"), "aasx-fileserver");
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
    public static class PostAASXPackage extends AbstractBasyxTest {

        private AasxFileServerApi api;
        private final BasyxTestRunner runner;
        private final BasyxFunctionalTestDefinition<PostAASXPackageParams, PackageDescription> def;

        public PostAASXPackage(String testName, BasyxFunctionalTestDefinition<PostAASXPackageParams, PackageDescription> def, BasyxTestRunner runner) {
            this.runner = runner;
            this.def = def;
        }

        @Before
        public void init() {
            this.api = new AasxFileServerApi(MAPPER, ENVIRONMENT.getAasxFileserverUrl());            
        }

        @Parameters(name="{0}")
        public static List<Object[]> initialize() {
            Path testFolder = Path.of(getPropertyOrThrow("basyxtest.folder"), "aasx-fileserver");
            ArrayList<Object[]> config = new ArrayList<>();
            BasyxTestRunner runner = new BasyxTestRunner(ENVIRONMENT, MAPPER, testFolder);
            List<BasyxFunctionalTestDefinition<PostAASXPackageParams, PackageDescription>> defs = runner.loadFunctionalTestDefinition("postAASXPackage", PostAASXPackageParams.class, PackageDescription.class);
            for (BasyxFunctionalTestDefinition<PostAASXPackageParams, PackageDescription> eachDef : defs) {            
        	    config.add(new Object[] {eachDef.getName(), eachDef, runner});
            }            
        	return config;
        }

        /**
        * Stores the AASX package at the server
        *
        * 
        *
        */
        @Test
        public void postAASXPackageTest() throws ApiException {                
           runner.runAndAssertWithFunctionalResult(def, this::postAASXPackage);            
        }
        
        private PackageDescription postAASXPackage(PostAASXPackageParams params) throws ApiException {
            return api.postAASXPackage(params.getAasIds(), params.get_file(), params.getFileName());
        }
    }

    @RunWith(Parameterized.class)
    public static class PutAASXByPackageId extends AbstractBasyxTest {

        private AasxFileServerApi api;
        private final BasyxTestRunner runner;
        private final BasyxVoidTestDefinition<PutAASXByPackageIdParams> def;

        public PutAASXByPackageId(String testName, BasyxVoidTestDefinition<PutAASXByPackageIdParams> def, BasyxTestRunner runner) {
            this.runner = runner;
            this.def = def;
        }

        @Before
        public void init() {
            this.api = new AasxFileServerApi(MAPPER, ENVIRONMENT.getAasxFileserverUrl());            
        }

        @Parameters(name="{0}")
        public static List<Object[]> initialize() {
            Path testFolder = Path.of(getPropertyOrThrow("basyxtest.folder"), "aasx-fileserver");
            ArrayList<Object[]> config = new ArrayList<>();
            BasyxTestRunner runner = new BasyxTestRunner(ENVIRONMENT, MAPPER, testFolder);
            List<BasyxVoidTestDefinition<PutAASXByPackageIdParams>> defs = runner.loadVoidTestDefinition("putAASXByPackageId", PutAASXByPackageIdParams.class);
            for (BasyxVoidTestDefinition<PutAASXByPackageIdParams> eachDef : defs) {            
        	    config.add(new Object[] {eachDef.getName(), eachDef, runner});
            }            
        	return config;
        }

        /**
        * Updates the AASX package at the server
        *
        * 
        *
        */
        @Test
        public void putAASXByPackageIdTest() throws ApiException {                
           runner.runAndAssertWithVoidResult(def, this::putAASXByPackageId);            
        }
        
        private void putAASXByPackageId(PutAASXByPackageIdParams params) throws ApiException {
            api.putAASXByPackageId(params.getPackageId(), params.getAasIds(), params.get_file(), params.getFileName());
        }
    }
    private static class DeleteAASXByPackageIdParams implements BasyxTestValues {

        private String packageId;
        @SuppressWarnings("unused")
        public void setPackageId(String packageId) {
            this.packageId = packageId;
        }

        public String getPackageId() {
            return this.packageId;
        }
    }  
    private static class GetAASXByPackageIdParams implements BasyxTestValues {

        private String packageId;
        @SuppressWarnings("unused")
        public void setPackageId(String packageId) {
            this.packageId = packageId;
        }

        public String getPackageId() {
            return this.packageId;
        }
    }  
    private static class GetAllAASXPackageIdsParams implements BasyxTestValues {

        private String aasId;
        private Integer limit;
        private String cursor;
        @SuppressWarnings("unused")
        public void setAasId(String aasId) {
            this.aasId = aasId;
        }
        @SuppressWarnings("unused")
        public void setLimit(Integer limit) {
            this.limit = limit;
        }
        @SuppressWarnings("unused")
        public void setCursor(String cursor) {
            this.cursor = cursor;
        }

        public String getAasId() {
            return this.aasId;
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
    private static class PostAASXPackageParams implements BasyxTestValues {

        private List<String> aasIds;
        private File _file;
        private String fileName;
        @SuppressWarnings("unused")
        public void setAasIds(List<String> aasIds) {
            this.aasIds = aasIds;
        }
        @SuppressWarnings("unused")
        public void set_file(File _file) {
            this._file = _file;
        }
        @SuppressWarnings("unused")
        public void setFileName(String fileName) {
            this.fileName = fileName;
        }

        public List<String> getAasIds() {
            return this.aasIds;
        }

        public File get_file() {
            return this._file;
        }

        public String getFileName() {
            return this.fileName;
        }
    }  
    private static class PutAASXByPackageIdParams implements BasyxTestValues {

        private String packageId;
        private List<String> aasIds;
        private File _file;
        private String fileName;
        @SuppressWarnings("unused")
        public void setPackageId(String packageId) {
            this.packageId = packageId;
        }
        @SuppressWarnings("unused")
        public void setAasIds(List<String> aasIds) {
            this.aasIds = aasIds;
        }
        @SuppressWarnings("unused")
        public void set_file(File _file) {
            this._file = _file;
        }
        @SuppressWarnings("unused")
        public void setFileName(String fileName) {
            this.fileName = fileName;
        }

        public String getPackageId() {
            return this.packageId;
        }

        public List<String> getAasIds() {
            return this.aasIds;
        }

        public File get_file() {
            return this._file;
        }

        public String getFileName() {
            return this.fileName;
        }
    }  
}    
