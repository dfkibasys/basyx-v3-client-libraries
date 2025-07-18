# ProtocolInformation


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**href** | **str** |  | 
**endpoint_protocol** | **str** |  | [optional] 
**endpoint_protocol_version** | **List[str]** |  | [optional] 
**subprotocol** | **str** |  | [optional] 
**subprotocol_body** | **str** |  | [optional] 
**subprotocol_body_encoding** | **str** |  | [optional] 
**security_attributes** | [**List[ProtocolInformationSecurityAttributes]**](ProtocolInformationSecurityAttributes.md) |  | [optional] 

## Example

```python
from basyxclients.models.part2.protocol_information import ProtocolInformation

# TODO update the JSON string below
json = "{}"
# create an instance of ProtocolInformation from a JSON string
protocol_information_instance = ProtocolInformation.from_json(json)
# print the JSON string representation of the object
print(ProtocolInformation.to_json())

# convert the object into a dict
protocol_information_dict = protocol_information_instance.to_dict()
# create an instance of ProtocolInformation from a dict
protocol_information_from_dict = ProtocolInformation.from_dict(protocol_information_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


