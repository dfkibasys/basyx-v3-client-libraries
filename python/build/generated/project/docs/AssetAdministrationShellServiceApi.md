# basyxclients.AssetAdministrationShellServiceApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**delete_file_by_path**](AssetAdministrationShellServiceApi.md#delete_file_by_path) | **DELETE** /submodels/{submodelIdentifier}/submodel-elements/{idShortPath}/attachment | Deletes file content of an existing submodel element at a specified path within submodel elements hierarchy
[**delete_submodel_by_id**](AssetAdministrationShellServiceApi.md#delete_submodel_by_id) | **DELETE** /submodels/{submodelIdentifier} | Deletes the submodel from the Asset Administration Shell.
[**delete_submodel_element_by_path**](AssetAdministrationShellServiceApi.md#delete_submodel_element_by_path) | **DELETE** /submodels/{submodelIdentifier}/submodel-elements/{idShortPath} | Deletes a submodel element at a specified path within the submodel elements hierarchy
[**delete_submodel_reference_by_id**](AssetAdministrationShellServiceApi.md#delete_submodel_reference_by_id) | **DELETE** /submodel-refs/{submodelIdentifier} | Deletes the submodel reference from the Asset Administration Shell. Does not delete the submodel itself!
[**delete_thumbnail**](AssetAdministrationShellServiceApi.md#delete_thumbnail) | **DELETE** /assetinformation/thumbnail | 
[**generate_serialization_by_ids**](AssetAdministrationShellServiceApi.md#generate_serialization_by_ids) | **GET** /serialization | Returns an appropriate serialization based on the specified format (see SerializationFormat)
[**get_all_submodel_elements**](AssetAdministrationShellServiceApi.md#get_all_submodel_elements) | **GET** /submodels/{submodelIdentifier}/submodel-elements | Returns all submodel elements including their hierarchy
[**get_all_submodel_elements_metadata**](AssetAdministrationShellServiceApi.md#get_all_submodel_elements_metadata) | **GET** /submodels/{submodelIdentifier}/submodel-elements/$metadata | Returns all submodel elements including their hierarchy
[**get_all_submodel_elements_path**](AssetAdministrationShellServiceApi.md#get_all_submodel_elements_path) | **GET** /submodels/{submodelIdentifier}/submodel-elements/$path | Returns all submodel elements including their hierarchy
[**get_all_submodel_elements_reference**](AssetAdministrationShellServiceApi.md#get_all_submodel_elements_reference) | **GET** /submodels/{submodelIdentifier}/submodel-elements/$reference | Returns all submodel elements as a list of References
[**get_all_submodel_elements_value_only**](AssetAdministrationShellServiceApi.md#get_all_submodel_elements_value_only) | **GET** /submodels/{submodelIdentifier}/submodel-elements/$value | Returns all submodel elements including their hierarchy in the ValueOnly representation
[**get_all_submodel_references**](AssetAdministrationShellServiceApi.md#get_all_submodel_references) | **GET** /submodel-refs | Returns all submodel references
[**get_asset_administration_shell**](AssetAdministrationShellServiceApi.md#get_asset_administration_shell) | **GET** / | Returns a specific Asset Administration Shell
[**get_asset_administration_shell_reference**](AssetAdministrationShellServiceApi.md#get_asset_administration_shell_reference) | **GET** /$reference | Returns a specific Asset Administration Shell as a Reference
[**get_asset_information**](AssetAdministrationShellServiceApi.md#get_asset_information) | **GET** /assetinformation | Returns the Asset Information
[**get_description**](AssetAdministrationShellServiceApi.md#get_description) | **GET** /description | Returns the self-describing information of a network resource (ServiceDescription)
[**get_file_by_path**](AssetAdministrationShellServiceApi.md#get_file_by_path) | **GET** /submodels/{submodelIdentifier}/submodel-elements/{idShortPath}/attachment | Downloads file content from a specific submodel element from the Submodel at a specified path
[**get_operation_async_result**](AssetAdministrationShellServiceApi.md#get_operation_async_result) | **GET** /submodels/{submodelIdentifier}/submodel-elements/{idShortPath}/operation-results/{handleId} | Returns the Operation result of an asynchronous invoked Operation
[**get_operation_async_result_value_only**](AssetAdministrationShellServiceApi.md#get_operation_async_result_value_only) | **GET** /submodels/{submodelIdentifier}/submodel-elements/{idShortPath}/operation-results/{handleId}/$value | Returns the value of the Operation result of an asynchronous invoked Operation
[**get_operation_async_status**](AssetAdministrationShellServiceApi.md#get_operation_async_status) | **GET** /submodels/{submodelIdentifier}/submodel-elements/{idShortPath}/operation-status/{handleId} | Returns the status of an asynchronously invoked Operation
[**get_submodel**](AssetAdministrationShellServiceApi.md#get_submodel) | **GET** /submodels/{submodelIdentifier} | Returns the Submodel
[**get_submodel_element_by_path**](AssetAdministrationShellServiceApi.md#get_submodel_element_by_path) | **GET** /submodels/{submodelIdentifier}/submodel-elements/{idShortPath} | Returns a specific submodel element from the Submodel at a specified path
[**get_submodel_element_by_path_metadata**](AssetAdministrationShellServiceApi.md#get_submodel_element_by_path_metadata) | **GET** /submodels/{submodelIdentifier}/submodel-elements/{idShortPath}/$metadata | Returns the metadata attributes if a specific submodel element from the Submodel at a specified path
[**get_submodel_element_by_path_path**](AssetAdministrationShellServiceApi.md#get_submodel_element_by_path_path) | **GET** /submodels/{submodelIdentifier}/submodel-elements/{idShortPath}/$path | Returns a specific submodel element from the Submodel at a specified path in the Path notation
[**get_submodel_element_by_path_reference**](AssetAdministrationShellServiceApi.md#get_submodel_element_by_path_reference) | **GET** /submodels/{submodelIdentifier}/submodel-elements/{idShortPath}/$reference | Returns the Reference of a specific submodel element from the Submodel at a specified path in the ValueOnly representation
[**get_submodel_element_by_path_value_only**](AssetAdministrationShellServiceApi.md#get_submodel_element_by_path_value_only) | **GET** /submodels/{submodelIdentifier}/submodel-elements/{idShortPath}/$value | Returns a specific submodel element from the Submodel at a specified path in the ValueOnly representation
[**get_submodel_metadata**](AssetAdministrationShellServiceApi.md#get_submodel_metadata) | **GET** /submodels/{submodelIdentifier}/$metadata | Returns the Submodel&#39;s metadata elements
[**get_submodel_metadata_reference**](AssetAdministrationShellServiceApi.md#get_submodel_metadata_reference) | **GET** /submodels/{submodelIdentifier}/$reference | Returns the Submodel as a Reference
[**get_submodel_path**](AssetAdministrationShellServiceApi.md#get_submodel_path) | **GET** /submodels/{submodelIdentifier}/$path | Returns the Submodel&#39;s metadata elements
[**get_submodel_value_only**](AssetAdministrationShellServiceApi.md#get_submodel_value_only) | **GET** /submodels/{submodelIdentifier}/$value | Returns the Submodel&#39;s ValueOnly representation
[**get_thumbnail**](AssetAdministrationShellServiceApi.md#get_thumbnail) | **GET** /assetinformation/thumbnail | 
[**invoke_operation_async**](AssetAdministrationShellServiceApi.md#invoke_operation_async) | **POST** /submodels/{submodelIdentifier}/submodel-elements/{idShortPath}/invoke-asnyc | Asynchronously invokes an Operation at a specified path
[**invoke_operation_async_value_only**](AssetAdministrationShellServiceApi.md#invoke_operation_async_value_only) | **POST** /submodels/{submodelIdentifier}/submodel-elements/{idShortPath}/invoke-async/$value | Asynchronously invokes an Operation at a specified path
[**invoke_operation_sync**](AssetAdministrationShellServiceApi.md#invoke_operation_sync) | **POST** /submodels/{submodelIdentifier}/submodel-elements/{idShortPath}/invoke | Synchronously invokes an Operation at a specified path
[**invoke_operation_sync_value_only**](AssetAdministrationShellServiceApi.md#invoke_operation_sync_value_only) | **POST** /submodels/{submodelIdentifier}/submodel-elements/{idShortPath}/invoke/$value | Synchronously invokes an Operation at a specified path
[**patch_submodel**](AssetAdministrationShellServiceApi.md#patch_submodel) | **PATCH** /submodels/{submodelIdentifier} | Updates the Submodel
[**patch_submodel_element_value_by_path**](AssetAdministrationShellServiceApi.md#patch_submodel_element_value_by_path) | **PATCH** /submodels/{submodelIdentifier}/submodel-elements/{idShortPath} | Updates an existing submodel element value at a specified path within submodel elements hierarchy
[**patch_submodel_element_value_by_path_metadata**](AssetAdministrationShellServiceApi.md#patch_submodel_element_value_by_path_metadata) | **PATCH** /submodels/{submodelIdentifier}/submodel-elements/{idShortPath}/$metadata | Updates the metadata attributes of an existing submodel element value at a specified path within submodel elements hierarchy
[**patch_submodel_element_value_by_path_value_only**](AssetAdministrationShellServiceApi.md#patch_submodel_element_value_by_path_value_only) | **PATCH** /submodels/{submodelIdentifier}/submodel-elements/{idShortPath}/$value | Updates the value of an existing submodel element value at a specified path within submodel elements hierarchy
[**patch_submodel_metadata**](AssetAdministrationShellServiceApi.md#patch_submodel_metadata) | **PATCH** /submodels/{submodelIdentifier}/$metadata | Updates the metadata attributes of the Submodel
[**patch_submodel_value_only**](AssetAdministrationShellServiceApi.md#patch_submodel_value_only) | **PATCH** /submodels/{submodelIdentifier}/$value | Updates teh values of the Submodel
[**post_submodel_element**](AssetAdministrationShellServiceApi.md#post_submodel_element) | **POST** /submodels/{submodelIdentifier}/submodel-elements | Creates a new submodel element
[**post_submodel_element_by_path**](AssetAdministrationShellServiceApi.md#post_submodel_element_by_path) | **POST** /submodels/{submodelIdentifier}/submodel-elements/{idShortPath} | Creates a new submodel element at a specified path within submodel elements hierarchy
[**post_submodel_reference**](AssetAdministrationShellServiceApi.md#post_submodel_reference) | **POST** /submodel-refs | Creates a submodel reference at the Asset Administration Shell
[**put_asset_administration_shell**](AssetAdministrationShellServiceApi.md#put_asset_administration_shell) | **PUT** / | Updates an existing Asset Administration Shell
[**put_asset_information**](AssetAdministrationShellServiceApi.md#put_asset_information) | **PUT** /assetinformation | Updates the Asset Information
[**put_file_by_path**](AssetAdministrationShellServiceApi.md#put_file_by_path) | **PUT** /submodels/{submodelIdentifier}/submodel-elements/{idShortPath}/attachment | Uploads file content to an existing submodel element at a specified path within submodel elements hierarchy
[**put_submodel**](AssetAdministrationShellServiceApi.md#put_submodel) | **PUT** /submodels/{submodelIdentifier} | Updates the Submodel
[**put_submodel_element_by_path**](AssetAdministrationShellServiceApi.md#put_submodel_element_by_path) | **PUT** /submodels/{submodelIdentifier}/submodel-elements/{idShortPath} | Updates an existing submodel element at a specified path within submodel elements hierarchy
[**put_thumbnail**](AssetAdministrationShellServiceApi.md#put_thumbnail) | **PUT** /assetinformation/thumbnail | 


# **delete_file_by_path**
> delete_file_by_path(submodel_identifier, id_short_path)

Deletes file content of an existing submodel element at a specified path within submodel elements hierarchy

### Example


```python
import basyxclients
from basyxclients.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost
# See configuration.py for a list of all supported configuration parameters.
configuration = basyxclients.Configuration(
    host = "http://localhost"
)


# Enter a context with an instance of the API client
with basyxclients.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = basyxclients.AssetAdministrationShellServiceApi(api_client)
    submodel_identifier = None # bytearray | The Submodel’s unique id (UTF8-BASE64-URL-encoded)
    id_short_path = 'id_short_path_example' # str | IdShort path to the submodel element (dot-separated)

    try:
        # Deletes file content of an existing submodel element at a specified path within submodel elements hierarchy
        api_instance.delete_file_by_path(submodel_identifier, id_short_path)
    except Exception as e:
        print("Exception when calling AssetAdministrationShellServiceApi->delete_file_by_path: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **submodel_identifier** | **bytearray**| The Submodel’s unique id (UTF8-BASE64-URL-encoded) | 
 **id_short_path** | **str**| IdShort path to the submodel element (dot-separated) | 

### Return type

void (empty response body)

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

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **delete_submodel_by_id**
> delete_submodel_by_id(submodel_identifier)

Deletes the submodel from the Asset Administration Shell.

### Example


```python
import basyxclients
from basyxclients.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost
# See configuration.py for a list of all supported configuration parameters.
configuration = basyxclients.Configuration(
    host = "http://localhost"
)


# Enter a context with an instance of the API client
with basyxclients.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = basyxclients.AssetAdministrationShellServiceApi(api_client)
    submodel_identifier = None # bytearray | The Submodel’s unique id (UTF8-BASE64-URL-encoded)

    try:
        # Deletes the submodel from the Asset Administration Shell.
        api_instance.delete_submodel_by_id(submodel_identifier)
    except Exception as e:
        print("Exception when calling AssetAdministrationShellServiceApi->delete_submodel_by_id: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **submodel_identifier** | **bytearray**| The Submodel’s unique id (UTF8-BASE64-URL-encoded) | 

### Return type

void (empty response body)

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

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **delete_submodel_element_by_path**
> delete_submodel_element_by_path(submodel_identifier, id_short_path)

Deletes a submodel element at a specified path within the submodel elements hierarchy

### Example


```python
import basyxclients
from basyxclients.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost
# See configuration.py for a list of all supported configuration parameters.
configuration = basyxclients.Configuration(
    host = "http://localhost"
)


# Enter a context with an instance of the API client
with basyxclients.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = basyxclients.AssetAdministrationShellServiceApi(api_client)
    submodel_identifier = None # bytearray | The Submodel’s unique id (UTF8-BASE64-URL-encoded)
    id_short_path = 'id_short_path_example' # str | IdShort path to the submodel element (dot-separated)

    try:
        # Deletes a submodel element at a specified path within the submodel elements hierarchy
        api_instance.delete_submodel_element_by_path(submodel_identifier, id_short_path)
    except Exception as e:
        print("Exception when calling AssetAdministrationShellServiceApi->delete_submodel_element_by_path: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **submodel_identifier** | **bytearray**| The Submodel’s unique id (UTF8-BASE64-URL-encoded) | 
 **id_short_path** | **str**| IdShort path to the submodel element (dot-separated) | 

### Return type

void (empty response body)

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

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **delete_submodel_reference_by_id**
> delete_submodel_reference_by_id(submodel_identifier)

Deletes the submodel reference from the Asset Administration Shell. Does not delete the submodel itself!

### Example


```python
import basyxclients
from basyxclients.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost
# See configuration.py for a list of all supported configuration parameters.
configuration = basyxclients.Configuration(
    host = "http://localhost"
)


# Enter a context with an instance of the API client
with basyxclients.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = basyxclients.AssetAdministrationShellServiceApi(api_client)
    submodel_identifier = None # bytearray | The Submodel’s unique id (UTF8-BASE64-URL-encoded)

    try:
        # Deletes the submodel reference from the Asset Administration Shell. Does not delete the submodel itself!
        api_instance.delete_submodel_reference_by_id(submodel_identifier)
    except Exception as e:
        print("Exception when calling AssetAdministrationShellServiceApi->delete_submodel_reference_by_id: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **submodel_identifier** | **bytearray**| The Submodel’s unique id (UTF8-BASE64-URL-encoded) | 

### Return type

void (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**204** | Submodel reference deleted successfully |  -  |
**400** | Bad Request, e.g. the request parameters of the format of the request body is wrong. |  -  |
**401** | Unauthorized, e.g. the server refused the authorization attempt. |  -  |
**403** | Forbidden |  -  |
**404** | Not Found |  -  |
**500** | Internal Server Error |  -  |
**0** | Default error handling for unmentioned status codes |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **delete_thumbnail**
> delete_thumbnail()

### Example


```python
import basyxclients
from basyxclients.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost
# See configuration.py for a list of all supported configuration parameters.
configuration = basyxclients.Configuration(
    host = "http://localhost"
)


# Enter a context with an instance of the API client
with basyxclients.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = basyxclients.AssetAdministrationShellServiceApi(api_client)

    try:
        api_instance.delete_thumbnail()
    except Exception as e:
        print("Exception when calling AssetAdministrationShellServiceApi->delete_thumbnail: %s\n" % e)
```



### Parameters

This endpoint does not need any parameter.

### Return type

void (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Thumbnail deletion successful |  -  |
**400** | Bad Request, e.g. the request parameters of the format of the request body is wrong. |  -  |
**401** | Unauthorized, e.g. the server refused the authorization attempt. |  -  |
**403** | Forbidden |  -  |
**404** | Not Found |  -  |
**500** | Internal Server Error |  -  |
**0** | Default error handling for unmentioned status codes |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **generate_serialization_by_ids**
> bytearray generate_serialization_by_ids(aas_ids=aas_ids, submodel_ids=submodel_ids, include_concept_descriptions=include_concept_descriptions)

Returns an appropriate serialization based on the specified format (see SerializationFormat)

### Example


```python
import basyxclients
from basyxclients.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost
# See configuration.py for a list of all supported configuration parameters.
configuration = basyxclients.Configuration(
    host = "http://localhost"
)


# Enter a context with an instance of the API client
with basyxclients.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = basyxclients.AssetAdministrationShellServiceApi(api_client)
    aas_ids = ['aas_ids_example'] # List[str] | The Asset Administration Shells' unique ids (UTF8-BASE64-URL-encoded) (optional)
    submodel_ids = ['submodel_ids_example'] # List[str] | The Submodels' unique ids (UTF8-BASE64-URL-encoded) (optional)
    include_concept_descriptions = True # bool | Include Concept Descriptions? (optional) (default to True)

    try:
        # Returns an appropriate serialization based on the specified format (see SerializationFormat)
        api_response = api_instance.generate_serialization_by_ids(aas_ids=aas_ids, submodel_ids=submodel_ids, include_concept_descriptions=include_concept_descriptions)
        print("The response of AssetAdministrationShellServiceApi->generate_serialization_by_ids:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling AssetAdministrationShellServiceApi->generate_serialization_by_ids: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **aas_ids** | [**List[str]**](str.md)| The Asset Administration Shells&#39; unique ids (UTF8-BASE64-URL-encoded) | [optional] 
 **submodel_ids** | [**List[str]**](str.md)| The Submodels&#39; unique ids (UTF8-BASE64-URL-encoded) | [optional] 
 **include_concept_descriptions** | **bool**| Include Concept Descriptions? | [optional] [default to True]

### Return type

**bytearray**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/asset-administration-shell-package+xml, application/json, application/xml

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Requested serialization based on SerializationFormat |  -  |
**400** | Bad Request, e.g. the request parameters of the format of the request body is wrong. |  -  |
**401** | Unauthorized, e.g. the server refused the authorization attempt. |  -  |
**403** | Forbidden |  -  |
**404** | Not Found |  -  |
**500** | Internal Server Error |  -  |
**0** | Default error handling for unmentioned status codes |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_all_submodel_elements**
> GetSubmodelElementsResult get_all_submodel_elements(submodel_identifier, limit=limit, cursor=cursor, level=level, extent=extent)

Returns all submodel elements including their hierarchy

### Example


```python
import basyxclients
from basyxclients.models.get_submodel_elements_result import GetSubmodelElementsResult
from basyxclients.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost
# See configuration.py for a list of all supported configuration parameters.
configuration = basyxclients.Configuration(
    host = "http://localhost"
)


# Enter a context with an instance of the API client
with basyxclients.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = basyxclients.AssetAdministrationShellServiceApi(api_client)
    submodel_identifier = None # bytearray | The Submodel’s unique id (UTF8-BASE64-URL-encoded)
    limit = 56 # int | The maximum number of elements in the response array (optional)
    cursor = 'cursor_example' # str | A server-generated identifier retrieved from pagingMetadata that specifies from which position the result listing should continue (optional)
    level = deep # str | Determines the structural depth of the respective resource content (optional) (default to deep)
    extent = withoutBlobValue # str | Determines to which extent the resource is being serialized (optional) (default to withoutBlobValue)

    try:
        # Returns all submodel elements including their hierarchy
        api_response = api_instance.get_all_submodel_elements(submodel_identifier, limit=limit, cursor=cursor, level=level, extent=extent)
        print("The response of AssetAdministrationShellServiceApi->get_all_submodel_elements:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling AssetAdministrationShellServiceApi->get_all_submodel_elements: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **submodel_identifier** | **bytearray**| The Submodel’s unique id (UTF8-BASE64-URL-encoded) | 
 **limit** | **int**| The maximum number of elements in the response array | [optional] 
 **cursor** | **str**| A server-generated identifier retrieved from pagingMetadata that specifies from which position the result listing should continue | [optional] 
 **level** | **str**| Determines the structural depth of the respective resource content | [optional] [default to deep]
 **extent** | **str**| Determines to which extent the resource is being serialized | [optional] [default to withoutBlobValue]

### Return type

[**GetSubmodelElementsResult**](GetSubmodelElementsResult.md)

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

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_all_submodel_elements_metadata**
> GetSubmodelElementsMetadataResult get_all_submodel_elements_metadata(submodel_identifier, limit=limit, cursor=cursor, level=level)

Returns all submodel elements including their hierarchy

### Example


```python
import basyxclients
from basyxclients.models.get_submodel_elements_metadata_result import GetSubmodelElementsMetadataResult
from basyxclients.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost
# See configuration.py for a list of all supported configuration parameters.
configuration = basyxclients.Configuration(
    host = "http://localhost"
)


# Enter a context with an instance of the API client
with basyxclients.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = basyxclients.AssetAdministrationShellServiceApi(api_client)
    submodel_identifier = None # bytearray | The Submodel’s unique id (UTF8-BASE64-URL-encoded)
    limit = 56 # int | The maximum number of elements in the response array (optional)
    cursor = 'cursor_example' # str | A server-generated identifier retrieved from pagingMetadata that specifies from which position the result listing should continue (optional)
    level = deep # str | Determines the structural depth of the respective resource content (optional) (default to deep)

    try:
        # Returns all submodel elements including their hierarchy
        api_response = api_instance.get_all_submodel_elements_metadata(submodel_identifier, limit=limit, cursor=cursor, level=level)
        print("The response of AssetAdministrationShellServiceApi->get_all_submodel_elements_metadata:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling AssetAdministrationShellServiceApi->get_all_submodel_elements_metadata: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **submodel_identifier** | **bytearray**| The Submodel’s unique id (UTF8-BASE64-URL-encoded) | 
 **limit** | **int**| The maximum number of elements in the response array | [optional] 
 **cursor** | **str**| A server-generated identifier retrieved from pagingMetadata that specifies from which position the result listing should continue | [optional] 
 **level** | **str**| Determines the structural depth of the respective resource content | [optional] [default to deep]

### Return type

[**GetSubmodelElementsMetadataResult**](GetSubmodelElementsMetadataResult.md)

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

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_all_submodel_elements_path**
> GetPathItemsResult get_all_submodel_elements_path(submodel_identifier, limit=limit, cursor=cursor, level=level)

Returns all submodel elements including their hierarchy

### Example


```python
import basyxclients
from basyxclients.models.get_path_items_result import GetPathItemsResult
from basyxclients.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost
# See configuration.py for a list of all supported configuration parameters.
configuration = basyxclients.Configuration(
    host = "http://localhost"
)


# Enter a context with an instance of the API client
with basyxclients.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = basyxclients.AssetAdministrationShellServiceApi(api_client)
    submodel_identifier = None # bytearray | The Submodel’s unique id (UTF8-BASE64-URL-encoded)
    limit = 56 # int | The maximum number of elements in the response array (optional)
    cursor = 'cursor_example' # str | A server-generated identifier retrieved from pagingMetadata that specifies from which position the result listing should continue (optional)
    level = deep # str | Determines the structural depth of the respective resource content (optional) (default to deep)

    try:
        # Returns all submodel elements including their hierarchy
        api_response = api_instance.get_all_submodel_elements_path(submodel_identifier, limit=limit, cursor=cursor, level=level)
        print("The response of AssetAdministrationShellServiceApi->get_all_submodel_elements_path:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling AssetAdministrationShellServiceApi->get_all_submodel_elements_path: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **submodel_identifier** | **bytearray**| The Submodel’s unique id (UTF8-BASE64-URL-encoded) | 
 **limit** | **int**| The maximum number of elements in the response array | [optional] 
 **cursor** | **str**| A server-generated identifier retrieved from pagingMetadata that specifies from which position the result listing should continue | [optional] 
 **level** | **str**| Determines the structural depth of the respective resource content | [optional] [default to deep]

### Return type

[**GetPathItemsResult**](GetPathItemsResult.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | List of found submodel elements in the Path notation |  -  |
**400** | Bad Request, e.g. the request parameters of the format of the request body is wrong. |  -  |
**401** | Unauthorized, e.g. the server refused the authorization attempt. |  -  |
**403** | Forbidden |  -  |
**404** | Not Found |  -  |
**500** | Internal Server Error |  -  |
**0** | Default error handling for unmentioned status codes |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_all_submodel_elements_reference**
> GetReferencesResult get_all_submodel_elements_reference(submodel_identifier, limit=limit, cursor=cursor, level=level)

Returns all submodel elements as a list of References

### Example


```python
import basyxclients
from basyxclients.models.get_references_result import GetReferencesResult
from basyxclients.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost
# See configuration.py for a list of all supported configuration parameters.
configuration = basyxclients.Configuration(
    host = "http://localhost"
)


# Enter a context with an instance of the API client
with basyxclients.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = basyxclients.AssetAdministrationShellServiceApi(api_client)
    submodel_identifier = None # bytearray | The Submodel’s unique id (UTF8-BASE64-URL-encoded)
    limit = 56 # int | The maximum number of elements in the response array (optional)
    cursor = 'cursor_example' # str | A server-generated identifier retrieved from pagingMetadata that specifies from which position the result listing should continue (optional)
    level = core # str | Determines the structural depth of the respective resource content (optional) (default to core)

    try:
        # Returns all submodel elements as a list of References
        api_response = api_instance.get_all_submodel_elements_reference(submodel_identifier, limit=limit, cursor=cursor, level=level)
        print("The response of AssetAdministrationShellServiceApi->get_all_submodel_elements_reference:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling AssetAdministrationShellServiceApi->get_all_submodel_elements_reference: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **submodel_identifier** | **bytearray**| The Submodel’s unique id (UTF8-BASE64-URL-encoded) | 
 **limit** | **int**| The maximum number of elements in the response array | [optional] 
 **cursor** | **str**| A server-generated identifier retrieved from pagingMetadata that specifies from which position the result listing should continue | [optional] 
 **level** | **str**| Determines the structural depth of the respective resource content | [optional] [default to core]

### Return type

[**GetReferencesResult**](GetReferencesResult.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | List of References of the found submodel elements |  -  |
**400** | Bad Request, e.g. the request parameters of the format of the request body is wrong. |  -  |
**401** | Unauthorized, e.g. the server refused the authorization attempt. |  -  |
**403** | Forbidden |  -  |
**404** | Not Found |  -  |
**500** | Internal Server Error |  -  |
**0** | Default error handling for unmentioned status codes |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_all_submodel_elements_value_only**
> GetSubmodelElementsValueResult get_all_submodel_elements_value_only(submodel_identifier, limit=limit, cursor=cursor, level=level, extent=extent)

Returns all submodel elements including their hierarchy in the ValueOnly representation

### Example


```python
import basyxclients
from basyxclients.models.get_submodel_elements_value_result import GetSubmodelElementsValueResult
from basyxclients.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost
# See configuration.py for a list of all supported configuration parameters.
configuration = basyxclients.Configuration(
    host = "http://localhost"
)


# Enter a context with an instance of the API client
with basyxclients.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = basyxclients.AssetAdministrationShellServiceApi(api_client)
    submodel_identifier = None # bytearray | The Submodel’s unique id (UTF8-BASE64-URL-encoded)
    limit = 56 # int | The maximum number of elements in the response array (optional)
    cursor = 'cursor_example' # str | A server-generated identifier retrieved from pagingMetadata that specifies from which position the result listing should continue (optional)
    level = deep # str | Determines the structural depth of the respective resource content (optional) (default to deep)
    extent = withoutBlobValue # str | Determines to which extent the resource is being serialized (optional) (default to withoutBlobValue)

    try:
        # Returns all submodel elements including their hierarchy in the ValueOnly representation
        api_response = api_instance.get_all_submodel_elements_value_only(submodel_identifier, limit=limit, cursor=cursor, level=level, extent=extent)
        print("The response of AssetAdministrationShellServiceApi->get_all_submodel_elements_value_only:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling AssetAdministrationShellServiceApi->get_all_submodel_elements_value_only: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **submodel_identifier** | **bytearray**| The Submodel’s unique id (UTF8-BASE64-URL-encoded) | 
 **limit** | **int**| The maximum number of elements in the response array | [optional] 
 **cursor** | **str**| A server-generated identifier retrieved from pagingMetadata that specifies from which position the result listing should continue | [optional] 
 **level** | **str**| Determines the structural depth of the respective resource content | [optional] [default to deep]
 **extent** | **str**| Determines to which extent the resource is being serialized | [optional] [default to withoutBlobValue]

### Return type

[**GetSubmodelElementsValueResult**](GetSubmodelElementsValueResult.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | List of found submodel elements in their ValueOnly representation |  -  |
**400** | Bad Request, e.g. the request parameters of the format of the request body is wrong. |  -  |
**401** | Unauthorized, e.g. the server refused the authorization attempt. |  -  |
**403** | Forbidden |  -  |
**404** | Not Found |  -  |
**500** | Internal Server Error |  -  |
**0** | Default error handling for unmentioned status codes |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_all_submodel_references**
> GetReferencesResult get_all_submodel_references(limit=limit, cursor=cursor)

Returns all submodel references

### Example


```python
import basyxclients
from basyxclients.models.get_references_result import GetReferencesResult
from basyxclients.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost
# See configuration.py for a list of all supported configuration parameters.
configuration = basyxclients.Configuration(
    host = "http://localhost"
)


# Enter a context with an instance of the API client
with basyxclients.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = basyxclients.AssetAdministrationShellServiceApi(api_client)
    limit = 56 # int | The maximum number of elements in the response array (optional)
    cursor = 'cursor_example' # str | A server-generated identifier retrieved from pagingMetadata that specifies from which position the result listing should continue (optional)

    try:
        # Returns all submodel references
        api_response = api_instance.get_all_submodel_references(limit=limit, cursor=cursor)
        print("The response of AssetAdministrationShellServiceApi->get_all_submodel_references:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling AssetAdministrationShellServiceApi->get_all_submodel_references: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **limit** | **int**| The maximum number of elements in the response array | [optional] 
 **cursor** | **str**| A server-generated identifier retrieved from pagingMetadata that specifies from which position the result listing should continue | [optional] 

### Return type

[**GetReferencesResult**](GetReferencesResult.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Requested submodel references |  -  |
**400** | Bad Request, e.g. the request parameters of the format of the request body is wrong. |  -  |
**401** | Unauthorized, e.g. the server refused the authorization attempt. |  -  |
**403** | Forbidden |  -  |
**500** | Internal Server Error |  -  |
**0** | Default error handling for unmentioned status codes |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_asset_administration_shell**
> AssetAdministrationShell get_asset_administration_shell()

Returns a specific Asset Administration Shell

### Example


```python
import basyxclients
from basyxclients.models.asset_administration_shell import AssetAdministrationShell
from basyxclients.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost
# See configuration.py for a list of all supported configuration parameters.
configuration = basyxclients.Configuration(
    host = "http://localhost"
)


# Enter a context with an instance of the API client
with basyxclients.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = basyxclients.AssetAdministrationShellServiceApi(api_client)

    try:
        # Returns a specific Asset Administration Shell
        api_response = api_instance.get_asset_administration_shell()
        print("The response of AssetAdministrationShellServiceApi->get_asset_administration_shell:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling AssetAdministrationShellServiceApi->get_asset_administration_shell: %s\n" % e)
```



### Parameters

This endpoint does not need any parameter.

### Return type

[**AssetAdministrationShell**](AssetAdministrationShell.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Requested Asset Administration Shell |  -  |
**400** | Bad Request, e.g. the request parameters of the format of the request body is wrong. |  -  |
**401** | Unauthorized, e.g. the server refused the authorization attempt. |  -  |
**403** | Forbidden |  -  |
**500** | Internal Server Error |  -  |
**0** | Default error handling for unmentioned status codes |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_asset_administration_shell_reference**
> Reference get_asset_administration_shell_reference()

Returns a specific Asset Administration Shell as a Reference

### Example


```python
import basyxclients
from basyxclients.models.reference import Reference
from basyxclients.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost
# See configuration.py for a list of all supported configuration parameters.
configuration = basyxclients.Configuration(
    host = "http://localhost"
)


# Enter a context with an instance of the API client
with basyxclients.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = basyxclients.AssetAdministrationShellServiceApi(api_client)

    try:
        # Returns a specific Asset Administration Shell as a Reference
        api_response = api_instance.get_asset_administration_shell_reference()
        print("The response of AssetAdministrationShellServiceApi->get_asset_administration_shell_reference:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling AssetAdministrationShellServiceApi->get_asset_administration_shell_reference: %s\n" % e)
```



### Parameters

This endpoint does not need any parameter.

### Return type

[**Reference**](Reference.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Requested Asset Administration Shell |  -  |
**400** | Bad Request, e.g. the request parameters of the format of the request body is wrong. |  -  |
**401** | Unauthorized, e.g. the server refused the authorization attempt. |  -  |
**403** | Forbidden |  -  |
**500** | Internal Server Error |  -  |
**0** | Default error handling for unmentioned status codes |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_asset_information**
> AssetInformation get_asset_information()

Returns the Asset Information

### Example


```python
import basyxclients
from basyxclients.models.asset_information import AssetInformation
from basyxclients.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost
# See configuration.py for a list of all supported configuration parameters.
configuration = basyxclients.Configuration(
    host = "http://localhost"
)


# Enter a context with an instance of the API client
with basyxclients.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = basyxclients.AssetAdministrationShellServiceApi(api_client)

    try:
        # Returns the Asset Information
        api_response = api_instance.get_asset_information()
        print("The response of AssetAdministrationShellServiceApi->get_asset_information:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling AssetAdministrationShellServiceApi->get_asset_information: %s\n" % e)
```



### Parameters

This endpoint does not need any parameter.

### Return type

[**AssetInformation**](AssetInformation.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Requested Asset Information |  -  |
**400** | Bad Request, e.g. the request parameters of the format of the request body is wrong. |  -  |
**401** | Unauthorized, e.g. the server refused the authorization attempt. |  -  |
**403** | Forbidden |  -  |
**500** | Internal Server Error |  -  |
**0** | Default error handling for unmentioned status codes |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_description**
> ServiceDescription get_description()

Returns the self-describing information of a network resource (ServiceDescription)

### Example


```python
import basyxclients
from basyxclients.models.service_description import ServiceDescription
from basyxclients.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost
# See configuration.py for a list of all supported configuration parameters.
configuration = basyxclients.Configuration(
    host = "http://localhost"
)


# Enter a context with an instance of the API client
with basyxclients.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = basyxclients.AssetAdministrationShellServiceApi(api_client)

    try:
        # Returns the self-describing information of a network resource (ServiceDescription)
        api_response = api_instance.get_description()
        print("The response of AssetAdministrationShellServiceApi->get_description:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling AssetAdministrationShellServiceApi->get_description: %s\n" % e)
```



### Parameters

This endpoint does not need any parameter.

### Return type

[**ServiceDescription**](ServiceDescription.md)

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

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_file_by_path**
> bytearray get_file_by_path(submodel_identifier, id_short_path)

Downloads file content from a specific submodel element from the Submodel at a specified path

### Example


```python
import basyxclients
from basyxclients.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost
# See configuration.py for a list of all supported configuration parameters.
configuration = basyxclients.Configuration(
    host = "http://localhost"
)


# Enter a context with an instance of the API client
with basyxclients.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = basyxclients.AssetAdministrationShellServiceApi(api_client)
    submodel_identifier = None # bytearray | The Submodel’s unique id (UTF8-BASE64-URL-encoded)
    id_short_path = 'id_short_path_example' # str | IdShort path to the submodel element (dot-separated)

    try:
        # Downloads file content from a specific submodel element from the Submodel at a specified path
        api_response = api_instance.get_file_by_path(submodel_identifier, id_short_path)
        print("The response of AssetAdministrationShellServiceApi->get_file_by_path:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling AssetAdministrationShellServiceApi->get_file_by_path: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **submodel_identifier** | **bytearray**| The Submodel’s unique id (UTF8-BASE64-URL-encoded) | 
 **id_short_path** | **str**| IdShort path to the submodel element (dot-separated) | 

### Return type

**bytearray**

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
**500** | Internal Server Error |  -  |
**0** | Default error handling for unmentioned status codes |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_operation_async_result**
> OperationResult get_operation_async_result(submodel_identifier, aas_identifier, id_short_path, handle_id)

Returns the Operation result of an asynchronous invoked Operation

### Example


```python
import basyxclients
from basyxclients.models.operation_result import OperationResult
from basyxclients.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost
# See configuration.py for a list of all supported configuration parameters.
configuration = basyxclients.Configuration(
    host = "http://localhost"
)


# Enter a context with an instance of the API client
with basyxclients.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = basyxclients.AssetAdministrationShellServiceApi(api_client)
    submodel_identifier = None # bytearray | The Submodel’s unique id (UTF8-BASE64-URL-encoded)
    aas_identifier = None # bytearray | The Asset Administration Shell’s unique id (UTF8-BASE64-URL-encoded)
    id_short_path = 'id_short_path_example' # str | IdShort path to the submodel element (dot-separated)
    handle_id = None # bytearray | The returned handle id of an operation's asynchronous invocation used to request the current state of the operation’s execution (UTF8-BASE64-URL-encoded)

    try:
        # Returns the Operation result of an asynchronous invoked Operation
        api_response = api_instance.get_operation_async_result(submodel_identifier, aas_identifier, id_short_path, handle_id)
        print("The response of AssetAdministrationShellServiceApi->get_operation_async_result:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling AssetAdministrationShellServiceApi->get_operation_async_result: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **submodel_identifier** | **bytearray**| The Submodel’s unique id (UTF8-BASE64-URL-encoded) | 
 **aas_identifier** | **bytearray**| The Asset Administration Shell’s unique id (UTF8-BASE64-URL-encoded) | 
 **id_short_path** | **str**| IdShort path to the submodel element (dot-separated) | 
 **handle_id** | **bytearray**| The returned handle id of an operation&#39;s asynchronous invocation used to request the current state of the operation’s execution (UTF8-BASE64-URL-encoded) | 

### Return type

[**OperationResult**](OperationResult.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Operation result object |  -  |
**400** | Bad Request, e.g. the request parameters of the format of the request body is wrong. |  -  |
**401** | Unauthorized, e.g. the server refused the authorization attempt. |  -  |
**403** | Forbidden |  -  |
**404** | Not Found |  -  |
**500** | Internal Server Error |  -  |
**0** | Default error handling for unmentioned status codes |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_operation_async_result_value_only**
> OperationResultValueOnly get_operation_async_result_value_only(submodel_identifier, aas_identifier, id_short_path, handle_id)

Returns the value of the Operation result of an asynchronous invoked Operation

### Example


```python
import basyxclients
from basyxclients.models.operation_result_value_only import OperationResultValueOnly
from basyxclients.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost
# See configuration.py for a list of all supported configuration parameters.
configuration = basyxclients.Configuration(
    host = "http://localhost"
)


# Enter a context with an instance of the API client
with basyxclients.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = basyxclients.AssetAdministrationShellServiceApi(api_client)
    submodel_identifier = None # bytearray | The Submodel’s unique id (UTF8-BASE64-URL-encoded)
    aas_identifier = None # bytearray | The Asset Administration Shell’s unique id (UTF8-BASE64-URL-encoded)
    id_short_path = 'id_short_path_example' # str | IdShort path to the submodel element (dot-separated)
    handle_id = None # bytearray | The returned handle id of an operation's asynchronous invocation used to request the current state of the operation’s execution (UTF8-BASE64-URL-encoded)

    try:
        # Returns the value of the Operation result of an asynchronous invoked Operation
        api_response = api_instance.get_operation_async_result_value_only(submodel_identifier, aas_identifier, id_short_path, handle_id)
        print("The response of AssetAdministrationShellServiceApi->get_operation_async_result_value_only:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling AssetAdministrationShellServiceApi->get_operation_async_result_value_only: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **submodel_identifier** | **bytearray**| The Submodel’s unique id (UTF8-BASE64-URL-encoded) | 
 **aas_identifier** | **bytearray**| The Asset Administration Shell’s unique id (UTF8-BASE64-URL-encoded) | 
 **id_short_path** | **str**| IdShort path to the submodel element (dot-separated) | 
 **handle_id** | **bytearray**| The returned handle id of an operation&#39;s asynchronous invocation used to request the current state of the operation’s execution (UTF8-BASE64-URL-encoded) | 

### Return type

[**OperationResultValueOnly**](OperationResultValueOnly.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Operation result object |  -  |
**400** | Bad Request, e.g. the request parameters of the format of the request body is wrong. |  -  |
**401** | Unauthorized, e.g. the server refused the authorization attempt. |  -  |
**403** | Forbidden |  -  |
**404** | Not Found |  -  |
**500** | Internal Server Error |  -  |
**0** | Default error handling for unmentioned status codes |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_operation_async_status**
> BaseOperationResult get_operation_async_status(submodel_identifier, aas_identifier, id_short_path, handle_id)

Returns the status of an asynchronously invoked Operation

### Example


```python
import basyxclients
from basyxclients.models.base_operation_result import BaseOperationResult
from basyxclients.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost
# See configuration.py for a list of all supported configuration parameters.
configuration = basyxclients.Configuration(
    host = "http://localhost"
)


# Enter a context with an instance of the API client
with basyxclients.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = basyxclients.AssetAdministrationShellServiceApi(api_client)
    submodel_identifier = None # bytearray | The Submodel’s unique id (UTF8-BASE64-URL-encoded)
    aas_identifier = None # bytearray | The Asset Administration Shell’s unique id (UTF8-BASE64-URL-encoded)
    id_short_path = 'id_short_path_example' # str | IdShort path to the submodel element (dot-separated)
    handle_id = None # bytearray | The returned handle id of an operation's asynchronous invocation used to request the current state of the operation’s execution (UTF8-BASE64-URL-encoded)

    try:
        # Returns the status of an asynchronously invoked Operation
        api_response = api_instance.get_operation_async_status(submodel_identifier, aas_identifier, id_short_path, handle_id)
        print("The response of AssetAdministrationShellServiceApi->get_operation_async_status:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling AssetAdministrationShellServiceApi->get_operation_async_status: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **submodel_identifier** | **bytearray**| The Submodel’s unique id (UTF8-BASE64-URL-encoded) | 
 **aas_identifier** | **bytearray**| The Asset Administration Shell’s unique id (UTF8-BASE64-URL-encoded) | 
 **id_short_path** | **str**| IdShort path to the submodel element (dot-separated) | 
 **handle_id** | **bytearray**| The returned handle id of an operation&#39;s asynchronous invocation used to request the current state of the operation’s execution (UTF8-BASE64-URL-encoded) | 

### Return type

[**BaseOperationResult**](BaseOperationResult.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Operation result object containing information that the &#39;executionState&#39; is still &#39;Running&#39; |  -  |
**302** | The target resource is available but at a different location. |  * Location - The URL where the client can find the target resource. <br>  |
**400** | Bad Request, e.g. the request parameters of the format of the request body is wrong. |  -  |
**401** | Unauthorized, e.g. the server refused the authorization attempt. |  -  |
**403** | Forbidden |  -  |
**404** | Not Found |  -  |
**500** | Internal Server Error |  -  |
**0** | Default error handling for unmentioned status codes |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_submodel**
> Submodel get_submodel(submodel_identifier, level=level, extent=extent)

Returns the Submodel

### Example


```python
import basyxclients
from basyxclients.models.submodel import Submodel
from basyxclients.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost
# See configuration.py for a list of all supported configuration parameters.
configuration = basyxclients.Configuration(
    host = "http://localhost"
)


# Enter a context with an instance of the API client
with basyxclients.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = basyxclients.AssetAdministrationShellServiceApi(api_client)
    submodel_identifier = None # bytearray | The Submodel’s unique id (UTF8-BASE64-URL-encoded)
    level = deep # str | Determines the structural depth of the respective resource content (optional) (default to deep)
    extent = withoutBlobValue # str | Determines to which extent the resource is being serialized (optional) (default to withoutBlobValue)

    try:
        # Returns the Submodel
        api_response = api_instance.get_submodel(submodel_identifier, level=level, extent=extent)
        print("The response of AssetAdministrationShellServiceApi->get_submodel:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling AssetAdministrationShellServiceApi->get_submodel: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **submodel_identifier** | **bytearray**| The Submodel’s unique id (UTF8-BASE64-URL-encoded) | 
 **level** | **str**| Determines the structural depth of the respective resource content | [optional] [default to deep]
 **extent** | **str**| Determines to which extent the resource is being serialized | [optional] [default to withoutBlobValue]

### Return type

[**Submodel**](Submodel.md)

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

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_submodel_element_by_path**
> SubmodelElement get_submodel_element_by_path(submodel_identifier, id_short_path, level=level, extent=extent)

Returns a specific submodel element from the Submodel at a specified path

### Example


```python
import basyxclients
from basyxclients.models.submodel_element import SubmodelElement
from basyxclients.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost
# See configuration.py for a list of all supported configuration parameters.
configuration = basyxclients.Configuration(
    host = "http://localhost"
)


# Enter a context with an instance of the API client
with basyxclients.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = basyxclients.AssetAdministrationShellServiceApi(api_client)
    submodel_identifier = None # bytearray | The Submodel’s unique id (UTF8-BASE64-URL-encoded)
    id_short_path = 'id_short_path_example' # str | IdShort path to the submodel element (dot-separated)
    level = deep # str | Determines the structural depth of the respective resource content (optional) (default to deep)
    extent = withoutBlobValue # str | Determines to which extent the resource is being serialized (optional) (default to withoutBlobValue)

    try:
        # Returns a specific submodel element from the Submodel at a specified path
        api_response = api_instance.get_submodel_element_by_path(submodel_identifier, id_short_path, level=level, extent=extent)
        print("The response of AssetAdministrationShellServiceApi->get_submodel_element_by_path:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling AssetAdministrationShellServiceApi->get_submodel_element_by_path: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **submodel_identifier** | **bytearray**| The Submodel’s unique id (UTF8-BASE64-URL-encoded) | 
 **id_short_path** | **str**| IdShort path to the submodel element (dot-separated) | 
 **level** | **str**| Determines the structural depth of the respective resource content | [optional] [default to deep]
 **extent** | **str**| Determines to which extent the resource is being serialized | [optional] [default to withoutBlobValue]

### Return type

[**SubmodelElement**](SubmodelElement.md)

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

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_submodel_element_by_path_metadata**
> SubmodelElementMetadata get_submodel_element_by_path_metadata(submodel_identifier, id_short_path, level=level)

Returns the metadata attributes if a specific submodel element from the Submodel at a specified path

### Example


```python
import basyxclients
from basyxclients.models.submodel_element_metadata import SubmodelElementMetadata
from basyxclients.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost
# See configuration.py for a list of all supported configuration parameters.
configuration = basyxclients.Configuration(
    host = "http://localhost"
)


# Enter a context with an instance of the API client
with basyxclients.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = basyxclients.AssetAdministrationShellServiceApi(api_client)
    submodel_identifier = None # bytearray | The Submodel’s unique id (UTF8-BASE64-URL-encoded)
    id_short_path = 'id_short_path_example' # str | IdShort path to the submodel element (dot-separated)
    level = deep # str | Determines the structural depth of the respective resource content (optional) (default to deep)

    try:
        # Returns the metadata attributes if a specific submodel element from the Submodel at a specified path
        api_response = api_instance.get_submodel_element_by_path_metadata(submodel_identifier, id_short_path, level=level)
        print("The response of AssetAdministrationShellServiceApi->get_submodel_element_by_path_metadata:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling AssetAdministrationShellServiceApi->get_submodel_element_by_path_metadata: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **submodel_identifier** | **bytearray**| The Submodel’s unique id (UTF8-BASE64-URL-encoded) | 
 **id_short_path** | **str**| IdShort path to the submodel element (dot-separated) | 
 **level** | **str**| Determines the structural depth of the respective resource content | [optional] [default to deep]

### Return type

[**SubmodelElementMetadata**](SubmodelElementMetadata.md)

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

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_submodel_element_by_path_path**
> str get_submodel_element_by_path_path(submodel_identifier, id_short_path, level=level)

Returns a specific submodel element from the Submodel at a specified path in the Path notation

### Example


```python
import basyxclients
from basyxclients.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost
# See configuration.py for a list of all supported configuration parameters.
configuration = basyxclients.Configuration(
    host = "http://localhost"
)


# Enter a context with an instance of the API client
with basyxclients.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = basyxclients.AssetAdministrationShellServiceApi(api_client)
    submodel_identifier = None # bytearray | The Submodel’s unique id (UTF8-BASE64-URL-encoded)
    id_short_path = 'id_short_path_example' # str | IdShort path to the submodel element (dot-separated)
    level = deep # str | Determines the structural depth of the respective resource content (optional) (default to deep)

    try:
        # Returns a specific submodel element from the Submodel at a specified path in the Path notation
        api_response = api_instance.get_submodel_element_by_path_path(submodel_identifier, id_short_path, level=level)
        print("The response of AssetAdministrationShellServiceApi->get_submodel_element_by_path_path:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling AssetAdministrationShellServiceApi->get_submodel_element_by_path_path: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **submodel_identifier** | **bytearray**| The Submodel’s unique id (UTF8-BASE64-URL-encoded) | 
 **id_short_path** | **str**| IdShort path to the submodel element (dot-separated) | 
 **level** | **str**| Determines the structural depth of the respective resource content | [optional] [default to deep]

### Return type

**str**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Requested submodel element in the Path notation |  -  |
**400** | Bad Request, e.g. the request parameters of the format of the request body is wrong. |  -  |
**401** | Unauthorized, e.g. the server refused the authorization attempt. |  -  |
**403** | Forbidden |  -  |
**404** | Not Found |  -  |
**500** | Internal Server Error |  -  |
**0** | Default error handling for unmentioned status codes |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_submodel_element_by_path_reference**
> Reference get_submodel_element_by_path_reference(submodel_identifier, id_short_path)

Returns the Reference of a specific submodel element from the Submodel at a specified path in the ValueOnly representation

### Example


```python
import basyxclients
from basyxclients.models.reference import Reference
from basyxclients.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost
# See configuration.py for a list of all supported configuration parameters.
configuration = basyxclients.Configuration(
    host = "http://localhost"
)


# Enter a context with an instance of the API client
with basyxclients.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = basyxclients.AssetAdministrationShellServiceApi(api_client)
    submodel_identifier = None # bytearray | The Submodel’s unique id (UTF8-BASE64-URL-encoded)
    id_short_path = 'id_short_path_example' # str | IdShort path to the submodel element (dot-separated)

    try:
        # Returns the Reference of a specific submodel element from the Submodel at a specified path in the ValueOnly representation
        api_response = api_instance.get_submodel_element_by_path_reference(submodel_identifier, id_short_path)
        print("The response of AssetAdministrationShellServiceApi->get_submodel_element_by_path_reference:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling AssetAdministrationShellServiceApi->get_submodel_element_by_path_reference: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **submodel_identifier** | **bytearray**| The Submodel’s unique id (UTF8-BASE64-URL-encoded) | 
 **id_short_path** | **str**| IdShort path to the submodel element (dot-separated) | 

### Return type

[**Reference**](Reference.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Requested submodel element in its ValueOnly representation |  -  |
**400** | Bad Request, e.g. the request parameters of the format of the request body is wrong. |  -  |
**401** | Unauthorized, e.g. the server refused the authorization attempt. |  -  |
**403** | Forbidden |  -  |
**404** | Not Found |  -  |
**500** | Internal Server Error |  -  |
**0** | Default error handling for unmentioned status codes |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_submodel_element_by_path_value_only**
> SubmodelElementValue get_submodel_element_by_path_value_only(submodel_identifier, id_short_path, level=level)

Returns a specific submodel element from the Submodel at a specified path in the ValueOnly representation

### Example


```python
import basyxclients
from basyxclients.models.submodel_element_value import SubmodelElementValue
from basyxclients.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost
# See configuration.py for a list of all supported configuration parameters.
configuration = basyxclients.Configuration(
    host = "http://localhost"
)


# Enter a context with an instance of the API client
with basyxclients.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = basyxclients.AssetAdministrationShellServiceApi(api_client)
    submodel_identifier = None # bytearray | The Submodel’s unique id (UTF8-BASE64-URL-encoded)
    id_short_path = 'id_short_path_example' # str | IdShort path to the submodel element (dot-separated)
    level = deep # str | Determines the structural depth of the respective resource content (optional) (default to deep)

    try:
        # Returns a specific submodel element from the Submodel at a specified path in the ValueOnly representation
        api_response = api_instance.get_submodel_element_by_path_value_only(submodel_identifier, id_short_path, level=level)
        print("The response of AssetAdministrationShellServiceApi->get_submodel_element_by_path_value_only:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling AssetAdministrationShellServiceApi->get_submodel_element_by_path_value_only: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **submodel_identifier** | **bytearray**| The Submodel’s unique id (UTF8-BASE64-URL-encoded) | 
 **id_short_path** | **str**| IdShort path to the submodel element (dot-separated) | 
 **level** | **str**| Determines the structural depth of the respective resource content | [optional] [default to deep]

### Return type

[**SubmodelElementValue**](SubmodelElementValue.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Requested submodel element in its ValueOnly representation |  -  |
**400** | Bad Request, e.g. the request parameters of the format of the request body is wrong. |  -  |
**401** | Unauthorized, e.g. the server refused the authorization attempt. |  -  |
**403** | Forbidden |  -  |
**404** | Not Found |  -  |
**500** | Internal Server Error |  -  |
**0** | Default error handling for unmentioned status codes |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_submodel_metadata**
> SubmodelMetadata get_submodel_metadata(submodel_identifier, level=level)

Returns the Submodel's metadata elements

### Example


```python
import basyxclients
from basyxclients.models.submodel_metadata import SubmodelMetadata
from basyxclients.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost
# See configuration.py for a list of all supported configuration parameters.
configuration = basyxclients.Configuration(
    host = "http://localhost"
)


# Enter a context with an instance of the API client
with basyxclients.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = basyxclients.AssetAdministrationShellServiceApi(api_client)
    submodel_identifier = None # bytearray | The Submodel’s unique id (UTF8-BASE64-URL-encoded)
    level = deep # str | Determines the structural depth of the respective resource content (optional) (default to deep)

    try:
        # Returns the Submodel's metadata elements
        api_response = api_instance.get_submodel_metadata(submodel_identifier, level=level)
        print("The response of AssetAdministrationShellServiceApi->get_submodel_metadata:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling AssetAdministrationShellServiceApi->get_submodel_metadata: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **submodel_identifier** | **bytearray**| The Submodel’s unique id (UTF8-BASE64-URL-encoded) | 
 **level** | **str**| Determines the structural depth of the respective resource content | [optional] [default to deep]

### Return type

[**SubmodelMetadata**](SubmodelMetadata.md)

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

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_submodel_metadata_reference**
> Reference get_submodel_metadata_reference(submodel_identifier, level=level)

Returns the Submodel as a Reference

### Example


```python
import basyxclients
from basyxclients.models.reference import Reference
from basyxclients.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost
# See configuration.py for a list of all supported configuration parameters.
configuration = basyxclients.Configuration(
    host = "http://localhost"
)


# Enter a context with an instance of the API client
with basyxclients.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = basyxclients.AssetAdministrationShellServiceApi(api_client)
    submodel_identifier = None # bytearray | The Submodel’s unique id (UTF8-BASE64-URL-encoded)
    level = core # str | Determines the structural depth of the respective resource content (optional) (default to core)

    try:
        # Returns the Submodel as a Reference
        api_response = api_instance.get_submodel_metadata_reference(submodel_identifier, level=level)
        print("The response of AssetAdministrationShellServiceApi->get_submodel_metadata_reference:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling AssetAdministrationShellServiceApi->get_submodel_metadata_reference: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **submodel_identifier** | **bytearray**| The Submodel’s unique id (UTF8-BASE64-URL-encoded) | 
 **level** | **str**| Determines the structural depth of the respective resource content | [optional] [default to core]

### Return type

[**Reference**](Reference.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Requested Submodel as a Reference |  -  |
**400** | Bad Request, e.g. the request parameters of the format of the request body is wrong. |  -  |
**401** | Unauthorized, e.g. the server refused the authorization attempt. |  -  |
**403** | Forbidden |  -  |
**404** | Not Found |  -  |
**500** | Internal Server Error |  -  |
**0** | Default error handling for unmentioned status codes |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_submodel_path**
> List[str] get_submodel_path(submodel_identifier, level=level)

Returns the Submodel's metadata elements

### Example


```python
import basyxclients
from basyxclients.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost
# See configuration.py for a list of all supported configuration parameters.
configuration = basyxclients.Configuration(
    host = "http://localhost"
)


# Enter a context with an instance of the API client
with basyxclients.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = basyxclients.AssetAdministrationShellServiceApi(api_client)
    submodel_identifier = None # bytearray | The Submodel’s unique id (UTF8-BASE64-URL-encoded)
    level = deep # str | Determines the structural depth of the respective resource content (optional) (default to deep)

    try:
        # Returns the Submodel's metadata elements
        api_response = api_instance.get_submodel_path(submodel_identifier, level=level)
        print("The response of AssetAdministrationShellServiceApi->get_submodel_path:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling AssetAdministrationShellServiceApi->get_submodel_path: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **submodel_identifier** | **bytearray**| The Submodel’s unique id (UTF8-BASE64-URL-encoded) | 
 **level** | **str**| Determines the structural depth of the respective resource content | [optional] [default to deep]

### Return type

**List[str]**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Requested Submodel in Path notation |  -  |
**400** | Bad Request, e.g. the request parameters of the format of the request body is wrong. |  -  |
**401** | Unauthorized, e.g. the server refused the authorization attempt. |  -  |
**403** | Forbidden |  -  |
**404** | Not Found |  -  |
**500** | Internal Server Error |  -  |
**0** | Default error handling for unmentioned status codes |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_submodel_value_only**
> SubmodelValue get_submodel_value_only(submodel_identifier, level=level, extent=extent)

Returns the Submodel's ValueOnly representation

### Example


```python
import basyxclients
from basyxclients.models.submodel_value import SubmodelValue
from basyxclients.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost
# See configuration.py for a list of all supported configuration parameters.
configuration = basyxclients.Configuration(
    host = "http://localhost"
)


# Enter a context with an instance of the API client
with basyxclients.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = basyxclients.AssetAdministrationShellServiceApi(api_client)
    submodel_identifier = None # bytearray | The Submodel’s unique id (UTF8-BASE64-URL-encoded)
    level = deep # str | Determines the structural depth of the respective resource content (optional) (default to deep)
    extent = withoutBlobValue # str | Determines to which extent the resource is being serialized (optional) (default to withoutBlobValue)

    try:
        # Returns the Submodel's ValueOnly representation
        api_response = api_instance.get_submodel_value_only(submodel_identifier, level=level, extent=extent)
        print("The response of AssetAdministrationShellServiceApi->get_submodel_value_only:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling AssetAdministrationShellServiceApi->get_submodel_value_only: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **submodel_identifier** | **bytearray**| The Submodel’s unique id (UTF8-BASE64-URL-encoded) | 
 **level** | **str**| Determines the structural depth of the respective resource content | [optional] [default to deep]
 **extent** | **str**| Determines to which extent the resource is being serialized | [optional] [default to withoutBlobValue]

### Return type

[**SubmodelValue**](SubmodelValue.md)

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

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_thumbnail**
> bytearray get_thumbnail()

### Example


```python
import basyxclients
from basyxclients.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost
# See configuration.py for a list of all supported configuration parameters.
configuration = basyxclients.Configuration(
    host = "http://localhost"
)


# Enter a context with an instance of the API client
with basyxclients.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = basyxclients.AssetAdministrationShellServiceApi(api_client)

    try:
        api_response = api_instance.get_thumbnail()
        print("The response of AssetAdministrationShellServiceApi->get_thumbnail:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling AssetAdministrationShellServiceApi->get_thumbnail: %s\n" % e)
```



### Parameters

This endpoint does not need any parameter.

### Return type

**bytearray**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/octet-stream, application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The thumbnail of the Asset Information. |  -  |
**400** | Bad Request, e.g. the request parameters of the format of the request body is wrong. |  -  |
**401** | Unauthorized, e.g. the server refused the authorization attempt. |  -  |
**403** | Forbidden |  -  |
**404** | Not Found |  -  |
**500** | Internal Server Error |  -  |
**0** | Default error handling for unmentioned status codes |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **invoke_operation_async**
> invoke_operation_async(submodel_identifier, id_short_path, operation_request)

Asynchronously invokes an Operation at a specified path

### Example


```python
import basyxclients
from basyxclients.models.operation_request import OperationRequest
from basyxclients.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost
# See configuration.py for a list of all supported configuration parameters.
configuration = basyxclients.Configuration(
    host = "http://localhost"
)


# Enter a context with an instance of the API client
with basyxclients.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = basyxclients.AssetAdministrationShellServiceApi(api_client)
    submodel_identifier = None # bytearray | The Submodel’s unique id (UTF8-BASE64-URL-encoded)
    id_short_path = 'id_short_path_example' # str | IdShort path to the submodel element (dot-separated)
    operation_request = basyxclients.OperationRequest() # OperationRequest | Operation request object

    try:
        # Asynchronously invokes an Operation at a specified path
        api_instance.invoke_operation_async(submodel_identifier, id_short_path, operation_request)
    except Exception as e:
        print("Exception when calling AssetAdministrationShellServiceApi->invoke_operation_async: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **submodel_identifier** | **bytearray**| The Submodel’s unique id (UTF8-BASE64-URL-encoded) | 
 **id_short_path** | **str**| IdShort path to the submodel element (dot-separated) | 
 **operation_request** | [**OperationRequest**](OperationRequest.md)| Operation request object | 

### Return type

void (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**202** | The server has accepted the request. |  * Location - The URL where the client can find the target resource. <br>  |
**400** | Bad Request, e.g. the request parameters of the format of the request body is wrong. |  -  |
**401** | Unauthorized, e.g. the server refused the authorization attempt. |  -  |
**403** | Forbidden |  -  |
**404** | Not Found |  -  |
**500** | Internal Server Error |  -  |
**0** | Default error handling for unmentioned status codes |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **invoke_operation_async_value_only**
> invoke_operation_async_value_only(submodel_identifier, id_short_path, operation_request_value_only)

Asynchronously invokes an Operation at a specified path

### Example


```python
import basyxclients
from basyxclients.models.operation_request_value_only import OperationRequestValueOnly
from basyxclients.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost
# See configuration.py for a list of all supported configuration parameters.
configuration = basyxclients.Configuration(
    host = "http://localhost"
)


# Enter a context with an instance of the API client
with basyxclients.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = basyxclients.AssetAdministrationShellServiceApi(api_client)
    submodel_identifier = None # bytearray | The Submodel’s unique id (UTF8-BASE64-URL-encoded)
    id_short_path = 'id_short_path_example' # str | IdShort path to the submodel element (dot-separated)
    operation_request_value_only = basyxclients.OperationRequestValueOnly() # OperationRequestValueOnly | Operation request object

    try:
        # Asynchronously invokes an Operation at a specified path
        api_instance.invoke_operation_async_value_only(submodel_identifier, id_short_path, operation_request_value_only)
    except Exception as e:
        print("Exception when calling AssetAdministrationShellServiceApi->invoke_operation_async_value_only: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **submodel_identifier** | **bytearray**| The Submodel’s unique id (UTF8-BASE64-URL-encoded) | 
 **id_short_path** | **str**| IdShort path to the submodel element (dot-separated) | 
 **operation_request_value_only** | [**OperationRequestValueOnly**](OperationRequestValueOnly.md)| Operation request object | 

### Return type

void (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**202** | The server has accepted the request. |  * Location - The URL where the client can find the target resource. <br>  |
**400** | Bad Request, e.g. the request parameters of the format of the request body is wrong. |  -  |
**401** | Unauthorized, e.g. the server refused the authorization attempt. |  -  |
**403** | Forbidden |  -  |
**404** | Not Found |  -  |
**500** | Internal Server Error |  -  |
**0** | Default error handling for unmentioned status codes |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **invoke_operation_sync**
> OperationResult invoke_operation_sync(submodel_identifier, id_short_path, operation_request)

Synchronously invokes an Operation at a specified path

### Example


```python
import basyxclients
from basyxclients.models.operation_request import OperationRequest
from basyxclients.models.operation_result import OperationResult
from basyxclients.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost
# See configuration.py for a list of all supported configuration parameters.
configuration = basyxclients.Configuration(
    host = "http://localhost"
)


# Enter a context with an instance of the API client
with basyxclients.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = basyxclients.AssetAdministrationShellServiceApi(api_client)
    submodel_identifier = None # bytearray | The Submodel’s unique id (UTF8-BASE64-URL-encoded)
    id_short_path = 'id_short_path_example' # str | IdShort path to the submodel element (dot-separated)
    operation_request = basyxclients.OperationRequest() # OperationRequest | Operation request object

    try:
        # Synchronously invokes an Operation at a specified path
        api_response = api_instance.invoke_operation_sync(submodel_identifier, id_short_path, operation_request)
        print("The response of AssetAdministrationShellServiceApi->invoke_operation_sync:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling AssetAdministrationShellServiceApi->invoke_operation_sync: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **submodel_identifier** | **bytearray**| The Submodel’s unique id (UTF8-BASE64-URL-encoded) | 
 **id_short_path** | **str**| IdShort path to the submodel element (dot-separated) | 
 **operation_request** | [**OperationRequest**](OperationRequest.md)| Operation request object | 

### Return type

[**OperationResult**](OperationResult.md)

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
**500** | Internal Server Error |  -  |
**0** | Default error handling for unmentioned status codes |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **invoke_operation_sync_value_only**
> OperationResultValueOnly invoke_operation_sync_value_only(submodel_identifier, id_short_path, operation_request_value_only)

Synchronously invokes an Operation at a specified path

### Example


```python
import basyxclients
from basyxclients.models.operation_request_value_only import OperationRequestValueOnly
from basyxclients.models.operation_result_value_only import OperationResultValueOnly
from basyxclients.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost
# See configuration.py for a list of all supported configuration parameters.
configuration = basyxclients.Configuration(
    host = "http://localhost"
)


# Enter a context with an instance of the API client
with basyxclients.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = basyxclients.AssetAdministrationShellServiceApi(api_client)
    submodel_identifier = None # bytearray | The Submodel’s unique id (UTF8-BASE64-URL-encoded)
    id_short_path = 'id_short_path_example' # str | IdShort path to the submodel element (dot-separated)
    operation_request_value_only = basyxclients.OperationRequestValueOnly() # OperationRequestValueOnly | Operation request object

    try:
        # Synchronously invokes an Operation at a specified path
        api_response = api_instance.invoke_operation_sync_value_only(submodel_identifier, id_short_path, operation_request_value_only)
        print("The response of AssetAdministrationShellServiceApi->invoke_operation_sync_value_only:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling AssetAdministrationShellServiceApi->invoke_operation_sync_value_only: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **submodel_identifier** | **bytearray**| The Submodel’s unique id (UTF8-BASE64-URL-encoded) | 
 **id_short_path** | **str**| IdShort path to the submodel element (dot-separated) | 
 **operation_request_value_only** | [**OperationRequestValueOnly**](OperationRequestValueOnly.md)| Operation request object | 

### Return type

[**OperationResultValueOnly**](OperationResultValueOnly.md)

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
**500** | Internal Server Error |  -  |
**0** | Default error handling for unmentioned status codes |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **patch_submodel**
> patch_submodel(submodel_identifier, submodel, level=level)

Updates the Submodel

### Example


```python
import basyxclients
from basyxclients.models.submodel import Submodel
from basyxclients.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost
# See configuration.py for a list of all supported configuration parameters.
configuration = basyxclients.Configuration(
    host = "http://localhost"
)


# Enter a context with an instance of the API client
with basyxclients.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = basyxclients.AssetAdministrationShellServiceApi(api_client)
    submodel_identifier = None # bytearray | The Submodel’s unique id (UTF8-BASE64-URL-encoded)
    submodel = basyxclients.Submodel() # Submodel | Submodel object
    level = core # str | Determines the structural depth of the respective resource content (optional) (default to core)

    try:
        # Updates the Submodel
        api_instance.patch_submodel(submodel_identifier, submodel, level=level)
    except Exception as e:
        print("Exception when calling AssetAdministrationShellServiceApi->patch_submodel: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **submodel_identifier** | **bytearray**| The Submodel’s unique id (UTF8-BASE64-URL-encoded) | 
 **submodel** | [**Submodel**](Submodel.md)| Submodel object | 
 **level** | **str**| Determines the structural depth of the respective resource content | [optional] [default to core]

### Return type

void (empty response body)

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

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **patch_submodel_element_value_by_path**
> patch_submodel_element_value_by_path(submodel_identifier, id_short_path, submodel_element, level=level)

Updates an existing submodel element value at a specified path within submodel elements hierarchy

### Example


```python
import basyxclients
from basyxclients.models.submodel_element import SubmodelElement
from basyxclients.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost
# See configuration.py for a list of all supported configuration parameters.
configuration = basyxclients.Configuration(
    host = "http://localhost"
)


# Enter a context with an instance of the API client
with basyxclients.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = basyxclients.AssetAdministrationShellServiceApi(api_client)
    submodel_identifier = None # bytearray | The Submodel’s unique id (UTF8-BASE64-URL-encoded)
    id_short_path = 'id_short_path_example' # str | IdShort path to the submodel element (dot-separated)
    submodel_element = basyxclients.SubmodelElement() # SubmodelElement | The updated value of the submodel element
    level = deep # str | Determines the structural depth of the respective resource content (optional) (default to deep)

    try:
        # Updates an existing submodel element value at a specified path within submodel elements hierarchy
        api_instance.patch_submodel_element_value_by_path(submodel_identifier, id_short_path, submodel_element, level=level)
    except Exception as e:
        print("Exception when calling AssetAdministrationShellServiceApi->patch_submodel_element_value_by_path: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **submodel_identifier** | **bytearray**| The Submodel’s unique id (UTF8-BASE64-URL-encoded) | 
 **id_short_path** | **str**| IdShort path to the submodel element (dot-separated) | 
 **submodel_element** | [**SubmodelElement**](SubmodelElement.md)| The updated value of the submodel element | 
 **level** | **str**| Determines the structural depth of the respective resource content | [optional] [default to deep]

### Return type

void (empty response body)

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

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **patch_submodel_element_value_by_path_metadata**
> patch_submodel_element_value_by_path_metadata(submodel_identifier, id_short_path, submodel_element_metadata, level=level)

Updates the metadata attributes of an existing submodel element value at a specified path within submodel elements hierarchy

### Example


```python
import basyxclients
from basyxclients.models.submodel_element_metadata import SubmodelElementMetadata
from basyxclients.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost
# See configuration.py for a list of all supported configuration parameters.
configuration = basyxclients.Configuration(
    host = "http://localhost"
)


# Enter a context with an instance of the API client
with basyxclients.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = basyxclients.AssetAdministrationShellServiceApi(api_client)
    submodel_identifier = None # bytearray | The Submodel’s unique id (UTF8-BASE64-URL-encoded)
    id_short_path = 'id_short_path_example' # str | IdShort path to the submodel element (dot-separated)
    submodel_element_metadata = basyxclients.SubmodelElementMetadata() # SubmodelElementMetadata | The updated metadata attributes of the submodel element
    level = deep # str | Determines the structural depth of the respective resource content (optional) (default to deep)

    try:
        # Updates the metadata attributes of an existing submodel element value at a specified path within submodel elements hierarchy
        api_instance.patch_submodel_element_value_by_path_metadata(submodel_identifier, id_short_path, submodel_element_metadata, level=level)
    except Exception as e:
        print("Exception when calling AssetAdministrationShellServiceApi->patch_submodel_element_value_by_path_metadata: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **submodel_identifier** | **bytearray**| The Submodel’s unique id (UTF8-BASE64-URL-encoded) | 
 **id_short_path** | **str**| IdShort path to the submodel element (dot-separated) | 
 **submodel_element_metadata** | [**SubmodelElementMetadata**](SubmodelElementMetadata.md)| The updated metadata attributes of the submodel element | 
 **level** | **str**| Determines the structural depth of the respective resource content | [optional] [default to deep]

### Return type

void (empty response body)

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

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **patch_submodel_element_value_by_path_value_only**
> patch_submodel_element_value_by_path_value_only(submodel_identifier, id_short_path, submodel_element_value, level=level)

Updates the value of an existing submodel element value at a specified path within submodel elements hierarchy

### Example


```python
import basyxclients
from basyxclients.models.submodel_element_value import SubmodelElementValue
from basyxclients.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost
# See configuration.py for a list of all supported configuration parameters.
configuration = basyxclients.Configuration(
    host = "http://localhost"
)


# Enter a context with an instance of the API client
with basyxclients.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = basyxclients.AssetAdministrationShellServiceApi(api_client)
    submodel_identifier = None # bytearray | The Submodel’s unique id (UTF8-BASE64-URL-encoded)
    id_short_path = 'id_short_path_example' # str | IdShort path to the submodel element (dot-separated)
    submodel_element_value = basyxclients.SubmodelElementValue() # SubmodelElementValue | The updated value of the submodel element
    level = deep # str | Determines the structural depth of the respective resource content (optional) (default to deep)

    try:
        # Updates the value of an existing submodel element value at a specified path within submodel elements hierarchy
        api_instance.patch_submodel_element_value_by_path_value_only(submodel_identifier, id_short_path, submodel_element_value, level=level)
    except Exception as e:
        print("Exception when calling AssetAdministrationShellServiceApi->patch_submodel_element_value_by_path_value_only: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **submodel_identifier** | **bytearray**| The Submodel’s unique id (UTF8-BASE64-URL-encoded) | 
 **id_short_path** | **str**| IdShort path to the submodel element (dot-separated) | 
 **submodel_element_value** | [**SubmodelElementValue**](SubmodelElementValue.md)| The updated value of the submodel element | 
 **level** | **str**| Determines the structural depth of the respective resource content | [optional] [default to deep]

### Return type

void (empty response body)

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

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **patch_submodel_metadata**
> patch_submodel_metadata(submodel_identifier, submodel_metadata, level=level)

Updates the metadata attributes of the Submodel

### Example


```python
import basyxclients
from basyxclients.models.submodel_metadata import SubmodelMetadata
from basyxclients.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost
# See configuration.py for a list of all supported configuration parameters.
configuration = basyxclients.Configuration(
    host = "http://localhost"
)


# Enter a context with an instance of the API client
with basyxclients.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = basyxclients.AssetAdministrationShellServiceApi(api_client)
    submodel_identifier = None # bytearray | The Submodel’s unique id (UTF8-BASE64-URL-encoded)
    submodel_metadata = basyxclients.SubmodelMetadata() # SubmodelMetadata | Submodel object
    level = core # str | Determines the structural depth of the respective resource content (optional) (default to core)

    try:
        # Updates the metadata attributes of the Submodel
        api_instance.patch_submodel_metadata(submodel_identifier, submodel_metadata, level=level)
    except Exception as e:
        print("Exception when calling AssetAdministrationShellServiceApi->patch_submodel_metadata: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **submodel_identifier** | **bytearray**| The Submodel’s unique id (UTF8-BASE64-URL-encoded) | 
 **submodel_metadata** | [**SubmodelMetadata**](SubmodelMetadata.md)| Submodel object | 
 **level** | **str**| Determines the structural depth of the respective resource content | [optional] [default to core]

### Return type

void (empty response body)

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

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **patch_submodel_value_only**
> patch_submodel_value_only(submodel_identifier, submodel_value, level=level)

Updates teh values of the Submodel

### Example


```python
import basyxclients
from basyxclients.models.submodel_value import SubmodelValue
from basyxclients.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost
# See configuration.py for a list of all supported configuration parameters.
configuration = basyxclients.Configuration(
    host = "http://localhost"
)


# Enter a context with an instance of the API client
with basyxclients.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = basyxclients.AssetAdministrationShellServiceApi(api_client)
    submodel_identifier = None # bytearray | The Submodel’s unique id (UTF8-BASE64-URL-encoded)
    submodel_value = basyxclients.SubmodelValue() # SubmodelValue | Submodel object in the ValueOnly representation
    level = core # str | Determines the structural depth of the respective resource content (optional) (default to core)

    try:
        # Updates teh values of the Submodel
        api_instance.patch_submodel_value_only(submodel_identifier, submodel_value, level=level)
    except Exception as e:
        print("Exception when calling AssetAdministrationShellServiceApi->patch_submodel_value_only: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **submodel_identifier** | **bytearray**| The Submodel’s unique id (UTF8-BASE64-URL-encoded) | 
 **submodel_value** | [**SubmodelValue**](SubmodelValue.md)| Submodel object in the ValueOnly representation | 
 **level** | **str**| Determines the structural depth of the respective resource content | [optional] [default to core]

### Return type

void (empty response body)

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

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **post_submodel_element**
> SubmodelElement post_submodel_element(submodel_identifier, submodel_element)

Creates a new submodel element

### Example


```python
import basyxclients
from basyxclients.models.submodel_element import SubmodelElement
from basyxclients.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost
# See configuration.py for a list of all supported configuration parameters.
configuration = basyxclients.Configuration(
    host = "http://localhost"
)


# Enter a context with an instance of the API client
with basyxclients.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = basyxclients.AssetAdministrationShellServiceApi(api_client)
    submodel_identifier = None # bytearray | The Submodel’s unique id (UTF8-BASE64-URL-encoded)
    submodel_element = basyxclients.SubmodelElement() # SubmodelElement | Requested submodel element

    try:
        # Creates a new submodel element
        api_response = api_instance.post_submodel_element(submodel_identifier, submodel_element)
        print("The response of AssetAdministrationShellServiceApi->post_submodel_element:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling AssetAdministrationShellServiceApi->post_submodel_element: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **submodel_identifier** | **bytearray**| The Submodel’s unique id (UTF8-BASE64-URL-encoded) | 
 **submodel_element** | [**SubmodelElement**](SubmodelElement.md)| Requested submodel element | 

### Return type

[**SubmodelElement**](SubmodelElement.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**201** | Submodel element created successfully |  * Location - The URL where the client can find the target resource. <br>  |
**400** | Bad Request, e.g. the request parameters of the format of the request body is wrong. |  -  |
**401** | Unauthorized, e.g. the server refused the authorization attempt. |  -  |
**403** | Forbidden |  -  |
**404** | Not Found |  -  |
**409** | Conflict, a resource which shall be created exists already. Might be thrown if a Submodel or SubmodelElement with the same ShortId is contained in a POST request. |  -  |
**500** | Internal Server Error |  -  |
**0** | Default error handling for unmentioned status codes |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **post_submodel_element_by_path**
> SubmodelElement post_submodel_element_by_path(submodel_identifier, id_short_path, submodel_element)

Creates a new submodel element at a specified path within submodel elements hierarchy

### Example


```python
import basyxclients
from basyxclients.models.submodel_element import SubmodelElement
from basyxclients.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost
# See configuration.py for a list of all supported configuration parameters.
configuration = basyxclients.Configuration(
    host = "http://localhost"
)


# Enter a context with an instance of the API client
with basyxclients.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = basyxclients.AssetAdministrationShellServiceApi(api_client)
    submodel_identifier = None # bytearray | The Submodel’s unique id (UTF8-BASE64-URL-encoded)
    id_short_path = 'id_short_path_example' # str | IdShort path to the submodel element (dot-separated)
    submodel_element = basyxclients.SubmodelElement() # SubmodelElement | Requested submodel element

    try:
        # Creates a new submodel element at a specified path within submodel elements hierarchy
        api_response = api_instance.post_submodel_element_by_path(submodel_identifier, id_short_path, submodel_element)
        print("The response of AssetAdministrationShellServiceApi->post_submodel_element_by_path:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling AssetAdministrationShellServiceApi->post_submodel_element_by_path: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **submodel_identifier** | **bytearray**| The Submodel’s unique id (UTF8-BASE64-URL-encoded) | 
 **id_short_path** | **str**| IdShort path to the submodel element (dot-separated) | 
 **submodel_element** | [**SubmodelElement**](SubmodelElement.md)| Requested submodel element | 

### Return type

[**SubmodelElement**](SubmodelElement.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**201** | Submodel element created successfully |  * Location - The URL where the client can find the target resource. <br>  |
**400** | Bad Request, e.g. the request parameters of the format of the request body is wrong. |  -  |
**401** | Unauthorized, e.g. the server refused the authorization attempt. |  -  |
**403** | Forbidden |  -  |
**404** | Not Found |  -  |
**409** | Conflict, a resource which shall be created exists already. Might be thrown if a Submodel or SubmodelElement with the same ShortId is contained in a POST request. |  -  |
**500** | Internal Server Error |  -  |
**0** | Default error handling for unmentioned status codes |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **post_submodel_reference**
> Reference post_submodel_reference(reference)

Creates a submodel reference at the Asset Administration Shell

### Example


```python
import basyxclients
from basyxclients.models.reference import Reference
from basyxclients.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost
# See configuration.py for a list of all supported configuration parameters.
configuration = basyxclients.Configuration(
    host = "http://localhost"
)


# Enter a context with an instance of the API client
with basyxclients.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = basyxclients.AssetAdministrationShellServiceApi(api_client)
    reference = basyxclients.Reference() # Reference | Reference to the Submodel

    try:
        # Creates a submodel reference at the Asset Administration Shell
        api_response = api_instance.post_submodel_reference(reference)
        print("The response of AssetAdministrationShellServiceApi->post_submodel_reference:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling AssetAdministrationShellServiceApi->post_submodel_reference: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **reference** | [**Reference**](Reference.md)| Reference to the Submodel | 

### Return type

[**Reference**](Reference.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**201** | Submodel reference created successfully |  * Location - The URL where the client can find the target resource. <br>  |
**400** | Bad Request, e.g. the request parameters of the format of the request body is wrong. |  -  |
**401** | Unauthorized, e.g. the server refused the authorization attempt. |  -  |
**403** | Forbidden |  -  |
**409** | Conflict, a resource which shall be created exists already. Might be thrown if a Submodel or SubmodelElement with the same ShortId is contained in a POST request. |  -  |
**500** | Internal Server Error |  -  |
**0** | Default error handling for unmentioned status codes |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **put_asset_administration_shell**
> put_asset_administration_shell(asset_administration_shell)

Updates an existing Asset Administration Shell

### Example


```python
import basyxclients
from basyxclients.models.asset_administration_shell import AssetAdministrationShell
from basyxclients.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost
# See configuration.py for a list of all supported configuration parameters.
configuration = basyxclients.Configuration(
    host = "http://localhost"
)


# Enter a context with an instance of the API client
with basyxclients.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = basyxclients.AssetAdministrationShellServiceApi(api_client)
    asset_administration_shell = basyxclients.AssetAdministrationShell() # AssetAdministrationShell | Asset Administration Shell object

    try:
        # Updates an existing Asset Administration Shell
        api_instance.put_asset_administration_shell(asset_administration_shell)
    except Exception as e:
        print("Exception when calling AssetAdministrationShellServiceApi->put_asset_administration_shell: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **asset_administration_shell** | [**AssetAdministrationShell**](AssetAdministrationShell.md)| Asset Administration Shell object | 

### Return type

void (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**204** | Asset Administration Shell updated successfully |  -  |
**400** | Bad Request, e.g. the request parameters of the format of the request body is wrong. |  -  |
**401** | Unauthorized, e.g. the server refused the authorization attempt. |  -  |
**403** | Forbidden |  -  |
**500** | Internal Server Error |  -  |
**0** | Default error handling for unmentioned status codes |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **put_asset_information**
> put_asset_information(asset_information)

Updates the Asset Information

### Example


```python
import basyxclients
from basyxclients.models.asset_information import AssetInformation
from basyxclients.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost
# See configuration.py for a list of all supported configuration parameters.
configuration = basyxclients.Configuration(
    host = "http://localhost"
)


# Enter a context with an instance of the API client
with basyxclients.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = basyxclients.AssetAdministrationShellServiceApi(api_client)
    asset_information = basyxclients.AssetInformation() # AssetInformation | Asset Information object

    try:
        # Updates the Asset Information
        api_instance.put_asset_information(asset_information)
    except Exception as e:
        print("Exception when calling AssetAdministrationShellServiceApi->put_asset_information: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **asset_information** | [**AssetInformation**](AssetInformation.md)| Asset Information object | 

### Return type

void (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**204** | Asset Information updated successfully |  -  |
**400** | Bad Request, e.g. the request parameters of the format of the request body is wrong. |  -  |
**401** | Unauthorized, e.g. the server refused the authorization attempt. |  -  |
**403** | Forbidden |  -  |
**500** | Internal Server Error |  -  |
**0** | Default error handling for unmentioned status codes |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **put_file_by_path**
> put_file_by_path(submodel_identifier, id_short_path, file_name=file_name, file=file)

Uploads file content to an existing submodel element at a specified path within submodel elements hierarchy

### Example


```python
import basyxclients
from basyxclients.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost
# See configuration.py for a list of all supported configuration parameters.
configuration = basyxclients.Configuration(
    host = "http://localhost"
)


# Enter a context with an instance of the API client
with basyxclients.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = basyxclients.AssetAdministrationShellServiceApi(api_client)
    submodel_identifier = None # bytearray | The Submodel’s unique id (UTF8-BASE64-URL-encoded)
    id_short_path = 'id_short_path_example' # str | IdShort path to the submodel element (dot-separated)
    file_name = 'file_name_example' # str |  (optional)
    file = None # bytearray |  (optional)

    try:
        # Uploads file content to an existing submodel element at a specified path within submodel elements hierarchy
        api_instance.put_file_by_path(submodel_identifier, id_short_path, file_name=file_name, file=file)
    except Exception as e:
        print("Exception when calling AssetAdministrationShellServiceApi->put_file_by_path: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **submodel_identifier** | **bytearray**| The Submodel’s unique id (UTF8-BASE64-URL-encoded) | 
 **id_short_path** | **str**| IdShort path to the submodel element (dot-separated) | 
 **file_name** | **str**|  | [optional] 
 **file** | **bytearray**|  | [optional] 

### Return type

void (empty response body)

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
**500** | Internal Server Error |  -  |
**0** | Default error handling for unmentioned status codes |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **put_submodel**
> put_submodel(submodel_identifier, submodel, level=level)

Updates the Submodel

### Example


```python
import basyxclients
from basyxclients.models.submodel import Submodel
from basyxclients.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost
# See configuration.py for a list of all supported configuration parameters.
configuration = basyxclients.Configuration(
    host = "http://localhost"
)


# Enter a context with an instance of the API client
with basyxclients.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = basyxclients.AssetAdministrationShellServiceApi(api_client)
    submodel_identifier = None # bytearray | The Submodel’s unique id (UTF8-BASE64-URL-encoded)
    submodel = basyxclients.Submodel() # Submodel | Submodel object
    level = deep # str | Determines the structural depth of the respective resource content (optional) (default to deep)

    try:
        # Updates the Submodel
        api_instance.put_submodel(submodel_identifier, submodel, level=level)
    except Exception as e:
        print("Exception when calling AssetAdministrationShellServiceApi->put_submodel: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **submodel_identifier** | **bytearray**| The Submodel’s unique id (UTF8-BASE64-URL-encoded) | 
 **submodel** | [**Submodel**](Submodel.md)| Submodel object | 
 **level** | **str**| Determines the structural depth of the respective resource content | [optional] [default to deep]

### Return type

void (empty response body)

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

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **put_submodel_element_by_path**
> put_submodel_element_by_path(submodel_identifier, id_short_path, submodel_element)

Updates an existing submodel element at a specified path within submodel elements hierarchy

### Example


```python
import basyxclients
from basyxclients.models.submodel_element import SubmodelElement
from basyxclients.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost
# See configuration.py for a list of all supported configuration parameters.
configuration = basyxclients.Configuration(
    host = "http://localhost"
)


# Enter a context with an instance of the API client
with basyxclients.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = basyxclients.AssetAdministrationShellServiceApi(api_client)
    submodel_identifier = None # bytearray | The Submodel’s unique id (UTF8-BASE64-URL-encoded)
    id_short_path = 'id_short_path_example' # str | IdShort path to the submodel element (dot-separated)
    submodel_element = basyxclients.SubmodelElement() # SubmodelElement | Requested submodel element

    try:
        # Updates an existing submodel element at a specified path within submodel elements hierarchy
        api_instance.put_submodel_element_by_path(submodel_identifier, id_short_path, submodel_element)
    except Exception as e:
        print("Exception when calling AssetAdministrationShellServiceApi->put_submodel_element_by_path: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **submodel_identifier** | **bytearray**| The Submodel’s unique id (UTF8-BASE64-URL-encoded) | 
 **id_short_path** | **str**| IdShort path to the submodel element (dot-separated) | 
 **submodel_element** | [**SubmodelElement**](SubmodelElement.md)| Requested submodel element | 

### Return type

void (empty response body)

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

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **put_thumbnail**
> put_thumbnail(file_name=file_name, file=file)

### Example


```python
import basyxclients
from basyxclients.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to http://localhost
# See configuration.py for a list of all supported configuration parameters.
configuration = basyxclients.Configuration(
    host = "http://localhost"
)


# Enter a context with an instance of the API client
with basyxclients.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = basyxclients.AssetAdministrationShellServiceApi(api_client)
    file_name = 'file_name_example' # str |  (optional)
    file = None # bytearray |  (optional)

    try:
        api_instance.put_thumbnail(file_name=file_name, file=file)
    except Exception as e:
        print("Exception when calling AssetAdministrationShellServiceApi->put_thumbnail: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **file_name** | **str**|  | [optional] 
 **file** | **bytearray**|  | [optional] 

### Return type

void (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: multipart/form-data
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**204** | Thumbnail updated successfully |  -  |
**400** | Bad Request, e.g. the request parameters of the format of the request body is wrong. |  -  |
**401** | Unauthorized, e.g. the server refused the authorization attempt. |  -  |
**403** | Forbidden |  -  |
**404** | Not Found |  -  |
**500** | Internal Server Error |  -  |
**0** | Default error handling for unmentioned status codes |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

