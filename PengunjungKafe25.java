public class PengunjungKafe25 {

    static void daftarPengunjung(int nomorMeja, String... namaPengunjung) {
        System.out.println("Meja nomor " + nomorMeja);
        System.out.println("Daftar nama pengunjung: ");
        for (String nama : namaPengunjung) {
            System.out.println("- " + nama);
        }
        System.out.println();
    }

    static int hitungTotalBelanja(int... harga) {
        int total = 0;
        for (int h : harga) {
            total += h;
        }
        return total;
    }

    public static void main(String[] args) {
        daftarPengunjung(1, "Andi");
        daftarPengunjung(2, "Doni", "Eti", "Fahmi", "Galih");

        String[] tamu = {"Ali", "Budi", "Citra"};
        daftarPengunjung(3, tamu);

        daftarPengunjung(4);

        int satu = hitungTotalBelanja(15000);
        int tiga = hitungTotalBelanja(15000, 20000, 22000);
        int lima = hitungTotalBelanja(15000, 20000, 22000, 12000, 10000);

        System.out.println("Total 1 item  : Rp" + satu);
        System.out.println("Total 3 item  : Rp" + tiga);
        System.out.println("Total 5 item  : Rp" + lima);
    }
}