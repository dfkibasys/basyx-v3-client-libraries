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
from typing import Optional, Set
from typing_extensions import Self

class Environment(BaseModel):
    """
    Environment
    """ # noqa: E501
    asset_administration_shells: Optional[Annotated[List[AssetAdministrationShell], Field(min_length=1)]] = Field(default=None, alias="assetAdministrationShells")
    submodels: Optional[Annotated[List[Submodel], Field(min_length=1)]] = None
    concept_descriptions: Optional[Annotated[List[ConceptDescription], Field(min_length=1)]] = Field(default=None, alias="conceptDescriptions")
    __properties: ClassVar[List[str]] = ["assetAdministrationShells", "submodels", "conceptDescriptions"]

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
        """Create an instance of Environment from a JSON string"""
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
        # override the default output from pydantic by calling `to_dict()` of each item in asset_administration_shells (list)
        _items = []
        if self.asset_administration_shells:
            for _item_asset_administration_shells in self.asset_administration_shells:
                if _item_asset_administration_shells:
                    _items.append(_item_asset_administration_shells.to_dict())
            _dict['assetAdministrationShells'] = _items
        # override the default output from pydantic by calling `to_dict()` of each item in submodels (list)
        _items = []
        if self.submodels:
            for _item_submodels in self.submodels:
                if _item_submodels:
                    _items.append(_item_submodels.to_dict())
            _dict['submodels'] = _items
        # override the default output from pydantic by calling `to_dict()` of each item in concept_descriptions (list)
        _items = []
        if self.concept_descriptions:
            for _item_concept_descriptions in self.concept_descriptions:
                if _item_concept_descriptions:
                    _items.append(_item_concept_descriptions.to_dict())
            _dict['conceptDescriptions'] = _items
        return _dict

    @classmethod
    def from_dict(cls, obj: Optional[Dict[str, Any]]) -> Optional[Self]:
        """Create an instance of Environment from a dict"""
        if obj is None:
            return None

        if not isinstance(obj, dict):
            return cls.model_validate(obj)

        _obj = cls.model_validate({
            "assetAdministrationShells": [AssetAdministrationShell.from_dict(_item) for _item in obj["assetAdministrationShells"]] if obj.get("assetAdministrationShells") is not None else None,
            "submodels": [Submodel.from_dict(_item) for _item in obj["submodels"]] if obj.get("submodels") is not None else None,
            "conceptDescriptions": [ConceptDescription.from_dict(_item) for _item in obj["conceptDescriptions"]] if obj.get("conceptDescriptions") is not None else None
        })
        return _obj

from basyxclients.models.part1.asset_administration_shell import AssetAdministrationShell
from basyxclients.models.part1.concept_description import ConceptDescription
from basyxclients.models.part1.submodel import Submodel
# TODO: Rewrite to not use raise_errors
Environment.model_rebuild(raise_errors=False)

