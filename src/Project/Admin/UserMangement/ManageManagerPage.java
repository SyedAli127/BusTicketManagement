
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

public class ManageManagerPage extends JFrame{

    DefaultTableModel tableModel;
    JTable recTable;
    Connection connection= Database.setConnection();
    public ManageManagerPage() {
        JLabel label=new JLabel();
        label.setText("Manage Manager");
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

        JLabel managerIDLabel =new JLabel();
        managerIDLabel.setText("Manager ID:");
        managerIDLabel.setBounds(240,80,150,50);
        managerIDLabel.setFont(new Font("Arial",Font.BOLD,15));
        managerIDLabel.setForeground(Color.orange);

        JTextField managerIDSearchTxt =new JTextField();
        managerIDSearchTxt.setBounds(400,90,150,30);

        JButton searchButton=new JButton("Search");
        searchButton.setBounds(570,90,100,30);
        searchButton.setBackground(Color.cyan);
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String val= managerIDSearchTxt.getText();
                boolean found=false;
                String query="select * from Manager where ManagerID=?";
                try {
                    PreparedStatement psmt=connection.prepareStatement(query);
                    psmt.setInt(1,Integer.parseInt(val));
                    ResultSet rs=psmt.executeQuery();
                    while (rs.next())
                    {
                        int managerID = rs.getInt("ManagerID");
                        String firstName = rs.getString("FirstName");
                        String lastName = rs.getString("LastName");
                        String dob = rs.getString("DOB");
                        String cnicNumber = rs.getString("CNIC");
                        String email = rs.getString("Email");
                        String contactNumber = rs.getString("ContactNo");
                        String city = rs.getString("City");
                        String address = rs.getString("Address");
                        String joiningDate = rs.getString("JoinDate");
                        String password = rs.getString("Password");
                        int salary = rs.getInt("Salary");
                        String accountStatus = rs.getString("AccountStatus");

                        String[] row = {Integer.toString(managerID), firstName, lastName, dob, cnicNumber,email,
                                contactNumber, city, address, joiningDate,password,Integer.toString(salary), accountStatus};
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
                    JOptionPane.showMessageDialog(null, "Record with Manager ID " + val + " not found.", "Record Not Found", JOptionPane.WARNING_MESSAGE);
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

        String[] columnNames = {"Manager ID","First Name","Last Name","Date of Birth","CNIC Number","Email","Contact Number","City","Address",
                "Joining Date","Password","Salary","Account Status"};


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
        recTable.getColumnModel().getColumn(11).setPreferredWidth(100);
        recTable.getColumnModel().getColumn(12).setPreferredWidth(100);

        String query="Select * from Manager order by ManagerID";
        try
        {
            PreparedStatement psmt=connection.prepareStatement(query);
            ResultSet rs=psmt.executeQuery();
            while (rs.next()) {
                int managerID = rs.getInt("ManagerID");
                String firstName = rs.getString("FirstName");
                String lastName = rs.getString("LastName");
                String dob = rs.getString("DOB");
                String cnicNumber = rs.getString("CNIC");
                String email = rs.getString("Email");
                String contactNumber = rs.getString("ContactNo");
                String city = rs.getString("City");
                String address = rs.getString("Address");
                String joiningDate = rs.getString("JoinDate");
                String password = rs.getString("Password");
                int salary = rs.getInt("Salary");
                String accountStatus = rs.getString("AccountStatus");

                String[] row = {Integer.toString(managerID), firstName, lastName, dob, cnicNumber,email,
                        contactNumber, city, address, joiningDate,password,Integer.toString(salary), accountStatus};
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

        setTitle("Manage Manager Page");
        setLayout(null);
        setSize(900, 650);
        getContentPane().setBackground(Color.darkGray);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);


        add(label);
        add(menuPanel);
        add(managerIDLabel);
        add(managerIDSearchTxt);
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
        inputPanel.setPreferredSize(new Dimension(480, 760));

        JLabel addRecLabel=new JLabel();
        addRecLabel.setText("Add New Record");
        addRecLabel.setFont(new Font("Arial",Font.BOLD,25));
        addRecLabel.setForeground(Color.orange);
        addRecLabel.setBounds(150, 30,240,30);

        JLabel firstNameLabel =new JLabel();
        firstNameLabel.setText("First Name:");
        firstNameLabel.setBounds(10,100,180,30);
        firstNameLabel.setFont(new Font("Arial",Font.BOLD,20));
        firstNameLabel.setForeground(Color.orange);

        JTextField firstNameTxt =new JTextField();
        firstNameTxt.setBounds(200,100,150,30);

        JLabel lastNameLabel =new JLabel();
        lastNameLabel.setText("Last Name:");
        lastNameLabel.setBounds(10,150,180,30);
        lastNameLabel.setFont(new Font("Arial",Font.BOLD,20));
        lastNameLabel.setForeground(Color.orange);

        JTextField lastNameTxt =new JTextField();
        lastNameTxt.setBounds(200,150,150,30);

        JLabel dobLabel =new JLabel();
        dobLabel.setText("Date of Birth:");
        dobLabel.setBounds(10,200,180,30);
        dobLabel.setFont(new Font("Arial",Font.BOLD,20));
        dobLabel.setForeground(Color.orange);

        JLabel dobDayLabel =new JLabel("(Day)");
        dobDayLabel.setBounds(200,235,50,30);
        dobDayLabel.setForeground(Color.orange);
        dobDayLabel.setFont(new Font("Arial",Font.BOLD,11));

        JTextField dobDayTxt =new JTextField();
        dobDayTxt.setBounds(200,200,40,30);

        JLabel dobMonLabel =new JLabel("(Month)");
        dobMonLabel.setBounds(250,235,50,30);
        dobMonLabel.setForeground(Color.orange);
        dobMonLabel.setFont(new Font("Arial",Font.BOLD,11));

        JTextField dobMonTxt =new JTextField();
        dobMonTxt.setBounds(250,200,40,30);

        JLabel dobYearLabel =new JLabel("(Year)");
        dobYearLabel.setBounds(300,235,50,30);
        dobYearLabel.setForeground(Color.orange);
        dobYearLabel.setFont(new Font("Arial",Font.BOLD,11));

        JTextField dobYearTxt =new JTextField();
        dobYearTxt.setBounds(300,200,40,30);

        JLabel cnicNoLabel=new JLabel();
        cnicNoLabel.setText("CNIC Number:");
        cnicNoLabel.setBounds(10,270,180,30);
        cnicNoLabel.setFont(new Font("Arial",Font.BOLD,20));
        cnicNoLabel.setForeground(Color.orange);

        JTextField cnicNoTxt=new JTextField();
        cnicNoTxt.setBounds(200,270,150,30);

        JLabel emailLabel=new JLabel();
        emailLabel.setText("Email:");
        emailLabel.setBounds(10,320,180,30);
        emailLabel.setFont(new Font("Arial",Font.BOLD,20));
        emailLabel.setForeground(Color.orange);

        JTextField emailTxt=new JTextField();
        emailTxt.setBounds(200,320,150,30);

        JLabel contactNoLabel =new JLabel();
        contactNoLabel.setText("Contact Number:");
        contactNoLabel.setBounds(10,370,180,30);
        contactNoLabel.setFont(new Font("Arial",Font.BOLD,20));
        contactNoLabel.setForeground(Color.orange);

        JTextField contactNoTxt=new JTextField();
        contactNoTxt.setBounds(200,370,150,30);

        JLabel cityLabel =new JLabel();
        cityLabel.setText("City:");
        cityLabel.setBounds(10,420,180,30);
        cityLabel.setFont(new Font("Arial",Font.BOLD,20));
        cityLabel.setForeground(Color.orange);

        JTextField cityTxt =new JTextField();
        cityTxt.setBounds(200,420,150,30);

        JLabel addressLabel =new JLabel();
        addressLabel.setText("Address:");
        addressLabel.setBounds(10,470,180,30);
        addressLabel.setFont(new Font("Arial",Font.BOLD,20));
        addressLabel.setForeground(Color.orange);

        JTextField addressTxt =new JTextField();
        addressTxt.setBounds(200,470,150,30);

        JLabel joinDateLabel =new JLabel();
        joinDateLabel.setText("Joining Date:");
        joinDateLabel.setBounds(10,520,180,30);
        joinDateLabel.setFont(new Font("Arial",Font.BOLD,20));
        joinDateLabel.setForeground(Color.orange);

        JLabel joinDateDayLabel =new JLabel("(Day)");
        joinDateDayLabel.setBounds(200,555,50,30);
        joinDateDayLabel.setForeground(Color.orange);
        joinDateDayLabel.setFont(new Font("Arial",Font.BOLD,11));

        JTextField joinDateDayTxt =new JTextField();
        joinDateDayTxt.setBounds(200,520,40,30);

        JLabel joinDateMonLabel =new JLabel("(Month)");
        joinDateMonLabel.setBounds(250,555,50,30);
        joinDateMonLabel.setForeground(Color.orange);
        joinDateMonLabel.setFont(new Font("Arial",Font.BOLD,11));

        JTextField joinDateMonTxt =new JTextField();
        joinDateMonTxt.setBounds(250,520,40,30);

        JLabel joinDateYearLabel =new JLabel("(Year)");
        joinDateYearLabel.setBounds(300,555,50,30);
        joinDateYearLabel.setForeground(Color.orange);
        joinDateYearLabel.setFont(new Font("Arial",Font.BOLD,11));

        JTextField joinDateYearTxt =new JTextField();
        joinDateYearTxt.setBounds(300,520,40,30);

        JLabel passwordLabel =new JLabel();
        passwordLabel.setText("Password:");
        passwordLabel.setBounds(10,590,180,30);
        passwordLabel.setFont(new Font("Arial",Font.BOLD,20));
        passwordLabel.setForeground(Color.orange);

        JTextField passwordTxt =new JTextField();
        passwordTxt.setBounds(200,590,150,30);

        JLabel salaryLabel =new JLabel();
        salaryLabel.setText("Salary:");
        salaryLabel.setBounds(10,640,180,30);
        salaryLabel.setFont(new Font("Arial",Font.BOLD,20));
        salaryLabel.setForeground(Color.orange);

        JTextField salaryTxt =new JTextField();
        salaryTxt.setBounds(200,640,150,30);

        JButton addButton=new JButton("Add");
        addButton.setBounds(150,690,100,40);
        addButton.setBackground(Color.cyan);
        addButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                int id,maxVal=0;
                String dob=dobYearTxt.getText()+"-"+dobMonTxt.getText()+"-"+dobDayTxt.getText();
                String joinDate=joinDateYearTxt.getText()+"-"+joinDateMonTxt.getText()+"-"+joinDateDayTxt.getText();
                String insertQuery="insert into Manager(FirstName,LastName,DOB,CNIC,Email,ContactNo,City,Address,JoinDate,Password,Salary,AccountStatus)values(?,?,?,?,?,?,?,?,?,?,?,?)";
                try
                {
                    PreparedStatement psmt=connection.prepareStatement(insertQuery);

                    psmt.setString(1,firstNameTxt.getText());
                    psmt.setString(2,lastNameTxt.getText());
                    psmt.setString(3,dob);
                    psmt.setString(4,cnicNoTxt.getText());
                    psmt.setString(5,emailTxt.getText());
                    psmt.setString(6,contactNoTxt.getText());
                    psmt.setString(7, cityTxt.getText());
                    psmt.setString(8,addressTxt.getText());
                    psmt.setString(9,joinDate);
                    psmt.setString(10,passwordTxt.getText());
                    psmt.setInt(11,Integer.parseInt(salaryTxt.getText()));
                    psmt.setString(12,"Active");
                    psmt.executeUpdate();

                    String query="Select ManagerID from Manager ";
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

                String[] row={Integer.toString(maxVal),firstNameTxt.getText(), lastNameTxt.getText(),
                        dob,cnicNoTxt.getText(),emailTxt.getText(),contactNoTxt.getText(),
                        cityTxt.getText(),addressTxt.getText(),joinDate,passwordTxt.getText(),salaryTxt.getText(),"Active"};

                tableModel.addRow(row);
                addDialog.dispose();
            }
        });

        inputPanel.add(addRecLabel);
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
        inputPanel.add(emailLabel);
        inputPanel.add(emailTxt);
        inputPanel.add(cityLabel);
        inputPanel.add(cityTxt);
        inputPanel.add(addressLabel);
        inputPanel.add(addressTxt);

        inputPanel.add(joinDateLabel);
        inputPanel.add(joinDateDayLabel);
        inputPanel.add(joinDateDayTxt);
        inputPanel.add(joinDateMonLabel);
        inputPanel.add(joinDateMonTxt);
        inputPanel.add(joinDateYearLabel);
        inputPanel.add(joinDateYearTxt);

        inputPanel.add(passwordLabel);
        inputPanel.add(passwordTxt);
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


        JLabel managerIDLabel =new JLabel();
        managerIDLabel.setText("Manager ID:");
        managerIDLabel.setBounds(10,100,180,30);
        managerIDLabel.setFont(new Font("Arial",Font.BOLD,20));
        managerIDLabel.setForeground(Color.orange);

        JTextField managerIDTxt =new JTextField();
        managerIDTxt.setBounds(200,100,150,30);

        JButton searchButton=new JButton("Search");
        searchButton.setBounds(130,150,100,30);
        searchButton.setBackground(Color.cyan);
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String val= managerIDTxt.getText();
                boolean found=false;
                for (int i = 0; i < tableModel.getRowCount(); i++)
                {
                    if (tableModel.getValueAt(i, 0).equals(val))
                    {
                        String delQuery="Delete from Manager where ManagerID=?";
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
                    JOptionPane.showMessageDialog(removeDialog, "Record with Manager ID " + val + " not found.", "Record Not Found", JOptionPane.WARNING_MESSAGE);
                }
                else {
                    JOptionPane.showMessageDialog(removeDialog, "Record with Manager ID " + val + " removed successfully.", "Record Removed", JOptionPane.INFORMATION_MESSAGE);
                }
            }



        });

