# EmbeddedDataSpecification


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**data_specification** | [**Reference**](Reference.md) |  | 
**data_specification_content** | [**DataSpecificationIec61360**](DataSpecificationIec61360.md) |  | 

## Example

```python
from basyxclients.models.part1.embedded_data_specification import EmbeddedDataSpecification

# TODO update the JSON string below
json = "{}"
# create an instance of EmbeddedDataSpecification from a JSON string
embedded_data_specification_instance = EmbeddedDataSpecification.from_json(json)
# print the JSON string representation of the object
print(EmbeddedDataSpecification.to_json())

# convert the object into a dict
embedded_data_specification_dict = embedded_data_specification_instance.to_dict()
# create an instance of EmbeddedDataSpecification from a dict
embedded_data_specification_from_dict = EmbeddedDataSpecification.from_dict(embedded_data_specification_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


