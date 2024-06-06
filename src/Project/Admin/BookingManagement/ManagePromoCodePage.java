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

public class ManagePromoCodePage extends JFrame {

    DefaultTableModel tableModel;
    JTable recTable;
    Connection connection= Database.setConnection();

    public ManagePromoCodePage()
    {
        JLabel label=new JLabel();
        label.setText("Manage PromoCode");
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

        JLabel promoCodeIDSearchLabel =new JLabel();
        promoCodeIDSearchLabel.setText(" PromoCode ID:");
        promoCodeIDSearchLabel.setBounds(230,80,180,50);
        promoCodeIDSearchLabel.setFont(new Font("Arial",Font.BOLD,20));
        promoCodeIDSearchLabel.setForeground(Color.orange);

        JTextField promoCodeIDSearchTxt =new JTextField();
        promoCodeIDSearchTxt.setBounds(390,90,150,30);


        JButton searchButton=new JButton("Search");
        searchButton.setBounds(580,90,100,30);
        searchButton.setBackground(Color.cyan);
        searchButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                int prcID=Integer.parseInt(promoCodeIDSearchTxt.getText());
                boolean found=false;
                String query="select * from PromoCode where PromoCodeID=? ";
                try
                {
                    PreparedStatement psmt=connection.prepareStatement(query);
                    psmt.setInt(1,prcID);
                    ResultSet rs=psmt.executeQuery();
                    while (rs.next())
                    {
                        tableModel.setRowCount(0);
                        int promoCodeID=rs.getInt("PromoCodeID");
                        String code=rs.getString("Code");
                        float discountPercentage=rs.getFloat("DiscountPercentage");
                        int remainTimeUsed=rs.getInt("RemainingTimeUsed");
                        String status=rs.getString("Status");

                        String [] row={Integer.toString(promoCodeID),code,Float.toString(discountPercentage),
                                Integer.toString(remainTimeUsed),status};

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
        addButton.setBounds(250,160,90,30);
        addButton.setBackground(Color.GREEN);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addRecord();
            }
        });

