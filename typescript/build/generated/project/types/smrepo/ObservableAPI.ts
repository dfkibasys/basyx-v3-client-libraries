import { ResponseContext, RequestContext, HttpFile, HttpInfo } from '../../http/http';
import { Configuration} from '../../configuration'
import { Observable, of, from } from '../../rxjsStub';
import {mergeMap, map} from  '../../rxjsStub';
import { SubmodelElement } from '../../models/part1/SubmodelElement';
import { SubmodelElementValue } from '../../models/part2/SubmodelElementValue';
import { Submodel } from '../../models/part1/Submodel';
import { SubmodelElementMetadata } from '../../models/part2/SubmodelElementMetadata';
import { SubmodelValue } from '../../models/part2/SubmodelValue';
import { SubmodelMetadata } from '../../models/part2/SubmodelMetadata';
import { OperationResultValueOnly } from '../../models/part2/OperationResultValueOnly';
import { OperationRequestValueOnly } from '../../models/part2/OperationRequestValueOnly';
import { OperationRequest } from '../../models/part2/OperationRequest';
import { OperationResult } from '../../models/part2/OperationResult';
import { Reference } from '../../models/part1/Reference';
import { BaseOperationResult } from '../../models/part2/BaseOperationResult';
import { ServiceDescription } from '../../models/part2/ServiceDescription';
import { GetSubmodelsValueResult } from '../../models/part2/GetSubmodelsValueResult';
import { GetReferencesResult } from '../../models/part2/GetReferencesResult';
import { GetPathItemsResult } from '../../models/part2/GetPathItemsResult';
import { GetSubmodelsMetadataResult } from '../../models/part2/GetSubmodelsMetadataResult';
import { GetSubmodelsResult } from '../../models/part2/GetSubmodelsResult';
import { GetSubmodelElementsResult } from '../../models/part2/GetSubmodelElementsResult';
import { GetSubmodelElementsValueResult } from '../../models/part2/GetSubmodelElementsValueResult';
import { GetSubmodelElementsMetadataResult } from '../../models/part2/GetSubmodelElementsMetadataResult';


import { SubmodelRepositoryApiRequestFactory, SubmodelRepositoryApiResponseProcessor} from "../../apis/SubmodelRepositoryApi";
export class ObservableSubmodelRepositoryApi {
    private requestFactory: SubmodelRepositoryApiRequestFactory;
    private responseProcessor: SubmodelRepositoryApiResponseProcessor;
    private configuration: Configuration;

    public constructor(
        configuration: Configuration,
        requestFactory?: SubmodelRepositoryApiRequestFactory,
        responseProcessor?: SubmodelRepositoryApiResponseProcessor
    ) {
        this.configuration = configuration;
        this.requestFactory = requestFactory || new SubmodelRepositoryApiRequestFactory(configuration);
        this.responseProcessor = responseProcessor || new SubmodelRepositoryApiResponseProcessor();
    }

