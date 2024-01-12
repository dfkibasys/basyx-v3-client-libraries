#!/bin/bash


PORTAINER_PWD=$(cat ./portainer/admin-password)

docker compose -p basyx -f docker-compose-basyx.yml up -d


set -a
source .env
set +a

echo ""
echo "=== twinficient services  ==="
echo ""

echo "Portainer:         http://portainer.$EXTERNAL_HOSTNAME (admin / $PORTAINER_PWD)"
echo "Aas Registry:      http://aas-registry.$EXTERNAL_HOSTNAME/api/v3.0" 
echo "Submodel Registry: http://submodel-registry.$EXTERNAL_HOSTNAME/api/v3.0" 
echo "Environment:       http://aas-environment.$EXTERNAL_HOSTNAME/shells" 
echo "AasGui:            http://aas-gui.$EXTERNAL_HOSTNAME/"
echo "AasDiscovery:      http://aas-discovery.$EXTERNAL_HOSTNAME/"

