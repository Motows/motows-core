FROM openjdk:8-jdk-alpine
WORKDIR motows
ADD target/*.jar motows-core.jar
EXPOSE 8093 3306 80
ENTRYPOINT ["java","-jar","motaows-core.jar"]