package patterns.head_first.strategy.duckSimulator;

public class Squeak implements QuackBehavior {

    @Override
    public void quack() {
        System.out.println("Squeak!!!");
    }
}