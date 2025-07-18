# ValueList


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**value_reference_pairs** | [**List[ValueReferencePair]**](ValueReferencePair.md) |  | 

## Example

```python
from basyxclients.models.part1.value_list import ValueList

# TODO update the JSON string below
json = "{}"
# create an instance of ValueList from a JSON string
value_list_instance = ValueList.from_json(json)
# print the JSON string representation of the object
print(ValueList.to_json())

# convert the object into a dict
value_list_dict = value_list_instance.to_dict()
# create an instance of ValueList from a dict
value_list_from_dict = ValueList.from_dict(value_list_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


