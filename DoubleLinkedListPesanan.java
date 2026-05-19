package CM;

public class DoubleLinkedListPesanan {
    NodePesanan head, tail;

    public boolean isEmpty() {
        return head == null;
    }

    // Menambah data pesanan setelah antrian dihapus/dipanggil
    public void tambahPesanan(Pesanan p) {
        if (isEmpty()) {
            head = tail = new NodePesanan(null, p, null);
        } else {
            NodePesanan newNode = new NodePesanan(tail, p, null);
            tail.next = newNode;
            tail = newNode;
        }
    }

    // Sorting Manual (Bubble Sort) berdasarkan Nama Pesanan secara Ascending (A-Z)
    public void sortPesanan() {
        if (isEmpty() || head.next == null) {
            return; // Tidak perlu disort jika kosong atau hanya 1 pesanan
        }
        boolean swapped;
        do {
            swapped = false;
            NodePesanan current = head;
            while (current.next != null) {
                // Membandingkan nama pesanan saat ini dengan nama pesanan selanjutnya
                if (current.pesanan.namaPesanan.compareToIgnoreCase(current.next.pesanan.namaPesanan) > 0) {
                    // Tukar (Swap) objek pesanan di dalam node
                    Pesanan temp = current.pesanan;
                    current.pesanan = current.next.pesanan;
                    current.next.pesanan = temp;
                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);
    }

    // Fitur 4: Laporan Pesanan dan Hitung Total Pendapatan
    public void laporanPesanan() {
        System.out.println("=============================================");
        System.out.println("LAPORAN PESANAN (URUT NAMA PESANAN)");
        System.out.println("=============================================");
        if (isEmpty()) {
            System.out.println("Belum ada pesanan masuk.");
            return;
        }

        sortPesanan(); // Panggil fungsi sorting manual sebelum dicetak

        System.out.printf("%-15s %-20s %-15s\n", "Kode Pesanan", "Nama Pesanan", "Harga");
        NodePesanan current = head;
        int totalPendapatan = 0;
        
        while (current != null) {
            System.out.printf("%-15d %-20s %-15d\n", current.pesanan.kodePesanan, current.pesanan.namaPesanan, current.pesanan.harga);
            totalPendapatan += current.pesanan.harga; // Kalkulasi total pendapatan
            current = current.next;
        }
        System.out.println("=============================================");
        System.out.println("TOTAL PENDAPATAN: Rp " + totalPendapatan);
    }
}
