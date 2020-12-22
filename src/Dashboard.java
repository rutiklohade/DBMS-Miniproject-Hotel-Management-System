import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.JMenu;
import java.awt.Font;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class Dashboard {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	 Dashboard() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.setBounds(250, 150, 994, 553);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.WHITE);
		menuBar.setBounds(0, 0, 1020, 25);
		frame.getContentPane().add(menuBar);
		
		JMenu mnMenu = new JMenu("MENU");
		mnMenu.setBackground(Color.WHITE);
		mnMenu.setForeground(Color.BLUE);
		mnMenu.setFont(new Font("Segoe UI", Font.BOLD, 16));
		menuBar.add(mnMenu);
		
		JMenuItem addRooms = new JMenuItem("ADD ROOMS");
		addRooms.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AddRooms addRooms = new AddRooms();
				addRooms.frame.setVisible(true);
				
				//Dashboard dashboard = new Dashboard();
			//	dashboard.frame.setVisible(false);
			}
		});
		addRooms.setBackground(Color.WHITE);
		addRooms.setForeground(Color.BLUE);
		mnMenu.add(addRooms);
		
		JMenuItem addEmployee = new JMenuItem("ADD EMPLOYEE");
		addEmployee.setBackground(Color.WHITE);
		addEmployee.setForeground(Color.BLUE);
		mnMenu.add(addEmployee);
		
		setVisible(true);
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dashboard window = new Dashboard();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}); 
	}
}
