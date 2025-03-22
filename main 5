class BankAccount {

private String pemilikAkun;

private double saldo;

// Constructor

public BankAccount(String pemilikAkun, double saldoAwal) {

this.pemilikAkun = pemilikAkun;

this.saldo = saldoAwal;

}

// Getter untuk saldo (agar bisa dibaca tapi tidak diubah langsung)

public double getSaldo() {

return saldo;

}

// Metode untuk menambah saldo

public void deposit(double jumlah) {

if (jumlah > 0) {

saldo += jumlah;

System.out.println("Deposit berhasil! Saldo sekarang: $" +
saldo);

} else {

System.out.println("Jumlah deposit harus lebih dari 0!");

}

}

// Metode untuk menarik saldo dengan validasi

public void tarikSaldo(double jumlah) {

if (jumlah > 0 && jumlah <= saldo) {

saldo -= jumlah;

System.out.println("Penarikan berhasil! Saldo tersisa: $" + saldo);

} else {

System.out.println("Penarikan gagal! Saldo tidak mencukupi atau jumlah tidak
valid.");

}

}

}

public class Main {

public static void main(String[] args) {

BankAccount akun1 = new BankAccount("Adi", 1000);

// Mengakses saldo dengan metode getter

System.out.println("Saldo awal: $" + akun1.getSaldo());

// Melakukan transaksi

akun1.deposit(500); // Menambah saldo

akun1.tarikSaldo(300); // Menarik saldo

// ❌ Tidak bisa mengubah saldo secara langsung

// akun1.saldo = 10000; // Error: saldo bersifat private

}

}
