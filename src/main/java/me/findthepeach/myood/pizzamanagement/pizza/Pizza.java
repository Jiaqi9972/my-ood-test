package me.findthepeach.myood.pizzamanagement.pizza;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private CrustType crustType;
    private Size size;
    private List<Toppings> toppings;
    private Pizza(Builder builder) {
        this.crustType = builder.crustType;
        this.size = builder.size;
        this.toppings = builder.toppings;
    }

    public int getPrice(){
        int price = 0;
        for (Toppings topping : toppings) {
            price += topping.getPrice();
        }
        price += crustType.getPrice();
        price += size.getPrice();
        return price;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "crustType=" + crustType +
                ", size=" + size +
                ", toppings=" + toppings +
                '}' + "Price" + getPrice();
    }

    public static class Builder{
        private CrustType crustType;
        private Size size;
        private List<Toppings> toppings = new ArrayList<>();
        public Builder(){}

        public Builder crustType(CrustType crustType) {
            this.crustType = crustType;
            return this;
        }

        public Builder size(Size size) {
            this.size = size;
            return this;
        }

        public Builder addTopping(Toppings topping){
            this.toppings.add(topping);
            return this;
        }

        public Pizza build(){
            if(crustType == null && size == null){
                throw new IllegalArgumentException("CrustType and size cannot be null");
            }
            return new Pizza(this);
        }
    }
}
