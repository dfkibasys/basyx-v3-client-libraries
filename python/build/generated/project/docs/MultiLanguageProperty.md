# MultiLanguageProperty


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**extensions** | [**List[Extension]**](Extension.md) |  | [optional] 
**category** | **str** |  | [optional] 
**id_short** | **str** |  | [optional] 
**display_name** | [**List[LangStringNameType]**](LangStringNameType.md) |  | [optional] 
**description** | [**List[LangStringTextType]**](LangStringTextType.md) |  | [optional] 
**model_type** | **str** |  | 
**semantic_id** | [**Reference**](Reference.md) |  | [optional] 
**supplemental_semantic_ids** | [**List[Reference]**](Reference.md) |  | [optional] 
**qualifiers** | [**List[Qualifier]**](Qualifier.md) |  | [optional] 
**embedded_data_specifications** | [**List[EmbeddedDataSpecification]**](EmbeddedDataSpecification.md) |  | [optional] 
**value** | [**List[LangStringTextType]**](LangStringTextType.md) |  | [optional] 
**value_id** | [**Reference**](Reference.md) |  | [optional] 

## Example

```python
from basyxclients.models.part1.multi_language_property import MultiLanguageProperty

# TODO update the JSON string below
json = "{}"
# create an instance of MultiLanguageProperty from a JSON string
multi_language_property_instance = MultiLanguageProperty.from_json(json)
# print the JSON string representation of the object
print(MultiLanguageProperty.to_json())

# convert the object into a dict
multi_language_property_dict = multi_language_property_instance.to_dict()
# create an instance of MultiLanguageProperty from a dict
multi_language_property_from_dict = MultiLanguageProperty.from_dict(multi_language_property_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


