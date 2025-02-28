# coding: utf-8

"""
    DotAAS Part 2 | HTTP/REST | Asset Administration Shell Registry Service Specification

    The Full Profile of the Asset Administration Shell Registry Service Specification as part of the [Specification of the Asset Administration Shell: Part 2](http://industrialdigitaltwin.org/en/content-hub).   Publisher: Industrial Digital Twin Association (IDTA) 2023

    The version of the OpenAPI document: V3.0.1_SSP-001
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
from basyxclients.models.search.page import Page
from basyxclients.models.search.shell_descriptor_query import ShellDescriptorQuery
from basyxclients.models.search.sorting import Sorting
from typing import Optional, Set
from typing_extensions import Self

class ShellDescriptorSearchRequest(BaseModel):
    """
    ShellDescriptorSearchRequest
    """ # noqa: E501
    page: Optional[Page] = None
    sort_by: Optional[Sorting] = Field(default=None, alias="sortBy")
    query: Optional[ShellDescriptorQuery] = None
    __properties: ClassVar[List[str]] = ["page", "sortBy", "query"]

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
        """Create an instance of ShellDescriptorSearchRequest from a JSON string"""
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
        # override the default output from pydantic by calling `to_dict()` of page
        if self.page:
            _dict['page'] = self.page.to_dict()
        # override the default output from pydantic by calling `to_dict()` of sort_by
        if self.sort_by:
            _dict['sortBy'] = self.sort_by.to_dict()
        # override the default output from pydantic by calling `to_dict()` of query
        if self.query:
            _dict['query'] = self.query.to_dict()
        return _dict

    @classmethod
    def from_dict(cls, obj: Optional[Dict[str, Any]]) -> Optional[Self]:
        """Create an instance of ShellDescriptorSearchRequest from a dict"""
        if obj is None:
            return None

        if not isinstance(obj, dict):
            return cls.model_validate(obj)

        _obj = cls.model_validate({
            "page": Page.from_dict(obj["page"]) if obj.get("page") is not None else None,
            "sortBy": Sorting.from_dict(obj["sortBy"]) if obj.get("sortBy") is not None else None,
            "query": ShellDescriptorQuery.from_dict(obj["query"]) if obj.get("query") is not None else None
        })
        return _obj


