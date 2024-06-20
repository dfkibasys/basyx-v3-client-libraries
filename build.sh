#!/bin/bash

#init
mvn install

# mvn-validate

mvn -V -s .m2/settings.xml --batch-mode validate

# mvn-install
mvn -s .m2/settings.xml --batch-mode install -Dmaven.validate.skip=true

# mpm-build
echo $MAVEN_REPO_USER
cd typescript/build/generated/project

# npm-publish
NPM_REPO=//nexus.basys.dfki.dev/repository/npm-hosted/
NPM_REPO_URL=https://nexus.basys.dfki.dev/repository/npm-hosted/


npm install
npm prune
npm run build


# npm config set strict-ssl false
# npm config set @basys:registry $NPM_REPO
# npm config set email basys-admin@dfki.de
# TOKEN=$(echo -n ${MAVEN_REPO_USER}:${MAVEN_REPO_PASS} | base64)
# npm config set //nexus.basys.dfki.dev/repository/npm-hosted/:_auth ${TOKEN} 



# npm publish
cd ../../../..
# mpm-deploy


