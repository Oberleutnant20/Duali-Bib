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
import java.util.logging.Level;
import java.util.logging.Logger;

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
                while (rs.next()) {
                    String login = rs.getString("u_login");
                    String passwd = rs.getString("u_passwd");
                    boolean mitarbeiter = rs.getBoolean("u_Mitarbeiter");
                    int id = rs.getInt("u_ID");
                    String vorname = rs.getString("u_Vorname");
                    String nachname = rs.getString("u_Nachname");
                    
                    ret.add(new Account(login,passwd, mitarbeiter, id, vorname, nachname));
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
        for (Account account : accountListe) {
            try {
                PreparedStatement ptsm = con.prepareStatement("INSERT INTO USER(u_Vorname, u_Nachname, u_login, u_Passwd, u_Mitarbeiter, u_Strasse, u_Hausnummer, u_PLZ, u_Ort, u_Anrede) "
                        + "VALUES('"+account.getVorname()+"','"+account.getNachname()+"','"+account.getUsername()+"','"+account.getPasswort()+"')");
                ptsm.execute();
            } catch (SQLException ex) {
                Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
            }            
        }
        
    }

}
