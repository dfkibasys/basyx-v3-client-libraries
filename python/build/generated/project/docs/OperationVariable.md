# OperationVariable


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**value** | [**SubmodelElementChoice**](SubmodelElementChoice.md) |  | 

## Example

```python
from basyxclients.models.part1.operation_variable import OperationVariable

# TODO update the JSON string below
json = "{}"
# create an instance of OperationVariable from a JSON string
operation_variable_instance = OperationVariable.from_json(json)
# print the JSON string representation of the object
print(OperationVariable.to_json())

# convert the object into a dict
operation_variable_dict = operation_variable_instance.to_dict()
# create an instance of OperationVariable from a dict
operation_variable_from_dict = OperationVariable.from_dict(operation_variable_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


