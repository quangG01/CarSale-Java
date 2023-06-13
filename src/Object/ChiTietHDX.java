package Object;

public class ChiTietHDX {
	private HoaDonXuat HoaDonXuat;
	private String MaHDX;
	private String MaXe;
	private double DonGia;
	private int SoLuong;
	private double ThueVAT;
	public ChiTietHDX() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ChiTietHDX(HoaDonXuat hoaDonXuat, String maHDX, String maXe, double donGia, int soLuong,double thueVAT) {
		super();
		HoaDonXuat = hoaDonXuat;
		MaHDX = maHDX;
		MaXe = maXe;
		DonGia = donGia;
		SoLuong = soLuong;
		ThueVAT = thueVAT;
	}

	public HoaDonXuat getHoaDonXuat() {
		return HoaDonXuat;
	}

	public void setHoaDonXuat(HoaDonXuat hoaDonXuat) {
		HoaDonXuat = hoaDonXuat;
	}

	public String getMaHDX() {
		return MaHDX;
	}

	public void setMaHDX(String maHDX) {
		MaHDX = maHDX;
	}

	public String getMaXe() {
		return MaXe;
	}

	public void setMaXe(String maXe) {
		MaXe = maXe;
	}

	public double getDonGia() {
		return DonGia;
	}

	public void setDonGia(double donGia) {
		DonGia = donGia;
	}

	public int getSoLuong() {
		return SoLuong;
	}

	public void setSoLuong(int soLuong) {
		SoLuong = soLuong;
	}

	public double getThueVAT() {
		return ThueVAT;
	}

	public void setThueVAT(double thueVAT) {
		ThueVAT = thueVAT;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("%s %s %s %ld %d %ld",HoaDonXuat, MaHDX,MaXe,DonGia,SoLuong,ThueVAT);
	}
}
