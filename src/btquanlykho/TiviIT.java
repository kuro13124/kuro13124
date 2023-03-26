
package btquanlykho;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class TiviIT extends Tivi{

    public TiviIT() {
    }

    public TiviIT(String ma, String ten, String xuatXu, int namSx, int hTrongkho,double donGia,Date ngayNhap) {
        super(ma, ten, namSx, xuatXu, hTrongkho,donGia,ngayNhap);
    }
    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String nnit = sdf.format(ngayNhap);
        return "TiviIT " + "ma=" + ma + ", ten=" + ten + ", namSx=" + namSx + ", xuatXu=" + xuatXu + ", hTrongkho=" + hTrongkho+", don gia="+donGia+", ngay nhap kho="+nnit;
    }
    @Override
    public Date hien(int day,int month,int year){
        Calendar cl = Calendar.getInstance();
        cl.set(year, month-1, day);
        return this.ngayNhap = cl.getTime();
    }
    @Override
    public Date xuat(int day,int month,int year){
        Calendar cl = Calendar.getInstance();
        cl.set(year, month-1, day);
        return this.ngayXuat=cl.getTime();
    }
    
}
