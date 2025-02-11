// TODO: better import syntax?
import {BaseAPIRequestFactory, RequiredError, COLLECTION_FORMATS} from './baseapi';
import {Configuration} from '../configuration';
import {RequestContext, HttpMethod, ResponseContext, HttpFile, HttpInfo} from '../http/http';
import {ObjectSerializer} from '../models/ObjectSerializer';
import {ApiException} from './exception';
import {canConsumeForm, isCodeInRange} from '../util';
import {SecurityAuthentication} from '../auth/auth';


import { GetSubmodelElementsResult } from '../models/part2/GetSubmodelElementsResult';
import { GetSubmodelsResult } from '../models/part2/GetSubmodelsResult';
import { OperationRequest } from '../models/part2/OperationRequest';
import { OperationResult } from '../models/part2/OperationResult';
import { Result } from '../models/part2/Result';
import { ServiceDescription } from '../models/part2/ServiceDescription';
import { Submodel } from '../models/part1/Submodel';
import { SubmodelElement } from '../models/part1/SubmodelElement';
import { SubmodelElementValue } from '../models/part2/SubmodelElementValue';
import { SubmodelMetadata } from '../models/part2/SubmodelMetadata';

/**
 * no description
 */
export class SubmodelRepositoryApiRequestFactory extends BaseAPIRequestFactory {

    /**
     * Deletes file content of an existing submodel element at a specified path within submodel elements hierarchy
     * @param submodelIdentifier The Submodel’s unique id (UTF8-BASE64-URL-encoded)
     * @param idShortPath IdShort path to the submodel element (dot-separated)
     */
    public async deleteFileAttachment(submodelIdentifier: string, idShortPath: string, _options?: Configuration): Promise<RequestContext> {
        if (submodelIdentifier !== undefined)  {

            submodelIdentifier = encodeURI(window.btoa(submodelIdentifier));
        }


        return this.deleteFileAttachment(submodelIdentifier, idShortPath, _options);
    }

    
    private async deleteFileAttachmentNoUrlEncoding(submodelIdentifier: string, idShortPath: string, _options?: Configuration): Promise<RequestContext> {
        let _config = _options || this.configuration;

        // verify required parameter 'submodelIdentifier' is not null or undefined
        if (submodelIdentifier === null || submodelIdentifier === undefined) {
            throw new RequiredError("SubmodelRepositoryApi", "deleteFileAttachment", "submodelIdentifier");
        }


        // verify required parameter 'idShortPath' is not null or undefined
        if (idShortPath === null || idShortPath === undefined) {
            throw new RequiredError("SubmodelRepositoryApi", "deleteFileAttachment", "idShortPath");
        }


        // Path Params
        const localVarPath = '/submodels/{submodelIdentifier}/submodel-elements/{idShortPath}/attachment'
            .replace('{' + 'submodelIdentifier' + '}', encodeURIComponent(String(submodelIdentifier)))
            .replace('{' + 'idShortPath' + '}', encodeURIComponent(String(idShortPath)));

        // Make Request Context
        const requestContext = _config.baseServer.makeRequestContext(localVarPath, HttpMethod.DELETE);
        requestContext.setHeaderParam("Accept", "application/json, */*;q=0.8")


        
        const defaultAuth: SecurityAuthentication | undefined = _options?.authMethods?.default || this.configuration?.authMethods?.default
        if (defaultAuth?.applySecurityAuthentication) {
            await defaultAuth?.applySecurityAuthentication(requestContext);
        }

        return requestContext;
    }

    /**
     * Deletes a Submodel
     * @param submodelIdentifier The Submodel’s unique id (UTF8-BASE64-URL-encoded)
     */
    public async deleteSubmodel(submodelIdentifier: string, _options?: Configuration): Promise<RequestContext> {
        if (submodelIdentifier !== undefined)  {

            submodelIdentifier = encodeURI(window.btoa(submodelIdentifier));
        }


        return this.deleteSubmodel(submodelIdentifier, _options);
    }

    
    private async deleteSubmodelNoUrlEncoding(submodelIdentifier: string, _options?: Configuration): Promise<RequestContext> {
        let _config = _options || this.configuration;

        // verify required parameter 'submodelIdentifier' is not null or undefined
        if (submodelIdentifier === null || submodelIdentifier === undefined) {
            throw new RequiredError("SubmodelRepositoryApi", "deleteSubmodel", "submodelIdentifier");
        }


        // Path Params
        const localVarPath = '/submodels/{submodelIdentifier}'
            .replace('{' + 'submodelIdentifier' + '}', encodeURIComponent(String(submodelIdentifier)));

        // Make Request Context
        const requestContext = _config.baseServer.makeRequestContext(localVarPath, HttpMethod.DELETE);
        requestContext.setHeaderParam("Accept", "application/json, */*;q=0.8")


        
        const defaultAuth: SecurityAuthentication | undefined = _options?.authMethods?.default || this.configuration?.authMethods?.default
        if (defaultAuth?.applySecurityAuthentication) {
            await defaultAuth?.applySecurityAuthentication(requestContext);
        }

        return requestContext;
    }

    /**
     * Deletes a submodel element at a specified path within the submodel elements hierarchy
     * @param submodelIdentifier The Submodel’s unique id (UTF8-BASE64-URL-encoded)
     * @param idShortPath IdShort path to the submodel element (dot-separated)
     */
    public async deleteSubmodelElement(submodelIdentifier: string, idShortPath: string, _options?: Configuration): Promise<RequestContext> {
        if (submodelIdentifier !== undefined)  {

            submodelIdentifier = encodeURI(window.btoa(submodelIdentifier));
        }


        return this.deleteSubmodelElement(submodelIdentifier, idShortPath, _options);
    }

    
    private async deleteSubmodelElementNoUrlEncoding(submodelIdentifier: string, idShortPath: string, _options?: Configuration): Promise<RequestContext> {
        let _config = _options || this.configuration;

        // verify required parameter 'submodelIdentifier' is not null or undefined
        if (submodelIdentifier === null || submodelIdentifier === undefined) {
            throw new RequiredError("SubmodelRepositoryApi", "deleteSubmodelElement", "submodelIdentifier");
        }


        // verify required parameter 'idShortPath' is not null or undefined
        if (idShortPath === null || idShortPath === undefined) {
            throw new RequiredError("SubmodelRepositoryApi", "deleteSubmodelElement", "idShortPath");
        }


        // Path Params
        const localVarPath = '/submodels/{submodelIdentifier}/submodel-elements/{idShortPath}'
            .replace('{' + 'submodelIdentifier' + '}', encodeURIComponent(String(submodelIdentifier)))
            .replace('{' + 'idShortPath' + '}', encodeURIComponent(String(idShortPath)));

        // Make Request Context
        const requestContext = _config.baseServer.makeRequestContext(localVarPath, HttpMethod.DELETE);
        requestContext.setHeaderParam("Accept", "application/json, */*;q=0.8")


        
        const defaultAuth: SecurityAuthentication | undefined = _options?.authMethods?.default || this.configuration?.authMethods?.default
        if (defaultAuth?.applySecurityAuthentication) {
            await defaultAuth?.applySecurityAuthentication(requestContext);
        }

        return requestContext;
    }

    /**
     * Returns all submodel elements including their hierarchy
     * @param submodelIdentifier The Submodel’s unique id (UTF8-BASE64-URL-encoded)
     * @param limit The maximum number of elements in the response array
     * @param cursor A server-generated identifier retrieved from pagingMetadata that specifies from which position the result listing should continue
     * @param level Determines the structural depth of the respective resource content
     * @param extent Determines to which extent the resource is being serialized
     */
    public async getAllSubmodelElements(submodelIdentifier: string, limit?: number, cursor?: string, level?: 'deep' | 'core', extent?: 'withBlobValue' | 'withoutBlobValue', _options?: Configuration): Promise<RequestContext> {
        if (submodelIdentifier !== undefined)  {

            submodelIdentifier = encodeURI(window.btoa(submodelIdentifier));
        }


        return this.getAllSubmodelElements(submodelIdentifier, limit, cursor, level, extent, _options);
    }

    
    private async getAllSubmodelElementsNoUrlEncoding(submodelIdentifier: string, limit?: number, cursor?: string, level?: 'deep' | 'core', extent?: 'withBlobValue' | 'withoutBlobValue', _options?: Configuration): Promise<RequestContext> {
        let _config = _options || this.configuration;

        // verify required parameter 'submodelIdentifier' is not null or undefined
        if (submodelIdentifier === null || submodelIdentifier === undefined) {
            throw new RequiredError("SubmodelRepositoryApi", "getAllSubmodelElements", "submodelIdentifier");
        }






        // Path Params
        const localVarPath = '/submodels/{submodelIdentifier}/submodel-elements'
            .replace('{' + 'submodelIdentifier' + '}', encodeURIComponent(String(submodelIdentifier)));

        // Make Request Context
        const requestContext = _config.baseServer.makeRequestContext(localVarPath, HttpMethod.GET);
        requestContext.setHeaderParam("Accept", "application/json, */*;q=0.8")

        // Query Params
        if (limit !== undefined) {
            requestContext.setQueryParam("limit", ObjectSerializer.serialize(limit, "number", ""));
        }

        // Query Params
        if (cursor !== undefined) {
            requestContext.setQueryParam("cursor", ObjectSerializer.serialize(cursor, "string", ""));
        }

        // Query Params
        if (level !== undefined) {
            requestContext.setQueryParam("level", ObjectSerializer.serialize(level, "'deep' | 'core'", ""));
        }

        // Query Params
        if (extent !== undefined) {
            requestContext.setQueryParam("extent", ObjectSerializer.serialize(extent, "'withBlobValue' | 'withoutBlobValue'", ""));
        }


        
        const defaultAuth: SecurityAuthentication | undefined = _options?.authMethods?.default || this.configuration?.authMethods?.default
        if (defaultAuth?.applySecurityAuthentication) {
            await defaultAuth?.applySecurityAuthentication(requestContext);
        }

        return requestContext;
    }

    /**
     * Returns all Submodels
     * @param semanticId The value of the semantic id reference (BASE64-URL-encoded)
     * @param idShort The Asset Administration Shell\&#39;s IdShort
     * @param limit The maximum number of elements in the response array
     * @param cursor A server-generated identifier retrieved from pagingMetadata that specifies from which position the result listing should continue
     * @param level Determines the structural depth of the respective resource content
     * @param extent Determines to which extent the resource is being serialized
     */
    public async getAllSubmodels(semanticId?: string, idShort?: string, limit?: number, cursor?: string, level?: 'deep' | 'core', extent?: 'withBlobValue' | 'withoutBlobValue', _options?: Configuration): Promise<RequestContext> {



        return this.getAllSubmodels(semanticId, idShort, limit, cursor, level, extent, _options);
    }

    
    private async getAllSubmodelsNoUrlEncoding(semanticId?: string, idShort?: string, limit?: number, cursor?: string, level?: 'deep' | 'core', extent?: 'withBlobValue' | 'withoutBlobValue', _options?: Configuration): Promise<RequestContext> {
        let _config = _options || this.configuration;







        // Path Params
        const localVarPath = '/submodels';

        // Make Request Context
        const requestContext = _config.baseServer.makeRequestContext(localVarPath, HttpMethod.GET);
        requestContext.setHeaderParam("Accept", "application/json, */*;q=0.8")

        // Query Params
        if (semanticId !== undefined) {
            requestContext.setQueryParam("semanticId", ObjectSerializer.serialize(semanticId, "string", ""));
        }

        // Query Params
        if (idShort !== undefined) {
            requestContext.setQueryParam("idShort", ObjectSerializer.serialize(idShort, "string", ""));
        }

        // Query Params
        if (limit !== undefined) {
            requestContext.setQueryParam("limit", ObjectSerializer.serialize(limit, "number", ""));
        }

        // Query Params
        if (cursor !== undefined) {
            requestContext.setQueryParam("cursor", ObjectSerializer.serialize(cursor, "string", ""));
        }

        // Query Params
        if (level !== undefined) {
            requestContext.setQueryParam("level", ObjectSerializer.serialize(level, "'deep' | 'core'", ""));
        }

        // Query Params
        if (extent !== undefined) {
            requestContext.setQueryParam("extent", ObjectSerializer.serialize(extent, "'withBlobValue' | 'withoutBlobValue'", ""));
        }


        
        const defaultAuth: SecurityAuthentication | undefined = _options?.authMethods?.default || this.configuration?.authMethods?.default
        if (defaultAuth?.applySecurityAuthentication) {
            await defaultAuth?.applySecurityAuthentication(requestContext);
        }

        return requestContext;
    }

