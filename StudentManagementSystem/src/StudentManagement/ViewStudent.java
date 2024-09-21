package StudentManagement;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class ViewStudent extends JFrame {

    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs;

    private JPanel contentPane;
    private JTable studentTable;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ViewStudent frame = new ViewStudent();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public ViewStudent() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 782, 611);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        contentPane.setBackground(Color.WHITE);

        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        contentPane.setLayout(gl_contentPane);

        JButton btnNewButton = new JButton("Go Back");
        btnNewButton.setForeground(Color.BLACK);
        btnNewButton.addActionListener(e -> {
            Menu menu = new Menu();
            menu.show();
            dispose();
        });
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));

        JLabel lblStudentDetails = new JLabel("Student Details :");
        lblStudentDetails.setForeground(Color.BLACK);
        lblStudentDetails.setFont(new Font("Tahoma", Font.BOLD, 28));

        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("Name");
        tableModel.addColumn("ID");
        tableModel.addColumn("Email");
        tableModel.addColumn("Contact Number");
        tableModel.addColumn("Address");
        tableModel.addColumn("Score");

        studentTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(studentTable);

        GroupLayout.Group hGroup = gl_contentPane.createSequentialGroup()
                .addComponent(lblStudentDetails)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(scrollPane)
                .addComponent(btnNewButton);

        GroupLayout.Group vGroup = gl_contentPane.createSequentialGroup()
                .addComponent(lblStudentDetails)
                .addComponent(scrollPane)
                .addComponent(btnNewButton);

        gl_contentPane.setHorizontalGroup(hGroup);
        gl_contentPane.setVerticalGroup(vGroup);

        displayStudentInformation(tableModel);

        setLocationRelativeTo(null); 
    }

    private void displayStudentInformation(DefaultTableModel tableModel) {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/studentmanagementsystem", "root", "1234");
            String query = "SELECT * FROM student";
            pst = con.prepareStatement(query);
            rs = pst.executeQuery();

            while (rs.next()) {
                String name = rs.getString("name");
                String id = rs.getString("id");
                String email = rs.getString("email");
                String contact = rs.getString("contactnumber");
                String address = rs.getString("address");
                String score = rs.getString("score");

                tableModel.addRow(new String[]{name, id, email, contact, address, score});
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        } finally {
            try {
                if (rs != null) rs.close();
                if (pst != null) pst.close();
                if (con != null) con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
