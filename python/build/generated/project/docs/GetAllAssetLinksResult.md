# GetAllAssetLinksResult


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**paging_metadata** | [**PagedResultPagingMetadata**](PagedResultPagingMetadata.md) |  | [optional] 
**result** | **List[str]** |  | [optional] 

## Example

```python
from basyxclients.models.discovery.get_all_asset_links_result import GetAllAssetLinksResult

# TODO update the JSON string below
json = "{}"
# create an instance of GetAllAssetLinksResult from a JSON string
get_all_asset_links_result_instance = GetAllAssetLinksResult.from_json(json)
# print the JSON string representation of the object
print(GetAllAssetLinksResult.to_json())

# convert the object into a dict
get_all_asset_links_result_dict = get_all_asset_links_result_instance.to_dict()
# create an instance of GetAllAssetLinksResult from a dict
get_all_asset_links_result_from_dict = GetAllAssetLinksResult.from_dict(get_all_asset_links_result_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


