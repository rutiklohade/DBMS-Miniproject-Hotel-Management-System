import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import net.proteanit.sql.DbUtils;

import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

public class AddRooms {

	public JFrame frame;
	private JTextField textField1;
	private JTextField textField2;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddRooms window = new AddRooms();
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
	public AddRooms() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(400, 200, 988, 477);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel addrooms = new JLabel("ADD ROOMS");
		addrooms.setFont(new Font("Serif", Font.BOLD, 18));
		addrooms.setBounds(164, 39, 121, 29);
		frame.getContentPane().add(addrooms);
		
		JLabel roomno = new JLabel("Room Number :");
		roomno.setFont(new Font("Tahoma", Font.PLAIN, 16));
		roomno.setBounds(72, 93, 127, 29);
		frame.getContentPane().add(roomno);
		
		JLabel avalible = new JLabel("Avalible :");
		avalible.setFont(new Font("Tahoma", Font.PLAIN, 16));
		avalible.setBounds(72, 144, 127, 29);
		frame.getContentPane().add(avalible);
		
		JLabel cleaningStatus = new JLabel("CleaningStatus :");
		cleaningStatus.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cleaningStatus.setBounds(72, 196, 127, 29);
		frame.getContentPane().add(cleaningStatus);
		
		JLabel bedtype = new JLabel("Bed Type :");
		bedtype.setFont(new Font("Tahoma", Font.PLAIN, 16));
		bedtype.setBounds(72, 243, 127, 29);
		frame.getContentPane().add(bedtype);
		
		textField1 = new JTextField();
		textField1.setBounds(222, 95, 151, 29);
		frame.getContentPane().add(textField1);
		textField1.setColumns(10);
		
		textField2 = new JTextField();
		textField2.setColumns(10);
		textField2.setBounds(222, 289, 151, 29);
		frame.getContentPane().add(textField2);
		
		JComboBox comboBox1 = new JComboBox(new String[] {"Available","Occupied" });
		comboBox1.setBackground(Color.WHITE);
		comboBox1.setBounds(222, 146, 151, 29);
		frame.getContentPane().add(comboBox1);
		
		JComboBox comboBox2 = new JComboBox(new String[] {"Cleaned","Dirty" });
		comboBox2.setBackground(Color.WHITE);
		comboBox2.setBounds(222, 196, 151, 29);
		frame.getContentPane().add(comboBox2);
		
		JLabel price = new JLabel("Price :");
		price.setFont(new Font("Tahoma", Font.PLAIN, 16));
		price.setBounds(72, 287, 127, 29);
		frame.getContentPane().add(price);
		
		JComboBox comboBox3 = new JComboBox(new String[] {"Single Bed","Double Bed" });
		comboBox3.setBackground(Color.WHITE);
		comboBox3.setBounds(222, 245, 151, 29);
		frame.getContentPane().add(comboBox3);
		
		JButton addRoombt = new JButton("ADD ROOM");
		addRoombt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 try{
				
				if(e.getSource()== addRoombt){
				    String roomno = textField1.getText();
				    String ava = (String)comboBox1.getSelectedItem();
				    String status = (String)comboBox2.getSelectedItem();
				    String price= textField2.getText();
				    String bedt =(String)comboBox3.getSelectedItem();
				    
				    
				    
				   
				    	Class.forName("com.mysql.cj.jdbc.Driver");
						
						Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/prohotelms","root","Rutik@1008");
						
						Statement statement = connection.createStatement();
				    	
				        String str = "insert into room values('"+roomno+"','"+ava+"','"+status+"','"+price+"','"+bedt+"')";
				      //  String str1 = "select * from room";
				        statement.executeUpdate(str);
				        
				      //  ResultSet rs = statement.executeQuery(str1);
				       // table.setModel(DbUtils.resultSetToTableModel(rs));
				        JOptionPane.showMessageDialog(null,"New Room Added");
				        
				        connection.close();
				        textField1.setText("");
				        textField2.setText("");
				        comboBox1.setSelectedItem("");
				        comboBox2.setSelectedItem("");
				        comboBox3.setSelectedItem("");
				        //this.setVisible(true);
				}
				    }catch(Exception ex){
				        System.out.println(ex);
				    }
				
				
			
			}
		});
		addRoombt.setForeground(Color.WHITE);
		addRoombt.setBackground(Color.BLACK);
		addRoombt.setFont(new Font("Tahoma", Font.BOLD, 12));
		addRoombt.setBounds(85, 352, 121, 29);
		frame.getContentPane().add(addRoombt);
		
		JButton cancle = new JButton("CANCLE");
		cancle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		cancle.setBackground(Color.BLACK);
		cancle.setForeground(Color.WHITE);
		cancle.setFont(new Font("Tahoma", Font.BOLD, 12));
		cancle.setBounds(222, 352, 121, 29);
		frame.getContentPane().add(cancle);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new EmptyBorder(0, 0, 0, 0));
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(420, 93, 526, 288);
		scrollPane.setBackground(Color.WHITE);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setBackground(Color.WHITE);
		scrollPane.setColumnHeaderView(table);
		
		JLabel roominfo = new JLabel("Room Information");
		roominfo.setFont(new Font("Serif", Font.BOLD, 18));
		roominfo.setBounds(625, 39, 151, 29);
		frame.getContentPane().add(roominfo);
		
		JButton display = new JButton("DISPLAY ROOMS");
		display.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try{
					
					if(e.getSource()== display){
					    String roomno = textField1.getText();
					    String ava = (String)comboBox1.getSelectedItem();
					    String status = (String)comboBox2.getSelectedItem();
					    String price= textField2.getText();
					    String bedt =(String)comboBox3.getSelectedItem();
					    
					    
					    
					   
					    	Class.forName("com.mysql.cj.jdbc.Driver");
							
							Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/prohotelms","root","Rutik@1008");
							
							Statement statement = connection.createStatement();
					    	
					       
					        String str1 = "select * from room";
					       
					        
					        ResultSet rs = statement.executeQuery(str1);
					        table.setModel(DbUtils.resultSetToTableModel(rs));
					        
					        
					       
					        //this.setVisible(true);
					}
					    }catch(Exception ex){
					        System.out.println(ex);
					    }
				
			}
		});
		display.setForeground(Color.WHITE);
		display.setFont(new Font("Tahoma", Font.BOLD, 12));
		display.setBackground(Color.BLACK);
		display.setBounds(130, 391, 169, 29);
		frame.getContentPane().add(display);
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
}