        removeDialog.add(addRecLabel);
        removeDialog.add(managerIDLabel);
        removeDialog.add(managerIDTxt);
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
        inputPanel.setPreferredSize(new Dimension(480, 700));

        JLabel editRecLabel =new JLabel();
        editRecLabel.setText("Edit Record");
        editRecLabel.setFont(new Font("Arial",Font.BOLD,22));
        editRecLabel.setForeground(Color.orange);
        editRecLabel.setBounds(150, 30,240,30);


        JLabel managerIDLabel =new JLabel();
        managerIDLabel.setText("Manager ID:");
        managerIDLabel.setBounds(50,100,180,30);
        managerIDLabel.setFont(new Font("Arial",Font.BOLD,20));
        managerIDLabel.setForeground(Color.orange);

        JTextField managerIDTxt =new JTextField();
        managerIDTxt.setBounds(200,100,150,30);

        JCheckBox emailCheckbox =new JCheckBox("Email");
        emailCheckbox.setBackground( Color.darkGray);
        emailCheckbox.setForeground(Color.orange);
        emailCheckbox.setBounds(40,200,60,30);
        emailCheckbox.setVisible(false);

        JCheckBox cityCheckbox =new JCheckBox("City");
        cityCheckbox.setBackground( Color.darkGray);
        cityCheckbox.setForeground(Color.orange);
        cityCheckbox.setBounds(130,200,50,30);
        cityCheckbox.setVisible(false);

