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


import { ObservableSubmodelRepositoryApi } from "./ObservableAPI";
import { SubmodelRepositoryApiRequestFactory, SubmodelRepositoryApiResponseProcessor} from "../../apis/SubmodelRepositoryApi";

export interface SubmodelRepositoryApiDeleteFileAttachmentRequest {
    /**
     * The Submodel’s unique id (UTF8-BASE64-URL-encoded)
     * @type string
     * @memberof SubmodelRepositoryApideleteFileAttachment
     */
    submodelIdentifier: string
    /**
     * IdShort path to the submodel element (dot-separated)
     * @type string
     * @memberof SubmodelRepositoryApideleteFileAttachment
     */
    idShortPath: string
}

export interface SubmodelRepositoryApiDeleteSubmodelRequest {
    /**
     * The Submodel’s unique id (UTF8-BASE64-URL-encoded)
     * @type string
     * @memberof SubmodelRepositoryApideleteSubmodel
     */
    submodelIdentifier: string
}

export interface SubmodelRepositoryApiDeleteSubmodelElementRequest {
    /**
     * The Submodel’s unique id (UTF8-BASE64-URL-encoded)
     * @type string
     * @memberof SubmodelRepositoryApideleteSubmodelElement
     */
    submodelIdentifier: string
    /**
     * IdShort path to the submodel element (dot-separated)
     * @type string
     * @memberof SubmodelRepositoryApideleteSubmodelElement
     */
    idShortPath: string
}

export interface SubmodelRepositoryApiGetAllSubmodelElementsRequest {
    /**
     * The Submodel’s unique id (UTF8-BASE64-URL-encoded)
     * @type string
     * @memberof SubmodelRepositoryApigetAllSubmodelElements
     */
    submodelIdentifier: string
    /**
     * The maximum number of elements in the response array
     * @type number
     * @memberof SubmodelRepositoryApigetAllSubmodelElements
     */
    limit?: number
    /**
     * A server-generated identifier retrieved from pagingMetadata that specifies from which position the result listing should continue
     * @type string
     * @memberof SubmodelRepositoryApigetAllSubmodelElements
     */
    cursor?: string
    /**
     * Determines the structural depth of the respective resource content
     * @type &#39;deep&#39; | &#39;core&#39;
     * @memberof SubmodelRepositoryApigetAllSubmodelElements
     */
    level?: 'deep' | 'core'
    /**
     * Determines to which extent the resource is being serialized
     * @type &#39;withBlobValue&#39; | &#39;withoutBlobValue&#39;
     * @memberof SubmodelRepositoryApigetAllSubmodelElements
     */
    extent?: 'withBlobValue' | 'withoutBlobValue'
}

export interface SubmodelRepositoryApiGetAllSubmodelsRequest {
    /**
     * The value of the semantic id reference (BASE64-URL-encoded)
     * @type string
     * @memberof SubmodelRepositoryApigetAllSubmodels
     */
    semanticId?: string
    /**
     * The Asset Administration Shell\&#39;s IdShort
     * @type string
     * @memberof SubmodelRepositoryApigetAllSubmodels
     */
    idShort?: string
    /**
     * The maximum number of elements in the response array
     * @type number
     * @memberof SubmodelRepositoryApigetAllSubmodels
     */
    limit?: number
    /**
     * A server-generated identifier retrieved from pagingMetadata that specifies from which position the result listing should continue
     * @type string
     * @memberof SubmodelRepositoryApigetAllSubmodels
     */
    cursor?: string
    /**
     * Determines the structural depth of the respective resource content
     * @type &#39;deep&#39; | &#39;core&#39;
     * @memberof SubmodelRepositoryApigetAllSubmodels
     */
    level?: 'deep' | 'core'
    /**
     * Determines to which extent the resource is being serialized
     * @type &#39;withBlobValue&#39; | &#39;withoutBlobValue&#39;
     * @memberof SubmodelRepositoryApigetAllSubmodels
     */
    extent?: 'withBlobValue' | 'withoutBlobValue'
}

export interface SubmodelRepositoryApiGetDescriptionRequest {
}

