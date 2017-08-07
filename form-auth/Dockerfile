FROM tomcat:8.0.45-jre8-alpine
ADD src/main/scripts/tomcat /usr/local/tomcat/
ADD target/ha-plugin/lib /usr/local/tomcat/lib
ADD target/form-auth.war /usr/local/tomcat/webapps/