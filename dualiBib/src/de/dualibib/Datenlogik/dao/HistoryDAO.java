/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dualibib.Datenlogik.dao;

import de.dualibib.Datenlogik.Database;
import de.dualibib.Datenlogik.IHistoryDAO;
import de.dualibib.Fachlogik.Accountverwaltung.Account;
import de.dualibib.Fachlogik.Historyverwaltung.History;
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
public class HistoryDAO implements IHistoryDAO {

    private final Database db = new Database();
    private final Connection con = db.connect_mysql_schema();
    private ResultSet rs = null;

    @Override
    public List<History> laden() throws IOException, ConnectionError {
        ArrayList<History> ret = new ArrayList<>();
        if (con != null) {
            try {
                PreparedStatement ptsm = con.prepareStatement(db.getResultSQLStatement("History"));
                rs = ptsm.executeQuery();
                int columnCount = db.getMetaData(rs).getColumnCount();
                while (rs.next()) {
                        ret.add(new History(rs.getLong(1), rs.getInt(2), rs.getInt(3),rs.getInt(4)));
                }
            } catch (SQLException ex) {
                System.err.println("HistoryDAO laden: " + ex);
            }
        } else {
            throw new ConnectionError();
        }
        return ret;
    }

    @Override
    public void speichern(List<History> historyListe) throws IOException {
        if (con != null) {
            for (History history : historyListe) {
                try {
                    history.getKategorieid();
                    history.getMedienid();
                    history.getUserid();
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
