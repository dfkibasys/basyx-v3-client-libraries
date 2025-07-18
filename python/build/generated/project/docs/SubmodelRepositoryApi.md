# basyxclients.SubmodelRepositoryApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**delete_file_attachment**](SubmodelRepositoryApi.md#delete_file_attachment) | **DELETE** /submodels/{submodelIdentifier}/submodel-elements/{idShortPath}/attachment | Deletes file content of an existing submodel element at a specified path within submodel elements hierarchy
[**delete_submodel**](SubmodelRepositoryApi.md#delete_submodel) | **DELETE** /submodels/{submodelIdentifier} | Deletes a Submodel
[**delete_submodel_element**](SubmodelRepositoryApi.md#delete_submodel_element) | **DELETE** /submodels/{submodelIdentifier}/submodel-elements/{idShortPath} | Deletes a submodel element at a specified path within the submodel elements hierarchy
[**get_all_submodel_elements**](SubmodelRepositoryApi.md#get_all_submodel_elements) | **GET** /submodels/{submodelIdentifier}/submodel-elements | Returns all submodel elements including their hierarchy
[**get_all_submodels**](SubmodelRepositoryApi.md#get_all_submodels) | **GET** /submodels | Returns all Submodels
[**get_description**](SubmodelRepositoryApi.md#get_description) | **GET** /description | Returns the self-describing information of a network resource (ServiceDescription)
[**get_file_attachment**](SubmodelRepositoryApi.md#get_file_attachment) | **GET** /submodels/{submodelIdentifier}/submodel-elements/{idShortPath}/attachment | Downloads file content from a specific submodel element from the Submodel at a specified path
[**get_submodel**](SubmodelRepositoryApi.md#get_submodel) | **GET** /submodels/{submodelIdentifier} | Returns a specific Submodel
[**get_submodel_element**](SubmodelRepositoryApi.md#get_submodel_element) | **GET** /submodels/{submodelIdentifier}/submodel-elements/{idShortPath} | Returns a specific submodel element from the Submodel at a specified path
[**get_submodel_element_value**](SubmodelRepositoryApi.md#get_submodel_element_value) | **GET** /submodels/{submodelIdentifier}/submodel-elements/{idShortPath}/$value | Returns a specific submodel element from the Submodel at a specified path in the ValueOnly representation
[**get_submodel_metadata**](SubmodelRepositoryApi.md#get_submodel_metadata) | **GET** /submodels/{submodelIdentifier}/$metadata | Returns the metadata attributes of a specific Submodel
[**invoke_operation**](SubmodelRepositoryApi.md#invoke_operation) | **POST** /submodels/{submodelIdentifier}/submodel-elements/{idShortPath}/invoke | Synchronously or asynchronously invokes an Operation at a specified path
[**patch_submodel_element_value**](SubmodelRepositoryApi.md#patch_submodel_element_value) | **PATCH** /submodels/{submodelIdentifier}/submodel-elements/{idShortPath}/$value | Updates the value of an existing SubmodelElement
[**post_submodel**](SubmodelRepositoryApi.md#post_submodel) | **POST** /submodels | Creates a new Submodel
[**post_submodel_element**](SubmodelRepositoryApi.md#post_submodel_element) | **POST** /submodels/{submodelIdentifier}/submodel-elements | Creates a new submodel element
[**post_submodel_element_under_path**](SubmodelRepositoryApi.md#post_submodel_element_under_path) | **POST** /submodels/{submodelIdentifier}/submodel-elements/{idShortPath} | Creates a new submodel element at a specified path within submodel elements hierarchy
[**put_file_attachment**](SubmodelRepositoryApi.md#put_file_attachment) | **PUT** /submodels/{submodelIdentifier}/submodel-elements/{idShortPath}/attachment | Uploads file content to an existing submodel element at a specified path within submodel elements hierarchy
[**put_submodel**](SubmodelRepositoryApi.md#put_submodel) | **PUT** /submodels/{submodelIdentifier} | Updates an existing Submodel
[**put_submodel_element**](SubmodelRepositoryApi.md#put_submodel_element) | **PUT** /submodels/{submodelIdentifier}/submodel-elements/{idShortPath} | Updates an existing submodel element at a specified path within submodel elements hierarchy


# **delete_file_attachment**
> delete_file_attachment(submodel_identifier, id_short_path)

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
    api_instance = basyxclients.SubmodelRepositoryApi(api_client)
    submodel_identifier = None # bytearray | The Submodel’s unique id (UTF8-BASE64-URL-encoded)
    id_short_path = 'id_short_path_example' # str | IdShort path to the submodel element (dot-separated)

    try:
        # Deletes file content of an existing submodel element at a specified path within submodel elements hierarchy
        api_instance.delete_file_attachment(submodel_identifier, id_short_path)
    except Exception as e:
        print("Exception when calling SubmodelRepositoryApi->delete_file_attachment: %s\n" % e)
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

# **delete_submodel**
> delete_submodel(submodel_identifier)

Deletes a Submodel

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
    api_instance = basyxclients.SubmodelRepositoryApi(api_client)
    submodel_identifier = None # bytearray | The Submodel’s unique id (UTF8-BASE64-URL-encoded)

    try:
        # Deletes a Submodel
        api_instance.delete_submodel(submodel_identifier)
    except Exception as e:
        print("Exception when calling SubmodelRepositoryApi->delete_submodel: %s\n" % e)
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

# **delete_submodel_element**
> delete_submodel_element(submodel_identifier, id_short_path)

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
    api_instance = basyxclients.SubmodelRepositoryApi(api_client)
    submodel_identifier = None # bytearray | The Submodel’s unique id (UTF8-BASE64-URL-encoded)
    id_short_path = 'id_short_path_example' # str | IdShort path to the submodel element (dot-separated)

    try:
        # Deletes a submodel element at a specified path within the submodel elements hierarchy
        api_instance.delete_submodel_element(submodel_identifier, id_short_path)
    except Exception as e:
        print("Exception when calling SubmodelRepositoryApi->delete_submodel_element: %s\n" % e)
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
    api_instance = basyxclients.SubmodelRepositoryApi(api_client)
    submodel_identifier = None # bytearray | The Submodel’s unique id (UTF8-BASE64-URL-encoded)
    limit = 56 # int | The maximum number of elements in the response array (optional)
    cursor = 'cursor_example' # str | A server-generated identifier retrieved from pagingMetadata that specifies from which position the result listing should continue (optional)
    level = deep # str | Determines the structural depth of the respective resource content (optional) (default to deep)
    extent = withoutBlobValue # str | Determines to which extent the resource is being serialized (optional) (default to withoutBlobValue)

    try:
        # Returns all submodel elements including their hierarchy
        api_response = api_instance.get_all_submodel_elements(submodel_identifier, limit=limit, cursor=cursor, level=level, extent=extent)
        print("The response of SubmodelRepositoryApi->get_all_submodel_elements:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling SubmodelRepositoryApi->get_all_submodel_elements: %s\n" % e)
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

# **get_all_submodels**
> GetSubmodelsResult get_all_submodels(semantic_id=semantic_id, id_short=id_short, limit=limit, cursor=cursor, level=level, extent=extent)

Returns all Submodels

### Example


```python
import basyxclients
from basyxclients.models.get_submodels_result import GetSubmodelsResult
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
    api_instance = basyxclients.SubmodelRepositoryApi(api_client)
    semantic_id = 'semantic_id_example' # str | The value of the semantic id reference (BASE64-URL-encoded) (optional)
    id_short = 'id_short_example' # str | The Asset Administration Shell's IdShort (optional)
    limit = 56 # int | The maximum number of elements in the response array (optional)
    cursor = 'cursor_example' # str | A server-generated identifier retrieved from pagingMetadata that specifies from which position the result listing should continue (optional)
    level = deep # str | Determines the structural depth of the respective resource content (optional) (default to deep)
    extent = withoutBlobValue # str | Determines to which extent the resource is being serialized (optional) (default to withoutBlobValue)

    try:
        # Returns all Submodels
        api_response = api_instance.get_all_submodels(semantic_id=semantic_id, id_short=id_short, limit=limit, cursor=cursor, level=level, extent=extent)
        print("The response of SubmodelRepositoryApi->get_all_submodels:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling SubmodelRepositoryApi->get_all_submodels: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **semantic_id** | **str**| The value of the semantic id reference (BASE64-URL-encoded) | [optional] 
 **id_short** | **str**| The Asset Administration Shell&#39;s IdShort | [optional] 
 **limit** | **int**| The maximum number of elements in the response array | [optional] 
 **cursor** | **str**| A server-generated identifier retrieved from pagingMetadata that specifies from which position the result listing should continue | [optional] 
 **level** | **str**| Determines the structural depth of the respective resource content | [optional] [default to deep]
 **extent** | **str**| Determines to which extent the resource is being serialized | [optional] [default to withoutBlobValue]

### Return type

[**GetSubmodelsResult**](GetSubmodelsResult.md)

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
    api_instance = basyxclients.SubmodelRepositoryApi(api_client)

    try:
        # Returns the self-describing information of a network resource (ServiceDescription)
        api_response = api_instance.get_description()
        print("The response of SubmodelRepositoryApi->get_description:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling SubmodelRepositoryApi->get_description: %s\n" % e)
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

# **get_file_attachment**
> bytearray get_file_attachment(submodel_identifier, id_short_path)

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
    api_instance = basyxclients.SubmodelRepositoryApi(api_client)
    submodel_identifier = None # bytearray | The Submodel’s unique id (UTF8-BASE64-URL-encoded)
    id_short_path = 'id_short_path_example' # str | IdShort path to the submodel element (dot-separated)

    try:
        # Downloads file content from a specific submodel element from the Submodel at a specified path
        api_response = api_instance.get_file_attachment(submodel_identifier, id_short_path)
        print("The response of SubmodelRepositoryApi->get_file_attachment:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling SubmodelRepositoryApi->get_file_attachment: %s\n" % e)
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
**405** | Method not allowed - Download only valid for File submodel element |  -  |
**500** | Internal Server Error |  -  |
**0** | Default error handling for unmentioned status codes |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_submodel**
> Submodel get_submodel(submodel_identifier, level=level, extent=extent)

Returns a specific Submodel

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
    api_instance = basyxclients.SubmodelRepositoryApi(api_client)
    submodel_identifier = None # bytearray | The Submodel’s unique id (UTF8-BASE64-URL-encoded)
    level = deep # str | Determines the structural depth of the respective resource content (optional) (default to deep)
    extent = withoutBlobValue # str | Determines to which extent the resource is being serialized (optional) (default to withoutBlobValue)

    try:
        # Returns a specific Submodel
        api_response = api_instance.get_submodel(submodel_identifier, level=level, extent=extent)
        print("The response of SubmodelRepositoryApi->get_submodel:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling SubmodelRepositoryApi->get_submodel: %s\n" % e)
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

# **get_submodel_element**
> SubmodelElement get_submodel_element(submodel_identifier, id_short_path, level=level, extent=extent)

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
    api_instance = basyxclients.SubmodelRepositoryApi(api_client)
    submodel_identifier = None # bytearray | The Submodel’s unique id (UTF8-BASE64-URL-encoded)
    id_short_path = 'id_short_path_example' # str | IdShort path to the submodel element (dot-separated)
    level = deep # str | Determines the structural depth of the respective resource content (optional) (default to deep)
    extent = withoutBlobValue # str | Determines to which extent the resource is being serialized (optional) (default to withoutBlobValue)

    try:
        # Returns a specific submodel element from the Submodel at a specified path
        api_response = api_instance.get_submodel_element(submodel_identifier, id_short_path, level=level, extent=extent)
        print("The response of SubmodelRepositoryApi->get_submodel_element:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling SubmodelRepositoryApi->get_submodel_element: %s\n" % e)
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

# **get_submodel_element_value**
> SubmodelElementValue get_submodel_element_value(submodel_identifier, id_short_path, level=level, extent=extent)

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
    api_instance = basyxclients.SubmodelRepositoryApi(api_client)
    submodel_identifier = None # bytearray | The Submodel’s unique id (UTF8-BASE64-URL-encoded)
    id_short_path = 'id_short_path_example' # str | IdShort path to the submodel element (dot-separated)
    level = deep # str | Determines the structural depth of the respective resource content (optional) (default to deep)
    extent = withoutBlobValue # str | Determines to which extent the resource is being serialized (optional) (default to withoutBlobValue)

    try:
        # Returns a specific submodel element from the Submodel at a specified path in the ValueOnly representation
        api_response = api_instance.get_submodel_element_value(submodel_identifier, id_short_path, level=level, extent=extent)
        print("The response of SubmodelRepositoryApi->get_submodel_element_value:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling SubmodelRepositoryApi->get_submodel_element_value: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **submodel_identifier** | **bytearray**| The Submodel’s unique id (UTF8-BASE64-URL-encoded) | 
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
> SubmodelMetadata get_submodel_metadata(submodel_identifier, level=level)

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
    api_instance = basyxclients.SubmodelRepositoryApi(api_client)
    submodel_identifier = None # bytearray | The Submodel’s unique id (UTF8-BASE64-URL-encoded)
    level = deep # str | Determines the structural depth of the respective resource content (optional) (default to deep)

    try:
        # Returns the metadata attributes of a specific Submodel
        api_response = api_instance.get_submodel_metadata(submodel_identifier, level=level)
        print("The response of SubmodelRepositoryApi->get_submodel_metadata:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling SubmodelRepositoryApi->get_submodel_metadata: %s\n" % e)
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
**200** | Requested Submodel in the metadata representation |  -  |
**400** | Bad Request, e.g. the request parameters of the format of the request body is wrong. |  -  |
**401** | Unauthorized, e.g. the server refused the authorization attempt. |  -  |
**403** | Forbidden |  -  |
**404** | Not Found |  -  |
**500** | Internal Server Error |  -  |
**0** | Default error handling for unmentioned status codes |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **invoke_operation**
> OperationResult invoke_operation(submodel_identifier, id_short_path, operation_request, var_async=var_async)

Synchronously or asynchronously invokes an Operation at a specified path

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
    api_instance = basyxclients.SubmodelRepositoryApi(api_client)
    submodel_identifier = None # bytearray | The Submodel’s unique id (UTF8-BASE64-URL-encoded)
    id_short_path = 'id_short_path_example' # str | IdShort path to the submodel element (dot-separated)
    operation_request = basyxclients.OperationRequest() # OperationRequest | Operation request object
    var_async = False # bool | Determines whether an operation invocation is performed asynchronously or synchronously (optional) (default to False)

    try:
        # Synchronously or asynchronously invokes an Operation at a specified path
        api_response = api_instance.invoke_operation(submodel_identifier, id_short_path, operation_request, var_async=var_async)
        print("The response of SubmodelRepositoryApi->invoke_operation:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling SubmodelRepositoryApi->invoke_operation: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **submodel_identifier** | **bytearray**| The Submodel’s unique id (UTF8-BASE64-URL-encoded) | 
 **id_short_path** | **str**| IdShort path to the submodel element (dot-separated) | 
 **operation_request** | [**OperationRequest**](OperationRequest.md)| Operation request object | 
 **var_async** | **bool**| Determines whether an operation invocation is performed asynchronously or synchronously | [optional] [default to False]

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

# **patch_submodel_element_value**
> patch_submodel_element_value(submodel_identifier, id_short_path, submodel_element_value, level=level)

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
    api_instance = basyxclients.SubmodelRepositoryApi(api_client)
    submodel_identifier = None # bytearray | The Submodel’s unique id (UTF8-BASE64-URL-encoded)
    id_short_path = 'id_short_path_example' # str | IdShort path to the submodel element (dot-separated)
    submodel_element_value = basyxclients.SubmodelElementValue() # SubmodelElementValue | The SubmodelElement in its ValueOnly representation
    level = core # str | Determines the structural depth of the respective resource content (optional) (default to core)

    try:
        # Updates the value of an existing SubmodelElement
        api_instance.patch_submodel_element_value(submodel_identifier, id_short_path, submodel_element_value, level=level)
    except Exception as e:
        print("Exception when calling SubmodelRepositoryApi->patch_submodel_element_value: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **submodel_identifier** | **bytearray**| The Submodel’s unique id (UTF8-BASE64-URL-encoded) | 
 **id_short_path** | **str**| IdShort path to the submodel element (dot-separated) | 
 **submodel_element_value** | [**SubmodelElementValue**](SubmodelElementValue.md)| The SubmodelElement in its ValueOnly representation | 
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

# **post_submodel**
> Submodel post_submodel(submodel)

Creates a new Submodel

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
    api_instance = basyxclients.SubmodelRepositoryApi(api_client)
    submodel = basyxclients.Submodel() # Submodel | Submodel object

    try:
        # Creates a new Submodel
        api_response = api_instance.post_submodel(submodel)
        print("The response of SubmodelRepositoryApi->post_submodel:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling SubmodelRepositoryApi->post_submodel: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **submodel** | [**Submodel**](Submodel.md)| Submodel object | 

### Return type

[**Submodel**](Submodel.md)

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
    api_instance = basyxclients.SubmodelRepositoryApi(api_client)
    submodel_identifier = None # bytearray | The Submodel’s unique id (UTF8-BASE64-URL-encoded)
    submodel_element = basyxclients.SubmodelElement() # SubmodelElement | Requested submodel element

    try:
        # Creates a new submodel element
        api_response = api_instance.post_submodel_element(submodel_identifier, submodel_element)
        print("The response of SubmodelRepositoryApi->post_submodel_element:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling SubmodelRepositoryApi->post_submodel_element: %s\n" % e)
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
**201** | Submodel element created successfully |  * Location - URL of the newly created resource <br>  |
**400** | Bad Request, e.g. the request parameters of the format of the request body is wrong. |  -  |
**401** | Unauthorized, e.g. the server refused the authorization attempt. |  -  |
**403** | Forbidden |  -  |
**404** | Not Found |  -  |
**409** | Conflict, a resource which shall be created exists already. Might be thrown if a Submodel or SubmodelElement with the same ShortId is contained in a POST request. |  -  |
**500** | Internal Server Error |  -  |
**0** | Default error handling for unmentioned status codes |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **post_submodel_element_under_path**
> SubmodelElement post_submodel_element_under_path(submodel_identifier, id_short_path, submodel_element)

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
    api_instance = basyxclients.SubmodelRepositoryApi(api_client)
    submodel_identifier = None # bytearray | The Submodel’s unique id (UTF8-BASE64-URL-encoded)
    id_short_path = 'id_short_path_example' # str | IdShort path to the submodel element (dot-separated)
    submodel_element = basyxclients.SubmodelElement() # SubmodelElement | Requested submodel element

    try:
        # Creates a new submodel element at a specified path within submodel elements hierarchy
        api_response = api_instance.post_submodel_element_under_path(submodel_identifier, id_short_path, submodel_element)
        print("The response of SubmodelRepositoryApi->post_submodel_element_under_path:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling SubmodelRepositoryApi->post_submodel_element_under_path: %s\n" % e)
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
**201** | Submodel element created successfully |  * Location - URL of the newly created resource <br>  |
**400** | Bad Request, e.g. the request parameters of the format of the request body is wrong. |  -  |
**401** | Unauthorized, e.g. the server refused the authorization attempt. |  -  |
**403** | Forbidden |  -  |
**404** | Not Found |  -  |
**409** | Conflict, a resource which shall be created exists already. Might be thrown if a Submodel or SubmodelElement with the same ShortId is contained in a POST request. |  -  |
**500** | Internal Server Error |  -  |
**0** | Default error handling for unmentioned status codes |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **put_file_attachment**
> put_file_attachment(submodel_identifier, id_short_path, file_name=file_name, file=file)

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
    api_instance = basyxclients.SubmodelRepositoryApi(api_client)
    submodel_identifier = None # bytearray | The Submodel’s unique id (UTF8-BASE64-URL-encoded)
    id_short_path = 'id_short_path_example' # str | IdShort path to the submodel element (dot-separated)
    file_name = 'file_name_example' # str |  (optional)
    file = None # bytearray |  (optional)

    try:
        # Uploads file content to an existing submodel element at a specified path within submodel elements hierarchy
        api_instance.put_file_attachment(submodel_identifier, id_short_path, file_name=file_name, file=file)
    except Exception as e:
        print("Exception when calling SubmodelRepositoryApi->put_file_attachment: %s\n" % e)
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
**405** | Method not allowed - Upload only valid for File submodel element |  -  |
**500** | Internal Server Error |  -  |
**0** | Default error handling for unmentioned status codes |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **put_submodel**
> put_submodel(submodel_identifier, submodel)

Updates an existing Submodel

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
    api_instance = basyxclients.SubmodelRepositoryApi(api_client)
    submodel_identifier = None # bytearray | The Submodel’s unique id (UTF8-BASE64-URL-encoded)
    submodel = basyxclients.Submodel() # Submodel | Submodel object

    try:
        # Updates an existing Submodel
        api_instance.put_submodel(submodel_identifier, submodel)
    except Exception as e:
        print("Exception when calling SubmodelRepositoryApi->put_submodel: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **submodel_identifier** | **bytearray**| The Submodel’s unique id (UTF8-BASE64-URL-encoded) | 
 **submodel** | [**Submodel**](Submodel.md)| Submodel object | 

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

# **put_submodel_element**
> put_submodel_element(submodel_identifier, id_short_path, submodel_element, level=level)

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
    api_instance = basyxclients.SubmodelRepositoryApi(api_client)
    submodel_identifier = None # bytearray | The Submodel’s unique id (UTF8-BASE64-URL-encoded)
    id_short_path = 'id_short_path_example' # str | IdShort path to the submodel element (dot-separated)
    submodel_element = basyxclients.SubmodelElement() # SubmodelElement | Requested submodel element
    level = deep # str | Determines the structural depth of the respective resource content (optional) (default to deep)

    try:
        # Updates an existing submodel element at a specified path within submodel elements hierarchy
        api_instance.put_submodel_element(submodel_identifier, id_short_path, submodel_element, level=level)
    except Exception as e:
        print("Exception when calling SubmodelRepositoryApi->put_submodel_element: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **submodel_identifier** | **bytearray**| The Submodel’s unique id (UTF8-BASE64-URL-encoded) | 
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

