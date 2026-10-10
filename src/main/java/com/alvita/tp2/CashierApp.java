package com.alvita.tp2;

import java.util.Scanner;

// pogram stack & queue: sistem kasir toko
public class CashierApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue antrian = new Queue();
        Stack riwayat = new Stack();
        int pilihan = 0;

        do {
            System.out.println("\n=== SISTEM KASIR TOKO ===");
            System.out.println("1. Tambah Antrian");
            System.out.println("2. Layani Pelanggan");
            System.out.println("3. Tampilkan Antrian");
            System.out.println("4. Lihat Riwayat Transaksi");
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
                case 1: // Enqueue
                    if (antrian.isFull()) {
                        System.out.println("Antrian penuh (maksimal " + Queue.MAX + " pelanggan)!");
                        break;
                    }
                    String kode;
                    while (true) {
                        System.out.print("Masukkan Nomor Antrian: ");
                        kode = sc.nextLine().trim();
                        if (kode.isEmpty()) System.out.println("Nomor antrian wajib diisi!");
                        else if (antrian.contains(kode)) System.out.println("Nomor antrian sudah ada!");
                        else break;
                    }
                    System.out.print("Masukkan Nama Pelanggan: ");
                    String nama = sc.nextLine().trim();
                    long total;
                    while (true) {
                        System.out.print("Masukkan Total Belanja: ");
                        try {
                            total = Long.parseLong(sc.nextLine().trim());
                            if (total >= 0) break;
                        } catch (NumberFormatException e) { /* ulangi input */ }
                        System.out.println("Total belanja harus berupa angka positif!");
                    }
                    antrian.enqueue(kode, nama, total);
                    System.out.println("Data pelanggan ditambahkan ke antrian!");
                    break;

                case 2: // dequeue + push ke stack
                    CustomerNode dilayani = antrian.dequeue();
                    if (dilayani == null) {
                        System.out.println("Tidak ada pelanggan dalam antrian.");
                    } else {
                        System.out.println("Melayani pelanggan " + dilayani.kode + " (" + dilayani.nama + ")");
                        riwayat.push(dilayani);
                        System.out.println("Transaksi disimpan ke riwayat.");
                    }
                    break;

                case 3:
                    antrian.display();
                    break;

                case 4:
                    riwayat.display();
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
