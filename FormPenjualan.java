import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class FormPenjualan extends JFrame {
    private JTextField tfKode, tfNama, tfJumlah, tfHarga, tfTotal;
    private JButton btnTambah, btnHapus, btnSimpan, btnBersihkan;
    private JTable table;
    private DefaultTableModel tableModel;

    public FormPenjualan() {
        setTitle("Form Penjualan");
        setSize(700, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Form input
        JPanel panelForm = new JPanel(new GridLayout(5, 2, 10, 10));
        panelForm.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        panelForm.add(new JLabel("Kode Barang:"));
        tfKode = new JTextField();
        panelForm.add(tfKode);

        panelForm.add(new JLabel("Nama Barang:"));
        tfNama = new JTextField();
        panelForm.add(tfNama);

        panelForm.add(new JLabel("Jumlah:"));
        tfJumlah = new JTextField();
        panelForm.add(tfJumlah);

        panelForm.add(new JLabel("Harga Satuan:"));
        tfHarga = new JTextField();
        panelForm.add(tfHarga);

        panelForm.add(new JLabel("Total Harga:"));
        tfTotal = new JTextField();
        tfTotal.setEditable(false);
        panelForm.add(tfTotal);

        // Tombol
        JPanel panelTombol = new JPanel(new FlowLayout());
        btnTambah = new JButton("Tambah");
        btnHapus = new JButton("Hapus");
        btnSimpan = new JButton("Simpan Transaksi");
        btnBersihkan = new JButton("Bersihkan");

        panelTombol.add(btnTambah);
        panelTombol.add(btnHapus);
        panelTombol.add(btnSimpan);
        panelTombol.add(btnBersihkan);

        JPanel panelAtas = new JPanel(new BorderLayout());
        panelAtas.add(panelForm, BorderLayout.CENTER);
        panelAtas.add(panelTombol, BorderLayout.SOUTH);

        // Tabel
        String[] kolom = {"Kode", "Nama", "Jumlah", "Harga Satuan", "Total Harga"};
        tableModel = new DefaultTableModel(kolom, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        add(panelAtas, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        // Event handler
        tfJumlah.addActionListener(e -> hitungTotal());
        tfHarga.addActionListener(e -> hitungTotal());

        btnTambah.addActionListener(e -> tambahBarang());
        btnHapus.addActionListener(e -> hapusBarang());
        btnSimpan.addActionListener(e -> simpanTransaksi());
        btnBersihkan.addActionListener(e -> bersihkanForm());

        table.getSelectionModel().addListSelectionListener(e -> isiFormDariTabel());
    }

    private void hitungTotal() {
        try {
            int jumlah = Integer.parseInt(tfJumlah.getText());
            double harga = Double.parseDouble(tfHarga.getText());
            double total = jumlah * harga;
            tfTotal.setText(String.valueOf(total));
        } catch (NumberFormatException e) {
            tfTotal.setText("0");
        }
    }

    private void tambahBarang() {
        String kode = tfKode.getText();
        String nama = tfNama.getText();
        String jumlah = tfJumlah.getText();
        String harga = tfHarga.getText();
        String total = tfTotal.getText();

        if (kode.isEmpty() || nama.isEmpty() || jumlah.isEmpty() || harga.isEmpty() || total.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Lengkapi semua field!");
        } else {
            tableModel.addRow(new Object[]{kode, nama, jumlah, harga, total});
            bersihkanForm();
        }
    }

    private void hapusBarang() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow >= 0) {
            tableModel.removeRow(selectedRow);
        } else {
            JOptionPane.showMessageDialog(this, "Pilih baris yang ingin dihapus.");
        }
    }

    private void simpanTransaksi() {
        int rowCount = tableModel.getRowCount();
        if (rowCount == 0) {
            JOptionPane.showMessageDialog(this, "Belum ada data untuk disimpan.");
            return;
        }

        double totalSemua = 0;
        for (int i = 0; i < rowCount; i++) {
            totalSemua += Double.parseDouble(tableModel.getValueAt(i, 4).toString());
        }

        JOptionPane.showMessageDialog(this, "Transaksi berhasil disimpan.\nTotal: Rp " + totalSemua);
        tableModel.setRowCount(0);
    }

    private void bersihkanForm() {
        tfKode.setText("");
        tfNama.setText("");
        tfJumlah.setText("");
        tfHarga.setText("");
        tfTotal.setText("");
        table.clearSelection();
    }

    private void isiFormDariTabel() {
        int row = table.getSelectedRow();
        if (row >= 0) {
            tfKode.setText(tableModel.getValueAt(row, 0).toString());
            tfNama.setText(tableModel.getValueAt(row, 1).toString());
            tfJumlah.setText(tableModel.getValueAt(row, 2).toString());
            tfHarga.setText(tableModel.getValueAt(row, 3).toString());
            tfTotal.setText(tableModel.getValueAt(row, 4).toString());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FormPenjualan().setVisible(true));
    }
}
