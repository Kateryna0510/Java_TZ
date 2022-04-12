

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.net.URI;
import java.net.URL;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBC {
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    private static final String URL = "jdbc:mysql://localhost:3306/mysql?useSSL=false";

    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        Driver driver;

        try {
            driver = new FabricMySQLDriver();
        } catch (SQLException ex) {
            System.out.println("Error during driver creation");
            return;
        }

        try {
            DriverManager.registerDriver(driver);
        } catch (SQLException ex) {
            System.out.println("Registration was unsuccessful");
            return;
        }
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("code...");
        } catch (SQLException ex) {
            System.out.println("Connection was unsuccessful");
            return;
        }
        finally {
            if (connection != null)
                connection.close();
        }
    }
}
