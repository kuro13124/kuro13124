
package btquanlykho;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class Manager {
       
    public Date ngayXuat;
    public String Agency;
    public int soHang;
    public double kq;
    public Manager(){
    }

    public Manager(Date ngayXuat, String Agency,int soHang,double kq){
        this.ngayXuat = ngayXuat;
        this.Agency = Agency;
        this.soHang = soHang;
        this.kq = kq;
    }
    
    public Date getNgayXuat() {
        return ngayXuat;
    }

    public void setNgayXuat(Date ngayXuat) {
        this.ngayXuat = ngayXuat;
    }

    public String getAgency() {
        return Agency;
    }

    public void setAgency(String Agency) {
        this.Agency = Agency;
    }

    public int getSoHang() {
        return soHang;
    }

    public void setSoHang(int soHang) {
        this.soHang = soHang;
    }

    public double getKq() {
        return kq;
    }

    public void setKq(double kq) {
        this.kq = kq;
    }
    

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String nx = sdf.format(ngayXuat);
            return "Info " + "Agency: " + Agency + ", Số hàng nhập: " + soHang  + ", Ngày xuất kho: " +nx +", Số Tiền hàng: "+kq;
    }
   public Date xuat(int day,int month,int year){
        Calendar cl = Calendar.getInstance();
        cl.set(year, month-1, day);
        return this.ngayXuat=cl.getTime();
    }
}
