
package btquanlykho;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class List {
     TiviIT it = new TiviIT();
     TiviST st = new TiviST();
     Manager mn = new Manager();
     private ArrayList<Tivi> ds;
     private ArrayList<Manager> mg;
    
    
    public List() {
        this.ds = new ArrayList<Tivi>();
        this.mg = new ArrayList<Manager>();
    }

    public List(ArrayList<Tivi> ds,ArrayList<Manager> mg){
        this.ds = ds;
        this.mg = mg;
    }
    

    public void add(Tivi tv){
        this.ds.add(tv);
    }
    public void display(){
        for (Tivi tv : ds){
            System.out.println(tv);     
        }      
    }
    public void displayMa(){
        for (Manager m : mg) {
            System.out.println(m);
        }
    }
    
    //3.dem so luong tivitt trong kho
    public int count(){
        return this.ds.size();
    }
    //4.tim kiem ten san pham trong kho
    public void search(String ten) {
        for (Tivi tivi : ds) {
            if (tivi.getTen().contains(ten)){
                System.out.println(tivi);
            }
        }
    }
    //5.xap xep tang giam theo so luong hang hoa trong kho
    public void arrange(){
        Collections.sort(this.ds, (Tivi sl1, Tivi sl2) -> {
            if (sl1.gethTrongkho() < sl2.gethTrongkho()) {
                return 1;
            } else if (sl1.gethTrongkho() > sl2.gethTrongkho()) {
                return -1;
                
            } else {
                return 0;
            }
        }
    );
} 
    //6sua thong tin
    public void edit() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập Mã sản phẩm cần sửa: ");
        String id = sc.nextLine();
        for (int i = 0; i < ds.size(); i++){
            if(id.equals(ds.get(i).getMa())){
                System.out.println("---Nhập dữ liệu mới---");
                if(ds.get(i).getMa().contains("ST")){
                st= new TiviST();
                st.nhap();
                ds.set(i, st);
                System.out.println("---Cập nhật thông tin thành công---");
                }
                if(ds.get(i).getMa().contains("IT")){
                it = new TiviIT();
                it.nhap();
                ds.set(i, it);
                System.out.println("---Cập nhật thông tin thành công---");
                }   
            }
        }
    }
    //7. xoa san pham
    public void delete() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập mã sản phẩm cần xóa: ");
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
            System.out.println("---Không tìm thấy sản phẩm nào---");
        } else {
            ds.remove(d);
            System.out.println("----Xóa thành công---");
        }
       
    }
    //8.luu file
    public void savefile(File file) {
        try {
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            for (Tivi tivi : ds){
                bw.write(tivi.toString());
                bw.newLine();
            }
            bw.close();
            System.out.println("---Lưu file thành công---");
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
                if (line == null) break;
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
                int day = Integer.parseInt(info[6].trim());
                int month = Integer.parseInt(info[7].trim());
                int year = Integer.parseInt(info[8].trim());  
                ds.add(new TiviIT(ma,ten,namSx,xuatXu,hTrongkho,donGia,it.hien(day, month, year)));
                it.setMa(ma);
                it.setTen(ten);
                it.setXuatXu(xuatXu);
                it.setDonGia(donGia);
                it.sethTrongkho(hTrongkho);
                it.setNamSx(namSx);
                System.out.println(it.toString());
                }
            
            }catch (Exception e){
        }
    }
       //10.nhap vao ngay du kiem xuat kho va so luong xuat kho va so luong con lai cua san pham
       public void du(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập Mã sản phẩm cần xuất kho: ");
        String id =  sc.nextLine();
        boolean vitri = false;
        int d=-1;
        for(int i = 0;i < ds.size();i++){
            if(id.equalsIgnoreCase(ds.get(i).getMa())){
            vitri = true;
            d=i;
            int day,month,year;
            System.out.print("Nhập Đại lý: "); mn.Agency = sc.nextLine();
            do{
                
                System.out.println("Nhập Ngày xuất kho: ");
                do{
                System.out.print("Ngày: "); day = sc.nextInt();
                System.out.print("Tháng: "); month = sc.nextInt();
                System.out.print("Năm: "); year = sc.nextInt();
                if(day<0||month <0||year<0||day>31||month>12){
                    System.out.println("Vui lòng nhập lại");
                }
                }while(day<0||month <0||year<0||day>31||month>12);
                mn.xuat(day, month, year);
                if(ds.get(i).getNgayNhap().compareTo(mn.ngayXuat)>0){
                    System.out.println("Vui lòng nhập lại: ");
                }
           }while(ds.get(i).getNgayNhap().compareTo(mn.ngayXuat)>0);
                System.out.print("Nhập số lượng cần xuất kho: ");
                mn.soHang = sc.nextInt();
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                String nx = sdf.format(mn.ngayXuat);
                String nn = sdf.format(ds.get(i).getNgayNhap());
                mn.kq = (double)(mn.getSoHang()*1.1*ds.get(i).getDonGia());
                String ramdom = mn.randomAlphaNumeric(6);
                System.out.println("Mã đơn hàng: "+ramdom+", Đại lý: "+mn.Agency+", Mã: "+ id +", Ngày nhập kho: "+nn+", Ngày xuất kho: "+nx+", Số lượng xuất kho: "+mn.getSoHang()+", Số hàng còn lại trong kho: "+(ds.get(i).gethTrongkho()-mn.getSoHang())+", Số tiền xuất hàng: "+mn.kq);
                ds.get(i).sethTrongkho(ds.get(i).gethTrongkho()-mn.getSoHang());
                mg.add(new Manager(mn.ngayXuat, mn.Agency,mn.soHang,mn.kq,ramdom));
                
                    try {
            FileWriter fw = new FileWriter("phieuxuat.txt",true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("Mã đơn hàng: "+ramdom+", Đại lý: "+mn.Agency+", Mã: "+ id +", Ngày nhập kho: "+nn+", Ngày xuất kho: "+nx+", Số lượng xuất kho: "+mn.getSoHang()+", Số hàng còn lại trong kho: "+ds.get(i).gethTrongkho()+", Số tiền xuất hàng: "+mn.kq);
            bw.newLine();
            bw.close();
           } catch (Exception e){
           }
           }    
       }if(vitri==false){
                System.out.println("---Không tìm thấy thông tin sản phẩm---");}
       else if(ds.get(d).gethTrongkho()==0){
           ds.remove(d);
       }
    }
}
