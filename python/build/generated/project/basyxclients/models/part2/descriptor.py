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
import pprint
import re  # noqa: F401
import json

from pydantic import BaseModel, ConfigDict, Field
from typing import Any, ClassVar, Dict, List, Optional
from typing_extensions import Annotated
from typing import Optional, Set
from typing_extensions import Self

class Descriptor(BaseModel):
    """
    Descriptor
    """ # noqa: E501
    description: Optional[List[LangStringTextType]] = None
    display_name: Optional[List[LangStringNameType]] = Field(default=None, alias="displayName")
    extensions: Optional[Annotated[List[Extension], Field(min_length=1)]] = None
    __properties: ClassVar[List[str]] = ["description", "displayName", "extensions"]

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
        """Create an instance of Descriptor from a JSON string"""
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
        # override the default output from pydantic by calling `to_dict()` of each item in description (list)
        _items = []
        if self.description:
            for _item in self.description:
                if _item:
                    _items.append(_item.to_dict())
            _dict['description'] = _items
        # override the default output from pydantic by calling `to_dict()` of each item in display_name (list)
        _items = []
        if self.display_name:
            for _item in self.display_name:
                if _item:
                    _items.append(_item.to_dict())
            _dict['displayName'] = _items
        # override the default output from pydantic by calling `to_dict()` of each item in extensions (list)
        _items = []
        if self.extensions:
            for _item in self.extensions:
                if _item:
                    _items.append(_item.to_dict())
            _dict['extensions'] = _items
        return _dict

    @classmethod
    def from_dict(cls, obj: Optional[Dict[str, Any]]) -> Optional[Self]:
        """Create an instance of Descriptor from a dict"""
        if obj is None:
            return None

        if not isinstance(obj, dict):
            return cls.model_validate(obj)

        _obj = cls.model_validate({
            "description": [LangStringTextType.from_dict(_item) for _item in obj["description"]] if obj.get("description") is not None else None,
            "displayName": [LangStringNameType.from_dict(_item) for _item in obj["displayName"]] if obj.get("displayName") is not None else None,
            "extensions": [Extension.from_dict(_item) for _item in obj["extensions"]] if obj.get("extensions") is not None else None
        })
        return _obj


