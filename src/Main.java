import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Apotek apotekKu= new Apotek();
        System.out.print("Masukan ukuran rak obat : ");
        apotekKu.setRakObat(input.nextInt());

        String[] Menu ={
                "Lihat Obat",
                "Tambah Obat",
                "Pindah Obat",
                "Beli Obat",
                "Keluar"
        };

        while (true){
            int i=1;
            System.out.println("Selamat Datang di Apotek");

            for (String menu:Menu){
                System.out.println(i+". "+ menu);
                i++;
            }

            System.out.print("Pilih Menu : ");
            String pilihan = input.next();

            if (Objects.equals(pilihan, "1")){
                apotekKu.lihatObat(false);
            }

            else if (Objects.equals(pilihan, "2")) {
                apotekKu.lihatObat(true);
                System.out.print("Masukan Nama Obat : ");
                String nama = input.next();

                System.out.print("Masukan Harga Obat : ");
                int harga = input.nextInt();

                System.out.print("Masukan Stock Obat : ");
                int stock = input.nextInt();

                System.out.print("Masukan posisi Obat : ");
                int posisi = input.nextInt();

                apotekKu.tambahObat(nama, harga, stock, posisi);
            }

            else if (Objects.equals(pilihan, "3")) {
                apotekKu.lihatObat(true);
                System.out.print("Masukan posisi obat yang ingin dipindah : ");
                int awal = input.nextInt();
                System.out.print("Masukan posisi kemana obat ingin dipindah : ");
                int akhir = input.nextInt();

                apotekKu.pindahObat(awal, akhir);
            }

            else if (Objects.equals(pilihan, "4")) {
                apotekKu.lihatObat(true);
                System.out.print("Masukan posisi obat yang ingin di beli : ");
                int indeks = input.nextInt();
                System.out.print("Masukan jumlah obat yang ingin dibeli : ");
                int jumlah = input.nextInt();

                apotekKu.beliObat(indeks, jumlah);
            }

            else if (Objects.equals(pilihan, "5")){
                System.out.println();
                break;
            }

        System.out.println();
        }
    }
}