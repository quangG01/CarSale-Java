package Object;

import java.util.Objects;

public class LoaiXe {
	private String MaLoaiXe;
	private String TenLoaiXe;
	public LoaiXe(String maLoaiXe, String tenLoaiXe) {
		super();
		MaLoaiXe = maLoaiXe;
		TenLoaiXe = tenLoaiXe;
	}
	protected LoaiXe() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LoaiXe(String maLoaiXe) {
		MaLoaiXe = maLoaiXe;
	}
	
	
	public String getMaLoaiXe() {
		return MaLoaiXe;
	}
	public void setMaLoaiXe(String maLoaiXe) {
		MaLoaiXe = maLoaiXe;
	}
	public String getTenLoaiXe() {
		return TenLoaiXe;
	}
	public void setTenLoaiXe(String tenLoaiXe) {
		TenLoaiXe = tenLoaiXe;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("%s %s", MaLoaiXe,TenLoaiXe);
	}
	@Override
	public int hashCode() {
		return Objects.hash(MaLoaiXe);
	}
}
