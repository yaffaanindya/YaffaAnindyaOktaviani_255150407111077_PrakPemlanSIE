import java.util.LinkedList;
import java.util.Scanner;

public class Antrian {
    public static void main(String[] args) {
        // Kita gunakan tipe LinkedList secara spesifik agar bisa akses fungsi addFirst
        LinkedList<String> queue = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        
        while (true) {
            System.out.println("\nMenu Antrian Pelanggan:");
            System.out.println("1. Tambah Pelanggan");
            System.out.println("2. Layani Pelanggan");
            System.out.println("3. Lihat Antrian Terdepan");
            System.out.println("4. Keluar");
            System.out.print("Pilih (1-4): ");
            
            try {
                int choice = sc.nextInt();
                sc.nextLine(); 
                
                switch (choice) {
                    case 1:
                        System.out.print("Masukan Nama Pelanggan: ");
                        String name = sc.nextLine();
                        
                        // budi
                        if (name.equalsIgnoreCase("Budi")) {
                            queue.addFirst(name); // Langsung ke urutan paling depan
                            System.out.println("Budi masuk jalur prioritas ke posisi paling depan!");
                        } else {
                            queue.addLast(name);  // Masuk ke urutan paling belakang (normal)
                            System.out.println(name + " ditambahkan ke antrian.");
                        }
                        break;
                        
                    case 2:
                        if (queue.isEmpty()) {
                            System.out.println("Antrian kosong.");
                        } else {
                            String nama = queue.poll(); // Mengambil dari yang paling depan
                            System.out.println("Melayani pelanggan : " + nama);
                        }
                        break;
                        
                    case 3:
                        if (queue.isEmpty()) {
                            System.out.println("Tidak ada antrian.");
                        } else {
                            System.out.println("Elemen paling depan: " + queue.peek());
                            System.out.println("Total Antrian: " + queue);
                        }
                        break;
                        
                    case 4:
                        System.out.println("Keluar.");
                        sc.close();
                        return;
                }
            } catch (Exception e) {
                System.out.println("Invalid input.");
                sc.nextLine();
            }
        }
    }
}