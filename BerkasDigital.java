
package sipusta;

public class BerkasDigital extends Koleksi {

    private double ukuranMB;
    private String tautanUnduh;

    public BerkasDigital(String kodeKoleksi, String judul,
                         int tahunTerbit, double ukuranMB,
                         String tautanUnduh) {

        super(kodeKoleksi, judul, tahunTerbit);
        this.ukuranMB = ukuranMB;
        this.tautanUnduh = tautanUnduh;
    }

    @Override
    public boolean isLayakDipinjam() {
        return true;
    }

    @Override
    public String getJenisKoleksi() {
        return "Berkas Digital";
    }

    public double getUkuranMB() {
        return ukuranMB;
    }

    public String getTautanUnduh() {
        return tautanUnduh;
    }
}
