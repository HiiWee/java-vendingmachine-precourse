package vendingmachine.view;

import java.util.Arrays;
import vendingmachine.domain.Coins;
import vendingmachine.domain.enums.Coin;

public class OutputView {
    public void printMessage(final String message) {
        System.out.println(message);
    }

    public void printMachineHavingCoins(final Coins coins) {
        System.out.println("자판기가 보유한 동전");
        Arrays.stream(Coin.values())
                .forEach(coin -> {
                    System.out.printf("%s원 - %d개", coin.toString(), coins.countOf(coin));
                });
    }
}
