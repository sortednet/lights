Lights Server
=============

Run in tomcat
-------------
Install the war file lights/lights-server/lights-webapp/target/lights-webapp-${version}.war in tomcat (eg in /usr/local/tomcat/webapps). 
This needs to be configured with the database url,user name and password. 
Either modify the application config or override in tomcat startup (using -D)

spring.datasource.url=jdbc:oracle:thin:@//lightsdb:1521/XE
spring.datasource.username=system
spring.datasource.password=oracle
spring.datasource.driverClassName=oracle.jdbc.driver.OracleDriver

Run using Docker
----------------
There are 2 images, webserver and database

These are made into a sysem using docker-compose