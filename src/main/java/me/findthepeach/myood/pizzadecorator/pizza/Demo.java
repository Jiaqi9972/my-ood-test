package me.findthepeach.myood.pizzadecorator.pizza;

import me.findthepeach.myood.pizzadecorator.pizza.enums.CrustType;
import me.findthepeach.myood.pizzadecorator.pizza.enums.Size;

public class Demo {
    public static void main(String[] args){
        Pizza pizza = new BasePizza(Size.LARGE, CrustType.CLASSIC);
        pizza = new Bacon(pizza);
        pizza = new Cheese(pizza);

        System.out.println(pizza.getDescription());
        System.out.println(pizza.getPrice());
    }
}
