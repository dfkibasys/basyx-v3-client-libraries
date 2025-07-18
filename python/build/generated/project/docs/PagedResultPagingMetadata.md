# PagedResultPagingMetadata


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**cursor** | **str** |  | [optional] 

## Example

```python
from basyxclients.models.part2.paged_result_paging_metadata import PagedResultPagingMetadata

# TODO update the JSON string below
json = "{}"
# create an instance of PagedResultPagingMetadata from a JSON string
paged_result_paging_metadata_instance = PagedResultPagingMetadata.from_json(json)
# print the JSON string representation of the object
print(PagedResultPagingMetadata.to_json())

# convert the object into a dict
paged_result_paging_metadata_dict = paged_result_paging_metadata_instance.to_dict()
# create an instance of PagedResultPagingMetadata from a dict
paged_result_paging_metadata_from_dict = PagedResultPagingMetadata.from_dict(paged_result_paging_metadata_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


