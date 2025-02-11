/*******************************************************************************
 * Copyright (C) 2024 DFKI GmbH (https://www.dfki.de/en/web)
 * 
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 * 
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 * 
 * SPDX-License-Identifier: MIT
 ******************************************************************************/
import { AasSubmodelElements } from '../../models/part1/AasSubmodelElements';
import { AnnotatedRelationshipElement } from '../../models/part1/AnnotatedRelationshipElement';
import { BasicEventElement } from '../../models/part1/BasicEventElement';
import { Blob } from '../../models/part1/Blob';
import { Capability } from '../../models/part1/Capability';
import { DataElementChoice } from '../../models/part1/DataElementChoice';
import { DataTypeDefXsd } from '../../models/part1/DataTypeDefXsd';
import { Direction } from '../../models/part1/Direction';
import { EmbeddedDataSpecification } from '../../models/part1/EmbeddedDataSpecification';
import { Entity } from '../../models/part1/Entity';
import { EntityType } from '../../models/part1/EntityType';
import { Extension } from '../../models/part1/Extension';
import { LangStringNameType } from '../../models/part1/LangStringNameType';
import { LangStringTextType } from '../../models/part1/LangStringTextType';
import { ModelFile } from '../../models/part1/ModelFile';
import { MultiLanguageProperty } from '../../models/part1/MultiLanguageProperty';
import { Operation } from '../../models/part1/Operation';
import { OperationVariable } from '../../models/part1/OperationVariable';
import { Property } from '../../models/part1/Property';
import { Qualifier } from '../../models/part1/Qualifier';
import { Range } from '../../models/part1/Range';
import { Reference } from '../../models/part1/Reference';
import { ReferenceElement } from '../../models/part1/ReferenceElement';
import { RelationshipElement } from '../../models/part1/RelationshipElement';
import { SpecificAssetId } from '../../models/part1/SpecificAssetId';
import { StateOfEvent } from '../../models/part1/StateOfEvent';
import { SubmodelElementCollection } from '../../models/part1/SubmodelElementCollection';
import { SubmodelElementList } from '../../models/part1/SubmodelElementList';
import { HttpFile } from '../../http/http';

export class SubmodelElementChoice {
    'extensions'?: Array<Extension>;
    'category'?: string;
    'idShort'?: string;
    'displayName'?: Array<LangStringNameType>;
    'description'?: Array<LangStringTextType>;
    'modelType': string;
    'semanticId'?: Reference;
    'supplementalSemanticIds'?: Array<Reference>;
    'qualifiers'?: Array<Qualifier>;
    'embeddedDataSpecifications'?: Array<EmbeddedDataSpecification>;
    'first': Reference;
    'second': Reference;
    'annotations'?: Array<DataElementChoice>;
    'observed': Reference;
    'direction': Direction;
    'state': StateOfEvent;
    'messageTopic'?: string;
    'messageBroker'?: Reference;
    'lastUpdate'?: string;
    'minInterval'?: string;
    'maxInterval'?: string;
    'value'?: Array<SubmodelElementChoice>;
    'contentType': string;
    'statements'?: Array<SubmodelElementChoice>;
    'entityType': EntityType;
    'globalAssetId'?: string;
    'specificAssetIds'?: Array<SpecificAssetId>;
    'valueId'?: Reference;
    'inputVariables'?: Array<OperationVariable>;
    'outputVariables'?: Array<OperationVariable>;
    'inoutputVariables'?: Array<OperationVariable>;
    'valueType': DataTypeDefXsd;
    'min'?: string;
    'max'?: string;
    'orderRelevant'?: boolean;
    'semanticIdListElement'?: Reference;
    'typeValueListElement': AasSubmodelElements;
    'valueTypeListElement'?: DataTypeDefXsd;

    static readonly discriminator: string | undefined = "modelType";

