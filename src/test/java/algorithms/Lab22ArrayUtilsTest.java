package algorithms;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class Lab22ArrayUtilsTest {
    @Test
    public void test1_diff_sides() {
        assertArrayEquals(null, Lab22ArrayUtils.rotateClockwise(new int[][]{{1, 2}, {2, 3, 4}}));
    }

    @Test
    public void test2_row_0() {
        assertArrayEquals(null, Lab22ArrayUtils.rotateClockwise(new int[][]{{1, 2}, {2, 3, 4}}));
    }

    @Test
    public void test3_null_Array() {
     assertArrayEquals(null, Lab22ArrayUtils.rotateClockwise(null));
    }

    @Test
    public void test4_rotateArray() {
        assertArrayEquals(new int[][]{{3, 1}, {4, 2}}, Lab22ArrayUtils.rotateClockwise(new int[][]{{1, 2}, {3, 4}}));
    }
}
