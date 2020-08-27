package patterns.juja.strategy;

public class ObjectLengthComparator implements Comparator {

    @Override
    public boolean compareTo(Object o1, Object o2) {
        return o1.toString().length() > o2.toString().length();
    }
}