
package bai1;

public abstract class PhuongTien {
    public String loai;
    public HangSanXuat hangSanXuat;
    
    public String laytenHangSanXuat(String a,String b){
        hangSanXuat.tenQuocGia =a;
        loai = b;
        return a+b;
    }
    public void batDau(){     
    }
    public void tangToc(){
    }
    public void dungLai(){
    }
    abstract double layVanToc();
}
