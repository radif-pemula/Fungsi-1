import java.util.Scanner;

public class BankSampah25 {

    static Scanner sc = new Scanner(System.in);

    // a. input berat setoran tiap nasabah, mengembalikan array
    static double[] inputSetoran(int n) {
        double[] setoran = new double[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Berat setoran nasabah ke-" + (i + 1) + " (kg): ");
            setoran[i] = sc.nextDouble();
        }
        return setoran;
    }

    // b. tampilkan berat setoran tiap nasabah
    static void tampilSetoran(double[] setoran) {
        System.out.println("Berat setoran tiap nasabah:");
        for (int i = 0; i < setoran.length; i++) {
            System.out.println("Nasabah " + (i + 1) + " : " + setoran[i] + " kg");
        }
    }

    // c. total setoran seluruh nasabah
    static double totalSetoran(double[] setoran) {
        double total = 0;
        for (double berat : setoran) {
            total += berat;
        }
        return total;
    }

    // d. saldo dalam rupiah
    static double hitungSaldo(double beratSetoran, double hargaPerKg) {
        return beratSetoran * hargaPerKg;
    }

    // e. indeks nasabah dengan setoran terbesar
    static int nasabahTerbanyak(double[] setoran) {
        int idxMax = 0;
        for (int i = 1; i < setoran.length; i++) {
            if (setoran[i] > setoran[idxMax]) {
                idxMax = i;
            }
        }
        return idxMax;
    }

    // f. main
    public static void main(String[] args) {
        System.out.print("Masukkan jumlah nasabah (N): ");
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("Jumlah nasabah harus lebih dari 0");
            return;
        }

        double[] setoran = inputSetoran(n);

        System.out.println();
        tampilSetoran(setoran);
        System.out.println("Total setoran: " + totalSetoran(setoran) + " kg");

        System.out.println("\nSaldo tiap nasabah (Rp3.000 per kg):");
        for (int i = 0; i < setoran.length; i++) {
            double saldo = hitungSaldo(setoran[i], 3000);
            System.out.printf("Nasabah %d : Rp%.0f%n", i + 1, saldo);
        }

        int idx = nasabahTerbanyak(setoran);
        System.out.println("\nSetoran terbanyak: nasabah ke-" + (idx + 1)
                + " (" + setoran[idx] + " kg)");

        sc.close();
    }
}