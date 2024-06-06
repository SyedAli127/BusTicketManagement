package Project.Customer.BookNow;

import Project.Customer.CustomerMenu;
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

public class BookNowPage1 extends JFrame {

    JComboBox depComboBox, arrComboBox, selectDateComboBox,selectBusTypeComboBox,departureTimeComboBox,arrivalTimeComboBox;
    JPanel panel;
    String cusID;
    ArrayList<String> arrivalList, dateList, departureTimeList, arrivalTimeList;
    ArrayList<JCheckBox> econCheckBoxList,luxCheckBoxList,firstClassCheckBoxList;
    Connection connection= Database.setConnection();
    public BookNowPage1(String cusID) {
        this.cusID = cusID;

        if(cusID.equals("")||cusID.equals("Dummy")){
            JOptionPane.showMessageDialog(null, "First Sign In", "Error", JOptionPane.ERROR_MESSAGE);
            CustomerMenu cm=new CustomerMenu("Dummy");
            dispose();
        }


        else {
            panel = new JPanel();
            panel.setLayout(null);
            panel.setBackground(Color.darkGray);
            panel.setPreferredSize(new Dimension(580, 680));

            JLabel label = new JLabel();
            label.setText("Plan Your Journey");
            label.setBounds(190, 20, 250, 50);
            label.setFont(new Font("Arial", Font.BOLD, 25));
            label.setForeground(Color.orange);

            JLabel depLabel = new JLabel();
            depLabel.setText("Departure:");
            depLabel.setBounds(40, 100, 140, 35);
            depLabel.setFont(new Font("Arial", Font.BOLD, 22));
            depLabel.setForeground(Color.orange);

            ArrayList<String> departureList = new ArrayList<>();
            departureList.add("-");
            String departureQuery = "select b.routeID,r.Departure,r.Stop1,r.Stop2,r.Stop3,r.Stop4,r.Stop5 from Booking b join route r on b.RouteID=r.RouteID where BookingStatus='Active'";
            try {
                PreparedStatement psmt = connection.prepareStatement(departureQuery);
                ResultSet rs = psmt.executeQuery();


                while (rs.next()) {

                    String departure = rs.getString("Departure");
                    String stop1 = rs.getString("Stop1");
                    String stop2 = rs.getString("Stop2");
                    String stop3 = rs.getString("Stop3");
                    String stop4 = rs.getString("Stop4");
                    String stop5 = rs.getString("Stop5");

                    if (departure != null && !departure.isEmpty() && !departureList.contains(departure)) {
                        departureList.add(departure);
                    }
                    if (stop1 != null && !stop1.isEmpty() && !departureList.contains(stop1)) {
                        departureList.add(stop1);
                    }
                    if (stop2 != null && !stop2.isEmpty() && !departureList.contains(stop2)) {
                        departureList.add(stop2);
                    }
                    if (stop3 != null && !stop3.isEmpty() && !departureList.contains(stop3)) {
                        departureList.add(stop3);
                    }
                    if (stop4 != null && !stop4.isEmpty() && !departureList.contains(stop4)) {
                        departureList.add(stop4);
                    }
                    if (stop5 != null && !stop5.isEmpty() && !departureList.contains(stop5)) {
                        departureList.add(stop5);
                    }
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            String[] departure = departureList.toArray(new String[0]);
            depComboBox = new JComboBox<>(departure);
            depComboBox.setBounds(220, 100, 150, 40);
            depComboBox.setBackground(Color.orange);


            JLabel arrLabel = new JLabel();
            arrLabel.setText("Arrival:");
            arrLabel.setBounds(40, 170, 150, 35);
            arrLabel.setFont(new Font("Arial", Font.BOLD, 22));
            arrLabel.setForeground(Color.orange);

            arrivalList = new ArrayList<>();
            updateArrivalList();

            String[] arrival = arrivalList.toArray(new String[0]);
            arrComboBox = new JComboBox<>(arrival);
            arrComboBox.setBounds(220, 170, 150, 40);
            arrComboBox.setBackground(Color.orange);
            depComboBox.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    updateArrivalComboBox();
                }
            });


            JLabel selLabel = new JLabel();
            selLabel.setText("Select Date:");
            selLabel.setBounds(40, 240, 150, 35);
            selLabel.setFont(new Font("Arial", Font.BOLD, 22));
            selLabel.setForeground(Color.orange);

            dateList = new ArrayList<>();
            arrComboBox.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dateComboBox();
                    setDepartureTime();
                }
            });

            String[] selectDate = dateList.toArray(new String[0]);
            selectDateComboBox = new JComboBox<>(selectDate);
            selectDateComboBox.setBounds(220, 240, 150, 40);
            selectDateComboBox.setBackground(Color.orange);

            JLabel depTimeLabel = new JLabel();
            depTimeLabel.setText("Departure Time:");
            depTimeLabel.setBounds(40, 310, 180, 35);
            depTimeLabel.setFont(new Font("Arial", Font.BOLD, 20));
            depTimeLabel.setForeground(Color.orange);

            departureTimeList = new ArrayList<>();
            selectDateComboBox.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setDepartureTime();
                }
            });

            String[] departureTime = departureTimeList.toArray(new String[0]);
            departureTimeComboBox = new JComboBox<>(departureTime);
            departureTimeComboBox.setBounds(220, 310, 150, 40);
            departureTimeComboBox.setBackground(Color.orange);

            JLabel arrTimeLabel = new JLabel();
            arrTimeLabel.setText("Arrival Time:");
            arrTimeLabel.setBounds(40, 380, 180, 35);
            arrTimeLabel.setFont(new Font("Arial", Font.BOLD, 20));
            arrTimeLabel.setForeground(Color.orange);

            arrivalTimeList = new ArrayList<>();
            departureTimeComboBox.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setArrivalTime();
                }
            });
            String[] arrivalTime = arrivalTimeList.toArray(new String[0]);
            arrivalTimeComboBox = new JComboBox<>(arrivalTime);
            arrivalTimeComboBox.setBounds(220, 380, 150, 40);
            arrivalTimeComboBox.setBackground(Color.orange);


            JLabel busTypeLabel = new JLabel();
            busTypeLabel.setText("Bus Type:");
            busTypeLabel.setBounds(40, 450, 150, 50);
            busTypeLabel.setFont(new Font("Arial", Font.BOLD, 22));
            busTypeLabel.setForeground(Color.orange);

            String[] bustype = {"-", "Economy", "Luxury", "First-Class"};
            selectBusTypeComboBox = new JComboBox<>(bustype);
            selectBusTypeComboBox.setBounds(220, 450, 150, 40);
            selectBusTypeComboBox.setBackground(Color.orange);

            JLabel seatSelectionLabel = new JLabel();
            seatSelectionLabel.setText("Seat Selection:");
            seatSelectionLabel.setBounds(40, 520, 150, 50);
            seatSelectionLabel.setFont(new Font("Arial", Font.BOLD, 20));
            seatSelectionLabel.setForeground(Color.orange);

            JButton seatButton = new JButton("Click Here");
            //seatButton.setBackground(Color.cyan);
            seatButton.setBounds(220, 525, 150, 40);
            seatButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (selectBusTypeComboBox.getSelectedItem().equals("Economy")) {
                        EconomySeats();
                    } else if (selectBusTypeComboBox.getSelectedItem().equals("Luxury")) {
                        LuxurySeats();
                    } else if (selectBusTypeComboBox.getSelectedItem().equals("First-Class")) {
                        FirstClassSeats();
                    }
                }
            });

            JButton nextButton = new JButton();
            nextButton.setText("Next");
            nextButton.setBounds(300, 590, 110, 40);
            nextButton.setBackground(Color.cyan);

            nextButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int KM = calculateTravelDistance();
                    String departure = (String) depComboBox.getSelectedItem();
                    String arrival = (String) arrComboBox.getSelectedItem();
                    String date = (String) selectDateComboBox.getSelectedItem();
                    System.out.println("KM= " + KM);
                    String bookID = null;
                    String query = "Select b.BookID from booking b join Route r on r.routeID=b.routeID where bookingStatus='Active'" +
                            "and Date=? and (departure=? or stop1=? or stop2=? or stop3=? or stop4=? or stop5=?) and( Arrival=? or stop1=? or stop2=? or stop3=? or stop4=? or stop5=?)";
                    String kmQuery = "";
                    try {
                        PreparedStatement pst = connection.prepareStatement(query);
                        pst.setString(1, date);
                        pst.setString(2, departure);
                        pst.setString(3, departure);
                        pst.setString(4, departure);
                        pst.setString(5, departure);
                        pst.setString(6, departure);
                        pst.setString(7, departure);
                        pst.setString(8, arrival);
                        pst.setString(9, arrival);
                        pst.setString(10, arrival);
                        pst.setString(11, arrival);
                        pst.setString(12, arrival);
                        pst.setString(13, arrival);
                        ResultSet rs = pst.executeQuery();
                        while (rs.next()) {
                            bookID = rs.getString("BookID");
                        }

                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }


                    System.out.println("Departure= " + departure);
                    System.out.println("Arrival= " + arrival);
                    System.out.println("Date= " + date);
                    System.out.println("Booking ID= " + bookID);

                    if (econCheckBoxList == null) {
                        econCheckBoxList = new ArrayList<>();
                    }
                    if (luxCheckBoxList == null) {
                        luxCheckBoxList = new ArrayList<>();
                    }
                    if (firstClassCheckBoxList == null) {
                        firstClassCheckBoxList = new ArrayList<>();
                    }
                    for (JCheckBox checkBox : econCheckBoxList) {
                        if (checkBox.isSelected()) {
                            System.out.println(checkBox.getText());
                        }
                    }
                    for (JCheckBox checkBox : luxCheckBoxList) {
                        if (checkBox.isSelected()) {
                            System.out.println(checkBox.getText());
                        }
                    }
                    for (JCheckBox checkBox : firstClassCheckBoxList) {
                        if (checkBox.isSelected()) {
                            System.out.println(checkBox.getText());
                        }
                    }
                    BookNowPage2 rp = new BookNowPage2(cusID, bookID, KM, departure, arrival, date, econCheckBoxList, luxCheckBoxList, firstClassCheckBoxList);
                    dispose();
                }
            });

            JButton backButton = new JButton();
            backButton.setText("Back");
            backButton.setBounds(150, 590, 120, 40);
            backButton.setBackground(Color.cyan);


            backButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    CustomerMenu cm = new CustomerMenu(cusID);
                    dispose();
                }
            });


            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            getContentPane().setBackground(Color.darkGray);
            setResizable(false);
            setSize(600, 600);
            setTitle("Booking Page");
            setVisible(true);
            setLocationRelativeTo(null);
            setLayout(null);

            panel.add(label);
            panel.add(arrComboBox);
            panel.add(depComboBox);
            panel.add(depLabel);
            panel.add(depTimeLabel);
            panel.add(arrLabel);
            panel.add(selectDateComboBox);
            panel.add(departureTimeComboBox);
            panel.add(selLabel);
            panel.add(busTypeLabel);
            panel.add(arrTimeLabel);
            panel.add(arrivalTimeComboBox);
            panel.add(selectBusTypeComboBox);
            panel.add(seatSelectionLabel);
            panel.add(seatButton);

            panel.add(nextButton);
            panel.add(backButton);

            JScrollPane scrollPane = new JScrollPane(panel);
            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
            scrollPane.setBounds(1, 1, 580, 580);
            add(scrollPane);
        }
    }

    public void updateArrivalList() {
        String selectedDepartureStop = (String) depComboBox.getSelectedItem();
        String arrQuery = "select b.routeID,r.Departure,r.Stop1,r.Stop2,r.Stop3,r.Stop4,r.Stop5,r.Arrival from Booking b join route r on b.RouteID=r.RouteID where BookingStatus='Active'";
        try {
            PreparedStatement pst = connection.prepareStatement(arrQuery);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String dep = rs.getString("Departure");
                String stop1 = rs.getString("Stop1");
                String stop2 = rs.getString("Stop2");
                String stop3 = rs.getString("Stop3");
                String stop4 = rs.getString("Stop4");
                String stop5 = rs.getString("Stop5");
                String arr = rs.getString("Arrival");

                // Determine the index of the selected departure stop
                int depIndex = -1;
                if (selectedDepartureStop != null) {
                    if (selectedDepartureStop.equals(dep)) {
                        depIndex = 0;
                    } else if (selectedDepartureStop.equals(stop1)) {
                        depIndex = 1;
                    } else if (selectedDepartureStop.equals(stop2)) {
                        depIndex = 2;
                    } else if (selectedDepartureStop.equals(stop3)) {
                        depIndex = 3;
                    } else if (selectedDepartureStop.equals(stop4)) {
                        depIndex = 4;
                    } else if (selectedDepartureStop.equals(stop5)) {
                        depIndex = 5;
                    }
                }

                // Add subsequent stops to arrival list
                if (depIndex != -1) {
                    if (depIndex < 1 && stop1 != null && !stop1.isEmpty() && !arrivalList.contains(stop1)) {
                        arrivalList.add(stop1);
                    }
                    if (depIndex < 2 && stop2 != null && !stop2.isEmpty() && !arrivalList.contains(stop2)) {
                        arrivalList.add(stop2);
                    }
                    if (depIndex < 3 && stop3 != null && !stop3.isEmpty() && !arrivalList.contains(stop3)) {
                        arrivalList.add(stop3);
                    }
                    if (depIndex < 4 && stop4 != null && !stop4.isEmpty() && !arrivalList.contains(stop4)) {
                        arrivalList.add(stop4);
                    }
                    if (depIndex < 5 && stop5 != null && !stop5.isEmpty() && !arrivalList.contains(stop5)) {
                        arrivalList.add(stop5);
                    }
                    if (arr != null && !arr.isEmpty() && !arrivalList.contains(arr)) {
                        arrivalList.add(arr);
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void dateComboBox() {
        dateList.clear();
        String departure = (String) depComboBox.getSelectedItem();
        String arrival=(String)arrComboBox.getSelectedItem();

        String query="Select b.Date, r.departure,r.stop1,r.stop2,r.stop3,r.stop4,r.stop5,r.arrival from booking b join Route r on r.routeID=b.routeID where bookingStatus='Active' and (departure=? or stop1=? or stop2=? or stop3=? or stop4=? or stop5=?) and( Arrival=? or stop1=? or stop2=? or stop3=? or stop4=? or stop5=?)";
        try
        {
            PreparedStatement psmt=connection.prepareStatement(query);
            psmt.setString(1, departure);
            psmt.setString(2, departure);
            psmt.setString(3, departure);
            psmt.setString(4, departure);
            psmt.setString(5, departure);
            psmt.setString(6, departure);
            psmt.setString(7, arrival);
            psmt.setString(8, arrival);
            psmt.setString(9, arrival);
            psmt.setString(10, arrival);
            psmt.setString(11, arrival);
            psmt.setString(12, arrival);


            ResultSet rs=psmt.executeQuery();
            while (rs.next()) {
                dateList.add(rs.getString("Date"));

            }
            String[] date = dateList.toArray(new String[0]);
            selectDateComboBox.setModel(new DefaultComboBoxModel<>(date));
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void updateArrivalComboBox() {
        arrivalList.clear(); // Clear the current list of arrivals
        updateArrivalList();

        String[] arrival = arrivalList.toArray(new String[0]);
        arrComboBox.setModel(new DefaultComboBoxModel<>(arrival));
    }

    public void EconomySeats() {
        JDialog econDialog = new JDialog(this, "Select Economy Seats", true);
        econDialog.setLayout(null);
        econDialog.getContentPane().setBackground(Color.darkGray);
        econDialog.setSize(600, 600);
        econDialog.setLocationRelativeTo(null);
        econDialog.setResizable(false);

        String departure = (String) depComboBox.getSelectedItem();
        String arrival=(String)arrComboBox.getSelectedItem();

        JLabel seatSelectionLabel =new JLabel();
        seatSelectionLabel.setText("Seat Selection");
        seatSelectionLabel.setFont(new Font("Arial",Font.BOLD,22));
        seatSelectionLabel.setForeground(Color.orange);
        seatSelectionLabel.setBounds(100, 30,240,30);

        String date=(String)selectDateComboBox.getSelectedItem();
        int busID=0;
        int checkboxY = 80;
        String busQ="Select b.BusID, b.Date, r.departure,r.stop1,r.stop2,r.stop3,r.stop4,r.stop5,r.arrival from booking b join Route r on r.routeID=b.routeID where bookingStatus='Active' " +
                "and Date=? and (departure=? or stop1=? or stop2=? or stop3=? or stop4=? or stop5=?) and( Arrival=? or stop1=? or stop2=? or stop3=? or stop4=? or stop5=?)  ";
        try {
            PreparedStatement ps=connection.prepareStatement(busQ);
            ps.setString(1, date);
            ps.setString(2, departure);
            ps.setString(3, departure);
            ps.setString(4, departure);
            ps.setString(5, departure);
            ps.setString(6, departure);
            ps.setString(7, departure);
            ps.setString(8, arrival);
            ps.setString(9, arrival);
            ps.setString(10, arrival);
            ps.setString(11, arrival);
            ps.setString(12, arrival);
            ps.setString(13, arrival);
            ResultSet rs=ps.executeQuery();
            while (rs.next()) {
                busID=rs.getInt("BusID");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        String query= "select EconomySeat.SeatNo from Booking b join EconomySeat on b.BusID=EconomySeat.BusID where b.Date=? and b.busID=? and EconomySeat.IsBooked=0";
        econCheckBoxList = new ArrayList<>();
        try
        {
            PreparedStatement psmt=connection.prepareStatement(query);
            psmt.setString(1, date);
            psmt.setInt(2, busID);
            ResultSet rs=psmt.executeQuery();
            int checkboxX = 55;
            int checkboxWidth = 55;
            int checkboxHeight = 30;

            while (rs.next()) {
                String seatNo = rs.getString("SeatNo");
                JCheckBox checkBox = new JCheckBox(seatNo);
                checkBox.setBounds(checkboxX, checkboxY, checkboxWidth, checkboxHeight);
                econDialog.add(checkBox);
                econCheckBoxList.add(checkBox);
                checkboxX += 65;
                if (checkboxX >= 500)
                {
                    checkboxX = 55;
                    checkboxY += 40;
                }
            }
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
        JButton confirmButton = new JButton("Confirm");
        confirmButton.setBackground(Color.cyan);
        confirmButton.setBounds(150,checkboxY+50,120,50);
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {

                for (JCheckBox checkBox : econCheckBoxList) {
                    if (checkBox.isSelected()) {
                        econDialog.dispose();
                    }
                }

            }
        });
        econDialog.add(seatSelectionLabel);
        econDialog.add(confirmButton);


        econDialog.setVisible(true);

    }

    public void LuxurySeats() {
        JDialog luxDialog = new JDialog(this, "Select Luxury Seats", true);
        luxDialog.setLayout(null);
        luxDialog.getContentPane().setBackground(Color.darkGray);
        luxDialog.setSize(600, 600);
        luxDialog.setLocationRelativeTo(null);
        luxDialog.setResizable(false);

        String departure = (String) depComboBox.getSelectedItem();
        String arrival=(String)arrComboBox.getSelectedItem();

        JLabel seatSelectionLabel =new JLabel();
        seatSelectionLabel.setText("Seat Selection");
        seatSelectionLabel.setFont(new Font("Arial",Font.BOLD,22));
        seatSelectionLabel.setForeground(Color.orange);
        seatSelectionLabel.setBounds(100, 30,240,30);

        String date=(String)selectDateComboBox.getSelectedItem();
        int busID=0;
        int checkboxY = 80;
        String busQ="Select b.BusID, b.Date, r.departure,r.stop1,r.stop2,r.stop3,r.stop4,r.stop5,r.arrival from booking b join Route r on r.routeID=b.routeID where bookingStatus='Active' " +
                "and Date=? and (departure=? or stop1=? or stop2=? or stop3=? or stop4=? or stop5=?) and( Arrival=? or stop1=? or stop2=? or stop3=? or stop4=? or stop5=?)  ";

        try {
            PreparedStatement ps=connection.prepareStatement(busQ);
            ps.setString(1, date);
            ps.setString(2, departure);
            ps.setString(3, departure);
            ps.setString(4, departure);
            ps.setString(5, departure);
            ps.setString(6, departure);
            ps.setString(7, departure);
            ps.setString(8, arrival);
            ps.setString(9, arrival);
            ps.setString(10, arrival);
            ps.setString(11, arrival);
            ps.setString(12, arrival);
            ps.setString(13, arrival);
            ResultSet rs=ps.executeQuery();
            while (rs.next()) {
                busID=rs.getInt("BusID");
            }

        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
        String query= "select LuxurySeat.SeatNo from Booking b join LuxurySeat on b.BusID=LuxurySeat.BusID where b.Date=? and b.busID=? and LuxurySeat.IsBooked=0";
        luxCheckBoxList=new ArrayList<>();

        try
        {
            PreparedStatement psmt=connection.prepareStatement(query);
            psmt.setString(1, date);
            psmt.setInt(2, busID);
            ResultSet rs=psmt.executeQuery();
            int checkboxX = 55;
            int checkboxWidth = 55;
            int checkboxHeight = 30;

            while (rs.next()) {
                String seatNo = rs.getString("SeatNo");
                JCheckBox checkBox = new JCheckBox(seatNo);
                checkBox.setBounds(checkboxX, checkboxY, checkboxWidth, checkboxHeight);
                luxDialog.add(checkBox);
                luxCheckBoxList.add(checkBox);
                checkboxX += 65;
                if (checkboxX >= 500) {
                    checkboxX = 55;
                    checkboxY += 40;
                }
            }
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
        JButton confirmButton = new JButton("Confirm");
        confirmButton.setBackground(Color.cyan);
        confirmButton.setBounds(150,checkboxY+50,120,50);
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (JCheckBox checkBox : luxCheckBoxList) {
                    if (checkBox.isSelected()) {
                        System.out.println(checkBox.getText());
                        luxDialog.dispose();
                    }
                }
            }
        });
        luxDialog.add(seatSelectionLabel);
        luxDialog.add(confirmButton);

        luxDialog.setVisible(true);

    }

    public void FirstClassSeats() {
        JDialog fcDialog = new JDialog(this, "Select FirstClass Seats", true);
        fcDialog.setLayout(null);
        fcDialog.getContentPane().setBackground(Color.darkGray);
        fcDialog.setSize(600, 600);
        fcDialog.setLocationRelativeTo(null);
        fcDialog.setResizable(false);

        String departure = (String) depComboBox.getSelectedItem();
        String arrival=(String)arrComboBox.getSelectedItem();


        JLabel seatSelectionLabel =new JLabel();
        seatSelectionLabel.setText("Seat Selection");
        seatSelectionLabel.setFont(new Font("Arial",Font.BOLD,22));
        seatSelectionLabel.setForeground(Color.orange);
        seatSelectionLabel.setBounds(100, 30,240,30);

        String date=(String)selectDateComboBox.getSelectedItem();
        int busID=0;
        int checkboxY = 80;
        String busQ="Select b.BusID, b.Date, r.departure,r.stop1,r.stop2,r.stop3,r.stop4,r.stop5,r.arrival from booking b join Route r on r.routeID=b.routeID where bookingStatus='Active' " +
                "and Date=? and" +
                "(departure=? or stop1=? or stop2=? or stop3=? or stop4=? or stop5=?) and( Arrival=? or stop1=? or stop2=? or stop3=? or stop4=? or stop5=?)  ";
        try {
            PreparedStatement ps=connection.prepareStatement(busQ);
            ps.setString(1, date);
            ps.setString(2, departure);
            ps.setString(3, departure);
            ps.setString(4, departure);
            ps.setString(5, departure);
            ps.setString(6, departure);
            ps.setString(7, departure);
            ps.setString(8, arrival);
            ps.setString(9, arrival);
            ps.setString(10, arrival);
            ps.setString(11, arrival);
            ps.setString(12, arrival);
            ps.setString(13, arrival);
            ResultSet rs=ps.executeQuery();
            while (rs.next()) {
                busID=rs.getInt("BusID");
            }

        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
        String query= "select FirstClassSeat.SeatNo from Booking b join FirstClassSeat on b.BusID=FirstClassSeat.BusID where b.Date=? and b.busID=? and FirstClassSeat.IsBooked=0";
        firstClassCheckBoxList=new ArrayList<>();
        try
        {
            PreparedStatement psmt=connection.prepareStatement(query);
            psmt.setString(1, date);
            psmt.setInt(2, busID);
            ResultSet rs=psmt.executeQuery();
            int checkboxX = 55;

            int checkboxWidth = 55;
            int checkboxHeight = 30;

            while (rs.next()) {
                String seatNo = rs.getString("SeatNo");
                JCheckBox checkBox = new JCheckBox(seatNo);
                checkBox.setBounds(checkboxX, checkboxY, checkboxWidth, checkboxHeight);
                fcDialog.add(checkBox);
                firstClassCheckBoxList.add(checkBox);
                checkboxX += 65;
                if (checkboxX >= 500) {
                    checkboxX = 55;
                    checkboxY += 40;

                }
            }
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }

        JButton confirmButton = new JButton("Confirm");
        confirmButton.setBackground(Color.cyan);
        confirmButton.setBounds(150,checkboxY+50,120,50);
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (JCheckBox checkBox : firstClassCheckBoxList) {
                    if (checkBox.isSelected()) {
                        fcDialog.dispose();
                    }
                }
            }
        });

        fcDialog.add(seatSelectionLabel);
        fcDialog.add(confirmButton);


        fcDialog.setVisible(true);

    }

    public void setDepartureTime() {
        departureTimeList.clear();

        String query ="SELECT r.Departure, r.Stop1, r.Stop2, r.Stop3, r.Stop4, r.Stop5, r.Arrival, r.DepartureTime, " +
                "s.Stop1Time, s.Stop2Time, s.Stop3Time, s.Stop4Time, s.Stop5Time " +
                "FROM Route r " +
                "join Booking b on b.RouteID=r.RouteID " +
                "Left JOIN StopRoute s ON s.StopRouteID = r.StopRouteID where (departure=? or stop1=? or stop2=? or stop3=? or stop4=? " +
                "or stop5=?) and( Arrival=? or stop1=? or stop2=? or stop3=? or stop4=? or stop5=?) and Date=?" ;
        String selectedDeparture =(String) depComboBox.getSelectedItem();
        String selectedArrival =(String) arrComboBox.getSelectedItem();
        String selectedDate=(String) selectDateComboBox.getSelectedItem();
        String departureTime = null;

        try {
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setString(1,selectedDeparture);
            pst.setString(2,selectedDeparture);
            pst.setString(3,selectedDeparture);
            pst.setString(4,selectedDeparture);
            pst.setString(5,selectedDeparture);
            pst.setString(6,selectedDeparture);
            pst.setString(7,selectedArrival);
            pst.setString(8,selectedArrival);
            pst.setString(9,selectedArrival);
            pst.setString(10,selectedArrival);
            pst.setString(11,selectedArrival);
            pst.setString(12,selectedArrival);
            pst.setString(13,selectedDate);
            ResultSet rs = pst.executeQuery();
            while (rs.next())
            {
                String dep = rs.getString("Departure");
                String stop1 = rs.getString("Stop1");
                String stop2 = rs.getString("Stop2");
                String stop3 = rs.getString("Stop3");
                String stop4 = rs.getString("Stop4");
                String stop5 = rs.getString("Stop5");
                String arr = rs.getString("Arrival");


                int depIndex = -1;
                int arrIndex = -1;
                if (selectedDeparture.equals(dep)) {
                    depIndex = 0;
                }
                else if (selectedDeparture.equals(stop1)) {
                    depIndex = 1;
                }
                else if (selectedDeparture.equals(stop2)) {
                    depIndex = 2;
                }
                else if (selectedDeparture.equals(stop3)) {
                    depIndex = 3;
                }
                else if (selectedDeparture.equals(stop4)) {
                    depIndex = 4;
                } else if (selectedDeparture.equals(stop5)) {
                    depIndex = 5;
                }

                if (selectedArrival.equals(stop1)) {
                    arrIndex = 1;
                } else if (selectedArrival.equals(stop2)) {
                    arrIndex = 2;
                } else if (selectedArrival.equals(stop3)) {
                    arrIndex = 3;
                } else if (selectedArrival.equals(stop4)) {
                    arrIndex = 4;
                } else if (selectedArrival.equals(stop5)) {
                    arrIndex = 5;
                } else if (selectedArrival.equals(arr)) {
                    arrIndex = 6;
                }

                if (depIndex != -1 && arrIndex != -1 && arrIndex > depIndex)
                {

                    if (depIndex ==0 && arrIndex ==1) {
                        departureTime= rs.getString("DepartureTime");
                    }
                    else if(depIndex==0 && arrIndex ==2){
                        departureTime= rs.getString("DepartureTime");
                    }
                    else if(depIndex==0 && arrIndex ==3){
                        departureTime= rs.getString("DepartureTime");
                    }
                    else if(depIndex==0 && arrIndex ==4){
                        departureTime= rs.getString("DepartureTime");
                    }
                    else if(depIndex==0 && arrIndex ==5){
                        departureTime= rs.getString("DepartureTime");
                    }
                    else if (depIndex == 0 && arrIndex == 6)
                    {
                        departureTime= rs.getString("DepartureTime");
                    }

                    if (depIndex ==1 && arrIndex == 2){
                        departureTime= rs.getString("Stop1Time");
                    }
                    else if(depIndex==1 && arrIndex ==3){
                        departureTime= rs.getString("Stop1Time");
                    }
                    else if(depIndex==1 && arrIndex ==4){
                        departureTime= rs.getString("Stop1Time");
                    }
                    else if(depIndex==1 && arrIndex ==5){
                        departureTime= rs.getString("Stop1Time");
                    }
                    else if(depIndex==1 && arrIndex==6){
                        departureTime= rs.getString("Stop1Time");
                    }


                    if (depIndex == 2 && arrIndex == 3)
                    {
                        departureTime= rs.getString("Stop2Time");
                    }
                    else if(depIndex==2 && arrIndex ==4){
                        departureTime= rs.getString("Stop2Time");
                    }
                    else if(depIndex==2 && arrIndex ==5){

                        departureTime= rs.getString("Stop2Time");
                    }
                    else if(depIndex==2 && arrIndex==6)
                    {
                        departureTime= rs.getString("Stop2Time");
                    }


                    if (depIndex == 3 && arrIndex == 4)
                    {
                        departureTime= rs.getString("Stop3Time");
                    }
                    else if(depIndex==3 && arrIndex ==5){
                        departureTime= rs.getString("Stop3Time");
                    }
                    else if(depIndex==3 && arrIndex==6){
                        departureTime= rs.getString("Stop3Time");
                    }

                    if (depIndex == 4 && arrIndex == 5) {
                        departureTime = rs.getString("Stop4Time");
                    }
                    else if(depIndex == 4 && arrIndex == 6)
                    {
                        departureTime= rs.getString("Stop4Time");
                    }

                    if (depIndex == 5 && arrIndex == 6)
                    {
                        departureTime= rs.getString("Stop5Time");
                    }
                }
                departureTimeList.add(departureTime);
                departureTimeComboBox.setModel(new DefaultComboBoxModel<>(departureTimeList.toArray(new String[0])));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public void setArrivalTime() {
        arrivalTimeList.clear();

        String query ="SELECT r.Departure, r.Stop1, r.Stop2, r.Stop3, r.Stop4, r.Stop5, r.Arrival,r.ArrivalTime, " +
                "s.Stop1Time, s.Stop2Time, s.Stop3Time, s.Stop4Time, s.Stop5Time " +
                "FROM Route r " +
                "join Booking b on b.RouteID=r.RouteID " +
                "Left JOIN StopRoute s ON s.StopRouteID = r.StopRouteID where (departure=? or stop1=? or stop2=? or stop3=? or stop4=? " +
                "or stop5=?) and( Arrival=? or stop1=? or stop2=? or stop3=? or stop4=? or stop5=?) and Date=? and DepartureTime=?" ;
        String selectedDeparture =(String) depComboBox.getSelectedItem();
        String selectedArrival =(String) arrComboBox.getSelectedItem();
        String selectedDate=(String) selectDateComboBox.getSelectedItem();
        String depTime=(String)departureTimeComboBox.getSelectedItem();
        String arrivalTime = null;

        try {
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setString(1,selectedDeparture);
            pst.setString(2,selectedDeparture);
            pst.setString(3,selectedDeparture);
            pst.setString(4,selectedDeparture);
            pst.setString(5,selectedDeparture);
            pst.setString(6,selectedDeparture);
            pst.setString(7,selectedArrival);
            pst.setString(8,selectedArrival);
            pst.setString(9,selectedArrival);
            pst.setString(10,selectedArrival);
            pst.setString(11,selectedArrival);
            pst.setString(12,selectedArrival);
            pst.setString(13,selectedDate);
            pst.setString(14,depTime);

            ResultSet rs = pst.executeQuery();
            while (rs.next())
            {
                String dep = rs.getString("Departure");
                String stop1 = rs.getString("Stop1");
                String stop2 = rs.getString("Stop2");
                String stop3 = rs.getString("Stop3");
                String stop4 = rs.getString("Stop4");
                String stop5 = rs.getString("Stop5");
                String arr = rs.getString("Arrival");


                int depIndex = -1;
                int arrIndex = -1;
                if (selectedDeparture.equals(dep)) {
                    depIndex = 0;
                }
                else if (selectedDeparture.equals(stop1)) {
                    depIndex = 1;
                }
                else if (selectedDeparture.equals(stop2)) {
                    depIndex = 2;
                }
                else if (selectedDeparture.equals(stop3)) {
                    depIndex = 3;
                }
                else if (selectedDeparture.equals(stop4)) {
                    depIndex = 4;
                } else if (selectedDeparture.equals(stop5)) {
                    depIndex = 5;
                }

                if (selectedArrival.equals(stop1)) {
                    arrIndex = 1;
                } else if (selectedArrival.equals(stop2)) {
                    arrIndex = 2;
                } else if (selectedArrival.equals(stop3)) {
                    arrIndex = 3;
                } else if (selectedArrival.equals(stop4)) {
                    arrIndex = 4;
                } else if (selectedArrival.equals(stop5)) {
                    arrIndex = 5;
                } else if (selectedArrival.equals(arr)) {
                    arrIndex = 6;
                }

                if (depIndex != -1 && arrIndex != -1 && arrIndex > depIndex)
                {

                    if (depIndex ==0 && arrIndex ==1) {
                        arrivalTime= rs.getString("Stop1Time");
                    }
                    else if(depIndex==0 && arrIndex ==2){
                        arrivalTime= rs.getString("Stop2Time");
                    }
                    else if(depIndex==0 && arrIndex ==3){
                        arrivalTime= rs.getString("Stop3Time");
                    }
                    else if(depIndex==0 && arrIndex ==4){
                        arrivalTime= rs.getString("Stop4Time");
                    }
                    else if(depIndex==0 && arrIndex ==5){
                        arrivalTime= rs.getString("Stop5Time");
                    }
                    else if (depIndex == 0 && arrIndex == 6)
                    {
                        arrivalTime= rs.getString("ArrivalTime");
                    }

                    if (depIndex ==1 && arrIndex == 2){
                        arrivalTime= rs.getString("Stop2Time");
                    }
                    else if(depIndex==1 && arrIndex ==3){
                        arrivalTime= rs.getString("Stop3Time");
                    }
                    else if(depIndex==1 && arrIndex ==4){
                        arrivalTime= rs.getString("Stop4Time");
                    }
                    else if(depIndex==1 && arrIndex ==5){
                        arrivalTime= rs.getString("Stop5Time");
                    }
                    else if(depIndex==1 && arrIndex==6){
                        arrivalTime= rs.getString("ArrivalTime");
                    }


                    if (depIndex == 2 && arrIndex == 3)
                    {
                        arrivalTime= rs.getString("Stop3Time");
                    }
                    else if(depIndex==2 && arrIndex ==4){
                        arrivalTime= rs.getString("Stop4Time");
                    }
                    else if(depIndex==2 && arrIndex ==5){

                        arrivalTime= rs.getString("Stop5Time");
                    }
                    else if(depIndex==2 && arrIndex==6)
                    {
                        arrivalTime= rs.getString("ArrivalTime");
                    }


                    if (depIndex == 3 && arrIndex == 4)
                    {
                        arrivalTime= rs.getString("Stop4Time");
                    }
                    else if(depIndex==3 && arrIndex ==5){
                        arrivalTime= rs.getString("Stop5Time");
                    }
                    else if(depIndex==3 && arrIndex==6){
                        arrivalTime= rs.getString("ArrivalTime");
                    }

                    if (depIndex == 4 && arrIndex == 5) {
                        arrivalTime = rs.getString("Stop5Time");
                    }
                    else if(depIndex == 4 && arrIndex == 6)
                    {
                        arrivalTime= rs.getString("ArrivalTime");
                    }

                    if (depIndex == 5 && arrIndex == 6)
                    {
                        arrivalTime= rs.getString("ArrivalTime");
                    }
                }
                arrivalTimeList.add(arrivalTime);
                arrivalTimeComboBox.setModel(new DefaultComboBoxModel<>(arrivalTimeList.toArray(new String[0])));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    private int calculateTravelDistance() {
        String query ="SELECT r.Departure, r.Stop1, r.Stop2, r.Stop3, r.Stop4, r.Stop5, r.Arrival, r.TravelKM," +
                "s.Stop1KM, s.Stop2KM, s.Stop3KM, s.Stop4KM, s.Stop5KM " +
                "FROM Route r " +
                "join Booking b on b.RouteID=r.RouteID " +
                "Left JOIN StopRoute s ON s.StopRouteID = r.StopRouteID where (departure=? or stop1=? or stop2=? or stop3=? or stop4=? " +
                "or stop5=?) and( Arrival=? or stop1=? or stop2=? or stop3=? or stop4=? or stop5=?) and Date=? and(DepartureTime=? or stop1Time=? or Stop2Time=? or Stop3Time=? or Stop4Time=? or Stop5Time=?) " +
                "and(ArrivalTime=? or stop1Time=? or Stop2Time=? or Stop3Time=? or Stop4Time=? or Stop5Time=?)";
        String departure =(String) depComboBox.getSelectedItem();
        String arrival =(String) arrComboBox.getSelectedItem();
        String date=(String) selectDateComboBox.getSelectedItem();
        String depTime=(String) departureTimeComboBox.getSelectedItem();
        String arrTime=(String) arrivalTimeComboBox.getSelectedItem();
        int totalTravelKM = 0;
        try {
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setString(1,departure);
            pst.setString(2,departure);
            pst.setString(3,departure);
            pst.setString(4,departure);
            pst.setString(5,departure);
            pst.setString(6,departure);
            pst.setString(7, arrival);
            pst.setString(8, arrival);
            pst.setString(9, arrival);
            pst.setString(10, arrival);
            pst.setString(11, arrival);
            pst.setString(12, arrival);
            pst.setString(13,date);
            pst.setString(14,depTime);
            pst.setString(15,depTime);
            pst.setString(16,depTime);
            pst.setString(17,depTime);
            pst.setString(18,depTime);
            pst.setString(19,depTime);
            pst.setString(20,arrTime);
            pst.setString(21,arrTime);
            pst.setString(22,arrTime);
            pst.setString(23,arrTime);
            pst.setString(24,arrTime);
            pst.setString(25,arrTime);

            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String dep = rs.getString("Departure");
                String stop1 = rs.getString("Stop1");
                String stop2 = rs.getString("Stop2");
                String stop3 = rs.getString("Stop3");
                String stop4 = rs.getString("Stop4");
                String stop5 = rs.getString("Stop5");
                String arr = rs.getString("Arrival");


                int depIndex = -1;
                int arrIndex = -1;
                if (departure.equals(dep)) {
                    depIndex = 0;
                } else if (departure.equals(stop1)) {
                    depIndex = 1;
                } else if (departure.equals(stop2)) {
                    depIndex = 2;
                } else if (departure.equals(stop3)) {
                    depIndex = 3;
                } else if (departure.equals(stop4)) {
                    depIndex = 4;
                } else if (departure.equals(stop5)) {
                    depIndex = 5;
                }

                if (arrival.equals(stop1)) {
                    arrIndex = 1;
                } else if (arrival.equals(stop2)) {
                    arrIndex = 2;
                } else if (arrival.equals(stop3)) {
                    arrIndex = 3;
                } else if (arrival.equals(stop4)) {
                    arrIndex = 4;
                } else if (arrival.equals(stop5)) {
                    arrIndex = 5;
                } else if (arrival.equals(arr)) {
                    arrIndex = 6;
                }

                if (depIndex != -1 && arrIndex != -1 && arrIndex > depIndex) {

                    if (depIndex == 0 && arrIndex == 1) {
                        totalTravelKM += rs.getInt("Stop1KM");
                    } else if (depIndex == 0 && arrIndex == 2) {
                        totalTravelKM += rs.getInt("Stop1KM");
                        totalTravelKM += rs.getInt("Stop2KM");
                    } else if (depIndex == 0 && arrIndex == 3) {
                        totalTravelKM += rs.getInt("Stop1KM");
                        totalTravelKM += rs.getInt("Stop2KM");
                        totalTravelKM += rs.getInt("Stop3KM");
                    } else if (depIndex == 0 && arrIndex == 4) {
                        totalTravelKM += rs.getInt("Stop1KM");
                        totalTravelKM += rs.getInt("Stop2KM");
                        totalTravelKM += rs.getInt("Stop3KM");
                        totalTravelKM += rs.getInt("Stop4KM");
                    } else if (depIndex == 0 && arrIndex == 5) {
                        totalTravelKM += rs.getInt("Stop1KM");
                        totalTravelKM += rs.getInt("Stop2KM");
                        totalTravelKM += rs.getInt("Stop3KM");
                        totalTravelKM += rs.getInt("Stop4KM");
                        totalTravelKM += rs.getInt("Stop5KM");
                    } else if (depIndex == 0 && arrIndex == 6) {
                        totalTravelKM += rs.getInt("TravelKM");
                    }

                    if (depIndex == 1 && arrIndex == 2) {
                        totalTravelKM += rs.getInt("Stop2KM");
                    } else if (depIndex == 1 && arrIndex == 3) {
                        totalTravelKM += rs.getInt("Stop2KM");
                        totalTravelKM += rs.getInt("Stop3KM");
                    } else if (depIndex == 1 && arrIndex == 4) {
                        totalTravelKM += rs.getInt("Stop2KM");
                        totalTravelKM += rs.getInt("Stop3KM");
                        totalTravelKM += rs.getInt("Stop4KM");
                    } else if (depIndex == 1 && arrIndex == 5) {
                        totalTravelKM += rs.getInt("Stop2KM");
                        totalTravelKM += rs.getInt("Stop3KM");
                        totalTravelKM += rs.getInt("Stop4KM");
                        totalTravelKM += rs.getInt("Stop5KM");
                    } else if (depIndex == 1 && arrIndex == 6) {
                        totalTravelKM = rs.getInt("TravelKM") - rs.getInt("Stop1KM");
                        ;
                    }


                    if (depIndex == 2 && arrIndex == 3) {
                        totalTravelKM += rs.getInt("Stop3KM");
                    } else if (depIndex == 2 && arrIndex == 4) {
                        totalTravelKM += rs.getInt("Stop3KM");
                        totalTravelKM += rs.getInt("Stop4KM");
                    } else if (depIndex == 2 && arrIndex == 5) {

                        totalTravelKM += rs.getInt("Stop3KM");
                        totalTravelKM += rs.getInt("Stop4KM");
                        totalTravelKM += rs.getInt("Stop5KM");
                    } else if (depIndex == 2 && arrIndex == 6) {
                        totalTravelKM = rs.getInt("TravelKM") - rs.getInt("Stop2KM");
                        ;
                    }


                    if (depIndex == 3 && arrIndex == 4)
                        totalTravelKM += rs.getInt("Stop4KM");
                    else if (depIndex == 3 && arrIndex == 5) {
                        totalTravelKM += rs.getInt("Stop4KM");
                        totalTravelKM += rs.getInt("Stop5KM");
                    } else if (depIndex == 3 && arrIndex == 6) {
                        totalTravelKM = rs.getInt("TravelKM") - rs.getInt("Stop3KM");
                        ;
                    }

                    if (depIndex == 4 && arrIndex == 5)
                        totalTravelKM += rs.getInt("Stop5KM");
                    else if (depIndex == 4 && arrIndex == 6) {
                        totalTravelKM = rs.getInt("TravelKM") - rs.getInt("Stop4KM");
                    }

                    if (depIndex == 5 && arrIndex == 6) {
                        totalTravelKM = rs.getInt("TravelKM") - rs.getInt("Stop5KM");
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return totalTravelKM;
    }
    public static void main(String[] args)
    {
        BookNowPage1 rp=new BookNowPage1("Dummy");
    }
}
