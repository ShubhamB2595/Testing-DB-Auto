import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MainTest extends DBConnection {

    // Declaration
    public static int count;

    // Method for reading all data from DB Table
    @Test
    public void readTableData() {

        try {
            // Query declaration
            String sqlQuery = "SELECT * FROM user";
            // Get connection and create statement of BD
            connection = this.getConnection();
            Statement statement = connection.createStatement();
            // Get the contents of user table from DB
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            // Print the result until all the records are printed
            while(resultSet.next()) {
                count += 1;
                int id = resultSet.getInt("uid");
                String name = resultSet.getString("uname");
                String email = resultSet.getString("uemail");
                System.out.println(count + " : " + id + " | " + name + " | " + email);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method for inserting data into DB Table
    @Test
    public void insertTableData() {
        // Get connection and create statement of BD
        String query = "INSERT INTO user VALUES(103, 'samarth', 'samarth@gmail.com')";
        try {
            // Get connection and create statement of BD
            connection = this.getConnection();
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            System.out.println("Done, data inserted into table");

            readTableData();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method for updating data of DB Table
    @Test
    public void updateTableData() {
        // Get connection and create statement of BD
        String query = "UPDATE user SET uemail = 'shubhamb@gmail.com' WHERE uid = 100";
        try {
            // Get connection and create statement of BD
            connection = this.getConnection();
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            System.out.println("Done, data updated into table");

            readTableData();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method for deleting data from DB Table
    @Test
    public void deleteTableData() {
        // Get connection and create statement of BD
        String query = "DELETE FROM user WHERE uid = 103";
        try {
            // Get connection and create statement of BD
            connection = this.getConnection();
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            System.out.println("Done, data deleted from table");

            readTableData();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
