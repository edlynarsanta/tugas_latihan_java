import java.util.Scanner;

public class LoginSystem {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            final String CORRECT_USERNAME = "admin";
            final String CORRECT_PASSWORD = "password123";
            final int MAX_ATTEMPTS = 3;
            int attempts = 0;
            
            while (attempts < MAX_ATTEMPTS) {
                System.out.print("Masukkan username: ");
                String username = scanner.nextLine().trim();
                
                System.out.print("Masukkan password: ");
                String password = scanner.nextLine().trim();
                
                if (username.equals(CORRECT_USERNAME) && password.equals(CORRECT_PASSWORD)) {
                    System.out.println("Selamat datang, " + username + "!");
                    break;
                } else {
                    attempts++;
                    System.out.println("Username atau password salah. Percobaan: " + attempts + "/" + MAX_ATTEMPTS);
                }
            }
            
            if (attempts == MAX_ATTEMPTS) {
                System.out.println("Akun diblokir!");
            }
        }
    }
}
