import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class FormDataBarang extends JFrame {
    private JTextField tfKode, tfNama, tfSatuan, tfStok, tfHarga;
    private JButton btnSimpan, btnUbah, btnHapus, btnBersihkan;
    private JTable table;
    private DefaultTableModel tableModel;

    public FormDataBarang() {
        setTitle("Form Data Barang");
        setSize(700, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Panel Form
        JPanel panelForm = new JPanel(new GridLayout(5, 2, 10, 10));
        panelForm.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        panelForm.add(new JLabel("Kode Barang:"));
        tfKode = new JTextField();
        panelForm.add(tfKode);

        panelForm.add(new JLabel("Nama Barang:"));
        tfNama = new JTextField();
        panelForm.add(tfNama);

        panelForm.add(new JLabel("Satuan:"));
        tfSatuan = new JTextField();
        panelForm.add(tfSatuan);

        panelForm.add(new JLabel("Stok:"));
        tfStok = new JTextField();
        panelForm.add(tfStok);

        panelForm.add(new JLabel("Harga:"));
        tfHarga = new JTextField();
        panelForm.add(tfHarga);

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

        // Gabungkan Form + Tombol
        JPanel panelAtas = new JPanel(new BorderLayout());
        panelAtas.add(panelForm, BorderLayout.CENTER);
        panelAtas.add(panelTombol, BorderLayout.SOUTH);

        // Tabel
        String[] kolom = {"Kode", "Nama", "Satuan", "Stok", "Harga"};
        tableModel = new DefaultTableModel(kolom, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        // Tambahkan ke Frame
        add(panelAtas, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        // Event Tombol
        btnSimpan.addActionListener(e -> simpanData());
        btnUbah.addActionListener(e -> ubahData());
        btnHapus.addActionListener(e -> hapusData());
        btnBersihkan.addActionListener(e -> bersihkanForm());
        table.getSelectionModel().addListSelectionListener(e -> isiFormDariTabel());
    }

    private void simpanData() {
        String kode = tfKode.getText();
        String nama = tfNama.getText();
        String satuan = tfSatuan.getText();
        String stok = tfStok.getText();
        String harga = tfHarga.getText();

        if (!kode.isEmpty() && !nama.isEmpty() && !satuan.isEmpty() && !stok.isEmpty() && !harga.isEmpty()) {
            tableModel.addRow(new Object[]{kode, nama, satuan, stok, harga});
            bersihkanForm();
            JOptionPane.showMessageDialog(this, "Data barang disimpan!");
        } else {
            JOptionPane.showMessageDialog(this, "Harap lengkapi semua data!");
        }
    }

    private void ubahData() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow >= 0) {
            tableModel.setValueAt(tfKode.getText(), selectedRow, 0);
            tableModel.setValueAt(tfNama.getText(), selectedRow, 1);
            tableModel.setValueAt(tfSatuan.getText(), selectedRow, 2);
            tableModel.setValueAt(tfStok.getText(), selectedRow, 3);
            tableModel.setValueAt(tfHarga.getText(), selectedRow, 4);
            bersihkanForm();
            JOptionPane.showMessageDialog(this, "Data barang diubah!");
        } else {
            JOptionPane.showMessageDialog(this, "Pilih data yang akan diubah!");
        }
    }

    private void hapusData() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow >= 0) {
            tableModel.removeRow(selectedRow);
            bersihkanForm();
            JOptionPane.showMessageDialog(this, "Data barang dihapus!");
        } else {
            JOptionPane.showMessageDialog(this, "Pilih data yang akan dihapus!");
        }
    }

    private void bersihkanForm() {
        tfKode.setText("");
        tfNama.setText("");
        tfSatuan.setText("");
        tfStok.setText("");
        tfHarga.setText("");
        table.clearSelection();
    }

    private void isiFormDariTabel() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow >= 0) {
            tfKode.setText(tableModel.getValueAt(selectedRow, 0).toString());
            tfNama.setText(tableModel.getValueAt(selectedRow, 1).toString());
            tfSatuan.setText(tableModel.getValueAt(selectedRow, 2).toString());
            tfStok.setText(tableModel.getValueAt(selectedRow, 3).toString());
            tfHarga.setText(tableModel.getValueAt(selectedRow, 4).toString());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FormDataBarang().setVisible(true));
    }
}
