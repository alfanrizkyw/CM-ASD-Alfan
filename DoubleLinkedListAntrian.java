package CM;

public class DoubleLinkedListAntrian {
    NodeAntrian head, tail;
    int counterAntrian = 1; // Untuk generate nomor antrian otomatis

    public boolean isEmpty() {
        return head == null;
    }

    // Fitur 1: Tambah Antrian
    public void tambahAntrian(Pembeli p) {
        if (isEmpty()) {
            head = tail = new NodeAntrian(null, counterAntrian, p, null);
        } else {
            NodeAntrian newNode = new NodeAntrian(tail, counterAntrian, p, null);
            tail.next = newNode;
            tail = newNode;
        }
        System.out.println("Antrian berhasil ditambahkan dengan nomor: " + counterAntrian);
        counterAntrian++;
    }

    // Fitur 3 (Bagian 1): Hapus Antrian (Konsep Dequeue)
    public NodeAntrian hapusAntrian() {
        if (isEmpty()) {
            System.out.println("Antrian saat ini kosong!");
            return null;
        }
        NodeAntrian removedNode = head;
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        return removedNode; // Mengembalikan data antrian yang dipanggil
    }

    // Fitur 2: Cetak Antrian
    public void cetakAntrian() {
        System.out.println("=============================================");
        System.out.println("Daftar Antrian Pembeli");
        System.out.println("=============================================");
        if (isEmpty()) {
            System.out.println("Tidak ada antrian.");
            return;
        }
        System.out.printf("%-15s %-20s %-15s\n", "No Antrian", "Nama", "No HP");
        NodeAntrian current = head;
        while (current != null) {
            System.out.printf("%-15d %-20s %-15s\n", current.noAntrian, current.pembeli.namaPembeli, current.pembeli.NoHp);
            current = current.next;
        }
    }
}