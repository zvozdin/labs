package patterns.head_first.strategy.duckSimulator;

public class HunterDuckDecoy {

    private QuackBehavior quackBehavior;

    public HunterDuckDecoy() {
        quackBehavior = new Quack();
    }

    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }

    public void decoy() {
        quackBehavior.quack();
    }
}