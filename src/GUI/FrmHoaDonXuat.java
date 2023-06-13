package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


import java.awt.BorderLayout;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

import Object.HoaDonXuat;
import DAO.HoaDonXuat_DAO;
import DAO.KhachHang_DAO;
import Data.database;
import Object.KhachHang;
import Object.Xe;
public class FrmHoaDonXuat extends JFrame implements ActionListener{
	JButton btnThem,btnXoa,btnCapNhap,btnLapChiTiet,btnTroVe;
	private JPanel contentPane;
	private JTable table;
	private JTextField txtMaHDX;
	private JTextField txtMaKH;
	private JTextField txtNgayXuat;
	private JTable table_1;
	private JTextField txtMaNV;
	private FrmChiTietHoaDonXuat frmChiTiet;
	/**
	 * Launch the application.
	 */
	ArrayList<KhachHang> dskh = new ArrayList<>();
	ArrayList<HoaDonXuat> dshd = new ArrayList<>();
	DefaultTableModel model,model_1;
	private HoaDonXuat_DAO hd_DAO = new HoaDonXuat_DAO();
	private KhachHang_DAO kh_DAO = new KhachHang_DAO();
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmHoaDonXuat frame = new FrmHoaDonXuat();
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
	public FrmHoaDonXuat() {
		frmChiTiet = new FrmChiTietHoaDonXuat();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(this);
		setBounds(100, 100, 1000, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 8, 968, 44);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Hóa Đơn Xuất");
		lblNewLabel.setBounds(0, 0, 968, 45);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 63, 689, 222);
		contentPane.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane, BorderLayout.CENTER);
		
		model = new DefaultTableModel();
		table = new JTable(model);
		model.addColumn("Mã Hóa Đơn Xuất");
		model.addColumn("Mã Khách Hàng");
		model.addColumn("Mã Nhân Viên");
		
		model.addColumn("Ngày Xuất");
		table.getColumnModel().getColumn(1).setPreferredWidth(94);
		table.getColumnModel().getColumn(2).setPreferredWidth(91);
		scrollPane.setViewportView(table);
		
		database.getInstance().connect();
		updateTableDataHoaDon();
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "L\u1EADp H\u00F3a \u0110\u01A1n Kh\u00E1ch H\u00E0ng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(10, 296, 689, 160);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Mã HDX");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setBounds(52, 27, 128, 38);
		panel_2.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Mã Nhân Viên");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1.setBounds(52, 86, 128, 38);
		panel_2.add(lblNewLabel_1_1);
		
		txtMaHDX = new JTextField();
		txtMaHDX.setBounds(185, 32, 96, 29);
		panel_2.add(txtMaHDX);
		txtMaHDX.setColumns(10);
		
		JLabel lblNewLabel_1_2 = new JLabel("Mã Khách Hàng");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_2.setBounds(352, 27, 128, 38);
		panel_2.add(lblNewLabel_1_2);
		
		txtMaKH = new JTextField();
		txtMaKH.setColumns(10);
		txtMaKH.setBounds(485, 32, 96, 29);
		panel_2.add(txtMaKH);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Ngày Xuất");
		lblNewLabel_1_2_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_2_1.setBounds(352, 86, 128, 38);
		panel_2.add(lblNewLabel_1_2_1);
		
		txtNgayXuat = new JTextField();
		txtNgayXuat.setColumns(10);
		txtNgayXuat.setBounds(485, 91, 96, 29);
		panel_2.add(txtNgayXuat);
		
		txtMaNV = new JTextField();
		txtMaNV.setColumns(10);
		txtMaNV.setBounds(185, 86, 96, 29);
		panel_2.add(txtMaNV);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 467, 689, 237);
		contentPane.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panel_3.add(scrollPane_1, BorderLayout.CENTER);
		
		
		model_1 = new DefaultTableModel();
		table_1 = new JTable(model_1);
		model_1.addColumn("Mã Khách Hàng");
		model_1.addColumn("Tên Khách Hàng");
		model_1.addColumn("Giới Tính");
		model_1.addColumn("Địa Chỉ");
		model_1.addColumn("SDT");
		model_1.addColumn("Ghi Chú");
		scrollPane_1.setViewportView(table_1);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(709, 63, 269, 641);
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		
		btnThem = new JButton("Thêm");
		btnThem.setBounds(10, 131, 113, 38);
		panel_4.add(btnThem);
		
		btnXoa = new JButton("Xóa");
		btnXoa.setBounds(146, 131, 113, 38);
		panel_4.add(btnXoa);
		
		btnCapNhap = new JButton("Cập Nhập");
		btnCapNhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCapNhap.setBounds(10, 194, 113, 38);
		panel_4.add(btnCapNhap);
		
		btnTroVe = new JButton("Trở Về");
		btnTroVe.setBounds(146, 194, 113, 38);
		panel_4.add(btnTroVe);
		
		btnLapChiTiet = new JButton("Lập Chi Tiết Đơn Hàng");
		btnLapChiTiet.setBounds(10, 264, 249, 38);
		panel_4.add(btnLapChiTiet);
		
		
		btnCapNhap.addActionListener(this);
		btnLapChiTiet.addActionListener(this);
		btnThem.addActionListener(this);
		btnTroVe.addActionListener(this);
		btnXoa.addActionListener(this);
		updateTableDataKhachHang();
		
	}
	
	private void updateTableDataKhachHang() {
		 
		KhachHang_DAO dskh = new KhachHang_DAO();
		List<KhachHang> list = dskh.docTuBang();
		for (KhachHang khach : list) {
			String [] rowData = {khach.getMaKH(),khach.getTenKH(),khach.getGioiTinh(), khach.getDiaChi(), khach.getSDT(),khach.getGhiChu()};
			
			model_1.addRow(rowData);
		}
		table_1.setModel(model_1);
	}
	private void updateTableDataHoaDon() {
		 
		HoaDonXuat_DAO dshd = new HoaDonXuat_DAO();
		List<HoaDonXuat> list = dshd.docTuBang();
		for (HoaDonXuat hd : list) {
			String [] rowData = {hd.getMaHDX(),hd.getMaNV(),hd.getMaKH(),hd.getNgayXuat()};
			model.addRow(rowData);
			
		}
		table.setModel(model);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(btnTroVe))
		{
			menuAdmin menuAdmin = new menuAdmin();
			this.setVisible(false);
			menuAdmin.setVisible(true);
		}
		else if (o.equals(btnThem)) {
			if ( checkregex()) {
				String maHDX = txtMaHDX.getText();
				String maKH =  txtMaKH.getText();
				String maNV = txtMaNV.getText();
				String ngayXuat = txtNgayXuat.getText();

				
				HoaDonXuat xe = new HoaDonXuat(maHDX,maNV, maKH,  ngayXuat);
			    Object[] row = {maHDX,maNV, maKH,  ngayXuat};
			    model.addRow(row);
			    dshd.add(xe);
			   
			    JOptionPane.showMessageDialog(this, "Thêm thành công");
				xoaRong();
			} 
		}
		else if(o.equals(btnCapNhap)) {
			for (HoaDonXuat hd : dshd) {
				HoaDonXuat hdx = new HoaDonXuat(hd.getMaHDX(),hd.getMaNV(),hd.getMaKH(),hd.getNgayXuat());
			    hd_DAO.tao(hdx);
			}
			JOptionPane.showMessageDialog(this, "Lưu thành công");
		}
		else if(o.equals(btnLapChiTiet)) {
			dispose();
			frmChiTiet.setVisible(true);
		}
		else if(o.equals(btnXoa)) {
			int row = table.getSelectedRow(); 
		    if (row >= 0){
		        String maHDX = (String) table.getModel().getValueAt(row, 0);
		        if(hd_DAO.xoaTheoMahd(maHDX)) {
		            model.removeRow(row);
		            xoaRong();
		            JOptionPane.showMessageDialog(this, "Xóa thành công");
		        }
		    }
		}
		
	}
	public void xoaRong() {
		txtMaHDX.setText("");
		txtMaKH.setText("");
		txtMaNV.setText(""); 
		txtNgayXuat.setText(""); 
		
		txtMaHDX.requestFocus();
	}
	public boolean checkregex() {
		String maHDX = txtMaHDX.getText().trim();
		String maKH = txtMaKH.getText().trim();
		String maNV = txtMaNV.getText().trim();
		String nx = txtNgayXuat.getText().trim();

		if(!(maHDX.length() > 0 && maHDX.matches("^HDX\\d{3}$")))
		{
			JOptionPane.showMessageDialog(this, "Error : Mã Xe theo mẫu : HDX001");
			return false;
		}
//		if(!(maKH.length() > 0 && maKH.matches("maKH.get")))
//		{
//		JOptionPane.showMessageDialog(this, "Error : Tên Xe theo mẫu : Yamaha|Honda|Suzuki|BMW + tên ");
//			return false;
//		}
		//if(!(giaBan > 0 ))
		{
			//JOptionPane.showMessageDialog(this, "Error : Giá Bán phải lớn hơn 0 ");
			//return false;
		}
		//if(!(soLuong > 0))
		{
			//JOptionPane.showMessageDialog(this, "Số lượng phải lớn hơn 0");
			//return false;
		}
		//if(!(soKhung.length() > 0 && soKhung.matches("\\b[A-Z]{2}\\d{4}\\b")))
		{
			//JOptionPane.showMessageDialog(this, "Số khung có 2 chữ đầu là chữ cái và 4 chữ số ");
			//return false;
		}
		//	txtSoLuong.getText().equals("") || txtSoKhung.getText().equals("") || txtSoMay.getText().equals("") || txtMau.getText().equals("") || txtDungTich.getText().equals("") || txtTinhTrang.
		return true;
	}
}
