package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import java.awt.Panel;

import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import javax.swing.JToolBar;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class menuAdmin extends JFrame implements ActionListener{

	private JPanel contentPane;
	private FrmXe FrmXe;
	private FrmKhachHang FrmKhachHang;
	private frmTimKiemXe frmTimKiemXe;//
	private frmTimKiemKhachHang frmTimKiemKhachHang;//
	
	private Login Login;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menuAdmin frame = new menuAdmin();
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
	public menuAdmin() {
		super("MenuQL");
		
		FrmXe = new FrmXe();
		FrmKhachHang = new FrmKhachHang();
		frmTimKiemXe = new frmTimKiemXe();//
		
		frmTimKiemKhachHang = new frmTimKiemKhachHang();//
	
		this.setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Hệ Thống");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Thông Tin Xe Máy");
		mntmNewMenuItem_4.addActionListener(this); 
		mnNewMenu.add(mntmNewMenuItem_4);
	
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Thông Tin Khách Hàng");
		mntmNewMenuItem_3.addActionListener(this);
		mnNewMenu.add(mntmNewMenuItem_3);
	
		
		
		JMenu mnNewMenu_3 = new JMenu("Tìm Kiếm");
		menuBar.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Tìm Kiếm Thông Tin Xe");
		mntmNewMenuItem_5.addActionListener(this);
		mnNewMenu_3.add(mntmNewMenuItem_5);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Tìm Kiếm Thông Tin Khách Hàng");
		mntmNewMenuItem_6.addActionListener(this);
		mnNewMenu_3.add(mntmNewMenuItem_6);
		
		JMenu mnNewMenu_1 = new JMenu("Tài Khoản");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Tạo Tài Khoản Nhân Viên");
		mntmNewMenuItem_2.addActionListener(this);
		mnNewMenu_1.add(mntmNewMenuItem_2);
		
		JMenu mnNewMenu_2 = new JMenu("Đăng Xuất");
		menuBar.add(mnNewMenu_2);
		
		
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Thoát");
		mntmNewMenuItem_1.addActionListener(this);
		mnNewMenu_2.add(mntmNewMenuItem_1);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("D:\\OOP_Laptrinhhuongdoituong\\WorkSpace\\BaiTapLonCuoiKi\\img\\xe 1.jpg"));
		lblNewLabel.setBounds(0, 0, 788, 461);
		contentPane.add(lblNewLabel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	    Object o = e.getSource();
	    if (o instanceof JMenuItem) {
	        JMenuItem menuItem = (JMenuItem) o;
	        if (menuItem.getText().equals("Thông Tin Xe Máy")) {
	            FrmXe.setVisible(true);
	            dispose();
	        } else if (menuItem.getText().equals("Thông Tin Khách Hàng")) {
	            FrmKhachHang.setVisible(true);
	            dispose();
	        } else if (menuItem.getText().equals("Tìm Kiếm Thông Tin Xe")) {
	            frmTimKiemXe.setVisible(true);
	            dispose();
	        } else if (menuItem.getText().equals("Tìm Kiếm Thông Tin Khách Hàng")) {
	            frmTimKiemKhachHang.setVisible(true);
	            dispose();
	        } else if (menuItem.getText().equals("Đăng Xuất Tài Khoản")) {
	            Login login = new Login();
	            login.setVisible(true);
	            dispose();
	        } else if (menuItem.getText().equals("Thoát")) {
	            dispose();
	        }
	    }
	}
}


