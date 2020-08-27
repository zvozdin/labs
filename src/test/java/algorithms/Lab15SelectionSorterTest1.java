package algorithms;

import java.util.Arrays;

public class Lab15SelectionSorterTest1 {
    public static void main(String[] args) {
        long start = System.nanoTime();
        int[] array = {4, 5, 3, 2, 1};
        Lab16InsertionSorter.sort(array);
        int[] expected = {1, 2, 3, 4, 5};
        if (Arrays.equals(array, expected)) {
            System.out.println("OK");
        } else {
            System.out.println("FAIL");
        }
        System.out.println((System.nanoTime() - start) / 1_000 + " ms");


    }
}
