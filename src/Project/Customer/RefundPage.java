package Project.Customer;

import Project.Database;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RefundPage extends JFrame {

    JRadioButton r1,r2,r3;
    JTextField reasonTxt;
    Connection connection= Database.setConnection();
    String cusID;
    public RefundPage(String cusID) {

        this.cusID = cusID;

        if(cusID.equals("")||cusID.equals("Dummy"))
        {
            JOptionPane.showMessageDialog(null, "First Sign In", "Error", JOptionPane.ERROR_MESSAGE);
            CustomerMenu cm=new CustomerMenu("Dummy");
            dispose();
        }
        else {
            System.out.println(cusID);
            JLabel label = new JLabel();
            label.setText("Refund Request Form");
            label.setFont(new Font("Ariel", Font.BOLD, 21));
            label.setForeground(Color.orange);
            label.setBounds(190, 20, 280, 25);

            JPanel panel = new JPanel();
            panel.setLayout(null);
            panel.setBackground(Color.darkGray);
            panel.setPreferredSize(new Dimension(500, 570)); // Set preferred size

            JLabel orderIDLabel = new JLabel();
            orderIDLabel.setText("Order ID:");
            orderIDLabel.setBounds(10, 90, 100, 50);
            orderIDLabel.setFont(new Font("Ariel", Font.BOLD, 18));
            orderIDLabel.setForeground(Color.orange);

            JTextField orderIDTxt = new JTextField();
            orderIDTxt.setBounds(190, 100, 180, 30);

            JLabel buyingDateLabel = new JLabel();
            buyingDateLabel.setText("Booking Date:");
            buyingDateLabel.setBounds(10, 150, 150, 50);
            buyingDateLabel.setFont(new Font("Ariel", Font.BOLD, 18));
            buyingDateLabel.setForeground(Color.orange);

            JTextField buyingDateDayTxt = new JTextField();
            buyingDateDayTxt.setBounds(190, 150, 40, 30);
            JTextField buyingDateMonTxt = new JTextField();
            buyingDateMonTxt.setBounds(240, 150, 40, 30);
            JTextField buyingDateYearTxt = new JTextField();
            buyingDateYearTxt.setBounds(290, 150, 40, 30);


            JLabel dateFormatDayLabel = new JLabel();
            dateFormatDayLabel.setText("(Day)");
            dateFormatDayLabel.setBounds(190, 185, 150, 50);
            dateFormatDayLabel.setFont(new Font("Ariel", Font.PLAIN, 11));
            dateFormatDayLabel.setForeground(Color.orange);

            JLabel dateFormatMonLabel = new JLabel();
            dateFormatMonLabel.setText("(Month)");
            dateFormatMonLabel.setBounds(240, 185, 150, 50);
            dateFormatMonLabel.setFont(new Font("Ariel", Font.PLAIN, 11));
            dateFormatMonLabel.setForeground(Color.orange);

            JLabel dateFormatYearLabel = new JLabel();
            dateFormatYearLabel.setText("(Year)");
            dateFormatYearLabel.setBounds(290, 185, 150, 50);
            dateFormatYearLabel.setFont(new Font("Ariel", Font.PLAIN, 11));
            dateFormatYearLabel.setForeground(Color.orange);

            JLabel reasonLabel = new JLabel();
            reasonLabel.setText("Reason for Refund:");
            reasonLabel.setBounds(10, 220, 180, 50);
            reasonLabel.setFont(new Font("Ariel", Font.BOLD, 18));
            reasonLabel.setForeground(Color.orange);

            r1 = new JRadioButton("Change in travel plans");
            r2 = new JRadioButton("Double booking");
            r3 = new JRadioButton("Others");

            r1.setBounds(190, 235, 170, 30);
            r2.setBounds(190, 285, 170, 30);
            r3.setBounds(190, 335, 70, 30);
            ButtonGroup group = new ButtonGroup();
            group.add(r1);
            group.add(r2);
            group.add(r3);

            reasonTxt = new JTextField();
            reasonTxt.setBounds(300, 335, 170, 30);

            JLabel additionalNoteLabel = new JLabel();
            additionalNoteLabel.setText("Additional Note:");
            additionalNoteLabel.setBounds(10, 380, 150, 50);
            additionalNoteLabel.setFont(new Font("Ariel", Font.BOLD, 18));
            additionalNoteLabel.setForeground(Color.orange);

            JTextField noteTxt = new JTextField();
            noteTxt.setBounds(190, 390, 280, 30);

            JButton submitButton = new JButton();
            submitButton.setText("Submit");
            submitButton.setBounds(280, 490, 110, 40);
            submitButton.setBackground(Color.cyan);
            submitButton.setEnabled(false);

            submitButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String date = buyingDateYearTxt.getText() + "-" + buyingDateMonTxt.getText() + "-" + buyingDateDayTxt.getText();
                    boolean found = false;
                    String checkQuery = "select * from Orders where CusID=? and OrderID=? and orderDate=?";
                    try {
                        PreparedStatement pst = connection.prepareStatement(checkQuery);
                        pst.setInt(1, Integer.parseInt(cusID));
                        pst.setInt(2, Integer.parseInt(orderIDTxt.getText()));
                        pst.setString(3, date);
                        ResultSet rs = pst.executeQuery();
                        found = rs.next();
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                    if (!found) {
                        JOptionPane.showMessageDialog(null, "Wrong Order ID! or Date", "Error", JOptionPane.ERROR_MESSAGE);
                        CustomerMenu cm = new CustomerMenu(cusID);
                        dispose();

                    } else {
                        CustomerMenu cm = new CustomerMenu(cusID);
                        dispose();
                        String query = "insert into Refund(OrderID,CusID,Reason,AdditionalNote,Decision)\n" +
                                "values(?,?,?,?,?) ";
                        try {
                            PreparedStatement psmt = connection.prepareStatement(query);
                            psmt.setInt(1, Integer.parseInt(orderIDTxt.getText()));
                            psmt.setInt(2, Integer.parseInt(cusID));
                            psmt.setString(3, getSelectedRadioButtonValue());
                            psmt.setString(4, noteTxt.getText());
                            psmt.setString(5, "Pending");
                            psmt.executeUpdate();
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);

                        }
                    }
                }
            });

            JCheckBox agreecheckbox = new JCheckBox();
            agreecheckbox.setText("i agree the Terms & Conditions");
            agreecheckbox.setBounds(190, 440, 220, 30);
            agreecheckbox.setBackground(Color.darkGray);
            agreecheckbox.setForeground(Color.orange);
            agreecheckbox.addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent e) {

                    submitButton.setEnabled(agreecheckbox.isSelected());
                }
            });

            JButton backButton = new JButton();
            backButton.setText("Back");
            backButton.setBounds(130, 490, 110, 40);
            backButton.setBackground(Color.cyan);

            backButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {


                    CustomerMenu cm = new CustomerMenu(cusID);
                    dispose();

                }
            });

            setLayout(null);
            setSize(600, 600);
            setResizable(false);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
            getContentPane().setBackground(Color.darkGray);
            setTitle("Refund Page");
            setLocationRelativeTo(null);


            JScrollPane scrollPane = new JScrollPane(panel);
            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
            scrollPane.setBounds(0, 0, 584, 580); // Set the bounds of the scroll pane to match the JFrame
            getContentPane().add(scrollPane);

            panel.add(label);
            panel.add(orderIDLabel);
            panel.add(orderIDTxt);
            panel.add(buyingDateLabel);
            panel.add(buyingDateDayTxt);
            panel.add(buyingDateMonTxt);
            panel.add(buyingDateYearTxt);
            panel.add(dateFormatDayLabel);
            panel.add(dateFormatMonLabel);
            panel.add(dateFormatYearLabel);
            panel.add(r1);
            panel.add(r2);
            panel.add(r3);
            panel.add(reasonLabel);
            panel.add(backButton);
            panel.add(reasonTxt);
            panel.add(additionalNoteLabel);
            panel.add(noteTxt);
            panel.add(submitButton);
            panel.add(agreecheckbox);

        }

    }

    private String getSelectedRadioButtonValue() {
        if (r1.isSelected()) {
            return r1.getText();
        }
        else if (r2.isSelected()) {
            return r2.getText();
        }
        else if (r3.isSelected()) {
            return reasonTxt.getText();
        }
        else {
            return "No option selected";
        }
    }
    public static void main(String[] args)
    {
        RefundPage rp=new RefundPage("Dummy");
    }

}