        JCheckBox contactNoCheckbox =new JCheckBox("Contact Number");
        contactNoCheckbox.setBackground( Color.darkGray);
        contactNoCheckbox.setForeground(Color.orange);
        contactNoCheckbox.setBounds(230,200,120,30);
        contactNoCheckbox.setVisible(false);

        JCheckBox addressCheckbox =new JCheckBox("Address");
        addressCheckbox.setBackground( Color.darkGray);
        addressCheckbox.setForeground(Color.orange);
        addressCheckbox.setBounds(350,200,90,30);
        addressCheckbox.setVisible(false);

        JCheckBox salaryCheckbox =new JCheckBox("Salary");
        salaryCheckbox.setBackground( Color.darkGray);
        salaryCheckbox.setForeground(Color.orange);
        salaryCheckbox.setBounds(40,235,90,30);
        salaryCheckbox.setVisible(false);


        JCheckBox passwordCheckbox =new JCheckBox("Password");
        passwordCheckbox.setBackground( Color.darkGray);
        passwordCheckbox.setForeground(Color.orange);
        passwordCheckbox.setBounds(130,235,90,30);
        passwordCheckbox.setVisible(false);

        JCheckBox statusCheckbox =new JCheckBox("Account Status");
        statusCheckbox.setBackground( Color.darkGray);
        statusCheckbox.setForeground(Color.orange);
        statusCheckbox.setBounds(230,235,120,30);
        statusCheckbox.setVisible(false);




