import java.util.Scanner;
public class Kafe25 {

    public static void Menu(String namaPelanggan, boolean isMember) {
    System.out.println("Selamat datang, " + namaPelanggan + " Di Kafe Kami!");

    if (isMember) {
        System.out.println("Anda adalah member, dapatkan diskon 10% untuk setiap pembelian!");
    }

    System.out.println("===MENU KAFE===");
    System.out.println("1. Kopi Hitam - Rp 15,000");
    System.out.println("2. Cappucccino - Rp 20,000");
    System.out.println("3. Latte - Rp 22,000");
    System.out.println("4. Teh Tarik - Rp 12,000");
    System.out.println("5. Roti Bakar - Rp 10,000");
    System.out.println("6. Mie Goreng - Rp 18,000");
    System.out.println("================");
    System.out.println("Silahkan pilih menu yang anda inginkan");
}

public static int hitungTotalHarga25(int pilihanMenu, int banyakItem) {
    int[] hargaItems = {15000, 20000, 22000, 12000, 10000, 18000};

    int hargaTotal = hargaItems[pilihanMenu - 1] * banyakItem;
    return  hargaTotal;
}
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in); 
    Menu("Andi" , true);

    System.out.println("\nMasukkan nomor menu yang ingin anda pesan: ");
    int pilihanMenu= sc.nextInt();
    System.out.println("Masukkan jumlah item yang ingin dipsan: ");
    int banyakItem = sc.nextInt();

    int totalBayar = hitungTotalHarga25(pilihanMenu, banyakItem);

    System.out.println("Total harga untuk pesanan anda: Rp" + totalBayar);
}
}

