
package sipusta;

public abstract class Koleksi {
    protected String kodeKoleksi;
    protected String judul;
    protected int tahunTerbit;
     // TAMBAHKAN DI SINI
    protected boolean sedangDipinjam = false;

    public Koleksi(String kodeKoleksi, String judul, int tahunTerbit) {
        this.kodeKoleksi = kodeKoleksi;
        this.judul = judul;
        this.tahunTerbit = tahunTerbit;
    }

    public String getKodeKoleksi() {
        return kodeKoleksi;
    }

    public String getJudul() {
        return judul;
    }

    public int getTahunTerbit() {
        return tahunTerbit;
    }

    public abstract boolean isLayakDipinjam();

    public abstract String getJenisKoleksi();

    public void tampilkanInfo() {
        System.out.println("Kode   : " + kodeKoleksi);
        System.out.println("Judul  : " + judul);
        System.out.println("Tahun  : " + tahunTerbit);
        System.out.println("Jenis  : " + getJenisKoleksi());
        System.out.println("Status : "
                + (isLayakDipinjam()
                ? "Layak dipinjam"
                : "Tidak layak dipinjam"));
    }
    public boolean isSedangDipinjam() {
    return sedangDipinjam;
}

public void setSedangDipinjam(boolean sedangDipinjam) {
    this.sedangDipinjam = sedangDipinjam;
}
}
