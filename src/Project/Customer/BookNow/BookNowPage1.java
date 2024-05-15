package Project.Customer.BookNow;

import Project.Customer.CustomerMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BookNowPage1 extends JFrame {

    JComboBox depComboBox, arrComboBox, selectDateComboBox,selectBusTypeComboBox;
    JPanel panel;
    public BookNowPage1() {

        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.darkGray);
        panel.setPreferredSize(new Dimension(500,720));

        JLabel label=new JLabel();
        label.setText("Plan Your Journey");
        label.setBounds(220,20,180,50);
        label.setFont(new Font("Ariel",Font.BOLD,20));
        label.setForeground(Color.orange);

        JLabel depLabel=new JLabel();
        depLabel.setText("Departure");
        depLabel.setBounds(50,70,150,35);
        depLabel.setFont(new Font("Ariel",Font.BOLD,12));
        depLabel.setForeground(Color.orange);

        String [] departure ={"-","Karachi","Lahore","Islamabad","Quetta","Hyderabad"};
        arrComboBox=new JComboBox<>(departure);
        arrComboBox.setBounds(50,100,150,35);
        arrComboBox.setBackground(Color.YELLOW);


        JLabel arrLabel=new JLabel();
        arrLabel.setText("Arrival");
        arrLabel.setBounds(240,70,150,35);
        arrLabel.setFont(new Font("Ariel",Font.BOLD,12));
        arrLabel.setForeground(Color.orange);

        String [] arrival ={"-","Karachi","Lahore","Islamabad","Quetta","Hyderabad"};
        depComboBox =new JComboBox<>(arrival);
        depComboBox.setBounds(240,100,150,35);
        depComboBox.setBackground(Color.YELLOW);


        JLabel selLabel=new JLabel();
        selLabel.setText("Select Date");
        selLabel.setBounds(420,70,150,35);
        selLabel.setFont(new Font("Ariel",Font.BOLD,12));
        selLabel.setForeground(Color.orange);


        String[] selectDate ={"-","1/5/24","2/5/24","3/5/24","4/4/24","5/5/24"};
        selectDateComboBox=new JComboBox<>(selectDate);
        selectDateComboBox.setBounds(420,100,150,35);
        selectDateComboBox.setBackground(Color.YELLOW);


        JLabel busTypeLabel=new JLabel();
        busTypeLabel.setText("Bus Type");
        busTypeLabel.setBounds(10,150,150,50);
        busTypeLabel.setFont(new Font("Ariel",Font.BOLD,18));
        busTypeLabel.setForeground(Color.orange);

        String[] bustype ={"-","Economy","Luxury","First-Class"};
        selectBusTypeComboBox=new JComboBox<>(bustype);
        selectBusTypeComboBox.setBounds(240,160,150,35);
        selectBusTypeComboBox.setBackground(Color.orange);

        JLabel seatSelectionLabel=new JLabel();
        seatSelectionLabel.setText("Seat Selection");
        seatSelectionLabel.setBounds(10,200,150,50);
        seatSelectionLabel.setFont(new Font("Ariel",Font.BOLD,18));
        seatSelectionLabel.setForeground(Color.orange);

        // Add action listener to the bus type combo box
        selectBusTypeComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedBusType = (String) selectBusTypeComboBox.getSelectedItem();
                generateSeatSelectionCheckboxes(selectedBusType);
            }
        });



        JLabel fullnameLabel=new JLabel();
        fullnameLabel.setText("Full Name:");
        fullnameLabel.setBounds(10,290,100,50);
        fullnameLabel.setFont(new Font("Ariel",Font.BOLD,18));
        fullnameLabel.setForeground(Color.orange);

        JTextField firstnameTxt=new JTextField();
        firstnameTxt.setBounds(190,300,150,30);

        JLabel firstNameLabel=new JLabel();
        firstNameLabel.setText("First Name");
        firstNameLabel.setBounds(190,315,100,50);
        firstNameLabel.setFont(new Font("Ariel",Font.BOLD,12));
        firstNameLabel.setForeground(Color.orange);

        JTextField lastNameTxt=new JTextField();
        lastNameTxt.setBounds(360,300,150,30);

        JLabel lastNameLabel=new JLabel();
        lastNameLabel.setText("Last Name");
        lastNameLabel.setBounds(360,315,100,50);
        lastNameLabel.setFont(new Font("Ariel",Font.BOLD,12));
        lastNameLabel.setForeground(Color.orange);

        JLabel phoneNoLabel=new JLabel();
        phoneNoLabel.setText("Phone No:");
        phoneNoLabel.setBounds(10,350,100,50);
        phoneNoLabel.setFont(new Font("Ariel",Font.BOLD,18));
        phoneNoLabel.setForeground(Color.orange);

        JTextField phoneNoTxt =new JTextField();
        phoneNoTxt.setBounds(190,360,180,30);


        JLabel cnicLabel=new JLabel();
        cnicLabel.setText("CNIC/Passport:");
        cnicLabel.setBounds(10,400,150,50);
        cnicLabel.setFont(new Font("Ariel",Font.BOLD,18));
        cnicLabel.setForeground(Color.orange);

        JTextField cnicTxt=new JTextField();
        cnicTxt.setBounds(190,410,180,30);

        JLabel emailLabel=new JLabel();
        emailLabel.setText("Email:");
        emailLabel.setBounds(10,450,100,50);
        emailLabel.setFont(new Font("Ariel",Font.BOLD,18));
        emailLabel.setForeground(Color.orange);

        JTextField emailTxt=new JTextField();
        emailTxt.setBounds(190,460,180,30);


        JLabel cityLabel=new JLabel();
        cityLabel.setText("City:");
        cityLabel.setBounds(10,500,150,50);
        cityLabel.setFont(new Font("Ariel",Font.BOLD,18));
        cityLabel.setForeground(Color.orange);

        JTextField cityTxt=new JTextField();
        cityTxt.setBounds(190,510,180,30);

        JLabel addressLabel=new JLabel();
        addressLabel.setText("Address:");
        addressLabel.setBounds(10,550,150,50);
        addressLabel.setFont(new Font("Ariel",Font.BOLD,18));
        addressLabel.setForeground(Color.orange);

        JTextField addressTxt=new JTextField();
        addressTxt.setBounds(190,560,180,30);

        JButton nextButton=new JButton();
        nextButton.setText("Next");
        nextButton.setBounds(300,620,110,40);
        nextButton.setBackground(Color.cyan);

        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                BookNowPage2 rp=new BookNowPage2();

                dispose();

            }
        });

        JButton backButton=new JButton();
        backButton.setText("Back");
        backButton.setBounds(150,620,120,40);
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
        setTitle("Booking Page");
        setVisible(true);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(Color.darkGray);

        panel.add(label);
        panel.add(arrComboBox);
        panel.add(depComboBox);
        panel.add(depLabel);
        panel.add(arrLabel);
        panel.add(selectDateComboBox);
        panel.add(selLabel);
        panel.add(busTypeLabel);
        panel.add(selectBusTypeComboBox);
        panel.add(seatSelectionLabel);
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
        panel.add(cityLabel);
        panel.add(cityTxt);
        panel.add(addressLabel);
        panel.add(addressTxt);
        panel.add(nextButton);
        panel.add(backButton);

        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(0, 0, 590, 600); // Set the bounds of the scroll pane to match the JFrame
        add(scrollPane);



    }

    private void generateSeatSelectionCheckboxes(String busType) {
        JPanel seatSelectionPanel = new JPanel();
        seatSelectionPanel.setBounds(150, 200, 400, 100);
        seatSelectionPanel.setLayout(new GridLayout(3, 4));
        seatSelectionPanel.setBackground(Color.darkGray);

        // Define seat numbers for each bus type
        int totalSeats;
        if (busType.equals("Economy")) {
            totalSeats = 20;
        } else if (busType.equals("Luxury")) {
            totalSeats = 10;
        } else if (busType.equals("First-Class")) {
            totalSeats = 5;
        } else {
            totalSeats = 0;
        }

        JCheckBox checkBox;
        // Create checkboxes for seat selection
        if(busType.equals("Economy"))
        {
            for (int i = 1; i <= totalSeats; i++) {

                checkBox = new JCheckBox("A " + i);
                checkBox.setForeground(Color.orange);
                checkBox.setBackground(Color.darkGray);
                seatSelectionPanel.add(checkBox);
            }
        }

        else if (busType.equals("Luxury"))
        {
            for (int i = 1; i <= totalSeats; i++) {

                checkBox = new JCheckBox("B "+i);
                checkBox.setForeground(Color.orange);
                checkBox.setBackground(Color.darkGray);
                seatSelectionPanel.add(checkBox);
            }
        }

        else if (busType.equals("First-Class"))
        {
            for (int i = 1; i <= totalSeats; i++) {

                checkBox = new JCheckBox("C " + i);
                checkBox.setForeground(Color.orange);
                checkBox.setBackground(Color.darkGray);
                seatSelectionPanel.add(checkBox);
            }

        }

        panel.add(seatSelectionPanel);

    }

    public static void main(String[] args)
    {
        BookNowPage1 rp=new BookNowPage1();
    }
}
