package me.findthepeach.myood.pizzadecorator.pizza;

import me.findthepeach.myood.pizzadecorator.pizza.enums.CrustType;
import me.findthepeach.myood.pizzadecorator.pizza.enums.Size;

public class BasePizza implements Pizza {

    private Size size;
    private CrustType crustType;

    public BasePizza(Size size, CrustType crustType) {
        this.size = size;
        this.crustType = crustType;
    }

    @Override
    public String getDescription() {
        return "Pizza Description: " + size + " " + crustType;
    }

    @Override
    public int getPrice() {
        return size.getPrice() + crustType.getPrice();
    }

    @Override
    public Size getSize() {
        return size;
    }

    @Override
    public CrustType getCrustType() {
        return crustType;
    }
}