        JLabel emailLabel =new JLabel();
        emailLabel.setText("Email:");
        emailLabel.setBounds(10,290,180,30);
        emailLabel.setFont(new Font("Arial",Font.BOLD,20));
        emailLabel.setForeground(Color.orange);
        emailLabel.setVisible(false);

        JTextField emailTxt =new JTextField();
        emailTxt.setBounds(200,290,150,30);
        emailTxt.setVisible(false);

        JLabel cityLabel =new JLabel();
        cityLabel.setText("City:");
        cityLabel.setBounds(10,340,180,30);
        cityLabel.setFont(new Font("Arial",Font.BOLD,20));
        cityLabel.setForeground(Color.orange);
        cityLabel.setVisible(false);

        JTextField cityTxt =new JTextField();
        cityTxt.setBounds(200,340,150,30);
        cityTxt.setVisible(false);

        JLabel contactNoLabel=new JLabel();
        contactNoLabel.setText("Contact Number:");
        contactNoLabel.setBounds(10,390,180,30);
        contactNoLabel.setFont(new Font("Arial",Font.BOLD,20));
        contactNoLabel.setForeground(Color.orange);
        contactNoLabel.setVisible(false);

        JTextField contactNoTxt=new JTextField();
        contactNoTxt.setBounds(200,390,150,30);
        contactNoTxt.setVisible(false);


