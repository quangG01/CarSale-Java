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
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import DAO.KhachHang_DAO;
import Data.database;
import GUI.FrmKhachHang;
import Object.KhachHang;


public class frmTimKiemKhachHang extends JFrame implements ActionListener{
	 JButton btnQuayLai,btnTimKiem,btnXoa;
	 JPanel contentPane;
	 JTextField txtMaKH;
	private JTable table;
	DefaultTableModel model;
	/**
	 * Launch the application.
	 */
	ArrayList<KhachHang> dskh = new ArrayList<>();
	private KhachHang_DAO kh_DAO = new KhachHang_DAO();
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmTimKiemKhachHang frame = new frmTimKiemKhachHang();
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
	public frmTimKiemKhachHang() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 550);
		contentPane = new JPanel();
		this.setResizable(false);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 0, 768, 45);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tìm Kiếm Khách hàng");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel.setBounds(10, 0, 758, 45);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Th\u00F4ng Tin Kh\u00E1ch H\u00E0ng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 48, 192, 467);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Mã Khách Hàng :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 83, 172, 23);
		panel_1.add(lblNewLabel_1);
		
		txtMaKH = new JTextField();
		txtMaKH.setBounds(10, 117, 172, 23);
		panel_1.add(txtMaKH);
		txtMaKH.setColumns(10);
		
		btnTimKiem = new JButton("Tìm Kiếm");
		btnTimKiem.setBackground(Color.CYAN);
		btnTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnTimKiem.setBounds(10, 187, 172, 33);
		panel_1.add(btnTimKiem);
		
		 btnXoa = new JButton("Xóa Khách Hàng");
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnXoa.setBackground(Color.CYAN);
		btnXoa.setBounds(10, 253, 172, 33);
		panel_1.add(btnXoa);
		
		btnQuayLai = new JButton("Quay Lại");
		btnQuayLai.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnQuayLai.setBackground(Color.CYAN);
		btnQuayLai.setBounds(10, 317, 172, 33);
		btnQuayLai.addActionListener(this);
		panel_1.add(btnQuayLai);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(212, 56, 566, 459);
		contentPane.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_2.add(scrollPane, BorderLayout.CENTER);
		
		model = new DefaultTableModel();
		table = new JTable(model);
		model.addColumn("Mã Khách Hàng");
		model.addColumn("Tên Khách Hàng");
		model.addColumn("Giới Tính");
		model.addColumn("Địa Chỉ");
		model.addColumn("SDT");
		model.addColumn("Ghi Chú");
		scrollPane.setViewportView(table);
		
		
		btnXoa.addActionListener(this);
		btnTimKiem.addActionListener(this);
		database.getInstance().connect();
		//updateTableData();
		Docthongtin();
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
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnQuayLai))
		{
			menuAdmin menuAdmin = new menuAdmin();
			dispose();
			menuAdmin.setVisible(true);
		}
		else if (o.equals(btnTimKiem))
		{
			String maKH = txtMaKH.getText().toString().trim();
			if(!(maKH.length() > 0 && maKH.matches("^KH\\d{2}$")))
			{
				JOptionPane.showMessageDialog(this, "Error : Mã khách hàng theo mẫu : KH01");
				
			}
			
			//dòng lấy model của table 
			model = (DefaultTableModel) table.getModel();
			//  tablerowsorter tạo model mới của bảng kh
			TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(model);
			//set model của table thành model mới vừa tạo ở trên
			table.setRowSorter(sorter);
			// list<row..> tạo một danh sách các thành phần tìm kiếm theo thứ tự
			List<RowFilter<Object, Object>> filters = new ArrayList<>();
			//các dòng filter , ở bảng tìm kiếm ở cột số 0, thành phần tìm kiếm là mã nv
			filters.add(RowFilter.regexFilter(maKH, 0));

			//dòng row dưới, sẽ add danh sách tìm kiếm vào model
			RowFilter<Object, Object> rf = RowFilter.andFilter(filters);
			//add vào model tìm kiếm
			sorter.setRowFilter(rf);
		}
		else if(o.equals(btnXoa)) {
			int row = table.getSelectedRow(); 
		    if (row >= 0){
		        String maKH = (String) table.getModel().getValueAt(row, 0);
		        if(kh_DAO.xoaTheoMakh(maKH)) {
		            model.removeRow(row);
		            JOptionPane.showMessageDialog(this, "Xóa thành công");
		        }
		    }
		}
	}
	//lấy thông tin từ sql
		public void Docthongtin() {
			dskh = kh_DAO.docTuBang();
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.setRowCount(0);
			for (KhachHang khach:dskh) {
			model.addRow(new Object[] {khach.getMaKH(),khach.getTenKH(),khach.getGioiTinh(), khach.getDiaChi(), khach.getSDT(),khach.getGhiChu()}); 
			} 
		}
}
