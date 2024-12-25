FROM openjdk:21
ADD target/Insurance-Management.jar Insurance-Management.jar
ENTRYPOINT ["java", "-jar", "Insurance-Management"]
