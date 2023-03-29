
package bai3;


/**
 *
 * @author ThienLaptop
 */
public class vang extends Giaodich {
    public String loai;

    public vang() {
    }

    
    public vang(String loai, String ma, double dongia, int soluong) {
        super(ma, dongia, soluong);
        this.loai = loai;
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }

    @Override
    public String toString() {
        return "vang{" + "loai=" + loai + '}';
    }
    
    
}
