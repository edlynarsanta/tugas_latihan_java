// Kelas induk (superclass)
class Hewan {
    public void makan() {
        System.out.println("Hewan sedang makan.");
    }
}

// Kelas Kucing yang mewarisi dari Hewan
class Kucing extends Hewan {
    public void suara() {
        System.out.println("Meow!");
    }
}

// Kelas KucingAnggora yang mewarisi dari Kucing
class KucingAnggora extends Kucing {
    public void jenis() {
        System.out.println("Ini anggora.");
    }
}

// Kelas utama untuk menjalankan program
public class Latihan2 {
    public static void main(String[] args) {
        KucingAnggora anggora = new KucingAnggora();

        anggora.makan(); // Memanggil metode dari superclass Hewan
        anggora.suara(); // Memanggil metode dari subclass Kucing
        anggora.jenis(); // Memanggil metode dari subclass KucingAnggora
    }
}
