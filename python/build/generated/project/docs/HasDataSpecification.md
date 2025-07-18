# HasDataSpecification


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**embedded_data_specifications** | [**List[EmbeddedDataSpecification]**](EmbeddedDataSpecification.md) |  | [optional] 

## Example

```python
from basyxclients.models.part1.has_data_specification import HasDataSpecification

# TODO update the JSON string below
json = "{}"
# create an instance of HasDataSpecification from a JSON string
has_data_specification_instance = HasDataSpecification.from_json(json)
# print the JSON string representation of the object
print(HasDataSpecification.to_json())

# convert the object into a dict
has_data_specification_dict = has_data_specification_instance.to_dict()
# create an instance of HasDataSpecification from a dict
has_data_specification_from_dict = HasDataSpecification.from_dict(has_data_specification_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


