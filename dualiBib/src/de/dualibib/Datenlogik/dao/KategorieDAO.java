/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dualibib.Datenlogik.dao;

import de.dualibib.Datenlogik.Database;
import de.dualibib.Datenlogik.IKategorieDAO;
import de.dualibib.Fachlogik.Kategorieverwaltung.Kategorie;
import de.dualibib.info.exceptions.ConnectionError;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Carina
 */
public class KategorieDAO implements IKategorieDAO {

    private final Database db = new Database();
    private final Connection con = db.connect_mysql_schema();
    private ResultSet rs = null;

    @Override
    public List<Kategorie> laden() throws IOException, ConnectionError {
        ArrayList<Kategorie> ret = new ArrayList<>();
        if (con != null) {
            try {
                PreparedStatement ptsm = con.prepareStatement(db.getResultSQLStatement("kategorieMedien"));
                rs = ptsm.executeQuery();
                int columnCount = db.getMetaData(rs).getColumnCount();
                while (rs.next()) {
                    int i = 1;
                    while (i <= columnCount) {
                        ret.add(new Kategorie(rs.getString(2)));
                    }
                }
            } catch (SQLException ex) {
                System.err.println("KategorieDAO laden: " + ex);
            }
        } else {
            throw new ConnectionError();
        }
        return ret;
    }

    @Override
    public void speichern(List<Kategorie> kategorieListe) throws IOException {
        //To change body of generated methods, choose Tools | Templates.
    }

}