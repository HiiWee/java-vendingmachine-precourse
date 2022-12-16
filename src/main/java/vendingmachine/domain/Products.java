package vendingmachine.domain;

import java.util.List;
import vendingmachine.exception.NoQuantityException;

public class Products {
    private final List<Product> products;

    public Products(final List<Product> products) {
        this.products = products;
    }

    public int findMinimumPrice() {
        return products.stream()
                .filter(Product::isPossibleToSell)
                .mapToInt(Product::getPrice)
                .min()
                .orElseThrow(NoQuantityException::new);
    }

    public boolean containsProduct(final String inputProduct) {
        return products.stream()
                .anyMatch(product -> product.contains(inputProduct));
    }

    public boolean isPossibleToBuy(final int currentMoney, final String inputProduct) {
        return findProduct(inputProduct).getPrice() < currentMoney;
    }

    private Product findProduct(final String inputProduct) {
        return products.stream()
                .filter(product -> product.contains(inputProduct))
                .findFirst()
                .get();
    }

    public void buy(final String inputProduct) {
        findProduct(inputProduct).takeQuantity(inputProduct);
    }

    public int findPrice(final String inputProduct) {
        return findProduct(inputProduct).getPrice();
    }
}
