import { ResponseContext, RequestContext, HttpFile, HttpInfo } from '../../http/http';
import { Configuration} from '../../configuration'


import { SpecificAssetId } from '../../models/part1/SpecificAssetId';
import { ServiceDescription } from '../../models/part2/ServiceDescription';


import { ObservableAssetAdministrationShellBasicDiscoveryApi } from "./ObservableAPI";
import { AssetAdministrationShellBasicDiscoveryApiRequestFactory, AssetAdministrationShellBasicDiscoveryApiResponseProcessor} from "../../apis/AssetAdministrationShellBasicDiscoveryApi";

export interface AssetAdministrationShellBasicDiscoveryApiDeleteAssetLinksByShellIdRequest {
    /**
     * The Asset Administration Shell’s unique id (UTF8-BASE64-URL-encoded)
     * @type string
     * @memberof AssetAdministrationShellBasicDiscoveryApideleteAssetLinksByShellId
     */
    aasIdentifier: string
}

export interface AssetAdministrationShellBasicDiscoveryApiGetAllShellIdsByAssetLinksRequest {
    /**
     * A list of specific Asset identifiers. Each Asset identifier is a base64-url-encoded [SpecificAssetId](./model-part1.yaml#/components/schemas/SpecificAssetId)
     * @type Array&lt;SpecificAssetId&gt;
     * @memberof AssetAdministrationShellBasicDiscoveryApigetAllShellIdsByAssetLinks
     */
    assetIds?: Array<SpecificAssetId>
    /**
     * The maximum number of elements in the response array
     * @type number
     * @memberof AssetAdministrationShellBasicDiscoveryApigetAllShellIdsByAssetLinks
     */
    limit?: number
    /**
     * A server-generated identifier retrieved from pagingMetadata that specifies from which position the result listing should continue
     * @type string
     * @memberof AssetAdministrationShellBasicDiscoveryApigetAllShellIdsByAssetLinks
     */
    cursor?: string
}

export interface AssetAdministrationShellBasicDiscoveryApiGetAssetLinksByShellIdRequest {
    /**
     * The Asset Administration Shell’s unique id (UTF8-BASE64-URL-encoded)
     * @type string
     * @memberof AssetAdministrationShellBasicDiscoveryApigetAssetLinksByShellId
     */
    aasIdentifier: string
}

export interface AssetAdministrationShellBasicDiscoveryApiGetDescriptionRequest {
}

export interface AssetAdministrationShellBasicDiscoveryApiPostAssetLinksByShellIdRequest {
    /**
     * The Asset Administration Shell’s unique id (UTF8-BASE64-URL-encoded)
     * @type string
     * @memberof AssetAdministrationShellBasicDiscoveryApipostAssetLinksByShellId
     */
    aasIdentifier: string
    /**
     * A list of specific Asset identifiers
     * @type Array&lt;SpecificAssetId&gt;
     * @memberof AssetAdministrationShellBasicDiscoveryApipostAssetLinksByShellId
     */
    specificAssetId: Array<SpecificAssetId>
}

export class ObjectAssetAdministrationShellBasicDiscoveryApi {
    private api: ObservableAssetAdministrationShellBasicDiscoveryApi

    public constructor(configuration: Configuration, requestFactory?: AssetAdministrationShellBasicDiscoveryApiRequestFactory, responseProcessor?: AssetAdministrationShellBasicDiscoveryApiResponseProcessor) {
        this.api = new ObservableAssetAdministrationShellBasicDiscoveryApi(configuration, requestFactory, responseProcessor);
    }

    /**
     * Deletes all specific Asset identifiers linked to an Asset Administration Shell to edit discoverable content
     * @param param the request object
     */
    public deleteAssetLinksByShellIdWithHttpInfo(param: AssetAdministrationShellBasicDiscoveryApiDeleteAssetLinksByShellIdRequest, options?: Configuration): Promise<HttpInfo<void>> {
        return this.api.deleteAssetLinksByShellIdWithHttpInfo(param.aasIdentifier,  options).toPromise();
    }

