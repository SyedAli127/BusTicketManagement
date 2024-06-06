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

public class ViewBookingPage extends JFrame {
    DefaultTableModel tableModel;
    JTable recTable;
    Connection conn = Database.setConnection();
    public ViewBookingPage() {
        JLabel label=new JLabel();
        label.setText("View Orders");
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


        JLabel orderIDLabel =new JLabel();
        orderIDLabel.setText("Order ID:");
        orderIDLabel.setBounds(240,80,150,50);
        orderIDLabel.setFont(new Font("Arial",Font.BOLD,18));
        orderIDLabel.setForeground(Color.orange);

        JTextField orderIDTxt =new JTextField();
        orderIDTxt.setBounds(400,90,150,30);

        JButton searchButton=new JButton("Search");
        searchButton.setBounds(570,90,100,30);
        searchButton.setBackground(Color.cyan);
        searchButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String id= orderIDTxt.getText();
                boolean found=false;
                String query="Select * from Orders where OrderID=? order by OrderID";
                try {
                    PreparedStatement pst=conn.prepareStatement(query);
                    pst.setInt(1,Integer.parseInt(id));
                    ResultSet rs=pst.executeQuery();
                    while (rs.next())
                    {
                        tableModel.setRowCount(0);
                        int bookID =rs.getInt("BookID");
                        int orderID =rs.getInt("OrderID");
                        int cusID =rs.getInt("CusID");
                        int promoCodeID =rs.getInt("PromoCodeID");
                        String date=rs.getString("OrderDate");
                        String details=rs.getString("OrderDetails");
                        int size=7*details.length();
                        recTable.getColumnModel().getColumn(5).setPreferredWidth(size);
                        Float priceID =rs.getFloat("TotalPrice");

                        String [] row={Integer.toString(orderID),Integer.toString(bookID),Integer.toString(cusID),
                                Integer.toString(promoCodeID),date,details,Float.toString(priceID)
                        };
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
                    JOptionPane.showMessageDialog(null, "Record with Order ID "+ id+ " not found.", "Record Not Found", JOptionPane.WARNING_MESSAGE);
                }

            }
        });
        JPanel tabPanel=new JPanel();
        tabPanel.setBounds(250,190,600,350);
        tabPanel.setLayout(null);

        String[] column={"Order ID","Book ID","Customer ID","PromoCode ID","Order Date","Order Details","Total Price"};

        tableModel=new DefaultTableModel(column,0);
        recTable=new JTable(tableModel);
        recTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF); // This ensures horizontal

        recTable.getColumnModel().getColumn(0).setPreferredWidth(100);
        recTable.getColumnModel().getColumn(1).setPreferredWidth(100);
        recTable.getColumnModel().getColumn(2).setPreferredWidth(100);
        recTable.getColumnModel().getColumn(3).setPreferredWidth(100);
        recTable.getColumnModel().getColumn(4).setPreferredWidth(100);
        recTable.getColumnModel().getColumn(5).setPreferredWidth(100);
        recTable.getColumnModel().getColumn(6).setPreferredWidth(100);


        String query="Select * from Orders order by OrderID";
        try
        {
            PreparedStatement pst=conn.prepareStatement(query);
            ResultSet rs=pst.executeQuery();
            while(rs.next())
            {
                int bookID =rs.getInt("BookID");
                int orderID =rs.getInt("OrderID");
                int cusID =rs.getInt("CusID");
                int promoCodeID =rs.getInt("PromoCodeID");
                String date=rs.getString("OrderDate");
                String details=rs.getString("OrderDetails");
                int size=7*details.length();
                recTable.getColumnModel().getColumn(5).setPreferredWidth(size);
                Float priceID =rs.getFloat("TotalPrice");

                String [] row={Integer.toString(orderID),Integer.toString(bookID),Integer.toString(cusID),
                        Integer.toString(promoCodeID),date,details,Float.toString(priceID)
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

        setTitle("View Booking Page");
        setLayout(null);
        setSize(900, 650);
        getContentPane().setBackground(Color.darkGray);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);


        add(label);
        add(menuPanel);
        add(orderIDLabel);
        add(orderIDTxt);
        add(searchButton);
        add(tabPanel);


    }
    public static void main(String[] args)
    {
        ViewBookingPage vbp=new ViewBookingPage();
    }
}
