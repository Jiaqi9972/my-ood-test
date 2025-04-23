package me.findthepeach.myood.pizzamanagement.pizza;

import java.util.List;

public class PizzaFactory {

    private static Pizza.Builder setCrustTypeAndSize(CrustType crustType, Size size) {
        return new Pizza.Builder()
                .crustType(crustType)
                .size(size);
    }

    public static Pizza createSteakPizza(CrustType crustType, Size size) {
        return setCrustTypeAndSize(crustType,size)
                .addTopping(Toppings.STEAK)
                .build();
    }

    public static Pizza createOwnPizza(CrustType crustType, Size size, List<Toppings> toppings) {
        Pizza.Builder builder = setCrustTypeAndSize(crustType,size);
        for (Toppings topping : toppings) {
            builder.addTopping(topping);
        }
        return builder.build();
    }
}
