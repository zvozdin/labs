package patterns.head_first.strategy.duckSimulator;

public class Quack implements QuackBehavior {

    @Override
    public void quack() {
        System.out.println("Quack!!!");
    }
}