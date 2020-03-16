package View;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
import Util.DataWriteUtil;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextField;

public class SaleReportFrame extends JFrame {
	
	private DataGetUtil dgu = new DataGetUtil();
	private DataWriteUtil dwu = new DataWriteUtil();
	private JPanel contentPane;
	private JTable reportTable;
	private JTable detailTable;
	private JTextField keyField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SaleReportFrame frame = new SaleReportFrame();
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
	public SaleReportFrame() {
		setTitle("Sale Report Log");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1199, 609);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblSaleReport = new JLabel("Sale Report");
		lblSaleReport.setFont(new Font("Calibri", Font.BOLD, 30));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblDetails = new JLabel("Details");
		lblDetails.setFont(new Font("Calibri", Font.BOLD, 30));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel dtm = (DefaultTableModel) detailTable.getModel();
				dtm.setRowCount(0);
			}
		});
		
		JButton btnBackToMenu = new JButton("Back to Menu");
		btnBackToMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ManagerFrame mf = new ManagerFrame();
				mf.setVisible(true);
			}
		});
		
		keyField = new JTextField();
		keyField.setColumns(10);
		
		JLabel lblKeyWordOf = new JLabel("Key word of the period");
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchPeriod(e);
			}
		});
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				draw();
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(23)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblSaleReport)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 554, GroupLayout.PREFERRED_SIZE))
							.addGap(71)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblDetails)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
									.addComponent(btnClear)
									.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 487, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(41)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(keyField, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
									.addGap(97)
									.addComponent(btnSearch)
									.addGap(27)
									.addComponent(btnRefresh))
								.addComponent(lblKeyWordOf))))
					.addContainerGap(36, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(546, Short.MAX_VALUE)
					.addComponent(btnBackToMenu)
					.addGap(496))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSaleReport)
						.addComponent(lblDetails))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE)
						.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btnClear)
					.addGap(11)
					.addComponent(lblKeyWordOf)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(keyField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSearch)
						.addComponent(btnRefresh))
					.addPreferredGap(ComponentPlacement.RELATED, 121, Short.MAX_VALUE)
					.addComponent(btnBackToMenu)
					.addContainerGap())
		);
		
		detailTable = new JTable();
		detailTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Name", "Qty/Wgt", "Spend"
			}
		));
		scrollPane_1.setViewportView(detailTable);
		
		reportTable = new JTable();
		reportTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				drawDetail(arg0);
			}
		});
		reportTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Order ID", "Customer", "Spend", "Discounted Price", "Date"
			}
		));
		reportTable.getColumnModel().getColumn(0).setPreferredWidth(10);
		reportTable.getColumnModel().getColumn(1).setPreferredWidth(10);
		reportTable.getColumnModel().getColumn(2).setPreferredWidth(10);
		reportTable.getColumnModel().getColumn(3).setPreferredWidth(10);
		scrollPane.setViewportView(reportTable);
		contentPane.setLayout(gl_contentPane);
		this.setLocationRelativeTo(null);
		draw();
	}
	
	private void drawDetail(MouseEvent arg0) {
		// TODO Auto-generated method stub
		int row = this.reportTable.getSelectedRow();
		int id = (int)this.reportTable.getValueAt(row, 0);
		
		DefaultTableModel dtm = (DefaultTableModel) detailTable.getModel();
		ArrayList<Sale> sr = dgu.saleReportGet();
		ArrayList<Cart> items = null;
		
		for(int i = 0; i < sr.size(); i++) {
			int orderID = sr.get(i).getId();
			
			if(id == orderID) {
				items = sr.get(i).getItems();
			}
		}
		
		try {
			dtm.setRowCount(0);
			for(int j = 0; j < items.size(); j++) {
				Vector v = new Vector();
				v.add(items.get(j).getId());
				v.add(items.get(j).getName());
				v.add(items.get(j).getQuantity());
				v.add(items.get(j).getSpend());
				dtm.addRow(v);
			}
		}catch(NullPointerException e) {
			JOptionPane.showMessageDialog(null, "Error: Detail is lost!");
		}
	}

	private void draw() {
		DefaultTableModel dtm = (DefaultTableModel) reportTable.getModel();
		ArrayList<Sale> sr = dgu.saleReportGet();
		
		dtm.setRowCount(0);
		for(int i = 0; i < sr.size(); i++) {
			Vector v1 = new Vector();
			v1.add(sr.get(i).getId());
			v1.add(sr.get(i).getCust());
			v1.add(sr.get(i).getTotalSpend());
			v1.add(sr.get(i).getDiscSpend());
			v1.add(sr.get(i).getDate().toString().replaceAll("AEST", ""));
			dtm.addRow(v1);
		}
		
	}
	
	private void searchPeriod(ActionEvent evt) {
		try {
			String word = this.keyField.getText();
			ArrayList<Sale> sr = dgu.saleReportGet();
			ArrayList<Sale> selected = new ArrayList<Sale>();
			
			for(int i = 0; i < sr.size(); i++) {
				String time = sr.get(i).getDate().toString();
				boolean check = time.contains(word);
				if(check) {
					selected.add(sr.get(i));
				}
			}
			
			DefaultTableModel dtm = (DefaultTableModel) reportTable.getModel();
			
			dtm.setRowCount(0);
			for(int i = 0; i < selected.size(); i++) {
				Vector v1 = new Vector();
				v1.add(selected.get(i).getId());
				v1.add(selected.get(i).getCust());
				v1.add(selected.get(i).getTotalSpend());
				v1.add(selected.get(i).getDiscSpend());
				v1.add(selected.get(i).getDate().toString().replaceAll("AEST", ""));
				dtm.addRow(v1);
			}
			
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Warning: Keyword is invaild!");
		}
	}
}
