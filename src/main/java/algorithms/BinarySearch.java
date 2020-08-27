package algorithms;

public class BinarySearch {
    public static int binarySearch(int[] array, int x, int lowIndex, int highIndex) {
        if (lowIndex <= highIndex) {
            int midIndex = lowIndex + highIndex >>> 1;
            if (array[midIndex] < x) {
                return binarySearch(array, x, midIndex + 1, highIndex);
            } else if (array[midIndex] > x) {
                return binarySearch(array, x, lowIndex, midIndex - 1);
            } else {
                return midIndex;
            }
        } else {
            return -(lowIndex + 1);
        }
    }

    public static void main(String[] args) {
        int[] array = {0, 1, 2, 3, 4, 5};
        System.out.println(binarySearch(array, 3, 0, array.length - 1));
    }
}