    static readonly attributeTypeMap: Array<{name: string, baseName: string, type: string, format: string}> = [
        {
            "name": "extensions",
            "baseName": "extensions",
            "type": "Array<Extension>",
            "format": ""
        },
        {
            "name": "category",
            "baseName": "category",
            "type": "string",
            "format": ""
        },
        {
            "name": "idShort",
            "baseName": "idShort",
            "type": "string",
            "format": ""
        },
        {
            "name": "displayName",
            "baseName": "displayName",
            "type": "Array<LangStringNameType>",
            "format": ""
        },
        {
            "name": "description",
            "baseName": "description",
            "type": "Array<LangStringTextType>",
            "format": ""
        },
        {
            "name": "modelType",
            "baseName": "modelType",
            "type": "string",
            "format": ""
        },
        {
            "name": "semanticId",
            "baseName": "semanticId",
            "type": "Reference",
            "format": ""
        },
        {
            "name": "supplementalSemanticIds",
            "baseName": "supplementalSemanticIds",
            "type": "Array<Reference>",
            "format": ""
        },
        {
            "name": "qualifiers",
            "baseName": "qualifiers",
            "type": "Array<Qualifier>",
            "format": ""
        },
        {
            "name": "embeddedDataSpecifications",
            "baseName": "embeddedDataSpecifications",
            "type": "Array<EmbeddedDataSpecification>",
            "format": ""
        },
        {
            "name": "first",
            "baseName": "first",
            "type": "Reference",
            "format": ""
        },
        {
            "name": "second",
            "baseName": "second",
            "type": "Reference",
            "format": ""
        },
        {
            "name": "annotations",
            "baseName": "annotations",
            "type": "Array<DataElementChoice>",
            "format": ""
        },
        {
            "name": "observed",
            "baseName": "observed",
            "type": "Reference",
            "format": ""
        },
        {
            "name": "direction",
            "baseName": "direction",
            "type": "Direction",
            "format": ""
        },
        {
            "name": "state",
            "baseName": "state",
            "type": "StateOfEvent",
            "format": ""
        },
        {
            "name": "messageTopic",
            "baseName": "messageTopic",
            "type": "string",
            "format": ""
        },
        {
            "name": "messageBroker",
            "baseName": "messageBroker",
            "type": "Reference",
            "format": ""
        },
        {
            "name": "lastUpdate",
            "baseName": "lastUpdate",
            "type": "string",
            "format": ""
        },
        {
            "name": "minInterval",
            "baseName": "minInterval",
            "type": "string",
            "format": ""
        },
        {
            "name": "maxInterval",
            "baseName": "maxInterval",
            "type": "string",
            "format": ""
        },
        {
            "name": "value",
            "baseName": "value",
            "type": "Array<SubmodelElementChoice>",
            "format": ""
        },
        {
            "name": "contentType",
            "baseName": "contentType",
            "type": "string",
            "format": ""
        },
        {
            "name": "statements",
            "baseName": "statements",
            "type": "Array<SubmodelElementChoice>",
            "format": ""
        },
        {
            "name": "entityType",
            "baseName": "entityType",
            "type": "EntityType",
            "format": ""
        },
        {
            "name": "globalAssetId",
            "baseName": "globalAssetId",
            "type": "string",
            "format": ""
        },
        {
            "name": "specificAssetIds",
            "baseName": "specificAssetIds",
            "type": "Array<SpecificAssetId>",
            "format": ""
        },
        {
            "name": "valueId",
            "baseName": "valueId",
            "type": "Reference",
            "format": ""
        },
        {
            "name": "inputVariables",
            "baseName": "inputVariables",
            "type": "Array<OperationVariable>",
            "format": ""
        },
        {
            "name": "outputVariables",
            "baseName": "outputVariables",
            "type": "Array<OperationVariable>",
            "format": ""
        },
        {
            "name": "inoutputVariables",
            "baseName": "inoutputVariables",
            "type": "Array<OperationVariable>",
            "format": ""
        },
        {
            "name": "valueType",
            "baseName": "valueType",
            "type": "DataTypeDefXsd",
            "format": ""
        },
        {
            "name": "min",
            "baseName": "min",
            "type": "string",
            "format": ""
        },
        {
            "name": "max",
            "baseName": "max",
            "type": "string",
            "format": ""
        },
        {
            "name": "orderRelevant",
            "baseName": "orderRelevant",
            "type": "boolean",
            "format": ""
        },
        {
            "name": "semanticIdListElement",
            "baseName": "semanticIdListElement",
            "type": "Reference",
            "format": ""
        },
        {
            "name": "typeValueListElement",
            "baseName": "typeValueListElement",
            "type": "AasSubmodelElements",
            "format": ""
        },
        {
            "name": "valueTypeListElement",
            "baseName": "valueTypeListElement",
            "type": "DataTypeDefXsd",
            "format": ""
        }    ];

    static getAttributeTypeMap() {
        return SubmodelElementChoice.attributeTypeMap;
    }

    public constructor() {
        this.modelType = "SubmodelElementChoice";
    }
}



