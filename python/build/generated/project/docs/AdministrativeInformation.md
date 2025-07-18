# AdministrativeInformation


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**embedded_data_specifications** | [**List[EmbeddedDataSpecification]**](EmbeddedDataSpecification.md) |  | [optional] 
**version** | **str** |  | [optional] 
**revision** | **str** |  | [optional] 
**creator** | [**Reference**](Reference.md) |  | [optional] 
**template_id** | **str** |  | [optional] 

## Example

```python
from basyxclients.models.part1.administrative_information import AdministrativeInformation

# TODO update the JSON string below
json = "{}"
# create an instance of AdministrativeInformation from a JSON string
administrative_information_instance = AdministrativeInformation.from_json(json)
# print the JSON string representation of the object
print(AdministrativeInformation.to_json())

# convert the object into a dict
administrative_information_dict = administrative_information_instance.to_dict()
# create an instance of AdministrativeInformation from a dict
administrative_information_from_dict = AdministrativeInformation.from_dict(administrative_information_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


