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

public class ManageBusMaintenancePage extends JFrame {

    DefaultTableModel tableModel;
    JTable recTable;
    Connection conn = Database.setConnection();

    public ManageBusMaintenancePage() {
        JLabel label=new JLabel();
        label.setText("Manage Bus Maintenance");
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

        JLabel busMaintenanceIDSearchLabel =new JLabel();
        busMaintenanceIDSearchLabel.setText(" BusMaintenance ID:");
        busMaintenanceIDSearchLabel.setBounds(200,80,180,50);
        busMaintenanceIDSearchLabel.setFont(new Font("Arial",Font.BOLD,18));
        busMaintenanceIDSearchLabel.setForeground(Color.orange);

        JTextField busMaintenanceIDSearchTxt =new JTextField();
        busMaintenanceIDSearchTxt.setBounds(390,90,150,30);


        JButton searchButton=new JButton("Search");
        searchButton.setBounds(580,90,100,30);
        searchButton.setBackground(Color.cyan);
        searchButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String busMID=busMaintenanceIDSearchTxt.getText();
                String query="Select * from BusMaintenance where BusMaintenanceID=?";
                boolean found=false;

                try
                {
                    PreparedStatement pst=conn.prepareStatement(query);
                    pst.setInt(1, Integer.parseInt(busMID));
                    ResultSet rs=pst.executeQuery();
                    while (rs.next())
                    {
                        tableModel.setRowCount(0);
                        int busMaintenanceID=rs.getInt(1);
                        int busID=rs.getInt(2);
                        int managerID=rs.getInt(3);
                        String maintenanceDate=rs.getString(4);
                        String maintenanceType=rs.getString(5);
                        int cost=rs.getInt(6);
                        String description=rs.getString(7);
                        String nextScheduleDate=rs.getString(8);

                        String[] row={Integer.toString(busMaintenanceID),Integer.toString(busID),Integer.toString(managerID),
                                maintenanceDate,maintenanceType,Integer.toString(cost),description,nextScheduleDate};

                        tableModel.addRow(row);
                        found=true;

                    }
                }
                catch (SQLException ex)
                {
                    throw new RuntimeException(ex);
                }
                if (!found)
                {
                    JOptionPane.showMessageDialog(null, "Record with Bus Maintenance ID " +busMID+ " not found.", "Record Not Found", JOptionPane.WARNING_MESSAGE);
                }

            }
        });

        JButton addButton =new JButton();
        addButton.setText("+ Add");
        addButton.setBounds(250,160,90,30);
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
        removeButton.setBounds(350,160,90,30);
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
        editButton.setBounds(450,160,90,30);
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

        String[] column={"BusMaintenance ID","Bus ID","Manager ID","Maintenance Date","Maintenance Type","Cost","Description","Next Schedule Date" };
        tableModel=new DefaultTableModel(column,0);
        recTable=new JTable(tableModel);
        recTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        recTable.getColumnModel().getColumn(0).setPreferredWidth(120);
        recTable.getColumnModel().getColumn(1).setPreferredWidth(100);
        recTable.getColumnModel().getColumn(2).setPreferredWidth(100);
        recTable.getColumnModel().getColumn(3).setPreferredWidth(120);
        recTable.getColumnModel().getColumn(4).setPreferredWidth(120);
        recTable.getColumnModel().getColumn(5).setPreferredWidth(100);
        recTable.getColumnModel().getColumn(6).setPreferredWidth(100);
        recTable.getColumnModel().getColumn(7).setPreferredWidth(130);

        String query="Select * from BusMaintenance";
        try {
            PreparedStatement psmt=conn.prepareStatement(query);
            ResultSet rs=psmt.executeQuery();
            while(rs.next()){
                int busMaintenanceID=rs.getInt(1);
                int busID=rs.getInt(2);
                int managerID=rs.getInt(3);
                String maintenanceDate=rs.getString(4);
                String maintenanceType=rs.getString(5);
                int cost=rs.getInt(6);
                String description=rs.getString(7);
                String nextScheduleDate=rs.getString(8);

                String[] row={Integer.toString(busMaintenanceID),Integer.toString(busID),Integer.toString(managerID),
                        maintenanceDate,maintenanceType,Integer.toString(cost),description,nextScheduleDate};

                tableModel.addRow(row);
            }
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }


        JScrollPane scrollPane = new JScrollPane(recTable);
        scrollPane.setBounds(1,1,580,350);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        tabPanel.add(scrollPane);

        setTitle("Manage BusMaintenance Page");
        setLayout(null);
        setSize(900, 650);
        getContentPane().setBackground(Color.darkGray);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);


        add(label);
        add(menuPanel);
        add(busMaintenanceIDSearchLabel);
        add(busMaintenanceIDSearchTxt);
        add(searchButton);
        add(addButton);
        add(removeButton);
        add(editButton);
        add(tabPanel);

    }

    public void addRecord()
    {
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
        inputPanel.setPreferredSize(new Dimension(480, 550));

        JLabel addRecordLabel = new JLabel("Add New Record");
        addRecordLabel.setFont(new Font("Arial", Font.BOLD, 25));
        addRecordLabel.setForeground(Color.orange);
        addRecordLabel.setBounds(150,30,200,50);

        JLabel busIDLabel =new JLabel();
        busIDLabel.setText("Bus ID:");
        busIDLabel.setBounds(10,100,180,30);
        busIDLabel.setFont(new Font("Arial",Font.BOLD,20));
        busIDLabel.setForeground(Color.orange);

        JTextField busIDTxt=new JTextField();
        busIDTxt.setBounds(200,100,180,30);

        JLabel managerIDLabel=new JLabel("Manager ID:");
        managerIDLabel.setFont(new Font("Arial",Font.BOLD,20));
        managerIDLabel.setForeground(Color.orange);
        managerIDLabel.setBounds(10,150,180,30);

        JTextField managerIDTxt=new JTextField();
        managerIDTxt.setBounds(200,150,180,30);

        JLabel maintenanceDateLabel=new JLabel("Maintenance Date:");
        maintenanceDateLabel.setFont(new Font("Arial",Font.BOLD,20));
        maintenanceDateLabel.setForeground(Color.orange);
        maintenanceDateLabel.setBounds(10,200,180,30);

        JLabel maintenanceDateDayLabel =new JLabel("(Day)");
        maintenanceDateDayLabel.setBounds(200,230,50,30);
        maintenanceDateDayLabel.setForeground(Color.orange);
        maintenanceDateDayLabel.setFont(new Font("Arial",Font.BOLD,11));

        JTextField maintenanceDateDayTxt=new JTextField();
        maintenanceDateDayTxt.setBounds(200,200,40,30);

        JLabel maintenanceDateMonLabel =new JLabel("(Month)");
        maintenanceDateMonLabel.setBounds(250,230,50,30);
        maintenanceDateMonLabel.setForeground(Color.orange);
        maintenanceDateMonLabel.setFont(new Font("Arial",Font.BOLD,11));

        JTextField maintenanceDateMonTxt=new JTextField();
        maintenanceDateMonTxt.setBounds(250,200,40,30);


        JLabel maintenanceDateYearLabel =new JLabel("(Year)");
        maintenanceDateYearLabel.setBounds(300,230,50,30);
        maintenanceDateYearLabel.setForeground(Color.orange);
        maintenanceDateYearLabel.setFont(new Font("Arial",Font.BOLD,11));


        JTextField maintenanceDateYearTxt=new JTextField();
        maintenanceDateYearTxt.setBounds(300,200,40,30);

        JLabel maintenanceTypeLabel=new JLabel("Maintenance Type:");
        maintenanceTypeLabel.setFont(new Font("Arial",Font.BOLD,20));
        maintenanceTypeLabel.setForeground(Color.orange);
        maintenanceTypeLabel.setBounds(10,280,180,30);

        JTextField maintenanceTypeTxt=new JTextField();
        maintenanceTypeTxt.setBounds(200,280,180,30);

        JLabel costLabel=new JLabel("Cost:");
        costLabel.setFont(new Font("Arial",Font.BOLD,20));
        costLabel.setForeground(Color.orange);
        costLabel.setBounds(10,330,180,30);

        JTextField costTxt=new JTextField();
        costTxt.setBounds(200,330,180,30);


        JLabel descriptionLabel=new JLabel("Description:");
        descriptionLabel.setFont(new Font("Arial",Font.BOLD,20));
        descriptionLabel.setForeground(Color.orange);
        descriptionLabel.setBounds(10,380,180,30);

        JTextField descriptionTxt=new JTextField();
        descriptionTxt.setBounds(200,380,180,30);


        JLabel nextSchDateLabel=new JLabel("Next Schedule Date:");
        nextSchDateLabel.setFont(new Font("Arial",Font.BOLD,18));
        nextSchDateLabel.setForeground(Color.orange);
        nextSchDateLabel.setBounds(10,430,180,30);

        JLabel nextSchDateDayLabel =new JLabel("(Day)");
        nextSchDateDayLabel.setBounds(200,460,50,30);
        nextSchDateDayLabel.setForeground(Color.orange);
        nextSchDateDayLabel.setFont(new Font("Arial",Font.BOLD,11));

        JTextField nextSchDateDayTxt=new JTextField();
        nextSchDateDayTxt.setBounds(200,430,40,30);

        JLabel nextSchDateMonLabel =new JLabel("(Month)");
        nextSchDateMonLabel.setBounds(250,460,50,30);
        nextSchDateMonLabel.setForeground(Color.orange);
        nextSchDateMonLabel.setFont(new Font("Arial",Font.BOLD,11));

        JTextField nextSchDateMonTxt=new JTextField();
        nextSchDateMonTxt.setBounds(250,430,40,30);


        JLabel nextSchDateYearLabel =new JLabel("(Year)");
        nextSchDateYearLabel.setBounds(300,460,50,30);
        nextSchDateYearLabel.setForeground(Color.orange);
        nextSchDateYearLabel.setFont(new Font("Arial",Font.BOLD,11));


        JTextField nextSchDateYearTxt=new JTextField();
        nextSchDateYearTxt.setBounds(300,430,40,30);


        JButton addButton=new JButton("Add");
        addButton.setBackground(Color.cyan);
        addButton.setBounds(150,510,100,30);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                int iD,maxVal=0;
                String maintenanceDate=maintenanceDateYearTxt.getText()+"-"+maintenanceDateMonTxt.getText()+"-"+maintenanceDateDayTxt.getText();
                String nextsch=nextSchDateYearTxt.getText()+"-"+nextSchDateMonTxt.getText()+"-"+nextSchDateDayTxt.getText();

                String insertQuery="insert into BusMaintenance(BusID,ManagerID,MaintenanceDate,MaintenanceType,Cost,Description,NextScheduleDate) values(?,?,?,?,?,?,?)";
                try {
                    PreparedStatement psmt=conn.prepareStatement(insertQuery);
                    psmt.setInt(1,Integer.parseInt(busIDTxt.getText()));

                    if(managerIDTxt.getText().equals(""))
                    {

                        psmt.setString(2,null);

                    }
                    else{
                        psmt.setInt(2,Integer.parseInt(managerIDTxt.getText()));

                    }
                    psmt.setString(3,maintenanceDate);
                    psmt.setString(4,maintenanceTypeTxt.getText());
                    psmt.setInt(5,Integer.parseInt(costTxt.getText()));
                    psmt.setString(6,descriptionTxt.getText());
                    psmt.setString(7,nextsch);

                    psmt.executeUpdate();

                    String query="Select BusMaintenanceID from BusMaintenance ";
                    PreparedStatement pst=conn.prepareStatement(query);
                    ResultSet rs=pst.executeQuery();
                    while(rs.next())
                    {
                        iD=rs.getInt(1);
                        if(iD>maxVal){
                            maxVal=iD;
                        }

                    }

                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                String[] row={Integer.toString(maxVal),busIDTxt.getText(),managerIDTxt.getText(),maintenanceDate,maintenanceTypeTxt.getText(),costTxt.getText(),descriptionTxt.getText(),nextsch};



                tableModel.addRow(row);
                addDialog.dispose();

            }
        });


        inputPanel.add(addRecordLabel);
        inputPanel.add(busIDLabel);
        inputPanel.add(busIDTxt);
        inputPanel.add(managerIDLabel);
        inputPanel.add(managerIDTxt);
        inputPanel.add(maintenanceDateLabel);
        inputPanel.add(maintenanceDateDayLabel);
        inputPanel.add(maintenanceDateDayTxt);
        inputPanel.add(maintenanceDateMonLabel);
        inputPanel.add(maintenanceDateMonTxt);
        inputPanel.add(maintenanceDateYearLabel);
        inputPanel.add(maintenanceDateYearTxt);
        inputPanel.add(maintenanceTypeLabel);
        inputPanel.add(maintenanceTypeTxt);
        inputPanel.add(costLabel);
        inputPanel.add(costTxt);
        inputPanel.add(descriptionLabel);
        inputPanel.add(descriptionTxt);
        inputPanel.add(nextSchDateLabel);
        inputPanel.add(nextSchDateDayLabel);
        inputPanel.add(nextSchDateDayTxt);
        inputPanel.add(nextSchDateMonLabel);
        inputPanel.add(nextSchDateMonTxt);
        inputPanel.add(nextSchDateYearLabel);
        inputPanel.add(nextSchDateYearTxt);

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


        JLabel busMaintenanceIDLabel =new JLabel();
        busMaintenanceIDLabel.setText("Bus Maintenance ID:");
        busMaintenanceIDLabel.setBounds(10,100,180,30);
        busMaintenanceIDLabel.setFont(new Font("Arial",Font.BOLD,17));
        busMaintenanceIDLabel.setForeground(Color.orange);

        JTextField busMaintenanceIDTxt =new JTextField();
        busMaintenanceIDTxt.setBounds(200,100,150,30);


        JButton searchButton=new JButton("Search");
        searchButton.setBounds(130,170,100,30);
        searchButton.setBackground(Color.cyan);
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String IDVal = busMaintenanceIDTxt.getText();
                boolean found=false;
                for (int i = 0; i < tableModel.getRowCount(); i++)
                {
                    if (tableModel.getValueAt(i, 0).equals(IDVal))
                    {
                        String delQuery="DELETE FROM BusMaintenance WHERE busMaintenanceID=?";
                        try
                        {
                            PreparedStatement preparedStatement=conn.prepareStatement(delQuery);
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
                    JOptionPane.showMessageDialog(removeDialog, "Record with Bus Maintenance ID " + IDVal +" not found.", "Record Not Found", JOptionPane.WARNING_MESSAGE);
                }
                else {
                    JOptionPane.showMessageDialog(removeDialog, "Record with Bus Maintenance ID " + IDVal +  " removed successfully.", "Record Removed", JOptionPane.INFORMATION_MESSAGE);
                }
            }



        });

        removeDialog.add(addRecLabel);
        removeDialog.add(busMaintenanceIDLabel);
        removeDialog.add(busMaintenanceIDTxt);
        removeDialog.add(searchButton);

        removeDialog.setVisible(true);
    }
    public void editRecord()
    {   JDialog editDialog = new JDialog(this, "Edit Record", true);
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
        inputPanel.setPreferredSize(new Dimension(480, 700));

        JLabel editRecLabel =new JLabel();
        editRecLabel.setText("Edit Record");
        editRecLabel.setFont(new Font("Arial",Font.BOLD,22));
        editRecLabel.setForeground(Color.orange);
        editRecLabel.setBounds(150, 30,240,30);


        JLabel busMaintenanceIDLabel =new JLabel();
        busMaintenanceIDLabel.setText("Bus Maintenance ID:");
        busMaintenanceIDLabel.setBounds(10,100,180,30);
        busMaintenanceIDLabel.setFont(new Font("Arial",Font.BOLD,17));
        busMaintenanceIDLabel.setForeground(Color.orange);

        JTextField busMaintenanceIDTxt =new JTextField();
        busMaintenanceIDTxt.setBounds(200,100,150,30);

        JCheckBox busIDCheckbox =new JCheckBox("Bus ID");
        busIDCheckbox.setBackground( Color.darkGray);
        busIDCheckbox.setForeground(Color.orange);
        busIDCheckbox.setBounds(40,200,70,30);
        busIDCheckbox.setVisible(false);

        JCheckBox maintenanceTypeCheckbox =new JCheckBox("Maintenance Type");
        maintenanceTypeCheckbox.setBackground( Color.darkGray);
        maintenanceTypeCheckbox.setForeground(Color.orange);
        maintenanceTypeCheckbox.setBounds(140,200,130,30);
        maintenanceTypeCheckbox.setVisible(false);

        JCheckBox maintenanceDateCheckbox =new JCheckBox("Maintenance Date");
        maintenanceDateCheckbox.setBackground( Color.darkGray);
        maintenanceDateCheckbox.setForeground(Color.orange);
        maintenanceDateCheckbox.setBounds(280,200,130,30);
        maintenanceDateCheckbox.setVisible(false);

        JCheckBox costCheckbox =new JCheckBox("Cost");
        costCheckbox.setBackground( Color.darkGray);
        costCheckbox.setForeground(Color.orange);
        costCheckbox.setBounds(40,235,60,30);
        costCheckbox.setVisible(false);

        JCheckBox descriptionCheckbox =new JCheckBox("Description");
        descriptionCheckbox.setBackground( Color.darkGray);
        descriptionCheckbox.setForeground(Color.orange);
        descriptionCheckbox.setBounds(140,235,90,30);
        descriptionCheckbox.setVisible(false);

        JCheckBox nextSchDateCheckbox =new JCheckBox("Next Schedule Date");
        nextSchDateCheckbox.setBackground( Color.darkGray);
        nextSchDateCheckbox.setForeground(Color.orange);
        nextSchDateCheckbox.setBounds(280,235,150,30);
        nextSchDateCheckbox.setVisible(false);



        JLabel busIDLabel =new JLabel();
        busIDLabel.setText("Bus ID:");
        busIDLabel.setBounds(10,290,180,30);
        busIDLabel.setFont(new Font("Arial",Font.BOLD,20));
        busIDLabel.setForeground(Color.orange);
        busIDLabel.setVisible(false);

        JTextField busIDTxt =new JTextField();
        busIDTxt.setBounds(200,290,150,30);
        busIDTxt.setVisible(false);

        JLabel maintenanceTypeLabel =new JLabel();
        maintenanceTypeLabel.setText("Maintenance Type:");
        maintenanceTypeLabel.setBounds(10,340,180,30);
        maintenanceTypeLabel.setFont(new Font("Arial",Font.BOLD,20));
        maintenanceTypeLabel.setForeground(Color.orange);
        maintenanceTypeLabel.setVisible(false);

        JTextField maintenanceTypeTxt =new JTextField();
        maintenanceTypeTxt.setBounds(200,340,150,30);
        maintenanceTypeTxt.setVisible(false);

        JLabel maintenanceDateLabel =new JLabel();
        maintenanceDateLabel.setText("Maintenance Date:");
        maintenanceDateLabel.setBounds(10,390,180,30);
        maintenanceDateLabel.setFont(new Font("Arial",Font.BOLD,20));
        maintenanceDateLabel.setForeground(Color.orange);
        maintenanceDateLabel.setVisible(false);

        JLabel maintenanceDateDayLabel =new JLabel("(Day)");
        maintenanceDateDayLabel.setBounds(200,420,50,30);
        maintenanceDateDayLabel.setForeground(Color.orange);
        maintenanceDateDayLabel.setFont(new Font("Arial",Font.BOLD,11));
        maintenanceDateDayLabel.setVisible(false);

        JTextField maintenanceDateDayTxt=new JTextField();
        maintenanceDateDayTxt.setBounds(200,390,40,30);
        maintenanceDateDayTxt.setVisible(false);

        JLabel maintenanceDateMonLabel =new JLabel("(Month)");
        maintenanceDateMonLabel.setBounds(250,420,50,30);
        maintenanceDateMonLabel.setForeground(Color.orange);
        maintenanceDateMonLabel.setFont(new Font("Arial",Font.BOLD,11));
        maintenanceDateMonLabel.setVisible(false);

        JTextField maintenanceDateMonTxt=new JTextField();
        maintenanceDateMonTxt.setBounds(250,390,40,30);
        maintenanceDateMonTxt.setVisible(false);

        JLabel maintenanceDateYearLabel =new JLabel("(Year)");
        maintenanceDateYearLabel.setBounds(300,420,50,30);
        maintenanceDateYearLabel.setForeground(Color.orange);
        maintenanceDateYearLabel.setFont(new Font("Arial",Font.BOLD,11));
        maintenanceDateYearLabel.setVisible(false);

        JTextField maintenanceDateYearTxt=new JTextField();
        maintenanceDateYearTxt.setBounds(300,390,40,30);
        maintenanceDateYearTxt.setVisible(false);

        JLabel costLabel =new JLabel("Cost:");
        costLabel.setBounds(10,470,180,30);
        costLabel.setFont(new Font("Arial",Font.BOLD,20));
        costLabel.setForeground(Color.orange);
        costLabel.setVisible(false);

        JTextField costTxt =new JTextField();
        costTxt.setBounds(200,470,150,30);
        costTxt.setVisible(false);

        JLabel descriptionLabel =new JLabel("Description:");
        descriptionLabel.setBounds(10,520,180,30);
        descriptionLabel.setFont(new Font("Arial",Font.BOLD,20));
        descriptionLabel.setForeground(Color.orange);
        descriptionLabel.setVisible(false);

        JTextField descriptionTxt =new JTextField();
        descriptionTxt.setBounds(200,520,150,30);
        descriptionTxt.setVisible(false);

        JLabel nextSchDateLabel=new JLabel("Next Schedule Date:");
        nextSchDateLabel.setFont(new Font("Arial",Font.BOLD,18));
        nextSchDateLabel.setForeground(Color.orange);
        nextSchDateLabel.setBounds(10,570,180,30);
        nextSchDateLabel.setVisible(false);

        JLabel nextSchDateDayLabel =new JLabel("(Day)");
        nextSchDateDayLabel.setBounds(200,600,50,30);
        nextSchDateDayLabel.setForeground(Color.orange);
        nextSchDateDayLabel.setFont(new Font("Arial",Font.BOLD,11));
        nextSchDateDayLabel.setVisible(false);

        JTextField nextSchDateDayTxt=new JTextField();
        nextSchDateDayTxt.setBounds(200,570,40,30);
        nextSchDateDayTxt.setVisible(false);

        JLabel nextSchDateMonLabel =new JLabel("(Month)");
        nextSchDateMonLabel.setBounds(250,600,50,30);
        nextSchDateMonLabel.setForeground(Color.orange);
        nextSchDateMonLabel.setFont(new Font("Arial",Font.BOLD,11));
        nextSchDateMonLabel.setVisible(false);

        JTextField nextSchDateMonTxt=new JTextField();
        nextSchDateMonTxt.setBounds(250,570,40,30);
        nextSchDateMonTxt.setVisible(false);

        JLabel nextSchDateYearLabel =new JLabel("(Year)");
        nextSchDateYearLabel.setBounds(300,600,50,30);
        nextSchDateYearLabel.setForeground(Color.orange);
        nextSchDateYearLabel.setFont(new Font("Arial",Font.BOLD,11));
        nextSchDateYearLabel.setVisible(false);

        JTextField nextSchDateYearTxt=new JTextField();
        nextSchDateYearTxt.setBounds(300,570,40,30);
        nextSchDateYearTxt.setVisible(false);

        JButton editButton=new JButton("Edit");
        editButton.setBounds(130,650,100,30);
        editButton.setBackground(Color.cyan);
        //editButton.setVisible(false);


        JButton searchButton=new JButton("Search");
        searchButton.setBounds(130,150,100,30);
        searchButton.setBackground(Color.cyan);
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String val= busMaintenanceIDTxt.getText();
                boolean found=false;
                for (int i = 0; i < tableModel.getRowCount(); i++)
                {
                    if (tableModel.getValueAt(i, 0).equals(val))
                    {

                        busIDCheckbox.setVisible(true);
                        maintenanceTypeCheckbox.setVisible(true);
                        maintenanceDateCheckbox.setVisible(true);
                        costCheckbox.setVisible(true);
                        descriptionCheckbox.setVisible(true);
                        nextSchDateCheckbox.setVisible(true);

                        found = true;
                        break;
                    }
                }
                if (!found)
                {
                    JOptionPane.showMessageDialog(editDialog, "Record with Bus Maintenance ID " + val + " not found.", "Record Not Found", JOptionPane.WARNING_MESSAGE);
                }
            }
        });


        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String val= busMaintenanceIDTxt.getText();
                for (int i = 0; i < tableModel.getRowCount(); i++)
                {
                    if (tableModel.getValueAt(i, 0).equals(val))
                    {


                        String maintenanceDate=maintenanceDateYearTxt.getText()+"-"+maintenanceDateMonTxt.getText()+"-"+maintenanceDateDayTxt.getText();
                        String nextSch=nextSchDateYearTxt.getText()+"-"+nextSchDateMonTxt.getText()+"-"+nextSchDateDayTxt.getText();


                        if(busIDCheckbox.isSelected())
                        {
                            recTable.setValueAt(busIDTxt.getText(),i,1);

                            String updateQuery="update BusMaintenance set BusID=? where BusMaintenanceID=?";
                            try {
                                PreparedStatement pst=conn.prepareStatement(updateQuery);
                                pst.setInt(1,Integer.parseInt(busIDTxt.getText()));
                                pst.setInt(2,Integer.parseInt(val));
                                pst.executeUpdate();

                            } catch (SQLException ex) {
                                throw new RuntimeException(ex);
                            }
                        }

                        if(maintenanceDateCheckbox.isSelected())
                        {
                            recTable.setValueAt(maintenanceDate,i,3);
                            String updateQuery="update BusMaintenance set MaintenanceDate=? where BusMaintenanceID=?";
                            try {
                                PreparedStatement pst=conn.prepareStatement(updateQuery);
                                pst.setString(1,maintenanceDate);
                                pst.setInt(2,Integer.parseInt(val));
                                pst.executeUpdate();

                            } catch (SQLException ex) {
                                throw new RuntimeException(ex);
                            }

                        }

                        if(maintenanceTypeCheckbox.isSelected())
                        {
                            recTable.setValueAt(maintenanceTypeTxt.getText(),i,4);

                            String updateQuery="update BusMaintenance set MaintenanceType=? where BusMaintenanceID=?";
                            try {
                                PreparedStatement pst=conn.prepareStatement(updateQuery);
                                pst.setString(1,maintenanceTypeTxt.getText());
                                pst.setInt(2,Integer.parseInt(val));
                                pst.executeUpdate();

                            } catch (SQLException ex) {
                                throw new RuntimeException(ex);
                            }
                        }

                        if(costCheckbox.isSelected())
                        {
                            recTable.setValueAt(costTxt.getText(),i,5);
                            String updateQuery="update BusMaintenance set Cost=? where BusMaintenanceID=?";
                            try {
                                PreparedStatement pst=conn.prepareStatement(updateQuery);
                                pst.setInt(1,Integer.parseInt(costTxt.getText()));
                                pst.setInt(2,Integer.parseInt(val));
                                pst.executeUpdate();

                            } catch (SQLException ex) {
                                throw new RuntimeException(ex);
                            }

                        }

                        if(descriptionCheckbox.isSelected())
                        {
                            recTable.setValueAt(descriptionTxt.getText(),i,6);

                            String updateQuery="update BusMaintenance set Description=? where BusMaintenanceID=?";
                            try {
                                PreparedStatement pst=conn.prepareStatement(updateQuery);
                                pst.setString(1,descriptionTxt.getText());
                                pst.setInt(2,Integer.parseInt(val));
                                pst.executeUpdate();

                            } catch (SQLException ex) {
                                throw new RuntimeException(ex);
                            }
                        }

                        if(nextSchDateCheckbox.isSelected())
                        {
                            recTable.setValueAt(nextSch,i,7);
                            String updateQuery="update BusMaintenance set NextScheduleDate=? where BusMaintenanceID=?";
                            try {
                                PreparedStatement pst=conn.prepareStatement(updateQuery);
                                pst.setString(1,nextSch);
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

        busIDCheckbox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(busIDCheckbox.isSelected())
                {
                    busIDLabel.setVisible(true);
                    busIDTxt.setVisible(true);
                }
                else{
                    busIDLabel.setVisible(false);
                    busIDTxt.setVisible(false);
                }
            }
        });

        costCheckbox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(costCheckbox.isSelected()){
                    costLabel.setVisible(true);
                    costTxt.setVisible(true);
                }
                else{
                    costLabel.setVisible(false);
                    costTxt.setVisible(false);
                }
            }
        });

        maintenanceDateCheckbox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(maintenanceDateCheckbox.isSelected()){
                    maintenanceDateLabel.setVisible(true);
                    maintenanceDateDayLabel.setVisible(true);
                    maintenanceDateDayTxt.setVisible(true);
                    maintenanceDateMonLabel.setVisible(true);
                    maintenanceDateMonTxt.setVisible(true);
                    maintenanceDateYearLabel.setVisible(true);
                    maintenanceDateYearTxt.setVisible(true);
                }
                else{
                    maintenanceDateLabel.setVisible(false);
                    maintenanceDateDayLabel.setVisible(false);
                    maintenanceDateDayTxt.setVisible(false);
                    maintenanceDateMonLabel.setVisible(false);
                    maintenanceDateMonTxt.setVisible(false);
                    maintenanceDateYearLabel.setVisible(false);
                    maintenanceDateYearTxt.setVisible(false);
                }
            }
        });

        maintenanceTypeCheckbox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(maintenanceTypeCheckbox.isSelected())
                {
                    maintenanceTypeLabel.setVisible(true);
                    maintenanceTypeTxt.setVisible(true);
                }
                else
                {
                    maintenanceTypeLabel.setVisible(false);
                    maintenanceTypeTxt.setVisible(false);

                }
            }
        });

        descriptionCheckbox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(descriptionCheckbox.isSelected())
                {
                    descriptionLabel.setVisible(true);
                    descriptionTxt.setVisible(true);
                }
                else{
                    descriptionLabel.setVisible(false);
                    descriptionTxt.setVisible(false);
                }
            }
        });

        nextSchDateCheckbox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(nextSchDateCheckbox.isSelected())
                {
                    nextSchDateLabel.setVisible(true);
                    nextSchDateDayLabel.setVisible(true);
                    nextSchDateDayTxt.setVisible(true);
                    nextSchDateMonLabel.setVisible(true);
                    nextSchDateMonTxt.setVisible(true);
                    nextSchDateYearLabel.setVisible(true);
                    nextSchDateYearTxt.setVisible(true);
                }
                else{
                    nextSchDateLabel.setVisible(false);
                    nextSchDateDayLabel.setVisible(false);
                    nextSchDateDayTxt.setVisible(false);
                    nextSchDateMonLabel.setVisible(false);
                    nextSchDateMonTxt.setVisible(false);
                    nextSchDateYearLabel.setVisible(false);
                    nextSchDateYearTxt.setVisible(false);
                }
            }
        });

        inputPanel.add(editRecLabel);
        inputPanel.add(busMaintenanceIDLabel);
        inputPanel.add(busMaintenanceIDTxt);
        inputPanel.add(searchButton);

        inputPanel.add(busIDCheckbox);
        inputPanel.add(maintenanceTypeCheckbox);
        inputPanel.add(maintenanceDateCheckbox);
        inputPanel.add(costCheckbox);
        inputPanel.add(descriptionCheckbox);
        inputPanel.add(nextSchDateCheckbox);
        inputPanel.add(busIDLabel);
        inputPanel.add(busIDTxt);
        inputPanel.add(maintenanceTypeLabel);
        inputPanel.add(maintenanceTypeTxt);
        inputPanel.add(maintenanceDateLabel);
        inputPanel.add(maintenanceDateDayLabel);
        inputPanel.add(maintenanceDateDayTxt);
        inputPanel.add(maintenanceDateMonLabel);
        inputPanel.add(maintenanceDateMonTxt);
        inputPanel.add(maintenanceDateYearLabel);
        inputPanel.add(maintenanceDateYearTxt);
        inputPanel.add(costLabel);
        inputPanel.add(costTxt);
        inputPanel.add(descriptionLabel);
        inputPanel.add(descriptionTxt);
        inputPanel.add(nextSchDateLabel);
        inputPanel.add(nextSchDateDayLabel);
        inputPanel.add(nextSchDateDayTxt);
        inputPanel.add(nextSchDateMonLabel);
        inputPanel.add(nextSchDateMonTxt);
        inputPanel.add(nextSchDateYearLabel);
        inputPanel.add(nextSchDateYearTxt);



        inputPanel.add(editButton);


        scrollPane.setViewportView(inputPanel);
        editDialog.getContentPane().add(scrollPane);

        editDialog.setResizable(false);
        editDialog.setVisible(true);

    }

    public static void main(String[] args) {
        ManageBusMaintenancePage mbmp= new ManageBusMaintenancePage();
    }
}
