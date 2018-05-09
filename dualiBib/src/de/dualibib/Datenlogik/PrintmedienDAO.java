/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dualibib.Datenlogik;

import de.dualibib.Fachlogik.Medienverwaltung.Printmedien;
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
public class PrintmedienDAO implements IPrintmedienDAO{

    Database db = new Database();
    private final Connection con = db.connect_mysql();
    private final ResultSet rs = db.getResult_mysql(con, "");
    

    @Override
    public List<Printmedien> laden() throws IOException {
        ArrayList<Printmedien> ret = new ArrayList<>();
        try {
            int columnCount = db.getMetaData(rs).getColumnCount();
            while (rs.next()) {
                int i = 1;
                while (i <= columnCount) {
                    ret.add(new Printmedien());
                }
            }
        } catch (SQLException ex) {
            System.err.println("MedienDAO laden: "+ ex);;
        }
        return ret;
        }

    @Override
    public void speichern(List<Printmedien> medienListe) throws IOException {
        //To change body of generated methods, choose Tools | Templates.
    }
    
}