    /**
     * Returns the self-describing information of a network resource (ServiceDescription)
     */
    public async getDescription(_options?: Configuration): Promise<RequestContext> {



        return this.getDescription(_options);
    }

    
    private async getDescriptionNoUrlEncoding(_options?: Configuration): Promise<RequestContext> {
        let _config = _options || this.configuration;

        // Path Params
        const localVarPath = '/description';

        // Make Request Context
        const requestContext = _config.baseServer.makeRequestContext(localVarPath, HttpMethod.GET);
        requestContext.setHeaderParam("Accept", "application/json, */*;q=0.8")


        
        const defaultAuth: SecurityAuthentication | undefined = _options?.authMethods?.default || this.configuration?.authMethods?.default
        if (defaultAuth?.applySecurityAuthentication) {
            await defaultAuth?.applySecurityAuthentication(requestContext);
        }

        return requestContext;
    }

    /**
     * Downloads file content from a specific submodel element from the Submodel at a specified path
     * @param submodelIdentifier The Submodel’s unique id (UTF8-BASE64-URL-encoded)
     * @param idShortPath IdShort path to the submodel element (dot-separated)
     */
    public async getFileAttachment(submodelIdentifier: string, idShortPath: string, _options?: Configuration): Promise<RequestContext> {
        if (submodelIdentifier !== undefined)  {

            submodelIdentifier = encodeURI(window.btoa(submodelIdentifier));
        }


        return this.getFileAttachment(submodelIdentifier, idShortPath, _options);
    }

    
    private async getFileAttachmentNoUrlEncoding(submodelIdentifier: string, idShortPath: string, _options?: Configuration): Promise<RequestContext> {
        let _config = _options || this.configuration;

        // verify required parameter 'submodelIdentifier' is not null or undefined
        if (submodelIdentifier === null || submodelIdentifier === undefined) {
            throw new RequiredError("SubmodelRepositoryApi", "getFileAttachment", "submodelIdentifier");
        }


        // verify required parameter 'idShortPath' is not null or undefined
        if (idShortPath === null || idShortPath === undefined) {
            throw new RequiredError("SubmodelRepositoryApi", "getFileAttachment", "idShortPath");
        }


        // Path Params
        const localVarPath = '/submodels/{submodelIdentifier}/submodel-elements/{idShortPath}/attachment'
            .replace('{' + 'submodelIdentifier' + '}', encodeURIComponent(String(submodelIdentifier)))
            .replace('{' + 'idShortPath' + '}', encodeURIComponent(String(idShortPath)));

        // Make Request Context
        const requestContext = _config.baseServer.makeRequestContext(localVarPath, HttpMethod.GET);
        requestContext.setHeaderParam("Accept", "application/json, */*;q=0.8")


        
        const defaultAuth: SecurityAuthentication | undefined = _options?.authMethods?.default || this.configuration?.authMethods?.default
        if (defaultAuth?.applySecurityAuthentication) {
            await defaultAuth?.applySecurityAuthentication(requestContext);
        }

        return requestContext;
    }

    /**
     * Returns a specific Submodel
     * @param submodelIdentifier The Submodel’s unique id (UTF8-BASE64-URL-encoded)
     * @param level Determines the structural depth of the respective resource content
     * @param extent Determines to which extent the resource is being serialized
     */
    public async getSubmodel(submodelIdentifier: string, level?: 'deep' | 'core', extent?: 'withBlobValue' | 'withoutBlobValue', _options?: Configuration): Promise<RequestContext> {
        if (submodelIdentifier !== undefined)  {

            submodelIdentifier = encodeURI(window.btoa(submodelIdentifier));
        }


        return this.getSubmodel(submodelIdentifier, level, extent, _options);
    }

    
    private async getSubmodelNoUrlEncoding(submodelIdentifier: string, level?: 'deep' | 'core', extent?: 'withBlobValue' | 'withoutBlobValue', _options?: Configuration): Promise<RequestContext> {
        let _config = _options || this.configuration;

        // verify required parameter 'submodelIdentifier' is not null or undefined
        if (submodelIdentifier === null || submodelIdentifier === undefined) {
            throw new RequiredError("SubmodelRepositoryApi", "getSubmodel", "submodelIdentifier");
        }




        // Path Params
        const localVarPath = '/submodels/{submodelIdentifier}'
            .replace('{' + 'submodelIdentifier' + '}', encodeURIComponent(String(submodelIdentifier)));

        // Make Request Context
        const requestContext = _config.baseServer.makeRequestContext(localVarPath, HttpMethod.GET);
        requestContext.setHeaderParam("Accept", "application/json, */*;q=0.8")

        // Query Params
        if (level !== undefined) {
            requestContext.setQueryParam("level", ObjectSerializer.serialize(level, "'deep' | 'core'", ""));
        }

        // Query Params
        if (extent !== undefined) {
            requestContext.setQueryParam("extent", ObjectSerializer.serialize(extent, "'withBlobValue' | 'withoutBlobValue'", ""));
        }


        
        const defaultAuth: SecurityAuthentication | undefined = _options?.authMethods?.default || this.configuration?.authMethods?.default
        if (defaultAuth?.applySecurityAuthentication) {
            await defaultAuth?.applySecurityAuthentication(requestContext);
        }

        return requestContext;
    }

    /**
     * Returns a specific submodel element from the Submodel at a specified path
     * @param submodelIdentifier The Submodel’s unique id (UTF8-BASE64-URL-encoded)
     * @param idShortPath IdShort path to the submodel element (dot-separated)
     * @param level Determines the structural depth of the respective resource content
     * @param extent Determines to which extent the resource is being serialized
     */
    public async getSubmodelElement(submodelIdentifier: string, idShortPath: string, level?: 'deep' | 'core', extent?: 'withBlobValue' | 'withoutBlobValue', _options?: Configuration): Promise<RequestContext> {
        if (submodelIdentifier !== undefined)  {

            submodelIdentifier = encodeURI(window.btoa(submodelIdentifier));
        }


        return this.getSubmodelElement(submodelIdentifier, idShortPath, level, extent, _options);
    }

    
    private async getSubmodelElementNoUrlEncoding(submodelIdentifier: string, idShortPath: string, level?: 'deep' | 'core', extent?: 'withBlobValue' | 'withoutBlobValue', _options?: Configuration): Promise<RequestContext> {
        let _config = _options || this.configuration;

        // verify required parameter 'submodelIdentifier' is not null or undefined
        if (submodelIdentifier === null || submodelIdentifier === undefined) {
            throw new RequiredError("SubmodelRepositoryApi", "getSubmodelElement", "submodelIdentifier");
        }


        // verify required parameter 'idShortPath' is not null or undefined
        if (idShortPath === null || idShortPath === undefined) {
            throw new RequiredError("SubmodelRepositoryApi", "getSubmodelElement", "idShortPath");
        }




        // Path Params
        const localVarPath = '/submodels/{submodelIdentifier}/submodel-elements/{idShortPath}'
            .replace('{' + 'submodelIdentifier' + '}', encodeURIComponent(String(submodelIdentifier)))
            .replace('{' + 'idShortPath' + '}', encodeURIComponent(String(idShortPath)));

        // Make Request Context
        const requestContext = _config.baseServer.makeRequestContext(localVarPath, HttpMethod.GET);
        requestContext.setHeaderParam("Accept", "application/json, */*;q=0.8")

        // Query Params
        if (level !== undefined) {
            requestContext.setQueryParam("level", ObjectSerializer.serialize(level, "'deep' | 'core'", ""));
        }

        // Query Params
        if (extent !== undefined) {
            requestContext.setQueryParam("extent", ObjectSerializer.serialize(extent, "'withBlobValue' | 'withoutBlobValue'", ""));
        }


        
        const defaultAuth: SecurityAuthentication | undefined = _options?.authMethods?.default || this.configuration?.authMethods?.default
        if (defaultAuth?.applySecurityAuthentication) {
            await defaultAuth?.applySecurityAuthentication(requestContext);
        }

        return requestContext;
    }

    /**
     * Returns a specific submodel element from the Submodel at a specified path in the ValueOnly representation
     * @param submodelIdentifier The Submodel’s unique id (UTF8-BASE64-URL-encoded)
     * @param idShortPath IdShort path to the submodel element (dot-separated)
     * @param level Determines the structural depth of the respective resource content
     * @param extent Determines to which extent the resource is being serialized
     */
    public async getSubmodelElementValue(submodelIdentifier: string, idShortPath: string, level?: 'deep' | 'core', extent?: 'withBlobValue' | 'withoutBlobValue', _options?: Configuration): Promise<RequestContext> {
        if (submodelIdentifier !== undefined)  {

            submodelIdentifier = encodeURI(window.btoa(submodelIdentifier));
        }


        return this.getSubmodelElementValue(submodelIdentifier, idShortPath, level, extent, _options);
    }

    
    private async getSubmodelElementValueNoUrlEncoding(submodelIdentifier: string, idShortPath: string, level?: 'deep' | 'core', extent?: 'withBlobValue' | 'withoutBlobValue', _options?: Configuration): Promise<RequestContext> {
        let _config = _options || this.configuration;

        // verify required parameter 'submodelIdentifier' is not null or undefined
        if (submodelIdentifier === null || submodelIdentifier === undefined) {
            throw new RequiredError("SubmodelRepositoryApi", "getSubmodelElementValue", "submodelIdentifier");
        }


        // verify required parameter 'idShortPath' is not null or undefined
        if (idShortPath === null || idShortPath === undefined) {
            throw new RequiredError("SubmodelRepositoryApi", "getSubmodelElementValue", "idShortPath");
        }




        // Path Params
        const localVarPath = '/submodels/{submodelIdentifier}/submodel-elements/{idShortPath}/$value'
            .replace('{' + 'submodelIdentifier' + '}', encodeURIComponent(String(submodelIdentifier)))
            .replace('{' + 'idShortPath' + '}', encodeURIComponent(String(idShortPath)));

        // Make Request Context
        const requestContext = _config.baseServer.makeRequestContext(localVarPath, HttpMethod.GET);
        requestContext.setHeaderParam("Accept", "application/json, */*;q=0.8")

        // Query Params
        if (level !== undefined) {
            requestContext.setQueryParam("level", ObjectSerializer.serialize(level, "'deep' | 'core'", ""));
        }

        // Query Params
        if (extent !== undefined) {
            requestContext.setQueryParam("extent", ObjectSerializer.serialize(extent, "'withBlobValue' | 'withoutBlobValue'", ""));
        }


        
        const defaultAuth: SecurityAuthentication | undefined = _options?.authMethods?.default || this.configuration?.authMethods?.default
        if (defaultAuth?.applySecurityAuthentication) {
            await defaultAuth?.applySecurityAuthentication(requestContext);
        }

        return requestContext;
    }

