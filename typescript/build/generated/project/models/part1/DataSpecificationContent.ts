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
import { DataSpecificationIec61360 } from '../../models/part1/DataSpecificationIec61360';
import { DataTypeIec61360 } from '../../models/part1/DataTypeIec61360';
import { LangStringDefinitionTypeIec61360 } from '../../models/part1/LangStringDefinitionTypeIec61360';
import { LangStringPreferredNameTypeIec61360 } from '../../models/part1/LangStringPreferredNameTypeIec61360';
import { LangStringShortNameTypeIec61360 } from '../../models/part1/LangStringShortNameTypeIec61360';
import { LevelType } from '../../models/part1/LevelType';
import { Reference } from '../../models/part1/Reference';
import { ValueList } from '../../models/part1/ValueList';
import { HttpFile } from '../../http/http';

export class DataSpecificationContent {
    'preferredName': Array<LangStringPreferredNameTypeIec61360>;
    'shortName'?: Array<LangStringShortNameTypeIec61360>;
    'unit'?: string;
    'unitId'?: Reference;
    'sourceOfDefinition'?: string;
    'symbol'?: string;
    'dataType'?: DataTypeIec61360;
    'definition'?: Array<LangStringDefinitionTypeIec61360>;
    'valueFormat'?: string;
    'valueList'?: ValueList;
    'value'?: string;
    'levelType'?: LevelType;
    'modelType': string;

    static readonly discriminator: string | undefined = "modelType";

    static readonly attributeTypeMap: Array<{name: string, baseName: string, type: string, format: string}> = [
        {
            "name": "preferredName",
            "baseName": "preferredName",
            "type": "Array<LangStringPreferredNameTypeIec61360>",
            "format": ""
        },
        {
            "name": "shortName",
            "baseName": "shortName",
            "type": "Array<LangStringShortNameTypeIec61360>",
            "format": ""
        },
        {
            "name": "unit",
            "baseName": "unit",
            "type": "string",
            "format": ""
        },
        {
            "name": "unitId",
            "baseName": "unitId",
            "type": "Reference",
            "format": ""
        },
        {
            "name": "sourceOfDefinition",
            "baseName": "sourceOfDefinition",
            "type": "string",
            "format": ""
        },
        {
            "name": "symbol",
            "baseName": "symbol",
            "type": "string",
            "format": ""
        },
        {
            "name": "dataType",
            "baseName": "dataType",
            "type": "DataTypeIec61360",
            "format": ""
        },
        {
            "name": "definition",
            "baseName": "definition",
            "type": "Array<LangStringDefinitionTypeIec61360>",
            "format": ""
        },
        {
            "name": "valueFormat",
            "baseName": "valueFormat",
            "type": "string",
            "format": ""
        },
        {
            "name": "valueList",
            "baseName": "valueList",
            "type": "ValueList",
            "format": ""
        },
        {
            "name": "value",
            "baseName": "value",
            "type": "string",
            "format": ""
        },
        {
            "name": "levelType",
            "baseName": "levelType",
            "type": "LevelType",
            "format": ""
        },
        {
            "name": "modelType",
            "baseName": "modelType",
            "type": "string",
            "format": ""
        }    ];

    static getAttributeTypeMap() {
        return DataSpecificationContent.attributeTypeMap;
    }

    public constructor() {
        this.modelType = "DataSpecificationContent";
    }
}



