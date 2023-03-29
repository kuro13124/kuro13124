/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bai3;



/**
 *
 * @author ThienLaptop
 */
public class tien extends Giaodich{
    public double tigia;

    public tien() {
    }

    public tien(double tigia, String ma, double dongia, int soluong) {
        super(ma, dongia, soluong);
        this.tigia = tigia;
    }

    

    public double getTigia() {
        return tigia;
    }

    public void setTigia(double tigia) {
        this.tigia = tigia;
    }

    @Override
    public String toString() {
        return "tien{" + "tigia=" + tigia + '}';
    }
   
    
}
