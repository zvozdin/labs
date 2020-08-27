package patterns.juja.observer.classic;

public class ObserverImplA implements Observer {

    @Override
    public void update(Object input) {
        System.out.println("A ==> " + input);
    }
}
