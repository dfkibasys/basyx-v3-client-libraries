# GetSubmodelsMetadataResult


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**paging_metadata** | [**PagedResultPagingMetadata**](PagedResultPagingMetadata.md) |  | [optional] 
**result** | [**List[SubmodelMetadata]**](SubmodelMetadata.md) |  | [optional] 

## Example

```python
from basyxclients.models.part2.get_submodels_metadata_result import GetSubmodelsMetadataResult

# TODO update the JSON string below
json = "{}"
# create an instance of GetSubmodelsMetadataResult from a JSON string
get_submodels_metadata_result_instance = GetSubmodelsMetadataResult.from_json(json)
# print the JSON string representation of the object
print(GetSubmodelsMetadataResult.to_json())

# convert the object into a dict
get_submodels_metadata_result_dict = get_submodels_metadata_result_instance.to_dict()
# create an instance of GetSubmodelsMetadataResult from a dict
get_submodels_metadata_result_from_dict = GetSubmodelsMetadataResult.from_dict(get_submodels_metadata_result_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


