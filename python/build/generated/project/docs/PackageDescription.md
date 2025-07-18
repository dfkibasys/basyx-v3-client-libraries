# PackageDescription


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**aas_ids** | **List[str]** |  | [optional] 
**package_id** | **str** |  | [optional] 

## Example

```python
from basyxclients.models.part2.package_description import PackageDescription

# TODO update the JSON string below
json = "{}"
# create an instance of PackageDescription from a JSON string
package_description_instance = PackageDescription.from_json(json)
# print the JSON string representation of the object
print(PackageDescription.to_json())

# convert the object into a dict
package_description_dict = package_description_instance.to_dict()
# create an instance of PackageDescription from a dict
package_description_from_dict = PackageDescription.from_dict(package_description_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


