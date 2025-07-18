# SubmodelElementValue


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**observed** | [**ReferenceValue**](ReferenceValue.md) |  | 
**content_type** | **str** |  | 
**value** | **str** |  | 
**max** | **float** |  | 
**min** | **float** |  | 
**type** | [**ReferenceTypes**](ReferenceTypes.md) |  | [optional] 
**keys** | [**List[Key]**](Key.md) |  | [optional] 
**first** | [**ReferenceValue**](ReferenceValue.md) |  | 
**second** | [**ReferenceValue**](ReferenceValue.md) |  | 
**annotations** | **List[object]** |  | [optional] 
**entity_type** | [**EntityType**](EntityType.md) |  | 
**global_asset_id** | **str** |  | [optional] 
**specific_asset_ids** | **List[object]** |  | [optional] 
**statements** | **List[object]** |  | 

## Example

```python
from basyxclients.models.part2.submodel_element_value import SubmodelElementValue

# TODO update the JSON string below
json = "{}"
# create an instance of SubmodelElementValue from a JSON string
submodel_element_value_instance = SubmodelElementValue.from_json(json)
# print the JSON string representation of the object
print(SubmodelElementValue.to_json())

# convert the object into a dict
submodel_element_value_dict = submodel_element_value_instance.to_dict()
# create an instance of SubmodelElementValue from a dict
submodel_element_value_from_dict = SubmodelElementValue.from_dict(submodel_element_value_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


