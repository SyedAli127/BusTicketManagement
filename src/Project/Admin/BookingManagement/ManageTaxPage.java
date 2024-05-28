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

public class ManageTaxPage extends JFrame {
    DefaultTableModel tableModel;
    JTable recTable;
    Connection connection= Database.setConnection();
    public ManageTaxPage()
    {
        JLabel label=new JLabel();
        label.setText("Manage Tax");
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

        JLabel taxIDSearchLabel =new JLabel();
        taxIDSearchLabel.setText(" Tax ID:");
        taxIDSearchLabel.setBounds(300,80,180,50);
        taxIDSearchLabel.setFont(new Font("Arial",Font.BOLD,20));
        taxIDSearchLabel.setForeground(Color.orange);

        JTextField taxIDSearchTxt =new JTextField();
        taxIDSearchTxt.setBounds(390,90,150,30);


        JButton searchButton=new JButton("Search");
        searchButton.setBounds(580,90,100,30);
        searchButton.setBackground(Color.cyan);
        searchButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                int taxID =Integer.parseInt(taxIDSearchTxt.getText());
                boolean found=false;
                String query="select * from Tax where TaxID=?";
                try
                {
                    PreparedStatement psmt=connection.prepareStatement(query);
                    psmt.setInt(1, taxID);
                    ResultSet rs=psmt.executeQuery();
                    while (rs.next())
                    {
                        tableModel.setRowCount(0);
                        int promoCodeID=rs.getInt("TaxID");
                        String taxName=rs.getString("TaxName");
                        Float taxPercentage=rs.getFloat("TaxPercentage");
                        String taxDescription =rs.getString("TaxDescription");

                        String [] row={Integer.toString(promoCodeID),taxName,Float.toString(taxPercentage), taxDescription};

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

        String[] column={"Tax ID","Tax Name","Tax Percentage","Tax Description"};
        tableModel=new DefaultTableModel(column,0);
        recTable=new JTable(tableModel);
        recTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        recTable.getColumnModel().getColumn(0).setPreferredWidth(100);
        recTable.getColumnModel().getColumn(1).setPreferredWidth(120);
        recTable.getColumnModel().getColumn(2).setPreferredWidth(120);
        recTable.getColumnModel().getColumn(3).setPreferredWidth(237);

        String query="select * from Tax";
        try
        {
            PreparedStatement psmt=connection.prepareStatement(query);
            ResultSet rs=psmt.executeQuery();
            while (rs.next())
            {
                int promoCodeID=rs.getInt("TaxID");
                String taxName=rs.getString("TaxName");
                Float taxPercentage =rs.getFloat("TaxPercentage");
                String remainTimeUsed=rs.getString("TaxDescription");

                String [] row={Integer.toString(promoCodeID),taxName, Float.toString(taxPercentage),remainTimeUsed};

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


        setTitle("Manage Tax Page");
        setLayout(null);
        setSize(900, 650);
        getContentPane().setBackground(Color.darkGray);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);


        add(label);
        add(menuPanel);
        add(taxIDSearchLabel);
        add(taxIDSearchTxt);
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


        JLabel taxNameLabel =new JLabel();
        taxNameLabel.setText("Tax Name:");
        taxNameLabel.setBounds(10,100,220,30);
        taxNameLabel.setFont(new Font("Arial",Font.BOLD,20));
        taxNameLabel.setForeground(Color.orange);

        JTextField taxNameTxt =new JTextField();
        taxNameTxt.setBounds(230,100,150,30);

        JLabel taxPercentageLabel =new JLabel();
        taxPercentageLabel.setText("Tax Percentage:");
        taxPercentageLabel.setBounds(10,150,220,30);
        taxPercentageLabel.setFont(new Font("Arial",Font.BOLD,20));
        taxPercentageLabel.setForeground(Color.orange);

        JTextField taxPercentageTxt =new JTextField();
        taxPercentageTxt.setBounds(230,150,150,30);

        JLabel taxDescriptionLabel =new JLabel();
        taxDescriptionLabel.setText("Tax Description:");
        taxDescriptionLabel.setBounds(10,200,220,30);
        taxDescriptionLabel.setFont(new Font("Arial",Font.BOLD,20));
        taxDescriptionLabel.setForeground(Color.orange);

        JTextField taxDescriptionTxt =new JTextField();
        taxDescriptionTxt.setBounds(230,200,150,30);


        JButton addButton=new JButton("Add");
        addButton.setBounds(150,280,100,40);
        addButton.setBackground(Color.cyan);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int maxVal=0,prcID=0;


                String insertQuery="insert into Tax(TaxName,TaxPercentage,TaxDescription) values(?,?,?)";
                try
                {
                    PreparedStatement psmt =connection.prepareStatement(insertQuery);
                    psmt.setString(1, taxNameTxt.getText());
                    psmt.setFloat(2,Float.parseFloat(taxPercentageTxt.getText()));
                    psmt.setString(3,taxDescriptionTxt.getText());
                    psmt.executeUpdate();

                    String query="Select TaxID from Tax ";
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

                String[] row={ Integer.toString(maxVal), taxNameTxt.getText(), taxPercentageTxt.getText(),
                        taxDescriptionTxt.getText()};
                tableModel.addRow(row);
                addDialog.dispose();

            }
        });

        addDialog.add(addRecLabel);
        addDialog.add(taxPercentageLabel);
        addDialog.add(taxPercentageTxt);
        addDialog.add(taxNameLabel);
        addDialog.add(taxNameTxt);
        addDialog.add(taxDescriptionLabel);
        addDialog.add(taxDescriptionTxt);

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


        JLabel taxIDLabel =new JLabel();
        taxIDLabel.setText("Tax ID:");
        taxIDLabel.setBounds(50,100,180,30);
        taxIDLabel.setFont(new Font("Arial",Font.BOLD,22));
        taxIDLabel.setForeground(Color.orange);

        JTextField taxIDTxt =new JTextField();
        taxIDTxt.setBounds(200,100,150,30);


        JButton searchButton=new JButton("Search");
        searchButton.setBounds(130,170,100,30);
        searchButton.setBackground(Color.cyan);
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String IDVal = taxIDTxt.getText();
                boolean found=false;
                for (int i = 0; i < tableModel.getRowCount(); i++)
                {
                    if (tableModel.getValueAt(i, 0).equals(IDVal))
                    {
                        String delQuery="delete  from Tax where TaxID=?";
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
                    JOptionPane.showMessageDialog(removeDialog, "Record with Tax ID " + IDVal +" not found.", "Record Not Found", JOptionPane.WARNING_MESSAGE);
                }
                else {
                    JOptionPane.showMessageDialog(removeDialog, "Record with Tax ID " + IDVal +  " removed successfully.", "Record Removed", JOptionPane.INFORMATION_MESSAGE);
                }
            }

        });

