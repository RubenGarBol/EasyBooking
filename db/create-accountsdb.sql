/* DELETE 'accountsDB' database*/
DROP SCHEMA easybooking;
/* DELETE USER 'sd' AT LOCAL SERVER*/
DROP USER 'nomgen2';

/* CREATE ''accountsDB' DATABASE */
CREATE SCHEMA easybooking;
/* CREATE THE USER 'accounts_user' AT LOCAL SERVER WITH PASSWORD 'password' */
CREATE USER 'nomgen2' IDENTIFIED BY 'password';
/* GRANT FULL ACCESS TO THE DATABASE FOR THE USER 'accounts_user' AT LOCAL SERVER*/
GRANT ALL ON easybooking.* TO 'nomgen2';