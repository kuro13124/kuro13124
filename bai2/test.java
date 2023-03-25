
package bai2;

import java.util.Scanner;



public class test {


    public static void main(String[] args) {
        
          Scanner sc = new Scanner(System.in);
          Danhsachhinh ds = new Danhsachhinh();
          Hinh t = new Hinhtron();
          Hinh c = new Hinhchunhat();
          
            do {
            System.out.print("Chọn chức năng  ");
            int choose = sc.nextInt();
             
            switch(choose) {
                case 1:
                    System.out.println("nhap cd");
                    float cd = sc.nextFloat();
                    System.out.println("nhap cr");
                    float cr = sc.nextFloat();
                    c.dientich();
                    Hinh cn = new Hinhchunhat(cd,cr);
                    ds.addH(cn);
                    ds.hienThiDanhSachHinh();
                    break;
                case 2:
                    System.out.println("nhap r");
                    float r = sc.nextFloat();
                    t.dientich();
                    Hinh ht = new Hinhtron(r);
                    ds.addH(ht);
                    ds.hienThiDanhSachHinh();
                    break;
            }
            }while (true);
            
 }
}


