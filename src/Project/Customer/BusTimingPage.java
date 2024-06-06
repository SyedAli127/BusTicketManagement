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

public class BusTimingPage extends JFrame{
    JComboBox depComboBox, arrComboBox, selectDateComboBox;
    String cusID;
    ArrayList<String> arrivalList,dateList;
    Connection connection=Database.setConnection();
    DefaultTableModel tableModel;
    JTable recTable;

    public BusTimingPage(String cusID) {
        this.cusID = cusID;

        JPanel tabPanel = new JPanel();
        tabPanel.setBounds(40, 240, 500, 250);
        tabPanel.setLayout(null);

        JLabel label=new JLabel();
        label.setText("Bus Timing");
        label.setBounds(220,20,150,50);
        label.setFont(new Font("Ariel",Font.BOLD,25));
        label.setForeground(Color.orange);

        JLabel depLabel=new JLabel();
        depLabel.setText("Departure");
        depLabel.setBounds(50,90,150,35);
        depLabel.setFont(new Font("Ariel",Font.BOLD,12));
        depLabel.setForeground(Color.orange);

        JLabel arrLabel=new JLabel();
        arrLabel.setText("Arrival");
        arrLabel.setBounds(240,90,150,35);
        arrLabel.setFont(new Font("Ariel",Font.BOLD,12));
        arrLabel.setForeground(Color.orange);



        JLabel selLabel=new JLabel();
        selLabel.setText("Select Date");
        selLabel.setBounds(420,90,150,35);
        selLabel.setFont(new Font("Ariel",Font.BOLD,12));
        selLabel.setForeground(Color.orange);

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

        String [] departure =departureList.toArray(new String[0]);
        depComboBox =new JComboBox<>(departure);
        depComboBox.setBounds(50,120,150,35);
        depComboBox.setBackground(Color.YELLOW);

        arrivalList = new ArrayList<>();
        updateArrivalList();
        String [] arrival =arrivalList.toArray(new String[0]);
        arrComboBox=new JComboBox<>(arrival);
        arrComboBox.setBounds(240,120,150,35);
        arrComboBox.setBackground(Color.YELLOW);

        depComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateArrivalComboBox();
            }
        });

        dateList = new ArrayList<>();
        arrComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dateComboBox();
            }
        });
        String[] selectDate =dateList.toArray(new String[0]);
        selectDateComboBox=new JComboBox<>(selectDate);
        selectDateComboBox.setBounds(420,120,150,35);
        selectDateComboBox.setBackground(Color.YELLOW);

        String[] columnNames = {"Departure", "Arrival","Date","Departure Time","Arrival Time"};
        tableModel = new DefaultTableModel(columnNames, 0);
        recTable = new JTable(tableModel);
        recTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        recTable.getColumnModel().getColumn(0).setPreferredWidth(100);
        recTable.getColumnModel().getColumn(1).setPreferredWidth(100);
        recTable.getColumnModel().getColumn(2).setPreferredWidth(97);
        recTable.getColumnModel().getColumn(3).setPreferredWidth(100);
        recTable.getColumnModel().getColumn(4).setPreferredWidth(100);

        JButton searchButton=new JButton();
        searchButton.setText("SEARCH");
        searchButton.setBounds(300,180,100,35);
        searchButton.setBackground(Color.cyan);

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tableModel.setRowCount(0);
                caluculateTime();

            }
        });

        JButton backButton=new JButton();
        backButton.setText("BACK");
        backButton.setBounds(140,180,100,35);
        backButton.setBackground(Color.cyan);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CustomerMenu cm=new CustomerMenu(cusID);
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
        setSize(600,600);
        getContentPane().setBackground(Color.darkGray);
        setLocationRelativeTo(null);
        setTitle("Bus Timing");
        setVisible(true);


        add(label);
        add(arrComboBox);
        add(depComboBox);
        add(searchButton);
        add(depLabel);
        add(arrLabel);
        add(selectDateComboBox);
        add(selLabel);
        add(tabPanel);
        add(backButton);


    }

    public void caluculateTime() {

        String query = "SELECT r.Departure, r.Stop1, r.Stop2, r.Stop3, r.Stop4, r.Stop5, r.Arrival,r.DepartureTime, r.ArrivalTime," +
                "s.Stop1Time, s.Stop2Time, s.Stop3Time, s.Stop4Time, s.Stop5Time,b.Date FROM Route r " +
                "Left JOIN StopRoute s ON s.StopRouteID = r.StopRouteID " +
                "join booking b on r.RouteID=b.RouteID " +
                "where (departure=? or stop1=? or stop2=? or stop3=? or stop4=? or stop5=?) and( Arrival=? or stop1=? or stop2=? or stop3=? or stop4=? or stop5=?) and Date=?";
        String selectedDeparture =(String) depComboBox.getSelectedItem();
        String selectedArrival =(String) arrComboBox.getSelectedItem();
        String selectedDate =(String) selectDateComboBox.getSelectedItem();
        String depTime=null,arrTime=null;
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
                        depTime=rs.getString("DepartureTime");
                        arrTime=rs.getString("Stop1Time");
                    }
                    else if(depIndex==0 && arrIndex ==2){
                        depTime=rs.getString("DepartureTime");
                        arrTime=rs.getString("Stop2Time");
                    }
                    else if(depIndex==0 && arrIndex ==3){
                        depTime=rs.getString("DepartureTime");
                        arrTime=rs.getString("Stop3Time");
                    }
                    else if(depIndex==0 && arrIndex ==4){
                        depTime=rs.getString("DepartureTime");
                        arrTime=rs.getString("Stop4Time");
                    }
                    else if(depIndex==0 && arrIndex ==5){
                        depTime=rs.getString("DepartureTime");
                        arrTime=rs.getString("Stop5Time");
                    }
                    else if (depIndex == 0 && arrIndex == 6)
                    {
                        depTime=rs.getString("DepartureTime");
                        arrTime=rs.getString("ArrivalTime");
                    }

                    if (depIndex ==1 && arrIndex == 2){
                        depTime=rs.getString("Stop1Time");
                        arrTime=rs.getString("Stop2Time");
                    }
                    else if(depIndex==1 && arrIndex ==3){
                        depTime=rs.getString("Stop1Time");
                        arrTime=rs.getString("Stop3Time");
                    }
                    else if(depIndex==1 && arrIndex ==4){
                        depTime=rs.getString("Stop1Time");
                        arrTime=rs.getString("Stop4Time");
                    }
                    else if(depIndex==1 && arrIndex ==5){
                        depTime=rs.getString("Stop1Time");
                        arrTime=rs.getString("Stop5Time");
                    }
                    else if(depIndex==1 && arrIndex==6){
                        depTime=rs.getString("Stop1Time");
                        arrTime=rs.getString("ArrivalTime");
                    }


                    if (depIndex == 2 && arrIndex == 3){
                        depTime=rs.getString("Stop2Time");
                        arrTime=rs.getString("Stop3Time");
                    }
                    else if(depIndex==2 && arrIndex ==4){
                        depTime=rs.getString("Stop2Time");
                        arrTime=rs.getString("Stop4Time");
                    }
                    else if(depIndex==2 && arrIndex ==5){

                        depTime=rs.getString("Stop2Time");
                        arrTime=rs.getString("Stop5Time");
                    }
                    else if(depIndex==2 && arrIndex==6){
                        depTime=rs.getString("Stop2Time");
                        arrTime=rs.getString("ArrivalTime");
                    }


                    if (depIndex == 3 && arrIndex == 4) {
                        depTime = rs.getString("Stop3Time");
                        arrTime=rs.getString("Stop4Time");
                    }
                    else if(depIndex==3 && arrIndex ==5){
                        depTime = rs.getString("Stop3Time");
                        arrTime=rs.getString("Stop5Time");
                    }
                    else if(depIndex==3 && arrIndex==6){
                        depTime = rs.getString("Stop3Time");
                        arrTime=rs.getString("ArrivalTime");
                    }

                    if (depIndex == 4 && arrIndex == 5)
                    {
                        depTime = rs.getString("Stop4Time");
                        arrTime=rs.getString("Stop5Time");
                    }
                    else if(depIndex == 4 && arrIndex == 6)
                    {
                        depTime = rs.getString("Stop4Time");
                        arrTime=rs.getString("ArrivalTime");
                    }

                    if (depIndex == 5 && arrIndex == 6)
                    {
                        depTime = rs.getString("Stop5Time");
                        arrTime=rs.getString("ArrivalTime");
                    }
                }
                String[] row={selectedDeparture,selectedArrival,selectedDate,depTime,arrTime};
                tableModel.addRow(row);
            }

            System.out.println("Final= "+depTime);
            System.out.println(arrTime);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateArrivalList() {
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
        arrivalList.clear();
        updateArrivalList();

        String[] arrival = arrivalList.toArray(new String[0]);
        arrComboBox.setModel(new DefaultComboBoxModel<>(arrival));
    }

    public static void main(String[] args){
        BusTimingPage btp=new BusTimingPage("Dummy");

    }

}
