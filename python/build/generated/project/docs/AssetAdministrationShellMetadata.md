# AssetAdministrationShellMetadata


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**extensions** | [**List[Extension]**](Extension.md) |  | [optional] 
**category** | **str** |  | [optional] 
**id_short** | **str** |  | [optional] 
**display_name** | [**List[LangStringNameType]**](LangStringNameType.md) |  | [optional] 
**description** | [**List[LangStringTextType]**](LangStringTextType.md) |  | [optional] 
**model_type** | [**ModelType**](ModelType.md) |  | 
**administration** | [**AdministrativeInformation**](AdministrativeInformation.md) |  | [optional] 
**id** | **str** |  | 
**embedded_data_specifications** | [**List[EmbeddedDataSpecification]**](EmbeddedDataSpecification.md) |  | [optional] 
**derived_from** | [**Reference**](Reference.md) |  | [optional] 

## Example

```python
from basyxclients.models.part2.asset_administration_shell_metadata import AssetAdministrationShellMetadata

# TODO update the JSON string below
json = "{}"
# create an instance of AssetAdministrationShellMetadata from a JSON string
asset_administration_shell_metadata_instance = AssetAdministrationShellMetadata.from_json(json)
# print the JSON string representation of the object
print(AssetAdministrationShellMetadata.to_json())

# convert the object into a dict
asset_administration_shell_metadata_dict = asset_administration_shell_metadata_instance.to_dict()
# create an instance of AssetAdministrationShellMetadata from a dict
asset_administration_shell_metadata_from_dict = AssetAdministrationShellMetadata.from_dict(asset_administration_shell_metadata_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


