package Project.Admin.UserMangement;

import Project.Admin.AdminDashboard;
import Project.Admin.BookingManagement.*;
import Project.Admin.BusManagement.ManageBusMaintenancePage;
import Project.Admin.BusManagement.ManageBusPage;
import Project.Admin.BusManagement.ManageRoutePage;
import Project.Admin.BusManagement.ManageStopRoutePage;
import Project.Admin.GenerateReportPage;
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
import java.util.ArrayList;

public class ManageDriverPage extends JFrame {

    DefaultTableModel tableModel;
    JTable recTable;
    Connection connection= Database.setConnection();

    public ManageDriverPage() {


        JLabel label=new JLabel();
        label.setText("Manage Driver");
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
        DefaultMutableTreeNode view_booking=new DefaultMutableTreeNode("View Orders");
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

                        case "View Orders":
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



        JLabel driverIDSearchLabel =new JLabel();
        driverIDSearchLabel.setText("Driver ID:");
        driverIDSearchLabel.setBounds(240,80,150,50);
        driverIDSearchLabel.setFont(new Font("Arial",Font.BOLD,15));
        driverIDSearchLabel.setForeground(Color.orange);

        JTextField driverIDSearchTxt =new JTextField();
        driverIDSearchTxt.setBounds(400,90,150,30);

        JButton searchButton=new JButton("Search");
        searchButton.setBounds(570,90,100,30);
        searchButton.setBackground(Color.cyan);
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String val= driverIDSearchTxt.getText();
                boolean found=false;
                String query="select * from Driver where DriverID=?";
                try {
                    PreparedStatement psmt=connection.prepareStatement(query);
                    psmt.setInt(1,Integer.parseInt(val));
                    ResultSet rs=psmt.executeQuery();
                    while (rs.next())
                    {
                        int driverID=rs.getInt("DriverID");
                        int managerID=rs.getInt("ManagerID");
                        String firstName=rs.getString("FirstName");
                        String lastName=rs.getString("LastName");
                        String dob=rs.getString("DOB");
                        String cnicNumber=rs.getString("CNIC Number");
                        String contactNumber=rs.getString("Contact Number");
                        String licenseNumber=rs.getString("License Number");
                        String address=rs.getString("Address");
                        int salary=rs.getInt("Salary");
                        String accountStatus=rs.getString("Account Status");

                        String [] row={Integer.toString(driverID),Integer.toString(managerID),firstName,lastName,dob,cnicNumber,
                                contactNumber,licenseNumber,address,Integer.toString(salary),accountStatus};
                        tableModel.addRow(row);

                        found = true;
                    }
                }
                catch (SQLException ex)
                {
                    throw new RuntimeException(ex);
                }
                if (!found)
                {
                    JOptionPane.showMessageDialog(null, "Record with Driver ID " + val + " not found.", "Record Not Found", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        JButton addButton =new JButton();
        addButton.setText("+ Add");
        addButton.setBounds(250,150,90,30);
        addButton.setBackground(Color.GREEN);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addRecord();
            }
        });

