
package bai_2;

import java.util.Scanner;

public class KH_NN extends KH{
    public String quoctich;

    public KH_NN() {
    }

    public KH_NN(String quoctich, String ma, String ho_ten, String date, double so_luong, double don_Gia) {
        super(ma, ho_ten, date, so_luong, don_Gia);
        this.quoctich = quoctich;
    }

    public String getQuoctich() {
        return quoctich;
    }

    public void setQuoctich(String quoctich) {
        this.quoctich = quoctich;
    }
    public void nhap(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ma "); ma = sc.nextLine();
        System.out.println("nhap quoc tich"); quoctich = sc.nextLine();
        System.out.println("nhao ngay/thang/nam");date = sc.nextLine(); 
        System.out.println("nhap don gia"); don_Gia = sc.nextDouble();
        System.out.println("nhap so luong"); so_luong= sc.nextDouble();
        
    }
    
}
