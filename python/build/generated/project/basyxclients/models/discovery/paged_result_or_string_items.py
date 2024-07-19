# coding: utf-8

"""
    DotAAS Part 2 | HTTP/REST | Discovery Service Specification

    The entire Full Profile of the Discovery Service Specification as part of the [Specification of the Asset Administration Shell: Part 2](http://industrialdigitaltwin.org/en/content-hub).   Publisher: Industrial Digital Twin Association (IDTA) April 2023

    The version of the OpenAPI document: V3.0.1_SSP-001
    Contact: info@idtwin.org
    Generated by OpenAPI Generator (https://openapi-generator.tech)

    Do not edit the class manually.
"""  # noqa: E501


from __future__ import annotations
import pprint
import re  # noqa: F401
import json

from pydantic import BaseModel, ConfigDict, StrictStr
from typing import Any, ClassVar, Dict, List, Optional
from basyxclients.models.part2.paged_result_paging_metadata import PagedResultPagingMetadata
from typing import Optional, Set
from typing_extensions import Self

class PagedResultOrStringItems(BaseModel):
    """
    PagedResultOrStringItems
    """ # noqa: E501
    paging_metadata: Optional[PagedResultPagingMetadata] = None
    result: Optional[List[StrictStr]] = None
    __properties: ClassVar[List[str]] = ["paging_metadata", "result"]

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
        """Create an instance of PagedResultOrStringItems from a JSON string"""
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
        # override the default output from pydantic by calling `to_dict()` of paging_metadata
        if self.paging_metadata:
            _dict['paging_metadata'] = self.paging_metadata.to_dict()
        return _dict

    @classmethod
    def from_dict(cls, obj: Optional[Dict[str, Any]]) -> Optional[Self]:
        """Create an instance of PagedResultOrStringItems from a dict"""
        if obj is None:
            return None

        if not isinstance(obj, dict):
            return cls.model_validate(obj)

        _obj = cls.model_validate({
            "paging_metadata": PagedResultPagingMetadata.from_dict(obj["paging_metadata"]) if obj.get("paging_metadata") is not None else None,
            "result": obj.get("result")
        })
        return _obj


