# Use a slim OpenJDK base image for smaller image size
FROM eclipse-temurin:21-jdk-alpine


# Set the working directory inside the container
WORKDIR /app

# A Copy of the application's JAR file into the container
COPY target/student-subjects-0.0.1-SNAPSHOT.jar app/student-subjects-0.0.1-SNAPSHOT.jar

# Exposing the Spring Boot application listens on 8761
EXPOSE 8780

# Define the command to run the Spring Boot application
ENTRYPOINT ["java", "-jar", "student-subjects-0.0.1-SNAPSHOT.jar"]