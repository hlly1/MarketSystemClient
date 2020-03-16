package View;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Modle.Cart;
import Modle.Customer;
import Modle.Product;
import Util.DataGetUtil;
import Util.DataWriteUtil;
import Util.QuantityAdd;

public class SaleStaffFrame extends JFrame {
	DataGetUtil dgu = new DataGetUtil();
	private DataWriteUtil dwu = new DataWriteUtil();
	private JPanel contentPane;
	private JTable cartTable;
	private JTextField idField;
	private JTextField cardField;
	private JTextField moneyField;
	private JTable cusTable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SaleStaffFrame frame = new SaleStaffFrame();
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
	public SaleStaffFrame() {
		setTitle("Sale Staff Maintain");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1216, 532);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblCustomerCart = new JLabel("Customer Cart");
		
		JLabel lblProductId = new JLabel("Product ID:");
		
		idField = new JTextField();
		idField.setColumns(10);
		
		JLabel label = new JLabel("");
		
		JButton btnRemoveItem = new JButton("Remove Item");
		btnRemoveItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				removeItem(evt);
			}

		});
		
		JLabel lblTopUpThe = new JLabel("Top up the card:");
		
		JButton btnNewButton = new JButton("Top up");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				topUpAct(arg0);
			}


		});
		
		cardField = new JTextField();
		cardField.setColumns(10);
		
		JLabel lblAddedMoney = new JLabel("Added Money:");
		
		moneyField = new JTextField();
		moneyField.setColumns(10);
		
		JButton btnBackToMenu = new JButton("Log out");
		btnBackToMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				int check = JOptionPane.showConfirmDialog(null, "Are you sure to exit?");
				if (check == 0) {
					logOutAction(evt);
				}
			}
		});
		
		JButton btnBackToShopping = new JButton("Back to Shopping Cart");
		btnBackToShopping.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				CustomerFrame cf = new CustomerFrame();
				cf.setVisible(true);
			}
		});
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		JLabel lblCustomerInformation = new JLabel("Customer Information");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(71)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblProductId)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(idField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblTopUpThe)
										.addComponent(cardField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(btnBackToMenu))
									.addGap(56)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(label)
										.addComponent(btnRemoveItem)
										.addComponent(lblAddedMoney)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(moneyField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addGap(83)
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(btnBackToShopping)
												.addComponent(btnNewButton))))))
							.addContainerGap(563, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 537, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblCustomerInformation)
								.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 437, GroupLayout.PREFERRED_SIZE))
							.addGap(55))))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(274)
					.addComponent(lblCustomerCart)
					.addContainerGap(810, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(24)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCustomerCart)
						.addComponent(lblCustomerInformation))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblProductId)
								.addComponent(label))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(idField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnRemoveItem))
							.addGap(58)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblTopUpThe)
								.addComponent(lblAddedMoney))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(cardField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(moneyField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNewButton))
							.addPreferredGap(ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnBackToMenu)
								.addComponent(btnBackToShopping))))
					.addContainerGap())
		);
		
		cusTable = new JTable();
		cusTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Card Number", "Name", "Money", "Points"
			}
		));
		scrollPane_1.setViewportView(cusTable);
		
		cartTable = new JTable();
		cartTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Name", "Qty", "Spend"
			}
		));
		scrollPane.setViewportView(cartTable);
		contentPane.setLayout(gl_contentPane);
		this.setLocationRelativeTo(null);
		draw();
	}
	
	public void draw() {
		DefaultTableModel dtm = (DefaultTableModel) cusTable.getModel();
		DefaultTableModel dtm3 = (DefaultTableModel) cartTable.getModel();
		ArrayList<Cart> cart = dgu.cartGet();
		Customer[] cus = dgu.customerGet();
		dtm3.setRowCount(0);
		for(int i = 0; i < cart.size(); i++) {
			Vector v2 = new Vector();	
			v2.add(cart.get(i).getId());
			v2.add(cart.get(i).getName());
			v2.add(cart.get(i).getQuantity());
			v2.add(cart.get(i).getSpend());
			dtm3.addRow(v2);
		}
		
		dtm.setRowCount(0);
		for(int j = 0; j < cus.length; j++) {
			Vector v = new Vector();	
			v.add(cus[j].getCreditCardId());
			v.add(cus[j].getCusName());
			v.add(Math.round(cus[j].getMoney() * 100.0)/100.0);
			v.add(cus[j].getPoint());
			dtm.addRow(v);
		}
			
	}
	
	private void removeItem(ActionEvent evt) {
		// TODO Auto-generated method stub
		try {
			int id = Integer.parseInt(this.idField.getText());
			ArrayList<Cart> cart = dgu.cartGet();
			
			for(int o = 0; o < cart.size(); o++) {
				if(id == cart.get(o).getId()) {
					QuantityAdd qa = new QuantityAdd();
					Product[] p = dgu.dbProductGet();
					cart.remove(o);
					for(Product pro : p) {
						if(cart.get(o).getId() == pro.getId()) {
							p = qa.quantityAdd(p, pro.getId(), cart.get(o).getQuantity());
							dwu.productWrite(p);
						}
					}
					dwu.cartSave(cart);
				}
			}		
			draw();
		}catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "You must enter the integer!");
		}
	}
	
	private void topUpAct(ActionEvent arg0) {
		// TODO Auto-generated method stub
		try {
			int card = Integer.parseInt(this.cardField.getText());
			double money = Double.parseDouble(this.moneyField.getText());
			boolean done = false;
			Customer[] cus = dgu.customerGet();
			
			for(int i = 0; i < cus.length; i++) {
				if(card == cus[i].getCreditCardId()) {
					cus[i].setMoney(cus[i].getMoney() + money);
					dwu.customerSave(cus);;
					done = true;
					draw();
					JOptionPane.showMessageDialog(null, "Top up successfully!");
				}
			}
			
			if(done == false) {
				JOptionPane.showMessageDialog(null, "Fail: Customer Not Found!");
			}
			
			
		}catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "You must enter the integer for card and numeric in added money!");
		}
		
	}
	
	
	
	
	
	private void logOutAction(ActionEvent evt) {
		// TODO Auto-generated method stub
		System.exit(0);
	}
}
