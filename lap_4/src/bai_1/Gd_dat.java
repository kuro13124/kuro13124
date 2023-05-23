
package bai_1;


import java.util.Scanner;

/**
 *
 * @author ThienLaptop
 */
public class Gd_dat extends Giaodich{
    public String loai_dat;

    public Gd_dat() {
    }
    public Gd_dat(String loai_dat, String ma, String date, double donGia, double S) {
        super(ma, date, donGia, S);
        this.loai_dat = loai_dat;
    }

    public String getLoai_dat() {
        return loai_dat;
    }

    public void setLoai_dat(String loai_dat) {
        this.loai_dat = loai_dat;
    }

    @Override
    public String toString() {
        return "Giaodich{" + "ma=" + ma + ", date=" + date + ", donGia=" + donGia + ", S=" + S + '}'+"Gd_dat{" + "loai_dat=" + loai_dat + '}';
    }
    
    
    public void nhap(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ma dat"); ma = sc.nextLine();
        System.out.println("nhap loai dat"); loai_dat = sc.nextLine();
        System.out.println("nhao ngay/thang/nam");date = sc.nextLine(); 
        System.out.println("nhap don gia dat"); donGia = sc.nextDouble();   
        System.out.println("nhap dien tich dat"); S = sc.nextDouble();
          
}
}
