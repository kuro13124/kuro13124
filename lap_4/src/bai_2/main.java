
package bai_2;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        KH_VN vn = new KH_VN();
        KH_NN nn = new KH_NN();
        List_KH_VN ds = new List_KH_VN();
        
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
                   vn = new KH_VN();
                   vn.nhap();
                   ds.add(vn);
                   break;
                }
                case 2:{
                    ds.display();
                    break;
                }
                case 3:{
                    System.out.println("count"+ds.count());
                    break;
                }
                case 4:{
                    ds.tt();
                    break;
                }
                case 5:{
                    ds.ngay();
                    break;
                }
                case 6:{
                    nn = new KH_NN();
                    nn.nhap();
                    ds.addn(nn);
                    break;
                }
                case 7:{
                    ds.displayn();
                    break;
                }
                case 8:{
                    ds.countn();
                    break;
                }
            }
        }while(luachon!=0);
    }
    }

