package collections;

import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.assertEquals;

public class MyLinkedList_2Test {

    @Test
    public void test1() {
        MyLinkedList_2 list = new MyLinkedList_2();

        assertEquals(0, list.size());
    }

    @Test
    public void test2() {
        MyLinkedList_2 list = new MyLinkedList_2();
        list.addLast("1");

        Iterator iterator = list.iterator();

        while (iterator.hasNext()) {
            assertEquals("1", iterator.next());
        }
    }

    @Test
    public void test3() {
        MyLinkedList_2 list = new MyLinkedList_2();
        list.addLast("1");
        list.addLast("1");
        assertEquals(2, list.size());
    }
}