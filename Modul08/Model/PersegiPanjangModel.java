/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.praktikumpemrograman2.Modul08.Model;

public class PersegiPanjangModel {
    private double panjang;
    private double lebar;
    private double luas;
    
    // hitung luas
    public void hitungLuas() {
        this.luas = this.panjang * this.lebar;
    }
    
    // getters setters
    public void setPanjang(double panjang) {
        this.panjang = panjang;
    }
    
    public void setLebar(double lebar) {
        this.lebar = lebar;
    }
    
    public double getLuas() {
        return luas;
    }
    
}
