package View;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Modle.Product;
import Util.DataGetUtil;
import Util.DataWriteUtil;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class PopularFrame extends JFrame {

	private DataGetUtil dgu = new DataGetUtil();
	private DataWriteUtil dwu = new DataWriteUtil();
	Product[] pros = dgu.dbProductGet();
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PopularFrame frame = new PopularFrame();
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
	public PopularFrame() {
		setTitle("Popular Items");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 740, 492);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnBackToMenu = new JButton("Back to Menu");
		btnBackToMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				ManagerFrame mf = new ManagerFrame();
				mf.setVisible(true);
			}
		});
		
		JLabel lblTopSoldProducts = new JLabel("Top Sold Products Sorted by Qty/Wgt");
		lblTopSoldProducts.setFont(new Font("Calibri", Font.BOLD, 30));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(286)
							.addComponent(btnBackToMenu))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(104)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblTopSoldProducts)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 479, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(129, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(9)
					.addComponent(lblTopSoldProducts)
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 265, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
					.addComponent(btnBackToMenu)
					.addContainerGap())
		);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Name", "Sold(Qty/Wgt)"
			}
		));
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
		this.setLocationRelativeTo(null);
		draw();
	}
	
	public void draw() {
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		ArrayList<Double> sold = new ArrayList<Double>();
		ArrayList<Double> sold1 = new ArrayList<Double>();
		
		for(Product p : pros) {
			double temp = p.getFullStock() - p.getQuantity();
			sold.add(temp);
			sold1.add(temp);
		}
		
		Collections.sort(sold);

		for(int i = sold.size() - 1; i >= 0 ; i--) {
			Vector v = new Vector();
			for(Product p1 : pros) {
				if(p1.getFullStock() - p1.getQuantity() == sold.get(i) && sold.get(i) != 0) {
					v.add(p1.getId());
					v.add(p1.getName());
					v.add(sold.get(i));
					
				}else {
					v.add("***");
					v.add("This item is not sold.");
					v.add("***");
				}
			}
			dtm.addRow(v);
		}
		
		

		
	}
}
