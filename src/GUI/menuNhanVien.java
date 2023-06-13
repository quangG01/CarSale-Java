package GUI;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class menuNhanVien extends JFrame implements ActionListener {
	
	private FrmXe FrmXe;
	private FrmKhachHang FrmKhachHang;
	private frmTimKiemXe frmTimKiemXe;//
	private frmTimKiemKhachHang frmTimKiemKhachHang;//
	
	private Login Login;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menuNhanVien frame = new menuNhanVien();
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
	public menuNhanVien() {
		super("MenuNV");
		FrmXe = new FrmXe();
		FrmKhachHang = new FrmKhachHang();
		frmTimKiemXe = new frmTimKiemXe();//
				frmTimKiemKhachHang = new frmTimKiemKhachHang();//
		this.setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Hệ Thống");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Thông Tin Khách Hàng");
		mntmNewMenuItem_1.addActionListener(this);
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Thông Tin Xe Máy");
		mntmNewMenuItem.addActionListener(this);
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenu mnNewMenu_1 = new JMenu("Tìm Kiếm");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Tìm Kiếm Thông tin Xe");
		mntmNewMenuItem_3.addActionListener(this);
		mnNewMenu_1.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Tìm Kiếm Thông Tin Khách Hàng");
		mntmNewMenuItem_4.addActionListener(this);
		mnNewMenu_1.add(mntmNewMenuItem_4);
		
		JMenu mnNewMenu_2 = new JMenu("Chức Năng");
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Hóa Đơn Xuất");
		mntmNewMenuItem_5.addActionListener(this);
		mnNewMenu_2.add(mntmNewMenuItem_5);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Phiếu Bảo Hành");
		mntmNewMenuItem_2.addActionListener(this);
		mnNewMenu_2.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Thoát");
		mntmNewMenuItem_6.addActionListener(this);
		mnNewMenu_2.add(mntmNewMenuItem_6);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		 Object o = e.getSource();
		    if (o instanceof JMenuItem) {
		        JMenuItem menuItem = (JMenuItem) o;
		        if (menuItem.getText().equals("Thông Tin Xe Máy")) {
		            FrmXe.setVisible(true);
		            this.setVisible(false);
		        } else if (menuItem.getText().equals("Thông Tin Khách Hàng")) {
		            FrmKhachHang.setVisible(true);
		            this.setVisible(false);
		        }else if (menuItem.getText().equals("Tìm Kiếm Thông tin Xe"))
		        {
		        	frmTimKiemXe.setVisible(true);
		        	this.setVisible(false);
		        }
		        else if (menuItem.getText().equals("Tìm Kiếm Thông Tin Khách Hàng"))
		        {
		        	frmTimKiemKhachHang.setVisible(true);
		        	this.setVisible(false);
		        }
		        
		        else if (menuItem.getText().equals("Thoát"))
		        {
		        	this.setVisible(false);
		        }
		    }
	}

}
