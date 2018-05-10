/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dualibib.Datenlogik.dao;

import de.dualibib.Datenlogik.Database;
import de.dualibib.Datenlogik.IGenreDAO;
import de.dualibib.Fachlogik.Genreverwaltung.Genre;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Carina
 */
public class GenreDAO implements IGenreDAO{

    private final Database db = new Database();
    private final Connection con = db.connect_mysql();
    private final ResultSet rs = db.getResult_mysql(con, "");
    

    @Override
    public List<Genre> laden() throws IOException {
        ArrayList<Genre> ret = new ArrayList<>();
        try {
            int columnCount = db.getMetaData(rs).getColumnCount();
            while (rs.next()) {
                int i = 1;
                while (i <= columnCount) {
                    ret.add(new Genre(bezeichnung));
                }
            }
        } catch (SQLException ex) {
            System.err.println("GenreDAO laden: "+ ex);
        }
        return ret;
    }
    
    @Override
    public void speichern(List<Genre> genreListe) throws IOException {
        //To change body of generated methods, choose Tools | Templates.
    }
    
}
