#!/bin/bash


PORTAINER_PWD=$(cat ./portainer/admin-password)


read -p "Should authentication be enabled? [Y/n]: " auth_enabled

auth_enabled=${auth_enabled:-Y}

if [[ "$auth_enabled" =~ ^[Yy]$ ]]; then
    echo "Authentication will be enabled."
    docker compose --env-file .env.secure -p basyx -f docker-compose-basyx.yml up -d --remove-orphans
    set -a
    source .env
    set +a
else
    echo "Authentication will not be enabled."
    docker compose --env-file .env.unsecure  -p basyx -f docker-compose-basyx.yml up -d --remove-orphans
    set -a
    source .env.unsecure
    set +a
fi


echo ""
echo "=== services services  ==="
echo ""

echo "Portainer:         http://localhost:8084 (admin / $PORTAINER_PWD)"
echo "Aas Registry:      http://localhost:8083/shell-descriptors" 
echo "Submodel Registry: http://localhost:8082" 
echo "AasRepo:           http://localhost:8081/shells" 
echo "SmRepo:            http://localhost:8081/submodels" 
echo "CdRepo:            http://localhost:8081/concept-descriptions" 
echo "AasxFileServer:    http://localhost:8086/packages"
echo "Keycloak:          http://localhost:8085 (keycloak / keycloak-admin)" 
echo "AasGui:            http://localhost:3000/"

