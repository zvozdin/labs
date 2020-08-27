package patterns.head_first.decorator.coffee_house;

public class Decaf extends Beverage {

    public Decaf() {
        description = "Decaf coffee";
    }

    @Override
    public double cost() {
        return 1.5;
    }
}