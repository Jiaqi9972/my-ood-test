package me.findthepeach.myood.pizzadecorator.pizza;

import me.findthepeach.myood.pizzadecorator.pizza.enums.Topping;

public class Bacon extends ToppingsDecorator{
    public Bacon(Pizza pizza){
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", bacon";
    }

    @Override
    public int getPrice() {
        return pizza.getPrice() + Topping.BACON.getPrice();
    }

}
