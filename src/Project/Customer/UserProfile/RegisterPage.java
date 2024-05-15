package Project.Customer.UserProfile;

import Project.Customer.CustomerMenu;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterPage extends JFrame {


    public RegisterPage() {


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

        JLabel phoneNoLabel=new JLabel();
        phoneNoLabel.setText("Phone No:");
        phoneNoLabel.setBounds(10,130,100,50);
        phoneNoLabel.setFont(new Font("Ariel",Font.BOLD,18));
        phoneNoLabel.setForeground(Color.orange);

        JTextField phoneNoTxt =new JTextField();
        phoneNoTxt.setBounds(190,140,180,30);


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

        JTextField doBTxt=new JTextField();
        doBTxt.setBounds(190,290,180,30);

        JLabel dateFormatLabel=new JLabel();
        dateFormatLabel.setText("(DD-MM-YYYY)");
        dateFormatLabel.setBounds(190,303,150,50);
        dateFormatLabel.setFont(new Font("Ariel",Font.PLAIN,11));
        dateFormatLabel.setForeground(Color.orange);

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
            public void actionPerformed(ActionEvent e) {


                //System.out.println(getSelectedRadioButtonValue());
                CustomerMenu CustomerMenu=new CustomerMenu();
                dispose();

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
                CustomerMenu cm=new CustomerMenu();
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
        panel.add(phoneNoLabel);
        panel.add(phoneNoTxt);
        panel.add(emailLabel);
        panel.add(emailTxt);
        panel.add(cnicLabel);
        panel.add(cnicTxt);
        panel.add(dateFormatLabel);
        panel.add(doBLabel);
        panel.add(doBTxt);
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

}
