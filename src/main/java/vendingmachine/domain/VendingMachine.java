package vendingmachine.domain;

import vendingmachine.message.ErrorMessage;

public class VendingMachine {
    public static final int MINIMUM_MONEY = 100;
    private final Coins coins;
    private final Products sellProducts;
    private int userMoney;

    public VendingMachine(final Coins coins, final Products sellProducts) {
        this.coins = coins;
        this.sellProducts = sellProducts;
    }

    public void putMoney(final int inputMoney) {
        validateUserMoney(inputMoney);
        userMoney = inputMoney;
    }

    private void validateUserMoney(final int inputMoney) {
        if (inputMoney < MINIMUM_MONEY) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_USER_MONEY);
        }
    }
}
