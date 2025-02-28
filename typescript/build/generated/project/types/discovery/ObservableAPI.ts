import { ResponseContext, RequestContext, HttpFile, HttpInfo } from '../../http/http';
import { Configuration} from '../../configuration'
import { Observable, of, from } from '../../rxjsStub';
import {mergeMap, map} from  '../../rxjsStub';
import { SpecificAssetId } from '../../models/part1/SpecificAssetId';
import { ServiceDescription } from '../../models/part2/ServiceDescription';


import { AssetAdministrationShellBasicDiscoveryApiRequestFactory, AssetAdministrationShellBasicDiscoveryApiResponseProcessor} from "../../apis/AssetAdministrationShellBasicDiscoveryApi";
export class ObservableAssetAdministrationShellBasicDiscoveryApi {
    private requestFactory: AssetAdministrationShellBasicDiscoveryApiRequestFactory;
    private responseProcessor: AssetAdministrationShellBasicDiscoveryApiResponseProcessor;
    private configuration: Configuration;

    public constructor(
        configuration: Configuration,
        requestFactory?: AssetAdministrationShellBasicDiscoveryApiRequestFactory,
        responseProcessor?: AssetAdministrationShellBasicDiscoveryApiResponseProcessor
    ) {
        this.configuration = configuration;
        this.requestFactory = requestFactory || new AssetAdministrationShellBasicDiscoveryApiRequestFactory(configuration);
        this.responseProcessor = responseProcessor || new AssetAdministrationShellBasicDiscoveryApiResponseProcessor();
    }

    /**
     * Deletes all specific Asset identifiers linked to an Asset Administration Shell to edit discoverable content
     * @param aasIdentifier The Asset Administration Shell’s unique id (UTF8-BASE64-URL-encoded)
     */
    public deleteAssetLinksByShellIdWithHttpInfo(aasIdentifier: string, _options?: Configuration): Observable<HttpInfo<void>> {
        const requestContextPromise = this.requestFactory.deleteAssetLinksByShellId(aasIdentifier, _options);

        // build promise chain
        let middlewarePreObservable = from<RequestContext>(requestContextPromise);
        for (let middleware of this.configuration.middleware) {
            middlewarePreObservable = middlewarePreObservable.pipe(mergeMap((ctx: RequestContext) => middleware.pre(ctx)));
        }

        return middlewarePreObservable.pipe(mergeMap((ctx: RequestContext) => this.configuration.httpApi.send(ctx))).
            pipe(mergeMap((response: ResponseContext) => {
                let middlewarePostObservable = of(response);
                for (let middleware of this.configuration.middleware) {
                    middlewarePostObservable = middlewarePostObservable.pipe(mergeMap((rsp: ResponseContext) => middleware.post(rsp)));
                }
                return middlewarePostObservable.pipe(map((rsp: ResponseContext) => this.responseProcessor.deleteAssetLinksByShellIdWithHttpInfo(rsp)));
            }));
    }

    /**
     * Deletes all specific Asset identifiers linked to an Asset Administration Shell to edit discoverable content
     * @param aasIdentifier The Asset Administration Shell’s unique id (UTF8-BASE64-URL-encoded)
     */
    public deleteAssetLinksByShellId(aasIdentifier: string, _options?: Configuration): Observable<void> {
        return this.deleteAssetLinksByShellIdWithHttpInfo(aasIdentifier, _options).pipe(map((apiResponse: HttpInfo<void>) => apiResponse.data));
    }

