# GetPathItemsResult


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**paging_metadata** | [**PagedResultPagingMetadata**](PagedResultPagingMetadata.md) |  | [optional] 
**result** | **List[str]** |  | [optional] 

## Example

```python
from basyxclients.models.part2.get_path_items_result import GetPathItemsResult

# TODO update the JSON string below
json = "{}"
# create an instance of GetPathItemsResult from a JSON string
get_path_items_result_instance = GetPathItemsResult.from_json(json)
# print the JSON string representation of the object
print(GetPathItemsResult.to_json())

# convert the object into a dict
get_path_items_result_dict = get_path_items_result_instance.to_dict()
# create an instance of GetPathItemsResult from a dict
get_path_items_result_from_dict = GetPathItemsResult.from_dict(get_path_items_result_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


