/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.praktikumpemrograman2.Modul08.View;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.*;

public class PersegiPanjangView extends JFrame {
    private JTextField txtPanjang = new JTextField(10);
    private JTextField txtLebar = new JTextField(10);
    private JLabel lblHasil = new JLabel("-");

    private JLabel lblKeliling = new JLabel("-"); // LATIHAN 2

    private JButton btnHitung = new JButton("Hitung Luas");
    private JButton btnKeliling = new JButton("Hitung Keliling"); // LATIHAN 2
    private JButton btnReset = new JButton("Reset"); // LATIHAN 3

    public PersegiPanjangView() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 250);
        this.setLayout(new GridLayout(6, 2, 10, 10));
        this.setTitle("MVC Kalkulator");

        this.add(new JLabel("Panjang:"));
        this.add(txtPanjang);

        this.add(new JLabel("Lebar:"));
        this.add(txtLebar);

        this.add(new JLabel("Hasil Luas:"));
        this.add(lblHasil);

        this.add(new JLabel("Keliling:")); // LATIHAN 2
        this.add(lblKeliling);

        this.add(btnHitung);
        this.add(btnKeliling); // LATIHAN 2

        this.add(btnReset); // LATIHAN 3
    }

    public double getPanjang() {
        return Double.parseDouble(txtPanjang.getText());
    }

    public double getLebar() {
        return Double.parseDouble(txtLebar.getText());
    }

    public void setHasil(double hasil) {
        lblHasil.setText(String.valueOf(hasil));
    }

    // LATIHAN 2: set keliling
    public void setHasilKeliling(double hasil) {
        lblKeliling.setText(String.valueOf(hasil));
    }

    public void tampilkanPesanError(String pesan){
        JOptionPane.showMessageDialog(this, pesan);
    }

    public void addHitungListener(ActionListener listener) {
        btnHitung.addActionListener(listener);
    }

    // LATIHAN 2
    public void addHitungKelilingListener(ActionListener listener) {
        btnKeliling.addActionListener(listener);
    }

    // LATIHAN 3
    public void addResetListener(ActionListener listener) {
        btnReset.addActionListener(listener);
    }

    // latihan 3: fungsi reset
    public void resetInput() {
        txtPanjang.setText("");
        txtLebar.setText("");
        lblHasil.setText("-");
        lblKeliling.setText("-");
    }
}
