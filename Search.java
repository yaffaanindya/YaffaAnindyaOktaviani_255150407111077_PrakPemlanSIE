import java.util.Arrays;
import java.util.Random;

public class Search {

    public static int linearSearch(int[] arr, int search) {
        // Deklarasi variabel check
        int check = 0;

        for (int i = 0; i < arr.length; i++) {
            // Mencatat jumlah pemeriksaan
            check++;

            if (arr[i] == search) {
                // Menampilkan jumlah pemeriksaan
                System.out.println("Jumlah pemeriksaan Linear Search: " + check);

                return i;
            }
        }
        System.out.println("Jumlah pemeriksaan Linear Search: " + check);
        return -1;
    }

    public static int binarySearch(int[] arr, int search) {

        // Deklarasi variabel check
        int check = 0;
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            // Mencatat jumlah pemeriksaan
            check++;

            int mid = low + (high - low) / 2;

            if (arr[mid] == search) {
                // Menampilkan jumlah pemeriksaan
                System.out.println("Jumlah pemeriksaan Binary Search: " + check);

                return mid;
            }

            if (arr[mid] < search)
                low = mid + 1;
            else
                high = mid - 1;
        }
        System.out.println("Jumlah pemeriksaan Binary Search: " + check);
        return -1;
    }

    public static void main(String[] args) {

        int[] arr = new int[30];
        Random random = new Random();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100) + 1;
        }

        // Memastikan ada nilai 88 di dalam array
        arr[random.nextInt(30)] = 88;

        Arrays.sort(arr);

        System.out.println("Isi Array:");
        System.out.println(Arrays.toString(arr));

        // linear search
        int hasilLinear = linearSearch(arr, 88);
        System.out.println("\nHasil Linear Search:");
        System.out.println("Nilai 88 ditemukan pada index: " + hasilLinear);

        // pencarian yang tidak ada (linear search)
        int hasilTidakAda = linearSearch(arr, 101);
        System.out.println("\nPencarian Nilai yang Tidak Ada:");
        System.out.println("Hasil pencarian index: " + hasilTidakAda);

        // binary search
        int hasilBinary = binarySearch(arr, 88);
        System.out.println("\nHasil Binary Search:");
        System.out.println("Nilai 88 ditemukan pada index: " + hasilBinary);

        // pencarian yang tidak ada (binary search)
        int hasilTidakAdaBinary = binarySearch(arr, 101);
        System.out.println("\nPencarian Binary Search Nilai yang Tidak Ada:");
        System.out.println("Hasil pencarian index: " + hasilTidakAdaBinary);
    }
}