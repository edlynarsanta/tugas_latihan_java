// Kelas induk (superclass)
class Hewan {
    String nama;

    // Konstruktor untuk menginisialisasi nama hewan
    public Hewan(String nama) {
        this.nama = nama;
    }

    // Metode untuk menampilkan informasi hewan
    public void info() {
        System.out.println("Nama: " + nama);
    }
}

// Kelas Kucing yang mewarisi dari Hewan
class Kucing extends Hewan {
    // Konstruktor Kucing yang memanggil konstruktor superclass
    public Kucing(String nama) {
        super(nama);
    }

    // Metode tambahan khusus untuk Kucing
    public void suara() {
        System.out.println(nama + " mengeong: Meow!");
    }
}

// Kelas utama untuk menjalankan program
public class latihan5{
    public static void main(String[] args) {
        // Membuat objek Kucing dengan nama "Tom"
        Kucing kucing = new Kucing("Tom");

        // Memanggil metode dari superclass Hewan
        kucing.info();

        // Memanggil metode dari subclass Kucing
        kucing.suara();
    }
}
