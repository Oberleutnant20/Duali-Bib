/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dualibib.Datenlogik.dao;

import de.dualibib.Datenlogik.dto.AccountDTO;
import de.dualibib.Datenlogik.Database;
import de.dualibib.Datenlogik.idao.IAccountDAO;
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
public class AccountDAO extends ElternDAO implements IAccountDAO {

    private final Database db = new Database();
    private final Connection con = db.connect_mysql_schema();
    private ResultSet rs = null;

    @Override
    public AccountDTO laden() throws IOException, ConnectionError {
        ArrayList<Account> ret = new ArrayList<>();
        AccountDTO accountDTO = new AccountDTO();
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
                    String strasse = rs.getString("u_Strasse");
                    String hausnummer = rs.getString("u_Hausnummer");
                    int plz = rs.getInt("u_PLZ");
                    String ort = rs.getString("u_ort");
                    String anrede = rs.getString("u_anrede");

                    ret.add(new Account(login, passwd, mitarbeiter, id, vorname, nachname, plz, strasse, hausnummer, ort));
                    
                }
            } catch (SQLException ex) {
                System.err.println("AccountDAO laden: " + ex);
            }
        } else {
            throw new ConnectionError();
        }
        accountDTO.setList(ret);
        return accountDTO;
    }

    @Override
    public void speichern(List<Account> accountListe) throws IOException, ConnectionError {
        if (con != null) {            
            for (Account account : accountListe) {
                try {
                    PreparedStatement ptsm = con.prepareStatement("INSERT INTO USER(u_Vorname, u_Nachname, u_login, u_Passwd, u_Mitarbeiter, u_Strasse, u_Hausnummer, u_PLZ, u_Ort) "
                            + "VALUES('" + account.getVorname() + "','" + account.getNachname() + "','" + account.getUsername() + "','" + account.getPasswort() + "', " + account.isMitarbeiter() + ", '" + account.getStrasse() + "', '" + account.getHausnummer() + "', " + account.getPlz() + ", '" + account.getOrt() + "');");
                    //System.out.println("INSERT INTO USER(u_Vorname, u_Nachname, u_login, u_Passwd, u_Mitarbeiter, u_Strasse, u_Hausnummer, u_PLZ, u_Ort) "
                    //        + "VALUES('" + account.getVorname() + "','" + account.getNachname() + "','" + account.getUsername() + "','" + account.getPasswort() + "', " + account.isMitarbeiter() + ", '" + account.getStrasse() + "', '" + account.getHausnummer() + "', " + account.getPlz() + ", '" + account.getOrt() + "');");
                    ptsm.execute();
                } catch (SQLException ex) {
                    Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            throw new ConnectionError();
        }
    }

    @Override
    public void update(List<Account> accountListe) throws IOException, ConnectionError {
        if(con != null){
            for (Account account : accountListe) {
                try {
                    String vorname = account.getVorname();
                    String nachname = account.getNachname();
                    String username = account.getUsername();
                    String passwd = account.getPasswort();
                    String str = account.getStrasse();
                    String hausnr = account.getHausnummer();
                    int plz = account.getPlz();
                    int id = account.getUserid();
                    String ort = account.getOrt();                    
                    boolean mitarbeiter = account.isMitarbeiter();
                    PreparedStatement ptsm = con .prepareStatement("UPDATE USER SET u_Vorname = '"+vorname+"', u_Nachname = '"+nachname+"', u_login = '"+username+"', u_passwd = '"+passwd+"', u_Mitarbeiter ="+mitarbeiter+", u_Strasse = '"+str+"', u_Hausnummer = '"+hausnr+"', u_PLZ = "+plz+", u_Ort = '"+ort+"' WHERE u_ID LIKE "+id+";");
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
