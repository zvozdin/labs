package collections;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList_2<E> implements Iterable {

    private int size = 0;
    private Node<E> first;
    private Node<E> last;

    public MyLinkedList_2() {
        first = new Node(null, null, last);
        last = new Node(first, null, null);
    }

    private static class Node<E> {

        Node<E> next;
        Node<E> prev;
        E item;
        public Node(Node<E> prev, E element, Node<E> next) {
            this.next = next;
            this.prev = prev;
            this.item = element;
        }

    }

    public boolean addLast(E e) {
        Node<E> current = last;
        last = new Node<>(current, e, null);
        if (current == null) {
            first = last;
        } else {
            current.next = last;
        }
        size++;
        return true;
    }

    public boolean addFirst(E e) {
        Node<E> current = first;
        last = new Node<>(null, e, current);
        if (current == null) {
            last = first;
        } else {
            current.prev = first;
        }
        size++;
        return true;
    }

    public void add(int index, E e) {
        if (index == size) {
            addLast(e);
        } else {
            Node node = getNode(index);
            Node pred = node.prev;
            Node<E> newNoda = new Node<E>(pred, e, node);
            node.prev = newNoda;
            if (pred == null) {
                first = newNoda;
            } else {
                pred.next = newNoda;
            }
        }
        size++;
    }

    private Node getNode(int index) {
        if (index < (size >> 1)) {
            Node x = first;
            for (int i = 0; i < index; i++) {
                x = x.next;
            }
            return x;
        } else {
            Node x = last;
            for (int i = size - 1; i > index; i--) {
                x = x.prev;
            }
            return x;
        }
    }

    public int size() {
        return size;
    }

    public E removeFirst() {
        if (first == null) {
            throw new NoSuchElementException();
        }

        E element = first.item;

        Node<E> next = first.next;
        first.item = null;
        first.next = null;
        first = next;
        if (next == null) {
            last = null;
        } else {
            next.prev = null;
        }
        size--;

        return element;
    }

    public E removeLast() {
        if (last == null) {
            throw new NoSuchElementException();
        }

        E element = last.item;

        Node<E> prev = last.prev;
        last.item = null;
        last.prev = null;
        last = prev;
        if (prev == null) {
            first = null;
        } else {
            prev.next = null;
        }
        size--;

        return element;
    }

    public E remove(E e) {
        Node<E> delete = findNode(e);

        Node<E> prev = delete.prev;
        Node<E> next = delete.next;


        if (prev == null) {
            first = next;
        } else {
            next.prev = prev;
        }

        if (next == null) {
            last = prev;
        } else {
            prev.next = next;
        }

        delete.prev = null;
        delete.next = null;
        delete.item = null;
        size--;

        return e;
    }

    private Node findNode(Object o) {
        if (o == null) {
            for (Node<E> x = first; x != null; x = x.next) {
                if (x.item == null) {
                    return x;
                }
            }
        } else {
            for (Node<E> x = first; x != null; x = x.next) {
                if (o.equals(x.item)) {
                    return x;
                }
            }
        }
        return null;
    }

    public int indexOf(Object o) {
        int index = 0;
        if (o == null) {
            for (Node<E> x = first; x != null; x = x.next) {
                if (x.item == null) {
                    return index;
                }
                index++;
            }
        } else {
            for (Node<E> x = first; x != null; x = x.next) {
                if (o.equals(x.item)) {
                    return index;
                }
                index++;
            }
        }
        return -1;
    }

    public E set(int index, E o) {
        Node old = getNode(index);
        E item = (E) old.item;
        old.item = o;
        return item;
    }

    public void clear() {
        for (Node<E> x = first; x != null; ) {
            Node<E> next = x.next;
            x.item = null;
            x.next = null;
            x.prev = null;
            x = next;
        }

        first = last = null;
        size = 0;
    }

    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }

    public Object[] toArray(Object[] a) {
        Object[] result = new Object[size];
        int i = 0;
        for (Node<E> x = first; x != null; x = x.next) {
            result[i++] = x.item;
        }
        return result;
    }

    @Override
    public Iterator iterator() {
        return new MyLinkedList_2_Iterator();
    }

    private class MyLinkedList_2_Iterator implements Iterator {

        Node<E> next;
        Node<E> returned;
        int nextIndex;

        public MyLinkedList_2_Iterator() {
            nextIndex = 0;
            next = getNode(nextIndex);
        }

        @Override
        public boolean hasNext() {
            return nextIndex < size;

        }

        @Override
        public Object next() {
            returned = next;
            next = next.next;
            nextIndex++;
            return returned.item;
        }
    }
}
