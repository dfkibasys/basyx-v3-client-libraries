import { ResponseContext, RequestContext, HttpFile, HttpInfo } from '../../http/http';
import { Configuration} from '../../configuration'


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

import { ObservableSubmodelRepositoryApi } from './ObservableAPI';

import { SubmodelRepositoryApiRequestFactory, SubmodelRepositoryApiResponseProcessor} from "../../apis/SubmodelRepositoryApi";

export class PromiseSubmodelRepositoryApi {
    private api: ObservableSubmodelRepositoryApi

    public constructor(
        configuration: Configuration,
        requestFactory?: SubmodelRepositoryApiRequestFactory,
        responseProcessor?: SubmodelRepositoryApiResponseProcessor
    ) {
        this.api = new ObservableSubmodelRepositoryApi(configuration, requestFactory, responseProcessor);
    }

    /**
     * Deletes file content of an existing submodel element at a specified path within submodel elements hierarchy
     * @param submodelIdentifier The Submodel’s unique id (UTF8-BASE64-URL-encoded)
     * @param idShortPath IdShort path to the submodel element (dot-separated)
     */
    public deleteFileAttachmentWithHttpInfo(submodelIdentifier: string, idShortPath: string, _options?: Configuration): Promise<HttpInfo<void>> {
        const result = this.api.deleteFileAttachmentWithHttpInfo(submodelIdentifier, idShortPath, _options);
        return result.toPromise();
    }

    /**
     * Deletes file content of an existing submodel element at a specified path within submodel elements hierarchy
     * @param submodelIdentifier The Submodel’s unique id (UTF8-BASE64-URL-encoded)
     * @param idShortPath IdShort path to the submodel element (dot-separated)
     */
    public deleteFileAttachment(submodelIdentifier: string, idShortPath: string, _options?: Configuration): Promise<void> {
        const result = this.api.deleteFileAttachment(submodelIdentifier, idShortPath, _options);
        return result.toPromise();
    }

    /**
     * Deletes a Submodel
     * @param submodelIdentifier The Submodel’s unique id (UTF8-BASE64-URL-encoded)
     */
    public deleteSubmodelWithHttpInfo(submodelIdentifier: string, _options?: Configuration): Promise<HttpInfo<void>> {
        const result = this.api.deleteSubmodelWithHttpInfo(submodelIdentifier, _options);
        return result.toPromise();
    }

    /**
     * Deletes a Submodel
     * @param submodelIdentifier The Submodel’s unique id (UTF8-BASE64-URL-encoded)
     */
    public deleteSubmodel(submodelIdentifier: string, _options?: Configuration): Promise<void> {
        const result = this.api.deleteSubmodel(submodelIdentifier, _options);
        return result.toPromise();
    }

    /**
     * Deletes a submodel element at a specified path within the submodel elements hierarchy
     * @param submodelIdentifier The Submodel’s unique id (UTF8-BASE64-URL-encoded)
     * @param idShortPath IdShort path to the submodel element (dot-separated)
     */
    public deleteSubmodelElementWithHttpInfo(submodelIdentifier: string, idShortPath: string, _options?: Configuration): Promise<HttpInfo<void>> {
        const result = this.api.deleteSubmodelElementWithHttpInfo(submodelIdentifier, idShortPath, _options);
        return result.toPromise();
    }

    /**
     * Deletes a submodel element at a specified path within the submodel elements hierarchy
     * @param submodelIdentifier The Submodel’s unique id (UTF8-BASE64-URL-encoded)
     * @param idShortPath IdShort path to the submodel element (dot-separated)
     */
    public deleteSubmodelElement(submodelIdentifier: string, idShortPath: string, _options?: Configuration): Promise<void> {
        const result = this.api.deleteSubmodelElement(submodelIdentifier, idShortPath, _options);
        return result.toPromise();
    }

    /**
     * Returns all submodel elements including their hierarchy
     * @param submodelIdentifier The Submodel’s unique id (UTF8-BASE64-URL-encoded)
     * @param limit The maximum number of elements in the response array
     * @param cursor A server-generated identifier retrieved from pagingMetadata that specifies from which position the result listing should continue
     * @param level Determines the structural depth of the respective resource content
     * @param extent Determines to which extent the resource is being serialized
     */
    public getAllSubmodelElementsWithHttpInfo(submodelIdentifier: string, limit?: number, cursor?: string, level?: 'deep' | 'core', extent?: 'withBlobValue' | 'withoutBlobValue', _options?: Configuration): Promise<HttpInfo<GetSubmodelElementsResult>> {
        const result = this.api.getAllSubmodelElementsWithHttpInfo(submodelIdentifier, limit, cursor, level, extent, _options);
        return result.toPromise();
    }

