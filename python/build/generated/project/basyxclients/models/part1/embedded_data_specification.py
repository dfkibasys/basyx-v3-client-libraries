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
from typing import Any, ClassVar, Dict, List
from basyxclients.models.part1.data_specification_content import DataSpecificationContent
from basyxclients.models.part1.reference import Reference
from typing import Optional, Set
from typing_extensions import Self

class EmbeddedDataSpecification(BaseModel):
    """
    EmbeddedDataSpecification
    """ # noqa: E501
    data_specification: Reference = Field(alias="dataSpecification")
    data_specification_content: DataSpecificationContent = Field(alias="dataSpecificationContent")
    __properties: ClassVar[List[str]] = ["dataSpecification", "dataSpecificationContent"]

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
        """Create an instance of EmbeddedDataSpecification from a JSON string"""
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
        # override the default output from pydantic by calling `to_dict()` of data_specification
        if self.data_specification:
            _dict['dataSpecification'] = self.data_specification.to_dict()
        # override the default output from pydantic by calling `to_dict()` of data_specification_content
        if self.data_specification_content:
            _dict['dataSpecificationContent'] = self.data_specification_content.to_dict()
        return _dict

    @classmethod
    def from_dict(cls, obj: Optional[Dict[str, Any]]) -> Optional[Self]:
        """Create an instance of EmbeddedDataSpecification from a dict"""
        if obj is None:
            return None

        if not isinstance(obj, dict):
            return cls.model_validate(obj)

        _obj = cls.model_validate({
            "dataSpecification": Reference.from_dict(obj["dataSpecification"]) if obj.get("dataSpecification") is not None else None,
            "dataSpecificationContent": DataSpecificationContent.from_dict(obj["dataSpecificationContent"]) if obj.get("dataSpecificationContent") is not None else None
        })
        return _obj


