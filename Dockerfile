# Use a Tomcat base image
FROM tomcat:9.0-jdk17-openjdk

# Set the working directory
WORKDIR /usr/local/tomcat/webapps

# Copy the WAR file into the Tomcat webapps directory
COPY target/*.war ROOT.war

# Expose the port Tomcat will run on
EXPOSE 8080

# Start Tomcat
CMD ["catalina.sh", "run"]
