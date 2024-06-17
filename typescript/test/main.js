"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var v3_client_ts_1 = require("@basyx/v3-client-ts");
// Funktion zum Ausgeben einer Begrüßung
function greet(name) {
    console.log("Hallo, ".concat(name, "!"));
    var configuration = (0, v3_client_ts_1.createConfiguration)();
    var apiInstance = new v3_client_ts_1.AssetAdministrationShellRegistryApi(configuration);
    apiInstance.getAllAssetAdministrationShellDescriptors().then(function (data) {
        console.log('API called successfully. Returned data: ' + data);
    }).catch(function (error) { return console.error(error); });
}
// Hauptmethode
function main() {
    // Hier kannst du deinen Code platzieren
    var name = "Welt";
    greet(name);
}
// Aufruf der Hauptmethode
main();
