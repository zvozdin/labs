package patterns.head_first.decorator.coffee_house;

public class Main {

    public static void main(String[] args) {
        Beverage espresso = new Espresso();
        System.out.println(String.format("%s $%.2f", espresso.getDescription(), espresso.cost()));
        Beverage espressoTall = new Espresso();
        espressoTall.setSize(Beverage.Size.VENTI);
        System.out.println(String.format("%s $%.2f", espressoTall.getDescription(), espressoTall.cost()));

        Beverage decaf = new Soy(new Mocha(new Milk(new Decaf())));
        System.out.println(String.format("%s $%.2f", decaf.getDescription(), decaf.cost()));
    }
}