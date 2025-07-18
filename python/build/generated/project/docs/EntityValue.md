# EntityValue


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**entity_type** | [**EntityType**](EntityType.md) |  | 
**global_asset_id** | **str** |  | [optional] 
**specific_asset_ids** | **List[object]** |  | [optional] 
**statements** | **List[object]** |  | 

## Example

```python
from basyxclients.models.part2.entity_value import EntityValue

# TODO update the JSON string below
json = "{}"
# create an instance of EntityValue from a JSON string
entity_value_instance = EntityValue.from_json(json)
# print the JSON string representation of the object
print(EntityValue.to_json())

# convert the object into a dict
entity_value_dict = entity_value_instance.to_dict()
# create an instance of EntityValue from a dict
entity_value_from_dict = EntityValue.from_dict(entity_value_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


