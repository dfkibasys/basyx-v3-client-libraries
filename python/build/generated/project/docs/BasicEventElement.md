# BasicEventElement


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
**observed** | [**Reference**](Reference.md) |  | 
**direction** | [**Direction**](Direction.md) |  | 
**state** | [**StateOfEvent**](StateOfEvent.md) |  | 
**message_topic** | **str** |  | [optional] 
**message_broker** | [**Reference**](Reference.md) |  | [optional] 
**last_update** | **str** |  | [optional] 
**min_interval** | **str** |  | [optional] 
**max_interval** | **str** |  | [optional] 

## Example

```python
from basyxclients.models.part1.basic_event_element import BasicEventElement

# TODO update the JSON string below
json = "{}"
# create an instance of BasicEventElement from a JSON string
basic_event_element_instance = BasicEventElement.from_json(json)
# print the JSON string representation of the object
print(BasicEventElement.to_json())

# convert the object into a dict
basic_event_element_dict = basic_event_element_instance.to_dict()
# create an instance of BasicEventElement from a dict
basic_event_element_from_dict = BasicEventElement.from_dict(basic_event_element_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


