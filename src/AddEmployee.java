import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

import net.proteanit.sql.DbUtils;

import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JTable;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
public class AddEmployee {

	private JFrame frame;
	private JTextField namet;
	private JTextField aget;
	private JTextField salaryt;
	private JTextField mobt;
	private JTextField emailt;
	private JTable table;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddEmployee window = new AddEmployee();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AddEmployee() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setFont(new Font("Serif", Font.PLAIN, 10));
		frame.setBounds(250, 150, 1175, 522);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel namelb = new JLabel("Name :");
		namelb.setFont(new Font("Serif", Font.PLAIN, 18));
		namelb.setForeground(Color.BLACK);
		namelb.setBackground(Color.WHITE);
		namelb.setBounds(86, 71, 130, 30);
		frame.getContentPane().add(namelb);
		
		JLabel agelb = new JLabel("Age :");
		agelb.setForeground(Color.BLACK);
		agelb.setFont(new Font("Serif", Font.PLAIN, 18));
		agelb.setBackground(Color.WHITE);
		agelb.setBounds(86, 111, 130, 30);
		frame.getContentPane().add(agelb);
		
		JLabel genderlb = new JLabel("Gender :");
		genderlb.setForeground(Color.BLACK);
		genderlb.setFont(new Font("Serif", Font.PLAIN, 18));
		genderlb.setBackground(Color.WHITE);
		genderlb.setBounds(86, 151, 130, 30);
		frame.getContentPane().add(genderlb);
		
		JLabel joblb = new JLabel("Job :");
		joblb.setForeground(Color.BLACK);
		joblb.setFont(new Font("Serif", Font.PLAIN, 18));
		joblb.setBackground(Color.WHITE);
		joblb.setBounds(86, 191, 130, 30);
		frame.getContentPane().add(joblb);
		
		JLabel salarylb = new JLabel("Salary :");
		salarylb.setForeground(Color.BLACK);
		salarylb.setFont(new Font("Serif", Font.PLAIN, 18));
		salarylb.setBackground(Color.WHITE);
		salarylb.setBounds(86, 231, 130, 30);
		frame.getContentPane().add(salarylb);
		
		JLabel mobilelb = new JLabel("Mobile Number :");
		mobilelb.setForeground(Color.BLACK);
		mobilelb.setFont(new Font("Serif", Font.PLAIN, 18));
		mobilelb.setBackground(Color.WHITE);
		mobilelb.setBounds(86, 271, 130, 30);
		frame.getContentPane().add(mobilelb);
		
		JLabel emaillb = new JLabel("Email :");
		emaillb.setForeground(Color.BLACK);
		emaillb.setFont(new Font("Serif", Font.PLAIN, 18));
		emaillb.setBackground(Color.WHITE);
		emaillb.setBounds(86, 311, 130, 30);
		frame.getContentPane().add(emaillb);
		
		namet = new JTextField();
		namet.setBounds(226, 75, 200, 30);
		frame.getContentPane().add(namet);
		namet.setColumns(10);
		
		aget = new JTextField();
		aget.setColumns(10);
		aget.setBounds(226, 115, 200, 30);
		frame.getContentPane().add(aget);
		
		salaryt = new JTextField();
		salaryt.setColumns(10);
		salaryt.setBounds(226, 235, 200, 30);
		frame.getContentPane().add(salaryt);
		
		mobt = new JTextField();
		mobt.setColumns(10);
		mobt.setBounds(226, 275, 200, 30);
		frame.getContentPane().add(mobt);
		
		emailt = new JTextField();
		emailt.setColumns(10);
		emailt.setBounds(226, 315, 200, 30);
		frame.getContentPane().add(emailt);
		
		
        ButtonGroup bg = new ButtonGroup();
		
		
		
		
		JRadioButton male = new JRadioButton("Male");
		male.setForeground(Color.BLACK);
		male.setBackground(Color.WHITE);
		male.setFont(new Font("Serif", Font.PLAIN, 16));
		male.setBounds(226, 157, 64, 21);
		bg.add(male);
		frame.getContentPane().add(male);
		