    /**
     * Deletes file content of an existing submodel element at a specified path within submodel elements hierarchy
     * @param submodelIdentifier The Submodel’s unique id (UTF8-BASE64-URL-encoded)
     * @param idShortPath IdShort path to the submodel element (dot-separated)
     */
    public deleteFileAttachmentWithHttpInfo(submodelIdentifier: string, idShortPath: string, _options?: Configuration): Observable<HttpInfo<void>> {
        const requestContextPromise = this.requestFactory.deleteFileAttachment(submodelIdentifier, idShortPath, _options);

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
                return middlewarePostObservable.pipe(map((rsp: ResponseContext) => this.responseProcessor.deleteFileAttachmentWithHttpInfo(rsp)));
            }));
    }

    /**
     * Deletes file content of an existing submodel element at a specified path within submodel elements hierarchy
     * @param submodelIdentifier The Submodel’s unique id (UTF8-BASE64-URL-encoded)
     * @param idShortPath IdShort path to the submodel element (dot-separated)
     */
    public deleteFileAttachment(submodelIdentifier: string, idShortPath: string, _options?: Configuration): Observable<void> {
        return this.deleteFileAttachmentWithHttpInfo(submodelIdentifier, idShortPath, _options).pipe(map((apiResponse: HttpInfo<void>) => apiResponse.data));
    }

    /**
     * Deletes a Submodel
     * @param submodelIdentifier The Submodel’s unique id (UTF8-BASE64-URL-encoded)
     */
    public deleteSubmodelWithHttpInfo(submodelIdentifier: string, _options?: Configuration): Observable<HttpInfo<void>> {
        const requestContextPromise = this.requestFactory.deleteSubmodel(submodelIdentifier, _options);

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
                return middlewarePostObservable.pipe(map((rsp: ResponseContext) => this.responseProcessor.deleteSubmodelWithHttpInfo(rsp)));
            }));
    }

    /**
     * Deletes a Submodel
     * @param submodelIdentifier The Submodel’s unique id (UTF8-BASE64-URL-encoded)
     */
    public deleteSubmodel(submodelIdentifier: string, _options?: Configuration): Observable<void> {
        return this.deleteSubmodelWithHttpInfo(submodelIdentifier, _options).pipe(map((apiResponse: HttpInfo<void>) => apiResponse.data));
    }

    /**
     * Deletes a submodel element at a specified path within the submodel elements hierarchy
     * @param submodelIdentifier The Submodel’s unique id (UTF8-BASE64-URL-encoded)
     * @param idShortPath IdShort path to the submodel element (dot-separated)
     */
    public deleteSubmodelElementWithHttpInfo(submodelIdentifier: string, idShortPath: string, _options?: Configuration): Observable<HttpInfo<void>> {
        const requestContextPromise = this.requestFactory.deleteSubmodelElement(submodelIdentifier, idShortPath, _options);

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
                return middlewarePostObservable.pipe(map((rsp: ResponseContext) => this.responseProcessor.deleteSubmodelElementWithHttpInfo(rsp)));
            }));
    }

    /**
     * Deletes a submodel element at a specified path within the submodel elements hierarchy
     * @param submodelIdentifier The Submodel’s unique id (UTF8-BASE64-URL-encoded)
     * @param idShortPath IdShort path to the submodel element (dot-separated)
     */
    public deleteSubmodelElement(submodelIdentifier: string, idShortPath: string, _options?: Configuration): Observable<void> {
        return this.deleteSubmodelElementWithHttpInfo(submodelIdentifier, idShortPath, _options).pipe(map((apiResponse: HttpInfo<void>) => apiResponse.data));
    }

    /**
     * Returns all submodel elements including their hierarchy
     * @param submodelIdentifier The Submodel’s unique id (UTF8-BASE64-URL-encoded)
     * @param limit The maximum number of elements in the response array
     * @param cursor A server-generated identifier retrieved from pagingMetadata that specifies from which position the result listing should continue
     * @param level Determines the structural depth of the respective resource content
     * @param extent Determines to which extent the resource is being serialized
     */
    public getAllSubmodelElementsWithHttpInfo(submodelIdentifier: string, limit?: number, cursor?: string, level?: 'deep' | 'core', extent?: 'withBlobValue' | 'withoutBlobValue', _options?: Configuration): Observable<HttpInfo<GetSubmodelElementsResult>> {
        const requestContextPromise = this.requestFactory.getAllSubmodelElements(submodelIdentifier, limit, cursor, level, extent, _options);

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
                return middlewarePostObservable.pipe(map((rsp: ResponseContext) => this.responseProcessor.getAllSubmodelElementsWithHttpInfo(rsp)));
            }));
    }

    /**
     * Returns all submodel elements including their hierarchy
     * @param submodelIdentifier The Submodel’s unique id (UTF8-BASE64-URL-encoded)
     * @param limit The maximum number of elements in the response array
     * @param cursor A server-generated identifier retrieved from pagingMetadata that specifies from which position the result listing should continue
     * @param level Determines the structural depth of the respective resource content
     * @param extent Determines to which extent the resource is being serialized
     */
    public getAllSubmodelElements(submodelIdentifier: string, limit?: number, cursor?: string, level?: 'deep' | 'core', extent?: 'withBlobValue' | 'withoutBlobValue', _options?: Configuration): Observable<GetSubmodelElementsResult> {
        return this.getAllSubmodelElementsWithHttpInfo(submodelIdentifier, limit, cursor, level, extent, _options).pipe(map((apiResponse: HttpInfo<GetSubmodelElementsResult>) => apiResponse.data));
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
    public getAllSubmodelsWithHttpInfo(semanticId?: string, idShort?: string, limit?: number, cursor?: string, level?: 'deep' | 'core', extent?: 'withBlobValue' | 'withoutBlobValue', _options?: Configuration): Observable<HttpInfo<GetSubmodelsResult>> {
        const requestContextPromise = this.requestFactory.getAllSubmodels(semanticId, idShort, limit, cursor, level, extent, _options);

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
                return middlewarePostObservable.pipe(map((rsp: ResponseContext) => this.responseProcessor.getAllSubmodelsWithHttpInfo(rsp)));
            }));
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
    public getAllSubmodels(semanticId?: string, idShort?: string, limit?: number, cursor?: string, level?: 'deep' | 'core', extent?: 'withBlobValue' | 'withoutBlobValue', _options?: Configuration): Observable<GetSubmodelsResult> {
        return this.getAllSubmodelsWithHttpInfo(semanticId, idShort, limit, cursor, level, extent, _options).pipe(map((apiResponse: HttpInfo<GetSubmodelsResult>) => apiResponse.data));
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
     * Downloads file content from a specific submodel element from the Submodel at a specified path
     * @param submodelIdentifier The Submodel’s unique id (UTF8-BASE64-URL-encoded)
     * @param idShortPath IdShort path to the submodel element (dot-separated)
     */
    public getFileAttachmentWithHttpInfo(submodelIdentifier: string, idShortPath: string, _options?: Configuration): Observable<HttpInfo<HttpFile>> {
        const requestContextPromise = this.requestFactory.getFileAttachment(submodelIdentifier, idShortPath, _options);

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
                return middlewarePostObservable.pipe(map((rsp: ResponseContext) => this.responseProcessor.getFileAttachmentWithHttpInfo(rsp)));
            }));
    }

    /**
     * Downloads file content from a specific submodel element from the Submodel at a specified path
     * @param submodelIdentifier The Submodel’s unique id (UTF8-BASE64-URL-encoded)
     * @param idShortPath IdShort path to the submodel element (dot-separated)
     */
    public getFileAttachment(submodelIdentifier: string, idShortPath: string, _options?: Configuration): Observable<HttpFile> {
        return this.getFileAttachmentWithHttpInfo(submodelIdentifier, idShortPath, _options).pipe(map((apiResponse: HttpInfo<HttpFile>) => apiResponse.data));
    }

    /**
     * Returns a specific Submodel
     * @param submodelIdentifier The Submodel’s unique id (UTF8-BASE64-URL-encoded)
     * @param level Determines the structural depth of the respective resource content
     * @param extent Determines to which extent the resource is being serialized
     */
    public getSubmodelWithHttpInfo(submodelIdentifier: string, level?: 'deep' | 'core', extent?: 'withBlobValue' | 'withoutBlobValue', _options?: Configuration): Observable<HttpInfo<Submodel>> {
        const requestContextPromise = this.requestFactory.getSubmodel(submodelIdentifier, level, extent, _options);

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
                return middlewarePostObservable.pipe(map((rsp: ResponseContext) => this.responseProcessor.getSubmodelWithHttpInfo(rsp)));
            }));
    }

    /**
     * Returns a specific Submodel
     * @param submodelIdentifier The Submodel’s unique id (UTF8-BASE64-URL-encoded)
     * @param level Determines the structural depth of the respective resource content
     * @param extent Determines to which extent the resource is being serialized
     */
    public getSubmodel(submodelIdentifier: string, level?: 'deep' | 'core', extent?: 'withBlobValue' | 'withoutBlobValue', _options?: Configuration): Observable<Submodel> {
        return this.getSubmodelWithHttpInfo(submodelIdentifier, level, extent, _options).pipe(map((apiResponse: HttpInfo<Submodel>) => apiResponse.data));
    }

    /**
     * Returns a specific submodel element from the Submodel at a specified path
     * @param submodelIdentifier The Submodel’s unique id (UTF8-BASE64-URL-encoded)
     * @param idShortPath IdShort path to the submodel element (dot-separated)
     * @param level Determines the structural depth of the respective resource content
     * @param extent Determines to which extent the resource is being serialized
     */
    public getSubmodelElementWithHttpInfo(submodelIdentifier: string, idShortPath: string, level?: 'deep' | 'core', extent?: 'withBlobValue' | 'withoutBlobValue', _options?: Configuration): Observable<HttpInfo<SubmodelElement>> {
        const requestContextPromise = this.requestFactory.getSubmodelElement(submodelIdentifier, idShortPath, level, extent, _options);

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
                return middlewarePostObservable.pipe(map((rsp: ResponseContext) => this.responseProcessor.getSubmodelElementWithHttpInfo(rsp)));
            }));
    }

    /**
     * Returns a specific submodel element from the Submodel at a specified path
     * @param submodelIdentifier The Submodel’s unique id (UTF8-BASE64-URL-encoded)
     * @param idShortPath IdShort path to the submodel element (dot-separated)
     * @param level Determines the structural depth of the respective resource content
     * @param extent Determines to which extent the resource is being serialized
     */
    public getSubmodelElement(submodelIdentifier: string, idShortPath: string, level?: 'deep' | 'core', extent?: 'withBlobValue' | 'withoutBlobValue', _options?: Configuration): Observable<SubmodelElement> {
        return this.getSubmodelElementWithHttpInfo(submodelIdentifier, idShortPath, level, extent, _options).pipe(map((apiResponse: HttpInfo<SubmodelElement>) => apiResponse.data));
    }

    /**
     * Returns a specific submodel element from the Submodel at a specified path in the ValueOnly representation
     * @param submodelIdentifier The Submodel’s unique id (UTF8-BASE64-URL-encoded)
     * @param idShortPath IdShort path to the submodel element (dot-separated)
     * @param level Determines the structural depth of the respective resource content
     * @param extent Determines to which extent the resource is being serialized
     */
    public getSubmodelElementValueWithHttpInfo(submodelIdentifier: string, idShortPath: string, level?: 'deep' | 'core', extent?: 'withBlobValue' | 'withoutBlobValue', _options?: Configuration): Observable<HttpInfo<SubmodelElementValue>> {
        const requestContextPromise = this.requestFactory.getSubmodelElementValue(submodelIdentifier, idShortPath, level, extent, _options);

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
                return middlewarePostObservable.pipe(map((rsp: ResponseContext) => this.responseProcessor.getSubmodelElementValueWithHttpInfo(rsp)));
            }));
    }

    /**
     * Returns a specific submodel element from the Submodel at a specified path in the ValueOnly representation
     * @param submodelIdentifier The Submodel’s unique id (UTF8-BASE64-URL-encoded)
     * @param idShortPath IdShort path to the submodel element (dot-separated)
     * @param level Determines the structural depth of the respective resource content
     * @param extent Determines to which extent the resource is being serialized
     */
    public getSubmodelElementValue(submodelIdentifier: string, idShortPath: string, level?: 'deep' | 'core', extent?: 'withBlobValue' | 'withoutBlobValue', _options?: Configuration): Observable<SubmodelElementValue> {
        return this.getSubmodelElementValueWithHttpInfo(submodelIdentifier, idShortPath, level, extent, _options).pipe(map((apiResponse: HttpInfo<SubmodelElementValue>) => apiResponse.data));
    }

    /**
     * Returns the metadata attributes of a specific Submodel
     * @param submodelIdentifier The Submodel’s unique id (UTF8-BASE64-URL-encoded)
     * @param level Determines the structural depth of the respective resource content
     */
    public getSubmodelMetadataWithHttpInfo(submodelIdentifier: string, level?: 'deep' | 'core', _options?: Configuration): Observable<HttpInfo<SubmodelMetadata>> {
        const requestContextPromise = this.requestFactory.getSubmodelMetadata(submodelIdentifier, level, _options);

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
                return middlewarePostObservable.pipe(map((rsp: ResponseContext) => this.responseProcessor.getSubmodelMetadataWithHttpInfo(rsp)));
            }));
    }

    /**
     * Returns the metadata attributes of a specific Submodel
     * @param submodelIdentifier The Submodel’s unique id (UTF8-BASE64-URL-encoded)
     * @param level Determines the structural depth of the respective resource content
     */
    public getSubmodelMetadata(submodelIdentifier: string, level?: 'deep' | 'core', _options?: Configuration): Observable<SubmodelMetadata> {
        return this.getSubmodelMetadataWithHttpInfo(submodelIdentifier, level, _options).pipe(map((apiResponse: HttpInfo<SubmodelMetadata>) => apiResponse.data));
    }

    /**
     * Synchronously or asynchronously invokes an Operation at a specified path
     * @param submodelIdentifier The Submodel’s unique id (UTF8-BASE64-URL-encoded)
     * @param idShortPath IdShort path to the submodel element (dot-separated)
     * @param operationRequest Operation request object
     * @param async Determines whether an operation invocation is performed asynchronously or synchronously
     */
    public invokeOperationWithHttpInfo(submodelIdentifier: string, idShortPath: string, operationRequest: OperationRequest, async?: boolean, _options?: Configuration): Observable<HttpInfo<OperationResult>> {
        const requestContextPromise = this.requestFactory.invokeOperation(submodelIdentifier, idShortPath, operationRequest, async, _options);

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
                return middlewarePostObservable.pipe(map((rsp: ResponseContext) => this.responseProcessor.invokeOperationWithHttpInfo(rsp)));
            }));
    }

    /**
     * Synchronously or asynchronously invokes an Operation at a specified path
     * @param submodelIdentifier The Submodel’s unique id (UTF8-BASE64-URL-encoded)
     * @param idShortPath IdShort path to the submodel element (dot-separated)
     * @param operationRequest Operation request object
     * @param async Determines whether an operation invocation is performed asynchronously or synchronously
     */
    public invokeOperation(submodelIdentifier: string, idShortPath: string, operationRequest: OperationRequest, async?: boolean, _options?: Configuration): Observable<OperationResult> {
        return this.invokeOperationWithHttpInfo(submodelIdentifier, idShortPath, operationRequest, async, _options).pipe(map((apiResponse: HttpInfo<OperationResult>) => apiResponse.data));
    }

    /**
     * Updates the value of an existing SubmodelElement
     * @param submodelIdentifier The Submodel’s unique id (UTF8-BASE64-URL-encoded)
     * @param idShortPath IdShort path to the submodel element (dot-separated)
     * @param submodelElementValue The SubmodelElement in its ValueOnly representation
     * @param level Determines the structural depth of the respective resource content
     */
    public patchSubmodelElementValueWithHttpInfo(submodelIdentifier: string, idShortPath: string, submodelElementValue: SubmodelElementValue, level?: 'core', _options?: Configuration): Observable<HttpInfo<void>> {
        const requestContextPromise = this.requestFactory.patchSubmodelElementValue(submodelIdentifier, idShortPath, submodelElementValue, level, _options);

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
                return middlewarePostObservable.pipe(map((rsp: ResponseContext) => this.responseProcessor.patchSubmodelElementValueWithHttpInfo(rsp)));
            }));
    }

    /**
     * Updates the value of an existing SubmodelElement
     * @param submodelIdentifier The Submodel’s unique id (UTF8-BASE64-URL-encoded)
     * @param idShortPath IdShort path to the submodel element (dot-separated)
     * @param submodelElementValue The SubmodelElement in its ValueOnly representation
     * @param level Determines the structural depth of the respective resource content
     */
    public patchSubmodelElementValue(submodelIdentifier: string, idShortPath: string, submodelElementValue: SubmodelElementValue, level?: 'core', _options?: Configuration): Observable<void> {
        return this.patchSubmodelElementValueWithHttpInfo(submodelIdentifier, idShortPath, submodelElementValue, level, _options).pipe(map((apiResponse: HttpInfo<void>) => apiResponse.data));
    }

    /**
     * Creates a new Submodel
     * @param submodel Submodel object
     */
    public postSubmodelWithHttpInfo(submodel: Submodel, _options?: Configuration): Observable<HttpInfo<Submodel>> {
        const requestContextPromise = this.requestFactory.postSubmodel(submodel, _options);

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
                return middlewarePostObservable.pipe(map((rsp: ResponseContext) => this.responseProcessor.postSubmodelWithHttpInfo(rsp)));
            }));
    }

    /**
     * Creates a new Submodel
     * @param submodel Submodel object
     */
    public postSubmodel(submodel: Submodel, _options?: Configuration): Observable<Submodel> {
        return this.postSubmodelWithHttpInfo(submodel, _options).pipe(map((apiResponse: HttpInfo<Submodel>) => apiResponse.data));
    }

    /**
     * Creates a new submodel element
     * @param submodelIdentifier The Submodel’s unique id (UTF8-BASE64-URL-encoded)
     * @param submodelElement Requested submodel element
     */
    public postSubmodelElementWithHttpInfo(submodelIdentifier: string, submodelElement: SubmodelElement, _options?: Configuration): Observable<HttpInfo<SubmodelElement>> {
        const requestContextPromise = this.requestFactory.postSubmodelElement(submodelIdentifier, submodelElement, _options);

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
                return middlewarePostObservable.pipe(map((rsp: ResponseContext) => this.responseProcessor.postSubmodelElementWithHttpInfo(rsp)));
            }));
    }

    /**
     * Creates a new submodel element
     * @param submodelIdentifier The Submodel’s unique id (UTF8-BASE64-URL-encoded)
     * @param submodelElement Requested submodel element
     */
    public postSubmodelElement(submodelIdentifier: string, submodelElement: SubmodelElement, _options?: Configuration): Observable<SubmodelElement> {
        return this.postSubmodelElementWithHttpInfo(submodelIdentifier, submodelElement, _options).pipe(map((apiResponse: HttpInfo<SubmodelElement>) => apiResponse.data));
    }

    /**
     * Creates a new submodel element at a specified path within submodel elements hierarchy
     * @param submodelIdentifier The Submodel’s unique id (UTF8-BASE64-URL-encoded)
     * @param idShortPath IdShort path to the submodel element (dot-separated)
     * @param submodelElement Requested submodel element
     */
    public postSubmodelElementUnderPathWithHttpInfo(submodelIdentifier: string, idShortPath: string, submodelElement: SubmodelElement, _options?: Configuration): Observable<HttpInfo<SubmodelElement>> {
        const requestContextPromise = this.requestFactory.postSubmodelElementUnderPath(submodelIdentifier, idShortPath, submodelElement, _options);

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
                return middlewarePostObservable.pipe(map((rsp: ResponseContext) => this.responseProcessor.postSubmodelElementUnderPathWithHttpInfo(rsp)));
            }));
    }

    /**
     * Creates a new submodel element at a specified path within submodel elements hierarchy
     * @param submodelIdentifier The Submodel’s unique id (UTF8-BASE64-URL-encoded)
     * @param idShortPath IdShort path to the submodel element (dot-separated)
     * @param submodelElement Requested submodel element
     */
    public postSubmodelElementUnderPath(submodelIdentifier: string, idShortPath: string, submodelElement: SubmodelElement, _options?: Configuration): Observable<SubmodelElement> {
        return this.postSubmodelElementUnderPathWithHttpInfo(submodelIdentifier, idShortPath, submodelElement, _options).pipe(map((apiResponse: HttpInfo<SubmodelElement>) => apiResponse.data));
    }

    /**
     * Uploads file content to an existing submodel element at a specified path within submodel elements hierarchy
     * @param submodelIdentifier The Submodel’s unique id (UTF8-BASE64-URL-encoded)
     * @param idShortPath IdShort path to the submodel element (dot-separated)
     * @param fileName 
     * @param file 
     */
    public putFileAttachmentWithHttpInfo(submodelIdentifier: string, idShortPath: string, fileName?: string, file?: HttpFile, _options?: Configuration): Observable<HttpInfo<void>> {
        const requestContextPromise = this.requestFactory.putFileAttachment(submodelIdentifier, idShortPath, fileName, file, _options);

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
                return middlewarePostObservable.pipe(map((rsp: ResponseContext) => this.responseProcessor.putFileAttachmentWithHttpInfo(rsp)));
            }));
    }

    /**
     * Uploads file content to an existing submodel element at a specified path within submodel elements hierarchy
     * @param submodelIdentifier The Submodel’s unique id (UTF8-BASE64-URL-encoded)
     * @param idShortPath IdShort path to the submodel element (dot-separated)
     * @param fileName 
     * @param file 
     */
    public putFileAttachment(submodelIdentifier: string, idShortPath: string, fileName?: string, file?: HttpFile, _options?: Configuration): Observable<void> {
        return this.putFileAttachmentWithHttpInfo(submodelIdentifier, idShortPath, fileName, file, _options).pipe(map((apiResponse: HttpInfo<void>) => apiResponse.data));
    }

    /**
     * Updates an existing Submodel
     * @param submodelIdentifier The Submodel’s unique id (UTF8-BASE64-URL-encoded)
     * @param submodel Submodel object
     */
    public putSubmodelWithHttpInfo(submodelIdentifier: string, submodel: Submodel, _options?: Configuration): Observable<HttpInfo<void>> {
        const requestContextPromise = this.requestFactory.putSubmodel(submodelIdentifier, submodel, _options);

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
                return middlewarePostObservable.pipe(map((rsp: ResponseContext) => this.responseProcessor.putSubmodelWithHttpInfo(rsp)));
            }));
    }

    /**
     * Updates an existing Submodel
     * @param submodelIdentifier The Submodel’s unique id (UTF8-BASE64-URL-encoded)
     * @param submodel Submodel object
     */
    public putSubmodel(submodelIdentifier: string, submodel: Submodel, _options?: Configuration): Observable<void> {
        return this.putSubmodelWithHttpInfo(submodelIdentifier, submodel, _options).pipe(map((apiResponse: HttpInfo<void>) => apiResponse.data));
    }

    /**
     * Updates an existing submodel element at a specified path within submodel elements hierarchy
     * @param submodelIdentifier The Submodel’s unique id (UTF8-BASE64-URL-encoded)
     * @param idShortPath IdShort path to the submodel element (dot-separated)
     * @param submodelElement Requested submodel element
     * @param level Determines the structural depth of the respective resource content
     */
    public putSubmodelElementWithHttpInfo(submodelIdentifier: string, idShortPath: string, submodelElement: SubmodelElement, level?: 'deep', _options?: Configuration): Observable<HttpInfo<void>> {
        const requestContextPromise = this.requestFactory.putSubmodelElement(submodelIdentifier, idShortPath, submodelElement, level, _options);

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
                return middlewarePostObservable.pipe(map((rsp: ResponseContext) => this.responseProcessor.putSubmodelElementWithHttpInfo(rsp)));
            }));
    }

    /**
     * Updates an existing submodel element at a specified path within submodel elements hierarchy
     * @param submodelIdentifier The Submodel’s unique id (UTF8-BASE64-URL-encoded)
     * @param idShortPath IdShort path to the submodel element (dot-separated)
     * @param submodelElement Requested submodel element
     * @param level Determines the structural depth of the respective resource content
     */
    public putSubmodelElement(submodelIdentifier: string, idShortPath: string, submodelElement: SubmodelElement, level?: 'deep', _options?: Configuration): Observable<void> {
        return this.putSubmodelElementWithHttpInfo(submodelIdentifier, idShortPath, submodelElement, level, _options).pipe(map((apiResponse: HttpInfo<void>) => apiResponse.data));
    }

}
