# Environment


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**asset_administration_shells** | [**List[AssetAdministrationShell]**](AssetAdministrationShell.md) |  | [optional] 
**submodels** | [**List[Submodel]**](Submodel.md) |  | [optional] 
**concept_descriptions** | [**List[ConceptDescription]**](ConceptDescription.md) |  | [optional] 

## Example

```python
from basyxclients.models.part1.environment import Environment

# TODO update the JSON string below
json = "{}"
# create an instance of Environment from a JSON string
environment_instance = Environment.from_json(json)
# print the JSON string representation of the object
print(Environment.to_json())

# convert the object into a dict
environment_dict = environment_instance.to_dict()
# create an instance of Environment from a dict
environment_from_dict = Environment.from_dict(environment_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


