# HasSemantics


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**semantic_id** | [**Reference**](Reference.md) |  | [optional] 
**supplemental_semantic_ids** | [**List[Reference]**](Reference.md) |  | [optional] 

## Example

```python
from basyxclients.models.part1.has_semantics import HasSemantics

# TODO update the JSON string below
json = "{}"
# create an instance of HasSemantics from a JSON string
has_semantics_instance = HasSemantics.from_json(json)
# print the JSON string representation of the object
print(HasSemantics.to_json())

# convert the object into a dict
has_semantics_dict = has_semantics_instance.to_dict()
# create an instance of HasSemantics from a dict
has_semantics_from_dict = HasSemantics.from_dict(has_semantics_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