        JButton removeButton =new JButton();
        removeButton.setText("- Remove");
        removeButton.setBounds(350,160,90,30);
        removeButton.setBackground(Color.RED);
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                removeRecord();
            }
        });



        JButton editButton =new JButton();
        editButton.setText("Edit");
        editButton.setBounds(450,160,90,30);
        editButton.setBackground(Color.PINK);
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                editRecord();
            }
        });


        JPanel tabPanel=new JPanel();
        tabPanel.setBounds(250,210,580,350);
        tabPanel.setLayout(null);

        String[] column={"PromoCode ID","Code","Discount Percentage","Remaining Time Used","Status"};
        tableModel=new DefaultTableModel(column,0);
        recTable=new JTable(tableModel);
        recTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        recTable.getColumnModel().getColumn(0).setPreferredWidth(100);
        recTable.getColumnModel().getColumn(1).setPreferredWidth(120);
        recTable.getColumnModel().getColumn(2).setPreferredWidth(140);
        recTable.getColumnModel().getColumn(3).setPreferredWidth(150);
        recTable.getColumnModel().getColumn(4).setPreferredWidth(100);
        String query="select * from PromoCode order by PromoCodeID";
        try
        {
            PreparedStatement psmt=connection.prepareStatement(query);
            ResultSet rs=psmt.executeQuery();
            while (rs.next())
            {
                int promoCodeID=rs.getInt("PromoCodeID");
                String code=rs.getString("Code");
                float discountPercentage=rs.getFloat("DiscountPercentage");
                int remainTimeUsed=rs.getInt("RemainingTimeUsed");
                String status=rs.getString("Status");

                String [] row={Integer.toString(promoCodeID),code,Float.toString(discountPercentage),
                        Integer.toString(remainTimeUsed),status};

                tableModel.addRow(row);
            }
        }
        catch (SQLException ex)
        {
            throw new RuntimeException(ex);
        }



        JScrollPane scrollPane=new JScrollPane(recTable);
        scrollPane.setBounds(1,1,580,350);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        tabPanel.add(scrollPane);

        setTitle("Manage PromoCode Page");
        setLayout(null);
        setSize(900, 650);
        getContentPane().setBackground(Color.darkGray);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);


        add(label);
        add(menuPanel);
        add(promoCodeIDSearchLabel);
        add(promoCodeIDSearchTxt);
        add(searchButton);
        add(addButton);
        add(removeButton);
        add(editButton);
        add(tabPanel);
    }

    public void  addRecord()
    {
        JDialog addDialog = new JDialog(this, "Add New Record", true);
        addDialog.setLayout(null);
        addDialog.getContentPane().setBackground(Color.darkGray);
        addDialog.setSize(500, 420);
        addDialog.setLocationRelativeTo(null);

        JLabel addRecLabel=new JLabel();
        addRecLabel.setText("Add New Record");
        addRecLabel.setFont(new Font("Arial",Font.BOLD,25));
        addRecLabel.setForeground(Color.orange);
        addRecLabel.setBounds(150, 30,240,30);


        JLabel codeLabel =new JLabel();
        codeLabel.setText("Code:");
        codeLabel.setBounds(10,100,220,30);
        codeLabel.setFont(new Font("Arial",Font.BOLD,20));
        codeLabel.setForeground(Color.orange);

        JTextField codeTxt =new JTextField();
        codeTxt.setBounds(230,100,150,30);

        JLabel discountPercentageLabel =new JLabel();
        discountPercentageLabel.setText("Discount Percentage:");
        discountPercentageLabel.setBounds(10,150,220,30);
        discountPercentageLabel.setFont(new Font("Arial",Font.BOLD,20));
        discountPercentageLabel.setForeground(Color.orange);

        JTextField discountPercentageTxt =new JTextField();
        discountPercentageTxt.setBounds(230,150,150,30);

        JLabel remainingTimeUsedLabel =new JLabel();
        remainingTimeUsedLabel.setText("Remaining Time Used:");
        remainingTimeUsedLabel.setBounds(10,200,220,30);
        remainingTimeUsedLabel.setFont(new Font("Arial",Font.BOLD,20));
        remainingTimeUsedLabel.setForeground(Color.orange);

        JTextField remainingTimeUsedTxt =new JTextField();
        remainingTimeUsedTxt.setBounds(230,200,150,30);


        JButton addButton=new JButton("Add");
        addButton.setBounds(150,280,100,40);
        addButton.setBackground(Color.cyan);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int maxVal=0,prcID=0;


                String insertQuery="insert into PromoCode(Code,DiscountPercentage,RemainingTimeUsed,Status) values(?,?,?,?)";
                try
                {
                    PreparedStatement psmt =connection.prepareStatement(insertQuery);
                    psmt.setString(1,codeTxt.getText());
                    psmt.setFloat(2,Float.parseFloat(discountPercentageTxt.getText()));
                    psmt.setInt(3,Integer.parseInt(remainingTimeUsedTxt.getText()));
                    psmt.setString(4,"Active");
                    psmt.executeUpdate();

                    String query="Select PromoCodeID from PromoCode ";
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

                String[] row={ Integer.toString(maxVal), codeTxt.getText(), discountPercentageTxt.getText(),
                        remainingTimeUsedTxt.getText(),"Active"};
                tableModel.addRow(row);
                addDialog.dispose();

            }
        });

        addDialog.add(addRecLabel);
        addDialog.add(discountPercentageLabel);
        addDialog.add(discountPercentageTxt);
        addDialog.add(codeLabel);
        addDialog.add(codeTxt);
        addDialog.add(remainingTimeUsedLabel);
        addDialog.add(remainingTimeUsedTxt);

        addDialog.add(addButton);

        addDialog.setResizable(false);
        addDialog.setVisible(true);

    }
    public void  removeRecord()
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


        JLabel promoCodeIDLabel =new JLabel();
        promoCodeIDLabel.setText("PromoCode ID:");
        promoCodeIDLabel.setBounds(10,100,180,30);
        promoCodeIDLabel.setFont(new Font("Arial",Font.BOLD,22));
        promoCodeIDLabel.setForeground(Color.orange);

        JTextField promoCodeIDTxt =new JTextField();
        promoCodeIDTxt.setBounds(200,100,150,30);


        JButton searchButton=new JButton("Search");
        searchButton.setBounds(130,170,100,30);
        searchButton.setBackground(Color.cyan);
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String IDVal = promoCodeIDTxt.getText();
                boolean found=false;
                for (int i = 0; i < tableModel.getRowCount(); i++)
                {
                    if (tableModel.getValueAt(i, 0).equals(IDVal))
                    {
                        String delQuery="delete  from PromoCode where PromoCodeID=?";
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
                    JOptionPane.showMessageDialog(removeDialog, "Record with PromoCode ID " + IDVal +" not found.", "Record Not Found", JOptionPane.WARNING_MESSAGE);
                }
                else {
                    JOptionPane.showMessageDialog(removeDialog, "Record with PromoCode ID " + IDVal +  " removed successfully.", "Record Removed", JOptionPane.INFORMATION_MESSAGE);
                }
            }

        });

        removeDialog.add(addRecLabel);
        removeDialog.add(promoCodeIDLabel);
        removeDialog.add(promoCodeIDTxt);
        removeDialog.add(searchButton);

        removeDialog.setVisible(true);

    }

    public void  editRecord()
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


        JLabel promoCodeIDLabel =new JLabel();
        promoCodeIDLabel.setText("PromoCode ID:");
        promoCodeIDLabel.setBounds(40,100,150,30);
        promoCodeIDLabel.setFont(new Font("Arial",Font.BOLD,20));
        promoCodeIDLabel.setForeground(Color.orange);

        JTextField promoCodeIDTxt =new JTextField();
        promoCodeIDTxt.setBounds(200,100,150,30);


        JCheckBox codeCheckBox =new JCheckBox("Code");
        codeCheckBox.setForeground(Color.orange);
        codeCheckBox.setBackground(Color.darkGray);
        codeCheckBox.setBounds(30,200,150,30);
        codeCheckBox.setVisible(false);

        JCheckBox discountPercentageCheckBox =new JCheckBox("Discount Percentage");
        discountPercentageCheckBox.setForeground(Color.orange);
        discountPercentageCheckBox.setBackground(Color.darkGray);
        discountPercentageCheckBox.setBounds(230,200,150,30);
        discountPercentageCheckBox.setVisible(false);

        JCheckBox remainingTimeUsedCheckBox =new JCheckBox("Remaining Time Used");
        remainingTimeUsedCheckBox.setForeground(Color.orange);
        remainingTimeUsedCheckBox.setBackground(Color.darkGray);
        remainingTimeUsedCheckBox.setBounds(30,230,150,30);
        remainingTimeUsedCheckBox.setVisible(false);

        JCheckBox statusCheckBox =new JCheckBox("Status");
        statusCheckBox.setForeground(Color.orange);
        statusCheckBox.setBackground(Color.darkGray);
        statusCheckBox.setBounds(230,230,90,30);
        statusCheckBox.setVisible(false);


        JLabel codeLabel =new JLabel();
        codeLabel.setText("Code:");
        codeLabel.setBounds(10,280,220,30);
        codeLabel.setFont(new Font("Arial",Font.BOLD,20));
        codeLabel.setForeground(Color.orange);
        codeLabel.setVisible(false);

        JTextField codeTxt =new JTextField();
        codeTxt.setBounds(230,280,150,30);
        codeTxt.setVisible(false);

        JLabel discountPercentageLabel =new JLabel();
        discountPercentageLabel.setText("Discount Percentage:");
        discountPercentageLabel.setBounds(10,330,220,30);
        discountPercentageLabel.setFont(new Font("Arial",Font.BOLD,20));
        discountPercentageLabel.setForeground(Color.orange);
        discountPercentageLabel.setVisible(false);

        JTextField discountPercentageTxt =new JTextField();
        discountPercentageTxt.setBounds(230,330,150,30);
        discountPercentageTxt.setVisible(false);

        JLabel remainingTimeUsedLabel =new JLabel();
        remainingTimeUsedLabel.setText("Remaining Time Used:");
        remainingTimeUsedLabel.setBounds(10,380,220,30);
        remainingTimeUsedLabel.setFont(new Font("Arial",Font.BOLD,20));
        remainingTimeUsedLabel.setForeground(Color.orange);
        remainingTimeUsedLabel.setVisible(false);

        JTextField remainingTimeUsedTxt =new JTextField();
        remainingTimeUsedTxt.setBounds(230,380,150,30);
        remainingTimeUsedTxt.setVisible(false);

        JLabel statusLabel =new JLabel();
        statusLabel.setText("Status:");
        statusLabel.setBounds(10,430,220,30);
        statusLabel.setFont(new Font("Arial",Font.BOLD,20));
        statusLabel.setForeground(Color.orange);
        statusLabel.setVisible(false);

        String[] stat={"-","Active","Not Active"};

        JComboBox statusCombobox=new JComboBox<>(stat);
        statusCombobox.setBounds(230,430,150,35);
        statusCombobox.setBackground(Color.orange);
        statusCombobox.setVisible(false);


        JButton searchButton=new JButton("Search");
        searchButton.setBounds(170,150,100,30);
        searchButton.setBackground(Color.cyan);
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String val= promoCodeIDTxt.getText();
                boolean found=false;
                for (int i = 0; i < tableModel.getRowCount(); i++)
                {
                    if (tableModel.getValueAt(i, 0).equals(val))
                    {
                        codeCheckBox.setVisible(true);
                        discountPercentageCheckBox.setVisible(true);
                        remainingTimeUsedCheckBox.setVisible(true);
                        statusCheckBox.setVisible(true);

                        found = true;
                        break;
                    }
                }
                if (!found)
                {
                    JOptionPane.showMessageDialog(editDialog, "Record with PromoCode ID " + val + " not found.", "Record Not Found", JOptionPane.WARNING_MESSAGE);
                }

            }
        });

        JButton editButton=new JButton("Edit");
        editButton.setBounds(130,500,100,30);
        editButton.setBackground(Color.cyan);
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {



                String val= promoCodeIDTxt.getText();
                for (int i = 0; i < tableModel.getRowCount(); i++)
                {
                    if (tableModel.getValueAt(i, 0).equals(val))
                    {


                        if(codeCheckBox.isSelected())
                        {
                            recTable.setValueAt(codeTxt.getText(),i,1);
                            String editQuery="Update PromoCode set Code=? where PromoCodeID=?";
                            try
                            {
                                PreparedStatement psmt=connection.prepareStatement(editQuery);
                                psmt.setString(1,codeTxt.getText());
                                psmt.setInt(2,Integer.parseInt(val));
                                psmt.executeUpdate();
                            }
                            catch (SQLException ex)
                            {
                                throw new RuntimeException(ex);
                            }

                        }
                        if (discountPercentageCheckBox.isSelected())
                        {
                            recTable.setValueAt(discountPercentageTxt.getText(),i,2);
                            String editQuery="Update PromoCode set DiscountPercentage=? where PromoCodeID=?";
                            try
                            {
                                PreparedStatement psmt=connection.prepareStatement(editQuery);
                                psmt.setFloat(1,Float.parseFloat(discountPercentageTxt.getText()));
                                psmt.setInt(2,Integer.parseInt(val));
                                psmt.executeUpdate();
                            }
                            catch (SQLException ex)
                            {
                                throw new RuntimeException(ex);
                            }


                        }
                        if(remainingTimeUsedCheckBox.isSelected())
                        {
                            recTable.setValueAt(remainingTimeUsedTxt.getText(),i,3);
                            String editQuery="Update PromoCode set RemainingTimeUsed=? where PromoCodeID=?";
                            try
                            {
                                PreparedStatement psmt=connection.prepareStatement(editQuery);
                                psmt.setInt(1,Integer.parseInt(remainingTimeUsedTxt.getText()));
                                psmt.setInt(2,Integer.parseInt(val));
                                psmt.executeUpdate();
                            }
                            catch (SQLException ex)
                            {
                                throw new RuntimeException(ex);
                            }

                        }
                        if(statusCheckBox.isSelected())
                        {
                            String status=(String)statusCombobox.getSelectedItem();
                            recTable.setValueAt(status,i,4);
                            String editQuery="Update PromoCode set Status=? where PromoCodeID=?";
                            try
                            {
                                PreparedStatement psmt=connection.prepareStatement(editQuery);
                                psmt.setString(1,status);
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

        codeCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(codeCheckBox.isSelected())
                {
                    codeLabel.setVisible(true);
                    codeTxt.setVisible(true);
                }
                else {
                    codeLabel.setVisible(false);
                    codeTxt.setVisible(false);
                }
            }
        });

        discountPercentageCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (discountPercentageCheckBox.isSelected())
                {
                    discountPercentageLabel.setVisible(true);
                    discountPercentageTxt.setVisible(true);
                }
                else {
                    discountPercentageLabel.setVisible(false);
                    discountPercentageTxt.setVisible(false);
                }
            }
        });

        remainingTimeUsedCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (remainingTimeUsedCheckBox.isSelected())
                {
                    remainingTimeUsedLabel.setVisible(true);
                    remainingTimeUsedTxt.setVisible(true);

                }
                else {
                    remainingTimeUsedLabel.setVisible(false);
                    remainingTimeUsedTxt.setVisible(false);
                }
            }
        });

        statusCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(statusCheckBox.isSelected())
                {
                    statusLabel.setVisible(true);
                    statusCombobox.setVisible(true);

                }
                else
                {
                    statusLabel.setVisible(false);
                    statusCombobox.setVisible(false);
                }
            }
        });


        editDialog.add(editRecLabel);
        editDialog.add(promoCodeIDLabel);
        editDialog.add(promoCodeIDTxt);
        editDialog.add(searchButton);
        editDialog.add(codeCheckBox);
        editDialog.add(discountPercentageCheckBox);
        editDialog.add(remainingTimeUsedCheckBox);
        editDialog.add(statusCheckBox);
        editDialog.add(codeLabel);
        editDialog.add(codeTxt);
        editDialog.add(discountPercentageLabel);
        editDialog.add(discountPercentageTxt);
        editDialog.add(remainingTimeUsedLabel);
        editDialog.add(remainingTimeUsedTxt);
        editDialog.add(statusLabel);
        editDialog.add(statusCombobox);

        editDialog.add(editButton);


        editDialog.setResizable(false);
        editDialog.setVisible(true);

    }

    public static void main(String[] args) {
        ManagePromoCodePage mpcp= new ManagePromoCodePage();
    }
}
