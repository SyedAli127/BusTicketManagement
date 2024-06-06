package Project.Customer;

import Project.Customer.BookNow.BookNowPage1;
import Project.Customer.UserProfile.SigninPage;
import Project.WelcomePage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerMenu extends JFrame {


    String cusID;
    public CustomerMenu(String cusID) {
        this.cusID = cusID;

        JLabel label=new JLabel();
        label.setText("Customer Menu");
        label.setBounds(200,1,190,75);
        label.setFont(new Font("Arial",Font.PLAIN,25));
        label.setForeground(Color.orange);

        JButton bookButton =new JButton();
        bookButton.setText("BOOK NOW");
        bookButton.setBounds(50,150,200,60);
        bookButton.setFont(new Font("Arial",Font.BOLD,15));

        bookButton.setBackground(Color.cyan);
        bookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                System.out.println("for book now");
                BookNowPage1 bookNowPage1=new BookNowPage1(cusID);
                dispose();

            }
        });

        JButton userProfButton=new JButton();
        userProfButton.setText("USER PROFILE");
        userProfButton.setBounds(320,150,200,60);
        userProfButton.setFont(new Font("Arial",Font.BOLD,15));
        userProfButton.setBackground(Color.cyan);

        userProfButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("for user prof");
                SigninPage upp=new SigninPage(cusID);
                dispose();
            }
        });

        JButton tickPrcButton=new JButton();
        tickPrcButton.setText("TICKET PRICE");
        tickPrcButton.setBounds(320,250,200,60);
        tickPrcButton.setFont(new Font("Arial",Font.BOLD,15));
        tickPrcButton.setBackground(Color.cyan);

        tickPrcButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.out.println("for ticket price");
                TicketPricePage tpp=new TicketPricePage(cusID);
                dispose();
            }
        });

        JButton bookHisButton=new JButton();
        bookHisButton.setText("BOOKING HISTORY");
        bookHisButton.setBounds(50,250,200,60);
        bookHisButton.setFont(new Font("Arial",Font.BOLD,15));
        bookHisButton.setBackground(Color.cyan);

        bookHisButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("for booking history");
                BookHistoryPage book=new BookHistoryPage(cusID);
                dispose();
            }
        });

        JButton busTimeButton=new JButton();
        busTimeButton.setText("BUS TIMING");
        busTimeButton.setBounds(50,350,200,60);
        busTimeButton.setFont(new Font("Arial",Font.BOLD,15));
        busTimeButton.setBackground(Color.cyan);

        busTimeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("for bus timing");
                BusTimingPage btp=new BusTimingPage(cusID);
                dispose();

            }
        });

        JButton refundButton=new JButton();
        refundButton.setText("REFUND");
        refundButton.setBounds(320,350,200,60);
        refundButton.setFont(new Font("Arial",Font.BOLD,15));
        refundButton.setBackground(Color.cyan);

        refundButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("for refund");
                RefundPage rp=new RefundPage(cusID);
                dispose();

            }
        });

        JButton feedbackButton=new JButton();
        feedbackButton.setText("FEEDBACK/COMPLAIN");
        feedbackButton.setBounds(50,450,200,60);
        feedbackButton.setFont(new Font("Arial",Font.BOLD,15));
        feedbackButton.setBackground(Color.cyan);

        feedbackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("for Feedback");
                FeedbackPage fbp=new FeedbackPage(cusID);
                dispose();
            }
        });

        JButton backButton=new JButton();
        backButton.setText("BACK");
        backButton.setBounds(320,450,200,60);
        backButton.setFont(new Font("Arial",Font.BOLD,15));
        backButton.setBackground(Color.cyan);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                WelcomePage wel=new WelcomePage();
                System.out.println("for back");
                dispose();
            }
        });


        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,600);
        setTitle("Customer Menu");
        setVisible(true);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(Color.darkGray);


        add(label);
        add(bookButton);
        add(userProfButton);
        add(tickPrcButton);
        add(bookHisButton);
        add(busTimeButton);
        add(refundButton);
        add(feedbackButton);
        add(backButton);

    }
    public static void main(String[] args){

        CustomerMenu cus= new CustomerMenu("Dummy");
    }
}
