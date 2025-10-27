# Use an official OpenJDK image
FROM openjdk:17-jdk-slim

# Set working directory
WORKDIR /app

# Copy all files to the container
COPY . .

# Expose the default Render port
EXPOSE 10000

# Run the WAR using Jetty Runner
CMD ["java", "-jar", "jetty-runner-9.4.51.v20230217.jar", "--port", "10000", "MedicalManagementSystem.war"]