        removeDialog.add(addRecLabel);
        removeDialog.add(taxIDLabel);
        removeDialog.add(taxIDTxt);
        removeDialog.add(searchButton);

        removeDialog.setVisible(true);

    }

    public void  editRecord()
    {
        JDialog editDialog = new JDialog(this, "Edit Record", true);
        editDialog.setLayout(null);
        editDialog.getContentPane().setBackground(Color.darkGray);
        editDialog.setSize(500, 530);
        editDialog.setLocationRelativeTo(null);

        JLabel editRecLabel =new JLabel();
        editRecLabel.setText("Edit Record");
        editRecLabel.setFont(new Font("Arial",Font.BOLD,22));
        editRecLabel.setForeground(Color.orange);
        editRecLabel.setBounds(150, 30,240,30);


        JLabel taxIDLabel =new JLabel();
        taxIDLabel.setText("Tax ID:");
        taxIDLabel.setBounds(40,100,150,30);
        taxIDLabel.setFont(new Font("Arial",Font.BOLD,20));
        taxIDLabel.setForeground(Color.orange);

        JTextField promoCodeIDTxt =new JTextField();
        promoCodeIDTxt.setBounds(200,100,150,30);


        JCheckBox taxNameCheckBox =new JCheckBox("Tax Name");
        taxNameCheckBox.setForeground(Color.orange);
        taxNameCheckBox.setBackground(Color.darkGray);
        taxNameCheckBox.setBounds(30,200,90,30);
        taxNameCheckBox.setVisible(false);

        JCheckBox taxPercentageCheckBox =new JCheckBox("Tax Percentage");
        taxPercentageCheckBox.setForeground(Color.orange);
        taxPercentageCheckBox.setBackground(Color.darkGray);
        taxPercentageCheckBox.setBounds(140,200,120,30);
        taxPercentageCheckBox.setVisible(false);

        JCheckBox taxDescriptionCheckBox =new JCheckBox("Tax Description");
        taxDescriptionCheckBox.setForeground(Color.orange);
        taxDescriptionCheckBox.setBackground(Color.darkGray);
        taxDescriptionCheckBox.setBounds(280,200,150,30);
        taxDescriptionCheckBox.setVisible(false);


        JLabel taxNameLabel =new JLabel();
        taxNameLabel.setText("Tax Name:");
        taxNameLabel.setBounds(10,250,220,30);
        taxNameLabel.setFont(new Font("Arial",Font.BOLD,20));
        taxNameLabel.setForeground(Color.orange);
        taxNameLabel.setVisible(false);

        JTextField taxNameTxt =new JTextField();
        taxNameTxt.setBounds(230,250,150,30);
        taxNameTxt.setVisible(false);

        JLabel taxPercentageLabel =new JLabel();
        taxPercentageLabel.setText("Tax Percentage:");
        taxPercentageLabel.setBounds(10,300,220,30);
        taxPercentageLabel.setFont(new Font("Arial",Font.BOLD,20));
        taxPercentageLabel.setForeground(Color.orange);
        taxPercentageLabel.setVisible(false);

        JTextField taxPercentageTxt =new JTextField();
        taxPercentageTxt.setBounds(230,300,150,30);
        taxPercentageTxt.setVisible(false);

        JLabel taxDescriptionLabel =new JLabel();
        taxDescriptionLabel.setText("Tax Description:");
        taxDescriptionLabel.setBounds(10,350,220,30);
        taxDescriptionLabel.setFont(new Font("Arial",Font.BOLD,20));
        taxDescriptionLabel.setForeground(Color.orange);
        taxDescriptionLabel.setVisible(false);

        JTextField taxDescriptionTxt =new JTextField();
        taxDescriptionTxt.setBounds(230,350,150,30);
        taxDescriptionTxt.setVisible(false);


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
                        taxNameCheckBox.setVisible(true);
                        taxPercentageCheckBox.setVisible(true);
                        taxDescriptionCheckBox.setVisible(true);
                        found = true;
                        break;
                    }
                }
                if (!found)
                {
                    JOptionPane.showMessageDialog(editDialog, "Record with Tax ID " + val + " not found.", "Record Not Found", JOptionPane.WARNING_MESSAGE);
                }

            }
        });

        JButton editButton=new JButton("Edit");
        editButton.setBounds(170,420,100,30);
        editButton.setBackground(Color.cyan);
        editButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String val= promoCodeIDTxt.getText();
                for (int i = 0; i < tableModel.getRowCount(); i++)
                {
                    if (tableModel.getValueAt(i, 0).equals(val))
                    {
                        if(taxNameCheckBox.isSelected())
                        {
                            recTable.setValueAt(taxNameTxt.getText(),i,1);
                            String editQuery="Update Tax set TaxName=? where TaxID=?";
                            try
                            {
                                PreparedStatement psmt=connection.prepareStatement(editQuery);
                                psmt.setString(1, taxNameTxt.getText());
                                psmt.setInt(2,Integer.parseInt(val));
                                psmt.executeUpdate();
                            }
                            catch (SQLException ex)
                            {
                                throw new RuntimeException(ex);
                            }

                        }
                        if (taxPercentageCheckBox.isSelected())
                        {
                            recTable.setValueAt(taxPercentageTxt.getText(),i,2);
                            String editQuery="Update Tax set TaxPercentage=? where TaxID=?";
                            try
                            {
                                PreparedStatement psmt=connection.prepareStatement(editQuery);
                                psmt.setFloat(1,Float.parseFloat(taxPercentageTxt.getText()));
                                psmt.setInt(2,Integer.parseInt(val));
                                psmt.executeUpdate();
                            }
                            catch (SQLException ex)
                            {
                                throw new RuntimeException(ex);
                            }


                        }
                        if(taxDescriptionCheckBox.isSelected())
                        {
                            recTable.setValueAt(taxDescriptionTxt.getText(),i,3);
                            String editQuery="Update Tax set TaxDescription=? where TaxID=?";
                            try
                            {
                                PreparedStatement psmt=connection.prepareStatement(editQuery);
                                psmt.setString(1,taxDescriptionTxt.getText());
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

        taxNameCheckBox.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if(taxNameCheckBox.isSelected())
                {
                    taxNameLabel.setVisible(true);
                    taxNameTxt.setVisible(true);
                }
                else {
                    taxNameLabel.setVisible(false);
                    taxNameTxt.setVisible(false);
                }
            }
        });

        taxPercentageCheckBox.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if (taxPercentageCheckBox.isSelected())
                {
                    taxPercentageLabel.setVisible(true);
                    taxPercentageTxt.setVisible(true);
                }
                else {
                    taxPercentageLabel.setVisible(false);
                    taxPercentageTxt.setVisible(false);
                }
            }
        });

        taxDescriptionCheckBox.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if (taxDescriptionCheckBox.isSelected())
                {
                    taxDescriptionLabel.setVisible(true);
                    taxDescriptionTxt.setVisible(true);

                }
                else {
                    taxDescriptionLabel.setVisible(false);
                    taxDescriptionTxt.setVisible(false);
                }
            }
        });



        editDialog.add(editRecLabel);
        editDialog.add(taxIDLabel);
        editDialog.add(promoCodeIDTxt);
        editDialog.add(searchButton);
        editDialog.add(taxNameCheckBox);
        editDialog.add(taxPercentageCheckBox);
        editDialog.add(taxDescriptionCheckBox);
        editDialog.add(taxNameLabel);
        editDialog.add(taxNameTxt);
        editDialog.add(taxPercentageLabel);
        editDialog.add(taxPercentageTxt);
        editDialog.add(taxDescriptionLabel);
        editDialog.add(taxDescriptionTxt);

        editDialog.add(editButton);


        editDialog.setResizable(false);
        editDialog.setVisible(true);

    }



    public static void main(String[] args)
    {
        ManageTaxPage mtp= new ManageTaxPage();
    }
}
