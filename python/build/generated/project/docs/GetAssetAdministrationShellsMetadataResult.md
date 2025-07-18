# GetAssetAdministrationShellsMetadataResult


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**paging_metadata** | [**PagedResultPagingMetadata**](PagedResultPagingMetadata.md) |  | [optional] 
**result** | [**List[AssetAdministrationShellMetadata]**](AssetAdministrationShellMetadata.md) |  | [optional] 

## Example

```python
from basyxclients.models.part2.get_asset_administration_shells_metadata_result import GetAssetAdministrationShellsMetadataResult

# TODO update the JSON string below
json = "{}"
# create an instance of GetAssetAdministrationShellsMetadataResult from a JSON string
get_asset_administration_shells_metadata_result_instance = GetAssetAdministrationShellsMetadataResult.from_json(json)
# print the JSON string representation of the object
print(GetAssetAdministrationShellsMetadataResult.to_json())

# convert the object into a dict
get_asset_administration_shells_metadata_result_dict = get_asset_administration_shells_metadata_result_instance.to_dict()
# create an instance of GetAssetAdministrationShellsMetadataResult from a dict
get_asset_administration_shells_metadata_result_from_dict = GetAssetAdministrationShellsMetadataResult.from_dict(get_asset_administration_shells_metadata_result_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


