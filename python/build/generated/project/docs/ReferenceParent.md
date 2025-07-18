# ReferenceParent


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**type** | [**ReferenceTypes**](ReferenceTypes.md) |  | 
**keys** | [**List[Key]**](Key.md) |  | 

## Example

```python
from basyxclients.models.part1.reference_parent import ReferenceParent

# TODO update the JSON string below
json = "{}"
# create an instance of ReferenceParent from a JSON string
reference_parent_instance = ReferenceParent.from_json(json)
# print the JSON string representation of the object
print(ReferenceParent.to_json())

# convert the object into a dict
reference_parent_dict = reference_parent_instance.to_dict()
# create an instance of ReferenceParent from a dict
reference_parent_from_dict = ReferenceParent.from_dict(reference_parent_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


