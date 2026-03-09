import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // instansiasi objek bernama m1
        Mobil m1 = new Mobil();

        System.out.print("Masukkan merk mobil m1: ");
        String merk1 = input.nextLine();

        System.out.print("Masukkan nomor polisi mobil m1: ");
        String nopol1 = input.nextLine();

        // instansiasi objek bernama m2
        Mobil m2 = new Mobil();

        System.out.print("Masukkan merk mobil m2: ");
        String merk2 = input.nextLine();

        System.out.print("Masukkan nomor polisi mobil m2: ");
        String nopol2 = input.nextLine();

        System.out.println(" ");

        m1.setKecepatan(50);
        m1.setMerk(merk1);
        m1.setNopol(nopol1);
        m1.setWarna("Merah");
        m1.display();
        System.out.println("---------------");

        m2.setKecepatan(100);
        m2.setMerk(merk2);
        m2.setNopol(nopol2);
        m2.setWarna("Biru");
        m2.display();
        System.out.println("---------------");
    }
}
