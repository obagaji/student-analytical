# Use a slim OpenJDK base image for smaller image size
FROM openjdk:17-jdk-slim


# Set the working directory inside the container
WORKDIR /app

# A Copy of the application's JAR file into the container
COPY target/student-eureka-0.0.1-SNAPSHOT.jar app.jar

# Exposing the Spring Boot application listens on 8761
EXPOSE 8761

# Define the command to run the Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar"]