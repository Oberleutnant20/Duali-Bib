
import de.dualibib.Datenlogik.Database;
import de.dualibib.Fachlogik.Accountverwaltung.Account;
import de.dualibib.info.exceptions.ConnectionError;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Administrator
 */
public class testOutput {

    public static void main(String[] args) throws ConnectionError {
        Database db = new Database();
        Connection con = db.connect_mysql_schema();
        ResultSet rs = null;
        ArrayList<Account> ret = new ArrayList<>();
        if (con != null) {            
            try {
                PreparedStatement ptsm = con.prepareStatement(db.getResultSQLStatement("user"));
                rs = ptsm.executeQuery();
                int columnCount = db.getMetaData(rs).getColumnCount();
                while (rs.next()) {
                    int i = 1;
                    while (i <= columnCount) {
                        ret.add(new Account(rs.getString(4), rs.getString(5), rs.getBoolean(6), rs.getInt(1), rs.getString(2), rs.getString(3)));
                    }
                }
            } catch (SQLException ex) {
                System.err.println("AccountDAO laden: " + ex);
            }
        } else {
            throw new ConnectionError();
        }
        for (Account account : ret) {
            System.out.println(account);
        }
    }

}
