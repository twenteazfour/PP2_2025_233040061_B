/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package id.ac.unpas.praktikumpemrograman2.Modul06;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Latihan2 {
    public static void main(String[] args) {
        // Membuat frame utama
        JFrame frame = new JFrame("Konversi Celcius ke Fahrenheit");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);
        frame.setLayout(new FlowLayout());

        // Komponen GUI
        JLabel labelCelcius = new JLabel("Celcius:");
        JTextField inputCelcius = new JTextField(10);
        JButton tombolKonversi = new JButton("Konversi");
        JLabel labelFahrenheit = new JLabel("Fahrenheit:");
        JLabel hasil = new JLabel("");

        // Menambahkan komponen ke frame
        frame.add(labelCelcius);
        frame.add(inputCelcius);
        frame.add(tombolKonversi);
        frame.add(labelFahrenheit);
        frame.add(hasil);

        // Aksi tombol
        tombolKonversi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double celcius = Double.parseDouble(inputCelcius.getText());
                    double fahrenheit = (celcius * 9 / 5) + 32;
                    hasil.setText(String.format("%.2f °F", fahrenheit));
                } catch (NumberFormatException ex) {
                    hasil.setText("Input tidak valid");
                }
            }
        });

        // Tampilkan frame di tengah layar
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
