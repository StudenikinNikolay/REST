FROM openjdk:17-jdk-slim-buster

EXPOSE 8080

ADD target/hw_AuthorizationService-0.0.1-SNAPSHOT.jar authorizationSevice.jar

CMD ["java", "-jar", "authorizationSevice.jar"]