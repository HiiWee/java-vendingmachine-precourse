package vendingmachine.repository;

import java.util.ArrayList;
import java.util.List;
import vendingmachine.domain.Products;

public class ProductsRepository {
    public static final int PROUDCTS_INDEX = 0;
    private static final ProductsRepository instance = new ProductsRepository();
    private static final List<Products> store = new ArrayList<>();

    private ProductsRepository() {
    }

    public static Products saveProducts(final Products products) {
        delete();
        store.add(products);
        return find();
    }

    public static Products find() {
        return store.get(PROUDCTS_INDEX);
    }

    private static void delete() {
        store.clear();
    }
}
