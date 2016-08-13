#!/usr/bin/bash

# Server
cd spring-cloud-demo-server
mvn clean package -Dmaven.test.skip=true
docker rmi spring-cloud-docker-demo/server
docker build -t spring-cloud-docker-demo/server .
cd ..

# Simple Client
cd spring-cloud-demo-simple-client
mvn clean package -Dmaven.test.skip=true
docker rmi spring-cloud-docker-demo/simple-client
docker build -t spring-cloud-docker-demo/simple-client .
cd ..

# Advanced Client
cd spring-cloud-demo-advanced-client
mvn clean package -Dmaven.test.skip=true
docker rmi spring-cloud-docker-demo/advanced-client
docker build -t spring-cloud-docker-demo/advanced-client .
cd ..