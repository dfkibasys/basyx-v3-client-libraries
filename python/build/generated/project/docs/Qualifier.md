# Qualifier


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**semantic_id** | [**Reference**](Reference.md) |  | [optional] 
**supplemental_semantic_ids** | [**List[Reference]**](Reference.md) |  | [optional] 
**kind** | [**QualifierKind**](QualifierKind.md) |  | [optional] 
**type** | **str** |  | 
**value_type** | [**DataTypeDefXsd**](DataTypeDefXsd.md) |  | 
**value** | **str** |  | [optional] 
**value_id** | [**Reference**](Reference.md) |  | [optional] 

## Example

```python
from basyxclients.models.part1.qualifier import Qualifier

# TODO update the JSON string below
json = "{}"
# create an instance of Qualifier from a JSON string
qualifier_instance = Qualifier.from_json(json)
# print the JSON string representation of the object
print(Qualifier.to_json())

# convert the object into a dict
qualifier_dict = qualifier_instance.to_dict()
# create an instance of Qualifier from a dict
qualifier_from_dict = Qualifier.from_dict(qualifier_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