    /**
     * Returns the metadata attributes of a specific Submodel
     * @param submodelIdentifier The Submodel’s unique id (UTF8-BASE64-URL-encoded)
     * @param level Determines the structural depth of the respective resource content
     */
    public async getSubmodelMetadata(submodelIdentifier: string, level?: 'deep' | 'core', _options?: Configuration): Promise<RequestContext> {
        if (submodelIdentifier !== undefined)  {

            submodelIdentifier = encodeURI(window.btoa(submodelIdentifier));
        }


        return this.getSubmodelMetadata(submodelIdentifier, level, _options);
    }

    
    private async getSubmodelMetadataNoUrlEncoding(submodelIdentifier: string, level?: 'deep' | 'core', _options?: Configuration): Promise<RequestContext> {
        let _config = _options || this.configuration;

        // verify required parameter 'submodelIdentifier' is not null or undefined
        if (submodelIdentifier === null || submodelIdentifier === undefined) {
            throw new RequiredError("SubmodelRepositoryApi", "getSubmodelMetadata", "submodelIdentifier");
        }



        // Path Params
        const localVarPath = '/submodels/{submodelIdentifier}/$metadata'
            .replace('{' + 'submodelIdentifier' + '}', encodeURIComponent(String(submodelIdentifier)));

        // Make Request Context
        const requestContext = _config.baseServer.makeRequestContext(localVarPath, HttpMethod.GET);
        requestContext.setHeaderParam("Accept", "application/json, */*;q=0.8")

        // Query Params
        if (level !== undefined) {
            requestContext.setQueryParam("level", ObjectSerializer.serialize(level, "'deep' | 'core'", ""));
        }


        
        const defaultAuth: SecurityAuthentication | undefined = _options?.authMethods?.default || this.configuration?.authMethods?.default
        if (defaultAuth?.applySecurityAuthentication) {
            await defaultAuth?.applySecurityAuthentication(requestContext);
        }

        return requestContext;
    }

    /**
     * Synchronously or asynchronously invokes an Operation at a specified path
     * @param submodelIdentifier The Submodel’s unique id (UTF8-BASE64-URL-encoded)
     * @param idShortPath IdShort path to the submodel element (dot-separated)
     * @param operationRequest Operation request object
     * @param async Determines whether an operation invocation is performed asynchronously or synchronously
     */
    public async invokeOperation(submodelIdentifier: string, idShortPath: string, operationRequest: OperationRequest, async?: boolean, _options?: Configuration): Promise<RequestContext> {
        if (submodelIdentifier !== undefined)  {

            submodelIdentifier = encodeURI(window.btoa(submodelIdentifier));
        }


        return this.invokeOperation(submodelIdentifier, idShortPath, operationRequest, async, _options);
    }

    
    private async invokeOperationNoUrlEncoding(submodelIdentifier: string, idShortPath: string, operationRequest: OperationRequest, async?: boolean, _options?: Configuration): Promise<RequestContext> {
        let _config = _options || this.configuration;

        // verify required parameter 'submodelIdentifier' is not null or undefined
        if (submodelIdentifier === null || submodelIdentifier === undefined) {
            throw new RequiredError("SubmodelRepositoryApi", "invokeOperation", "submodelIdentifier");
        }


        // verify required parameter 'idShortPath' is not null or undefined
        if (idShortPath === null || idShortPath === undefined) {
            throw new RequiredError("SubmodelRepositoryApi", "invokeOperation", "idShortPath");
        }


        // verify required parameter 'operationRequest' is not null or undefined
        if (operationRequest === null || operationRequest === undefined) {
            throw new RequiredError("SubmodelRepositoryApi", "invokeOperation", "operationRequest");
        }



        // Path Params
        const localVarPath = '/submodels/{submodelIdentifier}/submodel-elements/{idShortPath}/invoke'
            .replace('{' + 'submodelIdentifier' + '}', encodeURIComponent(String(submodelIdentifier)))
            .replace('{' + 'idShortPath' + '}', encodeURIComponent(String(idShortPath)));

        // Make Request Context
        const requestContext = _config.baseServer.makeRequestContext(localVarPath, HttpMethod.POST);
        requestContext.setHeaderParam("Accept", "application/json, */*;q=0.8")

        // Query Params
        if (async !== undefined) {
            requestContext.setQueryParam("async", ObjectSerializer.serialize(async, "boolean", ""));
        }


        // Body Params
        const contentType = ObjectSerializer.getPreferredMediaType([
            "application/json"
        ]);
        requestContext.setHeaderParam("Content-Type", contentType);
        const serializedBody = ObjectSerializer.stringify(
            ObjectSerializer.serialize(operationRequest, "OperationRequest", ""),
            contentType
        );
        requestContext.setBody(serializedBody);

        
        const defaultAuth: SecurityAuthentication | undefined = _options?.authMethods?.default || this.configuration?.authMethods?.default
        if (defaultAuth?.applySecurityAuthentication) {
            await defaultAuth?.applySecurityAuthentication(requestContext);
        }

        return requestContext;
    }

    /**
     * Updates the value of an existing SubmodelElement
     * @param submodelIdentifier The Submodel’s unique id (UTF8-BASE64-URL-encoded)
     * @param idShortPath IdShort path to the submodel element (dot-separated)
     * @param submodelElementValue The SubmodelElement in its ValueOnly representation
     * @param level Determines the structural depth of the respective resource content
     */
    public async patchSubmodelElementValue(submodelIdentifier: string, idShortPath: string, submodelElementValue: SubmodelElementValue, level?: 'core', _options?: Configuration): Promise<RequestContext> {
        if (submodelIdentifier !== undefined)  {

            submodelIdentifier = encodeURI(window.btoa(submodelIdentifier));
        }


        return this.patchSubmodelElementValue(submodelIdentifier, idShortPath, submodelElementValue, level, _options);
    }

    
    private async patchSubmodelElementValueNoUrlEncoding(submodelIdentifier: string, idShortPath: string, submodelElementValue: SubmodelElementValue, level?: 'core', _options?: Configuration): Promise<RequestContext> {
        let _config = _options || this.configuration;

        // verify required parameter 'submodelIdentifier' is not null or undefined
        if (submodelIdentifier === null || submodelIdentifier === undefined) {
            throw new RequiredError("SubmodelRepositoryApi", "patchSubmodelElementValue", "submodelIdentifier");
        }


        // verify required parameter 'idShortPath' is not null or undefined
        if (idShortPath === null || idShortPath === undefined) {
            throw new RequiredError("SubmodelRepositoryApi", "patchSubmodelElementValue", "idShortPath");
        }


        // verify required parameter 'submodelElementValue' is not null or undefined
        if (submodelElementValue === null || submodelElementValue === undefined) {
            throw new RequiredError("SubmodelRepositoryApi", "patchSubmodelElementValue", "submodelElementValue");
        }



        // Path Params
        const localVarPath = '/submodels/{submodelIdentifier}/submodel-elements/{idShortPath}/$value'
            .replace('{' + 'submodelIdentifier' + '}', encodeURIComponent(String(submodelIdentifier)))
            .replace('{' + 'idShortPath' + '}', encodeURIComponent(String(idShortPath)));

        // Make Request Context
        const requestContext = _config.baseServer.makeRequestContext(localVarPath, HttpMethod.PATCH);
        requestContext.setHeaderParam("Accept", "application/json, */*;q=0.8")

        // Query Params
        if (level !== undefined) {
            requestContext.setQueryParam("level", ObjectSerializer.serialize(level, "'core'", ""));
        }


        // Body Params
        const contentType = ObjectSerializer.getPreferredMediaType([
            "application/json"
        ]);
        requestContext.setHeaderParam("Content-Type", contentType);
        const serializedBody = ObjectSerializer.stringify(
            ObjectSerializer.serialize(submodelElementValue, "SubmodelElementValue", ""),
            contentType
        );
        requestContext.setBody(serializedBody);

        
        const defaultAuth: SecurityAuthentication | undefined = _options?.authMethods?.default || this.configuration?.authMethods?.default
        if (defaultAuth?.applySecurityAuthentication) {
            await defaultAuth?.applySecurityAuthentication(requestContext);
        }

        return requestContext;
    }

    /**
     * Creates a new Submodel
     * @param submodel Submodel object
     */
    public async postSubmodel(submodel: Submodel, _options?: Configuration): Promise<RequestContext> {



        return this.postSubmodel(submodel, _options);
    }

    
    private async postSubmodelNoUrlEncoding(submodel: Submodel, _options?: Configuration): Promise<RequestContext> {
        let _config = _options || this.configuration;

        // verify required parameter 'submodel' is not null or undefined
        if (submodel === null || submodel === undefined) {
            throw new RequiredError("SubmodelRepositoryApi", "postSubmodel", "submodel");
        }


        // Path Params
        const localVarPath = '/submodels';

        // Make Request Context
        const requestContext = _config.baseServer.makeRequestContext(localVarPath, HttpMethod.POST);
        requestContext.setHeaderParam("Accept", "application/json, */*;q=0.8")


        // Body Params
        const contentType = ObjectSerializer.getPreferredMediaType([
            "application/json"
        ]);
        requestContext.setHeaderParam("Content-Type", contentType);
        const serializedBody = ObjectSerializer.stringify(
            ObjectSerializer.serialize(submodel, "Submodel", ""),
            contentType
        );
        requestContext.setBody(serializedBody);

        
        const defaultAuth: SecurityAuthentication | undefined = _options?.authMethods?.default || this.configuration?.authMethods?.default
        if (defaultAuth?.applySecurityAuthentication) {
            await defaultAuth?.applySecurityAuthentication(requestContext);
        }

        return requestContext;
    }

    /**
     * Creates a new submodel element
     * @param submodelIdentifier The Submodel’s unique id (UTF8-BASE64-URL-encoded)
     * @param submodelElement Requested submodel element
     */
    public async postSubmodelElement(submodelIdentifier: string, submodelElement: SubmodelElement, _options?: Configuration): Promise<RequestContext> {
        if (submodelIdentifier !== undefined)  {

            submodelIdentifier = encodeURI(window.btoa(submodelIdentifier));
        }


        return this.postSubmodelElement(submodelIdentifier, submodelElement, _options);
    }

    
    private async postSubmodelElementNoUrlEncoding(submodelIdentifier: string, submodelElement: SubmodelElement, _options?: Configuration): Promise<RequestContext> {
        let _config = _options || this.configuration;

        // verify required parameter 'submodelIdentifier' is not null or undefined
        if (submodelIdentifier === null || submodelIdentifier === undefined) {
            throw new RequiredError("SubmodelRepositoryApi", "postSubmodelElement", "submodelIdentifier");
        }


        // verify required parameter 'submodelElement' is not null or undefined
        if (submodelElement === null || submodelElement === undefined) {
            throw new RequiredError("SubmodelRepositoryApi", "postSubmodelElement", "submodelElement");
        }


        // Path Params
        const localVarPath = '/submodels/{submodelIdentifier}/submodel-elements'
            .replace('{' + 'submodelIdentifier' + '}', encodeURIComponent(String(submodelIdentifier)));

        // Make Request Context
        const requestContext = _config.baseServer.makeRequestContext(localVarPath, HttpMethod.POST);
        requestContext.setHeaderParam("Accept", "application/json, */*;q=0.8")


        // Body Params
        const contentType = ObjectSerializer.getPreferredMediaType([
            "application/json"
        ]);
        requestContext.setHeaderParam("Content-Type", contentType);
        const serializedBody = ObjectSerializer.stringify(
            ObjectSerializer.serialize(submodelElement, "SubmodelElement", ""),
            contentType
        );
        requestContext.setBody(serializedBody);

        
        const defaultAuth: SecurityAuthentication | undefined = _options?.authMethods?.default || this.configuration?.authMethods?.default
        if (defaultAuth?.applySecurityAuthentication) {
            await defaultAuth?.applySecurityAuthentication(requestContext);
        }

        return requestContext;
    }

