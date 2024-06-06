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
public class AddBookingPage extends JFrame{

    DefaultTableModel tableModel;
    JTable recTable;
    Connection conn = Database.setConnection();

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
        searchButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String id=bookIDTxt.getText();
                boolean found=false;
                String query="Select * from Booking where BookID=? order by BookID";
                try {
                    PreparedStatement pst=conn.prepareStatement(query);
                    pst.setInt(1,Integer.parseInt(id));
                    ResultSet rs=pst.executeQuery();
                    while (rs.next())
                    {
                        tableModel.setRowCount(0);
                        int bookID =rs.getInt("BookID");
                        int routeID =rs.getInt("RouteID");
                        int busID =rs.getInt("BusID");
                        int driverID =rs.getInt("DriverID");
                        int priceID =rs.getInt("PriceID");
                        String date=rs.getString("Date");
                        String bookingStatus=rs.getString("BookingStatus");
                        String [] row= {Integer.toString(bookID), Integer.toString(routeID), Integer.toString(busID),
                                Integer.toString(driverID), Integer.toString(priceID), date, bookingStatus};

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
                    JOptionPane.showMessageDialog(null, "Record with Booking ID "+ id+ " not found.", "Record Not Found", JOptionPane.WARNING_MESSAGE);
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
        tabPanel.setBounds(250,190,600,350);
        tabPanel.setLayout(null);

        String[] column={"Booking ID","Route ID","Bus ID","Driver ID","Price ID","Date","Booking Status"};

        tableModel=new DefaultTableModel(column,0);
        recTable=new JTable(tableModel);
        recTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF); // This ensures horizontal

        recTable.getColumnModel().getColumn(0).setPreferredWidth(100);//Booking ID
        recTable.getColumnModel().getColumn(1).setPreferredWidth(100);//Route ID
        recTable.getColumnModel().getColumn(2).setPreferredWidth(100);//Bus ID
        recTable.getColumnModel().getColumn(3).setPreferredWidth(100);//Driver ID
        recTable.getColumnModel().getColumn(4).setPreferredWidth(100);//Price ID
        recTable.getColumnModel().getColumn(5).setPreferredWidth(100);//Date
        recTable.getColumnModel().getColumn(6).setPreferredWidth(100);//Booking Status


        String query="Select * from Booking order by BookID";
        try
        {
            PreparedStatement pst=conn.prepareStatement(query);
            ResultSet rs=pst.executeQuery();
            while(rs.next())
            {
                int bookID =rs.getInt("BookID");
                int routeID =rs.getInt("RouteID");
                int busID =rs.getInt("BusID");
                int driverID =rs.getInt("DriverID");
                int priceID =rs.getInt("PriceID");
                String date=rs.getString("Date");
                String bookingStatus=rs.getString("BookingStatus");
                String [] row={Integer.toString(bookID),Integer.toString(routeID),Integer.toString(busID),
                        Integer.toString(driverID),Integer.toString(priceID),date,bookingStatus
                };
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


        JLabel routeIDLabel =new JLabel();
        routeIDLabel.setText("Route ID:");
        routeIDLabel.setBounds(70,100,220,30);
        routeIDLabel.setFont(new Font("Arial",Font.BOLD,20));
        routeIDLabel.setForeground(Color.orange);

        ArrayList<String> routeIDStatList = new ArrayList<>();
        String routeIDQuery ="select RouteID from Route";
        try
        {
            PreparedStatement rspst=conn.prepareStatement(routeIDQuery);
            ResultSet rs=rspst.executeQuery();
            while(rs.next())
            {
                String routeID=Integer.toString(rs.getInt("RouteID"));
                routeIDStatList.add(routeID);
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        String[] routeState = routeIDStatList.toArray(new String[0]);

        JComboBox routeIDCombobox =new JComboBox<>(routeState);
        routeIDCombobox.setBounds(230,100,150,35);
        //routeIDCombobox.setBackground(Color.orange);


        JLabel busIDLabel =new JLabel();
        busIDLabel.setText("Bus ID:");
        busIDLabel.setBounds(70,150,220,30);
        busIDLabel.setFont(new Font("Arial",Font.BOLD,20));
        busIDLabel.setForeground(Color.orange);
        ArrayList<String> busStatList = new ArrayList<>();

        String busIDQuery ="select busID from Bus where Availability='Active'";
        try
        {
            PreparedStatement psmt=conn.prepareStatement(busIDQuery);
            ResultSet rs=psmt.executeQuery();
            while(rs.next())
            {
                String busID =Integer.toString(rs.getInt("BusID"));
                busStatList.add(busID);
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }

        String[] busState = busStatList.toArray(new String[0]);

        JComboBox busIDCombobox =new JComboBox<>(busState);
        busIDCombobox.setBounds(230,150,150,35);
        //busIDCombobox.setBackground(Color.orange);


        JLabel driverIDLabel =new JLabel();
        driverIDLabel.setText("Driver ID:");
        driverIDLabel.setBounds(70,200,220,30);
        driverIDLabel.setFont(new Font("Arial",Font.BOLD,20));
        driverIDLabel.setForeground(Color.orange);

        ArrayList<String> driverIDStatList = new ArrayList<>();
        String driverIDQuery ="select driverID from Driver where AccountStatus='Active'";
        try
        {
            PreparedStatement psmt=conn.prepareStatement(driverIDQuery);
            ResultSet rs=psmt.executeQuery();
            while(rs.next())
            {
                String driverID =Integer.toString(rs.getInt("DriverID"));
                driverIDStatList.add(driverID);
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        String[] driverState = driverIDStatList.toArray(new String[0]);
        JComboBox driverIDCombobox =new JComboBox<>(driverState);
        driverIDCombobox.setBounds(230,200,150,35);
        //driverIDCombobox.setBackground(Color.orange);

        JLabel priceIDLabel =new JLabel();
        priceIDLabel.setText("Price ID:");
        priceIDLabel.setBounds(70,250,220,30);
        priceIDLabel.setFont(new Font("Arial",Font.BOLD,20));
        priceIDLabel.setForeground(Color.orange);

        ArrayList<String> priceIDStatList = new ArrayList<>();
        String priceIDQuery ="select priceID from Price";
        try
        {
            PreparedStatement psmt=conn.prepareStatement(priceIDQuery);
            ResultSet rs=psmt.executeQuery();
            while(rs.next())
            {
                String priceID =Integer.toString(rs.getInt("PriceID"));
                priceIDStatList.add(priceID);
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        String[] priceIDState = priceIDStatList.toArray(new String[0]);
        JComboBox priceIDCombobox =new JComboBox<>(priceIDState);
        priceIDCombobox.setBounds(230,250,150,35);
        //priceIDCombobox.setBackground(Color.orange);


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


        JButton addButton=new JButton("Add");
        addButton.setBounds(150,390,100,40);
        addButton.setBackground(Color.cyan);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int id,maxVal=0;
                String date=yearTxt.getText()+"-"+monTxt.getText()+"-"+dayTxt.getText();
                String busID=(String)busIDCombobox.getSelectedItem();
                String routeID=(String)routeIDCombobox.getSelectedItem();
                String driverID=(String)driverIDCombobox.getSelectedItem();
                String priceID=(String)priceIDCombobox.getSelectedItem();

                String insertQuery="insert into Booking(RouteID,BusID,DriverID,PriceID,Date,BookingStatus)" +
                        "values(?,?,?,?,?,?)";
                try
                {
                    PreparedStatement psmt=conn.prepareStatement(insertQuery);
                    psmt.setInt(1,Integer.parseInt(routeID));
                    psmt.setInt(2,Integer.parseInt(busID));
                    psmt.setInt(3,Integer.parseInt(driverID));
                    psmt.setInt(4,Integer.parseInt(priceID));
                    psmt.setString(5,date);
                    psmt.setString(6,"Active");
                    psmt.executeUpdate();

                    String query="Select bookID from Booking ";
                    PreparedStatement pst=conn.prepareStatement(query);
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


                String[] row={Integer.toString(maxVal),routeID,busID,driverID,priceID,date,"Active"};
                tableModel.addRow(row);
                addDialog.dispose();
            }
        });

        addDialog.add(addRecLabel);
        addDialog.add(busIDLabel);
        addDialog.add(routeIDLabel);
        addDialog.add(routeIDCombobox);

        addDialog.add(driverIDLabel);
        addDialog.add(driverIDCombobox);
        addDialog.add(priceIDLabel);
        addDialog.add(priceIDCombobox);

        addDialog.add(busIDCombobox);

        addDialog.add(dateLabel);
        addDialog.add(dayTxt);
        addDialog.add(dayLabel);
        addDialog.add(monLabel);
        addDialog.add(monTxt);
        addDialog.add(yearLabel);
        addDialog.add(yearTxt);
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
        addRecLabel.setFont(new Font("Arial",Font.BOLD,25));
        addRecLabel.setForeground(Color.orange);
        addRecLabel.setBounds(100, 30,240,30);


        JLabel bookIDLabel =new JLabel();
        bookIDLabel.setText("Book ID:");
        bookIDLabel.setBounds(50,100,180,30);
        bookIDLabel.setFont(new Font("Arial",Font.BOLD,22));
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
                    {
                        String delQuery="delete from Booking where BookID=?";
                        try
                        {
                            PreparedStatement pst=conn.prepareStatement(delQuery);
                            pst.setString(1,IDVal);
                            pst.executeUpdate();
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
        inputPanel.setPreferredSize(new Dimension(480, 700));

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
        busIDCheckBox.setBounds(130,200,80,30);
        busIDCheckBox.setVisible(false);

        JCheckBox driverIDCheckBox =new JCheckBox("Driver ID");
        driverIDCheckBox.setForeground(Color.orange);
        driverIDCheckBox.setBackground(Color.darkGray);
        driverIDCheckBox.setBounds(230,200,80,30);
        driverIDCheckBox.setVisible(false);


        JCheckBox priceIDCheckBox =new JCheckBox("Price ID");
        priceIDCheckBox.setForeground(Color.orange);
        priceIDCheckBox.setBackground(Color.darkGray);
        priceIDCheckBox.setBounds(330,200,70,30);
        priceIDCheckBox.setVisible(false);

        JCheckBox dateCheckBox =new JCheckBox("Date");
        dateCheckBox.setForeground(Color.orange);
        dateCheckBox.setBackground(Color.darkGray);
        dateCheckBox.setBounds(30,240,60,30);
        dateCheckBox.setVisible(false);

        JCheckBox bookingStatusCheckBox =new JCheckBox("Booking Status");
        bookingStatusCheckBox.setForeground(Color.orange);
        bookingStatusCheckBox.setBackground(Color.darkGray);
        bookingStatusCheckBox.setBounds(130,240,120,30);
        bookingStatusCheckBox.setVisible(false);


        JLabel routeIDLabel =new JLabel();
        routeIDLabel.setText("Route ID:");
        routeIDLabel.setBounds(60,300,220,30);
        routeIDLabel.setFont(new Font("Arial",Font.BOLD,20));
        routeIDLabel.setForeground(Color.orange);
        routeIDLabel.setVisible(false);

        ArrayList<String> routeStatList = new ArrayList<>();
        String routeIDQuery ="select RouteID from Route";
        try
        {
            PreparedStatement rspst=conn.prepareStatement(routeIDQuery);
            ResultSet rs=rspst.executeQuery();
            while(rs.next())
            {
                String routeID=Integer.toString(rs.getInt("RouteID"));
                routeStatList.add(routeID);
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        String[] routeState = routeStatList.toArray(new String[0]);

        JComboBox routeIDCombobox =new JComboBox<>(routeState);
        routeIDCombobox.setBounds(230,300,150,35);
        //routeIDCombobox.setBackground(Color.orange);
        routeIDCombobox.setVisible(false);


        JLabel busIDLabel =new JLabel();
        busIDLabel.setText("Bus ID:");
        busIDLabel.setBounds(60,350,220,30);
        busIDLabel.setFont(new Font("Arial",Font.BOLD,20));
        busIDLabel.setForeground(Color.orange);
        busIDLabel.setVisible(false);

        ArrayList<String> busStatList = new ArrayList<>();

        String busIDquery ="select busID from Bus where Availability='Active'";
        try
        {
            PreparedStatement psmt=conn.prepareStatement(busIDquery);
            ResultSet rs=psmt.executeQuery();
            while(rs.next())
            {
                String busID =Integer.toString(rs.getInt("BusID"));
                busStatList.add(busID);
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }

        String[] busState = busStatList.toArray(new String[0]);

        JComboBox busIDCombobox =new JComboBox<>(busState);
        busIDCombobox.setBounds(230,350,150,35);
        //busIDCombobox.setBackground(//Color.orange);
        busIDCombobox.setVisible(false);

        JLabel driverIDLabel =new JLabel();
        driverIDLabel.setText("Driver ID:");
        driverIDLabel.setBounds(60,400,220,30);
        driverIDLabel.setFont(new Font("Arial",Font.BOLD,20));
        driverIDLabel.setForeground(Color.orange);
        driverIDLabel.setVisible(false);

        ArrayList<String> driverIDStatList = new ArrayList<>();
        String driverIDQuery ="select driverID from Driver where AccountStatus='Active'";
        try
        {
            PreparedStatement psmt=conn.prepareStatement(driverIDQuery);
            ResultSet rs=psmt.executeQuery();
            while(rs.next())
            {
                String driverID =Integer.toString(rs.getInt("DriverID"));
                driverIDStatList.add(driverID);
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        String[] driverState = driverIDStatList.toArray(new String[0]);
        JComboBox driverIDCombobox =new JComboBox<>(driverState);
        driverIDCombobox.setBounds(230,400,150,35);
        //driverIDCombobox.setBackground(Color.orange);
        driverIDCombobox.setVisible(false);

        JLabel priceIDLabel =new JLabel();
        priceIDLabel.setText("Price ID:");
        priceIDLabel.setBounds(60,450,220,30);
        priceIDLabel.setFont(new Font("Arial",Font.BOLD,20));
        priceIDLabel.setForeground(Color.orange);
        priceIDLabel.setVisible(false);

        ArrayList<String> priceIDStatList = new ArrayList<>();
        String priceIDQuery ="select priceID from Price";
        try
        {
            PreparedStatement psmt=conn.prepareStatement(priceIDQuery);
            ResultSet rs=psmt.executeQuery();
            while(rs.next())
            {
                String priceID =Integer.toString(rs.getInt("PriceID"));
                priceIDStatList.add(priceID);
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        String[] priceIDState = priceIDStatList.toArray(new String[0]);
        JComboBox priceIDCombobox =new JComboBox<>(priceIDState);
        priceIDCombobox.setBounds(230,450,150,35);
        //priceIDCombobox.setBackground(Color.orange);
        priceIDCombobox.setVisible(false);

        JLabel dateLabel =new JLabel();
        dateLabel.setText("Date:");
        dateLabel.setBounds(60,500,220,30);
        dateLabel.setFont(new Font("Arial",Font.BOLD,20));
        dateLabel.setForeground(Color.orange);
        dateLabel.setVisible(false);

        JLabel dayLabel =new JLabel("(Day)");
        dayLabel.setBounds(230,530,50,30);
        dayLabel.setForeground(Color.orange);
        dayLabel.setFont(new Font("Arial",Font.BOLD,11));
        dayLabel.setVisible(false);

        JTextField dayTxt =new JTextField();
        dayTxt.setBounds(230,500,40,30);
        dayTxt.setVisible(false);

        JLabel monLabel =new JLabel("(Month)");
        monLabel.setBounds(290,530,50,30);
        monLabel.setForeground(Color.orange);
        monLabel.setFont(new Font("Arial",Font.BOLD,11));
        monLabel.setVisible(false);

        JTextField monTxt =new JTextField();
        monTxt.setBounds(290,500,40,30);
        monTxt.setVisible(false);

        JLabel yearLabel =new JLabel("(Year)");
        yearLabel.setBounds(350,530,50,30);
        yearLabel.setForeground(Color.orange);
        yearLabel.setFont(new Font("Arial",Font.BOLD,11));
        yearLabel.setVisible(false);

        JTextField yearTxt =new JTextField();
        yearTxt.setBounds(350,500,40,30);
        yearTxt.setVisible(false);

        JLabel bookingStatusLabel =new JLabel();
        bookingStatusLabel.setText("Booking Status:");
        bookingStatusLabel.setBounds(60,580,220,30);
        bookingStatusLabel.setFont(new Font("Arial",Font.BOLD,20));
        bookingStatusLabel.setForeground(Color.orange);
        bookingStatusLabel.setVisible(false);

        String[] stat={"-","Active","Not Active"};

        JComboBox bookingStatusCombobox =new JComboBox<>(stat);
        bookingStatusCombobox.setBounds(230,580,150,35);
        //bookingStatusCombobox.setBackground(Color.orange);
        bookingStatusCombobox.setVisible(false);

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
                        bookingStatusCheckBox.setVisible(true);
                        priceIDCheckBox.setVisible(true);
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
        editButton.setBounds(130,650,100,30);
        editButton.setBackground(Color.cyan);
        editButton.setVisible(false);
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String date=yearTxt.getText()+"-"+monTxt.getText()+"-"+dayTxt.getText();

                String val= bookIDTxt.getText();
                for (int i = 0; i < tableModel.getRowCount(); i++)
                {
                    if (tableModel.getValueAt(i, 0).equals(val))
                    {


                        if(routeIDCheckBox.isSelected())
                        {
                            String routeID=(String)routeIDCombobox.getSelectedItem();
                            recTable.setValueAt(routeID,i,1);
                            String updateQuery="update Booking set RouteID=? where BookID=?";
                            try
                            {
                                PreparedStatement pst=conn.prepareStatement(updateQuery);
                                pst.setInt(1,Integer.parseInt(routeID));
                                pst.setInt(2,Integer.parseInt(bookIDTxt.getText()));
                                pst.executeUpdate();

                            }
                            catch (SQLException ex)
                            {
                                throw new RuntimeException(ex);
                            }

                        }
                        if (busIDCheckBox.isSelected())
                        {
                            String busID=(String)busIDCombobox.getSelectedItem();
                            recTable.setValueAt(busID,i,2);
                            String updateQuery="update Booking set BusID=? where BookID=?";
                            try
                            {
                                PreparedStatement pst=conn.prepareStatement(updateQuery);
                                pst.setInt(1,Integer.parseInt(busID));
                                pst.setInt(2,Integer.parseInt(bookIDTxt.getText()));
                                pst.executeUpdate();
                            }
                            catch (SQLException ex)
                            {
                                throw new RuntimeException(ex);
                            }

                        }
                        if(driverIDCheckBox.isSelected())
                        {
                            String driverID=(String)driverIDCombobox.getSelectedItem();
                            recTable.setValueAt(driverID,i,3);

                            String updateQuery="update Booking set DriverID=? where BookID=?";
                            try
                            {
                                PreparedStatement pst=conn.prepareStatement(updateQuery);
                                pst.setInt(1,Integer.parseInt(driverID));
                                pst.setInt(2,Integer.parseInt(bookIDTxt.getText()));
                                pst.executeUpdate();
                            }
                            catch (SQLException ex)
                            {
                                throw new RuntimeException(ex);
                            }

                        }
                        if(priceIDCheckBox.isSelected())
                        {
                            String priceID=(String)priceIDCombobox.getSelectedItem();
                            recTable.setValueAt(priceID,i,4);
                            String updateQuery="update Booking set PriceID=? where BookID=?";
                            try
                            {
                                PreparedStatement pst=conn.prepareStatement(updateQuery);
                                pst.setInt(1,Integer.parseInt(priceID));
                                pst.setInt(2,Integer.parseInt(bookIDTxt.getText()));
                                pst.executeUpdate();
                            }
                            catch (SQLException ex)
                            {
                                throw new RuntimeException(ex);
                            }


                        }
                        if(dateCheckBox.isSelected())
                        {
                            recTable.setValueAt(date,i,5);
                            String updateQuery="update Booking set Date=? where BookID=?";
                            try
                            {
                                PreparedStatement pst=conn.prepareStatement(updateQuery);
                                pst.setString(1,date);
                                pst.setInt(2,Integer.parseInt(bookIDTxt.getText()));
                                pst.executeUpdate();
                            }
                            catch (SQLException ex)
                            {
                                throw new RuntimeException(ex);
                            }

                        }
                        if(bookingStatusCheckBox.isSelected())
                        {
                            String status=(String)bookingStatusCombobox.getSelectedItem();
                            recTable.setValueAt(status,i,6);
                            String updateQuery="update Booking set BookingStatus=? where BookID=?";
                            try {
                                PreparedStatement pst= conn.prepareStatement(updateQuery);
                                pst.setString(1,status);
                                pst.setInt(2,Integer.parseInt(bookIDTxt.getText()));
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

        routeIDCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(routeIDCheckBox.isSelected())
                {
                    routeIDLabel.setVisible(true);
                    routeIDCombobox.setVisible(true);
                    editButton.setVisible(true);
                }
                else {
                    routeIDLabel.setVisible(false);
                    routeIDCombobox.setVisible(false);
                    editButton.setVisible(false);
                }
            }
        });

        busIDCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (busIDCheckBox.isSelected())
                {
                    busIDLabel.setVisible(true);
                    busIDCombobox.setVisible(true);
                    editButton.setVisible(true);
                }
                else {
                    busIDLabel.setVisible(false);
                    busIDCombobox.setVisible(false);
                    editButton.setVisible(false);
                }
            }
        });

        driverIDCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (driverIDCheckBox.isSelected())
                {
                    driverIDLabel.setVisible(true);
                    driverIDCombobox.setVisible(true);
                    editButton.setVisible(true);
                }
                else {
                    driverIDLabel.setVisible(false);
                    driverIDCombobox.setVisible(false);
                    editButton.setVisible(false);
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
                    editButton.setVisible(true);
                }
                else {
                    dateLabel.setVisible(false);
                    dayLabel.setVisible(false);
                    dayTxt.setVisible(false);
                    monLabel.setVisible(false);
                    monTxt.setVisible(false);
                    yearLabel.setVisible(false);
                    yearTxt.setVisible(false);
                    editButton.setVisible(false);
                }
            }
        });

        priceIDCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(priceIDCheckBox.isSelected())
                {
                    priceIDLabel.setVisible(true);
                    priceIDCombobox.setVisible(true);
                    editButton.setVisible(true);
                }
                else
                {
                    priceIDLabel.setVisible(false);
                    priceIDCombobox.setVisible(false);
                    editButton.setVisible(false);
                }
            }
        });

        bookingStatusCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(bookingStatusCheckBox.isSelected())
                {
                    bookingStatusLabel.setVisible(true);
                    bookingStatusCombobox.setVisible(true);
                    editButton.setVisible(true);
                }
                else
                {
                    bookingStatusLabel.setVisible(false);
                    bookingStatusCombobox.setVisible(false);
                    editButton.setVisible(false);
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
        inputPanel.add(bookingStatusCheckBox);
        inputPanel.add(priceIDCheckBox);

        inputPanel.add(routeIDLabel);
        inputPanel.add(routeIDCombobox);
        inputPanel.add(busIDLabel);
        inputPanel.add(busIDCombobox);
        inputPanel.add(driverIDLabel);
        inputPanel.add(driverIDCombobox);
        inputPanel.add(priceIDLabel);
        inputPanel.add(priceIDCombobox);
        inputPanel.add(dateLabel);
        inputPanel.add(dayLabel);
        inputPanel.add(dayTxt);
        inputPanel.add(monLabel);
        inputPanel.add(monTxt);
        inputPanel.add(yearLabel);
        inputPanel.add(yearTxt);
        inputPanel.add(bookingStatusLabel);
        inputPanel.add(bookingStatusCombobox);
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
