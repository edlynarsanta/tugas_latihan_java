// Kelas induk (superclass)
class Hewan {
    String nama;

    // Konstruktor kelas Hewan
    public Hewan(String nama) {
        this.nama = nama;
    }

    // Metode makan
    public void makan() {
        System.out.println(nama + " sedang makan.");
    }
}

// Kelas anak (subclass) yang mewarisi dari Hewan
class Kucing extends Hewan {
    
    // Konstruktor kelas Kucing
    public Kucing(String nama) {
        super(nama);
    }

    // Metode suara khusus untuk Kucing
    public void suara() {
        System.out.println(nama + " mengeong: Meow!");
    }
}

// Main class untuk menjalankan program
public class Latihan1 { // Nama kelas sebaiknya diawali huruf besar
    public static void main(String[] args) {
        Kucing kucing1 = new Kucing("Tom");
        kucing1.makan(); // Memanggil metode dari superclass
        kucing1.suara(); // Memanggil metode dari subclass
    }
}
