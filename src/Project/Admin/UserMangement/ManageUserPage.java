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

import java.sql.*;


public class ManageUserPage extends JFrame {

    DefaultTableModel tableModel;
    JTable recTable;
    Connection conn=Database.setConnection();
    public ManageUserPage() {

        JLabel label=new JLabel();
        label.setText("Manage User");
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



        JLabel customerIDLabel =new JLabel();
        customerIDLabel.setText("Customer ID:");
        customerIDLabel.setBounds(240,80,150,50);
        customerIDLabel.setFont(new Font("Arial",Font.BOLD,18));
        customerIDLabel.setForeground(Color.orange);

        JTextField customerIDTxt =new JTextField();
        customerIDTxt.setBounds(400,90,150,30);

        JButton searchButton=new JButton("Search");
        searchButton.setBounds(570,90,100,30);
        searchButton.setBackground(Color.cyan);
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String val = customerIDTxt.getText();
                boolean found = false;
                String query = "select * from Customer where CusID=?";
                try {
                    PreparedStatement psmt = conn.prepareStatement(query);
                    psmt.setInt(1, Integer.parseInt(val));
                    ResultSet rs = psmt.executeQuery();
                    while (rs.next())
                    {
                        tableModel.setRowCount(0);
                        int cusID = rs.getInt("CusID");
                        String firstName = rs.getString("FirstName");
                        String lastName = rs.getString("LastName");
                        String cnic = rs.getString("CNIC");
                        String dob = rs.getString("DOB");
                        String contact = rs.getString("ContactNo");
                        String email = rs.getString("Email");
                        String city = rs.getString("City");
                        String address = rs.getString("Address");;
                        String password = rs.getString("Password");
                        String lastSeen = rs.getString("LastSeen");
                        String accountStatus = rs.getString("AccountStatus");
                        int len=6*address.length();
                        if(len>180)
                        {
                            recTable.getColumnModel().getColumn(8).setPreferredWidth(len);
                        }
                        int emLen=6*email.length();
                        if(emLen>130)
                        {
                            recTable.getColumnModel().getColumn(6).setPreferredWidth(emLen);
                        }
                        String[] row = {Integer.toString(cusID), firstName, lastName, cnic, dob, contact, email, city, address, password, lastSeen, accountStatus};
                        tableModel.addRow(row);
                    }

                    found = true;

                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                if (!found) {
                    JOptionPane.showMessageDialog(null, "Record with Customer ID " + val + " not found.", "Record Not Found", JOptionPane.WARNING_MESSAGE);
                }

            }
        });

        JButton removeButton =new JButton();
        removeButton.setText("- Remove");
        removeButton.setBounds(240,140,90,30);
        removeButton.setBackground(Color.RED);
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                removeRecord();
            }
        });

        JButton editButton =new JButton();
        editButton.setText("Edit");
        editButton.setBounds(350,140,90,30);
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

        String[]column={"Customer ID","First Name","Last Name","CNIC/ Passport","Date of Birth","Contact Number","Email","City","Address","Password","Last Seen","Account Status"};

        tableModel=new DefaultTableModel(column,0);
        recTable=new JTable(tableModel);
        recTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        recTable.getColumnModel().getColumn(0).setPreferredWidth(100);
        recTable.getColumnModel().getColumn(1).setPreferredWidth(100);
        recTable.getColumnModel().getColumn(2).setPreferredWidth(100);
        recTable.getColumnModel().getColumn(3).setPreferredWidth(120);
        recTable.getColumnModel().getColumn(4).setPreferredWidth(120);
        recTable.getColumnModel().getColumn(5).setPreferredWidth(120);
        recTable.getColumnModel().getColumn(6).setPreferredWidth(130);
        recTable.getColumnModel().getColumn(7).setPreferredWidth(120);
        recTable.getColumnModel().getColumn(8).setPreferredWidth(180);
        recTable.getColumnModel().getColumn(9).setPreferredWidth(120);
        recTable.getColumnModel().getColumn(10).setPreferredWidth(120);
        recTable.getColumnModel().getColumn(11).setPreferredWidth(130);

        String query="Select * from Customer order by CustomerID";
        try
        {
            PreparedStatement psmt=conn.prepareStatement(query);
            ResultSet rs=psmt.executeQuery();
            while (rs.next())
            {
                int cusID = rs.getInt("CusID");
                String firstName = rs.getString("FirstName");
                String lastName = rs.getString("LastName");
                String cnic = rs.getString("CNIC");
                String dob = rs.getString("DOB");
                String contact = rs.getString("ContactNo");
                String email = rs.getString("Email");
                String city = rs.getString("City");
                String address = rs.getString("Address");;
                String password = rs.getString("Password");
                String lastSeen = rs.getString("LastSeen");
                String accountStatus = rs.getString("AccountStatus");
                int len=6*address.length();
                if(len>180)
                {
                    recTable.getColumnModel().getColumn(8).setPreferredWidth(len);
                }
                int emLen=6*email.length();
                if(emLen>130)
                {
                    recTable.getColumnModel().getColumn(6).setPreferredWidth(emLen);
                }
                String[] row = {Integer.toString(cusID), firstName, lastName, cnic, dob, contact, email, city, address, password, lastSeen, accountStatus};
                tableModel.addRow(row);
            }
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }


        JScrollPane scrollPane=new JScrollPane(recTable);
        scrollPane.setBounds(1,1,600,350);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        tabPanel.add(scrollPane);


        setTitle("Manage User");
        setLayout(null);
        setSize(900, 650);
        getContentPane().setBackground(Color.darkGray);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);


        add(label);
        add(menuPanel);
        add(customerIDLabel);
        add(customerIDTxt);
        add(searchButton);
        add(removeButton);
        add(editButton);
        add(tabPanel);
    }

    public void removeRecord() {

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


        JLabel customerIDLabel =new JLabel();
        customerIDLabel.setText("Customer ID:");
        customerIDLabel.setBounds(50,100,180,30);
        customerIDLabel.setFont(new Font("Arial",Font.BOLD,20));
        customerIDLabel.setForeground(Color.orange);

        JTextField customerIDTxt =new JTextField();
        customerIDTxt.setBounds(180,100,150,30);


        JButton searchButton=new JButton("Search");
        searchButton.setBounds(130,170,100,30);
        searchButton.setBackground(Color.cyan);
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String IDVal = customerIDTxt.getText();
                boolean found=false;
                for (int i = 0; i < tableModel.getRowCount(); i++)
                {
                    if (tableModel.getValueAt(i, 0).equals(IDVal))
                    {
                        String delQuery="Delete from Customer where CusID=?";
                        try
                        {
                            PreparedStatement psmt=conn.prepareStatement(delQuery);
                            psmt.setInt(1,Integer.parseInt(IDVal));
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
                    JOptionPane.showMessageDialog(removeDialog, "Record with Customer ID " + IDVal +" not found.", "Record Not Found", JOptionPane.WARNING_MESSAGE);
                }
                else {
                    JOptionPane.showMessageDialog(removeDialog, "Record with Customer ID " + IDVal +  " removed successfully.", "Record Removed", JOptionPane.INFORMATION_MESSAGE);
                }
            }



        });

        removeDialog.add(addRecLabel);
        removeDialog.add(customerIDLabel);
        removeDialog.add(customerIDTxt);
        removeDialog.add(searchButton);

        removeDialog.setVisible(true);


    }

    public void editRecord() {

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
        inputPanel.setPreferredSize(new Dimension(460, 680));

        JLabel editRecLabel =new JLabel();
        editRecLabel.setText("Edit Record");
        editRecLabel.setFont(new Font("Arial",Font.BOLD,22));
        editRecLabel.setForeground(Color.orange);
        editRecLabel.setBounds(150, 30,240,30);


        JLabel customerIDLabel =new JLabel();
        customerIDLabel.setText("Customer ID:");
        customerIDLabel.setBounds(10,100,180,30);
        customerIDLabel.setFont(new Font("Arial",Font.BOLD,20));
        customerIDLabel.setForeground(Color.orange);

        JTextField customerIDTxt =new JTextField();
        customerIDTxt.setBounds(200,100,150,30);

        JCheckBox contactNoCheckbox =new JCheckBox("Contact Number");
        contactNoCheckbox.setBackground( Color.darkGray);
        contactNoCheckbox.setForeground(Color.orange);
        contactNoCheckbox.setBounds(30,200,120,30);
        contactNoCheckbox.setVisible(false);

        JCheckBox emailCheckbox =new JCheckBox("Email");
        emailCheckbox.setBackground( Color.darkGray);
        emailCheckbox.setForeground(Color.orange);
        emailCheckbox.setBounds(150,200,60,30);
        emailCheckbox.setVisible(false);

        JCheckBox passwordCheckbox =new JCheckBox("Password");
        passwordCheckbox.setBackground( Color.darkGray);
        passwordCheckbox.setForeground(Color.orange);
        passwordCheckbox.setBounds(270,200,110,30);
        passwordCheckbox.setVisible(false);

        JCheckBox cityCheckbox =new JCheckBox("City");
        cityCheckbox.setBackground( Color.darkGray);
        cityCheckbox.setForeground(Color.orange);
        cityCheckbox.setBounds(30,230,50,30);
        cityCheckbox.setVisible(false);

        JCheckBox addressCheckbox =new JCheckBox("Address");
        addressCheckbox.setBackground( Color.darkGray);
        addressCheckbox.setForeground(Color.orange);
        addressCheckbox.setBounds(150,230,80,30);
        addressCheckbox.setVisible(false);

        JCheckBox accountStatusCheckbox =new JCheckBox("Account Status");
        accountStatusCheckbox.setBackground( Color.darkGray);
        accountStatusCheckbox.setForeground(Color.orange);
        accountStatusCheckbox.setBounds(270,230,160,30);
        accountStatusCheckbox.setVisible(false);

        JLabel contactNoLabel =new JLabel("Contact Number:");
        contactNoLabel.setBounds(10,280,180,30);
        contactNoLabel.setForeground(Color.orange);
        contactNoLabel.setFont(new Font("Arial",Font.BOLD,20));
        contactNoLabel.setVisible(false);

        JTextField contactNoTxt =new JTextField();
        contactNoTxt.setBounds(200,280,150,30);
        contactNoTxt.setVisible(false);

        JLabel emailLabel=new JLabel("Email:");
        emailLabel.setBounds(10,330,180,30);
        emailLabel.setForeground(Color.orange);
        emailLabel.setFont(new Font("Arial",Font.BOLD,20));
        emailLabel.setVisible(false);

        JTextField emailTxt=new JTextField();
        emailTxt.setBounds(200,330,150,30);
        emailTxt.setVisible(false);

        JLabel passwordLabel =new JLabel("Password:");
        passwordLabel.setBounds(10,380,180,30);
        passwordLabel.setForeground(Color.orange);
        passwordLabel.setFont(new Font("Arial",Font.BOLD,20));
        passwordLabel.setVisible(false);

        JTextField passwordTxt =new JTextField();
        passwordTxt.setBounds(200,380,150,30);
        passwordTxt.setVisible(false);


        JLabel cityLabel=new JLabel("City:");
        cityLabel.setBounds(10,430,180,30);
        cityLabel.setForeground(Color.orange);
        cityLabel.setFont(new Font("Arial",Font.BOLD,20));
        cityLabel.setVisible(false);

        JTextField cityTxt=new JTextField();
        cityTxt.setBounds(200,430,150,30);
        cityTxt.setVisible(false);

        JLabel addressLabel=new JLabel("Address:");
        addressLabel.setBounds(10,480,180,30);
        addressLabel.setForeground(Color.orange);
        addressLabel.setFont(new Font("Arial",Font.BOLD,20));
        addressLabel.setVisible(false);

        JTextField addressTxt=new JTextField();
        addressTxt.setBounds(200,480,150,30);
        addressTxt.setVisible(false);

        JLabel accountStatusLabel =new JLabel("Account Status:");
        accountStatusLabel.setBounds(10,530,180,30);
        accountStatusLabel.setFont(new Font("Arial",Font.BOLD,20));
        accountStatusLabel.setForeground(Color.orange);
        accountStatusLabel.setVisible(false);

        String[] stat={"-","Active","Not Active"};

        JComboBox statusCombobox=new JComboBox<>(stat);
        statusCombobox.setBounds(200,530,150,35);
        statusCombobox.setBackground(Color.orange);
        statusCombobox.setVisible(false);


        JButton searchButton=new JButton("Search");
        searchButton.setBounds(130,150,100,30);
        searchButton.setBackground(Color.cyan);
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String val= customerIDTxt.getText();
                boolean found=false;
                for (int i = 0; i < tableModel.getRowCount(); i++)
                {
                    if (tableModel.getValueAt(i, 0).equals(val))
                    {
                        contactNoCheckbox.setVisible(true);
                        passwordCheckbox.setVisible(true);
                        emailCheckbox.setVisible(true);
                        cityCheckbox.setVisible(true);
                        addressCheckbox.setVisible(true);
                        accountStatusCheckbox.setVisible(true);


                        found = true;
                        break;
                    }
                }
                if (!found)
                {
                    JOptionPane.showMessageDialog(editDialog, "Record with Customer ID " + val + " not found.", "Record Not Found", JOptionPane.WARNING_MESSAGE);
                }
            }
        });


        JButton editButton=new JButton("Edit");
        editButton.setBounds(130,600,100,30);
        editButton.setBackground(Color.cyan);
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String IDVal= customerIDTxt.getText();

                String stat=(String) statusCombobox.getSelectedItem();

                for(int i=0;i< tableModel.getRowCount();i++)
                {
                    if(recTable.getValueAt(i,0).equals(IDVal))
                    {
                        if(contactNoCheckbox.isSelected())
                        {
                            String phoneNo= contactNoTxt.getText();
                            String editQuery="Update Customer set ContactNo=? where CusID=?";
                            recTable.setValueAt(phoneNo,i,5);
                            try
                            {
                                PreparedStatement pst=conn.prepareStatement(editQuery);
                                pst.setString(1,phoneNo);
                                pst.setInt(2,Integer.parseInt(IDVal));
                                pst.executeUpdate();

                            }
                            catch (SQLException ex)
                            {
                                throw new RuntimeException(ex);
                            }

                        }
                        if(emailCheckbox.isSelected())
                        {
                            String email=emailTxt.getText();
                            int emLen=6*email.length();
                            if(emLen>130)
                            {
                                recTable.getColumnModel().getColumn(6).setPreferredWidth(emLen);
                            }
                            String editQuery="Update Customer set Email=? where CusID=?";
                            recTable.setValueAt(email,i,6);
                            try {
                                PreparedStatement pst=conn.prepareStatement(editQuery);
                                pst.setString(1,email);
                                pst.setInt(2,Integer.parseInt(IDVal));
                                pst.executeUpdate();

                            }
                            catch (SQLException ex)
                            {
                                throw new RuntimeException(ex);
                            }
                        }
                        if(passwordCheckbox.isSelected())
                        {
                            String pw= passwordTxt.getText();
                            String editQuery="Update Customer set Password=? where CusID=?";
                            recTable.setValueAt(pw,i,9);
                            try {
                                PreparedStatement pst=conn.prepareStatement(editQuery);
                                pst.setString(1,pw);
                                pst.setInt(2,Integer.parseInt(IDVal));
                                pst.executeUpdate();

                            } catch (SQLException ex) {
                                throw new RuntimeException(ex);
                            }
                        }
                        if(cityCheckbox.isSelected())
                        {
                            String city=cityTxt.getText();
                            String editQuery="Update Customer set City=? where CusID=?";
                            recTable.setValueAt(city,i,7);
                            try {
                                PreparedStatement pst=conn.prepareStatement(editQuery);
                                pst.setString(1,city);
                                pst.setInt(2,Integer.parseInt(IDVal));
                                pst.executeUpdate();

                            }
                            catch (SQLException ex)
                            {
                                throw new RuntimeException(ex);
                            }
                        }
                        if(addressCheckbox.isSelected())
                        {
                            String address=addressTxt.getText();
                            String editQuery="Update Customer set Address=? where CusID=?";
                            int len=6*address.length();
                            if(len>180)
                            {
                                recTable.getColumnModel().getColumn(8).setPreferredWidth(len);
                            }
                            recTable.setValueAt(address,i,8);
                            try {
                                PreparedStatement pst=conn.prepareStatement(editQuery);
                                pst.setString(1,address);
                                pst.setInt(2,Integer.parseInt(IDVal));
                                pst.executeUpdate();

                            }
                            catch (SQLException ex)
                            {
                                throw new RuntimeException(ex);
                            }

                        }
                        if(accountStatusCheckbox.isSelected())
                        {
                            String editQuery="Update Customer set AccountStatus=? where CusID=?";
                            recTable.setValueAt(stat,i,11);
                            try {
                                PreparedStatement pst=conn.prepareStatement(editQuery);
                                pst.setString(1,stat);
                                pst.setInt(2,Integer.parseInt(IDVal));
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

        contactNoCheckbox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (contactNoCheckbox.isSelected())
                {
                    contactNoLabel.setVisible(true);
                    contactNoTxt.setVisible(true);
                }
                else {
                    contactNoLabel.setVisible(false);
                    contactNoTxt.setVisible(false);
                }
            }
        });

        passwordCheckbox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(passwordCheckbox.isSelected())
                {
                    passwordLabel.setVisible(true);
                    passwordTxt.setVisible(true);
                }
                else{
                    passwordLabel.setVisible(false);
                    passwordTxt.setVisible(false);
                }
            }
        });

        emailCheckbox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(emailCheckbox.isSelected())
                {
                    emailLabel.setVisible(true);
                    emailTxt.setVisible(true);
                }
                else{
                    emailLabel.setVisible(false);
                    emailTxt.setVisible(false);
                }
            }
        });

        cityCheckbox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(cityCheckbox.isSelected())
                {
                    cityLabel.setVisible(true);
                    cityTxt.setVisible(true);
                }
                else{
                    cityLabel.setVisible(false);
                    cityTxt.setVisible(false);
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
                }
                else{
                    addressLabel.setVisible(false);
                    addressTxt.setVisible(false);
                }
            }
        });

        accountStatusCheckbox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(accountStatusCheckbox.isSelected())
                {
                    accountStatusLabel.setVisible(true);
                    statusCombobox.setVisible(true);
                }
                else{
                    accountStatusLabel.setVisible(false);
                    statusCombobox.setVisible(false);
                }
            }
        });



        inputPanel.add(editRecLabel);
        inputPanel.add(customerIDLabel);
        inputPanel.add(customerIDTxt);
        inputPanel.add(searchButton);
        inputPanel.add(contactNoCheckbox);
        inputPanel.add(emailCheckbox);
        inputPanel.add(passwordCheckbox);

        inputPanel.add(cityCheckbox);
        inputPanel.add(addressCheckbox);
        inputPanel.add(accountStatusCheckbox);
        inputPanel.add(contactNoLabel);
        inputPanel.add(contactNoTxt);
        inputPanel.add(passwordLabel);
        inputPanel.add(passwordTxt);
        inputPanel.add(emailLabel);
        inputPanel.add(emailTxt);
        inputPanel.add(cityLabel);
        inputPanel.add(cityTxt);
        inputPanel.add(addressLabel);
        inputPanel.add(addressTxt);
        inputPanel.add(accountStatusLabel);
        inputPanel.add(statusCombobox);
        inputPanel.add(editButton);

        scrollPane.setViewportView(inputPanel);
        editDialog.getContentPane().add(scrollPane);

        editDialog.setResizable(false);
        editDialog.setVisible(true);

    }
    public static void main(String[] args)
    {
        ManageUserPage mup=new ManageUserPage();
    }
}
