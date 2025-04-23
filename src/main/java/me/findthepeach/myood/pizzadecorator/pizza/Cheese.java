package me.findthepeach.myood.pizzadecorator.pizza;

import me.findthepeach.myood.pizzadecorator.pizza.enums.Topping;

public class Cheese extends ToppingsDecorator {

    public Cheese(Pizza pizza){
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", cheese";
    }

    @Override
    public int getPrice() {
        return pizza.getPrice() + Topping.CHEESE.getPrice();
    }

}
