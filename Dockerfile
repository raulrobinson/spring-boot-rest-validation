FROM openjdk:11-jre-slim-buster
RUN apt-get update && apt-get install curl -y
COPY /target/spring-boot-rest-validation.jar /home/spring-boot-rest-validation.jar
CMD ["java","-jar","/home/spring-boot-rest-validation.jar"]