export interface SubmodelRepositoryApiGetFileAttachmentRequest {
    /**
     * The Submodel’s unique id (UTF8-BASE64-URL-encoded)
     * @type string
     * @memberof SubmodelRepositoryApigetFileAttachment
     */
    submodelIdentifier: string
    /**
     * IdShort path to the submodel element (dot-separated)
     * @type string
     * @memberof SubmodelRepositoryApigetFileAttachment
     */
    idShortPath: string
}

export interface SubmodelRepositoryApiGetSubmodelRequest {
    /**
     * The Submodel’s unique id (UTF8-BASE64-URL-encoded)
     * @type string
     * @memberof SubmodelRepositoryApigetSubmodel
     */
    submodelIdentifier: string
    /**
     * Determines the structural depth of the respective resource content
     * @type &#39;deep&#39; | &#39;core&#39;
     * @memberof SubmodelRepositoryApigetSubmodel
     */
    level?: 'deep' | 'core'
    /**
     * Determines to which extent the resource is being serialized
     * @type &#39;withBlobValue&#39; | &#39;withoutBlobValue&#39;
     * @memberof SubmodelRepositoryApigetSubmodel
     */
    extent?: 'withBlobValue' | 'withoutBlobValue'
}

export interface SubmodelRepositoryApiGetSubmodelElementRequest {
    /**
     * The Submodel’s unique id (UTF8-BASE64-URL-encoded)
     * @type string
     * @memberof SubmodelRepositoryApigetSubmodelElement
     */
    submodelIdentifier: string
    /**
     * IdShort path to the submodel element (dot-separated)
     * @type string
     * @memberof SubmodelRepositoryApigetSubmodelElement
     */
    idShortPath: string
    /**
     * Determines the structural depth of the respective resource content
     * @type &#39;deep&#39; | &#39;core&#39;
     * @memberof SubmodelRepositoryApigetSubmodelElement
     */
    level?: 'deep' | 'core'
    /**
     * Determines to which extent the resource is being serialized
     * @type &#39;withBlobValue&#39; | &#39;withoutBlobValue&#39;
     * @memberof SubmodelRepositoryApigetSubmodelElement
     */
    extent?: 'withBlobValue' | 'withoutBlobValue'
}

export interface SubmodelRepositoryApiGetSubmodelElementValueRequest {
    /**
     * The Submodel’s unique id (UTF8-BASE64-URL-encoded)
     * @type string
     * @memberof SubmodelRepositoryApigetSubmodelElementValue
     */
    submodelIdentifier: string
    /**
     * IdShort path to the submodel element (dot-separated)
     * @type string
     * @memberof SubmodelRepositoryApigetSubmodelElementValue
     */
    idShortPath: string
    /**
     * Determines the structural depth of the respective resource content
     * @type &#39;deep&#39; | &#39;core&#39;
     * @memberof SubmodelRepositoryApigetSubmodelElementValue
     */
    level?: 'deep' | 'core'
    /**
     * Determines to which extent the resource is being serialized
     * @type &#39;withBlobValue&#39; | &#39;withoutBlobValue&#39;
     * @memberof SubmodelRepositoryApigetSubmodelElementValue
     */
    extent?: 'withBlobValue' | 'withoutBlobValue'
}

export interface SubmodelRepositoryApiGetSubmodelMetadataRequest {
    /**
     * The Submodel’s unique id (UTF8-BASE64-URL-encoded)
     * @type string
     * @memberof SubmodelRepositoryApigetSubmodelMetadata
     */
    submodelIdentifier: string
    /**
     * Determines the structural depth of the respective resource content
     * @type &#39;deep&#39; | &#39;core&#39;
     * @memberof SubmodelRepositoryApigetSubmodelMetadata
     */
    level?: 'deep' | 'core'
}

