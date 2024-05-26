import javax.swing.*;
import java.sql.*;

public class DummyClass extends JFrame {
    private JTextArea textArea;

    public DummyClass()  {

        Connection conn = null;
        PreparedStatement pstmt = null, pstmt1 = null;
        ResultSet rs = null;

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-GLB9ET7;databaseName=Bus_Management;encrypt=true;trustServerCertificate=true", "sa", "12345");

            String insertQuery = "INSERT INTO dummy1 (Name) VALUES ( ?)";
            pstmt = conn.prepareStatement(insertQuery);
            //pstmt.setInt(1, 1);
            pstmt.setString(1, "Mother");
            pstmt.executeUpdate();
            System.out.println("Data inserted into the database");

            String query = "SELECT * FROM dummy1";
            pstmt = conn.prepareStatement(query);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                int SerialNo = rs.getInt("ID");
                String Name = rs.getString("Name");
                System.out.println(SerialNo+" "+Name);

            }

            System.out.println("Connected to database and retrieved data");



        }
        catch (ClassNotFoundException e)
        {
            throw new RuntimeException(e);
        }
        catch (SQLException e) {
            System.out.println("database not found");
            throw new RuntimeException(e);
        }


    }
  /*  private void fetchDataFromDatabase() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-GLB9ET7;databaseName=Bus_Management;encrypt=true;trustServerCertificate=true", "sa", "12345");

            String query = "SELECT * FROM dummy";
            pstmt = conn.prepareStatement(query);
            rs = pstmt.executeQuery();

            StringBuilder userDetails = new StringBuilder();

            // Display query results in JTextArea
            while (rs.next()) {
                int serialNo = rs.getInt("Num");
                String name = rs.getString("Name");

                userDetails.append("Serial No: ").append(serialNo).append(", Name: ").append(name).append("\n");
            }

            textArea.setText(userDetails.toString()); // Set retrieved data to JTextArea

            System.out.println("Connected to database and retrieved data");

        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

   */
    public static void main(String[] args) {
        DummyClass mn = new DummyClass();
        //mn.setVisible(true);

    }
}
