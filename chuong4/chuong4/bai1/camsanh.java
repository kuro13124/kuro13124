
package bai1;

/**
 *
 * @author ThienLaptop
 */
public class camsanh extends quacam {

    public camsanh() {
    }

    public camsanh(String vo, String tepcam, String kichthuoc, String nguongoc, String ten, String ngay, int sl, int gia) {
        super(vo, tepcam, kichthuoc, nguongoc, ten, ngay, sl, gia);
    }
    
    public void display2(){
        System.out.println("day la cam sanh");
    }
}
