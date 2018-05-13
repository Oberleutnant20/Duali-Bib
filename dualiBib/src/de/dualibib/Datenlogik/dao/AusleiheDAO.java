/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dualibib.Datenlogik.dao;

import de.dualibib.Datenlogik.Database;
import de.dualibib.Datenlogik.IAusleiheDAO;
import de.dualibib.Fachlogik.Accountverwaltung.Account;
import de.dualibib.Fachlogik.Ausleihverwaltung.Ausleihe;
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
public class AusleiheDAO implements IAusleiheDAO {

    private final Database db = new Database();
    private final Connection con = db.connect_mysql_schema();
    private ResultSet rs = null;

    @Override
    public List<Ausleihe> laden() throws IOException, ConnectionError {
        ArrayList<Ausleihe> ret = new ArrayList<>();
        if (con != null) {
            try {
                PreparedStatement ptsm = con.prepareStatement(db.getResultSQLStatement("Ausleihe"));
                rs = ptsm.executeQuery();
                while (rs.next()) {
                    ret.add(new Ausleihe(rs.getLong(1), rs.getLong(3), rs.getDate(2), rs.getInt(4), rs.getInt(5)));
                }
            } catch (SQLException ex) {
                System.err.println("AusleiheDAO laden: " + ex);
            }
        } else {
            throw new ConnectionError();
        }
        return ret;
    }

    @Override
    public void speichern(List<Ausleihe> ausleiheListe) throws IOException {
        if (con != null) {
            for (Ausleihe ausleihe : ausleiheListe) {
                try {
                    ausleihe.getKategorieid();
                    ausleihe.getMedienid();
                    ausleihe.getUserid();
                    ausleihe.getDate();
                    PreparedStatement ptsm = con.prepareStatement("INSERT INTO USER(u_Vorname, u_Nachname, u_login, u_Passwd, u_Mitarbeiter, u_Strasse, u_Hausnummer, u_PLZ, u_Ort) "
                            + "VALUES('" + account.getVorname() + "','" + account.getNachname() + "','" + account.getUsername() + "','" + account.getPasswort() + "', " + account.isMitarbeiter() + ", '" + account.getStrasse() + "', '" + account.getHausnummer() + "', " + account.getPlz() + ", '" + account.getOrt() + "');");
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