		JRadioButton female = new JRadioButton("Female");
		female.setForeground(Color.BLACK);
		female.setFont(new Font("Serif", Font.PLAIN, 16));
		female.setBackground(Color.WHITE);
		female.setBounds(292, 157, 71, 21);
		bg.add(female);
		frame.getContentPane().add(female);
		
		JRadioButton other = new JRadioButton("Other");
		other.setForeground(Color.BLACK);
		other.setFont(new Font("Serif", Font.PLAIN, 16));
		other.setBackground(Color.WHITE);
		other.setBounds(365, 157, 71, 21);
		bg.add(other);
		frame.getContentPane().add(other);
		
		
		String s[] = {"Front Desk Clerk","Manager","Room Service","House Keeping","Kitechen Staff","Waiter/Waitress","Accountant"};
		JComboBox job = new JComboBox(s);
		job.setFont(new Font("Serif", Font.PLAIN, 16));
		job.setBackground(Color.WHITE);
		job.setForeground(Color.BLACK);
		job.setBounds(226, 192, 200, 30);
		frame.getContentPane().add(job);
		
		JButton addemployee = new JButton("ADD");
		addemployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/prohotelms","root","Rutik@1008");
					Statement statement = connection.createStatement();
					
					String nm = namet.getText();
					String age = aget.getText();
					String gender = null;
					
					if(male.isSelected()) {
						gender = "Male";
					}else if(female.isSelected()) {
						gender = "Female";
					}else if(other.isSelected()) {
						gender = "Other";
					}
					
					String jo = (String) job.getSelectedItem();
					String salary = salaryt.getText();
					String mob = mobt.getText();
					String email = emailt.getText();
					
					
					
					String sql = "insert into emp values('"+nm+"','"+age+"','"+gender+"','"+jo+"','"+salary+"','"+mob+"','"+email+"')";
					statement.executeUpdate(sql);
					
					JOptionPane.showMessageDialog(null, "Employee added ..!");
					
					
					
				}catch(Exception ex) {
					ex.printStackTrace();
				}
				
				
				
				
			}
		});
		addemployee.setForeground(Color.WHITE);
		addemployee.setBackground(Color.BLACK);
		addemployee.setFont(new Font("Serif", Font.BOLD, 16));
		addemployee.setBounds(113, 379, 130, 30);
		frame.getContentPane().add(addemployee);
		
		JButton cancle = new JButton("CANCLE");
		cancle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
			
		});
		cancle.setForeground(Color.WHITE);
		cancle.setFont(new Font("Serif", Font.BOLD, 18));
		cancle.setBackground(Color.BLACK);
		cancle.setBounds(252, 378, 130, 30);
		frame.getContentPane().add(cancle);
		
	
		
		
		
		JButton display = new JButton("Display Emloyee Information");
		display.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/prohotelms","root","Rutik@1008");
					Statement statement = connection.createStatement();
					
					String nm = namet.getText();
					String age = aget.getText();
					String gender = null;
					
					if(male.isSelected()) {
						gender = "Male";
					}else if(female.isSelected()) {
						gender = "Female";
					}else if(other.isSelected()) {
						gender = "Other";
					}
					
					String jo = (String) job.getSelectedItem();
					String salary = salaryt.getText();
					String mob = mobt.getText();
					String email = emailt.getText();
					
					
					String sql1 = "select * from emp";
					 ResultSet rs = statement.executeQuery(sql1);
				        table.setModel(DbUtils.resultSetToTableModel(rs));
					
				}catch(Exception ex) {
					ex.printStackTrace();
				}
				
			}
		});
		display.setForeground(Color.WHITE);
		display.setFont(new Font("Serif", Font.BOLD, 18));
		display.setBackground(Color.BLACK);
		display.setBounds(86, 419, 319, 30);
		frame.getContentPane().add(display);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(442, 81, 695, 374);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setColumnHeaderView(table);
		
		JLabel lblNewLabel = new JLabel("Employee Details");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setFont(new Font("Serif", Font.BOLD, 16));
		lblNewLabel.setBounds(706, 30, 147, 30);
		frame.getContentPane().add(lblNewLabel);
		
		
		
		
		
	
		
		
		
	}
}
