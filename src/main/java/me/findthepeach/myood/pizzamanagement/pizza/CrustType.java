package me.findthepeach.myood.pizzamanagement.pizza;

public enum CrustType {
    CLASSIC(5),
    AMERICAN(6),
    CRUNCHY(7);
    private final int price;
    CrustType(int price){
        this.price = price;
    }

    public int getPrice(){
        return this.price;
    }
}
