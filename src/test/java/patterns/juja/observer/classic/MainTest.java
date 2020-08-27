package patterns.juja.observer.classic;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;

public class MainTest {

    @Test
    public void testNotifyAll() {
        // given
        Observable observable = new ObservableImpl();

        Observer observerA = mock(Observer.class);
        observable.addObserver(observerA);

        Observer observerB = mock(Observer.class);
        observable.addObserver(observerB);

        // when
        observable.notifyObservers("hello");

        // then
        verify(observerA).update("hello");
        verify(observerB).update("hello");
    }

    @Test
    public void testNotifyOnlySubscribed() {
        // given
        Observable observable = new ObservableImpl();

        Observer observerA = mock(Observer.class);
        observable.addObserver(observerA);

        Observer observerB = mock(Observer.class);
        observable.addObserver(observerB);

        // when
        observable.removeObserver(observerB);
        observable.notifyObservers("hello");

        // then
        verify(observerA).update("hello");
        verifyZeroInteractions(observerB);
    }
}