/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dualibib.Datenlogik.dao;

import de.dualibib.Datenlogik.Database;
import de.dualibib.Datenlogik.IAccountDAO;
import de.dualibib.Fachlogik.Accountverwaltung.Account;
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
public class AccountDAO implements IAccountDAO {

    Database db = new Database();
    private final Connection con = db.connect_mysql_schema();
    private ResultSet rs = null;

    @Override
    public List<Account> laden() throws IOException, ConnectionError {
        ArrayList<Account> ret = new ArrayList<>();
        if (con != null) {            
            try {
                PreparedStatement ptsm = con.prepareStatement(db.getResultSQLStatement("user"));
                rs = ptsm.executeQuery();
                int columnCount = db.getMetaData(rs).getColumnCount();
                while (rs.next()) {
                    int i = 1;
                    while (i <= columnCount) {
                        ret.add(new Account(rs.getString("u_login"), rs.getString("u_passwd"), rs.getBoolean("u_Mitarbeiter"), rs.getInt("u_ID"), rs.getString("u_Vorname"), rs.getString("u_Nachname")));
                    }
                }
            } catch (SQLException ex) {
                System.err.println("AccountDAO laden: " + ex);
            }
        } else {
            throw new ConnectionError();
        }
        return ret;
    }

    @Override
    public void speichern(List<Account> accountListe) throws IOException {
        //To change body of generated methods, choose Tools | Templates.
    }

}