    /**
     * Deletes all specific Asset identifiers linked to an Asset Administration Shell to edit discoverable content
     * @param param the request object
     */
    public deleteAssetLinksByShellId(param: AssetAdministrationShellBasicDiscoveryApiDeleteAssetLinksByShellIdRequest, options?: Configuration): Promise<void> {
        return this.api.deleteAssetLinksByShellId(param.aasIdentifier,  options).toPromise();
    }

    /**
     * Returns a list of Asset Administration Shell ids linked to specific Asset identifiers
     * @param param the request object
     */
    public getAllShellIdsByAssetLinksWithHttpInfo(param: AssetAdministrationShellBasicDiscoveryApiGetAllShellIdsByAssetLinksRequest = {}, options?: Configuration): Promise<HttpInfo<GetAllAssetLinksResult>> {
        return this.api.getAllShellIdsByAssetLinksWithHttpInfo(param.assetIds, param.limit, param.cursor,  options).toPromise();
    }

    /**
     * Returns a list of Asset Administration Shell ids linked to specific Asset identifiers
     * @param param the request object
     */
    public getAllShellIdsByAssetLinks(param: AssetAdministrationShellBasicDiscoveryApiGetAllShellIdsByAssetLinksRequest = {}, options?: Configuration): Promise<GetAllAssetLinksResult> {
        return this.api.getAllShellIdsByAssetLinks(param.assetIds, param.limit, param.cursor,  options).toPromise();
    }

    /**
     * Returns a list of specific Asset identifiers based on an Asset Administration Shell id to edit discoverable content
     * @param param the request object
     */
    public getAssetLinksByShellIdWithHttpInfo(param: AssetAdministrationShellBasicDiscoveryApiGetAssetLinksByShellIdRequest, options?: Configuration): Promise<HttpInfo<Array<SpecificAssetId>>> {
        return this.api.getAssetLinksByShellIdWithHttpInfo(param.aasIdentifier,  options).toPromise();
    }

    /**
     * Returns a list of specific Asset identifiers based on an Asset Administration Shell id to edit discoverable content
     * @param param the request object
     */
    public getAssetLinksByShellId(param: AssetAdministrationShellBasicDiscoveryApiGetAssetLinksByShellIdRequest, options?: Configuration): Promise<Array<SpecificAssetId>> {
        return this.api.getAssetLinksByShellId(param.aasIdentifier,  options).toPromise();
    }

    /**
     * Returns the self-describing information of a network resource (ServiceDescription)
     * @param param the request object
     */
    public getDescriptionWithHttpInfo(param: AssetAdministrationShellBasicDiscoveryApiGetDescriptionRequest = {}, options?: Configuration): Promise<HttpInfo<ServiceDescription>> {
        return this.api.getDescriptionWithHttpInfo( options).toPromise();
    }

    /**
     * Returns the self-describing information of a network resource (ServiceDescription)
     * @param param the request object
     */
    public getDescription(param: AssetAdministrationShellBasicDiscoveryApiGetDescriptionRequest = {}, options?: Configuration): Promise<ServiceDescription> {
        return this.api.getDescription( options).toPromise();
    }

    /**
     * Creates specific Asset identifiers linked to an Asset Administration Shell to edit discoverable content
     * @param param the request object
     */
    public postAssetLinksByShellIdWithHttpInfo(param: AssetAdministrationShellBasicDiscoveryApiPostAssetLinksByShellIdRequest, options?: Configuration): Promise<HttpInfo<Array<SpecificAssetId>>> {
        return this.api.postAssetLinksByShellIdWithHttpInfo(param.aasIdentifier, param.specificAssetId,  options).toPromise();
    }

    /**
     * Creates specific Asset identifiers linked to an Asset Administration Shell to edit discoverable content
     * @param param the request object
     */
    public postAssetLinksByShellId(param: AssetAdministrationShellBasicDiscoveryApiPostAssetLinksByShellIdRequest, options?: Configuration): Promise<Array<SpecificAssetId>> {
        return this.api.postAssetLinksByShellId(param.aasIdentifier, param.specificAssetId,  options).toPromise();
    }

}
