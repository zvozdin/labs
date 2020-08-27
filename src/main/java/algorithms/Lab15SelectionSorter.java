package algorithms;

public class Lab15SelectionSorter {
    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int value = arr[i];
            for (int j = arr.length - 1; j > i + 1; j--) {
                if (arr[j - 1] > arr[j]) {
                    int tmp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = tmp;
                }
            }
            if (value > arr[i + 1]) {
                int tmp = value;
                arr[i] = arr[i + 1];
                arr[i + 1] = tmp;
            }
        }
    }
}
