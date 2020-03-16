package View;

import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Modle.Cart;
import Modle.Sale;
import Util.DataGetUtil;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ReceiptFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1385005508262682757L;
	private JPanel contentPane;
	private JTable orderTable;
	private JTable itemTable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReceiptFrame frame = new ReceiptFrame();
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
	public ReceiptFrame() {
		setTitle("Receipt");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 758, 507);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblThankYouFor = new JLabel("Thank you for your purchasing!");
		lblThankYouFor.setFont(new Font("Book Antiqua", Font.BOLD, 30));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnGotItAnd = new JButton("Got it and Log out");
		btnGotItAnd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int check = JOptionPane.showConfirmDialog(null, "Are you sure to exit?");
				if (check == 0) {
					logOut(arg0);
				}
				
			}
		});
		
		JScrollPane scrollPane_1 = new JScrollPane();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(281)
					.addComponent(btnGotItAnd)
					.addContainerGap(272, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(149, Short.MAX_VALUE)
					.addComponent(lblThankYouFor)
					.addGap(143))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(219)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 258, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(253, Short.MAX_VALUE))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(80)
					.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 561, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(89, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblThankYouFor)
					.addPreferredGap(ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
					.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
					.addGap(69)
					.addComponent(btnGotItAnd)
					.addContainerGap())
		);
		
		itemTable = new JTable();
		itemTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Name", "Quantity to Buy", "Spend"
			}
		));
		scrollPane_1.setViewportView(itemTable);
		
		orderTable = new JTable();
		orderTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Customer Name", "Total Price"
			}
		));
		orderTable.getColumnModel().getColumn(0).setPreferredWidth(132);
		scrollPane.setViewportView(orderTable);
		contentPane.setLayout(gl_contentPane);
		
		this.setLocationRelativeTo(null);
		draw();
	}
	
	
	public void draw() {
		DefaultTableModel dtm1 = (DefaultTableModel) orderTable.getModel();
		DefaultTableModel dtm2 = (DefaultTableModel) itemTable.getModel();
		DataGetUtil dgu = new DataGetUtil();
		ArrayList<Sale> s = dgu.saleReportGet();
		
		for(int i = 0; i < s.size(); i++) {
			if(i == s.size() - 1) {
				ArrayList<Cart> c = s.get(i).getItems();
				for(int j = 0; j < c.size(); j++) {
					Vector v1 = new Vector();
					v1.add(c.get(j).getId());
					v1.add(c.get(j).getName());
					v1.add(c.get(j).getQuantity());
					v1.add(c.get(j).getSpend());
					dtm2.addRow(v1);
				}

				Vector v = new Vector();
				v.add(s.get(i).getCust());
				v.add(s.get(i).getDiscSpend());
				dtm1.addRow(v);
				
				
			}
		}
		
	}
	
	private void logOut(ActionEvent evt) {
		System.exit(0);
	}
	
	
	
	
	
	
}
