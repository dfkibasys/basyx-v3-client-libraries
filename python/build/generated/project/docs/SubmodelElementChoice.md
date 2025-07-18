# SubmodelElementChoice


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
**observed** | [**Reference**](Reference.md) |  | 
**direction** | [**Direction**](Direction.md) |  | 
**state** | [**StateOfEvent**](StateOfEvent.md) |  | 
**message_topic** | **str** |  | [optional] 
**message_broker** | [**Reference**](Reference.md) |  | [optional] 
**last_update** | **str** |  | [optional] 
**min_interval** | **str** |  | [optional] 
**max_interval** | **str** |  | [optional] 
**value** | [**List[SubmodelElementChoice]**](SubmodelElementChoice.md) |  | [optional] 
**content_type** | **str** |  | 
**statements** | [**List[SubmodelElementChoice]**](SubmodelElementChoice.md) |  | [optional] 
**entity_type** | [**EntityType**](EntityType.md) |  | 
**global_asset_id** | **str** |  | [optional] 
**specific_asset_ids** | [**List[SpecificAssetId]**](SpecificAssetId.md) |  | [optional] 
**value_id** | [**Reference**](Reference.md) |  | [optional] 
**input_variables** | [**List[OperationVariable]**](OperationVariable.md) |  | [optional] 
**output_variables** | [**List[OperationVariable]**](OperationVariable.md) |  | [optional] 
**inoutput_variables** | [**List[OperationVariable]**](OperationVariable.md) |  | [optional] 
**value_type** | [**DataTypeDefXsd**](DataTypeDefXsd.md) |  | 
**min** | **str** |  | [optional] 
**max** | **str** |  | [optional] 
**order_relevant** | **bool** |  | [optional] 
**semantic_id_list_element** | [**Reference**](Reference.md) |  | [optional] 
**type_value_list_element** | [**AasSubmodelElements**](AasSubmodelElements.md) |  | 
**value_type_list_element** | [**DataTypeDefXsd**](DataTypeDefXsd.md) |  | [optional] 

## Example

```python
from basyxclients.models.part1.submodel_element_choice import SubmodelElementChoice

# TODO update the JSON string below
json = "{}"
# create an instance of SubmodelElementChoice from a JSON string
submodel_element_choice_instance = SubmodelElementChoice.from_json(json)
# print the JSON string representation of the object
print(SubmodelElementChoice.to_json())

# convert the object into a dict
submodel_element_choice_dict = submodel_element_choice_instance.to_dict()
# create an instance of SubmodelElementChoice from a dict
submodel_element_choice_from_dict = SubmodelElementChoice.from_dict(submodel_element_choice_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


