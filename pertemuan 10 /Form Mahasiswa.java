package koneksi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Koneksi {
    // Ganti dengan URL, username, dan password database Anda
    private static final String URL = "jdbc:mysql://localhost:3306/nama_database";
    private static final String USER = "username";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection connection = null;

        try {
            // Mencoba untuk membuat koneksi
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Koneksi ke database berhasil!");
        } catch (SQLException e) {
            System.out.println("Koneksi ke database gagal!");
            // Menampilkan stack trace untuk debugging
        } finally {
            // Menutup koneksi jika sudah tidak digunakan
            if (connection != null) {
                try {
                    connection.close();
                    System.out.println("Koneksi ditutup.");
                } catch (SQLException e) {
                    // Menampilkan stack trace jika terjadi kesalahan saat menutup koneksi
                    
                }
            }
        }
    }
}
