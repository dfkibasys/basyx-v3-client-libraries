# ValueReferencePair


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**value** | **str** |  | 
**value_id** | [**Reference**](Reference.md) |  | 

## Example

```python
from basyxclients.models.part1.value_reference_pair import ValueReferencePair

# TODO update the JSON string below
json = "{}"
# create an instance of ValueReferencePair from a JSON string
value_reference_pair_instance = ValueReferencePair.from_json(json)
# print the JSON string representation of the object
print(ValueReferencePair.to_json())

# convert the object into a dict
value_reference_pair_dict = value_reference_pair_instance.to_dict()
# create an instance of ValueReferencePair from a dict
value_reference_pair_from_dict = ValueReferencePair.from_dict(value_reference_pair_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


