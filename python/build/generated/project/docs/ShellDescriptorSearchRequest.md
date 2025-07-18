# ShellDescriptorSearchRequest


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**page** | [**Page**](Page.md) |  | [optional] 
**sort_by** | [**Sorting**](Sorting.md) |  | [optional] 
**query** | [**ShellDescriptorQuery**](ShellDescriptorQuery.md) |  | [optional] 

## Example

```python
from basyxclients.models.search.shell_descriptor_search_request import ShellDescriptorSearchRequest

# TODO update the JSON string below
json = "{}"
# create an instance of ShellDescriptorSearchRequest from a JSON string
shell_descriptor_search_request_instance = ShellDescriptorSearchRequest.from_json(json)
# print the JSON string representation of the object
print(ShellDescriptorSearchRequest.to_json())

# convert the object into a dict
shell_descriptor_search_request_dict = shell_descriptor_search_request_instance.to_dict()
# create an instance of ShellDescriptorSearchRequest from a dict
shell_descriptor_search_request_from_dict = ShellDescriptorSearchRequest.from_dict(shell_descriptor_search_request_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


