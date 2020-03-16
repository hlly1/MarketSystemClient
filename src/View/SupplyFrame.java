package View;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
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
import Modle.SupperReport;
import Util.DataGetUtil;
import Util.DataWriteUtil;
import Util.QuantityAdd;

public class SupplyFrame extends JFrame {

	private DataGetUtil dgu = new DataGetUtil();
	private DataWriteUtil dwu = new DataWriteUtil();
	private JPanel contentPane;
	private JTable orderTable;
	private JTable reportTable;
	private JTextField idField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SupplyFrame frame = new SupplyFrame();
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
	public SupplyFrame() {
		setTitle("Warehouse Staff Maintain");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1067, 538);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblWaitingToReplenish = new JLabel("Waiting to replenish");
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		JLabel lblFinishedOrder = new JLabel("Finished order");
		
		JLabel lblProductId = new JLabel("Product ID");
		
		idField = new JTextField();
		idField.setColumns(10);
		
		JButton btnReplenish = new JButton("Replenish");
		btnReplenish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				replenAct(arg0);
			}
		});
		
		JButton btnLogOut = new JButton("Log out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int check = JOptionPane.showConfirmDialog(null, "Are you sure to exit?");
				if (check == 0) {
					System.exit(0);
				}
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(26)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnLogOut)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 397, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblWaitingToReplenish))
							.addGap(70)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 493, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblFinishedOrder)))
						.addComponent(lblProductId)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(idField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(56)
							.addComponent(btnReplenish)))
					.addContainerGap(53, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(16)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFinishedOrder)
						.addComponent(lblWaitingToReplenish))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
						.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addComponent(lblProductId)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(idField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnReplenish))
					.addPreferredGap(ComponentPlacement.RELATED, 162, Short.MAX_VALUE)
					.addComponent(btnLogOut)
					.addContainerGap())
		);
		
		reportTable = new JTable();
		reportTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Name", "Qty", "Supplier ID", "Date"
			}
		));
		scrollPane_1.setViewportView(reportTable);
		
		orderTable = new JTable();
		orderTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Name", "Qty", "Supplier ID"
			}
		));
		scrollPane.setViewportView(orderTable);
		contentPane.setLayout(gl_contentPane);
		this.setLocationRelativeTo(null);
		draw();
	}
	
	private void draw() {
		DefaultTableModel dtm = (DefaultTableModel) reportTable.getModel();
		DefaultTableModel dtm1 = (DefaultTableModel) orderTable.getModel();
		ArrayList<PurchaseOrder> po = dgu.purchaseOrderGet();
		ArrayList<SupperReport> sr = dgu.supperReportGet();
		
		dtm.setRowCount(0);
		for(int j = 0; j < sr.size(); j++) {
			Vector v = new Vector();	
			v.add(sr.get(j).getId());
			v.add(sr.get(j).getName());
			v.add(sr.get(j).getQty());
			v.add(sr.get(j).getSupplierID());
			v.add(sr.get(j).getDate().toString());
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
	
	
	private void replenAct(ActionEvent arg0) {
		// TODO Auto-generated method stub
		Date date = new Date();
		
		try {
			int id = Integer.parseInt(this.idField.getText());
			ArrayList<PurchaseOrder> po = dgu.purchaseOrderGet();
			for(int i = 0; i < po.size(); i++) {
				if(id == po.get(i).getId()) {
					//Add the qty
					QuantityAdd qa = new QuantityAdd();
					
					
					Product[] pros = dgu.dbProductGet();
					
					pros = qa.quantityAdd(pros, id, po.get(i).getQty());
					dwu.productWrite(pros);
					
					SupperReport sr = new SupperReport(id, po.get(i).getName(), po.get(i).getQty(), po.get(i).getSupplierID(), date);
					ArrayList<SupperReport> s = dgu.supperReportGet();
					s.add(sr);
					dwu.supperReportSave(s);
					po.remove(i);
					dwu.purchaseOrderSave(po);
					draw();
				}
			}
			

			
			
		}catch(NumberFormatException e){
			JOptionPane.showMessageDialog(null, "ID must be integer!");
		}
		
	}
}
