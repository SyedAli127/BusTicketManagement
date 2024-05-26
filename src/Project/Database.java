package Project;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class Database {
    public static Connection setConnection() {
        Connection conn = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Bus_Management;encrypt=true;trustServerCertificate=true", "sa", "12345");
            conn = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-GLB9ET7;databaseName=Bus_Management;encrypt=true;trustServerCertificate=true", "sa", "12345");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Failed to connect to the database. Error: " + e.getMessage());        }
        return conn;
    }
}
