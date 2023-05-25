package ex2;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Locale;

public class KhachHang implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String cMND, tenKH, gaDen;
	private double giaTien;
	
	public String getcMND() {
		return cMND;
	}
	public void setcMND(String cMND) throws Exception {
		if(cMND.length() > 0)
			this.cMND = cMND;
		else
			throw new Exception("Số CMND không được để rỗng!");
	}
	public String getTenKH() {
		return tenKH;
	}
	public void setTenKH(String tenKH) throws Exception {
		if(tenKH.length() > 0)
			this.tenKH = tenKH;
		else
			throw new Exception("Tên khách hàng không được để rỗng!");
	}
	public String getGaDen() {
		return gaDen;
	}
	public void setGaDen(String gaDen) throws Exception {
		if(gaDen.length() > 0)
			this.gaDen = gaDen;
		else
			throw new Exception("Ga đến không được để rỗng!");
	}
	public double getGiaTien() {
		return giaTien;
	}
	public void setGiaTien(double giaTien) throws Exception {
		if(giaTien > 0)
			this.giaTien = giaTien;
		else
			throw new Exception("Giá tiền phải lớn hơn 0!");
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cMND == null) ? 0 : cMND.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KhachHang other = (KhachHang) obj;
		if (cMND == null) {
			if (other.cMND != null)
				return false;
		} else if (!cMND.equals(other.cMND))
			return false;
		return true;
	}
	
	public KhachHang(String cMND, String tenKH, String gaDen, double giaTien) {
		super();
		this.cMND = cMND;
		this.tenKH = tenKH;
		this.gaDen = gaDen;
		this.giaTien = giaTien;
	}
	
	public KhachHang() {
		super();
	}
	
	@Override
	public String toString() {
		Locale localeVN = new Locale("vi", "VN");
	    NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
		String gia = currencyVN.format(giaTien);
		return String.format("|"+"%-10s"+"|"+"%-30s"+"|"+"%-15s"+"|"+"%15s"+"|", cMND, tenKH, gaDen, gia);
	}
}
