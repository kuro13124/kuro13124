
package bai2;

import java.util.ArrayList;


public class Danhsachhinh {
    public ArrayList<Hinh> list;

    public Danhsachhinh(ArrayList<Hinh> list) {
        this.list = list;
    }

    Danhsachhinh() {
        this.list = new ArrayList<Hinh>();
    }
    public void addH(Hinh h){
        list.add(h);
    }
    public void hienThiDanhSachHinh() {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).toString());
            
        }
    }
}
