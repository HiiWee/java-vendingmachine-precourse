package vendingmachine.util;

import vendingmachine.message.ErrorMessage;

public class InputValidator {

    private InputValidator() {
    }

    public static void validateMachinePrice(final String userInput) {
        if (!isNumeric(userInput)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMERIC);
        }
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
