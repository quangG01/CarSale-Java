package Object;


import java.time.format.DateTimeFormatter;

public class NhanVien {
	private String MaNV;
	private String TenNV;
	private String GioiTinh;
	private String NgaySinh;
	private String DiaChi;
	private String SDT;
	private String ChucVu;
	private String CMND;
	private String UserName;
	private String Password;
	
	protected NhanVien() {
		super();
		
	}

	public NhanVien(String maNV, String tenNV, String gioiTinh, String ngaySinh, String diaChi, String sDT,
			String chucVu, String cMND, String userName, String password) {
		super();
		MaNV = maNV;
		TenNV = tenNV;
		GioiTinh = gioiTinh;
		NgaySinh = ngaySinh;
		DiaChi = diaChi;
		SDT = sDT;
		ChucVu = chucVu;
		CMND = cMND;
		UserName = userName;
		Password = password;
	}

	public String getMaNV() {
		return MaNV;
	}

	public void setMaNV(String maNV) {
		MaNV = maNV;
	}

	public String getTenNV() {
		return TenNV;
	}

	public void setTenNV(String tenNV) {
		TenNV = tenNV;
	}

	public String getGioiTinh() {
		return GioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		GioiTinh = gioiTinh;
	}

	public String getNgaySinh() {
		return NgaySinh;
	}

	public void setNgaySinh(String ngaySinh) {
		NgaySinh = ngaySinh;
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

	public String getChucVu() {
		return ChucVu;
	}

	public void setChucVu(String chucVu) {
		ChucVu = chucVu;
	}

	public String getCMND() {
		return CMND;
	}

	public void setCMND(String cMND) {
		CMND = cMND;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}
	@Override
	//	private String MaNV;
//	private String TenNV;
//	private String GioiTinh;
//	private LocalDate NgaySinh;
//	private String DiaChi;
//	private String SDT;
//	private String ChucVu;
//	private String CMND;
//	private String UserName;
//	private String Password;

	public String toString() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return String.format("%s %s %s %s %s %s %s %s %s %s ",MaNV,TenNV,GioiTinh,NgaySinh,DiaChi,SDT,ChucVu,CMND,UserName,Password);

	}
}
