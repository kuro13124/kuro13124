
package Test;

import btquanlykho.List;
import btquanlykho.TiviIT;
import btquanlykho.TiviST;
import java.io.File;
import java.util.Scanner;

public class main{
    public static void main(String[] args) {       
        Scanner sc = new Scanner(System.in);
        List ds = new List();
        TiviIT it = new TiviIT();
        TiviST st = new TiviST();
        int luaChon = 0;
        do{
            System.out.println("---------------------MENU----------------------------");
            System.out.println("----------------Quản lý KHO Tivi---------------------");
            System.out.println("-  Vui lòng chọn chức năng                          -");
            System.out.println("-  1.Nhập sản phẩm loại Tivi Smart                  -");
            System.out.println("-  2.Nhập sản phẩm loại Tivi Internet               -");
            System.out.println("-  3.In danh sách hiển thị sản phẩm trong kho       -");
            System.out.println("-  4.Đếm số lượng sản phẩm trong kho                -");
            System.out.println("-  5.Tìm kiếm sản phẩm theo tên                     -");
            System.out.println("-  6.Sắp xếp sản phẩm theo số lượng                 -");
            System.out.println("-  7.Sửa thông tin sản phẩm                         -");
            System.out.println("-  8.Xóa thông tin sản phâm                         -");
            System.out.println("-  9.Lưu danh sách vào file                         -");
            System.out.println("-  10.Đọc file danh sách Tivi Smart                 -");
            System.out.println("-  11.Đọc file danh sách Tivi Internet              -");
            System.out.println("-  12.Phiếu xuất hàng                               -");
            System.out.println("-  13.In danh sách Đại lý đã lấy hàng từ kho        -");
            System.out.println("-  0.Thoát chương trình                             -");
            System.out.println("-----------------------------------------------------");
            luaChon = sc.nextInt();
            sc.nextLine();
            switch(luaChon){
            case 1:
            {                      
                st = new TiviST();
                st.nhap();
                ds.add(st);
                break;
            }
            case 2:
            {      
                it = new TiviIT();
                it.nhap();
                ds.add(it);
                break;
            }
            case 3:{
                ds.display();
                break;
            }
            case 4:{
                System.out.println("Số lượng sản phẩm trong kho: " + ds.count());
                break;
            }
            case 5:{
                System.out.println("Nhập Tên Tivi: "); String ten = sc.nextLine();
                System.out.println("--Kết quản tìm kiếm---");
                ds.search(ten);
                break;
            }
            case 6:{
                ds.arrange();
                ds.display();
                break;
            }
            case 7:{
                ds.edit();
                break;
            }
            case 8:{
                ds.delete();
                break;
            }
            case 9:{
                System.out.print("Nhập tên file muốn lưu: ");
                String tenfilel = sc.nextLine();
                File fl = new File(tenfilel);
                ds.savefile(fl);
                break;
            }
            case 10:{
                System.out.print("Nhập tên file muốn đọc: ");
                String tenfiled = sc.nextLine();
                File fd = new File(tenfiled);
                ds.readfiles(fd);
                System.out.println("---Đọc file thành công---");
                break;
                }          
            case 11:{
                System.out.print("Nhập tên file muốn đọc: ");
                String tenfiled = sc.nextLine();
                File fd = new File(tenfiled);
                ds.readfilei(fd);
                System.out.println("---Đọc file thành công---");
                break;
            }
            case 12:{
                ds.du();
                break;
            }
            case 13:{
                ds.displayMa();
                break;
            }
            }   
    }while(luaChon!=0);
    
}
}
