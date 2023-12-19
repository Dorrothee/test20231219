FROM openjdk:17
//WORKDIR /app
COPY target/test-1.0-SNAPSHOT.jar app.jar
CMD ["java", "-jar", "/app.jar"]
