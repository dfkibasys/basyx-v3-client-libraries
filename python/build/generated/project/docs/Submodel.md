# Submodel


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**extensions** | [**List[Extension]**](Extension.md) |  | [optional] 
**category** | **str** |  | [optional] 
**id_short** | **str** |  | [optional] 
**display_name** | [**List[LangStringNameType]**](LangStringNameType.md) |  | [optional] 
**description** | [**List[LangStringTextType]**](LangStringTextType.md) |  | [optional] 
**model_type** | **str** |  | 
**administration** | [**AdministrativeInformation**](AdministrativeInformation.md) |  | [optional] 
**id** | **str** |  | 
**kind** | [**ModellingKind**](ModellingKind.md) |  | [optional] 
**semantic_id** | [**Reference**](Reference.md) |  | [optional] 
**supplemental_semantic_ids** | [**List[Reference]**](Reference.md) |  | [optional] 
**qualifiers** | [**List[Qualifier]**](Qualifier.md) |  | [optional] 
**embedded_data_specifications** | [**List[EmbeddedDataSpecification]**](EmbeddedDataSpecification.md) |  | [optional] 
**submodel_elements** | [**List[SubmodelElementChoice]**](SubmodelElementChoice.md) |  | [optional] 

## Example

```python
from basyxclients.models.part1.submodel import Submodel

# TODO update the JSON string below
json = "{}"
# create an instance of Submodel from a JSON string
submodel_instance = Submodel.from_json(json)
# print the JSON string representation of the object
print(Submodel.to_json())

# convert the object into a dict
submodel_dict = submodel_instance.to_dict()
# create an instance of Submodel from a dict
submodel_from_dict = Submodel.from_dict(submodel_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


