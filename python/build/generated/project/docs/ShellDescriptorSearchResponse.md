# ShellDescriptorSearchResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**total** | **int** |  | 
**hits** | [**List[AssetAdministrationShellDescriptor]**](AssetAdministrationShellDescriptor.md) |  | 

## Example

```python
from basyxclients.models.search.shell_descriptor_search_response import ShellDescriptorSearchResponse

# TODO update the JSON string below
json = "{}"
# create an instance of ShellDescriptorSearchResponse from a JSON string
shell_descriptor_search_response_instance = ShellDescriptorSearchResponse.from_json(json)
# print the JSON string representation of the object
print(ShellDescriptorSearchResponse.to_json())

# convert the object into a dict
shell_descriptor_search_response_dict = shell_descriptor_search_response_instance.to_dict()
# create an instance of ShellDescriptorSearchResponse from a dict
shell_descriptor_search_response_from_dict = ShellDescriptorSearchResponse.from_dict(shell_descriptor_search_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


