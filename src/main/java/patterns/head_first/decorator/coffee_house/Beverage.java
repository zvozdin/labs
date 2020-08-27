package patterns.head_first.decorator.coffee_house;

import lombok.Getter;
import lombok.Setter;

public abstract class Beverage {

    protected String description = "Unknown beverage";

    public enum Size {TALL, GRANDE, VENTI}

    @Getter
    @Setter
    protected Size size = Size.TALL;

    public abstract double cost();

    public String getDescription() {
        return description;
    }
}