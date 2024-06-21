import {createConfiguration, AssetAdministrationShellRegistryApi, ServerConfiguration } from "@basys/v3-client-ts";

function main(): void {
  let conf = {
    baseServer: new ServerConfiguration<{  }>("http://localhost:8083", {  })
  }

  const configuration = createConfiguration(conf);
  const apiInstance = new AssetAdministrationShellRegistryApi(configuration);

  apiInstance.getAllAssetAdministrationShellDescriptors( ).then((data:any) => {
    console.log('API called successfully. Returned data: ', data);
  }).catch((error:any) => console.error(error));
}

main();
