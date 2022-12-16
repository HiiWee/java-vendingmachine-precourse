package vendingmachine.domain;

import java.util.List;
import vendingmachine.message.ErrorMessage;

public class Product {
    public static final int NAME = 0;
    public static final int PRICE = 1;
    public static final int QUANTITY = 2;
    public static final int MINIMUM_PRICE = 100;

    private final String name;
    private final int price;
    private final int quantity;

    public Product(List<String> productInformation) {
        validate(productInformation);
        this.name = productInformation.get(NAME);
        this.price = Integer.parseInt(productInformation.get(PRICE));
        this.quantity = Integer.parseInt(productInformation.get(QUANTITY));
    }

    private void validate(final List<String> productInformation) {
        validatePrice(productInformation.get(PRICE));
        validateQuantity(productInformation.get(QUANTITY));
    }

    private void validateQuantity(final String quantity) {
        if (!isNumeric(quantity)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_QUANTITY_NUMERIC);
        }
    }

    private void validatePrice(final String price) {
        if (!isNumeric(price)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_PRICE_NUMERIC);
        }
        if (Integer.parseInt(price) % 10 != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_PRODUCT_MEASURE);
        }
        if (Integer.parseInt(price) < MINIMUM_PRICE) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_PRODUCT_PRICE);
        }
    }

    private boolean isNumeric(final String price) {
        try {
            Integer.parseInt(price);
        } catch (NumberFormatException exception) {
            return false;
        }
        return true;
    }
}
