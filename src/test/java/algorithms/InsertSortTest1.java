package algorithms;

import java.util.Arrays;

public class InsertSortTest1 {
    public static void main(String[] args) {
        int[] array = {5, 3, 4, 2, 1};
        int[] sortedArray = InsertSort.insertSort(array);

        int[] expected = {1, 2, 3, 4, 5};
        if (Arrays.equals(expected, sortedArray)) {
            System.out.println("OK");
        } else {
            System.out.println("FAIL");
            System.out.println("Was " + sortedArray + " but expected " + expected);
        }
    }
}
