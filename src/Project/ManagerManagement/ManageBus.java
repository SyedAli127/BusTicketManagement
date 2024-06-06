package Project.ManagerManagement;

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

public class ManageBus extends JFrame {
    String manID;
    DefaultTableModel tableModel;
    JTable recTable;
    Connection connection= Database.setConnection();
    public ManageBus(String manID)
    {
        this.manID = manID;
        JLabel label=new JLabel();
        label.setText("Manage Buses");
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
        //Children of Uer Management
        DefaultMutableTreeNode manage_driver=new DefaultMutableTreeNode("Manage Driver");

        //Children of Bus Management
        DefaultMutableTreeNode manage_bus=new DefaultMutableTreeNode("Manage Bus");
        DefaultMutableTreeNode manage_bus_maintenance=new DefaultMutableTreeNode("Manage Bus Maintenance");


        //GrandParent
        DefaultMutableTreeNode adminDashboard=new DefaultMutableTreeNode("Manager Dashboard");


        userManagement.add(manage_driver);

        busManagement.add(manage_bus);
        busManagement.add(manage_bus_maintenance);



        adminDashboard.add(dashboard);
        adminDashboard.add(userManagement);
        adminDashboard.add(busManagement);

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
                            ManagerDashboard adminDashboard=new ManagerDashboard(manID);
                            dispose();
                            break;

                        case "Manage Driver":
                            ManageDriver mdp=new ManageDriver(manID);
                            dispose();
                            break;

                        case "Manage Bus":
                            ManageBus mbp=new ManageBus(manID);
                            dispose();
                            break;

                        case "Manage Bus Maintenance":
                            ManageBusMaintenance mbmp=new ManageBusMaintenance(manID);
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


        JLabel busIDSearchLabel =new JLabel();
        busIDSearchLabel.setText(" Bus ID:");
        busIDSearchLabel.setBounds(280,80,180,50);
        busIDSearchLabel.setFont(new Font("Arial",Font.BOLD,20));
        busIDSearchLabel.setForeground(Color.orange);

        JTextField busIDSearchTxt =new JTextField();
        busIDSearchTxt.setBounds(390,90,150,30);


        JButton searchButton=new JButton("Search");
        searchButton.setBounds(580,90,100,30);
        searchButton.setBackground(Color.cyan);
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                String busid=busIDSearchTxt.getText();
                boolean found=false;

                String query="Select * from Bus where busID=? ";
                try {
                    PreparedStatement pst=connection.prepareStatement(query);
                    pst.setInt(1,Integer.parseInt(busid));
                    ResultSet rs=pst.executeQuery();
                    while (rs.next())
                    {
                        tableModel.setRowCount(0);
                        int id=rs.getInt("BusID");
                        int Mgrid=rs.getInt("ManagerID");
                        String BusName=rs.getString("BusName");
                        String BusCompany=rs.getString("BusCompany");
                        String model=rs.getString("Model");
                        String registrationNo=rs.getString("RegistrationNo");
                        String chassisNo=rs.getString("ChassisNo");
                        int econ=rs.getInt("EconomySeats");
                        int lux=rs.getInt("LuxurySeats");
                        int fc=rs.getInt("FirstClassSeats");
                        int total=rs.getInt("TotalSeats");
                        String availability=rs.getString("Availability");

                        String sID=Integer.toString(id);
                        String mgrid=Integer.toString(Mgrid);
                        String EconomySeats=Integer.toString(econ);
                        String LuxurySeats=Integer.toString(lux);
                        String firstClassSeats=Integer.toString(fc);
                        String totalCapacity=Integer.toString(total);
                        String economy = generateSeatRange("E", 1, econ);
                        String luxury = generateSeatRange("L", 1, lux);
                        String firstclass = generateSeatRange("F", 1, fc);

                        String[] data={sID,BusCompany,BusName,model,registrationNo,chassisNo,EconomySeats,LuxurySeats,firstClassSeats,totalCapacity,
                                economy,luxury,firstclass,mgrid,availability};
                        tableModel.addRow(data);
                        found = true;

                    }
                }
                catch (SQLException ex)
                {
                    throw new RuntimeException(ex);
                }

                if (!found) {
                    JOptionPane.showMessageDialog(null, "Record with Bus ID " +busid+ " not found.", "Record Not Found", JOptionPane.WARNING_MESSAGE);
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

                addRecord(manID);
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

        String[] column={"Bus ID","Bus Company","Bus Name","Model No","Registration Number","Chassis Number","Economy Seats","Luxury Seats"
                ,"First-Class Seats","Total Capacity","Economy Seat No.","Luxury Seat No.","First-Class Seat No.","ManagerID","Availability"};

        tableModel=new DefaultTableModel(column,0);
        recTable=new JTable(tableModel);
        recTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF); // This ensures horizontal scrolling

        String query="Select * from Bus order by busID";
        try {
            PreparedStatement ps=connection.prepareStatement(query);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){

                int id=rs.getInt("BusID");
                int Mgrid=rs.getInt("ManagerID");
                String BusName=rs.getString("BusName");
                String BusCompany=rs.getString("BusCompany");
                String model=rs.getString("Model");
                String registrationNo=rs.getString("RegistrationNo");
                String chassisNo=rs.getString("ChassisNo");
                int econ=rs.getInt("EconomySeats");
                int lux=rs.getInt("LuxurySeats");
                int fc=rs.getInt("FirstClassSeats");
                int total=rs.getInt("TotalSeats");
                String availability=rs.getString("Availability");

                String sID=Integer.toString(id);
                String mgrid=Integer.toString(Mgrid);
                String EconomySeats=Integer.toString(econ);
                String LuxurySeats=Integer.toString(lux);
                String firstClassSeats=Integer.toString(fc);
                String totalCapacity=Integer.toString(total);
                String economy = generateSeatRange("E", 1, econ);
                String luxury = generateSeatRange("L", 1, lux);
                String firstclass = generateSeatRange("F", 1, fc);

                String[] data={sID,BusCompany,BusName,model,registrationNo,chassisNo,EconomySeats,LuxurySeats,firstClassSeats,totalCapacity,
                        economy,luxury,firstclass,mgrid,availability};
                tableModel.addRow(data);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }





        JScrollPane scrollPane=new JScrollPane(recTable);
        scrollPane.setBounds(1,1,580,350);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        recTable.getColumnModel().getColumn(0).setPreferredWidth(70); // Bus ID
        recTable.getColumnModel().getColumn(1).setPreferredWidth(100); // Bus Company
        recTable.getColumnModel().getColumn(2).setPreferredWidth(120); // Name
        recTable.getColumnModel().getColumn(3).setPreferredWidth(80); // Model No
        recTable.getColumnModel().getColumn(4).setPreferredWidth(130); // Registration Number
        recTable.getColumnModel().getColumn(5).setPreferredWidth(110); // Chassis Number
        recTable.getColumnModel().getColumn(6).setPreferredWidth(100); // Economy Seats
        recTable.getColumnModel().getColumn(7).setPreferredWidth(100); // Luxury Seats
        recTable.getColumnModel().getColumn(8).setPreferredWidth(120); // First-Class Seats
        recTable.getColumnModel().getColumn(9).setPreferredWidth(100); // Total Capacity
        recTable.getColumnModel().getColumn(10).setPreferredWidth(130); // Economy Seats Number
        recTable.getColumnModel().getColumn(11).setPreferredWidth(130); // Luxury Seats Number
        recTable.getColumnModel().getColumn(12).setPreferredWidth(130); // First-Class Seats Number
        recTable.getColumnModel().getColumn(13).setPreferredWidth(100); // Availability

        tabPanel.add(scrollPane);

        setTitle("Manage Bus Page");
        setLayout(null);
        setSize(900, 650);
        getContentPane().setBackground(Color.darkGray);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);


