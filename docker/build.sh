#!/usr/bin/env bash

if [ ! -d "../build" ]
then
	echo "Seems like you haven't run gradle build"
	exit 1
fi

docker build -t linkshare:1.0 .