package View;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import DataAccessObject.UserDAO;
import Modle.User;

public class LoginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField usernameField;
	private JPasswordField passwordField;
	private UserDAO dao = new UserDAO() ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginFrame() {
		setTitle("System Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 634, 332);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblSupermarketSupportSystem = new JLabel("Supermarket Support System");
		lblSupermarketSupportSystem.setFont(new Font("Calibri", Font.PLAIN, 37));
		
		JLabel lblUsername = new JLabel("Username :");
		
		JLabel lblPassword = new JLabel("Password :");
		
		usernameField = new JTextField();
		usernameField.setColumns(10);
		
		passwordField = new JPasswordField();
		
		JButton btnLogIn = new JButton("Log in");
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent login) {
				
					try {
						loginAction(login);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			
			}
			
			
			
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(82)
							.addComponent(lblSupermarketSupportSystem, GroupLayout.PREFERRED_SIZE, 466, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(148)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblUsername)
									.addGap(18)
									.addComponent(usernameField, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblPassword)
									.addGap(18)
									.addComponent(passwordField))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(260)
							.addComponent(btnLogIn)))
					.addContainerGap(58, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(22)
					.addComponent(lblSupermarketSupportSystem, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
					.addGap(39)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUsername)
						.addComponent(usernameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPassword)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
					.addComponent(btnLogIn)
					.addGap(24))
		);
		contentPane.setLayout(gl_contentPane);
		
		this.setLocationRelativeTo(null);
	}
	

	// For login action
	private void loginAction(ActionEvent login) throws Exception {
		// TODO Auto-generated method stub
		String userName = this.usernameField.getText();
		String passwd = new String(this.passwordField.getPassword());
		
		if(userName.isEmpty() == true) {
			JOptionPane.showMessageDialog(null, "Error: Username cannot be empty!");
			return;
		}
		
		if(passwd.isEmpty() == true) {
			JOptionPane.showMessageDialog(null, "Error: Password cannnot be empty!");
			return;
		}
		
		
		User userWhoLogin = new User(userName,passwd);
		User current = dao.login(userWhoLogin);
		
		if(current == null) {
			JOptionPane.showMessageDialog(null, "Username and Password might be wrong!");
		}else if(current.getUserName().equals("tim")){
			
			dispose();
			ManagerFrame man = new ManagerFrame();
			man.setVisible(true);
			JOptionPane.showMessageDialog(null, "Login Successful!");
			
		}else if(current.getUserName().equals("kim")) {
			dispose();
			SaleStaffFrame sf = new SaleStaffFrame();
			sf.setVisible(true);
			JOptionPane.showMessageDialog(null, "Login Successful!");
		}else if(current.getUserName().equals("cus01") || current.getUserName().equals("cus02")) {
			dispose();
			CustomerFrame cf = new CustomerFrame();
			cf.setVisible(true);
			JOptionPane.showMessageDialog(null, "Login Successful!");
		}else if(current.getUserName().equals("frank")) {
			dispose();
			SaleStaffFrame ssf = new SaleStaffFrame();
			ssf.setVisible(true);
		}
		
		
		
		
		
		
	}
}
