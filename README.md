Lights Server
=============

Run in tomcat
-------------
Install the war file lights/lights-server/lights-webapp/target/lights-webapp-${version}.war in tomcat (eg in /usr/local/tomcat/webapps). 
This needs to be configured with the database url,user name and password. 
Either modify the application config or override in tomcat startup (using -D)

    spring.datasource.url=jdbc:oracle:thin:@//lights-db.sorted.net:1521/XE
    spring.datasource.username=system
    spring.datasource.password=oracle
    spring.datasource.driverClassName=oracle.jdbc.driver.OracleDriver

Run using Docker
----------------
There are 2 images, webserver and database

These are made into a sysem using docker-compose. 

To start up the lights system (webserver and DB)
    
    cd lights/lights-webserver/src/main/docker
    docker-compose up
    
The application is then available on the URL: http://localhost:8888/index.html
(on mac the IP of the VM that docker machine is running in will be needed. run 'docker-machine env default' and use the IP for the DOCKER_HOST instead of localhost).
The database is available on the same IP on port 1521

