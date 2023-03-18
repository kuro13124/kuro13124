
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


public class ListTiviIT {
    private ArrayList<TiviIT> danhSach1;

    public ListTiviIT() {
        this.danhSach1 = new ArrayList<TiviIT>();
    }
               
    public ListTiviIT(ArrayList<TiviIT> danhSach1) {
        this.danhSach1 = danhSach1;
    }
    //1.them san pham vao kho IT
    public void addIT(TiviIT tvit ){
        this.danhSach1.add(tvit);
    }
    //2. in san pham trong kho it
    public void displayIT(){
        for(TiviIT tiviIT : danhSach1){
            System.out.println(tiviIT);   
    }
    }
    //3.dem so luong sp trong kho
    public int countIT(){
        
        return this.danhSach1.size();
        
    }
    //4.tim kiem sp
    public void searchIT(String ten){
        for(TiviIT tiviIT : danhSach1){
            if(tiviIT.getTen().contains(ten)){
               System.out.println(tiviIT);
            }
        }
    }
    //5.sap xep sp
     public void arrangeIT(){
        Collections.sort(this.danhSach1, new Comparator<TiviIT>(){
            @Override
            public int compare(TiviIT sl1, TiviIT sl2) {
                if(sl1.gethTrongkho()<sl2.gethTrongkho()){
                    return 1;
                }else if(sl1.gethTrongkho()>sl2.gethTrongkho()){
                    return -1;
                    
                }else {
                    return 0;
                }          
            }   
    });
    }
     //6.sua san pham
    public void editIT(){
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap vao ma can sua : ");
        String id =  sc.nextLine();

        for(int i = 0;i < danhSach1.size();i++){
            if(id.equals(danhSach1.get(i).getMa())){
                System.out.println("---nhap du lieu moi---");
                System.out.println("Nhap ma tivi: "); String ma = sc.nextLine();
                System.out.println("Nhap ten tivi: "); String ten = sc.nextLine();
                System.out.println("Nhap xuat xu tivi: "); String xuatXu = sc.nextLine();               
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
                danhSach1.get(i).setMa(ma);
                danhSach1.get(i).setTen(ten);
                danhSach1.get(i).setXuatXu(xuatXu);
                danhSach1.get(i).setNamSx(namSx);
                danhSach1.get(i).sethTrongkho(hTrongkho);
            }
        }
    }
    //7. xoa san pham
    public void deleteIT(){
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap vao ma can xoa : ");
        String id =  sc.nextLine();
        
        int d=-1;
        boolean vitri = false;
        for(int i = 0;i < danhSach1.size();i++){
            if(id.equals(danhSach1.get(i).getMa())){
                vitri = true;
                d = i;
                break;                 
        }
        }
        if(vitri==false) System.out.println("khong tim thay ma san pham nao: ");
        else{
            danhSach1.remove(d);
            System.out.println("xoa thanh cong");
        }
    }
       //8.luu file
        public void savefileIT(File file){
        try{
FileWriter fw = new FileWriter(file,true);
        BufferedWriter bw = new BufferedWriter(fw);
        for(TiviIT tiviIT : danhSach1){
            bw.newLine();
            bw.write(tiviIT.toString());
            bw.newLine();
        }   
        bw.close();
        System.out.println("luu file thanh cong");
    }catch (Exception e){
    }
    }
    //9.docfile
       public void readfileIT(File file){
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
                
                danhSach1.add(new TiviIT(ma,ten,xuatXu,namSx,hTrongkho));
            }
    }catch (Exception e){
    }
    } 
    
    }