    /**
     * Returns a list of Asset Administration Shell ids linked to specific Asset identifiers
     * @param assetIds A list of specific Asset identifiers. Each Asset identifier is a base64-url-encoded [SpecificAssetId](./model-part1.yaml#/components/schemas/SpecificAssetId)
     * @param limit The maximum number of elements in the response array
     * @param cursor A server-generated identifier retrieved from pagingMetadata that specifies from which position the result listing should continue
     */
    public getAllShellIdsByAssetLinksWithHttpInfo(assetIds?: Array<SpecificAssetId>, limit?: number, cursor?: string, _options?: Configuration): Observable<HttpInfo<GetAllAssetLinksResult>> {
        const requestContextPromise = this.requestFactory.getAllShellIdsByAssetLinks(assetIds, limit, cursor, _options);

        // build promise chain
        let middlewarePreObservable = from<RequestContext>(requestContextPromise);
        for (let middleware of this.configuration.middleware) {
            middlewarePreObservable = middlewarePreObservable.pipe(mergeMap((ctx: RequestContext) => middleware.pre(ctx)));
        }

        return middlewarePreObservable.pipe(mergeMap((ctx: RequestContext) => this.configuration.httpApi.send(ctx))).
            pipe(mergeMap((response: ResponseContext) => {
                let middlewarePostObservable = of(response);
                for (let middleware of this.configuration.middleware) {
                    middlewarePostObservable = middlewarePostObservable.pipe(mergeMap((rsp: ResponseContext) => middleware.post(rsp)));
                }
                return middlewarePostObservable.pipe(map((rsp: ResponseContext) => this.responseProcessor.getAllShellIdsByAssetLinksWithHttpInfo(rsp)));
            }));
    }

    /**
     * Returns a list of Asset Administration Shell ids linked to specific Asset identifiers
     * @param assetIds A list of specific Asset identifiers. Each Asset identifier is a base64-url-encoded [SpecificAssetId](./model-part1.yaml#/components/schemas/SpecificAssetId)
     * @param limit The maximum number of elements in the response array
     * @param cursor A server-generated identifier retrieved from pagingMetadata that specifies from which position the result listing should continue
     */
    public getAllShellIdsByAssetLinks(assetIds?: Array<SpecificAssetId>, limit?: number, cursor?: string, _options?: Configuration): Observable<GetAllAssetLinksResult> {
        return this.getAllShellIdsByAssetLinksWithHttpInfo(assetIds, limit, cursor, _options).pipe(map((apiResponse: HttpInfo<GetAllAssetLinksResult>) => apiResponse.data));
    }

    /**
     * Returns a list of specific Asset identifiers based on an Asset Administration Shell id to edit discoverable content
     * @param aasIdentifier The Asset Administration Shell’s unique id (UTF8-BASE64-URL-encoded)
     */
    public getAssetLinksByShellIdWithHttpInfo(aasIdentifier: string, _options?: Configuration): Observable<HttpInfo<Array<SpecificAssetId>>> {
        const requestContextPromise = this.requestFactory.getAssetLinksByShellId(aasIdentifier, _options);

        // build promise chain
        let middlewarePreObservable = from<RequestContext>(requestContextPromise);
        for (let middleware of this.configuration.middleware) {
            middlewarePreObservable = middlewarePreObservable.pipe(mergeMap((ctx: RequestContext) => middleware.pre(ctx)));
        }

        return middlewarePreObservable.pipe(mergeMap((ctx: RequestContext) => this.configuration.httpApi.send(ctx))).
            pipe(mergeMap((response: ResponseContext) => {
                let middlewarePostObservable = of(response);
                for (let middleware of this.configuration.middleware) {
                    middlewarePostObservable = middlewarePostObservable.pipe(mergeMap((rsp: ResponseContext) => middleware.post(rsp)));
                }
                return middlewarePostObservable.pipe(map((rsp: ResponseContext) => this.responseProcessor.getAssetLinksByShellIdWithHttpInfo(rsp)));
            }));
    }

    /**
     * Returns a list of specific Asset identifiers based on an Asset Administration Shell id to edit discoverable content
     * @param aasIdentifier The Asset Administration Shell’s unique id (UTF8-BASE64-URL-encoded)
     */
    public getAssetLinksByShellId(aasIdentifier: string, _options?: Configuration): Observable<Array<SpecificAssetId>> {
        return this.getAssetLinksByShellIdWithHttpInfo(aasIdentifier, _options).pipe(map((apiResponse: HttpInfo<Array<SpecificAssetId>>) => apiResponse.data));
    }

