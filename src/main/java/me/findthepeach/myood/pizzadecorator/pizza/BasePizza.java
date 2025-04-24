package me.findthepeach.myood.pizzadecorator.pizza;

import me.findthepeach.myood.pizzadecorator.pizza.enums.CrustType;

public class BasePizza implements Pizza {
    private final CrustType crustType;
    private final Size size;
    public BasePizza(CrustType crustType, Size size) {
        this.crustType = crustType;
        this.size = size;
    }

    @Override
    public String getDescription(){
        return "Pizza: " + crustType.name() + " " + size.name();
    }

    @Override
    public int getPrice(){
        return crustType.getPrice() + size.getPrice();
    }
}
