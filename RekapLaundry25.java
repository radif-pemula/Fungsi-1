import java.util.Scanner;

public class RekapLaundry25 {

    static Scanner sc = new Scanner(System.in);
    static String[] namaHari = {"Senin", "Selasa", "Rabu", "Kamis", "Jumat", "Sabtu"};

    // menginput data berat cucian tiap layanan untuk tiap hari
    static void inputData(int[][] data, String[] namaLayanan) {
        for (int i = 0; i < data.length; i++) {
            System.out.println("Layanan: " + namaLayanan[i]);
            for (int j = 0; j < data[i].length; j++) {
                System.out.print("  Berat cucian " + namaHari[j] + " (kg): ");
                data[i][j] = sc.nextInt();
            }
        }
    }

    // menampilkan seluruh data dalam bentuk tabel
    static void tampilData(int[][] data, String[] namaLayanan) {
        System.out.printf("%-16s", "Layanan");
        for (int j = 0; j < data[0].length; j++) {
            System.out.printf("%9s", namaHari[j]);
        }
        System.out.println();

        for (int i = 0; i < data.length; i++) {
            System.out.printf("%-16s", namaLayanan[i]);
            for (int j = 0; j < data[i].length; j++) {
                System.out.printf("%9d", data[i][j]);
            }
            System.out.println();
        }
    }

    // total berat cucian satu layanan selama seluruh hari
    static int totalPerLayanan(int[][] data, int idxLayanan) {
        int total = 0;
        for (int j = 0; j < data[idxLayanan].length; j++) {
            total += data[idxLayanan][j];
        }
        return total;
    }

    // layanan dengan total tertinggi
    static void tampilLayananTertinggi(int[][] data, String[] namaLayanan) {
        int idxMax = 0;
        for (int i = 1; i < data.length; i++) {
            if (totalPerLayanan(data, i) > totalPerLayanan(data, idxMax)) {
                idxMax = i;
            }
        }
        System.out.println("Layanan dengan total tertinggi: " + namaLayanan[idxMax]
                + " (" + totalPerLayanan(data, idxMax) + " kg)");
    }

    // indeks hari dengan total berat cucian terbesar
    static int hariTersibuk(int[][] data) {
        int idxMax = 0;
        int maxTotal = -1;
        for (int j = 0; j < data[0].length; j++) {
            int total = 0;
            for (int i = 0; i < data.length; i++) {
                total += data[i][j];
            }
            if (total > maxTotal) {
                maxTotal = total;
                idxMax = j;
            }
        }
        return idxMax;
    }

    // pendapatan tiap layanan dan total pendapatan
    static void tampilPendapatan(int[][] data, String[] namaLayanan, int[] hargaPerKg) {
        long totalSemua = 0;
        System.out.println("Pendapatan per layanan:");
        for (int i = 0; i < data.length; i++) {
            long pendapatan = (long) totalPerLayanan(data, i) * hargaPerKg[i];
            System.out.println("- " + namaLayanan[i] + " : Rp" + pendapatan);
            totalSemua += pendapatan;
        }
        System.out.println("Total pendapatan: Rp" + totalSemua);
    }

    public static void main(String[] args) {
        String[] namaLayanan = {"Cuci Kering", "Cuci Setrika", "Setrika Saja", "Express"};
        int[] hargaPerKg = {6000, 8000, 5000, 12000};
        int[][] data = {
            {12, 15, 10, 18, 20, 25},
            {20, 18, 22, 15, 30, 35},
            {8, 5, 10, 7, 6, 12},
            {3, 6, 2, 5, 8, 10}
        };

        System.out.print("Input ulang data dari keyboard? (y/n): ");
        if (sc.next().equalsIgnoreCase("y")) {
            inputData(data, namaLayanan);
        }

        System.out.println("\n=== DATA BERAT CUCIAN (kg) ===");
        tampilData(data, namaLayanan);

        System.out.println("\n=== TOTAL PER LAYANAN ===");
        for (int i = 0; i < data.length; i++) {
            System.out.println(namaLayanan[i] + " : " + totalPerLayanan(data, i) + " kg");
        }

        System.out.println();
        tampilLayananTertinggi(data, namaLayanan);

        int idxHari = hariTersibuk(data);
        System.out.println("Hari tersibuk: " + namaHari[idxHari]);

        System.out.println();
        tampilPendapatan(data, namaLayanan, hargaPerKg);

        sc.close();
    }
}