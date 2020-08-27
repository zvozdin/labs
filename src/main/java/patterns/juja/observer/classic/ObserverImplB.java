package patterns.juja.observer.classic;

public class ObserverImplB implements Observer {

    @Override
    public void update(Object input) {
        System.out.println("B ==> " + input);
    }
}