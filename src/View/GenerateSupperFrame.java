package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Modle.SupperReport;
import Modle.Supplier;
import Util.DataGetUtil;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GenerateSupperFrame extends JFrame {

	private JPanel contentPane;
	private JTable reportTable;
	private JLabel lblSupperReport;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GenerateSupperFrame frame = new GenerateSupperFrame();
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
	public GenerateSupperFrame() {
		setTitle("Supper Report");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 735, 445);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnBackToMenu = new JButton("Back to Menu");
		btnBackToMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ManagerFrame mf = new ManagerFrame();
				mf.setVisible(true);
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		
		lblSupperReport = new JLabel("Supper Report");
		lblSupperReport.setFont(new Font("Calibri", Font.BOLD, 30));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(44)
							.addComponent(btnBackToMenu))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(31)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 638, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(244)
							.addComponent(lblSupperReport)))
					.addContainerGap(38, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(26)
					.addComponent(lblSupperReport)
					.addGap(28)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 121, Short.MAX_VALUE)
					.addComponent(btnBackToMenu)
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
		scrollPane.setViewportView(reportTable);
		contentPane.setLayout(gl_contentPane);
		this.setLocationRelativeTo(null);
		draw();
	}
	private void draw() {
		DataGetUtil dgu = new DataGetUtil();
		ArrayList<SupperReport> sr = dgu.supperReportGet();
		DefaultTableModel dtm = (DefaultTableModel) reportTable.getModel();
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
	}
}
