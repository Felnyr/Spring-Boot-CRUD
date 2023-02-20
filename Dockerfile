#FROM eclipse-temurin
FROM amazoncorretto:11-alpine-jdk
MAINTAINER felnyrius.io
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app-jpa.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app-jpa.jar"]