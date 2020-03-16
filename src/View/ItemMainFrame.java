package View;

import java.awt.EventQueue;
import java.awt.Font;
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

import Modle.Product;
import Modle.PurchaseOrder;
import Util.DataGetUtil;
import Util.DataWriteUtil;
import Util.QuantityAdd;


public class ItemMainFrame extends JFrame {

	private JPanel contentPane;
	JTable ItemTable;
	private DataGetUtil dgu = new DataGetUtil();
	private DataWriteUtil dwu = new DataWriteUtil();
	private JLabel lblNewLabel;
	private JLabel lblSearchById;
	private JTextField searchIDField;
	Product[] pros = null;
	private JButton btnNewButton;
	private JTextField idField;
	private JLabel lblAddHowMuch;
	private JTextField addField;
	private JLabel lblProductId_1;
	private JTextField idField1;
	private JLabel lblStdprice;
	private JTextField stdPriceField;
	private JTextField idField3;
	private JTextField supplierIdField;
	private JTable orderTable;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ItemMainFrame frame = new ItemMainFrame();
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
	public ItemMainFrame() {
		setTitle("Item Maintan System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1228, 612);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		
		lblNewLabel = new JLabel("Item Maintain");
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 20));
		
		JButton btnBack = new JButton("Back to Menu");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ManagerFrame man = new ManagerFrame();
				dispose();
				man.setVisible(true);			
			}
		});
		
		lblSearchById = new JLabel("Search by ID:");
		
		searchIDField = new JTextField();

		searchIDField.setColumns(10);
		
		JButton searchButton = new JButton("Search");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					idSearchAction(e);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		btnNewButton = new JButton("Refresh");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DefaultTableModel dtm = (DefaultTableModel) ItemTable.getModel();
					dtm.setRowCount(0);
					drawTable(pros);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		JButton btnNewButton_1 = new JButton("Replenishing");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				try {
					replenAct(e);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}			
				
			}
		});
		
		JLabel lblProductId = new JLabel("Product ID:");
		
		idField = new JTextField();
		idField.setColumns(10);
		
		lblAddHowMuch = new JLabel("Add how much:");
		
		addField = new JTextField();
		addField.setColumns(10);
		
		lblProductId_1 = new JLabel("Product ID:");
		
		idField1 = new JTextField();
		idField1.setColumns(10);
		
		lblStdprice = new JLabel("Std.Price:");
		
		stdPriceField = new JTextField();
		stdPriceField.setColumns(10);
		
		JButton btnModify = new JButton("Modify");
		btnModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				try {
					priceModify(event);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}			
				
			}
		});
		
		JLabel label = new JLabel("Product ID:");
		
		idField3 = new JTextField();
		idField3.setColumns(10);
		
		JLabel lblNewSupplierId = new JLabel("New Supplier ID:");
		
		supplierIdField = new JTextField();
		supplierIdField.setColumns(10);
		
		JButton btnIdModify = new JButton("ID Modify");
		btnIdModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					supplierIdAct(arg0);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		JLabel lblPurchaseOder = new JLabel("Purchase Oder");
		lblPurchaseOder.setFont(new Font("宋体", Font.BOLD, 20));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnBack))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(36)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblSearchById)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(searchIDField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(searchButton)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnNewButton))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(label, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
										.addComponent(idField3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(idField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblProductId_1)
										.addComponent(idField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblProductId))
									.addGap(38)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewSupplierId)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(supplierIdField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(stdPriceField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblStdprice)
												.addComponent(addField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblAddHowMuch))
											.addGap(118)
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(btnNewButton_1)
												.addComponent(btnModify)
												.addComponent(btnIdModify)))))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 530, GroupLayout.PREFERRED_SIZE)
									.addGap(74)
									.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 520, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap(40, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(265)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED, 411, Short.MAX_VALUE)
					.addComponent(lblPurchaseOder, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
					.addGap(238))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(lblPurchaseOder, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(scrollPane_1, 0, 0, Short.MAX_VALUE)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(13)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblSearchById)
								.addComponent(searchIDField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(searchButton)
								.addComponent(btnNewButton))
							.addGap(19)
							.addComponent(lblAddHowMuch)
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(idField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(addField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNewButton_1))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblProductId_1)
								.addComponent(lblStdprice))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(idField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(stdPriceField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnModify))
							.addGap(34)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(label)
								.addComponent(lblNewSupplierId))
							.addGap(17)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(idField3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnIdModify)
								.addComponent(supplierIdField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
							.addComponent(btnBack))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(58)
							.addComponent(lblProductId)))
					.addContainerGap())
		);
		
		orderTable = new JTable();
		orderTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Name", "Added Qty", "Supplier ID"
			}
		));
		scrollPane_1.setViewportView(orderTable);
		
		ItemTable = new JTable();
		ItemTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "name", "unit price", "quantity", "stock lv", "replen lv", "supplier id"
			}
		));
		ItemTable.getColumnModel().getColumn(2).setPreferredWidth(112);
		ItemTable.getColumnModel().getColumn(3).setPreferredWidth(90);
		ItemTable.getColumnModel().getColumn(4).setPreferredWidth(91);
		ItemTable.getColumnModel().getColumn(5).setPreferredWidth(99);
		ItemTable.getColumnModel().getColumn(6).setPreferredWidth(111);
		scrollPane.setViewportView(ItemTable);
		contentPane.setLayout(gl_contentPane);
		
		//set the window to the middle of the screen
		this.setLocationRelativeTo(null);
		try {
			this.drawTable(pros);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//This method is for drawing table
	public void drawTable(Product[] product) throws Exception {

			DefaultTableModel dtm = (DefaultTableModel) ItemTable.getModel();
			DefaultTableModel dtm1 = (DefaultTableModel) orderTable.getModel();
			ArrayList<PurchaseOrder> po = dgu.purchaseOrderGet();
			
			if(product == null) {
				product = dgu.dbProductGet();
			}
			
			dtm.setRowCount(0);
			for(Product p : product) {
				Vector v = new Vector();	
				v.add(p.getId());
				v.add(p.getName());
				v.add(p.getUnitPrice());
				v.add(p.getQuantity());
				v.add(p.getStockLv());
				v.add(p.getReplenLv());
				v.add(p.getSupplierId());
				dtm.addRow(v);
			}
			
			dtm1.setRowCount(0);
			for(int i = 0; i < po.size(); i++) {
				Vector v1 = new Vector();	
				v1.add(po.get(i).getId());
				v1.add(po.get(i).getName());
				v1.add(po.get(i).getQty());
				v1.add(po.get(i).getSupplierID());
				dtm1.addRow(v1);
			}
	}
	
	//This method is for searching item by ID
	private void idSearchAction(ActionEvent searchEvent) throws Exception {
		String id = this.searchIDField.getText();
		DefaultTableModel dtm = (DefaultTableModel) ItemTable.getModel();

		Product[] pros = dgu.dbProductGet();

		if(id.isEmpty()) {
			JOptionPane.showMessageDialog(null, "ID cannot be empty!");
		} else{
			Product[] p = new Product[1];
			try {
				int a = Integer.parseInt(this.searchIDField.getText());
				for(int i = 0; i < pros.length; i++) {
					if(pros[i].getId() == Integer.parseInt(this.searchIDField.getText())) {
						p[0] = pros[i];
						break;
					}
				}
			} catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "You must enter integer!");
			}

			if(p[0] == null) {
				JOptionPane.showMessageDialog(null, "Cannot find the Product!");
			}else {
				dtm.setRowCount(0);
				drawTable(p);		
			}
		}	
	}
	
	private void replenAct(ActionEvent evt) throws Exception {
		
		try {
			int id = Integer.parseInt(this.idField.getText());
			double qty = Double.parseDouble(this.addField.getText());
			pros = dgu.dbProductGet();
			ArrayList<PurchaseOrder> purchase = dgu.purchaseOrderGet();
			
			for(Product p : pros) {
				if(p.getId() == id) {
					PurchaseOrder po = new PurchaseOrder(id, p.getName(), qty,p.getSupplierId());
					 purchase.add(po);
					 dwu.purchaseOrderSave(purchase);
				}
			}
			
			drawTable(pros);
			
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null,"You must enter an integer to ID and numeric no. in quantity!");
		}

	}
	
	private void priceModify(ActionEvent evt) throws Exception {
		
		pros = dgu.dbProductGet();
		
		try{
			for(int i = 0; i < pros.length; i++) {
				if(pros[i].getId() == Integer.parseInt(this.idField1.getText())) {
					pros[i].setUnitPrice(Double.parseDouble(this.stdPriceField.getText()));
					dwu.productWrite(pros);
				}
			}
			DefaultTableModel dtm = (DefaultTableModel)ItemTable.getModel();
			dtm.setRowCount(0);
			drawTable(pros);
			
			
		}catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(null,"You must enter an integer for ID and numeric number for price!");
		}
		
	}
	
	private void supplierIdAct(ActionEvent arg0) throws Exception {
		// TODO Auto-generated method stub
		try{
			int product = Integer.parseInt(this.idField3.getText());
			int supplier = Integer.parseInt(this.supplierIdField.getText());
			
			pros = dgu.dbProductGet();
			for(int q = 0; q < pros.length; q++) {
				if(product == pros[q].getId()) {
					pros[q].setSupplierId(supplier);
				}
			}
			dwu.productWrite(pros);
			DefaultTableModel dtm = (DefaultTableModel)ItemTable.getModel();
			dtm.setRowCount(0);
			drawTable(pros);
			
			
		}catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(null,"You must enter an integer for ID!");
		}
		
		
	}
}
