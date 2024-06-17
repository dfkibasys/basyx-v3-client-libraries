import {createConfiguration, AssetAdministrationShellRegistryApi } from '@basyx/v3-client-ts' ;

// Funktion zum Ausgeben einer Begrüßung
function greet(name: string): void {
    console.log(`Hallo, ${name}!`);


    const configuration = createConfiguration();
    const apiInstance = new AssetAdministrationShellRegistryApi(configuration);
    
    
    apiInstance.getAllAssetAdministrationShellDescriptors( ).then((data:any) => {
      console.log('API called successfully. Returned data: ' + data);
    }).catch((error:any) => console.error(error));
    
    

}

// Hauptmethode
function main(): void {
    // Hier kannst du deinen Code platzieren
    const name: string = "Welt";
    greet(name);
}

// Aufruf der Hauptmethode
main();