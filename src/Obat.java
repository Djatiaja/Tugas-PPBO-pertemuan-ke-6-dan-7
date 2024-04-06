public class Obat {
    String nama;
    /**
     * Harga bisa diganti oleh orang luar jika tidak disembunyikan dan dibatasi akses system nya.
     */
    private int harga;
    int stock, indeks;
    Obat(String nama, int harga , int stock, int indeks){
        this.nama = nama;
        this.harga = harga;
        this.stock = stock;
        this.indeks= indeks;
    }

    @Override
    public String toString() {
        return
                "nama = " + nama  +
                       "  |" +
                " harga = " + harga +
                        "  |" +
                " stock = " + stock ;
    }

    public String display() {
        return
                "nama = " + nama  +
                "  |" +
                " harga = " + harga +
                "  |" +
                " stock = " + stock +
                "  |" +
                " posisi = " + indeks
                ;
    }

    public int getHarga(){
        return this.harga;
    }

}
