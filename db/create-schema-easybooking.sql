
DROP SCHEMA easybooking;

DROP USER 'nomgen2';

CREATE SCHEMA easybooking;

CREATE USER 'nomgen2' IDENTIFIED BY 'password';

GRANT ALL ON easybooking.* TO 'nomgen2';