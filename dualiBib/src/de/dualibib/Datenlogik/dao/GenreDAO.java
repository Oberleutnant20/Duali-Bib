/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dualibib.Datenlogik.dao;

import de.dualibib.Datenlogik.Database;
import de.dualibib.Datenlogik.IGenreDAO;
import de.dualibib.Fachlogik.Genreverwaltung.Genre;
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
public class GenreDAO implements IGenreDAO {

    private final Database db = new Database();
    private final Connection con = db.connect_mysql_schema();
    private ResultSet rs = null;

    @Override
    public List<Genre> laden() throws IOException, ConnectionError {
        ArrayList<Genre> ret = new ArrayList<>();
        if (con != null) {
            try {
                PreparedStatement ptsm = con.prepareStatement(db.getResultSQLStatement("genre"));
                rs = ptsm.executeQuery();
                while (rs.next()) {
                        ret.add(new Genre(rs.getString(2)));
                }
            } catch (SQLException ex) {
                System.err.println("GenreDAO laden: " + ex);
            }
        } else {
            throw new ConnectionError();
        }
        return ret;
    }

    @Override
    public void speichern(List<Genre> genreListe) throws IOException {
        //To change body of generated methods, choose Tools | Templates.
    }

}
