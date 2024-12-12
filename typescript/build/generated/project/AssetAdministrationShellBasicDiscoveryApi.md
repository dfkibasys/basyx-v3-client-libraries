# .AssetAdministrationShellBasicDiscoveryApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**deleteAssetLinksByShellId**](AssetAdministrationShellBasicDiscoveryApi.md#deleteAssetLinksByShellId) | **DELETE** /lookup/shells/{aasIdentifier} | Deletes all specific Asset identifiers linked to an Asset Administration Shell to edit discoverable content
[**getAllShellIdsByAssetLinks**](AssetAdministrationShellBasicDiscoveryApi.md#getAllShellIdsByAssetLinks) | **GET** /lookup/shells | Returns a list of Asset Administration Shell ids linked to specific Asset identifiers
[**getAssetLinksByShellId**](AssetAdministrationShellBasicDiscoveryApi.md#getAssetLinksByShellId) | **GET** /lookup/shells/{aasIdentifier} | Returns a list of specific Asset identifiers based on an Asset Administration Shell id to edit discoverable content
[**getDescription**](AssetAdministrationShellBasicDiscoveryApi.md#getDescription) | **GET** /description | Returns the self-describing information of a network resource (ServiceDescription)
[**postAssetLinksByShellId**](AssetAdministrationShellBasicDiscoveryApi.md#postAssetLinksByShellId) | **POST** /lookup/shells/{aasIdentifier} | Creates specific Asset identifiers linked to an Asset Administration Shell to edit discoverable content


# **deleteAssetLinksByShellId**
> void deleteAssetLinksByShellId()


### Example


```typescript
import {  } from '';
import * as fs from 'fs';

const configuration = .createConfiguration();
const apiInstance = new .AssetAdministrationShellBasicDiscoveryApi(configuration);

let body:.AssetAdministrationShellBasicDiscoveryApiDeleteAssetLinksByShellIdRequest = {
  // string | The Asset Administration Shell’s unique id (UTF8-BASE64-URL-encoded)
  aasIdentifier: 'YQ==',
};

apiInstance.deleteAssetLinksByShellId(body).then((data:any) => {
  console.log('API called successfully. Returned data: ' + data);
}).catch((error:any) => console.error(error));
```


### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **aasIdentifier** | [**string**] | The Asset Administration Shell’s unique id (UTF8-BASE64-URL-encoded) | defaults to undefined


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
**204** | Specific Asset identifiers deleted successfully |  -  |
**404** | Not Found |  -  |
**0** | Default error handling for unmentioned status codes |  -  |

[[Back to top]](#) [[Back to API list]](README.md#documentation-for-api-endpoints) [[Back to Model list]](README.md#documentation-for-models) [[Back to README]](README.md)

# **getAllShellIdsByAssetLinks**
> GetAllAssetLinksResult getAllShellIdsByAssetLinks()


### Example


```typescript
import {  } from '';
import * as fs from 'fs';

const configuration = .createConfiguration();
const apiInstance = new .AssetAdministrationShellBasicDiscoveryApi(configuration);

let body:.AssetAdministrationShellBasicDiscoveryApiGetAllShellIdsByAssetLinksRequest = {
  // Array<SpecificAssetId> | A list of specific Asset identifiers. Each Asset identifier is a base64-url-encoded [SpecificAssetId](./model-part1.yaml#/components/schemas/SpecificAssetId) (optional)
  assetIds: [
    null,
  ],
  // number | The maximum number of elements in the response array (optional)
  limit: 1,
  // string | A server-generated identifier retrieved from pagingMetadata that specifies from which position the result listing should continue (optional)
  cursor: "cursor_example",
};

apiInstance.getAllShellIdsByAssetLinks(body).then((data:any) => {
  console.log('API called successfully. Returned data: ' + data);
}).catch((error:any) => console.error(error));
```


### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **assetIds** | **Array&lt;SpecificAssetId&gt;** | A list of specific Asset identifiers. Each Asset identifier is a base64-url-encoded [SpecificAssetId](./model-part1.yaml#/components/schemas/SpecificAssetId) | (optional) defaults to undefined
 **limit** | [**number**] | The maximum number of elements in the response array | (optional) defaults to undefined
 **cursor** | [**string**] | A server-generated identifier retrieved from pagingMetadata that specifies from which position the result listing should continue | (optional) defaults to undefined


### Return type

**GetAllAssetLinksResult**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Requested Asset Administration Shell ids |  -  |
**0** | Default error handling for unmentioned status codes |  -  |

[[Back to top]](#) [[Back to API list]](README.md#documentation-for-api-endpoints) [[Back to Model list]](README.md#documentation-for-models) [[Back to README]](README.md)

# **getAssetLinksByShellId**
> Array<SpecificAssetId> getAssetLinksByShellId()


### Example


```typescript
import {  } from '';
import * as fs from 'fs';

const configuration = .createConfiguration();
const apiInstance = new .AssetAdministrationShellBasicDiscoveryApi(configuration);

let body:.AssetAdministrationShellBasicDiscoveryApiGetAssetLinksByShellIdRequest = {
  // string | The Asset Administration Shell’s unique id (UTF8-BASE64-URL-encoded)
  aasIdentifier: 'YQ==',
};

apiInstance.getAssetLinksByShellId(body).then((data:any) => {
  console.log('API called successfully. Returned data: ' + data);
}).catch((error:any) => console.error(error));
```


### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **aasIdentifier** | [**string**] | The Asset Administration Shell’s unique id (UTF8-BASE64-URL-encoded) | defaults to undefined


### Return type

**Array<SpecificAssetId>**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Requested specific Asset identifiers |  -  |
**404** | Not Found |  -  |
**0** | Default error handling for unmentioned status codes |  -  |

[[Back to top]](#) [[Back to API list]](README.md#documentation-for-api-endpoints) [[Back to Model list]](README.md#documentation-for-models) [[Back to README]](README.md)

# **getDescription**
> ServiceDescription getDescription()


### Example


```typescript
import {  } from '';
import * as fs from 'fs';

const configuration = .createConfiguration();
const apiInstance = new .AssetAdministrationShellBasicDiscoveryApi(configuration);

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
**0** | Default error handling for unmentioned status codes |  -  |

[[Back to top]](#) [[Back to API list]](README.md#documentation-for-api-endpoints) [[Back to Model list]](README.md#documentation-for-models) [[Back to README]](README.md)

# **postAssetLinksByShellId**
> Array<SpecificAssetId> postAssetLinksByShellId(specificAssetId)


### Example


```typescript
import {  } from '';
import * as fs from 'fs';

const configuration = .createConfiguration();
const apiInstance = new .AssetAdministrationShellBasicDiscoveryApi(configuration);

let body:.AssetAdministrationShellBasicDiscoveryApiPostAssetLinksByShellIdRequest = {
  // string | The Asset Administration Shell’s unique id (UTF8-BASE64-URL-encoded)
  aasIdentifier: 'YQ==',
  // Array<SpecificAssetId> | A list of specific Asset identifiers
  specificAssetId: [
    null,
  ],
};

apiInstance.postAssetLinksByShellId(body).then((data:any) => {
  console.log('API called successfully. Returned data: ' + data);
}).catch((error:any) => console.error(error));
```


### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **specificAssetId** | **Array<SpecificAssetId>**| A list of specific Asset identifiers |
 **aasIdentifier** | [**string**] | The Asset Administration Shell’s unique id (UTF8-BASE64-URL-encoded) | defaults to undefined


### Return type

**Array<SpecificAssetId>**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**201** | Specific Asset identifiers created successfully |  -  |
**400** | Bad Request, e.g. the request parameters of the format of the request body is wrong. |  -  |
**404** | Not Found |  -  |
**409** | Conflict, a resource which shall be created exists already. Might be thrown if a Submodel or SubmodelElement with the same ShortId is contained in a POST request. |  -  |
**0** | Default error handling for unmentioned status codes |  -  |

[[Back to top]](#) [[Back to API list]](README.md#documentation-for-api-endpoints) [[Back to Model list]](README.md#documentation-for-models) [[Back to README]](README.md)


