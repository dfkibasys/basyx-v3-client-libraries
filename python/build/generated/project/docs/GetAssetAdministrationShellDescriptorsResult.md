# GetAssetAdministrationShellDescriptorsResult


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**paging_metadata** | [**PagedResultPagingMetadata**](PagedResultPagingMetadata.md) |  | [optional] 
**result** | [**List[AssetAdministrationShellDescriptor]**](AssetAdministrationShellDescriptor.md) |  | [optional] 

## Example

```python
from basyxclients.models.part2.get_asset_administration_shell_descriptors_result import GetAssetAdministrationShellDescriptorsResult

# TODO update the JSON string below
json = "{}"
# create an instance of GetAssetAdministrationShellDescriptorsResult from a JSON string
get_asset_administration_shell_descriptors_result_instance = GetAssetAdministrationShellDescriptorsResult.from_json(json)
# print the JSON string representation of the object
print(GetAssetAdministrationShellDescriptorsResult.to_json())

# convert the object into a dict
get_asset_administration_shell_descriptors_result_dict = get_asset_administration_shell_descriptors_result_instance.to_dict()
# create an instance of GetAssetAdministrationShellDescriptorsResult from a dict
get_asset_administration_shell_descriptors_result_from_dict = GetAssetAdministrationShellDescriptorsResult.from_dict(get_asset_administration_shell_descriptors_result_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


