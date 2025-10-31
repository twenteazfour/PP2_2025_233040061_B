/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.praktikumpemrograman2.Modul05;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

/**
 *
 * @author ellen
 */
public class Latihan3 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("Label dan Tombol");
                frame.setSize(400, 300);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
                // 1. Atur Layout Manager
                frame.setLayout(new FlowLayout());
                
                // 2. Buat komponen GUI
                JLabel label = new JLabel("Teks Awal");
                JButton button = new JButton ("Klik Saya!");
                
                // 3. Tambahkan Aksi (ActionListener) ke tombol
                button.addActionListener(e -> {
                    label.setText("Tombol berhasil diklik!");
                });
                    
                // 4. Tambahkan komponen ke frame
                frame.add(label);
                frame.add(button);
                
                frame.setVisible(true);
                
                }
            });
       }
}
