package Project;

import Project.Admin.AdminSigninPage;
import Project.Customer.CustomerMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomePage extends JFrame {

    public WelcomePage() {

        JFrame frame = new JFrame();

        JLabel label=new JLabel();
        label.setText("Welcome to BUS Management System");
        label.setFont(new Font("Ariel",Font.BOLD,21));
        label.setForeground(Color.orange);
        label.setBounds(100,20,400,28);


        JButton customerButton = new JButton();
        customerButton.setText("Customer");
        customerButton.setBounds(220,120,150,60);
        customerButton.setFont(new Font("Ariel",Font.BOLD,15));
        customerButton.setBackground(Color.cyan);

        customerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CustomerMenu menu=new CustomerMenu();

                dispose();


            }
        });

        JButton adminButton = new JButton();
        adminButton.setText("Admin");
        adminButton.setBounds(220, 220,150,60);
        adminButton.setFont(new Font("Ariel",Font.BOLD,15));
        adminButton.setBackground(Color.cyan);

        adminButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("hiiii");
                AdminSigninPage adminSigninPage=new AdminSigninPage();
                dispose();
            }
        });

        JButton exitButton=new JButton();
        exitButton.setText("Exit");
        exitButton.setBounds(220,320,150,50);
        exitButton.setFont(new Font("Ariel",Font.BOLD,15));
        exitButton.setBackground(Color.cyan);


        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        setTitle("Welcome Page");
        setLayout(null);
        setSize(600, 600);
        getContentPane().setBackground(Color.darkGray);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);


        add(label);
        add(adminButton);
        add(customerButton);
        add(exitButton);
    }

    public static void main(String[] args)
    {
        WelcomePage wel=new WelcomePage();

    }

}
