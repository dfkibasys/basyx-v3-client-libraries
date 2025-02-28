#!/bin/bash


PORTAINER_PWD=$(cat ./portainer/admin-password)

read -p "Should authentication be enabled? [y/N]: " auth_enabled
auth_enabled=${auth_enabled:-N}
read -p "Should registy integration be enabled? [Y/n]: " registration_integration_enabled
registration_integration_enabled=${registration_integration_enabled:-Y}



if [[ "$auth_enabled" =~ ^[Yy]$ ]]; then
    envFile=.env
    profile="--profile secure"
else
    envFile=.env.unsecure    
    profile=""
fi

if [[ "$registration_integration_enabled" =~ ^[Yy]$ ]]; then
    echo "Registry integration will be enabled."
else
    echo "Registry integration will not be enabled."
    envFile=${envFile}.noregistryintegration
fi

echo using env file ${envFile}
docker compose --env-file ${envFile} -p basyx -f docker-compose-basyx.yml $profile up -d --remove-orphans
set -a
source ${envFile}
set +a


echo ""
echo "=== services services  ==="
echo ""

echo "Portainer:         http://localhost:8084 (admin / $PORTAINER_PWD)"
echo "Aas Registry:      http://localhost:8083/shell-descriptors" 
echo "Submodel Registry: http://localhost:8082" 
echo "AasRepo:           http://localhost:8081/shells" 
echo "SmRepo:            http://localhost:8081/submodels" 
echo "CdRepo:            http://localhost:8081/concept-descriptions" 
echo "SmService:         http://localhost:8079/submodel"
echo "AasxFileServer:    http://localhost:8086/packages"
echo "Keycloak:          http://localhost:8085 (keycloak / keycloak-admin)" 
echo "AasGui:            http://localhost:3000/"

