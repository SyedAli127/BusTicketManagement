package Project.Customer.BookNow;

import Project.Customer.CustomerMenu;
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

public class ConfirmPage extends JFrame {

    DefaultTableModel tableModel;
    JTable recTable;
    String cusID;
    int OrderID;
    Connection connection= Database.setConnection();
    public ConfirmPage(String cusID,int OrderID) {
        this.cusID = cusID;
        this.OrderID = OrderID;

        JLabel label = new JLabel();
        label.setText("Confirmation Page");
        label.setBounds(200, 20, 220, 35);
        label.setFont(new Font("Ariel", Font.BOLD, 25));
        label.setForeground(Color.orange);

        JPanel tabPanel = new JPanel();
        tabPanel.setBounds(50, 130, 500, 300);
        tabPanel.setLayout(null);

        String[] column = {"Order ID", "Order Details", "PromoCode","Order Date", "Total Price"};
        tableModel = new DefaultTableModel(column, 0);
        recTable = new JTable(tableModel);
        recTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        recTable.getColumnModel().getColumn(0).setPreferredWidth(100);
        recTable.getColumnModel().getColumn(1).setPreferredWidth(120);
        recTable.getColumnModel().getColumn(2).setPreferredWidth(157);
        recTable.getColumnModel().getColumn(3).setPreferredWidth(120);
        recTable.getColumnModel().getColumn(4).setPreferredWidth(120);
        String query="Select o.OrderID,o.OrderDate,pc.Code,o.orderDetails,o.totalPrice from Orders o " +
                " left join PromoCode pc on pc.PromoCodeID=o.PromoCodeID where cusID=? and OrderID=?";
        try {
            PreparedStatement psmt=connection.prepareStatement(query);
            psmt.setInt(1, Integer.parseInt(cusID));
            psmt.setInt(2, OrderID);
            ResultSet rs=psmt.executeQuery();
            while(rs.next()){
                int orderID=rs.getInt(1);
                String OrderDate=rs.getString(2);
                String Code=rs.getString(3);
                String OrderDetails=rs.getString(4);
                int size=6*OrderDetails.length();
                if(size>157){
                    recTable.getColumnModel().getColumn(1).setPreferredWidth(size);

                }
                Float TotalPrice=rs.getFloat(5);

                String[] row={Integer.toString(orderID),OrderDetails,Code,OrderDate,Float.toString(TotalPrice)};
                tableModel.addRow(row);
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }

        JButton confirmButton = new JButton();
        confirmButton.setText("Confirm");
        confirmButton.setBounds(240, 450, 110, 40);
        confirmButton.setBackground(Color.cyan);

        confirmButton.addActionListener(new ActionListener() {
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

        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,600);
        setTitle("Confirm Detail");
        setVisible(true);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(Color.darkGray);

        add(label);
        add(tabPanel);
        add(confirmButton);

    }

}
