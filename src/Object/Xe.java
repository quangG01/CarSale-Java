package Object;

public class Xe {
	private String MaXe;
	private String TenXe;
	private LoaiXe MaLoaiXe;
	private double GiaBan;
	private int SoLuong;
	private String SoKhung;
	private String SoMay;
	private String Mau;
	private int DungTich;
	private String TinhTrang;
	public Xe(String maXe, String tenXe, LoaiXe maLoaiXe, double giaBan, int soLuong, String soKhung,
			String soMay, String mau, int dungTich, String tinhTrang) {
		super();
		MaXe = maXe;
		TenXe = tenXe;
		MaLoaiXe = maLoaiXe;
		GiaBan = giaBan;
		SoLuong = soLuong;
		SoKhung = soKhung;
		SoMay = soMay;
		Mau = mau;
		DungTich = dungTich;
		TinhTrang = tinhTrang;
	}
	public Xe() {
		super();
		
	}
 
	public Xe(String maXe) {
		this.MaXe = maXe;
	}
	public String getMaXe() {
		return MaXe;
	}
	public void setMaXe(String maXe) {
		MaXe = maXe;
	}
	public String getTenXe() {
		return TenXe;
	}
	public void setTenXe(String tenXe) {
		TenXe = tenXe;
	}
	public LoaiXe getMaLoaiXe() {
		return MaLoaiXe;
	}
	public void setMaLoaiXe(LoaiXe maLoaiXe) {
		MaLoaiXe = maLoaiXe;
	}
	public double getGiaBan() {
		return GiaBan;
	}
	public void setGiaBan(double giaBan) {
		GiaBan = giaBan;
	}
	public int getSoLuong() {
		return SoLuong;
	}
	public void setSoLuong(int soLuong) {
		SoLuong = soLuong;
	}
	public String getSoKhung() {
		return SoKhung;
	}
	public void setSoKhung(String soKhung) {
		SoKhung = soKhung;
	}
	public String getSoMay() {
		return SoMay;
	}
	public void setSoMay(String soMay) {
		SoMay = soMay;
	}
	public String getMau() {
		return Mau;
	}
	public void setMau(String mau) {
		Mau = mau;
	}
	public int getDungTich() {
		return DungTich;
	}
	public void setDungTich(int dungTich) {
		DungTich = dungTich;
	}
	public String getTinhTrang() {
		return TinhTrang;
	}
	public void setTinhTrang(String tinhTrang) {
		TinhTrang = tinhTrang;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("%s %s %s %ld %d %s %s %s %s %s",MaXe,TenXe,MaLoaiXe,GiaBan,SoLuong,SoKhung,SoMay,Mau,DungTich,TinhTrang);
	}
}
//private String MaXe;
//private String TenXe;
//private String MaLoaiXe;
//private double GiaNhap;
//private double GiaBan;
//private int SoLuong;
//private String SoKhung;
//private String SoMay;
//private String Mau;
//private String DungTich;
//private String TinhTrang;