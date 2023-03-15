
package bai1;

/**
 *
 * @author ThienLaptop
 */
public class quacam extends Hoaqua {
    public String vo;
    public String tepcam;
    public String kichthuoc;

    public quacam() {
    }


    public quacam(String vo, String tepcam, String kichthuoc, String nguongoc, String ten, String ngay, int sl, int gia) {
        super(nguongoc, ten, ngay, sl, gia);
        this.vo = vo;
        this.tepcam = tepcam;
        this.kichthuoc = kichthuoc;
    }

    public String getVo() {
        return vo;
    }

    public void setVo(String vo) {
        this.vo = vo;
    }

    public String getTepcam() {
        return tepcam;
    }

    public void setTepcam(String tepcam) {
        this.tepcam = tepcam;
    }

    public String getKichthuoc() {
        return kichthuoc;
    }

    public void setKichthuoc(String kichthuoc) {
        this.kichthuoc = kichthuoc;
    }
    public void display(){
        System.out.println(" day la qua cam");
    }
    
}
