package collections;

import java.util.*;

public class MyArrayList_2 implements List {

    public static final int DEFAULT_CAPACITY = 10;
    public static final Object[] EMPTY_ELEMENTDATA = {};
    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};
    Object[] elementData;
    private int size;


    public MyArrayList_2(int capacity) {
        if (capacity > 0) {
            elementData = new Object[capacity];
        } else {
            if (capacity == 0) {
                elementData = EMPTY_ELEMENTDATA;
            } else {
                throw new IllegalArgumentException(String.valueOf(capacity));
            }
        }
    }

    public MyArrayList_2() {
        elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }

    public void trimToSize() {
        if (size < elementData.length) {
            elementData = (size == 0)
                    ? EMPTY_ELEMENTDATA
                    : Arrays.copyOf(elementData, size);

//            if (size == 0) {
//                elementData = EMPTY_ELEMENTDATA;
//            } else {
//                elementData = Arrays.copyOf(elementData, size);
//            }
        }
    }

    private void checkIndex(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public Object get(int index) {
        checkIndex(index);

        return elementData[index];
    }

    @Override
    public Object set(int index, Object element) {
        checkIndex(index);

        Object oldValue = elementData[index];
        elementData[index] = element;

        return oldValue;
    }

    @Override
    public void add(int index, Object element) {

    }

    @Override
    public Object remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        if (o == null) {
            for (int index = 0; index < size; index++) {
                if (elementData[index] == null) {
                    return index;
                }
            }
        } else {
            for (int index = 0; index < size; index++) {
                if (o.equals(elementData[index])) {
                    return index;
                }
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        if (o == null) {
            for (int index = size - 1; index >= 0; index--) {
                if (elementData[index] == null) {
                    return index;
                }
            }
        } else {
            for (int index = size - 1; index >= 0; index--) {
                if (o.equals(elementData[index])) {
                    return index;
                }
            }
        }
        return -1;
    }

    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(elementData, size);
    }

    @Override
    public boolean add(Object o) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }
}
