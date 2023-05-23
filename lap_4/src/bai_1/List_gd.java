
package bai_1;



import java.util.ArrayList;



public class List_gd {
    Gd_dat d = new Gd_dat();
    private ArrayList<Gd_dat> list;

    public List_gd() {
        this.list = new ArrayList<Gd_dat>();
    }

    public List_gd(ArrayList<Gd_dat> list) {
        this.list = list;
    }
    public void add(Gd_dat d){
        this.list.add(d);
    }
    public void display(){
        for (Gd_dat gd_dat : list) {
            System.out.println(gd_dat);
        }
    }
    public int count(){
        return this.list.size();
    }
    public void tb_dat(){
        double tong =0;
        double tb = 0;
        for(int i = 0;i <list.size();i++){
            if(list.get(i).getLoai_dat().equalsIgnoreCase("A")){
                tong +=list.get(i).getS()*list.get(i).getDonGia()*1.5;
                
            }else if(list.get(i).getLoai_dat().equalsIgnoreCase("B")||list.get(i).getLoai_dat().equalsIgnoreCase("C")){
                tong +=list.get(i).getS()*list.get(i).getDonGia();
            }
        }
        tb = tong/list.size();
        System.out.println("tb = "+tb);
    }
    public void ngay_dat(){
       for(int i =0;i<list.size();i++){
           String[] date_dat = list.get(i).getDate().split("/");
           if(date_dat[1].equals("9")&& date_dat[2].equals("2013")){
               System.out.println(list.get(i).toString());
           }
       }
    }
}
