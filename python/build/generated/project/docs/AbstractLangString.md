# AbstractLangString


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**language** | **str** |  | 

## Example

```python
from basyxclients.models.part1.abstract_lang_string import AbstractLangString

# TODO update the JSON string below
json = "{}"
# create an instance of AbstractLangString from a JSON string
abstract_lang_string_instance = AbstractLangString.from_json(json)
# print the JSON string representation of the object
print(AbstractLangString.to_json())

# convert the object into a dict
abstract_lang_string_dict = abstract_lang_string_instance.to_dict()
# create an instance of AbstractLangString from a dict
abstract_lang_string_from_dict = AbstractLangString.from_dict(abstract_lang_string_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


