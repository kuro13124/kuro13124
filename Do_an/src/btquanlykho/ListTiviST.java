package btquanlykho;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class ListTiviST {

    public ArrayList<TiviST> danhSach;

    public ListTiviST() {
        this.danhSach = new ArrayList<TiviST>();
    }

    public ListTiviST(ArrayList<TiviST> danhSach) {
        this.danhSach = danhSach;
    }

    // 1.them danh sach tivitt vao kho
    public void addST(TiviST tvst) {
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
                System.out.println("---nhap du lieu moi---");
                System.out.println("Nhap ma tivi: "); String ma = sc.nextLine();
                System.out.println("Nhap ten tivi: "); String ten = sc.nextLine();
                System.out.println("Nhap xuat xu tivi: "); String xuatXu = sc.nextLine();
                System.out.println("Nhap he dieu hanh cua tivi: "); String heDieuHanh = sc.nextLine();
                System.out.println("Nhap ram cua san pham: "); int ram = sc.nextInt();
                if(ram<0){
                    System.out.println(" Vui long nhap lai ram cua san pham : ");
                    ram = sc.nextInt();    
                }
                System.out.println("Nhap namsx tivi: "); int namSx = sc.nextInt();
                if(namSx<0){
                    System.out.println(" Vui long nhap lai nam san xuat cua san pham : ");
                    namSx = sc.nextInt();    
                }
                System.out.println("Nhap so hang trong kho tivi: "); int hTrongkho = sc.nextInt();
                if(hTrongkho<0){
                    System.out.println(" Vui long nhap lai so luong cua san pham : ");
                    hTrongkho = sc.nextInt();    
                }
                danhSach.get(i).setMa(ma);
                danhSach.get(i).setTen(ten);
                danhSach.get(i).setXuatXu(xuatXu);
                danhSach.get(i).setHeDieuHanh(heDieuHanh);
                danhSach.get(i).setRam(ram);
                danhSach.get(i).setNamSx(namSx);
                danhSach.get(i).sethTrongkho(hTrongkho);
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
                int ram = Integer.parseInt(info[4].trim());
                int namSx = Integer.parseInt(info[5].trim());
                int hTrongkho = Integer.parseInt(info[6].trim());

                danhSach.add(new TiviST(ma, ten, xuatXu, heDieuHanh, ram, namSx, hTrongkho));
            }

        } catch (Exception e) {
        }
    }
}
