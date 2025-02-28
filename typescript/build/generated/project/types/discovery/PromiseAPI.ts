import { ResponseContext, RequestContext, HttpFile, HttpInfo } from '../../http/http';
import { Configuration} from '../../configuration'


import { SpecificAssetId } from '../../models/part1/SpecificAssetId';
import { ServiceDescription } from '../../models/part2/ServiceDescription';

import { ObservableAssetAdministrationShellBasicDiscoveryApi } from './ObservableAPI';

import { AssetAdministrationShellBasicDiscoveryApiRequestFactory, AssetAdministrationShellBasicDiscoveryApiResponseProcessor} from "../../apis/AssetAdministrationShellBasicDiscoveryApi";

export class PromiseAssetAdministrationShellBasicDiscoveryApi {
    private api: ObservableAssetAdministrationShellBasicDiscoveryApi

    public constructor(
        configuration: Configuration,
        requestFactory?: AssetAdministrationShellBasicDiscoveryApiRequestFactory,
        responseProcessor?: AssetAdministrationShellBasicDiscoveryApiResponseProcessor
    ) {
        this.api = new ObservableAssetAdministrationShellBasicDiscoveryApi(configuration, requestFactory, responseProcessor);
    }

    /**
     * Deletes all specific Asset identifiers linked to an Asset Administration Shell to edit discoverable content
     * @param aasIdentifier The Asset Administration Shell’s unique id (UTF8-BASE64-URL-encoded)
     */
    public deleteAssetLinksByShellIdWithHttpInfo(aasIdentifier: string, _options?: Configuration): Promise<HttpInfo<void>> {
        const result = this.api.deleteAssetLinksByShellIdWithHttpInfo(aasIdentifier, _options);
        return result.toPromise();
    }

    /**
     * Deletes all specific Asset identifiers linked to an Asset Administration Shell to edit discoverable content
     * @param aasIdentifier The Asset Administration Shell’s unique id (UTF8-BASE64-URL-encoded)
     */
    public deleteAssetLinksByShellId(aasIdentifier: string, _options?: Configuration): Promise<void> {
        const result = this.api.deleteAssetLinksByShellId(aasIdentifier, _options);
        return result.toPromise();
    }

    /**
     * Returns a list of Asset Administration Shell ids linked to specific Asset identifiers
     * @param assetIds A list of specific Asset identifiers. Each Asset identifier is a base64-url-encoded [SpecificAssetId](./model-part1.yaml#/components/schemas/SpecificAssetId)
     * @param limit The maximum number of elements in the response array
     * @param cursor A server-generated identifier retrieved from pagingMetadata that specifies from which position the result listing should continue
     */
    public getAllShellIdsByAssetLinksWithHttpInfo(assetIds?: Array<SpecificAssetId>, limit?: number, cursor?: string, _options?: Configuration): Promise<HttpInfo<GetAllAssetLinksResult>> {
        const result = this.api.getAllShellIdsByAssetLinksWithHttpInfo(assetIds, limit, cursor, _options);
        return result.toPromise();
    }

    /**
     * Returns a list of Asset Administration Shell ids linked to specific Asset identifiers
     * @param assetIds A list of specific Asset identifiers. Each Asset identifier is a base64-url-encoded [SpecificAssetId](./model-part1.yaml#/components/schemas/SpecificAssetId)
     * @param limit The maximum number of elements in the response array
     * @param cursor A server-generated identifier retrieved from pagingMetadata that specifies from which position the result listing should continue
     */
    public getAllShellIdsByAssetLinks(assetIds?: Array<SpecificAssetId>, limit?: number, cursor?: string, _options?: Configuration): Promise<GetAllAssetLinksResult> {
        const result = this.api.getAllShellIdsByAssetLinks(assetIds, limit, cursor, _options);
        return result.toPromise();
    }

    /**
     * Returns a list of specific Asset identifiers based on an Asset Administration Shell id to edit discoverable content
     * @param aasIdentifier The Asset Administration Shell’s unique id (UTF8-BASE64-URL-encoded)
     */
    public getAssetLinksByShellIdWithHttpInfo(aasIdentifier: string, _options?: Configuration): Promise<HttpInfo<Array<SpecificAssetId>>> {
        const result = this.api.getAssetLinksByShellIdWithHttpInfo(aasIdentifier, _options);
        return result.toPromise();
    }

    /**
     * Returns a list of specific Asset identifiers based on an Asset Administration Shell id to edit discoverable content
     * @param aasIdentifier The Asset Administration Shell’s unique id (UTF8-BASE64-URL-encoded)
     */
    public getAssetLinksByShellId(aasIdentifier: string, _options?: Configuration): Promise<Array<SpecificAssetId>> {
        const result = this.api.getAssetLinksByShellId(aasIdentifier, _options);
        return result.toPromise();
    }

    /**
     * Returns the self-describing information of a network resource (ServiceDescription)
     */
    public getDescriptionWithHttpInfo(_options?: Configuration): Promise<HttpInfo<ServiceDescription>> {
        const result = this.api.getDescriptionWithHttpInfo(_options);
        return result.toPromise();
    }

    /**
     * Returns the self-describing information of a network resource (ServiceDescription)
     */
    public getDescription(_options?: Configuration): Promise<ServiceDescription> {
        const result = this.api.getDescription(_options);
        return result.toPromise();
    }

    /**
     * Creates specific Asset identifiers linked to an Asset Administration Shell to edit discoverable content
     * @param aasIdentifier The Asset Administration Shell’s unique id (UTF8-BASE64-URL-encoded)
     * @param specificAssetId A list of specific Asset identifiers
     */
    public postAssetLinksByShellIdWithHttpInfo(aasIdentifier: string, specificAssetId: Array<SpecificAssetId>, _options?: Configuration): Promise<HttpInfo<Array<SpecificAssetId>>> {
        const result = this.api.postAssetLinksByShellIdWithHttpInfo(aasIdentifier, specificAssetId, _options);
        return result.toPromise();
    }

    /**
     * Creates specific Asset identifiers linked to an Asset Administration Shell to edit discoverable content
     * @param aasIdentifier The Asset Administration Shell’s unique id (UTF8-BASE64-URL-encoded)
     * @param specificAssetId A list of specific Asset identifiers
     */
    public postAssetLinksByShellId(aasIdentifier: string, specificAssetId: Array<SpecificAssetId>, _options?: Configuration): Promise<Array<SpecificAssetId>> {
        const result = this.api.postAssetLinksByShellId(aasIdentifier, specificAssetId, _options);
        return result.toPromise();
    }


}



