package patterns.juja.strategy;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        BubbleSorter sorter = new BubbleSorter(new FirstLetterComparator());
        Object[] words = {"a", "fdsfd", "d", "dc", "e", "sdfdsfgd", "sdf"};
        Object[] numbers = {1, 21, 123, 1234, 4, 6, 65};

        System.out.println(Arrays.toString(sorter.sort(words)));
        System.out.println(Arrays.toString(sorter.sort(numbers)));

        BubbleSorter sorter1 = new BubbleSorter(
                (o1, o2) -> o1.toString().length() < o2.toString().length());

        System.out.println(Arrays.toString(sorter1.sort(numbers)));
    }
}