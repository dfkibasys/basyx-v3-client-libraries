# Extension


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**semantic_id** | [**Reference**](Reference.md) |  | [optional] 
**supplemental_semantic_ids** | [**List[Reference]**](Reference.md) |  | [optional] 
**name** | **str** |  | 
**value_type** | [**DataTypeDefXsd**](DataTypeDefXsd.md) |  | [optional] 
**value** | **str** |  | [optional] 
**refers_to** | [**List[Reference]**](Reference.md) |  | [optional] 

## Example

```python
from basyxclients.models.part1.extension import Extension

# TODO update the JSON string below
json = "{}"
# create an instance of Extension from a JSON string
extension_instance = Extension.from_json(json)
# print the JSON string representation of the object
print(Extension.to_json())

# convert the object into a dict
extension_dict = extension_instance.to_dict()
# create an instance of Extension from a dict
extension_from_dict = Extension.from_dict(extension_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


