# coding: utf-8

"""
    DotAAS Part 2 | API | Schemas

    The schemas implementing the [Specification of the Asset Administration Shell: Part 2](http://industrialdigitaltwin.org/en/content-hub).   Publisher: Industrial Digital Twin Association (IDTA) 2023

    The version of the OpenAPI document: V3.0.1
    Contact: info@idtwin.org
    Generated by OpenAPI Generator (https://openapi-generator.tech)

    Do not edit the class manually.
"""  # noqa: E501


from __future__ import annotations
import json
import pprint
from pydantic import BaseModel, ConfigDict, Field, StrictStr, ValidationError, field_validator
from typing import Any, Dict, List, Optional
from basyxclients.models.part2.annotated_relationship_element_value import AnnotatedRelationshipElementValue
from basyxclients.models.part2.basic_event_element_value import BasicEventElementValue
from basyxclients.models.part2.blob_value import BlobValue
from basyxclients.models.part2.entity_value import EntityValue
from basyxclients.models.part2.file_value import FileValue
from basyxclients.models.part2.property_value import PropertyValue
from basyxclients.models.part2.range_value import RangeValue
from basyxclients.models.part2.reference_value import ReferenceValue
from basyxclients.models.part2.relationship_element_value import RelationshipElementValue
from pydantic import StrictStr, Field
from typing import Union, List, Optional, Dict
from typing_extensions import Literal, Self

SUBMODELELEMENTVALUE_ONE_OF_SCHEMAS = ["AnnotatedRelationshipElementValue", "BasicEventElementValue", "BlobValue", "EntityValue", "FileValue", "PropertyValue", "RangeValue", "ReferenceValue", "RelationshipElementValue", "object"]

