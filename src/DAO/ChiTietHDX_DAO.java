//package DAO;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//
//import Data.database;
//import Object.ChiTietHDX;
//import Object.HoaDonXuat;
//
//
//
//public class ChiTietHDX_DAO {
//	private static ArrayList<ChiTietHDX> dshd = new ArrayList<ChiTietHDX>();
//	
//	public ArrayList<ChiTietHDX> docTuBang(){
//		try {
//			Connection con = database.getInstance().getConnection();
//			String sql = "select *, MaHDX from ChiTietHDX";
//			Statement statement = con.createStatement();
//			ResultSet rs = statement.executeQuery(sql);
//			while (rs.next()) {
//				String maHDX = rs.getString(1);
//				String maXe = rs.getString(2); 
//				HoaDonXuat maLoaiXe = new HoaDonXuat(rs.getString(3));
//				double donGia = rs.getDouble(4);
//				int soLuong = rs.getInt(5); 
//				double thueVAT = rs.getDouble(9); 
//				
//				ChiTietHDX hdx = new ChiTietHDX(maLoaiXe, maHDX, maXe, donGia, soLuong, thueVAT);
//				dshd.add(hdx);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return dshd;		
//	}
//	public boolean tao(ChiTietHDX x) {
//		Connection con = database.getInstance().getConnection();
//		if (con == null) {
//			// Xử lý lỗi kết nối
//			return false;
//		}
//
//		PreparedStatement stm = null;
//		int n = 0;
//		try {
//			String sql = "insert into ChiTietHDX values(?,?,?,?,?,?,?,?,?,?)";
//			stm = con.prepareStatement(sql);
//			stm.setString(1, x.getHoaDonXuat().getMaHDX());
//			stm.setString(2, x.getMaHDX());
//			stm.setString(3, x.getMaXe());
//			stm.setDouble(4, x.getDonGia());
//			stm.setInt(5, x.getSoLuong());
//			stm.setDouble(6, x.getThueVAT());
//	
//			n = stm.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if (stm != null) {
//					stm.close();
//				}
//			} catch (SQLException ex) {
//				ex.printStackTrace();
//			}
//		}
//
//		return n > 0;
//	}
//
////	public boolean tao (Xe x) {
////		Connection con = database.getInstance().getConnection();
////		PreparedStatement stm = null;
////		int n = 0;
////		try {
////			String sql = "insert into"+ " Xe values(?,?,?,?,?,?,?,?,?,?)";
////			stm = con.prepareStatement(sql);
////			stm.setString(1,x.getMaXe());
////			stm.setString(2, x.getTenXe());
////			stm.setString(3, x.getMaLoaiXe().getMaLoaiXe());
////			stm.setDouble(4, x.getGiaBan());
////			stm.setInt(5, x.getSoLuong());
////			stm.setString(6, x.getSoKhung());
////			stm.setString(7, x.getSoMay());
////			stm.setString(8, x.getMau());
////			stm.setInt(9, x.getDungTich());
////			stm.setString(10, x.getTinhTrang());
////			
////			n = stm.executeUpdate();
////		} catch (SQLException e) {
////			e.printStackTrace();
////		}
////		return n > 0;
////	}
//
//	public boolean capnhat (ChiTietHDX x) {
//		Connection con = database.getInstance().getConnection();
//		PreparedStatement stm = null;
//		int n = 0;
//		try {
//			String sql = "insert into ChiTietHDX values(?,?,?,?,?,?,?,?,?,?)";
//			stm = con.prepareStatement(sql);
//			stm.setString(1, x.getHoaDonXuat().getMaHDX());
//			stm.setString(2, x.getMaHDX());
//			stm.setString(3, x.getMaXe());
//			stm.setDouble(4, x.getDonGia());
//			stm.setInt(5, x.getSoLuong());
//			stm.setDouble(6, x.getThueVAT());
//	
//			n = stm.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if (stm != null) {
//					stm.close();
//				}
//			} catch (SQLException ex) {
//				ex.printStackTrace();
//			}
//		}
//
//		return n > 0;
//	}
//	
//	public static boolean xoaTheoMaHDX(String maHDX) {
//		Connection con = database.getInstance().getConnection();
//		PreparedStatement stm = null;
//		int n = 0;
//		try {
//			stm = con.prepareStatement("delete from ChiTietHDX where MaHDX=?");
//			stm.setString(1, maHDX);
//			n = stm.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//		if (n == 0) {
//			return false;
//		}
//		return true;
//	}
//}
