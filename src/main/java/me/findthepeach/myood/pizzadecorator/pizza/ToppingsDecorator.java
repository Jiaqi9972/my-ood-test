package me.findthepeach.myood.pizzadecorator.pizza;

import me.findthepeach.myood.pizzadecorator.pizza.enums.CrustType;
import me.findthepeach.myood.pizzadecorator.pizza.enums.Size;

public abstract class ToppingsDecorator implements Pizza {
    protected final Pizza pizza;

    public ToppingsDecorator(Pizza pizza) {
        this.pizza = pizza;
    }

    public abstract String getDescription();
    public abstract int getPrice();

    @Override
    public Size getSize() {
        return pizza.getSize();
    }

    @Override
    public CrustType getCrustType() {
        return pizza.getCrustType();
    }
}
