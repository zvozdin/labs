package algorithms;

import java.util.Arrays;

public class InsertSort {
    public static int[] insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int newElement = array[i];
            while (i - 1 >= 0 && array[i - 1] > newElement) {
                array[i] = array[i - 1];
                i--;
            }
            array[i] = newElement;
        }
        return array;
    }

    public static void main(String[] args) {
        int[] array = {5, 3, 1, 4, 2};
        System.out.println(Arrays.toString(insertSort(array)));
    }
}
