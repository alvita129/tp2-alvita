package com.alvita.tp2;

// stack riwayat transaksi berbasis linked list
public class Stack {
    private CustomerNode top;
    private int size;

    public boolean isEmpty() { return top == null; }

    // push: transaksi terbaru berada di paling atas
    public void push(CustomerNode data) {
        CustomerNode baru = new CustomerNode(data.kode, data.nama, data.total);
        baru.next = top;
        top = baru;
        size++;
    }

    // tampilkan riwayat dari transaksi terbaru ke terlama
    public void display() {
        if (isEmpty()) { System.out.println("Belum ada riwayat transaksi."); return; }
        System.out.println("Riwayat Transaksi (terbaru → lama):");
        int no = 1;
        for (CustomerNode c = top; c != null; c = c.next, no++)
            System.out.println(no + ". " + c.kode + " │ " + c.nama + " │ Rp" + c.total);
        System.out.println("Total transaksi: " + size);
    }
}
