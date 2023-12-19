FROM openjdk:17
COPY . app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
