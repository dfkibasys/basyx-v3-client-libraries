# AnnotatedRelationshipElementValue


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**first** | [**ReferenceValue**](ReferenceValue.md) |  | 
**second** | [**ReferenceValue**](ReferenceValue.md) |  | 
**annotations** | **List[object]** |  | [optional] 

## Example

```python
from basyxclients.models.part2.annotated_relationship_element_value import AnnotatedRelationshipElementValue

# TODO update the JSON string below
json = "{}"
# create an instance of AnnotatedRelationshipElementValue from a JSON string
annotated_relationship_element_value_instance = AnnotatedRelationshipElementValue.from_json(json)
# print the JSON string representation of the object
print(AnnotatedRelationshipElementValue.to_json())

# convert the object into a dict
annotated_relationship_element_value_dict = annotated_relationship_element_value_instance.to_dict()
# create an instance of AnnotatedRelationshipElementValue from a dict
annotated_relationship_element_value_from_dict = AnnotatedRelationshipElementValue.from_dict(annotated_relationship_element_value_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


