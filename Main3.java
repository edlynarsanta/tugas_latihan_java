class BankAccount {
    private double saldo; // Tidak bisa diakses langsung

    // Constructor
    public BankAccount(double saldoAwal) {
        if (saldoAwal >= 0) {
            this.saldo = saldoAwal;
        } else {
            System.out.println("Saldo awal tidak bisa negatif! Mengatur saldo ke 0.");
            this.saldo = 0;
        }
    }

    // Getter
    public double getSaldo() {
        return saldo;
    }

    // Setter dengan validasi
    public void setSaldo(double jumlah) {
        if (jumlah >= 0) {
            this.saldo = jumlah;
        } else {
            System.out.println("Saldo tidak bisa negatif!");
        }
    }

    // Method untuk menambah saldo (deposit)
    public void deposit(double jumlah) {
        if (jumlah > 0) {
            saldo += jumlah;
            System.out.println("Berhasil menambah saldo: Rp" + jumlah);
        } else {
            System.out.println("Jumlah deposit harus lebih dari 0!");
        }
    }

    // Method untuk menarik saldo (withdraw)
    public void withdraw(double jumlah) {
        if (jumlah > 0 && jumlah <= saldo) {
            saldo -= jumlah;
            System.out.println("Berhasil menarik saldo: Rp" + jumlah);
        } else if (jumlah > saldo) {
            System.out.println("Saldo tidak mencukupi!");
        } else {
            System.out.println("Jumlah penarikan harus lebih dari 0!");
        }
    }

    // Method untuk menampilkan saldo saat ini
    public void displaySaldo() {
        System.out.println("Saldo saat ini: Rp" + saldo);
    }
}

public class Main {
    public static void main(String[] args) {
        // Membuat akun bank dengan saldo awal Rp500.000
        BankAccount akun = new BankAccount(500000);

        // Menampilkan saldo awal
        akun.displaySaldo();

        // Menambah saldo
        akun.deposit(200000);
        akun.displaySaldo();

        // Menarik saldo
        akun.withdraw(100000);
        akun.displaySaldo();

        // Coba menarik saldo lebih dari yang dimiliki
        akun.withdraw(700000);

        // Coba deposit dan withdraw dengan nilai negatif
        akun.deposit(-50000);
        akun.withdraw(-30000);
    }
}
