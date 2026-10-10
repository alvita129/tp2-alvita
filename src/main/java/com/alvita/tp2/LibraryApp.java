package com.alvita.tp2;

import java.util.Scanner;

// program linked list: sistem data buku perpustakaan
public class LibraryApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BookLinkedList daftar = new BookLinkedList();
        int pilihan = 0;

        do {
            System.out.println("\n===== SISTEM DATA BUKU =====");
            System.out.println("1. Tambah Buku");
            System.out.println("2. Hapus Buku");
            System.out.println("3. Cari Buku");
            System.out.println("4. Lihat Semua Buku");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");

            try {
                pilihan = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Input harus berupa angka 1-5!");
                pilihan = 0;
                continue;
            }

            switch (pilihan) {
                case 1: // tambah buku di akhir daftar
                    String kode;
                    while (true) {
                        System.out.print("Masukkan Kode Buku (maks 5 karakter): ");
                        kode = sc.nextLine().trim();
                        if (kode.isEmpty() || kode.length() > 5) {
                            System.out.println("Kode buku wajib diisi dan maksimal 5 karakter!");
                        } else if (daftar.cariBuku(kode) != null) {
                            System.out.println("Kode buku sudah digunakan!");
                        } else break;
                    }
                    System.out.print("Masukkan Judul: ");
                    String judul = sc.nextLine().trim();
                    System.out.print("Masukkan Penulis: ");
                    String penulis = sc.nextLine().trim();
                    daftar.tambahBuku(kode, judul, penulis);
                    System.out.println("Data berhasil ditambahkan!");
                    break;

                case 2: // hapus buku terakhir
                    BookNode dihapus = daftar.hapusBukuTerakhir();
                    if (dihapus == null) {
                        System.out.println("Tidak ada data untuk dihapus.");
                    } else {
                        System.out.println("Buku terakhir berhasil dihapus: "
                                + dihapus.kodeBuku + " - " + dihapus.judul);
                    }
                    break;

                case 3: // cari buku berdasarkan kode
                    System.out.print("Masukkan Kode Buku: ");
                    BookNode hasil = daftar.cariBuku(sc.nextLine().trim());
                    if (hasil == null) {
                        System.out.println("Buku tidak ditemukan.");
                    } else {
                        System.out.println("Buku ditemukan:");
                        BookLinkedList.tampilkanDetail(hasil);
                    }
                    break;

                case 4: // tampilkan semua buku
                    daftar.tampilkanSemua();
                    if (daftar.getSize() < BookLinkedList.MIN_BUKU) {
                        System.out.println("(Catatan: data minimal " + BookLinkedList.MIN_BUKU
                                + " buku, saat ini baru " + daftar.getSize() + ")");
                    }
                    break;

                case 5:
                    System.out.println("Terima kasih, program selesai.");
                    break;

                default:
                    System.out.println("Menu tidak valid!");
            }
        } while (pilihan != 5);

        sc.close();
    }
}
