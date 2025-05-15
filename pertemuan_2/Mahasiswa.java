class Mahasiswa {
    private String nama; // Tidak bisa diakses langsung dari luar kelas
    private int umur; // Menambahkan atribut umur

    // Constructor
    public Mahasiswa(String nama, int umur) {
        this.nama = nama;
        setUmur(umur); // Gunakan setter untuk validasi umur
    }

    // Getter untuk nama
    public String getNama() {
        return nama;
    }

    // Setter untuk nama
    public void setNama(String nama) {
        this.nama = nama;
    }

    // Getter untuk umur
    public int getUmur() {
        return umur;
    }

    // Setter untuk umur dengan validasi
    public void setUmur(int umur) {
        if (umur > 0) {
            this.umur = umur;
        } else {
            System.out.println("Umur tidak valid!");
        }
    }

    // Method untuk menampilkan informasi mahasiswa
    public void displayInfo() {
        System.out.println("Nama: " + nama);
        System.out.println("Umur: " + umur);
    }
}

public class Main {
    public static void main(String[] args) {
        // Membuat objek Mahasiswa
        Mahasiswa mhs = new Mahasiswa("Adi", 20);

        // Menampilkan informasi awal
        mhs.displayInfo();

        // Mengubah nama dan umur
        mhs.setNama("Budi");
        mhs.setUmur(22);

        // Menampilkan informasi yang diperbarui
        System.out.println("\nSetelah diperbarui:");
        mhs.displayInfo();
    }
}
