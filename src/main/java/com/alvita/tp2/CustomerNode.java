package com.alvita.tp2;

// node untuk menyimpan data customer/transaksi
public class CustomerNode {
    String kode;   // nomor antrian
    String nama;
    long total;    // total belanja
    CustomerNode next;

    public CustomerNode(String kode, String nama, long total) {
        this.kode = kode;
        this.nama = nama;
        this.total = total;
        this.next = null;
    }
}
