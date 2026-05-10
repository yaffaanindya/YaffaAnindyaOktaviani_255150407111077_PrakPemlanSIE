import java.util.Arrays;

public class Sort {
    public static int[] bubble(int[] list) {
        int tukarAtauGeser = 0;
        for (int i = 0; i < list.length - 1; i++) {
            for (int k = i + 1; k < list.length; k++) {
                if (list[k] < list[i]) {
                    int t = list[i];
                    list[i] = list[k];
                    list[k] = t;
                    tukarAtauGeser++; // Mencatat setiap pertukaran (swap)
                }
            }
        }
        System.out.println("Jumlah tukar (Bubble Sort): " + tukarAtauGeser);
        return list;
    }

    public static int[] insertion(int[] list) {
        int tukarAtauGeser = 0;
        for (int i = 1; i < list.length; ++i) {
            int key = list[i];
            int k = i - 1;
            while (k >= 0 && list[k] > key) {
                list[k + 1] = list[k];
                k = k - 1;
                tukarAtauGeser++; // Mencatat setiap pergeseran (shift)
            }
            list[k + 1] = key;
        }
        System.out.println("Jumlah geser (Insertion Sort): " + tukarAtauGeser);
        return list;
    }

    public static int[] selection(int[] list) {
        int tukarAtauGeser = 0;
        for (int i = 0; i < list.length - 1; i++) {
            int minIndex = i;
            for (int k = i + 1; k < list.length; k++) {
                if (list[k] < list[minIndex])
                    minIndex = k;
            }
            // Swap elemen terkecil ke posisi i
            int t = list[minIndex];
            list[minIndex] = list[i];
            list[i] = t;
            tukarAtauGeser++; // Mencatat setiap pertukaran (swap)
        }
        System.out.println("Jumlah tukar (Selection Sort): " + tukarAtauGeser);
        return list;
    }

    public static void main(String[] args) {
        int[] arr = {
            15, 42, 8, 91, 23, 56, 77, 4, 39, 99, 
            12, 65, 31, 48, 2, 84, 19, 50, 71, 33, 
            9, 58, 27, 80, 44, 6, 95, 17, 62, 38
        };

        System.out.println("DATA AWAL: " + Arrays.toString(arr));
        System.out.println("------------------------------------------------------------");

        bubble(arr.clone());
        insertion(arr.clone());
        selection(arr.clone());
    }
}