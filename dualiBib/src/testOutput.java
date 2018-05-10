
import de.dualibib.Datenlogik.Database;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    public static void main(String[] args) {
        Database db = new Database();
        Connection con = db.connect_mysql_schema();
        ResultSet rs = db.getResult_mysql(con, "user");
        try {
            while(rs!=null){
                System.out.println("ID 1: "+rs.getString("u_Username"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(testOutput.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
