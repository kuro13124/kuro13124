
package btquanlykho;

import java.io.Serializable;
import java.util.Date;


public class Tivi implements Serializable {
    public String ma;
    public String ten;
    public int namSx;
    public String xuatXu;
    public int hTrongkho;
    public double donGia;
    public Date ngayNhap;


    public Tivi() {
    }   
    public Tivi(String ma, String ten, int namSx, String xuatXu, int hTrongkho,double donGia,Date ngayNhap) {
        this.ma = ma;
        this.ten = ten;
        this.namSx = namSx;
        this.xuatXu = xuatXu;
        this.hTrongkho = hTrongkho;
        this.donGia = donGia;
        this.ngayNhap = ngayNhap;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
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

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia){
        this.donGia = donGia;
    }

    public Date getNgayNhap() {
        return ngayNhap;
    }
    public void setNgayNhap(Date ngayNhap) {
        this.ngayNhap = ngayNhap;
    }
    public Date hien(int day,int month,int year){ 
        return ngayNhap;      
    }
}
