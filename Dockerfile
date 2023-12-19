FROM openjdk:17
WORKDIR /app
COPY target/test-1.0-SNAPSHOT.jar /app/test.jar
ENTRYPOINT ["java","-jar","test.jar"]