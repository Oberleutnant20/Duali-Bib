/**
 * Author:  Thomas Jäger
 * Created: 17.04.2018
 * Last Change: 24.04.2018
 */

-- Löscht das Datenbankschema(Database), wenn es existiert
DROP SCHEMA IF EXISTS dualibib;
-- Erstellt das Datenbankschema(Database), wenn es nicht existiert
CREATE SCHEMA IF NOT EXISTS dualibib;
-- Nutzt das erstellte Datenbankchema
USE dualibib;
-- Löscht Tabellen(Table), wenn diese existiert, auch wenn diese zusammenhängen
DROP TABLE IF EXISTS User;
DROP TABLE IF EXISTS Ausleihe;
DROP TABLE IF EXISTS History;
DROP TABLE IF EXISTS Printmedien;
DROP TABLE IF EXISTS andereMedien;
DROP TABLE IF EXISTS Genre;
DROP TABLE IF EXISTS KategorieMedien;

-- Erstelle Tabellen(Table)
CREATE TABLE User(
u_ID INTEGER AUTO_INCREMENT,
u_Vorname VARCHAR(150),
u_Nachname VARCHAR(150),
u_login VARCHAR(8) UNIQUE,
u_passwd VARCHAR(192),
u_Mitarbeiter BOOLEAN DEFAULT false,
PRIMARY KEY (u_ID)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE Ausleihe(
a_ID BIGINT AUTO_INCREMENT,
a_DATE DATE,
u_ID INTEGER,
PRIMARY KEY (a_ID),
FOREIGN KEY (u_ID) REFERENCES User(u_ID)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE Genre(
g_ID INTEGER AUTO_INCREMENT,
g_Name VARCHAR(150) UNIQUE,
PRIMARY KEY (g_ID)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE KategorieMedien(
km_ID INTEGER AUTO_INCREMENT,
km_name VARCHAR(150) UNIQUE,
km_beschreibung VARCHAR(500),
PRIMARY KEY (km_ID)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE Printmedien(
pm_ID BIGINT AUTO_INCREMENT,
pm_Titel VARCHAR(150),
pm_Author VARCHAR(150),
pm_ISBN VARCHAR(24) UNIQUE,
pm_Barcodenummer BIGINT UNIQUE, 
a_ID BIGINT,
km_ID INTEGER,
g_ID INTEGER,
PRIMARY KEY (pm_ID),
FOREIGN KEY (a_ID) REFERENCES Ausleihe(a_ID),
FOREIGN KEY (km_ID) REFERENCES KategorieMedien(km_ID),
FOREIGN KEY (g_ID) REFERENCES Genre(g_ID)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE andereMedien(
am_ID BIGINT AUTO_INCREMENT,
am_Titel VARCHAR(150),
am_Author VARCHAR(150),
am_Barcodenummer BIGINT UNIQUE,
a_ID BIGINT,
km_ID INTEGER,
g_ID INTEGER,
PRIMARY KEY (am_ID),
FOREIGN KEY ( a_ID) REFERENCES Ausleihe(a_ID),
FOREIGN KEY (km_ID) REFERENCES KategorieMedien(km_ID),
FOREIGN KEY (g_ID) REFERENCES Genre(g_ID)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE History(
h_ID BIGINT AUTO_INCREMENT,
u_ID INTEGER,
km_ID INTEGER,
PRIMARY KEY (h_ID),
FOREIGN KEY (u_ID) REFERENCES User(u_ID),
FOREIGN KEY (km_ID) REFERENCES KategorieMedien(km_ID)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

---- Einfügen(Insert)
INSERT INTO dualibib.Genre(g_name) VALUES ('Test');
INSERT INTO dualibib.KategorieMedien(km_name, km_beschreibung) VALUES ('Test1', 'Ein einfacher Test');
-- Password: !Administrator@dualibib
-- Passwordalgorithmus: SHA-512
INSERT INTO User(u_Vorname, u_Nachname, u_Login, u_passwd, u_mitarbeiter)
VALUES ('Admin', 'Min', 'admin001', '1f91db1eb1781471c712d1001a21971a01611ab1431601491881da1ed19111c12213e1df1241111ad1f014b1b214c1de1041f61ca1681371621c710318719612113213a1b81cc11a1ea10e1841c11d11c01851d21571a412a14111a13718d1e6', true)
