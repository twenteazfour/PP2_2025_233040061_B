/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package id.ac.unpas.praktikumpemrograman2;

import id.ac.unpas.praktikumpemrograman2.Modul08.controller.PersegiPanjangController;
import id.ac.unpas.praktikumpemrograman2.Modul08.Model.PersegiPanjangModel;
import id.ac.unpas.praktikumpemrograman2.Modul08.View.PersegiPanjangView;

public class Main {
    public static void main(String[] args) {
        PersegiPanjangModel model = new PersegiPanjangModel();
        PersegiPanjangView view = new PersegiPanjangView();
        new PersegiPanjangController(model, view);

        view.setVisible(true);
    }
}
