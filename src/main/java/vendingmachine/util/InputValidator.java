package vendingmachine.util;

import static vendingmachine.message.ErrorMessage.INVALID_NUMERIC;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputValidator {

    public static final String FIRST_SEPARATOR = ";";
    public static final int BRACKET = 1;

    private InputValidator() {
    }

    public static int validateMachinePrice(final String userInput) {
        if (!isNumeric(userInput)) {
            throw new IllegalArgumentException(INVALID_NUMERIC);
        }
        return Integer.parseInt(userInput);
    }

    private static boolean isNumeric(final String userInput) {
        try {
            Integer.parseInt(userInput);
        } catch (NumberFormatException exception) {
            return false;
        }
        return true;
    }

    public static List<String> parseProducts(final String inputProducts) {
        return Arrays.stream(inputProducts.split(FIRST_SEPARATOR))
                .map(productInfo -> productInfo.substring(BRACKET, productInfo.length() - BRACKET))
                .collect(Collectors.toList());
    }

    public static int validateInputPrice(final String inputBuyingPrice) {
        if (!isNumeric(inputBuyingPrice)) {
            throw new IllegalArgumentException(INVALID_NUMERIC);
        }
        return Integer.parseInt(inputBuyingPrice);
    }
}
