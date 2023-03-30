
package Test;

import btquanlykho.List;
import btquanlykho.Tivi;
import btquanlykho.TiviIT;
import btquanlykho.TiviST;
import java.io.File;
import java.util.Scanner;

public class main{
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        List ds = new List();
        Tivi it = new TiviIT();
        Tivi st = new TiviST();
        int luaChon = 0;
        do{
            System.out.println("MENU-------------------------------------------------");
            System.out.println("KHO Tivi---------------------------------------------");
            System.out.println("Vui long chon chuc nang -----------------------------");
            System.out.println("---1.them san pham loai Tivi Smart-------------------");
            System.out.println("---2.them san pham loai Tivi Internet----------------");
            System.out.println("---3.in danh sach san pham  trong kho ra man hinh----");
            System.out.println("---4.dem so luong san pham trong kho-----------------");
            System.out.println("---5.tim kiem ten san pham trong kho-----------------");
            System.out.println("---6.sap xep san pham theo so luong giam dan---------");
            System.out.println("---7.Sua thong tin san pham--------------------------");
            System.out.println("---8.Xoa thong tin san pham--------------------------");
            System.out.println("---9.Luu file ---------------------------------------");
            System.out.println("---10.doc file Tivi Smart----------------------------");
            System.out.println("---11.doc file Tivi Internet-------------------------");
            System.out.println("---12.phieu xuat hang--------------------------------");
            System.out.println("---0.thoat chuong trinh------------------------------");
 
            luaChon = sc.nextInt();
            sc.nextLine();
            switch(luaChon){
            case 1:
            {      
                System.out.print("Nhap ma tivi: "); String ma = sc.nextLine();
                System.out.print("Nhap ten tivi: "); String ten = sc.nextLine();
                System.out.print("Nhap xuat xu tivi: "); String xuatXu = sc.nextLine();
                System.out.print("Nhap he dieu hanh cua tivi: "); String heDieuHanh = sc.nextLine();               
                System.out.print("Nhap namsx tivi: "); int namSx = sc.nextInt();
                if(namSx<0){
                    System.out.print("Vui long nhap lai nam san xuat cua san pham : ");
                    namSx = sc.nextInt();    
                }
                System.out.println("Nhap vao ngay nhap kho: ");
                    System.out.print("ngay:"); int day = sc.nextInt();
                    System.out.print("thang:"); int month = sc.nextInt();
                    System.out.print("nam:"); int year = sc.nextInt();
                    st.hien(day, month, year);
                System.out.print("Nhap so hang trong kho tivi: "); int hTrongkho = sc.nextInt();
                if(hTrongkho<0){
                    System.out.print("Vui long nhap lai so luong cua san pham : ");
                    hTrongkho = sc.nextInt();    
                }
                System.out.print("Nhap don gia cua san pham: "); double donGia = sc.nextDouble();
                if(donGia<0){
                    System.out.print(" Vui long nhap lai don gia cua san pham: ");
                    donGia = sc.nextDouble();    
                }
                Tivi tvst = new TiviST(ma,ten,xuatXu,heDieuHanh,namSx,hTrongkho,donGia,st.hien(day, month, year));
                ds.add(tvst);
                break;
            }
            case 2:
            {      
                System.out.print("Nhap ma tivi: "); String ma = sc.nextLine();
                System.out.print("Nhap ten tivi: "); String ten = sc.nextLine();
                System.out.print("Nhap xuat xu tivi: "); String xuatXu = sc.nextLine();               
                System.out.print("Nhap namsx tivi: "); int namSx = sc.nextInt();
                if(namSx<0){
                    System.out.print("Vui long nhap lai nam san xuat cua san pham : ");
                    namSx = sc.nextInt();    
                }
                System.out.println("Nhap vao ngay nhap kho: ");
                    System.out.print("ngay:"); int day = sc.nextInt();
                    System.out.print("thang:"); int month = sc.nextInt();
                    System.out.print("nam:"); int year = sc.nextInt();
                    it.hien(day, month, year);
                System.out.print("Nhap so hang trong kho tivi: "); int hTrongkho = sc.nextInt();
                if(hTrongkho<0){
                    System.out.print("Vui long nhap lai so luong cua san pham : ");
                    hTrongkho = sc.nextInt();    
                }
                System.out.print("Nhap don gia cua san pham: "); double donGia = sc.nextDouble();
                if(donGia<0){
                    System.out.print(" Vui long nhap lai don gia cua san pham: ");
                    donGia = sc.nextDouble();    
                }
                Tivi tvit = new TiviIT(ma, ten, namSx, xuatXu, hTrongkho, donGia, it.hien(day, month, year));
                ds.add(tvit);
                break;
            }
            case 3:{
                ds.display();
                break;
            }
            case 4:{
                System.out.println("so luong loai san pham trong kho :" + ds.count());
                break;
            }
            case 5:{
                System.out.println("Nhap ten tivi: "); String ten = sc.nextLine();
                System.out.println("ket qua tim kiem trong kho");
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
                System.out.print("nhap ten file muon luu : ");
                String tenfilel = sc.nextLine();
                File fl = new File(tenfilel);
                ds.savefile(fl);
                break;
            }
            case 10:{
                System.out.print("nhap ten file muon doc : ");
                String tenfiled = sc.nextLine();
                File fd = new File(tenfiled);
                ds.readfiles(fd);
                System.out.println("doc file thanh cong");
                break;
            }
            case 11:{
                System.out.print("nhap ten file muon doc : ");
                String tenfiled = sc.nextLine();
                File fd = new File(tenfiled);
                ds.readfilei(fd);
                System.out.println("doc file thanh cong");
                break;
            }
            case 12:{
                ds.du();
                break;
            }
            }   
    }while(luaChon!=0);
    
}
}
