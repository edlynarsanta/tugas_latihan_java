import javax.swing.*;
import java.awt.*;

public class FormOrderBarang extends JFrame {

    private final JTextField tfNamaBarang;
    private final JTextField tfJumlah;
    private final JTextField tfHarga;
    private final JButton btnSimpan;
    private final JButton btnUbah;
    private final JButton btnHapus;
    private final JButton btnBersihkan;

    public FormOrderBarang() {
        setTitle("Form Order Barang");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel untuk form
        JPanel panelForm = new JPanel(new GridLayout(4, 2, 10, 10));
        panelForm.setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 20));

        // Komponen Form
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

        // Tambahkan panel ke frame
        add(panelForm, BorderLayout.CENTER);
        add(panelTombol, BorderLayout.SOUTH);

        // Event handling (contoh sederhana)
        btnSimpan.addActionListener(e -> JOptionPane.showMessageDialog(this, "Data disimpan!"));
        btnUbah.addActionListener(e -> JOptionPane.showMessageDialog(this, "Data diubah!"));
        btnHapus.addActionListener(e -> JOptionPane.showMessageDialog(this, "Data dihapus!"));
        btnBersihkan.addActionListener(e -> bersihkanForm());
    }

    private void bersihkanForm() {
        tfNamaBarang.setText("");
        tfJumlah.setText("");
        tfHarga.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FormOrderBarang().setVisible(true));
    }
}
