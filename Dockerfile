# Use Tomcat 11 with Java 21
FROM tomcat:11.0-jdk21

WORKDIR /usr/local/tomcat/webapps/

RUN rm -rf ROOT

COPY MedicalManagementSystem.war ROOT.war

EXPOSE 8080

CMD ["catalina.sh", "run"]
