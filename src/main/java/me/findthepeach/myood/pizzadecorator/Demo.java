package me.findthepeach.myood.pizzadecorator;

import me.findthepeach.myood.pizzadecorator.pizza.enums.CrustType;
import me.findthepeach.myood.pizzadecorator.pizza.BasePizza;
import me.findthepeach.myood.pizzadecorator.pizza.Cheese;
import me.findthepeach.myood.pizzadecorator.pizza.Pizza;
import me.findthepeach.myood.pizzadecorator.pizza.Size;

public class Demo {
    public static void main(String[] args) {
        Pizza pizza = new BasePizza(CrustType.CLASSIC, Size.LARGE);
        Cheese cheese = new Cheese(pizza);

        System.out.println(cheese.getDescription());
        System.out.println(cheese.getPrice());
    }
}
