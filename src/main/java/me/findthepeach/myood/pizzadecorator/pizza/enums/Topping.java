package me.findthepeach.myood.pizzadecorator.pizza.enums;

public enum Topping {
    CHEESE("cheese", 2),
    BACON("bacon", 2);
    private final String name;
    private final int price;
    Topping(String name, int price){
        this.name = name;
        this.price = price;
    }
    public int getPrice(){
        return price;
    }
    public String getName(){
        return name;
    }
}
