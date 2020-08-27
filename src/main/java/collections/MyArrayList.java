package collections;

import java.util.Arrays;

public class MyArrayList implements MyList {

    private Object[] array;

    public MyArrayList() {
        clear();
    }

    @Override
    public int size() {
        return array.length;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }

    @Override
    public boolean add(Object e) {
        add(size(), e);
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if (contains(o)) {
            remove(indexOf(o));
            return true;
        }
        return false;
    }

    @Override
    public void clear() {
        array = new Object[0];
    }

    @Override
    public Object get(int index) {
        return array[index];
    }

    @Override
    public Object set(int index, Object element) {
        return array[index] = element;
    }

    @Override
    public void add(int index, Object element) {
        Object[] newArray = new Object[size() + 1];
        for (int i = 0; i < index; i++) {
            newArray[i] = array[i];
        }
        newArray[index] = element;
        for (int i = index + 1; i < newArray.length; i++) {
            newArray[i] = array[index++];
        }
        array = newArray;
    }

    @Override
    public Object remove(int index) {
        Object[] newArray = new Object[size() - 1];
        for (int i = 0; i < index; i++) {
            newArray[i] = array[i];
        }
//        newArray[index] = array[index];
        Object oldObject = array[index];
        for (int i = index; i < newArray.length; i++) {
            newArray[i] = array[++index];
        }
        array = newArray;
        return oldObject;
    }

    @Override
    public int indexOf(Object o) {
        for (int index = 0; index < size(); index++) {
            Object object = get(index);
            if ((object == null && o == null) || object.equals(o)) {
                return index;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }
}
