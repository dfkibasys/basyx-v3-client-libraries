# GetSubmodelElementsResult


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**paging_metadata** | [**PagedResultPagingMetadata**](PagedResultPagingMetadata.md) |  | [optional] 
**result** | [**List[SubmodelElementChoice]**](SubmodelElementChoice.md) |  | [optional] 

## Example

```python
from basyxclients.models.part2.get_submodel_elements_result import GetSubmodelElementsResult

# TODO update the JSON string below
json = "{}"
# create an instance of GetSubmodelElementsResult from a JSON string
get_submodel_elements_result_instance = GetSubmodelElementsResult.from_json(json)
# print the JSON string representation of the object
print(GetSubmodelElementsResult.to_json())

# convert the object into a dict
get_submodel_elements_result_dict = get_submodel_elements_result_instance.to_dict()
# create an instance of GetSubmodelElementsResult from a dict
get_submodel_elements_result_from_dict = GetSubmodelElementsResult.from_dict(get_submodel_elements_result_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


