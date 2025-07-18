# GetConceptDescriptionsResult


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**paging_metadata** | [**PagedResultPagingMetadata**](PagedResultPagingMetadata.md) |  | [optional] 
**result** | [**List[ConceptDescription]**](ConceptDescription.md) |  | [optional] 

## Example

```python
from basyxclients.models.part2.get_concept_descriptions_result import GetConceptDescriptionsResult

# TODO update the JSON string below
json = "{}"
# create an instance of GetConceptDescriptionsResult from a JSON string
get_concept_descriptions_result_instance = GetConceptDescriptionsResult.from_json(json)
# print the JSON string representation of the object
print(GetConceptDescriptionsResult.to_json())

# convert the object into a dict
get_concept_descriptions_result_dict = get_concept_descriptions_result_instance.to_dict()
# create an instance of GetConceptDescriptionsResult from a dict
get_concept_descriptions_result_from_dict = GetConceptDescriptionsResult.from_dict(get_concept_descriptions_result_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


