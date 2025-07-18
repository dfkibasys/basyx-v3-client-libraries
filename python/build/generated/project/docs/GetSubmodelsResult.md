# GetSubmodelsResult


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**paging_metadata** | [**PagedResultPagingMetadata**](PagedResultPagingMetadata.md) |  | [optional] 
**result** | [**List[Submodel]**](Submodel.md) |  | [optional] 

## Example

```python
from basyxclients.models.part2.get_submodels_result import GetSubmodelsResult

# TODO update the JSON string below
json = "{}"
# create an instance of GetSubmodelsResult from a JSON string
get_submodels_result_instance = GetSubmodelsResult.from_json(json)
# print the JSON string representation of the object
print(GetSubmodelsResult.to_json())

# convert the object into a dict
get_submodels_result_dict = get_submodels_result_instance.to_dict()
# create an instance of GetSubmodelsResult from a dict
get_submodels_result_from_dict = GetSubmodelsResult.from_dict(get_submodels_result_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


