# BaseOperationResult


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**messages** | [**List[Message]**](Message.md) |  | [optional] 
**execution_state** | [**ExecutionState**](ExecutionState.md) |  | [optional] 
**success** | **bool** |  | [optional] 

## Example

```python
from basyxclients.models.part2.base_operation_result import BaseOperationResult

# TODO update the JSON string below
json = "{}"
# create an instance of BaseOperationResult from a JSON string
base_operation_result_instance = BaseOperationResult.from_json(json)
# print the JSON string representation of the object
print(BaseOperationResult.to_json())

# convert the object into a dict
base_operation_result_dict = base_operation_result_instance.to_dict()
# create an instance of BaseOperationResult from a dict
base_operation_result_from_dict = BaseOperationResult.from_dict(base_operation_result_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


