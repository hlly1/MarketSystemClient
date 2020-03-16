package View;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

import Modle.Supplier;
import Util.DataGetUtil;
import Util.DataWriteUtil;

public class SupplierMainFrame extends JFrame {

	private JPanel contentPane;
	private JTable idTable;
	DataWriteUtil dwu = new DataWriteUtil();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SupplierMainFrame frame = new SupplierMainFrame();
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
	public SupplierMainFrame() {
		setTitle("Supplier Details");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 556, 268);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnBackToMenu = new JButton("Back to Menu");
		btnBackToMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ManagerFrame man = new ManagerFrame();
				man.setVisible(true);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(76)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 365, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(196)
							.addComponent(btnBackToMenu)))
					.addContainerGap(87, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(27)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnBackToMenu)
					.addContainerGap(29, Short.MAX_VALUE))
		);
		
		idTable = new JTable();
		idTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Supplier ID", "Name"
			}
		));
		scrollPane.setViewportView(idTable);
		contentPane.setLayout(gl_contentPane);
		this.setLocationRelativeTo(null);
		draw();
		
	}
	
	private void draw() {
		DataGetUtil dgu = new DataGetUtil();
		Supplier[] supplier = dgu.dbSupplierGet();
		DefaultTableModel dtm = (DefaultTableModel) idTable.getModel();
		dtm.setRowCount(0);
		for(Supplier s: supplier) {
			Vector v = new Vector();	
			v.add(s.getId());
			v.add(s.getName());
			dtm.addRow(v);
		}
	}

}
