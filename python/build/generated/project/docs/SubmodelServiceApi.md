# basyxclients.SubmodelServiceApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**delete_file_by_path**](SubmodelServiceApi.md#delete_file_by_path) | **DELETE** /submodel/submodel-elements/{idShortPath}/attachment | Deletes file content of an existing submodel element at a specified path within submodel elements hierarchy
[**delete_submodel_element**](SubmodelServiceApi.md#delete_submodel_element) | **DELETE** /submodel/submodel-elements/{idShortPath} | Deletes a submodel element at a specified path within the submodel elements hierarchy
[**get_all_submodel_elements**](SubmodelServiceApi.md#get_all_submodel_elements) | **GET** /submodel/submodel-elements | Returns all submodel elements including their hierarchy
[**get_all_submodel_elements_metadata**](SubmodelServiceApi.md#get_all_submodel_elements_metadata) | **GET** /submodel/submodel-elements/$metadata | Returns the metadata attributes of all submodel elements including their hierarchy
[**get_all_submodel_elements_path**](SubmodelServiceApi.md#get_all_submodel_elements_path) | **GET** /submodel/submodel-elements/$path | Returns all submodel elements including their hierarchy in the Path notation
[**get_description**](SubmodelServiceApi.md#get_description) | **GET** /description | Returns the self-describing information of a network resource (ServiceDescription)
[**get_file_by_path**](SubmodelServiceApi.md#get_file_by_path) | **GET** /submodel/submodel-elements/{idShortPath}/attachment | Downloads file content from a specific submodel element from the Submodel at a specified path
[**get_submodel**](SubmodelServiceApi.md#get_submodel) | **GET** /submodel | Returns the Submodel
[**get_submodel_element**](SubmodelServiceApi.md#get_submodel_element) | **GET** /submodel/submodel-elements/{idShortPath} | Returns a specific submodel element from the Submodel at a specified path
[**get_submodel_element_by_path_metadata**](SubmodelServiceApi.md#get_submodel_element_by_path_metadata) | **GET** /submodel/submodel-elements/{idShortPath}/$metadata | Returns the matadata attributes of a specific submodel element from the Submodel at a specified path
[**get_submodel_element_by_path_path**](SubmodelServiceApi.md#get_submodel_element_by_path_path) | **GET** /submodel/submodel-elements/{idShortPath}/$path | Returns a specific submodel element from the Submodel at a specified path in the Path notation
[**get_submodel_element_value**](SubmodelServiceApi.md#get_submodel_element_value) | **GET** /submodel/submodel-elements/{idShortPath}/$value | Returns a specific submodel element from the Submodel at a specified path in the ValueOnly representation
[**get_submodel_metadata**](SubmodelServiceApi.md#get_submodel_metadata) | **GET** /submodel/$metadata | Returns the metadata attributes of a specific Submodel
[**get_submodel_value**](SubmodelServiceApi.md#get_submodel_value) | **GET** /submodel/$value | Returns the Submodel in the ValueOnly representation
[**invoke_operation**](SubmodelServiceApi.md#invoke_operation) | **POST** /submodel/submodel-elements/{idShortPath}/invoke | Synchronously invokes an Operation at a specified path
[**patch_submodel_element_by_path_metadata**](SubmodelServiceApi.md#patch_submodel_element_by_path_metadata) | **PATCH** /submodel/submodel-elements/{idShortPath}/$metadata | Updates the metadata attributes an existing SubmodelElement
[**patch_submodel_element_value**](SubmodelServiceApi.md#patch_submodel_element_value) | **PATCH** /submodel/submodel-elements/{idShortPath}/$value | Updates the value of an existing SubmodelElement
[**post_submodel_element**](SubmodelServiceApi.md#post_submodel_element) | **POST** /submodel/submodel-elements | Creates a new submodel element
[**post_submodel_element_by_path**](SubmodelServiceApi.md#post_submodel_element_by_path) | **POST** /submodel/submodel-elements/{idShortPath} | Creates a new submodel element at a specified path within submodel elements hierarchy
[**put_file_by_path**](SubmodelServiceApi.md#put_file_by_path) | **PUT** /submodel/submodel-elements/{idShortPath}/attachment | Uploads file content to an existing submodel element at a specified path within submodel elements hierarchy
[**put_submodel_element_by_path**](SubmodelServiceApi.md#put_submodel_element_by_path) | **PUT** /submodel/submodel-elements/{idShortPath} | Updates an existing submodel element at a specified path within submodel elements hierarchy


# **delete_file_by_path**
> delete_file_by_path(id_short_path)

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
    api_instance = basyxclients.SubmodelServiceApi(api_client)
    id_short_path = 'id_short_path_example' # str | IdShort path to the submodel element (dot-separated)

    try:
        # Deletes file content of an existing submodel element at a specified path within submodel elements hierarchy
        api_instance.delete_file_by_path(id_short_path)
    except Exception as e:
        print("Exception when calling SubmodelServiceApi->delete_file_by_path: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
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

# **delete_submodel_element**
> delete_submodel_element(id_short_path)

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
    api_instance = basyxclients.SubmodelServiceApi(api_client)
    id_short_path = 'id_short_path_example' # str | IdShort path to the submodel element (dot-separated)

    try:
        # Deletes a submodel element at a specified path within the submodel elements hierarchy
        api_instance.delete_submodel_element(id_short_path)
    except Exception as e:
        print("Exception when calling SubmodelServiceApi->delete_submodel_element: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
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

# **get_all_submodel_elements**
> GetSubmodelElementsResult get_all_submodel_elements(limit=limit, cursor=cursor, level=level, extent=extent)

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
    api_instance = basyxclients.SubmodelServiceApi(api_client)
    limit = 56 # int | The maximum number of elements in the response array (optional)
    cursor = 'cursor_example' # str | A server-generated identifier retrieved from pagingMetadata that specifies from which position the result listing should continue (optional)
    level = deep # str | Determines the structural depth of the respective resource content (optional) (default to deep)
    extent = withoutBlobValue # str | Determines to which extent the resource is being serialized (optional) (default to withoutBlobValue)

    try:
        # Returns all submodel elements including their hierarchy
        api_response = api_instance.get_all_submodel_elements(limit=limit, cursor=cursor, level=level, extent=extent)
        print("The response of SubmodelServiceApi->get_all_submodel_elements:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling SubmodelServiceApi->get_all_submodel_elements: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
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
**500** | Internal Server Error |  -  |
**0** | Default error handling for unmentioned status codes |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_all_submodel_elements_metadata**
> GetSubmodelElementsMetadataResult get_all_submodel_elements_metadata(limit=limit, cursor=cursor, level=level)

Returns the metadata attributes of all submodel elements including their hierarchy

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
    api_instance = basyxclients.SubmodelServiceApi(api_client)
    limit = 56 # int | The maximum number of elements in the response array (optional)
    cursor = 'cursor_example' # str | A server-generated identifier retrieved from pagingMetadata that specifies from which position the result listing should continue (optional)
    level = deep # str | Determines the structural depth of the respective resource content (optional) (default to deep)

    try:
        # Returns the metadata attributes of all submodel elements including their hierarchy
        api_response = api_instance.get_all_submodel_elements_metadata(limit=limit, cursor=cursor, level=level)
        print("The response of SubmodelServiceApi->get_all_submodel_elements_metadata:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling SubmodelServiceApi->get_all_submodel_elements_metadata: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
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
**500** | Internal Server Error |  -  |
**0** | Default error handling for unmentioned status codes |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_all_submodel_elements_path**
> GetPathItemsResult get_all_submodel_elements_path(limit=limit, cursor=cursor, level=level)

Returns all submodel elements including their hierarchy in the Path notation

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
    api_instance = basyxclients.SubmodelServiceApi(api_client)
    limit = 56 # int | The maximum number of elements in the response array (optional)
    cursor = 'cursor_example' # str | A server-generated identifier retrieved from pagingMetadata that specifies from which position the result listing should continue (optional)
    level = deep # str | Determines the structural depth of the respective resource content (optional) (default to deep)

    try:
        # Returns all submodel elements including their hierarchy in the Path notation
        api_response = api_instance.get_all_submodel_elements_path(limit=limit, cursor=cursor, level=level)
        print("The response of SubmodelServiceApi->get_all_submodel_elements_path:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling SubmodelServiceApi->get_all_submodel_elements_path: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
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
    api_instance = basyxclients.SubmodelServiceApi(api_client)

    try:
        # Returns the self-describing information of a network resource (ServiceDescription)
        api_response = api_instance.get_description()
        print("The response of SubmodelServiceApi->get_description:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling SubmodelServiceApi->get_description: %s\n" % e)
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
> bytearray get_file_by_path(id_short_path)

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
    api_instance = basyxclients.SubmodelServiceApi(api_client)
    id_short_path = 'id_short_path_example' # str | IdShort path to the submodel element (dot-separated)

    try:
        # Downloads file content from a specific submodel element from the Submodel at a specified path
        api_response = api_instance.get_file_by_path(id_short_path)
        print("The response of SubmodelServiceApi->get_file_by_path:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling SubmodelServiceApi->get_file_by_path: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
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
**405** | Method not allowed - Download only valid for File submodel element |  -  |
**500** | Internal Server Error |  -  |
**0** | Default error handling for unmentioned status codes |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_submodel**
> Submodel get_submodel(level=level, extent=extent)

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
    api_instance = basyxclients.SubmodelServiceApi(api_client)
    level = deep # str | Determines the structural depth of the respective resource content (optional) (default to deep)
    extent = withoutBlobValue # str | Determines to which extent the resource is being serialized (optional) (default to withoutBlobValue)

    try:
        # Returns the Submodel
        api_response = api_instance.get_submodel(level=level, extent=extent)
        print("The response of SubmodelServiceApi->get_submodel:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling SubmodelServiceApi->get_submodel: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
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
**500** | Internal Server Error |  -  |
**0** | Default error handling for unmentioned status codes |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_submodel_element**
> SubmodelElement get_submodel_element(id_short_path, level=level, extent=extent)

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
    api_instance = basyxclients.SubmodelServiceApi(api_client)
    id_short_path = 'id_short_path_example' # str | IdShort path to the submodel element (dot-separated)
    level = deep # str | Determines the structural depth of the respective resource content (optional) (default to deep)
    extent = withoutBlobValue # str | Determines to which extent the resource is being serialized (optional) (default to withoutBlobValue)

    try:
        # Returns a specific submodel element from the Submodel at a specified path
        api_response = api_instance.get_submodel_element(id_short_path, level=level, extent=extent)
        print("The response of SubmodelServiceApi->get_submodel_element:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling SubmodelServiceApi->get_submodel_element: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
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
> SubmodelElementMetadata get_submodel_element_by_path_metadata(id_short_path, cursor=cursor)

Returns the matadata attributes of a specific submodel element from the Submodel at a specified path

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
    api_instance = basyxclients.SubmodelServiceApi(api_client)
    id_short_path = 'id_short_path_example' # str | IdShort path to the submodel element (dot-separated)
    cursor = 'cursor_example' # str | A server-generated identifier retrieved from pagingMetadata that specifies from which position the result listing should continue (optional)

    try:
        # Returns the matadata attributes of a specific submodel element from the Submodel at a specified path
        api_response = api_instance.get_submodel_element_by_path_metadata(id_short_path, cursor=cursor)
        print("The response of SubmodelServiceApi->get_submodel_element_by_path_metadata:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling SubmodelServiceApi->get_submodel_element_by_path_metadata: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id_short_path** | **str**| IdShort path to the submodel element (dot-separated) | 
 **cursor** | **str**| A server-generated identifier retrieved from pagingMetadata that specifies from which position the result listing should continue | [optional] 

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
**200** | Metadata attributes of the requested submodel element |  -  |
**400** | Bad Request, e.g. the request parameters of the format of the request body is wrong. |  -  |
**401** | Unauthorized, e.g. the server refused the authorization attempt. |  -  |
**403** | Forbidden |  -  |
**404** | Not Found |  -  |
**500** | Internal Server Error |  -  |
**0** | Default error handling for unmentioned status codes |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_submodel_element_by_path_path**
> str get_submodel_element_by_path_path(id_short_path, level=level)

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
    api_instance = basyxclients.SubmodelServiceApi(api_client)
    id_short_path = 'id_short_path_example' # str | IdShort path to the submodel element (dot-separated)
    level = deep # str | Determines the structural depth of the respective resource content (optional) (default to deep)

    try:
        # Returns a specific submodel element from the Submodel at a specified path in the Path notation
        api_response = api_instance.get_submodel_element_by_path_path(id_short_path, level=level)
        print("The response of SubmodelServiceApi->get_submodel_element_by_path_path:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling SubmodelServiceApi->get_submodel_element_by_path_path: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
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
**200** | Requested submodel element |  -  |
**400** | Bad Request, e.g. the request parameters of the format of the request body is wrong. |  -  |
**401** | Unauthorized, e.g. the server refused the authorization attempt. |  -  |
**403** | Forbidden |  -  |
**404** | Not Found |  -  |
**500** | Internal Server Error |  -  |
**0** | Default error handling for unmentioned status codes |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_submodel_element_value**
> SubmodelElementValue get_submodel_element_value(id_short_path, level=level, extent=extent)

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
    api_instance = basyxclients.SubmodelServiceApi(api_client)
    id_short_path = 'id_short_path_example' # str | IdShort path to the submodel element (dot-separated)
    level = deep # str | Determines the structural depth of the respective resource content (optional) (default to deep)
    extent = withoutBlobValue # str | Determines to which extent the resource is being serialized (optional) (default to withoutBlobValue)

    try:
        # Returns a specific submodel element from the Submodel at a specified path in the ValueOnly representation
        api_response = api_instance.get_submodel_element_value(id_short_path, level=level, extent=extent)
        print("The response of SubmodelServiceApi->get_submodel_element_value:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling SubmodelServiceApi->get_submodel_element_value: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id_short_path** | **str**| IdShort path to the submodel element (dot-separated) | 
 **level** | **str**| Determines the structural depth of the respective resource content | [optional] [default to deep]
 **extent** | **str**| Determines to which extent the resource is being serialized | [optional] [default to withoutBlobValue]

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
**200** | Requested submodel element |  -  |
**400** | Bad Request, e.g. the request parameters of the format of the request body is wrong. |  -  |
**401** | Unauthorized, e.g. the server refused the authorization attempt. |  -  |
**403** | Forbidden |  -  |
**404** | Not Found |  -  |
**500** | Internal Server Error |  -  |
**0** | Default error handling for unmentioned status codes |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_submodel_metadata**
> SubmodelMetadata get_submodel_metadata(level=level)

Returns the metadata attributes of a specific Submodel

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
    api_instance = basyxclients.SubmodelServiceApi(api_client)
    level = deep # str | Determines the structural depth of the respective resource content (optional) (default to deep)

    try:
        # Returns the metadata attributes of a specific Submodel
        api_response = api_instance.get_submodel_metadata(level=level)
        print("The response of SubmodelServiceApi->get_submodel_metadata:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling SubmodelServiceApi->get_submodel_metadata: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
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
**200** | Requested Submodel in the metadata representation |  -  |
**400** | Bad Request, e.g. the request parameters of the format of the request body is wrong. |  -  |
**401** | Unauthorized, e.g. the server refused the authorization attempt. |  -  |
**403** | Forbidden |  -  |
**500** | Internal Server Error |  -  |
**0** | Default error handling for unmentioned status codes |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_submodel_value**
> SubmodelValue get_submodel_value(level=level, extent=extent)

Returns the Submodel in the ValueOnly representation

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
    api_instance = basyxclients.SubmodelServiceApi(api_client)
    level = deep # str | Determines the structural depth of the respective resource content (optional) (default to deep)
    extent = withoutBlobValue # str | Determines to which extent the resource is being serialized (optional) (default to withoutBlobValue)

    try:
        # Returns the Submodel in the ValueOnly representation
        api_response = api_instance.get_submodel_value(level=level, extent=extent)
        print("The response of SubmodelServiceApi->get_submodel_value:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling SubmodelServiceApi->get_submodel_value: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
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
**200** | ValueOnly representation of the Submodel |  -  |
**400** | Bad Request, e.g. the request parameters of the format of the request body is wrong. |  -  |
**401** | Unauthorized, e.g. the server refused the authorization attempt. |  -  |
**403** | Forbidden |  -  |
**500** | Internal Server Error |  -  |
**0** | Default error handling for unmentioned status codes |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **invoke_operation**
> OperationResult invoke_operation(id_short_path, operation_request)

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
    api_instance = basyxclients.SubmodelServiceApi(api_client)
    id_short_path = 'id_short_path_example' # str | IdShort path to the submodel element (dot-separated)
    operation_request = basyxclients.OperationRequest() # OperationRequest | Operation request object

    try:
        # Synchronously invokes an Operation at a specified path
        api_response = api_instance.invoke_operation(id_short_path, operation_request)
        print("The response of SubmodelServiceApi->invoke_operation:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling SubmodelServiceApi->invoke_operation: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
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
**405** | Method not allowed - Invoke only valid for Operation submodel element |  -  |
**500** | Internal Server Error |  -  |
**0** | Default error handling for unmentioned status codes |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **patch_submodel_element_by_path_metadata**
> patch_submodel_element_by_path_metadata(id_short_path, get_submodel_elements_metadata_result, limit=limit, cursor=cursor, level=level)

Updates the metadata attributes an existing SubmodelElement

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
    api_instance = basyxclients.SubmodelServiceApi(api_client)
    id_short_path = 'id_short_path_example' # str | IdShort path to the submodel element (dot-separated)
    get_submodel_elements_metadata_result = basyxclients.GetSubmodelElementsMetadataResult() # GetSubmodelElementsMetadataResult | Metadata attributes of the SubmodelElement
    limit = 56 # int | The maximum number of elements in the response array (optional)
    cursor = 'cursor_example' # str | A server-generated identifier retrieved from pagingMetadata that specifies from which position the result listing should continue (optional)
    level = core # str | Determines the structural depth of the respective resource content (optional) (default to core)

    try:
        # Updates the metadata attributes an existing SubmodelElement
        api_instance.patch_submodel_element_by_path_metadata(id_short_path, get_submodel_elements_metadata_result, limit=limit, cursor=cursor, level=level)
    except Exception as e:
        print("Exception when calling SubmodelServiceApi->patch_submodel_element_by_path_metadata: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id_short_path** | **str**| IdShort path to the submodel element (dot-separated) | 
 **get_submodel_elements_metadata_result** | [**GetSubmodelElementsMetadataResult**](GetSubmodelElementsMetadataResult.md)| Metadata attributes of the SubmodelElement | 
 **limit** | **int**| The maximum number of elements in the response array | [optional] 
 **cursor** | **str**| A server-generated identifier retrieved from pagingMetadata that specifies from which position the result listing should continue | [optional] 
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
**204** | SubmodelElement updated successfully |  -  |
**400** | Bad Request, e.g. the request parameters of the format of the request body is wrong. |  -  |
**401** | Unauthorized, e.g. the server refused the authorization attempt. |  -  |
**403** | Forbidden |  -  |
**404** | Not Found |  -  |
**500** | Internal Server Error |  -  |
**0** | Default error handling for unmentioned status codes |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **patch_submodel_element_value**
> patch_submodel_element_value(id_short_path, submodel_element_value, limit=limit, cursor=cursor, level=level)

Updates the value of an existing SubmodelElement

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
    api_instance = basyxclients.SubmodelServiceApi(api_client)
    id_short_path = 'id_short_path_example' # str | IdShort path to the submodel element (dot-separated)
    submodel_element_value = basyxclients.SubmodelElementValue() # SubmodelElementValue | The SubmodelElement in its ValueOnly representation
    limit = 56 # int | The maximum number of elements in the response array (optional)
    cursor = 'cursor_example' # str | A server-generated identifier retrieved from pagingMetadata that specifies from which position the result listing should continue (optional)
    level = core # str | Determines the structural depth of the respective resource content (optional) (default to core)

    try:
        # Updates the value of an existing SubmodelElement
        api_instance.patch_submodel_element_value(id_short_path, submodel_element_value, limit=limit, cursor=cursor, level=level)
    except Exception as e:
        print("Exception when calling SubmodelServiceApi->patch_submodel_element_value: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id_short_path** | **str**| IdShort path to the submodel element (dot-separated) | 
 **submodel_element_value** | [**SubmodelElementValue**](SubmodelElementValue.md)| The SubmodelElement in its ValueOnly representation | 
 **limit** | **int**| The maximum number of elements in the response array | [optional] 
 **cursor** | **str**| A server-generated identifier retrieved from pagingMetadata that specifies from which position the result listing should continue | [optional] 
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
> SubmodelElement post_submodel_element(submodel_element)

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
    api_instance = basyxclients.SubmodelServiceApi(api_client)
    submodel_element = basyxclients.SubmodelElement() # SubmodelElement | Requested submodel element

    try:
        # Creates a new submodel element
        api_response = api_instance.post_submodel_element(submodel_element)
        print("The response of SubmodelServiceApi->post_submodel_element:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling SubmodelServiceApi->post_submodel_element: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
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
**201** | Submodel element created successfully |  * Location - URL of the newly created resource <br>  |
**400** | Bad Request, e.g. the request parameters of the format of the request body is wrong. |  -  |
**401** | Unauthorized, e.g. the server refused the authorization attempt. |  -  |
**403** | Forbidden |  -  |
**409** | Conflict, a resource which shall be created exists already. Might be thrown if a Submodel or SubmodelElement with the same ShortId is contained in a POST request. |  -  |
**500** | Internal Server Error |  -  |
**0** | Default error handling for unmentioned status codes |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **post_submodel_element_by_path**
> SubmodelElement post_submodel_element_by_path(id_short_path, submodel_element)

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
    api_instance = basyxclients.SubmodelServiceApi(api_client)
    id_short_path = 'id_short_path_example' # str | IdShort path to the submodel element (dot-separated)
    submodel_element = basyxclients.SubmodelElement() # SubmodelElement | Requested submodel element

    try:
        # Creates a new submodel element at a specified path within submodel elements hierarchy
        api_response = api_instance.post_submodel_element_by_path(id_short_path, submodel_element)
        print("The response of SubmodelServiceApi->post_submodel_element_by_path:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling SubmodelServiceApi->post_submodel_element_by_path: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
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
**201** | Submodel element created successfully |  * Location - URL of the newly created resource <br>  |
**400** | Bad Request, e.g. the request parameters of the format of the request body is wrong. |  -  |
**401** | Unauthorized, e.g. the server refused the authorization attempt. |  -  |
**403** | Forbidden |  -  |
**404** | Not Found |  -  |
**409** | Conflict, a resource which shall be created exists already. Might be thrown if a Submodel or SubmodelElement with the same ShortId is contained in a POST request. |  -  |
**500** | Internal Server Error |  -  |
**0** | Default error handling for unmentioned status codes |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **put_file_by_path**
> put_file_by_path(id_short_path, file_name=file_name, file=file)

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
    api_instance = basyxclients.SubmodelServiceApi(api_client)
    id_short_path = 'id_short_path_example' # str | IdShort path to the submodel element (dot-separated)
    file_name = 'file_name_example' # str |  (optional)
    file = None # bytearray |  (optional)

    try:
        # Uploads file content to an existing submodel element at a specified path within submodel elements hierarchy
        api_instance.put_file_by_path(id_short_path, file_name=file_name, file=file)
    except Exception as e:
        print("Exception when calling SubmodelServiceApi->put_file_by_path: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
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
**405** | Method not allowed - Upload only valid for File submodel element |  -  |
**500** | Internal Server Error |  -  |
**0** | Default error handling for unmentioned status codes |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **put_submodel_element_by_path**
> put_submodel_element_by_path(id_short_path, submodel_element, level=level)

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
    api_instance = basyxclients.SubmodelServiceApi(api_client)
    id_short_path = 'id_short_path_example' # str | IdShort path to the submodel element (dot-separated)
    submodel_element = basyxclients.SubmodelElement() # SubmodelElement | Requested submodel element
    level = deep # str | Determines the structural depth of the respective resource content (optional) (default to deep)

    try:
        # Updates an existing submodel element at a specified path within submodel elements hierarchy
        api_instance.put_submodel_element_by_path(id_short_path, submodel_element, level=level)
    except Exception as e:
        print("Exception when calling SubmodelServiceApi->put_submodel_element_by_path: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id_short_path** | **str**| IdShort path to the submodel element (dot-separated) | 
 **submodel_element** | [**SubmodelElement**](SubmodelElement.md)| Requested submodel element | 
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

