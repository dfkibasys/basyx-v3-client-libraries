from basyxclients.api import AssetAdministrationShellBasicDiscoveryApi
from basyxclients.api import SubmodelRepositoryApi
from basyxclients import Configuration
from basyxclients import ApiClient
from basyxclients import ApiException
from basyxclients.models.part1 import SpecificAssetId

from pprint import pprint

# Defining the host is optional and defaults to http://localhost
# See configuration.py for a list of all supported configuration parameters.
configuration = Configuration(
    host = "http://localhost:8081"
)

# Enter a context with an instance of the API client
with ApiClient(configuration) as api_client:
    # Create an instance of the API class
 #   api_instance = AssetAdministrationShellBasicDiscoveryApi(api_client)
    api_instance = SubmodelRepositoryApi(api_client)
    
    try:
        # asset_id = SpecificAssetId(
        #     name="globalAssetId",
        #     value="http://aas.dfki.de/ids/asset/clip/l130"
        # )

        # # The API expects a list of these objects.
        # asset_id_list = [asset_id]
        # api_response = api_instance.post_asset_links_by_shell_id_with_http_info(aas_identifier="http://aas.dfki.de/shell/clip/l130", specific_asset_id=asset_id_list)
        # print("Response:")
        # pprint(api_response)
        # api_response = api_instance.get_all_shell_ids_by_asset_links_with_http_info(asset_ids=asset_id_list)
        # print("Response:")
        # pprint(api_response)

        api_response = api_instance.get_all_submodels().result[0].id
        print("Response:")
        pprint(api_response)
        api_response = api_instance.get_all_submodel_elements(submodel_identifier="http://acplt.test/Submodels/Assets/TestAsset/Identification")
        print("Response:")
        pprint(api_response)
    except ApiException as e: # Die Ausnahmemeldung wurde korrigiert, um zum API-Aufruf zu passen
        print("Exception when calling AssetAdministrationShellBasicDiscoveryApi->get_all_shell_ids_by_asset_links: %s\n" % e)

