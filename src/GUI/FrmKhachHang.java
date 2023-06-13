package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import java.awt.FlowLayout;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;


import Object.KhachHang;
import Object.Xe;
import DAO.KhachHang_DAO;
import DAO.Xe_DAO;
import Data.database;

public class FrmKhachHang extends JFrame implements ActionListener{
	private JButton btnQuayLai;
	private JPanel contentPane;
	private JTextField txtMaKH;
	private JTextField txtTenKH;
	private JTextField txtDiaChi;
	private JTextField txtSDT;
	private JTextField txtGhiChu;
	private JTextField txtGioiTinh;
	private JTable table;
	private JButton btnThem,btnCapNhap,btnXoa,btnXoaRong;
	/**
	 * Launch the application.
	 */
	ArrayList<KhachHang> dskh = new ArrayList<>();
	DefaultTableModel model;
	private KhachHang_DAO kh_DAO = new KhachHang_DAO();
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmKhachHang frame = new FrmKhachHang();
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
	public FrmKhachHang() {
		super("Thông Tin Khách Hàng");
		this.setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 768, 48);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Thông Tin Khách Hàng");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel.setBounds(0, 0, 768, 48);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(10, 70, 375, 125);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lbMaKH = new JLabel("Mã Khách Hàng");
		lbMaKH.setBounds(10, 11, 105, 26);
		panel_1.add(lbMaKH);
		
		JLabel lbTenKH = new JLabel("Tên Khách Hàng");
		lbTenKH.setBounds(10, 48, 105, 28);
		panel_1.add(lbTenKH);
		
		JLabel lbGioiTinh = new JLabel("Giới Tính");
		lbGioiTinh.setHorizontalAlignment(SwingConstants.LEFT);
		lbGioiTinh.setBounds(10, 86, 81, 28);
		panel_1.add(lbGioiTinh);
		
		txtMaKH = new JTextField();
		txtMaKH.setBounds(125, 14, 222, 20);
		panel_1.add(txtMaKH);
		txtMaKH.setColumns(10);
		
		txtTenKH = new JTextField();
		txtTenKH.setBounds(125, 52, 222, 20);
		panel_1.add(txtTenKH);
		txtTenKH.setColumns(10);
		
		txtGioiTinh = new JTextField();
		txtGioiTinh.setBounds(125, 90, 222, 20);
		panel_1.add(txtGioiTinh);
		txtGioiTinh.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(395, 70, 383, 125);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lbDiaChi = new JLabel("Địa Chỉ");
		lbDiaChi.setBounds(24, 11, 85, 26);
		panel_2.add(lbDiaChi);
		
		JLabel lbSDT = new JLabel("Số Điện Thoại");
		lbSDT.setBounds(24, 48, 85, 26);
		panel_2.add(lbSDT);
		
		JLabel lbGhiChu = new JLabel("Ghi Chú");
		lbGhiChu.setBounds(24, 85, 93, 25);
		panel_2.add(lbGhiChu);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setBounds(136, 14, 222, 20);
		panel_2.add(txtDiaChi);
		txtDiaChi.setColumns(10);
		
		txtSDT = new JTextField();
		txtSDT.setColumns(10);
		txtSDT.setBounds(136, 51, 220, 20);
		panel_2.add(txtSDT);
		
		txtGhiChu = new JTextField();
		txtGhiChu.setColumns(10);
		txtGhiChu.setBounds(136, 87, 222, 20);
		panel_2.add(txtGhiChu);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "Function", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(10, 206, 110, 248);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		 btnThem = new JButton("Thêm ");
		btnThem.setBounds(10, 26, 87, 29);
		panel_3.add(btnThem);
		
		 btnXoa = new JButton("Xóa");
		btnXoa.setBounds(10, 65, 87, 29);
		panel_3.add(btnXoa);
		
		 btnCapNhap = new JButton("Cập Nhập");
		btnCapNhap.setBounds(10, 104, 87, 29);
		panel_3.add(btnCapNhap);
		
		 btnQuayLai = new JButton("Quay Lại");
		btnQuayLai.setBounds(10, 144, 87, 29);
		btnQuayLai.addActionListener(this);
		panel_3.add(btnQuayLai);
		
		btnXoaRong = new JButton("Xóa Rỗng");
		btnXoaRong.setBounds(10, 184, 87, 29);
		panel_3.add(btnXoaRong);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(126, 206, 652, 248);
		contentPane.add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_4.add(scrollPane, BorderLayout.CENTER);
		model = new DefaultTableModel();
		table = new JTable(model);
		model.addColumn("Mã Khách Hàng");
		model.addColumn("Tên Khách Hàng");
		model.addColumn("Giới Tính");
		model.addColumn("Địa Chỉ");
		model.addColumn("SDT");
		model.addColumn("Ghi Chú");
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(4).setResizable(false);
		table.getColumnModel().getColumn(5).setResizable(false);
		
