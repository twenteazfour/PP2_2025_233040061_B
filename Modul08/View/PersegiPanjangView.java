/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.praktikumpemrograman2.Modul08.View;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class PersegiPanjangView extends JFrame {
    private JTextField txtPanjang = new JTextField(10);
    private JTextField txtLebar = new JTextField(10);
    private JLabel lblHasil = new JLabel("-");
    private JButton btnHitung = new JButton("Hitung Luas");
    
    public PersegiPanjangView() {
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setSize(300,200);
    this.setLayout(new GridLayout(4, 2, 10, 10));
    this.setTitle("MVC Kalkulator");

    this.add(new JLabel("Panjang:"));
    this.add(txtPanjang);
    this.add(new JLabel("Lebar:"));
    this.add(txtLebar);
    this.add(new JLabel("Hasil Luas:"));
    this.add(lblHasil);
    this.add(btnHitung);
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
    
    public void tampilkanPesanError(String pesan){
        JOptionPane.showMessageDialog(this, pesan);
    }
    
    public void addHitungListener(ActionListener listener) {
        btnHitung.addActionListener(listener);
    }
}
