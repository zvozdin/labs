package algorithms;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class MirrorTest {

    @Test
    public void testUpDown_whenArraySizeIs0() {
        Mirror mirror = new Mirror();
        int[][] array = new int[0][0];

        mirror.upDown(array);

        assertEquals("", toString(array));
    }

    @Test
    public void testUpDown_whenArraySizeIs1() {
        Mirror mirror = new Mirror();
        int[][] array = new int[1][1];
        array[0][0] = 13;

        mirror.upDown(array);

        assertEquals("13\n", toString(array));
    }

    @Test
    public void testUpDown_whenArraySizeIs2() {
        Mirror mirror = new Mirror();
        int[][] array = new int[2][2];
        //12
        //34
        array[0][0] = 1;
        array[1][0] = 3;
        array[0][1] = 2;
        array[1][1] = 4;

        assertEquals(
                "12\n" +
                        "34\n", toString(array));

        mirror.upDown(array);

        assertEquals(
                "34\n" +
                        "12\n", toString(array));
    }

    @Test
    public void testUpDown_whenArraySizeIs3() {
        Mirror mirror = new Mirror();
        int[][] array = new int[3][3];
        //123
        //456
        //789
        array[0][0] = 1;
        array[1][0] = 4;
        array[2][0] = 7;
        array[0][1] = 2;
        array[1][1] = 5;
        array[2][1] = 8;
        array[0][2] = 3;
        array[1][2] = 6;
        array[2][2] = 9;

        assertEquals(
                "123\n" +
                        "456\n" +
                        "789\n", toString(array));

        mirror.upDown(array);

        assertEquals(
                "789\n" +
                        "456\n" +
                        "123\n", toString(array));
    }

    @Test
    public void testLeftRight_whenArraySizeIs2() {
        Mirror mirror = new Mirror();
        int[][] array = new int[2][2];
        //12
        //34
        array[0] = new int[]{1, 2};
        array[1] = new int[]{3, 4};

        assertEquals(
                "12\n" +
                        "34\n", toString(array));

        mirror.leftRight(array);

        assertEquals(
                "21\n" +
                        "43\n", toString(array));
    }

    @Test
    public void testLeftRight_whenArraySizeIs3() {
        Mirror mirror = new Mirror();
        int[][] array = new int[3][3];
        //123
        //456
        //789
        array[0] = new int[]{1, 2, 3};
        array[1] = new int[]{4, 5, 6};
        array[2] = new int[]{7, 8, 9};

        assertEquals(
                "123\n" +
                        "456\n" +
                        "789\n", toString(array));

        mirror.leftRight(array);

        assertEquals(
                "321\n" +
                        "654\n" +
                        "987\n", toString(array));
    }

    @Test
    public void testAll_whenArraySizeIs2() {
        Mirror mirror = new Mirror();
        int[][] array = new int[2][2];
        //12
        //34
        array[0] = new int[]{1, 2};
        array[1] = new int[]{3, 4};

        assertEquals(
                "12\n" +
                        "34\n", toString(array));

        mirror.all(array);

        assertEquals(
                "43\n" +
                        "21\n", toString(array));
    }

    @Test
    public void testAll_whenArraySizeIs3() {
        Mirror mirror = new Mirror();
        int[][] array = new int[3][3];
        //123
        //456
        //789
        array[0] = new int[]{1, 2, 3};
        array[1] = new int[]{4, 5, 6};
        array[2] = new int[]{7, 8, 9};

        assertEquals(
                "123\n" +
                        "456\n" +
                        "789\n", toString(array));

        mirror.all(array);

        assertEquals(
                "987\n" +
                        "654\n" +
                        "321\n", toString(array));
    }

    private String toString(int[][] array) {
        String result = "";

        int size = array.length;

        for (int y = 0; y < size; y++) {
            int[] colon = array[y];
            if (colon.length != size) {
                fail("Size is not area");
            }
            for (int x = 0; x < size; x++) {
                result += array[y][x];
            }
            result += "\n";
        }

        return result;
    }
}
