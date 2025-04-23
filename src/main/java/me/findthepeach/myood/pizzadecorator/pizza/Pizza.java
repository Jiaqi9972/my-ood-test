package me.findthepeach.myood.pizzadecorator.pizza;

import me.findthepeach.myood.pizzadecorator.pizza.enums.CrustType;
import me.findthepeach.myood.pizzadecorator.pizza.enums.Size;

interface Pizza {

    String getDescription();
    int getPrice();

    Size getSize();
    CrustType getCrustType();

}
