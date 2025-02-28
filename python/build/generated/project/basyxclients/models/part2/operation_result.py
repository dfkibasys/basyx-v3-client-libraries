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

from pydantic import BaseModel, ConfigDict, Field, StrictBool
from typing import Any, ClassVar, Dict, List, Optional
from basyxclients.models.part2.execution_state import ExecutionState
from basyxclients.models.part2.message import Message
from basyxclients.models.part1.operation_variable import OperationVariable
from typing import Optional, Set
from typing_extensions import Self

class OperationResult(BaseModel):
    """
    OperationResult
    """ # noqa: E501
    messages: Optional[List[Message]] = None
    execution_state: Optional[ExecutionState] = Field(default=None, alias="executionState")
    success: Optional[StrictBool] = None
    inoutput_arguments: Optional[List[OperationVariable]] = Field(default=None, alias="inoutputArguments")
    output_arguments: Optional[List[OperationVariable]] = Field(default=None, alias="outputArguments")
    __properties: ClassVar[List[str]] = ["messages", "executionState", "success", "inoutputArguments", "outputArguments"]

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
        """Create an instance of OperationResult from a JSON string"""
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
        # override the default output from pydantic by calling `to_dict()` of each item in messages (list)
        _items = []
        if self.messages:
            for _item in self.messages:
                if _item:
                    _items.append(_item.to_dict())
            _dict['messages'] = _items
        # override the default output from pydantic by calling `to_dict()` of each item in inoutput_arguments (list)
        _items = []
        if self.inoutput_arguments:
            for _item in self.inoutput_arguments:
                if _item:
                    _items.append(_item.to_dict())
            _dict['inoutputArguments'] = _items
        # override the default output from pydantic by calling `to_dict()` of each item in output_arguments (list)
        _items = []
        if self.output_arguments:
            for _item in self.output_arguments:
                if _item:
                    _items.append(_item.to_dict())
            _dict['outputArguments'] = _items
        return _dict

    @classmethod
    def from_dict(cls, obj: Optional[Dict[str, Any]]) -> Optional[Self]:
        """Create an instance of OperationResult from a dict"""
        if obj is None:
            return None

        if not isinstance(obj, dict):
            return cls.model_validate(obj)

        _obj = cls.model_validate({
            "messages": [Message.from_dict(_item) for _item in obj["messages"]] if obj.get("messages") is not None else None,
            "executionState": obj.get("executionState"),
            "success": obj.get("success"),
            "inoutputArguments": [OperationVariable.from_dict(_item) for _item in obj["inoutputArguments"]] if obj.get("inoutputArguments") is not None else None,
            "outputArguments": [OperationVariable.from_dict(_item) for _item in obj["outputArguments"]] if obj.get("outputArguments") is not None else None
        })
        return _obj


