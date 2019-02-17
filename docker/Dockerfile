FROM openjdk:8-jre-alpine
MAINTAINER Swapnil Gaikwad <swapnilbgaikwad99@gmail.com>

EXPOSE 8080

#install utilities
RUN apk add --no-cache curl

#Install filebeat
ENV FILEBEAT_VERSION 5.6.10
ENV FILEBEAT_URL https://artifacts.elastic.co/downloads/beats/filebeat/filebeat-${FILEBEAT_VERSION}-linux-x86_64.tar.gz
ENV FILEBEAT_HOME /opt/filebeat-${FILEBEAT_VERSION}-linux-x86_64
ENV PATH $PATH:${FILEBEAT_HOME}
WORKDIR /opt/
RUN curl -sL ${FILEBEAT_URL} | tar xz -C .

COPY docker/filebeat/filebeat.yml ${FILEBEAT_HOME}/filebeat.yml
COPY build/libs/LinkShare*.jar /usr/local/appPath/LinkShare.jar
COPY docker/startup.sh /startup.sh

WORKDIR /usr/local/appPath

CMD ["/startup.sh"]
