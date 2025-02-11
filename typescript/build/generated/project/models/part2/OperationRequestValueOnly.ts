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
import { HttpFile } from '../../http/http';

export class OperationRequestValueOnly {
    /**
    * The ValueOnly serialization of submodel elements (patternProperties and propertyNames will be supported propably with OpenApi 3.1). The full description of the generic JSON validation schema for the ValueOnly-serialization can be found in chapter 11.4.3 in Details of the Asset Administration Shell Part 2. 
    */
    'inoutputArguments'?: any;
    /**
    * The ValueOnly serialization of submodel elements (patternProperties and propertyNames will be supported propably with OpenApi 3.1). The full description of the generic JSON validation schema for the ValueOnly-serialization can be found in chapter 11.4.3 in Details of the Asset Administration Shell Part 2. 
    */
    'inputArguments'?: any;
    'clientTimeoutDuration': string;

    static readonly discriminator: string | undefined = undefined;

    static readonly attributeTypeMap: Array<{name: string, baseName: string, type: string, format: string}> = [
        {
            "name": "inoutputArguments",
            "baseName": "inoutputArguments",
            "type": "any",
            "format": ""
        },
        {
            "name": "inputArguments",
            "baseName": "inputArguments",
            "type": "any",
            "format": ""
        },
        {
            "name": "clientTimeoutDuration",
            "baseName": "clientTimeoutDuration",
            "type": "string",
            "format": ""
        }    ];

    static getAttributeTypeMap() {
        return OperationRequestValueOnly.attributeTypeMap;
    }

    public constructor() {
    }
}

