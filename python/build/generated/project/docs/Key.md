# Key


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**type** | [**KeyTypes**](KeyTypes.md) |  | 
**value** | **str** |  | 

## Example

```python
from basyxclients.models.part1.key import Key

# TODO update the JSON string below
json = "{}"
# create an instance of Key from a JSON string
key_instance = Key.from_json(json)
# print the JSON string representation of the object
print(Key.to_json())

# convert the object into a dict
key_dict = key_instance.to_dict()
# create an instance of Key from a dict
key_from_dict = Key.from_dict(key_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


