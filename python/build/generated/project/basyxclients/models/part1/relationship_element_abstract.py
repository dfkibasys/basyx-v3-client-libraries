# coding: utf-8

"""
    DotAAS Part 1 | Metamodel | Schemas

    The schemas implementing the [Specification of the Asset Administration Shell: Part 1](http://industrialdigitaltwin.org/en/content-hub).   Publisher: Industrial Digital Twin Association (IDTA) 2023

    The version of the OpenAPI document: V3.0.1
    Contact: info@idtwin.org
    Generated by OpenAPI Generator (https://openapi-generator.tech)

    Do not edit the class manually.
"""  # noqa: E501


from __future__ import annotations
import pprint
import re  # noqa: F401
import json

from pydantic import BaseModel, ConfigDict, Field, field_validator
from typing import Any, ClassVar, Dict, List, Optional
from typing_extensions import Annotated
from basyxclients.models.part1.embedded_data_specification import EmbeddedDataSpecification
from basyxclients.models.part1.extension import Extension
from basyxclients.models.part1.lang_string_name_type import LangStringNameType
from basyxclients.models.part1.lang_string_text_type import LangStringTextType
from basyxclients.models.part1.model_type import ModelType
from basyxclients.models.part1.qualifier import Qualifier
from basyxclients.models.part1.reference import Reference
from typing import Optional, Set
from typing_extensions import Self

