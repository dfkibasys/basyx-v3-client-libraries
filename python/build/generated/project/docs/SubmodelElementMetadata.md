# SubmodelElementMetadata


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

## Example

```python
from basyxclients.models.part2.submodel_element_metadata import SubmodelElementMetadata

# TODO update the JSON string below
json = "{}"
# create an instance of SubmodelElementMetadata from a JSON string
submodel_element_metadata_instance = SubmodelElementMetadata.from_json(json)
# print the JSON string representation of the object
print(SubmodelElementMetadata.to_json())

# convert the object into a dict
submodel_element_metadata_dict = submodel_element_metadata_instance.to_dict()
# create an instance of SubmodelElementMetadata from a dict
submodel_element_metadata_from_dict = SubmodelElementMetadata.from_dict(submodel_element_metadata_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


