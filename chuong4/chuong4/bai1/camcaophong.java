
package bai1;

/**
 *
 * @author ThienLaptop
 */
public class camcaophong extends quacam {

    public camcaophong() {
    }

    
    public camcaophong(String vo, String tepcam, String kichthuoc, String nguongoc, String ten, String ngay, int sl, int gia) {
        super(vo, tepcam, kichthuoc, nguongoc, ten, ngay, sl, gia);
    }
    
    
    public void display1(){
        System.out.println(("day la cam cao phong"));
    }
}
