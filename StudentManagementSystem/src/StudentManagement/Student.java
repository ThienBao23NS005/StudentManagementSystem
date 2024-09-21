package StudentManagement;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;
import javax.swing.GroupLayout.*;
import javax.swing.LayoutStyle.*;
import javax.swing.border.EmptyBorder;

public class Student extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField id;
	private JTextField email;
	private JTextField contact;
	private JTextField add;
	private JTextField score;
	
	
	Connection con = null;
	PreparedStatement pst = null;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Student frame = new Student();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public Student() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 650);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		
		JLabel studentDetails = new JLabel("Student Details");
		studentDetails.setForeground(Color.BLACK);
		studentDetails.setFont(new Font("Perpetua Titling MT", Font.BOLD, 22));
		
		JLabel studentName = new JLabel("Student Name");
		studentName.setForeground(Color.BLACK);
		studentName.setFont(new Font("Perpetua Titling MT", Font.BOLD, 14));
		
		JLabel idNumber = new JLabel("ID Number");
		idNumber.setForeground(Color.BLACK);
		idNumber.setFont(new Font("Perpetua Titling MT", Font.BOLD, 14));
		
		JLabel emailAddress = new JLabel("Email Address");
		emailAddress.setForeground(Color.BLACK);
		emailAddress.setFont(new Font("Perpetua Titling MT", Font.BOLD, 14));
		
		JLabel contactNumber = new JLabel("Contact Number");
		contactNumber.setForeground(Color.BLACK);
		contactNumber.setFont(new Font("Perpetua Titling MT", Font.BOLD, 14));
		
		name = new JTextField();
		name.setColumns(10);
		
		id = new JTextField();
		id.setColumns(10);
		
		email = new JTextField();
		email.setColumns(10);
		
		contact = new JTextField();
		contact.setColumns(10);
		
		JLabel address = new JLabel("Address");
		address.setForeground(Color.BLACK);
		address.setFont(new Font("Perpetua Titling MT", Font.BOLD, 14));
		
		JLabel scores = new JLabel("Score");
		scores.setForeground(Color.BLACK);
		scores.setFont(new Font("Perpetua Titling MT", Font.BOLD, 14));
		
		score = new JTextField();
		score.setColumns(10);
		
		JButton submit = new JButton("Submit");
		submit.setForeground(Color.BLACK);
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String query = "INSERT INTO `student`(`name`, `id`, `email`, `contactnumber`, `address`, `score`) VALUES (?, ?, ?, ?, ?, ?)";
					con = DriverManager.getConnection("jdbc:mysql://localhost/studentmanagementsystem", "root", "1234");
					pst=con.prepareStatement(query);
					pst.setString(1, name.getText());
					pst.setString(2, id.getText());
					pst.setString(3, email.getText());
					pst.setString(4, contact.getText());
					pst.setString(5, add.getText());
					pst.setString(6, score.getText());
					if(name.getText().equals("") || id.getText().equals("") || email.getText().equals("") || contact.getText().equals("") || add.getText().equals("")|| score.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Fill all the details :(");
					}
					else {
						pst.executeUpdate();
						JOptionPane.showMessageDialog(null, "Student added Successfully :)");
						dispose();
						Menu menu = new Menu();
						menu.show();
					}
				}
				catch(Exception ex) {
					JOptionPane.showMessageDialog(null, ex);
				}
				
			}
		});
		submit.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		add = new JTextField();
		add.setColumns(10);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.GRAY);
		
		JButton btnNewButton = new JButton("Cancel");
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu menu = new Menu();
				menu.show();
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JDesktopPane desktopPane_1 = new JDesktopPane();
		desktopPane_1.setBackground(Color.GRAY);
		
		JDesktopPane desktopPane_2 = new JDesktopPane();
		desktopPane_2.setBackground(Color.GRAY);
		
		JDesktopPane desktopPane_3 = new JDesktopPane();
		desktopPane_3.setBackground(Color.GRAY);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
		gl_contentPane.createParallelGroup(Alignment.LEADING)
		.addComponent(desktopPane, GroupLayout.DEFAULT_SIZE, 573, Short.MAX_VALUE)
		.addGroup(gl_contentPane.createSequentialGroup()
		.addComponent(desktopPane_1, GroupLayout.PREFERRED_SIZE, 563, GroupLayout.PREFERRED_SIZE)
		.addContainerGap())
		.addGroup(gl_contentPane.createSequentialGroup()
		.addComponent(desktopPane_2, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
		.addPreferredGap(ComponentPlacement.RELATED)
		.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
		.addGroup(gl_contentPane.createSequentialGroup()
		.addGap(43)
		.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
		.addComponent(idNumber)
		.addComponent(studentName, GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
		.addComponent(emailAddress)
		.addComponent(contactNumber)
		.addComponent(address)
		.addComponent(scores))
		.addPreferredGap(ComponentPlacement.RELATED)
		.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
		.addComponent(contact, 242, 242, 242)
		.addComponent(add, 247, 247, 247)
		.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
		.addComponent(email)
		.addComponent(name)
		.addComponent(score)
		.addComponent(id, GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)))
		.addGap(34))
		.addGroup(gl_contentPane.createSequentialGroup()
		.addPreferredGap(ComponentPlacement.RELATED, 125, Short.MAX_VALUE)
		.addComponent(studentDetails)
		.addGap(137))
		.addGroup(gl_contentPane.createSequentialGroup()
		.addGap(119)
		.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
		.addComponent(btnNewButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		.addComponent(submit, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE))
		.addGap(128)))
		.addPreferredGap(ComponentPlacement.RELATED)
		.addComponent(desktopPane_3, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
		.addGap(18))
		);
		gl_contentPane.setVerticalGroup(
		gl_contentPane.createParallelGroup(Alignment.LEADING)
		.addGroup(gl_contentPane.createSequentialGroup()
		.addComponent(desktopPane, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
		.addGap(11)
		.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
		.addGroup(gl_contentPane.createSequentialGroup()
		.addComponent(studentDetails)
		.addGap(18)
		.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
		.addComponent(studentName, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
		.addComponent(name, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
		.addGap(28)
		.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
		.addComponent(id, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
		.addComponent(idNumber))
		.addGap(41)
		.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
		.addComponent(email, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
		.addComponent(emailAddress))
		.addGap(37)
		.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
		.addComponent(contactNumber)
		.addComponent(contact, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
		.addGap(41)
		.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
		.addComponent(add, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
		.addComponent(address))
		.addGap(43)
		.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
	    .addComponent(scores)
	    .addComponent(score, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
	    .addGap(31)
		.addComponent(submit, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
		.addGap(18)
		.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
		.addGroup(gl_contentPane.createSequentialGroup()
		.addPreferredGap(ComponentPlacement.RELATED)
		.addComponent(desktopPane_2, GroupLayout.PREFERRED_SIZE, 506, GroupLayout.PREFERRED_SIZE))
		.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
		.addPreferredGap(ComponentPlacement.UNRELATED)
		.addComponent(desktopPane_3, GroupLayout.PREFERRED_SIZE, 506, GroupLayout.PREFERRED_SIZE)
		.addPreferredGap(ComponentPlacement.RELATED)))
		.addGap(13)
		.addComponent(desktopPane_1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
		.addGap(6))
		);
		contentPane.setLayout(gl_contentPane);
	}

}