# ServiceDescription

The Description object enables servers to present their capabilities to the clients, in particular which profiles they implement. At least one defined profile is required. Additional, proprietary attributes might be included. Nevertheless, the server must not expect that a regular client understands them.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**profiles** | **List[str]** |  | [optional] 

## Example

```python
from basyxclients.models.part2.service_description import ServiceDescription

# TODO update the JSON string below
json = "{}"
# create an instance of ServiceDescription from a JSON string
service_description_instance = ServiceDescription.from_json(json)
# print the JSON string representation of the object
print(ServiceDescription.to_json())

# convert the object into a dict
service_description_dict = service_description_instance.to_dict()
# create an instance of ServiceDescription from a dict
service_description_from_dict = ServiceDescription.from_dict(service_description_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


