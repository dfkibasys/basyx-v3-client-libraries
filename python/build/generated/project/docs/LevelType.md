# LevelType


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**min** | **bool** |  | 
**nom** | **bool** |  | 
**typ** | **bool** |  | 
**max** | **bool** |  | 

## Example

```python
from basyxclients.models.part1.level_type import LevelType

# TODO update the JSON string below
json = "{}"
# create an instance of LevelType from a JSON string
level_type_instance = LevelType.from_json(json)
# print the JSON string representation of the object
print(LevelType.to_json())

# convert the object into a dict
level_type_dict = level_type_instance.to_dict()
# create an instance of LevelType from a dict
level_type_from_dict = LevelType.from_dict(level_type_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


