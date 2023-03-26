
package btquanlykho;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;




public class TiviST extends Tivi {

    private String heDieuHanh;

    public TiviST() {
    }

    public TiviST(String ma, String ten, String xuatXu,String heDieuHanh, int namSx, int hTrongkho,double donGia,Date NgayNhap){
        super(ma, ten, namSx, xuatXu, hTrongkho,donGia,NgayNhap);
        this.heDieuHanh = heDieuHanh;
    }


    public String getHeDieuHanh() {
        return heDieuHanh;
    }

    public void setHeDieuHanh(String heDieuHanh) {
        this.heDieuHanh = heDieuHanh;
    }

@Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String nnst = sdf.format(ngayNhap);
        return "TiviST " + "ma=" + ma + ", ten=" + ten + ", xuatXu=" + xuatXu + ", he dieu hanh=" + heDieuHanh +", namsx =" + namSx + ", hTrongkho=" + hTrongkho+", don gia="+donGia+", ngay nhap kho="+nnst;
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

    


 