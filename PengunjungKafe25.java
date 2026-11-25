public class PengunjungKafe25 {

    static void daftarPengunjung(int nomorMeja, String... namaPengunjung) {
        System.out.println("Meja nomor " + nomorMeja);
        System.out.println("Daftar nama pengunjung: ");
        for (String nama : namaPengunjung) {
            System.out.println("- " + nama);
        }
    }

    public static void main(String[] args) {
        daftarPengunjung(1,"Andi");
        daftarPengunjung(2,"Doni", "Eti", "Fahmi", "Galih");
    }
}
