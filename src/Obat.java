public class Obat {
    String nama;
    private int harga;
    int stock, indeks= 0;
    Obat(String nama, int harga , int stock, int indeks){
        this.nama = nama;
        this.harga = harga;
        this.stock = stock;
        this.indeks= indeks;
    }

    public void tambahStock(int stock){
        this.stock += stock;
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

    public void setharga(int harga){
        this.harga = harga;
    }
}
