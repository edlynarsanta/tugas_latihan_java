import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class FormKaryawan extends JFrame {
    private JTextField tfNIP, tfNama, tfJabatan, tfAlamat, tfNoHP;
    private JButton btnSimpan, btnUbah, btnHapus, btnBersihkan;
    private JTable table;
    private DefaultTableModel tableModel;

    public FormKaryawan() {
        setTitle("Form Karyawan");
        setSize(700, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Panel Form
        JPanel panelForm = new JPanel(new GridLayout(5, 2, 10, 10));
        panelForm.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        panelForm.add(new JLabel("NIP:"));
        tfNIP = new JTextField();
        panelForm.add(tfNIP);

        panelForm.add(new JLabel("Nama:"));
        tfNama = new JTextField();
        panelForm.add(tfNama);

        panelForm.add(new JLabel("Jabatan:"));
        tfJabatan = new JTextField();
        panelForm.add(tfJabatan);

        panelForm.add(new JLabel("Alamat:"));
        tfAlamat = new JTextField();
        panelForm.add(tfAlamat);

        panelForm.add(new JLabel("No. HP:"));
        tfNoHP = new JTextField();
        panelForm.add(tfNoHP);

        // Panel Tombol
        JPanel panelTombol = new JPanel(new FlowLayout());
        btnSimpan = new JButton("Simpan");
        btnUbah = new JButton("Ubah");
        btnHapus = new JButton("Hapus");
        btnBersihkan = new JButton("Bersihkan");

        panelTombol.add(btnSimpan);
        panelTombol.add(btnUbah);
        panelTombol.add(btnHapus);
        panelTombol.add(btnBersihkan);

        JPanel panelAtas = new JPanel(new BorderLayout());
        panelAtas.add(panelForm, BorderLayout.CENTER);
        panelAtas.add(panelTombol, BorderLayout.SOUTH);

        // Tabel
        String[] kolom = {"NIP", "Nama", "Jabatan", "Alamat", "No. HP"};
        tableModel = new DefaultTableModel(kolom, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        add(panelAtas, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        // Event handling
        btnSimpan.addActionListener(e -> simpanData());
        btnUbah.addActionListener(e -> ubahData());
        btnHapus.addActionListener(e -> hapusData());
        btnBersihkan.addActionListener(e -> bersihkanForm());
        table.getSelectionModel().addListSelectionListener(e -> isiFormDariTabel());
    }

    private void simpanData() {
        String nip = tfNIP.getText();
        String nama = tfNama.getText();
        String jabatan = tfJabatan.getText();
        String alamat = tfAlamat.getText();
        String nohp = tfNoHP.getText();

        if (!nip.isEmpty() && !nama.isEmpty() && !jabatan.isEmpty() && !alamat.isEmpty() && !nohp.isEmpty()) {
            tableModel.addRow(new Object[]{nip, nama, jabatan, alamat, nohp});
            bersihkanForm();
            JOptionPane.showMessageDialog(this, "Data karyawan disimpan!");
        } else {
            JOptionPane.showMessageDialog(this, "Harap lengkapi semua data!");
        }
    }

    private void ubahData() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow >= 0) {
            tableModel.setValueAt(tfNIP.getText(), selectedRow, 0);
            tableModel.setValueAt(tfNama.getText(), selectedRow, 1);
            tableModel.setValueAt(tfJabatan.getText(), selectedRow, 2);
            tableModel.setValueAt(tfAlamat.getText(), selectedRow, 3);
            tableModel.setValueAt(tfNoHP.getText(), selectedRow, 4);
            bersihkanForm();
            JOptionPane.showMessageDialog(this, "Data karyawan diubah!");
        } else {
            JOptionPane.showMessageDialog(this, "Pilih data yang akan diubah!");
        }
    }

    private void hapusData() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow >= 0) {
            tableModel.removeRow(selectedRow);
            bersihkanForm();
            JOptionPane.showMessageDialog(this, "Data karyawan dihapus!");
        } else {
            JOptionPane.showMessageDialog(this, "Pilih data yang akan dihapus!");
        }
    }

    private void bersihkanForm() {
        tfNIP.setText("");
        tfNama.setText("");
        tfJabatan.setText("");
        tfAlamat.setText("");
        tfNoHP.setText("");
        table.clearSelection();
    }

    private void isiFormDariTabel() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow >= 0) {
            tfNIP.setText(tableModel.getValueAt(selectedRow, 0).toString());
            tfNama.setText(tableModel.getValueAt(selectedRow, 1).toString());
            tfJabatan.setText(tableModel.getValueAt(selectedRow, 2).toString());
            tfAlamat.setText(tableModel.getValueAt(selectedRow, 3).toString());
            tfNoHP.setText(tableModel.getValueAt(selectedRow, 4).toString());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FormKaryawan().setVisible(true));
    }
}
