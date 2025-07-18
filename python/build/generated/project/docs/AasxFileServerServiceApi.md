# basyxclients.AasxFileServerServiceApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**delete_aasxby_package_id**](AasxFileServerServiceApi.md#delete_aasxby_package_id) | **DELETE** /packages/{packageId} | Deletes a specific AASX package from the server
[**get_aasxby_package_id**](AasxFileServerServiceApi.md#get_aasxby_package_id) | **GET** /packages/{packageId} | Returns a specific AASX package from the server
[**get_all_aasx_package_ids**](AasxFileServerServiceApi.md#get_all_aasx_package_ids) | **GET** /packages | Returns a list of available AASX packages at the server
[**get_description**](AasxFileServerServiceApi.md#get_description) | **GET** /description | Returns the self-describing information of a network resource (ServiceDescription)
[**post_aasx_package**](AasxFileServerServiceApi.md#post_aasx_package) | **POST** /packages | Stores the AASX package at the server
[**put_aasxby_package_id**](AasxFileServerServiceApi.md#put_aasxby_package_id) | **PUT** /packages/{packageId} | Updates the AASX package at the server


# **delete_aasxby_package_id**
> delete_aasxby_package_id(package_id)

Deletes a specific AASX package from the server

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
    api_instance = basyxclients.AasxFileServerServiceApi(api_client)
    package_id = None # bytearray | The package Id (UTF8-BASE64-URL-encoded)

    try:
        # Deletes a specific AASX package from the server
        api_instance.delete_aasxby_package_id(package_id)
    except Exception as e:
        print("Exception when calling AasxFileServerServiceApi->delete_aasxby_package_id: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **package_id** | **bytearray**| The package Id (UTF8-BASE64-URL-encoded) | 

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
**204** | Deleted successfully |  -  |
**400** | Bad Request, e.g. the request parameters of the format of the request body is wrong. |  -  |
**401** | Unauthorized, e.g. the server refused the authorization attempt. |  -  |
**403** | Forbidden |  -  |
**404** | Not Found |  -  |
**500** | Internal Server Error |  -  |
**0** | Default error handling for unmentioned status codes |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_aasxby_package_id**
> bytearray get_aasxby_package_id(package_id)

Returns a specific AASX package from the server

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
    api_instance = basyxclients.AasxFileServerServiceApi(api_client)
    package_id = None # bytearray | The package Id (UTF8-BASE64-URL-encoded)

    try:
        # Returns a specific AASX package from the server
        api_response = api_instance.get_aasxby_package_id(package_id)
        print("The response of AasxFileServerServiceApi->get_aasxby_package_id:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling AasxFileServerServiceApi->get_aasxby_package_id: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **package_id** | **bytearray**| The package Id (UTF8-BASE64-URL-encoded) | 

### Return type

**bytearray**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/asset-administration-shell-package, application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Requested AASX package |  * X-FileName - Filename of the package <br>  |
**400** | Bad Request, e.g. the request parameters of the format of the request body is wrong. |  -  |
**401** | Unauthorized, e.g. the server refused the authorization attempt. |  -  |
**403** | Forbidden |  -  |
**404** | Not Found |  -  |
**500** | Internal Server Error |  -  |
**0** | Default error handling for unmentioned status codes |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_all_aasx_package_ids**
> GetPackageDescriptionsResult get_all_aasx_package_ids(aas_id=aas_id, limit=limit, cursor=cursor)

Returns a list of available AASX packages at the server

### Example


```python
import basyxclients
from basyxclients.models.get_package_descriptions_result import GetPackageDescriptionsResult
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
    api_instance = basyxclients.AasxFileServerServiceApi(api_client)
    aas_id = None # bytearray | The Asset Administration Shell’s unique id (UTF8-BASE64-URL-encoded) (optional)
    limit = 56 # int | The maximum number of elements in the response array (optional)
    cursor = 'cursor_example' # str | A server-generated identifier retrieved from pagingMetadata that specifies from which position the result listing should continue (optional)

    try:
        # Returns a list of available AASX packages at the server
        api_response = api_instance.get_all_aasx_package_ids(aas_id=aas_id, limit=limit, cursor=cursor)
        print("The response of AasxFileServerServiceApi->get_all_aasx_package_ids:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling AasxFileServerServiceApi->get_all_aasx_package_ids: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **aas_id** | **bytearray**| The Asset Administration Shell’s unique id (UTF8-BASE64-URL-encoded) | [optional] 
 **limit** | **int**| The maximum number of elements in the response array | [optional] 
 **cursor** | **str**| A server-generated identifier retrieved from pagingMetadata that specifies from which position the result listing should continue | [optional] 

### Return type

[**GetPackageDescriptionsResult**](GetPackageDescriptionsResult.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Requested package list |  -  |
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
    api_instance = basyxclients.AasxFileServerServiceApi(api_client)

    try:
        # Returns the self-describing information of a network resource (ServiceDescription)
        api_response = api_instance.get_description()
        print("The response of AasxFileServerServiceApi->get_description:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling AasxFileServerServiceApi->get_description: %s\n" % e)
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
**400** | Bad Request, e.g. the request parameters of the format of the request body is wrong. |  -  |
**403** | Forbidden |  -  |
**404** | Not Found |  -  |
**500** | Internal Server Error |  -  |
**0** | Default error handling for unmentioned status codes |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **post_aasx_package**
> PackageDescription post_aasx_package(aas_ids=aas_ids, file=file, file_name=file_name)

Stores the AASX package at the server

### Example


```python
import basyxclients
from basyxclients.models.package_description import PackageDescription
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
    api_instance = basyxclients.AasxFileServerServiceApi(api_client)
    aas_ids = ['aas_ids_example'] # List[str] |  (optional)
    file = None # bytearray |  (optional)
    file_name = 'file_name_example' # str |  (optional)

    try:
        # Stores the AASX package at the server
        api_response = api_instance.post_aasx_package(aas_ids=aas_ids, file=file, file_name=file_name)
        print("The response of AasxFileServerServiceApi->post_aasx_package:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling AasxFileServerServiceApi->post_aasx_package: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **aas_ids** | [**List[str]**](str.md)|  | [optional] 
 **file** | **bytearray**|  | [optional] 
 **file_name** | **str**|  | [optional] 

### Return type

[**PackageDescription**](PackageDescription.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: multipart/form-data
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**201** | AASX package stored successfully |  * Location - URL of the newly created resource <br>  |
**400** | Bad Request, e.g. the request parameters of the format of the request body is wrong. |  -  |
**401** | Unauthorized, e.g. the server refused the authorization attempt. |  -  |
**403** | Forbidden |  -  |
**409** | Conflict, a resource which shall be created exists already. Might be thrown if a Submodel or SubmodelElement with the same ShortId is contained in a POST request. |  -  |
**500** | Internal Server Error |  -  |
**0** | Default error handling for unmentioned status codes |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **put_aasxby_package_id**
> put_aasxby_package_id(package_id, aas_ids=aas_ids, file=file, file_name=file_name)

Updates the AASX package at the server

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
    api_instance = basyxclients.AasxFileServerServiceApi(api_client)
    package_id = None # bytearray | The package Id (UTF8-BASE64-URL-encoded)
    aas_ids = ['aas_ids_example'] # List[str] |  (optional)
    file = None # bytearray |  (optional)
    file_name = 'file_name_example' # str |  (optional)

    try:
        # Updates the AASX package at the server
        api_instance.put_aasxby_package_id(package_id, aas_ids=aas_ids, file=file, file_name=file_name)
    except Exception as e:
        print("Exception when calling AasxFileServerServiceApi->put_aasxby_package_id: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **package_id** | **bytearray**| The package Id (UTF8-BASE64-URL-encoded) | 
 **aas_ids** | [**List[str]**](str.md)|  | [optional] 
 **file** | **bytearray**|  | [optional] 
 **file_name** | **str**|  | [optional] 

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
**204** | AASX package updated successfully |  -  |
**400** | Bad Request, e.g. the request parameters of the format of the request body is wrong. |  -  |
**401** | Unauthorized, e.g. the server refused the authorization attempt. |  -  |
**403** | Forbidden |  -  |
**404** | Not Found |  -  |
**500** | Internal Server Error |  -  |
**0** | Default error handling for unmentioned status codes |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