        JLabel addressLabel=new JLabel();
        addressLabel.setText("Address:");
        addressLabel.setBounds(10,440,180,30);
        addressLabel.setFont(new Font("Arial",Font.BOLD,20));
        addressLabel.setForeground(Color.orange);
        addressLabel.setVisible(false);

        JTextField addressTxt=new JTextField();
        addressTxt.setBounds(200,440,150,30);
        addressTxt.setVisible(false);

        JLabel salaryLabel=new JLabel();
        salaryLabel.setText("Salary:");
        salaryLabel.setBounds(10,490,180,30);
        salaryLabel.setFont(new Font("Arial",Font.BOLD,20));
        salaryLabel.setForeground(Color.orange);
        salaryLabel.setVisible(false);

        JTextField salaryTxt=new JTextField();
        salaryTxt.setBounds(200,490,150,30);
        salaryTxt.setVisible(false);

        JLabel passwordLabel=new JLabel();
        passwordLabel.setText("Password:");
        passwordLabel.setBounds(10,540,180,30);
        passwordLabel.setFont(new Font("Arial",Font.BOLD,20));
        passwordLabel.setForeground(Color.orange);
        passwordLabel.setVisible(false);

        JTextField passwordTxt=new JTextField();
        passwordTxt.setBounds(200,540,150,30);
        passwordTxt.setVisible(false);


        JLabel statusLabel=new JLabel();
        statusLabel.setText("Select Status:");
        statusLabel.setBounds(10,590,180,30);
        statusLabel.setFont(new Font("Arial",Font.BOLD,20));
        statusLabel.setForeground(Color.orange);
        statusLabel.setVisible(false);

        String[] stat={"-","Active","Not Active"};

        JComboBox statusCombobox=new JComboBox<>(stat);
        statusCombobox.setBounds(200,590,150,35);
        statusCombobox.setBackground(Color.orange);
        statusCombobox.setVisible(false);


