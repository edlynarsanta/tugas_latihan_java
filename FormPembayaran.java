import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FormPembayaran extends JFrame {
    private JTextField tfID, tfNama, tfTanggal, tfTagihan, tfBayar, tfKembalian;
    private JButton btnHitung, btnSimpan, btnHapus, btnBersihkan;
    private JTable table;
    private DefaultTableModel tableModel;

    public FormPembayaran() {
        setTitle("Form Pembayaran");
        setSize(750, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Panel form
        JPanel panelForm = new JPanel(new GridLayout(6, 2, 10, 10));
        panelForm.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        panelForm.add(new JLabel("ID Pembayaran:"));
        tfID = new JTextField();
        panelForm.add(tfID);

        panelForm.add(new JLabel("Nama Pelanggan:"));
        tfNama = new JTextField();
        panelForm.add(tfNama);

        panelForm.add(new JLabel("Tanggal (YYYY-MM-DD):"));
        tfTanggal = new JTextField(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        panelForm.add(tfTanggal);

        panelForm.add(new JLabel("Total Tagihan:"));
        tfTagihan = new JTextField();
        panelForm.add(tfTagihan);

        panelForm.add(new JLabel("Jumlah Bayar:"));
        tfBayar = new JTextField();
        panelForm.add(tfBayar);

        panelForm.add(new JLabel("Kembalian:"));
        tfKembalian = new JTextField();
        tfKembalian.setEditable(false);
        panelForm.add(tfKembalian);

        // Panel tombol
        JPanel panelTombol = new JPanel(new FlowLayout());
        btnHitung = new JButton("Hitung");
        btnSimpan = new JButton("Simpan");
        btnHapus = new JButton("Hapus");
        btnBersihkan = new JButton("Bersihkan");

        panelTombol.add(btnHitung);
        panelTombol.add(btnSimpan);
        panelTombol.add(btnHapus);
        panelTombol.add(btnBersihkan);

        // Panel atas
        JPanel panelAtas = new JPanel(new BorderLayout());
        panelAtas.add(panelForm, BorderLayout.CENTER);
        panelAtas.add(panelTombol, BorderLayout.SOUTH);

        // Tabel
        String[] kolom = {"ID", "Nama", "Tanggal", "Tagihan", "Bayar", "Kembalian"};
        tableModel = new DefaultTableModel(kolom, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        add(panelAtas, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        // Event
        btnHitung.addActionListener(e -> hitungKembalian());
        btnSimpan.addActionListener(e -> simpanData());
        btnHapus.addActionListener(e -> hapusData());
        btnBersihkan.addActionListener(e -> bersihkanForm());
        table.getSelectionModel().addListSelectionListener(e -> isiFormDariTabel());
    }

    private void hitungKembalian() {
        try {
            double tagihan = Double.parseDouble(tfTagihan.getText());
            double bayar = Double.parseDouble(tfBayar.getText());
            double kembali = bayar - tagihan;
            tfKembalian.setText(String.valueOf(kembali < 0 ? 0 : kembali));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Masukkan angka yang valid.");
        }
    }

    private void simpanData() {
        String id = tfID.getText();
        String nama = tfNama.getText();
        String tanggal = tfTanggal.getText();
        String tagihan = tfTagihan.getText();
        String bayar = tfBayar.getText();
        String kembali = tfKembalian.getText();

        if (id.isEmpty() || nama.isEmpty() || tanggal.isEmpty() ||
            tagihan.isEmpty() || bayar.isEmpty() || kembali.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Lengkapi semua data!");
            return;
        }

        tableModel.addRow(new Object[]{id, nama, tanggal, tagihan, bayar, kembali});
        bersihkanForm();
        JOptionPane.showMessageDialog(this, "Data pembayaran disimpan!");
    }

    private void hapusData() {
        int row = table.getSelectedRow();
        if (row >= 0) {
            tableModel.removeRow(row);
            bersihkanForm();
            JOptionPane.showMessageDialog(this, "Data pembayaran dihapus!");
        } else {
            JOptionPane.showMessageDialog(this, "Pilih data yang ingin dihapus!");
        }
    }

    private void bersihkanForm() {
        tfID.setText("");
        tfNama.setText("");
        tfTanggal.setText(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        tfTagihan.setText("");
        tfBayar.setText("");
        tfKembalian.setText("");
        table.clearSelection();
    }

    private void isiFormDariTabel() {
        int row = table.getSelectedRow();
        if (row >= 0) {
            tfID.setText(tableModel.getValueAt(row, 0).toString());
            tfNama.setText(tableModel.getValueAt(row, 1).toString());
            tfTanggal.setText(tableModel.getValueAt(row, 2).toString());
            tfTagihan.setText(tableModel.getValueAt(row, 3).toString());
            tfBayar.setText(tableModel.getValueAt(row, 4).toString());
            tfKembalian.setText(tableModel.getValueAt(row, 5).toString());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FormPembayaran().setVisible(true));
    }
}
