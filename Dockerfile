FROM openjdk:21
COPY target/Insurance-Management.jar  /usr/app/
WORKDIR /usr/app/
ENTRYPOINT ["java", "-jar", "Insurance-Management"]
