package me.findthepeach.myood.pizzamanagement;

import me.findthepeach.myood.pizzamanagement.pizza.*;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        Pizza pizza01 = PizzaFactory.createSteakPizza(CrustType.CLASSIC, Size.LARGE);
        System.out.println(pizza01.toString());

        Pizza pizza02 = PizzaFactory.createOwnPizza(CrustType.CLASSIC,Size.LARGE, Arrays.asList(Toppings.STEAK, Toppings.ONION));
        System.out.println(pizza02.toString());
    }
}
