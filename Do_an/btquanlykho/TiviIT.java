
package btquanlykho;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
public class TiviIT extends Tivi{
        
    public TiviIT() {
    }
    public TiviIT(String ma, String ten, int namSx, String xuatXu, int hTrongkho,double donGia,Date ngayNhap) {
        super(ma, ten, namSx, xuatXu, hTrongkho,donGia,ngayNhap);
    }
    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String nnit = sdf.format(ngayNhap);
        return "TiviIT " + "Mã: " + ma + ", Tên: " + ten + ", Xuất xứ: " + xuatXu + ", Năm sản xuất: " + namSx + ", Số lượng: " + hTrongkho+", Đơn giá: "+donGia+", Ngày nhập: "+nnit;
    }
    @Override
    public Date hien(int day,int month,int year){
        Calendar cl = Calendar.getInstance();
        cl.set(year, month-1, day);
        return ngayNhap = cl.getTime();
    }

    @Override
   public void nhap(){
                int day,month,year;
                Scanner sc = new Scanner(System.in);
                System.out.print("Nhập Mã Tivi: ");  ma = sc.nextLine();
                System.out.print("Nhập Tên Tivi: "); ten = sc.nextLine();
                System.out.print("Nhập xuất xứ Tivi: "); xuatXu = sc.nextLine(); 
                do{
                    System.out.print("Nhập năm sản xuất Tivi: ");namSx = sc.nextInt();
                    if(namSx<1955){
                        System.out.println("Vui lòng nhập lại: ");   
                }
                }while(namSx<1955);
                System.out.println("Nhập ngày nhập kho Tivi: ");
                do{
                System.out.print("Ngày: "); day = sc.nextInt();
                System.out.print("Tháng: "); month = sc.nextInt();
                System.out.print("Năm: "); year = sc.nextInt();
                if(day<0||month <0||year<0||day>31||month>12){
                    System.out.println("Vui lòng nhập lại");
                }
                }while(day<0||month <0||year<0||day>31||month>12);
                hien(day, month, year);
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
