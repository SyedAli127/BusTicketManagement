package Project.Admin;

import Project.Admin.BookingManagement.*;
import Project.Admin.BusManagement.ManageBusMaintenancePage;
import Project.Admin.BusManagement.ManageBusPage;
import Project.Admin.BusManagement.ManageRoutePage;
import Project.Admin.BusManagement.ManageStopRoutePage;
import Project.Admin.UserMangement.ManageDriverPage;
import Project.Admin.UserMangement.ManageManagerPage;
import Project.Admin.UserMangement.ManageUserPage;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AdminDashboard extends JFrame {

    JProgressBar totalTicketBookProgbar,totalBuyingAmountProgbar,totalPassengerProgbar;
    public AdminDashboard() {

        JLabel label=new JLabel();
        label.setText("Admin Dashboard");
        label.setBounds(450,20,250,50);
        label.setFont(new Font("Arial",Font.BOLD,25));
        label.setForeground(Color.orange);

        JPanel menuPanel =new JPanel();
        menuPanel.setBackground(new Color(14,47,68) );
        menuPanel.setBounds(1,1,200,1200);
        //menuPanel.setVisible(false);
        menuPanel.setLayout(null);

        JPanel panel=new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.darkGray);
        panel.setPreferredSize(new Dimension(900,1290));

        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(0, 0, 885, 700); // Set the bounds of the scroll pane to match the JFrame
        getContentPane().add(scrollPane);

        JPanel totalTicketBookingPanel =new JPanel();
        totalTicketBookingPanel.setBackground(Color.darkGray);
        totalTicketBookingPanel.setBounds(240,100,350,160);
        totalTicketBookingPanel.setLayout(null);
        totalTicketBookingPanel.setBorder(BorderFactory.createLineBorder(Color.GREEN));

        JLabel totTickBookLabel=new JLabel();
        totTickBookLabel.setText("Total Ticket Booking");
        totTickBookLabel.setBounds(80,10,240,40);
        totTickBookLabel.setFont(new Font("Arial",Font.BOLD,20));
        totTickBookLabel.setForeground(Color.orange);

        totalTicketBookingPanel.add(totTickBookLabel);

        totalTicketBookProgbar=new JProgressBar();
        totalTicketBookProgbar.setValue(0);
        totalTicketBookProgbar.setBounds(70,70,230,40);
        totalTicketBookProgbar.setStringPainted(true);
        totalTicketBookProgbar.setString("");

        totalTicketBookingPanel.add(totalTicketBookProgbar);

//NOTE: Progress bar is not completed till I have database connected

        JPanel totalBuyingAmountPanel =new JPanel();
        totalBuyingAmountPanel.setBackground(Color.darkGray);
        totalBuyingAmountPanel.setBounds(240,290,350,160);
        totalBuyingAmountPanel.setLayout(null);
        totalBuyingAmountPanel.setBorder(BorderFactory.createLineBorder(Color.GREEN));

        JLabel totalBuyingAmountLabel=new JLabel();
        totalBuyingAmountLabel.setText("Total Purchasing Amount");
        totalBuyingAmountLabel.setBounds(70,10,240,40);
        totalBuyingAmountLabel.setFont(new Font("Arial",Font.BOLD,20));
        totalBuyingAmountLabel.setForeground(Color.orange);

        totalBuyingAmountPanel.add(totalBuyingAmountLabel);

        totalBuyingAmountProgbar=new JProgressBar();
        totalBuyingAmountProgbar.setValue(0);
        totalBuyingAmountProgbar.setBounds(70,70,230,40);
        totalBuyingAmountProgbar.setStringPainted(true);
        totalBuyingAmountProgbar.setString("");

        totalBuyingAmountPanel.add(totalBuyingAmountProgbar);//same prob for progress bar

        JPanel totalPassengerPanel =new JPanel();
        totalPassengerPanel.setBackground(Color.darkGray);
        totalPassengerPanel.setBounds(240,480,350,160);
        totalPassengerPanel.setLayout(null);
        totalPassengerPanel.setBorder(BorderFactory.createLineBorder(Color.GREEN));

        JLabel totalPassengerLabel=new JLabel();
        totalPassengerLabel.setText("Total Number of Passengers");
        totalPassengerLabel.setBounds(50,10,290,40);
        totalPassengerLabel.setFont(new Font("Arial",Font.BOLD,20));
        totalPassengerLabel.setForeground(Color.orange);

        totalPassengerPanel.add(totalPassengerLabel);

        totalPassengerProgbar=new JProgressBar();
        totalPassengerProgbar.setValue(0);
        totalPassengerProgbar.setBounds(70,70,230,40);
        totalPassengerProgbar.setStringPainted(true);
        totalPassengerProgbar.setString("");
        totalPassengerPanel.add(totalPassengerProgbar);

        JLabel weekIncomeLabel=new JLabel();
        weekIncomeLabel.setText("Total Income of Week");
        weekIncomeLabel.setFont(new Font("Arial",Font.BOLD,20));
        weekIncomeLabel.setForeground(Color.orange);
        weekIncomeLabel.setBounds(240,700,250,60);


        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(100, "Income", "Monday");
        dataset.addValue(150, "Income", "Tuesday");
        dataset.addValue(200, "Income", "Wednesday");
        dataset.addValue(180, "Income", "Thursday");
        dataset.addValue(180, "Income", "Friday");
        dataset.addValue(180, "Income", "Saturday");
        dataset.addValue(140, "Income", "Sunday");


        // Create chart
        JFreeChart chart = ChartFactory.createBarChart("HOLA", "Week","Income",dataset,
                PlotOrientation.VERTICAL,  true, true,false );


        // Create panel to hold the chart
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(500, 300));
        chartPanel.setBounds(230,800,600,350);

        // Add chart panel to your UI


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



/*
        ImageIcon horizImageIcon = new ImageIcon("horizontal line.png");

        ImageIcon verImageIcon = new ImageIcon("vertical line.png");

        JLabel horizImageLabel = new JLabel();
        horizImageLabel.setIcon(horizImageIcon);
        horizImageLabel.setBounds(1, 1, 45, 35);


        horizImageLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e)
            {

                menuPanel.setVisible(!menuPanel.isVisible());
                if (menuPanel.isVisible())
                {
                    horizImageLabel.setIcon(verImageIcon);
                }
                else {
                    horizImageLabel.setIcon(horizImageIcon);
                }
            }
        });

 */


        setTitle("Admin Dashboard");
        setLayout(null);
        setSize(900, 650);
        getContentPane().setBackground(Color.darkGray);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);


        panel.add(label);
        //add(horizImageLabel);
        panel.add(menuPanel);
        //add(totTickBookLabel);
        panel.add(totalTicketBookingPanel);
        panel.add(totalBuyingAmountPanel);
        panel.add(totalPassengerPanel);
        panel.add(weekIncomeLabel);
        panel.add(chartPanel);


    }

    public static void main(String[] args)
    {
        AdminDashboard ad=new AdminDashboard();
    }
}
