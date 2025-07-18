# SubmodelElementList


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
**order_relevant** | **bool** |  | [optional] 
**semantic_id_list_element** | [**Reference**](Reference.md) |  | [optional] 
**type_value_list_element** | [**AasSubmodelElements**](AasSubmodelElements.md) |  | 
**value_type_list_element** | [**DataTypeDefXsd**](DataTypeDefXsd.md) |  | [optional] 
**value** | [**List[SubmodelElementChoice]**](SubmodelElementChoice.md) |  | [optional] 

## Example

```python
from basyxclients.models.part1.submodel_element_list import SubmodelElementList

# TODO update the JSON string below
json = "{}"
# create an instance of SubmodelElementList from a JSON string
submodel_element_list_instance = SubmodelElementList.from_json(json)
# print the JSON string representation of the object
print(SubmodelElementList.to_json())

# convert the object into a dict
submodel_element_list_dict = submodel_element_list_instance.to_dict()
# create an instance of SubmodelElementList from a dict
submodel_element_list_from_dict = SubmodelElementList.from_dict(submodel_element_list_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


