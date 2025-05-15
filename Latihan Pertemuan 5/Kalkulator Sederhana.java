import java.util.Scanner;

public class Kalkulator {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            char choice;
            
            do {
                // Input angka pertama
                System.out.print("Masukkan angka pertama: ");
                double num1 = scanner.nextDouble();
                
                // Input operator
                System.out.print("Masukkan operator (+, -, *, /, %): ");
                char op = scanner.next().charAt(0);
                
                // Input angka kedua
                System.out.print("Masukkan angka kedua: ");
                double num2 = scanner.nextDouble();
                
                double result = 0;
                boolean valid = true;
                
                // Kalkulasi menggunakan switch-case
                switch(op) {
                    case '+' -> {
                        result = num1 + num2;
                        System.out.println("Hasil: " + result);
                    }
                    case '-' -> {
                        result = num1 - num2;
                        System.out.println("Hasil: " + result);
                    }
                    case '*' -> {
                        result = num1 * num2;
                        System.out.println("Hasil: " + result);
                    }
                    case '/' -> {
                        if (num2 != 0)
                            result = num1 / num2;
                        else {
                            System.out.println("Error: Pembagian oleh nol tidak diperbolehkan!");
                            valid = false;
                        }
                        if (valid) System.out.println("Hasil: " + result);
                    }
                    case '%' -> {
                        if (num2 != 0)
                            result = num1 % num2;
                        else {
                            System.out.println("Error: Modulo oleh nol tidak diperbolehkan!");
                            valid = false;
                        }
                        if (valid) System.out.println("Hasil: " + result);
                    }
                    default -> System.out.println("Error: Operator tidak valid!");
                }
                
                // Tanya apakah ingin menghitung lagi
                System.out.print("Apakah ingin menghitung lagi? (y/n): ");
                choice = scanner.next().charAt(0);
            } while(choice == 'y' || choice == 'Y');
            
            System.out.println("Terima kasih telah menggunakan kalkulator!");
        }
    }
}
