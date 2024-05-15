package Project.Customer.BookNow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BookNowPage2 extends JFrame {

    JComboBox selectBusTypeComboBox;

    public BookNowPage2()
    {
        JLabel label=new JLabel();
        label.setText("Plan Your Journey");
        label.setBounds(220,20,180,50);
        label.setFont(new Font("Ariel",Font.BOLD,20));
        label.setForeground(Color.orange);

        JLabel promoCodeLabel=new JLabel();
        promoCodeLabel.setText("Promo Code:");
        promoCodeLabel.setBounds(10,90,120,50);
        promoCodeLabel.setFont(new Font("Ariel",Font.BOLD,18));
        promoCodeLabel.setForeground(Color.orange);

        JTextField promoCodeTxt=new JTextField();
        promoCodeTxt.setBounds(240,100,150,30);

        JLabel optionalLabel =new JLabel();
        optionalLabel.setText("(Optional)");
        optionalLabel.setBounds(240,115,150,50);
        optionalLabel.setFont(new Font("Ariel",Font.PLAIN,11));
        optionalLabel.setForeground(Color.orange);

        JLabel paymentLabel=new JLabel();
        paymentLabel.setText("Select Payment Method:");
        paymentLabel.setBounds(10,150,230,50);
        paymentLabel.setFont(new Font("Ariel",Font.BOLD,18));
        paymentLabel.setForeground(Color.orange);

        String[] paymentMethod ={"-","Paypal","Credit Card"};
        selectBusTypeComboBox=new JComboBox<>(paymentMethod);
        selectBusTypeComboBox.setBounds(240,160,150,35);
        selectBusTypeComboBox.setBackground(Color.orange);

        JLabel cardNumLabel=new JLabel();
        cardNumLabel.setText("Card Number:");
        cardNumLabel.setBounds(10,200,230,50);
        cardNumLabel.setFont(new Font("Ariel",Font.BOLD,18));
        cardNumLabel.setForeground(Color.orange);

        JTextField cardNumTxt=new JTextField();
        cardNumTxt.setBounds(240,210,150,30);

        JLabel cardNameLabel=new JLabel();
        cardNameLabel.setText("Name On Card:");
        cardNameLabel.setBounds(10,250,230,50);
        cardNameLabel.setFont(new Font("Ariel",Font.BOLD,18));
        cardNameLabel.setForeground(Color.orange);

        JTextField cardNameTxt=new JTextField();
        cardNameTxt.setBounds(240,260,150,30);

        JLabel cvvLabel=new JLabel();
        cvvLabel.setText("CVV:");
        cvvLabel.setBounds(10,300,230,50);
        cvvLabel.setFont(new Font("Ariel",Font.BOLD,18));
        cvvLabel.setForeground(Color.orange);

        JTextField cvvTxt=new JTextField();
        cvvTxt.setBounds(240,310,150,30);

        JLabel expDetLabel =new JLabel();
        expDetLabel.setText("Expiry Date Details:");
        expDetLabel.setBounds(10,350,230,50);
        expDetLabel.setFont(new Font("Ariel",Font.BOLD,18));
        expDetLabel.setForeground(Color.orange);

        JTextField expDetMonTxt=new JTextField();
        expDetMonTxt.setBounds(240,360,40,30);

        JTextField expDetYearTxt=new JTextField();
        expDetYearTxt.setBounds(290,360,40,30);


        JLabel monthLabel =new JLabel();
        monthLabel.setText("(Month)");
        monthLabel.setBounds(240,375,150,50);
        monthLabel.setFont(new Font("Ariel",Font.PLAIN,11));
        monthLabel.setForeground(Color.orange);

        JLabel yearLabel =new JLabel();
        yearLabel.setText("(Year)");
        yearLabel.setBounds(290,375,150,50);
        yearLabel.setFont(new Font("Ariel",Font.PLAIN,11));
        yearLabel.setForeground(Color.orange);


        JButton confirmButton=new JButton();
        confirmButton.setText("Confirm");
        confirmButton.setBounds(250,440,110,40);
        confirmButton.setBackground(Color.cyan);

        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ConfirmPage cp=new ConfirmPage();

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

        add(label);
        add(promoCodeLabel);
        add(promoCodeTxt);
        add(optionalLabel);
        add(paymentLabel);
        add(selectBusTypeComboBox);
        add(cardNumTxt);
        add(cardNumLabel);
        add(cardNameLabel);
        add(cardNameTxt);
        add(cvvLabel);
        add(cvvTxt);
        add(expDetLabel);
        add(expDetMonTxt);
        add(expDetYearTxt);
        add(monthLabel);
        add(yearLabel);
        add(confirmButton);
    }

    public static void main(String[] args)
    {
        BookNowPage2 rp=new BookNowPage2();
    }
}
