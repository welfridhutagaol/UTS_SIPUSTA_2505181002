
package sipusta;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class EksporKatalog {

    public static void ekspor(List<Koleksi> daftarKoleksi)
            throws IOException {

        Path lokasiFile = Paths.get(
        System.getProperty("user.dir"),
        "katalog.txt"
);

System.out.println("Lokasi file: " + lokasiFile.toAbsolutePath());

        try (BufferedWriter writer =
                Files.newBufferedWriter(lokasiFile)) {

            writer.write("KATALOG PERPUSTAKAAN SIPUSTA");
            writer.newLine();
            writer.write("----------------------------------------");
            writer.newLine();

            for (Koleksi koleksi : daftarKoleksi) {
                writer.write(
                    koleksi.getKodeKoleksi() + " | "
                    + koleksi.getJudul() + " | "
                    + koleksi.getTahunTerbit() + " | "
                    + koleksi.getJenisKoleksi() + " | "
                    + (koleksi.isLayakDipinjam()
                        ? "Layak dipinjam"
                        : "Tidak layak dipinjam")
                );

                writer.newLine();
            }
        }

        System.out.println("Katalog berhasil diekspor ke katalog.txt");
    }
}
