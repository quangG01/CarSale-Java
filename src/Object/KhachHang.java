package Object;

public class KhachHang {
	private String MaKH;
	private String TenKH;
	private String GioiTinh;
	private String DiaChi;
	private String SDT;
	private String GhiChu;
	public KhachHang() {
		super();
		// TODO Auto-generated constructor stub
	}
	public KhachHang(String maKH, String tenKH, String gioiTinh, String diaChi, String sDT, String ghiChu) {
		super();
		MaKH = maKH;
		TenKH = tenKH;
		GioiTinh = gioiTinh;
		DiaChi = diaChi;
		SDT = sDT;
		GhiChu = ghiChu;
	}
	public KhachHang(String maKH)
	{
		this.MaKH = maKH;
	}
	public String getMaKH() {
		return MaKH;
	}
	public void setMaKH(String maKH) {
		MaKH = maKH;
	}
	public String getTenKH() {
		return TenKH;
	}
	public void setTenKH(String tenKH) {
		TenKH = tenKH;
	}
	public String getGioiTinh() {
		return GioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		GioiTinh = gioiTinh;
	}
	public String getDiaChi() {
		return DiaChi;
	}
	public void setDiaChi(String diaChi) {
		DiaChi = diaChi;
	}
	public String getSDT() {
		return SDT;
	}
	public void setSDT(String sDT) {
		SDT = sDT;
	}
	public String getGhiChu() {
		return GhiChu;
	}
	public void setGhiChu(String ghiChu) {
		GhiChu = ghiChu;
	}
	@Override
	public String toString() {
		
		return String.format("%s %s %s %s %s %s",MaKH,TenKH,GioiTinh,DiaChi,SDT,GhiChu);
	}
}
