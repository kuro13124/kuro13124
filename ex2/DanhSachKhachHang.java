package ex2;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class DanhSachKhachHang implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Queue<KhachHang> listDoiVe, listCoVe;
	
	public DanhSachKhachHang()
	{
		listDoiVe = new LinkedList<KhachHang>();
		listCoVe = new LinkedList<KhachHang>();
	}
	
	public Queue<KhachHang> getAllKHDoiVe()
	{
		return listDoiVe;
	}
	
	public Queue<KhachHang> getAllKHCoVe()
	{
		return listCoVe;
	}
	
	public boolean themKHVaoListDoi(KhachHang kh) throws Exception
	{
		if(listDoiVe.contains(kh))
			throw new Exception("Trùng số CMND!");
		listDoiVe.add(kh);
		return true;
	}
	
	public boolean xoaKH(KhachHang kh)
	{
		listDoiVe.remove(kh);
		return true;
	}
	
	public KhachHang timKH(String cMND)
	{
		for (KhachHang kh : listDoiVe)
		{
			if(kh.getcMND().equalsIgnoreCase(cMND))
				return kh;
		}
		return null;
	}
	
	public boolean banVe() {
		if(listDoiVe.size() > 0)
		{
			KhachHang kh = listDoiVe.poll(); // Lấy khách hàng xếp hàng trước trong list đợi mua vé
			listCoVe.add(kh);
			return true;
		}
		return false;
	}
	
	public int tongSoKHDoiVe()
	{
		return listDoiVe.size();
	}
	
	public int tongSoKHCoVe()
	{
		return listCoVe.size();
	}
	
	public double tongTien()
	{
		double sum = 0;
		for (KhachHang kh : listCoVe) 
		{
			sum += kh.getGiaTien();
		}
		return sum;
	}
	
	public Set<String> danhSachGaDoiVe() 
	{
		Set<String> listGa = new TreeSet<String>();
		for(KhachHang kh: listDoiVe)
			listGa.add(kh.getGaDen());
		return listGa;
	}
	
	public int tongSoKHChoTungGa(String ga)
	{
		int dem = 0;
		for (KhachHang kh : listDoiVe) {
			if(kh.getGaDen().equalsIgnoreCase(ga))
				dem++;
		}
		return dem;
	}
	
	public Map<String, Integer> thongKeSoVeTungGa() 
	{
		Map<String, Integer> bangThongKe = new TreeMap<String, Integer>();
		for(KhachHang kh : listCoVe)
		{
			String ga = kh.getGaDen();
			if(bangThongKe.containsKey(ga)) // kiểm tra trong bảng thống kê có ga này hay không?
				bangThongKe.put(ga, bangThongKe.get(ga) + 1); // Nếu có: ga là key, và lấy ra value của ga này cộng thêm 1
			else
				bangThongKe.put(ga, 1); // Nếu không: thêm key mới là tên ga này, gán value bằng 1 
		}
		return bangThongKe;
	}
	
	// Lưu file
	public void saveDsDoiVe(String fileName) 
	{
		SaveLoadFile.save(listDoiVe, fileName);
	}
	
	// Đọc file
	public void loadDsDoiVe(String fileName)
	{
		listDoiVe = (Queue<KhachHang>)SaveLoadFile.load(fileName);
	}
}
