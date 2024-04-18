# Add Source

You need to add a source at first (replace the file path, prefer cmd shell):
``` sh
dotnet nuget add source C:\repo\i4.0\basys\basyx-v3-client-libraries\csharp\release -n localsource
```
Check that we have a new source:
``` sh
dotnet nuget list source
```
# Run Test

A dependency was already added:
``` sh
dotnet add package De.Dfki.Basys.Clients.V3 --version 1.1.0
```

Now build the project with the specific source:
``` sh
dotnet build
```
And/or run it directly:
``` sh
dotnet run
```