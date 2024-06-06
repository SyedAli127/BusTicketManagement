
package Project.Admin;

import Project.Admin.BookingManagement.*;
import Project.Admin.BusManagement.ManageBusMaintenancePage;
import Project.Admin.BusManagement.ManageBusPage;
import Project.Admin.BusManagement.ManageRoutePage;
import Project.Admin.BusManagement.ManageStopRoutePage;
import Project.Admin.UserMangement.ManageDriverPage;
import Project.Admin.UserMangement.ManageManagerPage;
import Project.Admin.UserMangement.ManageUserPage;
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

public class ViewFeedbackPage extends JFrame{

    DefaultTableModel tableModel;
    JTable recTable;
    Connection connection= Database.setConnection();
    public ViewFeedbackPage() {

        JLabel label=new JLabel();

        label.setText("View Feedback");
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



        JLabel feedbackIDLabel =new JLabel();
        feedbackIDLabel.setText("Feedback ID:");
        feedbackIDLabel.setBounds(240,80,150,50);
        feedbackIDLabel.setFont(new Font("Arial",Font.BOLD,18));
        feedbackIDLabel.setForeground(Color.orange);

        JTextField feedbackIDTxt =new JTextField();
        feedbackIDTxt.setBounds(400,90,150,30);

        JButton searchButton=new JButton("Search");
        searchButton.setBounds(570,90,100,30);
        searchButton.setBackground(Color.cyan);
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fdID = feedbackIDTxt.getText();
                boolean found = false;

                String query = "select f.FeedbackID,f.OrderID,f.CusID,f.Rating,f.Feedback,cus.FirstName,cus.LastName,cus.Email from Feedback f join Customer cus on cus.CusID=f.CusID" +
                        " where FeedbackID=?";
                try {

                    PreparedStatement pst = connection.prepareStatement(query);
                    pst.setInt(1, Integer.parseInt(fdID));
                    ResultSet rs = pst.executeQuery();
                    while (rs.next()) {
                        tableModel.setRowCount(0);
                        int fID=rs.getInt("FeedbackID");
                        int orderID=rs.getInt("OrderID");
                        int cusID=rs.getInt("CusID");
                        String firstName=rs.getString("FirstName");
                        String lastName=rs.getString("LastName");
                        String email=rs.getString("Email");
                        int rating=rs.getInt("Rating");
                        String feedback=rs.getString("Feedback");
                        String[] data={Integer.toString(fID),Integer.toString(orderID),Integer.toString(cusID),firstName,lastName,email,Integer.toString(rating),feedback};
                        tableModel.addRow(data);
                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        JButton removeButton =new JButton();
        removeButton.setText("- Remove");
        removeButton.setBounds(240,170,90,30);
        removeButton.setBackground(Color.RED);
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                removeRecord();
            }
        });

        JPanel tabPanel=new JPanel();
        tabPanel.setBounds(240,220,600,350);
        tabPanel.setLayout(null);


        String[]column={"Feedback ID","Order ID","Customer ID","First Name","Last Name","Email","Rating","Feedback"};

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
        recTable.getColumnModel().getColumn(7).setPreferredWidth(100);

