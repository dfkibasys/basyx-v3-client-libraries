# Basyx V3 Client Libraries

Client SDKS based that interact with this server implementation: https://github.com/eclipse-basyx/basyx-java-server-sdk



# Get Started

Pull the repository

Run *mvn install*

Go to the docker folder and run *./up.sh* and *./down.sh* to start and stop the server containers (docker needs to be installed).

Check out the main methods in the [facade project](./java/facade/src/main/java/org/eclipse/digitaltwin/basyx/v3/clientfacade/). One method uses environment variables and could be started from an [eclipse launch file](./java/facade/MainByEnvSettings.launch).