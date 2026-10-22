
package sipusta;

public class BukuCetak extends Koleksi implements Terasip {

    private int jumlahHalaman;
    private String rak;
    private String lantai;
    private boolean sedangDiperbaiki;

    public BukuCetak(String kodeKoleksi, String judul,
                     int tahunTerbit, int jumlahHalaman,
                     String rak, String lantai,
                     boolean sedangDiperbaiki) {

        super(kodeKoleksi, judul, tahunTerbit);
        this.jumlahHalaman = jumlahHalaman;
        this.rak = rak;
        this.lantai = lantai;
        this.sedangDiperbaiki = sedangDiperbaiki;
    }

    @Override
    public boolean isLayakDipinjam() {
        return !sedangDiperbaiki;
    }

    @Override
    public String getJenisKoleksi() {
        return "Buku Cetak";
    }

    @Override
    public String nomorRak() {
        return rak;
    }

    @Override
    public String lokasiLantai() {
        return lantai;
    }

    public int getJumlahHalaman() {
        return jumlahHalaman;
    }
}
