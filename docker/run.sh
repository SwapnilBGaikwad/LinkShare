#!/usr/bin/env bash

cd ../
./gradlew clean build
cd docker/
./buildDocker.sh
docker-compose up LinkShare
