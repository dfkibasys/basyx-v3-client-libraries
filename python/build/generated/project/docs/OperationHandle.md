# OperationHandle


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**handle_id** | **str** |  | [optional] 

## Example

```python
from basyxclients.models.part2.operation_handle import OperationHandle

# TODO update the JSON string below
json = "{}"
# create an instance of OperationHandle from a JSON string
operation_handle_instance = OperationHandle.from_json(json)
# print the JSON string representation of the object
print(OperationHandle.to_json())

# convert the object into a dict
operation_handle_dict = operation_handle_instance.to_dict()
# create an instance of OperationHandle from a dict
operation_handle_from_dict = OperationHandle.from_dict(operation_handle_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