        JButton removeButton =new JButton();
        removeButton.setText("- Remove");
        removeButton.setBounds(350,150,90,30);
        removeButton.setBackground(Color.RED);
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeRecord();
            }
        });


        JButton editButton =new JButton();
        editButton.setText("Edit");
        editButton.setBounds(450,150,90,30);
        editButton.setBackground(Color.PINK);
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editRecord();
            }
        });
        JPanel tabPanel=new JPanel();
        tabPanel.setBounds(250,190,590,350);
        tabPanel.setLayout(null);

        String[] columnNames = {"Driver ID","Manager ID","First Name","Last Name","Date of Birth","CNIC Number","Contact Number",
                "License Number","Address","Salary","Account Status"};


        tableModel=new DefaultTableModel(columnNames,0);
        recTable=new JTable(tableModel);
        recTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        recTable.getColumnModel().getColumn(0).setPreferredWidth(100);
        recTable.getColumnModel().getColumn(1).setPreferredWidth(100);
        recTable.getColumnModel().getColumn(2).setPreferredWidth(100);
        recTable.getColumnModel().getColumn(3).setPreferredWidth(100);
        recTable.getColumnModel().getColumn(4).setPreferredWidth(100);
        recTable.getColumnModel().getColumn(5).setPreferredWidth(130);
        recTable.getColumnModel().getColumn(6).setPreferredWidth(130);
        recTable.getColumnModel().getColumn(7).setPreferredWidth(130);
        recTable.getColumnModel().getColumn(8).setPreferredWidth(100);
        recTable.getColumnModel().getColumn(9).setPreferredWidth(100);
        recTable.getColumnModel().getColumn(10).setPreferredWidth(100);

        String query="Select * from Driver";
        try {
            PreparedStatement psmt=connection.prepareStatement(query);
            ResultSet rs=psmt.executeQuery();
            while (rs.next()) {
                int driverID = rs.getInt("DriverID");
                int managerID = rs.getInt("ManagerID");
                String firstName = rs.getString("FirstName");
                String lastName = rs.getString("LastName");
                String dob = rs.getString("DOB");
                String cnicNumber = rs.getString("CNIC");
                String contactNumber = rs.getString("ContactNo");
                String licenseNumber = rs.getString("LicenseNo");
                String address = rs.getString("Address");
                int length=address.length();
                int salary = rs.getInt("Salary");
                String accountStatus = rs.getString("AccountStatus");
                recTable.getColumnModel().getColumn(8).setPreferredWidth(6*length);
                String[] row = {Integer.toString(driverID), Integer.toString(managerID), firstName, lastName, dob, cnicNumber,
                        contactNumber, licenseNumber, address, Integer.toString(salary), accountStatus};
                tableModel.addRow(row);
            }
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }


        JScrollPane scrollPane=new JScrollPane(recTable);
        scrollPane.setBounds(1,1,590,350);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        tabPanel.add(scrollPane);


        setTitle("Manage Driver Page");
        setLayout(null);
        setSize(900, 650);
        getContentPane().setBackground(Color.darkGray);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);


        add(label);
        add(menuPanel);
        add(driverIDSearchLabel);
        add(driverIDSearchTxt);
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
        inputPanel.setPreferredSize(new Dimension(480, 650));

        JLabel addRecLabel=new JLabel();
        addRecLabel.setText("Add New Record");
        addRecLabel.setFont(new Font("Arial",Font.BOLD,25));
        addRecLabel.setForeground(Color.orange);
        addRecLabel.setBounds(150, 30,240,30);

        JLabel managerIDLabel =new JLabel();
        managerIDLabel.setText("Manager ID:");
        managerIDLabel.setBounds(10,100,150,30);
        managerIDLabel.setFont(new Font("Arial",Font.BOLD,20));
        managerIDLabel.setForeground(Color.orange);

        ArrayList<String> managerIDStatList = new ArrayList<>();
        managerIDStatList.add("null");
        String managerIDIDQuery ="select ManagerID from Manager where AccountStatus='Active'";
        try
        {
            PreparedStatement rspst=connection.prepareStatement(managerIDIDQuery);
            ResultSet rs=rspst.executeQuery();
            while(rs.next())
            {
                String managerID=Integer.toString(rs.getInt("ManagerID"));
                managerIDStatList.add(managerID);
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        String[] managerIDState = managerIDStatList.toArray(new String[0]);

        JComboBox managerIDCombobox =new JComboBox<>(managerIDState);
        managerIDCombobox.setBounds(200,150,150,35);
        //managerIDCombobox.setBackground(Color.orange);


        JLabel firstNameLabel =new JLabel();
        firstNameLabel.setText("First Name:");
        firstNameLabel.setBounds(10,150,180,30);
        firstNameLabel.setFont(new Font("Arial",Font.BOLD,20));
        firstNameLabel.setForeground(Color.orange);

        JTextField firstNameTxt =new JTextField();
        firstNameTxt.setBounds(200,150,150,30);

        JLabel lastNameLabel =new JLabel();
        lastNameLabel.setText("Last Name:");
        lastNameLabel.setBounds(10,200,180,30);
        lastNameLabel.setFont(new Font("Arial",Font.BOLD,20));
        lastNameLabel.setForeground(Color.orange);

        JTextField lastNameTxt =new JTextField();
        lastNameTxt.setBounds(200,200,150,30);

        JLabel dobLabel =new JLabel();
        dobLabel.setText("Date of Birth:");
        dobLabel.setBounds(10,250,180,30);
        dobLabel.setFont(new Font("Arial",Font.BOLD,20));
        dobLabel.setForeground(Color.orange);

        JLabel dobDayLabel =new JLabel("(Day)");
        dobDayLabel.setBounds(200,285,50,30);
        dobDayLabel.setForeground(Color.orange);
        dobDayLabel.setFont(new Font("Arial",Font.BOLD,11));

        JTextField dobDayTxt =new JTextField();
        dobDayTxt.setBounds(200,250,40,30);

        JLabel dobMonLabel =new JLabel("(Month)");
        dobMonLabel.setBounds(250,285,50,30);
        dobMonLabel.setForeground(Color.orange);
        dobMonLabel.setFont(new Font("Arial",Font.BOLD,11));

        JTextField dobMonTxt =new JTextField();
        dobMonTxt.setBounds(250,250,40,30);

        JLabel dobYearLabel =new JLabel("(Year)");
        dobYearLabel.setBounds(300,285,50,30);
        dobYearLabel.setForeground(Color.orange);
        dobYearLabel.setFont(new Font("Arial",Font.BOLD,11));

        JTextField dobYearTxt =new JTextField();
        dobYearTxt.setBounds(300,250,40,30);

        JLabel cnicNoLabel=new JLabel();
        cnicNoLabel.setText("CNIC Number:");
        cnicNoLabel.setBounds(10,340,180,30);
        cnicNoLabel.setFont(new Font("Arial",Font.BOLD,20));
        cnicNoLabel.setForeground(Color.orange);

        JTextField cnicNoTxt=new JTextField();
        cnicNoTxt.setBounds(200,340,150,30);

        JLabel contactNoLabel =new JLabel();
        contactNoLabel.setText("Contact Number:");
        contactNoLabel.setBounds(10,390,180,30);
        contactNoLabel.setFont(new Font("Arial",Font.BOLD,20));
        contactNoLabel.setForeground(Color.orange);

        JTextField contactNoTxt=new JTextField();
        contactNoTxt.setBounds(200,390,150,30);

        JLabel licenseNoLabel =new JLabel();
        licenseNoLabel.setText("License Number:");
        licenseNoLabel.setBounds(10,440,180,30);
        licenseNoLabel.setFont(new Font("Arial",Font.BOLD,20));
        licenseNoLabel.setForeground(Color.orange);

        JTextField licenseNoTxt =new JTextField();
        licenseNoTxt.setBounds(200,440,150,30);

        JLabel addressLabel =new JLabel();
        addressLabel.setText("Address:");
        addressLabel.setBounds(10,490,180,30);
        addressLabel.setFont(new Font("Arial",Font.BOLD,20));
        addressLabel.setForeground(Color.orange);

        JTextField addressTxt =new JTextField();
        addressTxt.setBounds(200,490,150,30);

        JLabel salaryLabel =new JLabel();
        salaryLabel.setText("Salary:");
        salaryLabel.setBounds(10,540,180,30);
        salaryLabel.setFont(new Font("Arial",Font.BOLD,20));
        salaryLabel.setForeground(Color.orange);

        JTextField salaryTxt =new JTextField();
        salaryTxt.setBounds(200,540,150,30);

        JButton addButton=new JButton("Add");
        addButton.setBounds(150,600,100,40);
        addButton.setBackground(Color.cyan);
        addButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                int id,maxVal=0;
                String dob=dobYearTxt.getText()+"-"+dobMonTxt.getText()+"-"+dobDayTxt.getText();
                String manID=(String) managerIDCombobox.getSelectedItem();
                String insertQuery="insert into Driver(ManagerID,FirstName,LastName,DOB,CNIC,ContactNo,LicenseNo,Address,Salary,AccountStatus) " +
                        "values(?,?,?,?,?,?,?,?,?,?)";
                try
                {
                    PreparedStatement psmt=connection.prepareStatement(insertQuery);
                    if(manID.equals("null"))
                    {
                        psmt.setString(2,null);

                    }
                    else
                    {
                        psmt.setInt(2, Integer.parseInt(manID));
                    }
                    psmt.setString(2,firstNameTxt.getText());
                    psmt.setString(3,lastNameTxt.getText());
                    psmt.setString(4,dob);
                    psmt.setString(5,cnicNoTxt.getText());
                    psmt.setString(6,contactNoTxt.getText());
                    psmt.setString(7,licenseNoTxt.getText());
                    psmt.setString(8,addressTxt.getText());
                    psmt.setInt(9,Integer.parseInt(salaryTxt.getText()));
                    psmt.setString(10,"Active");
                    psmt.executeUpdate();

                    String query="Select DriverID from Driver ";
                    PreparedStatement pst=connection.prepareStatement(query);
                    ResultSet rs=pst.executeQuery();
                    while(rs.next())
                    {
                        id=rs.getInt(1);
                        if(id>maxVal){
                            maxVal=id;
                        }

                    }

                }
                catch (SQLException ex)
                {
                    throw new RuntimeException(ex);
                }

                String[] row={Integer.toString(maxVal),manID,firstNameTxt.getText(), lastNameTxt.getText(),
                        dob,cnicNoTxt.getText(),contactNoTxt.getText(),
                        licenseNoTxt.getText(),addressTxt.getText(),salaryTxt.getText(),"Active"};
                int len=addressTxt.getText().length();
                recTable.getColumnModel().getColumn(8).setPreferredWidth(6*len);

                tableModel.addRow(row);
                addDialog.dispose();
            }
        });

        inputPanel.add(addRecLabel);
        inputPanel.add(managerIDLabel);
        inputPanel.add(managerIDCombobox);
        inputPanel.add(firstNameLabel);
        inputPanel.add(firstNameTxt);
        inputPanel.add(lastNameLabel);
        inputPanel.add(lastNameTxt);
        inputPanel.add(dobLabel);
        inputPanel.add(dobDayLabel);
        inputPanel.add(dobDayTxt);
        inputPanel.add(dobMonLabel);
        inputPanel.add(dobMonTxt);
        inputPanel.add(dobYearLabel);
        inputPanel.add(dobYearTxt);
        inputPanel.add(contactNoLabel);
        inputPanel.add(contactNoTxt);
        inputPanel.add(cnicNoLabel);
        inputPanel.add(cnicNoTxt);
        inputPanel.add(licenseNoLabel);
        inputPanel.add(licenseNoTxt);
        inputPanel.add(addressLabel);
        inputPanel.add(addressTxt);
        inputPanel.add(salaryLabel);
        inputPanel.add(salaryTxt);
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
        addRecLabel.setFont(new Font("Arial",Font.BOLD,22));
        addRecLabel.setForeground(Color.orange);
        addRecLabel.setBounds(100, 30,240,30);


        JLabel DriverIDLabel =new JLabel();
        DriverIDLabel.setText("Driver ID:");
        DriverIDLabel.setBounds(10,100,180,30);
        DriverIDLabel.setFont(new Font("Arial",Font.BOLD,20));
        DriverIDLabel.setForeground(Color.orange);

        JTextField driverIDTxt =new JTextField();
        driverIDTxt.setBounds(200,100,150,30);

        JButton searchButton=new JButton("Search");
        searchButton.setBounds(130,150,100,30);
        searchButton.setBackground(Color.cyan);
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String val= driverIDTxt.getText();
                boolean found=false;
                for (int i = 0; i < tableModel.getRowCount(); i++)
                {
                    if (tableModel.getValueAt(i, 0).equals(val))
                    {
                        String delQuery="Delete from Driver where DriverID=?";
                        try
                        {
                            PreparedStatement psmt=connection.prepareStatement(delQuery);
                            psmt.setInt(1,Integer.parseInt(val));
                            psmt.executeUpdate();
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
                if (!found) {
                    JOptionPane.showMessageDialog(removeDialog, "Record with Driver ID " + val + " not found.", "Record Not Found", JOptionPane.WARNING_MESSAGE);
                }
                else {
                    JOptionPane.showMessageDialog(removeDialog, "Record with Driver ID " + val + " removed successfully.", "Record Removed", JOptionPane.INFORMATION_MESSAGE);
                }
            }



        });

        removeDialog.add(addRecLabel);
        removeDialog.add(DriverIDLabel);
        removeDialog.add(driverIDTxt);
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
        inputPanel.setPreferredSize(new Dimension(480, 610));

        JLabel editRecLabel =new JLabel();
        editRecLabel.setText("Edit Record");
        editRecLabel.setFont(new Font("Arial",Font.BOLD,22));
        editRecLabel.setForeground(Color.orange);
        editRecLabel.setBounds(150, 30,240,30);


        JLabel driverIDLabel =new JLabel();
        driverIDLabel.setText("Driver ID:");
        driverIDLabel.setBounds(50,100,180,30);
        driverIDLabel.setFont(new Font("Arial",Font.BOLD,20));
        driverIDLabel.setForeground(Color.orange);

        JTextField driverIDTxt =new JTextField();
        driverIDTxt.setBounds(200,100,150,30);

        JCheckBox licenseCheckbox =new JCheckBox("License Number");
        licenseCheckbox.setBackground( Color.darkGray);
        licenseCheckbox.setForeground(Color.orange);
        licenseCheckbox.setBounds(40,200,130,30);
        licenseCheckbox.setVisible(false);


        JCheckBox contactNoCheckbox =new JCheckBox("Contact Number");
        contactNoCheckbox.setBackground( Color.darkGray);
        contactNoCheckbox.setForeground(Color.orange);
        contactNoCheckbox.setBounds(170,200,120,30);
        contactNoCheckbox.setVisible(false);

        JCheckBox addressCheckbox =new JCheckBox("Address");
        addressCheckbox.setBackground( Color.darkGray);
        addressCheckbox.setForeground(Color.orange);
        addressCheckbox.setBounds(300,200,90,30);
        addressCheckbox.setVisible(false);

        JCheckBox salaryCheckbox =new JCheckBox("Salary");
        salaryCheckbox.setBackground( Color.darkGray);
        salaryCheckbox.setForeground(Color.orange);
        salaryCheckbox.setBounds(40,235,90,30);
        salaryCheckbox.setVisible(false);

        JCheckBox statusCheckbox =new JCheckBox("Account Status");
        statusCheckbox.setBackground( Color.darkGray);
        statusCheckbox.setForeground(Color.orange);
        statusCheckbox.setBounds(170,235,120,30);
        statusCheckbox.setVisible(false);


        JLabel licenseNoLabel=new JLabel();
        licenseNoLabel.setText("License Number:");
        licenseNoLabel.setBounds(10,290,180,30);
        licenseNoLabel.setFont(new Font("Arial",Font.BOLD,20));
        licenseNoLabel.setForeground(Color.orange);
        licenseNoLabel.setVisible(false);

        JTextField licenseNoTxt=new JTextField();
        licenseNoTxt.setBounds(200,290,150,30);
        licenseNoTxt.setVisible(false);

        JLabel contactNoLabel=new JLabel();
        contactNoLabel.setText("Contact Number:");
        contactNoLabel.setBounds(10,340,180,30);
        contactNoLabel.setFont(new Font("Arial",Font.BOLD,20));
        contactNoLabel.setForeground(Color.orange);
        contactNoLabel.setVisible(false);

        JTextField contactNoTxt=new JTextField();
        contactNoTxt.setBounds(200,340,150,30);
        contactNoTxt.setVisible(false);


        JLabel addressLabel=new JLabel();
        addressLabel.setText("Address:");
        addressLabel.setBounds(10,390,180,30);
        addressLabel.setFont(new Font("Arial",Font.BOLD,20));
        addressLabel.setForeground(Color.orange);
        addressLabel.setVisible(false);

        JTextField addressTxt=new JTextField();
        addressTxt.setBounds(200,390,150,30);
        addressTxt.setVisible(false);

        JLabel salaryLabel=new JLabel();
        salaryLabel.setText("Salary:");
        salaryLabel.setBounds(10,440,180,30);
        salaryLabel.setFont(new Font("Arial",Font.BOLD,20));
        salaryLabel.setForeground(Color.orange);
        salaryLabel.setVisible(false);

        JTextField salaryTxt=new JTextField();
        salaryTxt.setBounds(200,440,150,30);
        salaryTxt.setVisible(false);

        JLabel statusLabel=new JLabel();
        statusLabel.setText("Select Status:");
        statusLabel.setBounds(10,490,180,30);
        statusLabel.setFont(new Font("Arial",Font.BOLD,20));
        statusLabel.setForeground(Color.orange);
        statusLabel.setVisible(false);

        String[] stat={"-","Active","Not Active"};

        JComboBox statusCombobox=new JComboBox<>(stat);
        statusCombobox.setBounds(200,490,150,35);
        statusCombobox.setBackground(Color.orange);
        statusCombobox.setVisible(false);


        JButton searchButton=new JButton("Search");
        searchButton.setBounds(130,150,100,30);
        searchButton.setBackground(Color.cyan);
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String val= driverIDTxt.getText();
                boolean found=false;
                for (int i = 0; i < tableModel.getRowCount(); i++)
                {
                    if (tableModel.getValueAt(i, 0).equals(val))
                    {
                        addressCheckbox.setVisible(true);
                        licenseCheckbox.setVisible(true);
                        contactNoCheckbox.setVisible(true);
                        salaryCheckbox.setVisible(true);
                        statusCheckbox.setVisible(true);

                        found = true;
                        break;
                    }
                }
                if (!found)
                {
                    JOptionPane.showMessageDialog(editDialog, "Record with Driver ID " + val + " not found.", "Record Not Found", JOptionPane.WARNING_MESSAGE);
                }
            }
        });


        JButton editButton=new JButton("Edit");
        editButton.setBounds(130,560,100,30);
        editButton.setBackground(Color.cyan);
        editButton.setVisible(false);

        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String val= driverIDTxt.getText();
                for (int i = 0; i < tableModel.getRowCount(); i++)
                {
                    if (tableModel.getValueAt(i, 0).equals(val))
                    {
                        if(contactNoCheckbox.isSelected())
                        {
                            String contact=contactNoTxt.getText();
                            recTable.setValueAt(contact, i, 6);
                            String updateQuery="update Driver set ContactNo=? where driverID=? ";
                            try
                            {
                                PreparedStatement pst=connection.prepareStatement(updateQuery);
                                pst.setString(1,contact);
                                pst.setString(2,val);
                                pst.executeUpdate();
                            }
                            catch (SQLException ex)
                            {
                                throw new RuntimeException(ex);
                            }
                        }
                        if(licenseCheckbox.isSelected())
                        {
                            String license=licenseNoTxt.getText();
                            recTable.setValueAt(license, i, 7);
                            String updateQuery="update Driver set LicenseNo=? where driverID=? ";
                            try
                            {
                                PreparedStatement pst=connection.prepareStatement(updateQuery);
                                pst.setString(1,license);
                                pst.setString(2,val);
                                pst.executeUpdate();
                            }
                            catch (SQLException ex)
                            {
                                throw new RuntimeException(ex);
                            }
                        }
                        if(addressCheckbox.isSelected())
                        {
                            String add=addressTxt.getText();
                            recTable.setValueAt(add, i, 8);
                            int len=addressTxt.getText().length();
                            recTable.getColumnModel().getColumn(8).setPreferredWidth(6*len);
                            String updateQuery="update Driver set Address=? where driverID=? ";
                            try
                            {
                                PreparedStatement pst=connection.prepareStatement(updateQuery);
                                pst.setString(1,add);
                                pst.setString(2,val);
                                pst.executeUpdate();
                            }
                            catch (SQLException ex)
                            {
                                throw new RuntimeException(ex);
                            }
                        }
                        if(salaryCheckbox.isSelected())
                        {
                            String sal=salaryTxt.getText();
                            recTable.setValueAt(sal, i, 9);
                            String updateQuery="update Driver set Salary=? where driverID=? ";
                            try {
                                PreparedStatement pst=connection.prepareStatement(updateQuery);
                                pst.setInt(1,Integer.parseInt(sal));
                                pst.setString(2,val);
                                pst.executeUpdate();
                            }
                            catch (SQLException ex)
                            {
                                throw new RuntimeException(ex);
                            }


                        }
                        if(statusCheckbox.isSelected())
                        {
                            String status=(String)statusCombobox.getSelectedItem();
                            recTable.setValueAt(status, i, 10);
                            String updateQuery="update Driver set AccountStatus=? where driverID=?";
                            try
                            {
                                PreparedStatement pst=connection.prepareStatement(updateQuery);
                                pst.setString(1,status);
                                pst.setString(2,val);
                                pst.executeUpdate();
                            }
                            catch (SQLException ex)
                            {
                                throw new RuntimeException(ex);
                            }
                        }

                        editDialog.dispose();
                        break;
                    }
                }
            }
        });

        addressCheckbox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(addressCheckbox.isSelected())
                {
                    addressLabel.setVisible(true);
                    addressTxt.setVisible(true);
                    editButton.setVisible(true);
                }
                else {
                    addressLabel.setVisible(false);
                    addressTxt.setVisible(false);
                    editButton.setVisible(false);

                }
            }
        });

        licenseCheckbox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(licenseCheckbox.isSelected())
                {
                    licenseNoLabel.setVisible(true);
                    licenseNoTxt.setVisible(true);
                    editButton.setVisible(true);

                }
                else {
                    licenseNoLabel.setVisible(false);
                    licenseNoTxt.setVisible(false);
                    editButton.setVisible(false);

                }
            }
        });

        contactNoCheckbox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(contactNoCheckbox.isSelected())
                {
                    contactNoLabel.setVisible(true);
                    contactNoTxt.setVisible(true);
                    editButton.setVisible(true);

                }
                else {
                    contactNoLabel.setVisible(false);
                    contactNoTxt.setVisible(false);
                    editButton.setVisible(false);

                }
            }
        });

        statusCheckbox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(statusCheckbox.isSelected())
                {
                    statusLabel.setVisible(true);
                    statusCombobox.setVisible(true);
                    editButton.setVisible(true);

                }
                else {
                    statusLabel.setVisible(false);
                    statusCombobox.setVisible(false);
                    editButton.setVisible(false);

                }
            }
        });

        salaryCheckbox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(salaryCheckbox.isSelected())
                {
                    salaryLabel.setVisible(true);
                    salaryTxt.setVisible(true);
                    editButton.setVisible(true);
                }
                else{
                    salaryLabel.setVisible(false);
                    salaryTxt.setVisible(false);
                    editButton.setVisible(false);
                }
            }
        });


        inputPanel.add(editRecLabel);
        inputPanel.add(driverIDLabel);
        inputPanel.add(driverIDTxt);
        inputPanel.add(searchButton);
        inputPanel.add(addressCheckbox);
        inputPanel.add(licenseCheckbox);
        inputPanel.add(contactNoCheckbox);
        inputPanel.add(salaryCheckbox);
        inputPanel.add(statusCheckbox);
        inputPanel.add(licenseNoLabel);
        inputPanel.add(licenseNoTxt);
        inputPanel.add(contactNoLabel);
        inputPanel.add(contactNoTxt);
        inputPanel.add(addressLabel);
        inputPanel.add(addressTxt);
        inputPanel.add(salaryLabel);
        inputPanel.add(salaryTxt);
        inputPanel.add(statusLabel);
        inputPanel.add(statusCombobox);
        inputPanel.add(editButton);

        scrollPane.setViewportView(inputPanel);
        editDialog.getContentPane().add(scrollPane);


        editDialog.setResizable(false);
        editDialog.setVisible(true);


    }

    public static void main(String[] args)
    {
        ManageDriverPage mg=new ManageDriverPage();
    }
}
