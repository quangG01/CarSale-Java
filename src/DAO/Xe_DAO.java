package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Data.database;
import Object.LoaiXe;
import Object.Xe;



public class Xe_DAO {
	private static ArrayList<Xe> dsXe = new ArrayList<Xe>();
	
	public ArrayList<Xe> docTuBang(){
		try {
			Connection con = database.getInstance().getConnection();
			String sql = "select *, MaXe from Xe";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maXe = rs.getString(1);
				String tenXe = rs.getString(2); 
				LoaiXe maLoaiXe = new LoaiXe(rs.getString(3));
				double giaBan = rs.getDouble(4);
				int soLuong = rs.getInt(5); 
				String soKhung = rs.getString(6); 
				String soMay = rs.getString(7); 
				String mau = rs.getString(8); 
				int dungTich = rs.getInt(9); 
				String tinhTrang = rs.getString(10); 
				
				Xe xe = new Xe(maXe,tenXe, maLoaiXe,  giaBan, soLuong, soKhung,soMay,mau ,dungTich, tinhTrang);
				dsXe.add(xe);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsXe;		
	}
	public boolean tao(Xe x) {
		Connection con = database.getInstance().getConnection();
		if (con == null) {
			// Xử lý lỗi kết nối
			return false;
		}

		PreparedStatement stm = null;
		int n = 0;
		try {
			String sql = "insert into Xe values(?,?,?,?,?,?,?,?,?,?)";
			stm = con.prepareStatement(sql);
			stm.setString(1, x.getMaXe());
			stm.setString(2, x.getTenXe());
			stm.setString(3, x.getMaLoaiXe().getMaLoaiXe());
			stm.setDouble(4, x.getGiaBan());
			stm.setInt(5, x.getSoLuong());
			stm.setString(6, x.getSoKhung());
			stm.setString(7, x.getSoMay());
			stm.setString(8, x.getMau());
			stm.setInt(9, x.getDungTich());
			stm.setString(10, x.getTinhTrang());

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

	public boolean capnhat (Xe x) {
		Connection con = database.getInstance().getConnection();
		PreparedStatement stm = null;
		int n = 0;
		try {
			stm = con.prepareStatement ("update Xe set TenXe = ?, MaLoaiXe = ?,GiaBan = ?,SoLuong = ?, SoKhung = ?,SoMay = ?,Mau = ? ,DungTich =?,TinhTrang = ? where MaXe = ?");
			
			
			stm.setString(1, x.getTenXe());
			stm.setString(2, x.getMaLoaiXe().getMaLoaiXe());
			stm.setDouble(3, x.getGiaBan());
			stm.setInt(4, x.getSoLuong());
			stm.setString(5, x.getSoKhung());
			stm.setString(6, x.getSoMay());
			stm.setString(7, x.getMau());
			stm.setInt(8, x.getDungTich());
			stm.setString(9, x.getTinhTrang());
			stm.setString(10,x.getMaXe());
			n = stm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}
	public boolean xoaTheoMaXe(String maXe) {
		Connection con = database.getInstance().getConnection();
		PreparedStatement stm = null;
		int n = 0;
		try {
			stm = con.prepareStatement("delete from Xe where MaXe=?");
			stm.setString(1, maXe);
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
