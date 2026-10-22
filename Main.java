
package sipusta;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        // 1. Membuat katalog
        KatalogPerpustakaan katalog = new KatalogPerpustakaan();

        // 2. Membuat enam koleksi sesuai data uji soal

        BukuCetak buku1 = new BukuCetak(
                "BK-001",
                "Java How to Program",
                2022,
                620,
                "A-12",
                "Lantai 1",
                false
        );

        BukuCetak buku2 = new BukuCetak(
                "BK-002",
                "Basis Data Relasional",
                2021,
                410,
                "B-04",
                "Lantai 1",
                true
        );

        Majalah majalah1 = new Majalah(
                "MJ-001",
                "Info Teknologi Edisi 88",
                2026,
                "Edisi 88",
                "Agustus",
                "C-01",
                "Lantai 2",
                true
        );

        Majalah majalah2 = new Majalah(
                "MJ-002",
                "Info Teknologi Edisi 87",
                2026,
                "Edisi 87",
                "Juli",
                "C-02",
                "Lantai 2",
                false
        );

        BerkasDigital digital1 = new BerkasDigital(
                "BD-001",
                "Panduan Pemrograman Java",
                2024,
                15.0,
                "unduh.polmed.ac.id/bd001"
        );

        BerkasDigital digital2 = new BerkasDigital(
                "BD-002",
                "Jurnal Rekayasa Perangkat",
                2025,
                8.0,
                "unduh.polmed.ac.id/bd002"
        );

        // 3. Memasukkan semua koleksi ke katalog
        katalog.tambahKoleksi(buku1);
        katalog.tambahKoleksi(buku2);
        katalog.tambahKoleksi(majalah1);
        katalog.tambahKoleksi(majalah2);
        katalog.tambahKoleksi(digital1);
        katalog.tambahKoleksi(digital2);

        // 4. Menampilkan katalog awal
        System.out.println("=== KATALOG SEBELUM DIURUTKAN ===");
        katalog.tampilkanKatalog();

        // 5. Mengurutkan katalog
        katalog.urutkanKatalog();

        System.out.println("\n=== KATALOG SETELAH DIURUTKAN ===");
        katalog.tampilkanKatalog();

        // 6. Menguji interface dan default method
        System.out.println("\n=== INFORMASI ARSIP ===");
        System.out.println("Nomor rak: " + buku1.nomorRak());
        System.out.println("Lokasi lantai: " + buku1.lokasiLantai());
        System.out.println("Ringkasan: " + buku1.ringkasanArsip());

        System.out.println("Nomor rak: " + majalah2.nomorRak());
        System.out.println("Lokasi lantai: " + majalah2.lokasiLantai());

        // 7. Menguji exception peminjaman
        System.out.println("\n=== PENGUJIAN PEMINJAMAN ===");

        try {
            katalog.pinjamKoleksi("BK-001");
            katalog.pinjamKoleksi("BK-001");
        } catch (PustakaException ex) {
            System.out.println("Kesalahan: " + ex.getMessage());
        }

        try {
            katalog.pinjamKoleksi("BK-002");
        } catch (PustakaException ex) {
            System.out.println("Kesalahan: " + ex.getMessage());
        }

        try {
            katalog.pinjamKoleksi("MJ-001");
        } catch (PustakaException ex) {
            System.out.println("Kesalahan: " + ex.getMessage());
        }

        try {
            katalog.pinjamKoleksi("KODE-999");
        } catch (PustakaException ex) {
            System.out.println("Kesalahan: " + ex.getMessage());
        }

        // 8. Mengekspor seluruh katalog ke katalog.txt
        try {
            EksporKatalog.ekspor(katalog.getDaftarKoleksi());
            System.out.println("Ekspor selesai.");
        } catch (IOException ex) {
            System.out.println(
                    "Gagal mengekspor: " + ex.getMessage()
            );
        }
    }
}
