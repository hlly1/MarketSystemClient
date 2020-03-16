package View;

import java.awt.Color;
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

import Modle.BulkSale;
import Modle.Product;
import Util.BulkSaleMaintain;
import Util.DataGetUtil;
import Util.DataWriteUtil;

public class DiscountFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8820557848901691014L;
	DataGetUtil dgu = new DataGetUtil();
	DataWriteUtil dwu = new DataWriteUtil();
	private JPanel contentPane;
	private JTable productTable;
	private JTable discountTable;
	private JTextField idField;
	private JTextField bulkField;
	private JTextField priceField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DiscountFrame frame = new DiscountFrame();
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
	public DiscountFrame() {
		setTitle("Discount Release");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1028, 505);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblProduct = new JLabel("Product:");
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		JLabel lblDiscount = new JLabel("Discount:");
		
		JLabel lblReleaseABulk = new JLabel("Release a Bulk Sale:");
		
		JLabel lblProductId = new JLabel("Product ID");
		
		idField = new JTextField();
		idField.setColumns(10);
		
		JLabel lblBulk = new JLabel("Qty");
		
		bulkField = new JTextField();
		bulkField.setColumns(10);
		
		JLabel lblPriceInBulk = new JLabel("Discount");
		
		priceField = new JTextField();
		priceField.setColumns(10);
		
		JButton btnBackToMenu = new JButton("Back to Menu");
		btnBackToMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				backAct(arg0);
			}
		});
		
		JButton btnAddToDiscount = new JButton("Add to Discount");
		btnAddToDiscount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addDist(arg0);
			}
		});
		
		JButton btnRemoveBulkSale = new JButton("Remove Bulk Sale");
		btnRemoveBulkSale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				removeDist(arg0);
			}
		});
		
		JLabel lbltipIfYou = new JLabel("(Tip: If you only want to remove a bulk sale,");
		lbltipIfYou.setForeground(Color.RED);
		
		JLabel lblYouCanOnly = new JLabel(" you can only enter the product ID)");
		lblYouCanOnly.setForeground(Color.RED);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 393, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblProduct))
									.addGap(40)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 509, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblDiscount)))
								.addComponent(lblReleaseABulk)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(74)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnRemoveBulkSale)
								.addComponent(idField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblProductId))
							.addGap(46)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(bulkField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblBulk))
									.addGap(114)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblPriceInBulk)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(priceField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addGap(78)
											.addComponent(btnAddToDiscount))))
								.addComponent(lbltipIfYou)
								.addComponent(lblYouCanOnly))
							.addGap(130))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnBackToMenu)))
					.addContainerGap(44, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblProduct)
						.addComponent(lblDiscount))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
							.addGap(26)
							.addComponent(lblReleaseABulk))
						.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblProductId)
						.addComponent(lblBulk)
						.addComponent(lblPriceInBulk))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(idField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(bulkField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(priceField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAddToDiscount))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnRemoveBulkSale)
						.addComponent(lbltipIfYou))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblYouCanOnly)
					.addPreferredGap(ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
					.addComponent(btnBackToMenu)
					.addContainerGap())
		);
		
		discountTable = new JTable();
		discountTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Name", "Qty", "Discount"
			}
		));
		scrollPane_1.setViewportView(discountTable);
		
		productTable = new JTable();
		productTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Name", "Unit Price"
			}
		));
		scrollPane.setViewportView(productTable);
		contentPane.setLayout(gl_contentPane);
		
		this.setLocationRelativeTo(null);
		draw();
	}
	
	public void draw() {
		DefaultTableModel dtm1 = (DefaultTableModel) productTable.getModel();
		DefaultTableModel dtm2 = (DefaultTableModel) discountTable.getModel();
		
		Product[] p  = dgu.dbProductGet(); 
		ArrayList<BulkSale> dist = dgu.bulkSaleGet();
		dtm1.setRowCount(0);
		for(Product p1 : p) {
			Vector v = new Vector();	
			v.add(p1.getId());
			v.add(p1.getName());
			v.add(p1.getUnitPrice());
			v.add(p1.getQuantity());
			dtm1.addRow(v);
		}
		
		dtm2.setRowCount(0);
		for(int i = 0; i < dist.size(); i++) {
			Vector v1 = new Vector();	
			v1.add(dist.get(i).getId());
			v1.add(dist.get(i).getName());
			v1.add(dist.get(i).getBulk());
			v1.add(dist.get(i).getDiscount());
			dtm2.addRow(v1);
		}
		
		
	}
	
	public void addDist(ActionEvent evt) {
//Empty Check
		if(this.idField.getText().isEmpty() || this.bulkField.getText().isEmpty() || this.priceField.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "You must enter the ID, bulk and price!");
		}else {
			//Validation check
			try {
				int id = Integer.parseInt(this.idField.getText());
				double bulk = Double.parseDouble(this.bulkField.getText());
				double discount = Double.parseDouble(this.priceField.getText());
				String namePro = "Not Found";
				boolean exist = false;
				boolean distExist = false;
				if(bulk < 0 || discount < 0) {
					JOptionPane.showMessageDialog(null, "You must enter the Positive number!");
				}else {
					Product[] pro = dgu.dbProductGet();
					ArrayList<BulkSale> bss = dgu.bulkSaleGet();
					for(Product p : pro) {
						
						if(id == p.getId()) {
							namePro = p.getName();
							exist = true;
							for(int i = 0; i < bss.size(); i++) {
								if(bss.get(i).getId() == id) {
									distExist = true;
									bss.get(i).setDiscount(discount);
									bss.get(i).setBulk(bulk);
									dwu.bulkSaleSave(bss);
									draw();
								}
							}
							
							
						}
					}
//Check the product is exist
					if(exist == true && distExist == false) {
						BulkSale bs = new BulkSale(id, namePro, bulk, discount);
						BulkSaleMaintain bsm = new BulkSaleMaintain();					
						ArrayList<BulkSale> addedBS = bsm.addSaleReport(bs);
						dwu.bulkSaleSave(addedBS);
						draw();
					}else if(exist == true && distExist == true){
						;
					}else{
						JOptionPane.showMessageDialog(null, "Sorry, the product is not exist!");
					}
				}
			}catch(NumberFormatException e1) {
				JOptionPane.showMessageDialog(null, "You must enter the integer for ID, valid number for bulk and price!");
			}
		}	
	}
	
	public void removeDist(ActionEvent evt) {
		if(this.idField.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "You must enter the ID to remove the discount!");
		}else {
			try {
				int id = Integer.parseInt(this.idField.getText());
				boolean exist = false;
				
				ArrayList<BulkSale> bs = dgu.bulkSaleGet();
				for(int i = 0; i < bs.size(); i++) {
					if(id == bs.get(i).getId()) {
						bs.remove(i);
						exist = true;
					}
				}

				if(exist == true) {
					dwu.bulkSaleSave(bs);
					draw();
				}else {
					JOptionPane.showMessageDialog(null, "Discount not found!");
				}
				
									
				
			}catch(NumberFormatException e1) {
				JOptionPane.showMessageDialog(null, "You must enter the integer for ID!");
			}
			
		}
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private void backAct(ActionEvent evt) {
		dispose();
		ManagerFrame mmf = new ManagerFrame();
		mmf.setVisible(true);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
