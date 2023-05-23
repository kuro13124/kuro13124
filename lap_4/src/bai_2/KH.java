
package bai_2;

public class KH {
    public String ma;
    public String ho_ten;
    public String date;
    public double so_luong;
    public double don_Gia;

    public KH() {
    }

    public KH(String ma, String ho_ten, String date, double so_luong, double don_Gia) {
        this.ma = ma;
        this.ho_ten = ho_ten;
        this.date = date;
        this.so_luong = so_luong;
        this.don_Gia = don_Gia;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getHo_ten() {
        return ho_ten;
    }

    public void setHo_ten(String ho_ten) {
        this.ho_ten = ho_ten;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getSo_luong() {
        return so_luong;
    }

    public void setSo_luong(double so_luong) {
        this.so_luong = so_luong;
    }

    public double getDon_Gia() {
        return don_Gia;
    }

    public void setDon_Gia(double don_Gia) {
        this.don_Gia = don_Gia;
    }
    
    
    
}
