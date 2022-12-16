package vendingmachine.domain;

public class Product {
    private final String name;
    private final int price;
    private final int quantity;

    public Product(final String name, final int price, final int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
}