export interface SubmodelRepositoryApiInvokeOperationRequest {
    /**
     * The Submodel’s unique id (UTF8-BASE64-URL-encoded)
     * @type string
     * @memberof SubmodelRepositoryApiinvokeOperation
     */
    submodelIdentifier: string
    /**
     * IdShort path to the submodel element (dot-separated)
     * @type string
     * @memberof SubmodelRepositoryApiinvokeOperation
     */
    idShortPath: string
    /**
     * Operation request object
     * @type OperationRequest
     * @memberof SubmodelRepositoryApiinvokeOperation
     */
    operationRequest: OperationRequest
    /**
     * Determines whether an operation invocation is performed asynchronously or synchronously
     * @type boolean
     * @memberof SubmodelRepositoryApiinvokeOperation
     */
    async?: boolean
}

export interface SubmodelRepositoryApiPatchSubmodelElementValueRequest {
    /**
     * The Submodel’s unique id (UTF8-BASE64-URL-encoded)
     * @type string
     * @memberof SubmodelRepositoryApipatchSubmodelElementValue
     */
    submodelIdentifier: string
    /**
     * IdShort path to the submodel element (dot-separated)
     * @type string
     * @memberof SubmodelRepositoryApipatchSubmodelElementValue
     */
    idShortPath: string
    /**
     * The SubmodelElement in its ValueOnly representation
     * @type SubmodelElementValue
     * @memberof SubmodelRepositoryApipatchSubmodelElementValue
     */
    submodelElementValue: SubmodelElementValue
    /**
     * Determines the structural depth of the respective resource content
     * @type &#39;core&#39;
     * @memberof SubmodelRepositoryApipatchSubmodelElementValue
     */
    level?: 'core'
}

export interface SubmodelRepositoryApiPostSubmodelRequest {
    /**
     * Submodel object
     * @type Submodel
     * @memberof SubmodelRepositoryApipostSubmodel
     */
    submodel: Submodel
}

export interface SubmodelRepositoryApiPostSubmodelElementRequest {
    /**
     * The Submodel’s unique id (UTF8-BASE64-URL-encoded)
     * @type string
     * @memberof SubmodelRepositoryApipostSubmodelElement
     */
    submodelIdentifier: string
    /**
     * Requested submodel element
     * @type SubmodelElement
     * @memberof SubmodelRepositoryApipostSubmodelElement
     */
    submodelElement: SubmodelElement
}

export interface SubmodelRepositoryApiPostSubmodelElementUnderPathRequest {
    /**
     * The Submodel’s unique id (UTF8-BASE64-URL-encoded)
     * @type string
     * @memberof SubmodelRepositoryApipostSubmodelElementUnderPath
     */
    submodelIdentifier: string
    /**
     * IdShort path to the submodel element (dot-separated)
     * @type string
     * @memberof SubmodelRepositoryApipostSubmodelElementUnderPath
     */
    idShortPath: string
    /**
     * Requested submodel element
     * @type SubmodelElement
     * @memberof SubmodelRepositoryApipostSubmodelElementUnderPath
     */
    submodelElement: SubmodelElement
}

export interface SubmodelRepositoryApiPutFileAttachmentRequest {
    /**
     * The Submodel’s unique id (UTF8-BASE64-URL-encoded)
     * @type string
     * @memberof SubmodelRepositoryApiputFileAttachment
     */
    submodelIdentifier: string
    /**
     * IdShort path to the submodel element (dot-separated)
     * @type string
     * @memberof SubmodelRepositoryApiputFileAttachment
     */
    idShortPath: string
    /**
     * 
     * @type string
     * @memberof SubmodelRepositoryApiputFileAttachment
     */
    fileName?: string
    /**
     * 
     * @type HttpFile
     * @memberof SubmodelRepositoryApiputFileAttachment
     */
    file?: HttpFile
}

export interface SubmodelRepositoryApiPutSubmodelRequest {
    /**
     * The Submodel’s unique id (UTF8-BASE64-URL-encoded)
     * @type string
     * @memberof SubmodelRepositoryApiputSubmodel
     */
    submodelIdentifier: string
    /**
     * Submodel object
     * @type Submodel
     * @memberof SubmodelRepositoryApiputSubmodel
     */
    submodel: Submodel
}

