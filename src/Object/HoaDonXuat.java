package Object;

import java.time.LocalDate;

public class HoaDonXuat {
	private String MaHDX;
	private String MaKH;
	private String MaNV;
	private String NgayXuat;
	protected HoaDonXuat() {
		super();
		// TODO Auto-generated constructor stub
	}
	public HoaDonXuat(String maHDX, String maKH, String maNV, String ngayXuat) {
		super();
		MaHDX = maHDX;
		MaKH = maKH;
		MaNV = maNV;
		NgayXuat = ngayXuat;
	}
	public HoaDonXuat(String maHDX)
	{
		this.MaHDX = maHDX;
	}
	public String getMaHDX() {
		return MaHDX;
	}
	public void setMaHDX(String maHDX) {
		MaHDX = maHDX;
	}
	public String getMaKH() {
		return MaKH;
	}
	public void setMaKH(String maKH) {
		MaKH = maKH;
	}
	public String getMaNV() {
		return MaNV;
	}
	public void setMaNV(String maNV) {
		MaNV = maNV;
	}
	public String getNgayXuat() {
		return NgayXuat;
	}
	public void setNgayXuat(String ngayXuat) {
		NgayXuat = ngayXuat;
	}
	@Override
	public String toString() {
		
		return String.format("%s %s %s %s", MaHDX,MaKH,MaNV,NgayXuat);
	}
}
