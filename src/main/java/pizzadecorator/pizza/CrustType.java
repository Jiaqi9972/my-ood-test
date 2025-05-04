package pizzadecorator.pizza;

public enum CrustType {
    CLASSIC("classic", 2),
    AMERICAN("American", 3),
    CRUNCHY("Crunchy", 4);
    private final int price;
    private final String name;
    CrustType(String name, int price) {
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
