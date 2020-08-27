package algorithms;

public class Mirror {


    public void upDown(int[][] array) {
        for (int x = 0; x < array.length; x++) {
            int y1 = 0;
            int y2 = array.length - 1;

            while (y1 < y2) {
                swapY(array, x, y1, y2);
                y1++;
                y2--;
            }
        }
    }

    private void swapY(int[][] array, int x, int y1, int y2) {
        int tmp = array[y1][x];
        array[y1][x] = array[y2][x];
        array[y2][x] = tmp;
    }

    public void leftRight(int[][] array) {
        for (int y = 0; y < array.length; y++) {
            int x1 = 0;
            int x2 = array.length - 1;

            while (x1 < x2) {
                swapX(array, y, x1, x2);
                x1++;
                x2--;
            }
        }
    }

    private void swapX(int[][] array, int y, int x1, int x2) {
        int tmp = array[y][x1];
        array[y][x1] = array[y][x2];
        array[y][x2] = tmp;
    }

    public void all(int[][] array) {
        upDown(array);
        leftRight(array);
    }
}
