# SubmodelDescriptor


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**description** | [**List[LangStringTextType]**](LangStringTextType.md) |  | [optional] 
**display_name** | [**List[LangStringNameType]**](LangStringNameType.md) |  | [optional] 
**extensions** | [**List[Extension]**](Extension.md) |  | [optional] 
**administration** | [**AdministrativeInformation**](AdministrativeInformation.md) |  | [optional] 
**id_short** | **str** |  | [optional] 
**id** | **str** |  | 
**semantic_id** | [**Reference**](Reference.md) |  | [optional] 
**supplemental_semantic_id** | [**List[Reference]**](Reference.md) |  | [optional] 
**endpoints** | [**List[Endpoint]**](Endpoint.md) |  | 

## Example

```python
from basyxclients.models.part2.submodel_descriptor import SubmodelDescriptor

# TODO update the JSON string below
json = "{}"
# create an instance of SubmodelDescriptor from a JSON string
submodel_descriptor_instance = SubmodelDescriptor.from_json(json)
# print the JSON string representation of the object
print(SubmodelDescriptor.to_json())

# convert the object into a dict
submodel_descriptor_dict = submodel_descriptor_instance.to_dict()
# create an instance of SubmodelDescriptor from a dict
submodel_descriptor_from_dict = SubmodelDescriptor.from_dict(submodel_descriptor_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


