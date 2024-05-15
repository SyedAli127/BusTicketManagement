import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Main extends JFrame {

    public Main() {
        String[][] data = {
                {"123","25-05-21","Karachi","Lahore","26-5-21","2","600","Luxury"},
                {"123","25-05-21","Karachi","Lahore","26-5-21","2","600","Luxury"},
                {"123","25-05-21","Karachi","Lahore","26-5-21","2","600","Luxury"},
                {"123","25-05-21","Karachi","Lahore","26-5-21","2","600","Luxury"},
                {"123","25-05-21","Karachi","Lahore","26-5-21","2","600","Luxury"},{"123","25-05-21","Karachi","Lahore","26-5-21","2","600","Luxury"},
                {"123","25-05-21","Karachi","Lahore","26-5-21","2","600","Luxury"},
                {"123","25-05-21","Karachi","Lahore","26-5-21","2","600","Luxury"},
                {"123","25-05-21","Karachi","Lahore","26-5-21","2","600","Luxury"},
                {"123","25-05-21","Karachi","Lahore","26-5-21","2","600","Luxury"},{"123","25-05-21","Karachi","Lahore","26-5-21","2","600","Luxury"},
                {"123","25-05-21","Karachi","Lahore","26-5-21","2","600","Luxury"},
                {"123","25-05-21","Karachi","Lahore","26-5-21","2","600","Luxury"},
                {"123","25-05-21","Karachi","Lahore","26-5-21","2","600","Luxury"},
                {"123","25-05-21","Karachi","Lahore","26-5-21","2","600","Luxury"},
        };

        String[] columnNames = {"Order No.","Date of Booking","Departure","Arrival","Departure Date","Total Seat","Ticket Price","Bus-type"};

        JLabel label = new JLabel();
        label.setText("Refund Request Form");
        label.setFont(new Font("Arial", Font.BOLD, 21));
        label.setForeground(Color.orange);
        label.setBounds(190, 20, 280, 25);

        JTable table = new JTable(data, columnNames);
        table.setBounds(50, 80, 500, 200);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(50, 80, 500, 200);

        setLayout(null);
        setSize(600, 600);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        getContentPane().setBackground(Color.darkGray);
        setTitle("Refund Page");
        setLocationRelativeTo(null);

        add(label);
        add(scrollPane);
    }

    public static void main(String[] args) {
        Main mn = new Main();
    }
}
