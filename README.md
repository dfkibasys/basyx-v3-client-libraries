# Basyx V3 Client Libraries

Client SDKS based that interact with this server implementation: https://github.com/eclipse-basyx/basyx-java-server-sdk


https://github.com/OpenAPITools/openapi-generator/tree/master/modules/openapi-generator-maven-plugin


# TODO 

- byte replacement auch auf listen anwenden z.B. bei AssetIds
- search api einbauen (wenig aufwändig, neue library?)
- SubmodelElementList wieder rein (am besten wäre ein discriminator feld, da das wohl nicht geht kann man vielleicht den generator von außen bereitstellen und nicht generieren, submodelelement kann dann als provided in den maven dependencies angegeben werden)
- patterns wieder rein (nicht besonders relevant)
- client c#, typescript und optional go und python