package Project.Admin.BookingManagement;

import Project.Admin.AdminDashboard;
import Project.Admin.BusManagement.ManageBusMaintenancePage;
import Project.Admin.BusManagement.ManageBusPage;
import Project.Admin.BusManagement.ManageRoutePage;
import Project.Admin.BusManagement.ManageStopRoutePage;
import Project.Admin.GenerateReportPage;
import Project.Admin.UserMangement.ManageDriverPage;
import Project.Admin.UserMangement.ManageManagerPage;
import Project.Admin.UserMangement.ManageUserPage;
import Project.Admin.ViewFeedbackPage;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AddBookingPage extends JFrame{

    DefaultTableModel tableModel;
    JTable recTable;


    public AddBookingPage() {
        JLabel label=new JLabel();
        label.setText("Add Bookings");
        label.setBounds(450,20,250,50);
        label.setFont(new Font("Arial",Font.BOLD,25));
        label.setForeground(Color.orange);

        JPanel menuPanel =new JPanel();
        menuPanel.setBackground(new Color(14,47,68) );
        menuPanel.setBounds(1,1,200,650);
        menuPanel.setLayout(null);


        //Parents
        DefaultMutableTreeNode dashboard=new DefaultMutableTreeNode("Dashboard");
        DefaultMutableTreeNode userManagement=new DefaultMutableTreeNode("User Management");
        DefaultMutableTreeNode busManagement=new DefaultMutableTreeNode("Bus Management");
        DefaultMutableTreeNode bookingManagement=new DefaultMutableTreeNode("Booking Management");
        DefaultMutableTreeNode feedbackManagement=new DefaultMutableTreeNode("Feedback Management");
        DefaultMutableTreeNode reportManagement=new DefaultMutableTreeNode("Reporting & Analytics");

        //Children of Uer Management
        DefaultMutableTreeNode manage_user=new DefaultMutableTreeNode("Manage User");
        DefaultMutableTreeNode manage_driver=new DefaultMutableTreeNode("Manage Driver");
        DefaultMutableTreeNode manage_manager=new DefaultMutableTreeNode("Manage Manager");

        //Children of Bus Management
        DefaultMutableTreeNode manage_bus=new DefaultMutableTreeNode("Manage Bus");
        DefaultMutableTreeNode manage_route=new DefaultMutableTreeNode("Manage Route");
        DefaultMutableTreeNode manage_stop_route=new DefaultMutableTreeNode("Manage Stop Route");
        DefaultMutableTreeNode manage_bus_maintenance=new DefaultMutableTreeNode("Manage Bus Maintenance");

        //Children of Booking Management
        DefaultMutableTreeNode add_booking=new DefaultMutableTreeNode("Add Booking");
        DefaultMutableTreeNode view_booking=new DefaultMutableTreeNode("View Booking");
        DefaultMutableTreeNode manage_pricing=new DefaultMutableTreeNode("Manage Pricing");
        DefaultMutableTreeNode view_seat=new DefaultMutableTreeNode("View Seat Occupancy");
        DefaultMutableTreeNode refund_manage=new DefaultMutableTreeNode("Refund Management");
        DefaultMutableTreeNode manage_promocode=new DefaultMutableTreeNode("Manage PromoCode");
        DefaultMutableTreeNode manage_tax=new DefaultMutableTreeNode("Manage Taxes");


        //Child of FeedBack Management
        DefaultMutableTreeNode view_feedback=new DefaultMutableTreeNode("View Feedback");

        //Child of FeedBack Management
        DefaultMutableTreeNode generate_report=new DefaultMutableTreeNode("Generate Report");

        //GrandParent
        DefaultMutableTreeNode adminDashboard=new DefaultMutableTreeNode("Admin Dashboard");


        userManagement.add(manage_user);
        userManagement.add(manage_driver);
        userManagement.add(manage_manager);

        busManagement.add(manage_bus);
        busManagement.add(manage_route);
        busManagement.add(manage_stop_route);
        busManagement.add(manage_bus_maintenance);

        bookingManagement.add(add_booking);
        bookingManagement.add(view_booking);
        bookingManagement.add(manage_pricing);
        bookingManagement.add(view_seat);
        bookingManagement.add(refund_manage);
        bookingManagement.add(manage_promocode);
        bookingManagement.add(manage_tax);

        feedbackManagement.add(view_feedback);

        reportManagement.add(generate_report);

        adminDashboard.add(dashboard);
        adminDashboard.add(userManagement);
        adminDashboard.add(busManagement);
        adminDashboard.add(bookingManagement);
        adminDashboard.add(feedbackManagement);
        adminDashboard.add(reportManagement);

        JTree dashboardTree=new JTree(adminDashboard);
        dashboardTree.setBounds(10,55,205,450);
        menuPanel.add(dashboardTree);
        dashboardTree.setBackground(new Color(14, 47, 68)); // Set background color

        dashboardTree.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Get the selected node
                DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) dashboardTree.getLastSelectedPathComponent();

                // Check if a node is selected and perform corresponding action
                if (selectedNode != null)
                {
                    String nodeLabel = selectedNode.getUserObject().toString();
                    switch (nodeLabel)
                    {
                        case "Dashboard":
                            // Open Dashboard page
                            AdminDashboard adminDashboard=new AdminDashboard();
                            dispose();
                            break;
                        case "Manage User":
                            ManageUserPage msp=new ManageUserPage();
                            dispose();
                            break;
                        case "Manage Manager":
                            ManageManagerPage mmp=new ManageManagerPage();
                            dispose();
                            break;

                        case "Manage Driver":
                            ManageDriverPage mdp=new ManageDriverPage();
                            dispose();
                            break;

                        case "Manage Bus":
                            ManageBusPage mbp=new ManageBusPage();
                            dispose();
                            break;

                        case "Manage Route":
                            ManageRoutePage mrp=new ManageRoutePage();
                            dispose();
                            break;

                        case "Add Booking":
                            AddBookingPage abp=new AddBookingPage();
                            dispose();
                            break;

                        case "View Booking":
                            ViewBookingPage vbp=new ViewBookingPage();
                            dispose();
                            break;
                        case "View Seat Occupancy":
                            ViewSeatPage vsp=new ViewSeatPage();
                            dispose();
                            break;

                        case "Manage Pricing":
                            ManagePricingPage mpp=new ManagePricingPage();
                            dispose();
                            break;
                        case "Refund Management":
                            RefundManagementPage rmp=new RefundManagementPage();
                            dispose();
                            break;
                        case "Manage PromoCode":
                            ManagePromoCodePage mpcp=new ManagePromoCodePage();
                            dispose();
                            break;

                        case "Manage Taxes":
                            ManageTaxPage mtp=new ManageTaxPage();
                            dispose();
                            break;

                        case "Manage Stop Route":
                            ManageStopRoutePage mspp=new ManageStopRoutePage();
                            dispose();
                            break;

                        case "Manage Bus Maintenance":
                            ManageBusMaintenancePage mbmp=new ManageBusMaintenancePage();
                            dispose();
                            break;

                        case "View Feedback":
                            ViewFeedbackPage vfp=new ViewFeedbackPage();
                            dispose();
                            break;
                        case "Generate Report":
                            GenerateReportPage grp=new GenerateReportPage();
                            dispose();
                            break;
                    }
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                dashboardTree.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                dashboardTree.setCursor(Cursor.getDefaultCursor());
            }
        });


        DefaultTreeCellRenderer renderer = new DefaultTreeCellRenderer() {
            @Override
            public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded,
                                                          boolean leaf, int row, boolean hasFocus) {
                Component c = super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);
                // Set text color
                c.setForeground(Color.WHITE);
                // Set background color
                setBackgroundNonSelectionColor(new Color(14, 47, 68));
                setBackgroundSelectionColor(new Color(0, 102, 153));
                return c;
            }
        };
        // Set the custom renderer to the JTree
        dashboardTree.setCellRenderer(renderer);


        JLabel bookIDLabel =new JLabel();
        bookIDLabel.setText("Booking ID:");
        bookIDLabel.setBounds(240,80,150,50);
        bookIDLabel.setFont(new Font("Arial",Font.BOLD,18));
        bookIDLabel.setForeground(Color.orange);

        JTextField bookIDTxt =new JTextField();
        bookIDTxt.setBounds(400,90,150,30);

        JButton searchButton=new JButton("Search");
        searchButton.setBounds(570,90,100,30);
        searchButton.setBackground(Color.cyan);
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        JButton addButton =new JButton();
        addButton.setText("+ Add");
        addButton.setBounds(240,150,80,30);
        addButton.setBackground(Color.GREEN);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addRecord();
            }
        });

        JButton removeButton =new JButton();
        removeButton.setText("- Remove");
        removeButton.setBounds(330,150,90,30);
        removeButton.setBackground(Color.RED);
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeRecord();
            }
        });


        JButton editButton =new JButton();
        editButton.setText("Edit");
        editButton.setBounds(430,150,90,30);
        editButton.setBackground(Color.PINK);
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editRecord();
            }
        });
        JPanel tabPanel=new JPanel();
        tabPanel.setBounds(240,190,600,350);
        tabPanel.setLayout(null);

        String[][] data={

        };

        String[] column={"BookID","RouteID","Departure","Arrival","Stop 1","Stop 2","Stop 3","Stop 4","Stop 5","Travel KM","Time Taken",
                "BusID","Bus Company","Bus Name","Model","Registration Number","Chassis Number","Economy Seats","Luxury Seats","First-Class Seats","Total Seats",
                "DriverID","Driver Name","License Number","Contact Number","CNIC Number","Date","Time"};

        tableModel=new DefaultTableModel(data,column);
        recTable=new JTable(tableModel);
        recTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF); // This ensures horizontal

        recTable.getColumnModel().getColumn(0).setPreferredWidth(90);//Booking ID
        recTable.getColumnModel().getColumn(1).setPreferredWidth(90);//Route ID
        recTable.getColumnModel().getColumn(2).setPreferredWidth(100);//Departure
        recTable.getColumnModel().getColumn(3).setPreferredWidth(100);//Arrival
        recTable.getColumnModel().getColumn(4).setPreferredWidth(100);//Stop 1
        recTable.getColumnModel().getColumn(5).setPreferredWidth(100);//Stop 2
        recTable.getColumnModel().getColumn(6).setPreferredWidth(100);//Stop 3
        recTable.getColumnModel().getColumn(7).setPreferredWidth(100);//Stop 4
        recTable.getColumnModel().getColumn(8).setPreferredWidth(100);//Stop 5
        recTable.getColumnModel().getColumn(9).setPreferredWidth(100);//Travel KM
        recTable.getColumnModel().getColumn(10).setPreferredWidth(100);//Time Taken
        recTable.getColumnModel().getColumn(11).setPreferredWidth(100);//Bus ID
        recTable.getColumnModel().getColumn(12).setPreferredWidth(100);//Bus Company
        recTable.getColumnModel().getColumn(13).setPreferredWidth(100);//Bus Name
        recTable.getColumnModel().getColumn(14).setPreferredWidth(100);//Model
        recTable.getColumnModel().getColumn(15).setPreferredWidth(130);//Registration Number
        recTable.getColumnModel().getColumn(16).setPreferredWidth(130);//Chassis Number
        recTable.getColumnModel().getColumn(17).setPreferredWidth(100);//Economy Seats
        recTable.getColumnModel().getColumn(18).setPreferredWidth(100);//Luxury Seats
        recTable.getColumnModel().getColumn(19).setPreferredWidth(110);//First-Class Seats
        recTable.getColumnModel().getColumn(20).setPreferredWidth(100);//Total Seats
        recTable.getColumnModel().getColumn(21).setPreferredWidth(100);//Driver ID
        recTable.getColumnModel().getColumn(22).setPreferredWidth(100);//Driver Name
        recTable.getColumnModel().getColumn(23).setPreferredWidth(130);//License Number
        recTable.getColumnModel().getColumn(24).setPreferredWidth(130);//Contact Number
        recTable.getColumnModel().getColumn(25).setPreferredWidth(130);//CNIC Number
        recTable.getColumnModel().getColumn(26).setPreferredWidth(100);//Date
        recTable.getColumnModel().getColumn(27).setPreferredWidth(100);//Time


        JScrollPane scrollPane=new JScrollPane(recTable);
        scrollPane.setBounds(1,1,600,350);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        tabPanel.add(scrollPane);

        setTitle("Add Booking Page");
        setLayout(null);
        setSize(900, 650);
        getContentPane().setBackground(Color.darkGray);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);


        add(label);
        add(menuPanel);
        add(bookIDLabel);
        add(bookIDTxt);
        add(searchButton);
        add(addButton);
        add(editButton);
        add(removeButton);
        add(tabPanel);



    }

    public void addRecord()
    {
        JDialog addDialog = new JDialog(this, "Add New Record", true);
        addDialog.setLayout(null);
        addDialog.getContentPane().setBackground(Color.darkGray);
        addDialog.setSize(500, 550);
        addDialog.setLocationRelativeTo(null);

        JLabel addRecLabel=new JLabel();
        addRecLabel.setText("Add New Record");
        addRecLabel.setFont(new Font("Arial",Font.BOLD,25));
        addRecLabel.setForeground(Color.orange);
        addRecLabel.setBounds(150, 30,240,30);

        JLabel bookIDLabel =new JLabel();
        bookIDLabel.setText("Book ID:");
        bookIDLabel.setBounds(70,100,220,30);
        bookIDLabel.setFont(new Font("Arial",Font.BOLD,20));
        bookIDLabel.setForeground(Color.orange);

        JTextField bookIDTxt =new JTextField();
        bookIDTxt.setBounds(230,100,150,30);


        JLabel routeIDLabel =new JLabel();
        routeIDLabel.setText("Route ID:");
        routeIDLabel.setBounds(70,150,220,30);
        routeIDLabel.setFont(new Font("Arial",Font.BOLD,20));
        routeIDLabel.setForeground(Color.orange);

        JTextField routeIDTxt =new JTextField();
        routeIDTxt.setBounds(230,150,150,30);

        JLabel busIDLabel =new JLabel();
        busIDLabel.setText("Bus ID:");
        busIDLabel.setBounds(70,200,220,30);
        busIDLabel.setFont(new Font("Arial",Font.BOLD,20));
        busIDLabel.setForeground(Color.orange);

        JTextField busIDTxt =new JTextField();
        busIDTxt.setBounds(230,200,150,30);

        JLabel driverIDLabel =new JLabel();
        driverIDLabel.setText("Driver ID:");
        driverIDLabel.setBounds(70,250,220,30);
        driverIDLabel.setFont(new Font("Arial",Font.BOLD,20));
        driverIDLabel.setForeground(Color.orange);

        JTextField driverIDTxt =new JTextField();
        driverIDTxt.setBounds(230,250,150,30);

        JLabel dateLabel =new JLabel();
        dateLabel.setText("Date:");
        dateLabel.setBounds(70,300,220,30);
        dateLabel.setFont(new Font("Arial",Font.BOLD,20));
        dateLabel.setForeground(Color.orange);

        JLabel dayLabel =new JLabel("(Day)");
        dayLabel.setBounds(230,330,50,30);
        dayLabel.setForeground(Color.orange);
        dayLabel.setFont(new Font("Arial",Font.BOLD,11));

        JTextField dayTxt =new JTextField();
        dayTxt.setBounds(230,300,40,30);

        JLabel monLabel =new JLabel("(Month)");
        monLabel.setBounds(290,330,50,30);
        monLabel.setForeground(Color.orange);
        monLabel.setFont(new Font("Arial",Font.BOLD,11));

        JTextField monTxt =new JTextField();
        monTxt.setBounds(290,300,40,30);

        JLabel yearLabel =new JLabel("(Year)");
        yearLabel.setBounds(350,330,50,30);
        yearLabel.setForeground(Color.orange);
        yearLabel.setFont(new Font("Arial",Font.BOLD,11));

        JTextField yearTxt =new JTextField();
        yearTxt.setBounds(350,300,40,30);


        JLabel timeLabel =new JLabel();
        timeLabel.setText("Time:");
        timeLabel.setBounds(70,370,220,30);
        timeLabel.setFont(new Font("Arial",Font.BOLD,20));
        timeLabel.setForeground(Color.orange);

        JLabel hourLabel =new JLabel("(Hour)");
        hourLabel.setBounds(230,395,50,30);
        hourLabel.setForeground(Color.orange);
        hourLabel.setFont(new Font("Arial",Font.BOLD,11));

        JTextField hourTxt =new JTextField();
        hourTxt.setBounds(230,370,40,30);

        JLabel minuteLabel =new JLabel("(Minute)");
        minuteLabel.setBounds(290,395,50,30);
        minuteLabel.setForeground(Color.orange);
        minuteLabel.setFont(new Font("Arial",Font.BOLD,11));

        JTextField minuteTxt =new JTextField();
        minuteTxt.setBounds(290,370,40,30);

        JButton addButton=new JButton("Add");
        addButton.setBounds(150,450,100,40);
        addButton.setBackground(Color.cyan);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String date=dayTxt.getText()+"-"+monTxt.getText()+"-"+yearTxt.getText();
                String time=hourTxt.getText()+":"+minuteTxt.getText();

                String[] row={bookIDTxt.getText(),routeIDTxt.getText(),"","","","","","","","","",busIDTxt.getText(),
                "","","","","","","","","",driverIDTxt.getText(),"","","","",date,time};
                tableModel.addRow(row);
                addDialog.dispose();
            }
        });

        addDialog.add(addRecLabel);
        addDialog.add(bookIDLabel);
        addDialog.add(bookIDTxt);
        addDialog.add(busIDLabel);
        addDialog.add(busIDTxt);
        addDialog.add(routeIDLabel);
        addDialog.add(routeIDTxt);
        addDialog.add(driverIDLabel);
        addDialog.add(driverIDTxt);

        addDialog.add(dateLabel);
        addDialog.add(dayTxt);
        addDialog.add(dayLabel);
        addDialog.add(monLabel);
        addDialog.add(monTxt);
        addDialog.add(yearLabel);
        addDialog.add(yearTxt);

        addDialog.add(timeLabel);
        addDialog.add(hourLabel);
        addDialog.add(hourTxt);
        addDialog.add(minuteLabel);
        addDialog.add(minuteTxt);
        addDialog.add(addButton);

        addDialog.setResizable(false);
        addDialog.setVisible(true);

    }

    public void removeRecord()
    {
        JDialog removeDialog = new JDialog(this, "Remove Record", true);
        removeDialog.setLayout(null);
        removeDialog.getContentPane().setBackground(Color.darkGray);
        removeDialog.setSize(400, 350);
        removeDialog.setLocationRelativeTo(null);
        removeDialog.setResizable(false);


        JLabel addRecLabel=new JLabel();
        addRecLabel.setText("Remove Record");
        addRecLabel.setFont(new Font("Arial",Font.BOLD,22));
        addRecLabel.setForeground(Color.orange);
        addRecLabel.setBounds(100, 30,240,30);


        JLabel bookIDLabel =new JLabel();
        bookIDLabel.setText("Book ID:");
        bookIDLabel.setBounds(10,100,180,30);
        bookIDLabel.setFont(new Font("Arial",Font.BOLD,17));
        bookIDLabel.setForeground(Color.orange);

        JTextField bookIDTxt =new JTextField();
        bookIDTxt.setBounds(200,100,150,30);


        JButton searchButton=new JButton("Search");
        searchButton.setBounds(130,170,100,30);
        searchButton.setBackground(Color.cyan);
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String IDVal = bookIDTxt.getText();
                boolean found=false;
                for (int i = 0; i < tableModel.getRowCount(); i++)
                {
                    if (tableModel.getValueAt(i, 0).equals(IDVal))
                    { // Checking Reg number at index 4 & Bus ID at index 0
                        tableModel.removeRow(i);
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    JOptionPane.showMessageDialog(removeDialog, "Record with Booking ID " + IDVal +" not found.", "Record Not Found", JOptionPane.WARNING_MESSAGE);
                }
                else {
                    JOptionPane.showMessageDialog(removeDialog, "Record with Booking ID " + IDVal +  " removed successfully.", "Record Removed", JOptionPane.INFORMATION_MESSAGE);
                }
            }

        });

        removeDialog.add(addRecLabel);
        removeDialog.add(bookIDLabel);
        removeDialog.add(bookIDTxt);
        removeDialog.add(searchButton);

        removeDialog.setVisible(true);
    }
    public void editRecord()
    {
        JDialog editDialog = new JDialog(this, "Edit Record", true);
        editDialog.setLayout(null);
        editDialog.getContentPane().setBackground(Color.darkGray);
        editDialog.setSize(500, 600);
        editDialog.setLocationRelativeTo(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBounds(0, 0, 485, 580);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(null);
        inputPanel.setBackground(Color.darkGray);
        inputPanel.setPreferredSize(new Dimension(480, 680));

        JLabel editRecLabel =new JLabel();
        editRecLabel.setText("Edit Record");
        editRecLabel.setFont(new Font("Arial",Font.BOLD,22));
        editRecLabel.setForeground(Color.orange);
        editRecLabel.setBounds(150, 30,240,30);


        JLabel bookIDLabel =new JLabel();
        bookIDLabel.setText("Booking ID:");
        bookIDLabel.setBounds(40,100,150,30);
        bookIDLabel.setFont(new Font("Arial",Font.BOLD,20));
        bookIDLabel.setForeground(Color.orange);

        JTextField bookIDTxt =new JTextField();
        bookIDTxt.setBounds(200,100,150,30);


        JCheckBox routeIDCheckBox =new JCheckBox("Route ID");
        routeIDCheckBox.setForeground(Color.orange);
        routeIDCheckBox.setBackground(Color.darkGray);
        routeIDCheckBox.setBounds(30,200,80,30);
        routeIDCheckBox.setVisible(false);

        JCheckBox busIDCheckBox =new JCheckBox("Bus ID");
        busIDCheckBox.setForeground(Color.orange);
        busIDCheckBox.setBackground(Color.darkGray);
        busIDCheckBox.setBounds(150,200,80,30);
        busIDCheckBox.setVisible(false);

        JCheckBox driverIDCheckBox =new JCheckBox("Driver ID");
        driverIDCheckBox.setForeground(Color.orange);
        driverIDCheckBox.setBackground(Color.darkGray);
        driverIDCheckBox.setBounds(250,200,80,30);
        driverIDCheckBox.setVisible(false);

        JCheckBox dateCheckBox =new JCheckBox("Date");
        dateCheckBox.setForeground(Color.orange);
        dateCheckBox.setBackground(Color.darkGray);
        dateCheckBox.setBounds(350,200,60,30);
        dateCheckBox.setVisible(false);

        JCheckBox timeCheckBox =new JCheckBox("Time");
        timeCheckBox.setForeground(Color.orange);
        timeCheckBox.setBackground(Color.darkGray);
        timeCheckBox.setBounds(30,250,60,30);
        timeCheckBox.setVisible(false);

        JLabel routeIDLabel =new JLabel();
        routeIDLabel.setText("Route ID:");
        routeIDLabel.setBounds(70,300,220,30);
        routeIDLabel.setFont(new Font("Arial",Font.BOLD,20));
        routeIDLabel.setForeground(Color.orange);
        routeIDLabel.setVisible(false);

        JTextField routeIDTxt =new JTextField();
        routeIDTxt.setBounds(230,300,150,30);
        routeIDTxt.setVisible(false);

        JLabel busIDLabel =new JLabel();
        busIDLabel.setText("Bus ID:");
        busIDLabel.setBounds(70,350,220,30);
        busIDLabel.setFont(new Font("Arial",Font.BOLD,20));
        busIDLabel.setForeground(Color.orange);
        busIDLabel.setVisible(false);

        JTextField busIDTxt =new JTextField();
        busIDTxt.setBounds(230,350,150,30);
        busIDTxt.setVisible(false);

        JLabel driverIDLabel =new JLabel();
        driverIDLabel.setText("Driver ID:");
        driverIDLabel.setBounds(70,400,220,30);
        driverIDLabel.setFont(new Font("Arial",Font.BOLD,20));
        driverIDLabel.setForeground(Color.orange);
        driverIDLabel.setVisible(false);

        JTextField driverIDTxt =new JTextField();
        driverIDTxt.setBounds(230,400,150,30);
        driverIDTxt.setVisible(false);

        JLabel dateLabel =new JLabel();
        dateLabel.setText("Date:");
        dateLabel.setBounds(70,450,220,30);
        dateLabel.setFont(new Font("Arial",Font.BOLD,20));
        dateLabel.setForeground(Color.orange);
        dateLabel.setVisible(false);

        JLabel dayLabel =new JLabel("(Day)");
        dayLabel.setBounds(230,480,50,30);
        dayLabel.setForeground(Color.orange);
        dayLabel.setFont(new Font("Arial",Font.BOLD,11));
        dayLabel.setVisible(false);

        JTextField dayTxt =new JTextField();
        dayTxt.setBounds(230,450,40,30);
        dayTxt.setVisible(false);

        JLabel monLabel =new JLabel("(Month)");
        monLabel.setBounds(290,480,50,30);
        monLabel.setForeground(Color.orange);
        monLabel.setFont(new Font("Arial",Font.BOLD,11));
        monLabel.setVisible(false);

        JTextField monTxt =new JTextField();
        monTxt.setBounds(290,450,40,30);
        monTxt.setVisible(false);

        JLabel yearLabel =new JLabel("(Year)");
        yearLabel.setBounds(350,480,50,30);
        yearLabel.setForeground(Color.orange);
        yearLabel.setFont(new Font("Arial",Font.BOLD,11));
        yearLabel.setVisible(false);

        JTextField yearTxt =new JTextField();
        yearTxt.setBounds(350,450,40,30);
        yearTxt.setVisible(false);

        JLabel timeLabel =new JLabel();
        timeLabel.setText("Time:");
        timeLabel.setBounds(70,530,220,30);
        timeLabel.setFont(new Font("Arial",Font.BOLD,20));
        timeLabel.setForeground(Color.orange);
        timeLabel.setVisible(false);

        JLabel hourLabel =new JLabel("(Hour)");
        hourLabel.setBounds(230,555,50,30);
        hourLabel.setForeground(Color.orange);
        hourLabel.setFont(new Font("Arial",Font.BOLD,11));
        hourLabel.setVisible(false);

        JTextField hourTxt =new JTextField();
        hourTxt.setBounds(230,530,40,30);
        hourTxt.setVisible(false);

        JLabel minuteLabel =new JLabel("(Minute)");
        minuteLabel.setBounds(290,555,50,30);
        minuteLabel.setForeground(Color.orange);
        minuteLabel.setFont(new Font("Arial",Font.BOLD,11));
        minuteLabel.setVisible(false);

        JTextField minuteTxt =new JTextField();
        minuteTxt.setBounds(290,530,40,30);
        minuteTxt.setVisible(false);


        JButton searchButton=new JButton("Search");
        searchButton.setBounds(170,150,100,30);
        searchButton.setBackground(Color.cyan);
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String val= bookIDTxt.getText();
                boolean found=false;
                for (int i = 0; i < tableModel.getRowCount(); i++)
                {
                    if (tableModel.getValueAt(i, 0).equals(val))
                    {
                        routeIDCheckBox.setVisible(true);
                        busIDCheckBox.setVisible(true);
                        driverIDCheckBox.setVisible(true);
                        dateCheckBox.setVisible(true);
                        timeCheckBox.setVisible(true);
                        found = true;
                        break;
                    }
                }
                if (!found)
                {
                    JOptionPane.showMessageDialog(editDialog, "Record with Booking ID " + val + " not found.", "Record Not Found", JOptionPane.WARNING_MESSAGE);
                }

            }
        });

        JButton editButton=new JButton("Edit");
        editButton.setBounds(130,610,100,30);
        editButton.setBackground(Color.cyan);
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String date=dayTxt.getText()+"-"+monTxt.getText()+"-"+yearTxt.getText();
                String time=hourTxt.getText()+":"+minuteTxt.getText();

                String val= bookIDTxt.getText();
                for (int i = 0; i < tableModel.getRowCount(); i++)
                {
                    if (tableModel.getValueAt(i, 0).equals(val))
                    {


                        if(routeIDCheckBox.isSelected())
                        {
                            recTable.setValueAt(routeIDTxt.getText(),i,1);

                        }
                        if (busIDCheckBox.isSelected())
                        {
                            recTable.setValueAt(busIDTxt.getText(),i,11);

                        }
                        if(driverIDCheckBox.isSelected())
                        {
                            recTable.setValueAt(driverIDTxt.getText(),i,21);

                        }
                        if(dateCheckBox.isSelected())
                        {
                            recTable.setValueAt(date,i,26);

                        }
                        if(timeCheckBox.isSelected())
                        {
                            recTable.setValueAt(time,i,27);
                        }

                        editDialog.dispose();
                        break;
                    }
                }
            }
        });

        routeIDCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(routeIDCheckBox.isSelected())
                {
                    routeIDLabel.setVisible(true);
                    routeIDTxt.setVisible(true);
                }
                else {
                    routeIDLabel.setVisible(false);
                    routeIDTxt.setVisible(false);
                }
            }
        });

        busIDCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (busIDCheckBox.isSelected())
                {
                    busIDLabel.setVisible(true);
                    busIDTxt.setVisible(true);
                }
                else {
                    busIDLabel.setVisible(false);
                    busIDTxt.setVisible(false);
                }
            }
        });

        driverIDCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (driverIDCheckBox.isSelected())
                {
                    driverIDLabel.setVisible(true);
                    driverIDTxt.setVisible(true);
                }
                else {
                    driverIDLabel.setVisible(false);
                    driverIDTxt.setVisible(false);
                }
            }
        });

        dateCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(dateCheckBox.isSelected())
                {
                    dateLabel.setVisible(true);
                    dayLabel.setVisible(true);
                    dayTxt.setVisible(true);
                    monLabel.setVisible(true);
                    monTxt.setVisible(true);
                    yearLabel.setVisible(true);
                    yearTxt.setVisible(true);
                }
                else {
                    dateLabel.setVisible(false);
                    dayLabel.setVisible(false);
                    dayTxt.setVisible(false);
                    monLabel.setVisible(false);
                    monTxt.setVisible(false);
                    yearLabel.setVisible(false);
                    yearTxt.setVisible(false);
                }
            }
        });

        timeCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(timeCheckBox.isSelected())
                {
                    timeLabel.setVisible(true);
                    hourLabel.setVisible(true);
                    hourTxt.setVisible(true);
                    minuteLabel.setVisible(true);
                    minuteTxt.setVisible(true);
                }
                else
                {
                    timeLabel.setVisible(false);
                    hourLabel.setVisible(false);
                    hourTxt.setVisible(false);
                    minuteLabel.setVisible(false);
                    minuteTxt.setVisible(false);
                }
            }
        });

        inputPanel.add(editRecLabel);
        inputPanel.add(bookIDLabel);
        inputPanel.add(bookIDTxt);
        inputPanel.add(searchButton);
        inputPanel.add(routeIDCheckBox);
        inputPanel.add(busIDCheckBox);
        inputPanel.add(driverIDCheckBox);
        inputPanel.add(dateCheckBox);
        inputPanel.add(timeCheckBox);
        inputPanel.add(routeIDLabel);
        inputPanel.add(routeIDTxt);
        inputPanel.add(busIDLabel);
        inputPanel.add(busIDTxt);
        inputPanel.add(driverIDLabel);
        inputPanel.add(driverIDTxt);
        inputPanel.add(dateLabel);
        inputPanel.add(dayLabel);
        inputPanel.add(dayTxt);
        inputPanel.add(monLabel);
        inputPanel.add(monTxt);
        inputPanel.add(yearLabel);
        inputPanel.add(yearTxt);
        inputPanel.add(timeLabel);
        inputPanel.add(hourLabel);
        inputPanel.add(hourTxt);
        inputPanel.add(minuteLabel);
        inputPanel.add(minuteTxt);
        inputPanel.add(editButton);


        editDialog.add(inputPanel);
        scrollPane.setViewportView(inputPanel);
        editDialog.getContentPane().add(scrollPane);

        editDialog.setResizable(false);
        editDialog.setVisible(true);


    }

    public static void main(String[] args)
    {
        AddBookingPage abp=new AddBookingPage();
    }
}
