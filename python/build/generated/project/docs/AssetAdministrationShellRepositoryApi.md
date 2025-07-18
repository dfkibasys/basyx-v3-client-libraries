# basyxclients.AssetAdministrationShellRepositoryApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**delete_asset_administration_shell**](AssetAdministrationShellRepositoryApi.md#delete_asset_administration_shell) | **DELETE** /shells/{aasIdentifier} | Deletes an Asset Administration Shell
[**delete_submodel_reference**](AssetAdministrationShellRepositoryApi.md#delete_submodel_reference) | **DELETE** /shells/{aasIdentifier}/submodel-refs/{submodelIdentifier} | Deletes the submodel reference from the Asset Administration Shell. Does not delete the submodel itself!
[**delete_thumbnail**](AssetAdministrationShellRepositoryApi.md#delete_thumbnail) | **DELETE** /shells/{aasIdentifier}/asset-information/thumbnail | 
[**get_all_asset_administration_shells**](AssetAdministrationShellRepositoryApi.md#get_all_asset_administration_shells) | **GET** /shells | Returns all Asset Administration Shells
[**get_all_submodel_references**](AssetAdministrationShellRepositoryApi.md#get_all_submodel_references) | **GET** /shells/{aasIdentifier}/submodel-refs | Returns all submodel references
[**get_asset_administration_shell**](AssetAdministrationShellRepositoryApi.md#get_asset_administration_shell) | **GET** /shells/{aasIdentifier} | Returns a specific Asset Administration Shell
[**get_asset_information**](AssetAdministrationShellRepositoryApi.md#get_asset_information) | **GET** /shells/{aasIdentifier}/asset-information | Returns the Asset Information
[**get_description**](AssetAdministrationShellRepositoryApi.md#get_description) | **GET** /description | Returns the self-describing information of a network resource (ServiceDescription)
[**get_thumbnail**](AssetAdministrationShellRepositoryApi.md#get_thumbnail) | **GET** /shells/{aasIdentifier}/asset-information/thumbnail | 
[**post_asset_administration_shell**](AssetAdministrationShellRepositoryApi.md#post_asset_administration_shell) | **POST** /shells | Creates a new Asset Administration Shell
[**post_submodel_reference**](AssetAdministrationShellRepositoryApi.md#post_submodel_reference) | **POST** /shells/{aasIdentifier}/submodel-refs | Creates a submodel reference at the Asset Administration Shell
[**put_asset_administration_shell**](AssetAdministrationShellRepositoryApi.md#put_asset_administration_shell) | **PUT** /shells/{aasIdentifier} | Updates an existing Asset Administration Shell
[**put_asset_information**](AssetAdministrationShellRepositoryApi.md#put_asset_information) | **PUT** /shells/{aasIdentifier}/asset-information | Updates the Asset Information
[**put_thumbnail**](AssetAdministrationShellRepositoryApi.md#put_thumbnail) | **PUT** /shells/{aasIdentifier}/asset-information/thumbnail | 


# **delete_asset_administration_shell**
> delete_asset_administration_shell(aas_identifier)

Deletes an Asset Administration Shell

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
    api_instance = basyxclients.AssetAdministrationShellRepositoryApi(api_client)
    aas_identifier = None # bytearray | The Asset Administration Shell’s unique id (UTF8-BASE64-URL-encoded)

    try:
        # Deletes an Asset Administration Shell
        api_instance.delete_asset_administration_shell(aas_identifier)
    except Exception as e:
        print("Exception when calling AssetAdministrationShellRepositoryApi->delete_asset_administration_shell: %s\n" % e)
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
**204** | Asset Administration Shell deleted successfully |  -  |
**401** | Unauthorized, e.g. the server refused the authorization attempt. |  -  |
**403** | Forbidden |  -  |
**404** | Not Found |  -  |
**500** | Internal Server Error |  -  |
**0** | Default error handling for unmentioned status codes |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **delete_submodel_reference**
> delete_submodel_reference(aas_identifier, submodel_identifier)

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
    api_instance = basyxclients.AssetAdministrationShellRepositoryApi(api_client)
    aas_identifier = None # bytearray | The Asset Administration Shell’s unique id (UTF8-BASE64-URL-encoded)
    submodel_identifier = None # bytearray | The Submodel’s unique id (UTF8-BASE64-URL-encoded)

    try:
        # Deletes the submodel reference from the Asset Administration Shell. Does not delete the submodel itself!
        api_instance.delete_submodel_reference(aas_identifier, submodel_identifier)
    except Exception as e:
        print("Exception when calling AssetAdministrationShellRepositoryApi->delete_submodel_reference: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **aas_identifier** | **bytearray**| The Asset Administration Shell’s unique id (UTF8-BASE64-URL-encoded) | 
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
> delete_thumbnail(aas_identifier)

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
    api_instance = basyxclients.AssetAdministrationShellRepositoryApi(api_client)
    aas_identifier = None # bytearray | The Asset Administration Shell’s unique id (UTF8-BASE64-URL-encoded)

    try:
        api_instance.delete_thumbnail(aas_identifier)
    except Exception as e:
        print("Exception when calling AssetAdministrationShellRepositoryApi->delete_thumbnail: %s\n" % e)
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
**200** | Thumbnail deletion successful |  -  |
**400** | Bad Request, e.g. the request parameters of the format of the request body is wrong. |  -  |
**401** | Unauthorized, e.g. the server refused the authorization attempt. |  -  |
**403** | Forbidden |  -  |
**404** | Not Found |  -  |
**500** | Internal Server Error |  -  |
**0** | Default error handling for unmentioned status codes |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_all_asset_administration_shells**
> GetAssetAdministrationShellsResult get_all_asset_administration_shells(asset_ids=asset_ids, id_short=id_short, limit=limit, cursor=cursor)

Returns all Asset Administration Shells

### Example


```python
import basyxclients
from basyxclients.models.get_asset_administration_shells_result import GetAssetAdministrationShellsResult
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
    api_instance = basyxclients.AssetAdministrationShellRepositoryApi(api_client)
    asset_ids = [basyxclients.SpecificAssetId()] # List[SpecificAssetId] | A list of specific Asset identifiers. Each Asset identifier is a base64-url-encoded [SpecificAssetId](./model-part1.yaml#/components/schemas/SpecificAssetId) (optional)
    id_short = 'id_short_example' # str | The Asset Administration Shell's IdShort (optional)
    limit = 56 # int | The maximum number of elements in the response array (optional)
    cursor = 'cursor_example' # str | A server-generated identifier retrieved from pagingMetadata that specifies from which position the result listing should continue (optional)

    try:
        # Returns all Asset Administration Shells
        api_response = api_instance.get_all_asset_administration_shells(asset_ids=asset_ids, id_short=id_short, limit=limit, cursor=cursor)
        print("The response of AssetAdministrationShellRepositoryApi->get_all_asset_administration_shells:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling AssetAdministrationShellRepositoryApi->get_all_asset_administration_shells: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **asset_ids** | [**List[SpecificAssetId]**](SpecificAssetId.md)| A list of specific Asset identifiers. Each Asset identifier is a base64-url-encoded [SpecificAssetId](./model-part1.yaml#/components/schemas/SpecificAssetId) | [optional] 
 **id_short** | **str**| The Asset Administration Shell&#39;s IdShort | [optional] 
 **limit** | **int**| The maximum number of elements in the response array | [optional] 
 **cursor** | **str**| A server-generated identifier retrieved from pagingMetadata that specifies from which position the result listing should continue | [optional] 

### Return type

[**GetAssetAdministrationShellsResult**](GetAssetAdministrationShellsResult.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Requested Asset Administration Shells |  -  |
**400** | Bad Request, e.g. the request parameters of the format of the request body is wrong. |  -  |
**401** | Unauthorized, e.g. the server refused the authorization attempt. |  -  |
**403** | Forbidden |  -  |
**500** | Internal Server Error |  -  |
**0** | Default error handling for unmentioned status codes |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_all_submodel_references**
> GetReferencesResult get_all_submodel_references(aas_identifier, limit=limit, cursor=cursor)

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
    api_instance = basyxclients.AssetAdministrationShellRepositoryApi(api_client)
    aas_identifier = None # bytearray | The Asset Administration Shell’s unique id (UTF8-BASE64-URL-encoded)
    limit = 56 # int | The maximum number of elements in the response array (optional)
    cursor = 'cursor_example' # str | A server-generated identifier retrieved from pagingMetadata that specifies from which position the result listing should continue (optional)

    try:
        # Returns all submodel references
        api_response = api_instance.get_all_submodel_references(aas_identifier, limit=limit, cursor=cursor)
        print("The response of AssetAdministrationShellRepositoryApi->get_all_submodel_references:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling AssetAdministrationShellRepositoryApi->get_all_submodel_references: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **aas_identifier** | **bytearray**| The Asset Administration Shell’s unique id (UTF8-BASE64-URL-encoded) | 
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
**404** | Not Found |  -  |
**500** | Internal Server Error |  -  |
**0** | Default error handling for unmentioned status codes |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_asset_administration_shell**
> AssetAdministrationShell get_asset_administration_shell(aas_identifier)

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
    api_instance = basyxclients.AssetAdministrationShellRepositoryApi(api_client)
    aas_identifier = None # bytearray | The Asset Administration Shell’s unique id (UTF8-BASE64-URL-encoded)

    try:
        # Returns a specific Asset Administration Shell
        api_response = api_instance.get_asset_administration_shell(aas_identifier)
        print("The response of AssetAdministrationShellRepositoryApi->get_asset_administration_shell:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling AssetAdministrationShellRepositoryApi->get_asset_administration_shell: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **aas_identifier** | **bytearray**| The Asset Administration Shell’s unique id (UTF8-BASE64-URL-encoded) | 

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
**404** | Not Found |  -  |
**500** | Internal Server Error |  -  |
**0** | Default error handling for unmentioned status codes |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_asset_information**
> AssetInformation get_asset_information(aas_identifier)

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
    api_instance = basyxclients.AssetAdministrationShellRepositoryApi(api_client)
    aas_identifier = None # bytearray | The Asset Administration Shell’s unique id (UTF8-BASE64-URL-encoded)

    try:
        # Returns the Asset Information
        api_response = api_instance.get_asset_information(aas_identifier)
        print("The response of AssetAdministrationShellRepositoryApi->get_asset_information:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling AssetAdministrationShellRepositoryApi->get_asset_information: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **aas_identifier** | **bytearray**| The Asset Administration Shell’s unique id (UTF8-BASE64-URL-encoded) | 

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
    api_instance = basyxclients.AssetAdministrationShellRepositoryApi(api_client)

    try:
        # Returns the self-describing information of a network resource (ServiceDescription)
        api_response = api_instance.get_description()
        print("The response of AssetAdministrationShellRepositoryApi->get_description:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling AssetAdministrationShellRepositoryApi->get_description: %s\n" % e)
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

# **get_thumbnail**
> bytearray get_thumbnail(aas_identifier)

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
    api_instance = basyxclients.AssetAdministrationShellRepositoryApi(api_client)
    aas_identifier = None # bytearray | The Asset Administration Shell’s unique id (UTF8-BASE64-URL-encoded)

    try:
        api_response = api_instance.get_thumbnail(aas_identifier)
        print("The response of AssetAdministrationShellRepositoryApi->get_thumbnail:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling AssetAdministrationShellRepositoryApi->get_thumbnail: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **aas_identifier** | **bytearray**| The Asset Administration Shell’s unique id (UTF8-BASE64-URL-encoded) | 

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

# **post_asset_administration_shell**
> AssetAdministrationShell post_asset_administration_shell(asset_administration_shell)

Creates a new Asset Administration Shell

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
    api_instance = basyxclients.AssetAdministrationShellRepositoryApi(api_client)
    asset_administration_shell = basyxclients.AssetAdministrationShell() # AssetAdministrationShell | Asset Administration Shell object

    try:
        # Creates a new Asset Administration Shell
        api_response = api_instance.post_asset_administration_shell(asset_administration_shell)
        print("The response of AssetAdministrationShellRepositoryApi->post_asset_administration_shell:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling AssetAdministrationShellRepositoryApi->post_asset_administration_shell: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **asset_administration_shell** | [**AssetAdministrationShell**](AssetAdministrationShell.md)| Asset Administration Shell object | 

### Return type

[**AssetAdministrationShell**](AssetAdministrationShell.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**201** | Asset Administration Shell created successfully |  * Location - URL of the newly created resource <br>  |
**400** | Bad Request, e.g. the request parameters of the format of the request body is wrong. |  -  |
**401** | Unauthorized, e.g. the server refused the authorization attempt. |  -  |
**403** | Forbidden |  -  |
**409** | Conflict, a resource which shall be created exists already. Might be thrown if a Submodel or SubmodelElement with the same ShortId is contained in a POST request. |  -  |
**500** | Internal Server Error |  -  |
**0** | Default error handling for unmentioned status codes |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **post_submodel_reference**
> Reference post_submodel_reference(aas_identifier, reference)

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
    api_instance = basyxclients.AssetAdministrationShellRepositoryApi(api_client)
    aas_identifier = None # bytearray | The Asset Administration Shell’s unique id (UTF8-BASE64-URL-encoded)
    reference = basyxclients.Reference() # Reference | Reference to the Submodel

    try:
        # Creates a submodel reference at the Asset Administration Shell
        api_response = api_instance.post_submodel_reference(aas_identifier, reference)
        print("The response of AssetAdministrationShellRepositoryApi->post_submodel_reference:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling AssetAdministrationShellRepositoryApi->post_submodel_reference: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **aas_identifier** | **bytearray**| The Asset Administration Shell’s unique id (UTF8-BASE64-URL-encoded) | 
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
**201** | Submodel reference created successfully |  * Location - URL of the newly created resource <br>  |
**400** | Bad Request, e.g. the request parameters of the format of the request body is wrong. |  -  |
**401** | Unauthorized, e.g. the server refused the authorization attempt. |  -  |
**403** | Forbidden |  -  |
**404** | Not Found |  -  |
**409** | Conflict, a resource which shall be created exists already. Might be thrown if a Submodel or SubmodelElement with the same ShortId is contained in a POST request. |  -  |
**500** | Internal Server Error |  -  |
**0** | Default error handling for unmentioned status codes |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **put_asset_administration_shell**
> put_asset_administration_shell(aas_identifier, asset_administration_shell)

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
    api_instance = basyxclients.AssetAdministrationShellRepositoryApi(api_client)
    aas_identifier = None # bytearray | The Asset Administration Shell’s unique id (UTF8-BASE64-URL-encoded)
    asset_administration_shell = basyxclients.AssetAdministrationShell() # AssetAdministrationShell | Asset Administration Shell object

    try:
        # Updates an existing Asset Administration Shell
        api_instance.put_asset_administration_shell(aas_identifier, asset_administration_shell)
    except Exception as e:
        print("Exception when calling AssetAdministrationShellRepositoryApi->put_asset_administration_shell: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **aas_identifier** | **bytearray**| The Asset Administration Shell’s unique id (UTF8-BASE64-URL-encoded) | 
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
**404** | Not Found |  -  |
**500** | Internal Server Error |  -  |
**0** | Default error handling for unmentioned status codes |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **put_asset_information**
> put_asset_information(aas_identifier, asset_information)

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
    api_instance = basyxclients.AssetAdministrationShellRepositoryApi(api_client)
    aas_identifier = None # bytearray | The Asset Administration Shell’s unique id (UTF8-BASE64-URL-encoded)
    asset_information = basyxclients.AssetInformation() # AssetInformation | Asset Information object

    try:
        # Updates the Asset Information
        api_instance.put_asset_information(aas_identifier, asset_information)
    except Exception as e:
        print("Exception when calling AssetAdministrationShellRepositoryApi->put_asset_information: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **aas_identifier** | **bytearray**| The Asset Administration Shell’s unique id (UTF8-BASE64-URL-encoded) | 
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
**404** | Not Found |  -  |
**500** | Internal Server Error |  -  |
**0** | Default error handling for unmentioned status codes |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **put_thumbnail**
> put_thumbnail(aas_identifier, file_name=file_name, file=file)

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
    api_instance = basyxclients.AssetAdministrationShellRepositoryApi(api_client)
    aas_identifier = None # bytearray | The Asset Administration Shell’s unique id (UTF8-BASE64-URL-encoded)
    file_name = 'file_name_example' # str |  (optional)
    file = None # bytearray |  (optional)

    try:
        api_instance.put_thumbnail(aas_identifier, file_name=file_name, file=file)
    except Exception as e:
        print("Exception when calling AssetAdministrationShellRepositoryApi->put_thumbnail: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **aas_identifier** | **bytearray**| The Asset Administration Shell’s unique id (UTF8-BASE64-URL-encoded) | 
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

