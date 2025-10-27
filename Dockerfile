# Use official Tomcat base image
FROM tomcat:10.1-jdk17

# Set working directory
WORKDIR /usr/local/tomcat/webapps/

# Remove the default ROOT app
RUN rm -rf ROOT

# Copy your WAR file and rename it as ROOT.war
COPY MedicalManagementSystem.war ROOT.war

# Expose Render's port
EXPOSE 8080

# Start Tomcat
CMD ["catalina.sh", "run"]
