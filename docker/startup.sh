#!/bin/sh

cd /opt/filebeat-${FILEBEAT_VERSION}-linux-x86_64
nohup filebeat &

cd /usr/local/appPath
java -jar LinkShare.jar
