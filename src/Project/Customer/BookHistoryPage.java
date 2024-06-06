package Project.Customer;

import Project.Database;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookHistoryPage extends JFrame {
    String cusID;
    Connection connection= Database.setConnection();
    DefaultTableModel tableModel;
    JTable recTable;

    public BookHistoryPage(String cusID){
        this.cusID = cusID;
        if(cusID.equals("")||cusID.equals("Dummy"))
        {
            JOptionPane.showMessageDialog(null, "First Sign In", "Error", JOptionPane.ERROR_MESSAGE);
            CustomerMenu cm=new CustomerMenu("Dummy");
            dispose();
        }
        else {
            JLabel label = new JLabel();
            label.setText("Booking History");
            label.setBounds(220, 20, 180, 35);
            label.setFont(new Font("Ariel", Font.BOLD, 22));
            label.setForeground(Color.orange);

            JLabel orderIDLabel = new JLabel();
            orderIDLabel.setText("Enter Order ID:");
            orderIDLabel.setBounds(50, 90, 180, 35);
            orderIDLabel.setFont(new Font("Ariel", Font.BOLD, 22));
            orderIDLabel.setForeground(Color.orange);

            JTextField orderIDTxt = new JTextField();
            orderIDTxt.setBounds(230, 95, 180, 30);

            JButton searchButton = new JButton();
            searchButton.setText("Search");
            searchButton.setBackground(Color.cyan);
            searchButton.setBounds(280, 150, 110, 40);
            searchButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String order=orderIDTxt.getText();
                    boolean found=false;
                    String query = "select OrderID,OrderDate,OrderDetails,TotalPrice from OrdersDummy  where CusID=? and OrderID=?";
                    try {
                        PreparedStatement psmt = connection.prepareStatement(query);
                        psmt.setInt(1, Integer.parseInt(cusID));
                        psmt.setInt(2, Integer.parseInt(order));
                        ResultSet rs = psmt.executeQuery();
                        while (rs.next()) {
                            tableModel.setRowCount(0);

                            int orderID = rs.getInt("OrderID");
                            String orderDate = rs.getString("OrderDate");
                            String orderDetails = rs.getString("OrderDetails");
                            int rowSize=6*orderDetails.length();
                            recTable.getColumnModel().getColumn(2).setPreferredWidth(rowSize);
                            float totalPrice = rs.getFloat("TotalPrice");

                            String[] row = {Integer.toString(orderID), orderDate, orderDetails, Float.toString(totalPrice)};
                            tableModel.addRow(row);
                        }

                    }
                    catch (SQLException ex)
                    {
                        throw new RuntimeException(ex);
                    }
                }
            });

            JPanel tabPanel = new JPanel();
            tabPanel.setBounds(50, 210, 500, 300);
            tabPanel.setLayout(null);

            String[] column = {"Order ID", "Order Date", "Order Details", "Total Price"};

            tableModel = new DefaultTableModel(column, 0);
            recTable = new JTable(tableModel);
            recTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            recTable.getColumnModel().getColumn(0).setPreferredWidth(100);
            recTable.getColumnModel().getColumn(1).setPreferredWidth(120);
            recTable.getColumnModel().getColumn(2).setPreferredWidth(157);
            recTable.getColumnModel().getColumn(3).setPreferredWidth(120);

            String query = "select OrderID,OrderDate,OrderDetails,TotalPrice from OrdersDummy  where CusID=?";
            try {
                PreparedStatement psmt = connection.prepareStatement(query);
                psmt.setInt(1, Integer.parseInt(cusID));
                ResultSet rs = psmt.executeQuery();
                while (rs.next()) {
                    int orderID = rs.getInt("OrderID");
                    String orderDate = rs.getString("OrderDate");
                    String orderDetails = rs.getString("OrderDetails");
                    int rowSize=6*orderDetails.length();
                    recTable.getColumnModel().getColumn(2).setPreferredWidth(rowSize);
                    float totalPrice = rs.getFloat("TotalPrice");

                    String[] row = {Integer.toString(orderID), orderDate, orderDetails, Float.toString(totalPrice)};
                    tableModel.addRow(row);
                }

            }
            catch (SQLException e) {
                throw new RuntimeException(e);
            }

            JButton backButton = new JButton();
            backButton.setText("Back");
            backButton.setBounds(140, 150, 110, 40);
            backButton.setBackground(Color.cyan);

            backButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    CustomerMenu cm = new CustomerMenu(cusID);
                    dispose();
                }
            });

            JScrollPane scrollPane = new JScrollPane(recTable);
            scrollPane.setBounds(1, 1, 500, 300);
            scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
            tabPanel.add(scrollPane);

            setTitle("Booking History");
            setLayout(null);
            getContentPane().setBackground(Color.darkGray);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
            setSize(600, 600);
            setResizable(false);
            setLocationRelativeTo(null);
            add(label);
            add(orderIDLabel);
            add(orderIDTxt);
            add(searchButton);
            add(backButton);
            add(tabPanel);
        }
    }
    public static void main(String[] args)
    {
        BookHistoryPage wel=new BookHistoryPage("Dummy");
    }
}
