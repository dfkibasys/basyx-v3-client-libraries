using De.Dfki.Basys.Clients.V3_0_1.Model.Part1;
using De.Dfki.Basys.Clients.V3_0_1.Model.Part2;
using De.Dfki.Basys.Clients.V3_0_1.Api;
using De.Dfki.Basys.Clients.V3_0_1.Client;
using System.Web;

TestAssetAdministrationShellRegistry();
TestBasicDiscoveryApi();
TestAssetAdministrionShellRepository();
TestConceptDescriptionRepository();
TestSubmodelRegistry();
TestSubmodelRepository();

void TestAssetAdministrationShellRegistry()
{
    var id = "https://acplt.test/Test_AssetAdministrationShell";
    var api = new AssetAdministrationShellRegistryApi("http://localhost:8083/api/v3.0");
    Console.WriteLine(api.GetAllAssetAdministrationShellDescriptorsWithHttpInfo().StatusCode);
    Console.WriteLine(api.GetAllAssetAdministrationShellDescriptors().ToJson());
    Console.WriteLine(api.GetAssetAdministrationShellDescriptorById(id).ToJson());
}

void TestBasicDiscoveryApi()
{
    try
    {
        var id = "https://acplt.test/Test_AssetAdministrationShell";
        var discoveryApi = new AssetAdministrationShellBasicDiscoveryApi("http://localhost:8081");
        Console.WriteLine(discoveryApi.GetDescription().ToJson());
        Console.WriteLine(discoveryApi.GetAllAssetLinksById(id));
    }
    catch (ApiException e)
    {
        Console.WriteLine(e.Message);
    }
}

void TestAssetAdministrionShellRepository() {
    var repoApi = new AssetAdministrationShellRepositoryApi("http://localhost:8081");
    Console.WriteLine(repoApi.GetDescription().ToJson());
    Console.WriteLine(repoApi.GetAssetAdministrationShellById("https://acplt.test/Test_AssetAdministrationShell").ToJson());
}

void TestConceptDescriptionRepository() {
    var cdApi = new ConceptDescriptionRepositoryApi("http://localhost:8081");
    Console.WriteLine(cdApi.GetDescription().ToJson());
    Console.WriteLine(cdApi.GetAllConceptDescriptions(null, null, null, null, null).ToJson());
}

void TestSubmodelRegistry() {
    var smApi = new SubmodelRegistryApi("http://localhost:8082/api/v3.0");
    var smResult = smApi.GetAllSubmodelDescriptors(null, null);
    Console.WriteLine(smResult.ToJson());
    Console.WriteLine(smApi.GetSubmodelDescriptorById("http://acplt.test/Submodels/Assets/TestAsset/Identification").ToJson());
}

void TestSubmodelRepository() {
    var smRepoApi = new SubmodelRepositoryApi("http://localhost:8081");
    Console.WriteLine(smRepoApi.GetAllSubmodels(null, null, null, null, null, null).ToJson());
    Console.WriteLine(smRepoApi.GetAllSubmodelElements("http://acplt.test/Submodels/Assets/TestAsset/Identification", 1, null, null, null));
}
