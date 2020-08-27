package algorithms;

public class WhiteCrow {

    public static final int ERROR_CODE = -1;

    public static int find(int[] array) {
        for (int index = 0; index < array.length; index++) {
            if (!found(index, array)) {
                return index;
            }
        }
        return ERROR_CODE;
    }

    private static boolean found(int givenNumber, int[] source) {
        for (int index = 0; index < source.length; index++) {
            if (givenNumber == index) {
                continue;
            }
            if (source[index] == source[givenNumber]) {
                return true;
            }
        }
        return false;
    }
}
