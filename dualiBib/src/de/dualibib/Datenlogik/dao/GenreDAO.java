/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dualibib.Datenlogik.dao;

import de.dualibib.Datenlogik.Database;
import de.dualibib.Datenlogik.dto.GenreDTO;
import de.dualibib.Datenlogik.idao.IGenreDAO;
import de.dualibib.Fachlogik.Genreverwaltung.Genre;
import de.dualibib.info.exceptions.ConnectionError;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Carina
 */
public class GenreDAO extends ElternDAO implements IGenreDAO {

    private final Database db = new Database();
    private final Connection con = db.connect_mysql_schema();
    private ResultSet rs = null;
    GenreDTO dto;

    @Override
    public GenreDTO laden() throws IOException, ConnectionError {
        ArrayList<Genre> ret = new ArrayList<>();
        dto = new GenreDTO();
        if (con != null) {
            try {
                PreparedStatement ptsm = con.prepareStatement(db.getResultSQLStatement("genre"));
                rs = ptsm.executeQuery();
                while (rs.next()) {
                    ret.add(new Genre(rs.getInt(1),rs.getString(2)));
                }
            } catch (SQLException ex) {
                System.err.println("GenreDAO laden: " + ex);
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
            ArrayList<Genre> liste  = dto.get();
            for (Genre genre : liste) {
                try {
                    PreparedStatement ptsm = con.prepareStatement("INSERT INTO Genre(g_Name) "
                            + "VALUES('" + genre.getBezeichnung() + "');");
                    ptsm.execute();
                } catch (SQLException ex) {
                    Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            throw new ConnectionError();
        }
    }

}
