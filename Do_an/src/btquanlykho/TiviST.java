
package btquanlykho;

public class TiviST extends Tivi {

    private String heDieuHanh;
    public int ram;

    public TiviST() {
    }

    public TiviST(String ma, String ten, String xuatXu,String heDieuHanh,int ram, int namSx, int hTrongkho) {
        super(ma, ten, namSx, xuatXu, hTrongkho);
        this.heDieuHanh = heDieuHanh;
        this.ram = ram;
    }

    public String getHeDieuHanh() {
        return heDieuHanh;
    }

    public void setHeDieuHanh(String heDieuHanh) {
        this.heDieuHanh = heDieuHanh;
    }
    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }


    @Override
    public String toString() {
        return "TiviST " + "ma=" + ma + ", ten=" + ten + ", xuatXu=" + xuatXu + ", he dieu hanh=" + heDieuHanh  + ", ram =" + ram +' ' +", namsx =" + namSx + ", hTrongkho=" + hTrongkho;
    }    
    }
    

    

    


 