package vendingmachine.domain.enums;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import vendingmachine.message.ErrorMessage;

public enum Coin {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);

    private final int amount;

    Coin(final int amount) {
        this.amount = amount;
    }

    public static List<Integer> getMoneyList() {
        return Arrays.stream(values())
                .map(coin -> coin.amount)
                .collect(Collectors.toList());
    }

    public static Coin getContainsCoin(final int value) {
        return Arrays.stream(values())
                .filter(coin -> coin.amount == value)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.INVALID_COIN));
    }

    public static int convertCoinToSumAmount(final List<Coin> coins) {
        return coins.stream()
                .mapToInt(coin -> coin.amount)
                .sum();
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return String.valueOf(amount);
    }

}
