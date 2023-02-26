
package nhanvien;

import java.util.Scanner;

public class Salary {
//thuoc tinh
    private String tenNhanVien;
    private double luongCoban=9000000;//luong co ban 9tr
    private double heSoluong;
    public double LUONG_MAX = 30000000;// luong max 30tr
    double tinhLuong;
    //khoi tao phuong thuc
    public Salary(){       
    }

    public Salary(String tenNhanVien, double heSoluong, double LUONG_MAX) {
        this.tenNhanVien = tenNhanVien;
        this.heSoluong = heSoluong;
    }

    public String getTenNhanVien() {
        return tenNhanVien;
    }

    public void setTenNhanVien(String tenNhanVien) {
        this.tenNhanVien = tenNhanVien;
    }

    public double getLuongCoban() {
        return luongCoban;
    }

    public void setLuongCoban(double luongCoban) {
        this.luongCoban = luongCoban;
    }

    public double getHeSoluong() {
        return heSoluong;
    }

    public void setHeSoluong(double heSoluong) {
        this.heSoluong = heSoluong;
    }

    @Override
    public String toString() {
        return  " "+ "tenNhanVien=" + tenNhanVien + ", heSoluong=" + heSoluong + "" ;
    }
    
    public void inTTtin(){
        System.out.println(toString());
    }
    public void input(){
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap ten nhan vien");
        this.tenNhanVien = sc.nextLine();
        System.out.println("nhap he so luong");
        this.heSoluong = sc.nextDouble();   
    }
 public double tinhLuong(){
     int luong = (int) (luongCoban * heSoluong);    
     System.out.println(" tien luong nhan vien la " + luong);
     return luong;
 }
 public boolean tangLuong(double tang){
     Scanner tl = new Scanner(System.in);
     System.out.println(" nhap so tang");
     tang = tl.nextDouble();
    int luongtang = (int) (luongCoban *(heSoluong + tang));
    if( luongtang  > LUONG_MAX){
        System.out.println(" tien luong nhan vien khong duoc tang ");
       return false;
   }
   System.out.println(" tien luong nhan vien sau khi tang " + luongtang);
    return true;
      }
}


                
