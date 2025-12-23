/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.praktikumpemrograman2.Modul10;

import javax.swing.*;
import java.sql.ResultSet;

public class MahasiswaAppController {
    
    private MahasiswaAppView view;
    private MahasiswaAppModel model;

    public MahasiswaAppController(MahasiswaAppView view, MahasiswaAppModel model) {
        this.view = view;
        this.model = model;

        view.btnSimpan.addActionListener(e -> tambahData());
        view.btnEdit.addActionListener(e -> ubahData());
        view.btnHapus.addActionListener(e -> hapusData());
        view.btnClear.addActionListener(e -> kosongkanForm());
        view.btnCari.addActionListener(e -> cariData());

        loadData();
    }

    private void loadData() {
        view.model.setRowCount(0);
        try {
            ResultSet res = model.loadData();
            int no = 1;
            while (res.next()) {
                view.model.addRow(new Object[]{
                        no++,
                        res.getString("nama"),
                        res.getString("nim"),
                        res.getString("jurusan")
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, "Gagal Load Data: " + e.getMessage());
        }
    }

    private void tambahData() {
        if (view.txtNama.getText().trim().isEmpty() || view.txtNIM.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(view, "Data tidak boleh kosong!", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            model.tambahData(
                    view.txtNama.getText(),
                    view.txtNIM.getText(),
                    view.txtJurusan.getText()
            );
            JOptionPane.showMessageDialog(view, "Data Berhasil Disimpan");
            loadData();
            kosongkanForm();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, "Gagal Simpan: " + e.getMessage());
        }
    }

    private void ubahData() {
        try {
            model.ubahData(
                    view.txtNama.getText(),
                    view.txtJurusan.getText(),
                    view.txtNIM.getText()
            );
            JOptionPane.showMessageDialog(view, "Data Berhasil Diubah");
            loadData();
            kosongkanForm();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, "Gagal Edit: " + e.getMessage());
        }
    }

    private void hapusData() {
        try {
            model.hapusData(view.txtNIM.getText());
            JOptionPane.showMessageDialog(view, "Data Berhasil Dihapus");
            loadData();
            kosongkanForm();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, "Gagal Hapus: " + e.getMessage());
        }
    }

    private void cariData() {
        view.model.setRowCount(0);
        try {
            ResultSet res = model.cariData(view.txtCari.getText());
            int no = 1;
            while (res.next()) {
                view.model.addRow(new Object[]{
                        no++,
                        res.getString("nama"),
                        res.getString("nim"),
                        res.getString("jurusan")
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, "Gagal Cari Data: " + e.getMessage());
        }
    }

    private void kosongkanForm() {
        view.txtNama.setText(null);
        view.txtNIM.setText(null);
        view.txtJurusan.setText(null);
    }
}

