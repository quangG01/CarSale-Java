package GUI;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class FrmChiTietHoaDonXuat extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmChiTietHoaDonXuat frame = new FrmChiTietHoaDonXuat();
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
	public FrmChiTietHoaDonXuat() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 968, 43);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Chi Tiết Hóa Đơn Xuất");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel.setBounds(0, 0, 968, 43);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Th\u00F4ng Tin Xe", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 65, 688, 183);
		contentPane.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					 "M\u00E3 Xe","M\u00E3 Lo\u1EA1i Xe", "T\u00EAn Xe","Dung T\u00EDch", "M\u00E0u", "S\u1ED1 M\u00E1y", "S\u1ED1 Khung", "Gi\u00E1 B\u00E1n", "Gi\u00E1 Nh\u1EADp",
			}
		));
		scrollPane.setViewportView(table);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 259, 688, 395);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Mã Hóa Đơn Xuất");
		lblNewLabel_1.setBounds(10, 24, 122, 33);
		panel_2.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Mã Xe");
		lblNewLabel_1_1.setBounds(10, 68, 122, 33);
		panel_2.add(lblNewLabel_1_1);
JLabel lblNewLabel_1_2 = new JLabel("Đơn Giá");
		lblNewLabel_1_2.setBounds(10, 115, 122, 33);
		panel_2.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Số Lượng");
		lblNewLabel_1_3.setBounds(369, 24, 122, 33);
		panel_2.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Thuế VAT");
		lblNewLabel_1_4.setBounds(369, 68, 122, 33);
		panel_2.add(lblNewLabel_1_4);
		
		textField = new JTextField();
		textField.setBounds(130, 24, 175, 33);
		panel_2.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(130, 68, 175, 33);
		panel_2.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(130, 115, 175, 33);
		panel_2.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(492, 24, 175, 33);
		panel_2.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(492, 68, 175, 33);
		panel_2.add(textField_4);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 159, 668, 225);
		panel_2.add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Mã Hóa Đơn Xuất", "M\u00E3 Xe", "\u0110\u01A1n Gi\u00E1", "S\u1ED1 L\u01B0\u1EE3ng", "Thu\u1EBF VAT"
			}
		));
		scrollPane_1.setViewportView(table_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(708, 65, 270, 589);
		contentPane.add(panel_3);
		panel_3.setLayout(null);

		JLabel lblNewLabel_1_5 = new JLabel("Tên Xe");
		lblNewLabel_1_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_5.setBounds(11, 23, 249, 31);
		panel_3.add(lblNewLabel_1_5);
		
		textField_3 = new JTextField();
		textField_3.setBounds(11, 65, 249, 31);
		panel_3.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton = new JButton("Thêm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(38, 123, 95, 34);
		panel_3.add(btnNewButton);
		
		JButton btnXa = new JButton("Xóa");
		btnXa.setBounds(143, 123, 95, 34);
		panel_3.add(btnXa);
		
		JButton btnSa = new JButton("Sửa");
		btnSa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSa.setBounds(38, 168, 95, 34);
		panel_3.add(btnSa);
		
		JButton btnTrV = new JButton("Trở Về");
		btnTrV.setBounds(143, 168, 95, 34);
		panel_3.add(btnTrV);
	}

}
