package Project.Customer;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicketPricePage extends JFrame {

    JComboBox depComboBox, arrComboBox;
    public TicketPricePage() {

        JLabel label=new JLabel();
        label.setText("Ticket Prices");
        label.setBounds(220,20,150,50);
        label.setFont(new Font("Ariel",Font.BOLD,20));
        label.setForeground(Color.orange);

        JLabel arrLabel=new JLabel();
        arrLabel.setText("Arrival");
        arrLabel.setBounds(280,120,150,35);
        arrLabel.setFont(new Font("Ariel",Font.BOLD,12));
        arrLabel.setForeground(Color.orange);

        JLabel depLabel=new JLabel();
        depLabel.setText("Departure");
        depLabel.setBounds(120,120,150,35);
        depLabel.setFont(new Font("Ariel",Font.BOLD,12));
        depLabel.setForeground(Color.orange);


        String [] arrival ={"-","Karachi","Lahore","Islamabad","Quetta","Hyderabad"};
        arrComboBox=new JComboBox<>(arrival);
        arrComboBox.setBounds(110,150,150,35);
        arrComboBox.setBackground(Color.YELLOW);

        String [] departure ={"-","Karachi","Lahore","Islamabad","Quetta","Hyderabad"};
        depComboBox =new JComboBox<>(departure);
        depComboBox.setBounds(300,150,150,35);
        depComboBox.setBackground(Color.YELLOW);

        JButton searchButton=new JButton();
        searchButton.setText("SEARCH");
        searchButton.setBounds(300,210,100,35);
        searchButton.setBackground(Color.cyan);

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(arrComboBox.getSelectedItem());
                System.out.println(depComboBox.getSelectedItem());

            }
        });

        JButton backButton=new JButton();
        backButton.setText("BACK");
        backButton.setBounds(170,210,100,35);
        backButton.setBackground(Color.cyan);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CustomerMenu cm=new CustomerMenu();
                dispose();
            }
        });


        setLayout(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,600);
        getContentPane().setBackground(Color.darkGray);
        setLocationRelativeTo(null);
        setTitle("Ticket Pricing");
        setVisible(true);
        add(label);
        add(arrComboBox);
        add(depComboBox);
        add(searchButton);
        add(depLabel);
        add(arrLabel);
        add(backButton);

    }



    public static void main(String[] args){
        TicketPricePage tpp=new TicketPricePage();

    }
}
