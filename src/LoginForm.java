import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

import javax.swing.Icon;
import javax.swing.ImageIcon;
public class LoginForm extends JFrame {

	public JFrame frame;
	public JTextField username;
	public JTextField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginForm window = new LoginForm();
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
	public LoginForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\RUTIK\\eclipse-workspace\\MiniProject\\src\\login.png"));
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(590, 300, 420, 380);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel loginlabel = new JLabel("LOGIN");
		loginlabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
		loginlabel.setBounds(166, 10, 80, 29);
		frame.getContentPane().add(loginlabel);
		
		JLabel usernamelable = new JLabel("UserName :");
		usernamelable.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		usernamelable.setBounds(76, 118, 99, 21);
		frame.getContentPane().add(usernamelable);
		
		JLabel passwordlabel = new JLabel("Password :");
		passwordlabel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		passwordlabel.setBounds(76, 188, 99, 21);
		frame.getContentPane().add(passwordlabel);
		
		username = new JTextField();
		username.setToolTipText("username");
		username.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		username.setBounds(76, 149, 281, 29);
		frame.getContentPane().add(username);
		username.setColumns(10);
		
		password = new JPasswordField();
		password.setBounds(76, 219, 281, 29);
		frame.getContentPane().add(password);
		
		JButton login = new JButton("LOGIN");
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
						
					
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/prohotelms","root","Rutik@1008");
					
					Statement statement = connection.createStatement();
					
					String un = username.getText();
					String pass = password.getText();
					
					String str= "select * from login where username= '"+un+"' and password = '"+pass+"'";
					ResultSet rs = statement.executeQuery(str);
					
					if(rs.next()) {
						
						
							
					JOptionPane.showMessageDialog(null, "login Succsss..!");
					Dashboard dashboard =new Dashboard();
					dashboard.frame.setVisible(true);
								frame.dispose();
					}
					else {
						JOptionPane.showMessageDialog(null, "Invalid UserName and Password..!");
					} 
					
					connection.close();
					username.setText("");
					password.setText("");
					
				}catch(Exception ex) {
					ex.printStackTrace();
				}
				
				
				
			}

			private void setVisible(boolean b) {
				// TODO Auto-generated method stub
				
			}

			
		});
		login.setForeground(Color.WHITE);
		login.setBackground(Color.BLACK);
		login.setFont(new Font("Times New Roman", Font.BOLD, 18));
		login.setBounds(76, 284, 126, 29);
		frame.getContentPane().add(login);
		
		JButton cancle = new JButton("CANCLE");
		cancle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
			}
		});
		cancle.setForeground(Color.WHITE);
		cancle.setFont(new Font("Times New Roman", Font.BOLD, 18));
		cancle.setBackground(Color.BLACK);
		cancle.setBounds(213, 284, 126, 29);
		frame.getContentPane().add(cancle);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon((Icon) new ImageIcon("C:\\Users\\RUTIK\\eclipse-workspace\\MiniProject\\src\\login.png").getImage().getScaledInstance(71, 61,Image.SCALE_DEFAULT));
		lblNewLabel.setBounds(176, 50, 71, 61);
		frame.getContentPane().add(lblNewLabel);
	}
}
