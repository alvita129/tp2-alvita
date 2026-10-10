package com.alvita.tp2;

// queue pelanggan berbasis linked list, maks 5
public class Queue {
    public static final int MAX = 5;
    private CustomerNode front, rear;
    private int size;

    public boolean isEmpty() { return front == null; }
    public boolean isFull()  { return size >= MAX; }
    public int getSize()     { return size; }

    // enqueue: tambah pelanggan di belakang antrian
    public void enqueue(String kode, String nama, long total) {
        CustomerNode baru = new CustomerNode(kode, nama, total);
        if (rear == null) front = rear = baru;
        else { rear.next = baru; rear = baru; }
        size++;
    }

    // dequeue: ambil pelanggan paling depan, return null jika kosong
    public CustomerNode dequeue() {
        if (front == null) return null;
        CustomerNode out = front;
        front = front.next;
        if (front == null) rear = null;
        out.next = null;
        size--;
        return out;
    }

    // cek apakah nomor antrian sudah ada
    public boolean contains(String kode) {
        for (CustomerNode c = front; c != null; c = c.next)
            if (c.kode.equalsIgnoreCase(kode)) return true;
        return false;
    }

    // tampilkan antrian dari depan ke belakang
    public void display() {
        if (isEmpty()) { System.out.println("Antrian kosong."); return; }
        System.out.println("Antrian saat ini:");
        int no = 1;
        for (CustomerNode c = front; c != null; c = c.next, no++)
            System.out.println(no + ". " + c.kode + " │ " + c.nama + " │ Rp" + c.total);
        System.out.println("Jumlah antrian: " + size + "/" + MAX);
    }
}
