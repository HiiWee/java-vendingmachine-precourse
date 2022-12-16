package vendingmachine.domain;

import vendingmachine.exception.NoPossibleProductToBuyException;
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

    public int getCurrentMoney() {
        return userMoney;
    }

    public void validateMachineStatus() {
        if (findMinimumPriceOfProduct() > userMoney) {
            throw new NoPossibleProductToBuyException();
        }
    }

    private int findMinimumPriceOfProduct() {
        return sellProducts.findMinimumPrice();
    }

    public void buyProduct(final String inputProduct) {
        validateBuyProduct(inputProduct);
        sellProducts.buy(inputProduct);
        userMoney -= sellProducts.findPrice(inputProduct);
    }

    private void validateBuyProduct(final String inputProduct) {
        if (!sellProducts.containsProduct(inputProduct)) {
            throw new IllegalArgumentException(ErrorMessage.NO_PRODUCT_NAME);
        }
        if (!sellProducts.isPossibleToBuy(userMoney, inputProduct)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_ENOUGH_MONEY);
        }
    }
}
