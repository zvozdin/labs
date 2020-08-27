package algorithms;

import java.util.Arrays;

public class Lab14BubbleSorter {
    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = arr.length - 1; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = tmp;
                }
                System.out.println(Arrays.toString(arr));
            }
        }
    }
}
