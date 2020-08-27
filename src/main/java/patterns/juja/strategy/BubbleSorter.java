package patterns.juja.strategy;

public class BubbleSorter {

    Comparator comparator;

    public BubbleSorter(Comparator comparator) {
        this.comparator = comparator;
    }

    public Object[] sort(Object[] input) {
        Object[] result = new Object[input.length];
        for (int i = 0; i < input.length; i++) {
            result[i] = input[i];
        }

        for (int i = 0; i < result.length - 1; i++) {
            for (int j = 0; j < result.length - i - 1; j++) {
                if (comparator.compareTo(result[j], result[j + 1])) {
                    Object temp = result[j];
                    result[j] = result[j + 1];
                    result[j + 1] = temp;
                }
            }
        }

        return result;
    }
}