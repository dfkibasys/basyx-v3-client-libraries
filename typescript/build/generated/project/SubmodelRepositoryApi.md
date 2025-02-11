# .SubmodelRepositoryApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**deleteFileAttachment**](SubmodelRepositoryApi.md#deleteFileAttachment) | **DELETE** /submodels/{submodelIdentifier}/submodel-elements/{idShortPath}/attachment | Deletes file content of an existing submodel element at a specified path within submodel elements hierarchy
[**deleteSubmodel**](SubmodelRepositoryApi.md#deleteSubmodel) | **DELETE** /submodels/{submodelIdentifier} | Deletes a Submodel
[**deleteSubmodelElement**](SubmodelRepositoryApi.md#deleteSubmodelElement) | **DELETE** /submodels/{submodelIdentifier}/submodel-elements/{idShortPath} | Deletes a submodel element at a specified path within the submodel elements hierarchy
[**getAllSubmodelElements**](SubmodelRepositoryApi.md#getAllSubmodelElements) | **GET** /submodels/{submodelIdentifier}/submodel-elements | Returns all submodel elements including their hierarchy
[**getAllSubmodels**](SubmodelRepositoryApi.md#getAllSubmodels) | **GET** /submodels | Returns all Submodels
[**getDescription**](SubmodelRepositoryApi.md#getDescription) | **GET** /description | Returns the self-describing information of a network resource (ServiceDescription)
[**getFileAttachment**](SubmodelRepositoryApi.md#getFileAttachment) | **GET** /submodels/{submodelIdentifier}/submodel-elements/{idShortPath}/attachment | Downloads file content from a specific submodel element from the Submodel at a specified path
[**getSubmodel**](SubmodelRepositoryApi.md#getSubmodel) | **GET** /submodels/{submodelIdentifier} | Returns a specific Submodel
[**getSubmodelElement**](SubmodelRepositoryApi.md#getSubmodelElement) | **GET** /submodels/{submodelIdentifier}/submodel-elements/{idShortPath} | Returns a specific submodel element from the Submodel at a specified path
[**getSubmodelElementValue**](SubmodelRepositoryApi.md#getSubmodelElementValue) | **GET** /submodels/{submodelIdentifier}/submodel-elements/{idShortPath}/$value | Returns a specific submodel element from the Submodel at a specified path in the ValueOnly representation
[**getSubmodelMetadata**](SubmodelRepositoryApi.md#getSubmodelMetadata) | **GET** /submodels/{submodelIdentifier}/$metadata | Returns the metadata attributes of a specific Submodel
[**invokeOperation**](SubmodelRepositoryApi.md#invokeOperation) | **POST** /submodels/{submodelIdentifier}/submodel-elements/{idShortPath}/invoke | Synchronously or asynchronously invokes an Operation at a specified path
[**patchSubmodelElementValue**](SubmodelRepositoryApi.md#patchSubmodelElementValue) | **PATCH** /submodels/{submodelIdentifier}/submodel-elements/{idShortPath}/$value | Updates the value of an existing SubmodelElement
[**postSubmodel**](SubmodelRepositoryApi.md#postSubmodel) | **POST** /submodels | Creates a new Submodel
[**postSubmodelElement**](SubmodelRepositoryApi.md#postSubmodelElement) | **POST** /submodels/{submodelIdentifier}/submodel-elements | Creates a new submodel element
[**postSubmodelElementUnderPath**](SubmodelRepositoryApi.md#postSubmodelElementUnderPath) | **POST** /submodels/{submodelIdentifier}/submodel-elements/{idShortPath} | Creates a new submodel element at a specified path within submodel elements hierarchy
[**putFileAttachment**](SubmodelRepositoryApi.md#putFileAttachment) | **PUT** /submodels/{submodelIdentifier}/submodel-elements/{idShortPath}/attachment | Uploads file content to an existing submodel element at a specified path within submodel elements hierarchy
[**putSubmodel**](SubmodelRepositoryApi.md#putSubmodel) | **PUT** /submodels/{submodelIdentifier} | Updates an existing Submodel
[**putSubmodelElement**](SubmodelRepositoryApi.md#putSubmodelElement) | **PUT** /submodels/{submodelIdentifier}/submodel-elements/{idShortPath} | Updates an existing submodel element at a specified path within submodel elements hierarchy


# **deleteFileAttachment**
> void deleteFileAttachment()


### Example


```typescript
import {  } from '';
import * as fs from 'fs';

const configuration = .createConfiguration();
const apiInstance = new .SubmodelRepositoryApi(configuration);

let body:.SubmodelRepositoryApiDeleteFileAttachmentRequest = {
  // string | The Submodel’s unique id (UTF8-BASE64-URL-encoded)
  submodelIdentifier: 'YQ==',
  // string | IdShort path to the submodel element (dot-separated)
  idShortPath: "idShortPath_example",
};

apiInstance.deleteFileAttachment(body).then((data:any) => {
  console.log('API called successfully. Returned data: ' + data);
}).catch((error:any) => console.error(error));
```


### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **submodelIdentifier** | [**string**] | The Submodel’s unique id (UTF8-BASE64-URL-encoded) | defaults to undefined
 **idShortPath** | [**string**] | IdShort path to the submodel element (dot-separated) | defaults to undefined


### Return type

**void**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Submodel element updated successfully |  -  |
**400** | Bad Request, e.g. the request parameters of the format of the request body is wrong. |  -  |
**401** | Unauthorized, e.g. the server refused the authorization attempt. |  -  |
**403** | Forbidden |  -  |
**404** | Not Found |  -  |
**500** | Internal Server Error |  -  |
**0** | Default error handling for unmentioned status codes |  -  |

[[Back to top]](#) [[Back to API list]](README.md#documentation-for-api-endpoints) [[Back to Model list]](README.md#documentation-for-models) [[Back to README]](README.md)

# **deleteSubmodel**
> void deleteSubmodel()


### Example


```typescript
import {  } from '';
import * as fs from 'fs';

const configuration = .createConfiguration();
const apiInstance = new .SubmodelRepositoryApi(configuration);

let body:.SubmodelRepositoryApiDeleteSubmodelRequest = {
  // string | The Submodel’s unique id (UTF8-BASE64-URL-encoded)
  submodelIdentifier: 'YQ==',
};

apiInstance.deleteSubmodel(body).then((data:any) => {
  console.log('API called successfully. Returned data: ' + data);
}).catch((error:any) => console.error(error));
```


### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **submodelIdentifier** | [**string**] | The Submodel’s unique id (UTF8-BASE64-URL-encoded) | defaults to undefined


### Return type

**void**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**204** | Submodel deleted successfully |  -  |
**400** | Bad Request, e.g. the request parameters of the format of the request body is wrong. |  -  |
**401** | Unauthorized, e.g. the server refused the authorization attempt. |  -  |
**403** | Forbidden |  -  |
**404** | Not Found |  -  |
**500** | Internal Server Error |  -  |
**0** | Default error handling for unmentioned status codes |  -  |

[[Back to top]](#) [[Back to API list]](README.md#documentation-for-api-endpoints) [[Back to Model list]](README.md#documentation-for-models) [[Back to README]](README.md)

# **deleteSubmodelElement**
> void deleteSubmodelElement()


### Example


```typescript
import {  } from '';
import * as fs from 'fs';

const configuration = .createConfiguration();
const apiInstance = new .SubmodelRepositoryApi(configuration);

let body:.SubmodelRepositoryApiDeleteSubmodelElementRequest = {
  // string | The Submodel’s unique id (UTF8-BASE64-URL-encoded)
  submodelIdentifier: 'YQ==',
  // string | IdShort path to the submodel element (dot-separated)
  idShortPath: "idShortPath_example",
};

apiInstance.deleteSubmodelElement(body).then((data:any) => {
  console.log('API called successfully. Returned data: ' + data);
}).catch((error:any) => console.error(error));
```


### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **submodelIdentifier** | [**string**] | The Submodel’s unique id (UTF8-BASE64-URL-encoded) | defaults to undefined
 **idShortPath** | [**string**] | IdShort path to the submodel element (dot-separated) | defaults to undefined


### Return type

**void**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**204** | Submodel element deleted successfully |  -  |
**400** | Bad Request, e.g. the request parameters of the format of the request body is wrong. |  -  |
**401** | Unauthorized, e.g. the server refused the authorization attempt. |  -  |
**403** | Forbidden |  -  |
**404** | Not Found |  -  |
**500** | Internal Server Error |  -  |
**0** | Default error handling for unmentioned status codes |  -  |

[[Back to top]](#) [[Back to API list]](README.md#documentation-for-api-endpoints) [[Back to Model list]](README.md#documentation-for-models) [[Back to README]](README.md)

# **getAllSubmodelElements**
> GetSubmodelElementsResult getAllSubmodelElements()


### Example


```typescript
import {  } from '';
import * as fs from 'fs';

const configuration = .createConfiguration();
const apiInstance = new .SubmodelRepositoryApi(configuration);

let body:.SubmodelRepositoryApiGetAllSubmodelElementsRequest = {
  // string | The Submodel’s unique id (UTF8-BASE64-URL-encoded)
  submodelIdentifier: 'YQ==',
  // number | The maximum number of elements in the response array (optional)
  limit: 1,
  // string | A server-generated identifier retrieved from pagingMetadata that specifies from which position the result listing should continue (optional)
  cursor: "cursor_example",
  // 'deep' | 'core' | Determines the structural depth of the respective resource content (optional)
  level: "deep",
  // 'withBlobValue' | 'withoutBlobValue' | Determines to which extent the resource is being serialized (optional)
  extent: "withoutBlobValue",
};

apiInstance.getAllSubmodelElements(body).then((data:any) => {
  console.log('API called successfully. Returned data: ' + data);
}).catch((error:any) => console.error(error));
```


### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **submodelIdentifier** | [**string**] | The Submodel’s unique id (UTF8-BASE64-URL-encoded) | defaults to undefined
 **limit** | [**number**] | The maximum number of elements in the response array | (optional) defaults to undefined
 **cursor** | [**string**] | A server-generated identifier retrieved from pagingMetadata that specifies from which position the result listing should continue | (optional) defaults to undefined
 **level** | [**&#39;deep&#39; | &#39;core&#39;**]**Array<&#39;deep&#39; &#124; &#39;core&#39;>** | Determines the structural depth of the respective resource content | (optional) defaults to 'deep'
 **extent** | [**&#39;withBlobValue&#39; | &#39;withoutBlobValue&#39;**]**Array<&#39;withBlobValue&#39; &#124; &#39;withoutBlobValue&#39;>** | Determines to which extent the resource is being serialized | (optional) defaults to 'withoutBlobValue'


### Return type

**GetSubmodelElementsResult**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | List of found submodel elements |  -  |
**400** | Bad Request, e.g. the request parameters of the format of the request body is wrong. |  -  |
**401** | Unauthorized, e.g. the server refused the authorization attempt. |  -  |
**403** | Forbidden |  -  |
**404** | Not Found |  -  |
**500** | Internal Server Error |  -  |
**0** | Default error handling for unmentioned status codes |  -  |

[[Back to top]](#) [[Back to API list]](README.md#documentation-for-api-endpoints) [[Back to Model list]](README.md#documentation-for-models) [[Back to README]](README.md)

# **getAllSubmodels**
> GetSubmodelsResult getAllSubmodels()


### Example


```typescript
import {  } from '';
import * as fs from 'fs';

const configuration = .createConfiguration();
const apiInstance = new .SubmodelRepositoryApi(configuration);

let body:.SubmodelRepositoryApiGetAllSubmodelsRequest = {
  // string | The value of the semantic id reference (BASE64-URL-encoded) (optional)
  semanticId: "semanticId_example",
  // string | The Asset Administration Shell\'s IdShort (optional)
  idShort: "idShort_example",
  // number | The maximum number of elements in the response array (optional)
  limit: 1,
  // string | A server-generated identifier retrieved from pagingMetadata that specifies from which position the result listing should continue (optional)
  cursor: "cursor_example",
  // 'deep' | 'core' | Determines the structural depth of the respective resource content (optional)
  level: "deep",
  // 'withBlobValue' | 'withoutBlobValue' | Determines to which extent the resource is being serialized (optional)
  extent: "withoutBlobValue",
};

apiInstance.getAllSubmodels(body).then((data:any) => {
  console.log('API called successfully. Returned data: ' + data);
}).catch((error:any) => console.error(error));
```


### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **semanticId** | [**string**] | The value of the semantic id reference (BASE64-URL-encoded) | (optional) defaults to undefined
 **idShort** | [**string**] | The Asset Administration Shell\&#39;s IdShort | (optional) defaults to undefined
 **limit** | [**number**] | The maximum number of elements in the response array | (optional) defaults to undefined
 **cursor** | [**string**] | A server-generated identifier retrieved from pagingMetadata that specifies from which position the result listing should continue | (optional) defaults to undefined
 **level** | [**&#39;deep&#39; | &#39;core&#39;**]**Array<&#39;deep&#39; &#124; &#39;core&#39;>** | Determines the structural depth of the respective resource content | (optional) defaults to 'deep'
 **extent** | [**&#39;withBlobValue&#39; | &#39;withoutBlobValue&#39;**]**Array<&#39;withBlobValue&#39; &#124; &#39;withoutBlobValue&#39;>** | Determines to which extent the resource is being serialized | (optional) defaults to 'withoutBlobValue'


### Return type

**GetSubmodelsResult**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Requested Submodels |  -  |
**400** | Bad Request, e.g. the request parameters of the format of the request body is wrong. |  -  |
**401** | Unauthorized, e.g. the server refused the authorization attempt. |  -  |
**403** | Forbidden |  -  |
**500** | Internal Server Error |  -  |
**0** | Default error handling for unmentioned status codes |  -  |

[[Back to top]](#) [[Back to API list]](README.md#documentation-for-api-endpoints) [[Back to Model list]](README.md#documentation-for-models) [[Back to README]](README.md)

# **getDescription**
> ServiceDescription getDescription()


### Example


```typescript
import {  } from '';
import * as fs from 'fs';

const configuration = .createConfiguration();
const apiInstance = new .SubmodelRepositoryApi(configuration);

let body:any = {};

apiInstance.getDescription(body).then((data:any) => {
  console.log('API called successfully. Returned data: ' + data);
}).catch((error:any) => console.error(error));
```


### Parameters
This endpoint does not need any parameter.


### Return type

**ServiceDescription**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Requested Description |  -  |
**401** | Unauthorized, e.g. the server refused the authorization attempt. |  -  |
**403** | Forbidden |  -  |

[[Back to top]](#) [[Back to API list]](README.md#documentation-for-api-endpoints) [[Back to Model list]](README.md#documentation-for-models) [[Back to README]](README.md)

# **getFileAttachment**
> HttpFile getFileAttachment()


### Example


```typescript
import {  } from '';
import * as fs from 'fs';

const configuration = .createConfiguration();
const apiInstance = new .SubmodelRepositoryApi(configuration);

let body:.SubmodelRepositoryApiGetFileAttachmentRequest = {
  // string | The Submodel’s unique id (UTF8-BASE64-URL-encoded)
  submodelIdentifier: 'YQ==',
  // string | IdShort path to the submodel element (dot-separated)
  idShortPath: "idShortPath_example",
};

apiInstance.getFileAttachment(body).then((data:any) => {
  console.log('API called successfully. Returned data: ' + data);
}).catch((error:any) => console.error(error));
```


### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **submodelIdentifier** | [**string**] | The Submodel’s unique id (UTF8-BASE64-URL-encoded) | defaults to undefined
 **idShortPath** | [**string**] | IdShort path to the submodel element (dot-separated) | defaults to undefined


### Return type

**HttpFile**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/octet-stream, application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Requested file |  * Content-Disposition - In order to physically download the file usually set to attachment with a filename <br>  |
**400** | Bad Request, e.g. the request parameters of the format of the request body is wrong. |  -  |
**401** | Unauthorized, e.g. the server refused the authorization attempt. |  -  |
**403** | Forbidden |  -  |
**404** | Not Found |  -  |
**405** | Method not allowed - Download only valid for File submodel element |  -  |
**500** | Internal Server Error |  -  |
**0** | Default error handling for unmentioned status codes |  -  |

[[Back to top]](#) [[Back to API list]](README.md#documentation-for-api-endpoints) [[Back to Model list]](README.md#documentation-for-models) [[Back to README]](README.md)

# **getSubmodel**
> Submodel getSubmodel()


### Example


```typescript
import {  } from '';
import * as fs from 'fs';

const configuration = .createConfiguration();
const apiInstance = new .SubmodelRepositoryApi(configuration);

let body:.SubmodelRepositoryApiGetSubmodelRequest = {
  // string | The Submodel’s unique id (UTF8-BASE64-URL-encoded)
  submodelIdentifier: 'YQ==',
  // 'deep' | 'core' | Determines the structural depth of the respective resource content (optional)
  level: "deep",
  // 'withBlobValue' | 'withoutBlobValue' | Determines to which extent the resource is being serialized (optional)
  extent: "withoutBlobValue",
};

apiInstance.getSubmodel(body).then((data:any) => {
  console.log('API called successfully. Returned data: ' + data);
}).catch((error:any) => console.error(error));
```


### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **submodelIdentifier** | [**string**] | The Submodel’s unique id (UTF8-BASE64-URL-encoded) | defaults to undefined
 **level** | [**&#39;deep&#39; | &#39;core&#39;**]**Array<&#39;deep&#39; &#124; &#39;core&#39;>** | Determines the structural depth of the respective resource content | (optional) defaults to 'deep'
 **extent** | [**&#39;withBlobValue&#39; | &#39;withoutBlobValue&#39;**]**Array<&#39;withBlobValue&#39; &#124; &#39;withoutBlobValue&#39;>** | Determines to which extent the resource is being serialized | (optional) defaults to 'withoutBlobValue'


### Return type

**Submodel**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Requested Submodel |  -  |
**400** | Bad Request, e.g. the request parameters of the format of the request body is wrong. |  -  |
**401** | Unauthorized, e.g. the server refused the authorization attempt. |  -  |
**403** | Forbidden |  -  |
**404** | Not Found |  -  |
**500** | Internal Server Error |  -  |
**0** | Default error handling for unmentioned status codes |  -  |

[[Back to top]](#) [[Back to API list]](README.md#documentation-for-api-endpoints) [[Back to Model list]](README.md#documentation-for-models) [[Back to README]](README.md)

# **getSubmodelElement**
> SubmodelElement getSubmodelElement()


### Example


```typescript
import {  } from '';
import * as fs from 'fs';

const configuration = .createConfiguration();
const apiInstance = new .SubmodelRepositoryApi(configuration);

let body:.SubmodelRepositoryApiGetSubmodelElementRequest = {
  // string | The Submodel’s unique id (UTF8-BASE64-URL-encoded)
  submodelIdentifier: 'YQ==',
  // string | IdShort path to the submodel element (dot-separated)
  idShortPath: "idShortPath_example",
  // 'deep' | 'core' | Determines the structural depth of the respective resource content (optional)
  level: "deep",
  // 'withBlobValue' | 'withoutBlobValue' | Determines to which extent the resource is being serialized (optional)
  extent: "withoutBlobValue",
};

apiInstance.getSubmodelElement(body).then((data:any) => {
  console.log('API called successfully. Returned data: ' + data);
}).catch((error:any) => console.error(error));
```


### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **submodelIdentifier** | [**string**] | The Submodel’s unique id (UTF8-BASE64-URL-encoded) | defaults to undefined
 **idShortPath** | [**string**] | IdShort path to the submodel element (dot-separated) | defaults to undefined
 **level** | [**&#39;deep&#39; | &#39;core&#39;**]**Array<&#39;deep&#39; &#124; &#39;core&#39;>** | Determines the structural depth of the respective resource content | (optional) defaults to 'deep'
 **extent** | [**&#39;withBlobValue&#39; | &#39;withoutBlobValue&#39;**]**Array<&#39;withBlobValue&#39; &#124; &#39;withoutBlobValue&#39;>** | Determines to which extent the resource is being serialized | (optional) defaults to 'withoutBlobValue'


### Return type

**SubmodelElement**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Requested submodel element |  -  |
**400** | Bad Request, e.g. the request parameters of the format of the request body is wrong. |  -  |
**401** | Unauthorized, e.g. the server refused the authorization attempt. |  -  |
**403** | Forbidden |  -  |
**404** | Not Found |  -  |
**500** | Internal Server Error |  -  |
**0** | Default error handling for unmentioned status codes |  -  |

[[Back to top]](#) [[Back to API list]](README.md#documentation-for-api-endpoints) [[Back to Model list]](README.md#documentation-for-models) [[Back to README]](README.md)

# **getSubmodelElementValue**
> SubmodelElementValue getSubmodelElementValue()


### Example


```typescript
import {  } from '';
import * as fs from 'fs';

const configuration = .createConfiguration();
const apiInstance = new .SubmodelRepositoryApi(configuration);

let body:.SubmodelRepositoryApiGetSubmodelElementValueRequest = {
  // string | The Submodel’s unique id (UTF8-BASE64-URL-encoded)
  submodelIdentifier: 'YQ==',
  // string | IdShort path to the submodel element (dot-separated)
  idShortPath: "idShortPath_example",
  // 'deep' | 'core' | Determines the structural depth of the respective resource content (optional)
  level: "deep",
  // 'withBlobValue' | 'withoutBlobValue' | Determines to which extent the resource is being serialized (optional)
  extent: "withoutBlobValue",
};

apiInstance.getSubmodelElementValue(body).then((data:any) => {
  console.log('API called successfully. Returned data: ' + data);
}).catch((error:any) => console.error(error));
```


### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **submodelIdentifier** | [**string**] | The Submodel’s unique id (UTF8-BASE64-URL-encoded) | defaults to undefined
 **idShortPath** | [**string**] | IdShort path to the submodel element (dot-separated) | defaults to undefined
 **level** | [**&#39;deep&#39; | &#39;core&#39;**]**Array<&#39;deep&#39; &#124; &#39;core&#39;>** | Determines the structural depth of the respective resource content | (optional) defaults to 'deep'
 **extent** | [**&#39;withBlobValue&#39; | &#39;withoutBlobValue&#39;**]**Array<&#39;withBlobValue&#39; &#124; &#39;withoutBlobValue&#39;>** | Determines to which extent the resource is being serialized | (optional) defaults to 'withoutBlobValue'


### Return type

**SubmodelElementValue**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Requested submodel element |  -  |
**400** | Bad Request, e.g. the request parameters of the format of the request body is wrong. |  -  |
**401** | Unauthorized, e.g. the server refused the authorization attempt. |  -  |
**403** | Forbidden |  -  |
**404** | Not Found |  -  |
**500** | Internal Server Error |  -  |
**0** | Default error handling for unmentioned status codes |  -  |

[[Back to top]](#) [[Back to API list]](README.md#documentation-for-api-endpoints) [[Back to Model list]](README.md#documentation-for-models) [[Back to README]](README.md)

# **getSubmodelMetadata**
> SubmodelMetadata getSubmodelMetadata()


### Example


```typescript
import {  } from '';
import * as fs from 'fs';

const configuration = .createConfiguration();
const apiInstance = new .SubmodelRepositoryApi(configuration);

let body:.SubmodelRepositoryApiGetSubmodelMetadataRequest = {
  // string | The Submodel’s unique id (UTF8-BASE64-URL-encoded)
  submodelIdentifier: 'YQ==',
  // 'deep' | 'core' | Determines the structural depth of the respective resource content (optional)
  level: "deep",
};

apiInstance.getSubmodelMetadata(body).then((data:any) => {
  console.log('API called successfully. Returned data: ' + data);
}).catch((error:any) => console.error(error));
```


### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **submodelIdentifier** | [**string**] | The Submodel’s unique id (UTF8-BASE64-URL-encoded) | defaults to undefined
 **level** | [**&#39;deep&#39; | &#39;core&#39;**]**Array<&#39;deep&#39; &#124; &#39;core&#39;>** | Determines the structural depth of the respective resource content | (optional) defaults to 'deep'


### Return type

**SubmodelMetadata**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Requested Submodel in the metadata representation |  -  |
**400** | Bad Request, e.g. the request parameters of the format of the request body is wrong. |  -  |
**401** | Unauthorized, e.g. the server refused the authorization attempt. |  -  |
**403** | Forbidden |  -  |
**404** | Not Found |  -  |
**500** | Internal Server Error |  -  |
**0** | Default error handling for unmentioned status codes |  -  |

[[Back to top]](#) [[Back to API list]](README.md#documentation-for-api-endpoints) [[Back to Model list]](README.md#documentation-for-models) [[Back to README]](README.md)

# **invokeOperation**
> OperationResult invokeOperation(operationRequest)


### Example


```typescript
import {  } from '';
import * as fs from 'fs';

const configuration = .createConfiguration();
const apiInstance = new .SubmodelRepositoryApi(configuration);

let body:.SubmodelRepositoryApiInvokeOperationRequest = {
  // string | The Submodel’s unique id (UTF8-BASE64-URL-encoded)
  submodelIdentifier: 'YQ==',
  // string | IdShort path to the submodel element (dot-separated)
  idShortPath: "idShortPath_example",
  // OperationRequest | Operation request object
  operationRequest: {
    inoutputArguments: [
      {
        value: null,
      },
    ],
    inputArguments: [
      {
        value: null,
      },
    ],
    clientTimeoutDuration: "-Pj",
  },
  // boolean | Determines whether an operation invocation is performed asynchronously or synchronously (optional)
  async: false,
};

apiInstance.invokeOperation(body).then((data:any) => {
  console.log('API called successfully. Returned data: ' + data);
}).catch((error:any) => console.error(error));
```


### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **operationRequest** | **OperationRequest**| Operation request object |
 **submodelIdentifier** | [**string**] | The Submodel’s unique id (UTF8-BASE64-URL-encoded) | defaults to undefined
 **idShortPath** | [**string**] | IdShort path to the submodel element (dot-separated) | defaults to undefined
 **async** | [**boolean**] | Determines whether an operation invocation is performed asynchronously or synchronously | (optional) defaults to false


### Return type

**OperationResult**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Operation result object |  -  |
**400** | Bad Request, e.g. the request parameters of the format of the request body is wrong. |  -  |
**401** | Unauthorized, e.g. the server refused the authorization attempt. |  -  |
**403** | Forbidden |  -  |
**404** | Not Found |  -  |
**405** | Method not allowed - Invoke only valid for Operation submodel element |  -  |
**500** | Internal Server Error |  -  |
**0** | Default error handling for unmentioned status codes |  -  |

[[Back to top]](#) [[Back to API list]](README.md#documentation-for-api-endpoints) [[Back to Model list]](README.md#documentation-for-models) [[Back to README]](README.md)

# **patchSubmodelElementValue**
> void patchSubmodelElementValue(submodelElementValue)


### Example


```typescript
import {  } from '';
import * as fs from 'fs';

const configuration = .createConfiguration();
const apiInstance = new .SubmodelRepositoryApi(configuration);

let body:.SubmodelRepositoryApiPatchSubmodelElementValueRequest = {
  // string | The Submodel’s unique id (UTF8-BASE64-URL-encoded)
  submodelIdentifier: 'YQ==',
  // string | IdShort path to the submodel element (dot-separated)
  idShortPath: "idShortPath_example",
  // SubmodelElementValue | The SubmodelElement in its ValueOnly representation
  submodelElementValue: null,
  // 'core' | Determines the structural depth of the respective resource content (optional)
  level: "core",
};

apiInstance.patchSubmodelElementValue(body).then((data:any) => {
  console.log('API called successfully. Returned data: ' + data);
}).catch((error:any) => console.error(error));
```


### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **submodelElementValue** | **SubmodelElementValue**| The SubmodelElement in its ValueOnly representation |
 **submodelIdentifier** | [**string**] | The Submodel’s unique id (UTF8-BASE64-URL-encoded) | defaults to undefined
 **idShortPath** | [**string**] | IdShort path to the submodel element (dot-separated) | defaults to undefined
 **level** | [**&#39;core&#39;**]**Array<&#39;core&#39;>** | Determines the structural depth of the respective resource content | (optional) defaults to 'core'


### Return type

**void**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**204** | Submodel updated successfully |  -  |
**400** | Bad Request, e.g. the request parameters of the format of the request body is wrong. |  -  |
**401** | Unauthorized, e.g. the server refused the authorization attempt. |  -  |
**403** | Forbidden |  -  |
**404** | Not Found |  -  |
**500** | Internal Server Error |  -  |
**0** | Default error handling for unmentioned status codes |  -  |

[[Back to top]](#) [[Back to API list]](README.md#documentation-for-api-endpoints) [[Back to Model list]](README.md#documentation-for-models) [[Back to README]](README.md)

# **postSubmodel**
> Submodel postSubmodel(submodel)


### Example


```typescript
import {  } from '';
import * as fs from 'fs';

const configuration = .createConfiguration();
const apiInstance = new .SubmodelRepositoryApi(configuration);

let body:.SubmodelRepositoryApiPostSubmodelRequest = {
  // Submodel | Submodel object
  submodel: null,
};

apiInstance.postSubmodel(body).then((data:any) => {
  console.log('API called successfully. Returned data: ' + data);
}).catch((error:any) => console.error(error));
```


### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **submodel** | **Submodel**| Submodel object |


### Return type

**Submodel**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**201** | Submodel created successfully |  * Location - URL of the newly created resource <br>  |
**400** | Bad Request, e.g. the request parameters of the format of the request body is wrong. |  -  |
**401** | Unauthorized, e.g. the server refused the authorization attempt. |  -  |
**403** | Forbidden |  -  |
**409** | Conflict, a resource which shall be created exists already. Might be thrown if a Submodel or SubmodelElement with the same ShortId is contained in a POST request. |  -  |
**500** | Internal Server Error |  -  |
**0** | Default error handling for unmentioned status codes |  -  |

[[Back to top]](#) [[Back to API list]](README.md#documentation-for-api-endpoints) [[Back to Model list]](README.md#documentation-for-models) [[Back to README]](README.md)

# **postSubmodelElement**
> SubmodelElement postSubmodelElement(submodelElement)


### Example


```typescript
import {  } from '';
import * as fs from 'fs';

const configuration = .createConfiguration();
const apiInstance = new .SubmodelRepositoryApi(configuration);

let body:.SubmodelRepositoryApiPostSubmodelElementRequest = {
  // string | The Submodel’s unique id (UTF8-BASE64-URL-encoded)
  submodelIdentifier: 'YQ==',
  // SubmodelElement | Requested submodel element
  submodelElement: null,
};

apiInstance.postSubmodelElement(body).then((data:any) => {
  console.log('API called successfully. Returned data: ' + data);
}).catch((error:any) => console.error(error));
```


### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **submodelElement** | **SubmodelElement**| Requested submodel element |
 **submodelIdentifier** | [**string**] | The Submodel’s unique id (UTF8-BASE64-URL-encoded) | defaults to undefined


### Return type

**SubmodelElement**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**201** | Submodel element created successfully |  * Location - URL of the newly created resource <br>  |
**400** | Bad Request, e.g. the request parameters of the format of the request body is wrong. |  -  |
**401** | Unauthorized, e.g. the server refused the authorization attempt. |  -  |
**403** | Forbidden |  -  |
**404** | Not Found |  -  |
**409** | Conflict, a resource which shall be created exists already. Might be thrown if a Submodel or SubmodelElement with the same ShortId is contained in a POST request. |  -  |
**500** | Internal Server Error |  -  |
**0** | Default error handling for unmentioned status codes |  -  |

[[Back to top]](#) [[Back to API list]](README.md#documentation-for-api-endpoints) [[Back to Model list]](README.md#documentation-for-models) [[Back to README]](README.md)

# **postSubmodelElementUnderPath**
> SubmodelElement postSubmodelElementUnderPath(submodelElement)


### Example


```typescript
import {  } from '';
import * as fs from 'fs';

const configuration = .createConfiguration();
const apiInstance = new .SubmodelRepositoryApi(configuration);

let body:.SubmodelRepositoryApiPostSubmodelElementUnderPathRequest = {
  // string | The Submodel’s unique id (UTF8-BASE64-URL-encoded)
  submodelIdentifier: 'YQ==',
  // string | IdShort path to the submodel element (dot-separated)
  idShortPath: "idShortPath_example",
  // SubmodelElement | Requested submodel element
  submodelElement: null,
};

apiInstance.postSubmodelElementUnderPath(body).then((data:any) => {
  console.log('API called successfully. Returned data: ' + data);
}).catch((error:any) => console.error(error));
```


### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **submodelElement** | **SubmodelElement**| Requested submodel element |
 **submodelIdentifier** | [**string**] | The Submodel’s unique id (UTF8-BASE64-URL-encoded) | defaults to undefined
 **idShortPath** | [**string**] | IdShort path to the submodel element (dot-separated) | defaults to undefined


### Return type

**SubmodelElement**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**201** | Submodel element created successfully |  * Location - URL of the newly created resource <br>  |
**400** | Bad Request, e.g. the request parameters of the format of the request body is wrong. |  -  |
**401** | Unauthorized, e.g. the server refused the authorization attempt. |  -  |
**403** | Forbidden |  -  |
**404** | Not Found |  -  |
**409** | Conflict, a resource which shall be created exists already. Might be thrown if a Submodel or SubmodelElement with the same ShortId is contained in a POST request. |  -  |
**500** | Internal Server Error |  -  |
**0** | Default error handling for unmentioned status codes |  -  |

[[Back to top]](#) [[Back to API list]](README.md#documentation-for-api-endpoints) [[Back to Model list]](README.md#documentation-for-models) [[Back to README]](README.md)

# **putFileAttachment**
> void putFileAttachment()


### Example


```typescript
import {  } from '';
import * as fs from 'fs';

const configuration = .createConfiguration();
const apiInstance = new .SubmodelRepositoryApi(configuration);

let body:.SubmodelRepositoryApiPutFileAttachmentRequest = {
  // string | The Submodel’s unique id (UTF8-BASE64-URL-encoded)
  submodelIdentifier: 'YQ==',
  // string | IdShort path to the submodel element (dot-separated)
  idShortPath: "idShortPath_example",
  // string (optional)
  fileName: "fileName_example",
  // HttpFile (optional)
  file: { data: Buffer.from(fs.readFileSync('/path/to/file', 'utf-8')), name: '/path/to/file' },
};

apiInstance.putFileAttachment(body).then((data:any) => {
  console.log('API called successfully. Returned data: ' + data);
}).catch((error:any) => console.error(error));
```


### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **submodelIdentifier** | [**string**] | The Submodel’s unique id (UTF8-BASE64-URL-encoded) | defaults to undefined
 **idShortPath** | [**string**] | IdShort path to the submodel element (dot-separated) | defaults to undefined
 **fileName** | [**string**] |  | (optional) defaults to undefined
 **file** | [**HttpFile**] |  | (optional) defaults to undefined


### Return type

**void**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: multipart/form-data
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**204** | Submodel element updated successfully |  -  |
**400** | Bad Request, e.g. the request parameters of the format of the request body is wrong. |  -  |
**401** | Unauthorized, e.g. the server refused the authorization attempt. |  -  |
**403** | Forbidden |  -  |
**404** | Not Found |  -  |
**405** | Method not allowed - Upload only valid for File submodel element |  -  |
**500** | Internal Server Error |  -  |
**0** | Default error handling for unmentioned status codes |  -  |

[[Back to top]](#) [[Back to API list]](README.md#documentation-for-api-endpoints) [[Back to Model list]](README.md#documentation-for-models) [[Back to README]](README.md)

# **putSubmodel**
> void putSubmodel(submodel)


### Example


```typescript
import {  } from '';
import * as fs from 'fs';

const configuration = .createConfiguration();
const apiInstance = new .SubmodelRepositoryApi(configuration);

let body:.SubmodelRepositoryApiPutSubmodelRequest = {
  // string | The Submodel’s unique id (UTF8-BASE64-URL-encoded)
  submodelIdentifier: 'YQ==',
  // Submodel | Submodel object
  submodel: null,
};

apiInstance.putSubmodel(body).then((data:any) => {
  console.log('API called successfully. Returned data: ' + data);
}).catch((error:any) => console.error(error));
```


### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **submodel** | **Submodel**| Submodel object |
 **submodelIdentifier** | [**string**] | The Submodel’s unique id (UTF8-BASE64-URL-encoded) | defaults to undefined


### Return type

**void**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**204** | Submodel updated successfully |  -  |
**400** | Bad Request, e.g. the request parameters of the format of the request body is wrong. |  -  |
**401** | Unauthorized, e.g. the server refused the authorization attempt. |  -  |
**403** | Forbidden |  -  |
**404** | Not Found |  -  |
**500** | Internal Server Error |  -  |
**0** | Default error handling for unmentioned status codes |  -  |

[[Back to top]](#) [[Back to API list]](README.md#documentation-for-api-endpoints) [[Back to Model list]](README.md#documentation-for-models) [[Back to README]](README.md)

# **putSubmodelElement**
> void putSubmodelElement(submodelElement)


### Example


```typescript
import {  } from '';
import * as fs from 'fs';

const configuration = .createConfiguration();
const apiInstance = new .SubmodelRepositoryApi(configuration);

let body:.SubmodelRepositoryApiPutSubmodelElementRequest = {
  // string | The Submodel’s unique id (UTF8-BASE64-URL-encoded)
  submodelIdentifier: 'YQ==',
  // string | IdShort path to the submodel element (dot-separated)
  idShortPath: "idShortPath_example",
  // SubmodelElement | Requested submodel element
  submodelElement: null,
  // 'deep' | Determines the structural depth of the respective resource content (optional)
  level: "deep",
};

apiInstance.putSubmodelElement(body).then((data:any) => {
  console.log('API called successfully. Returned data: ' + data);
}).catch((error:any) => console.error(error));
```


### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **submodelElement** | **SubmodelElement**| Requested submodel element |
 **submodelIdentifier** | [**string**] | The Submodel’s unique id (UTF8-BASE64-URL-encoded) | defaults to undefined
 **idShortPath** | [**string**] | IdShort path to the submodel element (dot-separated) | defaults to undefined
 **level** | [**&#39;deep&#39;**]**Array<&#39;deep&#39;>** | Determines the structural depth of the respective resource content | (optional) defaults to 'deep'


### Return type

**void**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**204** | Submodel element updated successfully |  -  |
**400** | Bad Request, e.g. the request parameters of the format of the request body is wrong. |  -  |
**401** | Unauthorized, e.g. the server refused the authorization attempt. |  -  |
**403** | Forbidden |  -  |
**404** | Not Found |  -  |
**500** | Internal Server Error |  -  |
**0** | Default error handling for unmentioned status codes |  -  |

[[Back to top]](#) [[Back to API list]](README.md#documentation-for-api-endpoints) [[Back to Model list]](README.md#documentation-for-models) [[Back to README]](README.md)


