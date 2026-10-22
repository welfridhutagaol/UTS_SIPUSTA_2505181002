
package sipusta;

public class Majalah extends Koleksi implements Terasip {

    private String edisi;
    private String bulanTerbit;
    private String rak;
    private String lantai;
    private boolean edisiTerbaru;

    public Majalah(String kodeKoleksi, String judul,
                   int tahunTerbit, String edisi,
                   String bulanTerbit, String rak,
                   String lantai, boolean edisiTerbaru) {

        super(kodeKoleksi, judul, tahunTerbit);
        this.edisi = edisi;
        this.bulanTerbit = bulanTerbit;
        this.rak = rak;
        this.lantai = lantai;
        this.edisiTerbaru = edisiTerbaru;
    }

    @Override
    public boolean isLayakDipinjam() {
        return !edisiTerbaru;
    }

    @Override
    public String getJenisKoleksi() {
        return "Majalah";
    }

    @Override
    public String nomorRak() {
        return rak;
    }

    @Override
    public String lokasiLantai() {
        return lantai;
    }

    public String getEdisi() {
        return edisi;
    }

    public String getBulanTerbit() {
        return bulanTerbit;
    }
}
