import java.util.Scanner;

public class RekapLaundry25 {

    static Scanner sc = new Scanner(System.in);

    static void inputData(int[][] data, String[] namaLayanan) {
        for (int i = 0; i < data.length; i++) {
            System.out.println("Layanan: " + namaLayanan[i]);
            for (int j = 0; j < data[i].length; j++) {
                System.out.print("  Berat cucian Hari ke-" + (j + 1) + " (kg): ");
                data[i][j] = sc.nextInt();
            }
        }
    }

    static void tampilData(int[][] data, String[] namaLayanan) {
        System.out.printf("%-16s", "Layanan");
        for (int j = 0; j < data[0].length; j++) {
            System.out.printf("%11s", "Hari ke-" + (j + 1));
        }
        System.out.println();

        for (int i = 0; i < data.length; i++) {
            System.out.printf("%-16s", namaLayanan[i]);
            for (int j = 0; j < data[i].length; j++) {
                System.out.printf("%11d", data[i][j]);
            }
            System.out.println();
        }
    }

    static int totalPerLayanan(int[][] data, int idxLayanan) {
        int total = 0;
        for (int j = 0; j < data[idxLayanan].length; j++) {
            total += data[idxLayanan][j];
        }
        return total;
    }

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
        System.out.print("Jumlah layanan: ");
        int jmlLayanan = sc.nextInt();
        System.out.print("Jumlah hari: ");
        int jmlHari = sc.nextInt();
        sc.nextLine(); // buang sisa baris baru setelah nextInt

        String[] namaLayanan = new String[jmlLayanan];
        int[] hargaPerKg = new int[jmlLayanan];

        for (int i = 0; i < jmlLayanan; i++) {
            System.out.print("Nama layanan ke-" + (i + 1) + ": ");
            namaLayanan[i] = sc.nextLine();
            System.out.print("Harga per kg " + namaLayanan[i] + " (Rp): ");
            hargaPerKg[i] = sc.nextInt();
            sc.nextLine();
        }

        int[][] data = new int[jmlLayanan][jmlHari];
        inputData(data, namaLayanan);

        System.out.println("\n=== DATA BERAT CUCIAN (kg) ===");
        tampilData(data, namaLayanan);

        System.out.println("\n=== TOTAL PER LAYANAN ===");
        for (int i = 0; i < data.length; i++) {
            System.out.println(namaLayanan[i] + " : " + totalPerLayanan(data, i) + " kg");
        }

        System.out.println();
        tampilLayananTertinggi(data, namaLayanan);

        int idxHari = hariTersibuk(data);
        System.out.println("Hari tersibuk: Hari ke-" + (idxHari + 1));

        System.out.println();
        tampilPendapatan(data, namaLayanan, hargaPerKg);

        sc.close();
    }
}