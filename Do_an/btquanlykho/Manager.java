
package btquanlykho;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
public class Manager {  
    public Date ngayXuat;
    public String Agency;
    public int soHang;
    public double kq;
    private String ramdom;
    private static final String alpha = "abcdefghijklmnopqrstuvwxyz"; // a-z
    private static final String digits = "0123456789"; // 0-9   
    private static Random generator = new Random();
    private static final String ALPHA_NUMERIC = alpha + digits;
    public Manager(){
    }

    public Manager(Date ngayXuat, String Agency,int soHang,double kq,String ramdom){
        this.ngayXuat = ngayXuat;
        this.Agency = Agency;
        this.soHang = soHang;
        this.kq = kq;
        this.ramdom = ramdom;
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

    public void setKq(double kq){
        this.kq = kq;
    }
    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String nx = sdf.format(ngayXuat);
            return "Mã đơn hàng: "+ ramdom + ", Agency: " + Agency + ", Số hàng nhập: " + soHang  + ", Ngày xuất kho: " +nx +", Số Tiền hàng: "+kq;
    }
   public Date xuat(int day,int month,int year){
        Calendar cl = Calendar.getInstance();
        cl.set(year, month-1, day);
        return this.ngayXuat=cl.getTime();
    }
    public String randomAlphaNumeric(int numberOfCharactor) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numberOfCharactor; i++) {
            int number = randomNumber(0, ALPHA_NUMERIC.length() - 1);
            char ch = ALPHA_NUMERIC.charAt(number);
            sb.append(ch);
        }
        return sb.toString();
    }
   public static int randomNumber(int min, int max) {
        return generator.nextInt((max - min) + 1) + min;
    }
}
