package patterns.head_first.decorator.coffee_house;

public class HouseBlend extends Beverage {

    public HouseBlend() {
        description = "House blend coffee";
    }

    @Override
    public double cost() {
        return .89;
    }
}