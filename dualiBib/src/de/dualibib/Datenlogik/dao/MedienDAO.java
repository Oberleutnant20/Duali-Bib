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
public class MedienDAO implements IMedienDAO{

    private final Database db = new Database();
    private final Connection con = db.connect_mysql();
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
                    ret.add(new Medien(rs.getString(4), rs.getLong(5), new Genre(rs1.getString(2)), new Kategorie(rs2.getLong(1), rs2.getString(2), rs2.getString(1)), rs.getString(2), true, true, rs.getLong(1),1));
            }
        } catch (SQLException ex) {
            System.err.println("MedienDAO laden: "+ ex);
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
