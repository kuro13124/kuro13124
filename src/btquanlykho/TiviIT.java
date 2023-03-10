
package btquanlykho;

public class TiviIT extends Tivi{

    public TiviIT() {
    }

    public TiviIT(String ma, String ten, String xuatXu, int namSx, double hTrongkho) {
        super(ma, ten, namSx, xuatXu, hTrongkho);
    }


    @Override
    public String toString() {

        return "TiviIT " + "ma=" + ma + ", ten=" + ten + ", namSx=" + namSx + ", xuatXu=" + xuatXu + ", hTrongkho=" + hTrongkho;
    }
    
}
