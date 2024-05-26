package Project.Admin.UserMangement;

import Project.Admin.AdminDashboard;
import Project.Admin.BookingManagement.*;
import Project.Admin.BusManagement.ManageBusMaintenancePage;
import Project.Admin.BusManagement.ManageBusPage;
import Project.Admin.BusManagement.ManageRoutePage;
import Project.Admin.BusManagement.ManageStopRoutePage;
import Project.Admin.GenerateReportPage;
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

public class ManageDriverPage extends JFrame {

    DefaultTableModel tableModel;
    JTable recTable;

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



        JLabel cnicSearchLabel =new JLabel();
        cnicSearchLabel.setText("CNIC No:");
        cnicSearchLabel.setBounds(240,80,150,50);
        cnicSearchLabel.setFont(new Font("Arial",Font.BOLD,15));
        cnicSearchLabel.setForeground(Color.orange);

        JTextField cnicSearchTxt =new JTextField();
        cnicSearchTxt.setBounds(400,90,150,30);

        JButton searchButton=new JButton("Search");
        searchButton.setBounds(570,90,100,30);
        searchButton.setBackground(Color.cyan);
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String val= cnicSearchTxt.getText();
                boolean found=false;
                for (int i = 0; i < tableModel.getRowCount(); i++)
                {
                    if (tableModel.getValueAt(i, 4).equals(val))
                    {
                        String message = "Driver ID: " + recTable.getValueAt(i, 0) + "\n" +
                                "Driver Name: " + recTable.getValueAt(i, 1) + "\n" +
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

        String[][] data = {
                {"123","25-05-21","Karachi","Lahore","26-5-21","2","600","Lahore","26-5-21","2","600"},
                {"123","25-05-21","Karachi","Lahore","26-5-21","2","600","Lahore","26-5-21","2","600"},
                {"123","25-05-21","Karachi","Lahore","26-5-21","2","600","Lahore","26-5-21","2","600"}
        };
        String[] columnNames = {"DriverID","Name","License Number","Contact Number","CNIC No.","Address","Status"};

        tableModel=new DefaultTableModel(data,columnNames);
        recTable=new JTable(tableModel);
        recTable.setBounds(240,190,600,300);
        JScrollPane scrollPane=new JScrollPane(recTable);
        scrollPane.setBounds(240,190,600,300);


        setTitle("Manage Driver");
        setLayout(null);
        setSize(900, 650);
        getContentPane().setBackground(Color.darkGray);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);


        add(label);
        add(menuPanel);
        add(cnicSearchLabel);
        add(cnicSearchTxt);
        add(searchButton);
        add(addButton);
        add(removeButton);
        add(editButton);
        add(scrollPane);

    }

    public void addRecord()
    {
        JDialog addDialog = new JDialog(this, "Add New Record", true);
        addDialog.setLayout(null);
        addDialog.getContentPane().setBackground(Color.darkGray);
        addDialog.setSize(500, 500);
        addDialog.setLocationRelativeTo(null);

        JLabel addRecLabel=new JLabel();
        addRecLabel.setText("Add New Record");
        addRecLabel.setFont(new Font("Arial",Font.BOLD,25));
        addRecLabel.setForeground(Color.orange);
        addRecLabel.setBounds(150, 30,240,30);

        JLabel driverIDLabel =new JLabel();
        driverIDLabel.setText("Driver ID:");
        driverIDLabel.setBounds(10,100,150,30);
        driverIDLabel.setFont(new Font("Arial",Font.BOLD,20));
        driverIDLabel.setForeground(Color.orange);

        JTextField driverIDTxt =new JTextField();
        driverIDTxt.setBounds(200,100,150,30);


        JLabel driverNameLabel =new JLabel();
        driverNameLabel.setText("Driver Name:");
        driverNameLabel.setBounds(10,150,180,30);
        driverNameLabel.setFont(new Font("Arial",Font.BOLD,20));
        driverNameLabel.setForeground(Color.orange);

        JTextField driverNameTxt =new JTextField();
        driverNameTxt.setBounds(200,150,150,30);

        JLabel licenseNoLabel=new JLabel();
        licenseNoLabel.setText("License Number:");
        licenseNoLabel.setBounds(10,200,180,30);
        licenseNoLabel.setFont(new Font("Arial",Font.BOLD,20));
        licenseNoLabel.setForeground(Color.orange);

        JTextField licenseNoTxt=new JTextField();
        licenseNoTxt.setBounds(200,200,150,30);

        JLabel contactNoLabel=new JLabel();
        contactNoLabel.setText("Contact Number:");
        contactNoLabel.setBounds(10,250,180,30);
        contactNoLabel.setFont(new Font("Arial",Font.BOLD,20));
        contactNoLabel.setForeground(Color.orange);

        JTextField contactNoTxt=new JTextField();
        contactNoTxt.setBounds(200,250,150,30);

        JLabel cnicNoLabel=new JLabel();
        cnicNoLabel.setText("CNIC Number:");
        cnicNoLabel.setBounds(10,300,180,30);
        cnicNoLabel.setFont(new Font("Arial",Font.BOLD,20));
        cnicNoLabel.setForeground(Color.orange);

        JTextField cnicNoTxt=new JTextField();
        cnicNoTxt.setBounds(200,300,150,30);

        JLabel addressLabel=new JLabel();
        addressLabel.setText("Address:");
        addressLabel.setBounds(10,350,180,30);
        addressLabel.setFont(new Font("Arial",Font.BOLD,20));
        addressLabel.setForeground(Color.orange);

        JTextField addressTxt=new JTextField();
        addressTxt.setBounds(200,350,150,30);

        JButton addButton=new JButton("Add");
        addButton.setBounds(150,400,100,40);
        addButton.setBackground(Color.cyan);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] row={driverIDTxt.getText(), driverNameTxt.getText(),licenseNoTxt.getText(),contactNoTxt.getText(),cnicNoTxt.getText(),addressTxt.getText(),"Active"};

