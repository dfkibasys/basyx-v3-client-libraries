# RelationshipElementChoice


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
**first** | [**Reference**](Reference.md) |  | 
**second** | [**Reference**](Reference.md) |  | 
**annotations** | [**List[DataElementChoice]**](DataElementChoice.md) |  | [optional] 

## Example

```python
from basyxclients.models.part1.relationship_element_choice import RelationshipElementChoice

# TODO update the JSON string below
json = "{}"
# create an instance of RelationshipElementChoice from a JSON string
relationship_element_choice_instance = RelationshipElementChoice.from_json(json)
# print the JSON string representation of the object
print(RelationshipElementChoice.to_json())

# convert the object into a dict
relationship_element_choice_dict = relationship_element_choice_instance.to_dict()
# create an instance of RelationshipElementChoice from a dict
relationship_element_choice_from_dict = RelationshipElementChoice.from_dict(relationship_element_choice_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


