#The first line is always from
FROM tomcat:8.0-jre8

#Who created this image
LABEL maintainer = "Travis Taylor"

#What do we do with the WAR file
ADD target/employee-servlet-app.war usr/local/tomcat/webapps

# Expose port 8080 from the container
EXPOSE 8080

#CMD instruction specifies to run when the container is run

CMD ["catalina.sh", "run"]