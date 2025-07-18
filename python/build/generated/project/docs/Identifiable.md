# Identifiable


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

## Example

```python
from basyxclients.models.part1.identifiable import Identifiable

# TODO update the JSON string below
json = "{}"
# create an instance of Identifiable from a JSON string
identifiable_instance = Identifiable.from_json(json)
# print the JSON string representation of the object
print(Identifiable.to_json())

# convert the object into a dict
identifiable_dict = identifiable_instance.to_dict()
# create an instance of Identifiable from a dict
identifiable_from_dict = Identifiable.from_dict(identifiable_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


