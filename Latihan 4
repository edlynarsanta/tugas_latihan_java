// Interface Hewan
interface Hewan {
    void makan();
}

// Interface Mamalia
interface Mamalia {
    void menyusui();
}

// Kelas Kucing yang mengimplementasikan interface Hewan dan Mamalia
class Kucing implements Hewan, Mamalia {
    @Override
    public void makan() {
        System.out.println("Kucing makan ikan.");
    }

    @Override
    public void menyusui() {
        System.out.println("Kucing menyusui anaknya.");
    }
}

// Kelas utama untuk menjalankan program
public class latihan4{
    public static void main(String[] args) {
        // Membuat objek Kucing
        Kucing kucing = new Kucing();
        
        // Memanggil metode yang dimiliki oleh Kucing
        kucing.makan();     // Dari interface Hewan
        kucing.menyusui();  // Dari interface Mamalia
    }
}
