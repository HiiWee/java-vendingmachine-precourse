package vendingmachine.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import vendingmachine.domain.enums.Coin;
import vendingmachine.message.ErrorMessage;

public class RandomCoinGenerator {

    public static final int MEASURE = 10;

    private RandomCoinGenerator() {
    }


    public static List<Coin> generateRandomCoins(final int machinePrice) {
        validateMoney(machinePrice);
        return generateCoins(machinePrice);
    }

    private static List<Coin> generateCoins(final int machinePrice) {
        int totalMoney = 0;
        List<Coin> coins = new ArrayList<>();
        while (totalMoney <= machinePrice) {
            int coin = Randoms.pickNumberInList(Coin.getMoneyList());
            if (totalMoney + coin <= machinePrice) {
                coins.add(Coin.getContainsCoin(coin));
                totalMoney += coin;
            }
            if (totalMoney == machinePrice) {
                break;
            }
        }
        return coins;
    }

    private static void validateMoney(final int machinePrice) {
        if (machinePrice % MEASURE != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_MACHINE_PRICE);
        }
    }
}
