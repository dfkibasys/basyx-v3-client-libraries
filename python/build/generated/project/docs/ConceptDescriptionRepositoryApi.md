# basyxclients.ConceptDescriptionRepositoryApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**delete_concept_description_by_id**](ConceptDescriptionRepositoryApi.md#delete_concept_description_by_id) | **DELETE** /concept-descriptions/{cdIdentifier} | Deletes a Concept Description
[**generate_serialization_by_ids**](ConceptDescriptionRepositoryApi.md#generate_serialization_by_ids) | **GET** /serialization | Returns an appropriate serialization based on the specified format (see SerializationFormat)
[**get_all_concept_descriptions**](ConceptDescriptionRepositoryApi.md#get_all_concept_descriptions) | **GET** /concept-descriptions | Returns all Concept Descriptions
[**get_concept_description_by_id**](ConceptDescriptionRepositoryApi.md#get_concept_description_by_id) | **GET** /concept-descriptions/{cdIdentifier} | Returns a specific Concept Description
[**get_description**](ConceptDescriptionRepositoryApi.md#get_description) | **GET** /description | Returns the self-describing information of a network resource (ServiceDescription)
[**post_concept_description**](ConceptDescriptionRepositoryApi.md#post_concept_description) | **POST** /concept-descriptions | Creates a new Concept Description
[**put_concept_description_by_id**](ConceptDescriptionRepositoryApi.md#put_concept_description_by_id) | **PUT** /concept-descriptions/{cdIdentifier} | Updates an existing Concept Description


# **delete_concept_description_by_id**
> delete_concept_description_by_id(cd_identifier)

Deletes a Concept Description

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
    api_instance = basyxclients.ConceptDescriptionRepositoryApi(api_client)
    cd_identifier = None # bytearray | The Concept Description’s unique id (UTF8-BASE64-URL-encoded)

    try:
        # Deletes a Concept Description
        api_instance.delete_concept_description_by_id(cd_identifier)
    except Exception as e:
        print("Exception when calling ConceptDescriptionRepositoryApi->delete_concept_description_by_id: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **cd_identifier** | **bytearray**| The Concept Description’s unique id (UTF8-BASE64-URL-encoded) | 

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
**204** | Concept Description deleted successfully |  -  |
**400** | Bad Request, e.g. the request parameters of the format of the request body is wrong. |  -  |
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
    api_instance = basyxclients.ConceptDescriptionRepositoryApi(api_client)
    aas_ids = ['aas_ids_example'] # List[str] | The Asset Administration Shells' unique ids (UTF8-BASE64-URL-encoded) (optional)
    submodel_ids = ['submodel_ids_example'] # List[str] | The Submodels' unique ids (UTF8-BASE64-URL-encoded) (optional)
    include_concept_descriptions = True # bool | Include Concept Descriptions? (optional) (default to True)

    try:
        # Returns an appropriate serialization based on the specified format (see SerializationFormat)
        api_response = api_instance.generate_serialization_by_ids(aas_ids=aas_ids, submodel_ids=submodel_ids, include_concept_descriptions=include_concept_descriptions)
        print("The response of ConceptDescriptionRepositoryApi->generate_serialization_by_ids:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling ConceptDescriptionRepositoryApi->generate_serialization_by_ids: %s\n" % e)
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
**403** | Forbidden |  -  |
**500** | Internal Server Error |  -  |
**0** | Default error handling for unmentioned status codes |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_all_concept_descriptions**
> GetConceptDescriptionsResult get_all_concept_descriptions(id_short=id_short, is_case_of=is_case_of, data_specification_ref=data_specification_ref, limit=limit, cursor=cursor)

Returns all Concept Descriptions

### Example


```python
import basyxclients
from basyxclients.models.get_concept_descriptions_result import GetConceptDescriptionsResult
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
    api_instance = basyxclients.ConceptDescriptionRepositoryApi(api_client)
    id_short = 'id_short_example' # str | The Concept Description’s IdShort (optional)
    is_case_of = None # bytearray | IsCaseOf reference (UTF8-BASE64-URL-encoded) (optional)
    data_specification_ref = None # bytearray | DataSpecification reference (UTF8-BASE64-URL-encoded) (optional)
    limit = 56 # int | The maximum number of elements in the response array (optional)
    cursor = 'cursor_example' # str | A server-generated identifier retrieved from pagingMetadata that specifies from which position the result listing should continue (optional)

    try:
        # Returns all Concept Descriptions
        api_response = api_instance.get_all_concept_descriptions(id_short=id_short, is_case_of=is_case_of, data_specification_ref=data_specification_ref, limit=limit, cursor=cursor)
        print("The response of ConceptDescriptionRepositoryApi->get_all_concept_descriptions:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling ConceptDescriptionRepositoryApi->get_all_concept_descriptions: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id_short** | **str**| The Concept Description’s IdShort | [optional] 
 **is_case_of** | **bytearray**| IsCaseOf reference (UTF8-BASE64-URL-encoded) | [optional] 
 **data_specification_ref** | **bytearray**| DataSpecification reference (UTF8-BASE64-URL-encoded) | [optional] 
 **limit** | **int**| The maximum number of elements in the response array | [optional] 
 **cursor** | **str**| A server-generated identifier retrieved from pagingMetadata that specifies from which position the result listing should continue | [optional] 

### Return type

[**GetConceptDescriptionsResult**](GetConceptDescriptionsResult.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Requested Concept Descriptions |  -  |
**400** | Bad Request, e.g. the request parameters of the format of the request body is wrong. |  -  |
**403** | Forbidden |  -  |
**500** | Internal Server Error |  -  |
**0** | Default error handling for unmentioned status codes |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_concept_description_by_id**
> ConceptDescription get_concept_description_by_id(cd_identifier)

Returns a specific Concept Description

### Example


```python
import basyxclients
from basyxclients.models.concept_description import ConceptDescription
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
    api_instance = basyxclients.ConceptDescriptionRepositoryApi(api_client)
    cd_identifier = None # bytearray | The Concept Description’s unique id (UTF8-BASE64-URL-encoded)

    try:
        # Returns a specific Concept Description
        api_response = api_instance.get_concept_description_by_id(cd_identifier)
        print("The response of ConceptDescriptionRepositoryApi->get_concept_description_by_id:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling ConceptDescriptionRepositoryApi->get_concept_description_by_id: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **cd_identifier** | **bytearray**| The Concept Description’s unique id (UTF8-BASE64-URL-encoded) | 

### Return type

[**ConceptDescription**](ConceptDescription.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Requested Concept Description |  -  |
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
    api_instance = basyxclients.ConceptDescriptionRepositoryApi(api_client)

    try:
        # Returns the self-describing information of a network resource (ServiceDescription)
        api_response = api_instance.get_description()
        print("The response of ConceptDescriptionRepositoryApi->get_description:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling ConceptDescriptionRepositoryApi->get_description: %s\n" % e)
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

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **post_concept_description**
> ConceptDescription post_concept_description(concept_description)

Creates a new Concept Description

### Example


```python
import basyxclients
from basyxclients.models.concept_description import ConceptDescription
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
    api_instance = basyxclients.ConceptDescriptionRepositoryApi(api_client)
    concept_description = basyxclients.ConceptDescription() # ConceptDescription | Concept Description object

    try:
        # Creates a new Concept Description
        api_response = api_instance.post_concept_description(concept_description)
        print("The response of ConceptDescriptionRepositoryApi->post_concept_description:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling ConceptDescriptionRepositoryApi->post_concept_description: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **concept_description** | [**ConceptDescription**](ConceptDescription.md)| Concept Description object | 

### Return type

[**ConceptDescription**](ConceptDescription.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**201** | Concept Description created successfully |  * Location - URL of the newly created resource <br>  |
**400** | Bad Request, e.g. the request parameters of the format of the request body is wrong. |  -  |
**403** | Forbidden |  -  |
**409** | Conflict, a resource which shall be created exists already. Might be thrown if a Submodel or SubmodelElement with the same ShortId is contained in a POST request. |  -  |
**500** | Internal Server Error |  -  |
**0** | Default error handling for unmentioned status codes |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **put_concept_description_by_id**
> put_concept_description_by_id(cd_identifier, concept_description)

Updates an existing Concept Description

### Example


```python
import basyxclients
from basyxclients.models.concept_description import ConceptDescription
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
    api_instance = basyxclients.ConceptDescriptionRepositoryApi(api_client)
    cd_identifier = None # bytearray | The Concept Description’s unique id (UTF8-BASE64-URL-encoded)
    concept_description = basyxclients.ConceptDescription() # ConceptDescription | Concept Description object

    try:
        # Updates an existing Concept Description
        api_instance.put_concept_description_by_id(cd_identifier, concept_description)
    except Exception as e:
        print("Exception when calling ConceptDescriptionRepositoryApi->put_concept_description_by_id: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **cd_identifier** | **bytearray**| The Concept Description’s unique id (UTF8-BASE64-URL-encoded) | 
 **concept_description** | [**ConceptDescription**](ConceptDescription.md)| Concept Description object | 

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
**204** | Concept Description updated successfully |  -  |
**400** | Bad Request, e.g. the request parameters of the format of the request body is wrong. |  -  |
**403** | Forbidden |  -  |
**404** | Not Found |  -  |
**500** | Internal Server Error |  -  |
**0** | Default error handling for unmentioned status codes |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

