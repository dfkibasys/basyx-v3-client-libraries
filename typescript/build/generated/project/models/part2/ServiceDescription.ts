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

/**
* The Description object enables servers to present their capabilities to the clients, in particular which profiles they implement. At least one defined profile is required. Additional, proprietary attributes might be included. Nevertheless, the server must not expect that a regular client understands them.
*/
export class ServiceDescription {
    'profiles'?: Array<ServiceDescriptionProfilesEnum>;

    static readonly discriminator: string | undefined = undefined;

    static readonly attributeTypeMap: Array<{name: string, baseName: string, type: string, format: string}> = [
        {
            "name": "profiles",
            "baseName": "profiles",
            "type": "Array<ServiceDescriptionProfilesEnum>",
            "format": ""
        }    ];

    static getAttributeTypeMap() {
        return ServiceDescription.attributeTypeMap;
    }

    public constructor() {
    }
}


export enum ServiceDescriptionProfilesEnum {
    AssetAdministrationShellServiceSpecificationSsp001 = 'https://admin-shell.io/aas/API/3/0/AssetAdministrationShellServiceSpecification/SSP-001',
    AssetAdministrationShellServiceSpecificationSsp002 = 'https://admin-shell.io/aas/API/3/0/AssetAdministrationShellServiceSpecification/SSP-002',
    SubmodelServiceSpecificationSsp001 = 'https://admin-shell.io/aas/API/3/0/SubmodelServiceSpecification/SSP-001',
    SubmodelServiceSpecificationSsp002 = 'https://admin-shell.io/aas/API/3/0/SubmodelServiceSpecification/SSP-002',
    SubmodelServiceSpecificationSsp003 = 'https://admin-shell.io/aas/API/3/0/SubmodelServiceSpecification/SSP-003',
    AasxFileServerServiceSpecificationSsp001 = 'https://admin-shell.io/aas/API/3/0/AasxFileServerServiceSpecification/SSP-001',
    AssetAdministrationShellRegistryServiceSpecificationSsp001 = 'https://admin-shell.io/aas/API/3/0/AssetAdministrationShellRegistryServiceSpecification/SSP-001',
    AssetAdministrationShellRegistryServiceSpecificationSsp002 = 'https://admin-shell.io/aas/API/3/0/AssetAdministrationShellRegistryServiceSpecification/SSP-002',
    SubmodelRegistryServiceSpecificationSsp001 = 'https://admin-shell.io/aas/API/3/0/SubmodelRegistryServiceSpecification/SSP-001',
    SubmodelRegistryServiceSpecificationSsp002 = 'https://admin-shell.io/aas/API/3/0/SubmodelRegistryServiceSpecification/SSP-002',
    DiscoveryServiceSpecificationSsp001 = 'https://admin-shell.io/aas/API/3/0/DiscoveryServiceSpecification/SSP-001',
    AssetAdministrationShellRepositoryServiceSpecificationSsp001 = 'https://admin-shell.io/aas/API/3/0/AssetAdministrationShellRepositoryServiceSpecification/SSP-001',
    AssetAdministrationShellRepositoryServiceSpecificationSsp002 = 'https://admin-shell.io/aas/API/3/0/AssetAdministrationShellRepositoryServiceSpecification/SSP-002',
    SubmodelRepositoryServiceSpecificationSsp001 = 'https://admin-shell.io/aas/API/3/0/SubmodelRepositoryServiceSpecification/SSP-001',
    SubmodelRepositoryServiceSpecificationSsp002 = 'https://admin-shell.io/aas/API/3/0/SubmodelRepositoryServiceSpecification/SSP-002',
    SubmodelRepositoryServiceSpecificationSsp003 = 'https://admin-shell.io/aas/API/3/0/SubmodelRepositoryServiceSpecification/SSP-003',
    SubmodelRepositoryServiceSpecificationSsp004 = 'https://admin-shell.io/aas/API/3/0/SubmodelRepositoryServiceSpecification/SSP-004',
    ConceptDescriptionServiceSpecificationSsp001 = 'https://admin-shell.io/aas/API/3/0/ConceptDescriptionServiceSpecification/SSP-001'
}

