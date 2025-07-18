# Qualifiable


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**qualifiers** | [**List[Qualifier]**](Qualifier.md) |  | [optional] 
**model_type** | [**ModelType**](ModelType.md) |  | 

## Example

```python
from basyxclients.models.part1.qualifiable import Qualifiable

# TODO update the JSON string below
json = "{}"
# create an instance of Qualifiable from a JSON string
qualifiable_instance = Qualifiable.from_json(json)
# print the JSON string representation of the object
print(Qualifiable.to_json())

# convert the object into a dict
qualifiable_dict = qualifiable_instance.to_dict()
# create an instance of Qualifiable from a dict
qualifiable_from_dict = Qualifiable.from_dict(qualifiable_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


