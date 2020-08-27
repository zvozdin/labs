package patterns.juja.observer.classic;

public class Main {

    public static void main(String[] args) {
        Observable observable = new ObservableImpl();
        observable.addObserver(new ObserverImplA());
        observable.addObserver(new ObserverImplB());

        observable.notifyObservers("Hello");
    }
}