# Use a slim OpenJDK base image for smaller image size
FROM eclipse-temurin:21-jdk-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the application's JAR file into the container
# Replace 'your-application.jar' with the actual name of your built JAR file
COPY target/student-config-0.0.1-SNAPSHOT.jar app/student-config-0.0.1-SNAPSHOT.jar

# Expose the port your Spring Boot application listens on (default is 8890)
EXPOSE 8890

# Define the command to run the Spring Boot application
ENTRYPOINT ["java", "-jar", "student-config-0.0.1-SNAPSHOT.jar"]