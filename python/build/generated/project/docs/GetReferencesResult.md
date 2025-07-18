# GetReferencesResult


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**paging_metadata** | [**PagedResultPagingMetadata**](PagedResultPagingMetadata.md) |  | [optional] 
**result** | [**List[Reference]**](Reference.md) |  | [optional] 

## Example

```python
from basyxclients.models.part2.get_references_result import GetReferencesResult

# TODO update the JSON string below
json = "{}"
# create an instance of GetReferencesResult from a JSON string
get_references_result_instance = GetReferencesResult.from_json(json)
# print the JSON string representation of the object
print(GetReferencesResult.to_json())

# convert the object into a dict
get_references_result_dict = get_references_result_instance.to_dict()
# create an instance of GetReferencesResult from a dict
get_references_result_from_dict = GetReferencesResult.from_dict(get_references_result_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


