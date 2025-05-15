import java.util.Random;
import java.util.Scanner;

public class TebakAngka {
    public static void main(String[] args) {
        Random rand = new Random();
        Scanner scanner = new Scanner(System.in);
        
        int angkaRahasia = rand.nextInt(100) + 1;
        int tebakan;
        int percobaan = 0;
        
        System.out.println("Selamat datang di permainan Tebak Angka!");
        System.out.println("Saya telah memilih angka antara 1 hingga 100.");
        System.out.println("Coba tebak angkanya! Ketik 0 untuk keluar.");
        
        while (true) {
            System.out.print("Masukkan tebakan Anda: ");
            tebakan = scanner.nextInt();
            
            if (tebakan == 0) {
                System.out.println("Terima kasih telah bermain. Sampai jumpa!");
                break;
            }
            
            percobaan++;
            
            if (tebakan < angkaRahasia) {
                System.out.println("Terlalu kecil! Coba lagi.");
            } else if (tebakan > angkaRahasia) {
                System.out.println("Terlalu besar! Coba lagi.");
            } else {
                System.out.println("Selamat! Anda menebak angka dengan benar dalam " + percobaan + " percobaan.");
                break;
            }
        }
        
        scanner.close();
    }
}
