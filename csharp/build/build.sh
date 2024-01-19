#!/bin/bash
#dotnet nuget add source ./release -n localrelease
#dotnet nuget list source

dotnet pack generated/project/src/De.Dfki.Basys.Clients.V3_0_1 -c Release -o ../release

#cp ./model-part1/generated/project/src/De.Dfki.Basys.Clients.V3_0_1/Release/De.Dfki.Basys.Clients.V3.0.1.0.nupkg ./release

#dotnet nuget package add --package De.Dfki.Basys.Clients.V3.Metamodel.Part1 --source localrelease ../Release


