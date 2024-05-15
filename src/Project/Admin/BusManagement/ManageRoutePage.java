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

public class ManageRoutePage extends JFrame {

    DefaultTableModel tableModel;
    JTable recTable;

    public ManageRoutePage() {
        JLabel label=new JLabel();
        label.setText("Manage Routes");
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


        JLabel routeIDLabel =new JLabel();
        routeIDLabel.setText("Route ID:");
        routeIDLabel.setBounds(240,80,150,50);
        routeIDLabel.setFont(new Font("Arial",Font.BOLD,18));
        routeIDLabel.setForeground(Color.orange);

        JTextField routeIDTxt =new JTextField();
        routeIDTxt.setBounds(400,90,150,30);

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
        addButton.setBounds(240,140,80,30);
        addButton.setBackground(Color.GREEN);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                addRecord();
            }
        });

        JButton removeButton =new JButton();
        removeButton.setText("- Remove");
        removeButton.setBounds(330,140,90,30);
        removeButton.setBackground(Color.RED);
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                removeRecord();
            }
        });

        JButton editButton =new JButton();
        editButton.setText("Edit");
        editButton.setBounds(430,140,90,30);
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

        String[][] data={{"1","Karachi","Lahore","Hyderabad","Multan","Kashmir","Hunza","Hari Por","500","5 Hours"}};
        String[]column={"Route ID","Departure","Arrival","Stop 1","Stop 2","Stop 3","Stop 4","Stop 5","Travel KM","Time Taken"};

        tableModel=new DefaultTableModel(data,column);
        recTable=new JTable(tableModel);
        recTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF); // This ensures horizontal scrolling

        JScrollPane scrollPane=new JScrollPane(recTable);
        scrollPane.setBounds(1,1,600,350);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        tabPanel.add(scrollPane);


        setTitle("Manage Routes");
        setLayout(null);
        setSize(900, 650);
        getContentPane().setBackground(Color.darkGray);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);


        add(label);
        add(menuPanel);
        add(routeIDLabel);
        add(routeIDTxt);
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
        addDialog.setSize(500, 500);
        addDialog.setLocationRelativeTo(null);
        addDialog.setResizable(false);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBounds(0, 0, 485, 480);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(null);
        inputPanel.setBackground(Color.darkGray);
        inputPanel.setPreferredSize(new Dimension(480, 450)); // Adjust height as needed


        JLabel addRecLabel=new JLabel();
        addRecLabel.setText("Add New Record");
        addRecLabel.setFont(new Font("Arial",Font.BOLD,25));
        addRecLabel.setForeground(Color.orange);
        addRecLabel.setBounds(150, 30,240,30);

        JLabel routeIDLabel =new JLabel();
        routeIDLabel.setText("Route ID:");
        routeIDLabel.setBounds(10,100,150,30);
        routeIDLabel.setFont(new Font("Arial",Font.BOLD,20));
        routeIDLabel.setForeground(Color.orange);

        JTextField routeIDTxt =new JTextField();
        routeIDTxt.setBounds(200,100,150,30);


        JLabel departureLabel =new JLabel();
        departureLabel.setText("Departure:");
        departureLabel.setBounds(10,150,180,30);
        departureLabel.setFont(new Font("Arial",Font.BOLD,20));
        departureLabel.setForeground(Color.orange);

        JTextField departureTxt =new JTextField();
        departureTxt.setBounds(200,150,150,30);

        JLabel arrivalLabel =new JLabel();
        arrivalLabel.setText("Arrival:");
        arrivalLabel.setBounds(10,200,180,30);
        arrivalLabel.setFont(new Font("Arial",Font.BOLD,20));
        arrivalLabel.setForeground(Color.orange);

        JTextField arrivalTxt =new JTextField();
        arrivalTxt.setBounds(200,200,150,30);

        JLabel travelKMLabel =new JLabel();
        travelKMLabel.setText("Travel KM:");
        travelKMLabel.setBounds(10,250,180,30);
        travelKMLabel.setFont(new Font("Arial",Font.BOLD,20));
        travelKMLabel.setForeground(Color.orange);

        JTextField travelKMTxt =new JTextField();
        travelKMTxt.setBounds(200,250,150,30);

        JLabel timeTakenLabel =new JLabel();
        timeTakenLabel.setText("Time Taken:");
        timeTakenLabel.setBounds(10,300,180,30);
        timeTakenLabel.setFont(new Font("Arial",Font.BOLD,20));
        timeTakenLabel.setForeground(Color.orange);

        JTextField timeTakenTxt =new JTextField();
        timeTakenTxt.setBounds(200,300,150,30);

        JLabel selectLabel=new JLabel();
        selectLabel.setText("Select how many stops:");
        selectLabel.setBounds(10,350,180,30);
        selectLabel.setFont(new Font("Arial",Font.BOLD,13));
        selectLabel.setForeground(Color.orange);

        JRadioButton r1=new JRadioButton("1");
        JRadioButton r2=new JRadioButton("2");
        JRadioButton r3=new JRadioButton("3");
        JRadioButton r4=new JRadioButton("4");
        JRadioButton r5=new JRadioButton("5");

        r1.setBounds(200,350,40,30);
        r2.setBounds(250,350,40,30);
        r3.setBounds(300,350,40,30);
        r4.setBounds(350,350,40,30);
        r5.setBounds(400,350,40,30);

        ButtonGroup group=new ButtonGroup();
        group.add(r1);
        group.add(r2);
        group.add(r3);
        group.add(r4);
        group.add(r5);

        JLabel stop1Label =new JLabel();
        stop1Label.setText("Stop 1 Location:");
        stop1Label.setVisible(false);

        JTextField stop1Txt =new JTextField();
        stop1Txt.setVisible(false);

        JLabel stop2Label =new JLabel();
        stop2Label.setText("Stop 2 Location:");
        stop2Label.setVisible(false);

        JTextField stop2Txt =new JTextField();
        stop2Txt.setVisible(false);

        JLabel stop3Label =new JLabel();
        stop3Label.setText("Stop 3 Location:");
        stop3Label.setVisible(false);

        JTextField stop3Txt =new JTextField();
        stop3Txt.setVisible(false);

        JLabel stop4Label =new JLabel();
        stop4Label.setText("Stop 4 Location:");
        stop4Label.setVisible(false);

        JTextField stop4Txt =new JTextField();
        stop4Txt.setVisible(false);

        JLabel stop5Label =new JLabel();
        stop5Label.setText("Stop 5 Location:");
        stop5Label.setVisible(false);

        JTextField stop5Txt =new JTextField();
        stop5Txt.setVisible(false);

        JButton addButton = new JButton("Add");
        addButton.setBounds(150, 400, 100, 40);


        ActionListener radio=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(r1.isSelected())
                {
                    stop1Label.setVisible(true);
                    stop1Txt.setVisible(true);
                    stop2Label.setVisible(false);
                    stop2Txt.setVisible(false);
                    stop3Label.setVisible(false);
                    stop3Txt.setVisible(false);
                    stop4Label.setVisible(false);
                    stop4Txt.setVisible(false);
                    stop5Label.setVisible(false);
                    stop5Txt.setVisible(false);
                    inputPanel.setPreferredSize(new Dimension(480, 500)); // Adjust height as needed
                    addButton.setBounds(150, 450, 100, 40);

                }
                else if(r2.isSelected())
                {
                    stop1Label.setVisible(true);
                    stop1Txt.setVisible(true);
                    stop2Label.setVisible(true);
                    stop2Txt.setVisible(true);
                    stop3Label.setVisible(false);
                    stop3Txt.setVisible(false);
                    stop4Label.setVisible(false);
                    stop4Txt.setVisible(false);
                    stop5Label.setVisible(false);
                    stop5Txt.setVisible(false);
                    inputPanel.setPreferredSize(new Dimension(480, 550)); // Adjust height as needed
                    addButton.setBounds(150, 500, 100, 40);


                }
                else if(r3.isSelected())
                {
                    stop1Label.setVisible(true);
                    stop1Txt.setVisible(true);
                    stop2Label.setVisible(true);
                    stop2Txt.setVisible(true);
                    stop3Label.setVisible(true);
                    stop3Txt.setVisible(true);
                    stop4Label.setVisible(false);
                    stop4Txt.setVisible(false);
                    stop5Label.setVisible(false);
                    stop5Txt.setVisible(false);
                    inputPanel.setPreferredSize(new Dimension(480, 600)); // Adjust height as needed
                    addButton.setBounds(150, 550, 100, 40);


                }
                else if(r4.isSelected())
                {
                    stop1Label.setVisible(true);
                    stop1Txt.setVisible(true);
                    stop2Label.setVisible(true);
                    stop2Txt.setVisible(true);
                    stop3Label.setVisible(true);
                    stop3Txt.setVisible(true);
                    stop4Label.setVisible(true);
                    stop4Txt.setVisible(true);
                    stop5Label.setVisible(false);
                    stop5Txt.setVisible(false);
                    inputPanel.setPreferredSize(new Dimension(480, 650)); // Adjust height as needed
                    addButton.setBounds(150, 600, 100, 40);


                }
                else if(r5.isSelected())
                {
                    stop1Label.setVisible(true);
                    stop1Txt.setVisible(true);
                    stop2Label.setVisible(true);
                    stop2Txt.setVisible(true);
                    stop3Label.setVisible(true);
                    stop3Txt.setVisible(true);
                    stop4Label.setVisible(true);
                    stop4Txt.setVisible(true);
                    stop5Label.setVisible(true);
                    stop5Txt.setVisible(true);
                    inputPanel.setPreferredSize(new Dimension(480, 700)); // Adjust height as needed
                    addButton.setBounds(150, 650, 100, 40);


                }

                else
                {
                    stop1Label.setVisible(false);
                    stop1Txt.setVisible(false);
                    stop2Label.setVisible(false);
                    stop2Txt.setVisible(false);
                    stop3Label.setVisible(false);
                    stop3Txt.setVisible(false);
                    stop4Label.setVisible(false);
                    stop4Txt.setVisible(false);
                    stop5Label.setVisible(false);
                    stop5Txt.setVisible(false);
                    addButton.setBounds(150, 400, 100, 40);

                }
            }


        };

        r1.addActionListener(radio);
        r2.addActionListener(radio);
        r3.addActionListener(radio);
        r4.addActionListener(radio);
        r5.addActionListener(radio);

        stop1Label.setBounds(10,400,180,30);
        stop1Label.setFont(new Font("Arial",Font.BOLD,20));
        stop1Label.setForeground(Color.orange);

        stop1Txt.setBounds(200,400,150,30);

        stop2Label.setBounds(10,450,180,30);
        stop2Label.setFont(new Font("Arial",Font.BOLD,20));
        stop2Label.setForeground(Color.orange);

        stop2Txt.setBounds(200,450,150,30);

        stop3Label.setBounds(10,500,180,30);
        stop3Label.setFont(new Font("Arial",Font.BOLD,20));
        stop3Label.setForeground(Color.orange);

        stop3Txt.setBounds(200,500,150,30);

        stop4Label.setBounds(10,550,180,30);
        stop4Label.setFont(new Font("Arial",Font.BOLD,20));
        stop4Label.setForeground(Color.orange);

        stop4Txt.setBounds(200,550,150,30);

        stop5Label.setBounds(10,600,180,30);
        stop5Label.setFont(new Font("Arial",Font.BOLD,20));
        stop5Label.setForeground(Color.orange);

        stop5Txt.setBounds(200,600,150,30);

        addButton.setBackground(Color.cyan);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String[] row={routeIDTxt.getText(), departureTxt.getText(), arrivalTxt.getText(),stop1Txt.getText(),
                        stop2Txt.getText(),stop3Txt.getText(),stop4Txt.getText(),stop5Txt.getText(),travelKMTxt.getText(),
                        timeTakenTxt.getText()+" Hours"};
                tableModel.addRow(row);
                addDialog.dispose();
            }
        });



        inputPanel.add(addRecLabel);
        inputPanel.add(routeIDLabel);
        inputPanel.add(routeIDTxt);
        inputPanel.add(departureLabel);
        inputPanel.add(departureTxt);
        inputPanel.add(arrivalLabel);
        inputPanel.add(arrivalTxt);
        inputPanel.add(selectLabel);
        inputPanel.add(addButton);
        inputPanel.add(timeTakenLabel);
        inputPanel.add(timeTakenTxt);
        inputPanel.add(travelKMLabel);
        inputPanel.add(travelKMTxt);
        inputPanel.add(r1);
        inputPanel.add(r2);
        inputPanel.add(r3);
        inputPanel.add(r4);
        inputPanel.add(r5);
        inputPanel.add(stop1Label);
        inputPanel.add(stop1Txt);
        inputPanel.add(stop2Label);
        inputPanel.add(stop2Txt);
        inputPanel.add(stop3Label);
        inputPanel.add(stop3Txt);
        inputPanel.add(stop4Label);
        inputPanel.add(stop4Txt);
        inputPanel.add(stop5Label);
        inputPanel.add(stop5Txt);

        scrollPane.setViewportView(inputPanel);
        addDialog.getContentPane().add(scrollPane);

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


        JLabel routeIDLabel =new JLabel();
        routeIDLabel.setText("Route ID:");
        routeIDLabel.setBounds(10,100,180,30);
        routeIDLabel.setFont(new Font("Arial",Font.BOLD,17));
        routeIDLabel.setForeground(Color.orange);

        JTextField routeIDTxt =new JTextField();
        routeIDTxt.setBounds(200,100,150,30);


        JButton searchButton=new JButton("Search");
        searchButton.setBounds(130,170,100,30);
        searchButton.setBackground(Color.cyan);
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String IDVal = routeIDTxt.getText();
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
                    JOptionPane.showMessageDialog(removeDialog, "Record with Route ID " + IDVal +" not found.", "Record Not Found", JOptionPane.WARNING_MESSAGE);
                }
                else {
                    JOptionPane.showMessageDialog(removeDialog, "Record with Route ID " + IDVal +  " removed successfully.", "Record Removed", JOptionPane.INFORMATION_MESSAGE);
                }
            }



        });

        removeDialog.add(addRecLabel);
        removeDialog.add(routeIDLabel);
        removeDialog.add(routeIDTxt);
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
        inputPanel.setPreferredSize(new Dimension(480, 580));

        JLabel editRecLabel =new JLabel();
        editRecLabel.setText("Edit Record");
        editRecLabel.setFont(new Font("Arial",Font.BOLD,22));
        editRecLabel.setForeground(Color.orange);
        editRecLabel.setBounds(100, 30,240,30);


        JLabel routeIDLabel =new JLabel();
        routeIDLabel.setText("Route ID:");
        routeIDLabel.setBounds(10,100,180,30);
        routeIDLabel.setFont(new Font("Arial",Font.BOLD,20));
        routeIDLabel.setForeground(Color.orange);

        JTextField routeIDTxt =new JTextField();
        routeIDTxt.setBounds(200,100,150,30);

        JCheckBox departureCheckbox =new JCheckBox("Departure");
        departureCheckbox.setBackground( Color.darkGray);
        departureCheckbox.setForeground(Color.orange);
        departureCheckbox.setBounds(40,200,90,30);
        departureCheckbox.setVisible(false);


        JCheckBox arrivalCheckbox =new JCheckBox("Arrival");
        arrivalCheckbox.setBackground( Color.darkGray);
        arrivalCheckbox.setForeground(Color.orange);
        arrivalCheckbox.setBounds(140,200,70,30);
        arrivalCheckbox.setVisible(false);

        JCheckBox selectStopCheckbox =new JCheckBox("Stop Selection");
        selectStopCheckbox.setBackground( Color.darkGray);
        selectStopCheckbox.setForeground(Color.orange);
        selectStopCheckbox.setBounds(40,235,110,30);
        selectStopCheckbox.setVisible(false);


        JCheckBox travelKMCheckbox =new JCheckBox("Travel KM");
        travelKMCheckbox.setBackground( Color.darkGray);
        travelKMCheckbox.setForeground(Color.orange);
        travelKMCheckbox.setBounds(220,200,100,30);
        travelKMCheckbox.setVisible(false);

        JCheckBox timeTakenCheckbox =new JCheckBox("Time Taken");
        timeTakenCheckbox.setBackground( Color.darkGray);
        timeTakenCheckbox.setForeground(Color.orange);
        timeTakenCheckbox.setBounds(320,200,120,30);
        timeTakenCheckbox.setVisible(false);


        JLabel departureLabel =new JLabel();
        departureLabel.setText("Departure:");
        departureLabel.setBounds(10,280,180,30);
        departureLabel.setFont(new Font("Arial",Font.BOLD,20));
        departureLabel.setForeground(Color.orange);
        departureLabel.setVisible(false);

        JTextField departureTxt =new JTextField();
        departureTxt.setBounds(200,280,150,30);
        departureTxt.setVisible(false);

        JLabel arrivalLabel =new JLabel();
        arrivalLabel.setText("Arrival:");
        arrivalLabel.setBounds(10,330,180,30);
        arrivalLabel.setFont(new Font("Arial",Font.BOLD,20));
        arrivalLabel.setForeground(Color.orange);
        arrivalLabel.setVisible(false);

        JTextField arrivalTxt =new JTextField();
        arrivalTxt.setBounds(200,330,150,30);
        arrivalTxt.setVisible(false);


        JLabel travelKMLabel =new JLabel();
        travelKMLabel.setText("Travel KM:");
        travelKMLabel.setBounds(10,380,180,30);
        travelKMLabel.setFont(new Font("Arial",Font.BOLD,20));
        travelKMLabel.setForeground(Color.orange);
        travelKMLabel.setVisible(false);

        JTextField travelKMTxt =new JTextField();
        travelKMTxt.setBounds(200,380,150,30);
        travelKMTxt.setVisible(false);

        JLabel timeTakenLabel =new JLabel();
        timeTakenLabel.setText("Time Taken:");
        timeTakenLabel.setBounds(10,430,180,30);
        timeTakenLabel.setFont(new Font("Arial",Font.BOLD,20));
        timeTakenLabel.setForeground(Color.orange);
        timeTakenLabel.setVisible(false);

        JTextField timeTakenTxt =new JTextField();
        timeTakenTxt.setBounds(200,430,150,30);
        timeTakenTxt.setVisible(false);

        JLabel selectStopLabel =new JLabel();
        selectStopLabel.setText("Select Stops:");
        selectStopLabel.setBounds(10,480,180,30);
        selectStopLabel.setFont(new Font("Arial",Font.BOLD,20));
        selectStopLabel.setForeground(Color.orange);
        selectStopLabel.setVisible(false);

        JRadioButton r1=new JRadioButton("1");
        JRadioButton r2=new JRadioButton("2");
        JRadioButton r3=new JRadioButton("3");
        JRadioButton r4=new JRadioButton("4");
        JRadioButton r5=new JRadioButton("5");

        r1.setBounds(200,480,40,30);
        r2.setBounds(250,480,40,30);
        r3.setBounds(300,480,40,30);
        r4.setBounds(350,480,40,30);
        r5.setBounds(400,480,40,30);

        r1.setVisible(false);
        r2.setVisible(false);
        r3.setVisible(false);
        r4.setVisible(false);
        r5.setVisible(false);

        ButtonGroup group=new ButtonGroup();
        group.add(r1);
        group.add(r2);
        group.add(r3);
        group.add(r4);
        group.add(r5);


        JLabel stop1Label =new JLabel();
        stop1Label.setText("Stop 1 Location:");
        stop1Label.setVisible(false);

        JTextField stop1Txt =new JTextField();
        stop1Txt.setVisible(false);

        JLabel stop2Label =new JLabel();
        stop2Label.setText("Stop 2 Location:");
        stop2Label.setVisible(false);

        JTextField stop2Txt =new JTextField();
        stop2Txt.setVisible(false);

        JLabel stop3Label =new JLabel();
        stop3Label.setText("Stop 3 Location:");
        stop3Label.setVisible(false);

        JTextField stop3Txt =new JTextField();
        stop3Txt.setVisible(false);

        JLabel stop4Label =new JLabel();
        stop4Label.setText("Stop 4 Location:");
        stop4Label.setVisible(false);

        JTextField stop4Txt =new JTextField();
        stop4Txt.setVisible(false);

        JLabel stop5Label =new JLabel();
        stop5Label.setText("Stop 5 Location:");
        stop5Label.setVisible(false);

        JTextField stop5Txt =new JTextField();
        stop5Txt.setVisible(false);

        JButton editButton=new JButton("Edit");
        editButton.setBounds(130,530,100,30);
        editButton.setBackground(Color.cyan);
        editButton.setVisible(false);


        ActionListener radio=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(r1.isSelected())
                {
                    editButton.setBounds(130,580,100,30);
                    stop1Label.setVisible(true);
                    stop1Txt.setVisible(true);
                    stop2Label.setVisible(false);
                    stop2Txt.setVisible(false);
                    stop3Label.setVisible(false);
                    stop3Txt.setVisible(false);
                    stop4Label.setVisible(false);
                    stop4Txt.setVisible(false);
                    stop5Label.setVisible(false);
                    stop5Txt.setVisible(false);
                    inputPanel.setPreferredSize(new Dimension(480, 630)); // Adjust height as needed


                }
                else if(r2.isSelected())
                {
                    editButton.setBounds(130,630,100,30);
                    stop1Label.setVisible(true);
                    stop1Txt.setVisible(true);
                    stop2Label.setVisible(true);
                    stop2Txt.setVisible(true);
                    stop3Label.setVisible(false);
                    stop3Txt.setVisible(false);
                    stop4Label.setVisible(false);
                    stop4Txt.setVisible(false);
                    stop5Label.setVisible(false);
                    stop5Txt.setVisible(false);
                    inputPanel.setPreferredSize(new Dimension(480, 680)); // Adjust height as needed


                }
                else if(r3.isSelected())
                {
                    editButton.setBounds(130,680,100,30);
                    stop1Label.setVisible(true);
                    stop1Txt.setVisible(true);
                    stop2Label.setVisible(true);
                    stop2Txt.setVisible(true);
                    stop3Label.setVisible(true);
                    stop3Txt.setVisible(true);
                    stop4Label.setVisible(false);
                    stop4Txt.setVisible(false);
                    stop5Label.setVisible(false);
                    stop5Txt.setVisible(false);
                    inputPanel.setPreferredSize(new Dimension(480, 730)); // Adjust height as needed


                }
                else if(r4.isSelected())
                {
                    editButton.setBounds(130,730,100,30);
                    stop1Label.setVisible(true);
                    stop1Txt.setVisible(true);
                    stop2Label.setVisible(true);
                    stop2Txt.setVisible(true);
                    stop3Label.setVisible(true);
                    stop3Txt.setVisible(true);
                    stop4Label.setVisible(true);
                    stop4Txt.setVisible(true);
                    stop5Label.setVisible(false);
                    stop5Txt.setVisible(false);
                    inputPanel.setPreferredSize(new Dimension(480, 780)); // Adjust height as needed


                }
                else if(r5.isSelected())
                {
                    editButton.setBounds(130,780,100,30);
                    stop1Label.setVisible(true);
                    stop1Txt.setVisible(true);
                    stop2Label.setVisible(true);
                    stop2Txt.setVisible(true);
                    stop3Label.setVisible(true);
                    stop3Txt.setVisible(true);
                    stop4Label.setVisible(true);
                    stop4Txt.setVisible(true);
                    stop5Label.setVisible(true);
                    stop5Txt.setVisible(true);
                    inputPanel.setPreferredSize(new Dimension(480, 830)); // Adjust height as needed


                }

                else
                {
                    stop1Label.setVisible(false);
                    stop1Txt.setVisible(false);
                    stop2Label.setVisible(false);
                    stop2Txt.setVisible(false);
                    stop3Label.setVisible(false);
                    stop3Txt.setVisible(false);
                    stop4Label.setVisible(false);
                    stop4Txt.setVisible(false);
                    stop5Label.setVisible(false);
                    stop5Txt.setVisible(false);
                    //addButton.setBounds(150, 400, 100, 40);

                }
            }


        };

        r1.addActionListener(radio);
        r2.addActionListener(radio);
        r3.addActionListener(radio);
        r4.addActionListener(radio);
        r5.addActionListener(radio);

        stop1Label.setBounds(10,530,180,30);
        stop1Label.setFont(new Font("Arial",Font.BOLD,20));
        stop1Label.setForeground(Color.orange);

        stop1Txt.setBounds(200,530,150,30);

        stop2Label.setBounds(10,580,180,30);
        stop2Label.setFont(new Font("Arial",Font.BOLD,20));
        stop2Label.setForeground(Color.orange);

        stop2Txt.setBounds(200,580,150,30);

        stop3Label.setBounds(10,630,180,30);
        stop3Label.setFont(new Font("Arial",Font.BOLD,20));
        stop3Label.setForeground(Color.orange);

        stop3Txt.setBounds(200,630,150,30);

        stop4Label.setBounds(10,680,180,30);
        stop4Label.setFont(new Font("Arial",Font.BOLD,20));
        stop4Label.setForeground(Color.orange);

        stop4Txt.setBounds(200,680,150,30);

        stop5Label.setBounds(10,730,180,30);
        stop5Label.setFont(new Font("Arial",Font.BOLD,20));
        stop5Label.setForeground(Color.orange);

        stop5Txt.setBounds(200,730,150,30);


        JButton searchButton=new JButton("Search");
        searchButton.setBounds(130,150,100,30);
        searchButton.setBackground(Color.cyan);
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String val= routeIDTxt.getText();
                boolean found=false;
                for (int i = 0; i < tableModel.getRowCount(); i++)
                {
                    if (tableModel.getValueAt(i, 0).equals(val))
                    {
                        departureCheckbox.setVisible(true);
                        arrivalCheckbox.setVisible(true);
                        selectStopCheckbox.setVisible(true);
                        travelKMCheckbox.setVisible(true);
                        timeTakenCheckbox.setVisible(true);
                        found = true;
                        break;
                    }
                }
                if (!found)
                {
                    JOptionPane.showMessageDialog(editDialog, "Record with Route ID " + val + " not found.", "Record Not Found", JOptionPane.WARNING_MESSAGE);
                }
            }
        });


        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String val= routeIDTxt.getText();
                for (int i = 0; i < tableModel.getRowCount(); i++)
                {
                    if (tableModel.getValueAt(i, 0).equals(val))
                    {
                        String departure=departureTxt.getText();
                        String arrival=arrivalTxt.getText();
                        String travelKM=travelKMTxt.getText()+" KM";
                        String timeTaken=timeTakenTxt.getText()+" hours";
                        String stop1=stop1Txt.getText();
                        String stop2=stop2Txt.getText();
                        String stop3=stop3Txt.getText();
                        String stop4=stop4Txt.getText();
                        String stop5=stop5Txt.getText();

                        if(departureCheckbox.isSelected())
                        {
                            recTable.setValueAt(departure,i,1);

                        }
                        if (arrivalCheckbox.isSelected())
                        {
                            recTable.setValueAt(arrival,i,2);

                        }
                        if(selectStopCheckbox.isSelected())
                        {
                            if(r1.isSelected())
                            {
                                recTable.setValueAt(stop1,i,3);
                            }
                            if(r2.isSelected())
                            {
                                recTable.setValueAt(stop1,i,3);
                                recTable.setValueAt(stop2,i,4);
                            }
                            if(r3.isSelected())
                            {
                                recTable.setValueAt(stop1,i,3);
                                recTable.setValueAt(stop2,i,4);
                                recTable.setValueAt(stop3,i,5);
                            }
                            if(r4.isSelected())
                            {
                                recTable.setValueAt(stop1,i,3);
                                recTable.setValueAt(stop2,i,4);
                                recTable.setValueAt(stop3,i,5);
                                recTable.setValueAt(stop4,i,6);
                            }
                            if(r5.isSelected())
                            {
                                recTable.setValueAt(stop1,i,3);
                                recTable.setValueAt(stop2,i,4);
                                recTable.setValueAt(stop3,i,5);
                                recTable.setValueAt(stop4,i,6);
                                recTable.setValueAt(stop5,i,7);
                            }
                        }
                        if(travelKMCheckbox.isSelected())
                        {
                            recTable.setValueAt(travelKM,i,8);

                        }
                        if(timeTakenCheckbox.isSelected())
                        {
                            recTable.setValueAt(timeTaken,i,9);
                        }

                        editDialog.dispose();
                        break;
                    }
                }
            }
        });

        selectStopCheckbox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(selectStopCheckbox.isSelected())
                {
                    selectStopLabel.setVisible(true);
                    r1.setVisible(true);
                    r2.setVisible(true);
                    r3.setVisible(true);
                    r4.setVisible(true);
                    r5.setVisible(true);
                    editButton.setVisible(true);
                }
                else {
                    selectStopLabel.setVisible(false);
                    r1.setVisible(false);
                    r2.setVisible(false);
                    r3.setVisible(false);
                    r4.setVisible(false);
                    r5.setVisible(false);
                    stop1Label.setVisible(false);
                    stop1Txt.setVisible(false);
                    stop2Label.setVisible(false);
                    stop2Txt.setVisible(false);
                    stop3Label.setVisible(false);
                    stop3Txt.setVisible(false);
                    stop4Label.setVisible(false);
                    stop4Txt.setVisible(false);
                    stop5Label.setVisible(false);
                    stop5Txt.setVisible(false);

                    editButton.setVisible(false);
                    editButton.setBounds(130,530,100,30);

                }
            }
        });


        departureCheckbox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(departureCheckbox.isSelected())
                {

                    departureLabel.setVisible(true);
                    departureTxt.setVisible(true);
                    //editButton.setBounds(130,,100,30);
                    editButton.setVisible(true);

                }
                else {
                    departureLabel.setVisible(false);
                    departureTxt.setVisible(false);
                    editButton.setVisible(false);

                }
            }
        });

        arrivalCheckbox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(arrivalCheckbox.isSelected())
                {

                    arrivalLabel.setVisible(true);
                    arrivalTxt.setVisible(true);
                    //editButton.setBounds(130,y[0],100,30);
                    editButton.setVisible(true);

                }
                else {
                    arrivalLabel.setVisible(false);
                    arrivalTxt.setVisible(false);
                    editButton.setVisible(false);

                }
            }
        });

        timeTakenCheckbox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(timeTakenCheckbox.isSelected())
                {
                    timeTakenLabel.setVisible(true);
                    timeTakenTxt.setVisible(true);

                }
                else
                {
                    timeTakenLabel.setVisible(false);
                    timeTakenTxt.setVisible(false);

                }
            }
        });

        travelKMCheckbox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(travelKMCheckbox.isSelected())
                {
                    travelKMLabel.setVisible(true);
                    travelKMTxt.setVisible(true);
                }
                else
                {
                    travelKMLabel.setVisible(false);
                    travelKMTxt.setVisible(false);
                }
            }
        });


        inputPanel.add(editRecLabel);
        inputPanel.add(routeIDLabel);
        inputPanel.add(routeIDTxt);
        inputPanel.add(searchButton);
        inputPanel.add(selectStopCheckbox);
        inputPanel.add(departureCheckbox);
        inputPanel.add(arrivalCheckbox);
        inputPanel.add(travelKMCheckbox);
        inputPanel.add(timeTakenCheckbox);
        inputPanel.add(departureLabel);
        inputPanel.add(departureTxt);
        inputPanel.add(arrivalLabel);
        inputPanel.add(arrivalTxt);
        inputPanel.add(travelKMLabel);
        inputPanel.add(travelKMTxt);
        inputPanel.add(timeTakenLabel);
        inputPanel.add(timeTakenTxt);
        inputPanel.add(selectStopLabel);
        inputPanel.add(r1);
        inputPanel.add(r2);
        inputPanel.add(r3);
        inputPanel.add(r4);
        inputPanel.add(r5);
        inputPanel.add(stop1Label);
        inputPanel.add(stop1Txt);
        inputPanel.add(stop2Label);
        inputPanel.add(stop2Txt);
        inputPanel.add(stop3Label);
        inputPanel.add(stop3Txt);
        inputPanel.add(stop4Label);
        inputPanel.add(stop4Txt);
        inputPanel.add(stop5Label);
        inputPanel.add(stop5Txt);

        inputPanel.add(editButton);


        scrollPane.setViewportView(inputPanel);
        editDialog.getContentPane().add(scrollPane);

        editDialog.setResizable(false);
        editDialog.setVisible(true);
    }

    public static void main(String[] args)
    {
        ManageRoutePage mrp=new ManageRoutePage();
    }
}
