class Kalkulator {

    // Metode pertama: Menjumlahkan dua angka
    int tambah(int a, int b) {
        return a + b;
    }

    // Metode kedua: Menjumlahkan tiga angka (Overloading)
    int tambah(int a, int b, int c) {
        return a + b + c;
    }

    // Metode ketiga: Menjumlahkan dua angka desimal (Overloading)
    double tambah(double a, double b) {
        return a + b;
    }
}


public class latihan6 {
    public static void main(String[] args) {

        Kalkulator k = new Kalkulator();

        // Memanggil metode pertama
        System.out.println(k.tambah(5, 10));

        // Memanggil metode kedua
        System.out.println(k.tambah(5, 10, 15));

        // Memanggil metode ketiga
        System.out.println(k.tambah(5.5, 2.5));
    }
}
