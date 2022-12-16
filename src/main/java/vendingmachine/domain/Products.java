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

}
