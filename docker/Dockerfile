FROM openjdk:8-jre-alpine
MAINTAINER Swapnil Gaikwad <swapnilbgaikwad99@gmail.com>

EXPOSE 8080

#install utilities
RUN apk add --no-cache curl

COPY artifact/LinkShare.jar /usr/local/appPath/LinkShare.jar

WORKDIR /usr/local/appPath

CMD java -jar LinkShare.jar
