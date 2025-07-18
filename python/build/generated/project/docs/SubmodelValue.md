# SubmodelValue


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**submodel_elements** | [**List[SubmodelElement]**](SubmodelElement.md) |  | [optional] 

## Example

```python
from basyxclients.models.part2.submodel_value import SubmodelValue

# TODO update the JSON string below
json = "{}"
# create an instance of SubmodelValue from a JSON string
submodel_value_instance = SubmodelValue.from_json(json)
# print the JSON string representation of the object
print(SubmodelValue.to_json())

# convert the object into a dict
submodel_value_dict = submodel_value_instance.to_dict()
# create an instance of SubmodelValue from a dict
submodel_value_from_dict = SubmodelValue.from_dict(submodel_value_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


