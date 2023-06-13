package DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Data.database;
import Object.NhanVien;

public class DanhSachNhanVien {
	ArrayList<NhanVien> list;

	public DanhSachNhanVien() {
		list = new ArrayList<NhanVien>();
	}

	public ArrayList<NhanVien> getDSNhanVien() {
		try {
			database.getInstance();
			Connection con = database.getConnection();
			String sql = "{call getDSNhanVien}";
			CallableStatement myCall = con.prepareCall(sql);
			ResultSet rs = myCall.executeQuery();
			while (rs.next()) {
				String maNV = rs.getString(1);
				String tenNV = rs.getString(2);
				String gioiTinh = rs.getString(4);
				String ngaySinh = rs.getString(9);
				String dc = rs.getString(6);
				String sdt = rs.getString(5);
				String chucVu = rs.getString(8);
				String cMND = rs.getString(9);
				String userName = rs.getString(4);
				String passWord = rs.getString(9);
				NhanVien nv = new NhanVien(maNV, tenNV, gioiTinh, ngaySinh,dc, sdt, chucVu, cMND, userName, passWord);
				list.add(nv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public NhanVien getNhanVienTheoMa(String ma) {
		NhanVien nv = null;
		try {
			database.getInstance();
			Connection con = database.getConnection();
			String sql = "{call getNV(?)}";
			CallableStatement myCall = con.prepareCall(sql);
			myCall.setString(1, ma);
			ResultSet rs = myCall.executeQuery();
			while (rs.next()) {
				String maNV = rs.getString(1);
				String tenNV = rs.getString(2);
				String gioiTinh = rs.getString(4);
				String ngaySinh = rs.getString(9);

				String dc = rs.getString(6);
				String sdt = rs.getString(5);
				String chucVu = rs.getString(8);
				String cMND = rs.getString(9);
				String userName = rs.getString(4);
				String passWord = rs.getString(9);
				nv = new NhanVien(maNV, tenNV, gioiTinh, ngaySinh, dc, sdt, chucVu, cMND, userName, passWord);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nv;
	}
	public int getNVLapHD(String ma) {
		int nv = 0;
		try {
			database.getInstance();
			Connection con = database.getConnection();
			String sql = "{call getNVLapHD(?)}";
			CallableStatement myCall = con.prepareCall(sql);
			myCall.setString(1, ma);
			ResultSet rs = myCall.executeQuery();
			while (rs.next()) {
				nv = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nv;
	}
	public NhanVien getNVTheoSDT(String sdt) {
		NhanVien nv = null;
		try {
			database.getInstance();
			Connection con = database.getConnection();
			String sql = "{call getNVTheoSDT(?)}";
			CallableStatement myCall = con.prepareCall(sql);
			myCall.setString(1, sdt);
			ResultSet rs = myCall.executeQuery();
			while (rs.next()) {
				String maNV = rs.getString(1);
				String tenNV = rs.getString(2);
				String gioiTinh = rs.getString(4);
				String ngaySinh = rs.getString(9);

				String dc = rs.getString(6);
String sdt1 = rs.getString(5);
				String chucVu = rs.getString(8);
				String cMND = rs.getString(9);
				String userName = rs.getString(4);
				String passWord = rs.getString(9);
				nv = new NhanVien(maNV, tenNV, gioiTinh, ngaySinh, dc, sdt1, chucVu, cMND, userName, passWord);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nv;
	}
	public ArrayList<NhanVien> getNVTheoTen(String ten) {
		ArrayList<NhanVien> ds = new ArrayList<NhanVien>();
		try {
			database.getInstance();
			Connection con = database.getConnection();
			String sql = "{call getNVTheoTen(?)}";
			CallableStatement myCall = con.prepareCall(sql);
			myCall.setString(1, ten);
			ResultSet rs = myCall.executeQuery();
			while (rs.next()) {
				String maNV = rs.getString(1);
				String tenNV = rs.getString(2);
				String gioiTinh = rs.getString(4);
				String dc = rs.getString(6);
				String sdt = rs.getString(5);
				String chucVu = rs.getString(8);
				String cMND = rs.getString(9);
				String userName = rs.getString(4);
				String passWord = rs.getString(9);
				String ngaySinh = rs.getString(9);

				NhanVien nv = new NhanVien(maNV, tenNV, gioiTinh, ngaySinh, dc, sdt, chucVu, cMND, userName, passWord);
				ds.add(nv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ds;
	}
	public ArrayList<NhanVien> getNVTheoDC(String dchi) {
		ArrayList<NhanVien> ds = new ArrayList<NhanVien>();
		try {
			database.getInstance();
			Connection con = database.getConnection();
			String sql = "{call getNVTheoDC(?)}";
			CallableStatement myCall = con.prepareCall(sql);
			myCall.setString(1, dchi);
			ResultSet rs = myCall.executeQuery();
			while (rs.next()) {
				String maNV = rs.getString(1);
				String tenNV = rs.getString(2);
				String gioiTinh = rs.getString(4);
				String dc = rs.getString(6);
				String sdt = rs.getString(5);
				String chucVu = rs.getString(8);
				String cMND = rs.getString(9);
				String userName = rs.getString(4);
				String passWord = rs.getString(9);
				String ngaySinh = rs.getString(9);

				NhanVien nv = new NhanVien(maNV, tenNV, gioiTinh, ngaySinh, dc, sdt, chucVu, cMND, userName, passWord);
				ds.add(nv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ds;
	}
	public ArrayList<NhanVien> getNVTheoPB(String pb) {
		ArrayList<NhanVien> ds = new ArrayList<NhanVien>();
		try {
			database.getInstance();
			Connection con = database.getConnection();
			String sql = "{call getNVTheoPB(?)}";
			CallableStatement myCall = con.prepareCall(sql);
			myCall.setString(1, pb);
			ResultSet rs = myCall.executeQuery();
			while (rs.next()) {
				String maNV = rs.getString(1);
				String tenNV = rs.getString(2);
				String gioiTinh = rs.getString(4);
				String dc = rs.getString(6);
				String sdt = rs.getString(5);
				String chucVu = rs.getString(8);
				String cMND = rs.getString(9);
				String userName = rs.getString(4);
				String passWord = rs.getString(9);
				String ngaySinh = rs.getString(9);
NhanVien nv = new NhanVien(maNV, tenNV, gioiTinh, ngaySinh, dc, sdt, chucVu, cMND, userName, passWord);
				ds.add(nv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ds;
	}
	public boolean themNhanVien(NhanVien nv) {
		boolean b = true;
		try {
			database.getInstance();
			Connection con = database.getConnection();
			String sql = "{call addNV(?,?,?,?,?,?,?,?,?)}";
			CallableStatement myCall = con.prepareCall(sql);
			CallableStatement Call = con.prepareCall("{call addTK(?,?)}");
			myCall.setString(1, nv.getMaNV());
			myCall.setString(2, nv.getTenNV());
			myCall.setString(3, nv.getGioiTinh());
			myCall.setString(4, nv.getDiaChi());
			myCall.setString(5, nv.getSDT());
			myCall.setString(6, nv.getChucVu());
			myCall.setString(7, nv.getCMND());
			myCall.setString(8, nv.getPassword());
			Call.setString(1, nv.getMaNV());
			Call.setString(2, nv.getPassword());
			b = myCall.execute();
			Call.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return b;
	}

	public boolean suaNhanVien(NhanVien nv) {
		boolean b = true;
		try {
			database.getInstance();
			Connection con = database.getConnection();
			String sql = "{call updateNV(?,?,?,?,?,?,?,?,?)}";
			CallableStatement Call = con.prepareCall("{call updateTK(?,?)}");
			CallableStatement myCall = con.prepareCall(sql);
			myCall.setString(1, nv.getMaNV());
			myCall.setString(2, nv.getTenNV());
			myCall.setString(3, nv.getGioiTinh());
			myCall.setString(4, nv.getDiaChi());
			myCall.setString(5, nv.getSDT());
			myCall.setString(6, nv.getChucVu());
			myCall.setString(7, nv.getCMND());
			myCall.setString(8, nv.getPassword());
			Call.setString(1, nv.getMaNV());
			Call.setString(2, nv.getPassword());
			b = myCall.execute();
			Call.execute();
			b = myCall.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return b;
	}

	public boolean xoaNhanVien(String ma) {
		boolean b = true;
		try {
			database.getInstance();
			Connection con = database.getConnection();
			String sql = "{call deleteNV(?)}";
			CallableStatement Call = con.prepareCall("{call deleteTK(?)}");
			CallableStatement myCall = con.prepareCall(sql);
			if(getNVLapHD(ma) == 0) {
			myCall.setString(1, ma);
			Call.setString(1, ma);
			Call.execute();
			b = myCall.execute();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return b;
	}

	public int size() {
		return list.size();
	}
}
