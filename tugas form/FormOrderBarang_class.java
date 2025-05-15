import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FormDataBarang extends JFrame {
    private JTextField tfKodeBarang, tfNamaBarang, tfStok, tfHarga;
    private JButton btnSimpan, btnUbah, btnHapus, btnBersihkan;

    public FormDataBarang() {
        setTitle("Form Data Barang");
        setSize(450, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel input
        JPanel panelForm = new JPanel(new GridLayout(4, 2, 10, 10));
        panelForm.setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 20));

        // Label dan Text Field
        panelForm.add(new JLabel("Kode Barang:"));
        tfKodeBaran
