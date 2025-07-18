# ShellDescriptorQuery


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**path** | **str** |  | 
**value** | **str** |  | 
**extension_name** | **str** | If this property is set, the query applies only to the extension of this name. In this case, the path must reference the value property of the extension object.  | [optional] 
**query_type** | **str** |  | [optional] [default to 'match']
**combined_with** | [**ShellDescriptorQuery**](ShellDescriptorQuery.md) |  | [optional] 

## Example

```python
from basyxclients.models.search.shell_descriptor_query import ShellDescriptorQuery

# TODO update the JSON string below
json = "{}"
# create an instance of ShellDescriptorQuery from a JSON string
shell_descriptor_query_instance = ShellDescriptorQuery.from_json(json)
# print the JSON string representation of the object
print(ShellDescriptorQuery.to_json())

# convert the object into a dict
shell_descriptor_query_dict = shell_descriptor_query_instance.to_dict()
# create an instance of ShellDescriptorQuery from a dict
shell_descriptor_query_from_dict = ShellDescriptorQuery.from_dict(shell_descriptor_query_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


