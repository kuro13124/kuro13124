
package bai_2;


import java.util.ArrayList;


public class List_KH_VN {
    private ArrayList<KH_VN> ds;
    private ArrayList<KH_NN> l;

    public List_KH_VN() {
        this.ds = new ArrayList<KH_VN>();
        this.l = new ArrayList<KH_NN>();
    }
    public List_KH_VN(ArrayList<KH_VN> ds,ArrayList<KH_NN> l) {
        this.ds = ds;
        this.l=l;
    }
    public void add(KH_VN h){
        this.ds.add(h);
    }
    public void display(){
        for (KH_VN h: ds) {
            System.out.println(h);
        }
    }
    public int count(){
        return this.ds.size();
    }
    public void addn(KH_NN n){
        this.l.add(n);
    }
    public void displayn(){
        for (KH_NN n: l) {
            System.out.println(n);
        }
    }
    public int countn(){
        return this.l.size();
    }
    public void tt(){
        double tt=0;
        double tb=0;
        for(int i = 0;i<ds.size();i++){
            if(ds.get(i).getSo_luong()<ds.get(i).getDinh_Muc()){
                tt += ds.get(i).getSo_luong()*ds.get(i).getSo_luong();
            }else{
                tt += ds.get(i).getSo_luong()*ds.get(i).getDon_Gia()*ds.get(i).getDinh_Muc()*2.5;
            }
            
        }
        tb=tt/ds.size();
        System.out.println("tb="+tb);
    }
    public void ngay(){
       for(int i =0;i<ds.size();i++){
           String[] date_dat = ds.get(i).getDate().split("/");
           if(date_dat[1].equals("9")&& date_dat[2].equals("2013")){
               System.out.println(ds.get(i).toString());
           }
       }
    }
    public void ngayn(){
       for(int i =0;i<l.size();i++){
           String[] date_dat = l.get(i).getDate().split("/");
           if(date_dat[1].equals("9")&& date_dat[2].equals("2013")){
               System.out.println(l.get(i).toString());
           }
       }
    }

    
}
