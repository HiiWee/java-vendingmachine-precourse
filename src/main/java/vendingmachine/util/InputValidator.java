package vendingmachine.util;

import vendingmachine.message.ErrorMessage;

public class InputValidator {

    private InputValidator() {
    }

    public static int validateMachinePrice(final String userInput) {
        if (!isNumeric(userInput)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMERIC);
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
}
