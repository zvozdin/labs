package patterns.juja.strategy;

public class FirstLetterComparator implements Comparator {

    @Override
    public boolean compareTo(Object o1, Object o2) {
        return o1.toString().charAt(0) > o2.toString().charAt(0);
    }
}