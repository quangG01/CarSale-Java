package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import DAO.KhachHang_DAO;
import DAO.Xe_DAO;
import Data.database;
import Object.KhachHang;
import Object.Xe;

public class frmTimKiemXe extends JFrame implements ActionListener{

	private JButton btnQuayLai,btnTimKiem,btnXoaXe;
	private JPanel contentPane;
	private JTextField txtMaXe;
	private JTable table;
	private menuAdmin menuAdmin;
	/**
	 * Launch the application.
	 */
	DefaultTableModel model;
	ArrayList<Xe> dsXe = new ArrayList<>();
	private Xe_DAO xe_DAO = new Xe_DAO();
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmTimKiemXe frame = new frmTimKiemXe();
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
	public frmTimKiemXe() {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setResizable(false);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 768, 40);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tìm Kiếm Xe");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel.setBounds(0, 0, 768, 40);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Th\u00F4ng Tin Xe", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 58, 197, 446);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Mã Xe :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setBounds(10, 92, 178, 27);
		panel_1.add(lblNewLabel_1);
		
		txtMaXe = new JTextField();
		txtMaXe.setBounds(10, 130, 178, 27);
		panel_1.add(txtMaXe);
		txtMaXe.setColumns(10);
		
		 btnTimKiem = new JButton("Tìm Kiếm");
		
		 btnTimKiem.setBackground(Color.CYAN);
		 btnTimKiem.setBounds(31, 187, 141, 33);
		panel_1.add(btnTimKiem);
		
		 btnXoaXe = new JButton("Xóa Xe");
		btnXoaXe.setBackground(Color.CYAN);
		btnXoaXe.setBounds(31, 250, 141, 33);
		panel_1.add(btnXoaXe);
		
		btnQuayLai = new JButton("Quay Lại");
		btnQuayLai.setBackground(Color.CYAN);
		btnQuayLai.setBounds(31, 315, 141, 33);
		panel_1.add(btnQuayLai);
		btnQuayLai.addActionListener(this);
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(217, 62, 561, 442);
		contentPane.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_2.add(scrollPane, BorderLayout.CENTER);
		
		model = new DefaultTableModel();
		table = new JTable(model);
		model.addColumn("Mã Xe");
		model.addColumn("Tên Xe");
		model.addColumn("Mã Loại xe");
		model.addColumn("Giá bán");
		model.addColumn("Số Lượng");
		model.addColumn("Số Khung");
		model.addColumn("Số Máy");
		model.addColumn("Màu Xe");
		model.addColumn("Dung Tich");
		model.addColumn("Tình Trạng");		
		scrollPane.setViewportView(table);
		
		btnXoaXe.addActionListener(this);
		btnTimKiem.addActionListener(this);
		database.getInstance().connect();
		//updateTableData();
		Docthongtin();
	}
//		private void updateTableData() {
//			 
//			Xe_DAO dsXe = new Xe_DAO();
//			List<Xe> list = dsXe.docTuBang();
//			for (Xe x : list) {
//				String [] rowData = {x.getMaXe(),x.getTenXe(),x.getMaLoaiXe().getMaLoaiXe(),Double.toString(x.getGiaBan()),Integer.toString(x.getSoLuong()),x.getSoKhung(),x.getSoMay(),x.getMau(),Integer.toString(x.getDungTich()),x.getTinhTrang()};
//				
//				model.addRow(rowData);
//			}
//			table.setModel(model);
//		}
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
					
				String maXe = txtMaXe.getText().toString().trim();
				if(!(maXe.length() > 0 && maXe.matches("^X\\d{2}$")))
				{
					JOptionPane.showMessageDialog(this, "Error : Mã Xe theo mẫu : X01");
					
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
				filters.add(RowFilter.regexFilter(maXe, 0));

				//dòng row dưới, sẽ add danh sách tìm kiếm vào model
				RowFilter<Object, Object> rf = RowFilter.andFilter(filters);
				//add vào model tìm kiếm
				sorter.setRowFilter(rf);
				
			}
			else if(o.equals(btnXoaXe)) {
				int row = table.getSelectedRow(); 
			    if (row >= 0){
			        String maXe = (String) table.getModel().getValueAt(row, 0);
			        if(xe_DAO.xoaTheoMaXe(maXe)) {
			            model.removeRow(row);
			            JOptionPane.showMessageDialog(this, "Xóa thành công");
			        }
			    }
			}
//			else if (o.equals(btnXoaXe))
		}
		//lấy thông tin từ sql
			public void Docthongtin() {
				dsXe = xe_DAO.docTuBang();
				 model = (DefaultTableModel) table.getModel();
				model.setRowCount(0);
				for (Xe x: dsXe) {
				model.addRow(new Object[] {x.getMaXe(),x.getTenXe(),x.getMaLoaiXe().getMaLoaiXe(),Double.toString(x.getGiaBan()),Integer.toString(x.getSoLuong()),x.getSoKhung(),x.getSoMay(),x.getMau(),Integer.toString(x.getDungTich()),x.getTinhTrang()}); 
				} 
			}
}
