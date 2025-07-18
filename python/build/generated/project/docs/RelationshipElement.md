# RelationshipElement


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

## Example

```python
from basyxclients.models.part1.relationship_element import RelationshipElement

# TODO update the JSON string below
json = "{}"
# create an instance of RelationshipElement from a JSON string
relationship_element_instance = RelationshipElement.from_json(json)
# print the JSON string representation of the object
print(RelationshipElement.to_json())

# convert the object into a dict
relationship_element_dict = relationship_element_instance.to_dict()
# create an instance of RelationshipElement from a dict
relationship_element_from_dict = RelationshipElement.from_dict(relationship_element_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


