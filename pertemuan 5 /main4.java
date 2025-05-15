class Mesin {
    private boolean menyala = false;

    private void cekBahanBakar() {
        System.out.println("Cek bahan bakar sebelum menyalakan mesin...");
    }

    public void nyalakanMesin() {
        if (!menyala) {
            cekBahanBakar();
            menyala = true;
            System.out.println("Mesin menyala!");
        } else {
            System.out.println("Mesin sudah dalam keadaan menyala.");
        }
    }

    public void matikanMesin() {
        if (menyala) {
            menyala = false;
            System.out.println("Mesin dimatikan.");
        } else {
            System.out.println("Mesin sudah dalam keadaan mati.");
        }
    }

    public void cekStatusMesin() {
        if (menyala) {
            System.out.println("Mesin sedang menyala.");
        } else {
            System.out.println("Mesin dalam keadaan mati.");
        }
    }
}

public class Main4{
    public static void main(String[] args) {
        Mesin mobil = new Mesin();

        mobil.nyalakanMesin();
        mobil.cekStatusMesin();
        mobil.matikanMesin();
        mobil.cekStatusMesin();
    }
}
