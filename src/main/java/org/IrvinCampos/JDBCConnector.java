package org.IrvinCampos;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class JDBCConnector {
    public static void main(String[] args) {
        Properties props = new Properties();
        Connection conn = null;

        try (FileInputStream fis = new FileInputStream("C://Users//Irvin//Desktop//JDBC//src//main//resources//config.properties")) {
            // Load the properties file
            props.load(fis);

            // Get the property values
            String driver = props.getProperty("driver");
            String url = props.getProperty("url");
            String username = props.getProperty("username");
            String password = props.getProperty("password");

            // Load the MySQL JDBC driver
            Class.forName(driver);

            // Establish the connection
            conn = DriverManager.getConnection(url, username, password);

            if (conn != null) {
                System.out.println("Connection established successfully!");

                // Create a statement object to perform a query
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM Employeeinfo");

                // Iterate through the result set and print the results
                while (resultSet.next()) {
                    System.out.println("Name: " + resultSet.getString("name"));
                    System.out.println("Age: " + resultSet.getInt("age"));
                }

                // Close the statement and result set
                resultSet.close();
                statement.close();
            } else {
                System.out.println("Failed to establish connection!");
            }

        } catch (IOException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // Ensure the connection is closed even if an exception is thrown
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
