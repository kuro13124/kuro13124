
package btquanlykho;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Tivi implements Serializable {
    public String ma;
    public String ten;
    public int namSx;
    public String xuatXu;
    public int hTrongkho;
    public double donGia;
    public Date ngayNhap,ngayXuat;


    public Tivi() {
    }   
    public Tivi(String ma, String ten, int namSx, String xuatXu, int hTrongkho,double donGia,Date ngayNhap) {
        this.ma = ma;
        this.ten = ten;
        this.namSx = namSx;
        this.xuatXu = xuatXu;
        this.hTrongkho = hTrongkho;
        this.ngayNhap = ngayNhap;
        this.donGia = donGia;
        
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String maTT) {
        this.ma = maTT;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String tenTT) {
        this.ten = tenTT;
    }

    public int getNamSx() {
        return namSx;
    }

    public void setNamSx(int namSx) {
        this.namSx = namSx;
    }

    public String getXuatXu() {
        return xuatXu;
    }

    public void setXuatXu(String xuatXu) {
        this.xuatXu = xuatXu;
    }

    public int gethTrongkho() {
        return hTrongkho;
    }

    public void sethTrongkho(int hTrongkho) {
        this.hTrongkho = hTrongkho;
    }

    public Date getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(Date ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }
    
    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String nnit = sdf.format(ngayNhap);
        return "TiviIT " + "ma=" + ma + ", ten=" + ten + ", namSx=" + namSx + ", xuatXu=" + xuatXu + ", hTrongkho=" + hTrongkho+", don gia="+donGia+", ngay nhap kho="+nnit;
    }
    public Date hien(int day,int month,int year){
        return this.ngayNhap;
    }
    public Date xuat(int day,int month,int year){
        return this.ngayXuat;
    }
    


}
