package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Data.database;
import Object.HoaDonXuat;

public class HoaDonXuat_DAO {
	private static ArrayList<HoaDonXuat> dshd = new ArrayList<HoaDonXuat>();
	
	public ArrayList<HoaDonXuat> docTuBang(){
		try {
			Connection con = database.getInstance().getConnection();
			String sql = "select *, MaHDX from HoaDonXuat";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String  mahdx = rs.getString(1);
				String manv = rs.getString(2);
				String makh = rs.getString(3); 
				
				String ngayxuat = rs.getString(4); //dd-mm-yyyy
				
								
				HoaDonXuat kh = new HoaDonXuat(mahdx,manv,makh,  ngayxuat);
				dshd.add(kh);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dshd;		
	}
	public boolean tao(HoaDonXuat hd) {
		Connection con = database.getInstance().getConnection();
		if (con == null) {
			// Xử lý lỗi kết nối
			return false;
		}

		PreparedStatement stm = null;
		int n = 0;
		try {
			String sql = "insert into HoaDonXuat values(?,?,?,?)";
			stm = con.prepareStatement(sql);
			stm.setString(1, hd.getMaHDX());
			stm.setString(2, hd.getMaNV());
			stm.setString(3, hd.getMaKH());
			stm.setString(4, hd.getNgayXuat());
			

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


	public boolean capnhat (HoaDonXuat hd) {
		Connection con = database.getInstance().getConnection();
		PreparedStatement stm = null;
		int n = 0;
		try {
			stm = con.prepareStatement ("update HoaDonXuat set MaNV = ?, MaKH = ?,NgayXuat= ? where MaHDX = ?");			
			stm.setString(1, hd.getMaNV());
			stm.setString(2, hd.getMaKH());
			stm.setString(3, hd.getNgayXuat());
			stm.setString(4, hd.getMaHDX());
			n = stm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}
	public boolean xoaTheoMahd(String maHDX) {
		Connection con = database.getInstance().getConnection();
		PreparedStatement stm = null;
		int n = 0;
		try {
			stm = con.prepareStatement("delete from HoaDonXuat where MaHDX=?");
			stm.setString(1, maHDX);
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