export interface SubmodelRepositoryApiPutSubmodelElementRequest {
    /**
     * The Submodel’s unique id (UTF8-BASE64-URL-encoded)
     * @type string
     * @memberof SubmodelRepositoryApiputSubmodelElement
     */
    submodelIdentifier: string
    /**
     * IdShort path to the submodel element (dot-separated)
     * @type string
     * @memberof SubmodelRepositoryApiputSubmodelElement
     */
    idShortPath: string
    /**
     * Requested submodel element
     * @type SubmodelElement
     * @memberof SubmodelRepositoryApiputSubmodelElement
     */
    submodelElement: SubmodelElement
    /**
     * Determines the structural depth of the respective resource content
     * @type &#39;deep&#39;
     * @memberof SubmodelRepositoryApiputSubmodelElement
     */
    level?: 'deep'
}

export class ObjectSubmodelRepositoryApi {
    private api: ObservableSubmodelRepositoryApi

    public constructor(configuration: Configuration, requestFactory?: SubmodelRepositoryApiRequestFactory, responseProcessor?: SubmodelRepositoryApiResponseProcessor) {
        this.api = new ObservableSubmodelRepositoryApi(configuration, requestFactory, responseProcessor);
    }

    /**
     * Deletes file content of an existing submodel element at a specified path within submodel elements hierarchy
     * @param param the request object
     */
    public deleteFileAttachmentWithHttpInfo(param: SubmodelRepositoryApiDeleteFileAttachmentRequest, options?: Configuration): Promise<HttpInfo<void>> {
        return this.api.deleteFileAttachmentWithHttpInfo(param.submodelIdentifier, param.idShortPath,  options).toPromise();
    }

    /**
     * Deletes file content of an existing submodel element at a specified path within submodel elements hierarchy
     * @param param the request object
     */
    public deleteFileAttachment(param: SubmodelRepositoryApiDeleteFileAttachmentRequest, options?: Configuration): Promise<void> {
        return this.api.deleteFileAttachment(param.submodelIdentifier, param.idShortPath,  options).toPromise();
    }

    /**
     * Deletes a Submodel
     * @param param the request object
     */
    public deleteSubmodelWithHttpInfo(param: SubmodelRepositoryApiDeleteSubmodelRequest, options?: Configuration): Promise<HttpInfo<void>> {
        return this.api.deleteSubmodelWithHttpInfo(param.submodelIdentifier,  options).toPromise();
    }

    /**
     * Deletes a Submodel
     * @param param the request object
     */
    public deleteSubmodel(param: SubmodelRepositoryApiDeleteSubmodelRequest, options?: Configuration): Promise<void> {
        return this.api.deleteSubmodel(param.submodelIdentifier,  options).toPromise();
    }

    /**
     * Deletes a submodel element at a specified path within the submodel elements hierarchy
     * @param param the request object
     */
    public deleteSubmodelElementWithHttpInfo(param: SubmodelRepositoryApiDeleteSubmodelElementRequest, options?: Configuration): Promise<HttpInfo<void>> {
        return this.api.deleteSubmodelElementWithHttpInfo(param.submodelIdentifier, param.idShortPath,  options).toPromise();
    }

    /**
     * Deletes a submodel element at a specified path within the submodel elements hierarchy
     * @param param the request object
     */
    public deleteSubmodelElement(param: SubmodelRepositoryApiDeleteSubmodelElementRequest, options?: Configuration): Promise<void> {
        return this.api.deleteSubmodelElement(param.submodelIdentifier, param.idShortPath,  options).toPromise();
    }

    /**
     * Returns all submodel elements including their hierarchy
     * @param param the request object
     */
    public getAllSubmodelElementsWithHttpInfo(param: SubmodelRepositoryApiGetAllSubmodelElementsRequest, options?: Configuration): Promise<HttpInfo<GetSubmodelElementsResult>> {
        return this.api.getAllSubmodelElementsWithHttpInfo(param.submodelIdentifier, param.limit, param.cursor, param.level, param.extent,  options).toPromise();
    }

