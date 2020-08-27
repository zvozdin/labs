package collections;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public abstract class MyListTest {

    MyList list;
    public abstract MyList getList();

    @Before
    public void setup() {
        list = getList();
    }


    @Test
    public void testRemoveByObject() {

        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
//        then
        list.remove("4");
        assertEquals("[1, 2, 3, 5]", list.toString());
    }

    @Test
    public void testRemoveByIndex() {
//        given
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");  //3
        list.add("5");
//        when
        list.remove(3);
//        then
        assertEquals("[1, 2, 3, 5]", list.toString());
    }

    @Test
    public void testRemoveByIndexFormStart() {
//        given
        list.add("1"); //0
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
//        when
        list.remove(0);
//        then
        assertEquals("[2, 3, 4, 5]", list.toString());
    }

    @Test
    public void testRemoveByIndexFormEnd() {
//        given
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5"); //end
//        when
        list.remove(list.size() - 1);
//        then
        assertEquals("[1, 2, 3, 4]", list.toString());
    }

    @Test
    public void testRemoveNotExist() {
//        given
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5"); //end
//        when
        list.remove("6");
//        then
        assertEquals("[1, 2, 3, 4, 5]", list.toString());
    }


    @Test
    public void testSizeFromNotEmpty() {
//        given
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
//        when
        int size = list.size();
//        then
        assertEquals(5, size);
    }

    @Test
    public void testSizeFromEmpty() {
//        given
//        when
        int size = list.size();
        assertEquals(0, size);
    }

    @Test
    public void testIsEmpty() {
//        given
//        when
        assertTrue(list.isEmpty());
    }
}

