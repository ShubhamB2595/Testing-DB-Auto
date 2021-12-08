import org.testng.annotations.BeforeTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    // Declaration
    public static Connection connection;

    // Method to connect with DB
    @BeforeTest
    public Connection getConnection() throws SQLException {

        // update the DB name and possword
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/spotifydb", "root", "");
        System.out.println("Connection to the DB successfully..! " + connection);
        return connection;
    }
}
