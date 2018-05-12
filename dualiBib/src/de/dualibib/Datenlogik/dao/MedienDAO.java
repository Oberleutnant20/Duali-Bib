/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dualibib.Datenlogik.dao;

import de.dualibib.Datenlogik.Database;
import de.dualibib.Fachlogik.Genreverwaltung.Genre;
import de.dualibib.Fachlogik.Kategorieverwaltung.Kategorie;
import de.dualibib.info.exceptions.ConnectionError;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import de.dualibib.Datenlogik.IMedienDAO;
import de.dualibib.Fachlogik.Medienverwaltung.Medien;

/**
 *
 * @author Carina
 */
public class MedienDAO implements IMedienDAO {

    private final Database db = new Database();
    private final Connection con = db.connect_mysql_schema();
    private ResultSet rs = null;
    private ResultSet rs1 = null;
    private ResultSet rs2 = null;

    @Override
    public List<Medien> laden() throws IOException, ConnectionError {
        ArrayList<Medien> ret = new ArrayList<>();
        if (con != null) {
            try {
                PreparedStatement ptsm = con.prepareStatement(db.getResultSQLStatement("medien"));
                PreparedStatement ptsm1 = con.prepareStatement(db.getResultSQLStatement("genre"));
                PreparedStatement ptsm2 = con.prepareStatement(db.getResultSQLStatement("kategorieMedien"));
                rs = ptsm.executeQuery();
                rs1 = ptsm1.executeQuery();
                rs2 = ptsm2.executeQuery();
                while (rs.next()) {
                    String isbn = rs.getString("m_ISBN");
                    long barcode = rs.getLong("m_barcode");
                    String titel = rs.getString("m_Titel");
                    boolean ausgeliehen = rs.getBoolean("m_ausgeliehen");
                    boolean vorgemerkt = rs.getBoolean("m_vorgemerkt");
                    int id = rs.getInt("m_ID");
                    int anzahl = rs.getInt("m_Anzahl");
                    
                    // Fehlerhaft??
                    Genre genre = new Genre(rs1.getString("g_Name"));
                    Kategorie kat = new Kategorie(rs2.getInt("km_id"), rs2.getString("km_name"), rs2.getString("km_beschreibung"));

                    ret.add(new Medien(isbn, barcode, genre, kat, titel, ausgeliehen, vorgemerkt, id, anzahl));
                }
            } catch (SQLException ex) {
                System.err.println("MedienDAO laden: " + ex);
            }
        } else {
            throw new ConnectionError();
        }
        return ret;
    }

    @Override
    public void speichern(List<Medien> medienListe) throws IOException {
        //To change body of generated methods, choose Tools | Templates.
    }

}
