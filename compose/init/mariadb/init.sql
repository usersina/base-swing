CREATE DATABASE IF NOT EXISTS `java_tp_db` DEFAULT CHARACTER SET UTF8 COLLATE UTF8_GENERAL_CI;

USE `java_tp_db`;

DROP TABLE IF EXISTS `student`;

CREATE TABLE student (
    id int NOT NULL PRIMARY KEY,
    firstname VARCHAR(255),
    lastname VARCHAR(255),
    average double
);