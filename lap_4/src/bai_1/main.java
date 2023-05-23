
package bai_1;

import java.text.ParseException;
import java.util.Scanner;


public class main {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        List_gd list = new List_gd();
        Gd_dat d = new Gd_dat();
        int luachon=0;
        do{
            System.out.println("1.add");
            System.out.println("2.display");
            System.out.println("3.count");
            System.out.println("");
            luachon = sc.nextInt();
            sc.nextLine();
            switch(luachon){
                case 1:{
                   d = new Gd_dat();
                   d.nhap();
                   list.add(d);
                   break;
                }
                case 2:{
                    list.display();
                    break;
                }
                case 3:{
                    System.out.println("count"+list.count());
                    break;
                }
                case 4:{
                    list.tb_dat();
                    break;
                }
                case 5:{
                    list.ngay_dat();
                    break;
                }
            }
        }while(luachon!=0);
    }
}
