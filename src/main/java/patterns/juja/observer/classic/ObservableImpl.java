package patterns.juja.observer.classic;

import java.util.ArrayList;
import java.util.List;

public class ObservableImpl implements Observable {

    private List<Observer> list;

    public ObservableImpl() {
        this.list = new ArrayList<>();
    }

    @Override
    public void addObserver(Observer observer) {
        list.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        list.remove(observer);
    }

    @Override
    public void notifyObservers(Object input) {
        list.stream().forEach(observer -> observer.update(input));
    }
}