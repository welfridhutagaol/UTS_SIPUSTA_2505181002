
package sipusta;

import java.util.Comparator;

public class UrutLayakLaluJudul
        implements Comparator<Koleksi> {

    @Override
    public int compare(Koleksi k1, Koleksi k2) {

        int hasilStatus = Boolean.compare(
            k2.isLayakDipinjam(),
            k1.isLayakDipinjam()
        );

        if (hasilStatus != 0) {
            return hasilStatus;
        }

        return k1.getJudul().compareToIgnoreCase(
            k2.getJudul()
        );
    }
}
