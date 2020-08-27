package algorithms;

import java.util.Arrays;

public class Lab22ArrayUtils {
    public static int[][] rotateClockwise(int[][] arg) {
        if (arg == null || arg.length == 0) {
            return null;
        }
        int sideMatrix = arg.length;
        for (int i = 0; i < sideMatrix; i++) {
            if (arg[i] == null || sideMatrix != arg[i].length || arg[i].length == 0) {
                return null;
            }
        }
        int[][] result = new int[sideMatrix][sideMatrix];
        for (int i = 0; i < sideMatrix; i++) {
            for (int j = 0; j < sideMatrix; j++) {
                result[i][j] = arg[sideMatrix - j - 1][i];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(rotateClockwise(new int[][] {null})));
    }
}
