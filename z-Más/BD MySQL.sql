DROP DATABASE apragma;
CREATE DATABASE IF NOT EXISTS apragma;
USE apragma;
DROP TABLE IF EXISTS `ciudad`;
CREATE TABLE `ciudad` (
    `id` INT NOT NULL,
    `nombre` VARCHAR(255) NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE(`nombre`)
);
DROP TABLE IF EXISTS `documentotipo`;
CREATE TABLE `documentotipo` (
    `id` INT NOT NULL,
    `nombre` VARCHAR(255) NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE(`nombre`)
);
DROP TABLE IF EXISTS `persona`;
CREATE TABLE `persona` (
    `id` INT NOT NULL,
    `nombres` VARCHAR(50) NOT NULL,
    `apellidos` VARCHAR(255) NOT NULL,
    `iddocumentotipo` INT NOT NULL,
    `documentonumero` VARCHAR(255) NOT NULL,
    `edad` INT NOT NULL,
    `idciudadnacimiento` INT NOT NULL,
    `idfoto` VARCHAR(30) NOT NULL,
    PRIMARY KEY (`id`),
    FOREIGN KEY (`idciudadnacimiento`) REFERENCES `ciudad`(`id`),
    FOREIGN KEY (`iddocumentotipo`) REFERENCES `documentotipo`(`id`),
    UNIQUE(`documentonumero`),
    INDEX (`edad`)
);
INSERT INTO ciudad
VALUES (1, "Cúcuta"),
    (2, "Cali"),
    (3, "Bucaramanga"),
    (4, "Bogotá"),
    (5, "Medellin");
INSERT INTO documentotipo
VALUES (1, "Cédula de ciudadania"),
    (2, "Tarjeta de identidad");
INSERT INTO persona
VALUES (1, "Jorge", "Anaya", 1, "123", 19, 1, "60d4c1fdaba981f736e01d7d"),
    (2, "Paola", "León", 2, "223", 11, 2, "60d4c1fdaba981f736e01d7e"),
    (3, "Daniela", "Torres", 1, "323", 65, 3, "60d4c1fdaba981f736e01d7f"),
    (4, "Monica", "Luz", 2, "423", 16, 4, "60d4c1fdaba981f736e01d80"),
    (5, "Ricardo", "Agua", 1, "523", 23, 5, "60d4c1fdaba981f736e01d81");