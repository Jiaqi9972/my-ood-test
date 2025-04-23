package me.findthepeach.myood.pizzadecorator.pizza.enums;

public enum Size {
    SMALL("small",5),
    MEDIUM("medium",6),
    LARGE("large", 8);
    private final String name;
    private final int price;
    Size(String name, int price) {
        this.name = name;
        this.price = price;
    }
    public int getPrice() {
        return price;
    }
    public String getName() {
        return name;
    }
}
