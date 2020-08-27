package patterns.head_first.decorator.coffee_house;

public class Espresso extends Beverage {

    public Espresso() {
        description = "Espresso";
    }

    @Override
    public double cost() {
        double cost = 1.99;
        if (getSize() == Size.TALL) {
            return cost + .1;
        } else if (getSize() == Size.GRANDE) {
            return cost + .2;
        } else if (getSize() == Size.VENTI) {
            return cost + .3;
        } else {
            return cost;
        }
    }
}