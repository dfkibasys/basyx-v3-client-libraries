# RelationshipElementValue


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**first** | [**ReferenceValue**](ReferenceValue.md) |  | 
**second** | [**ReferenceValue**](ReferenceValue.md) |  | 

## Example

```python
from basyxclients.models.part2.relationship_element_value import RelationshipElementValue

# TODO update the JSON string below
json = "{}"
# create an instance of RelationshipElementValue from a JSON string
relationship_element_value_instance = RelationshipElementValue.from_json(json)
# print the JSON string representation of the object
print(RelationshipElementValue.to_json())

# convert the object into a dict
relationship_element_value_dict = relationship_element_value_instance.to_dict()
# create an instance of RelationshipElementValue from a dict
relationship_element_value_from_dict = RelationshipElementValue.from_dict(relationship_element_value_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