    /**
     * Returns the self-describing information of a network resource (ServiceDescription)
     */
    public getDescriptionWithHttpInfo(_options?: Configuration): Observable<HttpInfo<ServiceDescription>> {
        const requestContextPromise = this.requestFactory.getDescription(_options);

        // build promise chain
        let middlewarePreObservable = from<RequestContext>(requestContextPromise);
        for (let middleware of this.configuration.middleware) {
            middlewarePreObservable = middlewarePreObservable.pipe(mergeMap((ctx: RequestContext) => middleware.pre(ctx)));
        }

        return middlewarePreObservable.pipe(mergeMap((ctx: RequestContext) => this.configuration.httpApi.send(ctx))).
            pipe(mergeMap((response: ResponseContext) => {
                let middlewarePostObservable = of(response);
                for (let middleware of this.configuration.middleware) {
                    middlewarePostObservable = middlewarePostObservable.pipe(mergeMap((rsp: ResponseContext) => middleware.post(rsp)));
                }
                return middlewarePostObservable.pipe(map((rsp: ResponseContext) => this.responseProcessor.getDescriptionWithHttpInfo(rsp)));
            }));
    }

    /**
     * Returns the self-describing information of a network resource (ServiceDescription)
     */
    public getDescription(_options?: Configuration): Observable<ServiceDescription> {
        return this.getDescriptionWithHttpInfo(_options).pipe(map((apiResponse: HttpInfo<ServiceDescription>) => apiResponse.data));
    }

    /**
     * Creates specific Asset identifiers linked to an Asset Administration Shell to edit discoverable content
     * @param aasIdentifier The Asset Administration Shell’s unique id (UTF8-BASE64-URL-encoded)
     * @param specificAssetId A list of specific Asset identifiers
     */
    public postAssetLinksByShellIdWithHttpInfo(aasIdentifier: string, specificAssetId: Array<SpecificAssetId>, _options?: Configuration): Observable<HttpInfo<Array<SpecificAssetId>>> {
        const requestContextPromise = this.requestFactory.postAssetLinksByShellId(aasIdentifier, specificAssetId, _options);

        // build promise chain
        let middlewarePreObservable = from<RequestContext>(requestContextPromise);
        for (let middleware of this.configuration.middleware) {
            middlewarePreObservable = middlewarePreObservable.pipe(mergeMap((ctx: RequestContext) => middleware.pre(ctx)));
        }

        return middlewarePreObservable.pipe(mergeMap((ctx: RequestContext) => this.configuration.httpApi.send(ctx))).
            pipe(mergeMap((response: ResponseContext) => {
                let middlewarePostObservable = of(response);
                for (let middleware of this.configuration.middleware) {
                    middlewarePostObservable = middlewarePostObservable.pipe(mergeMap((rsp: ResponseContext) => middleware.post(rsp)));
                }
                return middlewarePostObservable.pipe(map((rsp: ResponseContext) => this.responseProcessor.postAssetLinksByShellIdWithHttpInfo(rsp)));
            }));
    }

    /**
     * Creates specific Asset identifiers linked to an Asset Administration Shell to edit discoverable content
     * @param aasIdentifier The Asset Administration Shell’s unique id (UTF8-BASE64-URL-encoded)
     * @param specificAssetId A list of specific Asset identifiers
     */
    public postAssetLinksByShellId(aasIdentifier: string, specificAssetId: Array<SpecificAssetId>, _options?: Configuration): Observable<Array<SpecificAssetId>> {
        return this.postAssetLinksByShellIdWithHttpInfo(aasIdentifier, specificAssetId, _options).pipe(map((apiResponse: HttpInfo<Array<SpecificAssetId>>) => apiResponse.data));
    }

}
