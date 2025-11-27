/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.praktikumpemrograman2.Modul07;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author ellen
 */
public class TugasModul07 extends JFrame {
    private JTextField txtNama;
    private JTextField txtNilai;
    private JComboBox<String> cmbMatkul;
    private JTable tableData;
    private DefaultTableModel tableModel;
    private JTabbedPane tabbedPane;

    // constructor
    public TugasModul07() {
        setTitle("Aplikasi Manajemen Nilai Siswa");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(620, 420);
        setLocationRelativeTo(null);

        tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Input Data", createInputPanel());
        tabbedPane.addTab("Daftar Nilai", createTablePanel());

        add(tabbedPane);
    }

    // Method untuk membuat desain Tab Input
    private JPanel createInputPanel() {
        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Komponen Nama
        panel.add(new JLabel("Nama Siswa:"));
        txtNama = new JTextField();
        panel.add(txtNama);

        // Komponen Mata Pelajaran (ComboBox)
        panel.add(new JLabel("Mata Pelajaran:"));
        String[] matkul = {
            "Matematika Dasar",
            "Bahasa Indonesia",
            "Algoritma dan Pemrograman I",
            "Praktikum Pemrograman II"
        };
        cmbMatkul = new JComboBox<>(matkul);
        panel.add(cmbMatkul);

        // Komponen Nilai
        panel.add(new JLabel("Nilai (0-100):"));
        txtNilai = new JTextField();
        panel.add(txtNilai);

        // Tombol Simpan dan Reset (diletakkan agar posisi kanan seperti PDF)
        JButton btnSimpan = new JButton("Simpan Data");
        JButton btnReset = new JButton("Reset");
        panel.add(new JLabel("")); // Placeholder kosong agar tombol di kanan
        JPanel pBtns = new JPanel(new GridLayout(1, 2, 6, 0));
        pBtns.add(btnSimpan);
        pBtns.add(btnReset);
        panel.add(pBtns);

        // Event Handling Tombol Simpan
        btnSimpan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                prosesSimpan();
            }
        });

        // Event Handling Tombol Reset
        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetInput();
            }
        });

        return panel;
    }

    // Method untuk membuat desain Tab Tabel
    private JPanel createTablePanel() {
        JPanel panel = new JPanel(new BorderLayout());

        // Setup Model Tabel (Kolom)
        String[] kolom = { "Nama Siswa", "Mata Pelajaran", "Nilai", "Grade" };
        tableModel = new DefaultTableModel(kolom, 0);
        tableData = new JTable(tableModel);

        // Membungkus tabel dengan ScrollPane (agar bisa discroll jika data banyak)
        JScrollPane scrollPane = new JScrollPane(tableData);
        panel.add(scrollPane, BorderLayout.CENTER);

        // Tombol Hapus di bagian bawah
        JButton btnHapus = new JButton("Hapus Data");
        JPanel south = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        south.add(btnHapus);
        panel.add(south, BorderLayout.SOUTH);

        // Event Handling Hapus
        btnHapus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = tableData.getSelectedRow();
                if (row > -1) {
                    int opsi = JOptionPane.showConfirmDialog(
                            TugasModul07.this,
                            "Yakin ingin menghapus baris terpilih?",
                            "Konfirmasi Hapus",
                            JOptionPane.YES_NO_OPTION
                    );
                    if (opsi == JOptionPane.YES_OPTION) {
                        tableModel.removeRow(row);
                    }
                } else {
                    JOptionPane.showMessageDialog(TugasModul07.this,
                            "Pilih baris yang akan dihapus",
                            "Informasi", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        return panel;
    }

    // Logika Validasi dan Penyimpanan Data
    private void prosesSimpan() {
        // 1. Ambil data dari input
        String nama = txtNama.getText();
        String matkul = (String) cmbMatkul.getSelectedItem();
        String strNilai = txtNilai.getText();

        // 2. VALIDASI INPUT

        // Validasi 1: Cek apakah nama kosong
        if (nama == null || nama.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nama tidak boleh kosong!",
                    "Error Validasi", JOptionPane.ERROR_MESSAGE);
            return; // Hentikan proses
        }

        // Validasi tambahan: nama minimal 3 karakter
        if (nama.trim().length() < 3) {
            JOptionPane.showMessageDialog(this, "Nama minimal terdiri dari 3 karakter!",
                    "Error Validasi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Validasi 2: Cek apakah nilai berupa angka dan dalam range valid
        int nilai;
        try {
            nilai = Integer.parseInt(strNilai.trim());
            if (nilai < 0 || nilai > 100) {
                JOptionPane.showMessageDialog(this, "Nilai harus antara 0 - 100!",
                        "Error Validasi", JOptionPane.WARNING_MESSAGE);
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Nilai harus berupa angka!",
                    "Error Validasi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // 3. Logika Bisnis (Menentukan Grade) -- DIUBAH MENJADI SWITCH CASE
        String grade;
        switch (nilai / 10) {
            case 10:
            case 9:
            case 8:
                grade = "A";
                break;
            case 7:
                grade = "AB";
                break;
            case 6:
                grade = "B";
                break;
            case 5:
                grade = "BC";
                break;
            case 4:
                grade = "C";
                break;
            case 3:
                grade = "D";
                break;
            default:
                grade = "E";
                break;
        }

        // 4. Masukkan ke Tabel (Update Model)
        Object[] dataBaris = { nama, matkul, nilai, grade };
        tableModel.addRow(dataBaris);

        // 5. Reset Form dan Pindah Tab
        resetInput();

        JOptionPane.showMessageDialog(this, "Data Berhasil Disimpan!");
        tabbedPane.setSelectedIndex(1); // Otomatis pindah ke tab tabel
    }

    // Reset input fields (Nama dan Nilai) -- sesuai ketentuan tugas
    private void resetInput() {
        txtNama.setText("");
        txtNilai.setText("");
        cmbMatkul.setSelectedIndex(0);
    }

    // main
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TugasModul07().setVisible(true);
            }
        });
    }
}
   
