package Project.Customer.UserProfile;

import Project.Customer.CustomerMenu;
import Project.Customer.RefundPage;
import Project.Database;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SigninPage extends JFrame {
    String cusID;
    Connection connection= Database.setConnection();
    public SigninPage(String cusID) {
        this.cusID = cusID;

        JLabel label=new JLabel();
        label.setText("Sign In");
        label.setFont(new Font("Ariel",Font.BOLD,25));
        label.setForeground(Color.orange);
        label.setBounds(260,20,280,30);

        JLabel emailLabel=new JLabel();
        emailLabel.setText("Email:");
        emailLabel.setBounds(30,65,100,50);
        emailLabel.setFont(new Font("Ariel",Font.BOLD,20));
        emailLabel.setForeground(Color.orange);

        JTextField emailTxt =new JTextField();
        emailTxt.setBounds(160,75,230,30);

        JLabel passwordLabel=new JLabel();
        passwordLabel.setText("Password:");
        passwordLabel.setBounds(30,135,100,50);
        passwordLabel.setFont(new Font("Ariel",Font.BOLD,18));
        passwordLabel.setForeground(Color.orange);

        JPasswordField passwordTxt=new JPasswordField();
        passwordTxt.setBounds(160,145,230,30);

        JLabel registerLabel=new JLabel();
        registerLabel.setText("Register Yourself");
        registerLabel.setBounds(50,205,100,30);
        registerLabel.setFont(new Font("Ariel",Font.ITALIC,12));
        registerLabel.setForeground(Color.orange);


        registerLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                RegisterPage rp=new RegisterPage(cusID);
                dispose();
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                registerLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                registerLabel.setCursor(Cursor.getDefaultCursor());
            }
        });

        JButton backButton=new JButton();
        backButton.setText("Back");
        backButton.setBounds(140,295,120,40);
        backButton.setBackground(Color.cyan);


        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CustomerMenu cm=new CustomerMenu(cusID);
                dispose();
            }
        });

        JButton signInButton =new JButton();
        signInButton.setText("Sign In");
        signInButton.setBounds(290,295,120,40);
        signInButton.setBackground(Color.cyan);

        signInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email=emailTxt.getText();
                String password=passwordTxt.getText();
                String query="Select cusID from Customer where Email=? and Password=? and AccountStatus='Active'";
                boolean found=false;
                String cusID="";
                try
                {
                    PreparedStatement psmt=connection.prepareStatement(query);
                    psmt.setString(1,email);
                    psmt.setString(2,password);
                    ResultSet rs=psmt.executeQuery();
                    if (rs.next()) {
                        found = true;
                        cusID = Integer.toString(rs.getInt("cusID"));
                    }

                }
                catch (SQLException ex)
                {
                    throw new RuntimeException(ex);
                }
                if(!found)
                {
                    JOptionPane.showMessageDialog(null, "Sign in Failed!", "Error", JOptionPane.ERROR_MESSAGE);

                }else {
                    JOptionPane.showMessageDialog(null, "Sign in successful!", "Message", JOptionPane.INFORMATION_MESSAGE);
                    CustomerMenu cm=new CustomerMenu(cusID);
                    System.out.println(cusID);
                    dispose();
                }


            }
        });

        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,500);
        setTitle("Sign-in Page");
        setVisible(true);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(Color.darkGray);


        add(label);
        add(emailLabel);
        add(emailTxt);
        add(passwordLabel);
        add(passwordTxt);
        add(backButton);
        add(signInButton);
        add(registerLabel);

    }
}
