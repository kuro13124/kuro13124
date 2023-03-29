/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bai3;

import java.util.ArrayList;


public class main {
    public static void main(String[] args) {
        ArrayList<tien> t = new ArrayList<>();
        ArrayList<vang> v = new ArrayList<>();
        vang vv = new vang();
        Giaodich at1 = new tien(1,"USA",1000,4);
        Giaodich at2 = new tien(2,"VN",1000,4);
        Giaodich at3 = new tien(2,"Euro",1000,4);
        Giaodich vt1= new vang("loai1","Vang",1000,5);
        Giaodich vt2 = new vang("loai2","Vanggia",1000,6);
        t.add((tien) at1);
        t.add((tien) at2);
        t.add((tien) at3);
        v.add((vang) vt1);
        v.add((vang) vt2);
        
        
        System.out.println("so luong "+t.size());
        System.out.println("so luong "+v.size());
        double  tong1=0,tong2 = 0,tong3= 0;
        
        for(int i = 0 ; i < t.size();i++){
                if(t.get(i).getMa().equalsIgnoreCase("USA")){
                    tong1 += t.get(i).getDongia()*t.get(i).getSoluong()*t.get(i).getTigia();    
                }
                
                if(t.get(i).getMa().equalsIgnoreCase("Euro")){
                     tong2 += t.get(i).getDongia()*t.get(i).getSoluong()*t.get(i).getTigia();
                }
                if(t.get(i).getMa().equalsIgnoreCase("VN")){
                    tong3 += t.get(i).getDongia()*t.get(i).getSoluong();
                }
        }
        double tong =tong1+tong2+tong3;
        System.out.println("tbc:"+(tong)/t.size());
        
        int d;
        for(int i =0;i<v.size();i++)
            if(v.get(i).getDongia()*v.get(i).getSoluong()>1000){
                System.out.println("onnn");
            }
    
}
}