        add(label);
        add(menuPanel);
        add(busIDSearchLabel);
        add(busIDSearchTxt);
        add(searchButton);
        add(addButton);
        add(removeButton);
        add(editButton);
        add(tabPanel);


    }
    public void addRecord(String manID)
    {
        this.manID=manID;

        JDialog addDialog = new JDialog(this, "Add New Record", true);
        addDialog.setLayout(null);
        addDialog.getContentPane().setBackground(Color.darkGray);
        addDialog.setSize(500, 650);
        addDialog.setLocationRelativeTo(null);
        addDialog.setResizable(false);

        JLabel addRecLabel=new JLabel();
        addRecLabel.setText("Add New Record");
        addRecLabel.setFont(new Font("Arial",Font.BOLD,25));
        addRecLabel.setForeground(Color.orange);
        addRecLabel.setBounds(150, 30,240,30);


        JLabel busCompLabel =new JLabel();
        busCompLabel.setText("Bus Company Name:");
        busCompLabel.setBounds(10,100,220,30);
        busCompLabel.setFont(new Font("Arial",Font.BOLD,20));
        busCompLabel.setForeground(Color.orange);

        JTextField busCompTxt =new JTextField();
        busCompTxt.setBounds(230,100,150,30);

        JLabel busNameLabel=new JLabel();
        busNameLabel.setText("Bus Name:");
        busNameLabel.setBounds(10,150,220,30);
        busNameLabel.setFont(new Font("Arial",Font.BOLD,20));
        busNameLabel.setForeground(Color.orange);

        JTextField busNameTxt =new JTextField();
        busNameTxt.setBounds(230,150,150,30);

        JLabel modelLabel =new JLabel();
        modelLabel.setText("Bus Model:");
        modelLabel.setBounds(10,200,220,30);
        modelLabel.setFont(new Font("Arial",Font.BOLD,20));
        modelLabel.setForeground(Color.orange);

        JTextField modelTxt =new JTextField();
        modelTxt.setBounds(230,200,150,30);

        JLabel regNoLabel =new JLabel();
        regNoLabel.setText("Registration Number:");
        regNoLabel.setBounds(10,250,220,30);
        regNoLabel.setFont(new Font("Arial",Font.BOLD,20));
        regNoLabel.setForeground(Color.orange);

        JTextField regNoTxt =new JTextField();
        regNoTxt.setBounds(230,250,150,30);

        JLabel chassisNoLabel =new JLabel();
        chassisNoLabel.setText("Chassis Number:");
        chassisNoLabel.setBounds(10,300,220,30);
        chassisNoLabel.setFont(new Font("Arial",Font.BOLD,20));
        chassisNoLabel.setForeground(Color.orange);

        JTextField chassisNoTxt =new JTextField();
        chassisNoTxt.setBounds(230,300,150,30);

        JLabel economyLabel =new JLabel();
        economyLabel.setText("Economy Seats:");
        economyLabel.setBounds(10,350,220,30);
        economyLabel.setFont(new Font("Arial",Font.BOLD,20));
        economyLabel.setForeground(Color.orange);

        JTextField economyTxt =new JTextField();
        economyTxt.setBounds(230,350,70,30);

        JLabel luxuryLabel =new JLabel();
        luxuryLabel.setText("Luxury Seats:");
        luxuryLabel.setBounds(10,400,220,30);
        luxuryLabel.setFont(new Font("Arial",Font.BOLD,20));
        luxuryLabel.setForeground(Color.orange);

        JTextField luxuryTxt =new JTextField();
        luxuryTxt.setBounds(230,400,70,30);

        JLabel firstClassLabel =new JLabel();
        firstClassLabel.setText("First-Class Seats:");
        firstClassLabel.setBounds(10,450,220,30);
        firstClassLabel.setFont(new Font("Arial",Font.BOLD,20));
        firstClassLabel.setForeground(Color.orange);

        JTextField firstClassTxt =new JTextField();
        firstClassTxt.setBounds(230,450,70,30);


        JButton addButton=new JButton("Add");
        addButton.setBounds(150,500,100,40);
        addButton.setBackground(Color.cyan);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                int maxVal=0;

                int busID;
                int economySeat = Integer.parseInt(economyTxt.getText());
                int luxurySeat = Integer.parseInt(luxuryTxt.getText());
                int firstSeat = Integer.parseInt(firstClassTxt.getText());

                int totalSeat=economySeat+luxurySeat+firstSeat;
                try{
                    Connection connection = Database.setConnection();
                    String insertQuery = "INSERT INTO Bus (ManagerID,BusCompany,BusName,Model, RegistrationNo,ChassisNo, EconomySeats, LuxurySeats, FirstClassSeats, TotalSeats,Availability) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
                    PreparedStatement psmt= connection.prepareStatement(insertQuery);
                    if(manID.equals("null")||manID.equals("Dummy"))
                    {
                        psmt.setString(1,null);

                    }
                    else
                    {
                        psmt.setInt(1, Integer.parseInt(manID));
                    }

                    psmt.setString(2,busCompTxt.getText());
                    psmt.setString(3,busNameTxt.getText());
                    psmt.setString(4,modelTxt.getText());
                    psmt.setString(5,regNoTxt.getText());
                    psmt.setString(6,chassisNoTxt.getText());
                    psmt.setInt(7,economySeat);
                    psmt.setInt(8,luxurySeat);
                    psmt.setInt(9,firstSeat);
                    psmt.setInt(10,totalSeat);
                    psmt.setString(11,"Active");
                    psmt.executeUpdate();


                    String query="Select busID from Bus ";
                    PreparedStatement pst = connection.prepareStatement(query);
                    ResultSet rs = pst.executeQuery();
                    while(rs.next()){

                        busID=rs.getInt(1);
                        if(busID>maxVal){
                            maxVal=busID;

                        }
                    }
                    String queryforSeats="DECLARE @NewBusID INT SET @NewBusID = ? " +
                            "EXEC PopulateSeats @NewBusID;";
                    PreparedStatement ps=connection.prepareStatement(queryforSeats);
                    ps.setInt(1,maxVal);
                    ps.executeUpdate();


                } catch (SQLException ex)
                {
                    throw new RuntimeException(ex);
                }

                String economySeats = generateSeatRange("E", 1, economySeat);
                String luxurySeats = generateSeatRange("L", 1, luxurySeat);
                String firstClassSeats = generateSeatRange("F", 1, firstSeat);


                String[] row={Integer.toString(maxVal), busCompTxt.getText(), busNameTxt.getText(), modelTxt.getText(), regNoTxt.getText(), chassisNoTxt.getText(),
                        Integer.toString(economySeat), Integer.toString(luxurySeat), Integer.toString(firstSeat), Integer.toString(totalSeat),
                        economySeats,luxurySeats,firstClassSeats,manID,"Active"};

                tableModel.addRow(row);

                addDialog.dispose();
            }
        });

        addDialog.add(addRecLabel);

        addDialog.add(busNameLabel);
        addDialog.add(busNameTxt);
        addDialog.add(busCompLabel);
        addDialog.add(busCompTxt);
        addDialog.add(modelLabel);
        addDialog.add(modelTxt);
        addDialog.add(regNoLabel);
        addDialog.add(regNoTxt);
        addDialog.add(chassisNoLabel);
        addDialog.add(chassisNoTxt);
        addDialog.add(luxuryLabel);
        addDialog.add(luxuryTxt);
        addDialog.add(economyLabel);
        addDialog.add(economyTxt);
        addDialog.add(firstClassLabel);
        addDialog.add(firstClassTxt);
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
        addRecLabel.setFont(new Font("Arial",Font.BOLD,25));
        addRecLabel.setForeground(Color.orange);
        addRecLabel.setBounds(100, 30,240,30);


        JLabel busIDLabel =new JLabel();
        busIDLabel.setText("Bus ID:");
        busIDLabel.setBounds(50,100,180,30);
        busIDLabel.setFont(new Font("Arial",Font.BOLD,22));
        busIDLabel.setForeground(Color.orange);

        JTextField busIDTxt =new JTextField();
        busIDTxt.setBounds(180,100,150,30);


        JButton searchButton=new JButton("Search");
        searchButton.setBounds(130,170,100,30);
        searchButton.setBackground(Color.cyan);
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String idVal=busIDTxt.getText();
                boolean found=false;
                for (int i = 0; i < tableModel.getRowCount(); i++)
                {

                    if (tableModel.getValueAt(i,0).equals(idVal))
                    {
                        String delQuery="DELETE FROM Bus WHERE BusID=?";

                        try
                        {
                            PreparedStatement preparedStatement=connection.prepareStatement(delQuery);
                            preparedStatement.setInt(1,Integer.parseInt(idVal));
                            preparedStatement.executeUpdate();

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
                    JOptionPane.showMessageDialog(removeDialog, "Record with Bus ID " +idVal+ " not found.", "Record Not Found", JOptionPane.WARNING_MESSAGE);
                }
                else {

                    JOptionPane.showMessageDialog(removeDialog, "Record with Bus ID " +idVal+ " removed successfully.", "Record Removed", JOptionPane.INFORMATION_MESSAGE);
                }
            }

        });

        removeDialog.add(addRecLabel);
        removeDialog.add(busIDLabel);
        removeDialog.add(busIDTxt);
        removeDialog.add(searchButton);

        removeDialog.setResizable(false);
        removeDialog.setVisible(true);

    }

    public void editRecord()
    {

        JDialog editDialog = new JDialog(this, "Edit Record", true);
        editDialog.setLayout(null);
        editDialog.getContentPane().setBackground(Color.darkGray);
        editDialog.setSize(500, 600);
        editDialog.setLocationRelativeTo(null);
        editDialog.setResizable(false);


        JLabel editRecLabel =new JLabel();
        editRecLabel.setText("Edit Record");
        editRecLabel.setFont(new Font("Arial",Font.BOLD,22));
        editRecLabel.setForeground(Color.orange);
        editRecLabel.setBounds(150, 30,240,30);


        JLabel busIDLabel =new JLabel();
        busIDLabel.setText("Bus ID:");
        busIDLabel.setBounds(50,100,100,30);
        busIDLabel.setFont(new Font("Arial",Font.BOLD,20));
        busIDLabel.setForeground(Color.orange);

        JTextField busIDTxt=new JTextField();
        busIDTxt.setBounds(150,100,150,30);

        JCheckBox economyCheckbox =new JCheckBox("Economy Seats");
        economyCheckbox.setBackground( Color.darkGray);
        economyCheckbox.setForeground(Color.orange);
        economyCheckbox.setBounds(10,150,130,30);
        economyCheckbox.setVisible(false);


        JCheckBox luxuryCheckbox =new JCheckBox("Luxury Seats");
        luxuryCheckbox.setBackground( Color.darkGray);
        luxuryCheckbox.setForeground(Color.orange);
        luxuryCheckbox.setBounds(140,150,110,30);
        luxuryCheckbox.setVisible(false);

        JCheckBox firstClassCheckbox =new JCheckBox("First-Class Seats");
        firstClassCheckbox.setBackground( Color.darkGray);
        firstClassCheckbox.setForeground(Color.orange);
        firstClassCheckbox.setBounds(250,150,130,30);
        firstClassCheckbox.setVisible(false);


        JCheckBox availabilityCheckbox =new JCheckBox("Availability");
        availabilityCheckbox.setBackground( Color.darkGray);
        availabilityCheckbox.setForeground(Color.orange);
        availabilityCheckbox.setBounds(380,150,120,30);
        availabilityCheckbox.setVisible(false);


        JLabel economySeatLabel=new JLabel();
        economySeatLabel.setText("Economy Seats:");
        economySeatLabel.setBounds(10,200,180,30);
        economySeatLabel.setFont(new Font("Arial",Font.BOLD,20));
        economySeatLabel.setForeground(Color.orange);
        economySeatLabel.setVisible(false);

        JTextField economySeatTxt =new JTextField();
        economySeatTxt.setBounds(200,200,150,30);
        economySeatTxt.setVisible(false);

        JLabel luxurySeatLabel =new JLabel();
        luxurySeatLabel.setText("Luxury Seat:");
        luxurySeatLabel.setBounds(10,250,180,30);
        luxurySeatLabel.setFont(new Font("Arial",Font.BOLD,20));
        luxurySeatLabel.setForeground(Color.orange);
        luxurySeatLabel.setVisible(false);

        JTextField luxurySeatTxt =new JTextField();
        luxurySeatTxt.setBounds(200,250,150,30);
        luxurySeatTxt.setVisible(false);


        JLabel firstClassSeatLabel=new JLabel();
        firstClassSeatLabel.setText("First-Class Seat:");
        firstClassSeatLabel.setBounds(10,300,180,30);
        firstClassSeatLabel.setFont(new Font("Arial",Font.BOLD,20));
        firstClassSeatLabel.setForeground(Color.orange);
        firstClassSeatLabel.setVisible(false);

        JTextField firstClassSeatTxt =new JTextField();
        firstClassSeatTxt.setBounds(200,300,150,30);
        firstClassSeatTxt.setVisible(false);

        JLabel availabilityLabel =new JLabel();
        availabilityLabel.setText("Select Availability:");
        availabilityLabel.setBounds(10,350,180,30);
        availabilityLabel.setFont(new Font("Arial",Font.BOLD,20));
        availabilityLabel.setForeground(Color.orange);
        availabilityLabel.setVisible(false);

        String[] avail={"-","Active","Not Active"};

        JComboBox availabilityCombobox =new JComboBox<>(avail);
        availabilityCombobox.setBounds(200,350,150,35);
        availabilityCombobox.setBackground(Color.orange);
        availabilityCombobox.setVisible(false);


        JButton searchButton=new JButton("Search");
        searchButton.setBounds(330,100,100,30);
        searchButton.setBackground(Color.cyan);
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String busIDVal =busIDTxt.getText();

                boolean found=false;
                for (int i = 0; i < tableModel.getRowCount(); i++)
                {
                    if (tableModel.getValueAt(i, 0).equals(busIDVal))
                    {
                        firstClassCheckbox.setVisible(true);
                        economyCheckbox.setVisible(true);
                        luxuryCheckbox.setVisible(true);
                        availabilityCheckbox.setVisible(true);

                        found = true;
                        break;
                    }
                }
                if (!found)
                {
                    JOptionPane.showMessageDialog(editDialog, "Record with Bus ID "+ busIDVal +" not found.","Record Not Found", JOptionPane.WARNING_MESSAGE);
                }
            }
        });


        JButton editButton=new JButton("Edit");
        editButton.setBounds(170,450,100,30);
        editButton.setBackground(Color.cyan);
        editButton.setVisible(false);

        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String busIDVal =busIDTxt.getText();
                for (int i = 0; i < tableModel.getRowCount(); i++)
                {
                    if (tableModel.getValueAt(i, 0).equals(busIDVal))
                    {

                        String status=(String) availabilityCombobox.getSelectedItem();

                        if(economyCheckbox.isSelected())
                        {
                            recTable.setValueAt(economySeatTxt.getText(), i, 6); // Update Economy Seat
                            int econSeat= Integer.parseInt (economySeatTxt.getText());
                            int id=Integer.parseInt(busIDVal);
                            int luxurySeats= Integer.parseInt( recTable.getValueAt(i,7).toString());
                            int firstCSeat=Integer.parseInt( recTable.getValueAt(i,8).toString());
                            int totalSeats=0;
                            totalSeats=firstCSeat+econSeat+luxurySeats;
                            recTable.setValueAt(Integer.toString(totalSeats), i, 9);

                            String economySeats = generateSeatRange("E", 1, econSeat);
                            recTable.setValueAt(economySeats,i,10);

                            String editQuery="update Bus set EconomySeats=? where BusID=? ";
                            try {
                                PreparedStatement psmt=connection.prepareStatement(editQuery);
                                psmt.setInt(1,econSeat);
                                psmt.setInt(2,id);
                                psmt.executeUpdate();
                                System.out.println("Updated");
                            } catch (SQLException ex) {
                                throw new RuntimeException(ex);
                            }


                        }

                        if(luxuryCheckbox.isSelected())
                        {
                            recTable.setValueAt(luxurySeatTxt.getText(), i, 7); // Update Luxury Seat
                            int id=Integer.parseInt(busIDVal);
                            int econSeat= Integer.parseInt( recTable.getValueAt(i,6).toString());
                            int luxurySeats= Integer.parseInt(luxurySeatTxt.getText());
                            int firstCSeat=Integer.parseInt( recTable.getValueAt(i,8).toString());
                            int totalSeats=0;
                            totalSeats=firstCSeat+econSeat+luxurySeats;
                            recTable.setValueAt(Integer.toString(totalSeats), i, 9);


                            String luxurySeat = generateSeatRange("L", 1, luxurySeats);
                            recTable.setValueAt(luxurySeat,i,11);

                            String editQuery="update Bus set LuxurySeats=? where BusID=? ";
                            try {
                                PreparedStatement psmt=connection.prepareStatement(editQuery);
                                psmt.setInt(1,luxurySeats);
                                psmt.setInt(2,id);
                                psmt.executeUpdate();
                                System.out.println("Updated");
                            } catch (SQLException ex) {
                                throw new RuntimeException(ex);
                            }

                        }

                        if(firstClassCheckbox.isSelected())
                        {
                            int id=Integer.parseInt(busIDVal);
                            recTable.setValueAt(firstClassSeatTxt.getText(), i, 8); // Update  First Class Seat

                            int econSeats= Integer.parseInt( recTable.getValueAt(i,6).toString());
                            int luxurySeats= Integer.parseInt( recTable.getValueAt(i,7).toString());
                            int firstCSeat=Integer.parseInt( firstClassSeatTxt.getText());
                            int totalSeats=0;
                            totalSeats=firstCSeat+econSeats+luxurySeats;
                            recTable.setValueAt(Integer.toString(totalSeats), i, 9);

                            String firstClassSeats = generateSeatRange("F", 1, firstCSeat);
                            recTable.setValueAt(firstClassSeats,i,12);
                            String editQuery="update Bus set FirstClassSeats=? where BusID=? ";
                            try {
                                PreparedStatement psmt=connection.prepareStatement(editQuery);
                                psmt.setInt(1,luxurySeats);
                                psmt.setInt(2,id);
                                psmt.executeUpdate();
                                System.out.println("Updated");
                            } catch (SQLException ex) {
                                throw new RuntimeException(ex);
                            }
                        }

                        if(availabilityCheckbox.isSelected())
                        {
                            int id=Integer.parseInt(busIDVal);
                            recTable.setValueAt(status, i, 14); // Update Status
                            String editQuery="update Bus set Availability=? where BusID=? ";
                            try {
                                PreparedStatement psmt=connection.prepareStatement(editQuery);
                                psmt.setString(1,status);
                                psmt.setInt(2,id);
                                psmt.executeUpdate();
                            } catch (SQLException ex)
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

        economyCheckbox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(economyCheckbox.isSelected())
                {
                    economySeatLabel.setVisible(true);
                    economySeatTxt.setVisible(true);

                }
                else {
                    economySeatLabel.setVisible(false);
                    economySeatTxt.setVisible(false);

                }

                if(economyCheckbox.isSelected()||luxuryCheckbox.isSelected()||firstClassCheckbox.isSelected()||availabilityCheckbox.isSelected())
                {
                    editButton.setVisible(true);
                }
                else{
                    editButton.setVisible(false);
                }
            }

        });

        luxuryCheckbox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(luxuryCheckbox.isSelected())
                {
                    luxurySeatLabel.setVisible(true);
                    luxurySeatTxt.setVisible(true);

                }
                else {
                    luxurySeatLabel.setVisible(false);
                    luxurySeatTxt.setVisible(false);

                }
                if(economyCheckbox.isSelected()||luxuryCheckbox.isSelected()||firstClassCheckbox.isSelected()||availabilityCheckbox.isSelected())
                {
                    editButton.setVisible(true);
                }
                else{
                    editButton.setVisible(false);
                }
            }
        });

        firstClassCheckbox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(firstClassCheckbox.isSelected())
                {
                    firstClassSeatLabel.setVisible(true);
                    firstClassSeatTxt.setVisible(true);
                }
                else {
                    firstClassSeatLabel.setVisible(false);
                    firstClassSeatTxt.setVisible(false);

                }
                if(economyCheckbox.isSelected()||luxuryCheckbox.isSelected()||firstClassCheckbox.isSelected()||availabilityCheckbox.isSelected())
                {
                    editButton.setVisible(true);
                }
                else{
                    editButton.setVisible(false);
                }
            }
        });
        availabilityCheckbox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(availabilityCheckbox.isSelected())
                {
                    availabilityLabel.setVisible(true);
                    availabilityCombobox.setVisible(true);

                }
                else {
                    availabilityLabel.setVisible(false);
                    availabilityCombobox.setVisible(false);

                }
                if(economyCheckbox.isSelected()||luxuryCheckbox.isSelected()||firstClassCheckbox.isSelected()||availabilityCheckbox.isSelected())
                {
                    editButton.setVisible(true);
                }
                else{
                    editButton.setVisible(false);
                }
            }
        });



        editDialog.add(editRecLabel);
        editDialog.add(busIDLabel);
        editDialog.add(busIDTxt);
        editDialog.add(searchButton);
        editDialog.add(firstClassCheckbox);
        editDialog.add(economyCheckbox);
        editDialog.add(luxuryCheckbox);
        editDialog.add(availabilityCheckbox);
        editDialog.add(economySeatLabel);
        editDialog.add(economySeatTxt);
        editDialog.add(luxurySeatLabel);
        editDialog.add(luxurySeatTxt);
        editDialog.add(firstClassSeatLabel);
        editDialog.add(firstClassSeatTxt);
        editDialog.add(availabilityLabel);
        editDialog.add(availabilityCombobox);
        editDialog.add(editButton);


        editDialog.setVisible(true);

    }

    private String generateSeatRange(String prefix, int start, int count) {
        if (count == 0) return "";

        StringBuilder seatRange = new StringBuilder();
        seatRange.append(prefix).append(start);
        if (count > 1) {
            seatRange.append("-").append(prefix).append(start + count - 1);
        }
        return seatRange.toString();
    }


    public static void main(String[] args) {
        new ManageBus("Dummy");
    }
}