    /**
     * Returns all submodel elements including their hierarchy
     * @param param the request object
     */
    public getAllSubmodelElements(param: SubmodelRepositoryApiGetAllSubmodelElementsRequest, options?: Configuration): Promise<GetSubmodelElementsResult> {
        return this.api.getAllSubmodelElements(param.submodelIdentifier, param.limit, param.cursor, param.level, param.extent,  options).toPromise();
    }

    /**
     * Returns all Submodels
     * @param param the request object
     */
    public getAllSubmodelsWithHttpInfo(param: SubmodelRepositoryApiGetAllSubmodelsRequest = {}, options?: Configuration): Promise<HttpInfo<GetSubmodelsResult>> {
        return this.api.getAllSubmodelsWithHttpInfo(param.semanticId, param.idShort, param.limit, param.cursor, param.level, param.extent,  options).toPromise();
    }

    /**
     * Returns all Submodels
     * @param param the request object
     */
    public getAllSubmodels(param: SubmodelRepositoryApiGetAllSubmodelsRequest = {}, options?: Configuration): Promise<GetSubmodelsResult> {
        return this.api.getAllSubmodels(param.semanticId, param.idShort, param.limit, param.cursor, param.level, param.extent,  options).toPromise();
    }

    /**
     * Returns the self-describing information of a network resource (ServiceDescription)
     * @param param the request object
     */
    public getDescriptionWithHttpInfo(param: SubmodelRepositoryApiGetDescriptionRequest = {}, options?: Configuration): Promise<HttpInfo<ServiceDescription>> {
        return this.api.getDescriptionWithHttpInfo( options).toPromise();
    }

    /**
     * Returns the self-describing information of a network resource (ServiceDescription)
     * @param param the request object
     */
    public getDescription(param: SubmodelRepositoryApiGetDescriptionRequest = {}, options?: Configuration): Promise<ServiceDescription> {
        return this.api.getDescription( options).toPromise();
    }

    /**
     * Downloads file content from a specific submodel element from the Submodel at a specified path
     * @param param the request object
     */
    public getFileAttachmentWithHttpInfo(param: SubmodelRepositoryApiGetFileAttachmentRequest, options?: Configuration): Promise<HttpInfo<HttpFile>> {
        return this.api.getFileAttachmentWithHttpInfo(param.submodelIdentifier, param.idShortPath,  options).toPromise();
    }

    /**
     * Downloads file content from a specific submodel element from the Submodel at a specified path
     * @param param the request object
     */
    public getFileAttachment(param: SubmodelRepositoryApiGetFileAttachmentRequest, options?: Configuration): Promise<HttpFile> {
        return this.api.getFileAttachment(param.submodelIdentifier, param.idShortPath,  options).toPromise();
    }

    /**
     * Returns a specific Submodel
     * @param param the request object
     */
    public getSubmodelWithHttpInfo(param: SubmodelRepositoryApiGetSubmodelRequest, options?: Configuration): Promise<HttpInfo<Submodel>> {
        return this.api.getSubmodelWithHttpInfo(param.submodelIdentifier, param.level, param.extent,  options).toPromise();
    }

    /**
     * Returns a specific Submodel
     * @param param the request object
     */
    public getSubmodel(param: SubmodelRepositoryApiGetSubmodelRequest, options?: Configuration): Promise<Submodel> {
        return this.api.getSubmodel(param.submodelIdentifier, param.level, param.extent,  options).toPromise();
    }

    /**
     * Returns a specific submodel element from the Submodel at a specified path
     * @param param the request object
     */
    public getSubmodelElementWithHttpInfo(param: SubmodelRepositoryApiGetSubmodelElementRequest, options?: Configuration): Promise<HttpInfo<SubmodelElement>> {
        return this.api.getSubmodelElementWithHttpInfo(param.submodelIdentifier, param.idShortPath, param.level, param.extent,  options).toPromise();
    }

    /**
     * Returns a specific submodel element from the Submodel at a specified path
     * @param param the request object
     */
    public getSubmodelElement(param: SubmodelRepositoryApiGetSubmodelElementRequest, options?: Configuration): Promise<SubmodelElement> {
        return this.api.getSubmodelElement(param.submodelIdentifier, param.idShortPath, param.level, param.extent,  options).toPromise();
    }

