
package bai1;

public class XeOto extends PhuongTien {
    public String loaiNhienLieu;

    public XeOto() {
    }

    public XeOto(String loaiNhienLieu) {
        this.loaiNhienLieu = loaiNhienLieu;
    }

    public String getLoaiNhienLieu() {
        return loaiNhienLieu;
    }

    public void setLoaiNhienLieu(String loaiNhienLieu) {
        this.loaiNhienLieu = loaiNhienLieu;
    }

    @Override
    double layVanToc() {        
        return 100;    
    }
    
}
