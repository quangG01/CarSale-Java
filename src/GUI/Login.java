package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import DAO.DanhSachNhanVien;
import DAO.DanhSachTaikhoan_DAO;
import DAO.DanhSachTaikhoan_DAO;
import Object.NhanVien;
import Object.TaiKhoan;
import GUI.menuAdmin;
import Data.database;

import javax.swing.border.LineBorder;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.Component;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.CardLayout;

public class Login extends JFrame  {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JButton btn, btn1;
	DanhSachTaikhoan_DAO dsTK;
	DanhSachNhanVien dsNV;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		setLocationRelativeTo(null);
		// Add components to contentPane
		this.setResizable(false);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 38, 688, 427);
		panel_1.setBackground(new Color(125, 189, 210));
		contentPane.add(panel_1);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 358, 440);
		panel.setBackground(Color.PINK);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon("D:\\OOP_Laptrinhhuongdoituong\\WorkSpace\\BaiTapLonCuoiKi\\img\\motorbike.png"));
		
		JButton btn_1 = new JButton("EXIT");
		btn_1.setBackground(Color.CYAN);
		btn_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(100)
					.addComponent(btn_1, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(119, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(33)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btn_1, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(95, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(389, 76, 281, 67);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBounds(389, 163, 281, 67);
		
		btn = new JButton("SIGN IN");
		btn.setBounds(435, 290, 172, 50);
		btn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_1.addActionListener((e)->System.exit(0));
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dangNhap();
			}
		});
		
		JLabel lblNewLabel_5 = new JLabel("LOG IN");
		lblNewLabel_5.setBounds(466, 27, 125, 29);
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2_1.setLayout(null);
		
		JLabel lblNewLabel_2_1 = new JLabel("Password");
		lblNewLabel_2_1.setBounds(0, 0, 216, 67);
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2_1.setBackground(Color.PINK);
		panel_2_1.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setIcon(new ImageIcon("D:\\OOP_Laptrinhhuongdoituong\\WorkSpace\\BaiTapLonCuoiKi\\img\\lock.png"));
		lblNewLabel_4.setBounds(216, 0, 65, 67);
		panel_2_1.add(lblNewLabel_4);
		
		textField = new JTextField();
		textField.setBounds(0, 0, 216, 67);
		panel_2_1.add(textField);
		textField.setColumns(10);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Username");
		lblNewLabel_2.setBackground(Color.PINK);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(0, 0, 216, 67);
		panel_2.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setIcon(new ImageIcon("D:\\OOP_Laptrinhhuongdoituong\\WorkSpace\\BaiTapLonCuoiKi\\img\\user.png"));
		lblNewLabel_3.setBounds(213, 0, 68, 67);
		panel_2.add(lblNewLabel_3);
		
		textField_1 = new JTextField();
		textField_1.setBounds(0, 0, 216, 67);
		panel_2.add(textField_1);
		textField_1.setColumns(10);
		panel_1.setLayout(null);
		panel_1.add(panel);
		panel_1.add(panel_2);
		panel_1.add(panel_2_1);
		panel_1.add(lblNewLabel_5);
		panel_1.add(btn);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(0, 0, 688, 38);
		panel_4.setBackground(Color.WHITE);
		panel_4.setBorder(new LineBorder(Color.CYAN));
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("QUẢN LÝ BÁN XE MÁY");
		lblNewLabel_1.setBounds(204, 6, 279, 31);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_1.setBackground(Color.RED);
		panel_4.add(lblNewLabel_1);
		JPanel borderPanel = new JPanel();
		borderPanel.setLayout(new BorderLayout());
		borderPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		JLabel label = new JLabel("Label with border");
		borderPanel.add(label, BorderLayout.CENTER);
		// Tai Khoan Mac Dinh
		textField.setText("NV01");
		textField_1.setText("nv01");
		this.setVisible(true);
		// Action
	
		database.getInstance().connect();
		dsTK = new DanhSachTaikhoan_DAO();
		dsNV = new DAO.DanhSachNhanVien();
		
	}
	
	// kiem tra dang nhap
	public void dangNhap() {
		String maTK = textField_1.getText().toString().trim();
		String mk = textField.getText().toString().trim();
		TaiKhoan tk = dsTK.getTaiKhoanTheoMa(maTK);

		if (tk == null) {
			JOptionPane.showMessageDialog(this, "Tài khoản không đúng!\nVui lòng kiểm tra lại.");
			textField_1.requestFocus();
		} else if (!tk.getMk().equalsIgnoreCase(mk)) {
			JOptionPane.showMessageDialog(this, "Mật khẩu không đúng!\nVui lòng kiểm tra lại.");
			textField.requestFocus();
		} else {
			NhanVien nv = dsNV.getNhanVienTheoMa(maTK);
			menuAdmin frmMain = new menuAdmin();
			frmMain.setVisible(true);
			dispose();
		}

	}

	
}