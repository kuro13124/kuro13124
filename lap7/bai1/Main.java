
package bai1;

public class Main {
    public static void main(String[] args){
        MayBay mb = new MayBay();
        PhuongTien ot = new XeOto();
        PhuongTien xm = new XeMay();
    
        mb.haCanh();
        mb.catCanh();
        System.out.println("Van toc chung "+(mb.layVanToc()+ot.layVanToc()+xm.layVanToc()));
    }
     
}
