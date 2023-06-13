package DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Data.database;
import Object.TaiKhoan;

public class DanhSachTaikhoan_DAO {
	ArrayList<TaiKhoan> list;

	public DanhSachTaikhoan_DAO() {
		list = new ArrayList<TaiKhoan>();
	}

	public ArrayList<TaiKhoan> getDSTaiKhoan() {
		try {
			database.getInstance();
			Connection con = database.getConnection();
			String sql = "{call getDSTaiKhoan}";
			CallableStatement myCall = con.prepareCall(sql);
			ResultSet rs = myCall.executeQuery();
			while (rs.next()) {
				String maNV = rs.getString(1);
				String mkNV = rs.getString(2);
				TaiKhoan tk = new TaiKhoan(maNV, mkNV);
				list.add(tk);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public TaiKhoan getTaiKhoanTheoMa(String ma) {
		TaiKhoan tk = null;
		try {
			database.getInstance();
			Connection con = database.getConnection();
			String sql = "{call getTK(?)}";
			CallableStatement myCall = con.prepareCall(sql);
			myCall.setString(1, ma);
			ResultSet rs = myCall.executeQuery();
			while (rs.next()) {
				String maNV = rs.getString(1);
				String mkNV = rs.getString(2);
				tk = new TaiKhoan(maNV, mkNV);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tk;
	}

	public boolean themTaiKhoan(TaiKhoan tk) {
		boolean b = true;
		try {
			database.getInstance();
			Connection con = database.getConnection();
			String sql = "{call addTK(?,?)}";
			CallableStatement myCall = con.prepareCall(sql);
			myCall.setString(1, tk.getTenTK());
			myCall.setString(2, tk.getMk());
			b = myCall.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return b;
	}

	public boolean suaTaiKhoan(TaiKhoan tk) {
		boolean b = true;
		try {
			database.getInstance();
			Connection con = database.getConnection();
			String sql = "{call updateTK(?,?)}";
			CallableStatement myCall = con.prepareCall(sql);
			myCall.setString(1, tk.getTenTK());
			myCall.setString(2, tk.getMk());
			b = myCall.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return b;
	}

	public boolean xoaTaiKhoan(String ma) {
		boolean b = true;
		try {
			database.getInstance();
			Connection con = database.getConnection();
			String sql = "{call deleteTK(?)}";
			CallableStatement myCall = con.prepareCall(sql);
			myCall.setString(1, ma);
			b = myCall.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return b;
	}

	public int size() {
		return list.size();
	}
}
