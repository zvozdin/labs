package collections;

public class MyArrayListTest extends MyListTest{

    @Override
    public MyList getList() {
        return new MyArrayList();
    }
}