# basyxclients.SubmodelRegistryApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**delete_submodel_descriptor_by_id**](SubmodelRegistryApi.md#delete_submodel_descriptor_by_id) | **DELETE** /submodel-descriptors/{submodelIdentifier} | Deletes a Submodel Descriptor, i.e. de-registers a submodel
[**get_all_submodel_descriptors**](SubmodelRegistryApi.md#get_all_submodel_descriptors) | **GET** /submodel-descriptors | Returns all Submodel Descriptors
[**get_description**](SubmodelRegistryApi.md#get_description) | **GET** /description | Returns the self-describing information of a network resource (ServiceDescription)
[**get_submodel_descriptor_by_id**](SubmodelRegistryApi.md#get_submodel_descriptor_by_id) | **GET** /submodel-descriptors/{submodelIdentifier} | Returns a specific Submodel Descriptor
[**post_submodel_descriptor**](SubmodelRegistryApi.md#post_submodel_descriptor) | **POST** /submodel-descriptors | Creates a new Submodel Descriptor, i.e. registers a submodel
[**put_submodel_descriptor_by_id**](SubmodelRegistryApi.md#put_submodel_descriptor_by_id) | **PUT** /submodel-descriptors/{submodelIdentifier} | Updates an existing Submodel Descriptor


# **delete_submodel_descriptor_by_id**
> delete_submodel_descriptor_by_id(submodel_identifier)

Deletes a Submodel Descriptor, i.e. de-registers a submodel

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
    api_instance = basyxclients.SubmodelRegistryApi(api_client)
    submodel_identifier = None # bytearray | The Submodel’s unique id (UTF8-BASE64-URL-encoded)

    try:
        # Deletes a Submodel Descriptor, i.e. de-registers a submodel
        api_instance.delete_submodel_descriptor_by_id(submodel_identifier)
    except Exception as e:
        print("Exception when calling SubmodelRegistryApi->delete_submodel_descriptor_by_id: %s\n" % e)
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
**204** | Submodel Descriptor deleted successfully |  -  |
**400** | Bad Request, e.g. the request parameters of the format of the request body is wrong. |  -  |
**403** | Forbidden |  -  |
**404** | Not Found |  -  |
**500** | Internal Server Error |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_all_submodel_descriptors**
> GetSubmodelDescriptorsResult get_all_submodel_descriptors(limit=limit, cursor=cursor)

Returns all Submodel Descriptors

### Example


```python
import basyxclients
from basyxclients.models.get_submodel_descriptors_result import GetSubmodelDescriptorsResult
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
    api_instance = basyxclients.SubmodelRegistryApi(api_client)
    limit = 56 # int | The maximum number of elements in the response array (optional)
    cursor = 'cursor_example' # str | A server-generated identifier retrieved from pagingMetadata that specifies from which position the result listing should continue (optional)

    try:
        # Returns all Submodel Descriptors
        api_response = api_instance.get_all_submodel_descriptors(limit=limit, cursor=cursor)
        print("The response of SubmodelRegistryApi->get_all_submodel_descriptors:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling SubmodelRegistryApi->get_all_submodel_descriptors: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **limit** | **int**| The maximum number of elements in the response array | [optional] 
 **cursor** | **str**| A server-generated identifier retrieved from pagingMetadata that specifies from which position the result listing should continue | [optional] 

### Return type

[**GetSubmodelDescriptorsResult**](GetSubmodelDescriptorsResult.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Requested Submodel Descriptors |  -  |
**400** | Bad Request, e.g. the request parameters of the format of the request body is wrong. |  -  |
**403** | Forbidden |  -  |
**404** | Not Found |  -  |
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
    api_instance = basyxclients.SubmodelRegistryApi(api_client)

    try:
        # Returns the self-describing information of a network resource (ServiceDescription)
        api_response = api_instance.get_description()
        print("The response of SubmodelRegistryApi->get_description:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling SubmodelRegistryApi->get_description: %s\n" % e)
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
**403** | Forbidden |  -  |
**0** | Default error handling for unmentioned status codes |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_submodel_descriptor_by_id**
> SubmodelDescriptor get_submodel_descriptor_by_id(submodel_identifier)

Returns a specific Submodel Descriptor

### Example


```python
import basyxclients
from basyxclients.models.submodel_descriptor import SubmodelDescriptor
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
    api_instance = basyxclients.SubmodelRegistryApi(api_client)
    submodel_identifier = None # bytearray | The Submodel’s unique id (UTF8-BASE64-URL-encoded)

    try:
        # Returns a specific Submodel Descriptor
        api_response = api_instance.get_submodel_descriptor_by_id(submodel_identifier)
        print("The response of SubmodelRegistryApi->get_submodel_descriptor_by_id:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling SubmodelRegistryApi->get_submodel_descriptor_by_id: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **submodel_identifier** | **bytearray**| The Submodel’s unique id (UTF8-BASE64-URL-encoded) | 

### Return type

[**SubmodelDescriptor**](SubmodelDescriptor.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Requested Submodel Descriptor |  -  |
**400** | Bad Request, e.g. the request parameters of the format of the request body is wrong. |  -  |
**403** | Forbidden |  -  |
**404** | Not Found |  -  |
**500** | Internal Server Error |  -  |
**0** | Default error handling for unmentioned status codes |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **post_submodel_descriptor**
> SubmodelDescriptor post_submodel_descriptor(submodel_descriptor)

Creates a new Submodel Descriptor, i.e. registers a submodel

### Example


```python
import basyxclients
from basyxclients.models.submodel_descriptor import SubmodelDescriptor
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
    api_instance = basyxclients.SubmodelRegistryApi(api_client)
    submodel_descriptor = basyxclients.SubmodelDescriptor() # SubmodelDescriptor | Submodel Descriptor object

    try:
        # Creates a new Submodel Descriptor, i.e. registers a submodel
        api_response = api_instance.post_submodel_descriptor(submodel_descriptor)
        print("The response of SubmodelRegistryApi->post_submodel_descriptor:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling SubmodelRegistryApi->post_submodel_descriptor: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **submodel_descriptor** | [**SubmodelDescriptor**](SubmodelDescriptor.md)| Submodel Descriptor object | 

### Return type

[**SubmodelDescriptor**](SubmodelDescriptor.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**201** | Submodel Descriptor created successfully |  * Location - URL of the newly created resource <br>  |
**400** | Bad Request, e.g. the request parameters of the format of the request body is wrong. |  -  |
**403** | Forbidden |  -  |
**409** | Conflict, a resource which shall be created exists already. Might be thrown if a Submodel or SubmodelElement with the same ShortId is contained in a POST request. |  -  |
**0** | Default error handling for unmentioned status codes |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **put_submodel_descriptor_by_id**
> put_submodel_descriptor_by_id(submodel_identifier, submodel_descriptor)

Updates an existing Submodel Descriptor

### Example


```python
import basyxclients
from basyxclients.models.submodel_descriptor import SubmodelDescriptor
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
    api_instance = basyxclients.SubmodelRegistryApi(api_client)
    submodel_identifier = None # bytearray | The Submodel’s unique id (UTF8-BASE64-URL-encoded)
    submodel_descriptor = basyxclients.SubmodelDescriptor() # SubmodelDescriptor | Submodel Descriptor object

    try:
        # Updates an existing Submodel Descriptor
        api_instance.put_submodel_descriptor_by_id(submodel_identifier, submodel_descriptor)
    except Exception as e:
        print("Exception when calling SubmodelRegistryApi->put_submodel_descriptor_by_id: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **submodel_identifier** | **bytearray**| The Submodel’s unique id (UTF8-BASE64-URL-encoded) | 
 **submodel_descriptor** | [**SubmodelDescriptor**](SubmodelDescriptor.md)| Submodel Descriptor object | 

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
**204** | Submodel Descriptor updated successfully |  -  |
**400** | Bad Request, e.g. the request parameters of the format of the request body is wrong. |  -  |
**403** | Forbidden |  -  |
**404** | Not Found |  -  |
**500** | Internal Server Error |  -  |
**0** | Default error handling for unmentioned status codes |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

