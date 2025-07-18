# OperationResult


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**messages** | [**List[Message]**](Message.md) |  | [optional] 
**execution_state** | [**ExecutionState**](ExecutionState.md) |  | [optional] 
**success** | **bool** |  | [optional] 
**inoutput_arguments** | [**List[OperationVariable]**](OperationVariable.md) |  | [optional] 
**output_arguments** | [**List[OperationVariable]**](OperationVariable.md) |  | [optional] 

## Example

```python
from basyxclients.models.part2.operation_result import OperationResult

# TODO update the JSON string below
json = "{}"
# create an instance of OperationResult from a JSON string
operation_result_instance = OperationResult.from_json(json)
# print the JSON string representation of the object
print(OperationResult.to_json())

# convert the object into a dict
operation_result_dict = operation_result_instance.to_dict()
# create an instance of OperationResult from a dict
operation_result_from_dict = OperationResult.from_dict(operation_result_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


