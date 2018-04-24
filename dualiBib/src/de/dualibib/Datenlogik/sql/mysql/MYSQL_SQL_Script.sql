/**
 * Author:  @alex: TODO - Autor
 * Created: 20.02.2018
 * Last Modify: 02.03.2018 TODO - MODIFY
 */

-- Löscht das Datenbankschema(Database), wenn es existiert
DROP SCHEMA IF EXISTS dms;
-- Erstellt das Datenbankschema(Database), wenn es nicht existiert
CREATE SCHEMA IF NOT EXISTS dms;
-- Nutzt das erstellte Datenbankchema
USE dms;

-- Löscht Ansichten(Views), wenn diese existiert
DROP VIEW IF EXISTS dateninterface;
DROP VIEW IF EXISTS userinterface;

-- Löscht Tabellen(Table), wenn diese existiert, auch wenn diese zusammenhängen
-- durch Fremdschlüssel(Foreign key)
-- Löschreihenfolge von der zu letzt erstellten Tabelle zur ersten.
DROP TABLE IF EXISTS daten CASCADE;
DROP TABLE IF EXISTS user CASCADE;
DROP TABLE IF EXISTS kategorie CASCADE;
DROP TABLE IF EXISTS user_group CASCADE;

-- Erstelle Tabellen(Table)
CREATE TABLE user_group(
  ug_ID             INTEGER       AUTO_INCREMENT,
  ug_name           VARCHAR(50)   UNIQUE NOT NULL,
  ug_beschreibung   VARCHAR(500)  NOT NULL DEFAULT 'N.N.',
  CONSTRAINT ug_ugId_PK PRIMARY KEY (ug_ID)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE kategorie(
  k_ID              INTEGER       AUTO_INCREMENT,
  k_name            VARCHAR(50)   UNIQUE NOT NULL,
  k_Beschreibung   VARCHAR(500)  NOT NULL DEFAULT 'N.N.',
  CONSTRAINT k_kID_PK PRIMARY KEY(k_ID)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE user(
  u_ID              INTEGER       AUTO_INCREMENT,
  u_username        VARCHAR(150)  UNIQUE NOT NULL,
  u_vorname         VARCHAR(50)   DEFAULT 'N.N.',
  u_nachname        VARCHAR(50)   DEFAULT 'N.N.',
  u_password        VARCHAR(192)  NOT NULL,
  ug_ID             INTEGER,
  CONSTRAINT u_uID_PK PRIMARY KEY (u_ID),
  CONSTRAINT u_ugID_FK FOREIGN KEY (ug_ID) REFERENCES user_group(ug_ID)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE daten(
  d_ID              INTEGER       AUTO_INCREMENT,
  d_daten           LONGBLOB      NOT NULL,
  d_dateiname       VARCHAR(500)  UNIQUE NOT NULL,
  d_datum           DATETIME      DEFAULT current_timestamp,
  k_ID              INTEGER       DEFAULT 1 NOT NULL,
  u_ID              INTEGER       NOT NULL,
  CONSTRAINT d_dID_PK PRIMARY KEY (d_ID),
  CONSTRAINT d_uID_FK FOREIGN KEY (u_ID) REFERENCES user(u_ID),
  CONSTRAINT d_kID FOREIGN KEY(k_ID) REFERENCES kategorie(k_ID)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

-- Erstellt Ansichten(Views)
CREATE VIEW dateninterface AS
SELECT d_ID AS ID, d_Daten AS Datei, d_Datum AS Datum, k_name AS Kategoriename, u_Username AS Username, ug_Name AS Gruppenname FROM daten
  JOIN user ON daten.u_ID = user.u_ID
  JOIN user_group ON user.ug_ID = user_group.ug_ID
  JOIN kategorie ON kategorie.k_ID = daten.k_ID
  ORDER BY ID ASC;

CREATE VIEW userinterface AS
SELECT u_ID AS ID, u_Username AS Username, u_Vorname AS Vorname, u_Nachname AS Nachname, ug_Name AS Gruppenname, ug_Beschreibung As Gruppenbeschreibung FROM dms.USER
  JOIN user_group ON user.ug_ID = user_group.ug_ID
  ORDER BY ID ASC;

---- Einfügen(Insert)
INSERT INTO USER_GROUP(UG_NAME, UG_BESCHREIBUNG) VALUES ('Administrator','Systemverantwortlicher');
INSERT INTO KATEGORIE(K_NAME, K_Beschreibung) VALUES ('nicht Kategorisiert', 'Default Kategorie');
-- Password: Administrator@DMS 
-- Passwordalgorithmus: SHA-512
INSERT INTO USER(u_username, u_password, ug_id) 
VALUES ('admin', '1ba1051b916318d15f1ec14016d10f13e11615416d1181f11dd17815a11711d11110b12017b1d31771f819e1e01671e910a1c113612e1b11671541e712512613611b1081e81f219e17a1cc1b51401d71341c11d710711e15c1a41fc1b6189140', 1);