FROM openjdk:17
WORKDIR /app
COPY . /app/Main.jar
CMD ["java", "-jar", "Main.jar"]
