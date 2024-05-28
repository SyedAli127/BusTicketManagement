package Project.Admin;

import Project.Database;
import Project.ManagerManagement.ManagerDashboard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminSigninPage extends JFrame {
    Connection con= Database.setConnection();

    public AdminSigninPage() {

        JLabel label=new JLabel();
        label.setText("Sign In Page");
        label.setBounds(180,20,200,50);
        label.setFont(new Font("Arial",Font.BOLD,29));
        label.setForeground(Color.orange);

        JLabel adminlabel =new JLabel();
        adminlabel.setText("Admin Log In");
        adminlabel.setBounds(180,20,200,50);
        adminlabel.setFont(new Font("Arial",Font.BOLD,29));
        adminlabel.setForeground(Color.orange);
        adminlabel.setVisible(false);

        JLabel managerlabel =new JLabel();
        managerlabel.setText("Manager Log In");
        managerlabel.setBounds(180,20,200,50);
        managerlabel.setFont(new Font("Arial",Font.BOLD,25));
        managerlabel.setForeground(Color.orange);
        managerlabel.setVisible(false);


        JRadioButton admin=new JRadioButton("Admin");
        admin.setBounds(180,150,70,30);
        JRadioButton manager=new JRadioButton("Manager");
        manager.setBounds(280,150,80,30);

        ButtonGroup bg=new ButtonGroup();
        bg.add(admin);
        bg.add(manager);

        JLabel emaillabel=new JLabel();
        emaillabel.setText("Email:");
        emaillabel.setBounds(70,110,110,30);
        emaillabel.setFont(new Font("Arial",Font.BOLD,18));
        emaillabel.setForeground(Color.orange);
        emaillabel.setVisible(false);

        JTextField emailTxt=new JTextField();
        emailTxt.setBounds(200,110,170,30);
        emailTxt.setVisible(false);

        JLabel passwordlabel=new JLabel();
        passwordlabel.setText("Password:");
        passwordlabel.setBounds(70,160,110,30);
        passwordlabel.setFont(new Font("Arial",Font.BOLD,18));
        passwordlabel.setForeground(Color.orange);
        passwordlabel.setVisible(false);

        JPasswordField passwordTxt=new JPasswordField();
        passwordTxt.setBounds(200,160,170,30);
        passwordTxt.setVisible(false);

        JButton signButton=new JButton();
        signButton.setText("Sign In");
        signButton.setBounds(200,280,100,50);
        signButton.setFont(new Font("Ariel",Font.BOLD,15));
        signButton.setBackground(Color.cyan);
        signButton.setVisible(false);

        ActionListener radio=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(admin.isSelected())
                {
                    adminlabel.setVisible(true);
                    managerlabel.setVisible(false);
                    label.setVisible(false);
                    admin.setBounds(180,210,80,30);
                    manager.setBounds(280,210,80,30);
                    emaillabel.setVisible(true);
                    emailTxt.setVisible(true);
                    passwordlabel.setVisible(true);
                    passwordTxt.setVisible(true);
                    signButton.setVisible(true);


                } else if (manager.isSelected()) {
                    adminlabel.setVisible(false);
                    managerlabel.setVisible(true);
                    label.setVisible(false);
                    admin.setBounds(180,210,80,30);
                    manager.setBounds(280,210,80,30);
                    emaillabel.setVisible(true);
                    emailTxt.setVisible(true);
                    passwordlabel.setVisible(true);
                    passwordTxt.setVisible(true);
                    signButton.setVisible(true);
                }

            }
        };

        admin.addActionListener(radio);
        manager.addActionListener(radio);
        String query="select * from Manager where Email=? and Password=?";

        signButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if(admin.isSelected())
                {
                    if (emailTxt.getText().equals("ali") && passwordTxt.getText().equals("ali")) {
                        AdminDashboard adminDashboard = new AdminDashboard();
                        dispose();
                    } else {
                        AdminDashboard adminDashboard = new AdminDashboard();
                    }
                }
                else if(manager.isSelected())
                {
                    boolean found=false;
                    try
                    {
                        PreparedStatement  d=con.prepareStatement(query);
                        d.setString(1,emailTxt.getText());
                        d.setString(2,passwordTxt.getText());
                        ResultSet rs = d.executeQuery();
                        found = rs.next();

                    } catch (SQLException ex)
                    {
                        throw new RuntimeException(ex);
                    }
                    if(!found){
                        System.out.println("Error");
                    }
                    else {
                        System.out.println("Mubarak");
                        ManagerDashboard md=new ManagerDashboard();
                        dispose();
                    }

                }
            }
        });

        setTitle("Admin Sign In Page");
        setLayout(null);
        setSize(550, 500);
        getContentPane().setBackground(Color.darkGray);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);


        add(label);
        add(adminlabel);
        add(managerlabel);
        add(admin);
        add(manager);
        add(emaillabel);
        add(emailTxt);
        add(passwordlabel);
        add(passwordTxt);
        add(signButton);

    }

    public static void main(String[] args)
    {
        AdminSigninPage adminSigninPage=new AdminSigninPage();
    }
}
