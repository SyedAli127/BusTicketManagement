package Project.Customer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FeedbackPage extends JFrame {

    JRadioButton r1,r2,r3,r4,r5;
    public FeedbackPage() {

        JLabel label=new JLabel();
        label.setText("Share Us Your FeedBack");
        label.setFont(new Font("Ariel",Font.BOLD,21));
        label.setForeground(Color.orange);
        label.setBounds(190,20,280,20);

        JLabel fullnameLabel=new JLabel();
        fullnameLabel.setText("Full Name:");
        fullnameLabel.setBounds(10,65,100,50);
        fullnameLabel.setFont(new Font("Ariel",Font.BOLD,18));
        fullnameLabel.setForeground(Color.orange);

        JTextField firstnameTxt=new JTextField();
        firstnameTxt.setBounds(130,75,150,30);

        JLabel firstNameLabel=new JLabel();
        firstNameLabel.setText("First Name");
        firstNameLabel.setBounds(130,90,100,50);
        firstNameLabel.setFont(new Font("Ariel",Font.BOLD,12));
        firstNameLabel.setForeground(Color.orange);

        JTextField lastNameTxt=new JTextField();
        lastNameTxt.setBounds(300,75,150,30);

        JLabel lastNameLabel=new JLabel();
        lastNameLabel.setText("Last Name");
        lastNameLabel.setBounds(300,90,100,50);
        lastNameLabel.setFont(new Font("Ariel",Font.BOLD,12));
        lastNameLabel.setForeground(Color.orange);

        JLabel orderIDLabel=new JLabel();
        orderIDLabel.setText("Order ID:");
        orderIDLabel.setBounds(10,130,100,50);
        orderIDLabel.setFont(new Font("Ariel",Font.BOLD,18));
        orderIDLabel.setForeground(Color.orange);

        JTextField orderIDTxt=new JTextField();
        orderIDTxt.setBounds(130,140,180,30);


        JLabel emailLabel=new JLabel();
        emailLabel.setText("Email:");
        emailLabel.setBounds(10,185,100,50);
        emailLabel.setFont(new Font("Ariel",Font.BOLD,18));
        emailLabel.setForeground(Color.orange);

        JTextField emailTxt=new JTextField();
        emailTxt.setBounds(130,195,180,30);


        JLabel ratingLabel=new JLabel();
        ratingLabel.setText("Overall Satisfaction:");
        ratingLabel.setBounds(10,235,180,50);
        ratingLabel.setFont(new Font("Ariel",Font.BOLD,18));
        ratingLabel.setForeground(Color.orange);

        //RADIO BUTTONS
        r1=new JRadioButton("1");
        r2=new JRadioButton("2");
        r3=new JRadioButton("3");
        r4=new JRadioButton("4");
        r5=new JRadioButton("5");

        r1.setBounds(200,245,40,30);
        r2.setBounds(250,245,40,30);
        r3.setBounds(300,245,40,30);
        r4.setBounds(350,245,40,30);
        r5.setBounds(400,245,40,30);

        ButtonGroup group=new ButtonGroup();
        group.add(r1);
        group.add(r2);
        group.add(r3);
        group.add(r4);
        group.add(r5);

        JLabel terribleLabel=new JLabel();
        terribleLabel.setText("(Terrible)");
        terribleLabel.setBounds(200,265,48,50);
        terribleLabel.setFont(new Font("Ariel",Font.PLAIN,11));
        terribleLabel.setForeground(Color.orange);

        JLabel lovelyLabel=new JLabel();
        lovelyLabel.setText("(Lovely)");
        lovelyLabel.setBounds(400,265,40,50);
        lovelyLabel.setFont(new Font("Ariel",Font.PLAIN,11));
        lovelyLabel.setForeground(Color.orange);

        JLabel thoughtLabel=new JLabel();
        thoughtLabel.setText("Share us your thought:");
        thoughtLabel.setBounds(10,310,250,50);
        thoughtLabel.setFont(new Font("Ariel",Font.BOLD,18));
        thoughtLabel.setForeground(Color.orange);
        JTextField thoughtTxt=new JTextField();
        thoughtTxt.setBounds(230,320,250,120);


        JButton submitButton=new JButton();
        submitButton.setText("Submit");
        submitButton.setBounds(300,470,110,40);
        submitButton.setBackground(Color.cyan);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(firstnameTxt.getText());
                System.out.println(lastNameTxt.getText());
                System.out.println(orderIDTxt.getText());
                System.out.println(emailTxt.getText());
                System.out.println(thoughtTxt.getText());
                System.out.println(getSelectedRadioButtonValue());
                dispose();
                CustomerMenu cm=new CustomerMenu();

            }
        });

        JButton backButton=new JButton();
        backButton.setText("Back");
        backButton.setBounds(140,470,110,40);
        backButton.setBackground(Color.cyan);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CustomerMenu cm=new CustomerMenu();
                dispose();
            }
        });

        //JFrame
        setSize(600,600);
        setTitle("FeedBack Page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setVisible(true);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.darkGray);
        setResizable(false);

        add(label);
        add(fullnameLabel);
        add(firstnameTxt);
        add(firstNameLabel);
        add(lastNameTxt);
        add(lastNameLabel);
        add(orderIDLabel);
        add(orderIDTxt);
        add(emailLabel);
        add(emailTxt);
        add(ratingLabel);
        add(r1);
        add(r2);
        add(r3);
        add(r4);
        add(r5);
        add(terribleLabel);
        add(lovelyLabel);
        add(thoughtLabel);
        add(thoughtTxt);
        add(submitButton);
        add(backButton);

    }
    private String getSelectedRadioButtonValue() {
        if (r1.isSelected()) {
            return r1.getText();
        } else if (r2.isSelected()) {
            return r2.getText();
        } else if (r3.isSelected()) {
            return r3.getText();
        } else if (r4.isSelected()) {
            return r4.getText();
        } else if (r5.isSelected()) {
            return r5.getText();
        } else {
            return "No option selected";
        }
    }
    public static void main(String[] args)
    {
        FeedbackPage fdp=new FeedbackPage();
    }
}
