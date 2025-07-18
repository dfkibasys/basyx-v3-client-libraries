# GetSubmodelElementsMetadataResult


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**paging_metadata** | [**PagedResultPagingMetadata**](PagedResultPagingMetadata.md) |  | [optional] 
**result** | [**List[SubmodelElementMetadata]**](SubmodelElementMetadata.md) |  | [optional] 

## Example

```python
from basyxclients.models.part2.get_submodel_elements_metadata_result import GetSubmodelElementsMetadataResult

# TODO update the JSON string below
json = "{}"
# create an instance of GetSubmodelElementsMetadataResult from a JSON string
get_submodel_elements_metadata_result_instance = GetSubmodelElementsMetadataResult.from_json(json)
# print the JSON string representation of the object
print(GetSubmodelElementsMetadataResult.to_json())

# convert the object into a dict
get_submodel_elements_metadata_result_dict = get_submodel_elements_metadata_result_instance.to_dict()
# create an instance of GetSubmodelElementsMetadataResult from a dict
get_submodel_elements_metadata_result_from_dict = GetSubmodelElementsMetadataResult.from_dict(get_submodel_elements_metadata_result_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


