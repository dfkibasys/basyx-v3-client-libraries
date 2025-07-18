# DataSpecificationIec61360


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**preferred_name** | [**List[LangStringPreferredNameTypeIec61360]**](LangStringPreferredNameTypeIec61360.md) |  | 
**short_name** | [**List[LangStringShortNameTypeIec61360]**](LangStringShortNameTypeIec61360.md) |  | [optional] 
**unit** | **str** |  | [optional] 
**unit_id** | [**Reference**](Reference.md) |  | [optional] 
**source_of_definition** | **str** |  | [optional] 
**symbol** | **str** |  | [optional] 
**data_type** | [**DataTypeIec61360**](DataTypeIec61360.md) |  | [optional] 
**definition** | [**List[LangStringDefinitionTypeIec61360]**](LangStringDefinitionTypeIec61360.md) |  | [optional] 
**value_format** | **str** |  | [optional] 
**value_list** | [**ValueList**](ValueList.md) |  | [optional] 
**value** | **str** |  | [optional] 
**level_type** | [**LevelType**](LevelType.md) |  | [optional] 
**model_type** | **str** |  | [default to 'DataSpecificationIec61360']

## Example

```python
from basyxclients.models.part1.data_specification_iec61360 import DataSpecificationIec61360

# TODO update the JSON string below
json = "{}"
# create an instance of DataSpecificationIec61360 from a JSON string
data_specification_iec61360_instance = DataSpecificationIec61360.from_json(json)
# print the JSON string representation of the object
print(DataSpecificationIec61360.to_json())

# convert the object into a dict
data_specification_iec61360_dict = data_specification_iec61360_instance.to_dict()
# create an instance of DataSpecificationIec61360 from a dict
data_specification_iec61360_from_dict = DataSpecificationIec61360.from_dict(data_specification_iec61360_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


