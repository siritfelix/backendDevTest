FROM openjdk:8-jdk-alpine
COPY target/devtest-0.0.1-SNAPSHOT.jar devtest-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar", "-Dspring.profiles.active=docker" ,"/devtest-0.0.1-SNAPSHOT.jar"]