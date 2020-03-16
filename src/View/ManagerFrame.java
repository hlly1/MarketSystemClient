package View;

import java.awt.EventQueue;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Modle.User;
import Util.DataGetUtil;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ManagerFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagerFrame frame = new ManagerFrame();
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
	public ManagerFrame() {
		setTitle("Manager Maintain System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 721, 544);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("Item Maintain");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent item) {
				DataGetUtil dgu = new DataGetUtil();
				ItemMainFrame imf = new ItemMainFrame();
				dispose();
				imf.setVisible(true);
			}
		});
		
		JButton btnSupplierMaintain = new JButton("Supplier Details");
		btnSupplierMaintain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				SupplierMainFrame smf = new SupplierMainFrame();
				smf.setVisible(true);
			}
		});
		
		JButton btnReleaseDiscount = new JButton("Release Discount");
		btnReleaseDiscount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				DiscountFrame df = new DiscountFrame();
				df.setVisible(true);
				
			}
		});
		
		JButton btnSaleReport = new JButton("Sale Report");
		btnSaleReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				SaleReportFrame srf = new SaleReportFrame();
				srf.setVisible(true);
			}
		});
		
		JLabel lblNewLabel = new JLabel("Welcome: Manager Tim!");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 40));
		
		JButton btnNewButton_1 = new JButton("Log out");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent managerLogOut) {
				//0 for yes, 1 for no, 2 for cancel
				int check = JOptionPane.showConfirmDialog(null, "Are you sure to exit?");
				if (check == 0) {
					managerLogOutAction(managerLogOut);
				}
				
			}

		});
		
		JButton btnSupplyReport = new JButton("Supply Report");
		btnSupplyReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {	
				dispose();
				GenerateSupperFrame gsf = new GenerateSupperFrame();
				gsf.setVisible(true);	
			}
		});
		
		JButton btnPopularProduct = new JButton("Popular Product");
		btnPopularProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				PopularFrame pf = new PopularFrame();
				pf.setVisible(true);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(33)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(btnNewButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnSupplierMaintain, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnReleaseDiscount, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnPopularProduct, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE))
					.addGap(40)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnSupplyReport, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSaleReport, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(37, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(138, Short.MAX_VALUE)
					.addComponent(lblNewLabel)
					.addGap(143))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(299, Short.MAX_VALUE)
					.addComponent(btnNewButton_1)
					.addGap(305))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(41)
					.addComponent(lblNewLabel)
					.addGap(91)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
							.addGap(31)
							.addComponent(btnSupplierMaintain, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnSaleReport, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnReleaseDiscount, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnPopularProduct, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnSupplyReport, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE))))
					.addPreferredGap(ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
					.addComponent(btnNewButton_1)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
		
		this.setLocationRelativeTo(null);
	}
	
	//For manager to logout
	private void managerLogOutAction(ActionEvent managerLogOut) {
		// TODO Auto-generated method stub
		System.exit(0);
	}
	

	
	
	
	
	
	
	
}
