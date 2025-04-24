package me.findthepeach.myood.pizzadecorator.pizza;

public abstract class ToppingDecorator implements Pizza{
    protected Pizza pizza;

    public ToppingDecorator(Pizza pizza) {
        this.pizza = pizza;
    }

    public abstract String getDescription();
    public abstract int getPrice();

}
