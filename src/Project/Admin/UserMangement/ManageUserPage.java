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


        //StringBuilder userDetails = new StringBuilder();

        try{
            String query = "SELECT * FROM Dummy1";
            Connection connection = Database.setConnection();


            String insertQuery = "INSERT INTO dummy1 (Name) VALUES ( ?)";
            PreparedStatement pstmt = connection.prepareStatement(insertQuery);
            pstmt.setString(1, "Hi");
            pstmt.executeUpdate();

            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                /*
                int customerId = resultSet.getInt("CustomerID");

                String firstName = resultSet.getString("FirstName");
                String lastName = resultSet.getString("LastName");
                String phoneNumber = resultSet.getString("PhoneNumber");
                String email = resultSet.getString("Email");


                 */
                // Append user details to the StringBuilder
               /* userDetails.append("Customer ID: ").append(customerId).append("\n")
                        .append("First Name: ").append(firstName).append("\n")
                        .append("Last Name: ").append(lastName).append("\n")
                        .append("Phone Number: ").append(phoneNumber).append("\n")
                        .append("Email: ").append(email).append("\n")
                        .append("----------------------------\n");

                */




                int SerialNo = resultSet.getInt("ID");
                String Name = resultSet.getString("Name");
                System.out.println(SerialNo+" "+Name);
            }
        } catch (SQLException e) {
            
            throw new RuntimeException(e);
        }





        String[][] data={ {"1","A","B","0312345687912","123456789012345","abc123aba45@gmail.com","31/12/2022","Malam Jabba","jhkaifjlkafjakfjalkjflkajflkjalkjfalkj","abc123av245","22/12/2024","Enable"}


        };

        String[]column={"Customer ID","First Name","Last Name","Phone No","CNIC/ Passport","Email","Date of Birth","City","Address","Password","Last Seen","Account Active"};

        tableModel=new DefaultTableModel(data,column);
        recTable=new JTable(tableModel);
        recTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF); // This ensures horizontal

        recTable.getColumnModel().getColumn(1).setPreferredWidth(100);
        recTable.getColumnModel().getColumn(2).setPreferredWidth(100);
        recTable.getColumnModel().getColumn(3).setPreferredWidth(110);
        recTable.getColumnModel().getColumn(4).setPreferredWidth(130);
        recTable.getColumnModel().getColumn(5).setPreferredWidth(170);
        recTable.getColumnModel().getColumn(6).setPreferredWidth(100);
        recTable.getColumnModel().getColumn(7).setPreferredWidth(110);
        recTable.getColumnModel().getColumn(8).setPreferredWidth(180);
        recTable.getColumnModel().getColumn(9).setPreferredWidth(120);
        recTable.getColumnModel().getColumn(10).setPreferredWidth(120);
        recTable.getColumnModel().getColumn(11).setPreferredWidth(130);

        JScrollPane scrollPane=new JScrollPane(recTable);
        scrollPane.setBounds(1,1,600,350);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
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
                    { // Checking Reg number at index 4 & Bus ID at index 0
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
        inputPanel.setPreferredSize(new Dimension(460, 750));

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

        JCheckBox phoneNoCheckbox =new JCheckBox("Phone Number");
        phoneNoCheckbox.setBackground( Color.darkGray);
        phoneNoCheckbox.setForeground(Color.orange);
        phoneNoCheckbox.setBounds(30,200,110,30);
        phoneNoCheckbox.setVisible(false);


        JCheckBox cnicCheckbox =new JCheckBox("CNIC/Passport");
        cnicCheckbox.setBackground( Color.darkGray);
        cnicCheckbox.setForeground(Color.orange);
        cnicCheckbox.setBounds(150,200,110,30);
        cnicCheckbox.setVisible(false);

        JCheckBox emailCheckbox =new JCheckBox("Email");
        emailCheckbox.setBackground( Color.darkGray);
        emailCheckbox.setForeground(Color.orange);
        emailCheckbox.setBounds(270,200,60,30);
        emailCheckbox.setVisible(false);


        JCheckBox dobCheckbox =new JCheckBox("Date of Birth");
        dobCheckbox.setBackground( Color.darkGray);
        dobCheckbox.setForeground(Color.orange);
        dobCheckbox.setBounds(340,200,100,30);
        dobCheckbox.setVisible(false);

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

        JCheckBox accountActiveCheckbox =new JCheckBox("Account Activity");
        accountActiveCheckbox.setBackground( Color.darkGray);
        accountActiveCheckbox.setForeground(Color.orange);
        accountActiveCheckbox.setBounds(270,230,160,30);
        accountActiveCheckbox.setVisible(false);

        JLabel phoneNoLabel=new JLabel("Phone Number:");
        phoneNoLabel.setBounds(10,280,180,30);
        phoneNoLabel.setForeground(Color.orange);
        phoneNoLabel.setFont(new Font("Arial",Font.BOLD,20));
        phoneNoLabel.setVisible(false);

        JTextField phoneNoTxt=new JTextField();
        phoneNoTxt.setBounds(200,280,150,30);
        phoneNoTxt.setVisible(false);

        JLabel cnicLabel=new JLabel("CNIC/Passport:");
        cnicLabel.setBounds(10,330,180,30);
        cnicLabel.setForeground(Color.orange);
        cnicLabel.setFont(new Font("Arial",Font.BOLD,20));
        cnicLabel.setVisible(false);

        JTextField cnicTxt=new JTextField();
        cnicTxt.setBounds(200,330,150,30);
        cnicTxt.setVisible(false);

        JLabel emailLabel=new JLabel("Email:");
        emailLabel.setBounds(10,380,180,30);
        emailLabel.setForeground(Color.orange);
        emailLabel.setFont(new Font("Arial",Font.BOLD,20));
        emailLabel.setVisible(false);

        JTextField emailTxt=new JTextField();
        emailTxt.setBounds(200,380,150,30);
        emailTxt.setVisible(false);

        JLabel dobLabel=new JLabel("Date of Birth:");
        dobLabel.setBounds(10,430,180,30);
        dobLabel.setForeground(Color.orange);
        dobLabel.setFont(new Font("Arial",Font.BOLD,20));
        dobLabel.setVisible(false);

        JLabel dobDayLabel=new JLabel("(Day)");
        dobDayLabel.setBounds(200,455,50,30);
        dobDayLabel.setForeground(Color.orange);
        dobDayLabel.setFont(new Font("Arial",Font.BOLD,11));
        dobDayLabel.setVisible(false);

        JTextField dobDayTxt=new JTextField();
        dobDayTxt.setBounds(200,430,40,30);
        dobDayTxt.setVisible(false);

        JLabel dobMonLabel=new JLabel("(Month)");
        dobMonLabel.setBounds(260,455,50,30);
        dobMonLabel.setForeground(Color.orange);
        dobMonLabel.setFont(new Font("Arial",Font.BOLD,11));
        dobMonLabel.setVisible(false);

        JTextField dobMonTxt=new JTextField();
        dobMonTxt.setBounds(260,430,40,30);
        dobMonTxt.setVisible(false);

        JLabel dobYearLabel=new JLabel("(Year)");
        dobYearLabel.setBounds(320,455,50,30);
        dobYearLabel.setForeground(Color.orange);
        dobYearLabel.setFont(new Font("Arial",Font.BOLD,11));
        dobYearLabel.setVisible(false);

        JTextField dobYearTxt=new JTextField();
        dobYearTxt.setBounds(320,430,40,30);
        dobYearTxt.setVisible(false);


        JLabel cityLabel=new JLabel("City:");
        cityLabel.setBounds(10,490,180,30);
        cityLabel.setForeground(Color.orange);
        cityLabel.setFont(new Font("Arial",Font.BOLD,20));
        cityLabel.setVisible(false);

        JTextField cityTxt=new JTextField();
        cityTxt.setBounds(200,490,150,30);
        cityTxt.setVisible(false);

        JLabel accountActiveLabel =new JLabel("Account Activity:");
        accountActiveLabel.setBounds(10,540,180,30);
        accountActiveLabel.setFont(new Font("Arial",Font.BOLD,15));
        accountActiveLabel.setForeground(Color.orange);
        accountActiveLabel.setVisible(false);

        JRadioButton enRadio=new JRadioButton("Enable");
        JRadioButton disRadio=new JRadioButton("Disable");

        enRadio.setBounds(200,540,80,30);
        disRadio.setBounds(290,540,80,30);

        enRadio.setVisible(false);
        disRadio.setVisible(false);

        ButtonGroup group =new ButtonGroup();
        group.add(enRadio);
        group.add(disRadio);

        JLabel addressLabel=new JLabel("Address:");
        addressLabel.setBounds(10,580,180,30);
        addressLabel.setForeground(Color.orange);
        addressLabel.setFont(new Font("Arial",Font.BOLD,20));
        addressLabel.setVisible(false);

        JTextArea addressTxt=new JTextArea();
        addressTxt.setBounds(200,580,150,90);
        addressTxt.setVisible(false);



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
                        phoneNoCheckbox.setVisible(true);
                        cnicCheckbox.setVisible(true);
                        emailCheckbox.setVisible(true);
                        dobCheckbox.setVisible(true);
                        cityCheckbox.setVisible(true);
                        addressCheckbox.setVisible(true);
                        accountActiveCheckbox.setVisible(true);


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


        JButton editButton=new JButton("Edit");
        editButton.setBounds(130,680,100,30);
        editButton.setBackground(Color.cyan);
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String IDVal= customerIDTxt.getText();
                boolean found=false;
                String phoneNo=phoneNoTxt.getText();
                String cnic=cnicTxt.getText();
                String email=emailTxt.getText();
                String dob=dobDayTxt.getText()+"/"+dobMonTxt.getText()+"/"+dobYearTxt.getText();
                String city=cityTxt.getText();
                String address=addressTxt.getText();
                String en=enRadio.getText();
                String dis=disRadio.getText();

                for(int i=0;i< tableModel.getRowCount();i++)
                {
                    if(recTable.getValueAt(i,0).equals(IDVal))
                    {
                        if(phoneNoCheckbox.isSelected())
                        {
                            recTable.setValueAt(phoneNo,i,3);

                        }
                        if(cnicCheckbox.isSelected())
                        {
                            recTable.setValueAt(cnic,i,4);
                        }
                        if(emailCheckbox.isSelected())
                        {
                            recTable.setValueAt(email,i,5);
                        }
                        if(dobCheckbox.isSelected())
                        {
                            recTable.setValueAt(dob,i,6);
                        }
                        if(cityCheckbox.isSelected())
                        {
                            recTable.setValueAt(city,i,7);
                        }
                        if(addressCheckbox.isSelected())
                        {
                            recTable.setValueAt(address,i,8);

                        }
                        if(accountActiveCheckbox.isSelected())
                        {
                            if(enRadio.isSelected())
                            {
                                recTable.setValueAt(en,i,11);
                            }
                            else if(disRadio.isSelected())
                            {
                                recTable.setValueAt(dis,i,11);
                            }

                        }

                        editDialog.dispose();
                        break;

                    }
                }
            }
        });

        phoneNoCheckbox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (phoneNoCheckbox.isSelected())
                {
                    phoneNoLabel.setVisible(true);
                    phoneNoTxt.setVisible(true);
                }
                else {
                    phoneNoLabel.setVisible(false);
                    phoneNoTxt.setVisible(false);
                }
            }
        });

        cnicCheckbox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(cnicCheckbox.isSelected())
                {
                    cnicLabel.setVisible(true);
                    cnicTxt.setVisible(true);
                }
                else{
                    cnicLabel.setVisible(false);
                    cnicTxt.setVisible(false);
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
        dobCheckbox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(dobCheckbox.isSelected())
                {
                    dobLabel.setVisible(true);
                    dobDayLabel.setVisible(true);
                    dobDayTxt.setVisible(true);
                    dobMonLabel.setVisible(true);
                    dobMonTxt.setVisible(true);
                    dobYearLabel.setVisible(true);
                    dobYearTxt.setVisible(true);
                }
                else{
                    dobLabel.setVisible(false);
                    dobDayLabel.setVisible(false);
                    dobDayTxt.setVisible(false);
                    dobMonLabel.setVisible(false);
                    dobMonTxt.setVisible(false);
                    dobYearLabel.setVisible(false);
                    dobYearTxt.setVisible(false);
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

        accountActiveCheckbox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(accountActiveCheckbox.isSelected())
                {
                    accountActiveLabel.setVisible(true);
                    enRadio.setVisible(true);
                    disRadio.setVisible(true);
                }
                else{
                    accountActiveLabel.setVisible(false);
                    enRadio.setVisible(false);
                    disRadio.setVisible(false);
                }
            }
        });



        inputPanel.add(editRecLabel);
        inputPanel.add(customerIDLabel);
        inputPanel.add(customerIDTxt);
        inputPanel.add(searchButton);
        inputPanel.add(phoneNoCheckbox);
        inputPanel.add(cnicCheckbox);
        inputPanel.add(emailCheckbox);
        inputPanel.add(dobCheckbox);
        inputPanel.add(cityCheckbox);
        inputPanel.add(addressCheckbox);
        inputPanel.add(accountActiveCheckbox);
        inputPanel.add(phoneNoLabel);
        inputPanel.add(phoneNoTxt);
        inputPanel.add(cnicLabel);
        inputPanel.add(cnicTxt);
        inputPanel.add(emailLabel);
        inputPanel.add(emailTxt);
        inputPanel.add(dobLabel);
        inputPanel.add(cityLabel);
        inputPanel.add(cityTxt);
        inputPanel.add(addressLabel);
        inputPanel.add(addressTxt);
        inputPanel.add(accountActiveLabel);
        inputPanel.add(enRadio);
        inputPanel.add(disRadio);
        inputPanel.add(editButton);
        inputPanel.add(dobDayLabel);
        inputPanel.add(dobDayTxt);
        inputPanel.add(dobMonLabel);
        inputPanel.add(dobMonTxt);
        inputPanel.add(dobYearLabel);
        inputPanel.add(dobYearTxt);

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
