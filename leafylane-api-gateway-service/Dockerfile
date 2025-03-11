FROM openjdk:17-alpine

VOLUME /tmp

ARG JAR_FILE

COPY target/${JAR_FILE} gateway-server.jar

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/gateway-server.jar"]