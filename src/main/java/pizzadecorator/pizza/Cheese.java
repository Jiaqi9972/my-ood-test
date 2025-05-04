package pizzadecorator.pizza;

public class Cheese extends ToppingDecorator{
    public Cheese(Pizza Pizza) {
        super(Pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", cheese";
    }

    @Override
    public int getPrice() {
        return pizza.getPrice() + Topping.CHEESE.getPrice();
    }

}
