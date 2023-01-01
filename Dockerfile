FROM anapsix/alpine-java
RUN apt-get update && apt-get install curl -y
LABEL maintainer="rasysbox@hotmail.com"
COPY /target/spring-boot-rest-validation-0.0.1-SNAPSHOT.jar /home/spring-boot-rest-validation-0.0.1-SNAPSHOT.jar
CMD ["java","-jar","/home/spring-boot-rest-validation-0.0.1-SNAPSHOT.jar"]
