# ProtocolInformationSecurityAttributes


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**type** | **str** |  | 
**key** | **str** |  | 
**value** | **str** |  | 

## Example

```python
from basyxclients.models.part2.protocol_information_security_attributes import ProtocolInformationSecurityAttributes

# TODO update the JSON string below
json = "{}"
# create an instance of ProtocolInformationSecurityAttributes from a JSON string
protocol_information_security_attributes_instance = ProtocolInformationSecurityAttributes.from_json(json)
# print the JSON string representation of the object
print(ProtocolInformationSecurityAttributes.to_json())

# convert the object into a dict
protocol_information_security_attributes_dict = protocol_information_security_attributes_instance.to_dict()
# create an instance of ProtocolInformationSecurityAttributes from a dict
protocol_information_security_attributes_from_dict = ProtocolInformationSecurityAttributes.from_dict(protocol_information_security_attributes_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


