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

// Kelas Anjing yang mewarisi dari Hewan
class Anjing extends Hewan {
    public void suara() {
        System.out.println("Guk Guk!");
    }
}


public class latihan3 {
    public static void main(String[] args) {
        // Membuat objek Kucing
        Kucing kucing = new Kucing();
        System.out.println("Objek Kucing:");
        kucing.makan(); // Dari kelas Hewan
        kucing.suara(); // Dari kelas Kucing

        System.out.println(); // Baris kosong untuk pemisah

        // Membuat objek Anjing
        Anjing anjing = new Anjing();
        System.out.println("Objek Anjing:");
        anjing.makan(); // Dari kelas Hewan
        anjing.suara(); // Dari kelas Anjing
    }
}
