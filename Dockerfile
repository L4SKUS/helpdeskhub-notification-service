FROM openjdk:17-jdk-slim
COPY target/notifications-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "app.jar"]