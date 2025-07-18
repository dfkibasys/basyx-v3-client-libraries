# OperationResultValueOnly


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**messages** | [**List[Message]**](Message.md) |  | [optional] 
**execution_state** | [**ExecutionState**](ExecutionState.md) |  | [optional] 
**success** | **bool** |  | [optional] 
**inoutput_arguments** | **object** | The ValueOnly serialization of submodel elements (patternProperties and propertyNames will be supported propably with OpenApi 3.1). The full description of the generic JSON validation schema for the ValueOnly-serialization can be found in chapter 11.4.3 in Details of the Asset Administration Shell Part 2.  | [optional] 
**output_arguments** | **object** | The ValueOnly serialization of submodel elements (patternProperties and propertyNames will be supported propably with OpenApi 3.1). The full description of the generic JSON validation schema for the ValueOnly-serialization can be found in chapter 11.4.3 in Details of the Asset Administration Shell Part 2.  | [optional] 

## Example

```python
from basyxclients.models.part2.operation_result_value_only import OperationResultValueOnly

# TODO update the JSON string below
json = "{}"
# create an instance of OperationResultValueOnly from a JSON string
operation_result_value_only_instance = OperationResultValueOnly.from_json(json)
# print the JSON string representation of the object
print(OperationResultValueOnly.to_json())

# convert the object into a dict
operation_result_value_only_dict = operation_result_value_only_instance.to_dict()
# create an instance of OperationResultValueOnly from a dict
operation_result_value_only_from_dict = OperationResultValueOnly.from_dict(operation_result_value_only_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