class SubmodelElementValue(BaseModel):
    """
    SubmodelElementValue
    """
    # data type: BasicEventElementValue
    oneof_schema_1_validator: Optional[BasicEventElementValue] = None
    # data type: PropertyValue
    oneof_schema_2_validator: Optional[PropertyValue] = None
    # data type: object
    oneof_schema_3_validator: Optional[Dict[str, Any]] = Field(default=None, description="Since patternProperties and propertyNames are not supported by OpenApi yet, the ValueOnly serialization for this elements works with the key-attribute as the JSON-property name and the value-attribute as the corresponding value.")
    # data type: BlobValue
    oneof_schema_4_validator: Optional[BlobValue] = None
    # data type: FileValue
    oneof_schema_5_validator: Optional[FileValue] = None
    # data type: RangeValue
    oneof_schema_6_validator: Optional[RangeValue] = None
    # data type: ReferenceValue
    oneof_schema_7_validator: Optional[ReferenceValue] = None
    # data type: RelationshipElementValue
    oneof_schema_8_validator: Optional[RelationshipElementValue] = None
    # data type: AnnotatedRelationshipElementValue
    oneof_schema_9_validator: Optional[AnnotatedRelationshipElementValue] = None
    # data type: EntityValue
    oneof_schema_10_validator: Optional[EntityValue] = None
    # data type: object
    oneof_schema_11_validator: Optional[Dict[str, Any]] = Field(default=None, description="Since patternProperties and propertyNames are not supported by OpenApi yet, the ValueOnly serialization for this elements works with the key-attribute as the JSON-property name and the value-attribute as the corresponding value.")
    actual_instance: Optional[Union[AnnotatedRelationshipElementValue, BasicEventElementValue, BlobValue, EntityValue, FileValue, PropertyValue, RangeValue, ReferenceValue, RelationshipElementValue, object]] = None
    one_of_schemas: List[str] = Field(default=Literal["AnnotatedRelationshipElementValue", "BasicEventElementValue", "BlobValue", "EntityValue", "FileValue", "PropertyValue", "RangeValue", "ReferenceValue", "RelationshipElementValue", "object"])

    model_config = ConfigDict(
        validate_assignment=True,
        protected_namespaces=(),
    )


    def __init__(self, *args, **kwargs) -> None:
        if args:
            if len(args) > 1:
                raise ValueError("If a position argument is used, only 1 is allowed to set `actual_instance`")
            if kwargs:
                raise ValueError("If a position argument is used, keyword arguments cannot be used.")
            super().__init__(actual_instance=args[0])
        else:
            super().__init__(**kwargs)

    @field_validator('actual_instance')
    def actual_instance_must_validate_oneof(cls, v):
        instance = SubmodelElementValue.model_construct()
        error_messages = []
        match = 0
        # validate data type: BasicEventElementValue
        if not isinstance(v, BasicEventElementValue):
            error_messages.append(f"Error! Input type `{type(v)}` is not `BasicEventElementValue`")
        else:
            match += 1
        # validate data type: PropertyValue
        if not isinstance(v, PropertyValue):
            error_messages.append(f"Error! Input type `{type(v)}` is not `PropertyValue`")
        else:
            match += 1
        # validate data type: object
        try:
            instance.oneof_schema_3_validator = v
            match += 1
        except (ValidationError, ValueError) as e:
            error_messages.append(str(e))
        # validate data type: BlobValue
        if not isinstance(v, BlobValue):
            error_messages.append(f"Error! Input type `{type(v)}` is not `BlobValue`")
        else:
            match += 1
        # validate data type: FileValue
        if not isinstance(v, FileValue):
            error_messages.append(f"Error! Input type `{type(v)}` is not `FileValue`")
        else:
            match += 1
        # validate data type: RangeValue
        if not isinstance(v, RangeValue):
            error_messages.append(f"Error! Input type `{type(v)}` is not `RangeValue`")
        else:
            match += 1
        # validate data type: ReferenceValue
        if not isinstance(v, ReferenceValue):
            error_messages.append(f"Error! Input type `{type(v)}` is not `ReferenceValue`")
        else:
            match += 1
        # validate data type: RelationshipElementValue
        if not isinstance(v, RelationshipElementValue):
            error_messages.append(f"Error! Input type `{type(v)}` is not `RelationshipElementValue`")
        else:
            match += 1
        # validate data type: AnnotatedRelationshipElementValue
        if not isinstance(v, AnnotatedRelationshipElementValue):
            error_messages.append(f"Error! Input type `{type(v)}` is not `AnnotatedRelationshipElementValue`")
        else:
            match += 1
        # validate data type: EntityValue
        if not isinstance(v, EntityValue):
            error_messages.append(f"Error! Input type `{type(v)}` is not `EntityValue`")
        else:
            match += 1
        # validate data type: object
        try:
            instance.oneof_schema_11_validator = v
            match += 1
        except (ValidationError, ValueError) as e:
            error_messages.append(str(e))
        if match > 1:
            # more than 1 match
            raise ValueError("Multiple matches found when setting `actual_instance` in SubmodelElementValue with oneOf schemas: AnnotatedRelationshipElementValue, BasicEventElementValue, BlobValue, EntityValue, FileValue, PropertyValue, RangeValue, ReferenceValue, RelationshipElementValue, object. Details: " + ", ".join(error_messages))
        elif match == 0:
            # no match
            raise ValueError("No match found when setting `actual_instance` in SubmodelElementValue with oneOf schemas: AnnotatedRelationshipElementValue, BasicEventElementValue, BlobValue, EntityValue, FileValue, PropertyValue, RangeValue, ReferenceValue, RelationshipElementValue, object. Details: " + ", ".join(error_messages))
        else:
            return v

    @classmethod
    def from_dict(cls, obj: Union[str, Dict[str, Any]]) -> Self:
        return cls.from_json(json.dumps(obj))

    @classmethod
    def from_json(cls, json_str: str) -> Self:
        """Returns the object represented by the json string"""
        instance = cls.model_construct()
        error_messages = []
        match = 0

        # deserialize data into BasicEventElementValue
        try:
            instance.actual_instance = BasicEventElementValue.from_json(json_str)
            match += 1
        except (ValidationError, ValueError) as e:
            error_messages.append(str(e))
        # deserialize data into PropertyValue
        try:
            instance.actual_instance = PropertyValue.from_json(json_str)
            match += 1
        except (ValidationError, ValueError) as e:
            error_messages.append(str(e))
        # deserialize data into object
        try:
            # validation
            instance.oneof_schema_3_validator = json.loads(json_str)
            # assign value to actual_instance
            instance.actual_instance = instance.oneof_schema_3_validator
            match += 1
        except (ValidationError, ValueError) as e:
            error_messages.append(str(e))
        # deserialize data into BlobValue
        try:
            instance.actual_instance = BlobValue.from_json(json_str)
            match += 1
        except (ValidationError, ValueError) as e:
            error_messages.append(str(e))
        # deserialize data into FileValue
        try:
            instance.actual_instance = FileValue.from_json(json_str)
            match += 1
        except (ValidationError, ValueError) as e:
            error_messages.append(str(e))
        # deserialize data into RangeValue
        try:
            instance.actual_instance = RangeValue.from_json(json_str)
            match += 1
        except (ValidationError, ValueError) as e:
            error_messages.append(str(e))
        # deserialize data into ReferenceValue
        try:
            instance.actual_instance = ReferenceValue.from_json(json_str)
            match += 1
        except (ValidationError, ValueError) as e:
            error_messages.append(str(e))
        # deserialize data into RelationshipElementValue
        try:
            instance.actual_instance = RelationshipElementValue.from_json(json_str)
            match += 1
        except (ValidationError, ValueError) as e:
            error_messages.append(str(e))
        # deserialize data into AnnotatedRelationshipElementValue
        try:
            instance.actual_instance = AnnotatedRelationshipElementValue.from_json(json_str)
            match += 1
        except (ValidationError, ValueError) as e:
            error_messages.append(str(e))
        # deserialize data into EntityValue
        try:
            instance.actual_instance = EntityValue.from_json(json_str)
            match += 1
        except (ValidationError, ValueError) as e:
            error_messages.append(str(e))
        # deserialize data into object
        try:
            # validation
            instance.oneof_schema_11_validator = json.loads(json_str)
            # assign value to actual_instance
            instance.actual_instance = instance.oneof_schema_11_validator
            match += 1
        except (ValidationError, ValueError) as e:
            error_messages.append(str(e))

        if match > 1:
            # more than 1 match
            raise ValueError("Multiple matches found when deserializing the JSON string into SubmodelElementValue with oneOf schemas: AnnotatedRelationshipElementValue, BasicEventElementValue, BlobValue, EntityValue, FileValue, PropertyValue, RangeValue, ReferenceValue, RelationshipElementValue, object. Details: " + ", ".join(error_messages))
        elif match == 0:
            # no match
            raise ValueError("No match found when deserializing the JSON string into SubmodelElementValue with oneOf schemas: AnnotatedRelationshipElementValue, BasicEventElementValue, BlobValue, EntityValue, FileValue, PropertyValue, RangeValue, ReferenceValue, RelationshipElementValue, object. Details: " + ", ".join(error_messages))
        else:
            return instance

    def to_json(self) -> str:
        """Returns the JSON representation of the actual instance"""
        if self.actual_instance is None:
            return "null"

        if hasattr(self.actual_instance, "to_json") and callable(self.actual_instance.to_json):
            return self.actual_instance.to_json()
        else:
            return json.dumps(self.actual_instance)

    def to_dict(self) -> Optional[Union[Dict[str, Any], AnnotatedRelationshipElementValue, BasicEventElementValue, BlobValue, EntityValue, FileValue, PropertyValue, RangeValue, ReferenceValue, RelationshipElementValue, object]]:
        """Returns the dict representation of the actual instance"""
        if self.actual_instance is None:
            return None

        if hasattr(self.actual_instance, "to_dict") and callable(self.actual_instance.to_dict):
            return self.actual_instance.to_dict()
        else:
            # primitive type
            return self.actual_instance

    def to_str(self) -> str:
        """Returns the string representation of the actual instance"""
        return pprint.pformat(self.model_dump())


