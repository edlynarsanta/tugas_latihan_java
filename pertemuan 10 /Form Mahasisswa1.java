import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class FormMahasiswa extends JFrame {

    private JTextField tfNim, tfNama;
    private JComboBox<String> cbProdi;

    public FormMahasiswa() {
        super("Form Mahasiswa");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(350, 220);
        setLocationRelativeTo(null);          // posisikan di tengah

        // --- Komponen ---
        tfNim  = new JTextField(15);
        tfNama = new JTextField(15);

        cbProdi = new JComboBox<>(new String[]{
                "Informatika", "Sistem Informasi", "Teknik Komputer",
                "Teknik Elektro", "Matematika"
        });

        JButton btnSimpan = new JButton("Simpan");
        btnSimpan.addActionListener(this::simpanData);

        // --- Layout ---
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(8, 8, 8, 8);
        c.anchor = GridBagConstraints.WEST;

        c.gridx = 0; c.gridy = 0; panel.add(new JLabel("NIM"), c);
        c.gridx = 1; panel.add(tfNim, c);

        c.gridx = 0; c.gridy = 1; panel.add(new JLabel("Nama"), c);
        c.gridx = 1; panel.add(tfNama, c);

        c.gridx = 0; c.gridy = 2; panel.add(new JLabel("Program Studi"), c);
        c.gridx = 1; panel.add(cbProdi, c);

        c.gridx = 1; c.gridy = 3; c.anchor = GridBagConstraints.CENTER;
        panel.add(btnSimpan, c);

        add(panel);
        setVisible(true);
    }

    private void simpanData(ActionEvent e) {
        String nim   = tfNim.getText().trim();
        String nama  = tfNama.getText().trim();
        String prodi = (String) cbProdi.getSelectedItem();

        if (nim.isEmpty() || nama.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "NIM dan Nama wajib diisi!",
                    "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String msg = String.format(
                "Data Mahasiswa:\nNIM  : %s\nNama : %s\nProdi: %s",
                nim, nama, prodi);

        JOptionPane.showMessageDialog(this, msg, "Berhasil", JOptionPane.INFORMATION_MESSAGE);

        // reset field
        tfNim.setText("");
        tfNama.setText("");
        cbProdi.setSelectedIndex(0);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(FormMahasiswa::new);
    }
}
