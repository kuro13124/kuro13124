
package bai1;


public class Hoaqua {
    public String nguongoc;
    public String ten;
    public String ngay;
    public int sl;
    public int gia;

    public Hoaqua() {
    }

    public Hoaqua(String nguongoc, String ten, String ngay, int sl, int gia) {
        this.nguongoc = nguongoc;
        this.ten = ten;
        this.ngay = ngay;
        this.sl = sl;
        this.gia = gia;
    }

    public String getNguongoc() {
        return nguongoc;
    }

    public void setNguongoc(String nguongoc) {
        this.nguongoc = nguongoc;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getNgay() {
        return ngay;
    }

    public void setNgay(String ngay) {
        this.ngay = ngay;
    }

    public int getSl() {
        return sl;
    }

    public void setSl(int sl) {
        this.sl = sl;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }
    
    
}
