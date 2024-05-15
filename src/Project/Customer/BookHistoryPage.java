package Project.Customer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BookHistoryPage extends JFrame {
    public BookHistoryPage(){

        JLabel label=new JLabel();
        label.setText("Booking History");
        label.setBounds(220,20,180,35);
        label.setFont(new Font("Ariel",Font.BOLD,22));
        label.setForeground(Color.orange);

        JLabel personIDLabel=new JLabel();
        personIDLabel.setText("Enter ID");
        personIDLabel.setBounds(50,70,180,35);
        personIDLabel.setFont(new Font("Ariel",Font.BOLD,12));
        personIDLabel.setForeground(Color.orange);

        JTextField text=new JTextField();
        text.setBounds(50,100,180,35);

        JButton searchButton=new JButton();
        searchButton.setText("Search");
        searchButton.setBackground(Color.cyan);
        searchButton.setBounds(250,100,110,35);
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(text.getText());
            }
        });

        JButton backButton=new JButton();
        backButton.setText("Back");
        backButton.setBounds(140,150,110,40);
        backButton.setBackground(Color.cyan);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CustomerMenu cm=new CustomerMenu();
                dispose();
            }
        });

        setTitle("Booking History");
        setLayout(null);
        getContentPane().setBackground(Color.darkGray);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(600,600);
        setResizable(false);
        setLocationRelativeTo(null);
        add(label);
        add(personIDLabel);
        add(text);
        add(searchButton);
        add(backButton);

    }
    public static void main(String[] args)
    {
        BookHistoryPage wel=new BookHistoryPage();
    }
}
