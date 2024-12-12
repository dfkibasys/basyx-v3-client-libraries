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
import { AdministrativeInformation } from '../../models/part1/AdministrativeInformation';
import { Extension } from '../../models/part1/Extension';
import { LangStringNameType } from '../../models/part1/LangStringNameType';
import { LangStringTextType } from '../../models/part1/LangStringTextType';
import { ModelType } from '../../models/part1/ModelType';
import { HttpFile } from '../../http/http';

export class Identifiable {
    'extensions'?: Array<Extension>;
    'category'?: string;
    'idShort'?: string;
    'displayName'?: Array<LangStringNameType>;
    'description'?: Array<LangStringTextType>;
    'modelType': ModelType;
    'administration'?: AdministrativeInformation;
    'id': string;

    static readonly discriminator: string | undefined = undefined;

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
            "type": "ModelType",
            "format": ""
        },
        {
            "name": "administration",
            "baseName": "administration",
            "type": "AdministrativeInformation",
            "format": ""
        },
        {
            "name": "id",
            "baseName": "id",
            "type": "string",
            "format": ""
        }    ];

    static getAttributeTypeMap() {
        return Identifiable.attributeTypeMap;
    }

    public constructor() {
    }
}



