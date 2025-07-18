# RangeMetadata


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**value_type** | [**DataTypeDefXsd**](DataTypeDefXsd.md) |  | [optional] 
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
from basyxclients.models.part2.range_metadata import RangeMetadata

# TODO update the JSON string below
json = "{}"
# create an instance of RangeMetadata from a JSON string
range_metadata_instance = RangeMetadata.from_json(json)
# print the JSON string representation of the object
print(RangeMetadata.to_json())

# convert the object into a dict
range_metadata_dict = range_metadata_instance.to_dict()
# create an instance of RangeMetadata from a dict
range_metadata_from_dict = RangeMetadata.from_dict(range_metadata_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