    /**
     * Creates a new submodel element at a specified path within submodel elements hierarchy
     * @param submodelIdentifier The Submodel’s unique id (UTF8-BASE64-URL-encoded)
     * @param idShortPath IdShort path to the submodel element (dot-separated)
     * @param submodelElement Requested submodel element
     */
    public async postSubmodelElementUnderPath(submodelIdentifier: string, idShortPath: string, submodelElement: SubmodelElement, _options?: Configuration): Promise<RequestContext> {
        if (submodelIdentifier !== undefined)  {

            submodelIdentifier = encodeURI(window.btoa(submodelIdentifier));
        }


        return this.postSubmodelElementUnderPath(submodelIdentifier, idShortPath, submodelElement, _options);
    }

    
    private async postSubmodelElementUnderPathNoUrlEncoding(submodelIdentifier: string, idShortPath: string, submodelElement: SubmodelElement, _options?: Configuration): Promise<RequestContext> {
        let _config = _options || this.configuration;

        // verify required parameter 'submodelIdentifier' is not null or undefined
        if (submodelIdentifier === null || submodelIdentifier === undefined) {
            throw new RequiredError("SubmodelRepositoryApi", "postSubmodelElementUnderPath", "submodelIdentifier");
        }


        // verify required parameter 'idShortPath' is not null or undefined
        if (idShortPath === null || idShortPath === undefined) {
            throw new RequiredError("SubmodelRepositoryApi", "postSubmodelElementUnderPath", "idShortPath");
        }


        // verify required parameter 'submodelElement' is not null or undefined
        if (submodelElement === null || submodelElement === undefined) {
            throw new RequiredError("SubmodelRepositoryApi", "postSubmodelElementUnderPath", "submodelElement");
        }


        // Path Params
        const localVarPath = '/submodels/{submodelIdentifier}/submodel-elements/{idShortPath}'
            .replace('{' + 'submodelIdentifier' + '}', encodeURIComponent(String(submodelIdentifier)))
            .replace('{' + 'idShortPath' + '}', encodeURIComponent(String(idShortPath)));

        // Make Request Context
        const requestContext = _config.baseServer.makeRequestContext(localVarPath, HttpMethod.POST);
        requestContext.setHeaderParam("Accept", "application/json, */*;q=0.8")


        // Body Params
        const contentType = ObjectSerializer.getPreferredMediaType([
            "application/json"
        ]);
        requestContext.setHeaderParam("Content-Type", contentType);
        const serializedBody = ObjectSerializer.stringify(
            ObjectSerializer.serialize(submodelElement, "SubmodelElement", ""),
            contentType
        );
        requestContext.setBody(serializedBody);

        
        const defaultAuth: SecurityAuthentication | undefined = _options?.authMethods?.default || this.configuration?.authMethods?.default
        if (defaultAuth?.applySecurityAuthentication) {
            await defaultAuth?.applySecurityAuthentication(requestContext);
        }

        return requestContext;
    }

    /**
     * Uploads file content to an existing submodel element at a specified path within submodel elements hierarchy
     * @param submodelIdentifier The Submodel’s unique id (UTF8-BASE64-URL-encoded)
     * @param idShortPath IdShort path to the submodel element (dot-separated)
     * @param fileName 
     * @param file 
     */
    public async putFileAttachment(submodelIdentifier: string, idShortPath: string, fileName?: string, file?: HttpFile, _options?: Configuration): Promise<RequestContext> {
        if (submodelIdentifier !== undefined)  {

            submodelIdentifier = encodeURI(window.btoa(submodelIdentifier));
        }


        return this.putFileAttachment(submodelIdentifier, idShortPath, fileName, file, _options);
    }

    
    private async putFileAttachmentNoUrlEncoding(submodelIdentifier: string, idShortPath: string, fileName?: string, file?: HttpFile, _options?: Configuration): Promise<RequestContext> {
        let _config = _options || this.configuration;

        // verify required parameter 'submodelIdentifier' is not null or undefined
        if (submodelIdentifier === null || submodelIdentifier === undefined) {
            throw new RequiredError("SubmodelRepositoryApi", "putFileAttachment", "submodelIdentifier");
        }


        // verify required parameter 'idShortPath' is not null or undefined
        if (idShortPath === null || idShortPath === undefined) {
            throw new RequiredError("SubmodelRepositoryApi", "putFileAttachment", "idShortPath");
        }




        // Path Params
        const localVarPath = '/submodels/{submodelIdentifier}/submodel-elements/{idShortPath}/attachment'
            .replace('{' + 'submodelIdentifier' + '}', encodeURIComponent(String(submodelIdentifier)))
            .replace('{' + 'idShortPath' + '}', encodeURIComponent(String(idShortPath)));

        // Make Request Context
        const requestContext = _config.baseServer.makeRequestContext(localVarPath, HttpMethod.PUT);
        requestContext.setHeaderParam("Accept", "application/json, */*;q=0.8")

        // Form Params
        const useForm = canConsumeForm([
            'multipart/form-data',
        ]);

        let localVarFormParams
        if (useForm) {
            localVarFormParams = new FormData();
        } else {
            localVarFormParams = new URLSearchParams();
        }

        if (fileName !== undefined) {
             // TODO: replace .append with .set
             localVarFormParams.append('fileName', fileName as any);
        }
        if (file !== undefined) {
             // TODO: replace .append with .set
             if (localVarFormParams instanceof FormData) {
                 localVarFormParams.append('file', file, file.name);
             }
        }

        requestContext.setBody(localVarFormParams);

        if(!useForm) {
            const contentType = ObjectSerializer.getPreferredMediaType([
                "multipart/form-data"
            ]);
            requestContext.setHeaderParam("Content-Type", contentType);
        }

        
        const defaultAuth: SecurityAuthentication | undefined = _options?.authMethods?.default || this.configuration?.authMethods?.default
        if (defaultAuth?.applySecurityAuthentication) {
            await defaultAuth?.applySecurityAuthentication(requestContext);
        }

        return requestContext;
    }

    /**
     * Updates an existing Submodel
     * @param submodelIdentifier The Submodel’s unique id (UTF8-BASE64-URL-encoded)
     * @param submodel Submodel object
     */
    public async putSubmodel(submodelIdentifier: string, submodel: Submodel, _options?: Configuration): Promise<RequestContext> {
        if (submodelIdentifier !== undefined)  {

            submodelIdentifier = encodeURI(window.btoa(submodelIdentifier));
        }


        return this.putSubmodel(submodelIdentifier, submodel, _options);
    }

    
    private async putSubmodelNoUrlEncoding(submodelIdentifier: string, submodel: Submodel, _options?: Configuration): Promise<RequestContext> {
        let _config = _options || this.configuration;

        // verify required parameter 'submodelIdentifier' is not null or undefined
        if (submodelIdentifier === null || submodelIdentifier === undefined) {
            throw new RequiredError("SubmodelRepositoryApi", "putSubmodel", "submodelIdentifier");
        }


        // verify required parameter 'submodel' is not null or undefined
        if (submodel === null || submodel === undefined) {
            throw new RequiredError("SubmodelRepositoryApi", "putSubmodel", "submodel");
        }


        // Path Params
        const localVarPath = '/submodels/{submodelIdentifier}'
            .replace('{' + 'submodelIdentifier' + '}', encodeURIComponent(String(submodelIdentifier)));

        // Make Request Context
        const requestContext = _config.baseServer.makeRequestContext(localVarPath, HttpMethod.PUT);
        requestContext.setHeaderParam("Accept", "application/json, */*;q=0.8")


        // Body Params
        const contentType = ObjectSerializer.getPreferredMediaType([
            "application/json"
        ]);
        requestContext.setHeaderParam("Content-Type", contentType);
        const serializedBody = ObjectSerializer.stringify(
            ObjectSerializer.serialize(submodel, "Submodel", ""),
            contentType
        );
        requestContext.setBody(serializedBody);

        
        const defaultAuth: SecurityAuthentication | undefined = _options?.authMethods?.default || this.configuration?.authMethods?.default
        if (defaultAuth?.applySecurityAuthentication) {
            await defaultAuth?.applySecurityAuthentication(requestContext);
        }

        return requestContext;
    }

    /**
     * Updates an existing submodel element at a specified path within submodel elements hierarchy
     * @param submodelIdentifier The Submodel’s unique id (UTF8-BASE64-URL-encoded)
     * @param idShortPath IdShort path to the submodel element (dot-separated)
     * @param submodelElement Requested submodel element
     * @param level Determines the structural depth of the respective resource content
     */
    public async putSubmodelElement(submodelIdentifier: string, idShortPath: string, submodelElement: SubmodelElement, level?: 'deep', _options?: Configuration): Promise<RequestContext> {
        if (submodelIdentifier !== undefined)  {

            submodelIdentifier = encodeURI(window.btoa(submodelIdentifier));
        }


        return this.putSubmodelElement(submodelIdentifier, idShortPath, submodelElement, level, _options);
    }

    
    private async putSubmodelElementNoUrlEncoding(submodelIdentifier: string, idShortPath: string, submodelElement: SubmodelElement, level?: 'deep', _options?: Configuration): Promise<RequestContext> {
        let _config = _options || this.configuration;

        // verify required parameter 'submodelIdentifier' is not null or undefined
        if (submodelIdentifier === null || submodelIdentifier === undefined) {
            throw new RequiredError("SubmodelRepositoryApi", "putSubmodelElement", "submodelIdentifier");
        }


        // verify required parameter 'idShortPath' is not null or undefined
        if (idShortPath === null || idShortPath === undefined) {
            throw new RequiredError("SubmodelRepositoryApi", "putSubmodelElement", "idShortPath");
        }


        // verify required parameter 'submodelElement' is not null or undefined
        if (submodelElement === null || submodelElement === undefined) {
            throw new RequiredError("SubmodelRepositoryApi", "putSubmodelElement", "submodelElement");
        }



        // Path Params
        const localVarPath = '/submodels/{submodelIdentifier}/submodel-elements/{idShortPath}'
            .replace('{' + 'submodelIdentifier' + '}', encodeURIComponent(String(submodelIdentifier)))
            .replace('{' + 'idShortPath' + '}', encodeURIComponent(String(idShortPath)));

        // Make Request Context
        const requestContext = _config.baseServer.makeRequestContext(localVarPath, HttpMethod.PUT);
        requestContext.setHeaderParam("Accept", "application/json, */*;q=0.8")

        // Query Params
        if (level !== undefined) {
            requestContext.setQueryParam("level", ObjectSerializer.serialize(level, "'deep'", ""));
        }


        // Body Params
        const contentType = ObjectSerializer.getPreferredMediaType([
            "application/json"
        ]);
        requestContext.setHeaderParam("Content-Type", contentType);
        const serializedBody = ObjectSerializer.stringify(
            ObjectSerializer.serialize(submodelElement, "SubmodelElement", ""),
            contentType
        );
        requestContext.setBody(serializedBody);

        
        const defaultAuth: SecurityAuthentication | undefined = _options?.authMethods?.default || this.configuration?.authMethods?.default
        if (defaultAuth?.applySecurityAuthentication) {
            await defaultAuth?.applySecurityAuthentication(requestContext);
        }

        return requestContext;
    }

}

export class SubmodelRepositoryApiResponseProcessor {



