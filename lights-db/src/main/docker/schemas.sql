--
-- Table spaces
--
CREATE  TABLESPACE lightsdat
DATAFILE '/u01/app/oracle/oradata/lights_01.dbf' SIZE 2m AUTOEXTEND ON NEXT 10m MAXSIZE 20m
LOGGING EXTENT MANAGEMENT LOCAL SEGMENT SPACE MANAGEMENT AUTO;

--
-- ROLES
--
CREATE ROLE lights_app_role;

GRANT create session            TO lights_app_role;
GRANT create synonym            TO lights_app_role;
GRANT create indextype          TO lights_app_role;
GRANT create materialized view  TO lights_app_role;
GRANT create procedure          TO lights_app_role;
GRANT create sequence           TO lights_app_role;
GRANT create table              TO lights_app_role;
GRANT create trigger            TO lights_app_role;
GRANT create type               TO lights_app_role;
GRANT create view               TO lights_app_role;


--
-- Users
--
CREATE USER lights IDENTIFIED BY Pa55W0rd
DEFAULT TABLESPACE lightsdat TEMPORARY TABLESPACE temp
QUOTA UNLIMITED ON lightsdat
ACCOUNT UNLOCK;
GRANT lights_app_role to lights;

exit

