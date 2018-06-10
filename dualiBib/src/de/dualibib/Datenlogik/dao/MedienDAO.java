/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dualibib.Datenlogik.dao;

import de.dualibib.Datenlogik.Database;
import de.dualibib.Datenlogik.dto.GenreDTO;
import de.dualibib.Datenlogik.dto.KategorieDTO;
import de.dualibib.Datenlogik.dto.MedienDTO;
import de.dualibib.Fachlogik.Genreverwaltung.Genre;
import de.dualibib.info.exceptions.ConnectionError;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import de.dualibib.Datenlogik.idao.IMedienDAO;
import de.dualibib.Fachlogik.Kategorieverwaltung.Kategorie;
import de.dualibib.Fachlogik.Medienverwaltung.Medien;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Carina
 */
public class MedienDAO extends ElternDAO implements IMedienDAO {

    private final Database db = new Database();
    private final Connection con = db.connect_mysql_schema();
    private ResultSet rs = null;
    private ResultSet rs1 = null;
    private ResultSet rs2 = null;
    GenreDAO gen = new GenreDAO();
    KategorieDAO kat = new KategorieDAO();
    MedienDTO dto;

    @Override
    public MedienDTO laden() throws IOException, ConnectionError {
        ArrayList<Medien> ret = new ArrayList<>();
        dto = new MedienDTO();
        if (con != null) {
            try {
                PreparedStatement ptsm = con.prepareStatement(db.getResultSQLStatement("medien"));
                rs = ptsm.executeQuery();
                GenreDTO genreListe = gen.laden();
                KategorieDTO kategorieListe = kat.laden();
                while (rs.next()) {
                    String isbn = rs.getString("m_ISBN");
                    long barcode = rs.getLong("m_barcode");
                    String titel = rs.getString("m_Titel");
                    boolean ausgeliehen = rs.getBoolean("m_ausgeliehen");
                    boolean vorgemerkt = rs.getBoolean("m_vorgemerkt");
                    int id = rs.getInt("m_ID");
                    int anzahl = rs.getInt("m_Anzahl");
                    int kmid = rs.getInt("km_ID");
                    int gid = rs.getInt("g_ID");
                    String author = rs.getString("m_Author");
                    String desc = rs.getString("m_Beschreibung");

                    Genre genre = matchGenre(genreListe, gid);
                    Kategorie kat = matchKategorie(kategorieListe, kmid);

                    ret.add(new Medien(isbn, barcode, genre, kat, titel, ausgeliehen, vorgemerkt, id, anzahl, author, desc));
                }
            } catch (SQLException ex) {
                System.err.println("MedienDAO laden: " + ex);
            }
        } else {
            throw new ConnectionError();
        }
        dto.set(ret);
        return dto;
    }

    @Override
    public void speichern() throws IOException, ConnectionError {
        if (con != null) {
            ArrayList<Medien> liste  = dto.get();
            for (Medien medien : liste) {
                try {

                    PreparedStatement ptsm = con.prepareStatement("INSERT INTO Medien(m_Titel, m_Author, m_ISBN, m_Barcode, m_ausgeliehen, m_Vorgemerkt, m_Anzahl, m_beschreibung, km_ID, g_ID) "
                            + "VALUES('" + medien.getName() + "','" + medien.getAuthor() + "','" + medien.getIsbn() + "'," + medien.getBarcodenummer() + ", " + medien.getVerfuegbare() + ", " + medien.getAnzahl() + ", '" + medien.getDesc() + "', " + medien.getKategorien().getId() + ", " + medien.getGenre().getId() + ");");
                    ptsm.execute();
                } catch (SQLException ex) {
                    Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            throw new ConnectionError();
        }
    }

    private Genre matchGenre(GenreDTO genreListe, int gid) {
        for (int i = 0; i < genreListe.size(); i++) {
            if (genreListe.get(i).getId() == gid) {
                return genreListe.get(i);
            }
        }
        return null;
    }

    private Kategorie matchKategorie(KategorieDTO kategorieListe, int kmid) {
        for (int i = 0; i < kategorieListe.size(); i++) {
            if (kategorieListe.get(i).getId() == kmid) {
                return kategorieListe.get(i);
            }
        }
        return null;
    }

    @Override
    public void update() throws IOException, ConnectionError {
        if (con != null) {
            ArrayList<Medien> liste  = dto.get();
            for (Medien medien : liste) {
                try {
                    String name = medien.getName();
                    String ISBN = medien.getIsbn();
                    long barcode = medien.getBarcodenummer();
                    int anzahl = medien.getAnzahl();
                    String author = medien.getAuthor();
                    String desc = medien.getDesc();
                    int gID = medien.getGenre().getId();
                    long mID = medien.getId();
                    long kID = medien.getKategorien().getId();
                    boolean ausgeliehen = medien.isAusgeliehen();
                    boolean vorgemerkt = medien.isVorgemerkt();
                    PreparedStatement ptsm = con.prepareStatement("UPDATE Medien SET m_Titel = '" + name + "', m_Author = '" + author + "', m_ISBN = '" + ISBN + "', m_Barcode =" + barcode + ", m_ausgeliehen = " + ausgeliehen + ", m_Vorgemerkt = " + vorgemerkt + ", m_Anzahl = " + anzahl + ", m_beschreibung = '" + desc + "', km_ID = " + kID + ", g_ID = " + gID + " WHERE m_ID LIKE " + mID + ";");
                    ptsm.execute();
                } catch (SQLException ex) {
                    Logger.getLogger(MedienDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            throw new ConnectionError();
        }
    }

}
