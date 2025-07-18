# basyxclients.AssetAdministrationShellBasicDiscoveryApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**delete_asset_links_by_shell_id**](AssetAdministrationShellBasicDiscoveryApi.md#delete_asset_links_by_shell_id) | **DELETE** /lookup/shells/{aasIdentifier} | Deletes all specific Asset identifiers linked to an Asset Administration Shell to edit discoverable content
[**get_all_shell_ids_by_asset_links**](AssetAdministrationShellBasicDiscoveryApi.md#get_all_shell_ids_by_asset_links) | **GET** /lookup/shells | Returns a list of Asset Administration Shell ids linked to specific Asset identifiers
[**get_asset_links_by_shell_id**](AssetAdministrationShellBasicDiscoveryApi.md#get_asset_links_by_shell_id) | **GET** /lookup/shells/{aasIdentifier} | Returns a list of specific Asset identifiers based on an Asset Administration Shell id to edit discoverable content
[**get_description**](AssetAdministrationShellBasicDiscoveryApi.md#get_description) | **GET** /description | Returns the self-describing information of a network resource (ServiceDescription)
[**post_asset_links_by_shell_id**](AssetAdministrationShellBasicDiscoveryApi.md#post_asset_links_by_shell_id) | **POST** /lookup/shells/{aasIdentifier} | Creates specific Asset identifiers linked to an Asset Administration Shell to edit discoverable content


# **delete_asset_links_by_shell_id**
> delete_asset_links_by_shell_id(aas_identifier)

Deletes all specific Asset identifiers linked to an Asset Administration Shell to edit discoverable content

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
    api_instance = basyxclients.AssetAdministrationShellBasicDiscoveryApi(api_client)
    aas_identifier = None # bytearray | The Asset Administration Shell’s unique id (UTF8-BASE64-URL-encoded)

    try:
        # Deletes all specific Asset identifiers linked to an Asset Administration Shell to edit discoverable content
        api_instance.delete_asset_links_by_shell_id(aas_identifier)
    except Exception as e:
        print("Exception when calling AssetAdministrationShellBasicDiscoveryApi->delete_asset_links_by_shell_id: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **aas_identifier** | **bytearray**| The Asset Administration Shell’s unique id (UTF8-BASE64-URL-encoded) | 

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
**204** | Specific Asset identifiers deleted successfully |  -  |
**404** | Not Found |  -  |
**0** | Default error handling for unmentioned status codes |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_all_shell_ids_by_asset_links**
> GetAllAssetLinksResult get_all_shell_ids_by_asset_links(asset_ids=asset_ids, limit=limit, cursor=cursor)

Returns a list of Asset Administration Shell ids linked to specific Asset identifiers

### Example


```python
import basyxclients
from basyxclients.models.get_all_asset_links_result import GetAllAssetLinksResult
from basyxclients.models.specific_asset_id import SpecificAssetId
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
    api_instance = basyxclients.AssetAdministrationShellBasicDiscoveryApi(api_client)
    asset_ids = [basyxclients.SpecificAssetId()] # List[SpecificAssetId] | A list of specific Asset identifiers. Each Asset identifier is a base64-url-encoded [SpecificAssetId](./model-part1.yaml#/components/schemas/SpecificAssetId) (optional)
    limit = 56 # int | The maximum number of elements in the response array (optional)
    cursor = 'cursor_example' # str | A server-generated identifier retrieved from pagingMetadata that specifies from which position the result listing should continue (optional)

    try:
        # Returns a list of Asset Administration Shell ids linked to specific Asset identifiers
        api_response = api_instance.get_all_shell_ids_by_asset_links(asset_ids=asset_ids, limit=limit, cursor=cursor)
        print("The response of AssetAdministrationShellBasicDiscoveryApi->get_all_shell_ids_by_asset_links:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling AssetAdministrationShellBasicDiscoveryApi->get_all_shell_ids_by_asset_links: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **asset_ids** | [**List[SpecificAssetId]**](SpecificAssetId.md)| A list of specific Asset identifiers. Each Asset identifier is a base64-url-encoded [SpecificAssetId](./model-part1.yaml#/components/schemas/SpecificAssetId) | [optional] 
 **limit** | **int**| The maximum number of elements in the response array | [optional] 
 **cursor** | **str**| A server-generated identifier retrieved from pagingMetadata that specifies from which position the result listing should continue | [optional] 

### Return type

[**GetAllAssetLinksResult**](GetAllAssetLinksResult.md)

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

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_asset_links_by_shell_id**
> List[SpecificAssetId] get_asset_links_by_shell_id(aas_identifier)

Returns a list of specific Asset identifiers based on an Asset Administration Shell id to edit discoverable content

### Example


```python
import basyxclients
from basyxclients.models.specific_asset_id import SpecificAssetId
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
    api_instance = basyxclients.AssetAdministrationShellBasicDiscoveryApi(api_client)
    aas_identifier = None # bytearray | The Asset Administration Shell’s unique id (UTF8-BASE64-URL-encoded)

    try:
        # Returns a list of specific Asset identifiers based on an Asset Administration Shell id to edit discoverable content
        api_response = api_instance.get_asset_links_by_shell_id(aas_identifier)
        print("The response of AssetAdministrationShellBasicDiscoveryApi->get_asset_links_by_shell_id:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling AssetAdministrationShellBasicDiscoveryApi->get_asset_links_by_shell_id: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **aas_identifier** | **bytearray**| The Asset Administration Shell’s unique id (UTF8-BASE64-URL-encoded) | 

### Return type

[**List[SpecificAssetId]**](SpecificAssetId.md)

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
    api_instance = basyxclients.AssetAdministrationShellBasicDiscoveryApi(api_client)

    try:
        # Returns the self-describing information of a network resource (ServiceDescription)
        api_response = api_instance.get_description()
        print("The response of AssetAdministrationShellBasicDiscoveryApi->get_description:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling AssetAdministrationShellBasicDiscoveryApi->get_description: %s\n" % e)
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
**0** | Default error handling for unmentioned status codes |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **post_asset_links_by_shell_id**
> List[SpecificAssetId] post_asset_links_by_shell_id(aas_identifier, specific_asset_id)

Creates specific Asset identifiers linked to an Asset Administration Shell to edit discoverable content

### Example


```python
import basyxclients
from basyxclients.models.specific_asset_id import SpecificAssetId
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
    api_instance = basyxclients.AssetAdministrationShellBasicDiscoveryApi(api_client)
    aas_identifier = None # bytearray | The Asset Administration Shell’s unique id (UTF8-BASE64-URL-encoded)
    specific_asset_id = [basyxclients.SpecificAssetId()] # List[SpecificAssetId] | A list of specific Asset identifiers

    try:
        # Creates specific Asset identifiers linked to an Asset Administration Shell to edit discoverable content
        api_response = api_instance.post_asset_links_by_shell_id(aas_identifier, specific_asset_id)
        print("The response of AssetAdministrationShellBasicDiscoveryApi->post_asset_links_by_shell_id:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling AssetAdministrationShellBasicDiscoveryApi->post_asset_links_by_shell_id: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **aas_identifier** | **bytearray**| The Asset Administration Shell’s unique id (UTF8-BASE64-URL-encoded) | 
 **specific_asset_id** | [**List[SpecificAssetId]**](SpecificAssetId.md)| A list of specific Asset identifiers | 

### Return type

[**List[SpecificAssetId]**](SpecificAssetId.md)

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

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

