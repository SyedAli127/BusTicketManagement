package Project.Customer.UserProfile;

import Project.Customer.CustomerMenu;
import Project.Database;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterPage extends JFrame {
    Connection connection= Database.setConnection();
    String cusID;
    public RegisterPage(String cusID) {
        this.cusID = cusID;

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.darkGray);
        panel.setPreferredSize(new Dimension(500,650)); // Set preferred size


        JLabel label=new JLabel();
        label.setText("Register Yourself");
        label.setFont(new Font("Ariel",Font.BOLD,21));
        label.setForeground(Color.orange);
        label.setBounds(190,20,280,25);

        JLabel fullnameLabel=new JLabel();
        fullnameLabel.setText("Full Name:");
        fullnameLabel.setBounds(10,65,100,50);
        fullnameLabel.setFont(new Font("Ariel",Font.BOLD,18));
        fullnameLabel.setForeground(Color.orange);

        JTextField firstnameTxt=new JTextField();
        firstnameTxt.setBounds(190,75,150,30);

        JLabel firstNameLabel=new JLabel();
        firstNameLabel.setText("First Name");
        firstNameLabel.setBounds(190,90,100,50);
        firstNameLabel.setFont(new Font("Ariel",Font.BOLD,12));
        firstNameLabel.setForeground(Color.orange);

        JTextField lastNameTxt=new JTextField();
        lastNameTxt.setBounds(360,75,150,30);

        JLabel lastNameLabel=new JLabel();
        lastNameLabel.setText("Last Name");
        lastNameLabel.setBounds(360,90,100,50);
        lastNameLabel.setFont(new Font("Ariel",Font.BOLD,12));
        lastNameLabel.setForeground(Color.orange);

        JLabel contactNoLabel =new JLabel();
        contactNoLabel.setText("Contact Number:");
        contactNoLabel.setBounds(10,130,150,50);
        contactNoLabel.setFont(new Font("Ariel",Font.BOLD,18));
        contactNoLabel.setForeground(Color.orange);

        JTextField contactNoTxt =new JTextField();
        contactNoTxt.setBounds(190,140,180,30);


        JLabel cnicLabel=new JLabel();
        cnicLabel.setText("CNIC/Passport:");
        cnicLabel.setBounds(10,185,150,50);
        cnicLabel.setFont(new Font("Ariel",Font.BOLD,18));
        cnicLabel.setForeground(Color.orange);

        JTextField cnicTxt=new JTextField();
        cnicTxt.setBounds(190,195,180,30);

        JLabel emailLabel=new JLabel();
        emailLabel.setText("Email:");
        emailLabel.setBounds(10,235,100,50);
        emailLabel.setFont(new Font("Ariel",Font.BOLD,18));
        emailLabel.setForeground(Color.orange);

        JTextField emailTxt=new JTextField();
        emailTxt.setBounds(190,245,180,30);


        JLabel doBLabel=new JLabel();
        doBLabel.setText("Date of Birth:");
        doBLabel.setBounds(10,280,150,50);
        doBLabel.setFont(new Font("Ariel",Font.BOLD,18));
        doBLabel.setForeground(Color.orange);

        JTextField doBDayTxt =new JTextField();
        doBDayTxt.setBounds(190,290,40,30);

        JTextField doBMonTxt =new JTextField();
        doBMonTxt.setBounds(240,290,40,30);

        JTextField doBYearTxt =new JTextField();
        doBYearTxt.setBounds(290,290,40,30);

        JLabel doBDayLabel =new JLabel();
        doBDayLabel.setText("(Day)");
        doBDayLabel.setBounds(190,303,150,50);
        doBDayLabel.setFont(new Font("Ariel",Font.PLAIN,11));
        doBDayLabel.setForeground(Color.orange);

        JLabel doBMonLabel =new JLabel();
        doBMonLabel.setText("(Month)");
        doBMonLabel.setBounds(240,303,150,50);
        doBMonLabel.setFont(new Font("Ariel",Font.PLAIN,11));
        doBMonLabel.setForeground(Color.orange);

        JLabel doBYearLabel =new JLabel();
        doBYearLabel.setText("(Year)");
        doBYearLabel.setBounds(290,303,150,50);
        doBYearLabel.setFont(new Font("Ariel",Font.PLAIN,11));
        doBYearLabel.setForeground(Color.orange);


        JLabel cityLabel=new JLabel();
        cityLabel.setText("City:");
        cityLabel.setBounds(10,340,150,50);
        cityLabel.setFont(new Font("Ariel",Font.BOLD,18));
        cityLabel.setForeground(Color.orange);

        JTextField cityTxt=new JTextField();
        cityTxt.setBounds(190,350,180,30);

        JLabel addressLabel=new JLabel();
        addressLabel.setText("Address:");
        addressLabel.setBounds(10,390,150,50);
        addressLabel.setFont(new Font("Ariel",Font.BOLD,18));
        addressLabel.setForeground(Color.orange);

        JTextField addressTxt=new JTextField();
        addressTxt.setBounds(190,400,180,30);
//---------------------------------------------------------------
        JLabel passwordLabel=new JLabel();
        passwordLabel.setText("Password:");
        passwordLabel.setBounds(10,440,100,50);
        passwordLabel.setFont(new Font("Ariel",Font.BOLD,18));
        passwordLabel.setForeground(Color.orange);

        JPasswordField passwordTxt=new JPasswordField();
        passwordTxt.setBounds(190,450,140,30);
        //--------------------------------------------------------------
        JLabel cnfrmpasswordLabel=new JLabel();
        cnfrmpasswordLabel.setText("Confirm Password:");
        cnfrmpasswordLabel.setBounds(10,490,190,50);
        cnfrmpasswordLabel.setFont(new Font("Ariel",Font.BOLD,18));
        cnfrmpasswordLabel.setForeground(Color.orange);

        JPasswordField cnfrmpasswordTxt=new JPasswordField();
        cnfrmpasswordTxt.setBounds(190,500,140,30);

        JButton submitButton=new JButton();
        submitButton.setText("Submit");
        submitButton.setBounds(280,600,110,40);
        submitButton.setBackground(Color.cyan);
        submitButton.setEnabled(false);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if (passwordTxt.getText().equals(cnfrmpasswordTxt.getText()))
                {
                    String dob = doBYearTxt.getText() + "-" + doBMonTxt.getText() + "-" + doBDayTxt.getText();
                    String insertQuery = "insert into Customer(FirstName,LastName,CNIC,DOB,ContactNo,Email,Address,Password,City,AccountStatus) values(?,?,?,?,?,?,?,?,?,?)";
                    try
                    {
                        PreparedStatement psmt = connection.prepareStatement(insertQuery);
                        psmt.setString(1, firstnameTxt.getText());
                        psmt.setString(2, lastNameTxt.getText());
                        psmt.setString(3, cnicTxt.getText());
                        psmt.setString(4, dob);
                        psmt.setString(5, contactNoTxt.getText());
                        psmt.setString(6, emailTxt.getText());
                        psmt.setString(7, addressTxt.getText());
                        psmt.setString(8, passwordTxt.getText());
                        psmt.setString(9,cityTxt.getText());
                        psmt.setString(10, "Active");
                        psmt.executeUpdate();

                    }
                    catch (SQLException ex)
                    {
                        throw new RuntimeException(ex);
                    }


                    CustomerMenu CustomerMenu = new CustomerMenu(cusID);
                    dispose();

                }
            }
        });

        JCheckBox agreecheckbox=new JCheckBox();
        agreecheckbox.setText("i agree the Terms & Conditions");
        agreecheckbox.setBounds(190,550,220,30);
        agreecheckbox.setBackground(Color.darkGray);
        agreecheckbox.setForeground(Color.orange);
        agreecheckbox.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                submitButton.setEnabled(agreecheckbox.isSelected());
            }
        });

        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(0, 0, 600, 600); // Set the bounds of the scroll pane to match the JFrame
        add(scrollPane);


        JButton backButton=new JButton();
        backButton.setText("Back");
        backButton.setBounds(140,600,110,40);
        backButton.setBackground(Color.cyan);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CustomerMenu cm=new CustomerMenu(cusID);
                dispose();
            }
        });

        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,600);
        setTitle("Register Page");
        setVisible(true);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(Color.darkGray);



        panel.add(label);
        panel.add(fullnameLabel);
        panel.add(firstnameTxt);
        panel.add(firstNameLabel);
        panel.add(lastNameTxt);
        panel.add(lastNameLabel);
        panel.add(contactNoLabel);
        panel.add(contactNoTxt);
        panel.add(emailLabel);
        panel.add(emailTxt);
        panel.add(cnicLabel);
        panel.add(cnicTxt);
        panel.add(doBLabel);
        panel.add(doBDayLabel);
        panel.add(doBMonLabel);
        panel.add(doBYearLabel);
        panel.add(doBDayTxt);
        panel.add(doBMonTxt);
        panel.add(doBYearTxt);
        panel.add(cityLabel);
        panel.add(cityTxt);
        panel.add(addressLabel);
        panel.add(addressTxt);
        panel.add(passwordLabel);
        panel.add(passwordTxt);
        panel.add(cnfrmpasswordLabel);
        panel.add(cnfrmpasswordTxt);
        panel.add(agreecheckbox);
        panel.add(submitButton);
        panel.add(backButton);

    }
    public static void main(String[] args) {
        RegisterPage tp=new RegisterPage("Dummy");
    }

}
