package Project.Customer;

import Project.Database;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FeedbackPage extends JFrame {

    JRadioButton r1,r2,r3,r4,r5;
    String cusID;
    Connection con= Database.setConnection();
    public FeedbackPage(String cusID) {
        this.cusID = cusID;

        if(cusID.equals("")||cusID.equals("Dummy"))
        {
            JOptionPane.showMessageDialog(null, "First Sign In", "Error", JOptionPane.ERROR_MESSAGE);
            CustomerMenu cm=new CustomerMenu("Dummy");
            dispose();
        }
        else {
            JLabel label = new JLabel();
            label.setText("Share Us Your FeedBack");
            label.setFont(new Font("Ariel", Font.BOLD, 21));
            label.setForeground(Color.orange);
            label.setBounds(190, 20, 280, 20);

            JLabel orderIDLabel = new JLabel();
            orderIDLabel.setText("Order ID:");
            orderIDLabel.setBounds(10, 70, 100, 50);
            orderIDLabel.setFont(new Font("Ariel", Font.BOLD, 18));
            orderIDLabel.setForeground(Color.orange);

            JTextField orderIDTxt = new JTextField();
            orderIDTxt.setBounds(230, 80, 180, 30);


            JLabel ratingLabel = new JLabel();
            ratingLabel.setText("Overall Satisfaction:");
            ratingLabel.setBounds(10, 130, 180, 50);
            ratingLabel.setFont(new Font("Ariel", Font.BOLD, 18));
            ratingLabel.setForeground(Color.orange);

            //RADIO BUTTONS
            r1 = new JRadioButton("1");
            r2 = new JRadioButton("2");
            r3 = new JRadioButton("3");
            r4 = new JRadioButton("4");
            r5 = new JRadioButton("5");

            r1.setBounds(230, 140, 40, 30);
            r2.setBounds(280, 140, 40, 30);
            r3.setBounds(330, 140, 40, 30);
            r4.setBounds(380, 140, 40, 30);
            r5.setBounds(430, 140, 40, 30);

            ButtonGroup group = new ButtonGroup();
            group.add(r1);
            group.add(r2);
            group.add(r3);
            group.add(r4);
            group.add(r5);

            JLabel terribleLabel = new JLabel();
            terribleLabel.setText("(Terrible)");
            terribleLabel.setBounds(230, 160, 48, 50);
            terribleLabel.setFont(new Font("Ariel", Font.PLAIN, 11));
            terribleLabel.setForeground(Color.orange);

            JLabel lovelyLabel = new JLabel();
            lovelyLabel.setText("(Lovely)");
            lovelyLabel.setBounds(430, 160, 40, 50);
            lovelyLabel.setFont(new Font("Ariel", Font.PLAIN, 11));
            lovelyLabel.setForeground(Color.orange);

            JLabel thoughtLabel = new JLabel();
            thoughtLabel.setText("Share us your thought:");
            thoughtLabel.setBounds(10, 210, 250, 50);
            thoughtLabel.setFont(new Font("Ariel", Font.BOLD, 18));
            thoughtLabel.setForeground(Color.orange);

            JTextField thoughtTxt = new JTextField();
            thoughtTxt.setBounds(230, 220, 250, 30);


            JButton submitButton = new JButton();
            submitButton.setText("Submit");
            submitButton.setBounds(300, 280, 110, 40);
            submitButton.setBackground(Color.cyan);

            submitButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    boolean found = false;
                    String checkQuery = "select * from Orders where CusID=? and OrderID=? ";
                    try {
                        PreparedStatement pst = con.prepareStatement(checkQuery);
                        pst.setInt(1, Integer.parseInt(cusID));
                        pst.setInt(2, Integer.parseInt(orderIDTxt.getText()));
                        ResultSet rs = pst.executeQuery();
                        found = rs.next();
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                    if (!found) {
                        JOptionPane.showMessageDialog(null, "Wrong Order ID!", "Error", JOptionPane.ERROR_MESSAGE);
                        CustomerMenu cm = new CustomerMenu(cusID);
                        dispose();

                    } else {
                        CustomerMenu cm = new CustomerMenu(cusID);
                        dispose();
                        String query = "insert into Feedback(OrderID,CusID,Rating,Feedback)" +
                                "values(?,?,?,?) ";
                        try {
                            PreparedStatement psmt = con.prepareStatement(query);
                            psmt.setInt(1, Integer.parseInt(orderIDTxt.getText()));
                            psmt.setInt(2, Integer.parseInt(cusID));
                            psmt.setInt(3, Integer.parseInt(getSelectedRadioButtonValue()));
                            psmt.setString(4, thoughtTxt.getText());
                            psmt.executeUpdate();
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);

                        }
                    }
                }
            });

            JButton backButton = new JButton();
            backButton.setText("Back");
            backButton.setBounds(140, 280, 110, 40);
            backButton.setBackground(Color.cyan);

            backButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    CustomerMenu cm = new CustomerMenu(cusID);
                    dispose();
                }
            });

            //JFrame
            setSize(600, 450);
            setTitle("FeedBack Page");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLayout(null);
            setVisible(true);
            setLocationRelativeTo(null);
            getContentPane().setBackground(Color.darkGray);
            setResizable(false);

            add(label);
            add(orderIDLabel);
            add(orderIDTxt);
            add(ratingLabel);
            add(r1);
            add(r2);
            add(r3);
            add(r4);
            add(r5);
            add(terribleLabel);
            add(lovelyLabel);
            add(thoughtLabel);
            add(thoughtTxt);
            add(submitButton);
            add(backButton);
        }
    }
    private String getSelectedRadioButtonValue() {
        if (r1.isSelected()) {
            return r1.getText();
        } else if (r2.isSelected()) {
            return r2.getText();
        } else if (r3.isSelected()) {
            return r3.getText();
        } else if (r4.isSelected()) {
            return r4.getText();
        } else if (r5.isSelected()) {
            return r5.getText();
        } else {
            return "No option selected";
        }
    }
    public static void main(String[] args)
    {
        FeedbackPage fdp=new FeedbackPage("Dummy");
    }
}
