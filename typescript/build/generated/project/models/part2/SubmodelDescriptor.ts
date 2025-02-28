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
import { Endpoint } from '../../models/part2/Endpoint';
import { Extension } from '../../models/part1/Extension';
import { LangStringNameType } from '../../models/part1/LangStringNameType';
import { LangStringTextType } from '../../models/part1/LangStringTextType';
import { Reference } from '../../models/part1/Reference';
import { HttpFile } from '../../http/http';

export class SubmodelDescriptor {
    'description'?: Array<LangStringTextType>;
    'displayName'?: Array<LangStringNameType>;
    'extensions'?: Array<Extension>;
    'administration'?: AdministrativeInformation;
    'idShort'?: string;
    'id': string;
    'semanticId'?: Reference;
    'supplementalSemanticId'?: Array<Reference>;
    'endpoints': Array<Endpoint>;

    static readonly discriminator: string | undefined = undefined;

    static readonly attributeTypeMap: Array<{name: string, baseName: string, type: string, format: string}> = [
        {
            "name": "description",
            "baseName": "description",
            "type": "Array<LangStringTextType>",
            "format": ""
        },
        {
            "name": "displayName",
            "baseName": "displayName",
            "type": "Array<LangStringNameType>",
            "format": ""
        },
        {
            "name": "extensions",
            "baseName": "extensions",
            "type": "Array<Extension>",
            "format": ""
        },
        {
            "name": "administration",
            "baseName": "administration",
            "type": "AdministrativeInformation",
            "format": ""
        },
        {
            "name": "idShort",
            "baseName": "idShort",
            "type": "string",
            "format": ""
        },
        {
            "name": "id",
            "baseName": "id",
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
            "name": "supplementalSemanticId",
            "baseName": "supplementalSemanticId",
            "type": "Array<Reference>",
            "format": ""
        },
        {
            "name": "endpoints",
            "baseName": "endpoints",
            "type": "Array<Endpoint>",
            "format": ""
        }    ];

    static getAttributeTypeMap() {
        return SubmodelDescriptor.attributeTypeMap;
    }

    public constructor() {
    }
}

