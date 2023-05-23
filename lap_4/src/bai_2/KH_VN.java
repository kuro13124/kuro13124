/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bai_2;

import java.util.Scanner;

/**
 *
 * @author ThienLaptop
 */
public class KH_VN extends KH{
    public String doi_Tuong;
    public double dinh_Muc;

    public KH_VN() {
    }

    public KH_VN(String doi_Tuong, double dinh_Muc, String ma, String ho_ten, String date, double so_luong, double don_Gia) {
        super(ma, ho_ten, date, so_luong, don_Gia);
        this.doi_Tuong = doi_Tuong;
        this.dinh_Muc = dinh_Muc;
    }

    public String getDoi_Tuong() {
        return doi_Tuong;
    }

    public void setDoi_Tuong(String doi_Tuong) {
        this.doi_Tuong = doi_Tuong;
    }

    public double getDinh_Muc() {
        return dinh_Muc;
    }

    public void setDinh_Muc(double dinh_Muc) {
        this.dinh_Muc = dinh_Muc;
    }
    public void nhap(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ma "); ma = sc.nextLine();
        System.out.println("nhap doi tuong"); doi_Tuong = sc.nextLine();
        System.out.println("nhao ngay/thang/nam");date = sc.nextLine(); 
        System.out.println("nhap don gia"); don_Gia = sc.nextDouble();
        System.out.println("nhap so luong"); so_luong= sc.nextDouble();
        System.out.println("nhap dinh muc"); dinh_Muc = sc.nextDouble();
    }

    @Override
    public String toString() {
        return "KH{" + "ma=" + ma + ", ho_ten=" + ho_ten + ", date=" + date + ", so_luong=" + so_luong + ", don_Gia=" + don_Gia +"KH_VN{" + "doi_Tuong=" + doi_Tuong + ", dinh_Muc=" + dinh_Muc + '}';
    }
    
    
}
