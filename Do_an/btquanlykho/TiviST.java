
package btquanlykho;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
public class TiviST extends Tivi {
    String heDieuHanh;
    public TiviST() {
    }
    public TiviST(String ma, String ten, String xuatXu,String heDieuHanh, int namSx, int hTrongkho,double donGia,Date ngayNhap){
        super(ma, ten, namSx, xuatXu, hTrongkho,donGia,ngayNhap);
        this.heDieuHanh = heDieuHanh;
    }
    public String getHeDieuHanh() {
        return heDieuHanh;
    }
    public void setHeDieuHanh(String heDieuHanh) {
        this.heDieuHanh = heDieuHanh;
    }
    @Override
    public String toString(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String nnst = sdf.format(ngayNhap);
        return "TiviST " + "Mã: " + ma + ", Tên: " + ten + ", Xuất xứ: " + xuatXu + ", Hệ điều hanh: " + heDieuHanh +", Năm sản xuất: " + namSx + ", Số lượng: " + hTrongkho+", Đơn giá: "+donGia+", Ngày nhập: "+nnst;
    }
    @Override
    public Date hien(int day,int month,int year){
        Calendar cl = Calendar.getInstance();
        cl.set(year, month-1, day);
        return ngayNhap = cl.getTime();
    }
    @Override
    public void nhap(){
                java.util.Date date = new java.util.Date();
                Calendar cl = Calendar.getInstance();
                date = cl.getTime();
                ngayNhap = cl.getTime();
                int day,month,year;
                Scanner sc = new Scanner(System.in);
                System.out.print("Nhập Mã Tivi: ");  ma = sc.nextLine();
                System.out.print("Nhập Tên Tivi: "); ten = sc.nextLine();
                System.out.print("Nhập xuất xứ Tivi: "); xuatXu = sc.nextLine();
                System.out.print("Nhập hệ điều hành Tivi: ");heDieuHanh = sc.nextLine();  
                do{
                    System.out.print("Nhập năm sản xuất Tivi: ");namSx = sc.nextInt();
                    if(namSx<1955){
                        System.out.println("Vui lòng nhập lại: ");   
                }
                }while(namSx<1955);
                System.out.println("Nhập ngày nhập kho Tivi: ");
                do{
                do{
                System.out.print("Ngày: "); day = sc.nextInt();
                System.out.print("Tháng: "); month = sc.nextInt();
                System.out.print("Năm: "); year = sc.nextInt();
                if(day<0||month <0||year<0||day>31||month>12){
                    System.out.println("Vui lòng nhập lại");
                }
                }while(day<0||month <0||year<0||day>31||month>12);
                hien(day, month, year);
                if(ngayNhap.compareTo(date)>0){
                    System.out.println("nhap lai");
                }
            }while(ngayNhap.compareTo(date)>0);
                do{
                System.out.print("Nhập số hàng trong kho Tivi: ");hTrongkho = sc.nextInt();
                if(hTrongkho<0){
                    System.out.print("Vui lòng nhập lại: ");   
                }
                }while(hTrongkho<0);
                do{
                System.out.print("Nhập đơn giá của sản phẩm: "); donGia = sc.nextDouble();
                if(donGia<0){
                    System.out.print("Vui lòng nhập lại: ");    
                }
                }while(donGia<0);
        }
}  

    


 