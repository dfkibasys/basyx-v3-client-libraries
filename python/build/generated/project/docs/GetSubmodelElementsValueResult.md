# GetSubmodelElementsValueResult


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**paging_metadata** | [**PagedResultPagingMetadata**](PagedResultPagingMetadata.md) |  | [optional] 
**result** | [**List[SubmodelElementValue]**](SubmodelElementValue.md) |  | [optional] 

## Example

```python
from basyxclients.models.part2.get_submodel_elements_value_result import GetSubmodelElementsValueResult

# TODO update the JSON string below
json = "{}"
# create an instance of GetSubmodelElementsValueResult from a JSON string
get_submodel_elements_value_result_instance = GetSubmodelElementsValueResult.from_json(json)
# print the JSON string representation of the object
print(GetSubmodelElementsValueResult.to_json())

# convert the object into a dict
get_submodel_elements_value_result_dict = get_submodel_elements_value_result_instance.to_dict()
# create an instance of GetSubmodelElementsValueResult from a dict
get_submodel_elements_value_result_from_dict = GetSubmodelElementsValueResult.from_dict(get_submodel_elements_value_result_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


