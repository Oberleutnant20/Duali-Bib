
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Database Class with Connect, Disconnect and Resultset.
 *
 * @author Tim Lorse
 */
public class Database {

    /**
     * Connection for Database HyperSQL(HSQLDB) on Localhost with Login SA.
     *
     * @return Connection if Successful
     */
    public Connection connect_hsqldb() {
        return connect_hsqldb("SA", "");
    }
    
    /**
     * Connection for Database MySQL on Localhost with Login root.
     *
     * @return Connection if Successful
     */
    public Connection connect_mysql(){
        return connect_mysql("root", "");
    }

    /**
     * Connection for Database HyperSQL(HSQLDB) on Localhost without Login User.
     *
     * @param usr Username to Connect with the Database.
     * @param passwd Password to Authentication the User.
     * @return Connection if Successful
     */
    public Connection connect_hsqldb(String usr, String passwd) {
        return connect_hsqldb("jdbc:hsqldb:hsql://localhost/", usr, passwd);
    }
    
    /**
     * Connection for Database MySQL on Localhost without Login User.
     *
     * @param usr Username to Connect with the Database.
     * @param passwd Password to Authentication the User.
     * @return Connection if Successful
     */
    public Connection connect_mysql(String usr, String passwd){
        return connect_mysql("jdbc:mysql://localhost:3306", usr, passwd);
    }

    /**
     * Connection for Database HyperSQL(HSQLDB) without Login User, Password and
     * URL
     *
     * @param url URL to the Database for Example<br>
     * <strong>HSQLDB: </strong>"jdbc:hsqldb:hsql://localhost/"
     * @param usr Username to Connect with the Database.
     * @param passwd Password to Authentication the User.
     * @return Connection if Successful
     */
    public Connection connect_hsqldb(String url, String usr, String passwd) {
        return connect(url, usr, passwd, "org.hsqldb.jdbcDriver");
    }
    
    /**
     * Connection for Database MySQL without Login User, Password and
     * URL
     *
     * @param url URL to the Database for Example<br>
     * <strong>MySQL: </strong>"jdbc:mysql://localhost:3306"
     * @param usr Username to Connect with the Database.
     * @param passwd Password to Authentication the User.
     * @return Connection if Successful
     */
    public Connection connect_mysql(String url, String usr, String passwd){
        return connect(url, usr, passwd, "com.mysql.jdbc.Driver");
    }

    /**
     * Connection without any User, Password or Driver.
     *
     * @param url URL to the Database for Example <br>
     * <strong>HSQLDB: </strong>"jdbc:hsqldb:hsql://localhost/"<br>
     * <strong>MySQL: </strong>"jdbc:mysql://localhost:3306"
     * @param usr Username to Connect with the Database.
     * @param passwd Password to Authentication the User.
     * @param driver Database driver. For Example<br>
     * <strong>HSQLDB: </strong>"org.hsqldb.jdbcDriver"<br>
     * <strong>MySQL: </strong>"com.mysql.jdbc.Driver"
     * @return Connection if Successful
     */
    public Connection connect(String url, String usr, String passwd, String driver) {
        Connection con = null;
        try {
            // Treiber Laden
            Class.forName(driver);

            con = DriverManager.getConnection(url, usr, passwd);
        } catch (ClassNotFoundException cnfe) {
            System.err.println("connect: Database Driver not found: " + cnfe);
        } catch (SQLException ex) {
            System.err.println("connect: " + ex);
        }
        return con;
    }

    /**
     * Disconnect the Database
     * @param con Connection
     * @return True or False
     */
    public boolean disconnect(Connection con) {
        boolean ret = false;
        if (con != null) {
            try {
                if (!con.isClosed()) {
                    con.close();
                    ret = true;
                }
            } catch (SQLException ex) {
                System.err.println("Exception in disconnect: " + ex);
            }
        }
        return ret;
    }

    /**
     * Resultset from a complete Table
     * 
     * @param con Connection
     * @param table Tablename
     * @param attribut Attributname
     * @param value Value
     * @return Result
     */
    public static ResultSet getResut(Connection con, String table, String attribut, String value) {
        ResultSet rs = null;
        try (PreparedStatement ptsm = con.prepareStatement("SELECT * FROM " + table + " WHERE " + attribut + " LIKE " + value)) {
            rs = ptsm.executeQuery();
        } catch (SQLException ex) {
            System.err.println("getResult: " + ex);
        }
        return rs;
    }
}
