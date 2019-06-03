# /usr/bin/env bash

set -e

#HOST_LIST=''
HOST_LIST='
123.59.85.8
'

# build
cd ..
mvn clean
mvn package -Dmaven.test.skip=true

# deploy remotely
for host in $HOST_LIST
do
    echo 'To deploy '$host'...'
    scp -P 59522 target/personal-tailor-1.0.0.war root@$host:/data/rosetta/war_temp
	echo ''$host' deployed'
done