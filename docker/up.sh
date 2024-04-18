#!/bin/bash


PORTAINER_PWD=$(cat ./portainer/admin-password)

docker compose -p basyx -f docker-compose-basyx.yml up -d


set -a
source .env
set +a

echo ""
echo "=== services services  ==="
echo ""

echo "Portainer:         http://locahost:8084 (admin / $PORTAINER_PWD)"
echo "Aas Registry:      http://localhost:8083" 
echo "Submodel Registry: http://localhost:8082" 
echo "AasRepo:           http://localhost:8081/shells" 
echo "SmRepo:            http://localhost:8081/submodels" 
echo "CdRepo:            http://localhost:8081/concept-descriptions" 
echo "AasGui:            http://localhost:3000/"