    /**
     * Returns a specific submodel element from the Submodel at a specified path in the ValueOnly representation
     * @param param the request object
     */
    public getSubmodelElementValueWithHttpInfo(param: SubmodelRepositoryApiGetSubmodelElementValueRequest, options?: Configuration): Promise<HttpInfo<SubmodelElementValue>> {
        return this.api.getSubmodelElementValueWithHttpInfo(param.submodelIdentifier, param.idShortPath, param.level, param.extent,  options).toPromise();
    }

    /**
     * Returns a specific submodel element from the Submodel at a specified path in the ValueOnly representation
     * @param param the request object
     */
    public getSubmodelElementValue(param: SubmodelRepositoryApiGetSubmodelElementValueRequest, options?: Configuration): Promise<SubmodelElementValue> {
        return this.api.getSubmodelElementValue(param.submodelIdentifier, param.idShortPath, param.level, param.extent,  options).toPromise();
    }

    /**
     * Returns the metadata attributes of a specific Submodel
     * @param param the request object
     */
    public getSubmodelMetadataWithHttpInfo(param: SubmodelRepositoryApiGetSubmodelMetadataRequest, options?: Configuration): Promise<HttpInfo<SubmodelMetadata>> {
        return this.api.getSubmodelMetadataWithHttpInfo(param.submodelIdentifier, param.level,  options).toPromise();
    }

    /**
     * Returns the metadata attributes of a specific Submodel
     * @param param the request object
     */
    public getSubmodelMetadata(param: SubmodelRepositoryApiGetSubmodelMetadataRequest, options?: Configuration): Promise<SubmodelMetadata> {
        return this.api.getSubmodelMetadata(param.submodelIdentifier, param.level,  options).toPromise();
    }

    /**
     * Synchronously or asynchronously invokes an Operation at a specified path
     * @param param the request object
     */
    public invokeOperationWithHttpInfo(param: SubmodelRepositoryApiInvokeOperationRequest, options?: Configuration): Promise<HttpInfo<OperationResult>> {
        return this.api.invokeOperationWithHttpInfo(param.submodelIdentifier, param.idShortPath, param.operationRequest, param.async,  options).toPromise();
    }

    /**
     * Synchronously or asynchronously invokes an Operation at a specified path
     * @param param the request object
     */
    public invokeOperation(param: SubmodelRepositoryApiInvokeOperationRequest, options?: Configuration): Promise<OperationResult> {
        return this.api.invokeOperation(param.submodelIdentifier, param.idShortPath, param.operationRequest, param.async,  options).toPromise();
    }

    /**
     * Updates the value of an existing SubmodelElement
     * @param param the request object
     */
    public patchSubmodelElementValueWithHttpInfo(param: SubmodelRepositoryApiPatchSubmodelElementValueRequest, options?: Configuration): Promise<HttpInfo<void>> {
        return this.api.patchSubmodelElementValueWithHttpInfo(param.submodelIdentifier, param.idShortPath, param.submodelElementValue, param.level,  options).toPromise();
    }

    /**
     * Updates the value of an existing SubmodelElement
     * @param param the request object
     */
    public patchSubmodelElementValue(param: SubmodelRepositoryApiPatchSubmodelElementValueRequest, options?: Configuration): Promise<void> {
        return this.api.patchSubmodelElementValue(param.submodelIdentifier, param.idShortPath, param.submodelElementValue, param.level,  options).toPromise();
    }

    /**
     * Creates a new Submodel
     * @param param the request object
     */
    public postSubmodelWithHttpInfo(param: SubmodelRepositoryApiPostSubmodelRequest, options?: Configuration): Promise<HttpInfo<Submodel>> {
        return this.api.postSubmodelWithHttpInfo(param.submodel,  options).toPromise();
    }

    /**
     * Creates a new Submodel
     * @param param the request object
     */
    public postSubmodel(param: SubmodelRepositoryApiPostSubmodelRequest, options?: Configuration): Promise<Submodel> {
        return this.api.postSubmodel(param.submodel,  options).toPromise();
    }

