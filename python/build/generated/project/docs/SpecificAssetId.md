# SpecificAssetId


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**semantic_id** | [**Reference**](Reference.md) |  | [optional] 
**supplemental_semantic_ids** | [**List[Reference]**](Reference.md) |  | [optional] 
**name** | **str** |  | 
**value** | **str** |  | 
**external_subject_id** | [**Reference**](Reference.md) |  | [optional] 

## Example

```python
from basyxclients.models.part1.specific_asset_id import SpecificAssetId

# TODO update the JSON string below
json = "{}"
# create an instance of SpecificAssetId from a JSON string
specific_asset_id_instance = SpecificAssetId.from_json(json)
# print the JSON string representation of the object
print(SpecificAssetId.to_json())

# convert the object into a dict
specific_asset_id_dict = specific_asset_id_instance.to_dict()
# create an instance of SpecificAssetId from a dict
specific_asset_id_from_dict = SpecificAssetId.from_dict(specific_asset_id_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


