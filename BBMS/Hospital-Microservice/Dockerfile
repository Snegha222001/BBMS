FROM adoptopenjdk/openjdk11:alpine-jre
ARG JAR_FILE=target/*.jar
WORKDIR /opt/app
COPY ${JAR_FILE} Hospital-Microservice.jar
ENTRYPOINT ["java","-jar","Hospital-Microservice.jar"]
