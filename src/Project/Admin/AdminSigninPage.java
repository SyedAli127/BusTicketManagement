package Project.Admin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminSigninPage extends JFrame {

    public AdminSigninPage() {

        JLabel label=new JLabel();
        label.setText("Admin Log In");
        label.setBounds(180,20,200,50);
        label.setFont(new Font("Arial",Font.BOLD,29));
        label.setForeground(Color.orange);

        JLabel emaillabel=new JLabel();
        emaillabel.setText("Email:");
        emaillabel.setBounds(70,110,110,30);
        emaillabel.setFont(new Font("Arial",Font.BOLD,18));
        emaillabel.setForeground(Color.orange);

        JTextField emailTxt=new JTextField();
        emailTxt.setBounds(200,110,170,30);

        JLabel passwordlabel=new JLabel();
        passwordlabel.setText("Password:");
        passwordlabel.setBounds(70,160,110,30);
        passwordlabel.setFont(new Font("Arial",Font.BOLD,18));
        passwordlabel.setForeground(Color.orange);

        JPasswordField passwordTxt=new JPasswordField();
        passwordTxt.setBounds(200,160,170,30);

        JButton signButton=new JButton();
        signButton.setText("Sign In");
        signButton.setBounds(200,280,150,50);
        signButton.setFont(new Font("Ariel",Font.BOLD,15));
        signButton.setBackground(Color.cyan);

        signButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(emailTxt.getText().equals("ali") && passwordTxt.getText().equals("ali"))
                {
                    AdminDashboard adminDashboard=new AdminDashboard();
                    dispose();
                }
                else {
                    AdminDashboard adminDashboard=new AdminDashboard();
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
