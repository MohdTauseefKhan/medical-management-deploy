FROM openjdk:17-jdk-slim

WORKDIR /app

# Copy all necessary files
COPY MedicalManagementSystem.war .
COPY webapp-runner-main-9.0.41.0.jar .

# Expose Render's dynamic port
EXPOSE 8080

# Start the app using webapp-runner
CMD ["java", "-jar", "webapp-runner-main-9.0.41.0.jar", "--port", "8080", "MedicalManagementSystem.war"]