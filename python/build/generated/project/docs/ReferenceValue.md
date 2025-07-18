# ReferenceValue


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**type** | [**ReferenceTypes**](ReferenceTypes.md) |  | [optional] 
**keys** | [**List[Key]**](Key.md) |  | [optional] 

## Example

```python
from basyxclients.models.part2.reference_value import ReferenceValue

# TODO update the JSON string below
json = "{}"
# create an instance of ReferenceValue from a JSON string
reference_value_instance = ReferenceValue.from_json(json)
# print the JSON string representation of the object
print(ReferenceValue.to_json())

# convert the object into a dict
reference_value_dict = reference_value_instance.to_dict()
# create an instance of ReferenceValue from a dict
reference_value_from_dict = ReferenceValue.from_dict(reference_value_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


