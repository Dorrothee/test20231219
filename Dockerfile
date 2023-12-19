FROM openjdk:17
COPY target/test-1.0-SNAPSHOT.jar app.jar
<<<<<<< HEAD
CMD ["java", "-jar", "/app.jar"]
=======
CMD ["java", "-jar", "/app.jar"]
>>>>>>> 7d4774037636872a4ca8a422ed1e0c25cd8a91a0