                tableModel.addRow(row);
                addDialog.dispose();
            }
        });

        addDialog.add(addRecLabel);
        addDialog.add(driverIDLabel);
        addDialog.add(driverIDTxt);
        addDialog.add(driverNameLabel);
        addDialog.add(driverNameTxt);
        addDialog.add(licenseNoLabel);
        addDialog.add(licenseNoTxt);
        addDialog.add(contactNoLabel);
        addDialog.add(contactNoTxt);
        addDialog.add(cnicNoLabel);
        addDialog.add(cnicNoTxt);
        addDialog.add(addressLabel);
        addDialog.add(addressTxt);
        addDialog.add(addButton);

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


        JLabel cnicNoLabel=new JLabel();
        cnicNoLabel.setText("CNIC Number:");
        cnicNoLabel.setBounds(10,100,180,30);
        cnicNoLabel.setFont(new Font("Arial",Font.BOLD,20));
        cnicNoLabel.setForeground(Color.orange);

        JTextField cnicNoTxt=new JTextField();
        cnicNoTxt.setBounds(200,100,150,30);

        JButton searchButton=new JButton("Search");
        searchButton.setBounds(130,150,100,30);
        searchButton.setBackground(Color.cyan);
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String val=cnicNoTxt.getText();
                boolean found=false;
                for (int i = 0; i < tableModel.getRowCount(); i++)
                {
                    if (tableModel.getValueAt(i, 4).equals(val))
                    { // Checking CNIC number at index 4
                        tableModel.removeRow(i);
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    JOptionPane.showMessageDialog(removeDialog, "Record with CNIC number " + val + " not found.", "Record Not Found", JOptionPane.WARNING_MESSAGE);
                }
                else {
                    JOptionPane.showMessageDialog(removeDialog, "Record with CNIC number " + val + " removed successfully.", "Record Removed", JOptionPane.INFORMATION_MESSAGE);
                }
            }



        });

        removeDialog.add(addRecLabel);
        removeDialog.add(cnicNoLabel);
        removeDialog.add(cnicNoTxt);
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

        JLabel editRecLabel =new JLabel();
        editRecLabel.setText("Edit Record");
        editRecLabel.setFont(new Font("Arial",Font.BOLD,22));
        editRecLabel.setForeground(Color.orange);
        editRecLabel.setBounds(100, 30,240,30);


        JLabel cnicNoLabel=new JLabel();
        cnicNoLabel.setText("CNIC Number:");
        cnicNoLabel.setBounds(10,100,180,30);
        cnicNoLabel.setFont(new Font("Arial",Font.BOLD,20));
        cnicNoLabel.setForeground(Color.orange);

        JTextField cnicNoTxt=new JTextField();
        cnicNoTxt.setBounds(200,100,150,30);

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
        addressCheckbox.setBounds(295,200,90,30);
        addressCheckbox.setVisible(false);


        JCheckBox statusCheckbox =new JCheckBox("Status");
        statusCheckbox.setBackground( Color.darkGray);
        statusCheckbox.setForeground(Color.orange);
        statusCheckbox.setBounds(380,200,120,30);
        statusCheckbox.setVisible(false);


        JLabel licenseNoLabel=new JLabel();
        licenseNoLabel.setText("License Number:");
        licenseNoLabel.setBounds(10,250,180,30);
        licenseNoLabel.setFont(new Font("Arial",Font.BOLD,20));
        licenseNoLabel.setForeground(Color.orange);
        licenseNoLabel.setVisible(false);

        JTextField licenseNoTxt=new JTextField();
        licenseNoTxt.setBounds(200,250,150,30);
        licenseNoTxt.setVisible(false);

        JLabel contactNoLabel=new JLabel();
        contactNoLabel.setText("Contact Number:");
        contactNoLabel.setBounds(10,300,180,30);
        contactNoLabel.setFont(new Font("Arial",Font.BOLD,20));
        contactNoLabel.setForeground(Color.orange);
        contactNoLabel.setVisible(false);

        JTextField contactNoTxt=new JTextField();
        contactNoTxt.setBounds(200,300,150,30);
        contactNoTxt.setVisible(false);


        JLabel addressLabel=new JLabel();
        addressLabel.setText("Address:");
        addressLabel.setBounds(10,350,180,30);
        addressLabel.setFont(new Font("Arial",Font.BOLD,20));
        addressLabel.setForeground(Color.orange);
        addressLabel.setVisible(false);

        JTextField addressTxt=new JTextField();
        addressTxt.setBounds(200,350,150,30);
        addressTxt.setVisible(false);

        JLabel statusLabel=new JLabel();
        statusLabel.setText("Select Status:");
        statusLabel.setBounds(10,400,180,30);
        statusLabel.setFont(new Font("Arial",Font.BOLD,20));
        statusLabel.setForeground(Color.orange);
        statusLabel.setVisible(false);

        String[] stat={"-","Active","Not Active"};

        JComboBox statusCombobox=new JComboBox<>(stat);
        statusCombobox.setBounds(200,400,150,35);
        statusCombobox.setBackground(Color.orange);
        statusCombobox.setVisible(false);


        JButton searchButton=new JButton("Search");
        searchButton.setBounds(130,150,100,30);
        searchButton.setBackground(Color.cyan);
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String val=cnicNoTxt.getText();
                boolean found=false;
                for (int i = 0; i < tableModel.getRowCount(); i++)
                {
                    if (tableModel.getValueAt(i, 4).equals(val))
                    {
                        addressCheckbox.setVisible(true);
                        licenseCheckbox.setVisible(true);
                        contactNoCheckbox.setVisible(true);
                        statusCheckbox.setVisible(true);

                        found = true;
                        break;
                    }
                }
                if (!found)
                {
                    JOptionPane.showMessageDialog(editDialog, "Record with CNIC number " + val + " not found.", "Record Not Found", JOptionPane.WARNING_MESSAGE);
                }
            }
        });


        JButton editButton=new JButton("Edit");
        editButton.setBounds(130,450,100,30);
        editButton.setBackground(Color.cyan);
        editButton.setVisible(false);

        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String val=cnicNoTxt.getText();
                for (int i = 0; i < tableModel.getRowCount(); i++)
                {
                    if (tableModel.getValueAt(i, 4).equals(val))
                    {
                        String lic=licenseNoTxt.getText();
                        String contact=contactNoTxt.getText();
                        String add=addressTxt.getText();
                        String status=(String)statusCombobox.getSelectedItem();
                        if(addressCheckbox.isSelected())
                        {
                            recTable.setValueAt(add, i, 5); // Update Address


                        }
                        if(contactNoCheckbox.isSelected())
                        {
                            recTable.setValueAt(contact, i, 3); // Update Contact Number
                        }
                        if(licenseCheckbox.isSelected())
                        {
                            recTable.setValueAt(lic, i, 2); // Update License Number
                        }
                        if(statusCheckbox.isSelected())
                        {
                            recTable.setValueAt(status, i, 6); // Update Status
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


        editDialog.add(editRecLabel);
        editDialog.add(cnicNoLabel);
        editDialog.add(cnicNoTxt);
        editDialog.add(searchButton);
        editDialog.add(addressCheckbox);
        editDialog.add(licenseCheckbox);
        editDialog.add(contactNoCheckbox);
        editDialog.add(statusCheckbox);
        editDialog.add(licenseNoLabel);
        editDialog.add(licenseNoTxt);
        editDialog.add(contactNoLabel);
        editDialog.add(contactNoTxt);
        editDialog.add(addressLabel);
        editDialog.add(addressTxt);
        editDialog.add(statusLabel);
        editDialog.add(statusCombobox);
        editDialog.add(editButton);


        editDialog.setResizable(false);
        editDialog.setVisible(true);


    }

    public static void main(String[] args)
    {
        ManageDriverPage mg=new ManageDriverPage();
    }
}
