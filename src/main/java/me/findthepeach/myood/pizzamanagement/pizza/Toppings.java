package me.findthepeach.myood.pizzamanagement.pizza;

public enum Toppings {
    ONION(2),
    BACON(3),
    STEAK(5);
    private final int price;
    Toppings(int price){
        this.price = price;
    }
    public int getPrice(){
        return this.price;
    }
}
