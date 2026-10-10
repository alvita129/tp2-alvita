package com.alvita.tp2;

// single linked list untuk daftar buku perpustakaan
public class BookLinkedList {
    private BookNode head;
    private int size;

    public static final int MIN_BUKU = 5;

    public void tambahBuku(String kode, String judul, String penulis) {
        BookNode baru = new BookNode(kode, judul, penulis);
        if (head == null) {
            head = baru;
        } else {
            BookNode cur = head;
            while (cur.next != null) cur = cur.next; // cari node terakhir
            cur.next = baru;
        }
        size++;
    }

    // hapus buku terakhir, return null jika daftar kosong
    public BookNode hapusBukuTerakhir() {
        if (head == null) return null;
        BookNode removed;
        if (head.next == null) { // hanya satu node
            removed = head;
            head = null;
        } else {
            BookNode cur = head;
            while (cur.next.next != null) cur = cur.next; // berhenti di node sebelum terakhir
            removed = cur.next;
            cur.next = null;
        }
        size--;
        return removed;
    }

    // cari buku berdasarkan kode, return null jika tidak ada
    public BookNode cariBuku(String kode) {
        BookNode cur = head;
        while (cur != null) {
            if (cur.kodeBuku.equalsIgnoreCase(kode)) return cur;
            cur = cur.next;
        }
        return null;
    }

    // tampilkan semua buku sesuai urutan input beserta totalnya
    public void tampilkanSemua() {
        if (head == null) {
            System.out.println("Daftar buku masih kosong.");
            return;
        }
        System.out.println("Daftar Buku:");
        BookNode cur = head;
        while (cur != null) {
            tampilkanDetail(cur);
            cur = cur.next;
        }
        System.out.println("Total Buku: " + size);
    }

    public static void tampilkanDetail(BookNode b) {
        System.out.println("Kode: " + b.kodeBuku + " │ Judul: " + b.judul + " │ Penulis: " + b.penulis);
    }

    public int getSize() { return size; }
}
