package algorithms;

import java.util.Arrays;

public class SelectSortTest1 {
    public static void main(String[] args) {
        int[] array = {5, 4, 3, 2, 1};
        int[] sortedArray = SelectSort.selectSort(array);
        int[] expectd = {1, 2, 3, 4, 5};
        if (Arrays.equals(sortedArray, expectd)) {
            System.out.println("OK");
        } else {
            System.out.println("FAIL");
        }
    }

    public static class Lab09_ArrayFilter {
        public static void main(String[] args) {
            int[] array = {4, 3, 5, 6, 7, 9};
            System.out.println(Arrays.toString(filterEven(array)));
        }

        public static int[] filterEven(int[] nums) {
            int[] arrEven = new int[nums.length];
            int k = 0;
            for (int i = 0; i < arrEven.length; i++) {
                for (int j = k; j < nums.length; j++) {
                    k++;
                    if (nums[j] % 2 == 0) {
                        arrEven[i] = nums[j];
                        break;
                    }
                }
            }

            return arrEven;
        }
    }
}
