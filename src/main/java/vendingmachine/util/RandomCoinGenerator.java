package vendingmachine.util;

import vendingmachine.domain.Coins;
import vendingmachine.message.ErrorMessage;

public class RandomCoinGenerator {

    public static final int MEASURE = 10;

    private RandomCoinGenerator() {
    }


    public static Coins generateRandomCoins(final int machinePrice) {
        validateMoney(machinePrice);

        return null;
    }

    private static void validateMoney(final int machinePrice) {
        if (machinePrice % MEASURE != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_MACHINE_PRICE);
        }
    }
}
