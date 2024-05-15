package Project.Admin.BusManagement;

import Project.Admin.AdminDashboard;
import Project.Admin.BookingManagement.*;
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

public class ManageBusPage extends JFrame {
    DefaultTableModel tableModel;
    JTable recTable;

    public ManageBusPage() {
        JLabel label=new JLabel();
        label.setText("Manage Buses");
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

        //Children of Booking Management
        DefaultMutableTreeNode add_booking=new DefaultMutableTreeNode("Add Booking");
        DefaultMutableTreeNode view_booking=new DefaultMutableTreeNode("View Booking");
        DefaultMutableTreeNode manage_pricing=new DefaultMutableTreeNode("Manage Pricing");
        DefaultMutableTreeNode view_seat=new DefaultMutableTreeNode("View Seat Occupancy");
        DefaultMutableTreeNode refund_manage=new DefaultMutableTreeNode("Refund Management");

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

        bookingManagement.add(add_booking);
        bookingManagement.add(view_booking);
        bookingManagement.add(manage_pricing);
        bookingManagement.add(view_seat);
        bookingManagement.add(refund_manage);

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


        JLabel regSearchLabel =new JLabel();
        regSearchLabel.setText("Registration Number:");
        regSearchLabel.setBounds(240,80,180,50);
        regSearchLabel.setFont(new Font("Arial",Font.BOLD,15));
        regSearchLabel.setForeground(Color.orange);

        JTextField regSearchTxt =new JTextField();
        regSearchTxt.setBounds(430,90,150,30);

        JLabel busIDSearchLabel =new JLabel();
        busIDSearchLabel.setText(" Bus ID:");
        busIDSearchLabel.setBounds(240,130,180,50);
        busIDSearchLabel.setFont(new Font("Arial",Font.BOLD,15));
        busIDSearchLabel.setForeground(Color.orange);

        JTextField busIDSearchTxt =new JTextField();
        busIDSearchTxt.setBounds(430,140,150,30);


        JButton searchButton=new JButton("Search");
        searchButton.setBounds(400,200,100,30);
        searchButton.setBackground(Color.cyan);
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                /*
                String val= cnicSearchTxt.getText();
                boolean found=false;
                for (int i = 0; i < tableModel.getRowCount(); i++)
                {
                    if (tableModel.getValueAt(i, 4).equals(val))
                    {
                        String message = "Employee ID: " + recTable.getValueAt(i, 0) + "\n" +
                                "Name: " + recTable.getValueAt(i, 1) + "\n" +
                                "License Number: " + recTable.getValueAt(i, 2) + "\n" +
                                "Contact Number: " + recTable.getValueAt(i, 3) + "\n" +
                                "CNIC No.: " + recTable.getValueAt(i, 4) + "\n" +
                                "Address: " + recTable.getValueAt(i, 5)+"\n"+
                                "Staus: "+recTable.getValueAt(i,6);
                        JOptionPane.showMessageDialog(null, message, "Record Found", JOptionPane.INFORMATION_MESSAGE);

                        found = true;
                        break;
                    }
                }
                if (!found)
                {
                    JOptionPane.showMessageDialog(null, "Record with CNIC number " + val + " not found.", "Record Not Found", JOptionPane.WARNING_MESSAGE);
                }

                 */
            }


        });

        JButton addButton =new JButton();
        addButton.setText("+ Add");
        addButton.setBounds(240,260,80,30);
        addButton.setBackground(Color.GREEN);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                addRecord();
            }
        });

        JButton removeButton =new JButton();
        removeButton.setText("- Remove");
        removeButton.setBounds(330,260,90,30);
        removeButton.setBackground(Color.RED);
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                removeRecord();
            }
        });



        JButton editButton =new JButton();
        editButton.setText("Edit");
        editButton.setBounds(430,260,90,30);
        editButton.setBackground(Color.PINK);
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                editRecord();
            }
        });


        JPanel tabPanel=new JPanel();
        tabPanel.setBounds(250,300,580,300);
        tabPanel.setLayout(null);

        String[][] data = {
                {"12345", "ABC Bus Company",  "Super Express",  "XYZ Model", "ABCD1234",    "CHAS123456", "50", "20",  "10",
                "80", "1-10", "21-40", "41-60", "Active" },
                {"12345", "ABC Bus Company",  "Super Express",  "XYZ Model", "ABCD1234",    "CHAS123456", "50", "20",  "10",
                "80", "1-10", "21-40", "41-60", "Active" },
                {"12345", "ABC Bus Company",  "Super Express",  "XYZ Model", "ABCD1234",    "CHAS123456", "50", "20",  "10",
                "80", "1-10", "21-40", "41-60", "Active" },
                {"12345", "ABC Bus Company",  "Super Express",  "XYZ Model", "ABCD1234",    "CHAS123456", "50", "20",  "10",
                "80", "1-10", "21-40", "41-60", "Active" },
                {"5", "ABC Bus Company",  "Super Express",  "XYZ Model", "5",    "CHAS123456", "50", "20",  "10",
                "80", "1-10", "21-40", "41-60", "Active" }

        };
        String[] column={"Bus ID","Bus Company","Bus Name","Model No","Registration Number","Chassis Number","Economy Seats","Luxury Seats"
                ,"First-Class Seats","Total Capacity","Economy Seat No.","Luxury Seat No.","First-Class Seat No.","Availability"};

        tableModel=new DefaultTableModel(data,column);
        recTable=new JTable(tableModel);
        recTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF); // This ensures horizontal scrolling

        JScrollPane scrollPane=new JScrollPane(recTable);
        scrollPane.setBounds(1,1,580,300);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        recTable.getColumnModel().getColumn(0).setPreferredWidth(70); // Bus ID
        recTable.getColumnModel().getColumn(1).setPreferredWidth(100); // Bus Company
        recTable.getColumnModel().getColumn(2).setPreferredWidth(120); // Name
        recTable.getColumnModel().getColumn(3).setPreferredWidth(80); // Model No
        recTable.getColumnModel().getColumn(4).setPreferredWidth(130); // Registration Number
        recTable.getColumnModel().getColumn(5).setPreferredWidth(110); // Chassis Number
        recTable.getColumnModel().getColumn(6).setPreferredWidth(100); // Economy Seats
        recTable.getColumnModel().getColumn(7).setPreferredWidth(100); // Luxury Seats
        recTable.getColumnModel().getColumn(8).setPreferredWidth(120); // First-Class Seats
        recTable.getColumnModel().getColumn(9).setPreferredWidth(100); // Total Capacity
        recTable.getColumnModel().getColumn(10).setPreferredWidth(130); // Economy Seats Number
        recTable.getColumnModel().getColumn(11).setPreferredWidth(130); // Luxury Seats Number
        recTable.getColumnModel().getColumn(12).setPreferredWidth(130); // First-Class Seats Number
        recTable.getColumnModel().getColumn(13).setPreferredWidth(100); // Availability

        tabPanel.add(scrollPane);

        setTitle("Manage Bus Page");
        setLayout(null);
        setSize(900, 650);
        getContentPane().setBackground(Color.darkGray);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);


        add(label);
        add(menuPanel);
        add(regSearchLabel);
        add(regSearchTxt);
        add(busIDSearchLabel);
        add(busIDSearchTxt);
        add(searchButton);
        add(addButton);
        add(removeButton);
        add(editButton);
        add(tabPanel);


    }

    public void addRecord()
    {
        JDialog addDialog = new JDialog(this, "Add New Record", true);
        addDialog.setLayout(null);
        addDialog.getContentPane().setBackground(Color.darkGray);
        addDialog.setSize(500, 650);
        addDialog.setLocationRelativeTo(null);

        JLabel addRecLabel=new JLabel();
        addRecLabel.setText("Add New Record");
        addRecLabel.setFont(new Font("Arial",Font.BOLD,25));
        addRecLabel.setForeground(Color.orange);
        addRecLabel.setBounds(150, 30,240,30);

        JLabel busIDLabel =new JLabel();
        busIDLabel.setText("Bus ID:");
        busIDLabel.setBounds(10,100,220,30);
        busIDLabel.setFont(new Font("Arial",Font.BOLD,20));
        busIDLabel.setForeground(Color.orange);

        JTextField busIDTxt =new JTextField();
        busIDTxt.setBounds(230,100,150,30);


        JLabel busCompLabel =new JLabel();
        busCompLabel.setText("Bus Company Name:");
        busCompLabel.setBounds(10,150,220,30);
        busCompLabel.setFont(new Font("Arial",Font.BOLD,20));
        busCompLabel.setForeground(Color.orange);

        JTextField busCompTxt =new JTextField();
        busCompTxt.setBounds(230,150,150,30);

        JLabel busNameLabel=new JLabel();
        busNameLabel.setText("Bus Name:");
        busNameLabel.setBounds(10,200,220,30);
        busNameLabel.setFont(new Font("Arial",Font.BOLD,20));
        busNameLabel.setForeground(Color.orange);

        JTextField busNameTxt =new JTextField();
        busNameTxt.setBounds(230,200,150,30);

        JLabel modelLabel =new JLabel();
        modelLabel.setText("Bus Model:");
        modelLabel.setBounds(10,250,220,30);
        modelLabel.setFont(new Font("Arial",Font.BOLD,20));
        modelLabel.setForeground(Color.orange);

        JTextField modelTxt =new JTextField();
        modelTxt.setBounds(230,250,150,30);

        JLabel regNoLabel =new JLabel();
        regNoLabel.setText("Registration Number:");
        regNoLabel.setBounds(10,300,220,30);
        regNoLabel.setFont(new Font("Arial",Font.BOLD,20));
        regNoLabel.setForeground(Color.orange);

        JTextField regNoTxt =new JTextField();
        regNoTxt.setBounds(230,300,150,30);

        JLabel chassisNoLabel =new JLabel();
        chassisNoLabel.setText("Chassis Number:");
        chassisNoLabel.setBounds(10,350,220,30);
        chassisNoLabel.setFont(new Font("Arial",Font.BOLD,20));
        chassisNoLabel.setForeground(Color.orange);

        JTextField chassisNoTxt =new JTextField();
        chassisNoTxt.setBounds(230,350,150,30);

        JLabel economyLabel =new JLabel();
        economyLabel.setText("Economy Seats:");
        economyLabel.setBounds(10,400,220,30);
        economyLabel.setFont(new Font("Arial",Font.BOLD,20));
        economyLabel.setForeground(Color.orange);

        JTextField economyTxt =new JTextField();
        economyTxt.setBounds(230,400,70,30);

        JLabel luxuryLabel =new JLabel();
        luxuryLabel.setText("Luxury Seats:");
        luxuryLabel.setBounds(10,450,220,30);
        luxuryLabel.setFont(new Font("Arial",Font.BOLD,20));
        luxuryLabel.setForeground(Color.orange);

        JTextField luxuryTxt =new JTextField();
        luxuryTxt.setBounds(230,450,70,30);

        JLabel firstClassLabel =new JLabel();
        firstClassLabel.setText("First-Class Seats:");
        firstClassLabel.setBounds(10,500,220,30);
        firstClassLabel.setFont(new Font("Arial",Font.BOLD,20));
        firstClassLabel.setForeground(Color.orange);

        JTextField firstClassTxt =new JTextField();
        firstClassTxt.setBounds(230,500,70,30);

        JButton addButton=new JButton("Add");
        addButton.setBounds(150,550,100,40);
        addButton.setBackground(Color.cyan);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int economySeat = Integer.parseInt(economyTxt.getText());
                int luxurySeat = Integer.parseInt(luxuryTxt.getText());
                int firstSeat = Integer.parseInt(firstClassTxt.getText());
                int totalSeat=economySeat+luxurySeat+firstSeat;

                String economySeats = generateSeatRange("E", 1, economySeat);
                String luxurySeats = generateSeatRange("L", 1, luxurySeat);
                String firstClassSeats = generateSeatRange("F", 1, firstSeat);

                String[] row={busIDTxt.getText(), busCompTxt.getText(), busNameTxt.getText(), modelTxt.getText(), regNoTxt.getText(), chassisNoTxt.getText(),
                        Integer.toString(economySeat), Integer.toString(luxurySeat), Integer.toString(firstSeat), Integer.toString(totalSeat), economySeats,luxurySeats,firstClassSeats,"Active"};

                tableModel.addRow(row);
                addDialog.dispose();
            }
        });

        addDialog.add(addRecLabel);
        addDialog.add(busIDLabel);
        addDialog.add(busIDTxt);
        addDialog.add(busNameLabel);
        addDialog.add(busNameTxt);
        addDialog.add(busCompLabel);
        addDialog.add(busCompTxt);
        addDialog.add(modelLabel);
        addDialog.add(modelTxt);
        addDialog.add(regNoLabel);
        addDialog.add(regNoTxt);
        addDialog.add(chassisNoLabel);
        addDialog.add(chassisNoTxt);
        addDialog.add(luxuryLabel);
        addDialog.add(luxuryTxt);
        addDialog.add(economyLabel);
        addDialog.add(economyTxt);
        addDialog.add(firstClassLabel);
        addDialog.add(firstClassTxt);
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


        JLabel addRecLabel=new JLabel();
        addRecLabel.setText("Remove Record");
        addRecLabel.setFont(new Font("Arial",Font.BOLD,22));
        addRecLabel.setForeground(Color.orange);
        addRecLabel.setBounds(100, 30,240,30);


        JLabel regNoLabel =new JLabel();
        regNoLabel.setText("Registration Number:");
        regNoLabel.setBounds(10,100,180,30);
        regNoLabel.setFont(new Font("Arial",Font.BOLD,17));
        regNoLabel.setForeground(Color.orange);

        JTextField regNoTxt =new JTextField();
        regNoTxt.setBounds(200,100,150,30);

        JLabel busIDLabel =new JLabel();
        busIDLabel.setText("Bus ID:");
        busIDLabel.setBounds(10,150,180,30);
        busIDLabel.setFont(new Font("Arial",Font.BOLD,17));
        busIDLabel.setForeground(Color.orange);

        JTextField busIDTxt =new JTextField();
        busIDTxt.setBounds(200,150,150,30);

        JButton searchButton=new JButton("Search");
        searchButton.setBounds(130,220,100,30);
        searchButton.setBackground(Color.cyan);
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String regVal= regNoTxt.getText();
                String idVal=busIDTxt.getText();
                boolean found=false;
                for (int i = 0; i < tableModel.getRowCount(); i++)
                {
                    if (tableModel.getValueAt(i, 4).equals(regVal)&&tableModel.getValueAt(i,0).equals(idVal))
                    { // Checking Reg number at index 4 & Bus ID at index 0
                        tableModel.removeRow(i);
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    JOptionPane.showMessageDialog(removeDialog, "Record with Registration Number " + regVal +
                            " & ID: " +idVal+ " not found.", "Record Not Found", JOptionPane.WARNING_MESSAGE);
                }
                else {
                    JOptionPane.showMessageDialog(removeDialog, "Record with Registration Number " + regVal +
                            " & ID: " +idVal+ " removed successfully.", "Record Removed", JOptionPane.INFORMATION_MESSAGE);
                }
            }



        });

        removeDialog.add(addRecLabel);
        removeDialog.add(regNoLabel);
        removeDialog.add(regNoTxt);
        removeDialog.add(busIDLabel);
        removeDialog.add(busIDTxt);
        removeDialog.add(searchButton);

        removeDialog.setResizable(false);
        removeDialog.setVisible(true);

    }

    public void editRecord()
    {

        JDialog editDialog = new JDialog(this, "Edit Record", true);
        editDialog.setLayout(null);
        editDialog.getContentPane().setBackground(Color.darkGray);
        editDialog.setSize(500, 600);
        editDialog.setLocationRelativeTo(null);

        JLabel editRecLabel =new JLabel();
        editRecLabel.setText("Edit Record");
        editRecLabel.setFont(new Font("Arial",Font.BOLD,22));
        editRecLabel.setForeground(Color.orange);
        editRecLabel.setBounds(150, 30,240,30);


        JLabel regNoLabel =new JLabel();
        regNoLabel.setText("Registration Number:");
        regNoLabel.setBounds(10,100,230,30);
        regNoLabel.setFont(new Font("Arial",Font.BOLD,20));
        regNoLabel.setForeground(Color.orange);

        JTextField regNoTxt=new JTextField();
        regNoTxt.setBounds(230,105,150,30);

        JLabel busIDLabel =new JLabel();
        busIDLabel.setText("Bus ID:");
        busIDLabel.setBounds(10,150,230,30);
        busIDLabel.setFont(new Font("Arial",Font.BOLD,20));
        busIDLabel.setForeground(Color.orange);

        JTextField busIDTxt=new JTextField();
        busIDTxt.setBounds(230,155,150,30);

        JCheckBox economyCheckbox =new JCheckBox("Economy Seats");
        economyCheckbox.setBackground( Color.darkGray);
        economyCheckbox.setForeground(Color.orange);
        economyCheckbox.setBounds(10,250,130,30);
        economyCheckbox.setVisible(false);


        JCheckBox luxuryCheckbox =new JCheckBox("Luxury Seats");
        luxuryCheckbox.setBackground( Color.darkGray);
        luxuryCheckbox.setForeground(Color.orange);
        luxuryCheckbox.setBounds(140,250,110,30);
        luxuryCheckbox.setVisible(false);

        JCheckBox firstClassCheckbox =new JCheckBox("First-Class Seats");
        firstClassCheckbox.setBackground( Color.darkGray);
        firstClassCheckbox.setForeground(Color.orange);
        firstClassCheckbox.setBounds(250,250,130,30);
        firstClassCheckbox.setVisible(false);


        JCheckBox availabilityCheckbox =new JCheckBox("Availability");
        availabilityCheckbox.setBackground( Color.darkGray);
        availabilityCheckbox.setForeground(Color.orange);
        availabilityCheckbox.setBounds(380,250,120,30);
        availabilityCheckbox.setVisible(false);


        JLabel economySeatLabel=new JLabel();
        economySeatLabel.setText("Economy Seats:");
        economySeatLabel.setBounds(10,300,180,30);
        economySeatLabel.setFont(new Font("Arial",Font.BOLD,20));
        economySeatLabel.setForeground(Color.orange);
        economySeatLabel.setVisible(false);

        JTextField economySeatTxt =new JTextField();
        economySeatTxt.setBounds(200,300,150,30);
        economySeatTxt.setVisible(false);

        JLabel luxurySeatLabel =new JLabel();
        luxurySeatLabel.setText("Luxury Seat:");
        luxurySeatLabel.setBounds(10,350,180,30);
        luxurySeatLabel.setFont(new Font("Arial",Font.BOLD,20));
        luxurySeatLabel.setForeground(Color.orange);
        luxurySeatLabel.setVisible(false);

        JTextField luxurySeatTxt =new JTextField();
        luxurySeatTxt.setBounds(200,350,150,30);
        luxurySeatTxt.setVisible(false);


        JLabel firstClassSeatLabel=new JLabel();
        firstClassSeatLabel.setText("First-Class Seat:");
        firstClassSeatLabel.setBounds(10,400,180,30);
        firstClassSeatLabel.setFont(new Font("Arial",Font.BOLD,20));
        firstClassSeatLabel.setForeground(Color.orange);
        firstClassSeatLabel.setVisible(false);

        JTextField firstClassSeatTxt =new JTextField();
        firstClassSeatTxt.setBounds(200,400,150,30);
        firstClassSeatTxt.setVisible(false);

        JLabel availabilityLabel =new JLabel();
        availabilityLabel.setText("Select Availability:");
        availabilityLabel.setBounds(10,450,180,30);
        availabilityLabel.setFont(new Font("Arial",Font.BOLD,20));
        availabilityLabel.setForeground(Color.orange);
        availabilityLabel.setVisible(false);

        String[] avail={"-","Active","Not Active"};

        JComboBox availabilityCombobox =new JComboBox<>(avail);
        availabilityCombobox.setBounds(200,450,150,35);
        availabilityCombobox.setBackground(Color.orange);
        availabilityCombobox.setVisible(false);


        JButton searchButton=new JButton("Search");
        searchButton.setBounds(130,200,100,30);
        searchButton.setBackground(Color.cyan);
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String regNoVal=regNoTxt.getText();
                String busIDVal =regNoTxt.getText();

                boolean found=false;
                for (int i = 0; i < tableModel.getRowCount(); i++)
                {
                    if (tableModel.getValueAt(i, 0).equals(busIDVal)&&tableModel.getValueAt(i, 4).equals(regNoVal))
                    {
                        firstClassCheckbox.setVisible(true);
                        economyCheckbox.setVisible(true);
                        luxuryCheckbox.setVisible(true);
                        availabilityCheckbox.setVisible(true);

                        found = true;
                        break;
                    }
                }
                if (!found)
                {
                    JOptionPane.showMessageDialog(editDialog, "Record with Registration Number " + regNoVal + " & ID: " + busIDVal + " not found.",
                            "Record Not Found", JOptionPane.WARNING_MESSAGE);
                }
            }
        });


        JButton editButton=new JButton("Edit");
        editButton.setBounds(170,500,100,30);
        editButton.setBackground(Color.cyan);
        editButton.setVisible(false);

        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String regNoVal=regNoTxt.getText();
                String busIDVal =regNoTxt.getText();
                for (int i = 0; i < tableModel.getRowCount(); i++)
                {
                    if (tableModel.getValueAt(i, 0).equals(busIDVal)&&tableModel.getValueAt(i, 4).equals(regNoVal))
                    {

                        String status=(String) availabilityCombobox.getSelectedItem();

                        if(economyCheckbox.isSelected())
                        {

                            recTable.setValueAt(economySeatTxt.getText(), i, 6); // Update Economy Seat
                            int econSeat= Integer.parseInt (economySeatTxt.getText());
                            int luxurySeats= Integer.parseInt( recTable.getValueAt(i,7).toString());
                            int firstCSeat=Integer.parseInt( recTable.getValueAt(i,8).toString());
                            int totalSeats=0;
                            totalSeats=firstCSeat+econSeat+luxurySeats;
                            recTable.setValueAt(Integer.toString(totalSeats), i, 9);

                            String economySeats = generateSeatRange("E", 1, econSeat);
                            recTable.setValueAt(economySeats,i,10);
                        }

                        if(luxuryCheckbox.isSelected())
                        {
                            recTable.setValueAt(luxurySeatTxt.getText(), i, 7); // Update Luxury Seat

                            int econSeat= Integer.parseInt( recTable.getValueAt(i,6).toString());
                            int luxurySeats= Integer.parseInt(luxurySeatTxt.getText());
                            int firstCSeat=Integer.parseInt( recTable.getValueAt(i,8).toString());
                            int totalSeats=0;
                            totalSeats=firstCSeat+econSeat+luxurySeats;
                            recTable.setValueAt(Integer.toString(totalSeats), i, 9);

                            String luxurySeat = generateSeatRange("L", 1, luxurySeats);
                            recTable.setValueAt(luxurySeat,i,11);

                        }

                        if(firstClassCheckbox.isSelected())
                        {
                            recTable.setValueAt(firstClassSeatTxt.getText(), i, 8); // Update  First Class Seat

                            int econSeats= Integer.parseInt( recTable.getValueAt(i,6).toString());
                            int luxurySeats= Integer.parseInt( recTable.getValueAt(i,7).toString());
                            int firstCSeat=Integer.parseInt( firstClassSeatTxt.getText());
                            int totalSeats=0;
                            totalSeats=firstCSeat+econSeats+luxurySeats;
                            recTable.setValueAt(Integer.toString(totalSeats), i, 9);

                            String firstClassSeats = generateSeatRange("F", 1, firstCSeat);
                            recTable.setValueAt(firstClassSeats,i,12);

                        }

                        if(availabilityCheckbox.isSelected())
                        {
                            recTable.setValueAt(status, i, 13); // Update Status
                        }

                        editDialog.dispose();
                        break;
                    }
                }
            }
        });



        economyCheckbox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(economyCheckbox.isSelected())
                {
                    economySeatLabel.setVisible(true);
                    economySeatTxt.setVisible(true);

                }
                else {
                    economySeatLabel.setVisible(false);
                    economySeatTxt.setVisible(false);

                }

                if(economyCheckbox.isSelected()||luxuryCheckbox.isSelected()||firstClassCheckbox.isSelected()||availabilityCheckbox.isSelected())
                {
                    editButton.setVisible(true);
                }
                else{
                    editButton.setVisible(false);
                }
            }

        });

        luxuryCheckbox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(luxuryCheckbox.isSelected())
                {
                    luxurySeatLabel.setVisible(true);
                    luxurySeatTxt.setVisible(true);

                }
                else {
                    luxurySeatLabel.setVisible(false);
                    luxurySeatTxt.setVisible(false);

                }
                if(economyCheckbox.isSelected()||luxuryCheckbox.isSelected()||firstClassCheckbox.isSelected()||availabilityCheckbox.isSelected())
                {
                    editButton.setVisible(true);
                }
                else{
                    editButton.setVisible(false);
                }
            }
        });

        firstClassCheckbox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(firstClassCheckbox.isSelected())
                {
                    firstClassSeatLabel.setVisible(true);
                    firstClassSeatTxt.setVisible(true);
                }
                else {
                    firstClassSeatLabel.setVisible(false);
                    firstClassSeatTxt.setVisible(false);

                }
                if(economyCheckbox.isSelected()||luxuryCheckbox.isSelected()||firstClassCheckbox.isSelected()||availabilityCheckbox.isSelected())
                {
                    editButton.setVisible(true);
                }
                else{
                    editButton.setVisible(false);
                }
            }
        });
        availabilityCheckbox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(availabilityCheckbox.isSelected())
                {
                    availabilityLabel.setVisible(true);
                    availabilityCombobox.setVisible(true);

                }
                else {
                    availabilityLabel.setVisible(false);
                    availabilityCombobox.setVisible(false);

                }
                if(economyCheckbox.isSelected()||luxuryCheckbox.isSelected()||firstClassCheckbox.isSelected()||availabilityCheckbox.isSelected())
                {
                    editButton.setVisible(true);
                }
                else{
                    editButton.setVisible(false);
                }
            }
        });



        editDialog.add(editRecLabel);
        editDialog.add(regNoLabel);
        editDialog.add(regNoTxt);
        editDialog.add(busIDLabel);
        editDialog.add(busIDTxt);
        editDialog.add(searchButton);
        editDialog.add(firstClassCheckbox);
        editDialog.add(economyCheckbox);
        editDialog.add(luxuryCheckbox);
        editDialog.add(availabilityCheckbox);
        editDialog.add(economySeatLabel);
        editDialog.add(economySeatTxt);
        editDialog.add(luxurySeatLabel);
        editDialog.add(luxurySeatTxt);
        editDialog.add(firstClassSeatLabel);
        editDialog.add(firstClassSeatTxt);
        editDialog.add(availabilityLabel);
        editDialog.add(availabilityCombobox);
        editDialog.add(editButton);


        editDialog.setResizable(false);
        editDialog.setVisible(true);

    }

    private String generateSeatRange(String prefix, int start, int count) {
        if (count == 0) return "";

        StringBuilder seatRange = new StringBuilder();
        seatRange.append(prefix).append(start);
        if (count > 1) {
            seatRange.append("-").append(prefix).append(start + count - 1);
        }
        return seatRange.toString();
    }


    public static void main(String[] args)
    {
        ManageBusPage mbp=new ManageBusPage();
    }
}
