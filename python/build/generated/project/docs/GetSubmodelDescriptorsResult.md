# GetSubmodelDescriptorsResult


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**paging_metadata** | [**PagedResultPagingMetadata**](PagedResultPagingMetadata.md) |  | [optional] 
**result** | [**List[SubmodelDescriptor]**](SubmodelDescriptor.md) |  | [optional] 

## Example

```python
from basyxclients.models.part2.get_submodel_descriptors_result import GetSubmodelDescriptorsResult

# TODO update the JSON string below
json = "{}"
# create an instance of GetSubmodelDescriptorsResult from a JSON string
get_submodel_descriptors_result_instance = GetSubmodelDescriptorsResult.from_json(json)
# print the JSON string representation of the object
print(GetSubmodelDescriptorsResult.to_json())

# convert the object into a dict
get_submodel_descriptors_result_dict = get_submodel_descriptors_result_instance.to_dict()
# create an instance of GetSubmodelDescriptorsResult from a dict
get_submodel_descriptors_result_from_dict = GetSubmodelDescriptorsResult.from_dict(get_submodel_descriptors_result_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


