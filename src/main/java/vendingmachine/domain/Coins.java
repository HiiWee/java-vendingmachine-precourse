package vendingmachine.domain;

import java.util.List;
import vendingmachine.domain.enums.Coin;

public class Coins {
    private final List<Coin> machineCoins;

    public Coins(final List<Coin> machineCoins) {
        this.machineCoins = machineCoins;
    }

    public int countOf(final Coin findCoin) {
        return (int) machineCoins.stream()
                .filter(coin -> findCoin == coin)
                .count();
    }
}
