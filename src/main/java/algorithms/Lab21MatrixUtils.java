package algorithms;

public class Lab21MatrixUtils {
    public static int[][] mul(int[][] fst, int[][] snd) {
        int firstRow = fst.length;//3
        int firstCol = fst[0].length;//3
        int secondRow = snd.length;
        int secondCol = snd[0].length;//3
        int[][] result = new int[firstRow][secondCol];

        if (fst == null || snd == null) {
            throw new IllegalArgumentException();
        }

        if (fst[0].length != snd.length) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < firstRow; i++) {
            if (fst[0].length != firstCol) {
                throw new IllegalArgumentException();
            }
        }

        for (int i = 0; i < secondRow; i++) {
            if (snd[0].length != secondCol) {
                throw new IllegalArgumentException();
            }
        }

        for (int i = 0; i < firstRow; i++) {
            for (int j = 0; j < secondCol; j++) {
                int sum = 0;
                for (int k = 0; k < firstCol; k++) {
                    sum += fst[i][k]*snd[k][j];
                }
                result[i][j] = sum;
            }
        }
        return result;
    }
}
