FROM maven:3.9.5-eclipse-temurin-21 AS builder
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests
FROM openjdk:21
WORKDIR /app
COPY --from=builder /app/target/Insurance-Management.jar Insurance-Management.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "Insurance-Management.jar"]
