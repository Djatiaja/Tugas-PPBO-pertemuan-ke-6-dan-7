import java.awt.image.AreaAveragingScaleFilter;
import java.util.Arrays;

public class Apotek {
    Obat[] rakObat;

    public void tambahObat(String nama , int harga, int stock, int indeks){
        if (indeks> rakObat.length || indeks<=0){
            System.out.println("Maaf rak tidak muat");
            return;
        }
        Obat obat = new Obat(nama, harga, stock, indeks);
        indeks --;
        Obat referensiDepan = cariObat(true,indeks);
        Obat referensiBelakang = cariObat(false,indeks);
        if(referensiDepan != null){
            if (referensiDepan.indeks == indeks + 1){
                System.out.println("Maaf terdapat obat lain pada posisi tersebut");
                return;
            }
            else if (referensiDepan.getHarga() > obat.getHarga()){
                System.out.println("Obat lebih murah dari obat sebelumnya");
                return;
            }
        }

        if(referensiBelakang != null){
            if (referensiBelakang.indeks == indeks + 1){
                System.out.println("Maaf terdapat obat lain pada posisi tersebut");
                return;
            }
            else if (referensiBelakang.getHarga() < obat.getHarga()){
                System.out.println("Obat lebih mahal dari obat setelahnya");
                return;
            }
        }

        rakObat[indeks] = obat;
        System.out.println("Obat Berhasil Ditambahkan");
    }

    public void lihatObat(boolean displayIndeks){
        boolean garisAkhir =false;
        for (Obat obat:rakObat){
            if (obat != null){
                garisAkhir=true;
                System.out.println("------------------------------------------------------------------------");
                if (displayIndeks){
                    System.out.println(obat.display());
                    continue;
                }
                System.out.println(obat);
            }
        }
        if (garisAkhir){
            System.out.println("------------------------------------------------------------------------");
        }
    }

    public void pindahObat(int asal, int akhir){
        System.out.println(Arrays.toString(rakObat));
        if (asal > rakObat.length || akhir > rakObat.length || asal==akhir || asal<=0||akhir<=0){
            System.out.println("error");
            return;
        }

        asal --;
        akhir--;

        Obat pindah = rakObat[asal];
        Obat terpindah = rakObat[akhir];

//        Melakukan pengecekan jika kedua objek bukan null karena jika dipindahkan dari kecil ke besar
//        maka harga pindah lebih besar dari harga terpindah begitu sebaliknya jika pindah dari posisi besar ke kecil
        if (terpindah!= null && pindah!= null){
            if (asal>akhir){
                if (terpindah.getHarga()<pindah.getHarga()){
                    System.out.println("Obat lebih murah dari obat sebelumnya");
                    return;
                }
            }
            else if (terpindah.getHarga()>pindah.getHarga()){
                    System.out.println("Obat lebih murah dari obat sebelumnya");
                    return;

            }

        }
//        Tukar lokasi objek pada list array
        rakObat[akhir] = pindah;
        rakObat[asal] = terpindah;


        akhir++;
        asal ++;
        if (terpindah != null){
            terpindah.indeks =asal+1;
        }

        if (pindah != null){
            pindah.indeks =akhir+1;
        }

        System.out.println("Obat berhasil dipindahkan dari posisi "+ asal +" ke posisi "+ akhir);
    }
    private int rakObatLength(){
        return rakObat.length ;
    }
    private Obat cariObat(boolean ascending, int akhir){
        Obat temp= null;

        for (int i = 0; i < rakObatLength(); i++) {
            if (ascending) {
                if (i - 1 >= akhir) {
                    break;
                }
                if (rakObat[i] != null) {
                    temp = rakObat[i];
                }
                continue;
            }
            if (rakObatLength()-i-1  <= akhir) {
                break;
            }
            if (rakObat[rakObatLength() - i-1] != null) {
                temp = rakObat[rakObatLength() - 1];
            }
        }

        return temp;
    }

    public void beliObat(int indeks , int jumlah){
        indeks --;

        Obat temp = rakObat[indeks];
        if (temp.stock < jumlah){
            System.out.println("Maaf Stock Obat tidak cukup");
            return;
        }

        temp.stock-=jumlah;
        System.out.println("Obat Berhasil dibeli");
    }
    public void setRakObat (int size){
        this.rakObat = new Obat[size];
    }
}
