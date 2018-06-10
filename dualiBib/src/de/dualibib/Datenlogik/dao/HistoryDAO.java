/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dualibib.Datenlogik.dao;

import de.dualibib.Datenlogik.Database;
import de.dualibib.Datenlogik.dto.HistoryDTO;
import de.dualibib.Datenlogik.idao.IHistoryDAO;
import de.dualibib.Fachlogik.Historyverwaltung.History;
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
public class HistoryDAO extends ElternDAO implements IHistoryDAO {

    private final Database db = new Database();
    private final Connection con = db.connect_mysql_schema();
    private ResultSet rs = null;
    HistoryDTO dto;

    @Override
    public HistoryDTO laden() throws IOException, ConnectionError {
        ArrayList<History> ret = new ArrayList<>();
        dto = new HistoryDTO();
        if (con != null) {
            try {
                PreparedStatement ptsm = con.prepareStatement(db.getResultSQLStatement("History"));
                rs = ptsm.executeQuery();
                int columnCount = db.getMetaData(rs).getColumnCount();
                while (rs.next()) {
                    ret.add(new History(rs.getLong(1), rs.getInt(2), rs.getInt(3), rs.getInt(4)));
                }
            } catch (SQLException ex) {
                System.err.println("HistoryDAO laden: " + ex);
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
            ArrayList<History> liste  = dto.get();
            for (History history : liste) {
                try {
                    history.getKategorieid();
                    history.getMedienid();
                    history.getUserid();
                    PreparedStatement ptsm = con.prepareStatement("INSERT INTO History(u_ID, km_ID, m_ID) "
                            + "VALUES(" + history.getUserid() + ", " + history.getKategorieid() + ", " + history.getMedienid() + ");");
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
