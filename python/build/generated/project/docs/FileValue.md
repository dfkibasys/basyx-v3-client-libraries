# FileValue


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**content_type** | **str** |  | 
**value** | **str** |  | 

## Example

```python
from basyxclients.models.part2.file_value import FileValue

# TODO update the JSON string below
json = "{}"
# create an instance of FileValue from a JSON string
file_value_instance = FileValue.from_json(json)
# print the JSON string representation of the object
print(FileValue.to_json())

# convert the object into a dict
file_value_dict = file_value_instance.to_dict()
# create an instance of FileValue from a dict
file_value_from_dict = FileValue.from_dict(file_value_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