		scrollPane.setViewportView(table);
		
		
		btnCapNhap.addActionListener(this);
		btnThem.addActionListener(this);
		btnXoa.addActionListener(this);
		btnXoaRong.addActionListener(this);
		table.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				txtMaKH.setText(model.getValueAt(row, 0).toString());
				txtTenKH.setText(model.getValueAt(row, 1).toString());
				txtGioiTinh.setText(model.getValueAt(row, 2).toString());
				txtDiaChi.setText(model.getValueAt(row, 3).toString());
				txtSDT.setText(model.getValueAt(row, 4).toString());
				txtGhiChu.setText(model.getValueAt(row, 5).toString());
				
			}
		});
		
		database.getInstance().connect();
		updateTableData();
	}
	private void updateTableData() {
		 
		KhachHang_DAO dskh = new KhachHang_DAO();
		List<KhachHang> list = dskh.docTuBang();
		for (KhachHang khach : list) {
			String [] rowData = {khach.getMaKH(),khach.getTenKH(),khach.getGioiTinh(), khach.getDiaChi(), khach.getSDT(),khach.getGhiChu()};
			
			model.addRow(rowData);
		}
		table.setModel(model);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnQuayLai))
		{
			menuAdmin menuAdmin = new menuAdmin();
			dispose();
			menuAdmin.setVisible(true);
		}
		else if (o.equals(btnThem)) {
			if ( checkregex()) {
				String makh = txtMaKH.getText();
				
				
				String tenkh = txtTenKH.getText();
				String gt = txtGioiTinh.getText();
				String dc = txtDiaChi.getText();
				String sdt = txtSDT.getText();
				
				String gc = txtGhiChu.getText();
				KhachHang kh = new KhachHang(makh,tenkh, gt, dc, sdt, gc);
			    Object[] row = {makh,tenkh, gt, dc, sdt, gc};
			    model.addRow(row);
			    dskh.add(kh);
			    JOptionPane.showMessageDialog(this, "Thêm thành công");
				xoaRong();
			} 
		}
		else if(o.equals(btnCapNhap)) {
			for (KhachHang kh : dskh) {
			    KhachHang khach = new KhachHang(kh.getMaKH(),kh.getTenKH(),kh.getGioiTinh(), kh.getDiaChi(), kh.getSDT(),kh.getGhiChu());
			    kh_DAO.tao(khach);
			}
			JOptionPane.showMessageDialog(this, "Lưu thành công");
		}
		else if(o.equals(btnXoa)) {
			int row = table.getSelectedRow(); 
		    if (row >= 0){
		        String maKH = (String) table.getModel().getValueAt(row, 0);
		        if(kh_DAO.xoaTheoMakh(maKH)) {
		            model.removeRow(row);
		            xoaRong();
		            JOptionPane.showMessageDialog(this, "Xóa thành công");
		        }
		    }
		}
		else if(o.equals(btnXoaRong)) {
			xoaRong();
		}
	}
	public void xoaRong() {
		 
		txtMaKH.setText(""); 
		txtTenKH.setText(""); 
		txtGioiTinh.setText(""); 
		txtDiaChi.setText(""); 
		txtSDT.setText(""); 
		txtGhiChu.setText(""); 
		txtMaKH.requestFocus();
	}
	public boolean checkregex() {
		String maKH = txtMaKH.getText().trim();
		String tenKH = txtTenKH.getText().trim();
		String gt = txtGioiTinh.getText().trim();
		String dc = txtDiaChi.getText().trim();
		String sdt = txtSDT.getText().trim();
		String gc = txtGhiChu.getText().trim();
		if(!(maKH.length() > 0 && maKH.matches("^KH\\d{2}$")))
		{
			JOptionPane.showMessageDialog(this, "Error : Mã khách hàng theo mẫu : KH01");
			return false;
		}
		if (!(gt.length() > 0 && gt.matches("(Nam|Nữ)"))) {
		    JOptionPane.showMessageDialog(this, "Giới tính phải là 'Nam' hoặc 'Nữ'");
		    return false;
		}
		if(!(sdt.length() > 0 && sdt.matches("^0[0-9]{9}$") ))
		{
			JOptionPane.showMessageDialog(this, "Số điện thoại gồm 10 số và bắt đầu từ 0 ");
			return false;
		}
		
		return true;
	}
}
