
package Test;

import btquanlykho.ListTiviIT;
import btquanlykho.ListTiviST;
import btquanlykho.TiviIT;
import btquanlykho.TiviST;
import java.io.File;
import java.util.Scanner;


public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListTiviST dsst = new ListTiviST();
        ListTiviIT dsit = new ListTiviIT();
        int luaChon = 0;
        int luaChon1 = 0;
        int luaChon2 = 0;
        do{
            System.out.println("MENU--------------");
            System.out.println("Vui long chon chuc nang ------------");
            System.out.println("---1.quan ly san pham trong kho Tivi Smart---");
            System.out.println("---2.quan ly san pham trong kho Tivi Internet---");
            System.out.println("---0.thoat chuong trinh---");
            
            luaChon = sc.nextInt();
            sc.nextLine();
            switch(luaChon){
                case 1:{
        do{
            System.out.println("MENU--------------");
            System.out.println("KHO Tivi Smart--------------");
            System.out.println("Vui long chon chuc nang ------------");
            System.out.println("---1.them san pham trong kho---");
            System.out.println("---2.in danh sach san pham  trong kho ra man hinh---");
            System.out.println("---3.dem loai san pham trong kho---");
            System.out.println("---4.tim kiem ten san pham trong kho---");
            System.out.println("---5.sap xep san pham theo so luong giam dan---");
            System.out.println("---6.Sua thong tin san pham---");
            System.out.println("---7.Xoa thong tin san pham---");
            System.out.println("---8.Luu file ---");
            System.out.println("---9.doc file ---");
            System.out.println("---0.thoat chuong trinh---");
            
            luaChon1 = sc.nextInt();
            sc.nextLine();
            switch(luaChon1){
            case 1:
            {   
                System.out.println("Nhap ma tivi: "); String ma = sc.nextLine();
                System.out.println("Nhap ten tivi: "); String ten = sc.nextLine();
                System.out.println("Nhap xuat xu tivi: "); String xuatXu = sc.nextLine();
                System.out.println("Nhap he dieu hanh cua tivi: "); String heDieuHanh = sc.nextLine();
                System.out.println("Nhap ram cua san pham: "); int ram = sc.nextInt();
                System.out.println("Nhap namsx tivi: "); int namSx = sc.nextInt();                            
                System.out.println("Nhap so hang trong kho tivi: "); double hTrongkho = sc.nextDouble();
                
                TiviST tvst = new TiviST(ma,ten,xuatXu,heDieuHanh,ram,namSx,hTrongkho);
                dsst.addST(tvst);
                break;
            }
            case 2:{
                dsst.displayST();
                break;
            }
            case 3:{
                System.out.println("so luong loai san pham trong kho :" + dsst.countST());
                break;
            }
            case 4:{
                System.out.println("Nhap ten tivi: "); String ten = sc.nextLine();
                System.out.println("ket qua tim kiem");
                dsst.searchST(ten);
                break;
            }
            case 5:{
                dsst.arrangeST();
                dsst.displayST();
                break;
            }
            case 6:{
                dsst.editST();
                break;
            }
            case 7:{
                dsst.deleteST();
                break;
            }
            case 8:{
                System.out.println(" nhap ten file muon luu ");
                String tenfilel = sc.nextLine();
                File fl = new File(tenfilel);
                dsst.savefileST(fl);
                break;
            }
            case 9:{
                System.out.println(" nhap ten file muon doc ");
                String tenfiled = sc.nextLine();
                File fd = new File(tenfiled);
                dsst.readfileST(fd);
                dsst.displayST();
                break;
            }
        }   
        }while(luaChon1!=0);
        break;
                }
                case 2:{
        do{
            System.out.println("MENU--------------");
            System.out.println("KHO Tivi Internet--------------");
            System.out.println("---Vui long chon chuc nang ------------");
            System.out.println("---1.them san pham trong kho---");
            System.out.println("---2.in danh sach san pham trong kho ra man hinh---");
            System.out.println("---3.dem loai san pham trong kho---");
            System.out.println("---4.tim kiem ten san pham trong kho---");
            System.out.println("---5.sap xep san pham theo so luong giam dan---");
            System.out.println("---6.Sua thong tin san pham---");
            System.out.println("---7.Xoa thong tin san pham---");
            System.out.println("---8.Luu file ---");
            System.out.println("---9.doc file ---");
            System.out.println("---0.thoat chuong trinh---");
            
            luaChon2 = sc.nextInt();
            sc.nextLine();
            switch(luaChon2){
                case 1:{
                    System.out.println("Nhap ma tivi: "); String ma = sc.nextLine();
                    System.out.println("Nhap ten tivi: "); String ten = sc.nextLine();
                    System.out.println("Nhap xuat xu tivi: "); String xuatXu = sc.nextLine();
                    System.out.println("Nhap namsx tivi: "); int namSx = sc.nextInt();                            
                    System.out.println("Nhap so hang trong kho tivi: "); double hTrongkho = sc.nextDouble();
                
                    TiviIT tvit = new TiviIT(ma,ten,xuatXu,namSx,hTrongkho);
                    dsit.addIT(tvit);
                    break;
            }
                case 2:{
                    dsit.displayIT();
                    break; 
            }
                case 3:{
                    System.out.println("so luong loai san pham trong kho :" + dsit.countIT());
                    break;
            }
                case 4:{
                System.out.println("Nhap ten tivi: "); String ten = sc.nextLine();
                System.out.println("ket qua tim kiem");
                dsit.searchIT(ten);
                break;
            }
                case 5:{
                dsit.arrangeIT();
                dsit.displayIT();
                break;
            }
                case 6:{
                dsit.editIT();
                break;
            }
             case 7:{
                dsit.deleteIT();
                break;
            }
             case 8:{
                System.out.println(" nhap ten file ");
                String tenfilel = sc.nextLine();
                File fl = new File(tenfilel);
                dsit.savefileIT(fl);
                break;
            }
             case 9:{
                System.out.println(" nhap ten file muon doc ");
                String tenfiled = sc.nextLine();
                File fd = new File(tenfiled);
                dsit.readfileIT(fd);
                dsit.displayIT();
                break;
            }
            }
            } while(luaChon2!=0);
                break;
                }
                }
            }while(luaChon!=0);

        }
}