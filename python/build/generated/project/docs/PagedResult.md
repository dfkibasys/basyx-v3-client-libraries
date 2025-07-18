# PagedResult


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**paging_metadata** | [**PagedResultPagingMetadata**](PagedResultPagingMetadata.md) |  | [optional] 

## Example

```python
from basyxclients.models.part2.paged_result import PagedResult

# TODO update the JSON string below
json = "{}"
# create an instance of PagedResult from a JSON string
paged_result_instance = PagedResult.from_json(json)
# print the JSON string representation of the object
print(PagedResult.to_json())

# convert the object into a dict
paged_result_dict = paged_result_instance.to_dict()
# create an instance of PagedResult from a dict
paged_result_from_dict = PagedResult.from_dict(paged_result_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


