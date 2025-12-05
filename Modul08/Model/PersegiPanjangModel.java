/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.praktikumpemrograman2.Modul08.Model;

public class PersegiPanjangModel {
    private double panjang;
    private double lebar;
    private double luas;

    private double keliling; // LATIHAN 2

    // hitung luas
    public void hitungLuas() {
        this.luas = this.panjang * this.lebar;
    }

    // latihan 2: hitung keliling
    public void hitungKeliling() {
        this.keliling = 2 * (this.panjang + this.lebar);
    }

    public void setPanjang(double panjang) {
        this.panjang = panjang;
    }

    public void setLebar(double lebar) {
        this.lebar = lebar;
    }

    public double getLuas() {
        return luas;
    }

    // latihan 2
    public double getKeliling() {
        return keliling;
    }

}
