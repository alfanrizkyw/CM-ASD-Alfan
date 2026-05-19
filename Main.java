package CM;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DoubleLinkedListAntrian dllAntrian = new DoubleLinkedListAntrian();
        DoubleLinkedListPesanan dllPesanan = new DoubleLinkedListPesanan();
        int menu = -1;

        do {
            System.out.println("\n=============================================");
            System.out.println("SISTEM ANTRIAN ROYAL DELISH");
            System.out.println("=============================================");
            System.out.println("1. Tambah Antrian");
            System.out.println("2. Cetak Antrian");
            System.out.println("3. Hapus Antrian dan Pesan");
            System.out.println("4. Laporan Pesanan");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu : ");
            
            // Validasi input menu
            if(sc.hasNextInt()) {
                menu = sc.nextInt();
                sc.nextLine(); // clear buffer
            } else {
                System.out.println("Masukkan angka yang valid!");
                sc.nextLine();
                continue;
            }

            switch (menu) {
                case 1:
                    System.out.print("Nama Pembeli : ");
                    String nama = sc.nextLine();
                    System.out.print("No HP        : ");
                    String noHp = sc.nextLine();
                    
                    // Implementasi objek dan konstruktor
                    Pembeli pembeliBaru = new Pembeli(nama, noHp);
                    dllAntrian.tambahAntrian(pembeliBaru);
                    break;
                    
                case 2:
                    dllAntrian.cetakAntrian();
                    break;
                    
                case 3:
                    // Antrian dihapus dari list dan disimpan di variabel sementara
                    NodeAntrian antrianDiproses = dllAntrian.hapusAntrian();
                    
                    if (antrianDiproses != null) {
                        System.out.print("Kode Pesanan : ");
                        int kode = sc.nextInt();
                        sc.nextLine(); // clear buffer
                        System.out.print("Nama Pesanan : ");
                        String namaPesanan = sc.nextLine();
                        System.out.print("Harga        : ");
                        int harga = sc.nextInt();
                        sc.nextLine(); // clear buffer

                        // Implementasi objek dan konstruktor
                        Pesanan pesananBaru = new Pesanan(kode, namaPesanan, harga);
                        dllPesanan.tambahPesanan(pesananBaru);
                        
                        System.out.println(antrianDiproses.pembeli.namaPembeli + " telah memesan " + namaPesanan);
                    }
                    break;
                    
                case 4:
                    dllPesanan.laporanPesanan();
                    break;
                    
                case 0:
                    System.out.println("Keluar dari program. Terima kasih!");
                    break;
                    
                default:
                    System.out.println("Menu tidak valid. Silakan coba lagi.");
            }
        } while (menu != 0);
        
        sc.close();
    }
}
