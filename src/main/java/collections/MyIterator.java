package collections;

public interface MyIterator<T> {

    boolean hasNext();
    Object next();
    default void remove() {
        throw new UnsupportedOperationException("remove");
    }
}
