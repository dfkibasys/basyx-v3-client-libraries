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
import { AnnotatedRelationshipElementValue } from '../../models/part2/AnnotatedRelationshipElementValue';
import { BasicEventElementValue } from '../../models/part2/BasicEventElementValue';
import { BlobValue } from '../../models/part2/BlobValue';
import { EntityType } from '../../models/part1/EntityType';
import { EntityValue } from '../../models/part2/EntityValue';
import { FileValue } from '../../models/part2/FileValue';
import { Key } from '../../models/part1/Key';
import { PropertyValue } from '../../models/part2/PropertyValue';
import { RangeValue } from '../../models/part2/RangeValue';
import { ReferenceTypes } from '../../models/part1/ReferenceTypes';
import { ReferenceValue } from '../../models/part2/ReferenceValue';
import { RelationshipElementValue } from '../../models/part2/RelationshipElementValue';
import { HttpFile } from '../../http/http';

export class SubmodelElementValue {
    'observed': ReferenceValue;
    'contentType': string;
    'value': string;
    'max': number;
    'min': number;
    'type'?: ReferenceTypes;
    'keys'?: Array<Key>;
    'first': ReferenceValue;
    'second': ReferenceValue;
    'annotations'?: Array<any>;
    'entityType': EntityType;
    'globalAssetId'?: string;
    'specificAssetIds'?: Array<any>;
    'statements': Array<any>;

    static readonly discriminator: string | undefined = undefined;

    static readonly attributeTypeMap: Array<{name: string, baseName: string, type: string, format: string}> = [
        {
            "name": "observed",
            "baseName": "observed",
            "type": "ReferenceValue",
            "format": ""
        },
        {
            "name": "contentType",
            "baseName": "contentType",
            "type": "string",
            "format": ""
        },
        {
            "name": "value",
            "baseName": "value",
            "type": "string",
            "format": ""
        },
        {
            "name": "max",
            "baseName": "max",
            "type": "number",
            "format": ""
        },
        {
            "name": "min",
            "baseName": "min",
            "type": "number",
            "format": ""
        },
        {
            "name": "type",
            "baseName": "type",
            "type": "ReferenceTypes",
            "format": ""
        },
        {
            "name": "keys",
            "baseName": "keys",
            "type": "Array<Key>",
            "format": ""
        },
        {
            "name": "first",
            "baseName": "first",
            "type": "ReferenceValue",
            "format": ""
        },
        {
            "name": "second",
            "baseName": "second",
            "type": "ReferenceValue",
            "format": ""
        },
        {
            "name": "annotations",
            "baseName": "annotations",
            "type": "Array<any>",
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
            "type": "Array<any>",
            "format": ""
        },
        {
            "name": "statements",
            "baseName": "statements",
            "type": "Array<any>",
            "format": ""
        }    ];

    static getAttributeTypeMap() {
        return SubmodelElementValue.attributeTypeMap;
    }

    public constructor() {
    }
}



