FROM openjdk:17
COPY target/test-1.0-SNAPSHOT.jar app.jar
CMD ["java", "-jar", "/app.jar"]