package View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFileChooser;
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
import Modle.Cart;
import Modle.Customer;
import Modle.Product;
import Modle.Sale;
import Util.BarcodeReader;
import Util.DataGetUtil;
import Util.DataWriteUtil;
import Util.QuantityAdd;
import Util.SaleReportAdd;

public class CustomerFrame extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTable productTable;
	private JTable discountTable;
	private JTable cartTable;
	private DataGetUtil dgu = new DataGetUtil();
	private DataWriteUtil dwu = new DataWriteUtil();
	private JTextField idField;
	private JTextField quantityField;
	private ArrayList<Cart> cart = dgu.cartGet();
	private JTextField cardField;
	private JTextField pathField;
	private JTable readTable;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerFrame frame = new CustomerFrame();
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
	public CustomerFrame() {
		setTitle("Shopping Center");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 817, 949);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblProducts = new JLabel("Products:");
		lblProducts.setFont(new Font("Calibri", Font.BOLD, 20));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblDiscount = new JLabel("Discount:");
		lblDiscount.setFont(new Font("Calibri", Font.BOLD, 20));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		JLabel lblWelcomeCustomer = new JLabel("Welcome, customer!");
		lblWelcomeCustomer.setForeground(Color.MAGENTA);
		lblWelcomeCustomer.setFont(new Font("Calibri", Font.BOLD, 40));
		
		JLabel lblChart = new JLabel("Cart");
		lblChart.setFont(new Font("Calibri", Font.BOLD, 20));
		
		JScrollPane scrollPane_2 = new JScrollPane();
		
		JButton btnLogOut = new JButton("Log out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				int check = JOptionPane.showConfirmDialog(null, "Are you sure to exit?");
				if (check == 0) {
					customerLogOutAction(evt);
				}
			}
		});
		
		JLabel lblProductId = new JLabel("Product ID:");
		
		idField = new JTextField();
		idField.setColumns(10);
		
		JLabel lblQuantityToBuy = new JLabel("Qty/Wgt to buy:");
		
		quantityField = new JTextField();
		quantityField.setColumns(10);
		
		JButton btnAddToCart = new JButton("Add to Cart");
		btnAddToCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addToCart(arg0);
			}
		});
		
		JButton btnNewButton = new JButton("Purchase");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				purchaseAct(arg0);
			}


		});
		
		JButton btnRemoveItemCall = new JButton("Remove Item( Call Staff )");
		btnRemoveItemCall.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				LoginFrame login = new LoginFrame();
				login.setVisible(true);
				
			}
		});
		
		JLabel lblCreditCard = new JLabel("Credit Card:");
		
		cardField = new JTextField();
		cardField.setColumns(10);
		
		pathField = new JTextField();
		pathField.setColumns(10);
		
		JLabel lblEnterThePath = new JLabel("Enter the path of the barcode img here:");
		
		JButton btnBrowser = new JButton("browser");
		btnBrowser.setActionCommand("open");
		btnBrowser.addActionListener(this);
		
		JButton btnReadTheBarcode = new JButton("Read the barcode");
		btnReadTheBarcode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				readBarcode(evt);
			}
		});
		
		JScrollPane scrollPane_3 = new JScrollPane();
		
		JLabel lblReadResult = new JLabel("Read result:");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblDiscount)
								.addComponent(lblProducts)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(scrollPane_1, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
									.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE)))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
									.addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 304, GroupLayout.PREFERRED_SIZE)
									.addGap(54))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(156)
									.addComponent(lblChart)
									.addContainerGap())))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnLogOut)
							.addContainerGap(686, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblProductId)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
									.addComponent(lblCreditCard)
									.addComponent(idField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addGap(54)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblQuantityToBuy)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(quantityField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(cardField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGap(70)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(btnNewButton)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(btnAddToCart)
											.addGap(38)
											.addComponent(btnRemoveItemCall)))))
							.addContainerGap(77, Short.MAX_VALUE))))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(208)
					.addComponent(lblWelcomeCustomer)
					.addContainerGap(234, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(35)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblReadResult)
						.addComponent(scrollPane_3, GroupLayout.PREFERRED_SIZE, 474, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(pathField, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnBrowser)
							.addGap(8)
							.addComponent(btnReadTheBarcode))
						.addComponent(lblEnterThePath))
					.addContainerGap(275, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(27)
					.addComponent(lblWelcomeCustomer)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblProducts)
						.addComponent(lblChart))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblDiscount)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE))
						.addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 252, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(46)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblProductId)
								.addComponent(lblQuantityToBuy))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(idField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(quantityField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnAddToCart))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnNewButton)
								.addComponent(lblCreditCard)
								.addComponent(cardField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(43)
							.addComponent(lblEnterThePath)
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(pathField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnBrowser)
								.addComponent(btnReadTheBarcode)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addComponent(btnRemoveItemCall)))
					.addPreferredGap(ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
					.addComponent(lblReadResult)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane_3, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
					.addGap(60)
					.addComponent(btnLogOut)
					.addContainerGap())
		);
		
		readTable = new JTable();
		readTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Name"
			}
		));
		scrollPane_3.setViewportView(readTable);
		
		cartTable = new JTable();
		cartTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Name", "Qty/Wgt", "Spend"
			}
		));
		scrollPane_2.setViewportView(cartTable);
		
		discountTable = new JTable();
		discountTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Name", "Qty/Wgt", "Discount"
			}
		));
		scrollPane_1.setViewportView(discountTable);
		
		productTable = new JTable();
		productTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Name", "Unit Price", "Qty/Wgt", "unit"
			}
		));
		productTable.getColumnModel().getColumn(2).setPreferredWidth(102);
		scrollPane.setViewportView(productTable);
		contentPane.setLayout(gl_contentPane);
		this.setLocationRelativeTo(null);
		draw();
	}
	
	private void readBarcode(ActionEvent evt) {
		// TODO Auto-generated method stub
		BarcodeReader br = new BarcodeReader();
        try {
            File file = new File(this.pathField.getText());
            String decodedText = br.decodeQRCode(file);
            if(decodedText == null) {
            	JOptionPane.showMessageDialog(null,"No Bar Code found in the image");
            } else {
                Product[] ps = dgu.dbProductGet();
                int id = Integer.parseInt(decodedText);
                for(Product p : ps) {
                	if(p.getId() == id) {
                		
                		DefaultTableModel dtm = (DefaultTableModel) readTable.getModel();
            			Vector v = new Vector();	
            			v.add(p.getId());
            			v.add(p.getName());
            			dtm.addRow(v);
	
                	}
                }
                
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,"Fail to read the barcode!");
        }

	}

	public void draw() {
		DefaultTableModel dtm1 = (DefaultTableModel) productTable.getModel();
		DefaultTableModel dtm2 = (DefaultTableModel) discountTable.getModel();
		DefaultTableModel dtm3 = (DefaultTableModel) cartTable.getModel();
		
		Product[] p  = dgu.dbProductGet(); 
		ArrayList<Cart> cart = dgu.cartGet();
		ArrayList<BulkSale> bs = dgu.bulkSaleGet();
		
		//This is for the product
		dtm1.setRowCount(0);
		for(Product p1 : p) {
			Vector v = new Vector();	
			v.add(p1.getId());
			v.add(p1.getName());
			v.add(p1.getUnitPrice());
			v.add(p1.getQuantity());
			v.add(p1.getUnit());
			dtm1.addRow(v);
		}
		
		//This is for the discount
		dtm2.setRowCount(0);
		for(int i = 0; i < bs.size(); i++) {
			Vector v1 = new Vector();
			v1.add(bs.get(i).getId());
			v1.add(bs.get(i).getName());
			v1.add(bs.get(i).getBulk());
			v1.add(bs.get(i).getDiscount());
			dtm2.addRow(v1);
		}

		//This is for the cart
		for(int i = 0; i < cart.size(); i++) {
			Vector v2 = new Vector();	
			v2.add(cart.get(i).getId());
			v2.add(cart.get(i).getName());
			v2.add(cart.get(i).getQuantity());
			v2.add(cart.get(i).getSpend());
			dtm3.addRow(v2);
		}	
	}
	
	private void addToCart(ActionEvent a) {

		try {
			int id = Integer.parseInt(this.idField.getText());
			double quantity = Double.parseDouble(this.quantityField.getText());
			Product[] product = dgu.dbProductGet();
			if(quantity < 0) {
				JOptionPane.showMessageDialog(null, "You must enter the positive number!");
			}else {
				boolean exist = false;
				for(Product p : product) {
					if(p.getId() == id) {
						exist = true;
						if(quantity > p.getQuantity()) {
							JOptionPane.showMessageDialog(null, "You buy too much");
						}else {
							//check the item whetheris bought and update the quantity
							boolean cartExist = false;
							double newPrice = 0;
							for(int i = 0; i < cart.size(); i++) {
								if(id == cart.get(i).getId()) {
									//update the quantity first
									cart.get(i).setQuantity(cart.get(i).getQuantity() + quantity);
									newPrice = cart.get(i).getSpend() + quantity * p.getUnitPrice();
									
									ArrayList<BulkSale> bs = dgu.bulkSaleGet();
									for(int j = 0; j < bs.size(); j++) {
										if(id == bs.get(j).getId()) {
											double bulk = bs.get(j).getBulk();
											double discount = bs.get(j).getDiscount();
											if(cart.get(i).getQuantity() - bulk >= 0) {
												newPrice = cart.get(i).getSpend() + ((1 - discount) * p.getUnitPrice()) * quantity;
											}
										}
									}
									
									//round up to 2 decimal place
									cart.get(i).setSpend(Math.round(newPrice * 100.0)/100.0);
									p.decreaseQuantity(quantity);
									cartExist = true;
									dwu.cartSave(cart);
								}
							}
							
							// If the item is not exist, add to cart
							if(cartExist == false) {
								//System.out.println(bulkExist);
								ArrayList<BulkSale> bs = dgu.bulkSaleGet();
								newPrice = p.getUnitPrice() * quantity;
								for(int j = 0; j < bs.size(); j++) {
									if(id == bs.get(j).getId()) {
										double bulk = bs.get(j).getBulk();
										double discount = bs.get(j).getDiscount();
										double orignal = bulk - 1;
										if(quantity >= bulk) {
											newPrice = (p.getUnitPrice() * orignal) + ((1-discount) * p.getUnitPrice()) * (quantity - orignal);
										}else {
											newPrice = p.getUnitPrice() * quantity;
										}
									}
								}
								
								this.cart.add(new Cart(p.getId(), p.getName(), quantity, Math.round(newPrice * 100.0)/100.0));
								p.decreaseQuantity(quantity);
							}					
						}
					}	
				}
				
				if(exist == false) {
					JOptionPane.showMessageDialog(null, "Sorry, we dont have this kind of product.");
				}
				
				
				dwu.productWrite(product);
				dwu.cartSave(cart);
				DefaultTableModel dtm = (DefaultTableModel) cartTable.getModel();
				dtm.setRowCount(0);
				draw();
			}
			
		}catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "You must enter the quantity and product ID");
		}
		
	}
	
	private void purchaseAct(ActionEvent arg0) {
		try {
			
//Check the card whether it is empty
			if(this.cardField.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "You must enter your credit card!");
			}else {
				
//Check the card number whether it is valid
				int cardNum = Integer.parseInt(this.cardField.getText());
				if(cardNum < 0) {
					JOptionPane.showMessageDialog(null, "You cannot enter the negative!");
				}else {
					
//Find out the Customer
					Customer[] cus = dgu.customerGet();
					Customer customer = null;
					for(Customer c : cus) {
						if(c.getCreditCardId() == cardNum) {
							customer = c;
							break;
						}
					}
					
					if(customer == null) {
						JOptionPane.showMessageDialog(null, "You are not registered!");
					}else {
						
//Compute the total spend without point discount
						double totalSpend = 0;
						//ArrayList<Cart> cart = dgu.cartGet();
						for(int i = 0; i < cart.size(); i++) {
							totalSpend = totalSpend + cart.get(i).getSpend();
						}
						System.out.println(customer.getCusName() + " "+customer.getMoney()+ " "+customer.getCreditCardId() + customer.getPoint());
						//System.out.println("total price: "+totalSpend);
//Computer the point and discount
						int point = customer.getPoint();
						double discount = 0;

//If the point is enough, then give the discount, otherwise, discount is 0
						if(point >= 20) {
							int discTime = (int)Math.floor(point/20);
							discount = 5 * discTime;
							customer.setPoint(point - discTime * 20);							
						}
						
						double discSpend = totalSpend - discount;
						double newMoney = customer.getMoney() - discSpend;
						//Compute whether the customer has enough money to pay the bill after discounted
						if(newMoney < 0) {
							JOptionPane.showMessageDialog(null, "You dont have enough money!");
							
//Give the item quantity back to product
							Product[] p = dgu.dbProductGet();
							for(int a = 0; a < cart.size(); a++) {
								for(Product products : p) {
									if(products.getId() == cart.get(a).getId()) {
										products.setQuantity(products.addQuantity(cart.get(a).getQuantity()));
									}
								}
							}
							dwu.productWrite(p);
							
							//Empty the cart
							cart.clear();
							dwu.cartSave(cart);
							DefaultTableModel dtm3 = (DefaultTableModel) cartTable.getModel();
							dtm3.setRowCount(0);
							draw();
						}else {

//Update the money and point after payment
							customer.setMoney(newMoney);					
							int addPoint = (int)Math.floor(discSpend/10);
							customer.addPoint(addPoint);
							
//Generate the sale report and save it to disk
							Date date = new Date();
							ArrayList<Sale> addedSale = dgu.saleReportGet();
							Sale s = new Sale(addedSale.size(), this.cart, Math.round(totalSpend * 100.0)/100.0, Math.round(discSpend * 100.0)/100.0, customer.getCusName(), date);
							SaleReportAdd addSale = new SaleReportAdd();
							addedSale = addSale.addSaleReport(s);
							dwu.saleReportSave(addedSale);
							
//Empty the cart
							this.cart.clear();
							dwu.cartSave(this.cart);
							
//Update the information of customer
							for(Customer ct : cus) {
								if(ct.getCreditCardId() == customer.getCreditCardId()) {
									ct = customer;
								}
							}
							dwu.customerSave(cus);
							
//close the window and print the receipt
							dispose();
							ReceiptFrame rf = new ReceiptFrame();
							rf.setVisible(true);
						}	
					}
				}
			}			
		}catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "You must enter the integer!");
		}	
	}

	private void customerLogOutAction(ActionEvent evt) {
		QuantityAdd qa = new QuantityAdd();
		Product[] p = dgu.dbProductGet();
		for(Product pro : p) {
			for(int i = 0; i < cart.size(); i++) {
				if(cart.get(i).getId() == pro.getId()) {
					p = qa.quantityAdd(p, pro.getId(), cart.get(i).getQuantity());
					dwu.productWrite(p);
				}
			}
		}
		
		this.cart.clear();
		dwu.cartSave(this.cart);
		System.exit(0);
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		try {
			if (evt.getActionCommand().equals("open")){
				JFileChooser jf = new JFileChooser();
				jf.showOpenDialog(this);//open the choose window
				File f =  jf.getSelectedFile();//get the file
				String s = f.getAbsolutePath();//get the path of the file
				this.pathField.setText(s);
				 
			}
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null,"Please select a file again!");
		}
		

	}
}
