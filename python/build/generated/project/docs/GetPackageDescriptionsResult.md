# GetPackageDescriptionsResult


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**paging_metadata** | [**PagedResultPagingMetadata**](PagedResultPagingMetadata.md) |  | [optional] 
**result** | [**List[PackageDescription]**](PackageDescription.md) |  | [optional] 

## Example

```python
from basyxclients.models.part2.get_package_descriptions_result import GetPackageDescriptionsResult

# TODO update the JSON string below
json = "{}"
# create an instance of GetPackageDescriptionsResult from a JSON string
get_package_descriptions_result_instance = GetPackageDescriptionsResult.from_json(json)
# print the JSON string representation of the object
print(GetPackageDescriptionsResult.to_json())

# convert the object into a dict
get_package_descriptions_result_dict = get_package_descriptions_result_instance.to_dict()
# create an instance of GetPackageDescriptionsResult from a dict
get_package_descriptions_result_from_dict = GetPackageDescriptionsResult.from_dict(get_package_descriptions_result_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


