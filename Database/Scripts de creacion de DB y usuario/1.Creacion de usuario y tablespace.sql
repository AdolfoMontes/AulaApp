--Creacion de Tablespace
create tablespace AULAAPP 
datafile 'C:\app\oradata\XE\AULAAPP.dbf'
size 40M
EXTENT MANAGEMENT LOCAL
SEGMENT SPACE MANAGEMENT AUTO;

--Creacion de usuario
alter session set "_ORACLE_SCRIPT"=true;
CREATE USER AULAAPP IDENTIFIED BY AULAAPP 
DEFAULT TABLESPACE AULAAPP;
ALTER USER AULAAPP QUOTA UNLIMITED ON USERS;
GRANT CREATE SESSION TO AULAAPP;
GRANT "RESOURCE" TO AULAAPP;
GRANT "DBA" TO AULAAPP;
ALTER USER AULAAPP DEFAULT ROLE "RESOURCE";
GRANT CREATE VIEW TO AULAAPP;