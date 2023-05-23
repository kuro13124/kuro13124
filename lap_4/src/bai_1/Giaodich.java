/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bai_1;

import java.util.Date;
/**
 *
 * @author ThienLaptop
 */
public class Giaodich {
    
    public String ma;
    public String date;
    public double donGia;
    public double S;

    public Giaodich() {
    }

    public Giaodich(String ma, String date, double donGia, double S) {
        this.ma = ma;
        this.date = date;
        this.donGia = donGia;
        this.S = S;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public double getS() {
        return S;
    }

    public void setS(double S) {
        this.S = S;
    }

    
    
    
     
}


