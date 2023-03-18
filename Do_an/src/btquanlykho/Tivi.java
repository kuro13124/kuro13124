
package btquanlykho;

import java.io.Serializable;

public class Tivi implements Serializable {
    public String ma;
    public String ten;
    public int namSx;
    public String xuatXu;
    public int hTrongkho;

    public Tivi() {
    }   
    public Tivi(String ma, String ten, int namSx, String xuatXu, int hTrongkho) {
        this.ma = ma;
        this.ten = ten;
        this.namSx = namSx;
        this.xuatXu = xuatXu;
        this.hTrongkho = hTrongkho;
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
 
}
