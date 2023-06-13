package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.Box;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;


import DAO.Xe_DAO;
import Data.database;

import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

import Object.Xe;

import Object.LoaiXe;
public class FrmXe extends JFrame implements ActionListener {
	private JButton btnQuayLai,btnBan,btnCapNhat,btnXoa,btnThem;
	JPanel cen;
	private JPanel contentPane;
	private JTable table;
	private JTextField txtMaXe,txtMaLoai,txtTenXe,txtGiaBan,txtSoLuong,txtSoKhung,txtSoMay,txtMau,txtDungTich,txtTinhTrang;
	/**
	 * Launch the application.
	 */
	ArrayList<Xe> dsXe = new ArrayList<>();
	DefaultTableModel model;
	private Xe_DAO xe_DAO = new Xe_DAO();
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmXe frame = new FrmXe();
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
	public FrmXe() {
		super("Thông Tin Xe");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		this.setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(10, 10));
		
		JPanel top = new JPanel();
		top.setBorder(new TitledBorder(null, "Nh\u1EADp Th\u00F4ng Tin Xe", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(top, BorderLayout.NORTH);
		top.setLayout(new BoxLayout(top, BoxLayout.Y_AXIS));
		Box BoxDoc =  Box.createVerticalBox();
		Box box = Box.createHorizontalBox();
		Box b1_1 = Box.createVerticalBox();
		Box title = Box.createVerticalBox();
		Box b1_2 = Box.createVerticalBox();
		Box b1 = Box.createHorizontalBox();
		
		Box b2 = Box.createHorizontalBox();
		
		Box b3 = Box.createHorizontalBox();
		
		Box b4 = Box.createHorizontalBox();
		
		Box b5 = Box.createHorizontalBox();
		
		Box b6 = Box.createHorizontalBox();
		
		Box b7 = Box.createHorizontalBox();
		
		Box b8 = Box.createHorizontalBox();
		
		Box b9 = Box.createHorizontalBox();
		
		Box b10 = Box.createHorizontalBox();
		
		BoxDoc.add(title);
		BoxDoc.add(box);
		box.add(b1_1);
		box.add(b1_2);
		b1_1.add(b1);
		b1_1.add(b2);
		b1_1.add(b3);
		b1_1.add(b4);
		b1_1.add(b5);
		
		b1_2.add(b6);
		b1_2.add(b7);
		b1_2.add(b8);
		b1_2.add(b9);
		b1_2.add(b10);
		
		top.add(BoxDoc);
		
		JLabel lbMaXe = new JLabel("Mã Xe");
		txtMaXe = new JTextField();
		b1.add(lbMaXe);
		b1.add(txtMaXe);
		
		JLabel lbMaLoai = new JLabel("Mã Loại xe");
		txtMaLoai = new JTextField();
		b3.add(lbMaLoai);
		b3.add(txtMaLoai);
		lbMaXe.setPreferredSize(lbMaLoai.getPreferredSize());
		
		JLabel lbTenXe = new JLabel("Tên Xe");
		txtTenXe = new JTextField();
		b2.add(lbTenXe);
		b2.add(txtTenXe);
		lbTenXe.setPreferredSize(lbMaLoai.getPreferredSize());
		
		JLabel lbGiaBan = new JLabel("Giá bán");
		txtGiaBan= new JTextField();
		b4.add(lbGiaBan);
		b4.add(txtGiaBan);
		lbGiaBan.setPreferredSize(lbMaLoai.getPreferredSize());

		JLabel lbSoLuong = new JLabel("Số Lượng");
		txtSoLuong = new JTextField();
		b5.add(lbSoLuong);
		b5.add(txtSoLuong);
		lbSoLuong.setPreferredSize(lbMaLoai.getPreferredSize());
		
		JLabel lbSoKhung = new JLabel("Số Khung");
		txtSoKhung= new JTextField();
		b6.add(lbSoKhung);
		b6.add(txtSoKhung);
		
		JLabel lbSoMay = new JLabel("Số Máy");
		txtSoMay = new JTextField();
		b7.add(lbSoMay);
		b7.add(txtSoMay);
		lbSoMay.setPreferredSize(lbSoKhung.getPreferredSize());
		
		JLabel lbMau = new JLabel("Màu Xe");
		txtMau = new JTextField();
		b8.add(lbMau);
		b8.add(txtMau);
		lbMau.setPreferredSize(lbSoKhung.getPreferredSize());
		
		JLabel lbDungTich = new JLabel("Dung Tich");
		txtDungTich = new JTextField();
		b9.add(lbDungTich);
		b9.add(txtDungTich);
		lbDungTich.setPreferredSize(lbSoKhung.getPreferredSize());
		
		JLabel lbTinhTrang = new JLabel("Tình Trạng");
		txtTinhTrang = new JTextField();
		b10.add(lbTinhTrang);
		b10.add(txtTinhTrang);
		lbDungTich.setPreferredSize(lbSoKhung.getPreferredSize());
		
		
		
		JLabel lblNewLabel = new JLabel("CẬP NHẬP THÔNG TIN XE");
		lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		title.add(lblNewLabel);
		
		JPanel left = new JPanel();
		left.setBorder(new TitledBorder(null, "Function", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(left, BorderLayout.WEST);
		left.setLayout(new BoxLayout(left, BoxLayout.LINE_AXIS));
		
		Box verticalBox = Box.createVerticalBox();
		left.add(verticalBox);
		
		 btnThem = new JButton("Thêm ");
		
		btnThem.setMaximumSize(new Dimension(Integer.MAX_VALUE, btnThem.getPreferredSize().height));
		verticalBox.add(box.createVerticalStrut(10));
		verticalBox.add(btnThem);
		
		btnXoa = new JButton("Xóa");
		btnXoa.setForeground(Color.WHITE);
		btnXoa.setBackground(Color.RED);
		
		btnXoa.setMaximumSize(new Dimension(Integer.MAX_VALUE, btnXoa.getPreferredSize().height));
		verticalBox.add(box.createVerticalStrut(10));
		verticalBox.add(btnXoa);
		
		
		 btnCapNhat = new JButton("Cập nhập");
		btnCapNhat.setForeground(Color.BLACK);
		verticalBox.add(box.createVerticalStrut(10));
		
	
		
		verticalBox.add(box.createVerticalStrut(10));
		verticalBox.add(btnCapNhat);
		
		
		
		verticalBox.add(box.createVerticalStrut(10));
		 btnQuayLai = new JButton("Quay Lại");
		verticalBox.add(btnQuayLai);
		btnQuayLai.setMaximumSize(new Dimension(Integer.MAX_VALUE, btnXoa.getPreferredSize().height));
		cen = new JPanel();
		
		btnQuayLai.addActionListener(this);
		
		btnCapNhat.addActionListener(this);
		btnThem.addActionListener(this);
		btnXoa.addActionListener(this);
		taoBang();
		database.getInstance().connect();
		updateTableData();
	
		
	}
	private void updateTableData() {
		 
		Xe_DAO dsXe = new Xe_DAO();
		List<Xe> list = dsXe.docTuBang();
		for (Xe x : list) {
			String [] rowData = {x.getMaXe(),x.getTenXe(),x.getMaLoaiXe().getMaLoaiXe(),Double.toString(x.getGiaBan()),Integer.toString(x.getSoLuong()),x.getSoKhung(),x.getSoMay(),x.getMau(),Integer.toString(x.getDungTich()),x.getTinhTrang()};
			
			model.addRow(rowData);
		}
		table.setModel(model);
	}

	public void taoBang() {

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
		JScrollPane jc = new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	
		getContentPane().add(jc, BorderLayout.CENTER);
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
				txtMaXe.setText(model.getValueAt(row, 0).toString());
				txtMaLoai.setText(model.getValueAt(row, 1).toString());
				txtTenXe.setText(model.getValueAt(row, 2).toString());
				txtGiaBan.setText(model.getValueAt(row, 3).toString());
				txtSoLuong.setText(model.getValueAt(row, 4).toString());
				txtSoKhung.setText(model.getValueAt(row, 5).toString());
				txtSoMay.setText(model.getValueAt(row, 6).toString());
				txtMau.setText(model.getValueAt(row, 7).toString());
				txtDungTich.setText(model.getValueAt(row, 8).toString());
				txtTinhTrang.setText(model.getValueAt(row, 9).toString());

			}
		});
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
				String maXe = txtMaXe.getText();
		
				
				String loaiXe =  txtMaLoai.getText();
				LoaiXe lx = new LoaiXe(loaiXe);
				
				String tenXe = txtTenXe.getText();
				double giaBan = Double.parseDouble(txtGiaBan.getText());
				int soLuong = Integer.parseInt(txtSoLuong.getText());
				String soKhung = txtSoKhung.getText();
				String soMay = txtSoMay.getText();
				String mau = txtMau.getText();
				int dungTich = Integer.parseInt(txtDungTich.getText());
				String tinhTrang = txtTinhTrang.getText();
				Xe xe = new Xe(maXe,tenXe, lx,  giaBan, soLuong, soKhung,soMay,mau ,dungTich, tinhTrang);
			    Object[] row = {maXe,tenXe, lx,  giaBan, soLuong, soKhung,soMay,mau ,dungTich, tinhTrang};
			    model.addRow(row);
			    dsXe.add(xe);
			    JOptionPane.showMessageDialog(this, "Thêm thành công");
				xoaRong();
			} 
		}
		else if(o.equals(btnCapNhat)) {   
			for (Xe x : dsXe) {
			    Xe xe = new Xe(x.getMaXe(),x.getTenXe(), x.getMaLoaiXe(), x.getGiaBan(), x.getSoLuong(),x.getSoKhung(),x.getSoMay(),x.getMau(),x.getDungTich(),x.getTinhTrang());
			    xe_DAO.tao(xe);
			}
			JOptionPane.showMessageDialog(this, "Lưu thành công");
		}
		else if(o.equals(btnXoa)) {
			int row = table.getSelectedRow(); 
		    if (row >= 0){
		        String maXe = (String) table.getModel().getValueAt(row, 0);
		        if(xe_DAO.xoaTheoMaXe(maXe)) {
		            model.removeRow(row);
		            xoaRong();
		            JOptionPane.showMessageDialog(this, "Xóa thành công");
		        }
		    }
		}
		
	}
	
	public void xoaRong() {
		txtDungTich.setText("");
		txtGiaBan.setText("");
		txtMaLoai.setText(""); 
		txtMau.setText(""); 
		txtMaXe.setText(""); 
		txtSoKhung.setText(""); 
		txtSoLuong.setText(""); 
		txtSoMay.setText(""); 
		txtTenXe.setText(""); 
		txtTinhTrang.setText(""); 
		txtMaXe.requestFocus();
	}
	public boolean checkregex() {
		String maXe = txtMaXe.getText().trim();
		String maLoaiXe = txtMaLoai.getText().trim();
		String tenXe = txtTenXe.getText().trim();
		double giaBan = Double.parseDouble(txtGiaBan.getText().trim());
		int soLuong = Integer.parseInt(txtSoLuong.getText().trim());
		String soKhung = txtSoKhung.getText().trim();
		String soMay = txtSoMay.getText().trim();
		String mau = txtMau.getText().trim();
		int dungTich =Integer.parseInt(txtDungTich.getText().trim());
		String tinhTrang = txtTinhTrang.getText().trim();
		if(!(maXe.length() > 0 && maXe.matches("^X\\d{2}$")))
		{
			JOptionPane.showMessageDialog(this, "Error : Mã Xe theo mẫu : X01");
			return false;
		}
		if(!(tenXe.length() > 0 && maXe.matches("^[a-zA-Z0-9\\-\\s\\.\\'\\\"]+$")))
		{
			JOptionPane.showMessageDialog(this, "Error : Tên Xe theo mẫu ");
			return false;
		}
		if(!(giaBan > 0 ))
		{
			JOptionPane.showMessageDialog(this, "Error : Giá Bán phải lớn hơn 0 ");
			return false;
		}
		if(!(soLuong > 0))
		{
			JOptionPane.showMessageDialog(this, "Số lượng phải lớn hơn 0");
			return false;
		}
		if(!(soKhung.length() > 0 && soKhung.matches("^SK\\d{3}$")))
		{
			JOptionPane.showMessageDialog(this, "Số khung có 2 chữ đầu là SK và 3 số ");
			return false;
		}
		if(!(soMay.length() > 0 && soMay.matches("^SM\\d{3}$") ))
		{
			JOptionPane.showMessageDialog(this, "Số máy có 2 chữ đầu là SM và 3 số ");
			return false;
		}
		if(!(dungTich >= 100))
		{
			JOptionPane.showMessageDialog(this, "Dung tích phải lớn hơn bằng 100");
			return false;
		}
		if (!(tinhTrang.length() > 0 && tinhTrang.matches("(Mới|Cũ)"))) {
		    JOptionPane.showMessageDialog(this, "Tình trạng phải là 'Mới' hoặc 'Cũ'");
		    return false;
		}
		//	txtSoLuong.getText().equals("") || txtSoKhung.getText().equals("") || txtSoMay.getText().equals("") || txtMau.getText().equals("") || txtDungTich.getText().equals("") || txtTinhTrang.
		return true;
	}
}
