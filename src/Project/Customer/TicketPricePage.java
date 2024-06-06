package Project.Customer;

import Project.Database;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TicketPricePage extends JFrame {
    Connection connection = Database.setConnection();
    JComboBox<String> depComboBox, arrComboBox;
    ArrayList<String> arrivalList;
    String cusID;
    DefaultTableModel tableModel;
    JTable recTable;

    public TicketPricePage(String cusID) {
        this.cusID = cusID;

        JLabel label = new JLabel();
        label.setText("Ticket Prices");
        label.setBounds(220, 20, 150, 50);
        label.setFont(new Font("Ariel", Font.BOLD, 20));
        label.setForeground(Color.orange);

        JPanel tabPanel = new JPanel();
        tabPanel.setBounds(40, 210, 500, 250);
        tabPanel.setLayout(null);

        JLabel depLabel = new JLabel();
        depLabel.setText("Departure");
        depLabel.setBounds(110, 70, 150, 35);
        depLabel.setFont(new Font("Ariel", Font.BOLD, 12));
        depLabel.setForeground(Color.orange);

        ArrayList<String> departureList = new ArrayList<>();
        String routeIDQuery = "Select r.RouteID,r.Departure, r.Stop1, r.Stop2, r.Stop3, r.Stop4, r.Stop5 FROM Route r " +
                "join Booking b on b.RouteID=r.RouteID";
        try {
            PreparedStatement rspst = connection.prepareStatement(routeIDQuery);
            ResultSet rs = rspst.executeQuery();
            while (rs.next()) {
                String dep = rs.getString("Departure");
                String stop1 = rs.getString("Stop1");
                String stop2 = rs.getString("Stop2");
                String stop3 = rs.getString("Stop3");
                String stop4 = rs.getString("Stop4");
                String stop5 = rs.getString("Stop5");

                if (dep != null && !dep.isEmpty() && !departureList.contains(dep)) {
                    departureList.add(dep);
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
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        String[] departure = departureList.toArray(new String[0]);
        depComboBox = new JComboBox<>(departure);
        depComboBox.setBackground(Color.orange);
        depComboBox.setBounds(110, 100, 150, 35);

        JLabel arrLabel = new JLabel();
        arrLabel.setText("Arrival");
        arrLabel.setBounds(300, 70, 150, 35);
        arrLabel.setFont(new Font("Ariel", Font.BOLD, 12));
        arrLabel.setForeground(Color.orange);

        arrivalList = new ArrayList<>();
        updateArrivalList();

        String[] arrival = arrivalList.toArray(new String[0]);
        arrComboBox = new JComboBox<>(arrival);
        arrComboBox.setBounds(300, 100, 150, 35);
        arrComboBox.setBackground(Color.orange);

        depComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateArrivalComboBox();
            }
        });

        String[] columnNames = {"Seat Type", "Price","Date"};
        tableModel = new DefaultTableModel(columnNames, 0);
        recTable = new JTable(tableModel);
        recTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        recTable.getColumnModel().getColumn(0).setPreferredWidth(170);
        recTable.getColumnModel().getColumn(1).setPreferredWidth(170);
        recTable.getColumnModel().getColumn(2).setPreferredWidth(157);

        JButton searchButton = new JButton();
        searchButton.setText("SEARCH");
        searchButton.setBounds(300, 160, 100, 35);
        searchButton.setBackground(Color.cyan);


        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                List<Object[]> results = calculateTravelDistance();
                updateTable(results);
            }
        });
        JButton backButton = new JButton();
        backButton.setText("BACK");
        backButton.setBounds(170, 160, 100, 35);
        backButton.setBackground(Color.cyan);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CustomerMenu cm = new CustomerMenu(cusID);
                dispose();
            }
        });
        JScrollPane scrollPane = new JScrollPane(recTable);
        scrollPane.setBounds(1, 1, 580, 350);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        tabPanel.add(scrollPane);

        setLayout(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
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
        add(tabPanel);
        add(backButton);
    }

    private void updateArrivalList() {
        String selectedDepartureStop = (String) depComboBox.getSelectedItem();
        String arrQuery = "Select r.Departure, r.Stop1, r.Stop2, r.Stop3, r.Stop4, r.Stop5,r.Arrival FROM Route r " +
                " join Booking b on b.RouteID=r.RouteID";
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

/*
    private void calculateTravelDistance() {
        String query = "SELECT r.Departure, r.Stop1, r.Stop2, r.Stop3, r.Stop4, r.Stop5, r.Arrival, r.TravelKM, " +
                "s.Stop1KM, s.Stop2KM, s.Stop3KM, s.Stop4KM, s.Stop5KM " +
                "FROM Route r " +
                "Left JOIN StopRoute s ON s.StopRouteID = r.StopRouteID where (departure=? or stop1=? or stop2=? or stop3=? or stop4=?" +
                " or stop5=?) and( Arrival=? or stop1=? or stop2=? or stop3=? or stop4=? or stop5=?)";
        String selectedDeparture =(String) depComboBox.getSelectedItem();
        String selectedArrival =(String) arrComboBox.getSelectedItem();
        int totalTravelKM = 0;
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
                        totalTravelKM += rs.getInt("Stop1KM");
                    }
                    else if(depIndex==0 && arrIndex ==2){
                        totalTravelKM += rs.getInt("Stop1KM");
                        totalTravelKM += rs.getInt("Stop2KM");
                    }
                    else if(depIndex==0 && arrIndex ==3){
                        totalTravelKM += rs.getInt("Stop1KM");
                        totalTravelKM += rs.getInt("Stop2KM");
                        totalTravelKM += rs.getInt("Stop3KM");
                    }
                    else if(depIndex==0 && arrIndex ==4){
                        totalTravelKM += rs.getInt("Stop1KM");
                        totalTravelKM += rs.getInt("Stop2KM");
                        totalTravelKM += rs.getInt("Stop3KM");
                        totalTravelKM += rs.getInt("Stop4KM");
                    }
                    else if(depIndex==0 && arrIndex ==5){
                        totalTravelKM += rs.getInt("Stop1KM");
                        totalTravelKM += rs.getInt("Stop2KM");
                        totalTravelKM += rs.getInt("Stop3KM");
                        totalTravelKM += rs.getInt("Stop4KM");
                        totalTravelKM += rs.getInt("Stop5KM");
                    }
                    else if (depIndex == 0 && arrIndex == 6)
                    {
                        totalTravelKM += rs.getInt("TravelKM");
                    }

                    if (depIndex ==1 && arrIndex == 2){
                        totalTravelKM += rs.getInt("Stop2KM");
                    }
                    else if(depIndex==1 && arrIndex ==3){
                        totalTravelKM += rs.getInt("Stop2KM");
                        totalTravelKM += rs.getInt("Stop3KM");
                    }
                    else if(depIndex==1 && arrIndex ==4){
                        totalTravelKM += rs.getInt("Stop2KM");
                        totalTravelKM += rs.getInt("Stop3KM");
                        totalTravelKM += rs.getInt("Stop4KM");
                    }
                    else if(depIndex==1 && arrIndex ==5){
                        totalTravelKM += rs.getInt("Stop2KM");
                        totalTravelKM += rs.getInt("Stop3KM");
                        totalTravelKM += rs.getInt("Stop4KM");
                        totalTravelKM += rs.getInt("Stop5KM");
                    }
                    else if(depIndex==1 && arrIndex==6){
                        totalTravelKM = rs.getInt("TravelKM")-rs.getInt("Stop1KM");;
                    }


                    if (depIndex == 2 && arrIndex == 3){
                        totalTravelKM += rs.getInt("Stop3KM");
                    }
                    else if(depIndex==2 && arrIndex ==4){
                        totalTravelKM += rs.getInt("Stop3KM");
                        totalTravelKM += rs.getInt("Stop4KM");
                    }
                    else if(depIndex==2 && arrIndex ==5){

                        totalTravelKM += rs.getInt("Stop3KM");
                        totalTravelKM += rs.getInt("Stop4KM");
                        totalTravelKM += rs.getInt("Stop5KM");
                    }
                    else if(depIndex==2 && arrIndex==6){
                        totalTravelKM = rs.getInt("TravelKM")-rs.getInt("Stop2KM");;
                    }


                    if (depIndex == 3 && arrIndex == 4)
                        totalTravelKM += rs.getInt("Stop4KM");
                    else if(depIndex==3 && arrIndex ==5){
                        totalTravelKM += rs.getInt("Stop4KM");
                        totalTravelKM += rs.getInt("Stop5KM");
                    }
                    else if(depIndex==3 && arrIndex==6){
                        totalTravelKM = rs.getInt("TravelKM")-rs.getInt("Stop3KM");;
                    }

                    if (depIndex == 4 && arrIndex == 5)
                        totalTravelKM += rs.getInt("Stop5KM");
                    else if(depIndex == 4 && arrIndex == 6)
                    {
                        totalTravelKM = rs.getInt("TravelKM")-rs.getInt("Stop4KM");
                    }

                    if (depIndex == 5 && arrIndex == 6)
                    {
                        totalTravelKM = rs.getInt("TravelKM")-rs.getInt("Stop5KM");
                    }
                }


                System.out.println(totalTravelKM);
                totalTravelKM=0;
            }
            System.out.println("Final= "+totalTravelKM);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
}*/

    private void updateArrivalComboBox() {
        arrivalList.clear();
        updateArrivalList();

        String[] arrival = arrivalList.toArray(new String[0]);
        arrComboBox.setModel(new DefaultComboBoxModel<>(arrival));
    }

    private List<Object[]> calculateTravelDistance() {
        List<Object[]> results = new ArrayList<>();
        String query = "SELECT r.Departure, r.Stop1, r.Stop2, r.Stop3, r.Stop4, r.Stop5, r.Arrival, r.TravelKM, " +
                "s.Stop1KM, s.Stop2KM, s.Stop3KM, s.Stop4KM, s.Stop5KM, p.EconomySeatPrice,p.LuxurySeatPrice,p.FirstClassSeatPrice,p.KMPrice,b.Date " +
                "FROM Route r " +
                "join booking b on b.RouteID=r.RouteID " +
                "join price p on b.PriceID= p.PriceID "+
                "LEFT JOIN StopRoute s ON s.StopRouteID = r.StopRouteID WHERE (departure=? OR stop1=? OR stop2=? OR stop3=? OR stop4=? OR stop5=?) " +
                "AND (Arrival=? OR stop1=? OR stop2=? OR stop3=? OR stop4=? OR stop5=?)";
        String selectedDeparture = (String) depComboBox.getSelectedItem();
        String selectedArrival = (String) arrComboBox.getSelectedItem();

        try {
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setString(1, selectedDeparture);
            pst.setString(2, selectedDeparture);
            pst.setString(3, selectedDeparture);
            pst.setString(4, selectedDeparture);
            pst.setString(5, selectedDeparture);
            pst.setString(6, selectedDeparture);
            pst.setString(7, selectedArrival);
            pst.setString(8, selectedArrival);
            pst.setString(9, selectedArrival);
            pst.setString(10, selectedArrival);
            pst.setString(11, selectedArrival);
            pst.setString(12, selectedArrival);

            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String date=rs.getString("Date");
                int EconomySeatPrice = Integer.parseInt(rs.getString("EconomySeatPrice"));
                int LuxurySeatPrice = Integer.parseInt(rs.getString("LuxurySeatPrice"));
                int FirstClassSeatPrice = Integer.parseInt(rs.getString("FirstClassSeatPrice"));
                int KMPrice = Integer.parseInt(rs.getString("KMPrice"));

                int totalTravelKM = calculateKM(rs, selectedDeparture, selectedArrival);
                if (totalTravelKM > 0) {

                    double economyPrice = (totalTravelKM * KMPrice)+EconomySeatPrice;
                    double luxuryPrice = (totalTravelKM * KMPrice)+LuxurySeatPrice;
                    double firstClassPrice =(totalTravelKM * KMPrice)+FirstClassSeatPrice;

                    results.add(new Object[]{"Economy Seat", economyPrice,date});
                    results.add(new Object[]{"Luxury Seat", luxuryPrice,date});
                    results.add(new Object[]{"First Class Seat", firstClassPrice,date});
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return results;
    }

    private int calculateKM(ResultSet rs, String selectedDeparture, String selectedArrival) throws SQLException {

        int totalTravelKM = 0;
        int depIndex = -1;
        int arrIndex = -1;
        String[] stops = {rs.getString("Departure"), rs.getString("Stop1"), rs.getString("Stop2"), rs.getString("Stop3"), rs.getString("Stop4"), rs.getString("Stop5"), rs.getString("Arrival")};

        for (int i = 0; i < stops.length; i++) {
            if (selectedDeparture.equals(stops[i])) {
                depIndex = i;
            }
            if (selectedArrival.equals(stops[i])) {
                arrIndex = i;
            }
        }

        if (depIndex != -1 && arrIndex != -1 && arrIndex > depIndex) {
            int[] kms = {0, rs.getInt("Stop1KM"), rs.getInt("Stop2KM"), rs.getInt("Stop3KM"), rs.getInt("Stop4KM"), rs.getInt("Stop5KM"), rs.getInt("TravelKM")};
            for (int i = depIndex; i < arrIndex; i++) {
                totalTravelKM += kms[i + 1];
            }
        }
        return totalTravelKM;
    }

    private void updateTable(List<Object[]> results) {
        tableModel.setRowCount(0);
        for (Object[] row : results) {
            tableModel.addRow(row);
        }
    }


    public static void main(String[] args) {
        TicketPricePage tpp = new TicketPricePage("Dummy");
    }

}