package btquanlykho;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import java.util.Scanner;

public class ListTiviST {
    public ArrayList<TiviST> danhSach;
    TiviST st = new TiviST();

    public ListTiviST() {
        this.danhSach = new ArrayList<TiviST>();
    }

    public ListTiviST(ArrayList<TiviST> danhSach) {
        this.danhSach = danhSach;

    }

    // 1.them danh sach tivitt vao kho
    public void addST(TiviST tvst){
        this.danhSach.add(tvst);
    }

    //2.in danh sach tivitt ra man hinh
    public void displayST() {
        for (TiviST tiviST : danhSach) {
            System.out.println(tiviST);
        }
        
    }


    //3.dem so luong tivitt trong kho
    public int countST() {
        return this.danhSach.size();
    }

    //4.tim kiem ten san pham trong kho
    public void searchST(String ten) {
        for (TiviST tiviST : danhSach) {
            if (tiviST.getTen().contains(ten)) {
                System.out.println(tiviST);
            }
        }
    }

    //5.xap xep tang giam theo so luong hang hoa trong kho
    public void arrangeST() {
        Collections.sort(this.danhSach, new Comparator<TiviST>() {
            @Override
            public int compare(TiviST sl1, TiviST sl2) {
                if (sl1.gethTrongkho() < sl2.gethTrongkho()) {
                    return 1;
                } else if (sl1.gethTrongkho() > sl2.gethTrongkho()) {
                    return -1;

                } else {
                    return 0;
                }
            }
        });
    }

    //6.sua san pham
    public void editST() {
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap vao ma can sua : ");
        String id = sc.nextLine();

        for (int i = 0; i < danhSach.size(); i++) {
            if (id.equals(danhSach.get(i).getMa())) {
                System.out.print("---nhap du lieu moi---");
                System.out.print("Nhap ma tivi: "); String ma = sc.nextLine();
                System.out.print("Nhap ten tivi: "); String ten = sc.nextLine();
                System.out.print("Nhap xuat xu tivi: "); String xuatXu = sc.nextLine();
                System.out.print("Nhap he dieu hanh cua tivi: "); String heDieuHanh = sc.nextLine();
                
                System.out.print("Nhap namsx tivi: "); int namSx = sc.nextInt();
                if(namSx<0){
                    System.out.print(" Vui long nhap lai nam san xuat cua san pham: ");
                    namSx = sc.nextInt();    
                }
                System.out.println("Nhap vao ngay nhap kho: ");
                System.out.print("ngay:"); int day = sc.nextInt();
                System.out.print("thang:"); int month = sc.nextInt();
                System.out.print("nam:"); int year = sc.nextInt();
                st.hien(day, month, year);
                System.out.print("Nhap so hang trong kho tivi: "); int hTrongkho = sc.nextInt();
                if(hTrongkho<0){
                    System.out.print(" Vui long nhap lai so luong cua san pham: ");
                    hTrongkho = sc.nextInt();    
                }
                System.out.print("Nhap don gia cua san pham: "); double donGia = sc.nextDouble();
                if(donGia<0){
                    System.out.print(" Vui long nhap lai don gia cua san pham: ");
                    donGia = sc.nextDouble();    
                }
                danhSach.get(i).setMa(ma);
                danhSach.get(i).setTen(ten);
                danhSach.get(i).setXuatXu(xuatXu);
                danhSach.get(i).setHeDieuHanh(heDieuHanh);
                danhSach.get(i).setNamSx(namSx);
                danhSach.get(i).sethTrongkho(hTrongkho);
                danhSach.get(i).setDonGia(donGia);
                danhSach.get(i).setNgayNhap(st.getNgayNhap());

                
            }
        }
    }

    //7. xoa san pham
    public void deleteST() {
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap vao ma can xoa : ");
        String id = sc.nextLine();

        int d = -1;
        boolean vitri = false;
        for (int i = 0; i < danhSach.size(); i++) {
            if (id.equals(danhSach.get(i).getMa())) {
                vitri = true;
                d = i;
                break;
            }
        }
        
        if (vitri == false) {
            System.out.println("khong tim thay ma san pham nao");
        } else {
            danhSach.remove(d);
            System.out.println("xoa thanh cong");
        }
       
    }

    //8.luu file
    public void savefileST(File file) {
        try {
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            for (TiviST tiviST : danhSach) {
                bw.newLine();
                bw.write(tiviST.toString());
                bw.newLine();
            }
            bw.close();
            System.out.println("luu file thanh cong");
        } catch (Exception e) {
        }
    }

    //9.docfile
    public void readfileST(File file) {
        try {

            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            while (true) {
                String line = br.readLine();
                if (line == null) {
                    break;
                }
                String[] info = line.split("[|]");
                String ma = info[0].trim();
                String ten = info[1].trim();
                String xuatXu = info[2].trim();
                String heDieuHanh = info[3].trim();
                int namSx = Integer.parseInt(info[4].trim());
                int hTrongkho = Integer.parseInt(info[5].trim());
                double donGia = Double.parseDouble(info[6].trim());
                int year = Integer.parseInt(info[7].trim());
                int month = Integer.parseInt(info[8].trim());
                int day = Integer.parseInt(info[9].trim());

                
                danhSach.add(new TiviST(ma, ten, xuatXu, heDieuHanh, namSx, hTrongkho,donGia,st.hien(day, month, year)));
            }

        } catch (Exception e) {
        }
    }
        //10.nhap vao ngay du kiem xuat kho va so luong xuat kho va so luong con lai cua san pham
       public void dust(){
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap vao ma san pham can xuat: ");
        String id =  sc.nextLine();
        boolean vitri = false;
        int d=-1;
        for(int i = 0;i < danhSach.size();i++){
            if(id.equals(danhSach.get(i).getMa())){
            vitri = true;
            d=i;
            do{
                System.out.println("Nhap ngay xuat kho: ");
                System.out.print("ngay:");  int day = sc.nextInt();
                System.out.print("thang:");  int month = sc.nextInt();
                System.out.print("nam:");  int year = sc.nextInt();
                st.xuat(day, month, year);
                if(danhSach.get(i).getNgayNhap().compareTo(st.ngayXuat)>0){
                    System.out.println("Nhap lai:");
                }
           }while(danhSach.get(i).getNgayNhap().compareTo(st.ngayXuat)>0);
                System.out.println("nhap so luong can xuat");
                int k = sc.nextInt();
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                String nxit = sdf.format(st.ngayXuat);
                String nnit = sdf.format(danhSach.get(i).getNgayNhap());
                System.out.println("MaST="+ id +", Ngay nhap="+nnit+", Ngay xuat="+nxit+", so luong xuat kho: "+k+", so luong hang con lai:"+(danhSach.get(i).gethTrongkho()-k)+", so tien hang: "+k*0.8*danhSach.get(i).getDonGia());
                danhSach.get(i).sethTrongkho(danhSach.get(i).gethTrongkho()-k);
                            try {
            FileWriter fw = new FileWriter("phieuxuat.txt",true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("MaIT="+ id +", Ngay nhap="+nnit+", Ngay xuat="+nxit+", so luong xuat kho: "+k+", so luong hang con lai:"+(danhSach.get(i).gethTrongkho()-k)+", so tien hang: "+k*0.8*danhSach.get(i).getDonGia());
            bw.newLine();
            bw.close();
           } catch (Exception e) {
           }
           }    
       }if(vitri==false){
                System.out.println("Khong tim thay san pham");}
       else if(danhSach.get(d).gethTrongkho()==0){
           danhSach.remove(d);
       }
    }
}
