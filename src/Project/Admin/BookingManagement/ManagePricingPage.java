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

public class ManagePricingPage extends JFrame{

    DefaultTableModel tableModel;
    JTable recTable;
    Connection connection= Database.setConnection();

    public ManagePricingPage() {
        JLabel label=new JLabel();
        label.setText("Manage Pricing");
        label.setBounds(430,20,250,50);
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



        JLabel priceIDLabel =new JLabel();
        priceIDLabel.setText("Price ID:");
        priceIDLabel.setBounds(300,80,150,50);
        priceIDLabel.setFont(new Font("Arial",Font.BOLD,22));
        priceIDLabel.setForeground(Color.orange);

        JTextField priceIDTxt =new JTextField();
        priceIDTxt.setBounds(400,90,150,30);

        JButton searchButton=new JButton("Search");
        searchButton.setBounds(580,90,100,30);
        searchButton.setBackground(Color.cyan);
        searchButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                int prcID=Integer.parseInt(priceIDTxt.getText());
                boolean found=false;
                String query="select * from Price where PriceID=?";
                try
                {
                    PreparedStatement psmt=connection.prepareStatement(query);
                    psmt.setInt(1,prcID);
                    ResultSet rs=psmt.executeQuery();
                    while (rs.next())
                    {
                        tableModel.setRowCount(0);
                        int priceID=rs.getInt("Price ID");
                        int economySeatPrice=rs.getInt("EconomySeatPrice");
                        int luxurySeatPrice=rs.getInt("LuxurySeatPrice");
                        int firstClassSeatPrice=rs.getInt("FirstClassSeatPrice");
                        int kmPrice=rs.getInt("KMPrice");

                        String [] row={Integer.toString(priceID),Integer.toString(economySeatPrice),Integer.toString(luxurySeatPrice),
                                Integer.toString(firstClassSeatPrice),Integer.toString(kmPrice)};

                        tableModel.addRow(row);
                    }
                }
                catch (SQLException ex)
                {
                    throw new RuntimeException(ex);
                }
            }
        });

        JButton addButton =new JButton();
        addButton.setText("+ Add");
        addButton.setBounds(250,140,90,30);
        addButton.setBackground(Color.GREEN);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                addRecord();
            }
        });

        JButton removeButton =new JButton();
        removeButton.setText("- Remove");
        removeButton.setBounds(350,140,90,30);
        removeButton.setBackground(Color.RED);
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                removeRecord();
            }
        });

        JButton editButton =new JButton();
        editButton.setText("Edit");
        editButton.setBounds(450,140,90,30);
        editButton.setBackground(Color.PINK);
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                editRecord();
            }
        });
        JPanel tabPanel=new JPanel();
        tabPanel.setBounds(250,190,580,350);
        tabPanel.setLayout(null);

        String[]column={"Price ID","Economy Seat Price","Luxury Seat Price","First-Class Seat Price","KM price"};

        tableModel=new DefaultTableModel(column,0);
        recTable=new JTable(tableModel);
        recTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF); // This ensures horizontal scrolling

        recTable.getColumnModel().getColumn(0).setPreferredWidth(85);
        recTable.getColumnModel().getColumn(1).setPreferredWidth(130);
        recTable.getColumnModel().getColumn(2).setPreferredWidth(130);
        recTable.getColumnModel().getColumn(3).setPreferredWidth(150);
        recTable.getColumnModel().getColumn(4).setPreferredWidth(85);

        String query="Select * from Price";
        try
        {
            PreparedStatement psmt=connection.prepareStatement(query);
            ResultSet rs=psmt.executeQuery();
            while (rs.next())
            {
                int priceID=rs.getInt("PriceID");
                int economySeatPrice=rs.getInt("EconomySeatPrice");
                int luxurySeatPrice=rs.getInt("LuxurySeatPrice");
                int firstClassSeatPrice=rs.getInt("FirstClassSeatPrice");
                int kmPrice=rs.getInt("KMPrice");

                String [] row={Integer.toString(priceID),Integer.toString(economySeatPrice),Integer.toString(luxurySeatPrice),
                        Integer.toString(firstClassSeatPrice),Integer.toString(kmPrice)};

                tableModel.addRow(row);

            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }

        JScrollPane scrollPane=new JScrollPane(recTable);
        scrollPane.setBounds(1,1,590,350);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        tabPanel.add(scrollPane);



        setTitle("Manage Price Page");
        setLayout(null);
        setSize(900, 650);
        getContentPane().setBackground(Color.darkGray);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);


        add(label);
        add(menuPanel);
        add(label);
        add(menuPanel);
        add(priceIDLabel);
        add(priceIDTxt);
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
        addDialog.setSize(500, 480);
        addDialog.setLocationRelativeTo(null);

        JLabel addRecLabel=new JLabel();
        addRecLabel.setText("Add New Record");
        addRecLabel.setFont(new Font("Arial",Font.BOLD,25));
        addRecLabel.setForeground(Color.orange);
        addRecLabel.setBounds(150, 30,240,30);


        JLabel econSeatRateLabel =new JLabel();
        econSeatRateLabel.setText("Economy Seat Price:");
        econSeatRateLabel.setBounds(10,100,220,30);
        econSeatRateLabel.setFont(new Font("Arial",Font.BOLD,20));
        econSeatRateLabel.setForeground(Color.orange);

        JTextField econSeatRateTxt =new JTextField();
        econSeatRateTxt.setBounds(230,100,150,30);

        JLabel luxSeatRateLabel =new JLabel();
        luxSeatRateLabel.setText("Luxury Seat Price:");
        luxSeatRateLabel.setBounds(10,150,220,30);
        luxSeatRateLabel.setFont(new Font("Arial",Font.BOLD,20));
        luxSeatRateLabel.setForeground(Color.orange);

        JTextField luxSeatRateTxt =new JTextField();
        luxSeatRateTxt.setBounds(230,150,150,30);

        JLabel firstCSeatRateLabel =new JLabel();
        firstCSeatRateLabel.setText("First-Class Seat Price:");
        firstCSeatRateLabel.setBounds(10,200,220,30);
        firstCSeatRateLabel.setFont(new Font("Arial",Font.BOLD,20));
        firstCSeatRateLabel.setForeground(Color.orange);

        JTextField firstCSeatRateTxt =new JTextField();
        firstCSeatRateTxt.setBounds(230,200,150,30);

        JLabel kmPriceLabel =new JLabel();
        kmPriceLabel.setText("KM Price:");
        kmPriceLabel.setBounds(10,250,220,30);
        kmPriceLabel.setFont(new Font("Arial",Font.BOLD,20));
        kmPriceLabel.setForeground(Color.orange);

        JTextField kmPriceTxt =new JTextField();
        kmPriceTxt.setBounds(230,250,150,30);


        JButton addButton=new JButton("Add");
        addButton.setBounds(150,330,100,40);
        addButton.setBackground(Color.cyan);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int maxVal=0,prcID=0;


                String insertQuery="insert into Price(EconomySeatPrice,LuxurySeatPrice,FirstClassSeatPrice,KMPrice)values (?,?,?,?)";
                try {
                    PreparedStatement psmt =connection.prepareStatement(insertQuery);
                    psmt.setInt(1,Integer.parseInt(econSeatRateTxt.getText()));
                    psmt.setInt(2,Integer.parseInt(luxSeatRateTxt.getText()));
                    psmt.setInt(3,Integer.parseInt(firstCSeatRateTxt.getText()));
                    psmt.setInt(4,Integer.parseInt(kmPriceTxt.getText()));
                    psmt.executeUpdate();

                    String query="Select PriceID from Price ";
                    PreparedStatement pst = connection.prepareStatement(query);
                    ResultSet rs = pst.executeQuery();
                    while(rs.next()) {

                        prcID = rs.getInt(1);
                        if (prcID > maxVal) {
                            maxVal = prcID;

                        }

                    }

                }
                catch (SQLException ex)
                {
                    throw new RuntimeException(ex);
                }

                String[] row={ Integer.toString(maxVal), econSeatRateTxt.getText(), luxSeatRateTxt.getText(),
                        firstCSeatRateTxt.getText(),kmPriceTxt.getText()};
                tableModel.addRow(row);
                addDialog.dispose();

            }
        });

        addDialog.add(addRecLabel);
        addDialog.add(luxSeatRateLabel);
        addDialog.add(luxSeatRateTxt);
        addDialog.add(econSeatRateLabel);
        addDialog.add(econSeatRateTxt);
        addDialog.add(firstCSeatRateLabel);
        addDialog.add(firstCSeatRateTxt);

        addDialog.add(kmPriceLabel);
        addDialog.add(kmPriceTxt);

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
        addRecLabel.setFont(new Font("Arial",Font.BOLD,22));
        addRecLabel.setForeground(Color.orange);
        addRecLabel.setBounds(100, 30,240,30);


        JLabel priceIDLabel =new JLabel();
        priceIDLabel.setText("Price ID:");
        priceIDLabel.setBounds(10,100,180,30);
        priceIDLabel.setFont(new Font("Arial",Font.BOLD,17));
        priceIDLabel.setForeground(Color.orange);

        JTextField priceIDTxt =new JTextField();
        priceIDTxt.setBounds(200,100,150,30);


        JButton searchButton=new JButton("Search");
        searchButton.setBounds(130,170,100,30);
        searchButton.setBackground(Color.cyan);
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String IDVal = priceIDTxt.getText();
                boolean found=false;
                for (int i = 0; i < tableModel.getRowCount(); i++)
                {
                    if (tableModel.getValueAt(i, 0).equals(IDVal))
                    {
                        String delQuery="delete  from Price where PriceID=?";
                        try
                        {
                            PreparedStatement preparedStatement=connection.prepareStatement(delQuery);
                            preparedStatement.setInt(1,Integer.parseInt(IDVal));
                            preparedStatement.executeUpdate();

                        } catch (SQLException ex)
                        {
                            throw new RuntimeException(ex);
                        }
                        tableModel.removeRow(i);
                        found = true;

                        break;

                    }
                }
                if (!found) {
                    JOptionPane.showMessageDialog(removeDialog, "Record with Price ID " + IDVal +" not found.", "Record Not Found", JOptionPane.WARNING_MESSAGE);
                }
                else {
                    JOptionPane.showMessageDialog(removeDialog, "Record with Price ID " + IDVal +  " removed successfully.", "Record Removed", JOptionPane.INFORMATION_MESSAGE);
                }
            }

        });

        removeDialog.add(addRecLabel);
        removeDialog.add(priceIDLabel);
        removeDialog.add(priceIDTxt);
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
        editRecLabel.setBounds(150, 30,240,30);


        JLabel priceIDLabel =new JLabel();
        priceIDLabel.setText("Price ID:");
        priceIDLabel.setBounds(40,100,150,30);
        priceIDLabel.setFont(new Font("Arial",Font.BOLD,20));
        priceIDLabel.setForeground(Color.orange);

        JTextField priceIDTxt =new JTextField();
        priceIDTxt.setBounds(200,100,150,30);


        JCheckBox econSeatRateCheckBox =new JCheckBox("Economy Seat Rate");
        econSeatRateCheckBox.setForeground(Color.orange);
        econSeatRateCheckBox.setBackground(Color.darkGray);
        econSeatRateCheckBox.setBounds(30,200,150,30);
        econSeatRateCheckBox.setVisible(false);

        JCheckBox luxSeatRateCheckBox =new JCheckBox("Luxury Seat Rate");
        luxSeatRateCheckBox.setForeground(Color.orange);
        luxSeatRateCheckBox.setBackground(Color.darkGray);
        luxSeatRateCheckBox.setBounds(230,200,130,30);
        luxSeatRateCheckBox.setVisible(false);

        JCheckBox firstCSeatRateCheckBox =new JCheckBox("First-Class Seat Rate");
        firstCSeatRateCheckBox.setForeground(Color.orange);
        firstCSeatRateCheckBox.setBackground(Color.darkGray);
        firstCSeatRateCheckBox.setBounds(30,230,150,30);
        firstCSeatRateCheckBox.setVisible(false);

        JCheckBox kmPriceCheckBox =new JCheckBox("KM Price");
        kmPriceCheckBox.setForeground(Color.orange);
        kmPriceCheckBox.setBackground(Color.darkGray);
        kmPriceCheckBox.setBounds(230,230,90,30);
        kmPriceCheckBox.setVisible(false);


        JLabel econSeatRateLabel =new JLabel();
        econSeatRateLabel.setText("Economy Seat Price:");
        econSeatRateLabel.setBounds(10,280,220,30);
        econSeatRateLabel.setFont(new Font("Arial",Font.BOLD,20));
        econSeatRateLabel.setForeground(Color.orange);
        econSeatRateLabel.setVisible(false);

        JTextField econSeatRateTxt =new JTextField();
        econSeatRateTxt.setBounds(230,280,150,30);
        econSeatRateTxt.setVisible(false);

        JLabel luxSeatRateLabel =new JLabel();
        luxSeatRateLabel.setText("Luxury Seat Price:");
        luxSeatRateLabel.setBounds(10,330,220,30);
        luxSeatRateLabel.setFont(new Font("Arial",Font.BOLD,20));
        luxSeatRateLabel.setForeground(Color.orange);
        luxSeatRateLabel.setVisible(false);

        JTextField luxSeatRateTxt =new JTextField();
        luxSeatRateTxt.setBounds(230,330,150,30);
        luxSeatRateTxt.setVisible(false);

        JLabel firstCSeatRateLabel =new JLabel();
        firstCSeatRateLabel.setText("First-Class Seat Price:");
        firstCSeatRateLabel.setBounds(10,380,220,30);
        firstCSeatRateLabel.setFont(new Font("Arial",Font.BOLD,20));
        firstCSeatRateLabel.setForeground(Color.orange);
        firstCSeatRateLabel.setVisible(false);

        JTextField firstCSeatRateTxt =new JTextField();
        firstCSeatRateTxt.setBounds(230,380,150,30);
        firstCSeatRateTxt.setVisible(false);

        JLabel kmPriceLabel =new JLabel();
        kmPriceLabel.setText("KM Price:");
        kmPriceLabel.setBounds(10,430,220,30);
        kmPriceLabel.setFont(new Font("Arial",Font.BOLD,20));
        kmPriceLabel.setForeground(Color.orange);
        kmPriceLabel.setVisible(false);

        JTextField kmPriceTxt =new JTextField();
        kmPriceTxt.setBounds(230,430,150,30);
        kmPriceTxt.setVisible(false);




        JButton searchButton=new JButton("Search");
        searchButton.setBounds(170,150,100,30);
        searchButton.setBackground(Color.cyan);
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String val= priceIDTxt.getText();
                boolean found=false;
                for (int i = 0; i < tableModel.getRowCount(); i++)
                {
                    if (tableModel.getValueAt(i, 0).equals(val))
                    {
                        econSeatRateCheckBox.setVisible(true);
                        luxSeatRateCheckBox.setVisible(true);
                        firstCSeatRateCheckBox.setVisible(true);
                        kmPriceCheckBox.setVisible(true);
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
        editButton.setBounds(130,500,100,30);
        editButton.setBackground(Color.cyan);
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {



                String val= priceIDTxt.getText();
                for (int i = 0; i < tableModel.getRowCount(); i++)
                {
                    if (tableModel.getValueAt(i, 0).equals(val))
                    {


                        if(econSeatRateCheckBox.isSelected())
                        {
                            recTable.setValueAt(econSeatRateTxt.getText(),i,1);
                            String editQuery="Update Price set EconomySeatPrice=? where PriceID=?";
                            try
                            {
                                PreparedStatement psmt=connection.prepareStatement(editQuery);
                                psmt.setInt(1,Integer.parseInt(econSeatRateTxt.getText()));
                                psmt.setInt(2,Integer.parseInt(val));
                                psmt.executeUpdate();
                            }
                            catch (SQLException ex)
                            {
                                throw new RuntimeException(ex);
                            }

                        }
                        if (luxSeatRateCheckBox.isSelected())
                        {
                            recTable.setValueAt(luxSeatRateTxt.getText(),i,2);
                            String editQuery="Update Price set LuxurySeatPrice=? where PriceID=?";
                            try
                            {
                                PreparedStatement psmt=connection.prepareStatement(editQuery);
                                psmt.setInt(1,Integer.parseInt(luxSeatRateTxt.getText()));
                                psmt.setInt(2,Integer.parseInt(val));
                                psmt.executeUpdate();
                            }
                            catch (SQLException ex)
                            {
                                throw new RuntimeException(ex);
                            }


                        }
                        if(firstCSeatRateCheckBox.isSelected())
                        {
                            recTable.setValueAt(firstCSeatRateTxt.getText(),i,3);
                            String editQuery="Update Price set FirstClassSeatPrice=? where PriceID=?";
                            try
                            {
                                PreparedStatement psmt=connection.prepareStatement(editQuery);
                                psmt.setInt(1,Integer.parseInt(firstCSeatRateTxt.getText()));
                                psmt.setInt(2,Integer.parseInt(val));
                                psmt.executeUpdate();
                            }
                            catch (SQLException ex)
                            {
                                throw new RuntimeException(ex);
                            }

                        }
                        if(kmPriceCheckBox.isSelected())
                        {
                            recTable.setValueAt(kmPriceTxt.getText(),i,4);
                            String editQuery="Update Price set KMPrice=? where PriceID=?";
                            try
                            {
                                PreparedStatement psmt=connection.prepareStatement(editQuery);
                                psmt.setInt(1,Integer.parseInt(kmPriceTxt.getText()));
                                psmt.setInt(2,Integer.parseInt(val));
                                psmt.executeUpdate();
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

        econSeatRateCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(econSeatRateCheckBox.isSelected())
                {
                    econSeatRateLabel.setVisible(true);
                    econSeatRateTxt.setVisible(true);
                }
                else {
                    econSeatRateLabel.setVisible(false);
                    econSeatRateTxt.setVisible(false);
                }
            }
        });

        luxSeatRateCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (luxSeatRateCheckBox.isSelected())
                {
                    luxSeatRateLabel.setVisible(true);
                    luxSeatRateTxt.setVisible(true);
                }
                else {
                    luxSeatRateLabel.setVisible(false);
                    luxSeatRateTxt.setVisible(false);
                }
            }
        });

        firstCSeatRateCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (firstCSeatRateCheckBox.isSelected())
                {
                    firstCSeatRateLabel.setVisible(true);
                    firstCSeatRateTxt.setVisible(true);

                }
                else {
                    firstCSeatRateLabel.setVisible(false);
                    firstCSeatRateTxt.setVisible(false);
                }
            }
        });

        kmPriceCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(kmPriceCheckBox.isSelected())
                {
                    kmPriceLabel.setVisible(true);
                    kmPriceTxt.setVisible(true);

                }
                else {
                    kmPriceLabel.setVisible(false);
                    kmPriceTxt.setVisible(false);

                }
            }
        });


        editDialog.add(editRecLabel);
        editDialog.add(priceIDLabel);
        editDialog.add(priceIDTxt);
        editDialog.add(searchButton);
        editDialog.add(econSeatRateCheckBox);
        editDialog.add(luxSeatRateCheckBox);
        editDialog.add(firstCSeatRateCheckBox);
        editDialog.add(kmPriceCheckBox );
        editDialog.add(econSeatRateLabel);
        editDialog.add(econSeatRateTxt);
        editDialog.add(luxSeatRateLabel);
        editDialog.add(luxSeatRateTxt);
        editDialog.add(firstCSeatRateLabel);
        editDialog.add(firstCSeatRateTxt);
        editDialog.add(kmPriceLabel);
        editDialog.add(kmPriceTxt);

        editDialog.add(editButton);


        editDialog.setResizable(false);
        editDialog.setVisible(true);


    }

    public static void main(String[]args)
    {
        ManagePricingPage mpp=new ManagePricingPage();
    }
}
