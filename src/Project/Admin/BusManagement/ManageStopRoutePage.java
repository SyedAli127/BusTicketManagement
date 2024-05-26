package Project.Admin.BusManagement;

import Project.Admin.AdminDashboard;
import Project.Admin.BookingManagement.*;
import Project.Admin.GenerateReportPage;
import Project.Admin.UserMangement.ManageDriverPage;
import Project.Admin.UserMangement.ManageManagerPage;
import Project.Admin.UserMangement.ManageUserPage;
import Project.Admin.ViewFeedbackPage;
import Project.Database;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ManageStopRoutePage extends JFrame {
    DefaultTableModel tableModel;
    JTable recTable;
    Connection connection= Database.setConnection();

    public ManageStopRoutePage() {
        JLabel label=new JLabel();
        label.setText("Manage Stop Routes");
        label.setBounds(400,20,320,50);
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

        JLabel stopRouteIDSearchLabel =new JLabel();
        stopRouteIDSearchLabel.setText(" StopRoute ID:");
        stopRouteIDSearchLabel.setBounds(250,80,180,50);
        stopRouteIDSearchLabel.setFont(new Font("Arial",Font.BOLD,18));
        stopRouteIDSearchLabel.setForeground(Color.orange);

        JTextField stopRouteIDSearchTxt =new JTextField();
        stopRouteIDSearchTxt.setBounds(390,90,150,30);


        JButton searchButton=new JButton("Search");
        searchButton.setBounds(580,90,100,30);
        searchButton.setBackground(Color.cyan);
        searchButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String srID=stopRouteIDSearchTxt.getText();
                boolean found=false;

                        String query="Select * from StopRouteTimeDummy where StopRouteID=?";
                        try {
                            PreparedStatement pst=connection.prepareStatement(query);
                            pst.setInt(1,Integer.parseInt(srID));
                            ResultSet rs=pst.executeQuery();
                            while (rs.next())
                            {
                                tableModel.setRowCount(0);

                                int stopRID=rs.getInt("StopRouteID");
                                String s1T=rs.getString("Stop1Time");
                                String s2T=rs.getString("Stop2Time");
                                String s3T=rs.getString("Stop3Time");
                                String s4T=rs.getString("Stop4Time");
                                String s5T=rs.getString("Stop5Time");
                                int s1km=rs.getInt("Stop1KM");
                                int s2km=rs.getInt("Stop2KM");
                                int s3km=rs.getInt("Stop3KM");
                                int s4km=rs.getInt("Stop4KM");
                                int s5km=rs.getInt("Stop5KM");

                                String [] row={Integer.toString(stopRID),s1T,s2T,s3T,s4T,s5T,Integer.toString(s1km),Integer.toString(s2km),
                                        Integer.toString(s3km),Integer.toString(s4km),Integer.toString(s5km)};
                                tableModel.addRow(row);
                                found = true;

                            }

                        }
                        catch (SQLException ex)
                        {
                            throw new RuntimeException(ex);
                        }

                if (!found) {
                    JOptionPane.showMessageDialog(null, "Record with StopRoute ID " +srID+ " not found.", "Record Not Found", JOptionPane.WARNING_MESSAGE);
                }

            }
        });

        JButton addButton =new JButton();
        addButton.setText("+ Add");
        addButton.setBounds(250,160,80,30);
        addButton.setBackground(Color.GREEN);
        addButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                addRecord();
            }
        });

        JButton removeButton =new JButton();
        removeButton.setText("- Remove");
        removeButton.setBounds(340,160,90,30);
        removeButton.setBackground(Color.RED);
        removeButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {

                removeRecord();
            }
        });



        JButton editButton =new JButton();
        editButton.setText("Edit");
        editButton.setBounds(440,160,90,30);
        editButton.setBackground(Color.PINK);
        editButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {

                editRecord();
            }
        });


        JPanel tabPanel=new JPanel();
        tabPanel.setBounds(250,210,580,350);
        tabPanel.setLayout(null);

        String[] column={"StopRoute ID","Stop1 Time","Stop2 Time","Stop3 Time","Stop4 Time","Stop5 Time","Stop1 KM","Stop2 KM","Stop3 KM","Stop4 KM","Stop5 KM"};
        tableModel = new DefaultTableModel(column,0);
        recTable=new JTable(tableModel);
        recTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        recTable.getColumnModel().getColumn(0).setPreferredWidth(100);
        recTable.getColumnModel().getColumn(1).setPreferredWidth(100);
        recTable.getColumnModel().getColumn(2).setPreferredWidth(100);
        recTable.getColumnModel().getColumn(3).setPreferredWidth(100);
        recTable.getColumnModel().getColumn(4).setPreferredWidth(100);
        recTable.getColumnModel().getColumn(5).setPreferredWidth(100);
        recTable.getColumnModel().getColumn(6).setPreferredWidth(100);
        recTable.getColumnModel().getColumn(7).setPreferredWidth(100);
        recTable.getColumnModel().getColumn(8).setPreferredWidth(100);
        recTable.getColumnModel().getColumn(9).setPreferredWidth(100);
        recTable.getColumnModel().getColumn(10).setPreferredWidth(100);

        String query="Select * from StopRouteTimeDummy";
        try
        {
            PreparedStatement psmt=connection.prepareStatement(query);
            ResultSet rs=psmt.executeQuery();
            while (rs.next())
            {
                int stoprID=rs.getInt("StopRouteID");
                String s1T=rs.getString("Stop1Time");
                String s2T=rs.getString("Stop2Time");
                String s3T=rs.getString("Stop3Time");
                String s4T=rs.getString("Stop4Time");
                String s5T=rs.getString("Stop5Time");
                int s1km=rs.getInt("Stop1KM");
                int s2km=rs.getInt("Stop2KM");
                int s3km=rs.getInt("Stop3KM");
                int s4km=rs.getInt("Stop4KM");
                int s5km=rs.getInt("Stop5KM");

                String [] row={Integer.toString(stoprID),s1T,s2T,s3T,s4T,s5T,Integer.toString(s1km),Integer.toString(s2km),
                        Integer.toString(s3km),Integer.toString(s4km),Integer.toString(s5km)};
                tableModel.addRow(row);

            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }


        JScrollPane scrollPane=new JScrollPane(recTable);
        scrollPane.setBounds(1,1,600,350);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        tabPanel.add(scrollPane);

        setTitle("Manage StopRoute Page");
        setLayout(null);
        setSize(900, 650);
        getContentPane().setBackground(Color.darkGray);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);


        add(label);
        add(menuPanel);
        add(stopRouteIDSearchLabel);
        add(stopRouteIDSearchTxt);
        add(searchButton);
        add(addButton);
        add(removeButton);
        add(editButton);
        add(tabPanel);

    }

    public void addRecord(){
        JDialog addDialog=new JDialog(this,"Add New Record",true);
        addDialog.setLayout(null);
        addDialog.setBackground(Color.darkGray);
        addDialog.setSize(500,500);
        addDialog.setLocationRelativeTo(null);
        addDialog.setResizable(false);


        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBounds(0, 0, 485, 480);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(null);
        inputPanel.setBackground(Color.darkGray);
        inputPanel.setPreferredSize(new Dimension(480, 470));

        JLabel addRecordLabel = new JLabel("Add New Record");
        addRecordLabel.setFont(new Font("Arial", Font.BOLD, 25));
        addRecordLabel.setForeground(Color.orange);
        addRecordLabel.setBounds(150,30,200,50);

        JLabel selectLabel=new JLabel();
        selectLabel.setText("Select how many stops:");
        selectLabel.setBounds(10,100,180,30);
        selectLabel.setFont(new Font("Arial",Font.BOLD,13));
        selectLabel.setForeground(Color.orange);

        JRadioButton r1=new JRadioButton("1");
        JRadioButton r2=new JRadioButton("2");
        JRadioButton r3=new JRadioButton("3");
        JRadioButton r4=new JRadioButton("4");
        JRadioButton r5=new JRadioButton("5");

        r1.setBounds(200,100,40,30);
        r2.setBounds(250,100,40,30);
        r3.setBounds(300,100,40,30);
        r4.setBounds(350,100,40,30);
        r5.setBounds(400,100,40,30);

        ButtonGroup group=new ButtonGroup();
        group.add(r1);
        group.add(r2);
        group.add(r3);
        group.add(r4);
        group.add(r5);

        JLabel stop1TimeLabel=new JLabel("Stop 1 Time:");
        stop1TimeLabel.setVisible(false);

        JTextField stop1TimeHrTxt=new JTextField();
        stop1TimeHrTxt.setVisible(false);
        JTextField stop1TimeMinTxt=new JTextField();
        stop1TimeMinTxt.setVisible(false);

        JLabel stop1KMLabel=new JLabel("Stop 1 KM:");
        stop1KMLabel.setVisible(false);
        JTextField stop1KMTxt=new JTextField();
        stop1KMTxt.setVisible(false);

        JLabel stop2TimeLabel=new JLabel("Stop 2 Time:");
        stop2TimeLabel.setVisible(false);

        JTextField stop2TimeHrTxt=new JTextField();
        stop2TimeHrTxt.setVisible(false);
        JTextField stop2TimeMinTxt=new JTextField();
        stop2TimeMinTxt.setVisible(false);

        JLabel stop2KMLabel=new JLabel("Stop 2 KM:");
        stop2KMLabel.setVisible(false);

        JTextField stop2KMTxt=new JTextField();
        stop2KMTxt.setVisible(false);

        JLabel stop3TimeLabel=new JLabel("Stop 3 Time:");
        stop3TimeLabel.setVisible(false);

        JTextField stop3TimeHrTxt=new JTextField();
        stop3TimeHrTxt.setVisible(false);
        JTextField stop3TimeMinTxt=new JTextField();
        stop3TimeMinTxt.setVisible(false);

        JLabel stop3KMLabel=new JLabel("Stop 3 KM:");
        stop3KMLabel.setVisible(false);
        JTextField stop3KMTxt=new JTextField();
        stop3KMTxt.setVisible(false);

        JLabel stop4TimeLabel=new JLabel("Stop 4 Time:");
        stop4TimeLabel.setVisible(false);

        JTextField stop4TimeHrTxt=new JTextField();
        stop4TimeHrTxt.setVisible(false);
        JTextField stop4TimeMinTxt=new JTextField();
        stop4TimeMinTxt.setVisible(false);

        JLabel stop4KMLabel=new JLabel("Stop 4 KM:");
        stop4KMLabel.setVisible(false);
        JTextField stop4KMTxt=new JTextField();
        stop4KMTxt.setVisible(false);

        JLabel stop5TimeLabel=new JLabel("Stop 5 Time:");
        stop5TimeLabel.setVisible(false);

        JTextField stop5TimeHrTxt=new JTextField();
        stop5TimeHrTxt.setVisible(false);
        JTextField stop5TimeMinTxt=new JTextField();
        stop5TimeMinTxt.setVisible(false);

        JLabel stop5KMLabel=new JLabel("Stop 5 KM:");
        stop5KMLabel.setVisible(false);
        JTextField stop5KMTxt=new JTextField();
        stop5KMTxt.setVisible(false);

        JButton addButton=new JButton("Add");
        addButton.setVisible(false);

        ActionListener radio=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(r1.isSelected()){
                    stop1TimeLabel.setVisible(true);
                    stop1TimeHrTxt.setVisible(true);
                    stop1TimeMinTxt.setVisible(true);

                    stop1KMLabel.setVisible(true);
                    stop1KMTxt.setVisible(true);

                    stop2TimeLabel.setVisible(false);
                    stop2TimeHrTxt.setVisible(false);
                    stop2TimeMinTxt.setVisible(false);

                    stop2KMLabel.setVisible(false);
                    stop2KMTxt.setVisible(false);

                    stop3TimeLabel.setVisible(false);
                    stop3TimeHrTxt.setVisible(false);
                    stop3TimeMinTxt.setVisible(false);

                    stop3KMLabel.setVisible(false);
                    stop3KMTxt.setVisible(false);

                    stop4TimeLabel.setVisible(false);
                    stop4TimeHrTxt.setVisible(false);
                    stop4TimeMinTxt.setVisible(false);


                    stop4KMLabel.setVisible(false);
                    stop4KMTxt.setVisible(false);

                    stop5TimeLabel.setVisible(false);
                    stop5TimeHrTxt.setVisible(false);
                    stop5TimeMinTxt.setVisible(false);

                    stop5KMLabel.setVisible(false);
                    stop5KMTxt.setVisible(false);

                    addButton.setVisible(true);
                    inputPanel.setPreferredSize(new Dimension(480, 470));
                    addButton.setBounds(150,250,100,30);


                }
                else if(r2.isSelected()){
                    stop1TimeLabel.setVisible(true);
                    stop1TimeHrTxt.setVisible(true);
                    stop1TimeMinTxt.setVisible(true);

                    stop1KMLabel.setVisible(true);
                    stop1KMTxt.setVisible(true);

                    stop2TimeLabel.setVisible(true);
                    stop2TimeHrTxt.setVisible(true);
                    stop2TimeMinTxt.setVisible(true);


                    stop2KMLabel.setVisible(true);
                    stop2KMTxt.setVisible(true);

                    stop3TimeLabel.setVisible(false);
                    stop3TimeHrTxt.setVisible(false);
                    stop3TimeMinTxt.setVisible(false);

                    stop3KMLabel.setVisible(false);
                    stop3KMTxt.setVisible(false);

                    stop4TimeLabel.setVisible(false);
                    stop4TimeHrTxt.setVisible(false);
                    stop4TimeMinTxt.setVisible(false);

                    stop4KMLabel.setVisible(false);
                    stop4KMTxt.setVisible(false);

                    stop5TimeLabel.setVisible(false);
                    stop5TimeHrTxt.setVisible(false);
                    stop5TimeMinTxt.setVisible(false);

                    stop5KMLabel.setVisible(false);
                    stop5KMTxt.setVisible(false);

                    addButton.setVisible(true);
                    inputPanel.setPreferredSize(new Dimension(480, 470));
                    addButton.setBounds(150,350,100,30);

                }
                else if(r3.isSelected()){
                    stop1TimeLabel.setVisible(true);
                    stop1TimeHrTxt.setVisible(true);
                    stop1TimeMinTxt.setVisible(true);

                    stop1KMLabel.setVisible(true);
                    stop1KMTxt.setVisible(true);

                    stop2TimeLabel.setVisible(true);
                    stop2TimeHrTxt.setVisible(true);
                    stop2TimeMinTxt.setVisible(true);


                    stop2KMLabel.setVisible(true);
                    stop2KMTxt.setVisible(true);

                    stop3TimeLabel.setVisible(true);
                    stop3TimeHrTxt.setVisible(true);
                    stop3TimeMinTxt.setVisible(true);

                    stop3KMLabel.setVisible(true);
                    stop3KMTxt.setVisible(true);

                    stop4TimeLabel.setVisible(false);
                    stop4TimeHrTxt.setVisible(false);
                    stop4TimeMinTxt.setVisible(false);

                    stop4KMLabel.setVisible(false);
                    stop4KMTxt.setVisible(false);

                    stop5TimeLabel.setVisible(false);
                    stop5TimeHrTxt.setVisible(false);
                    stop5TimeMinTxt.setVisible(false);

                    stop5KMLabel.setVisible(false);
                    stop5KMTxt.setVisible(false);

                    addButton.setVisible(true);
                    inputPanel.setPreferredSize(new Dimension(480, 520));
                    addButton.setBounds(150,450,100,30);
                }
                else if(r4.isSelected()){
                    stop1TimeLabel.setVisible(true);
                    stop1TimeHrTxt.setVisible(true);
                    stop1TimeMinTxt.setVisible(true);

                    stop1KMLabel.setVisible(true);
                    stop1KMTxt.setVisible(true);

                    stop2TimeLabel.setVisible(true);
                    stop2TimeHrTxt.setVisible(true);
                    stop2TimeMinTxt.setVisible(true);


                    stop2KMLabel.setVisible(true);
                    stop2KMTxt.setVisible(true);

                    stop3TimeLabel.setVisible(true);
                    stop3TimeHrTxt.setVisible(true);
                    stop3TimeMinTxt.setVisible(true);

                    stop3KMLabel.setVisible(true);
                    stop3KMTxt.setVisible(true);

                    stop4TimeLabel.setVisible(true);
                    stop4TimeHrTxt.setVisible(true);
                    stop4TimeMinTxt.setVisible(true);

                    stop4KMLabel.setVisible(true);
                    stop4KMTxt.setVisible(true);

                    stop5TimeLabel.setVisible(false);
                    stop5TimeHrTxt.setVisible(false);
                    stop5TimeMinTxt.setVisible(false);

                    stop5KMLabel.setVisible(false);
                    stop5KMTxt.setVisible(false);

                    addButton.setVisible(true);
                    inputPanel.setPreferredSize(new Dimension(480, 620));
                    addButton.setBounds(150,550,100,30);
                }
                else if(r5.isSelected()){
                    stop1TimeLabel.setVisible(true);
                    stop1TimeHrTxt.setVisible(true);
                    stop1TimeMinTxt.setVisible(true);

                    stop1KMLabel.setVisible(true);
                    stop1KMTxt.setVisible(true);

                    stop2TimeLabel.setVisible(true);
                    stop2TimeHrTxt.setVisible(true);
                    stop2TimeMinTxt.setVisible(true);


                    stop2KMLabel.setVisible(true);
                    stop2KMTxt.setVisible(true);

                    stop3TimeLabel.setVisible(true);
                    stop3TimeHrTxt.setVisible(true);
                    stop3TimeMinTxt.setVisible(true);

                    stop3KMLabel.setVisible(true);
                    stop3KMTxt.setVisible(true);

                    stop4TimeLabel.setVisible(true);
                    stop4TimeHrTxt.setVisible(true);
                    stop4TimeMinTxt.setVisible(true);

                    stop4KMLabel.setVisible(true);
                    stop4KMTxt.setVisible(true);

                    stop5TimeLabel.setVisible(true);
                    stop5TimeHrTxt.setVisible(true);
                    stop5TimeMinTxt.setVisible(true);

                    stop5KMLabel.setVisible(true);
                    stop5KMTxt.setVisible(true);

                    addButton.setVisible(true);
                    inputPanel.setPreferredSize(new Dimension(480, 720));
                    addButton.setBounds(150,650,100,30);
                }
            }
        };
        r1.addActionListener(radio);
        r2.addActionListener(radio);
        r3.addActionListener(radio);
        r4.addActionListener(radio);
        r5.addActionListener(radio);

        stop1TimeLabel.setBounds(10,150,180,30);
        stop1TimeLabel.setForeground(Color.orange);
        stop1TimeLabel.setFont(new Font("Arial",Font.BOLD,20));

        stop1TimeHrTxt.setBounds(200,150,40,30);
        stop1TimeMinTxt.setBounds(250,150,40,30);

        stop1KMLabel.setBounds(10,200,180,30);
        stop1KMLabel.setForeground(Color.orange);
        stop1KMLabel.setFont(new Font("Arial",Font.BOLD,20));

        stop1KMTxt.setBounds(200,200,150,30);

        stop2TimeLabel.setBounds(10,250,180,30);
        stop2TimeLabel.setForeground(Color.orange);
        stop2TimeLabel.setFont(new Font("Arial",Font.BOLD,20));

        stop2TimeHrTxt.setBounds(200,250,40,30);
        stop2TimeMinTxt.setBounds(250,250,40,30);

        stop2KMLabel.setBounds(10,300,180,30);
        stop2KMLabel.setForeground(Color.orange);
        stop2KMLabel.setFont(new Font("Arial",Font.BOLD,20));

        stop2KMTxt.setBounds(200,300,150,30);

        stop3TimeLabel.setBounds(10,350,180,30);
        stop3TimeLabel.setForeground(Color.orange);
        stop3TimeLabel.setFont(new Font("Arial",Font.BOLD,20));

        stop3TimeHrTxt.setBounds(200,350,40,30);
        stop3TimeMinTxt.setBounds(250,350,40,30);

        stop3KMLabel.setBounds(10,400,180,30);
        stop3KMLabel.setForeground(Color.orange);
        stop3KMLabel.setFont(new Font("Arial",Font.BOLD,20));

        stop3KMTxt.setBounds(200,400,150,30);

        stop4TimeLabel.setBounds(10,450,180,30);
        stop4TimeLabel.setForeground(Color.orange);
        stop4TimeLabel.setFont(new Font("Arial",Font.BOLD,20));

        stop4TimeHrTxt.setBounds(200,450,40,30);
        stop4TimeMinTxt.setBounds(250,450,40,30);

        stop4KMLabel.setBounds(10,500,180,30);
        stop4KMLabel.setForeground(Color.orange);
        stop4KMLabel.setFont(new Font("Arial",Font.BOLD,20));

        stop4KMTxt.setBounds(200,500,150,30);

        stop5TimeLabel.setBounds(10,550,180,30);
        stop5TimeLabel.setForeground(Color.orange);
        stop5TimeLabel.setFont(new Font("Arial",Font.BOLD,20));

        stop5TimeHrTxt.setBounds(200,550,40,30);
        stop5TimeMinTxt.setBounds(250,550,40,30);

        stop5KMLabel.setBounds(10,600,180,30);
        stop5KMLabel.setForeground(Color.orange);
        stop5KMLabel.setFont(new Font("Arial",Font.BOLD,20));

        stop5KMTxt.setBounds(200,600,150,30);


        addButton.setBackground(Color.cyan);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                int RsID,maxVal=0;
                String stop1Time=stop1TimeHrTxt.getText()+":"+ stop1TimeMinTxt.getText();
                String stop2Time=stop2TimeHrTxt.getText()+":"+ stop2TimeMinTxt.getText();
                String stop3Time=stop3TimeHrTxt.getText()+":"+ stop3TimeMinTxt.getText();
                String stop4Time=stop4TimeHrTxt.getText()+":"+ stop4TimeMinTxt.getText();
                String stop5Time=stop5TimeHrTxt.getText()+":"+ stop5TimeMinTxt.getText();

                String insertQuery="insert into StopRouteTimeDummy(Stop1Time,Stop2Time,Stop3Time,Stop4Time,Stop5Time,Stop1KM,Stop2KM,Stop3KM,Stop4KM,Stop5KM) " +
                        "values (?,?,?,?,?,?,?,?,?,?)";
                try {
                    PreparedStatement psmt=connection.prepareStatement(insertQuery);
                    if(r1.isSelected())
                    {


                        psmt.setString(1,stop1Time);
                        psmt.setString(2,null);
                        psmt.setString(3,null);
                        psmt.setString(4,null);
                        psmt.setString(5,null);
                        psmt.setInt(6,Integer.parseInt(stop1KMTxt.getText()));
                        psmt.setInt(7,0);
                        psmt.setInt(8,0);
                        psmt.setInt(9,0);
                        psmt.setInt(10,0);



                    }
                    else if (r2.isSelected())
                    {
                        psmt.setString(1,stop1Time);
                        psmt.setString(2,stop2Time);
                        psmt.setString(3,null);
                        psmt.setString(4,null);
                        psmt.setString(5,null);
                        psmt.setInt(6,Integer.parseInt(stop1KMTxt.getText()));
                        psmt.setInt(7,Integer.parseInt(stop2KMTxt.getText()));
                        psmt.setInt(8,0);
                        psmt.setInt(9,0);
                        psmt.setInt(10,0);



                    }
                    else if (r3.isSelected())
                    {
                        psmt.setString(1,stop1Time);
                        psmt.setString(2,stop2Time);
                        psmt.setString(3,stop3Time);
                        psmt.setString(4,null);
                        psmt.setString(5,null);
                        psmt.setInt(6,Integer.parseInt(stop1KMTxt.getText()));
                        psmt.setInt(7,Integer.parseInt(stop2KMTxt.getText()));
                        psmt.setInt(8,Integer.parseInt(stop3KMTxt.getText()));
                        psmt.setInt(9,0);
                        psmt.setInt(10,0);



                    }
                    else if (r4.isSelected())
                    {
                        psmt.setString(1,stop1Time);
                        psmt.setString(2,stop2Time);
                        psmt.setString(3,stop3Time);
                        psmt.setString(4,stop4Time);
                        psmt.setString(5,null);
                        psmt.setInt(6,Integer.parseInt(stop1KMTxt.getText()));
                        psmt.setInt(7,Integer.parseInt(stop2KMTxt.getText()));
                        psmt.setInt(8,Integer.parseInt(stop3KMTxt.getText()));
                        psmt.setInt(9,Integer.parseInt(stop4KMTxt.getText()));
                        psmt.setInt(10,0);

                    }
                    else if (r5.isSelected())
                    {
                        psmt.setString(1,stop1Time);
                        psmt.setString(2,stop2Time);
                        psmt.setString(3,stop3Time);
                        psmt.setString(4,stop4Time);
                        psmt.setString(5,stop5Time);
                        psmt.setInt(6,Integer.parseInt(stop1KMTxt.getText()));
                        psmt.setInt(7,Integer.parseInt(stop2KMTxt.getText()));
                        psmt.setInt(8,Integer.parseInt(stop3KMTxt.getText()));
                        psmt.setInt(9,Integer.parseInt(stop4KMTxt.getText()));
                        psmt.setInt(10,Integer.parseInt(stop5KMTxt.getText()));

                    }

                    psmt.executeUpdate();

                    String query="Select StopRouteID from StopRouteTimeDummy ";
                    PreparedStatement pst=connection.prepareStatement(query);
                    ResultSet rs=pst.executeQuery();
                    while(rs.next())
                    {
                        RsID=rs.getInt(1);
                        if(RsID>maxVal){
                            maxVal=RsID;
                        }

                    }

                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                String[] row={Integer.toString(maxVal),stop1Time,stop2Time,
                        stop3Time, stop4Time,stop5Time,
                        stop1KMTxt.getText(),stop2KMTxt.getText(),stop3KMTxt.getText(),stop4KMTxt.getText(),
                        stop5KMTxt.getText()
                };

                tableModel.addRow(row);
                addDialog.dispose();

            }
        });


        inputPanel.add(addRecordLabel);
        inputPanel.add(selectLabel);
        inputPanel.add(r1);
        inputPanel.add(r2);
        inputPanel.add(r3);
        inputPanel.add(r4);
        inputPanel.add(r5);
        inputPanel.add(stop1TimeLabel);
        inputPanel.add(stop1TimeHrTxt);
        inputPanel.add(stop1TimeMinTxt);
        inputPanel.add(stop1KMLabel);
        inputPanel.add(stop1KMTxt);
        inputPanel.add(stop2TimeLabel);
        inputPanel.add(stop2TimeHrTxt);
        inputPanel.add(stop2TimeMinTxt);
        inputPanel.add(stop2KMLabel);
        inputPanel.add(stop2KMTxt);
        inputPanel.add(stop3TimeLabel);
        inputPanel.add(stop3TimeHrTxt);
        inputPanel.add(stop3TimeMinTxt);
        inputPanel.add(stop3KMLabel);
        inputPanel.add(stop3KMTxt);
        inputPanel.add(stop4TimeLabel);
        inputPanel.add(stop4TimeHrTxt);
        inputPanel.add(stop4TimeMinTxt);
        inputPanel.add(stop4KMLabel);
        inputPanel.add(stop4KMTxt);
        inputPanel.add(stop5TimeLabel);
        inputPanel.add(stop5TimeHrTxt);
        inputPanel.add(stop5TimeMinTxt);
        inputPanel.add(stop5KMLabel);
        inputPanel.add(stop5KMTxt);
        inputPanel.add(addButton);



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
        addRecLabel.setFont(new Font("Arial",Font.BOLD,25));
        addRecLabel.setForeground(Color.orange);
        addRecLabel.setBounds(100, 30,240,30);


        JLabel stopRouteIDLabel =new JLabel();
        stopRouteIDLabel.setText("StopRoute ID:");
        stopRouteIDLabel.setBounds(40,100,180,30);
        stopRouteIDLabel.setFont(new Font("Arial",Font.BOLD,20));
        stopRouteIDLabel.setForeground(Color.orange);

        JTextField stopRouteIDTxt =new JTextField();
        stopRouteIDTxt.setBounds(200,100,150,30);


        JButton searchButton=new JButton("Search");
        searchButton.setBounds(130,170,100,30);
        searchButton.setBackground(Color.cyan);
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String IDVal = stopRouteIDTxt.getText();
                boolean found=false;
                for (int i = 0; i < tableModel.getRowCount(); i++)
                {
                    if (tableModel.getValueAt(i, 0).equals(IDVal))
                    {
                        String delQuery="DELETE FROM StopRouteTimeDummy WHERE StopRouteID=?";
                        try
                        {
                            PreparedStatement preparedStatement=connection.prepareStatement(delQuery);
                            preparedStatement.setInt(1,Integer.parseInt(IDVal));
                            preparedStatement.executeUpdate();

                        }
                        catch (SQLException ex)
                        {
                            throw new RuntimeException(ex);
                        }
                        tableModel.removeRow(i);
                        found = true;
                        break;
                    }
                }
                if (!found)
                {
                    JOptionPane.showMessageDialog(removeDialog, "Record with StopRoute ID " + IDVal +" not found.", "Record Not Found", JOptionPane.WARNING_MESSAGE);
                }
                else {
                    JOptionPane.showMessageDialog(removeDialog, "Record with StopRoute ID " + IDVal +  " removed successfully.", "Record Removed", JOptionPane.INFORMATION_MESSAGE);
                }
            }



        });

        removeDialog.add(addRecLabel);
        removeDialog.add(stopRouteIDLabel);
        removeDialog.add(stopRouteIDTxt);
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
        inputPanel.setPreferredSize(new Dimension(480, 870));

        JLabel editRecLabel =new JLabel();
        editRecLabel.setText("Edit Record");
        editRecLabel.setFont(new Font("Arial",Font.BOLD,22));
        editRecLabel.setForeground(Color.orange);
        editRecLabel.setBounds(150, 30,240,30);


        JLabel stopRouteIDLabel =new JLabel();
        stopRouteIDLabel.setText("Stop Route ID:");
        stopRouteIDLabel.setBounds(40,100,180,30);
        stopRouteIDLabel.setFont(new Font("Arial",Font.BOLD,19));
        stopRouteIDLabel.setForeground(Color.orange);

        JTextField stopRouteIDTxt =new JTextField();
        stopRouteIDTxt.setBounds(200,100,150,30);

        JCheckBox stop1TimeCheckbox =new JCheckBox("Stop1 Time");
        stop1TimeCheckbox.setBackground( Color.darkGray);
        stop1TimeCheckbox.setForeground(Color.orange);
        stop1TimeCheckbox.setBounds(40,200,90,30);
        stop1TimeCheckbox.setVisible(false);

        JCheckBox stop1KMCheckbox =new JCheckBox("Stop1 KM");
        stop1KMCheckbox.setBackground( Color.darkGray);
        stop1KMCheckbox.setForeground(Color.orange);
        stop1KMCheckbox.setBounds(140,200,90,30);
        stop1KMCheckbox.setVisible(false);

        JCheckBox stop2TimeCheckbox =new JCheckBox("Stop2 Time");
        stop2TimeCheckbox.setBackground( Color.darkGray);
        stop2TimeCheckbox.setForeground(Color.orange);
        stop2TimeCheckbox.setBounds(240,200,90,30);
        stop2TimeCheckbox.setVisible(false);

        JCheckBox stop2KMCheckbox =new JCheckBox("Stop2 KM");
        stop2KMCheckbox.setBackground( Color.darkGray);
        stop2KMCheckbox.setForeground(Color.orange);
        stop2KMCheckbox.setBounds(340,200,90,30);
        stop2KMCheckbox.setVisible(false);

        JCheckBox stop3TimeCheckbox =new JCheckBox("Stop3 Time");
        stop3TimeCheckbox.setBackground( Color.darkGray);
        stop3TimeCheckbox.setForeground(Color.orange);
        stop3TimeCheckbox.setBounds(40,235,90,30);
        stop3TimeCheckbox.setVisible(false);

        JCheckBox stop3KMCheckbox =new JCheckBox("Stop3 KM");
        stop3KMCheckbox.setBackground( Color.darkGray);
        stop3KMCheckbox.setForeground(Color.orange);
        stop3KMCheckbox.setBounds(140,235,90,30);
        stop3KMCheckbox.setVisible(false);

        JCheckBox stop4TimeCheckbox =new JCheckBox("Stop4 Time");
        stop4TimeCheckbox.setBackground( Color.darkGray);
        stop4TimeCheckbox.setForeground(Color.orange);
        stop4TimeCheckbox.setBounds(240,235,90,30);
        stop4TimeCheckbox.setVisible(false);

        JCheckBox stop4KMCheckbox =new JCheckBox("Stop4 KM");
        stop4KMCheckbox.setBackground( Color.darkGray);
        stop4KMCheckbox.setForeground(Color.orange);
        stop4KMCheckbox.setBounds(340,235,90,30);
        stop4KMCheckbox.setVisible(false);

        JCheckBox stop5TimeCheckbox =new JCheckBox("Stop5 Time");
        stop5TimeCheckbox.setBackground( Color.darkGray);
        stop5TimeCheckbox.setForeground(Color.orange);
        stop5TimeCheckbox.setBounds(40,270,90,30);
        stop5TimeCheckbox.setVisible(false);

        JCheckBox stop5KMCheckbox =new JCheckBox("Stop5 KM");
        stop5KMCheckbox.setBackground( Color.darkGray);
        stop5KMCheckbox.setForeground(Color.orange);
        stop5KMCheckbox.setBounds(140,270,90,30);
        stop5KMCheckbox.setVisible(false);



        JLabel stop1TimeLabel =new JLabel();
        stop1TimeLabel.setText("Stop1 Time:");
        stop1TimeLabel.setBounds(10,320,180,30);
        stop1TimeLabel.setFont(new Font("Arial",Font.BOLD,20));
        stop1TimeLabel.setForeground(Color.orange);
        stop1TimeLabel.setVisible(false);

        JTextField stop1TimeHrTxt =new JTextField();
        stop1TimeHrTxt.setBounds(200,320,40,30);
        stop1TimeHrTxt.setVisible(false);

        JTextField stop1TimeMinTxt =new JTextField();
        stop1TimeMinTxt.setBounds(250,320,40,30);
        stop1TimeMinTxt.setVisible(false);

        JLabel stop1KMLabel =new JLabel();
        stop1KMLabel.setText("Stop1 KM:");
        stop1KMLabel.setBounds(10,370,180,30);
        stop1KMLabel.setFont(new Font("Arial",Font.BOLD,20));
        stop1KMLabel.setForeground(Color.orange);
        stop1KMLabel.setVisible(false);

        JTextField stop1KMTxt =new JTextField();
        stop1KMTxt.setBounds(200,370,150,30);
        stop1KMTxt.setVisible(false);

        JLabel stop2TimeLabel =new JLabel();
        stop2TimeLabel.setText("Stop2 Time:");
        stop2TimeLabel.setBounds(10,420,180,30);
        stop2TimeLabel.setFont(new Font("Arial",Font.BOLD,20));
        stop2TimeLabel.setForeground(Color.orange);
        stop2TimeLabel.setVisible(false);

        JTextField stop2TimeHrTxt =new JTextField();
        stop2TimeHrTxt.setBounds(200,420,40,30);
        stop2TimeHrTxt.setVisible(false);

        JTextField stop2TimeMinTxt =new JTextField();
        stop2TimeMinTxt.setBounds(250,420,40,30);
        stop2TimeMinTxt.setVisible(false);

        JLabel stop2KMLabel =new JLabel();
        stop2KMLabel.setText("Stop2 KM:");
        stop2KMLabel.setBounds(10,470,180,30);
        stop2KMLabel.setFont(new Font("Arial",Font.BOLD,20));
        stop2KMLabel.setForeground(Color.orange);
        stop2KMLabel.setVisible(false);

        JTextField stop2KMTxt =new JTextField();
        stop2KMTxt.setBounds(200,470,150,30);
        stop2KMTxt.setVisible(false);

        JLabel stop3TimeLabel =new JLabel();
        stop3TimeLabel.setText("Stop3 Time:");
        stop3TimeLabel.setBounds(10,520,180,30);
        stop3TimeLabel.setFont(new Font("Arial",Font.BOLD,20));
        stop3TimeLabel.setForeground(Color.orange);
        stop3TimeLabel.setVisible(false);

        JTextField stop3TimeHrTxt =new JTextField();
        stop3TimeHrTxt.setBounds(200,520,40,30);
        stop3TimeHrTxt.setVisible(false);

        JTextField stop3TimeMinTxt =new JTextField();
        stop3TimeMinTxt.setBounds(250,520,40,30);
        stop3TimeMinTxt.setVisible(false);

        JLabel stop3KMLabel =new JLabel();
        stop3KMLabel.setText("Stop3 KM:");
        stop3KMLabel.setBounds(10,570,180,30);
        stop3KMLabel.setFont(new Font("Arial",Font.BOLD,20));
        stop3KMLabel.setForeground(Color.orange);
        stop3KMLabel.setVisible(false);

        JTextField stop3KMTxt =new JTextField();
        stop3KMTxt.setBounds(200,570,150,30);
        stop3KMTxt.setVisible(false);

        JLabel stop4TimeLabel =new JLabel();
        stop4TimeLabel.setText("Stop4 Time:");
        stop4TimeLabel.setBounds(10,620,180,30);
        stop4TimeLabel.setFont(new Font("Arial",Font.BOLD,20));
        stop4TimeLabel.setForeground(Color.orange);
        stop4TimeLabel.setVisible(false);

        JTextField stop4TimeHrTxt =new JTextField();
        stop4TimeHrTxt.setBounds(200,620,40,30);
        stop4TimeHrTxt.setVisible(false);

        JTextField stop4TimeMinTxt =new JTextField();
        stop4TimeMinTxt.setBounds(250,620,40,30);
        stop4TimeMinTxt.setVisible(false);

        JLabel stop4KMLabel =new JLabel();
        stop4KMLabel.setText("Stop4 KM:");
        stop4KMLabel.setBounds(10,670,180,30);
        stop4KMLabel.setFont(new Font("Arial",Font.BOLD,20));
        stop4KMLabel.setForeground(Color.orange);
        stop4KMLabel.setVisible(false);

        JTextField stop4KMTxt =new JTextField();
        stop4KMTxt.setBounds(200,670,150,30);
        stop4KMTxt.setVisible(false);


        JLabel stop5TimeLabel =new JLabel();
        stop5TimeLabel.setText("Stop5 Time:");
        stop5TimeLabel.setBounds(10,720,180,30);
        stop5TimeLabel.setFont(new Font("Arial",Font.BOLD,20));
        stop5TimeLabel.setForeground(Color.orange);
        stop5TimeLabel.setVisible(false);

        JTextField stop5TimeHrTxt =new JTextField();
        stop5TimeHrTxt.setBounds(200,720,40,30);
        stop5TimeHrTxt.setVisible(false);

        JTextField stop5TimeMinTxt =new JTextField();
        stop5TimeMinTxt.setBounds(250,720,40,30);
        stop5TimeMinTxt.setVisible(false);

        JLabel stop5KMLabel =new JLabel();
        stop5KMLabel.setText("Stop5 KM:");
        stop5KMLabel.setBounds(10,770,180,30);
        stop5KMLabel.setFont(new Font("Arial",Font.BOLD,20));
        stop5KMLabel.setForeground(Color.orange);
        stop5KMLabel.setVisible(false);

        JTextField stop5KMTxt =new JTextField();
        stop5KMTxt.setBounds(200,770,150,30);
        stop5KMTxt.setVisible(false);


        JButton editButton=new JButton("Edit");
        editButton.setBounds(130,820,100,30);
        editButton.setBackground(Color.cyan);
        //editButton.setVisible(false);




        JButton searchButton=new JButton("Search");
        searchButton.setBounds(130,150,100,30);
        searchButton.setBackground(Color.cyan);
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String val= stopRouteIDTxt.getText();
                boolean found=false;
                for (int i = 0; i < tableModel.getRowCount(); i++)
                {
                    if (tableModel.getValueAt(i, 0).equals(val))
                    {

                        stop1TimeCheckbox.setVisible(true);
                        stop1KMCheckbox.setVisible(true);
                        stop2TimeCheckbox.setVisible(true);
                        stop2KMCheckbox.setVisible(true);
                        stop3TimeCheckbox.setVisible(true);
                        stop3KMCheckbox.setVisible(true);
                        stop4TimeCheckbox.setVisible(true);
                        stop4KMCheckbox.setVisible(true);
                        stop5TimeCheckbox.setVisible(true);
                        stop5KMCheckbox.setVisible(true);



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

                String val= stopRouteIDTxt.getText();
                for (int i = 0; i < tableModel.getRowCount(); i++)
                {
                    if (tableModel.getValueAt(i, 0).equals(val))
                    {

                        String stop1Time=stop1TimeHrTxt.getText()+":"+stop1TimeMinTxt.getText();
                        String stop2Time=stop2TimeHrTxt.getText()+":"+stop2TimeMinTxt.getText();
                        String stop3Time=stop3TimeHrTxt.getText()+":"+stop3TimeMinTxt.getText();
                        String stop4Time=stop4TimeHrTxt.getText()+":"+stop4TimeMinTxt.getText();
                        String stop5Time=stop5TimeHrTxt.getText()+":"+stop5TimeMinTxt.getText();


                        if(stop1TimeCheckbox.isSelected())
                        {
                            recTable.setValueAt(stop1Time,i,1);

                            String updateQuery="update StopRouteTimeDummy set Stop1Time=? where StopRouteID=?";
                            try {
                                PreparedStatement pst=connection.prepareStatement(updateQuery);
                                pst.setString(1,stop1Time);
                                pst.setInt(2,Integer.parseInt(val));
                                pst.executeUpdate();

                            } catch (SQLException ex) {
                                throw new RuntimeException(ex);
                            }
                        }

                        if(stop1KMCheckbox.isSelected())
                        {
                            recTable.setValueAt(stop1KMTxt.getText(),i,6);
                            String updateQuery="update StopRouteTimeDummy set Stop1KM=? where StopRouteID=?";
                            try {
                                PreparedStatement pst=connection.prepareStatement(updateQuery);
                                pst.setInt(1,Integer.parseInt(stop1KMTxt.getText()));
                                pst.setInt(2,Integer.parseInt(val));
                                pst.executeUpdate();

                            } catch (SQLException ex) {
                                throw new RuntimeException(ex);
                            }

                        }

                        if(stop2TimeCheckbox.isSelected())
                        {
                            recTable.setValueAt(stop2Time,i,2);

                            String updateQuery="update StopRouteTimeDummy set Stop2Time=? where StopRouteID=?";
                            try {
                                PreparedStatement pst=connection.prepareStatement(updateQuery);
                                pst.setString(1,stop2Time);
                                pst.setInt(2,Integer.parseInt(val));
                                pst.executeUpdate();

                            } catch (SQLException ex) {
                                throw new RuntimeException(ex);
                            }
                        }

                        if(stop2KMCheckbox.isSelected())
                        {
                            recTable.setValueAt(stop2KMTxt.getText(),i,7);
                            String updateQuery="update StopRouteTimeDummy set Stop2KM=? where StopRouteID=?";
                            try {
                                PreparedStatement pst=connection.prepareStatement(updateQuery);
                                pst.setInt(1,Integer.parseInt(stop2KMTxt.getText()));
                                pst.setInt(2,Integer.parseInt(val));
                                pst.executeUpdate();

                            } catch (SQLException ex) {
                                throw new RuntimeException(ex);
                            }

                        }
                        if(stop3TimeCheckbox.isSelected())
                        {
                            recTable.setValueAt(stop3Time,i,3);

                            String updateQuery="update StopRouteTimeDummy set Stop3Time=? where StopRouteID=?";
                            try {
                                PreparedStatement pst=connection.prepareStatement(updateQuery);
                                pst.setString(1,stop3Time);
                                pst.setInt(2,Integer.parseInt(val));
                                pst.executeUpdate();

                            } catch (SQLException ex) {
                                throw new RuntimeException(ex);
                            }
                        }

                        if(stop3KMCheckbox.isSelected())
                        {
                            recTable.setValueAt(stop3KMTxt.getText(),i,8);
                            String updateQuery="update StopRouteTimeDummy set Stop3KM=? where StopRouteID=?";
                            try {
                                PreparedStatement pst=connection.prepareStatement(updateQuery);
                                pst.setInt(1,Integer.parseInt(stop3KMTxt.getText()));
                                pst.setInt(2,Integer.parseInt(val));
                                pst.executeUpdate();

                            } catch (SQLException ex) {
                                throw new RuntimeException(ex);
                            }

                        }
                        if(stop4TimeCheckbox.isSelected())
                        {
                            recTable.setValueAt(stop4Time,i,4);

                            String updateQuery="update StopRouteTimeDummy set Stop4Time=? where StopRouteID=?";
                            try {
                                PreparedStatement pst=connection.prepareStatement(updateQuery);
                                pst.setString(1,stop4Time);
                                pst.setInt(2,Integer.parseInt(val));
                                pst.executeUpdate();

                            } catch (SQLException ex) {
                                throw new RuntimeException(ex);
                            }
                        }

                        if(stop4KMCheckbox.isSelected())
                        {
                            recTable.setValueAt(stop4KMTxt.getText(),i,9);
                            String updateQuery="update StopRouteTimeDummy set Stop4KM=? where StopRouteID=?";
                            try {
                                PreparedStatement pst=connection.prepareStatement(updateQuery);
                                pst.setInt(1,Integer.parseInt(stop4KMTxt.getText()));
                                pst.setInt(2,Integer.parseInt(val));
                                pst.executeUpdate();

                            } catch (SQLException ex) {
                                throw new RuntimeException(ex);
                            }

                        }
                        if(stop5TimeCheckbox.isSelected())
                        {
                            recTable.setValueAt(stop5Time,i,5);

                            String updateQuery="update StopRouteTimeDummy set Stop5Time=? where StopRouteID=?";
                            try {
                                PreparedStatement pst=connection.prepareStatement(updateQuery);
                                pst.setString(1,stop5Time);
                                pst.setInt(2,Integer.parseInt(val));
                                pst.executeUpdate();

                            } catch (SQLException ex) {
                                throw new RuntimeException(ex);
                            }
                        }

                        if(stop5KMCheckbox.isSelected())
                        {
                            recTable.setValueAt(stop5KMTxt.getText(),i,10);
                            String updateQuery="update StopRouteTimeDummy set Stop5KM=? where StopRouteID=?";
                            try {
                                PreparedStatement pst=connection.prepareStatement(updateQuery);
                                pst.setInt(1,Integer.parseInt(stop5KMTxt.getText()));
                                pst.setInt(2,Integer.parseInt(val));
                                pst.executeUpdate();

                            } catch (SQLException ex) {
                                throw new RuntimeException(ex);
                            }

                        }

                        editDialog.dispose();
                        break;
                    }
                }
            }
        });

        stop1TimeCheckbox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(stop1TimeCheckbox.isSelected())
                {
                    stop1TimeLabel.setVisible(true);
                    stop1TimeHrTxt.setVisible(true);
                    stop1TimeMinTxt.setVisible(true);
                }
                else {
                    stop1TimeLabel.setVisible(false);
                    stop1TimeHrTxt.setVisible(false);
                    stop1TimeMinTxt.setVisible(false);
                }
            }
        });
        stop1KMCheckbox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (stop1KMCheckbox.isSelected())
                {
                    stop1KMLabel.setVisible(true);
                    stop1KMTxt.setVisible(true);
                }
                else {
                    stop1KMLabel.setVisible(false);
                    stop1KMTxt.setVisible(false);
                }

            }
        });

        stop2TimeCheckbox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(stop2TimeCheckbox.isSelected())
                {
                    stop2TimeLabel.setVisible(true);
                    stop2TimeHrTxt.setVisible(true);
                    stop2TimeMinTxt.setVisible(true);
                }
                else{
                    stop2TimeLabel.setVisible(false);
                    stop2TimeHrTxt.setVisible(false);
                    stop2TimeMinTxt.setVisible(false);
                }
            }
        });
        stop2KMCheckbox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (stop2KMCheckbox.isSelected())
                {
                    stop2KMLabel.setVisible(true);
                    stop2KMTxt.setVisible(true);
                }
                else {
                    stop2KMLabel.setVisible(false);
                    stop2KMTxt.setVisible(false);
                }

            }
        });

        stop3TimeCheckbox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(stop3TimeCheckbox.isSelected())
                {
                    stop3TimeLabel.setVisible(true);
                    stop3TimeHrTxt.setVisible(true);
                    stop3TimeMinTxt.setVisible(true);
                }
                else{
                    stop3TimeLabel.setVisible(false);
                    stop3TimeHrTxt.setVisible(false);
                    stop3TimeMinTxt.setVisible(false);
                }
            }
        });
        stop3KMCheckbox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (stop3KMCheckbox.isSelected())
                {
                    stop3KMLabel.setVisible(true);
                    stop3KMTxt.setVisible(true);
                }
                else {
                    stop3KMLabel.setVisible(false);
                    stop3KMTxt.setVisible(false);
                }

            }
        });

        stop4TimeCheckbox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(stop4TimeCheckbox.isSelected())
                {
                    stop4TimeLabel.setVisible(true);
                    stop4TimeHrTxt.setVisible(true);
                    stop4TimeMinTxt.setVisible(true);
                }
                else{
                    stop4TimeLabel.setVisible(false);
                    stop4TimeHrTxt.setVisible(false);
                    stop4TimeMinTxt.setVisible(false);
                }
            }
        });
        stop4KMCheckbox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (stop4KMCheckbox.isSelected())
                {
                    stop4KMLabel.setVisible(true);
                    stop4KMTxt.setVisible(true);
                }
                else {
                    stop4KMLabel.setVisible(false);
                    stop4KMTxt.setVisible(false);
                }

            }
        });

        stop5TimeCheckbox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(stop5TimeCheckbox.isSelected())
                {
                    stop5TimeLabel.setVisible(true);
                    stop5TimeHrTxt.setVisible(true);
                    stop5TimeMinTxt.setVisible(true);
                }
                else{
                    stop5TimeLabel.setVisible(false);
                    stop5TimeHrTxt.setVisible(false);
                    stop5TimeMinTxt.setVisible(false);
                }
            }
        });
        stop5KMCheckbox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (stop5KMCheckbox.isSelected())
                {
                    stop5KMLabel.setVisible(true);
                    stop5KMTxt.setVisible(true);
                }
                else {
                    stop5KMLabel.setVisible(false);
                    stop5KMTxt.setVisible(false);
                }

            }
        });


        inputPanel.add(editRecLabel);
        inputPanel.add(stopRouteIDLabel);
        inputPanel.add(stopRouteIDTxt);
        inputPanel.add(searchButton);

        inputPanel.add(stop1TimeCheckbox);
        inputPanel.add(stop1KMCheckbox);
        inputPanel.add(stop2TimeCheckbox);
        inputPanel.add(stop2KMCheckbox);
        inputPanel.add(stop3TimeCheckbox);
        inputPanel.add(stop3KMCheckbox);
        inputPanel.add(stop4TimeCheckbox);
        inputPanel.add(stop4KMCheckbox);
        inputPanel.add(stop5TimeCheckbox);
        inputPanel.add(stop5KMCheckbox);
        inputPanel.add(stop1TimeLabel);
        inputPanel.add(stop1TimeHrTxt);
        inputPanel.add(stop1TimeMinTxt);
        inputPanel.add(stop1KMLabel);
        inputPanel.add(stop1KMTxt);
        inputPanel.add(stop2TimeLabel);
        inputPanel.add(stop2TimeHrTxt);
        inputPanel.add(stop2TimeMinTxt);
        inputPanel.add(stop2KMLabel);
        inputPanel.add(stop2KMTxt);
        inputPanel.add(stop3TimeLabel);
        inputPanel.add(stop3TimeHrTxt);
        inputPanel.add(stop3TimeMinTxt);
        inputPanel.add(stop3KMLabel);
        inputPanel.add(stop3KMTxt);
        inputPanel.add(stop4TimeLabel);
        inputPanel.add(stop4TimeHrTxt);
        inputPanel.add(stop4TimeMinTxt);
        inputPanel.add(stop4KMLabel);
        inputPanel.add(stop4KMTxt);
        inputPanel.add(stop5TimeLabel);
        inputPanel.add(stop5TimeHrTxt);
        inputPanel.add(stop5TimeMinTxt);
        inputPanel.add(stop5KMLabel);
        inputPanel.add(stop5KMTxt);



        inputPanel.add(editButton);


        scrollPane.setViewportView(inputPanel);
        editDialog.getContentPane().add(scrollPane);

        editDialog.setResizable(false);
        editDialog.setVisible(true);
    }

    public static void main(String[] args) {
        ManageStopRoutePage msp = new ManageStopRoutePage();
    }
}
