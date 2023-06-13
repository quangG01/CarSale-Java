package DAO;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Data.database;
import Object.KhachHang;





public class KhachHang_DAO {
	private static ArrayList<KhachHang> dskh = new ArrayList<KhachHang>();
	
	public ArrayList<KhachHang> docTuBang(){
		try {
			Connection con = database.getInstance().getConnection();
			String sql = "select *, MaKH from KhachHang";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String  makh = rs.getString(1);
				String tenkh = rs.getString(2); 
				String gt = rs.getString(3);
				String dc = rs.getString(4);
				String sdt = rs.getString(5);
				String gc = rs.getString(6);
								
				KhachHang kh = new KhachHang(makh,tenkh, gt, dc, sdt, gc);
				dskh.add(kh);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dskh;		
	}
	public boolean tao(KhachHang kh) {
		Connection con = database.getInstance().getConnection();
		if (con == null) {
			// Xử lý lỗi kết nối
			return false;
		}

		PreparedStatement stm = null;
		int n = 0;
		try {
			String sql = "insert into KhachHang values(?,?,?,?,?,?)";
			stm = con.prepareStatement(sql);
			stm.setString(1, kh.getMaKH());
			stm.setString(2, kh.getTenKH());
			stm.setString(3, kh.getGioiTinh());
			stm.setString(4, kh.getDiaChi());
			stm.setString(5, kh.getSDT());
			stm.setString(6, kh.getGhiChu());

			n = stm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stm != null) {
					stm.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}

		return n > 0;
	}

//	public boolean tao (Xe x) {
//		Connection con = database.getInstance().getConnection();
//		PreparedStatement stm = null;
//		int n = 0;
//		try {
//			String sql = "insert into"+ " Xe values(?,?,?,?,?,?,?,?,?,?)";
//			stm = con.prepareStatement(sql);
//			stm.setString(1,x.getMaXe());
//			stm.setString(2, x.getTenXe());
//			stm.setString(3, x.getMaLoaiXe().getMaLoaiXe());
//			stm.setDouble(4, x.getGiaBan());
//			stm.setInt(5, x.getSoLuong());
//			stm.setString(6, x.getSoKhung());
//			stm.setString(7, x.getSoMay());
//			stm.setString(8, x.getMau());
//			stm.setInt(9, x.getDungTich());
//			stm.setString(10, x.getTinhTrang());
//			
//			n = stm.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return n > 0;
//	}

	public boolean capnhat (KhachHang kh) {
		Connection con = database.getInstance().getConnection();
		PreparedStatement stm = null;
		int n = 0;
		try {
			stm = con.prepareStatement ("update KhachHang set TenKH = ?,GioiTinh = ?,DiaChi = ?, SDT = ?,GhiChu= ? where MaKH = ?");
			
			
			
			stm.setString(1, kh.getTenKH());
			stm.setString(2, kh.getGioiTinh());
			stm.setString(3, kh.getDiaChi());
			stm.setString(4, kh.getSDT());
			stm.setString(5, kh.getGhiChu());
			stm.setString(6, kh.getMaKH());
			
			n = stm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}
	public boolean xoaTheoMakh(String maKH) {
		Connection con = database.getInstance().getConnection();
		PreparedStatement stm = null;
		int n = 0;
		try {
			stm = con.prepareStatement("delete from KhachHang where MaKH=?");
			stm.setString(1, maKH);
			n = stm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (n == 0) {
			return false;
		}
		return true;
	}
	
}
