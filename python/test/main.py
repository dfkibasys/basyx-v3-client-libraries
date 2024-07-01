import sys
import os

# Füge den Pfad der lokalen Bibliothek zum Systempfad hinzu
sys.path.append(os.path.join(os.path.dirname(__file__), '../build/generated/project'))
import basyxclients
from basyxclients.rest import ApiException
from pprint import pprint

def main():
    # Defining the host is optional and defaults to http://localhost
    # See configuration.py for a list of all supported configuration parameters.
    configuration = basyxclients.Configuration(
        host = "http://localhost:8083"
    )

    # Enter a context with an instance of the API client
    with basyxclients.ApiClient(configuration) as api_client:
        # Create an instance of the API class
        api_instance = basyxclients.AssetAdministrationShellRegistryApi(api_client)

        try:
            # Deletes an Asset Administration Shell Descriptor, i.e. de-registers an AAS
            result = api_instance.get_all_asset_administration_shell_descriptors()
            print("Got result: %d\n " % len(result.result))
            
        except ApiException as e:
            print("Exception when calling AssetAdministrationShellRegistryApi->delete_asset_administration_shell_descriptor_by_id: %s\n" % e)

    

if __name__ == "__main__":
    main()