package vendingmachine.domain;

import java.util.ArrayList;
import java.util.List;
import vendingmachine.domain.enums.Coin;

public class Coins {
    private final List<Coin> machineCoins = new ArrayList<>();

    public Coins(final List<Coin> machineCoins) {
        this.machineCoins.addAll(machineCoins);
    }

    public int countOf(final Coin findCoin) {
        return (int) machineCoins.stream()
                .filter(coin -> findCoin == coin)
                .count();
    }

    public Coins createLeftCoins(final int userMoney) {
        int currentMoney = userMoney;
        List<Coin> coinsToReturn = new ArrayList<>();
        machineCoins.sort((o1, o2) -> o2.getAmount() - o1.getAmount());
        for (int index = 0; index < machineCoins.size(); index++) {
            Coin coin = machineCoins.get(index);
            if (currentMoney - coin.getAmount() >= 0) {
                currentMoney -= coin.getAmount();
                coinsToReturn.add(coin);
            }
        }
        return new Coins(coinsToReturn);
    }
}
