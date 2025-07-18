# OperationRequestValueOnly


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**inoutput_arguments** | **object** | The ValueOnly serialization of submodel elements (patternProperties and propertyNames will be supported propably with OpenApi 3.1). The full description of the generic JSON validation schema for the ValueOnly-serialization can be found in chapter 11.4.3 in Details of the Asset Administration Shell Part 2.  | [optional] 
**input_arguments** | **object** | The ValueOnly serialization of submodel elements (patternProperties and propertyNames will be supported propably with OpenApi 3.1). The full description of the generic JSON validation schema for the ValueOnly-serialization can be found in chapter 11.4.3 in Details of the Asset Administration Shell Part 2.  | [optional] 
**client_timeout_duration** | **str** |  | 

## Example

```python
from basyxclients.models.part2.operation_request_value_only import OperationRequestValueOnly

# TODO update the JSON string below
json = "{}"
# create an instance of OperationRequestValueOnly from a JSON string
operation_request_value_only_instance = OperationRequestValueOnly.from_json(json)
# print the JSON string representation of the object
print(OperationRequestValueOnly.to_json())

# convert the object into a dict
operation_request_value_only_dict = operation_request_value_only_instance.to_dict()
# create an instance of OperationRequestValueOnly from a dict
operation_request_value_only_from_dict = OperationRequestValueOnly.from_dict(operation_request_value_only_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


