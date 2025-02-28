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
import { AssetKind } from '../../models/part1/AssetKind';
import { Endpoint } from '../../models/part2/Endpoint';
import { Extension } from '../../models/part1/Extension';
import { LangStringNameType } from '../../models/part1/LangStringNameType';
import { LangStringTextType } from '../../models/part1/LangStringTextType';
import { SpecificAssetId } from '../../models/part1/SpecificAssetId';
import { SubmodelDescriptor } from '../../models/part2/SubmodelDescriptor';
import { HttpFile } from '../../http/http';

export class AssetAdministrationShellDescriptor {
    'description'?: Array<LangStringTextType>;
    'displayName'?: Array<LangStringNameType>;
    'extensions'?: Array<Extension>;
    'administration'?: AdministrativeInformation;
    'assetKind'?: AssetKind;
    'assetType'?: string;
    'endpoints'?: Array<Endpoint>;
    'globalAssetId'?: string;
    'idShort'?: string;
    'id': string;
    'specificAssetIds'?: Array<SpecificAssetId>;
    'submodelDescriptors'?: Array<SubmodelDescriptor>;

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
            "name": "assetKind",
            "baseName": "assetKind",
            "type": "AssetKind",
            "format": ""
        },
        {
            "name": "assetType",
            "baseName": "assetType",
            "type": "string",
            "format": ""
        },
        {
            "name": "endpoints",
            "baseName": "endpoints",
            "type": "Array<Endpoint>",
            "format": ""
        },
        {
            "name": "globalAssetId",
            "baseName": "globalAssetId",
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
            "name": "id",
            "baseName": "id",
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
            "name": "submodelDescriptors",
            "baseName": "submodelDescriptors",
            "type": "Array<SubmodelDescriptor>",
            "format": ""
        }    ];

    static getAttributeTypeMap() {
        return AssetAdministrationShellDescriptor.attributeTypeMap;
    }

    public constructor() {
    }
}



