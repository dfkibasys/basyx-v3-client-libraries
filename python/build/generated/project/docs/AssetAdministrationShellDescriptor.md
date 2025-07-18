# AssetAdministrationShellDescriptor


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**description** | [**List[LangStringTextType]**](LangStringTextType.md) |  | [optional] 
**display_name** | [**List[LangStringNameType]**](LangStringNameType.md) |  | [optional] 
**extensions** | [**List[Extension]**](Extension.md) |  | [optional] 
**administration** | [**AdministrativeInformation**](AdministrativeInformation.md) |  | [optional] 
**asset_kind** | [**AssetKind**](AssetKind.md) |  | [optional] 
**asset_type** | **str** |  | [optional] 
**endpoints** | [**List[Endpoint]**](Endpoint.md) |  | [optional] 
**global_asset_id** | **str** |  | [optional] 
**id_short** | **str** |  | [optional] 
**id** | **str** |  | 
**specific_asset_ids** | [**List[SpecificAssetId]**](SpecificAssetId.md) |  | [optional] 
**submodel_descriptors** | [**List[SubmodelDescriptor]**](SubmodelDescriptor.md) |  | [optional] 

## Example

```python
from basyxclients.models.part2.asset_administration_shell_descriptor import AssetAdministrationShellDescriptor

# TODO update the JSON string below
json = "{}"
# create an instance of AssetAdministrationShellDescriptor from a JSON string
asset_administration_shell_descriptor_instance = AssetAdministrationShellDescriptor.from_json(json)
# print the JSON string representation of the object
print(AssetAdministrationShellDescriptor.to_json())

# convert the object into a dict
asset_administration_shell_descriptor_dict = asset_administration_shell_descriptor_instance.to_dict()
# create an instance of AssetAdministrationShellDescriptor from a dict
asset_administration_shell_descriptor_from_dict = AssetAdministrationShellDescriptor.from_dict(asset_administration_shell_descriptor_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