class RelationshipElementAbstract(BaseModel):
    """
    RelationshipElementAbstract
    """ # noqa: E501
    extensions: Optional[Annotated[List[Extension], Field(min_length=1)]] = None
    category: Optional[Annotated[str, Field(min_length=1, strict=True, max_length=128)]] = None
    id_short: Optional[Annotated[str, Field(min_length=1, strict=True, max_length=128)]] = Field(default=None, alias="idShort")
    display_name: Optional[Annotated[List[LangStringNameType], Field(min_length=1)]] = Field(default=None, alias="displayName")
    description: Optional[Annotated[List[LangStringTextType], Field(min_length=1)]] = None
    model_type: ModelType = Field(alias="modelType")
    semantic_id: Optional[Reference] = Field(default=None, alias="semanticId")
    supplemental_semantic_ids: Optional[Annotated[List[Reference], Field(min_length=1)]] = Field(default=None, alias="supplementalSemanticIds")
    qualifiers: Optional[Annotated[List[Qualifier], Field(min_length=1)]] = None
    embedded_data_specifications: Optional[Annotated[List[EmbeddedDataSpecification], Field(min_length=1)]] = Field(default=None, alias="embeddedDataSpecifications")
    first: Reference
    second: Reference
    __properties: ClassVar[List[str]] = ["extensions", "category", "idShort", "displayName", "description", "modelType", "semanticId", "supplementalSemanticIds", "qualifiers", "embeddedDataSpecifications", "first", "second"]

    @field_validator('id_short')
    def id_short_validate_regular_expression(cls, value):
        """Validates the regular expression"""
        if value is None:
            return value

        if not re.match(r"^[a-zA-Z][a-zA-Z0-9_]*$", value):
            raise ValueError(r"must validate the regular expression /^[a-zA-Z][a-zA-Z0-9_]*$/")
        return value

    model_config = ConfigDict(
        populate_by_name=True,
        validate_assignment=True,
        protected_namespaces=(),
    )


    def to_str(self) -> str:
        """Returns the string representation of the model using alias"""
        return pprint.pformat(self.model_dump(by_alias=True))

    def to_json(self) -> str:
        """Returns the JSON representation of the model using alias"""
        # TODO: pydantic v2: use .model_dump_json(by_alias=True, exclude_unset=True) instead
        return json.dumps(self.to_dict())

    @classmethod
    def from_json(cls, json_str: str) -> Optional[Self]:
        """Create an instance of RelationshipElementAbstract from a JSON string"""
        return cls.from_dict(json.loads(json_str))

    def to_dict(self) -> Dict[str, Any]:
        """Return the dictionary representation of the model using alias.

        This has the following differences from calling pydantic's
        `self.model_dump(by_alias=True)`:

        * `None` is only added to the output dict for nullable fields that
          were set at model initialization. Other fields with value `None`
          are ignored.
        """
        excluded_fields: Set[str] = set([
        ])

        _dict = self.model_dump(
            by_alias=True,
            exclude=excluded_fields,
            exclude_none=True,
        )
        # override the default output from pydantic by calling `to_dict()` of each item in extensions (list)
        _items = []
        if self.extensions:
            for _item in self.extensions:
                if _item:
                    _items.append(_item.to_dict())
            _dict['extensions'] = _items
        # override the default output from pydantic by calling `to_dict()` of each item in display_name (list)
        _items = []
        if self.display_name:
            for _item in self.display_name:
                if _item:
                    _items.append(_item.to_dict())
            _dict['displayName'] = _items
        # override the default output from pydantic by calling `to_dict()` of each item in description (list)
        _items = []
        if self.description:
            for _item in self.description:
                if _item:
                    _items.append(_item.to_dict())
            _dict['description'] = _items
        # override the default output from pydantic by calling `to_dict()` of semantic_id
        if self.semantic_id:
            _dict['semanticId'] = self.semantic_id.to_dict()
        # override the default output from pydantic by calling `to_dict()` of each item in supplemental_semantic_ids (list)
        _items = []
        if self.supplemental_semantic_ids:
            for _item in self.supplemental_semantic_ids:
                if _item:
                    _items.append(_item.to_dict())
            _dict['supplementalSemanticIds'] = _items
        # override the default output from pydantic by calling `to_dict()` of each item in qualifiers (list)
        _items = []
        if self.qualifiers:
            for _item in self.qualifiers:
                if _item:
                    _items.append(_item.to_dict())
            _dict['qualifiers'] = _items
        # override the default output from pydantic by calling `to_dict()` of each item in embedded_data_specifications (list)
        _items = []
        if self.embedded_data_specifications:
            for _item in self.embedded_data_specifications:
                if _item:
                    _items.append(_item.to_dict())
            _dict['embeddedDataSpecifications'] = _items
        # override the default output from pydantic by calling `to_dict()` of first
        if self.first:
            _dict['first'] = self.first.to_dict()
        # override the default output from pydantic by calling `to_dict()` of second
        if self.second:
            _dict['second'] = self.second.to_dict()
        return _dict

    @classmethod
    def from_dict(cls, obj: Optional[Dict[str, Any]]) -> Optional[Self]:
        """Create an instance of RelationshipElementAbstract from a dict"""
        if obj is None:
            return None

        if not isinstance(obj, dict):
            return cls.model_validate(obj)

        _obj = cls.model_validate({
            "extensions": [Extension.from_dict(_item) for _item in obj["extensions"]] if obj.get("extensions") is not None else None,
            "category": obj.get("category"),
            "idShort": obj.get("idShort"),
            "displayName": [LangStringNameType.from_dict(_item) for _item in obj["displayName"]] if obj.get("displayName") is not None else None,
            "description": [LangStringTextType.from_dict(_item) for _item in obj["description"]] if obj.get("description") is not None else None,
            "modelType": obj.get("modelType"),
            "semanticId": Reference.from_dict(obj["semanticId"]) if obj.get("semanticId") is not None else None,
            "supplementalSemanticIds": [Reference.from_dict(_item) for _item in obj["supplementalSemanticIds"]] if obj.get("supplementalSemanticIds") is not None else None,
            "qualifiers": [Qualifier.from_dict(_item) for _item in obj["qualifiers"]] if obj.get("qualifiers") is not None else None,
            "embeddedDataSpecifications": [EmbeddedDataSpecification.from_dict(_item) for _item in obj["embeddedDataSpecifications"]] if obj.get("embeddedDataSpecifications") is not None else None,
            "first": Reference.from_dict(obj["first"]) if obj.get("first") is not None else None,
            "second": Reference.from_dict(obj["second"]) if obj.get("second") is not None else None
        })
        return _obj


