package pizzadecorator;

import pizzadecorator.pizza.*;

public class Demo {
    public static void main(String[] args) {
        Pizza pizza = new BasePizza(CrustType.CLASSIC, Size.LARGE);
        Cheese cheese = new Cheese(pizza);

        System.out.println(cheese.getDescription());
        System.out.println(cheese.getPrice());
    }
}