        String query="select f.FeedbackID,f.OrderID,f.CusID,f.Rating,f.Feedback,cus.FirstName,cus.LastName,cus.Email from Feedback f join Customer cus on cus.CusID=f.CusID order by FeedbackID";
        try {
            PreparedStatement psmt=connection.prepareStatement(query);
            ResultSet rs=psmt.executeQuery();
            while (rs.next())
            {
                int fID=rs.getInt("FeedbackID");
                int orderID=rs.getInt("OrderID");
                int cusID=rs.getInt("CusID");
                String firstName=rs.getString("FirstName");
                String lastName=rs.getString("LastName");
                String email=rs.getString("Email");
                int rating=rs.getInt("Rating");
                String feedback=rs.getString("Feedback");
                String[] data={Integer.toString(fID),Integer.toString(orderID),Integer.toString(cusID),firstName,lastName,email,Integer.toString(rating),feedback};
                tableModel.addRow(data);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        JLabel sortbyLabel=new JLabel("(Sort By)");
        sortbyLabel.setBounds(400,140,50,30);
        sortbyLabel.setFont(new Font("Arial",Font.PLAIN,12));
        sortbyLabel.setForeground(Color.orange);


        String[] sortCombo={"-","By Rating(Ascending)","By Rating(Descending)"};
        JComboBox sortComboBox=new JComboBox<>(sortCombo);
        sortComboBox.setBounds(400,170,180,30);

        sortComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sort=(String) sortComboBox.getSelectedItem();
                switch (sort)
                {
                    case "By Rating(Ascending)":
                        ratingAscending();
                        break;

                    case "By Rating(Descending)":
                        ratingDescending();
                        break;
                }

            }
        });

        JScrollPane scrollPane=new JScrollPane(recTable);
        scrollPane.setBounds(1,1,600,350);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        tabPanel.add(scrollPane);

        setTitle("View Feedbacks");
        setLayout(null);
        setSize(900, 650);
        getContentPane().setBackground(Color.darkGray);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);


        add(label);
        add(menuPanel);
        add(feedbackIDLabel);
        add(feedbackIDTxt);
        add(searchButton);
        add(removeButton);
        add(tabPanel);
        add(sortbyLabel);
        add(sortComboBox);




    }

    public void removeRecord(){
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


        JLabel feedbackIDLabel =new JLabel();
        feedbackIDLabel.setText("Feedback ID:");
        feedbackIDLabel.setBounds(40,100,180,30);
        feedbackIDLabel.setFont(new Font("Arial",Font.BOLD,20));
        feedbackIDLabel.setForeground(Color.orange);

        JTextField feedbackIDTxt =new JTextField();
        feedbackIDTxt.setBounds(200,100,150,30);


        JButton searchButton=new JButton("Search");
        searchButton.setBounds(130,170,100,30);
        searchButton.setBackground(Color.cyan);
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String IDVal = feedbackIDTxt.getText();
                boolean found=false;
                for (int i = 0; i < tableModel.getRowCount(); i++)
                {
                    if (tableModel.getValueAt(i, 0).equals(IDVal))
                    {  String delQuery="delete from Feedback where FeedbackID=?";
                        try {
                            PreparedStatement pst=connection.prepareStatement(delQuery);
                            pst.setString(1,IDVal);
                            pst.executeUpdate();
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }
                        tableModel.removeRow(i);
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    JOptionPane.showMessageDialog(removeDialog, "Record with Feedback ID " + IDVal +" not found.", "Record Not Found", JOptionPane.WARNING_MESSAGE);
                }
                else {
                    JOptionPane.showMessageDialog(removeDialog, "Record with Feedback ID " + IDVal +  " removed successfully.", "Record Removed", JOptionPane.INFORMATION_MESSAGE);
                }
            }



        });

        removeDialog.add(addRecLabel);
        removeDialog.add(feedbackIDLabel);
        removeDialog.add(feedbackIDTxt);
        removeDialog.add(searchButton);

        removeDialog.setVisible(true);

    }

    public void ratingAscending()
    {
        String query="select f.FeedbackID,f.OrderID,f.CusID,f.Rating,f.Feedback,cus.FirstName,cus.LastName,cus.Email from Feedback f join Customer cus on cus.CusID=f.CusID order by Rating ";
        try {
            PreparedStatement psmt=connection.prepareStatement(query);
            ResultSet rs=psmt.executeQuery();
            tableModel.setRowCount(0);
            while (rs.next())
            {
                int fID=rs.getInt("FeedbackID");
                int orderID=rs.getInt("OrderID");
                int cusID=rs.getInt("CusID");
                String firstName=rs.getString("FirstName");
                String lastName=rs.getString("LastName");
                String email=rs.getString("Email");
                int rating=rs.getInt("Rating");
                String feedback=rs.getString("Feedback");
                String[] data={Integer.toString(fID),Integer.toString(orderID),Integer.toString(cusID),firstName,lastName,email,Integer.toString(rating),feedback};
                tableModel.addRow(data);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void ratingDescending()
    {
        String query="select f.FeedbackID,f.OrderID,f.CusID,f.Rating,f.Feedback,cus.FirstName,cus.LastName,cus.Email from Feedback f join Customer cus on cus.CusID=f.CusID order by Rating desc ";
        try {
            PreparedStatement psmt=connection.prepareStatement(query);
            ResultSet rs=psmt.executeQuery();
            tableModel.setRowCount(0);
            while (rs.next())
            {
                int fID=rs.getInt("FeedbackID");
                int orderID=rs.getInt("OrderID");
                int cusID=rs.getInt("CusID");
                String firstName=rs.getString("FirstName");
                String lastName=rs.getString("LastName");
                String email=rs.getString("Email");
                int rating=rs.getInt("Rating");
                String feedback=rs.getString("Feedback");
                String[] data={Integer.toString(fID),Integer.toString(orderID),Integer.toString(cusID),firstName,lastName,email,Integer.toString(rating),feedback};
                tableModel.addRow(data);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static void main(String[] args)
    {
        ViewFeedbackPage vfp=new ViewFeedbackPage();
    }

}


