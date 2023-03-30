
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
        return "TiviST " + "ma=" + ma + ", ten=" + ten + ", xuatXu=" + xuatXu + ", he dieu hanh=" + heDieuHanh +", namsx =" + namSx + ", hTrongkho=" + hTrongkho+", don gia="+donGia+", ngay nhap kho="+nnst;
    }
    @Override
    public Date hien(int day,int month,int year){
        Calendar cl = Calendar.getInstance();
        cl.set(year, month-1, day);
        return ngayNhap = cl.getTime();
    }
        public void nhap(){
                Scanner sc = new Scanner(System.in);
                System.out.print("Nhap ma tivi: ");  ma = sc.nextLine();
                System.out.print("Nhap ten tivi: "); ten = sc.nextLine();
                System.out.print("Nhap xuat xu tivi: "); xuatXu = sc.nextLine();
                System.out.print("Nhap he dieu hanh cua tivi: ");heDieuHanh = sc.nextLine();
                
                System.out.print("Nhap namsx tivi: ");namSx = sc.nextInt();
                if(namSx<0){
                    System.out.print(" Vui long nhap lai nam san xuat cua san pham: ");
                    namSx = sc.nextInt();    
                }
                System.out.println("Nhap vao ngay nhap kho: ");
                System.out.print("ngay:"); int day = sc.nextInt();
                System.out.print("thang:"); int month = sc.nextInt();
                System.out.print("nam:"); int year = sc.nextInt();
                hien(day, month, year);
                System.out.print("Nhap so hang trong kho tivi: ");hTrongkho = sc.nextInt();
                if(hTrongkho<0){
                    System.out.print(" Vui long nhap lai so luong cua san pham: ");
                    hTrongkho = sc.nextInt();    
                }
                System.out.print("Nhap don gia cua san pham: "); donGia = sc.nextDouble();
                if(donGia<0){
                    System.out.print(" Vui long nhap lai don gia cua san pham: ");
                    donGia = sc.nextDouble();    
                }
        }
}  

    


 