
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


public class List {
    TiviIT it = new TiviIT();
     TiviST st = new TiviST();
     Manager mn = new Manager();
     private ArrayList<Tivi> ds;

    public List() {
        this.ds = new ArrayList<Tivi>();
    }

    public List(ArrayList<Tivi> ds){
        this.ds = ds;
    }
    
    //1.
    public void add(Tivi tv){
        this.ds.add(tv);
    }
     //2
    public void display(){
        for (Tivi tv : ds){
            System.out.println(tv);     
        }      
    }
    //3.dem so luong tivitt trong kho
    public int count() {
        return this.ds.size();
    }

    //4.tim kiem ten san pham trong kho
    public void search(String ten) {
        for (Tivi tivi : ds) {
            if (tivi.getTen().contains(ten)) {
                System.out.println(tivi);
            }
        }
    }

    //5.xap xep tang giam theo so luong hang hoa trong kho
    public void arrange(){
        Collections.sort(this.ds, new Comparator<Tivi>(){
            @Override
            public int compare(Tivi sl1, Tivi sl2) {
                if (sl1.gethTrongkho() < sl2.gethTrongkho()) {
                    return 1;
                } else if (sl1.gethTrongkho() > sl2.gethTrongkho()) {
                    return -1;

                } else {
                    return 0;
                }
            }
        }
    );
}
    
    //6sua thong tin
    public void edit() {
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap vao ma can sua : ");
        String id = sc.nextLine();

        for (int i = 0; i < ds.size(); i++) {
            if (id.equals(ds.get(i).getMa())) {
                System.out.println("---nhap du lieu moi---");
                if(ds.get(i).getMa().contains("ST")){
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
                Tivi tvst = new TiviST(ma, ten, xuatXu, heDieuHanh, namSx, hTrongkho, donGia, st.hien(day, month, year));
                ds.set(i, tvst);
                }
                if(ds.get(i).getMa().contains("IT")){
                System.out.print("Nhap ma tivi: "); String ma = sc.nextLine();
                System.out.print("Nhap ten tivi: "); String ten = sc.nextLine();
                System.out.print("Nhap xuat xu tivi: "); String xuatXu = sc.nextLine();
                System.out.print("Nhap namsx tivi: "); int namSx = sc.nextInt();
                if(namSx<0){
                    System.out.print(" Vui long nhap lai nam san xuat cua san pham: ");
                    namSx = sc.nextInt();    
                }
                System.out.println("Nhap vao ngay nhap kho: ");
                System.out.print("ngay:"); int day = sc.nextInt();
                System.out.print("thang:"); int month = sc.nextInt();
                System.out.print("nam:"); int year = sc.nextInt();
                it.hien(day, month, year);
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
                Tivi tvit = new TiviIT(ma, ten, namSx, xuatXu, hTrongkho, donGia, it.hien(day, month, year));
                ds.set(i, tvit);
                }
            }
        }
    }
    //7. xoa san pham
    public void delete() {
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap vao ma can xoa : ");
        String id = sc.nextLine();

        int d = -1;
        boolean vitri = false;
        for (int i = 0; i < ds.size(); i++) {
            if (id.equals(ds.get(i).getMa())) {
                vitri = true;
                d = i;
                break;
            }
        }
        
        if (vitri == false) {
            System.out.println("khong tim thay ma san pham nao");
        } else {
            ds.remove(d);
            System.out.println("xoa thanh cong");
        }
       
    }

    //8.luu file
    public void savefile(File file) {
        try {
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            for (Tivi tivi : ds) {
                bw.newLine();
                bw.write(tivi.toString());
                bw.newLine();
            }
            bw.close();
            System.out.println("luu file thanh cong");
        } catch (Exception e) {
        }
    }

    //9.docfilest
    public void readfiles(File file) {
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
                int day = Integer.parseInt(info[7].trim());
                int month = Integer.parseInt(info[8].trim());
                int year = Integer.parseInt(info[9].trim()); 
 
                ds.add(new TiviST(ma, ten, xuatXu, heDieuHanh, namSx, hTrongkho,donGia,st.hien(day, month, year)));
                st.setMa(ma);
                st.setTen(ten);
                st.setXuatXu(xuatXu);
                st.setHeDieuHanh(heDieuHanh);
                st.setDonGia(donGia);
                st.sethTrongkho(hTrongkho);
                st.setNamSx(namSx);
                System.out.println(st.toString());
            }
            
                  

        } catch (Exception e) {
        }
    }
           public void readfilei(File file){
        try{
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            while(true){
                String line = br.readLine();
                if(line == null) break;
                String[] info = line.split("[|]");
                String ma = info[0].trim();
                String ten = info[1].trim();
                String xuatXu = info[2].trim();                        
                int namSx = Integer.parseInt(info[3].trim());
                int hTrongkho = Integer.parseInt(info[4].trim());
                double donGia = Double.parseDouble(info[5].trim());
                int year = Integer.parseInt(info[6].trim());
                int month = Integer.parseInt(info[7].trim());
                int day = Integer.parseInt(info[8].trim());
                
                ds.add(new TiviIT(ma,ten,namSx,xuatXu,hTrongkho,donGia,it.hien(year, month, day)));
                it.setMa(ma);
                it.setTen(ten);
                it.setXuatXu(xuatXu);
                it.setDonGia(donGia);
                it.setDonGia(donGia);
                it.sethTrongkho(hTrongkho);
                it.setNamSx(namSx);
                System.out.println(it.toString());
            }
    }catch (Exception e){
    }
    }
    //9.docfilei
    
        //10.nhap vao ngay du kiem xuat kho va so luong xuat kho va so luong con lai cua san pham
       public void du(){
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap vao ma san pham can xuat: ");
        String id =  sc.nextLine();
        boolean vitri = false;
        int d=-1;
        for(int i = 0;i < ds.size();i++){
            if(id.equals(ds.get(i).getMa())){
            vitri = true;
            d=i;
            do{
                System.out.println("Nhap ngay xuat kho: ");
                System.out.print("ngay:");  int day = sc.nextInt();
                System.out.print("thang:");  int month = sc.nextInt();
                System.out.print("nam:");  int year = sc.nextInt();
                mn.xuat(day, month, year);
                if(ds.get(i).getNgayNhap().compareTo(mn.ngayXuat)>0){
                    System.out.println("Nhap lai:");
                }
           }while(ds.get(i).getNgayNhap().compareTo(mn.ngayXuat)>0);
                System.out.println("nhap so luong can xuat");
                int k = sc.nextInt();
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                String nxit = sdf.format(mn.ngayXuat);
                String nnit = sdf.format(ds.get(i).getNgayNhap());
                System.out.println("MaST="+ id +", Ngay nhap="+nnit+", Ngay xuat="+nxit+", so luong xuat kho: "+k+", so luong hang con lai:"+(ds.get(i).gethTrongkho()-k)+", so tien hang: "+k*1.2*ds.get(i).getDonGia());
                ds.get(i).sethTrongkho(ds.get(i).gethTrongkho()-k);
                            try {
            FileWriter fw = new FileWriter("phieuxuat.txt",true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("MaST="+ id +", Ngay nhap="+nnit+", Ngay xuat="+nxit+", so luong xuat kho: "+k+", so luong hang con lai:"+(ds.get(i).gethTrongkho()-k)+", so tien hang: "+k*0.8*ds.get(i).getDonGia());
            bw.newLine();
            bw.close();
           } catch (Exception e) {
           }
           }    
       }if(vitri==false){
                System.out.println("Khong tim thay san pham");}
       else if(ds.get(d).gethTrongkho()==0){
           ds.remove(d);
       }
    }
}
