package Object;

import java.util.Objects;

public class TaiKhoan {



	String tenTK;
	String mk;
	public TaiKhoan() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TaiKhoan(String tenTK, String mk) {
		super();
		this.tenTK = tenTK;
		this.mk = mk;
	}
	public String getTenTK() {
		return tenTK;
	}
	public void setTenTK(String tenTK) {
		this.tenTK = tenTK;
	}
	public String getMk() {
		return mk;
	}
	public void setMk(String mk) {
		this.mk = mk;
	}
	@Override
	public int hashCode() {
		return Objects.hash(mk);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TaiKhoan other = (TaiKhoan) obj;
		return Objects.equals(mk, other.mk);
	}

}
