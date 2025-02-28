// TODO: better import syntax?
import {BaseAPIRequestFactory, RequiredError, COLLECTION_FORMATS} from './baseapi';
import {Configuration} from '../configuration';
import {RequestContext, HttpMethod, ResponseContext, HttpFile, HttpInfo} from '../http/http';
import {ObjectSerializer} from '../models/ObjectSerializer';
import {ApiException} from './exception';
import {canConsumeForm, isCodeInRange} from '../util';
import {SecurityAuthentication} from '../auth/auth';


import { GetAllAssetLinksResult } from '../models/discovery/GetAllAssetLinksResult';
import { Result } from '../models/part2/Result';
import { ServiceDescription } from '../models/part2/ServiceDescription';
import { SpecificAssetId } from '../models/part1/SpecificAssetId';

/**
 * no description
 */
export class AssetAdministrationShellBasicDiscoveryApiRequestFactory extends BaseAPIRequestFactory {

    /**
     * Deletes all specific Asset identifiers linked to an Asset Administration Shell to edit discoverable content
     * @param aasIdentifier The Asset Administration Shell’s unique id (UTF8-BASE64-URL-encoded)
     */
    public async deleteAssetLinksByShellId(aasIdentifier: string, _options?: Configuration): Promise<RequestContext> {
        if (aasIdentifier !== undefined)  {

            aasIdentifier = encodeURI(window.btoa(aasIdentifier));
        }


        return this.deleteAssetLinksByShellId(aasIdentifier, _options);
    }

    
    private async deleteAssetLinksByShellIdNoUrlEncoding(aasIdentifier: string, _options?: Configuration): Promise<RequestContext> {
        let _config = _options || this.configuration;

        // verify required parameter 'aasIdentifier' is not null or undefined
        if (aasIdentifier === null || aasIdentifier === undefined) {
            throw new RequiredError("AssetAdministrationShellBasicDiscoveryApi", "deleteAssetLinksByShellId", "aasIdentifier");
        }


        // Path Params
        const localVarPath = '/lookup/shells/{aasIdentifier}'
            .replace('{' + 'aasIdentifier' + '}', encodeURIComponent(String(aasIdentifier)));

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
     * Returns a list of Asset Administration Shell ids linked to specific Asset identifiers
     * @param assetIds A list of specific Asset identifiers. Each Asset identifier is a base64-url-encoded [SpecificAssetId](./model-part1.yaml#/components/schemas/SpecificAssetId)
     * @param limit The maximum number of elements in the response array
     * @param cursor A server-generated identifier retrieved from pagingMetadata that specifies from which position the result listing should continue
     */
    public async getAllShellIdsByAssetLinks(assetIds?: Array<SpecificAssetId>, limit?: number, cursor?: string, _options?: Configuration): Promise<RequestContext> {



        return this.getAllShellIdsByAssetLinks(assetIds, limit, cursor, _options);
    }

    
    private async getAllShellIdsByAssetLinksNoUrlEncoding(assetIds?: Array<SpecificAssetId>, limit?: number, cursor?: string, _options?: Configuration): Promise<RequestContext> {
        let _config = _options || this.configuration;




        // Path Params
        const localVarPath = '/lookup/shells';

        // Make Request Context
        const requestContext = _config.baseServer.makeRequestContext(localVarPath, HttpMethod.GET);
        requestContext.setHeaderParam("Accept", "application/json, */*;q=0.8")

        // Query Params
        if (assetIds !== undefined) {
            requestContext.setQueryParam("assetIds", ObjectSerializer.serialize(assetIds, "Array<SpecificAssetId>", ""));
        }

        // Query Params
        if (limit !== undefined) {
            requestContext.setQueryParam("limit", ObjectSerializer.serialize(limit, "number", ""));
        }

        // Query Params
        if (cursor !== undefined) {
            requestContext.setQueryParam("cursor", ObjectSerializer.serialize(cursor, "string", ""));
        }


        
        const defaultAuth: SecurityAuthentication | undefined = _options?.authMethods?.default || this.configuration?.authMethods?.default
        if (defaultAuth?.applySecurityAuthentication) {
            await defaultAuth?.applySecurityAuthentication(requestContext);
        }

        return requestContext;
    }

    /**
     * Returns a list of specific Asset identifiers based on an Asset Administration Shell id to edit discoverable content
     * @param aasIdentifier The Asset Administration Shell’s unique id (UTF8-BASE64-URL-encoded)
     */
    public async getAssetLinksByShellId(aasIdentifier: string, _options?: Configuration): Promise<RequestContext> {
        if (aasIdentifier !== undefined)  {

            aasIdentifier = encodeURI(window.btoa(aasIdentifier));
        }


        return this.getAssetLinksByShellId(aasIdentifier, _options);
    }

    
    private async getAssetLinksByShellIdNoUrlEncoding(aasIdentifier: string, _options?: Configuration): Promise<RequestContext> {
        let _config = _options || this.configuration;

        // verify required parameter 'aasIdentifier' is not null or undefined
        if (aasIdentifier === null || aasIdentifier === undefined) {
            throw new RequiredError("AssetAdministrationShellBasicDiscoveryApi", "getAssetLinksByShellId", "aasIdentifier");
        }


        // Path Params
        const localVarPath = '/lookup/shells/{aasIdentifier}'
            .replace('{' + 'aasIdentifier' + '}', encodeURIComponent(String(aasIdentifier)));

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
     * Creates specific Asset identifiers linked to an Asset Administration Shell to edit discoverable content
     * @param aasIdentifier The Asset Administration Shell’s unique id (UTF8-BASE64-URL-encoded)
     * @param specificAssetId A list of specific Asset identifiers
     */
    public async postAssetLinksByShellId(aasIdentifier: string, specificAssetId: Array<SpecificAssetId>, _options?: Configuration): Promise<RequestContext> {
        if (aasIdentifier !== undefined)  {

            aasIdentifier = encodeURI(window.btoa(aasIdentifier));
        }


        return this.postAssetLinksByShellId(aasIdentifier, specificAssetId, _options);
    }

    
    private async postAssetLinksByShellIdNoUrlEncoding(aasIdentifier: string, specificAssetId: Array<SpecificAssetId>, _options?: Configuration): Promise<RequestContext> {
        let _config = _options || this.configuration;

        // verify required parameter 'aasIdentifier' is not null or undefined
        if (aasIdentifier === null || aasIdentifier === undefined) {
            throw new RequiredError("AssetAdministrationShellBasicDiscoveryApi", "postAssetLinksByShellId", "aasIdentifier");
        }


        // verify required parameter 'specificAssetId' is not null or undefined
        if (specificAssetId === null || specificAssetId === undefined) {
            throw new RequiredError("AssetAdministrationShellBasicDiscoveryApi", "postAssetLinksByShellId", "specificAssetId");
        }


        // Path Params
        const localVarPath = '/lookup/shells/{aasIdentifier}'
            .replace('{' + 'aasIdentifier' + '}', encodeURIComponent(String(aasIdentifier)));

        // Make Request Context
        const requestContext = _config.baseServer.makeRequestContext(localVarPath, HttpMethod.POST);
        requestContext.setHeaderParam("Accept", "application/json, */*;q=0.8")


        // Body Params
        const contentType = ObjectSerializer.getPreferredMediaType([
            "application/json"
        ]);
        requestContext.setHeaderParam("Content-Type", contentType);
        const serializedBody = ObjectSerializer.stringify(
            ObjectSerializer.serialize(specificAssetId, "Array<SpecificAssetId>", ""),
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

export class AssetAdministrationShellBasicDiscoveryApiResponseProcessor {



    /**
     * Unwraps the actual response sent by the server from the response context and deserializes the response content
     * to the expected objects
     *
     * @params response Response returned by the server for a request to deleteAssetLinksByShellId
     * @throws ApiException if the response code was not in [200, 299]
     */
     public async deleteAssetLinksByShellIdWithHttpInfo(response: ResponseContext): Promise<HttpInfo<void >> {
        const contentType = ObjectSerializer.normalizeMediaType(response.headers["content-type"]);
        if (isCodeInRange("204", response.httpStatusCode)) {
            return new HttpInfo(response.httpStatusCode, response.headers, response.body, undefined);
        }
        if (isCodeInRange("404", response.httpStatusCode)) {
            const body: Result = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "Result", ""
            ) as Result;
            throw new ApiException<Result>(response.httpStatusCode, "Not Found", body, response.headers);
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
     * @params response Response returned by the server for a request to getAllShellIdsByAssetLinks
     * @throws ApiException if the response code was not in [200, 299]
     */
     public async getAllShellIdsByAssetLinksWithHttpInfo(response: ResponseContext): Promise<HttpInfo<GetAllAssetLinksResult >> {
        const contentType = ObjectSerializer.normalizeMediaType(response.headers["content-type"]);
        if (isCodeInRange("200", response.httpStatusCode)) {
            const body: GetAllAssetLinksResult = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "GetAllAssetLinksResult", ""
            ) as GetAllAssetLinksResult;
            return new HttpInfo(response.httpStatusCode, response.headers, response.body, body);
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
            const body: GetAllAssetLinksResult = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "GetAllAssetLinksResult", ""
            ) as GetAllAssetLinksResult;
            return new HttpInfo(response.httpStatusCode, response.headers, response.body, body);
        }

        throw new ApiException<string | Blob | undefined>(response.httpStatusCode, "Unknown API Status Code!", await response.getBodyAsAny(), response.headers);
    }



    /**
     * Unwraps the actual response sent by the server from the response context and deserializes the response content
     * to the expected objects
     *
     * @params response Response returned by the server for a request to getAssetLinksByShellId
     * @throws ApiException if the response code was not in [200, 299]
     */
     public async getAssetLinksByShellIdWithHttpInfo(response: ResponseContext): Promise<HttpInfo<Array<SpecificAssetId> >> {
        const contentType = ObjectSerializer.normalizeMediaType(response.headers["content-type"]);
        if (isCodeInRange("200", response.httpStatusCode)) {
            const body: Array<SpecificAssetId> = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "Array<SpecificAssetId>", ""
            ) as Array<SpecificAssetId>;
            return new HttpInfo(response.httpStatusCode, response.headers, response.body, body);
        }
        if (isCodeInRange("404", response.httpStatusCode)) {
            const body: Result = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "Result", ""
            ) as Result;
            throw new ApiException<Result>(response.httpStatusCode, "Not Found", body, response.headers);
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
            const body: Array<SpecificAssetId> = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "Array<SpecificAssetId>", ""
            ) as Array<SpecificAssetId>;
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
        if (isCodeInRange("0", response.httpStatusCode)) {
            const body: Result = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "Result", ""
            ) as Result;
            throw new ApiException<Result>(response.httpStatusCode, "Default error handling for unmentioned status codes", body, response.headers);
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
     * @params response Response returned by the server for a request to postAssetLinksByShellId
     * @throws ApiException if the response code was not in [200, 299]
     */
     public async postAssetLinksByShellIdWithHttpInfo(response: ResponseContext): Promise<HttpInfo<Array<SpecificAssetId> >> {
        const contentType = ObjectSerializer.normalizeMediaType(response.headers["content-type"]);
        if (isCodeInRange("201", response.httpStatusCode)) {
            const body: Array<SpecificAssetId> = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "Array<SpecificAssetId>", ""
            ) as Array<SpecificAssetId>;
            return new HttpInfo(response.httpStatusCode, response.headers, response.body, body);
        }
        if (isCodeInRange("400", response.httpStatusCode)) {
            const body: Result = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "Result", ""
            ) as Result;
            throw new ApiException<Result>(response.httpStatusCode, "Bad Request, e.g. the request parameters of the format of the request body is wrong.", body, response.headers);
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
        if (isCodeInRange("0", response.httpStatusCode)) {
            const body: Result = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "Result", ""
            ) as Result;
            throw new ApiException<Result>(response.httpStatusCode, "Default error handling for unmentioned status codes", body, response.headers);
        }

        // Work around for missing responses in specification, e.g. for petstore.yaml
        if (response.httpStatusCode >= 200 && response.httpStatusCode <= 299) {
            const body: Array<SpecificAssetId> = ObjectSerializer.deserialize(
                ObjectSerializer.parse(await response.body.text(), contentType),
                "Array<SpecificAssetId>", ""
            ) as Array<SpecificAssetId>;
            return new HttpInfo(response.httpStatusCode, response.headers, response.body, body);
        }

        throw new ApiException<string | Blob | undefined>(response.httpStatusCode, "Unknown API Status Code!", await response.getBodyAsAny(), response.headers);
    }

}