    /**
     * Creates a new submodel element
     * @param param the request object
     */
    public postSubmodelElementWithHttpInfo(param: SubmodelRepositoryApiPostSubmodelElementRequest, options?: Configuration): Promise<HttpInfo<SubmodelElement>> {
        return this.api.postSubmodelElementWithHttpInfo(param.submodelIdentifier, param.submodelElement,  options).toPromise();
    }

    /**
     * Creates a new submodel element
     * @param param the request object
     */
    public postSubmodelElement(param: SubmodelRepositoryApiPostSubmodelElementRequest, options?: Configuration): Promise<SubmodelElement> {
        return this.api.postSubmodelElement(param.submodelIdentifier, param.submodelElement,  options).toPromise();
    }

    /**
     * Creates a new submodel element at a specified path within submodel elements hierarchy
     * @param param the request object
     */
    public postSubmodelElementUnderPathWithHttpInfo(param: SubmodelRepositoryApiPostSubmodelElementUnderPathRequest, options?: Configuration): Promise<HttpInfo<SubmodelElement>> {
        return this.api.postSubmodelElementUnderPathWithHttpInfo(param.submodelIdentifier, param.idShortPath, param.submodelElement,  options).toPromise();
    }

    /**
     * Creates a new submodel element at a specified path within submodel elements hierarchy
     * @param param the request object
     */
    public postSubmodelElementUnderPath(param: SubmodelRepositoryApiPostSubmodelElementUnderPathRequest, options?: Configuration): Promise<SubmodelElement> {
        return this.api.postSubmodelElementUnderPath(param.submodelIdentifier, param.idShortPath, param.submodelElement,  options).toPromise();
    }

    /**
     * Uploads file content to an existing submodel element at a specified path within submodel elements hierarchy
     * @param param the request object
     */
    public putFileAttachmentWithHttpInfo(param: SubmodelRepositoryApiPutFileAttachmentRequest, options?: Configuration): Promise<HttpInfo<void>> {
        return this.api.putFileAttachmentWithHttpInfo(param.submodelIdentifier, param.idShortPath, param.fileName, param.file,  options).toPromise();
    }

    /**
     * Uploads file content to an existing submodel element at a specified path within submodel elements hierarchy
     * @param param the request object
     */
    public putFileAttachment(param: SubmodelRepositoryApiPutFileAttachmentRequest, options?: Configuration): Promise<void> {
        return this.api.putFileAttachment(param.submodelIdentifier, param.idShortPath, param.fileName, param.file,  options).toPromise();
    }

    /**
     * Updates an existing Submodel
     * @param param the request object
     */
    public putSubmodelWithHttpInfo(param: SubmodelRepositoryApiPutSubmodelRequest, options?: Configuration): Promise<HttpInfo<void>> {
        return this.api.putSubmodelWithHttpInfo(param.submodelIdentifier, param.submodel,  options).toPromise();
    }

    /**
     * Updates an existing Submodel
     * @param param the request object
     */
    public putSubmodel(param: SubmodelRepositoryApiPutSubmodelRequest, options?: Configuration): Promise<void> {
        return this.api.putSubmodel(param.submodelIdentifier, param.submodel,  options).toPromise();
    }

    /**
     * Updates an existing submodel element at a specified path within submodel elements hierarchy
     * @param param the request object
     */
    public putSubmodelElementWithHttpInfo(param: SubmodelRepositoryApiPutSubmodelElementRequest, options?: Configuration): Promise<HttpInfo<void>> {
        return this.api.putSubmodelElementWithHttpInfo(param.submodelIdentifier, param.idShortPath, param.submodelElement, param.level,  options).toPromise();
    }

    /**
     * Updates an existing submodel element at a specified path within submodel elements hierarchy
     * @param param the request object
     */
    public putSubmodelElement(param: SubmodelRepositoryApiPutSubmodelElementRequest, options?: Configuration): Promise<void> {
        return this.api.putSubmodelElement(param.submodelIdentifier, param.idShortPath, param.submodelElement, param.level,  options).toPromise();
    }

}
