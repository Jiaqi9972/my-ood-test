package pizzadecorator.pizza;

public enum Topping {
    BACON("bacon", 2),
    CHEESE("cheese", 3);
    private final String name;
    private final int price;
    Topping(String name, int price) {
        this.name = name;
        this.price = price;
    }
    public String getName() {
        return name;
    }
    public int getPrice() {
        return price;
    }
}
