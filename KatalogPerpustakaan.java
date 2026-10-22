
package sipusta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KatalogPerpustakaan {

    private List<Koleksi> daftarKoleksi;

    public KatalogPerpustakaan() {
        daftarKoleksi = new ArrayList<>();
    }

    public void tambahKoleksi(Koleksi koleksi) {
        daftarKoleksi.add(koleksi);
    }

    public List<Koleksi> getDaftarKoleksi() {
        return daftarKoleksi;
    }

    public void tampilkanKatalog() {
        System.out.println("==================================");
        System.out.println("     KATALOG PERPUSTAKAAN");
        System.out.println("==================================");

        for (Koleksi koleksi : daftarKoleksi) {
            koleksi.tampilkanInfo();
            System.out.println("----------------------------------");
        }
    }

    public void urutkanKatalog() {
        Collections.sort(
                daftarKoleksi,
                new UrutLayakLaluJudul()
        );
    }

    // Method untuk proses peminjaman
    public void pinjamKoleksi(String kodeKoleksi)
            throws PustakaException {

        for (Koleksi koleksi : daftarKoleksi) {

            if (koleksi.getKodeKoleksi().equals(kodeKoleksi)) {

                if (koleksi.isSedangDipinjam()) {
                    throw new KoleksiSedangDipinjamException(
                            "Koleksi sedang dipinjam!"
                    );
                }

                if (!koleksi.isLayakDipinjam()) {
                    throw new KoleksiTidakLayakException(
                            "Koleksi tidak layak dipinjam!"
                    );
                }

                koleksi.setSedangDipinjam(true);

                System.out.println(
                        "Berhasil meminjam: " + koleksi.getJudul()
                );
                return;
            }
        }

        throw new PustakaException(
                "Kode koleksi tidak ditemukan: " + kodeKoleksi
        );
    }
}
