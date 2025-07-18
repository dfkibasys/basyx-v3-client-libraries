# BasicEventElementValue


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**observed** | [**ReferenceValue**](ReferenceValue.md) |  | 

## Example

```python
from basyxclients.models.part2.basic_event_element_value import BasicEventElementValue

# TODO update the JSON string below
json = "{}"
# create an instance of BasicEventElementValue from a JSON string
basic_event_element_value_instance = BasicEventElementValue.from_json(json)
# print the JSON string representation of the object
print(BasicEventElementValue.to_json())

# convert the object into a dict
basic_event_element_value_dict = basic_event_element_value_instance.to_dict()
# create an instance of BasicEventElementValue from a dict
basic_event_element_value_from_dict = BasicEventElementValue.from_dict(basic_event_element_value_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


