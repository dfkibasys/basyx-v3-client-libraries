# DataElementChoice


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
**value** | [**Reference**](Reference.md) |  | [optional] 
**content_type** | **str** |  | 
**value_id** | [**Reference**](Reference.md) |  | [optional] 
**value_type** | [**DataTypeDefXsd**](DataTypeDefXsd.md) |  | 
**min** | **str** |  | [optional] 
**max** | **str** |  | [optional] 

## Example

```python
from basyxclients.models.part1.data_element_choice import DataElementChoice

# TODO update the JSON string below
json = "{}"
# create an instance of DataElementChoice from a JSON string
data_element_choice_instance = DataElementChoice.from_json(json)
# print the JSON string representation of the object
print(DataElementChoice.to_json())

# convert the object into a dict
data_element_choice_dict = data_element_choice_instance.to_dict()
# create an instance of DataElementChoice from a dict
data_element_choice_from_dict = DataElementChoice.from_dict(data_element_choice_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


