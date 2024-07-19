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

from pydantic import BaseModel, ConfigDict, Field
from typing import Any, ClassVar, Dict, List, Optional
from typing_extensions import Annotated
from basyxclients.models.part1.embedded_data_specification import EmbeddedDataSpecification
from typing import Optional, Set
from typing_extensions import Self

class HasDataSpecification(BaseModel):
    """
    HasDataSpecification
    """ # noqa: E501
    embedded_data_specifications: Optional[Annotated[List[EmbeddedDataSpecification], Field(min_length=1)]] = Field(default=None, alias="embeddedDataSpecifications")
    __properties: ClassVar[List[str]] = ["embeddedDataSpecifications"]

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
        """Create an instance of HasDataSpecification from a JSON string"""
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
        # override the default output from pydantic by calling `to_dict()` of each item in embedded_data_specifications (list)
        _items = []
        if self.embedded_data_specifications:
            for _item in self.embedded_data_specifications:
                if _item:
                    _items.append(_item.to_dict())
            _dict['embeddedDataSpecifications'] = _items
        return _dict

    @classmethod
    def from_dict(cls, obj: Optional[Dict[str, Any]]) -> Optional[Self]:
        """Create an instance of HasDataSpecification from a dict"""
        if obj is None:
            return None

        if not isinstance(obj, dict):
            return cls.model_validate(obj)

        _obj = cls.model_validate({
            "embeddedDataSpecifications": [EmbeddedDataSpecification.from_dict(_item) for _item in obj["embeddedDataSpecifications"]] if obj.get("embeddedDataSpecifications") is not None else None
        })
        return _obj


