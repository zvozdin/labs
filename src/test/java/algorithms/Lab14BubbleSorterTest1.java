package algorithms;

import java.util.Arrays;

public class Lab14BubbleSorterTest1 {
    public static void main(String[] args) {
        int[] array = {5, 4, 3, 2, 1};
        Lab14BubbleSorter.sort(array);
        int[] expected = {1, 2, 3, 4, 5};
        if (Arrays.equals(array, expected)) {
            System.out.println("OK");
        } else {
            System.out.println("FAIL");
        }
    }
}
