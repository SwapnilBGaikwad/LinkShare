#!/usr/bin/env bash

if [ ! -d "../build" ]
then
	echo "Seems like you haven't run gradle build"
	exit 1
fi

mkdir artifact
cp -rf ../build/libs/LinkShare*.jar artifact/LinkShare.jar

docker build -t linkshare:1.0 .