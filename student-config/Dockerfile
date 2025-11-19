# Use a slim OpenJDK base image for smaller image size
FROM openjdk:21-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the application's JAR file into the container
# Replace 'your-application.jar' with the actual name of your built JAR file
COPY target/your-application.jar app.jar

# Expose the port your Spring Boot application listens on (default is 8080)
EXPOSE 8080

# Define the command to run the Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar"]