package com.alvita.tp2;

// node untuk menyimpan data satu buku pada single linked List
public class BookNode {
    String kodeBuku;
    String judul;
    String penulis;
    BookNode next; // penunjuk ke node berikutnya

    public BookNode(String kodeBuku, String judul, String penulis) {
        this.kodeBuku = kodeBuku;
        this.judul = judul;
        this.penulis = penulis;
        this.next = null;
    }
}
