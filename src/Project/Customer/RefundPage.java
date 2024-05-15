package Project.Customer;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RefundPage extends JFrame {

    JRadioButton r1,r2,r3;
    JTextField reasonTxt;
    public RefundPage() {

        JLabel label=new JLabel();
        label.setText("Refund Request Form");
        label.setFont(new Font("Ariel",Font.BOLD,21));
        label.setForeground(Color.orange);
        label.setBounds(190,20,280,25);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.darkGray);
        panel.setPreferredSize(new Dimension(500,780)); // Set preferred size


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


        JLabel orderIDLabel=new JLabel();
        orderIDLabel.setText("Order ID:");
        orderIDLabel.setBounds(10,130,100,50);
        orderIDLabel.setFont(new Font("Ariel",Font.BOLD,18));
        orderIDLabel.setForeground(Color.orange);

        JTextField orderIDTxt=new JTextField();
        orderIDTxt.setBounds(190,140,180,30);



        JLabel emailLabel=new JLabel();
        emailLabel.setText("Email:");
        emailLabel.setBounds(10,185,100,50);
        emailLabel.setFont(new Font("Ariel",Font.BOLD,18));
        emailLabel.setForeground(Color.orange);

        JTextField emailTxt=new JTextField();
        emailTxt.setBounds(190,195,180,30);

        JLabel buyingDateLabel=new JLabel();
        buyingDateLabel.setText("Booking Date:");
        buyingDateLabel.setBounds(10,230,150,50);
        buyingDateLabel.setFont(new Font("Ariel",Font.BOLD,18));
        buyingDateLabel.setForeground(Color.orange);

        JTextField buyingDateTxt=new JTextField();
        buyingDateTxt.setBounds(190,240,180,30);

        JLabel dateFormatLabel=new JLabel();
        dateFormatLabel.setText("(DD-MM-YYYY)");
        dateFormatLabel.setBounds(190,253,150,50);
        dateFormatLabel.setFont(new Font("Ariel",Font.PLAIN,11));
        dateFormatLabel.setForeground(Color.orange);

        JLabel reasonLabel=new JLabel();
        reasonLabel.setText("Reason for Refund:");
        reasonLabel.setBounds(10,285,180,50);
        reasonLabel.setFont(new Font("Ariel",Font.BOLD,18));
        reasonLabel.setForeground(Color.orange);

        r1=new JRadioButton("Change in travel plans");
        r2=new JRadioButton("Double booking");
        r3=new JRadioButton("Others");

        r1.setBounds(190,300,170,25);
        r2.setBounds(190,340,170,30);
        r3.setBounds(190,390,70,30);
        ButtonGroup group=new ButtonGroup();
        group.add(r1);
        group.add(r2);
        group.add(r3);

        reasonTxt=new JTextField();
        reasonTxt.setBounds(300,390,170,30);

        JLabel additionalNoteLabel =new JLabel();
        additionalNoteLabel.setText("Additional Note:");
        additionalNoteLabel.setBounds(10,440,150,50);
        additionalNoteLabel.setFont(new Font("Ariel",Font.BOLD,18));
        additionalNoteLabel.setForeground(Color.orange);

        JTextField noteTxt=new JTextField();
        noteTxt.setBounds(190,455,280,150);

        JButton submitButton=new JButton();
        submitButton.setText("Submit");
        submitButton.setBounds(280,680,110,40);
        submitButton.setBackground(Color.cyan);
        submitButton.setEnabled(false);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                CustomerMenu cm=new CustomerMenu();
                dispose();
                System.out.println(getSelectedRadioButtonValue());


            }
        });

        JCheckBox agreecheckbox=new JCheckBox();
        agreecheckbox.setText("i agree the Terms & Conditions");
        agreecheckbox.setBounds(190,620,220,30);
        agreecheckbox.setBackground(Color.darkGray);
        agreecheckbox.setForeground(Color.orange);
        agreecheckbox.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {

                submitButton.setEnabled(agreecheckbox.isSelected());
            }
        });

        JButton backButton=new JButton();
        backButton.setText("Back");
        backButton.setBounds(130,680,110,40);
        backButton.setBackground(Color.cyan);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                CustomerMenu cm=new CustomerMenu();
                dispose();

            }
        });

        setLayout(null);
        setSize(600,600);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        getContentPane().setBackground(Color.darkGray);
        setTitle("Refund Page");
        setLocationRelativeTo(null);


        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(0, 0, 584, 600); // Set the bounds of the scroll pane to match the JFrame
        getContentPane().add(scrollPane);

        panel.add(label);
        panel.add(fullnameLabel);
        panel.add(firstnameTxt);
        panel.add(firstNameLabel);
        panel.add(lastNameTxt);
        panel.add(lastNameLabel);
        panel.add(orderIDLabel);
        panel.add(orderIDTxt);
        panel.add(emailLabel);
        panel.add(emailTxt);
        panel.add(buyingDateLabel);
        panel.add(buyingDateTxt);
        panel.add(dateFormatLabel);
        panel.add(r1);
        panel.add(r2);
        panel.add(r3);
        panel.add(reasonLabel);
        panel.add(backButton);
        panel.add(reasonTxt);
        panel.add(additionalNoteLabel);
        panel.add(noteTxt);
        panel.add(submitButton);
        panel.add(agreecheckbox);



    }

    private String getSelectedRadioButtonValue() {
        if (r1.isSelected()) {
            return r1.getText();
        }
        else if (r2.isSelected()) {
            return r2.getText();
        }
        else if (r3.isSelected()) {
            return reasonTxt.getText();
        }
        else {
            return "No option selected";
        }
    }
    public static void main(String[] args)
    {
        RefundPage rp=new RefundPage();
    }

}
