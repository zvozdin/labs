package collections;

public interface MyList {
    //Iterable
//    MyIterator iterator();

    //Collection
    int size();
    boolean isEmpty();
    boolean contains(Object o);
//    Object[] toArray();
//    Object[] toArray(Object[] a);
    boolean add(Object e);
    boolean remove(Object o);
//    boolean containsAll(Object c);
//    boolean addAll(Object c);
//    boolean removeAll(Object c);
//    boolean retainAll(Object c);
    void clear();
//    boolean equals(Object o);
//    int hashCode();

    //List
//    boolean addAll(int index, Object c);
    Object get(int index);
    Object set(int index, Object element);
    void add(int index, Object element);
    Object remove(int index);
    int indexOf(Object o);
//    int lastIndexOf(Object o);
//    Object subList(int fromIndex, int toIndex);

    //ListIterator<E> listIterator();
}
