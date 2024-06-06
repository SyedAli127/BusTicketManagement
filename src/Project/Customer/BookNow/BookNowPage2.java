package Project.Customer.BookNow;

import Project.Database;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class BookNowPage2 extends JFrame {

    JComboBox selectMethodComboBox;
    String cusID,departure,arrival,date,bookID;
    int KM;
    ArrayList<JCheckBox> econCheckBoxList,luxCheckBoxList,firstClassCheckBoxList;
    Connection conn= Database.setConnection();
    public BookNowPage2(String cusID,String bookID,int KM, String departure, String arrival, String date
            ,ArrayList<JCheckBox> econCheckBoxList,ArrayList<JCheckBox> luxCheckBoxList,ArrayList<JCheckBox> firstClassCheckBoxList)
    {
        this.cusID=cusID;
        this.bookID=bookID;
        this.KM=KM;
        this.departure=departure;
        this.arrival=arrival;
        this.date=date;
        this.econCheckBoxList=econCheckBoxList;
        this.luxCheckBoxList=luxCheckBoxList;
        this.firstClassCheckBoxList=firstClassCheckBoxList;

        System.out.println("Departure= "+departure);
        System.out.println("Arrival= "+arrival);
        System.out.println("KM= "+KM);
        System.out.println("Date= "+date);
        System.out.println("Book ID= "+bookID);


        JLabel label=new JLabel();
        label.setText("Plan Your Journey");
        label.setBounds(220,20,180,50);
        label.setFont(new Font("Arial",Font.BOLD,20));
        label.setForeground(Color.orange);

        JLabel promoCodeLabel=new JLabel();
        promoCodeLabel.setText("Promo Code:");
        promoCodeLabel.setBounds(10,90,120,50);
        promoCodeLabel.setFont(new Font("Arial",Font.BOLD,18));
        promoCodeLabel.setForeground(Color.orange);

        JTextField promoCodeTxt=new JTextField();
        promoCodeTxt.setBounds(240,100,150,30);

        JLabel optionalLabel =new JLabel();
        optionalLabel.setText("(Optional)");
        optionalLabel.setBounds(240,115,150,50);
        optionalLabel.setFont(new Font("Arial",Font.PLAIN,11));
        optionalLabel.setForeground(Color.orange);

        JLabel paymentLabel=new JLabel();
        paymentLabel.setText("Select Payment Method:");
        paymentLabel.setBounds(10,150,230,50);
        paymentLabel.setFont(new Font("Arial",Font.BOLD,18));
        paymentLabel.setForeground(Color.orange);

        String[] paymentMethod ={"-","Cash","Credit Card"};
        selectMethodComboBox=new JComboBox<>(paymentMethod);
        selectMethodComboBox.setBounds(240,160,150,35);
        selectMethodComboBox.setBackground(Color.orange);



        JLabel cardNumLabel=new JLabel();
        cardNumLabel.setText("Card Number:");
        cardNumLabel.setBounds(10,200,230,50);
        cardNumLabel.setFont(new Font("Arial",Font.BOLD,18));
        cardNumLabel.setForeground(Color.orange);
        cardNumLabel.setVisible(false);

        JTextField cardNumTxt=new JTextField();
        cardNumTxt.setBounds(240,210,150,30);
        cardNumTxt.setVisible(false);

        JLabel cardNameLabel=new JLabel();
        cardNameLabel.setText("Name On Card:");
        cardNameLabel.setBounds(10,250,230,50);
        cardNameLabel.setFont(new Font("Arial",Font.BOLD,18));
        cardNameLabel.setForeground(Color.orange);
        cardNameLabel.setVisible(false);

        JTextField cardNameTxt=new JTextField();
        cardNameTxt.setBounds(240,260,150,30);
        cardNameTxt.setVisible(false);

        JLabel cvvLabel=new JLabel();
        cvvLabel.setText("CVV:");
        cvvLabel.setBounds(10,300,230,50);
        cvvLabel.setFont(new Font("Arial",Font.BOLD,18));
        cvvLabel.setForeground(Color.orange);
        cvvLabel.setVisible(false);

        JTextField cvvTxt=new JTextField();
        cvvTxt.setBounds(240,310,150,30);
        cvvTxt.setVisible(false);

        JLabel expDetLabel =new JLabel();
        expDetLabel.setText("Expiry Date Details:");
        expDetLabel.setBounds(10,350,230,50);
        expDetLabel.setFont(new Font("Arial",Font.BOLD,18));
        expDetLabel.setForeground(Color.orange);
        expDetLabel.setVisible(false);
        JTextField expDetMonTxt=new JTextField();
        expDetMonTxt.setBounds(240,360,40,30);
        expDetMonTxt.setVisible(false);

        JTextField expDetYearTxt=new JTextField();
        expDetYearTxt.setBounds(290,360,40,30);
        expDetYearTxt.setVisible(false);

        JLabel monthLabel =new JLabel();
        monthLabel.setText("(Month)");
        monthLabel.setBounds(240,375,150,50);
        monthLabel.setFont(new Font("Arial",Font.PLAIN,11));
        monthLabel.setForeground(Color.orange);
        monthLabel.setVisible(false);

        JLabel yearLabel =new JLabel();
        yearLabel.setText("(Year)");
        yearLabel.setBounds(290,375,150,50);
        yearLabel.setFont(new Font("Arial ",Font.PLAIN,11));
        yearLabel.setForeground(Color.orange);
        yearLabel.setVisible(false);


        JButton confirmButton=new JButton();
        confirmButton.setText("Confirm");
        confirmButton.setBounds(250,440,110,40);
        confirmButton.setBackground(Color.cyan);
        confirmButton.setVisible(false);

        selectMethodComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(selectMethodComboBox.getSelectedItem()=="Cash"){
                    confirmButton.setBounds(250,220,110,40);
                    confirmButton.setVisible(true);

                    cardNumLabel.setVisible(false);
                    cardNumTxt.setVisible(false);
                    cardNameLabel.setVisible(false);
                    cardNameTxt.setVisible(false);
                    cvvLabel.setVisible(false);
                    cvvTxt.setVisible(false);
                    expDetLabel.setVisible(false);
                    expDetMonTxt.setVisible(false);
                    monthLabel.setVisible(false);
                    yearLabel.setVisible(false);
                    expDetYearTxt.setVisible(false);

                }
                else if(selectMethodComboBox.getSelectedItem()=="Credit Card"){
                    cardNumLabel.setVisible(true);
                    cardNumTxt.setVisible(true);
                    cardNameLabel.setVisible(true);
                    cardNameTxt.setVisible(true);
                    cvvLabel.setVisible(true);
                    cvvTxt.setVisible(true);
                    expDetLabel.setVisible(true);
                    expDetMonTxt.setVisible(true);
                    monthLabel.setVisible(true);
                    yearLabel.setVisible(true);
                    expDetYearTxt.setVisible(true);
                    confirmButton.setBounds(250,440,110,40);
                    confirmButton.setVisible(true);

                }
            }
        });


        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                List<Integer> EconIDs = new ArrayList<>();
                List<Integer> luxIDs = new ArrayList<>();
                List<Integer> FCIDs = new ArrayList<>();
                List<String> econSeats = new ArrayList<>();
                List<String> luxSeats = new ArrayList<>();
                List<String> firstClassSeats = new ArrayList<>();

                int econS=0,luxS=0,firstClassS=0;
                int promoCodeID =0,remainUse=0;
                float discount=0;
                int econSeatPrice=0;
                int luxSeatPrice=0;
                int firstClassSeatPrice=0;
                int KMPrice=0;
                String query="Select PromoCodeID,RemainingTimeUsed,DiscountPercentage from PromoCode where Code=? and RemainingTimeUsed>0 and status='Active'";
                String RemainUseQuery="Update PromoCode set RemainingTimeUsed=? where PromoCodeID=? and Code=?";
                String priceIDQuery="Select p.EconomySeatPrice,p.LuxurySeatPrice,p.FirstClassSeatPrice,p.KMPrice from booking b " +
                        "join price p on b.PriceID=p.PriceID where BookID=?";
                try
                {
                    PreparedStatement psmt=conn.prepareStatement(query);
                    psmt.setString(1,promoCodeTxt.getText());
                    ResultSet rs= psmt.executeQuery();
                    while (rs.next())
                    {
                        promoCodeID =rs.getInt("PromoCodeID");
                        remainUse=rs.getInt("RemainingTimeUsed");
                        discount=rs.getFloat("DiscountPercentage");
                    }
                    remainUse--;
                    PreparedStatement pst=conn.prepareStatement(RemainUseQuery);
                    pst.setInt(1,remainUse);
                    pst.setInt(2, promoCodeID);
                    pst.setString(3,promoCodeTxt.getText());
                    pst.executeUpdate();

                    PreparedStatement preparedStatement=conn.prepareStatement(priceIDQuery);
                    preparedStatement.setInt(1,Integer.parseInt(bookID));
                    ResultSet resultSet=preparedStatement.executeQuery();
                    while (resultSet.next())
                    {
                        econSeatPrice=resultSet.getInt("EconomySeatPrice");
                        luxSeatPrice=resultSet.getInt("LuxurySeatPrice");
                        firstClassSeatPrice=resultSet.getInt("FirstClassSeatPrice");
                        KMPrice=resultSet.getInt("KMPrice");
                    }
                    System.out.println("BookingID= "+bookID);

                    for (JCheckBox checkBox : econCheckBoxList) {
                        if (checkBox.isSelected()) {
                            econS++;
                            String updateSeats="update EconomySeat  set IsBooked=1" +
                                    "where SeatNo=? and BusID=("+
                                    "select BusID from Booking " +
                                    "where BookID=? )";
                            PreparedStatement ps=conn.prepareStatement(updateSeats);
                            ps.setString(1,checkBox.getText());
                            ps.setInt(2,Integer.parseInt(bookID));
                            ps.executeUpdate();
                        }
                    }

                    for (JCheckBox checkBox : luxCheckBoxList) {
                        if (checkBox.isSelected()) {
                            luxS++;
                            String updateSeats="update LuxurySeat  set IsBooked=1" +
                                    "where SeatNo=? and BusID=("+
                                    "select BusID from Booking " +
                                    "where BookID=? )";
                            PreparedStatement ps=conn.prepareStatement(updateSeats);
                            ps.setString(1,checkBox.getText());
                            ps.setInt(2,Integer.parseInt(bookID));
                            ps.executeUpdate();
                        }
                    }
                    for (JCheckBox checkBox : firstClassCheckBoxList) {
                        if (checkBox.isSelected()) {
                            firstClassS++;
                            String updateSeats="update FirstClassSeat  set IsBooked=1" +
                                    "where SeatNo=? and BusID=("+
                                    "select BusID from Booking " +
                                    "where BookID=? )";
                            PreparedStatement ps=conn.prepareStatement(updateSeats);
                            ps.setString(1,checkBox.getText());
                            ps.setInt(2,Integer.parseInt(bookID));
                            ps.executeUpdate();
                        }
                    }


                    for (JCheckBox checkBox : econCheckBoxList) {
                        if (checkBox.isSelected()) {
                            String econQuery="select EconID from EconomySeat where IsBooked=1 and SeatNo=? and busID=(Select BusID from Booking where BookID=? )";
                            PreparedStatement econPst=conn.prepareStatement(econQuery);
                            econPst.setString(1,checkBox.getText());
                            econPst.setInt(2,Integer.parseInt(bookID));
                            ResultSet econRs=econPst.executeQuery();
                            while (econRs.next())
                            {
                                int econID = econRs.getInt("EconID");
                                EconIDs.add(econID);
                                System.out.println("Econ IDs "+econID);
                            }
                        }
                    }

                    for (JCheckBox checkBox : luxCheckBoxList) {
                        if (checkBox.isSelected()) {
                            String luxQuery="Select LuxID from LuxurySeat where IsBooked=1 and SeatNo=? and busID=(Select BusID from Booking where BookID=?) ";
                            PreparedStatement luxPst=conn.prepareStatement(luxQuery);
                            luxPst.setString(1,checkBox.getText());
                            luxPst.setInt(2,Integer.parseInt(bookID));
                            ResultSet luxRs=luxPst.executeQuery();
                            while (luxRs.next())
                            {
                                int luxID = luxRs.getInt("LuxID");
                                luxIDs.add(luxID);
                            }
                        }
                    }

                    for (JCheckBox checkBox : firstClassCheckBoxList) {
                        if (checkBox.isSelected()) {
                            String FCQuery="Select FCID from FirstClassSeat where IsBooked=1 and SeatNo=? and busID=(Select BusID from Booking where BookID=?) ";
                            PreparedStatement fcPst=conn.prepareStatement(FCQuery);
                            fcPst.setString(1,checkBox.getText());
                            fcPst.setInt(2,Integer.parseInt(bookID));
                            ResultSet fcRs =fcPst.executeQuery();
                            while (fcRs.next())
                            {
                                int fcID = fcRs.getInt("FCID");
                                FCIDs.add(fcID);
                            }
                        }
                    }

                }
                catch (SQLException ex)
                {
                    throw new RuntimeException(ex);
                }
                if(promoCodeID ==0)
                {
                    JOptionPane.showMessageDialog(null, "PromoCode not activated!", "Error", JOptionPane.INFORMATION_MESSAGE);

                }
                else{
                    JOptionPane.showMessageDialog(null, "PromoCode Activated!", "Error", JOptionPane.INFORMATION_MESSAGE);
                }

                int totalEconPrice=((KM*KMPrice)+((econSeatPrice*econS)+(luxSeatPrice*luxS)+(firstClassSeatPrice*firstClassS)));

                System.out.println("Total Before PromoCode="+totalEconPrice);
                System.out.println("Discount= "+discount);
                float total=totalEconPrice-((totalEconPrice*discount)/100);

                System.out.println("Total Price after PromoCode= "+total);
                String taxQuery="select TaxPercentage from Tax";
                try {
                    PreparedStatement pst=conn.prepareStatement(taxQuery);
                    ResultSet rs=pst.executeQuery();
                    while (rs.next())
                    {
                        float taxPer=rs.getFloat("TaxPercentage");
                        System.out.println("Tax= "+taxPer);
                        total=(total+((total*taxPer)/100));
                    }
                }
                catch (SQLException ex)
                {
                    throw new RuntimeException(ex);
                }

                System.out.println("Total Price After taxes= "+total);
                StringBuilder orderDescription = new StringBuilder();
                orderDescription.append("Departure= "+departure+", ").append("Arrival= "+arrival+", ").append("Economy Seats= "+Integer.toString(econS)+", ")
                        .append("Luxury Seats= "+Integer.toString(luxS)+", ").append("FirstClass Seats= "+Integer.toString(firstClassS)+", ");

                String insertQuery="insert into Orders(BookID,CusID,PromoCodeID,OrderDetails,OrderDate,TotalPrice) values(?,?,?,?,?,?)";
                String orderIDQuery="Select max(OrderID) as 'Max' from Orders ";
                int orderID=0;
                try {
                    PreparedStatement pst=conn.prepareStatement(insertQuery);
                    pst.setInt(1,Integer.parseInt(bookID));
                    pst.setInt(2,Integer.parseInt(cusID));
                    if(promoCodeID==0)
                    {
                        pst.setString(3,null);

                    }else{

                        pst.setInt(3,promoCodeID);
                    }
                    pst.setString(4,orderDescription.toString());
                    pst.setDate(5,getCurrentSqlDate());
                    pst.setFloat(6,total);
                    pst.executeUpdate();

                    PreparedStatement psmt=conn.prepareStatement(orderIDQuery);
                    ResultSet rs=psmt.executeQuery();
                    while (rs.next())
                    {
                        orderID=rs.getInt("Max");
                    }

                    System.out.println("OrderID="+orderID);

                    for (Integer econID : EconIDs) {
                        String SeatQuery = "insert into SeatBooking(OrderID,EconID) values (?,?)";
                        PreparedStatement econPst = conn.prepareStatement(SeatQuery);
                        econPst.setInt(1, orderID);
                        econPst.setInt(2, econID);
                        econPst.executeUpdate();
                    }

                    for (Integer luxID : luxIDs) {
                        String SeatQuery = "update SeatBooking set LuxID=? where OrderID=?";
                        PreparedStatement econPst = conn.prepareStatement(SeatQuery);
                        econPst.setInt(1, orderID);
                        econPst.setInt(2, luxID);
                        econPst.executeUpdate();
                    }

                    for (Integer fcID : FCIDs) {
                        String SeatQuery = "update SeatBooking set FCID=? where OrderID=?";
                        PreparedStatement econPst = conn.prepareStatement(SeatQuery);
                        econPst.setInt(1, orderID);
                        econPst.setInt(2, fcID);
                        econPst.executeUpdate();
                    }

                }
                catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }


                ConfirmPage cp=new ConfirmPage(cusID,orderID);
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
        add(selectMethodComboBox);
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
    public java.sql.Date getCurrentSqlDate() {
        java.util.Date utilDate = new java.util.Date();
        return new java.sql.Date(utilDate.getTime());
    }

}
