use db_project;
INSERT INTO `account` (`username`,`passwd`,`role`,`enabled`)
VALUES ('namhm',
'$2a$10$XptfskLsT1l/bRTLRiiCgejHqOpgXFreUnNUa35gJdCr2v2QbVFzu',
'ROLE_USER', 1);
 
INSERT INTO `account` (`username`,`passwd`,`role`,`enabled`)
VALUES ('admin',
'$2a$10$zxvEq8XzYEYtNjbkRsJEbukHeRx3XS6MDXHMu8cNuNsRfZJWwswDy',
'ROLE_ADMIN', 1);