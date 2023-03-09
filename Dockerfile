#FROM eclipse-temurin
FROM amazoncorretto:17-alpine-jdk
MAINTAINER felnyrius.io
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app-jpa.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app-jpa.jar"]

#FROM maven:3.8.2-jdk-8
#WORKDIR .
#COPY . .
#RUN mvn clean install
#CMD mvn spring-boot:run
