/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.praktikumpemrograman2.Modul10;
import javax.swing.SwingUtilities;

public class Main {
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MahasiswaAppView view = new MahasiswaAppView();
            MahasiswaAppModel model = new MahasiswaAppModel();
            new MahasiswaAppController(view, model);
            view.setVisible(true);
        });
    }
}