/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package id.ac.unpas.praktikumpemrograman2.Modul08.controller;

import id.ac.unpas.praktikumpemrograman2.Modul08.Model.PersegiPanjangModel;
import id.ac.unpas.praktikumpemrograman2.Modul08.View.PersegiPanjangView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PersegiPanjangController {

    private PersegiPanjangModel model;
    private PersegiPanjangView view;

    public PersegiPanjangController(PersegiPanjangModel model, PersegiPanjangView view) {
        this.model = model;
        this.view = view;

        this.view.addHitungListener(new HitungListener());
        this.view.addHitungKelilingListener(new HitungKelilingListener()); // LATIHAN 2
        this.view.addResetListener(new ResetListener()); // LATIHAN 3
    }

    class HitungListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                double p = view.getPanjang();
                double l = view.getLebar();

                model.setPanjang(p);
                model.setLebar(l);
                model.hitungLuas();

                double hasil = model.getLuas();
                view.setHasil(hasil);

            } catch (NumberFormatException ex) {
                view.tampilkanPesanError("Masukkan angka yang valid!");
            }
        }
    }

    // latihan 2: hitung keliling
    class HitungKelilingListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                double p = view.getPanjang();
                double l = view.getLebar();

                model.setPanjang(p);
                model.setLebar(l);
                model.hitungKeliling();

                view.setHasilKeliling(model.getKeliling());

            } catch (NumberFormatException ex) {
                view.tampilkanPesanError("Masukkan angka yang valid!");
            }
        }
    }

    // latihan 3: reset input
    class ResetListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.resetInput();
        }
    }
}
