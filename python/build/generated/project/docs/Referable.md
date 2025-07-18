# Referable


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**extensions** | [**List[Extension]**](Extension.md) |  | [optional] 
**category** | **str** |  | [optional] 
**id_short** | **str** |  | [optional] 
**display_name** | [**List[LangStringNameType]**](LangStringNameType.md) |  | [optional] 
**description** | [**List[LangStringTextType]**](LangStringTextType.md) |  | [optional] 
**model_type** | [**ModelType**](ModelType.md) |  | 

## Example

```python
from basyxclients.models.part1.referable import Referable

# TODO update the JSON string below
json = "{}"
# create an instance of Referable from a JSON string
referable_instance = Referable.from_json(json)
# print the JSON string representation of the object
print(Referable.to_json())

# convert the object into a dict
referable_dict = referable_instance.to_dict()
# create an instance of Referable from a dict
referable_from_dict = Referable.from_dict(referable_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


