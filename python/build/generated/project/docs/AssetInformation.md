# AssetInformation


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**asset_kind** | [**AssetKind**](AssetKind.md) |  | 
**global_asset_id** | **str** |  | [optional] 
**specific_asset_ids** | [**List[SpecificAssetId]**](SpecificAssetId.md) |  | [optional] 
**asset_type** | **str** |  | [optional] 
**default_thumbnail** | [**Resource**](Resource.md) |  | [optional] 

## Example

```python
from basyxclients.models.part1.asset_information import AssetInformation

# TODO update the JSON string below
json = "{}"
# create an instance of AssetInformation from a JSON string
asset_information_instance = AssetInformation.from_json(json)
# print the JSON string representation of the object
print(AssetInformation.to_json())

# convert the object into a dict
asset_information_dict = asset_information_instance.to_dict()
# create an instance of AssetInformation from a dict
asset_information_from_dict = AssetInformation.from_dict(asset_information_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


