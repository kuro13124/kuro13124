
package bai3;



public class Giaodich {
    public String ma;
    public double dongia;
    public int soluong;

    public Giaodich() {
    }

    public Giaodich(String ma, double dongia, int soluong) {
        this.ma = ma;
        this.dongia = dongia;
        this.soluong = soluong;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

   

    public double getDongia() {
        return dongia;
    }

    public void setDongia(double dongia) {
        this.dongia = dongia;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    @Override
    public String toString() {
        return "Giaodich{" + "ma=" + ma + ", dongia=" + dongia + ", soluong=" + soluong + '}';
    }
    
    
}
