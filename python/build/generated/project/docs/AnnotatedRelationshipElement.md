# AnnotatedRelationshipElement


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
from basyxclients.models.part1.annotated_relationship_element import AnnotatedRelationshipElement

# TODO update the JSON string below
json = "{}"
# create an instance of AnnotatedRelationshipElement from a JSON string
annotated_relationship_element_instance = AnnotatedRelationshipElement.from_json(json)
# print the JSON string representation of the object
print(AnnotatedRelationshipElement.to_json())

# convert the object into a dict
annotated_relationship_element_dict = annotated_relationship_element_instance.to_dict()
# create an instance of AnnotatedRelationshipElement from a dict
annotated_relationship_element_from_dict = AnnotatedRelationshipElement.from_dict(annotated_relationship_element_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


