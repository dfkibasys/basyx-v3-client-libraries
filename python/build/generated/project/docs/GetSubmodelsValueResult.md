# GetSubmodelsValueResult


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**paging_metadata** | [**PagedResultPagingMetadata**](PagedResultPagingMetadata.md) |  | [optional] 
**result** | [**List[SubmodelValue]**](SubmodelValue.md) |  | [optional] 

## Example

```python
from basyxclients.models.part2.get_submodels_value_result import GetSubmodelsValueResult

# TODO update the JSON string below
json = "{}"
# create an instance of GetSubmodelsValueResult from a JSON string
get_submodels_value_result_instance = GetSubmodelsValueResult.from_json(json)
# print the JSON string representation of the object
print(GetSubmodelsValueResult.to_json())

# convert the object into a dict
get_submodels_value_result_dict = get_submodels_value_result_instance.to_dict()
# create an instance of GetSubmodelsValueResult from a dict
get_submodels_value_result_from_dict = GetSubmodelsValueResult.from_dict(get_submodels_value_result_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