    /**
     * Returns all submodel elements including their hierarchy
     * @param submodelIdentifier The Submodel’s unique id (UTF8-BASE64-URL-encoded)
     * @param limit The maximum number of elements in the response array
     * @param cursor A server-generated identifier retrieved from pagingMetadata that specifies from which position the result listing should continue
     * @param level Determines the structural depth of the respective resource content
     * @param extent Determines to which extent the resource is being serialized
     */
    public getAllSubmodelElements(submodelIdentifier: string, limit?: number, cursor?: string, level?: 'deep' | 'core', extent?: 'withBlobValue' | 'withoutBlobValue', _options?: Configuration): Promise<GetSubmodelElementsResult> {
        const result = this.api.getAllSubmodelElements(submodelIdentifier, limit, cursor, level, extent, _options);
        return result.toPromise();
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
    public getAllSubmodelsWithHttpInfo(semanticId?: string, idShort?: string, limit?: number, cursor?: string, level?: 'deep' | 'core', extent?: 'withBlobValue' | 'withoutBlobValue', _options?: Configuration): Promise<HttpInfo<GetSubmodelsResult>> {
        const result = this.api.getAllSubmodelsWithHttpInfo(semanticId, idShort, limit, cursor, level, extent, _options);
        return result.toPromise();
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
    public getAllSubmodels(semanticId?: string, idShort?: string, limit?: number, cursor?: string, level?: 'deep' | 'core', extent?: 'withBlobValue' | 'withoutBlobValue', _options?: Configuration): Promise<GetSubmodelsResult> {
        const result = this.api.getAllSubmodels(semanticId, idShort, limit, cursor, level, extent, _options);
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
     * Downloads file content from a specific submodel element from the Submodel at a specified path
     * @param submodelIdentifier The Submodel’s unique id (UTF8-BASE64-URL-encoded)
     * @param idShortPath IdShort path to the submodel element (dot-separated)
     */
    public getFileAttachmentWithHttpInfo(submodelIdentifier: string, idShortPath: string, _options?: Configuration): Promise<HttpInfo<HttpFile>> {
        const result = this.api.getFileAttachmentWithHttpInfo(submodelIdentifier, idShortPath, _options);
        return result.toPromise();
    }

    /**
     * Downloads file content from a specific submodel element from the Submodel at a specified path
     * @param submodelIdentifier The Submodel’s unique id (UTF8-BASE64-URL-encoded)
     * @param idShortPath IdShort path to the submodel element (dot-separated)
     */
    public getFileAttachment(submodelIdentifier: string, idShortPath: string, _options?: Configuration): Promise<HttpFile> {
        const result = this.api.getFileAttachment(submodelIdentifier, idShortPath, _options);
        return result.toPromise();
    }

    /**
     * Returns a specific Submodel
     * @param submodelIdentifier The Submodel’s unique id (UTF8-BASE64-URL-encoded)
     * @param level Determines the structural depth of the respective resource content
     * @param extent Determines to which extent the resource is being serialized
     */
    public getSubmodelWithHttpInfo(submodelIdentifier: string, level?: 'deep' | 'core', extent?: 'withBlobValue' | 'withoutBlobValue', _options?: Configuration): Promise<HttpInfo<Submodel>> {
        const result = this.api.getSubmodelWithHttpInfo(submodelIdentifier, level, extent, _options);
        return result.toPromise();
    }

    /**
     * Returns a specific Submodel
     * @param submodelIdentifier The Submodel’s unique id (UTF8-BASE64-URL-encoded)
     * @param level Determines the structural depth of the respective resource content
     * @param extent Determines to which extent the resource is being serialized
     */
    public getSubmodel(submodelIdentifier: string, level?: 'deep' | 'core', extent?: 'withBlobValue' | 'withoutBlobValue', _options?: Configuration): Promise<Submodel> {
        const result = this.api.getSubmodel(submodelIdentifier, level, extent, _options);
        return result.toPromise();
    }

    /**
     * Returns a specific submodel element from the Submodel at a specified path
     * @param submodelIdentifier The Submodel’s unique id (UTF8-BASE64-URL-encoded)
     * @param idShortPath IdShort path to the submodel element (dot-separated)
     * @param level Determines the structural depth of the respective resource content
     * @param extent Determines to which extent the resource is being serialized
     */
    public getSubmodelElementWithHttpInfo(submodelIdentifier: string, idShortPath: string, level?: 'deep' | 'core', extent?: 'withBlobValue' | 'withoutBlobValue', _options?: Configuration): Promise<HttpInfo<SubmodelElement>> {
        const result = this.api.getSubmodelElementWithHttpInfo(submodelIdentifier, idShortPath, level, extent, _options);
        return result.toPromise();
    }

    /**
     * Returns a specific submodel element from the Submodel at a specified path
     * @param submodelIdentifier The Submodel’s unique id (UTF8-BASE64-URL-encoded)
     * @param idShortPath IdShort path to the submodel element (dot-separated)
     * @param level Determines the structural depth of the respective resource content
     * @param extent Determines to which extent the resource is being serialized
     */
    public getSubmodelElement(submodelIdentifier: string, idShortPath: string, level?: 'deep' | 'core', extent?: 'withBlobValue' | 'withoutBlobValue', _options?: Configuration): Promise<SubmodelElement> {
        const result = this.api.getSubmodelElement(submodelIdentifier, idShortPath, level, extent, _options);
        return result.toPromise();
    }

    /**
     * Returns a specific submodel element from the Submodel at a specified path in the ValueOnly representation
     * @param submodelIdentifier The Submodel’s unique id (UTF8-BASE64-URL-encoded)
     * @param idShortPath IdShort path to the submodel element (dot-separated)
     * @param level Determines the structural depth of the respective resource content
     * @param extent Determines to which extent the resource is being serialized
     */
    public getSubmodelElementValueWithHttpInfo(submodelIdentifier: string, idShortPath: string, level?: 'deep' | 'core', extent?: 'withBlobValue' | 'withoutBlobValue', _options?: Configuration): Promise<HttpInfo<SubmodelElementValue>> {
        const result = this.api.getSubmodelElementValueWithHttpInfo(submodelIdentifier, idShortPath, level, extent, _options);
        return result.toPromise();
    }

    /**
     * Returns a specific submodel element from the Submodel at a specified path in the ValueOnly representation
     * @param submodelIdentifier The Submodel’s unique id (UTF8-BASE64-URL-encoded)
     * @param idShortPath IdShort path to the submodel element (dot-separated)
     * @param level Determines the structural depth of the respective resource content
     * @param extent Determines to which extent the resource is being serialized
     */
    public getSubmodelElementValue(submodelIdentifier: string, idShortPath: string, level?: 'deep' | 'core', extent?: 'withBlobValue' | 'withoutBlobValue', _options?: Configuration): Promise<SubmodelElementValue> {
        const result = this.api.getSubmodelElementValue(submodelIdentifier, idShortPath, level, extent, _options);
        return result.toPromise();
    }

    /**
     * Returns the metadata attributes of a specific Submodel
     * @param submodelIdentifier The Submodel’s unique id (UTF8-BASE64-URL-encoded)
     * @param level Determines the structural depth of the respective resource content
     */
    public getSubmodelMetadataWithHttpInfo(submodelIdentifier: string, level?: 'deep' | 'core', _options?: Configuration): Promise<HttpInfo<SubmodelMetadata>> {
        const result = this.api.getSubmodelMetadataWithHttpInfo(submodelIdentifier, level, _options);
        return result.toPromise();
    }

    /**
     * Returns the metadata attributes of a specific Submodel
     * @param submodelIdentifier The Submodel’s unique id (UTF8-BASE64-URL-encoded)
     * @param level Determines the structural depth of the respective resource content
     */
    public getSubmodelMetadata(submodelIdentifier: string, level?: 'deep' | 'core', _options?: Configuration): Promise<SubmodelMetadata> {
        const result = this.api.getSubmodelMetadata(submodelIdentifier, level, _options);
        return result.toPromise();
    }

    /**
     * Synchronously or asynchronously invokes an Operation at a specified path
     * @param submodelIdentifier The Submodel’s unique id (UTF8-BASE64-URL-encoded)
     * @param idShortPath IdShort path to the submodel element (dot-separated)
     * @param operationRequest Operation request object
     * @param async Determines whether an operation invocation is performed asynchronously or synchronously
     */
    public invokeOperationWithHttpInfo(submodelIdentifier: string, idShortPath: string, operationRequest: OperationRequest, async?: boolean, _options?: Configuration): Promise<HttpInfo<OperationResult>> {
        const result = this.api.invokeOperationWithHttpInfo(submodelIdentifier, idShortPath, operationRequest, async, _options);
        return result.toPromise();
    }

    /**
     * Synchronously or asynchronously invokes an Operation at a specified path
     * @param submodelIdentifier The Submodel’s unique id (UTF8-BASE64-URL-encoded)
     * @param idShortPath IdShort path to the submodel element (dot-separated)
     * @param operationRequest Operation request object
     * @param async Determines whether an operation invocation is performed asynchronously or synchronously
     */
    public invokeOperation(submodelIdentifier: string, idShortPath: string, operationRequest: OperationRequest, async?: boolean, _options?: Configuration): Promise<OperationResult> {
        const result = this.api.invokeOperation(submodelIdentifier, idShortPath, operationRequest, async, _options);
        return result.toPromise();
    }

    /**
     * Updates the value of an existing SubmodelElement
     * @param submodelIdentifier The Submodel’s unique id (UTF8-BASE64-URL-encoded)
     * @param idShortPath IdShort path to the submodel element (dot-separated)
     * @param submodelElementValue The SubmodelElement in its ValueOnly representation
     * @param level Determines the structural depth of the respective resource content
     */
    public patchSubmodelElementValueWithHttpInfo(submodelIdentifier: string, idShortPath: string, submodelElementValue: SubmodelElementValue, level?: 'core', _options?: Configuration): Promise<HttpInfo<void>> {
        const result = this.api.patchSubmodelElementValueWithHttpInfo(submodelIdentifier, idShortPath, submodelElementValue, level, _options);
        return result.toPromise();
    }

    /**
     * Updates the value of an existing SubmodelElement
     * @param submodelIdentifier The Submodel’s unique id (UTF8-BASE64-URL-encoded)
     * @param idShortPath IdShort path to the submodel element (dot-separated)
     * @param submodelElementValue The SubmodelElement in its ValueOnly representation
     * @param level Determines the structural depth of the respective resource content
     */
    public patchSubmodelElementValue(submodelIdentifier: string, idShortPath: string, submodelElementValue: SubmodelElementValue, level?: 'core', _options?: Configuration): Promise<void> {
        const result = this.api.patchSubmodelElementValue(submodelIdentifier, idShortPath, submodelElementValue, level, _options);
        return result.toPromise();
    }

    /**
     * Creates a new Submodel
     * @param submodel Submodel object
     */
    public postSubmodelWithHttpInfo(submodel: Submodel, _options?: Configuration): Promise<HttpInfo<Submodel>> {
        const result = this.api.postSubmodelWithHttpInfo(submodel, _options);
        return result.toPromise();
    }

    /**
     * Creates a new Submodel
     * @param submodel Submodel object
     */
    public postSubmodel(submodel: Submodel, _options?: Configuration): Promise<Submodel> {
        const result = this.api.postSubmodel(submodel, _options);
        return result.toPromise();
    }

    /**
     * Creates a new submodel element
     * @param submodelIdentifier The Submodel’s unique id (UTF8-BASE64-URL-encoded)
     * @param submodelElement Requested submodel element
     */
    public postSubmodelElementWithHttpInfo(submodelIdentifier: string, submodelElement: SubmodelElement, _options?: Configuration): Promise<HttpInfo<SubmodelElement>> {
        const result = this.api.postSubmodelElementWithHttpInfo(submodelIdentifier, submodelElement, _options);
        return result.toPromise();
    }

    /**
     * Creates a new submodel element
     * @param submodelIdentifier The Submodel’s unique id (UTF8-BASE64-URL-encoded)
     * @param submodelElement Requested submodel element
     */
    public postSubmodelElement(submodelIdentifier: string, submodelElement: SubmodelElement, _options?: Configuration): Promise<SubmodelElement> {
        const result = this.api.postSubmodelElement(submodelIdentifier, submodelElement, _options);
        return result.toPromise();
    }

    /**
     * Creates a new submodel element at a specified path within submodel elements hierarchy
     * @param submodelIdentifier The Submodel’s unique id (UTF8-BASE64-URL-encoded)
     * @param idShortPath IdShort path to the submodel element (dot-separated)
     * @param submodelElement Requested submodel element
     */
    public postSubmodelElementUnderPathWithHttpInfo(submodelIdentifier: string, idShortPath: string, submodelElement: SubmodelElement, _options?: Configuration): Promise<HttpInfo<SubmodelElement>> {
        const result = this.api.postSubmodelElementUnderPathWithHttpInfo(submodelIdentifier, idShortPath, submodelElement, _options);
        return result.toPromise();
    }

    /**
     * Creates a new submodel element at a specified path within submodel elements hierarchy
     * @param submodelIdentifier The Submodel’s unique id (UTF8-BASE64-URL-encoded)
     * @param idShortPath IdShort path to the submodel element (dot-separated)
     * @param submodelElement Requested submodel element
     */
    public postSubmodelElementUnderPath(submodelIdentifier: string, idShortPath: string, submodelElement: SubmodelElement, _options?: Configuration): Promise<SubmodelElement> {
        const result = this.api.postSubmodelElementUnderPath(submodelIdentifier, idShortPath, submodelElement, _options);
        return result.toPromise();
    }

    /**
     * Uploads file content to an existing submodel element at a specified path within submodel elements hierarchy
     * @param submodelIdentifier The Submodel’s unique id (UTF8-BASE64-URL-encoded)
     * @param idShortPath IdShort path to the submodel element (dot-separated)
     * @param fileName 
     * @param file 
     */
    public putFileAttachmentWithHttpInfo(submodelIdentifier: string, idShortPath: string, fileName?: string, file?: HttpFile, _options?: Configuration): Promise<HttpInfo<void>> {
        const result = this.api.putFileAttachmentWithHttpInfo(submodelIdentifier, idShortPath, fileName, file, _options);
        return result.toPromise();
    }

    /**
     * Uploads file content to an existing submodel element at a specified path within submodel elements hierarchy
     * @param submodelIdentifier The Submodel’s unique id (UTF8-BASE64-URL-encoded)
     * @param idShortPath IdShort path to the submodel element (dot-separated)
     * @param fileName 
     * @param file 
     */
    public putFileAttachment(submodelIdentifier: string, idShortPath: string, fileName?: string, file?: HttpFile, _options?: Configuration): Promise<void> {
        const result = this.api.putFileAttachment(submodelIdentifier, idShortPath, fileName, file, _options);
        return result.toPromise();
    }

    /**
     * Updates an existing Submodel
     * @param submodelIdentifier The Submodel’s unique id (UTF8-BASE64-URL-encoded)
     * @param submodel Submodel object
     */
    public putSubmodelWithHttpInfo(submodelIdentifier: string, submodel: Submodel, _options?: Configuration): Promise<HttpInfo<void>> {
        const result = this.api.putSubmodelWithHttpInfo(submodelIdentifier, submodel, _options);
        return result.toPromise();
    }

    /**
     * Updates an existing Submodel
     * @param submodelIdentifier The Submodel’s unique id (UTF8-BASE64-URL-encoded)
     * @param submodel Submodel object
     */
    public putSubmodel(submodelIdentifier: string, submodel: Submodel, _options?: Configuration): Promise<void> {
        const result = this.api.putSubmodel(submodelIdentifier, submodel, _options);
        return result.toPromise();
    }

    /**
     * Updates an existing submodel element at a specified path within submodel elements hierarchy
     * @param submodelIdentifier The Submodel’s unique id (UTF8-BASE64-URL-encoded)
     * @param idShortPath IdShort path to the submodel element (dot-separated)
     * @param submodelElement Requested submodel element
     * @param level Determines the structural depth of the respective resource content
     */
    public putSubmodelElementWithHttpInfo(submodelIdentifier: string, idShortPath: string, submodelElement: SubmodelElement, level?: 'deep', _options?: Configuration): Promise<HttpInfo<void>> {
        const result = this.api.putSubmodelElementWithHttpInfo(submodelIdentifier, idShortPath, submodelElement, level, _options);
        return result.toPromise();
    }

    /**
     * Updates an existing submodel element at a specified path within submodel elements hierarchy
     * @param submodelIdentifier The Submodel’s unique id (UTF8-BASE64-URL-encoded)
     * @param idShortPath IdShort path to the submodel element (dot-separated)
     * @param submodelElement Requested submodel element
     * @param level Determines the structural depth of the respective resource content
     */
    public putSubmodelElement(submodelIdentifier: string, idShortPath: string, submodelElement: SubmodelElement, level?: 'deep', _options?: Configuration): Promise<void> {
        const result = this.api.putSubmodelElement(submodelIdentifier, idShortPath, submodelElement, level, _options);
        return result.toPromise();
    }


}



