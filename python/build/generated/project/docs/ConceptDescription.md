# ConceptDescription


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**extensions** | [**List[Extension]**](Extension.md) |  | [optional] 
**category** | **str** |  | [optional] 
**id_short** | **str** |  | [optional] 
**display_name** | [**List[LangStringNameType]**](LangStringNameType.md) |  | [optional] 
**description** | [**List[LangStringTextType]**](LangStringTextType.md) |  | [optional] 
**model_type** | **str** |  | 
**administration** | [**AdministrativeInformation**](AdministrativeInformation.md) |  | [optional] 
**id** | **str** |  | 
**embedded_data_specifications** | [**List[EmbeddedDataSpecification]**](EmbeddedDataSpecification.md) |  | [optional] 
**is_case_of** | [**List[Reference]**](Reference.md) |  | [optional] 

## Example

```python
from basyxclients.models.part1.concept_description import ConceptDescription

# TODO update the JSON string below
json = "{}"
# create an instance of ConceptDescription from a JSON string
concept_description_instance = ConceptDescription.from_json(json)
# print the JSON string representation of the object
print(ConceptDescription.to_json())

# convert the object into a dict
concept_description_dict = concept_description_instance.to_dict()
# create an instance of ConceptDescription from a dict
concept_description_from_dict = ConceptDescription.from_dict(concept_description_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


