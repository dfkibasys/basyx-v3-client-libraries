# BasicEventElementMetadata


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**extensions** | [**List[Extension]**](Extension.md) |  | [optional] 
**category** | **str** |  | [optional] 
**id_short** | **str** |  | [optional] 
**display_name** | [**List[LangStringNameType]**](LangStringNameType.md) |  | [optional] 
**description** | [**List[LangStringTextType]**](LangStringTextType.md) |  | [optional] 
**model_type** | [**ModelType**](ModelType.md) |  | 
**embedded_data_specifications** | [**List[EmbeddedDataSpecification]**](EmbeddedDataSpecification.md) |  | [optional] 
**semantic_id** | [**Reference**](Reference.md) |  | [optional] 
**supplemental_semantic_ids** | [**List[Reference]**](Reference.md) |  | [optional] 
**qualifiers** | [**List[Qualifier]**](Qualifier.md) |  | [optional] 
**kind** | [**ModellingKind**](ModellingKind.md) |  | [optional] 
**direction** | [**Direction**](Direction.md) |  | [optional] 
**state** | [**StateOfEvent**](StateOfEvent.md) |  | [optional] 
**message_topic** | **str** |  | [optional] 
**message_broker** | [**Reference**](Reference.md) |  | [optional] 
**last_update** | **str** |  | [optional] 
**min_interval** | **str** |  | [optional] 
**max_interval** | **str** |  | [optional] 

## Example

```python
from basyxclients.models.part2.basic_event_element_metadata import BasicEventElementMetadata

# TODO update the JSON string below
json = "{}"
# create an instance of BasicEventElementMetadata from a JSON string
basic_event_element_metadata_instance = BasicEventElementMetadata.from_json(json)
# print the JSON string representation of the object
print(BasicEventElementMetadata.to_json())

# convert the object into a dict
basic_event_element_metadata_dict = basic_event_element_metadata_instance.to_dict()
# create an instance of BasicEventElementMetadata from a dict
basic_event_element_metadata_from_dict = BasicEventElementMetadata.from_dict(basic_event_element_metadata_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


