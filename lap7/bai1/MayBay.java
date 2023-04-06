
package bai1;

public class MayBay extends PhuongTien {
   public String loaiNhienLieu;

    public MayBay() {
    }

    public MayBay(String loaiNhienLieu){
        this.loaiNhienLieu = loaiNhienLieu;
    }

    public String getLoaiNhienLieu() {
        return loaiNhienLieu;
    }

    public void setLoaiNhienLieu(String loaiNhienLieu) {
        this.loaiNhienLieu = loaiNhienLieu;
    }
    public void catCanh(){
        System.out.println(" cat canh ");
    }
   public void haCanh(){
       System.out.println(" ha canh ");
   }
   @Override
   public double layVanToc(){
       return 1000;
   }
}