    /**
     * Unwraps the actual response sent by the server from the response context and deserializes the response content
     * to the expected objects
     *
     * @params response Response returned by the server for a request to deleteFileAttachment
     * @throws ApiException if the response code was not in [200, 299]
     */
     public async deleteFileAttachmentWithHttpInfo(response: ResponseContext): Promise<HttpInfo<void >> {
        const contentType = ObjectSerializer.normalizeMediaType(response.headers["content-type"]);
        if (isCodeInRange("200", response.httpStatusCode)) {
            return new HttpInfo(response.httpStatusCode, response.headers, response.body, undefined);
        }
        if (isCodeInRange("400", response.httpStatusCode)) {
            const body: Result = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "Result", ""
            ) as Result;
            throw new ApiException<Result>(response.httpStatusCode, "Bad Request, e.g. the request parameters of the format of the request body is wrong.", body, response.headers);
        }
        if (isCodeInRange("401", response.httpStatusCode)) {
            const body: Result = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "Result", ""
            ) as Result;
            throw new ApiException<Result>(response.httpStatusCode, "Unauthorized, e.g. the server refused the authorization attempt.", body, response.headers);
        }
        if (isCodeInRange("403", response.httpStatusCode)) {
            const body: Result = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "Result", ""
            ) as Result;
            throw new ApiException<Result>(response.httpStatusCode, "Forbidden", body, response.headers);
        }
        if (isCodeInRange("404", response.httpStatusCode)) {
            const body: Result = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "Result", ""
            ) as Result;
            throw new ApiException<Result>(response.httpStatusCode, "Not Found", body, response.headers);
        }
        if (isCodeInRange("500", response.httpStatusCode)) {
            const body: Result = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "Result", ""
            ) as Result;
            throw new ApiException<Result>(response.httpStatusCode, "Internal Server Error", body, response.headers);
        }
        if (isCodeInRange("0", response.httpStatusCode)) {
            const body: Result = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "Result", ""
            ) as Result;
            throw new ApiException<Result>(response.httpStatusCode, "Default error handling for unmentioned status codes", body, response.headers);
        }

        // Work around for missing responses in specification, e.g. for petstore.yaml
        if (response.httpStatusCode >= 200 && response.httpStatusCode <= 299) {
            const body: void = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "void", ""
            ) as void;
            return new HttpInfo(response.httpStatusCode, response.headers, response.body, body);
        }

        throw new ApiException<string | Blob | undefined>(response.httpStatusCode, "Unknown API Status Code!", await response.getBodyAsAny(), response.headers);
    }



    /**
     * Unwraps the actual response sent by the server from the response context and deserializes the response content
     * to the expected objects
     *
     * @params response Response returned by the server for a request to deleteSubmodel
     * @throws ApiException if the response code was not in [200, 299]
     */
     public async deleteSubmodelWithHttpInfo(response: ResponseContext): Promise<HttpInfo<void >> {
        const contentType = ObjectSerializer.normalizeMediaType(response.headers["content-type"]);
        if (isCodeInRange("204", response.httpStatusCode)) {
            return new HttpInfo(response.httpStatusCode, response.headers, response.body, undefined);
        }
        if (isCodeInRange("400", response.httpStatusCode)) {
            const body: Result = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "Result", ""
            ) as Result;
            throw new ApiException<Result>(response.httpStatusCode, "Bad Request, e.g. the request parameters of the format of the request body is wrong.", body, response.headers);
        }
        if (isCodeInRange("401", response.httpStatusCode)) {
            const body: Result = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "Result", ""
            ) as Result;
            throw new ApiException<Result>(response.httpStatusCode, "Unauthorized, e.g. the server refused the authorization attempt.", body, response.headers);
        }
        if (isCodeInRange("403", response.httpStatusCode)) {
            const body: Result = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "Result", ""
            ) as Result;
            throw new ApiException<Result>(response.httpStatusCode, "Forbidden", body, response.headers);
        }
        if (isCodeInRange("404", response.httpStatusCode)) {
            const body: Result = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "Result", ""
            ) as Result;
            throw new ApiException<Result>(response.httpStatusCode, "Not Found", body, response.headers);
        }
        if (isCodeInRange("500", response.httpStatusCode)) {
            const body: Result = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "Result", ""
            ) as Result;
            throw new ApiException<Result>(response.httpStatusCode, "Internal Server Error", body, response.headers);
        }
        if (isCodeInRange("0", response.httpStatusCode)) {
            const body: Result = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "Result", ""
            ) as Result;
            throw new ApiException<Result>(response.httpStatusCode, "Default error handling for unmentioned status codes", body, response.headers);
        }

        // Work around for missing responses in specification, e.g. for petstore.yaml
        if (response.httpStatusCode >= 200 && response.httpStatusCode <= 299) {
            const body: void = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "void", ""
            ) as void;
            return new HttpInfo(response.httpStatusCode, response.headers, response.body, body);
        }

        throw new ApiException<string | Blob | undefined>(response.httpStatusCode, "Unknown API Status Code!", await response.getBodyAsAny(), response.headers);
    }



    /**
     * Unwraps the actual response sent by the server from the response context and deserializes the response content
     * to the expected objects
     *
     * @params response Response returned by the server for a request to deleteSubmodelElement
     * @throws ApiException if the response code was not in [200, 299]
     */
     public async deleteSubmodelElementWithHttpInfo(response: ResponseContext): Promise<HttpInfo<void >> {
        const contentType = ObjectSerializer.normalizeMediaType(response.headers["content-type"]);
        if (isCodeInRange("204", response.httpStatusCode)) {
            return new HttpInfo(response.httpStatusCode, response.headers, response.body, undefined);
        }
        if (isCodeInRange("400", response.httpStatusCode)) {
            const body: Result = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "Result", ""
            ) as Result;
            throw new ApiException<Result>(response.httpStatusCode, "Bad Request, e.g. the request parameters of the format of the request body is wrong.", body, response.headers);
        }
        if (isCodeInRange("401", response.httpStatusCode)) {
            const body: Result = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "Result", ""
            ) as Result;
            throw new ApiException<Result>(response.httpStatusCode, "Unauthorized, e.g. the server refused the authorization attempt.", body, response.headers);
        }
        if (isCodeInRange("403", response.httpStatusCode)) {
            const body: Result = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "Result", ""
            ) as Result;
            throw new ApiException<Result>(response.httpStatusCode, "Forbidden", body, response.headers);
        }
        if (isCodeInRange("404", response.httpStatusCode)) {
            const body: Result = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "Result", ""
            ) as Result;
            throw new ApiException<Result>(response.httpStatusCode, "Not Found", body, response.headers);
        }
        if (isCodeInRange("500", response.httpStatusCode)) {
            const body: Result = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "Result", ""
            ) as Result;
            throw new ApiException<Result>(response.httpStatusCode, "Internal Server Error", body, response.headers);
        }
        if (isCodeInRange("0", response.httpStatusCode)) {
            const body: Result = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "Result", ""
            ) as Result;
            throw new ApiException<Result>(response.httpStatusCode, "Default error handling for unmentioned status codes", body, response.headers);
        }

        // Work around for missing responses in specification, e.g. for petstore.yaml
        if (response.httpStatusCode >= 200 && response.httpStatusCode <= 299) {
            const body: void = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "void", ""
            ) as void;
            return new HttpInfo(response.httpStatusCode, response.headers, response.body, body);
        }

        throw new ApiException<string | Blob | undefined>(response.httpStatusCode, "Unknown API Status Code!", await response.getBodyAsAny(), response.headers);
    }



    /**
     * Unwraps the actual response sent by the server from the response context and deserializes the response content
     * to the expected objects
     *
     * @params response Response returned by the server for a request to getAllSubmodelElements
     * @throws ApiException if the response code was not in [200, 299]
     */
     public async getAllSubmodelElementsWithHttpInfo(response: ResponseContext): Promise<HttpInfo<GetSubmodelElementsResult >> {
        const contentType = ObjectSerializer.normalizeMediaType(response.headers["content-type"]);
        if (isCodeInRange("200", response.httpStatusCode)) {
            const body: GetSubmodelElementsResult = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "GetSubmodelElementsResult", ""
            ) as GetSubmodelElementsResult;
            return new HttpInfo(response.httpStatusCode, response.headers, response.body, body);
        }
        if (isCodeInRange("400", response.httpStatusCode)) {
            const body: Result = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "Result", ""
            ) as Result;
            throw new ApiException<Result>(response.httpStatusCode, "Bad Request, e.g. the request parameters of the format of the request body is wrong.", body, response.headers);
        }
        if (isCodeInRange("401", response.httpStatusCode)) {
            const body: Result = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "Result", ""
            ) as Result;
            throw new ApiException<Result>(response.httpStatusCode, "Unauthorized, e.g. the server refused the authorization attempt.", body, response.headers);
        }
        if (isCodeInRange("403", response.httpStatusCode)) {
            const body: Result = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "Result", ""
            ) as Result;
            throw new ApiException<Result>(response.httpStatusCode, "Forbidden", body, response.headers);
        }
        if (isCodeInRange("404", response.httpStatusCode)) {
            const body: Result = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "Result", ""
            ) as Result;
            throw new ApiException<Result>(response.httpStatusCode, "Not Found", body, response.headers);
        }
        if (isCodeInRange("500", response.httpStatusCode)) {
            const body: Result = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "Result", ""
            ) as Result;
            throw new ApiException<Result>(response.httpStatusCode, "Internal Server Error", body, response.headers);
        }
        if (isCodeInRange("0", response.httpStatusCode)) {
            const body: Result = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "Result", ""
            ) as Result;
            throw new ApiException<Result>(response.httpStatusCode, "Default error handling for unmentioned status codes", body, response.headers);
        }

        // Work around for missing responses in specification, e.g. for petstore.yaml
        if (response.httpStatusCode >= 200 && response.httpStatusCode <= 299) {
            const body: GetSubmodelElementsResult = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "GetSubmodelElementsResult", ""
            ) as GetSubmodelElementsResult;
            return new HttpInfo(response.httpStatusCode, response.headers, response.body, body);
        }

        throw new ApiException<string | Blob | undefined>(response.httpStatusCode, "Unknown API Status Code!", await response.getBodyAsAny(), response.headers);
    }



    /**
     * Unwraps the actual response sent by the server from the response context and deserializes the response content
     * to the expected objects
     *
     * @params response Response returned by the server for a request to getAllSubmodels
     * @throws ApiException if the response code was not in [200, 299]
     */
     public async getAllSubmodelsWithHttpInfo(response: ResponseContext): Promise<HttpInfo<GetSubmodelsResult >> {
        const contentType = ObjectSerializer.normalizeMediaType(response.headers["content-type"]);
        if (isCodeInRange("200", response.httpStatusCode)) {
            const body: GetSubmodelsResult = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "GetSubmodelsResult", ""
            ) as GetSubmodelsResult;
            return new HttpInfo(response.httpStatusCode, response.headers, response.body, body);
        }
        if (isCodeInRange("400", response.httpStatusCode)) {
            const body: Result = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "Result", ""
            ) as Result;
            throw new ApiException<Result>(response.httpStatusCode, "Bad Request, e.g. the request parameters of the format of the request body is wrong.", body, response.headers);
        }
        if (isCodeInRange("401", response.httpStatusCode)) {
            const body: Result = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "Result", ""
            ) as Result;
            throw new ApiException<Result>(response.httpStatusCode, "Unauthorized, e.g. the server refused the authorization attempt.", body, response.headers);
        }
        if (isCodeInRange("403", response.httpStatusCode)) {
            const body: Result = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "Result", ""
            ) as Result;
            throw new ApiException<Result>(response.httpStatusCode, "Forbidden", body, response.headers);
        }
        if (isCodeInRange("500", response.httpStatusCode)) {
            const body: Result = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "Result", ""
            ) as Result;
            throw new ApiException<Result>(response.httpStatusCode, "Internal Server Error", body, response.headers);
        }
        if (isCodeInRange("0", response.httpStatusCode)) {
            const body: Result = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "Result", ""
            ) as Result;
            throw new ApiException<Result>(response.httpStatusCode, "Default error handling for unmentioned status codes", body, response.headers);
        }

        // Work around for missing responses in specification, e.g. for petstore.yaml
        if (response.httpStatusCode >= 200 && response.httpStatusCode <= 299) {
            const body: GetSubmodelsResult = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "GetSubmodelsResult", ""
            ) as GetSubmodelsResult;
            return new HttpInfo(response.httpStatusCode, response.headers, response.body, body);
        }

        throw new ApiException<string | Blob | undefined>(response.httpStatusCode, "Unknown API Status Code!", await response.getBodyAsAny(), response.headers);
    }



    /**
     * Unwraps the actual response sent by the server from the response context and deserializes the response content
     * to the expected objects
     *
     * @params response Response returned by the server for a request to getDescription
     * @throws ApiException if the response code was not in [200, 299]
     */
     public async getDescriptionWithHttpInfo(response: ResponseContext): Promise<HttpInfo<ServiceDescription >> {
        const contentType = ObjectSerializer.normalizeMediaType(response.headers["content-type"]);
        if (isCodeInRange("200", response.httpStatusCode)) {
            const body: ServiceDescription = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "ServiceDescription", ""
            ) as ServiceDescription;
            return new HttpInfo(response.httpStatusCode, response.headers, response.body, body);
        }
        if (isCodeInRange("401", response.httpStatusCode)) {
            const body: Result = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "Result", ""
            ) as Result;
            throw new ApiException<Result>(response.httpStatusCode, "Unauthorized, e.g. the server refused the authorization attempt.", body, response.headers);
        }
        if (isCodeInRange("403", response.httpStatusCode)) {
            const body: Result = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "Result", ""
            ) as Result;
            throw new ApiException<Result>(response.httpStatusCode, "Forbidden", body, response.headers);
        }

        // Work around for missing responses in specification, e.g. for petstore.yaml
        if (response.httpStatusCode >= 200 && response.httpStatusCode <= 299) {
            const body: ServiceDescription = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "ServiceDescription", ""
            ) as ServiceDescription;
            return new HttpInfo(response.httpStatusCode, response.headers, response.body, body);
        }

        throw new ApiException<string | Blob | undefined>(response.httpStatusCode, "Unknown API Status Code!", await response.getBodyAsAny(), response.headers);
    }



    /**
     * Unwraps the actual response sent by the server from the response context and deserializes the response content
     * to the expected objects
     *
     * @params response Response returned by the server for a request to getFileAttachment
     * @throws ApiException if the response code was not in [200, 299]
     */
     public async getFileAttachmentWithHttpInfo(response: ResponseContext): Promise<HttpInfo<HttpFile >> {
        const contentType = ObjectSerializer.normalizeMediaType(response.headers["content-type"]);
        if (isCodeInRange("200", response.httpStatusCode)) {
            const body: HttpFile = await response.getBodyAsFile() as any as HttpFile;
            return new HttpInfo(response.httpStatusCode, response.headers, response.body, body);
        }
        if (isCodeInRange("400", response.httpStatusCode)) {
            const body: Result = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "Result", "binary"
            ) as Result;
            throw new ApiException<Result>(response.httpStatusCode, "Bad Request, e.g. the request parameters of the format of the request body is wrong.", body, response.headers);
        }
        if (isCodeInRange("401", response.httpStatusCode)) {
            const body: Result = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "Result", "binary"
            ) as Result;
            throw new ApiException<Result>(response.httpStatusCode, "Unauthorized, e.g. the server refused the authorization attempt.", body, response.headers);
        }
        if (isCodeInRange("403", response.httpStatusCode)) {
            const body: Result = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "Result", "binary"
            ) as Result;
            throw new ApiException<Result>(response.httpStatusCode, "Forbidden", body, response.headers);
        }
        if (isCodeInRange("404", response.httpStatusCode)) {
            const body: Result = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "Result", "binary"
            ) as Result;
            throw new ApiException<Result>(response.httpStatusCode, "Not Found", body, response.headers);
        }
        if (isCodeInRange("405", response.httpStatusCode)) {
            const body: Result = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "Result", "binary"
            ) as Result;
            throw new ApiException<Result>(response.httpStatusCode, "Method not allowed - Download only valid for File submodel element", body, response.headers);
        }
        if (isCodeInRange("500", response.httpStatusCode)) {
            const body: Result = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "Result", "binary"
            ) as Result;
            throw new ApiException<Result>(response.httpStatusCode, "Internal Server Error", body, response.headers);
        }
        if (isCodeInRange("0", response.httpStatusCode)) {
            const body: Result = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "Result", "binary"
            ) as Result;
            throw new ApiException<Result>(response.httpStatusCode, "Default error handling for unmentioned status codes", body, response.headers);
        }

        // Work around for missing responses in specification, e.g. for petstore.yaml
        if (response.httpStatusCode >= 200 && response.httpStatusCode <= 299) {
            const body: HttpFile = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "HttpFile", "binary"
            ) as HttpFile;
            return new HttpInfo(response.httpStatusCode, response.headers, response.body, body);
        }

        throw new ApiException<string | Blob | undefined>(response.httpStatusCode, "Unknown API Status Code!", await response.getBodyAsAny(), response.headers);
    }



    /**
     * Unwraps the actual response sent by the server from the response context and deserializes the response content
     * to the expected objects
     *
     * @params response Response returned by the server for a request to getSubmodel
     * @throws ApiException if the response code was not in [200, 299]
     */
     public async getSubmodelWithHttpInfo(response: ResponseContext): Promise<HttpInfo<Submodel >> {
        const contentType = ObjectSerializer.normalizeMediaType(response.headers["content-type"]);
        if (isCodeInRange("200", response.httpStatusCode)) {
            const body: Submodel = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "Submodel", ""
            ) as Submodel;
            return new HttpInfo(response.httpStatusCode, response.headers, response.body, body);
        }
        if (isCodeInRange("400", response.httpStatusCode)) {
            const body: Result = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "Result", ""
            ) as Result;
            throw new ApiException<Result>(response.httpStatusCode, "Bad Request, e.g. the request parameters of the format of the request body is wrong.", body, response.headers);
        }
        if (isCodeInRange("401", response.httpStatusCode)) {
            const body: Result = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "Result", ""
            ) as Result;
            throw new ApiException<Result>(response.httpStatusCode, "Unauthorized, e.g. the server refused the authorization attempt.", body, response.headers);
        }
        if (isCodeInRange("403", response.httpStatusCode)) {
            const body: Result = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "Result", ""
            ) as Result;
            throw new ApiException<Result>(response.httpStatusCode, "Forbidden", body, response.headers);
        }
        if (isCodeInRange("404", response.httpStatusCode)) {
            const body: Result = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "Result", ""
            ) as Result;
            throw new ApiException<Result>(response.httpStatusCode, "Not Found", body, response.headers);
        }
        if (isCodeInRange("500", response.httpStatusCode)) {
            const body: Result = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "Result", ""
            ) as Result;
            throw new ApiException<Result>(response.httpStatusCode, "Internal Server Error", body, response.headers);
        }
        if (isCodeInRange("0", response.httpStatusCode)) {
            const body: Result = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "Result", ""
            ) as Result;
            throw new ApiException<Result>(response.httpStatusCode, "Default error handling for unmentioned status codes", body, response.headers);
        }

        // Work around for missing responses in specification, e.g. for petstore.yaml
        if (response.httpStatusCode >= 200 && response.httpStatusCode <= 299) {
            const body: Submodel = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "Submodel", ""
            ) as Submodel;
            return new HttpInfo(response.httpStatusCode, response.headers, response.body, body);
        }

        throw new ApiException<string | Blob | undefined>(response.httpStatusCode, "Unknown API Status Code!", await response.getBodyAsAny(), response.headers);
    }



    /**
     * Unwraps the actual response sent by the server from the response context and deserializes the response content
     * to the expected objects
     *
     * @params response Response returned by the server for a request to getSubmodelElement
     * @throws ApiException if the response code was not in [200, 299]
     */
     public async getSubmodelElementWithHttpInfo(response: ResponseContext): Promise<HttpInfo<SubmodelElement >> {
        const contentType = ObjectSerializer.normalizeMediaType(response.headers["content-type"]);
        if (isCodeInRange("200", response.httpStatusCode)) {
            const body: SubmodelElement = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "SubmodelElement", ""
            ) as SubmodelElement;
            return new HttpInfo(response.httpStatusCode, response.headers, response.body, body);
        }
        if (isCodeInRange("400", response.httpStatusCode)) {
            const body: Result = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "Result", ""
            ) as Result;
            throw new ApiException<Result>(response.httpStatusCode, "Bad Request, e.g. the request parameters of the format of the request body is wrong.", body, response.headers);
        }
        if (isCodeInRange("401", response.httpStatusCode)) {
            const body: Result = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "Result", ""
            ) as Result;
            throw new ApiException<Result>(response.httpStatusCode, "Unauthorized, e.g. the server refused the authorization attempt.", body, response.headers);
        }
        if (isCodeInRange("403", response.httpStatusCode)) {
            const body: Result = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "Result", ""
            ) as Result;
            throw new ApiException<Result>(response.httpStatusCode, "Forbidden", body, response.headers);
        }
        if (isCodeInRange("404", response.httpStatusCode)) {
            const body: Result = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "Result", ""
            ) as Result;
            throw new ApiException<Result>(response.httpStatusCode, "Not Found", body, response.headers);
        }
        if (isCodeInRange("500", response.httpStatusCode)) {
            const body: Result = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "Result", ""
            ) as Result;
            throw new ApiException<Result>(response.httpStatusCode, "Internal Server Error", body, response.headers);
        }
        if (isCodeInRange("0", response.httpStatusCode)) {
            const body: Result = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "Result", ""
            ) as Result;
            throw new ApiException<Result>(response.httpStatusCode, "Default error handling for unmentioned status codes", body, response.headers);
        }

        // Work around for missing responses in specification, e.g. for petstore.yaml
        if (response.httpStatusCode >= 200 && response.httpStatusCode <= 299) {
            const body: SubmodelElement = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "SubmodelElement", ""
            ) as SubmodelElement;
            return new HttpInfo(response.httpStatusCode, response.headers, response.body, body);
        }

        throw new ApiException<string | Blob | undefined>(response.httpStatusCode, "Unknown API Status Code!", await response.getBodyAsAny(), response.headers);
    }



    /**
     * Unwraps the actual response sent by the server from the response context and deserializes the response content
     * to the expected objects
     *
     * @params response Response returned by the server for a request to getSubmodelElementValue
     * @throws ApiException if the response code was not in [200, 299]
     */
     public async getSubmodelElementValueWithHttpInfo(response: ResponseContext): Promise<HttpInfo<SubmodelElementValue >> {
        const contentType = ObjectSerializer.normalizeMediaType(response.headers["content-type"]);
        if (isCodeInRange("200", response.httpStatusCode)) {
            const body: SubmodelElementValue = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "SubmodelElementValue", ""
            ) as SubmodelElementValue;
            return new HttpInfo(response.httpStatusCode, response.headers, response.body, body);
        }
        if (isCodeInRange("400", response.httpStatusCode)) {
            const body: Result = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "Result", ""
            ) as Result;
            throw new ApiException<Result>(response.httpStatusCode, "Bad Request, e.g. the request parameters of the format of the request body is wrong.", body, response.headers);
        }
        if (isCodeInRange("401", response.httpStatusCode)) {
            const body: Result = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "Result", ""
            ) as Result;
            throw new ApiException<Result>(response.httpStatusCode, "Unauthorized, e.g. the server refused the authorization attempt.", body, response.headers);
        }
        if (isCodeInRange("403", response.httpStatusCode)) {
            const body: Result = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "Result", ""
            ) as Result;
            throw new ApiException<Result>(response.httpStatusCode, "Forbidden", body, response.headers);
        }
        if (isCodeInRange("404", response.httpStatusCode)) {
            const body: Result = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "Result", ""
            ) as Result;
            throw new ApiException<Result>(response.httpStatusCode, "Not Found", body, response.headers);
        }
        if (isCodeInRange("500", response.httpStatusCode)) {
            const body: Result = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "Result", ""
            ) as Result;
            throw new ApiException<Result>(response.httpStatusCode, "Internal Server Error", body, response.headers);
        }
        if (isCodeInRange("0", response.httpStatusCode)) {
            const body: Result = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "Result", ""
            ) as Result;
            throw new ApiException<Result>(response.httpStatusCode, "Default error handling for unmentioned status codes", body, response.headers);
        }

        // Work around for missing responses in specification, e.g. for petstore.yaml
        if (response.httpStatusCode >= 200 && response.httpStatusCode <= 299) {
            const body: SubmodelElementValue = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "SubmodelElementValue", ""
            ) as SubmodelElementValue;
            return new HttpInfo(response.httpStatusCode, response.headers, response.body, body);
        }

        throw new ApiException<string | Blob | undefined>(response.httpStatusCode, "Unknown API Status Code!", await response.getBodyAsAny(), response.headers);
    }



    /**
     * Unwraps the actual response sent by the server from the response context and deserializes the response content
     * to the expected objects
     *
     * @params response Response returned by the server for a request to getSubmodelMetadata
     * @throws ApiException if the response code was not in [200, 299]
     */
     public async getSubmodelMetadataWithHttpInfo(response: ResponseContext): Promise<HttpInfo<SubmodelMetadata >> {
        const contentType = ObjectSerializer.normalizeMediaType(response.headers["content-type"]);
        if (isCodeInRange("200", response.httpStatusCode)) {
            const body: SubmodelMetadata = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "SubmodelMetadata", ""
            ) as SubmodelMetadata;
            return new HttpInfo(response.httpStatusCode, response.headers, response.body, body);
        }
        if (isCodeInRange("400", response.httpStatusCode)) {
            const body: Result = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "Result", ""
            ) as Result;
            throw new ApiException<Result>(response.httpStatusCode, "Bad Request, e.g. the request parameters of the format of the request body is wrong.", body, response.headers);
        }
        if (isCodeInRange("401", response.httpStatusCode)) {
            const body: Result = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "Result", ""
            ) as Result;
            throw new ApiException<Result>(response.httpStatusCode, "Unauthorized, e.g. the server refused the authorization attempt.", body, response.headers);
        }
        if (isCodeInRange("403", response.httpStatusCode)) {
            const body: Result = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "Result", ""
            ) as Result;
            throw new ApiException<Result>(response.httpStatusCode, "Forbidden", body, response.headers);
        }
        if (isCodeInRange("404", response.httpStatusCode)) {
            const body: Result = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "Result", ""
            ) as Result;
            throw new ApiException<Result>(response.httpStatusCode, "Not Found", body, response.headers);
        }
        if (isCodeInRange("500", response.httpStatusCode)) {
            const body: Result = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "Result", ""
            ) as Result;
            throw new ApiException<Result>(response.httpStatusCode, "Internal Server Error", body, response.headers);
        }
        if (isCodeInRange("0", response.httpStatusCode)) {
            const body: Result = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "Result", ""
            ) as Result;
            throw new ApiException<Result>(response.httpStatusCode, "Default error handling for unmentioned status codes", body, response.headers);
        }

        // Work around for missing responses in specification, e.g. for petstore.yaml
        if (response.httpStatusCode >= 200 && response.httpStatusCode <= 299) {
            const body: SubmodelMetadata = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "SubmodelMetadata", ""
            ) as SubmodelMetadata;
            return new HttpInfo(response.httpStatusCode, response.headers, response.body, body);
        }

        throw new ApiException<string | Blob | undefined>(response.httpStatusCode, "Unknown API Status Code!", await response.getBodyAsAny(), response.headers);
    }



    /**
     * Unwraps the actual response sent by the server from the response context and deserializes the response content
     * to the expected objects
     *
     * @params response Response returned by the server for a request to invokeOperation
     * @throws ApiException if the response code was not in [200, 299]
     */
     public async invokeOperationWithHttpInfo(response: ResponseContext): Promise<HttpInfo<OperationResult >> {
        const contentType = ObjectSerializer.normalizeMediaType(response.headers["content-type"]);
        if (isCodeInRange("200", response.httpStatusCode)) {
            const body: OperationResult = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "OperationResult", ""
            ) as OperationResult;
            return new HttpInfo(response.httpStatusCode, response.headers, response.body, body);
        }
        if (isCodeInRange("400", response.httpStatusCode)) {
            const body: Result = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "Result", ""
            ) as Result;
            throw new ApiException<Result>(response.httpStatusCode, "Bad Request, e.g. the request parameters of the format of the request body is wrong.", body, response.headers);
        }
        if (isCodeInRange("401", response.httpStatusCode)) {
            const body: Result = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "Result", ""
            ) as Result;
            throw new ApiException<Result>(response.httpStatusCode, "Unauthorized, e.g. the server refused the authorization attempt.", body, response.headers);
        }
        if (isCodeInRange("403", response.httpStatusCode)) {
            const body: Result = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "Result", ""
            ) as Result;
            throw new ApiException<Result>(response.httpStatusCode, "Forbidden", body, response.headers);
        }
        if (isCodeInRange("404", response.httpStatusCode)) {
            const body: Result = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "Result", ""
            ) as Result;
            throw new ApiException<Result>(response.httpStatusCode, "Not Found", body, response.headers);
        }
        if (isCodeInRange("405", response.httpStatusCode)) {
            const body: Result = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "Result", ""
            ) as Result;
            throw new ApiException<Result>(response.httpStatusCode, "Method not allowed - Invoke only valid for Operation submodel element", body, response.headers);
        }
        if (isCodeInRange("500", response.httpStatusCode)) {
            const body: Result = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "Result", ""
            ) as Result;
            throw new ApiException<Result>(response.httpStatusCode, "Internal Server Error", body, response.headers);
        }
        if (isCodeInRange("0", response.httpStatusCode)) {
            const body: Result = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "Result", ""
            ) as Result;
            throw new ApiException<Result>(response.httpStatusCode, "Default error handling for unmentioned status codes", body, response.headers);
        }

        // Work around for missing responses in specification, e.g. for petstore.yaml
        if (response.httpStatusCode >= 200 && response.httpStatusCode <= 299) {
            const body: OperationResult = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "OperationResult", ""
            ) as OperationResult;
            return new HttpInfo(response.httpStatusCode, response.headers, response.body, body);
        }

        throw new ApiException<string | Blob | undefined>(response.httpStatusCode, "Unknown API Status Code!", await response.getBodyAsAny(), response.headers);
    }



    /**
     * Unwraps the actual response sent by the server from the response context and deserializes the response content
     * to the expected objects
     *
     * @params response Response returned by the server for a request to patchSubmodelElementValue
     * @throws ApiException if the response code was not in [200, 299]
     */
     public async patchSubmodelElementValueWithHttpInfo(response: ResponseContext): Promise<HttpInfo<void >> {
        const contentType = ObjectSerializer.normalizeMediaType(response.headers["content-type"]);
        if (isCodeInRange("204", response.httpStatusCode)) {
            return new HttpInfo(response.httpStatusCode, response.headers, response.body, undefined);
        }
        if (isCodeInRange("400", response.httpStatusCode)) {
            const body: Result = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "Result", ""
            ) as Result;
            throw new ApiException<Result>(response.httpStatusCode, "Bad Request, e.g. the request parameters of the format of the request body is wrong.", body, response.headers);
        }
        if (isCodeInRange("401", response.httpStatusCode)) {
            const body: Result = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "Result", ""
            ) as Result;
            throw new ApiException<Result>(response.httpStatusCode, "Unauthorized, e.g. the server refused the authorization attempt.", body, response.headers);
        }
        if (isCodeInRange("403", response.httpStatusCode)) {
            const body: Result = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "Result", ""
            ) as Result;
            throw new ApiException<Result>(response.httpStatusCode, "Forbidden", body, response.headers);
        }
        if (isCodeInRange("404", response.httpStatusCode)) {
            const body: Result = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "Result", ""
            ) as Result;
            throw new ApiException<Result>(response.httpStatusCode, "Not Found", body, response.headers);
        }
        if (isCodeInRange("500", response.httpStatusCode)) {
            const body: Result = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "Result", ""
            ) as Result;
            throw new ApiException<Result>(response.httpStatusCode, "Internal Server Error", body, response.headers);
        }
        if (isCodeInRange("0", response.httpStatusCode)) {
            const body: Result = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "Result", ""
            ) as Result;
            throw new ApiException<Result>(response.httpStatusCode, "Default error handling for unmentioned status codes", body, response.headers);
        }

        // Work around for missing responses in specification, e.g. for petstore.yaml
        if (response.httpStatusCode >= 200 && response.httpStatusCode <= 299) {
            const body: void = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "void", ""
            ) as void;
            return new HttpInfo(response.httpStatusCode, response.headers, response.body, body);
        }

        throw new ApiException<string | Blob | undefined>(response.httpStatusCode, "Unknown API Status Code!", await response.getBodyAsAny(), response.headers);
    }



    /**
     * Unwraps the actual response sent by the server from the response context and deserializes the response content
     * to the expected objects
     *
     * @params response Response returned by the server for a request to postSubmodel
     * @throws ApiException if the response code was not in [200, 299]
     */
     public async postSubmodelWithHttpInfo(response: ResponseContext): Promise<HttpInfo<Submodel >> {
        const contentType = ObjectSerializer.normalizeMediaType(response.headers["content-type"]);
        if (isCodeInRange("201", response.httpStatusCode)) {
            const body: Submodel = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "Submodel", ""
            ) as Submodel;
            return new HttpInfo(response.httpStatusCode, response.headers, response.body, body);
        }
        if (isCodeInRange("400", response.httpStatusCode)) {
            const body: Result = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "Result", ""
            ) as Result;
            throw new ApiException<Result>(response.httpStatusCode, "Bad Request, e.g. the request parameters of the format of the request body is wrong.", body, response.headers);
        }
        if (isCodeInRange("401", response.httpStatusCode)) {
            const body: Result = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "Result", ""
            ) as Result;
            throw new ApiException<Result>(response.httpStatusCode, "Unauthorized, e.g. the server refused the authorization attempt.", body, response.headers);
        }
        if (isCodeInRange("403", response.httpStatusCode)) {
            const body: Result = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "Result", ""
            ) as Result;
            throw new ApiException<Result>(response.httpStatusCode, "Forbidden", body, response.headers);
        }
        if (isCodeInRange("409", response.httpStatusCode)) {
            const body: Result = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "Result", ""
            ) as Result;
            throw new ApiException<Result>(response.httpStatusCode, "Conflict, a resource which shall be created exists already. Might be thrown if a Submodel or SubmodelElement with the same ShortId is contained in a POST request.", body, response.headers);
        }
        if (isCodeInRange("500", response.httpStatusCode)) {
            const body: Result = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "Result", ""
            ) as Result;
            throw new ApiException<Result>(response.httpStatusCode, "Internal Server Error", body, response.headers);
        }
        if (isCodeInRange("0", response.httpStatusCode)) {
            const body: Result = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "Result", ""
            ) as Result;
            throw new ApiException<Result>(response.httpStatusCode, "Default error handling for unmentioned status codes", body, response.headers);
        }

        // Work around for missing responses in specification, e.g. for petstore.yaml
        if (response.httpStatusCode >= 200 && response.httpStatusCode <= 299) {
            const body: Submodel = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "Submodel", ""
            ) as Submodel;
            return new HttpInfo(response.httpStatusCode, response.headers, response.body, body);
        }

        throw new ApiException<string | Blob | undefined>(response.httpStatusCode, "Unknown API Status Code!", await response.getBodyAsAny(), response.headers);
    }



    /**
     * Unwraps the actual response sent by the server from the response context and deserializes the response content
     * to the expected objects
     *
     * @params response Response returned by the server for a request to postSubmodelElement
     * @throws ApiException if the response code was not in [200, 299]
     */
     public async postSubmodelElementWithHttpInfo(response: ResponseContext): Promise<HttpInfo<SubmodelElement >> {
        const contentType = ObjectSerializer.normalizeMediaType(response.headers["content-type"]);
        if (isCodeInRange("201", response.httpStatusCode)) {
            const body: SubmodelElement = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "SubmodelElement", ""
            ) as SubmodelElement;
            return new HttpInfo(response.httpStatusCode, response.headers, response.body, body);
        }
        if (isCodeInRange("400", response.httpStatusCode)) {
            const body: Result = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "Result", ""
            ) as Result;
            throw new ApiException<Result>(response.httpStatusCode, "Bad Request, e.g. the request parameters of the format of the request body is wrong.", body, response.headers);
        }
        if (isCodeInRange("401", response.httpStatusCode)) {
            const body: Result = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "Result", ""
            ) as Result;
            throw new ApiException<Result>(response.httpStatusCode, "Unauthorized, e.g. the server refused the authorization attempt.", body, response.headers);
        }
        if (isCodeInRange("403", response.httpStatusCode)) {
            const body: Result = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "Result", ""
            ) as Result;
            throw new ApiException<Result>(response.httpStatusCode, "Forbidden", body, response.headers);
        }
        if (isCodeInRange("404", response.httpStatusCode)) {
            const body: Result = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "Result", ""
            ) as Result;
            throw new ApiException<Result>(response.httpStatusCode, "Not Found", body, response.headers);
        }
        if (isCodeInRange("409", response.httpStatusCode)) {
            const body: Result = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "Result", ""
            ) as Result;
            throw new ApiException<Result>(response.httpStatusCode, "Conflict, a resource which shall be created exists already. Might be thrown if a Submodel or SubmodelElement with the same ShortId is contained in a POST request.", body, response.headers);
        }
        if (isCodeInRange("500", response.httpStatusCode)) {
            const body: Result = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "Result", ""
            ) as Result;
            throw new ApiException<Result>(response.httpStatusCode, "Internal Server Error", body, response.headers);
        }
        if (isCodeInRange("0", response.httpStatusCode)) {
            const body: Result = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "Result", ""
            ) as Result;
            throw new ApiException<Result>(response.httpStatusCode, "Default error handling for unmentioned status codes", body, response.headers);
        }

        // Work around for missing responses in specification, e.g. for petstore.yaml
        if (response.httpStatusCode >= 200 && response.httpStatusCode <= 299) {
            const body: SubmodelElement = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "SubmodelElement", ""
            ) as SubmodelElement;
            return new HttpInfo(response.httpStatusCode, response.headers, response.body, body);
        }

        throw new ApiException<string | Blob | undefined>(response.httpStatusCode, "Unknown API Status Code!", await response.getBodyAsAny(), response.headers);
    }



    /**
     * Unwraps the actual response sent by the server from the response context and deserializes the response content
     * to the expected objects
     *
     * @params response Response returned by the server for a request to postSubmodelElementUnderPath
     * @throws ApiException if the response code was not in [200, 299]
     */
     public async postSubmodelElementUnderPathWithHttpInfo(response: ResponseContext): Promise<HttpInfo<SubmodelElement >> {
        const contentType = ObjectSerializer.normalizeMediaType(response.headers["content-type"]);
        if (isCodeInRange("201", response.httpStatusCode)) {
            const body: SubmodelElement = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "SubmodelElement", ""
            ) as SubmodelElement;
            return new HttpInfo(response.httpStatusCode, response.headers, response.body, body);
        }
        if (isCodeInRange("400", response.httpStatusCode)) {
            const body: Result = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "Result", ""
            ) as Result;
            throw new ApiException<Result>(response.httpStatusCode, "Bad Request, e.g. the request parameters of the format of the request body is wrong.", body, response.headers);
        }
        if (isCodeInRange("401", response.httpStatusCode)) {
            const body: Result = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "Result", ""
            ) as Result;
            throw new ApiException<Result>(response.httpStatusCode, "Unauthorized, e.g. the server refused the authorization attempt.", body, response.headers);
        }
        if (isCodeInRange("403", response.httpStatusCode)) {
            const body: Result = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "Result", ""
            ) as Result;
            throw new ApiException<Result>(response.httpStatusCode, "Forbidden", body, response.headers);
        }
        if (isCodeInRange("404", response.httpStatusCode)) {
            const body: Result = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "Result", ""
            ) as Result;
            throw new ApiException<Result>(response.httpStatusCode, "Not Found", body, response.headers);
        }
        if (isCodeInRange("409", response.httpStatusCode)) {
            const body: Result = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "Result", ""
            ) as Result;
            throw new ApiException<Result>(response.httpStatusCode, "Conflict, a resource which shall be created exists already. Might be thrown if a Submodel or SubmodelElement with the same ShortId is contained in a POST request.", body, response.headers);
        }
        if (isCodeInRange("500", response.httpStatusCode)) {
            const body: Result = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "Result", ""
            ) as Result;
            throw new ApiException<Result>(response.httpStatusCode, "Internal Server Error", body, response.headers);
        }
        if (isCodeInRange("0", response.httpStatusCode)) {
            const body: Result = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "Result", ""
            ) as Result;
            throw new ApiException<Result>(response.httpStatusCode, "Default error handling for unmentioned status codes", body, response.headers);
        }

        // Work around for missing responses in specification, e.g. for petstore.yaml
        if (response.httpStatusCode >= 200 && response.httpStatusCode <= 299) {
            const body: SubmodelElement = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "SubmodelElement", ""
            ) as SubmodelElement;
            return new HttpInfo(response.httpStatusCode, response.headers, response.body, body);
        }

        throw new ApiException<string | Blob | undefined>(response.httpStatusCode, "Unknown API Status Code!", await response.getBodyAsAny(), response.headers);
    }



    /**
     * Unwraps the actual response sent by the server from the response context and deserializes the response content
     * to the expected objects
     *
     * @params response Response returned by the server for a request to putFileAttachment
     * @throws ApiException if the response code was not in [200, 299]
     */
     public async putFileAttachmentWithHttpInfo(response: ResponseContext): Promise<HttpInfo<void >> {
        const contentType = ObjectSerializer.normalizeMediaType(response.headers["content-type"]);
        if (isCodeInRange("204", response.httpStatusCode)) {
            return new HttpInfo(response.httpStatusCode, response.headers, response.body, undefined);
        }
        if (isCodeInRange("400", response.httpStatusCode)) {
            const body: Result = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "Result", ""
            ) as Result;
            throw new ApiException<Result>(response.httpStatusCode, "Bad Request, e.g. the request parameters of the format of the request body is wrong.", body, response.headers);
        }
        if (isCodeInRange("401", response.httpStatusCode)) {
            const body: Result = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "Result", ""
            ) as Result;
            throw new ApiException<Result>(response.httpStatusCode, "Unauthorized, e.g. the server refused the authorization attempt.", body, response.headers);
        }
        if (isCodeInRange("403", response.httpStatusCode)) {
            const body: Result = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "Result", ""
            ) as Result;
            throw new ApiException<Result>(response.httpStatusCode, "Forbidden", body, response.headers);
        }
        if (isCodeInRange("404", response.httpStatusCode)) {
            const body: Result = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "Result", ""
            ) as Result;
            throw new ApiException<Result>(response.httpStatusCode, "Not Found", body, response.headers);
        }
        if (isCodeInRange("405", response.httpStatusCode)) {
            const body: Result = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "Result", ""
            ) as Result;
            throw new ApiException<Result>(response.httpStatusCode, "Method not allowed - Upload only valid for File submodel element", body, response.headers);
        }
        if (isCodeInRange("500", response.httpStatusCode)) {
            const body: Result = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "Result", ""
            ) as Result;
            throw new ApiException<Result>(response.httpStatusCode, "Internal Server Error", body, response.headers);
        }
        if (isCodeInRange("0", response.httpStatusCode)) {
            const body: Result = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "Result", ""
            ) as Result;
            throw new ApiException<Result>(response.httpStatusCode, "Default error handling for unmentioned status codes", body, response.headers);
        }

        // Work around for missing responses in specification, e.g. for petstore.yaml
        if (response.httpStatusCode >= 200 && response.httpStatusCode <= 299) {
            const body: void = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "void", ""
            ) as void;
            return new HttpInfo(response.httpStatusCode, response.headers, response.body, body);
        }

        throw new ApiException<string | Blob | undefined>(response.httpStatusCode, "Unknown API Status Code!", await response.getBodyAsAny(), response.headers);
    }



    /**
     * Unwraps the actual response sent by the server from the response context and deserializes the response content
     * to the expected objects
     *
     * @params response Response returned by the server for a request to putSubmodel
     * @throws ApiException if the response code was not in [200, 299]
     */
     public async putSubmodelWithHttpInfo(response: ResponseContext): Promise<HttpInfo<void >> {
        const contentType = ObjectSerializer.normalizeMediaType(response.headers["content-type"]);
        if (isCodeInRange("204", response.httpStatusCode)) {
            return new HttpInfo(response.httpStatusCode, response.headers, response.body, undefined);
        }
        if (isCodeInRange("400", response.httpStatusCode)) {
            const body: Result = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "Result", ""
            ) as Result;
            throw new ApiException<Result>(response.httpStatusCode, "Bad Request, e.g. the request parameters of the format of the request body is wrong.", body, response.headers);
        }
        if (isCodeInRange("401", response.httpStatusCode)) {
            const body: Result = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "Result", ""
            ) as Result;
            throw new ApiException<Result>(response.httpStatusCode, "Unauthorized, e.g. the server refused the authorization attempt.", body, response.headers);
        }
        if (isCodeInRange("403", response.httpStatusCode)) {
            const body: Result = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "Result", ""
            ) as Result;
            throw new ApiException<Result>(response.httpStatusCode, "Forbidden", body, response.headers);
        }
        if (isCodeInRange("404", response.httpStatusCode)) {
            const body: Result = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "Result", ""
            ) as Result;
            throw new ApiException<Result>(response.httpStatusCode, "Not Found", body, response.headers);
        }
        if (isCodeInRange("500", response.httpStatusCode)) {
            const body: Result = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "Result", ""
            ) as Result;
            throw new ApiException<Result>(response.httpStatusCode, "Internal Server Error", body, response.headers);
        }
        if (isCodeInRange("0", response.httpStatusCode)) {
            const body: Result = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "Result", ""
            ) as Result;
            throw new ApiException<Result>(response.httpStatusCode, "Default error handling for unmentioned status codes", body, response.headers);
        }

        // Work around for missing responses in specification, e.g. for petstore.yaml
        if (response.httpStatusCode >= 200 && response.httpStatusCode <= 299) {
            const body: void = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "void", ""
            ) as void;
            return new HttpInfo(response.httpStatusCode, response.headers, response.body, body);
        }

        throw new ApiException<string | Blob | undefined>(response.httpStatusCode, "Unknown API Status Code!", await response.getBodyAsAny(), response.headers);
    }



    /**
     * Unwraps the actual response sent by the server from the response context and deserializes the response content
     * to the expected objects
     *
     * @params response Response returned by the server for a request to putSubmodelElement
     * @throws ApiException if the response code was not in [200, 299]
     */
     public async putSubmodelElementWithHttpInfo(response: ResponseContext): Promise<HttpInfo<void >> {
        const contentType = ObjectSerializer.normalizeMediaType(response.headers["content-type"]);
        if (isCodeInRange("204", response.httpStatusCode)) {
            return new HttpInfo(response.httpStatusCode, response.headers, response.body, undefined);
        }
        if (isCodeInRange("400", response.httpStatusCode)) {
            const body: Result = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "Result", ""
            ) as Result;
            throw new ApiException<Result>(response.httpStatusCode, "Bad Request, e.g. the request parameters of the format of the request body is wrong.", body, response.headers);
        }
        if (isCodeInRange("401", response.httpStatusCode)) {
            const body: Result = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "Result", ""
            ) as Result;
            throw new ApiException<Result>(response.httpStatusCode, "Unauthorized, e.g. the server refused the authorization attempt.", body, response.headers);
        }
        if (isCodeInRange("403", response.httpStatusCode)) {
            const body: Result = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "Result", ""
            ) as Result;
            throw new ApiException<Result>(response.httpStatusCode, "Forbidden", body, response.headers);
        }
        if (isCodeInRange("404", response.httpStatusCode)) {
            const body: Result = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "Result", ""
            ) as Result;
            throw new ApiException<Result>(response.httpStatusCode, "Not Found", body, response.headers);
        }
        if (isCodeInRange("500", response.httpStatusCode)) {
            const body: Result = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "Result", ""
            ) as Result;
            throw new ApiException<Result>(response.httpStatusCode, "Internal Server Error", body, response.headers);
        }
        if (isCodeInRange("0", response.httpStatusCode)) {
            const body: Result = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "Result", ""
            ) as Result;
            throw new ApiException<Result>(response.httpStatusCode, "Default error handling for unmentioned status codes", body, response.headers);
        }

        // Work around for missing responses in specification, e.g. for petstore.yaml
        if (response.httpStatusCode >= 200 && response.httpStatusCode <= 299) {
            const body: void = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "void", ""
            ) as void;
            return new HttpInfo(response.httpStatusCode, response.headers, response.body, body);
        }

        throw new ApiException<string | Blob | undefined>(response.httpStatusCode, "Unknown API Status Code!", await response.getBodyAsAny(), response.headers);
    }

}