        JButton searchButton=new JButton("Search");
        searchButton.setBounds(130,150,100,30);
        searchButton.setBackground(Color.cyan);
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String val= managerIDTxt.getText();
                boolean found=false;
                for (int i = 0; i < tableModel.getRowCount(); i++)
                {
                    if (tableModel.getValueAt(i, 0).equals(val))
                    {
                        addressCheckbox.setVisible(true);
                        emailCheckbox.setVisible(true);
                        contactNoCheckbox.setVisible(true);
                        salaryCheckbox.setVisible(true);
                        statusCheckbox.setVisible(true);
                        passwordCheckbox.setVisible(true);
                        cityCheckbox.setVisible(true);

                        found = true;
                        break;
                    }
                }
                if (!found)
                {
                    JOptionPane.showMessageDialog(editDialog, "Record with Manager ID " + val + " not found.", "Record Not Found", JOptionPane.WARNING_MESSAGE);
                }
            }
        });


        JButton editButton=new JButton("Edit");
        editButton.setBounds(130,640,100,30);
        editButton.setBackground(Color.cyan);
        editButton.setVisible(false);

        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String val= managerIDTxt.getText();
                for (int i = 0; i < tableModel.getRowCount(); i++)
                {
                    if (tableModel.getValueAt(i, 0).equals(val))
                    {
                        if(contactNoCheckbox.isSelected())
                        {
                            String contact=contactNoTxt.getText();
                            recTable.setValueAt(contact, i, 6);
                            String updateQuery="update Manager set ContactNo=? where ManagerID=? ";
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
                        if(emailCheckbox.isSelected())
                        {
                            String email= emailTxt.getText();
                            recTable.setValueAt(email, i, 5);
                            String updateQuery="update Manager set Email=? where ManagerID=? ";
                            try
                            {
                                PreparedStatement pst=connection.prepareStatement(updateQuery);
                                pst.setString(1,email);
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
                            String updateQuery="update Manager set Address=? where ManagerID=? ";
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
                            recTable.setValueAt(sal, i, 11);
                            String updateQuery="update Manager set Salary=? where ManagerID=? ";
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
                            recTable.setValueAt(status, i, 12);
                            String updateQuery="update Manager set AccountStatus=? where ManagerID=?";
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
                        if(passwordCheckbox.isSelected())
                        {
                            String password=passwordTxt.getText();
                            recTable.setValueAt(password, i, 10);
                            String updateQuery="update Manager set Password=? where ManagerID=?";
                            try
                            {
                                PreparedStatement pst=connection.prepareStatement(updateQuery);
                                pst.setString(1,password);
                                pst.setString(2,val);
                                pst.executeUpdate();
                            }
                            catch (SQLException ex)
                            {
                                throw new RuntimeException(ex);
                            }

                        }
                        if (cityCheckbox.isSelected())
                        {
                            String city=cityTxt.getText();
                            recTable.setValueAt(city, i, 7);
                            String updateQuery="update Manager set City=? where ManagerID=?";
                            try
                            {
                                PreparedStatement pst=connection.prepareStatement(updateQuery);
                                pst.setString(1,city);
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

        emailCheckbox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(emailCheckbox.isSelected())
                {
                    emailLabel.setVisible(true);
                    emailTxt.setVisible(true);
                    editButton.setVisible(true);

                }
                else {
                    emailLabel.setVisible(false);
                    emailTxt.setVisible(false);
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

        cityCheckbox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(cityCheckbox.isSelected())
                {
                    cityLabel.setVisible(true);
                    cityTxt.setVisible(true);
                    editButton.setVisible(true);
                }
                else{
                    cityLabel.setVisible(false);
                    cityTxt.setVisible(false);
                    editButton.setVisible(false);
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
                    editButton.setVisible(true);
                }
                else {
                    passwordLabel.setVisible(false);
                    passwordTxt.setVisible(false);
                    editButton.setVisible(false);
                }
            }
        });


        inputPanel.add(editRecLabel);
        inputPanel.add(managerIDLabel);
        inputPanel.add(managerIDTxt);
        inputPanel.add(searchButton);
        inputPanel.add(addressCheckbox);
        inputPanel.add(emailCheckbox);
        inputPanel.add(contactNoCheckbox);
        inputPanel.add(salaryCheckbox);
        inputPanel.add(statusCheckbox);
        inputPanel.add(passwordCheckbox);
        inputPanel.add(cityCheckbox);

        inputPanel.add(emailLabel);
        inputPanel.add(emailTxt);
        inputPanel.add(cityLabel);
        inputPanel.add(cityTxt);
        inputPanel.add(contactNoLabel);
        inputPanel.add(contactNoTxt);
        inputPanel.add(addressLabel);
        inputPanel.add(addressTxt);
        inputPanel.add(salaryLabel);
        inputPanel.add(salaryTxt);
        inputPanel.add(passwordLabel);
        inputPanel.add(passwordTxt);
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
        ManageManagerPage mgp=new ManageManagerPage();
    }
}
