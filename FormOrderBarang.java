import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class FormOrderBarang extends JFrame {
    private JTextField tfNamaBarang, tfJumlah, tfHarga;
    private JButton btnSimpan, btnUbah, btnHapus, btnBersihkan;
    private JTable table;
    private DefaultTableModel tableModel;

    public FormOrderBarang() {
        setTitle("Form Order Barang");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Panel untuk form
        JPanel panelForm = new JPanel(new GridLayout(3, 2, 10, 10));
        panelForm.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        panelForm.add(new JLabel("Nama Barang:"));
        tfNamaBarang = new JTextField();
        panelForm.add(tfNamaBarang);

        panelForm.add(new JLabel("Jumlah:"));
        tfJumlah = new JTextField();
        panelForm.add(tfJumlah);

        panelForm.add(new JLabel("Harga:"));
        tfHarga = new JTextField();
        panelForm.add(tfHarga);

        // Panel tombol
        JPanel panelTombol = new JPanel(new FlowLayout());
        btnSimpan = new JButton("Simpan");
        btnUbah = new JButton("Ubah");
        btnHapus = new JButton("Hapus");
        btnBersihkan = new JButton("Bersihkan");

        panelTombol.add(btnSimpan);
        panelTombol.add(btnUbah);
        panelTombol.add(btnHapus);
        panelTombol.add(btnBersihkan);

        // Panel atas gabungkan form dan tombol
        JPanel panelAtas = new JPanel(new BorderLayout());
        panelAtas.add(panelForm, BorderLayout.CENTER);
        panelAtas.add(panelTombol, BorderLayout.SOUTH);

        // Tabel
        String[] kolom = {"Nama Barang", "Jumlah", "Harga"};
        tableModel = new DefaultTableModel(kolom, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        // Tambahkan ke frame
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
        String nama = tfNamaBarang.getText();
        String jumlah = tfJumlah.getText();
        String harga = tfHarga.getText();

        if (!nama.isEmpty() && !jumlah.isEmpty() && !harga.isEmpty()) {
            tableModel.addRow(new Object[]{nama, jumlah, harga});
            bersihkanForm();
            JOptionPane.showMessageDialog(this, "Data disimpan!");
        } else {
            JOptionPane.showMessageDialog(this, "Harap lengkapi semua data!");
        }
    }

    private void ubahData() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow >= 0) {
            tableModel.setValueAt(tfNamaBarang.getText(), selectedRow, 0);
            tableModel.setValueAt(tfJumlah.getText(), selectedRow, 1);
            tableModel.setValueAt(tfHarga.getText(), selectedRow, 2);
            bersihkanForm();
            JOptionPane.showMessageDialog(this, "Data diubah!");
        } else {
            JOptionPane.showMessageDialog(this, "Pilih data yang akan diubah!");
        }
    }

    private void hapusData() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow >= 0) {
            tableModel.removeRow(selectedRow);
            bersihkanForm();
            JOptionPane.showMessageDialog(this, "Data dihapus!");
        } else {
            JOptionPane.showMessageDialog(this, "Pilih data yang akan dihapus!");
        }
    }

    private void bersihkanForm() {
        tfNamaBarang.setText("");
        tfJumlah.setText("");
        tfHarga.setText("");
        table.clearSelection();
    }

    private void isiFormDariTabel() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow >= 0) {
            tfNamaBarang.setText(tableModel.getValueAt(selectedRow, 0).toString());
            tfJumlah.setText(tableModel.getValueAt(selectedRow, 1).toString());
            tfHarga.setText(tableModel.getValueAt(selectedRow, 2).toString());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FormOrderBarang().setVisible(true));
    }
}
