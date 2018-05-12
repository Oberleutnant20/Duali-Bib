/**
 * Author:  Thomas Jäger
 * Created: 17.04.2018
 * Last Change: 12.05.2018
 */

-- Löscht das Datenbankschema(Database), wenn es existiert
DROP SCHEMA IF EXISTS dualibib;
-- Erstellt das Datenbankschema(Database), wenn es nicht existiert
CREATE SCHEMA IF NOT EXISTS dualibib;
-- Nutzt das erstellte Datenbankchema
USE dualibib;
-- Löscht Tabellen(Table), wenn diese existiert, auch wenn diese zusammenhängen
DROP TABLE IF EXISTS history;
DROP TABLE IF EXISTS Ausleihe;
DROP TABLE IF EXISTS Medien;
DROP TABLE IF EXISTS Printmedien;
DROP TABLE IF EXISTS andereMedien;
DROP TABLE IF EXISTS Genre;
DROP TABLE IF EXISTS KategorieMedien;
DROP TABLE IF EXISTS User;

-- Erstelle Tabellen(Table)
-- Tebellen ohne Fremdschlüssel
CREATE TABLE User(
u_ID            INTEGER AUTO_INCREMENT,
u_Vorname       VARCHAR(150),
u_Nachname      VARCHAR(150),
u_login         VARCHAR(8) UNIQUE,
u_passwd        VARCHAR(192),
u_Mitarbeiter   BOOLEAN DEFAULT false,
u_Strasse       VARCHAR(50),
U_Hausnummer    VARCHAR(50),
u_PLZ           INTEGER,
u_Ort           VARCHAR(25),
u_Anrede        VARCHAR(4) DEFAULT 'N.N.',
--CONSTRAINT u_AnredeCK CHECK(u_Anrede IN ('Herr', 'Frau')),
CONSTRAINT u_uID_PK PRIMARY KEY (u_ID)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE Genre(
g_ID            INTEGER AUTO_INCREMENT,
g_Name          VARCHAR(150) UNIQUE,
CONSTRAINT g_gID_PK PRIMARY KEY (g_ID)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE KategorieMedien(
km_ID           INTEGER AUTO_INCREMENT,
km_name         VARCHAR(150) UNIQUE,
km_beschreibung VARCHAR(500),
CONSTRAINT km_kmID_PK PRIMARY KEY (km_ID)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

-- Fremdschlüssel Tabellen
CREATE TABLE Medien(
m_ID BIGINT AUTO_INCREMENT,
m_Titel VARCHAR(150),
m_Author VARCHAR(150),
m_ISBN VARCHAR(24) UNIQUE,
m_Barcode BIGINT UNIQUE,
m_ausgeliehen   BOOLEAN DEFAULT FALSE,
m_Vorgemerkt    BOOLEAN DEFAULT FALSE,
m_Anzahl        INTEGER,
m_beschreibung  VARCHAR(500),
km_ID INTEGER,
g_ID INTEGER,
CONSTRAINT m_mID_PK PRIMARY KEY (m_ID),
CONSTRAINT m_kmID_FK FOREIGN KEY (km_ID) REFERENCES KategorieMedien(km_ID),
CONSTRAINT m_gID_FK FOREIGN KEY (g_ID) REFERENCES Genre(g_ID)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE Ausleihe(
a_ID BIGINT AUTO_INCREMENT,
a_DATE DATE,
u_ID INTEGER,
m_id BIGINT,
km_id   INTEGER,
CONSTRAINT a_aID_PK PRIMARY KEY (a_ID),
CONSTRAINT a_uID_FK FOREIGN KEY (u_ID) REFERENCES User(u_ID),
CONSTRAINT a_mID_FK FOREIGN KEY (m_ID) REFERENCES Medien(m_ID),
CONSTRAINT a_kmID_FK FOREIGN KEY (km_ID) REFERENCES KategorieMedien(km_ID)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE History(
h_ID BIGINT AUTO_INCREMENT,
u_ID INTEGER,
km_ID INTEGER,
m_ID BIGINT,
CONSTRAINT h_hID_PK PRIMARY KEY (h_ID),
CONSTRAINT h_uID_FK FOREIGN KEY (u_ID) REFERENCES User(u_ID),
CONSTRAINT h_kmID_FK FOREIGN KEY (km_ID) REFERENCES KategorieMedien(km_ID),
CONSTRAINT h_mID_FK FOREIGN KEY(m_ID) REFERENCES Medien(m_ID)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

---- Einfügen(Insert)
-- Password: !Administrator@dualibib
-- Passwordalgorithmus: SHA-512
--DEfault Inserts
INSERT INTO User(u_Vorname, u_Nachname, u_Login, u_passwd, u_mitarbeiter,u_Strasse, u_Hausnummer, u_PLZ, u_Ort)
VALUES ('Admin', 'Min', 'admin001', '1f91db1eb1781471c712d1001a21971a01611ab1431601491881da1ed19111c12213e1df1241111ad1f014b1b214c1de1041f61ca1681371621c710318719612113213a1b81cc11a1ea10e1841c11d11c01851d21571a412a14111a13718d1e6', true, 'TestStr.', 1, 12345, 'Testort');
-- Testinserts
INSERT INTO User(u_Vorname, u_Nachname, u_Login, u_passwd, u_mitarbeiter, u_Strasse, u_Hausnummer, u_PLZ, u_Ort)
VALUES ('vor', 'nach', 'user', 'pw', true,'Testweg', 12, 22554, 'Testdorf');
INSERT INTO Genre(g_name) VALUES ('Test');
INSERT INTO Genre(g_Name) VALUES ('Test1');
INSERT INTO KategorieMedien(km_name, km_beschreibung) VALUES ('Test1', 'Ein einfacher Test');
INSERT INTO KategorieMedien(km_name, km_beschreibung) VALUES ('Test2', 'Ein einfacher Test1');
INSERT INTO Medien(m_Titel, m_Author, m_ISBN, m_Barcode, m_Anzahl, m_beschreibung, km_id, g_id) 
VALUES('Datenbanken-Implementierungste', 'Andreas Heuer', '978-3826691560', 9783826691560, 1, 'Dieses Buch behandelt Konzepte und Techniken der Implementierung von Datenbanksystemen, die heutzutage die Kernkomponente von Informationssystemen darstellen.', 1, 1);
INSERT INTO Medien(m_Titel, m_Author, m_ISBN, m_Barcode, m_Anzahl, m_beschreibung, km_id, g_id) 
VALUES('BLub Buch', 'Test Author', '978-3826691561', 9783826691561, 2,'blub', 2, 2);


