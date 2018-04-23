
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Tim Lorse
 */
public class insertDefaultAdmin {
    public static void main(String[] args){
        try {
            System.out.println("OLD: 1f91db1eb1781471c712d1001a21971a01611ab1431601491881da1ed19111c12213e1df1241111ad1f014b1b214c1de1041f61ca1681371621c710318719612113213a1b81cc11a1ea10e1841c11d11c01851d21571a412a14111a13718d1e6");
            System.out.println("NEW: "+new Password().getSHA512("!Administrator@dualibib"));
//        Database db = new Database();
//        Connection con = db.connect_hsqldb();
//        String sql = null;
//        try {
//            sql = "INSERT INTO dualibib.user(U_VORNAME, U_Nachname, u_login, U_PASSWORD, u_mitarbeiter) VALUES ('Admin','Min','admin001','"+new Password().getSHA512("!Administrator@dualibib")+"', true)";
//        } catch (NoSuchAlgorithmException ex) {
//            Logger.getLogger(insertDefaultAdmin.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (UnsupportedEncodingException ex) {
//            Logger.getLogger(insertDefaultAdmin.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        PreparedStatement pstm = con.prepareStatement(sql);
//        System.out.println(pstm.executeUpdate());
//        con.close();
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(insertDefaultAdmin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(insertDefaultAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
