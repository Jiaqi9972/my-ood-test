package me.findthepeach.myood.pizzamanagement.pizza;

public enum Size {
    SMALL(6),
    MEDIUM(7),
    LARGE(8);
    private final int price;
    Size(int price) {
        this.price = price;
    }
    public int getPrice(){
        return this.price;
    }
}
