# BlobValue


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**content_type** | **str** |  | 
**value** | **str** |  | 

## Example

```python
from basyxclients.models.part2.blob_value import BlobValue

# TODO update the JSON string below
json = "{}"
# create an instance of BlobValue from a JSON string
blob_value_instance = BlobValue.from_json(json)
# print the JSON string representation of the object
print(BlobValue.to_json())

# convert the object into a dict
blob_value_dict = blob_value_instance.to_dict()
# create an instance of BlobValue from a dict
blob_value_from_dict = BlobValue.from_dict(blob_value_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


