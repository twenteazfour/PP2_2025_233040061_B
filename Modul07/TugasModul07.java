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

public class TugasModul07 extends JFrame {

    private JTextField txtNama;
    private JTextField txtNilai;
    private JComboBox<String> cmbMatkul;

    private JTable tableData;
    private DefaultTableModel tableModel;
    private JTabbedPane tabbedPane;

    // input panel
    private JPanel createInputPanel() {
    JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));
    panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

    panel.add(new JLabel("Nama Siswa:"));
    txtNama = new JTextField();
    panel.add(txtNama);

    panel.add(new JLabel("Mata Pelajaran:"));
    String[] matkul = {
            "Matematika Dasar",
            "Bahasa Indonesia",
            "Algoritma dan Pemrograman I",
            "Praktikum Pemrograman II"
    };
    cmbMatkul = new JComboBox<>(matkul);
    panel.add(cmbMatkul);

    panel.add(new JLabel("Nilai (0-100):"));
    txtNilai = new JTextField();
    panel.add(txtNilai);

    JButton btnSimpan = new JButton("Simpan Data");
    JButton btnReset = new JButton("Reset");

    panel.add(new JLabel("")); // kosong untuk dorong tombol ke kanan

    JPanel pBtns = new JPanel(new GridLayout(1, 2, 10, 0));
    pBtns.add(btnReset);
    pBtns.add(btnSimpan);
    panel.add(pBtns);

    btnSimpan.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            prosesSimpan();
        }
    });

    btnReset.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            txtNama.setText("");
            txtNilai.setText("");
            cmbMatkul.setSelectedIndex(0);
        }
    });

    return panel;
}

    // table panel
    private JPanel createTablePanel() {
        JPanel panel = new JPanel(new BorderLayout());

        String[] kolom = {"Nama Siswa", "Mata Pelajaran", "Nilai", "Grade"};
        tableModel = new DefaultTableModel(kolom, 0);
        tableData = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(tableData);
        panel.add(scrollPane, BorderLayout.CENTER);

        JButton btnHapus = new JButton("Hapus");
        JPanel south = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        south.add(btnHapus);

        panel.add(south, BorderLayout.SOUTH);

        btnHapus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = tableData.getSelectedRow();
                if (row > -1) {
                    tableModel.removeRow(row);
                } else {
                    JOptionPane.showMessageDialog(
                            TugasModul07.this,
                            "Pilih baris yang ingin dihapus!"
                    );
                }
            }
        });

        return panel;
    }

    // logika simpan
    private void prosesSimpan() {
        String nama = txtNama.getText();
        String matkul = (String) cmbMatkul.getSelectedItem();
        String strNilai = txtNilai.getText();

        if (nama.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nama tidak boleh kosong!");
            return;
        }

        if (nama.trim().length() < 3) {
            JOptionPane.showMessageDialog(this, "Nama minimal 3 karakter!");
            return;
        }

        int nilai;
        try {
            nilai = Integer.parseInt(strNilai);
            if (nilai < 0 || nilai > 100) {
                JOptionPane.showMessageDialog(this, "Nilai harus antara 0 - 100!");
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Nilai harus berupa angka!");
            return;
        }

        String grade;
        switch (nilai / 10) {
            case 10:
            case 9: grade = "A"; break;
            case 8: grade = "AB"; break;
            case 7: grade = "B"; break;
            case 6: grade = "BC"; break;
            case 5: grade = "C"; break;
            case 4: grade = "D"; break;
            default: grade = "E"; break;
        }

        Object[] dataBaris = {nama, matkul, nilai, grade};
        tableModel.addRow(dataBaris);

        txtNama.setText("");
        txtNilai.setText("");
        cmbMatkul.setSelectedIndex(0);

        JOptionPane.showMessageDialog(this, "Data Berhasil Disimpan!");
        tabbedPane.setSelectedIndex(1);
    }

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

    // main
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TugasModul07().setVisible(true);
        });
    }
}
